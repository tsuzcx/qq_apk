package com.tencent.qzonehub.api.impl;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import cooperation.qzone.patch.QZonePatchRequest;
import cooperation.qzone.plugin.PluginIntent.OnResultListner;

class QzonePatchApiImpl$1
  implements PluginIntent.OnResultListner
{
  QzonePatchApiImpl$1(QzonePatchApiImpl paramQzonePatchApiImpl) {}
  
  public void onRecieve(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = QZonePatchRequest.onResponse(paramFromServiceMsg.getWupBuffer());
      QzonePatchApiImpl.access$000(this.a, paramIntent);
      ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).handleModuleRsp(paramIntent);
      paramFromServiceMsg = this.a;
      boolean bool;
      if (paramIntent != null) {
        bool = true;
      } else {
        bool = false;
      }
      QzonePatchApiImpl.access$102(paramFromServiceMsg, bool);
    }
    else
    {
      QzonePatchApiImpl.access$102(this.a, false);
    }
    QzonePatchApiImpl.access$202(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzonePatchApiImpl.1
 * JD-Core Version:    0.7.0.1
 */