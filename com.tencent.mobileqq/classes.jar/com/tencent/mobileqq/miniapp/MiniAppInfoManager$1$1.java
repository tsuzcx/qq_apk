package com.tencent.mobileqq.miniapp;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.im.oidb.oidb_0xb61.GetAppinfoRsp;
import tencent.im.oidb.oidb_0xb61.GetPkgUrlRsp;
import tencent.im.oidb.oidb_0xb61.RspBody;
import tencent.im.oidb.qqconnect.Appinfo;

class MiniAppInfoManager$1$1
  extends ProtoUtils.AppProtocolObserver
{
  MiniAppInfoManager$1$1(MiniAppInfoManager.1 param1) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onResult type=");
      paramBundle.append(this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_Int);
      paramBundle.append(", appid=");
      paramBundle.append(this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_JavaLangString);
      paramBundle.append(", code=");
      paramBundle.append(paramInt);
      QLog.i("MiniAppInfoManager", 2, paramBundle.toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      paramBundle = new oidb_0xb61.RspBody();
    }
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      if (paramBundle.wording.has()) {
        this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.g = paramBundle.wording.get();
      }
      if ((this.a.jdField_a_of_type_Int == 1) && (paramBundle.get_appinfo_rsp.appinfo.has()))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_b_of_type_Int = paramBundle.get_appinfo_rsp.appinfo.platform.get();
        this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_b_of_type_JavaLangString = paramBundle.get_appinfo_rsp.appinfo.app_name.get();
        this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_c_of_type_Int = paramBundle.get_appinfo_rsp.appinfo.app_state.get();
        this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_c_of_type_JavaLangString = paramBundle.get_appinfo_rsp.appinfo.icon_url.get();
        this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.e = paramBundle.get_appinfo_rsp.appinfo.icon_small_url.get();
        this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_d_of_type_JavaLangString = paramBundle.get_appinfo_rsp.appinfo.icon_middle_url.get();
        if (paramBundle.next_req_duration.has()) {
          this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTimeMillis() + Math.max(paramBundle.next_req_duration.get() * 1000L, 300000L));
        }
      }
      else
      {
        if ((this.a.jdField_a_of_type_Int != 2) || (!paramBundle.get_mqqapp_url_rsp.has())) {
          break label554;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_d_of_type_Int = paramBundle.get_mqqapp_url_rsp.app_version.get();
        this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.f = paramBundle.get_mqqapp_url_rsp.pkg_url.get();
        if (paramBundle.next_req_duration.has()) {
          this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.jdField_b_of_type_Long = (NetConnInfoCenter.getServerTimeMillis() + Math.max(paramBundle.next_req_duration.get() * 1000L, 300000L));
        }
      }
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("receive appInfo: ");
        paramArrayOfByte.append(this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo);
        QLog.d("MiniAppInfoManager", 2, paramArrayOfByte.toString());
      }
      MiniAppManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo);
      if ((this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback == null) || (this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback.a == null)) {
        break label663;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback.a(this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback.a.get(), true, this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo);
      return;
      label554:
      if ((this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback != null) && (this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback.a != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback.a(this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback.a.get(), false, this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label609:
      break label609;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback != null) && (this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback.a != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback.a(this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback.a.get(), false, this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo);
    }
    label663:
    return;
    if ((!QLog.isColorLevel()) || (paramArrayOfByte != null)) {}
    try
    {
      paramBundle = ((oidb_0xb61.RspBody)new oidb_0xb61.RspBody().mergeFrom(paramArrayOfByte)).wording.get();
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      label698:
      StringBuilder localStringBuilder;
      break label698;
    }
    paramBundle = "";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("req error code=");
    localStringBuilder.append(paramInt);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = ", data=null";
    }
    else
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(", msg=");
      paramArrayOfByte.append(paramBundle);
      paramArrayOfByte = paramArrayOfByte.toString();
    }
    localStringBuilder.append(paramArrayOfByte);
    QLog.i("MiniAppInfoManager", 2, localStringBuilder.toString());
    if ((this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback != null) && (this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback.a != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback.a(this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoCallback.a.get(), false, this.a.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppInfoManager.1.1
 * JD-Core Version:    0.7.0.1
 */