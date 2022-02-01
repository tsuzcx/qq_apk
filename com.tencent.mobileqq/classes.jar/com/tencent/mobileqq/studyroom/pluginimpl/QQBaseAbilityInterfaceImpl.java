package com.tencent.mobileqq.studyroom.pluginimpl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.intervideo.now.dynamic.IPluginManagerInterfaceImpl;
import com.tencent.mobileqq.intervideo.now.dynamic.IPluginManagerInterfaceImplApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studyroom.api.impl.StudyRoomReporterImpl;
import com.tencent.mobileqq.studyroom.config.StudyRoomConfBean;
import com.tencent.mobileqq.studyroom.config.StudyRoomConfProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.CommonCallback;
import com.tencent.qqinterface.DownloadCallback;
import com.tencent.qqinterface.QQBaseAbilityInterface;
import com.tencent.qqinterface.QQConfigAbilityInterface;
import com.tencent.qqinterface.QQConfigAbilityInterface.Callback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class QQBaseAbilityInterfaceImpl
  implements QQBaseAbilityInterface, QQConfigAbilityInterface
{
  private static final String TAG = "studyroom.QQBaseAbilityInterface";
  private final IPluginManagerInterfaceImpl impl = ((IPluginManagerInterfaceImplApi)QRoute.api(IPluginManagerInterfaceImplApi.class)).getInstance();
  private final AtomicBoolean mClientInitialized = new AtomicBoolean(false);
  private final ExecutorService networkExecutor = ThreadManagerExecutor.getExecutorService(128);
  
  public QQBaseAbilityInterfaceImpl()
  {
    QLog.d("studyroom.QQBaseAbilityInterface", 4, "init");
  }
  
  private TroopMemberApiClient getClient()
  {
    TroopMemberApiClient localTroopMemberApiClient = TroopMemberApiClient.a();
    if (this.mClientInitialized.compareAndSet(false, true)) {
      localTroopMemberApiClient.a();
    }
    return localTroopMemberApiClient;
  }
  
  private void uploadPic(JSONObject paramJSONObject, QQConfigAbilityInterface.Callback<JSONObject> paramCallback)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("localPath");
      if (TextUtils.isEmpty(paramJSONObject)) {
        return;
      }
      getClient().e(paramJSONObject, new QQBaseAbilityInterfaceImpl.2(this, paramCallback));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void uploadPicCancel(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("localPath");
      if (TextUtils.isEmpty(paramJSONObject)) {
        return;
      }
      getClient().g(paramJSONObject);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void beaconReportData(Bundle paramBundle, int paramInt) {}
  
  public boolean callMethod(int paramInt, JSONObject paramJSONObject, QQConfigAbilityInterface.Callback<JSONObject> paramCallback)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return false;
      }
      uploadPicCancel(paramJSONObject);
      return true;
    }
    uploadPic(paramJSONObject, paramCallback);
    return true;
  }
  
  public void doCgiReq(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback) {}
  
  public void download(Bundle paramBundle, DownloadCallback paramDownloadCallback)
  {
    String str = paramBundle.getString("path", "");
    this.impl.a(paramBundle, new QQBaseAbilityInterfaceImpl.1(this, str, paramDownloadCallback));
  }
  
  protected void finalize()
  {
    try
    {
      if (this.mClientInitialized.get()) {
        getClient().b();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public Future<Bundle> getA1(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return null;
  }
  
  public Future<Bundle> getAccessToken(String paramString1, String paramString2)
  {
    return this.networkExecutor.submit(new QQBaseAbilityInterfaceImpl.GetAccessTokenBundle(paramString2, paramString1));
  }
  
  public JSONObject getConfigFromQQ()
  {
    StudyRoomConfBean localStudyRoomConfBean = StudyRoomConfProcessor.a();
    if (localStudyRoomConfBean != null) {
      return localStudyRoomConfBean.a;
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
  
  public void printQLog(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6) {
            return;
          }
          QLog.e(paramString1, 1, paramString2);
          return;
        }
        QLog.w(paramString1, 1, paramString2);
        return;
      }
      QLog.i(paramString1, 1, paramString2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public void printQLog(Bundle paramBundle)
  {
    this.impl.a(paramBundle);
  }
  
  public void reportData(Bundle paramBundle)
  {
    if (MobileQQ.sProcessId == 1)
    {
      StudyRoomReporterImpl.report(paramBundle);
      return;
    }
    getClient().c(paramBundle);
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
    StudyRoomConfProcessor.a();
  }
  
  public void sendSSOTask(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback) {}
  
  public void showToast(Context paramContext, CharSequence paramCharSequence, int paramInt) {}
  
  public boolean useIpDirectConnect()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.pluginimpl.QQBaseAbilityInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */