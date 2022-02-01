package com.tencent.mobileqq.intervideo.audioroom.pluginimpl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.CommonCallback;
import com.tencent.qqinterface.DownloadCallback;
import com.tencent.qqinterface.QQBaseAbilityInterface;
import java.util.concurrent.Future;

public class QQBaseAbilityInterfaceImpl
  implements QQBaseAbilityInterface
{
  private final TroopMemberApiClient a;
  
  public QQBaseAbilityInterfaceImpl()
  {
    QLog.d("QQBaseAbilityInterface", 4, "init");
    this.a = TroopMemberApiClient.a();
    this.a.e();
  }
  
  public void beaconReportData(Bundle paramBundle, int paramInt) {}
  
  public void doCgiReq(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback) {}
  
  public void download(Bundle paramBundle, DownloadCallback paramDownloadCallback) {}
  
  public Future<Bundle> getA1(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return null;
  }
  
  public Future<Bundle> getAccessToken(String paramString1, String paramString2)
  {
    return null;
  }
  
  public String getSelfUin()
  {
    return null;
  }
  
  public Bundle getTickets()
  {
    return null;
  }
  
  public void hasPluginLoaded()
  {
    QLog.d("QQBaseAbilityInterface", 4, "hasPluginLoaded");
  }
  
  public boolean isMobileNet()
  {
    return false;
  }
  
  public void jumpAction(String paramString)
  {
    AudioRoomJumpActionDispatcher.dispatch(paramString);
  }
  
  public void openWebView(Bundle paramBundle)
  {
    AudioRoomOpenWebViewHandler.openWebView(paramBundle);
  }
  
  public void printQLog(Bundle paramBundle) {}
  
  public void reportData(Bundle paramBundle)
  {
    this.a.c(paramBundle);
  }
  
  public String reqDns(String paramString)
  {
    return null;
  }
  
  public void sendSSOTask(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback) {}
  
  public void showToast(Context paramContext, CharSequence paramCharSequence, int paramInt) {}
  
  public boolean useIpDirectConnect()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.pluginimpl.QQBaseAbilityInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */