package com.tencent.mobileqq.businessCard.activity;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class CardPicGalleryActivity$6
  implements QQPermissionCallback
{
  CardPicGalleryActivity$6(CardPicGalleryActivity paramCardPicGalleryActivity, URLDrawable paramURLDrawable) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.b, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.b.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity.6
 * JD-Core Version:    0.7.0.1
 */