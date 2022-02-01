package com.tencent.qzonehub.api.impl;

import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import android.text.TextUtils;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import com.tencent.qzonehub.api.IQzonePatchApi;
import cooperation.qzone.patch.QZonePatchService;
import cooperation.qzone.patch.QzoneUpdatePatchServlet;
import cooperation.qzone.plugin.PluginIntent;
import cooperation.qzone.plugin.QZonePluginUtils;

public class QzonePatchApiImpl
  implements IQzonePatchApi
{
  private boolean isLastSuccess;
  private boolean isRequesting;
  
  private void handlePatchResp(SQ_CLIENT_UPDATE_RSP paramSQ_CLIENT_UPDATE_RSP)
  {
    String str;
    Object localObject;
    if (QLog.isColorLevel())
    {
      str = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("收到补丁包信息：");
      ((StringBuilder)localObject).append(paramSQ_CLIENT_UPDATE_RSP);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
    if (paramSQ_CLIENT_UPDATE_RSP != null)
    {
      str = paramSQ_CLIENT_UPDATE_RSP.md5;
      paramSQ_CLIENT_UPDATE_RSP = paramSQ_CLIENT_UPDATE_RSP.upUrl;
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramSQ_CLIENT_UPDATE_RSP)))
      {
        if (QLog.isColorLevel())
        {
          localObject = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("patchMd5：");
          localStringBuilder.append(str);
          localStringBuilder.append(", patchUrl:");
          localStringBuilder.append(paramSQ_CLIENT_UPDATE_RSP);
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        QZonePatchService.getInstance().onPatchResponse(str, paramSQ_CLIENT_UPDATE_RSP);
      }
    }
  }
  
  public String getLoadQZoneLivePluginId()
  {
    return QZonePluginUtils.getLoadQZoneLivePluginId();
  }
  
  public void getPatchList()
  {
    if ((!this.isRequesting) && (!this.isLastSuccess))
    {
      this.isRequesting = true;
      localObject = new PluginIntent(BaseApplicationImpl.getContext(), QzoneUpdatePatchServlet.class);
      ((PluginIntent)localObject).module_update_infos = ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).getUpdateInfo();
      ((PluginIntent)localObject).setResultListner(new QzonePatchApiImpl.1(this));
      return;
    }
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPatchList() isRequesting:");
    localStringBuilder.append(this.isRequesting);
    localStringBuilder.append(", isLastSuccess:");
    localStringBuilder.append(this.isLastSuccess);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
  }
  
  public void triggerQQDownloadPtuFilter()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "triggerQQDownloadPtuFilter");
    }
    if (PtvFilterSoLoad.a())
    {
      QLog.w(TAG, 1, "triggerQQDownloadPtuFilter");
      ((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.AE_RES_BASE_PACKAGE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzonePatchApiImpl
 * JD-Core Version:    0.7.0.1
 */