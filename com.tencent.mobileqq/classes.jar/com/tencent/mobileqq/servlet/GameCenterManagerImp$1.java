package com.tencent.mobileqq.servlet;

import com.tencent.gamecenter.common.util.ScreenshotManager.ShotCallback;
import com.tencent.qphone.base.util.QLog;

class GameCenterManagerImp$1
  implements ScreenshotManager.ShotCallback
{
  GameCenterManagerImp$1(GameCenterManagerImp paramGameCenterManagerImp, int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("on push code=");
    paramString.append(paramInt);
    paramString.append(" cmd=");
    paramString.append(this.jdField_a_of_type_Int);
    QLog.i("GameCenterManagerImp", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.GameCenterManagerImp.1
 * JD-Core Version:    0.7.0.1
 */