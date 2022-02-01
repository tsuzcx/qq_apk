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
      localObject = this.a;
      if ((localObject != null) && (((MiniAppInfoCallback)localObject).b != null))
      {
        localObject = this.a;
        ((MiniAppInfoCallback)localObject).a(((MiniAppInfoCallback)localObject).b.get(), false, this.b);
      }
      return;
    }
    try
    {
      int i = Integer.parseInt(this.b.a);
      oidb_0xb61.ReqBody localReqBody = new oidb_0xb61.ReqBody();
      int j = this.c;
      if (j == 1)
      {
        localReqBody.get_appinfo_req.setHasFlag(true);
        localReqBody.get_appinfo_req.appid.set(i);
        localReqBody.get_appinfo_req.app_type.set(this.b.b);
      }
      else
      {
        if (j != 2) {
          break label340;
        }
        localReqBody.get_mqqapp_url_req.setHasFlag(true);
        localReqBody.get_mqqapp_url_req.appid.set(i);
        localReqBody.get_mqqapp_url_req.app_type.set(this.b.b);
        localReqBody.get_mqqapp_url_req.app_version.set(this.b.i);
        localReqBody.get_mqqapp_url_req.platform.set(4);
        localReqBody.get_mqqapp_url_req.sys_version.set(String.valueOf(Build.VERSION.SDK_INT));
        localReqBody.get_mqqapp_url_req.qq_version.set("8.8.17");
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("serviceType=");
        localStringBuilder.append(this.c);
        localStringBuilder.append(", apptype=");
        localStringBuilder.append(this.b.b);
        localStringBuilder.append(", appid=");
        localStringBuilder.append(this.b.a);
        QLog.i("MiniAppInfoManager", 2, localStringBuilder.toString());
      }
      ProtoUtils.a((AppRuntime)localObject, new MiniAppInfoManager.1.1(this), localReqBody.toByteArray(), "OidbSvc.0xb61", 2913, this.c, null, 0L);
      return;
      label340:
      localObject = this.a;
      if ((localObject != null) && (((MiniAppInfoCallback)localObject).b != null))
      {
        localObject = this.a;
        ((MiniAppInfoCallback)localObject).a(((MiniAppInfoCallback)localObject).b.get(), false, this.b);
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label378:
      break label378;
    }
    localObject = this.a;
    if ((localObject != null) && (((MiniAppInfoCallback)localObject).b != null))
    {
      localObject = this.a;
      ((MiniAppInfoCallback)localObject).a(((MiniAppInfoCallback)localObject).b.get(), false, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppInfoManager.1
 * JD-Core Version:    0.7.0.1
 */