package com.tencent.mobileqq.filemanager.activity;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.open.downloadnew.DownloadInfo;

class UniformDownloadActivity$10$2
  implements Runnable
{
  UniformDownloadActivity$10$2(UniformDownloadActivity.10 param10, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    UniformDownloadActivity.h(this.b.a).setVisibility(0);
    UniformDownloadActivity.j(this.b.a).setVisibility(0);
    TextView localTextView = UniformDownloadActivity.k(this.b.a);
    UniformDownloadActivity localUniformDownloadActivity = this.b.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.t);
    localStringBuilder.append("%");
    localTextView.setText(localUniformDownloadActivity.getString(2131888811, new Object[] { localStringBuilder.toString() }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.10.2
 * JD-Core Version:    0.7.0.1
 */