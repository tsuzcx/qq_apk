package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class EmoticonPanelFavHelper$5$1
  implements Runnable
{
  EmoticonPanelFavHelper$5$1(EmoticonPanelFavHelper.5 param5, Object paramObject) {}
  
  public void run()
  {
    int j = ((Integer)this.val$data).intValue();
    switch (j)
    {
    default: 
      break;
    case 7: 
    case 8: 
      boolean bool = CameraEmoAllSend.b;
      i = 2;
      QLog.e("FavEmoRoamingObserver", 1, new Object[] { "update panel, over limit flag:", Boolean.valueOf(bool), " ret:", Integer.valueOf(j), " isResumed:", Boolean.valueOf(((EmoticonPanelController)this.this$1.this$0.mPanelController).isResumed()) });
      if (!CameraEmoAllSend.b)
      {
        if (!((EmoticonPanelController)this.this$1.this$0.mPanelController).isResumed()) {
          return;
        }
        CameraEmoAllSend.b = true;
        if (j == 7) {
          i = 1;
        }
        EmoAddedAuthCallback.b(((EmoticonPanelController)this.this$1.this$0.mPanelController).app.getQQAppInterface(), ((EmoticonPanelController)this.this$1.this$0.mPanelController).context, i);
      }
      else
      {
        return;
      }
      break;
    case 6: 
      i = 2131691901;
      break;
    case 5: 
      i = 2131691900;
      break;
    case 4: 
      i = 2131699732;
      break;
    case 3: 
      i = 2131699733;
      break;
    case 2: 
      i = 2131699726;
      break;
    case 1: 
      i = 2131699725;
      break;
    }
    int i = 0;
    if (i != 0) {
      QQToast.a(MobileQQ.getContext(), 1, i, 0).b(((EmoticonPanelController)this.this$1.this$0.mPanelController).getToastOffset());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.5.1
 * JD-Core Version:    0.7.0.1
 */