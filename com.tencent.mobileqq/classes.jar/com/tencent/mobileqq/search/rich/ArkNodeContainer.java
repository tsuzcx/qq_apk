package com.tencent.mobileqq.search.rich;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase.AppInfo;
import com.tencent.ark.ArkViewModelBase.ErrorInfo;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppInfo.TimeRecord;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.component.ArkMediaPlayer;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class ArkNodeContainer
  extends ArkViewModel
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  public ArkAppInfo.TimeRecord a;
  private ArkNodeConfig a;
  
  public ArkNodeContainer(ArkAppCallBackHandler paramArkAppCallBackHandler)
  {
    super(paramArkAppCallBackHandler, ArkAiAppCenter.b ^ true);
    this.jdField_a_of_type_ComTencentArkOpenArkAppInfo$TimeRecord = new ArkAppInfo.TimeRecord(this.mTimeRecord);
    ArkMultiProcUtil.a();
  }
  
  private void b(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public void a()
  {
    destroy();
    this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig = null;
  }
  
  public void a(String paramString)
  {
    try
    {
      new JSONObject(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ArkNodeContainer", 2, String.format("CheckMetaLegality,appMeta is parse error and msg=%s", new Object[] { paramString.getMessage() }));
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadArkApp, apppath:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" retcode:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" msg:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("ArkNodeContainer", 2, String.format(((StringBuilder)localObject).toString(), new Object[0]));
    }
    boolean bool1;
    if (paramInt != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (paramInt == -2) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    String str1 = ArkEnvironmentManager.getInstance().getCacheDirectory();
    String str2 = ArkEnvironmentManager.getInstance().getStorageDirectory();
    String str3 = ArkEnvironmentManager.getInstance().getAppResPath(this.mAppInfo.name);
    b(str1);
    b(str2);
    b(str3);
    Object localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    doLoadArkApp(paramString1, str1, str2, str3, bool1, bool2, paramInt, (String)localObject);
  }
  
  public boolean a(ArkNodeConfig paramArkNodeConfig, String paramString, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig = paramArkNodeConfig;
    if (this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig == null) {
      return false;
    }
    if (!TextUtils.isEmpty(paramString)) {
      a(paramString);
    }
    return super.init(this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig.b(), this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig.d(), this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig.c(), paramString, ArkAppCenterUtil.a(), paramFloat);
  }
  
  protected void initLibrary()
  {
    ark.MediaSetStub(ArkMediaPlayer.a);
  }
  
  protected void onFirstDrawEnd()
  {
    super.onFirstDrawEnd();
  }
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo)
  {
    if (paramAppPathInfo != null) {
      paramAppPathInfo = paramAppPathInfo.path;
    } else {
      paramAppPathInfo = null;
    }
    ArkAppInfo.TimeRecord localTimeRecord = this.jdField_a_of_type_ComTencentArkOpenArkAppInfo$TimeRecord;
    localTimeRecord.getAppFromLocal = false;
    localTimeRecord.endOfGetApp = System.currentTimeMillis();
    a(paramAppPathInfo, paramInt, paramString);
  }
  
  public boolean onLoadApp(ArkViewModelBase.AppInfo paramAppInfo)
  {
    if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null)
    {
      this.mInit = false;
      this.mLoadFailed = true;
      paramAppInfo = this.mViewImpl;
      if (paramAppInfo != null) {
        paramAppInfo.onLoadFailed(null, this.mErrorInfo.retCode, true);
      }
      return true;
    }
    this.jdField_a_of_type_ComTencentArkOpenArkAppInfo$TimeRecord.beginOfGetApp = System.currentTimeMillis();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig.a();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ArkAppMgr.getInstance().getAppPathFromCache(this.mAppInfo.name, this.mAppInfo.appMinVersion);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArkNodeContainer", 2, String.format("onLoadApp,mAppInfo.name=%s,appPath=%s", new Object[] { this.mAppInfo.name, localObject1 }));
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      ArkDispatchTask.getInstance().post(this.mAppInfo.name, new ArkNodeContainer.1(this, (String)localObject1));
      return true;
    }
    localObject2 = this.mViewImpl;
    if (localObject2 != null) {
      ((ArkViewImplement)localObject2).onLoading();
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArkNodeContainer", 2, String.format("onLoadApp,mAppInfo.name=%s,appPath=%s,viewImplement=%h", new Object[] { this.mAppInfo.name, localObject1, localObject2 }));
    }
    ArkAppMgr.getInstance().getAppPathByName(paramAppInfo.name, paramAppInfo.appMinVersion, new ArkNodeContainer.AppPathCallback(this));
    return false;
  }
  
  protected void onRunAppFailed()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ArkNodeContainer", 2, String.format("onRunAppFailed", new Object[0]));
    }
    Object localObject = this.mViewImpl;
    if (localObject != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig != null)
      {
        localObject = ((ArkViewImplement)localObject).getView().getContext().getString(2131718619);
        this.mErrorInfo.msg = String.format((String)localObject, new Object[] { this.jdField_a_of_type_ComTencentMobileqqSearchRichArkNodeConfig.b() });
      }
      else
      {
        this.mErrorInfo.msg = "";
      }
      this.mErrorInfo.canRetry = false;
    }
    super.onRunAppFailed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.ArkNodeContainer
 * JD-Core Version:    0.7.0.1
 */