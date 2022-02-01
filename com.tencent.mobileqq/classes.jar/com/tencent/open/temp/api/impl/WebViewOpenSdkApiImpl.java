package com.tencent.open.temp.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.filemanageraux.app.UniformDownload;
import com.tencent.mobileqq.filemanageraux.app.UniformDownload.UniDownloadListener;
import com.tencent.open.appstore.dl.DownloadInfoReport;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.temp.api.IWebViewOpenSdkApi;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

public class WebViewOpenSdkApiImpl
  implements IWebViewOpenSdkApi
{
  public void cancelDownload(String paramString1, String paramString2, boolean paramBoolean)
  {
    DownloadApi.a(paramString1, paramString2, paramBoolean);
  }
  
  public Object createDownloadListener(Activity paramActivity, AppRuntime paramAppRuntime, Object paramObject, Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("fromArkAppDownload", false);
    paramActivity = new UniformDownload.UniDownloadListener((AppInterface)paramAppRuntime, paramActivity, (TouchWebView)paramObject);
    paramActivity.a(bool);
    return paramActivity;
  }
  
  public void downloadByDownloadApi(Activity paramActivity, Bundle paramBundle)
  {
    DownloadApi.a(paramActivity, paramBundle, "biz_src_yyb", null, 0);
  }
  
  public void downloadByUniformDownload(Bundle paramBundle, Activity paramActivity, String paramString1, String paramString2)
  {
    if (paramBundle != null)
    {
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("qb_info", 0);
      if (localSharedPreferences != null)
      {
        paramBundle.putString("param_content_memo", localSharedPreferences.getString("content_memo", null));
        paramBundle.putString("param_icon_path", localSharedPreferences.getString("icon_url", null));
      }
      paramBundle.putString("param_user_agent", paramString2);
      paramBundle.putString("param_refer_url", paramString1);
      paramString1 = paramBundle.getString("qb_param_url");
      if ((paramString1 != null) && (paramString1.length() != 0))
      {
        paramBundle.remove("qb_param_url");
        paramBundle.putBoolean("param_isqbdownload", true);
        UniformDownload.a(paramActivity, paramString1, paramBundle);
      }
    }
  }
  
  public void downloadUrlByUniformDownload(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, Activity paramActivity, String paramString5)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("_filesize", paramLong);
    localBundle.putString("param_user_agent", paramString2);
    localBundle.putString("param_content_des", paramString3);
    localBundle.putString("param_mime_type", paramString4);
    localBundle.putString("param_refer_url", paramString5);
    UniformDownload.a(paramActivity, paramString1, localBundle);
  }
  
  public Object getDownloadInfo(String paramString)
  {
    return DownloadManager.a().a(paramString);
  }
  
  public boolean hasMyAppTask(String paramString)
  {
    return DownloadApi.a(paramString);
  }
  
  public void reportDownloadInfo(Context paramContext, Object paramObject)
  {
    if ((paramObject instanceof DownloadInfo)) {
      DownloadInfoReport.a(paramContext, (DownloadInfo)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.temp.api.impl.WebViewOpenSdkApiImpl
 * JD-Core Version:    0.7.0.1
 */