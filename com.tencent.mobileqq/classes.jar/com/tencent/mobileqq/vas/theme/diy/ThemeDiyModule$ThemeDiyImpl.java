package com.tencent.mobileqq.vas.theme.diy;

import android.os.Bundle;
import org.json.JSONObject;

public abstract interface ThemeDiyModule$ThemeDiyImpl
{
  public abstract void callJs(String paramString, String... paramVarArgs);
  
  public abstract void diyThemeSetup(JSONObject paramJSONObject, String paramString);
  
  public abstract void downloadBgPic(String paramString, Bundle paramBundle);
  
  public abstract void startDownload(JSONObject paramJSONObject, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeDiyModule.ThemeDiyImpl
 * JD-Core Version:    0.7.0.1
 */