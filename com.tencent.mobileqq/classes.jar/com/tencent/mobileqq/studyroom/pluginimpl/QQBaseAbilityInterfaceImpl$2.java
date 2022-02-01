package com.tencent.mobileqq.studyroom.pluginimpl;

import android.os.Bundle;
import com.tencent.mobileqq.studyroom.upload.StudyRoomPicUploadUtil;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qqinterface.QQConfigAbilityInterface.Callback;

class QQBaseAbilityInterfaceImpl$2
  implements ITroopMemberApiClientApi.Callback
{
  QQBaseAbilityInterfaceImpl$2(QQBaseAbilityInterfaceImpl paramQQBaseAbilityInterfaceImpl, QQConfigAbilityInterface.Callback paramCallback) {}
  
  public void callback(Bundle paramBundle)
  {
    QQConfigAbilityInterface.Callback localCallback = this.val$callback;
    if (localCallback != null) {
      localCallback.onResult(StudyRoomPicUploadUtil.a(paramBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.pluginimpl.QQBaseAbilityInterfaceImpl.2
 * JD-Core Version:    0.7.0.1
 */