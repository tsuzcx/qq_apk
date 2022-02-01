package com.tencent.mobileqq.kandian.ad.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IRIJCommonService
  extends QRouteApi
{
  public abstract String appendUrlParameter(String paramString);
  
  public abstract void applySharedPreferences(SharedPreferences.Editor paramEditor, boolean paramBoolean);
  
  public abstract boolean checkIsVideoFeedsGameAdComBarLocalConfigToday(AppRuntime paramAppRuntime);
  
  public abstract void closeFloatWindow(Context paramContext);
  
  public abstract String getProteusOfflineBid(String paramString);
  
  public abstract SharedPreferences getReadInJoySP(AppRuntime paramAppRuntime, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract <T> T getReadInJoySpValue(String paramString, T paramT);
  
  public abstract boolean isDailyChannel(int paramInt);
  
  public abstract boolean isRecommendChannel(int paramInt);
  
  public abstract Integer jumpToUrl(Context paramContext, String paramString);
  
  public abstract Integer jumpToUrl(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public abstract Map<String, String> parseContentXml(String paramString);
  
  public abstract void showPopSheetDialog(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public abstract void updateProteusOfflineBid(String paramString1, String paramString2);
  
  public abstract <T> void updateReadInJoySpValue(String paramString, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJCommonService
 * JD-Core Version:    0.7.0.1
 */