package com.tencent.mobileqq.mini.out.activity;

import android.view.View;
import bfpc;
import com.tencent.widget.AdapterView;

class PhotoPreviewActivity$2
  implements bfpc
{
  PhotoPreviewActivity$2(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.this$0.showBar)
    {
      this.this$0.hideMenuBar();
      return;
    }
    this.this$0.showMenuBar();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PhotoPreviewActivity.2
 * JD-Core Version:    0.7.0.1
 */