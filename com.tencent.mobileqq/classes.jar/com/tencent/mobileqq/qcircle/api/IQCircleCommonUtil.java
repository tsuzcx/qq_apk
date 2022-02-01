package com.tencent.mobileqq.qcircle.api;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IQCircleCommonUtil
  extends QRouteApi
{
  public abstract int getColorFromJSON(JSONObject paramJSONObject, String paramString);
  
  public abstract int getDefaultThemeColor(boolean paramBoolean);
  
  public abstract String getQCirclePluginInfo();
  
  public abstract long getSystemTotalMemory();
  
  public abstract boolean isInNightMode();
  
  public abstract Bundle jsonToLabel(Bundle paramBundle, String paramString);
  
  public abstract String keyGpsInfo();
  
  public abstract String keyParseDataErrorMsg();
  
  public abstract String labelToJson(Bundle paramBundle);
  
  public abstract void setStatusBarColor(Activity paramActivity, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil
 * JD-Core Version:    0.7.0.1
 */