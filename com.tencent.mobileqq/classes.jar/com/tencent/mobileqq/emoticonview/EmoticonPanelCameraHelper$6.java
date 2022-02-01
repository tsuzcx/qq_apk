package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerProxy;
import com.tencent.mobileqq.utils.NetworkUtil;

class EmoticonPanelCameraHelper$6
  implements Runnable
{
  EmoticonPanelCameraHelper$6(EmoticonPanelCameraHelper paramEmoticonPanelCameraHelper, Context paramContext, QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp) {}
  
  public void run()
  {
    if ((!NetworkUtil.d(this.val$context)) || (this.val$app == null)) {
      return;
    }
    ((CameraEmoRoamingManagerProxy)this.val$app.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER)).syncRoaming();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.6
 * JD-Core Version:    0.7.0.1
 */