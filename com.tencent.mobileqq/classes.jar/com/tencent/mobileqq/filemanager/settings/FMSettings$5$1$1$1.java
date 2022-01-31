package com.tencent.mobileqq.filemanager.settings;

import android.widget.ProgressBar;
import apto;
import aptp;

public class FMSettings$5$1$1$1
  implements Runnable
{
  public FMSettings$5$1$1$1(aptp paramaptp, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aptp.a.a.setVisibility(0);
    float f = (float)this.jdField_a_of_type_Long / (float)this.b;
    this.jdField_a_of_type_Aptp.a.a.setProgress((int)(f * 100.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings.5.1.1.1
 * JD-Core Version:    0.7.0.1
 */