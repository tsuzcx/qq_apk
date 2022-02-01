package com.tencent.mobileqq.troop.api.config;

import android.content.Context;
import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.List;
import mqq.app.AppRuntime;

public abstract class AbsTroopCommonProcessor
{
  public void a(List<String> paramList) {}
  
  public boolean a(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    return false;
  }
  
  public boolean b(AppRuntime paramAppRuntime, String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.AbsTroopCommonProcessor
 * JD-Core Version:    0.7.0.1
 */