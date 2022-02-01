package com.tencent.mobileqq.music;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mediafocus.MediaFocusManager.OnMediaFocusChangeListener;

final class QQPlayerService$12
  implements MediaFocusManager.OnMediaFocusChangeListener
{
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case 1: 
      QQPlayerService.a(BaseApplicationImpl.getContext(), QQPlayerService.b());
      return;
    }
    QQPlayerService.c(BaseApplicationImpl.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.12
 * JD-Core Version:    0.7.0.1
 */