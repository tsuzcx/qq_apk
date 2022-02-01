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
    PathTraceManagerImpl.DataUploadTask.a(this.jdField_a_of_type_ComTencentMobileqqVashealthApiImplPathTraceManagerImpl$DataUploadTask, paramBoolean, paramInt);
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
          if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
          {
            this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", 1);
            if (this.jdField_a_of_type_ComTencentMobileqqVashealthApiImplPathTraceManagerImpl$DataUploadTask.this$0.mUIHandler != null)
            {
              paramBundle = Message.obtain();
              paramBundle.what = 1;
              paramBundle.obj = this.jdField_a_of_type_OrgJsonJSONObject;
              this.jdField_a_of_type_ComTencentMobileqqVashealthApiImplPathTraceManagerImpl$DataUploadTask.this$0.mUIHandler.sendMessage(paramBundle);
            }
            this.jdField_a_of_type_ComTencentMobileqqVashealthApiImplPathTraceManagerImpl$DataUploadTask.this$0.pathTraceDelete(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqVashealthTracePathData.startTime));
            QLog.d("PathTraceManager", 1, "upload success");
            PathTraceManagerImpl.access$302(this.jdField_a_of_type_ComTencentMobileqqVashealthApiImplPathTraceManagerImpl$DataUploadTask.this$0, null);
            this.jdField_a_of_type_AndroidContentSharedPreferences.edit().clear().commit();
            return;
          }
          if (this.jdField_a_of_type_JavaUtilList.size() > 0)
          {
            if (this.jdField_a_of_type_JavaUtilList.size() > 0)
            {
              i = paramInt;
              if (i < paramInt + 3000)
              {
                paramBundle = new QQSportsOrbit.OrbitPoint();
                paramBundle.latitude.set(((TracePointsData)this.jdField_a_of_type_JavaUtilList.get(i)).latitude);
                paramBundle.longitude.set(((TracePointsData)this.jdField_a_of_type_JavaUtilList.get(i)).longitude);
                paramBundle.timef.set((int)((TracePointsData)this.jdField_a_of_type_JavaUtilList.get(i)).time);
                paramBundle.speedf.set(((TracePointsData)this.jdField_a_of_type_JavaUtilList.get(i)).speed);
                paramBundle.accuracy.set(((TracePointsData)this.jdField_a_of_type_JavaUtilList.get(i)).accuracy);
                paramBundle.step.set(((TracePointsData)this.jdField_a_of_type_JavaUtilList.get(i)).steps);
                paramBundle.altitude.set((float)((TracePointsData)this.jdField_a_of_type_JavaUtilList.get(i)).altitude);
                this.jdField_a_of_type_ComTencentMobileqqVashealthPbQQSportsOrbit$OrbitReq.tracePath.add(paramBundle);
                if (i != this.jdField_a_of_type_JavaUtilList.size() - 1) {
                  break label850;
                }
              }
            }
            if (paramInt + 3000 >= this.jdField_a_of_type_JavaUtilList.size()) {
              this.jdField_a_of_type_ComTencentMobileqqVashealthPbQQSportsOrbit$OrbitReq.isOver.set(1);
            } else {
              this.jdField_a_of_type_ComTencentMobileqqVashealthPbQQSportsOrbit$OrbitReq.isOver.set(0);
            }
            this.jdField_a_of_type_ComTencentMobileqqVashealthPbQQSportsOrbit$OrbitReq.num.set(paramInt + 1);
          }
          paramBundle = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqVashealthApiImplPathTraceManagerImpl$DataUploadTask.this$0.mApp.getApplicationContext(), WebSSOAgentServlet.class);
          paramBundle.putExtra("extra_cmd", PathTraceManagerImpl.DataUploadTask.a(this.jdField_a_of_type_ComTencentMobileqqVashealthApiImplPathTraceManagerImpl$DataUploadTask));
          paramBundle.putExtra("extra_data", PathTraceManagerImpl.gzip(this.jdField_a_of_type_ComTencentMobileqqVashealthPbQQSportsOrbit$OrbitReq.toByteArray()));
          this.jdField_a_of_type_ComTencentMobileqqVashealthPbQQSportsOrbit$OrbitReq.tracePath.clear();
          paramBundle.putExtra("extra_timeout", 15000);
          paramBundle.setObserver(this);
          this.jdField_a_of_type_ComTencentMobileqqVashealthApiImplPathTraceManagerImpl$DataUploadTask.this$0.mApp.startServlet(paramBundle);
          return;
        }
        this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", -10);
        if (this.jdField_a_of_type_ComTencentMobileqqVashealthApiImplPathTraceManagerImpl$DataUploadTask.this$0.mUIHandler != null)
        {
          paramBundle = Message.obtain();
          paramBundle.what = 1;
          paramBundle.obj = this.jdField_a_of_type_OrgJsonJSONObject;
          this.jdField_a_of_type_ComTencentMobileqqVashealthApiImplPathTraceManagerImpl$DataUploadTask.this$0.mUIHandler.sendMessage(paramBundle);
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
        if (this.jdField_a_of_type_ComTencentMobileqqVashealthApiImplPathTraceManagerImpl$DataUploadTask.this$0.mUIHandler != null)
        {
          localObject = Message.obtain();
          ((Message)localObject).what = 1;
          ((Message)localObject).obj = paramBundle;
          this.jdField_a_of_type_ComTencentMobileqqVashealthApiImplPathTraceManagerImpl$DataUploadTask.this$0.mUIHandler.sendMessage((Message)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.PathTraceManagerImpl.DataUploadTask.1
 * JD-Core Version:    0.7.0.1
 */