package com.tencent.mobileqq.ocr.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TranslatePopupActionSheetMenuDialog$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.TranslatePopupActionSheetMenuDialog.1
 * JD-Core Version:    0.7.0.1
 */