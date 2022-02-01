package com.tencent.mobileqq.businessCard.activity;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class CardPicGalleryActivity$4
  implements ActionSheet.OnButtonClickListener
{
  CardPicGalleryActivity$4(CardPicGalleryActivity paramCardPicGalleryActivity, URLDrawable paramURLDrawable, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.c.a(paramInt, this.a);
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity.4
 * JD-Core Version:    0.7.0.1
 */