package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class FavEmosmViewPage$1
  implements QQPermissionCallback
{
  FavEmosmViewPage$1(FavEmosmViewPage paramFavEmosmViewPage) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a.a);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.c();
    FavEmosmViewPage.a(this.a).f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavEmosmViewPage.1
 * JD-Core Version:    0.7.0.1
 */