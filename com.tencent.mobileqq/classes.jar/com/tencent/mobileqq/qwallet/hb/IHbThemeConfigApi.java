package com.tencent.mobileqq.qwallet.hb;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IHbThemeConfigApi
  extends QRouteApi
{
  public abstract String getConfigCache();
  
  public abstract JSONObject getFaceConfig(Context paramContext);
  
  public abstract void onDestory();
  
  public abstract void setConfigCache(String paramString);
  
  public abstract void updateConfig(AppInterface paramAppInterface, String paramString);
  
  public abstract void updateFaceConfig(AppInterface paramAppInterface, JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.IHbThemeConfigApi
 * JD-Core Version:    0.7.0.1
 */