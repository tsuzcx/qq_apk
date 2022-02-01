package com.tencent.mobileqq.miniapp;

import android.os.Build.VERSION;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import tencent.im.oidb.oidb_0xb61.GetAppinfoReq;
import tencent.im.oidb.oidb_0xb61.GetPkgUrlReq;
import tencent.im.oidb.oidb_0xb61.ReqBody;

class MiniAppInfoManager$1
  implements Runnable
{
  MiniAppInfoManager$1(MiniAppInfoManager paramMiniAppInfoManager, MiniAppInfoManager.MiniAppInfoCallback paramMiniAppInfoCallback, MiniAppInfo paramMiniAppInfo, int paramInt) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {
      if ((this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager$MiniAppInfoCallback != null) && (this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager$MiniAppInfoCallback.a != null)) {
        this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager$MiniAppInfoCallback.a(this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager$MiniAppInfoCallback.a.get(), false, this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo);
      }
    }
    label247:
    do
    {
      return;
      for (;;)
      {
        int i;
        oidb_0xb61.ReqBody localReqBody;
        try
        {
          i = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_JavaLangString);
          localReqBody = new oidb_0xb61.ReqBody();
          if (this.jdField_a_of_type_Int != 1) {
            break label247;
          }
          localReqBody.get_appinfo_req.setHasFlag(true);
          localReqBody.get_appinfo_req.appid.set(i);
          localReqBody.get_appinfo_req.app_type.set(this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_Int);
          if (QLog.isColorLevel()) {
            QLog.i("MiniAppInfoManager", 2, "serviceType=" + this.jdField_a_of_type_Int + ", apptype=" + this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_Int + ", appid=" + this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_JavaLangString);
          }
          ProtoUtils.a(localAppRuntime, new MiniAppInfoManager.1.1(this), localReqBody.toByteArray(), "OidbSvc.0xb61", 2913, this.jdField_a_of_type_Int, null, 0L);
          return;
        }
        catch (NumberFormatException localNumberFormatException) {}
        if ((this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager$MiniAppInfoCallback == null) || (this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager$MiniAppInfoCallback.a == null)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager$MiniAppInfoCallback.a(this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager$MiniAppInfoCallback.a.get(), false, this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo);
        return;
        if (this.jdField_a_of_type_Int != 2) {
          break label350;
        }
        localReqBody.get_mqqapp_url_req.setHasFlag(true);
        localReqBody.get_mqqapp_url_req.appid.set(i);
        localReqBody.get_mqqapp_url_req.app_type.set(this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_Int);
        localReqBody.get_mqqapp_url_req.app_version.set(this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.d);
        localReqBody.get_mqqapp_url_req.platform.set(4);
        localReqBody.get_mqqapp_url_req.sys_version.set(String.valueOf(Build.VERSION.SDK_INT));
        localReqBody.get_mqqapp_url_req.qq_version.set("8.5.5");
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager$MiniAppInfoCallback == null) || (this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager$MiniAppInfoCallback.a == null));
    label350:
    this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager$MiniAppInfoCallback.a(this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager$MiniAppInfoCallback.a.get(), false, this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppInfoManager.1
 * JD-Core Version:    0.7.0.1
 */