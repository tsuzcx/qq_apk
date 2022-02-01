package com.tencent.mobileqq.music;

import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.colornote.smallscreen.IServiceSyncListener;

class QQPlayerService$3
  implements IServiceSyncListener
{
  QQPlayerService$3(QQPlayerService paramQQPlayerService) {}
  
  public void onServiceSyncSucc(boolean paramBoolean)
  {
    if ((QQPlayerService.b()) && (QQPlayerService.a(this.a) != null) && (!QQPlayerService.a(this.a).c())) {
      QQPlayerService.a(this.a).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.3
 * JD-Core Version:    0.7.0.1
 */