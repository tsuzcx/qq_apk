package com.tencent.mobileqq.music;

import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class ColorNoteQQPlayerCallback
  implements IQQPlayerLifeCycleCallback
{
  private ColorNoteMusicProxy a;
  
  public void a(AppService paramAppService)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteQQPlayerCallback", 2, "[onCreate]");
    }
    this.a = new ColorNoteMusicProxy(paramAppService.getBaseContext());
  }
  
  public void b(AppService paramAppService)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteQQPlayerCallback", 2, "[onDestroy]");
    }
    this.a.a();
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.ColorNoteQQPlayerCallback
 * JD-Core Version:    0.7.0.1
 */