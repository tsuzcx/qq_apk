package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import com.tencent.mobileqq.statistics.ReportController;

public class QfileFavVideoFileTabView
  extends QfileFavFileTabView
{
  public QfileFavVideoFileTabView(Context paramContext, QfileFavFileRecordProvider paramQfileFavFileRecordProvider, QfileBaseFavFileTabView.ITabBarViewProxy paramITabBarViewProxy)
  {
    super(paramContext, paramQfileFavFileRecordProvider, paramITabBarViewProxy);
  }
  
  protected void a(boolean paramBoolean)
  {
    ReportController.b(this.D, "dc00898", "", "", "0X800AFAB", "0X800AFAB", 0, 0, "", "", "", "");
  }
  
  protected int getFileRecordType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavVideoFileTabView
 * JD-Core Version:    0.7.0.1
 */