package com.tencent.mobileqq.nearby;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil;
import com.tencent.mobileqq.uniformdownload.util.IGetFileInfoCallBack;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

class NearbyTribeAppController$2
  implements IGetFileInfoCallBack
{
  NearbyTribeAppController$2(NearbyTribeAppController paramNearbyTribeAppController) {}
  
  public void a(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramLong <= 0L) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FMSettings.a().getDefaultRecvPath());
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
      if (new File((String)localObject).exists())
      {
        ((IUniformDownloadUtil)QRoute.api(IUniformDownloadUtil.class)).installAPK((String)localObject);
        if (QLog.isColorLevel())
        {
          paramString = NearbyTribeAppController.a(this.a);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("UniformDownloadUtil.installAPK,savePath=");
          localStringBuilder.append((String)localObject);
          QLog.d(paramString, 2, localStringBuilder.toString());
        }
        return;
      }
      NearbyTribeAppController.a(this.a).post(new NearbyTribeAppController.2.1(this));
      localObject = new Bundle();
      ((Bundle)localObject).putString("_filename_from_dlg", paramString);
      ((Bundle)localObject).putLong("_filesize_from_dlg", paramLong);
      ((Bundle)localObject).putString("_notify_name_dialog", HardCodeUtil.a(2131707416));
      ((Bundle)localObject).putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_hdsp_nearby");
      QLog.e(NearbyTribeAppController.a(this.a), 1, "这里已经下架，如果依然发现该log，异常case");
      ((IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).startDownload("https://pub.idqqimg.com/pc/misc/files/20170706/c221bf304be44e5a9e0441768beacff0.apk", (Bundle)localObject, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTribeAppController.2
 * JD-Core Version:    0.7.0.1
 */