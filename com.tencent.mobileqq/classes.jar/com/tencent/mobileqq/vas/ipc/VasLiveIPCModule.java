package com.tencent.mobileqq.vas.ipc;

import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vastrash.uec.UECPageStayController;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.host.IliveEnterGroupHost;
import cooperation.ilive.manager.IlivePreDownloadManager;
import eipc.EIPCResult;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class VasLiveIPCModule
  extends QIPCModule
{
  public static final String ACTION_CANCEL_PRE_DOWNLOAD = "action_cancel_pre_load";
  public static final String ACTION_CLOSE_DRAWER = "action_close_drawer";
  public static final String ACTION_ENTER_GROUP = "enterGroup";
  public static final String ACTION_FOLLOW_ACCOUNT = "followAccount";
  public static final String ACTION_GET_ACCOUNT_NICK_NAME = "action_get_nick_name";
  public static final String ACTION_REPORT_STAY_TIME = "action_report_stay_time";
  public static final String KEY_ANCHOR_UIN = "anchorUin";
  public static final String KEY_FOLLOW_TYPE = "followType";
  public static final String KEY_GET_ACCOUNT_NICK_NAME = "accountName";
  public static final String KEY_GROUP_UIN = "groupUin";
  public static final String KEY_STAY_INFO = "stayInfo";
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
      localObject = ContactUtils.e((AppInterface)localObject, ((QQAppInterface)localObject).getCurrentAccountUin());
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
  
  private void handleCloseDrawerAction(int paramInt, Bundle paramBundle)
  {
    ThreadManager.getUIHandler().post(new VasLiveIPCModule.1(this));
    callbackResult(paramInt, EIPCResult.createResult(0, null));
  }
  
  private void handleEnterGroupAction(int paramInt, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("groupUin");
    TroopManager localTroopManager = (TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_MANAGER);
    boolean bool;
    if ((localTroopManager != null) && (localTroopManager.b(paramBundle) != null)) {
      bool = true;
    } else {
      bool = false;
    }
    IliveEnterGroupHost.joinGroup(bool, paramBundle, "");
    callbackResult(paramInt, EIPCResult.createResult(0, null));
  }
  
  private void handleFollowAccountAction(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    try
    {
      localObject = paramBundle.getString("anchorUin");
      int i = paramBundle.getInt("followType");
      paramBundle = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (i == 1)
      {
        localIPublicAccountObserver = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
        localIPublicAccountObserver.setOnCallback(new VasLiveIPCModule.2(this, paramInt));
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).followUin(paramBundle, BaseApplicationImpl.getContext(), (String)localObject, localIPublicAccountObserver, false, 0, true);
        return;
      }
      IPublicAccountObserver localIPublicAccountObserver = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
      localIPublicAccountObserver.setOnCallback(new VasLiveIPCModule.3(this, paramInt));
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).unfollowUin(paramBundle, BaseApplicationImpl.getContext(), (String)localObject, false, localIPublicAccountObserver, true);
      return;
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleFollowAccountAction exception = ");
      ((StringBuilder)localObject).append(paramBundle.getMessage());
      QLog.e("VasLiveIPCModule", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void handleStayTimeInfo(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle = (ArrayList)paramBundle.getSerializable("stayInfo");
    UECPageStayController.a().a(paramBundle);
    callbackResult(paramInt, EIPCResult.createResult(0, null));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action:");
      localStringBuilder.append(paramString);
      QLog.i("VasLiveIPCModule", 2, localStringBuilder.toString());
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
    if ("enterGroup".equals(paramString))
    {
      handleEnterGroupAction(paramInt, paramBundle);
      return null;
    }
    if ("action_close_drawer".equals(paramString))
    {
      handleCloseDrawerAction(paramInt, paramBundle);
      return null;
    }
    if ("action_report_stay_time".equals(paramString))
    {
      handleStayTimeInfo(paramInt, paramBundle);
      return null;
    }
    new EIPCResult().data = paramBundle;
    return RemoteProxy.onCall(this, paramString, paramBundle, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.VasLiveIPCModule
 * JD-Core Version:    0.7.0.1
 */