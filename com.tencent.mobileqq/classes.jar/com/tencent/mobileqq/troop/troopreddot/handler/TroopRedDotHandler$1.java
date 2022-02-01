package com.tencent.mobileqq.troop.troopreddot.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;

class TroopRedDotHandler$1
  extends TroopObserver
{
  TroopRedDotHandler$1(TroopRedDotHandler paramTroopRedDotHandler, long paramLong, int paramInt) {}
  
  public void onGetTroopAuth(boolean paramBoolean, long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    if ((this.a == paramLong) && (paramString.equals("SUBCMD_GET_TROOP_AUTH_FOR_REDPOINT")))
    {
      if ((paramBoolean) && (paramArrayOfByte != null))
      {
        paramString = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.a);
        TroopRedDotHandler.a(paramString, localStringBuilder.toString(), paramArrayOfByte, this.b);
      }
      TroopRedDotHandler.a(this.c).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopreddot.handler.TroopRedDotHandler.1
 * JD-Core Version:    0.7.0.1
 */