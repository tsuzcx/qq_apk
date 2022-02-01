package com.tencent.qqinterface;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.Future;

public abstract interface QQBaseAbilityInterface
{
  public abstract void beaconReportData(Bundle paramBundle, int paramInt);
  
  public abstract void doCgiReq(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback);
  
  public abstract void download(Bundle paramBundle, DownloadCallback paramDownloadCallback);
  
  public abstract Future<Bundle> getA1(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract Future<Bundle> getAccessToken(String paramString1, String paramString2);
  
  public abstract String getSelfUin();
  
  public abstract Bundle getTickets();
  
  public abstract void hasPluginLoaded();
  
  public abstract boolean isMobileNet();
  
  public abstract void jumpAction(String paramString);
  
  public abstract void openWebView(Bundle paramBundle);
  
  public abstract void printQLog(Bundle paramBundle);
  
  public abstract void reportData(Bundle paramBundle);
  
  public abstract String reqDns(String paramString);
  
  public abstract void sendSSOTask(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback);
  
  public abstract void showToast(Context paramContext, CharSequence paramCharSequence, int paramInt);
  
  public abstract boolean useIpDirectConnect();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqinterface.QQBaseAbilityInterface
 * JD-Core Version:    0.7.0.1
 */