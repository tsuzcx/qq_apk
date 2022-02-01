package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class FavEmosmViewPage$5
  implements QQPermissionCallback
{
  FavEmosmViewPage$5(FavEmosmViewPage paramFavEmosmViewPage) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a.a);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    FavEmosmViewPage.b(this.a);
    ReportController.b(FavEmosmViewPage.a(this.a), "CliOper", "", "", "0X800A6D6", "0X800A6D6", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavEmosmViewPage.5
 * JD-Core Version:    0.7.0.1
 */