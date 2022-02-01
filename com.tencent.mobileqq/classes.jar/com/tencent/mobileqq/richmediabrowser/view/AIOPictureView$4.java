package com.tencent.mobileqq.richmediabrowser.view;

import android.text.TextUtils;
import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AIOPictureView$4
  implements ActionSheet.OnButtonClickListener
{
  AIOPictureView$4(AIOPictureView paramAIOPictureView, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.a.dismiss();
      return;
    }
    paramView = this.a.getContent(paramInt);
    if (paramView == null)
    {
      this.a.dismiss();
      return;
    }
    if (TextUtils.isEmpty(paramView))
    {
      this.a.dismiss();
      return;
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.4
 * JD-Core Version:    0.7.0.1
 */