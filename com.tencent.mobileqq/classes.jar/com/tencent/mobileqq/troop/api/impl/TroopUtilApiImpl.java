package com.tencent.mobileqq.troop.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.utils.TroopUtils;

public class TroopUtilApiImpl
  implements ITroopUtilApi
{
  public boolean hasSetTroopHead(String paramString)
  {
    return TroopUtils.a(paramString);
  }
  
  public void openTroopInfoActivity(Context paramContext, Bundle paramBundle, int paramInt)
  {
    TroopUtils.a(paramContext, paramBundle, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */