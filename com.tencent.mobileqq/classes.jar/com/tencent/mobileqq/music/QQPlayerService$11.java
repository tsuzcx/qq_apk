package com.tencent.mobileqq.music;

import com.tencent.mobileqq.mediafocus.MediaFocusManager.OnMediaFocusChangeListener;
import mqq.app.MobileQQ;

final class QQPlayerService$11
  implements MediaFocusManager.OnMediaFocusChangeListener
{
  public void a(int paramInt)
  {
    if ((paramInt != -2) && (paramInt != -1))
    {
      if (paramInt != 1) {
        return;
      }
      QQPlayerService.a(MobileQQ.getContext(), QQPlayerService.y());
      return;
    }
    QQPlayerService.e(MobileQQ.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.11
 * JD-Core Version:    0.7.0.1
 */