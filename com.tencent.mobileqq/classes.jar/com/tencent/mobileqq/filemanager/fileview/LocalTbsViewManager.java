package com.tencent.mobileqq.filemanager.fileview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.reader.ReaderEngine;
import com.tencent.tbs.reader.TbsReaderView;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class LocalTbsViewManager
{
  private static LocalTbsViewManager jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager;
  private int jdField_a_of_type_Int = -1;
  private TbsReaderView jdField_a_of_type_ComTencentTbsReaderTbsReaderView = null;
  private final HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private TbsReaderView jdField_b_of_type_ComTencentTbsReaderTbsReaderView = null;
  private boolean jdField_b_of_type_Boolean = false;
  
  public static LocalTbsViewManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager == null) {
      jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager = new LocalTbsViewManager();
    }
    return jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager;
  }
  
  private void a()
  {
    LocalTbsViewManager.3 local3 = new LocalTbsViewManager.3(this);
    ThreadManagerV2.getUIHandlerV2().post(new LocalTbsViewManager.4(this, local3));
  }
  
  private void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putAll(paramBundle);
    ((Bundle)localObject).putString("big_brother_source_key", "biz_src_jc_file");
    paramBundle = new Bundle();
    paramBundle.putString("_filename_from_dlg", paramContext.getString(2131694576));
    paramBundle.putString("big_brother_source_key", "biz_src_jc_file");
    paramBundle.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
    paramBundle.putBundle("_user_data", (Bundle)localObject);
    localObject = (IUniformDownloadMgr)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IUniformDownloadMgr.class, "all");
    if (((IUniformDownloadMgr)localObject).getApp() == null)
    {
      localObject = new Intent("com.tencent.mobileqq.qfile_unifromdownload");
      ((Intent)localObject).putExtra("param", paramBundle);
      ((Intent)localObject).putExtra("url", paramString);
      paramContext.sendBroadcast((Intent)localObject);
      QLog.i("LocalTbsViewManager<FileAssistant>", 1, "app is null try sendBroadcast!");
      return;
    }
    ((IUniformDownloadMgr)localObject).startDownloadNoSzie(paramString, paramBundle);
    paramContext = new StringBuilder();
    paramContext.append("downloadQQBrowser:");
    paramContext.append(paramString);
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, paramContext.toString());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B00B", "0X800B00B", 0, 0, "", "", "", "");
      return;
    }
    int i;
    if (paramBoolean2) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B00C", "0X800B00C", i, 0, "", "", "", "");
  }
  
  public Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", paramString);
    paramString = FMSettings.a().getDefaultRecvPath();
    Object localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTbsFileReaderOpenParams: barSwitch[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append("]");
      QLog.i("LocalTbsViewManager<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    localBundle.putString("tempPath", paramString);
    localBundle.putBoolean("file_reader_tool_bar_hide", this.jdField_a_of_type_Boolean ^ true);
    localBundle.putInt("file_reader_download_type", 1);
    localBundle.putString("reader_tokenid", "Y29tLnRlbmNlbnQubW9iaWxlcXE=");
    localBundle.putString("reader_pkgname", "com.tencent.mobileqq");
    localBundle.putBoolean("file_reader_click_action_disable", true);
    localBundle.putInt("style", 2);
    localBundle.putInt("file_reader_bg_content_color", -1);
    localBundle.putBoolean("file_reader_add_view_to_toolbar", this.jdField_b_of_type_Boolean);
    localBundle.putString("big_brother_source_key", "biz_src_jc_file");
    return localBundle;
  }
  
  public TbsReaderView a(Activity paramActivity, String paramString, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback)
  {
    if ((this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView != null) && (paramActivity.hashCode() == this.jdField_a_of_type_Int)) {
      return this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
    }
    if (!FileUtil.a(paramString)) {
      return null;
    }
    Object localObject = this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView;
    if (localObject != null)
    {
      ((TbsReaderView)localObject).onStop();
      this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView = null;
    }
    localObject = this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
    if (localObject != null)
    {
      ((TbsReaderView)localObject).onStop();
      this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView = null;
    }
    QLog.w("LocalTbsViewManager<FileAssistant>", 4, "initVarView: new TbsReaderView");
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView = new TbsReaderView(paramActivity, new LocalTbsViewManager.TbsFileReaderEventCallback(this, paramLocalTbsViewManagerCallback, paramActivity, paramString));
    QLog.w("LocalTbsViewManager<FileAssistant>", 4, "initVarView: TbsReaderView openFile");
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.setBackgroundColor(-1);
    localObject = FileUtil.a(paramString);
    paramLocalTbsViewManagerCallback = (LocalTbsViewManager.LocalTbsViewManagerCallback)localObject;
    if (((String)localObject).startsWith(".")) {
      paramLocalTbsViewManagerCallback = ((String)localObject).replaceFirst(".", "");
    }
    localObject = this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
    boolean bool = false;
    if (((TbsReaderView)localObject).preOpen(paramLocalTbsViewManagerCallback, false))
    {
      paramString = a(paramString);
      if (this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.openFile(paramString) == 0) {
        bool = true;
      }
      a(true, bool);
      this.jdField_a_of_type_Int = paramActivity.hashCode();
      return this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
    }
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.onStop();
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView = null;
    return null;
  }
  
  public void a(int paramInt, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback)
  {
    ThreadManagerV2.getUIHandlerV2().post(new LocalTbsViewManager.6(this, paramInt, paramLocalTbsViewManagerCallback));
  }
  
  public void a(Activity paramActivity)
  {
    int i = paramActivity.hashCode();
    if (QLog.isDevelopLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("LocalTbsViewManager destroy hashCode[");
      paramActivity.append(this.jdField_a_of_type_Int);
      paramActivity.append("],activity[");
      paramActivity.append(i);
      paramActivity.append("]");
      QLog.d("LocalTbsViewManager<FileAssistant>", 4, paramActivity.toString());
    }
    if (this.jdField_a_of_type_Int != i) {
      return;
    }
    paramActivity = this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView;
    if (paramActivity != null)
    {
      paramActivity.onStop();
      this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView = null;
    }
    paramActivity = this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
    if (paramActivity != null)
    {
      paramActivity.onStop();
      this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView = null;
    }
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800AF73", "0X800AF73", 0, 0, "", "", "", "");
    paramBundle = (Intent)paramBundle.getParcelable("file_open_intent");
    if (paramBundle != null)
    {
      paramBundle.putExtra("big_brother_source_key", "biz_src_jc_file");
      paramContext.startActivity(paramBundle);
    }
  }
  
  public void a(Context paramContext, Bundle paramBundle, String paramString)
  {
    if (paramBundle == null)
    {
      QLog.e("LocalTbsViewManager<FileAssistant>", 1, "downloadQQBrowser params null!");
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("stat_download_start", paramBundle.getString("stat_download_start", ""));
    this.jdField_a_of_type_JavaUtilHashMap.put("stat_download_downloading", paramBundle.getString("stat_download_downloading", ""));
    this.jdField_a_of_type_JavaUtilHashMap.put("stat_download_success", paramBundle.getString("stat_download_success", ""));
    this.jdField_a_of_type_JavaUtilHashMap.put("stat_download_failed", paramBundle.getString("stat_download_failed", ""));
    this.jdField_a_of_type_JavaUtilHashMap.put("stat_download_installed_success", paramBundle.getString("stat_download_installed_success", ""));
    this.jdField_a_of_type_JavaUtilHashMap.put("stat_open_qb_success", paramBundle.getString("stat_open_qb_success", ""));
    paramBundle = paramBundle.getString("download_url", "");
    if (((IUniformDownloadMgr)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IUniformDownloadMgr.class, "")).isExistedDownloadOfUrl(paramBundle))
    {
      QLog.w("LocalTbsViewManager<FileAssistant>", 1, "downloadQQBrowser isExistedDownloadOfUrl show toast!");
      QQToast.a(paramContext, 0, 2131698305, 0).a();
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("_open_with_qq_browser_", paramString);
    localBundle.putBoolean("tbs_new_report", true);
    a(paramContext, paramBundle, localBundle);
    a("stat_download_start");
  }
  
  public void a(Context paramContext, Object paramObject1, Object paramObject2, String paramString, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback)
  {
    if (paramObject1 != null)
    {
      if (!(paramObject1 instanceof Bundle)) {
        return;
      }
      paramObject1 = (Bundle)paramObject1;
      int i = paramObject1.getInt("typeId", -1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleTbsReaderEvent: actionType[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.i("LocalTbsViewManager<FileAssistant>", 1, localStringBuilder.toString());
      switch (i)
      {
      default: 
      case 7: 
        a(paramObject2, paramLocalTbsViewManagerCallback);
        return;
      case 6: 
        a(paramContext, paramObject1);
        return;
      case 5: 
        ReportController.b(null, "dc00898", "", "", "0X800AF75", "0X800AF75", 0, 0, "", "", "", "");
        a(paramContext, paramObject1, paramString);
        return;
      case 4: 
        ReportController.b(null, "dc00898", "", "", "0X800AF74", "0X800AF74", 0, 0, "", "", "", "");
        return;
      case 2: 
        ReportController.b(null, "dc00898", "", "", "0X800AF72", "0X800AF72", 1, 0, "", "", "", "");
        return;
      case 1: 
        ReportController.b(null, "dc00898", "", "", "0X800AF71", "0X800AF71", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(Object paramObject, Activity paramActivity, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback)
  {
    if (paramObject == null) {
      return;
    }
    int i = ((Bundle)paramObject).getInt("function_id");
    paramLocalTbsViewManagerCallback.a(TbsReaderView.getResString(paramActivity, i), TbsReaderView.getResDrawable(paramActivity, i + 1), TbsReaderView.getResDrawable(paramActivity, i + 2), new LocalTbsViewManager.5(this, i, paramActivity));
  }
  
  public void a(Object paramObject, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback)
  {
    paramLocalTbsViewManagerCallback = paramLocalTbsViewManagerCallback.a();
    if (((paramObject instanceof ViewGroup)) && ((paramLocalTbsViewManagerCallback instanceof View))) {
      ((ViewGroup)paramObject).addView(paramLocalTbsViewManagerCallback);
    }
  }
  
  public void a(Object paramObject, String paramString)
  {
    if (!(paramObject instanceof Integer)) {
      return;
    }
    if (((Integer)paramObject).intValue() != 0) {
      return;
    }
    paramObject = a(paramString);
    boolean bool;
    if (this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.openFile(paramObject) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    a(true, bool);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportQQBrowserDownloadEvent: reportType[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, localStringBuilder.toString());
    if ((this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView != null) && (!TextUtils.isEmpty(str))) {
      this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.userStatistics(str);
    }
    if (paramString.equals("stat_download_success"))
    {
      ReportController.b(null, "dc00898", "", "", "0X800AF76", "0X800AF76", 0, 0, "", "", "", "");
      return;
    }
    if (paramString.equals("stat_open_qb_success")) {
      ReportController.b(null, "dc00898", "", "", "0X800AF73", "0X800AF73", 0, 0, "", "", "", "");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return ReaderEngine.getInstance().getVersionCode() >= 5060010;
  }
  
  public boolean a(Activity paramActivity, String paramString, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback, boolean paramBoolean)
  {
    if (!a(true)) {
      return false;
    }
    if (this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "canOpenFile return 2-------");
      }
      this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView.onStop();
      this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView = null;
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (paramLocalTbsViewManagerCallback != null) {
        paramLocalTbsViewManagerCallback.b(false);
      }
      return false;
    }
    TbsReaderView localTbsReaderView = new TbsReaderView(paramActivity, new LocalTbsViewManager.1(this, paramLocalTbsViewManagerCallback));
    paramString = FileUtil.a(paramString);
    paramActivity = paramString;
    if (paramString.startsWith(".")) {
      paramActivity = paramString.replaceFirst(".", "");
    }
    if (!localTbsReaderView.preOpen(paramActivity, paramBoolean ^ true))
    {
      localTbsReaderView.onStop();
      if (paramLocalTbsViewManagerCallback != null) {
        paramLocalTbsViewManagerCallback.b(false);
      }
      if (QLog.isColorLevel()) {
        QLog.i("LocalTbsViewManager<FileAssistant>", 1, "pre open file false!");
      }
      return false;
    }
    if ((paramBoolean) && (paramLocalTbsViewManagerCallback != null)) {
      paramLocalTbsViewManagerCallback.b(true);
    }
    if (QLog.isColorLevel()) {
      QLog.i("LocalTbsViewManager<FileAssistant>", 1, "pre open file true! wait callback!");
    }
    this.jdField_b_of_type_ComTencentTbsReaderTbsReaderView = localTbsReaderView;
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tbs reader engine init. isForeground[");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("]");
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = new LocalTbsViewManager.2(this);
    paramBoolean = ReaderEngine.getInstance().fileEnginePreLoad(BaseApplication.getContext(), (TBSOneCallback)localObject, paramBoolean);
    if (paramBoolean)
    {
      QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs reader engine had downloaded.");
      a();
      return paramBoolean;
    }
    QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs reader engine not download.");
    ReportController.b(null, "dc00898", "", "", "0X800B009", "0X800B009", 0, 0, "", "", "", "");
    return paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager
 * JD-Core Version:    0.7.0.1
 */