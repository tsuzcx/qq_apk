package com.tencent.mobileqq.vas.ipc;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.manager.IlivePreDownloadManager;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import uuc;

public class VasLiveIPCModule
  extends QIPCModule
{
  public static final String ACTION_CANCEL_PRE_DOWNLOAD = "action_cancel_pre_load";
  public static final String ACTION_FOLLOW_ACCOUNT = "followAccount";
  public static final String ACTION_GET_ACCOUNT_NICK_NAME = "action_get_nick_name";
  public static final String KEY_ANCHOR_UIN = "anchorUin";
  public static final String KEY_FOLLOW_TYPE = "followType";
  public static final String KEY_GET_ACCOUNT_NICK_NAME = "accountName";
  public static final String NAME = "VasLiveIPCModule";
  private static final String TAG = "VasLiveIPCModule";
  private static VasLiveIPCModule sInstance;
  
  private VasLiveIPCModule(String paramString)
  {
    super(paramString);
  }
  
  private long getAccount()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
  }
  
  private String getAccountName()
  {
    long l = getAccount();
    try
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = ContactUtils.getAccountNickName((QQAppInterface)localObject, ((QQAppInterface)localObject).getCurrentAccountUin());
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return String.valueOf(l);
  }
  
  public static VasLiveIPCModule getInstance()
  {
    try
    {
      if (sInstance == null)
      {
        sInstance = new VasLiveIPCModule("VasLiveIPCModule");
        QIPCClientHelper.getInstance().register(sInstance);
      }
      VasLiveIPCModule localVasLiveIPCModule = sInstance;
      return localVasLiveIPCModule;
    }
    finally {}
  }
  
  private void handleFollowAccountAction(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    String str;
    try
    {
      str = paramBundle.getString("anchorUin");
      int i = paramBundle.getInt("followType");
      paramBundle = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (i == 1)
      {
        uuc.a(paramBundle, BaseApplicationImpl.getContext(), str, new VasLiveIPCModule.1(this, paramInt), false, 0, true);
        return;
      }
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
      QLog.e("VasLiveIPCModule", 1, "handleFollowAccountAction exception = " + paramBundle.getMessage());
      return;
    }
    uuc.a(paramBundle, BaseApplicationImpl.getContext(), str, false, new VasLiveIPCModule.2(this, paramInt), true);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasLiveIPCModule", 2, "action:" + paramString);
    }
    if ("action_get_nick_name".equals(paramString))
    {
      paramString = new Bundle();
      paramString.putString("accountName", getAccountName());
      callbackResult(paramInt, EIPCResult.createResult(0, paramString));
      return null;
    }
    if ("action_cancel_pre_load".equals(paramString))
    {
      IlivePreDownloadManager.getInstance().cancelPreloadDownload();
      return null;
    }
    if ("followAccount".equals(paramString))
    {
      handleFollowAccountAction(paramInt, paramBundle);
      return null;
    }
    new EIPCResult().data = paramBundle;
    return RemoteProxy.onCall(this, paramString, paramBundle, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.VasLiveIPCModule
 * JD-Core Version:    0.7.0.1
 */