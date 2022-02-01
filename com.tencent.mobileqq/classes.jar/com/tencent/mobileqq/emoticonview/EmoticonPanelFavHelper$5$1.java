package com.tencent.mobileqq.emoticonview;

import araj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class EmoticonPanelFavHelper$5$1
  implements Runnable
{
  EmoticonPanelFavHelper$5$1(EmoticonPanelFavHelper.5 param5, Object paramObject) {}
  
  public void run()
  {
    int i = ((Integer)this.val$data).intValue();
    switch (i)
    {
    default: 
      i = 0;
      if (i != 0) {
        QQToast.a(BaseApplicationImpl.sApplication, 1, i, 0).b(this.this$1.this$0.mPanelController.toastOffset);
      }
      break;
    }
    do
    {
      return;
      i = 2131691768;
      break;
      i = 2131691770;
      break;
      i = 2131691772;
      break;
      i = 2131691771;
      break;
      i = 2131691767;
      break;
      i = 2131691769;
      break;
      QLog.e("FavEmoRoamingObserver", 1, new Object[] { "update panel, over limit flag:", Boolean.valueOf(CameraEmoAllSend.b), " ret:", Integer.valueOf(i), " isResumed:", Boolean.valueOf(this.this$1.this$0.mPanelController.isResumed) });
    } while ((CameraEmoAllSend.b) || (!this.this$1.this$0.mPanelController.isResumed));
    CameraEmoAllSend.b = true;
    if (i == 7) {}
    for (i = 1;; i = 2)
    {
      araj.b(this.this$1.this$0.mPanelController.app, this.this$1.this$0.mPanelController.context, i);
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.5.1
 * JD-Core Version:    0.7.0.1
 */