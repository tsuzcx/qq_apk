package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import com.tencent.mobileqq.statistics.ReportController;

public class QfileFavDocFileTabView
  extends QfileFavFileTabView
{
  public QfileFavDocFileTabView(Context paramContext, QfileFavFileRecordProvider paramQfileFavFileRecordProvider, QfileBaseFavFileTabView.ITabBarViewProxy paramITabBarViewProxy)
  {
    super(paramContext, paramQfileFavFileRecordProvider, paramITabBarViewProxy);
  }
  
  protected void a(boolean paramBoolean)
  {
    ReportController.b(this.D, "dc00898", "", "", "0X800AFA9", "0X800AFA9", 0, 0, "", "", "", "");
  }
  
  protected int getFileRecordType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavDocFileTabView
 * JD-Core Version:    0.7.0.1
 */