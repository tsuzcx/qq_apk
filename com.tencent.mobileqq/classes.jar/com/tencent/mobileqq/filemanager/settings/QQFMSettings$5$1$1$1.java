package com.tencent.mobileqq.filemanager.settings;

import android.widget.ProgressBar;

class QQFMSettings$5$1$1$1
  implements Runnable
{
  QQFMSettings$5$1$1$1(QQFMSettings.5.1.1 param1, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    this.c.a.b.setVisibility(0);
    float f = (float)this.a / (float)this.b;
    this.c.a.b.setProgress((int)(f * 100.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.QQFMSettings.5.1.1.1
 * JD-Core Version:    0.7.0.1
 */