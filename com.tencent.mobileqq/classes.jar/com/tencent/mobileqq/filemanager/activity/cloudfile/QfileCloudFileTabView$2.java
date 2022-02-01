package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.view.View.OnClickListener;
import android.widget.TextView;

class QfileCloudFileTabView$2
  implements QfileCloudFileTabView.IWeiYunImageEvent
{
  QfileCloudFileTabView$2(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  public View.OnClickListener a(TextView paramTextView)
  {
    this.a.a = paramTextView;
    return new QfileCloudFileTabView.2.1(this);
  }
  
  public boolean a()
  {
    return this.a.c;
  }
  
  public boolean b()
  {
    return this.a.b;
  }
  
  public boolean c()
  {
    return QfileCloudFileTabView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.2
 * JD-Core Version:    0.7.0.1
 */