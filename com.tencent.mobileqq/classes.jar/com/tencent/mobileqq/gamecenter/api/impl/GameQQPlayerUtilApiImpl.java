package com.tencent.mobileqq.gamecenter.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameQQPlayerUtilApi;
import com.tencent.mobileqq.gamecenter.data.GameQQPlayerUtils;

public class GameQQPlayerUtilApiImpl
  implements IGameQQPlayerUtilApi
{
  public String getMsgExtraString(AppInterface paramAppInterface, String paramString)
  {
    return GameQQPlayerUtils.a(paramAppInterface, paramString);
  }
  
  public void openGameMsgAIO(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7, String paramString8, int paramInt1, int paramInt2)
  {
    GameQQPlayerUtils.a(paramAppInterface, paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramLong, paramString7, paramString8, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameQQPlayerUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */