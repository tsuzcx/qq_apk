package com.tencent.mobileqq.filemanager.openbrowser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnAppStorePromoteListener;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public abstract class FileBrowserModelDefault
  implements IFileBrowserModel
{
  public static String a = "https://docs.qq.com/desktop/favicon.ico";
  
  private QFileAppStorePromoteManager a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface)) {
      return null;
    }
    return ((QQAppInterface)localAppRuntime).getFileManagerEngine().a();
  }
  
  public String a(Context paramContext)
  {
    QFileAppStorePromoteManager localQFileAppStorePromoteManager = a();
    if (localQFileAppStorePromoteManager == null) {
      return null;
    }
    if (!e()) {
      return null;
    }
    if (!localQFileAppStorePromoteManager.b()) {
      return null;
    }
    if (TextUtils.isEmpty(f())) {
      return null;
    }
    int i = c();
    if ((i != 6) && (i != 2) && (i != 4) && (i != 5)) {
      return localQFileAppStorePromoteManager.a(paramContext);
    }
    return null;
  }
  
  public void a(Activity paramActivity, int paramInt, String paramString)
  {
    MiniChatActivity.a(paramActivity, paramInt, paramString, ContactUtils.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), paramString, paramInt));
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    FileManagerUtil.a(paramActivity, paramString);
  }
  
  public void a(Context paramContext)
  {
    QFileAppStorePromoteManager localQFileAppStorePromoteManager = a();
    if (localQFileAppStorePromoteManager == null) {
      return;
    }
    String str = f();
    if (localQFileAppStorePromoteManager.a())
    {
      if (!TextUtils.isEmpty(str))
      {
        QFileAppStorePromoteManager.a(str, 1);
        return;
      }
      QLog.i("FileBrowserModel", 1, "app store has installed, but apk package name is null!");
      return;
    }
    localQFileAppStorePromoteManager.b(paramContext, str);
  }
  
  public void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public void a(JSONObject paramJSONObject, String paramString, Context paramContext)
  {
    TencentDocData localTencentDocData = new TencentDocData();
    TencentDocData.obtainFromJsonObject(paramJSONObject, null, localTencentDocData);
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("key_flag_from_plugin", true);
    paramJSONObject.putExtra("k_forward_show_direct_share_tips", true);
    paramJSONObject.setClass(paramContext, ForwardRecentActivity.class);
    ShareMsgHelper.a(paramContext, 1001, 95, "web_share", "", localTencentDocData.docIcon, localTencentDocData.title, localTencentDocData.summary, paramContext.getString(2131696401, new Object[] { localTencentDocData.title }), paramString, "web", null, null, null, "web", null, null, null, a, paramContext.getString(2131719569), "", paramJSONObject, 2865, "https://docs.qq.com/desktop/m/index.html?_wv=2097154", -1L);
  }
  
  public void a(JSONObject paramJSONObject, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Activity paramActivity)
  {
    TencentDocData localTencentDocData = new TencentDocData();
    TencentDocData.obtainFromJsonObject(paramJSONObject, null, localTencentDocData);
    localTencentDocData.docUrl = paramString;
    TeamWorkUtils.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), paramActivity, localTencentDocData, paramTeamWorkFileImportInfo);
  }
  
  public boolean a(Context paramContext, IFileBrowserModel.OnAppStorePromoteListener paramOnAppStorePromoteListener)
  {
    QFileAppStorePromoteManager localQFileAppStorePromoteManager = a();
    if (localQFileAppStorePromoteManager == null) {
      return false;
    }
    return localQFileAppStorePromoteManager.a(paramContext, g(), new FileBrowserModelDefault.1(this, paramOnAppStorePromoteListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.FileBrowserModelDefault
 * JD-Core Version:    0.7.0.1
 */