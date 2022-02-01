package com.tencent.mobileqq.intervideo.now.dynamic;

import android.content.Context;
import android.os.Bundle;
import com.tencent.intervideo.nowproxy.ability.ExtSdkBizAbilityImpl;
import com.tencent.intervideo.nowproxy.ability.SdkBaseAbilityImpl;
import com.tencent.qqinterface.CommonCallback;
import com.tencent.qqinterface.DownloadCallback;
import com.tencent.qqinterface.QQBaseAbilityInterface;
import java.util.concurrent.Future;

public class QQBaseAbilityInterfaceImpl
  implements QQBaseAbilityInterface
{
  SdkBaseAbilityImpl baseHolder = SdkBaseAbilityImpl.getsInstance();
  
  public void beaconReportData(Bundle paramBundle, int paramInt)
  {
    ExtSdkBizAbilityImpl.getInstance().beaconReportData(paramBundle, paramInt);
  }
  
  public void doCgiReq(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    this.baseHolder.doCgiReq(paramBundle, paramCommonCallback);
  }
  
  public void download(Bundle paramBundle, DownloadCallback paramDownloadCallback)
  {
    String str1 = paramBundle.getString("url", "");
    String str2 = paramBundle.getString("path", "");
    boolean bool = paramBundle.getBoolean("is_predownload", false);
    paramBundle = paramBundle.getBundle("user_data");
    this.baseHolder.download(bool, str1, str2, paramBundle, new QQBaseAbilityInterfaceImpl.1(this, str2, paramDownloadCallback));
  }
  
  public Future<Bundle> getA1(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return this.baseHolder.getA1(paramString1, paramString2, paramString3, paramString4);
  }
  
  public Future<Bundle> getAccessToken(String paramString1, String paramString2)
  {
    return this.baseHolder.getAccessToken(paramString1, paramString2);
  }
  
  public String getSelfUin()
  {
    return "";
  }
  
  public Bundle getTickets()
  {
    return this.baseHolder.getTickets();
  }
  
  public void hasPluginLoaded()
  {
    this.baseHolder.hasPluginLoaded();
  }
  
  public boolean isMobileNet()
  {
    return false;
  }
  
  public void jumpAction(String paramString) {}
  
  public void openWebView(Bundle paramBundle)
  {
    this.baseHolder.openWebView(paramBundle, null);
  }
  
  public void printQLog(Bundle paramBundle)
  {
    this.baseHolder.printQLog(paramBundle);
  }
  
  public void reportData(Bundle paramBundle)
  {
    this.baseHolder.reportData(paramBundle);
  }
  
  public String reqDns(String paramString)
  {
    return this.baseHolder.reqDns(paramString);
  }
  
  public void sendSSOTask(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback)
  {
    this.baseHolder.sendSSOTask(paramBundle, paramCommonCallback);
  }
  
  public void showToast(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    this.baseHolder.showToast(paramContext, paramCharSequence, paramInt);
  }
  
  public boolean useIpDirectConnect()
  {
    return this.baseHolder.useIpDirectConnect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.QQBaseAbilityInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */