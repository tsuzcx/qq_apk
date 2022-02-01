package com.tencent.mobileqq.vas;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.theme.IDownloadListener;
import com.tencent.mobileqq.theme.IDownloadListener.Stub;
import com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import eipc.EIPCResult;

public class QuickUpdateIPCModule
  extends QIPCModule
{
  private static QuickUpdateIPCModule jdField_a_of_type_ComTencentMobileqqVasQuickUpdateIPCModule;
  private static String jdField_a_of_type_JavaLangString = "download";
  private static String b = "query_version";
  
  public QuickUpdateIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static QuickUpdateIPCModule a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqVasQuickUpdateIPCModule == null) {
        jdField_a_of_type_ComTencentMobileqqVasQuickUpdateIPCModule = new QuickUpdateIPCModule("QuickUpdateIPCModule");
      }
      QuickUpdateIPCModule localQuickUpdateIPCModule = jdField_a_of_type_ComTencentMobileqqVasQuickUpdateIPCModule;
      return localQuickUpdateIPCModule;
    }
    finally {}
  }
  
  public static void a(int paramInt, String paramString, boolean paramBoolean, QueryItemCallback paramQueryItemCallback)
  {
    QuickUpdateIPCModule.Params localParams = new QuickUpdateIPCModule.Params(null);
    localParams.intVal = paramInt;
    localParams.boolVal = paramBoolean;
    localParams.strVal1 = paramString;
    paramString = new Bundle();
    paramString.putSerializable("params", localParams);
    QIPCClientHelper.getInstance().callServer("QuickUpdateIPCModule", b, paramString, new QuickUpdateIPCModule.2(paramQueryItemCallback));
  }
  
  public static void a(long paramLong, String paramString, IDownloadListener paramIDownloadListener)
  {
    Bundle localBundle = new Bundle();
    if (paramIDownloadListener != null) {
      localBundle.putParcelable("binder", new BinderWarpper(paramIDownloadListener.asBinder()));
    }
    localBundle.putLong("bid", paramLong);
    localBundle.putString("scid", paramString);
    QIPCClientHelper.getInstance().callServer("QuickUpdateIPCModule", jdField_a_of_type_JavaLangString, localBundle, null);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramBundle.setClassLoader(BinderWarpper.class.getClassLoader());
    Object localObject;
    if (jdField_a_of_type_JavaLangString.equals(paramString))
    {
      long l = paramBundle.getLong("bid");
      localObject = paramBundle.getString("scid");
      paramString = null;
      if (paramBundle.containsKey("binder")) {
        paramString = new QuickUpdateIPCModule.RemoteListener(l, (String)localObject, IDownloadListener.Stub.asInterface(((BinderWarpper)paramBundle.getParcelable("binder")).a), null);
      }
      QLog.e("QuickUpdateIPCModule", 1, "download listener: " + paramString);
      UpdateCallbackSelector.getCallback(l).download(l, (String)localObject, paramString, false);
    }
    for (;;)
    {
      return null;
      if (b.equals(paramString))
      {
        paramString = (QuickUpdateIPCModule.Params)paramBundle.getSerializable("params");
        localObject = BaseApplicationImpl.getApplication();
        if (localObject == null)
        {
          QLog.e("QuickUpdateIPCModule", 1, "onCall fail null application");
          callbackResult(paramInt, EIPCResult.createResult(-102, paramBundle));
        }
        else
        {
          ((IVasQuickUpdateService)((QQAppInterface)((BaseApplicationImpl)localObject).getRuntime()).getRuntimeService(IVasQuickUpdateService.class, "")).queryItemVersion(paramString.intVal, paramString.strVal1, paramString.boolVal, false, 10000L, new QuickUpdateIPCModule.1(this, paramInt));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.QuickUpdateIPCModule
 * JD-Core Version:    0.7.0.1
 */