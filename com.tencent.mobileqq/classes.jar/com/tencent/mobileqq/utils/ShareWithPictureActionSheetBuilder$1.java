package com.tencent.mobileqq.utils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class ShareWithPictureActionSheetBuilder$1
  implements View.OnClickListener
{
  ShareWithPictureActionSheetBuilder$1(ShareWithPictureActionSheetBuilder paramShareWithPictureActionSheetBuilder) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.isShowing())
    {
      this.a.a.cancel();
      this.a.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareWithPictureActionSheetBuilder.1
 * JD-Core Version:    0.7.0.1
 */