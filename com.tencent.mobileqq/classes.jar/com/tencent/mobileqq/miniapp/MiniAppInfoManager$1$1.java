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
      paramBundle.append(this.b.b.b);
      paramBundle.append(", appid=");
      paramBundle.append(this.b.b.a);
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
        this.b.b.k = paramBundle.wording.get();
      }
      if ((this.b.c == 1) && (paramBundle.get_appinfo_rsp.appinfo.has()))
      {
        this.b.b.c = paramBundle.get_appinfo_rsp.appinfo.platform.get();
        this.b.b.d = paramBundle.get_appinfo_rsp.appinfo.app_name.get();
        this.b.b.h = paramBundle.get_appinfo_rsp.appinfo.app_state.get();
        this.b.b.e = paramBundle.get_appinfo_rsp.appinfo.icon_url.get();
        this.b.b.g = paramBundle.get_appinfo_rsp.appinfo.icon_small_url.get();
        this.b.b.f = paramBundle.get_appinfo_rsp.appinfo.icon_middle_url.get();
        if (paramBundle.next_req_duration.has()) {
          this.b.b.l = (NetConnInfoCenter.getServerTimeMillis() + Math.max(paramBundle.next_req_duration.get() * 1000L, 300000L));
        }
      }
      else
      {
        if ((this.b.c != 2) || (!paramBundle.get_mqqapp_url_rsp.has())) {
          break label554;
        }
        this.b.b.i = paramBundle.get_mqqapp_url_rsp.app_version.get();
        this.b.b.j = paramBundle.get_mqqapp_url_rsp.pkg_url.get();
        if (paramBundle.next_req_duration.has()) {
          this.b.b.m = (NetConnInfoCenter.getServerTimeMillis() + Math.max(paramBundle.next_req_duration.get() * 1000L, 300000L));
        }
      }
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("receive appInfo: ");
        paramArrayOfByte.append(this.b.b);
        QLog.d("MiniAppInfoManager", 2, paramArrayOfByte.toString());
      }
      MiniAppManager.a().a(this.b.b);
      if ((this.b.a == null) || (this.b.a.b == null)) {
        break label663;
      }
      this.b.a.a(this.b.a.b.get(), true, this.b.b);
      return;
      label554:
      if ((this.b.a != null) && (this.b.a.b != null)) {
        this.b.a.a(this.b.a.b.get(), false, this.b.b);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label609:
      break label609;
    }
    if ((this.b.a != null) && (this.b.a.b != null)) {
      this.b.a.a(this.b.a.b.get(), false, this.b.b);
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
    if ((this.b.a != null) && (this.b.a.b != null)) {
      this.b.a.a(this.b.a.b.get(), false, this.b.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppInfoManager.1.1
 * JD-Core Version:    0.7.0.1
 */