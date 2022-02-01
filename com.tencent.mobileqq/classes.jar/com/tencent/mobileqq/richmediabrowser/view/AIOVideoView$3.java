package com.tencent.mobileqq.richmediabrowser.view;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class AIOVideoView$3
  implements QQPermissionCallback
{
  AIOVideoView$3(AIOVideoView paramAIOVideoView) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a.c);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AIOVideoView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.3
 * JD-Core Version:    0.7.0.1
 */