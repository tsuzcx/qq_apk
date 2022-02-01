package com.tencent.mobileqq.filemanager.activity;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Random;

class FilePreviewActivity$6
  implements View.OnClickListener
{
  FilePreviewActivity$6(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.startTitleProgress();
    this.a.w.setVisibility(8);
    this.a.x.setText(2131892582);
    this.a.A.setOnClickListener(null);
    if (this.a.C != null)
    {
      FilePreviewDataReporter localFilePreviewDataReporter = this.a.C;
      localFilePreviewDataReporter.i += 1;
    }
    int i = new Random(System.currentTimeMillis()).nextInt(1500);
    new Handler().postDelayed(new FilePreviewActivity.6.1(this), i % 1001 + 500);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.6
 * JD-Core Version:    0.7.0.1
 */