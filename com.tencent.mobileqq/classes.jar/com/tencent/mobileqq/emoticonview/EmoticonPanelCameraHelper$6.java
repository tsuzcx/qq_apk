package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerServiceProxy;
import com.tencent.mobileqq.utils.NetworkUtil;

class EmoticonPanelCameraHelper$6
  implements Runnable
{
  EmoticonPanelCameraHelper$6(EmoticonPanelCameraHelper paramEmoticonPanelCameraHelper, Context paramContext, QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp) {}
  
  public void run()
  {
    if (NetworkUtil.isNetSupport(this.val$context))
    {
      QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = this.val$app;
      if (localQQEmoticonMainPanelApp == null) {
        return;
      }
      ((CameraEmoRoamingManagerServiceProxy)localQQEmoticonMainPanelApp.getRuntimeService(ICameraEmoRoamingManagerService.class)).syncRoaming();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.6
 * JD-Core Version:    0.7.0.1
 */