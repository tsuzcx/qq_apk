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
  private static long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QFileAppStorePromoteManager.FetchAppInfoCallback jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileAppStorePromoteManager$FetchAppInfoCallback;
  private HashMap<Integer, QFileAppStorePromoteManager.IGetAppDetailCallback> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean = false;
  
  public QFileAppStorePromoteManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileAppStorePromoteManager$FetchAppInfoCallback = new QFileAppStorePromoteManager.FetchAppInfoCallback(this);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private static String a(String paramString, int paramInt)
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
  
  public static void a(String paramString, int paramInt)
  {
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 1000L)
    {
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, "startAppStoreByTmast: start app store limit.");
      return;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
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
    paramString = a(paramString, paramInt);
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
  
  public static void b()
  {
    ReportController.b(null, "dc00898", "", "", "0X800B00D", "0X800B00D", 0, 0, "", "", "", "");
  }
  
  IQFileAppStorePromoteConfigBean a()
  {
    return ((IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class)).getYYBPromoteConfig();
  }
  
  IQFileAppStorePromoteDialogConfigBean a()
  {
    return ((IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class)).getYYBPromoteDialogConfig();
  }
  
  protected IUniformDownloadMgr a()
  {
    return (IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "");
  }
  
  public String a(Context paramContext)
  {
    String str2 = a().a();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramContext.getString(2131698310);
    }
    return str1;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ThreadManagerV2.executeOnSubThread(new QFileAppStorePromoteManager.1(this));
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("params_open_with_yyb", paramString);
    ((Bundle)localObject).putString("big_brother_source_key", "biz_src_jc_file");
    if (a().getApp() == null)
    {
      paramString = new Bundle();
      paramString.putString("_filename_from_dlg", paramContext.getString(2131694578));
      paramString.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
      paramString.putBundle("_user_data", (Bundle)localObject);
      localObject = new Intent("com.tencent.mobileqq.qfile_unifromdownload");
      ((Intent)localObject).putExtra("param", paramString);
      ((Intent)localObject).putExtra("url", "https://a.app.qq.com/o/myapp-down?g_f=1116518");
      paramContext.sendBroadcast((Intent)localObject);
      return;
    }
    paramString = new Bundle();
    paramString.putString("_filename_from_dlg", paramContext.getString(2131694578));
    paramString.putString("big_brother_source_key", "biz_src_jc_file");
    paramString.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
    paramString.putBundle("_user_data", (Bundle)localObject);
    a().startDownloadNoSzie("https://a.app.qq.com/o/myapp-down?g_f=1116518", paramString);
  }
  
  public void a(String paramString, QFileAppStorePromoteManager.IGetAppDetailCallback paramIGetAppDetailCallback)
  {
    a();
    ThreadManagerV2.excute(new QFileAppStorePromoteManager.2(this, paramString, paramIGetAppDetailCallback), 128, null, true);
  }
  
  public boolean a()
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
  
  public boolean a(Context paramContext, String paramString, QFileAppStorePromoteManager.IAppStoreRemindCallback paramIAppStoreRemindCallback)
  {
    if (a().a())
    {
      String str1 = paramContext.getString(2131698316);
      paramString = String.format(paramContext.getString(2131698313), new Object[] { paramString });
      String str2 = paramContext.getString(2131698314);
      String str3 = paramContext.getString(2131698315);
      QFileAppStorePromoteManager.3 local3 = new QFileAppStorePromoteManager.3(this, paramIAppStoreRemindCallback);
      paramIAppStoreRemindCallback = new QFileAppStorePromoteManager.4(this, paramIAppStoreRemindCallback);
      DialogUtil.a(paramContext, 0, str1, paramString, str2, str3, paramContext.getString(2131690728), local3, paramIAppStoreRemindCallback).show();
      ReportController.b(null, "dc00898", "", "", "0X800AE3F", "0X800AE3F", 0, 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  public void b(Context paramContext, String paramString)
  {
    if (a().isExistedDownloadOfUrl("https://a.app.qq.com/o/myapp-down?g_f=1116518"))
    {
      QQToast.a(paramContext, 0, 2131698312, 0).a();
      return;
    }
    String str = paramContext.getString(2131698311);
    DialogUtil.a((Activity)paramContext, str, 2131690728, 2131694583, new QFileAppStorePromoteManager.5(this, paramContext, paramString), new QFileAppStorePromoteManager.6(this)).show();
  }
  
  public boolean b()
  {
    return a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager
 * JD-Core Version:    0.7.0.1
 */