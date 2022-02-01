package com.tencent.mobileqq.relationx.icebreaking;

import com.tencent.mobileqq.app.TroopBusinessObserver;

class IceBreakingMng$4
  extends TroopBusinessObserver
{
  IceBreakingMng$4(IceBreakingMng paramIceBreakingMng) {}
  
  public void onPassiveExit(String paramString, int paramInt)
  {
    this.a.g(paramString);
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt2 == 0) && ((paramInt1 == 9) || (paramInt1 == 2))) {
      this.a.g(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng.4
 * JD-Core Version:    0.7.0.1
 */