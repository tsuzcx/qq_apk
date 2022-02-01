package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import aseg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;

class EmoticonPanelCameraHelper$6
  implements Runnable
{
  EmoticonPanelCameraHelper$6(EmoticonPanelCameraHelper paramEmoticonPanelCameraHelper, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((!NetworkUtil.isNetSupport(this.val$context)) || (this.val$app == null)) {
      return;
    }
    ((aseg)this.val$app.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.6
 * JD-Core Version:    0.7.0.1
 */