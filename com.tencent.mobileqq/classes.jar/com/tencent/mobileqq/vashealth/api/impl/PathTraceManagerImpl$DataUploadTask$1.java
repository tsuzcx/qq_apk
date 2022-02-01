package com.tencent.mobileqq.vashealth.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.vashealth.TracePathData;
import com.tencent.mobileqq.vashealth.TracePointsData;
import com.tencent.mobileqq.vashealth.pb.QQSportsOrbit.OrbitPoint;
import com.tencent.mobileqq.vashealth.pb.QQSportsOrbit.OrbitReq;
import com.tencent.mobileqq.vashealth.pb.QQSportsOrbit.OrbitRsp;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgentServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class PathTraceManagerImpl$DataUploadTask$1
  implements BusinessObserver
{
  PathTraceManagerImpl$DataUploadTask$1(PathTraceManagerImpl.DataUploadTask paramDataUploadTask, JSONObject paramJSONObject, List paramList, TracePathData paramTracePathData, SharedPreferences paramSharedPreferences, QQSportsOrbit.OrbitReq paramOrbitReq) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    PathTraceManagerImpl.DataUploadTask.a(this.f, paramBoolean, paramInt);
    if (paramBoolean) {}
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        byte[] arrayOfByte = paramBundle.getByteArray("extra_data");
        paramBundle = new QQSportsOrbit.OrbitRsp();
        try
        {
          paramBundle.mergeFrom(arrayOfByte);
          paramInt = paramBundle.lastNum.get();
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[run] json fail");
          localStringBuilder.append(localException.getMessage());
          QLog.e("PathTraceManager", 1, localStringBuilder.toString());
          paramInt = -1;
        }
        if ((paramInt != -1) && (paramBundle.retCode.get() == 0))
        {
          if (paramInt >= this.b.size())
          {
            this.a.put("retCode", 1);
            if (this.f.this$0.mUIHandler != null)
            {
              paramBundle = Message.obtain();
              paramBundle.what = 1;
              paramBundle.obj = this.a;
              this.f.this$0.mUIHandler.sendMessage(paramBundle);
            }
            this.f.this$0.pathTraceDelete(Long.valueOf(this.c.startTime));
            QLog.d("PathTraceManager", 1, "upload success");
            PathTraceManagerImpl.access$302(this.f.this$0, null);
            this.d.edit().clear().commit();
            return;
          }
          if (this.b.size() > 0)
          {
            if (this.b.size() > 0)
            {
              i = paramInt;
              if (i < paramInt + 3000)
              {
                paramBundle = new QQSportsOrbit.OrbitPoint();
                paramBundle.latitude.set(((TracePointsData)this.b.get(i)).latitude);
                paramBundle.longitude.set(((TracePointsData)this.b.get(i)).longitude);
                paramBundle.timef.set((int)((TracePointsData)this.b.get(i)).time);
                paramBundle.speedf.set(((TracePointsData)this.b.get(i)).speed);
                paramBundle.accuracy.set(((TracePointsData)this.b.get(i)).accuracy);
                paramBundle.step.set(((TracePointsData)this.b.get(i)).steps);
                paramBundle.altitude.set((float)((TracePointsData)this.b.get(i)).altitude);
                this.e.tracePath.add(paramBundle);
                if (i != this.b.size() - 1) {
                  break label850;
                }
              }
            }
            if (paramInt + 3000 >= this.b.size()) {
              this.e.isOver.set(1);
            } else {
              this.e.isOver.set(0);
            }
            this.e.num.set(paramInt + 1);
          }
          paramBundle = new NewIntent(this.f.this$0.mApp.getApplicationContext(), WebSSOAgentServlet.class);
          paramBundle.putExtra("extra_cmd", PathTraceManagerImpl.DataUploadTask.a(this.f));
          paramBundle.putExtra("extra_data", PathTraceManagerImpl.gzip(this.e.toByteArray()));
          this.e.tracePath.clear();
          paramBundle.putExtra("extra_timeout", 15000);
          paramBundle.setObserver(this);
          this.f.this$0.mApp.startServlet(paramBundle);
          return;
        }
        this.a.put("retCode", -10);
        if (this.f.this$0.mUIHandler != null)
        {
          paramBundle = Message.obtain();
          paramBundle.what = 1;
          paramBundle.obj = this.a;
          this.f.this$0.mUIHandler.sendMessage(paramBundle);
        }
        return;
      }
      catch (Exception paramBundle)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[run] json fail");
        ((StringBuilder)localObject).append(paramBundle.getMessage());
        QLog.e("PathTraceManager", 1, ((StringBuilder)localObject).toString());
        return;
      }
      QLog.e("PathTraceManager", 1, "upload fail");
      try
      {
        paramBundle = new JSONObject();
        paramBundle.put("retCode", -10);
        if (this.f.this$0.mUIHandler != null)
        {
          localObject = Message.obtain();
          ((Message)localObject).what = 1;
          ((Message)localObject).obj = paramBundle;
          this.f.this$0.mUIHandler.sendMessage((Message)localObject);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("uploadfail:");
        ((StringBuilder)localObject).append(paramBundle.toString());
        QLog.d("PathTraceManager", 1, ((StringBuilder)localObject).toString());
      }
      return;
      label850:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.PathTraceManagerImpl.DataUploadTask.1
 * JD-Core Version:    0.7.0.1
 */