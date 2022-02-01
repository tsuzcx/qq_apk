package com.tencent.mobileqq.nearby.gameroom;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.QQPermissionCallback;

class GameRoomTransActivity$1
  implements QQPermissionCallback
{
  GameRoomTransActivity$1(GameRoomTransActivity paramGameRoomTransActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QQToast.makeText(this.a, HardCodeUtil.a(2131903055), 0).show();
    this.a.finish();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.doWork();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity.1
 * JD-Core Version:    0.7.0.1
 */