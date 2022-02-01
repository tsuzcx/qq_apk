package com.tencent.mobileqq.filemanager.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.qfile.IQFileAppStorePromoteConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileAppStorePromoteDialogConfigBean;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class QFileAppStorePromoteManager
{
  private static long e;
  private QQAppInterface a;
  private boolean b = false;
  private HashMap<Integer, QFileAppStorePromoteManager.IGetAppDetailCallback> c;
  private QFileAppStorePromoteManager.FetchAppInfoCallback d;
  
  public QFileAppStorePromoteManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.d = new QFileAppStorePromoteManager.FetchAppInfoCallback(this);
    this.c = new HashMap();
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (System.currentTimeMillis() - e < 1000L)
    {
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, "startAppStoreByTmast: start app store limit.");
      return;
    }
    e = System.currentTimeMillis();
    if (TextUtils.isEmpty(paramString)) {
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, "startAppStoreByTmast : error. apk package name can not be null.");
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startAppStoreByTmast : apkPkgName[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, ((StringBuilder)localObject).toString());
    }
    paramString = b(paramString, paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startAppStoreByTmast : jumpTmast[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("url", paramString);
    TMAssistantCallYYB_V2.getInstance().addDownloadTaskFromTmast((Bundle)localObject);
    localObject = new Intent("android.intent.action.VIEW");
    ((Intent)localObject).setPackage("com.tencent.android.qqdownloader");
    ((Intent)localObject).setData(Uri.parse(paramString));
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_file");
    try
    {
      BaseApplication.getContext().startActivity((Intent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startAppStoreByTmast : error. ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private static String b(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("tmast://appdetails?");
    localStringBuilder.append("pname=");
    localStringBuilder.append(paramString);
    if (paramInt == 2)
    {
      localStringBuilder.append("&via=");
      localStringBuilder.append("ANDROIDQQ.NEWYYB.APKBYYBAPK");
      ReportController.b(null, "dc00898", "", "", "0X800B00E", "0X800B00E", 0, 0, "", "", "", "");
    }
    else
    {
      localStringBuilder.append("&via=");
      localStringBuilder.append("ANDROIDQQ.YYB.APKBYYBAPK");
    }
    localStringBuilder.append("&qimei=");
    localStringBuilder.append(UserAction.getQIMEI());
    return localStringBuilder.toString();
  }
  
  public static void c()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B00D", "0X800B00D", 0, 0, "", "", "", "");
  }
  
  public String a(Context paramContext)
  {
    String str2 = f().b();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramContext.getString(2131896211);
    }
    return str1;
  }
  
  public void a()
  {
    if (!this.b)
    {
      ThreadManagerV2.executeOnSubThread(new QFileAppStorePromoteManager.1(this));
      this.b = true;
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("params_open_with_yyb", paramString);
    ((Bundle)localObject).putString("big_brother_source_key", "biz_src_jc_file");
    if (d().getApp() == null)
    {
      paramString = new Bundle();
      paramString.putString("_filename_from_dlg", paramContext.getString(2131892262));
      paramString.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
      paramString.putBundle("_user_data", (Bundle)localObject);
      localObject = new Intent("com.tencent.mobileqq.qfile_unifromdownload");
      ((Intent)localObject).putExtra("param", paramString);
      ((Intent)localObject).putExtra("url", "https://a.app.qq.com/o/myapp-down?g_f=1116518");
      paramContext.sendBroadcast((Intent)localObject);
      return;
    }
    paramString = new Bundle();
    paramString.putString("_filename_from_dlg", paramContext.getString(2131892262));
    paramString.putString("big_brother_source_key", "biz_src_jc_file");
    paramString.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
    paramString.putBundle("_user_data", (Bundle)localObject);
    d().startDownloadNoSzie("https://a.app.qq.com/o/myapp-down?g_f=1116518", paramString);
  }
  
  public void a(String paramString, QFileAppStorePromoteManager.IGetAppDetailCallback paramIGetAppDetailCallback)
  {
    a();
    ThreadManagerV2.excute(new QFileAppStorePromoteManager.2(this, paramString, paramIGetAppDetailCallback), 128, null, true);
  }
  
  public boolean a(Context paramContext, String paramString, QFileAppStorePromoteManager.IAppStoreRemindCallback paramIAppStoreRemindCallback)
  {
    if (e().a())
    {
      String str1 = paramContext.getString(2131896217);
      paramString = String.format(paramContext.getString(2131896214), new Object[] { paramString });
      String str2 = paramContext.getString(2131896215);
      String str3 = paramContext.getString(2131896216);
      QFileAppStorePromoteManager.3 local3 = new QFileAppStorePromoteManager.3(this, paramIAppStoreRemindCallback);
      paramIAppStoreRemindCallback = new QFileAppStorePromoteManager.4(this, paramIAppStoreRemindCallback);
      DialogUtil.a(paramContext, 0, str1, paramString, str2, str3, paramContext.getString(2131887648), local3, paramIAppStoreRemindCallback).show();
      ReportController.b(null, "dc00898", "", "", "0X800AE3F", "0X800AE3F", 0, 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  public void b(Context paramContext, String paramString)
  {
    if (d().isExistedDownloadOfUrl("https://a.app.qq.com/o/myapp-down?g_f=1116518"))
    {
      QQToast.makeText(paramContext, 0, 2131896213, 0).show();
      return;
    }
    String str = paramContext.getString(2131896212);
    DialogUtil.a((Activity)paramContext, str, 2131887648, 2131892267, new QFileAppStorePromoteManager.5(this, paramContext, paramString), new QFileAppStorePromoteManager.6(this)).show();
  }
  
  public boolean b()
  {
    a();
    int i = TMAssistantCallYYB_V2.getInstance().checkQQDownloaderInstalled();
    if ((i != 2) && (i != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    int j;
    if (i != 0) {
      j = GlobalUtil.getInstance().getQQDownloaderVersionCode();
    } else {
      j = 0;
    }
    return (i != 0) && (j > 7342130);
  }
  
  protected IUniformDownloadMgr d()
  {
    return (IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "");
  }
  
  IQFileAppStorePromoteDialogConfigBean e()
  {
    return ((IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class)).getYYBPromoteDialogConfig();
  }
  
  IQFileAppStorePromoteConfigBean f()
  {
    return ((IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class)).getYYBPromoteConfig();
  }
  
  public boolean g()
  {
    return f().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager
 * JD-Core Version:    0.7.0.1
 */