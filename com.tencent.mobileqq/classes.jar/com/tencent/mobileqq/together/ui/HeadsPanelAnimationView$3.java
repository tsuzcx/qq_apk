package com.tencent.mobileqq.together.ui;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.ArrayList;
import java.util.List;

class HeadsPanelAnimationView$3
  implements Handler.Callback
{
  HeadsPanelAnimationView$3(HeadsPanelAnimationView paramHeadsPanelAnimationView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      paramMessage = (ArrayList)paramMessage.obj;
      if (this.a.j)
      {
        paramMessage = Message.obtain(this.a.f, 2, paramMessage);
        this.a.f.sendMessageDelayed(paramMessage, 500L);
        return false;
      }
      HeadsPanelAnimationView.a(this.a, paramMessage);
      return false;
    }
    if (this.a.g.size() == 0)
    {
      QLog.d("MatchViewHolder", 1, "MSG_START_ANIMATION uinList is empty!");
      return false;
    }
    this.a.c();
    if (this.a.f.hasMessages(1)) {
      this.a.f.removeMessages(1);
    }
    if ((this.a.g != null) && (this.a.g.size() > 3))
    {
      paramMessage = (String)this.a.g.get(3);
      Drawable localDrawable = ImageUtil.a(true);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null) {
        FaceDrawable.getFaceDrawable(localQQAppInterface, 1, paramMessage, 4, localDrawable, localDrawable);
      }
    }
    this.a.f.sendEmptyMessageDelayed(1, 5000L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.HeadsPanelAnimationView.3
 * JD-Core Version:    0.7.0.1
 */