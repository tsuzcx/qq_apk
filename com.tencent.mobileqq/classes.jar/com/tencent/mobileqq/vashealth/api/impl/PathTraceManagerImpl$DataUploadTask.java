package com.tencent.mobileqq.vashealth.api.impl;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vashealth.TracePathData;
import com.tencent.mobileqq.vashealth.TracePointsData;
import com.tencent.mobileqq.vashealth.pb.QQSportsOrbit.OrbitHeader;
import com.tencent.mobileqq.vashealth.pb.QQSportsOrbit.OrbitPacePoint;
import com.tencent.mobileqq.vashealth.pb.QQSportsOrbit.OrbitPoint;
import com.tencent.mobileqq.vashealth.pb.QQSportsOrbit.OrbitReq;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgentServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONObject;

class PathTraceManagerImpl$DataUploadTask
  implements Runnable
{
  private final int jdField_a_of_type_Int = 3000;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private String b = "yundong_orbit.datauploadV3";
  
  public PathTraceManagerImpl$DataUploadTask(PathTraceManagerImpl paramPathTraceManagerImpl, long paramLong, String paramString)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (this.this$0.mApp != null)
    {
      HashMap localHashMap = new HashMap();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("");
      localHashMap.put("type", ((StringBuilder)localObject).toString());
      localObject = this.this$0.mApp.getCurrentAccountUin();
      StatisticCollector.getInstance(this.this$0.mApp.getApp()).collectPerformance((String)localObject, "QQSportUpload", paramBoolean, System.currentTimeMillis(), 0L, localHashMap, "", false);
    }
  }
  
  public void run()
  {
    QQSportsOrbit.OrbitReq localOrbitReq = new QQSportsOrbit.OrbitReq();
    label1097:
    label1106:
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("callback", this.jdField_a_of_type_JavaLangString);
        TracePathData localTracePathData;
        if (PathTraceManagerImpl.access$300(this.this$0) != null)
        {
          localTracePathData = PathTraceManagerImpl.access$300(this.this$0);
          this.this$0.updateEntity(PathTraceManagerImpl.access$300(this.this$0));
        }
        else
        {
          localTracePathData = this.this$0.getPathTraceByTime(this.jdField_a_of_type_Long);
        }
        if ((this.this$0.mUploadTime != 0L) && (localTracePathData != null)) {
          localTracePathData.totalTime = this.this$0.mUploadTime;
        }
        List localList = this.this$0.getAllTracePointByStartTime(this.jdField_a_of_type_Long);
        String str = "message";
        localObject1 = "retCode";
        if ((localTracePathData != null) && (localList != null))
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("upload startTime: ");
          ((StringBuilder)localObject2).append(localTracePathData.toString());
          ((StringBuilder)localObject2).append(",point size: ");
          ((StringBuilder)localObject2).append(localList.size());
          QLog.d("PathTraceManager", 1, ((StringBuilder)localObject2).toString());
          localObject2 = new QQSportsOrbit.OrbitHeader();
          ((QQSportsOrbit.OrbitHeader)localObject2).startTime.set((int)localTracePathData.startTime);
          ((QQSportsOrbit.OrbitHeader)localObject2).endTime.set((int)localTracePathData.endTime);
          ((QQSportsOrbit.OrbitHeader)localObject2).totalTime.set((int)localTracePathData.totalTime);
          ((QQSportsOrbit.OrbitHeader)localObject2).totalSteps.set(localTracePathData.totalSteps);
          ((QQSportsOrbit.OrbitHeader)localObject2).type.set(localTracePathData.type);
          ((QQSportsOrbit.OrbitHeader)localObject2).distance.set((float)localTracePathData.distance);
          ((QQSportsOrbit.OrbitHeader)localObject2).platform.set(2);
          if ((Build.VERSION.SDK_INT >= 19) && (this.this$0.mStepSensor != null)) {
            ((QQSportsOrbit.OrbitHeader)localObject2).stepType.set(1);
          } else {
            ((QQSportsOrbit.OrbitHeader)localObject2).stepType.set(0);
          }
          SharedPreferences localSharedPreferences = this.this$0.mApp.getApplication().getSharedPreferences(String.valueOf(localTracePathData.startTime), 0);
          i = 1;
          Object localObject3;
          if (localSharedPreferences.getString(String.valueOf(i), null) != null)
          {
            localObject3 = localSharedPreferences.getString(String.valueOf(i), null);
            if (localObject3 != null)
            {
              localObject3 = ((String)localObject3).split(",");
              QQSportsOrbit.OrbitPacePoint localOrbitPacePoint = new QQSportsOrbit.OrbitPacePoint();
              localOrbitPacePoint.km.set(i);
              localOrbitPacePoint.time.set(Integer.parseInt(localObject3[0]));
              localOrbitPacePoint.latitude.set(Double.valueOf(localObject3[1]).doubleValue());
              localOrbitPacePoint.longitude.set(Double.valueOf(localObject3[2]).doubleValue());
              ((QQSportsOrbit.OrbitHeader)localObject2).kmRecords.add(localOrbitPacePoint);
            }
          }
          else
          {
            localOrbitReq.reqHeader.set((MessageMicro)localObject2);
            localOrbitReq.isOver.set(0);
            if (localList.size() > 0)
            {
              i = 0;
              if (i < 3000)
              {
                localObject2 = new QQSportsOrbit.OrbitPoint();
                ((QQSportsOrbit.OrbitPoint)localObject2).latitude.set(((TracePointsData)localList.get(i)).latitude);
                ((QQSportsOrbit.OrbitPoint)localObject2).longitude.set(((TracePointsData)localList.get(i)).longitude);
                ((QQSportsOrbit.OrbitPoint)localObject2).timef.set((int)((TracePointsData)localList.get(i)).time);
                ((QQSportsOrbit.OrbitPoint)localObject2).speedf.set(((TracePointsData)localList.get(i)).speed);
                ((QQSportsOrbit.OrbitPoint)localObject2).accuracy.set(((TracePointsData)localList.get(i)).accuracy + 1);
                ((QQSportsOrbit.OrbitPoint)localObject2).step.set(((TracePointsData)localList.get(i)).steps);
                ((QQSportsOrbit.OrbitPoint)localObject2).altitude.set((float)((TracePointsData)localList.get(i)).altitude);
                localOrbitReq.tracePath.add((MessageMicro)localObject2);
                if (i != localList.size() - 1) {
                  break label1097;
                }
                localOrbitReq.isOver.set(1);
              }
            }
            localObject3 = localOrbitReq.toByteArray();
            long l = System.currentTimeMillis();
            localObject2 = PathTraceManagerImpl.gzip((byte[])localObject3);
            if ((!QLog.isColorLevel()) || (localObject2 == null)) {
              break label1106;
            }
            i = localObject3.length;
            int j = localObject2.length;
            int k = localObject2.length;
            double d1 = k;
            Double.isNaN(d1);
            k = localObject3.length;
            double d2 = k;
            Double.isNaN(d2);
            d1 = (d1 + 0.0D) / (d2 + 0.0D);
            QLog.d("PathTraceManager", 2, String.format("first:%s second:%s rate:%.3f time:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Double.valueOf(d1), Long.valueOf(System.currentTimeMillis() - l) }));
            if ((localObject2 != null) && (localObject2.length != 0))
            {
              localObject1 = new NewIntent(this.this$0.mApp.getApplicationContext(), WebSSOAgentServlet.class);
              ((NewIntent)localObject1).putExtra("extra_cmd", this.b);
              localOrbitReq.num.set(0);
              ((NewIntent)localObject1).putExtra("extra_data", (byte[])localObject2);
              localOrbitReq.tracePath.clear();
              ((NewIntent)localObject1).putExtra("extra_timeout", 15000);
              ((NewIntent)localObject1).setObserver(new PathTraceManagerImpl.DataUploadTask.1(this, localJSONObject, localList, localTracePathData, localSharedPreferences, localOrbitReq));
              this.this$0.mApp.startServlet((NewIntent)localObject1);
              return;
            }
            localJSONObject.put((String)localObject1, -11);
            localJSONObject.put(str, "gzip failed");
          }
        }
        else
        {
          localJSONObject.put("retCode", -9);
          localJSONObject.put("message", "no path trace recode");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[run] json fail");
        ((StringBuilder)localObject1).append(localThrowable.getMessage());
        QLog.e("PathTraceManager", 1, ((StringBuilder)localObject1).toString());
        return;
      }
      i += 1;
      continue;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.PathTraceManagerImpl.DataUploadTask
 * JD-Core Version:    0.7.0.1
 */