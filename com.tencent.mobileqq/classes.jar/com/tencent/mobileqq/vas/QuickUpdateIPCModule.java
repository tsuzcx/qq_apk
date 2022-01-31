package com.tencent.mobileqq.vas;

import android.os.Bundle;
import bans;
import bant;
import bdtn;
import bdtp;
import bdtq;
import bdtr;
import bdwi;
import bdws;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
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
  
  public static void a(int paramInt, String paramString, boolean paramBoolean, bdtn parambdtn)
  {
    QuickUpdateIPCModule.Params localParams = new QuickUpdateIPCModule.Params(null);
    localParams.intVal = paramInt;
    localParams.boolVal = paramBoolean;
    localParams.strVal1 = paramString;
    paramString = new Bundle();
    paramString.putSerializable("params", localParams);
    QIPCClientHelper.getInstance().callServer("QuickUpdateIPCModule", b, paramString, new bdtq(parambdtn));
  }
  
  public static void a(long paramLong, String paramString, bans parambans)
  {
    Bundle localBundle = new Bundle();
    if (parambans != null) {
      localBundle.putParcelable("binder", new BinderWarpper(parambans.asBinder()));
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
        paramString = new bdtr(l, (String)localObject, bant.asInterface(((BinderWarpper)paramBundle.getParcelable("binder")).a), null);
      }
      QLog.e("QuickUpdateIPCModule", 1, "download listener: " + paramString);
      bdws.a(l).download(null, l, (String)localObject, paramString, false);
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
          ((VasQuickUpdateManager)((QQAppInterface)((BaseApplicationImpl)localObject).getRuntime()).getManager(184)).queryItemVersion(paramString.intVal, paramString.strVal1, paramString.boolVal, false, 10000L, new bdtp(this, paramInt));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.QuickUpdateIPCModule
 * JD-Core Version:    0.7.0.1
 */