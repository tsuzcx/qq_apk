package com.tencent.mobileqq.forward;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class ForwardSdkBaseOption$3
  implements BusinessObserver
{
  ForwardSdkBaseOption$3(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.b("KEY_GET_APP_INFO", paramBoolean);
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "AppinfoObserver onReceive isSuccess = ", Boolean.valueOf(paramBoolean) });
    Object localObject2 = null;
    synchronized (ForwardSdkBaseOption.jdField_a_of_type_JavaLangObject)
    {
      this.a.m = false;
      Object localObject1 = localObject2;
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          localObject1 = paramBundle.getByteArray("data");
          if (localObject1 != null) {
            paramBundle = new GetAppInfoProto.GetAppinfoResponse();
          }
        }
        catch (Exception localException1)
        {
          paramBundle = null;
        }
        try
        {
          paramBundle.mergeFrom((byte[])localObject1);
          this.a.jdField_a_of_type_ComTencentMobileqqForwardAppInfo = AppInfo.a(paramBundle);
          if ((this.a instanceof ForwardSdkShareOption)) {
            ((ForwardSdkStatusManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SDK_SHARE)).a().a(this.a.b, this.a.jdField_a_of_type_ComTencentMobileqqForwardAppInfo);
          }
          QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "get appinfo time=", Long.valueOf(System.currentTimeMillis() - this.a.c), ", ret=", Integer.valueOf(paramBundle.ret.get()) });
          this.a.e();
          localObject1 = paramBundle;
          this.a.z();
          if ((localObject1 == null) || (((GetAppInfoProto.GetAppinfoResponse)localObject1).ret.get() == 0) || (!(this.a instanceof ForwardSdkShareOption))) {
            break;
          }
          if (this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("enable_d55", false)) {
            this.a.a(((GetAppInfoProto.GetAppinfoResponse)localObject1).msg.get(), true);
          }
          ForwardSdkBaseOption.jdField_a_of_type_JavaLangObject.notify();
          return;
        }
        catch (Exception localException2)
        {
          Bundle localBundle;
          break label298;
        }
        QLog.e("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver onReceive data=null");
        localObject1 = localObject2;
        continue;
        label298:
        QLog.e("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "AppinfoObserver.onReceive ", localException1.getMessage() });
        localBundle = paramBundle;
      }
      QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver onReceive success, go share");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.3
 * JD-Core Version:    0.7.0.1
 */