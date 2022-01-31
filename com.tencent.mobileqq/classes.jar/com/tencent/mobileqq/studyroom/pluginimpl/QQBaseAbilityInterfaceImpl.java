package com.tencent.mobileqq.studyroom.pluginimpl;

import android.content.Context;
import android.os.Bundle;
import ateg;
import babr;
import babs;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.CommonCallback;
import com.tencent.qqinterface.DownloadCallback;
import com.tencent.qqinterface.QQBaseAbilityInterface;
import com.tencent.qqinterface.QQConfigAbilityInterface;
import com.tencent.qqinterface.QQConfigAbilityInterface.Callback;
import java.util.concurrent.Future;
import org.json.JSONObject;
import yqz;

public class QQBaseAbilityInterfaceImpl
  implements QQBaseAbilityInterface, QQConfigAbilityInterface
{
  private static final String TAG = "studyroom.QQBaseAbilityInterface";
  private final ateg impl = ateg.a();
  private final yqz mClient;
  
  public QQBaseAbilityInterfaceImpl()
  {
    QLog.d("studyroom.QQBaseAbilityInterface", 4, "init");
    this.mClient = yqz.a();
    this.mClient.a();
  }
  
  public void beaconReportData(Bundle paramBundle, int paramInt) {}
  
  public void doCgiReq(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback) {}
  
  public void download(Bundle paramBundle, DownloadCallback paramDownloadCallback)
  {
    String str = paramBundle.getString("path", "");
    this.impl.a(paramBundle, new QQBaseAbilityInterfaceImpl.1(this, str, paramDownloadCallback));
  }
  
  public Future<Bundle> getA1(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return null;
  }
  
  public Future<Bundle> getAccessToken(String paramString1, String paramString2)
  {
    return this.impl.a(paramString1, paramString2);
  }
  
  public JSONObject getConfigFromQQ()
  {
    babr localbabr = babs.a();
    if (localbabr != null) {
      return localbabr.a;
    }
    return new JSONObject();
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
    QLog.d("studyroom.QQBaseAbilityInterface", 4, "hasPluginLoaded");
  }
  
  public boolean isMobileNet()
  {
    return false;
  }
  
  public void jumpAction(String paramString) {}
  
  public void openWebView(Bundle paramBundle) {}
  
  public void printQLog(Bundle paramBundle)
  {
    this.impl.b(paramBundle);
  }
  
  public void reportData(Bundle paramBundle)
  {
    this.mClient.b(paramBundle);
  }
  
  public String reqDns(String paramString)
  {
    return null;
  }
  
  public void requestConfigFromQQ(QQConfigAbilityInterface.Callback<JSONObject> paramCallback)
  {
    if (paramCallback != null) {
      paramCallback.onResult(getConfigFromQQ());
    }
    babs.b();
  }
  
  public void sendSSOTask(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback) {}
  
  public void showToast(Context paramContext, CharSequence paramCharSequence, int paramInt) {}
  
  public boolean useIpDirectConnect()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.pluginimpl.QQBaseAbilityInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */