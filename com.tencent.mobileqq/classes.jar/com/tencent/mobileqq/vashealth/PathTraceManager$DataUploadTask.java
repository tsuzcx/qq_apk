package com.tencent.mobileqq.vashealth;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import arpb;
import axrl;
import bbud;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONObject;
import tencent.im.pb.qqsport.QQSportsOrbit.OrbitHeader;
import tencent.im.pb.qqsport.QQSportsOrbit.OrbitPacePoint;
import tencent.im.pb.qqsport.QQSportsOrbit.OrbitPoint;
import tencent.im.pb.qqsport.QQSportsOrbit.OrbitReq;

public class PathTraceManager$DataUploadTask
  implements Runnable
{
  private final int jdField_a_of_type_Int = 3000;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private String b = "yundong_orbit.datauploadV3";
  
  public PathTraceManager$DataUploadTask(PathTraceManager paramPathTraceManager, long paramLong, String paramString)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", paramInt + "");
      String str = this.this$0.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getCurrentAccountUin();
      axrl.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.getApp()).a(str, "QQSportUpload", paramBoolean, System.currentTimeMillis(), 0L, localHashMap, "", false);
    }
  }
  
  public void run()
  {
    QQSportsOrbit.OrbitReq localOrbitReq = new QQSportsOrbit.OrbitReq();
    JSONObject localJSONObject;
    List localList;
    Object localObject1;
    SharedPreferences localSharedPreferences;
    int i;
    Object localObject2;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("callback", this.jdField_a_of_type_JavaLangString);
      TracePathData localTracePathData;
      if (PathTraceManager.a(this.this$0) != null)
      {
        localTracePathData = PathTraceManager.a(this.this$0);
        this.this$0.a(PathTraceManager.a(this.this$0));
        if ((this.this$0.b != 0L) && (localTracePathData != null)) {
          localTracePathData.totalTime = this.this$0.b;
        }
        localList = this.this$0.a(this.jdField_a_of_type_Long);
        if ((localTracePathData == null) || (localList == null)) {
          break label965;
        }
        QLog.d("PathTraceManager", 1, "upload startTime: " + localTracePathData.toString() + ",point size: " + localList.size());
        localObject1 = new QQSportsOrbit.OrbitHeader();
        ((QQSportsOrbit.OrbitHeader)localObject1).startTime.set((int)localTracePathData.startTime);
        ((QQSportsOrbit.OrbitHeader)localObject1).endTime.set((int)localTracePathData.endTime);
        ((QQSportsOrbit.OrbitHeader)localObject1).totalTime.set((int)localTracePathData.totalTime);
        ((QQSportsOrbit.OrbitHeader)localObject1).totalSteps.set(localTracePathData.totalSteps);
        ((QQSportsOrbit.OrbitHeader)localObject1).type.set(localTracePathData.type);
        ((QQSportsOrbit.OrbitHeader)localObject1).distance.set((float)localTracePathData.distance);
        ((QQSportsOrbit.OrbitHeader)localObject1).platform.set(2);
        if ((Build.VERSION.SDK_INT < 19) || (this.this$0.jdField_a_of_type_AndroidHardwareSensor == null)) {
          break label447;
        }
        ((QQSportsOrbit.OrbitHeader)localObject1).stepType.set(1);
      }
      for (;;)
      {
        localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(String.valueOf(localTracePathData.startTime), 0);
        i = 1;
        if (localSharedPreferences.getString(String.valueOf(i), null) == null) {
          break label492;
        }
        localObject2 = localSharedPreferences.getString(String.valueOf(i), null);
        if (localObject2 == null) {
          break label989;
        }
        localObject2 = ((String)localObject2).split(",");
        QQSportsOrbit.OrbitPacePoint localOrbitPacePoint = new QQSportsOrbit.OrbitPacePoint();
        localOrbitPacePoint.km.set(i);
        localOrbitPacePoint.time.set(Integer.parseInt(localObject2[0]));
        localOrbitPacePoint.latitude.set(Double.valueOf(localObject2[1]).doubleValue());
        localOrbitPacePoint.longitude.set(Double.valueOf(localObject2[2]).doubleValue());
        ((QQSportsOrbit.OrbitHeader)localObject1).kmRecords.add(localOrbitPacePoint);
        break label989;
        localTracePathData = this.this$0.a(this.jdField_a_of_type_Long);
        break;
        label447:
        ((QQSportsOrbit.OrbitHeader)localObject1).stepType.set(0);
      }
      localOrbitReq.reqHeader.set((MessageMicro)localObject1);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PathTraceManager", 1, "[run] json fail" + localThrowable.getMessage());
      return;
    }
    label492:
    localOrbitReq.isOver.set(0);
    if (localList.size() > 0) {
      i = 0;
    }
    for (;;)
    {
      if (i < 3000)
      {
        localObject1 = new QQSportsOrbit.OrbitPoint();
        ((QQSportsOrbit.OrbitPoint)localObject1).latitude.set(((TracePointsData)localList.get(i)).latitude);
        ((QQSportsOrbit.OrbitPoint)localObject1).longitude.set(((TracePointsData)localList.get(i)).longitude);
        ((QQSportsOrbit.OrbitPoint)localObject1).timef.set((int)((TracePointsData)localList.get(i)).time);
        ((QQSportsOrbit.OrbitPoint)localObject1).speedf.set(((TracePointsData)localList.get(i)).speed);
        ((QQSportsOrbit.OrbitPoint)localObject1).accuracy.set(((TracePointsData)localList.get(i)).accuracy + 1);
        ((QQSportsOrbit.OrbitPoint)localObject1).step.set(((TracePointsData)localList.get(i)).steps);
        ((QQSportsOrbit.OrbitPoint)localObject1).altitude.set((float)((TracePointsData)localList.get(i)).altitude);
        localOrbitReq.tracePath.add((MessageMicro)localObject1);
        if (i == localList.size() - 1) {
          localOrbitReq.isOver.set(1);
        }
      }
      else
      {
        localObject2 = localOrbitReq.toByteArray();
        long l = System.currentTimeMillis();
        localObject1 = PathTraceManager.a((byte[])localObject2);
        if ((QLog.isColorLevel()) && (localObject1 != null)) {
          QLog.d("PathTraceManager", 2, String.format("first:%s second:%s rate:%.3f time:%s", new Object[] { Integer.valueOf(localObject2.length), Integer.valueOf(localObject1.length), Double.valueOf((localObject1.length + 0.0D) / (localObject2.length + 0.0D)), Long.valueOf(System.currentTimeMillis() - l) }));
        }
        if ((localObject1 == null) || (localObject1.length == 0))
        {
          localJSONObject.put("retCode", -11);
          localJSONObject.put("message", "gzip failed");
          return;
        }
        localObject2 = new NewIntent(BaseApplicationImpl.sApplication.getApplicationContext(), arpb.class);
        ((NewIntent)localObject2).putExtra("extra_cmd", this.b);
        localOrbitReq.num.set(0);
        ((NewIntent)localObject2).putExtra("extra_data", (byte[])localObject1);
        localOrbitReq.tracePath.clear();
        ((NewIntent)localObject2).putExtra("extra_timeout", 15000);
        ((NewIntent)localObject2).setObserver(new bbud(this, localJSONObject, localList, localThrowable, localSharedPreferences, localOrbitReq));
        BaseApplicationImpl.sApplication.getRuntime().startServlet((NewIntent)localObject2);
        return;
        label965:
        localJSONObject.put("retCode", -9);
        localJSONObject.put("message", "no path trace recode");
        return;
        label989:
        i += 1;
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.PathTraceManager.DataUploadTask
 * JD-Core Version:    0.7.0.1
 */