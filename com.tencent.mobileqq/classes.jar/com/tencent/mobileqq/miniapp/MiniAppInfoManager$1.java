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
  MiniAppInfoManager$1(MiniAppInfoManager paramMiniAppInfoManager, MiniAppInfoCallback paramMiniAppInfoCallback, MiniAppInfo paramMiniAppInfo, int paramInt) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback;
      if ((localObject != null) && (((MiniAppInfoCallback)localObject).a != null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback;
        ((MiniAppInfoCallback)localObject).a(((MiniAppInfoCallback)localObject).a.get(), false, this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo);
      }
      return;
    }
    try
    {
      int i = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_JavaLangString);
      oidb_0xb61.ReqBody localReqBody = new oidb_0xb61.ReqBody();
      int j = this.jdField_a_of_type_Int;
      if (j == 1)
      {
        localReqBody.get_appinfo_req.setHasFlag(true);
        localReqBody.get_appinfo_req.appid.set(i);
        localReqBody.get_appinfo_req.app_type.set(this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_Int);
      }
      else
      {
        if (j != 2) {
          break label340;
        }
        localReqBody.get_mqqapp_url_req.setHasFlag(true);
        localReqBody.get_mqqapp_url_req.appid.set(i);
        localReqBody.get_mqqapp_url_req.app_type.set(this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_Int);
        localReqBody.get_mqqapp_url_req.app_version.set(this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.d);
        localReqBody.get_mqqapp_url_req.platform.set(4);
        localReqBody.get_mqqapp_url_req.sys_version.set(String.valueOf(Build.VERSION.SDK_INT));
        localReqBody.get_mqqapp_url_req.qq_version.set("8.7.0");
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("serviceType=");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(", apptype=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_Int);
        localStringBuilder.append(", appid=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_JavaLangString);
        QLog.i("MiniAppInfoManager", 2, localStringBuilder.toString());
      }
      ProtoUtils.a((AppRuntime)localObject, new MiniAppInfoManager.1.1(this), localReqBody.toByteArray(), "OidbSvc.0xb61", 2913, this.jdField_a_of_type_Int, null, 0L);
      return;
      label340:
      localObject = this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback;
      if ((localObject != null) && (((MiniAppInfoCallback)localObject).a != null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback;
        ((MiniAppInfoCallback)localObject).a(((MiniAppInfoCallback)localObject).a.get(), false, this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo);
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label378:
      break label378;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback;
    if ((localObject != null) && (((MiniAppInfoCallback)localObject).a != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback;
      ((MiniAppInfoCallback)localObject).a(((MiniAppInfoCallback)localObject).a.get(), false, this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppInfoManager.1
 * JD-Core Version:    0.7.0.1
 */