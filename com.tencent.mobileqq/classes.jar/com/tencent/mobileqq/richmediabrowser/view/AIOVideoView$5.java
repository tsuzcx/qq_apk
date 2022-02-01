package com.tencent.mobileqq.richmediabrowser.view;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class AIOVideoView$5
  implements QQPermissionCallback
{
  AIOVideoView$5(AIOVideoView paramAIOVideoView) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a.mContext);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AIOVideoView.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.5
 * JD-Core Version:    0.7.0.1
 */