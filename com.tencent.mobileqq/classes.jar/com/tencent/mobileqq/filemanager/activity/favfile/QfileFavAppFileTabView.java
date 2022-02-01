package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import com.tencent.mobileqq.statistics.ReportController;

public class QfileFavAppFileTabView
  extends QfileFavFileTabView
{
  public QfileFavAppFileTabView(Context paramContext, QfileFavFileRecordProvider paramQfileFavFileRecordProvider, QfileBaseFavFileTabView.ITabBarViewProxy paramITabBarViewProxy)
  {
    super(paramContext, paramQfileFavFileRecordProvider, paramITabBarViewProxy);
  }
  
  protected void a(boolean paramBoolean)
  {
    ReportController.b(this.D, "dc00898", "", "", "0X800AFB1", "0X800AFB1", 0, 0, "", "", "", "");
  }
  
  protected int getFileRecordType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavAppFileTabView
 * JD-Core Version:    0.7.0.1
 */