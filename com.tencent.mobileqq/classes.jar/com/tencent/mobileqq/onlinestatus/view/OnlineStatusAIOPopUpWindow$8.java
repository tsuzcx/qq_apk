package com.tencent.mobileqq.onlinestatus.view;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class OnlineStatusAIOPopUpWindow$8
  implements QQPermissionCallback
{
  OnlineStatusAIOPopUpWindow$8(OnlineStatusAIOPopUpWindow paramOnlineStatusAIOPopUpWindow) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(OnlineStatusAIOPopUpWindow.f(this.a), 2131896422, 2131896423);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    OnlineStatusAIOPopUpWindow.h(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusAIOPopUpWindow.8
 * JD-Core Version:    0.7.0.1
 */