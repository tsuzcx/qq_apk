package com.tencent.mobileqq.forward;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;

class ForwardSdkBaseOption$3
  implements OpensdkBusinessObserver
{
  ForwardSdkBaseOption$3(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.b("KEY_GET_APP_INFO", paramBoolean);
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "AppinfoObserver onReceive isSuccess = ", Boolean.valueOf(paramBoolean) });
    synchronized (ForwardSdkBaseOption.jdField_a_of_type_JavaLangObject)
    {
      this.a.m = false;
      Object localObject3 = null;
      Object localObject2 = null;
      Object localObject1 = localObject3;
      if (paramBoolean) {
        try
        {
          localObject1 = paramBundle.getByteArray("data");
          if (localObject1 != null)
          {
            paramBundle = new GetAppInfoProto.GetAppinfoResponse();
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
            }
            catch (Exception localException)
            {
              localObject1 = paramBundle;
              paramBundle = localException;
              break label241;
            }
          }
          else
          {
            QLog.e("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver onReceive data=null");
            localObject1 = localObject3;
          }
        }
        catch (Exception paramBundle)
        {
          localObject1 = localException;
          label241:
          QLog.e("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "AppinfoObserver.onReceive ", paramBundle.getMessage() });
        }
      }
      this.a.A();
      if ((localObject1 != null) && (((GetAppInfoProto.GetAppinfoResponse)localObject1).ret.get() != 0) && ((this.a instanceof ForwardSdkShareOption)))
      {
        if (this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("enable_d55", false)) {
          this.a.a(((GetAppInfoProto.GetAppinfoResponse)localObject1).msg.get(), true);
        }
      }
      else {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver onReceive success, go share");
      }
      ForwardSdkBaseOption.jdField_a_of_type_JavaLangObject.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.3
 * JD-Core Version:    0.7.0.1
 */