package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FolderTextView$2
  implements View.OnClickListener
{
  FolderTextView$2(FolderTextView paramFolderTextView) {}
  
  public void onClick(View paramView)
  {
    if (FolderTextView.b(this.a) == 0) {
      FolderTextView.a(this.a, 1);
    } else {
      FolderTextView.a(this.a, 0);
    }
    FolderTextView.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FolderTextView.2
 * JD-Core Version:    0.7.0.1
 */