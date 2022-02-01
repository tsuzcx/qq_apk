package com.tencent.mobileqq.filemanager.activity;

import android.widget.RelativeLayout;
import android.widget.TextView;

class UniformDownloadActivity$11$4
  implements Runnable
{
  UniformDownloadActivity$11$4(UniformDownloadActivity.11 param11, int paramInt) {}
  
  public void run()
  {
    UniformDownloadActivity.h(this.b.a).setVisibility(0);
    TextView localTextView = UniformDownloadActivity.k(this.b.a);
    UniformDownloadActivity localUniformDownloadActivity = this.b.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("%");
    localTextView.setText(localUniformDownloadActivity.getString(2131888810, new Object[] { localStringBuilder.toString() }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.11.4
 * JD-Core Version:    0.7.0.1
 */