package com.tencent.mobileqq.studyroom.pluginimpl;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.studyroom.upload.StudyRoomPicUploadUtil;
import com.tencent.qqinterface.QQConfigAbilityInterface.Callback;

class QQBaseAbilityInterfaceImpl$2
  implements TroopMemberApiClient.Callback
{
  QQBaseAbilityInterfaceImpl$2(QQBaseAbilityInterfaceImpl paramQQBaseAbilityInterfaceImpl, QQConfigAbilityInterface.Callback paramCallback) {}
  
  public void callback(Bundle paramBundle)
  {
    if (this.val$callback != null) {
      this.val$callback.onResult(StudyRoomPicUploadUtil.a(paramBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.pluginimpl.QQBaseAbilityInterfaceImpl.2
 * JD-Core Version:    0.7.0.1
 */