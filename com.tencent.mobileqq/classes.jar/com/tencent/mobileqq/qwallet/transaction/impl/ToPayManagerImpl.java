package com.tencent.mobileqq.qwallet.transaction.impl;

import Wallet.PfaFriend;
import Wallet.PfaFriendRqt;
import Wallet.PfaFriendRsp;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.biz.eqq.api.ICrmApi;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.transaction.IToPayManager;
import com.tencent.mobileqq.qwallet.transaction.IToPayManager.TopayListener;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class ToPayManagerImpl
  implements IToPayManager
{
  private static final String TAG = "TopayManager";
  public static WeakReference<IToPayManager.TopayListener> gWeakListener;
  protected static WeakReference<QWalletPayProgressDialog> gWeakProgress;
  protected static int mBusinessSubType = 0;
  protected static int mBusinessType = 0;
  public static PfaFriendRsp mData;
  protected static Handler mHandler = new ToPayManagerImpl.3(Looper.getMainLooper());
  public static int mLoadedFromFileState = -1;
  protected static BusinessObserver mRecentListObserver = null;
  
  public static ArrayList<PfaFriend> getRecentList()
  {
    Object localObject1 = QWalletTools.a();
    if (localObject1 == null) {
      return null;
    }
    localObject1 = ((IRecentUserProxyService)((BaseQQAppInterface)localObject1).getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((RecentUserProxy)localObject1).a(true);
    if (localObject2 == null) {
      return null;
    }
    localObject1 = new ArrayList();
    ICrmApi localICrmApi = (ICrmApi)QWalletHelperImpl.getAppRuntime().getRuntimeService(ICrmApi.class, "");
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.getType() != 1020) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && (localRecentUser.getType() != 1006) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 1001) && (localRecentUser.getType() != 10002) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1022) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 1) && ((localRecentUser.getType() != 0) || (!localICrmApi.isQiye(localRecentUser.uin, localRecentUser.getType()))) && (localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000))
      {
        PfaFriend localPfaFriend = new PfaFriend();
        localPfaFriend.uin = localRecentUser.uin;
        ((ArrayList)localObject1).add(localPfaFriend);
      }
    }
    return localObject1;
  }
  
  private static void gotoAio(Activity paramActivity, List<String> paramList1, List<String> paramList2)
  {
    if (paramList1.size() == 1)
    {
      Intent localIntent = BaseAIOUtils.a(new Intent(), null);
      localIntent.putExtra("uin", (String)paramList1.get(0));
      localIntent.putExtra("uintype", 0);
      localIntent.putExtra("uinname", (String)paramList2.get(0));
      localIntent.setFlags(335544320);
      RouteUtils.a(paramActivity, localIntent, "/base/start/splash");
    }
    else if (paramList1.size() > 1)
    {
      paramList1 = new Intent();
      paramList1.putExtra("tab_index", FrameControllerUtil.a);
      paramList1.setFlags(67108864);
      RouteUtils.a(paramActivity, paramList1, "/base/start/splash");
    }
    paramActivity.setResult(-1);
    paramActivity.finish();
  }
  
  protected static void notifyUi(boolean paramBoolean)
  {
    Object localObject = gWeakListener;
    if (localObject != null)
    {
      localObject = (IToPayManager.TopayListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((IToPayManager.TopayListener)localObject).onRefreshTopayList(paramBoolean);
      }
    }
  }
  
  protected static void onGetRecomendList(boolean paramBoolean1, PfaFriendRsp paramPfaFriendRsp, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && ((!paramBoolean1) || (paramPfaFriendRsp == null) || ((paramPfaFriendRsp != null) && (paramPfaFriendRsp.ret != 0)))) {
      return;
    }
    if ((!paramBoolean2) && (mData != null) && (paramPfaFriendRsp != null) && ((paramPfaFriendRsp.vecPfaMsg == null) || (paramPfaFriendRsp.vecPfaMsg.size() <= 0)))
    {
      mData.vecRec = paramPfaFriendRsp.vecRec;
      mData.use_default = paramPfaFriendRsp.use_default;
      mData.vecSpfaRec = paramPfaFriendRsp.vecSpfaRec;
    }
    else
    {
      mData = paramPfaFriendRsp;
    }
    notifyUi(paramBoolean2 ^ true);
    if ((!paramBoolean2) && (mData != null)) {
      ThreadManager.getFileThreadHandler().post(new ToPayManagerImpl.2());
    }
  }
  
  protected static void refreshFromNet(int paramInt1, int paramInt2)
  {
    BaseQQAppInterface localBaseQQAppInterface = QWalletTools.a();
    if (localBaseQQAppInterface == null) {
      return;
    }
    if (mRecentListObserver == null) {
      mRecentListObserver = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).getQWalletAuthObserver(mHandler);
    }
    localBaseQQAppInterface.addObserver(mRecentListObserver);
    PfaFriendRqt localPfaFriendRqt = new PfaFriendRqt();
    localPfaFriendRqt.mqq_version = DeviceInfoUtil.a(MobileQQ.sMobileQQ);
    Object localObject = mData;
    if (localObject != null) {
      localPfaFriendRqt.pfa_msg_edition = ((PfaFriendRsp)localObject).pfa_msg_edition;
    } else {
      localPfaFriendRqt.pfa_msg_edition = "0";
    }
    localObject = (TicketManager)localBaseQQAppInterface.getManager(2);
    if (localObject != null) {
      localPfaFriendRqt.skey = ((TicketManager)localObject).getSkey(localBaseQQAppInterface.getCurrentAccountUin());
    }
    localPfaFriendRqt.pfa_sub_type = 0;
    if (paramInt1 == 1) {
      if (paramInt2 == 1) {
        localPfaFriendRqt.pfa_sub_type = 1;
      } else if (paramInt2 == 2) {
        localPfaFriendRqt.pfa_sub_type = 2;
      }
    }
    ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QWalletAuthHandler$sendGetRecentList(localBaseQQAppInterface, localPfaFriendRqt);
  }
  
  public static void sendTopay(AppActivity paramAppActivity, ArrayList<ResultRecord> paramArrayList, QQCustomDialog paramQQCustomDialog)
  {
    if ((paramAppActivity != null) && (!paramAppActivity.isFinishing()) && (paramAppActivity.getIntent() != null))
    {
      if (paramAppActivity.getIntent().getExtras() == null) {
        return;
      }
      if (paramArrayList != null)
      {
        if (paramArrayList.size() <= 0) {
          return;
        }
        ResultReceiver localResultReceiver = (ResultReceiver)paramAppActivity.getIntent().getParcelableExtra("aapay_result_recevier");
        if (localResultReceiver == null) {
          return;
        }
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)localIterator.next();
          localArrayList1.add(localResultRecord.uin);
          paramArrayList = localResultRecord.phone;
          String str = "";
          if (paramArrayList == null) {
            paramArrayList = "";
          } else {
            paramArrayList = localResultRecord.phone;
          }
          localArrayList2.add(paramArrayList);
          if (localResultRecord.name == null) {
            paramArrayList = str;
          } else {
            paramArrayList = localResultRecord.name;
          }
          localArrayList3.add(paramArrayList);
        }
        if (localArrayList1.size() <= 0) {
          return;
        }
        paramArrayList = new Bundle();
        paramArrayList.putStringArrayList("choose_friend_uins", localArrayList1);
        paramArrayList.putStringArrayList("choose_friend_phones", localArrayList2);
        paramArrayList.putStringArrayList("choose_friend_names", localArrayList3);
        if (paramQQCustomDialog != null) {
          paramArrayList.putString("choose_friend_feedback", paramQQCustomDialog.getInputValue());
        }
        paramQQCustomDialog = new ToPayManagerImpl.5(null, new WeakReference(paramAppActivity), localResultReceiver, localArrayList1, localArrayList3);
        showProgress(paramAppActivity, true);
        paramAppActivity = Parcel.obtain();
        paramQQCustomDialog.writeToParcel(paramAppActivity, 0);
        paramAppActivity.setDataPosition(0);
        paramQQCustomDialog = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramAppActivity);
        paramAppActivity.recycle();
        paramArrayList.putParcelable("callback", paramQQCustomDialog);
        localResultReceiver.send(0, paramArrayList);
      }
    }
  }
  
  private static void showBackDialogTip(Activity paramActivity, List<String> paramList1, List<String> paramList2)
  {
    ToPayManagerImpl.6 local6 = new ToPayManagerImpl.6(paramActivity);
    paramList1 = new ToPayManagerImpl.7(paramActivity, paramList1, paramList2);
    paramActivity = DialogUtil.a(paramActivity, 230, null, HardCodeUtil.a(R.string.cZ), HardCodeUtil.a(R.string.cX), "留在QQ", paramList1, local6);
    paramActivity.setCancelable(false);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.show();
  }
  
  private static void showProgress(AppActivity paramAppActivity, boolean paramBoolean)
  {
    if (paramAppActivity != null)
    {
      if (paramAppActivity.isFinishing()) {
        return;
      }
      Object localObject = null;
      if (paramBoolean)
      {
        paramAppActivity = new QWalletPayProgressDialog(paramAppActivity);
        gWeakProgress = new WeakReference(paramAppActivity);
        paramAppActivity.show();
        return;
      }
      WeakReference localWeakReference = gWeakProgress;
      paramAppActivity = localObject;
      if (localWeakReference != null) {
        paramAppActivity = (QWalletPayProgressDialog)localWeakReference.get();
      }
      if ((paramAppActivity != null) && (paramAppActivity.isShowing())) {
        paramAppActivity.dismiss();
      }
    }
  }
  
  public HashMap<String, Object> getTopayList(IToPayManager.TopayListener paramTopayListener, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    gWeakListener = new WeakReference(paramTopayListener);
    if ((paramInt1 != mBusinessType) || (paramInt2 != mBusinessSubType))
    {
      mData = null;
      mLoadedFromFileState = -1;
      mBusinessType = paramInt1;
      mBusinessSubType = paramInt2;
    }
    paramTopayListener = new HashMap();
    PfaFriendRsp localPfaFriendRsp = mData;
    if (localPfaFriendRsp == null)
    {
      paramTopayListener.put("recommend", getRecentList());
      if (mLoadedFromFileState == -1)
      {
        mLoadedFromFileState = 1;
        ThreadManager.getFileThreadHandler().post(new ToPayManagerImpl.1(this, paramInt1, paramInt2, paramBoolean));
        return paramTopayListener;
      }
    }
    else
    {
      if (localPfaFriendRsp.use_default == 1) {
        paramTopayListener.put("recommend", getRecentList());
      } else {
        paramTopayListener.put("recommend", mData.vecRec);
      }
      paramTopayListener.put("tips", mData.vecPfaMsg);
    }
    if (paramBoolean) {
      refreshFromNet(paramInt1, paramInt2);
    }
    return paramTopayListener;
  }
  
  public void onReceivePayerNotify(BaseQQAppInterface paramBaseQQAppInterface, String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramLong < 1L) {
        return;
      }
      Intent localIntent = new Intent("com.tencent.qwallet.payer.notify");
      localIntent.putExtra("sendUin", paramLong);
      localIntent.putExtra("tokenId", paramString);
      paramBaseQQAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void removeObserver(AppRuntime paramAppRuntime)
  {
    mLoadedFromFileState = -1;
    mData = null;
    WeakReference localWeakReference = gWeakListener;
    if (localWeakReference != null)
    {
      localWeakReference.clear();
      gWeakListener = null;
    }
    localWeakReference = gWeakProgress;
    if (localWeakReference != null)
    {
      localWeakReference.clear();
      gWeakProgress = null;
    }
    if ((paramAppRuntime instanceof AppInterface)) {
      ((AppInterface)paramAppRuntime).removeObserver(mRecentListObserver);
    }
  }
  
  public void topay(AppActivity paramAppActivity, ArrayList<ResultRecord> paramArrayList)
  {
    if ((paramAppActivity != null) && (!paramAppActivity.isFinishing()) && (paramAppActivity.getIntent() != null))
    {
      if (paramAppActivity.getIntent().getExtras() == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = HardCodeUtil.a(R.string.cY);
      Object localObject1 = localObject2;
      if (paramArrayList != null)
      {
        localObject1 = localObject2;
        int i = 0;
        while (i < paramArrayList.size())
        {
          ResultRecord localResultRecord = (ResultRecord)paramArrayList.get(i);
          localObject2 = localObject1;
          if (localResultRecord != null)
          {
            localObject2 = localObject1;
            if (localResultRecord.type == 0)
            {
              localObject2 = localObject1;
              if (localResultRecord.uin != null)
              {
                localArrayList.add(localResultRecord);
                if (!TextUtils.isEmpty(localResultRecord.name))
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append((String)localObject1);
                  ((StringBuilder)localObject2).append(localResultRecord.name);
                  localObject1 = ((StringBuilder)localObject2).toString();
                }
                else
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append((String)localObject1);
                  ((StringBuilder)localObject2).append(localResultRecord.uin);
                  localObject1 = ((StringBuilder)localObject2).toString();
                }
                localObject2 = localObject1;
                if (i < paramArrayList.size() - 1)
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append((String)localObject1);
                  ((StringBuilder)localObject2).append("、");
                  localObject2 = ((StringBuilder)localObject2).toString();
                }
              }
            }
          }
          i += 1;
          localObject1 = localObject2;
        }
      }
      if (localArrayList.size() <= 0)
      {
        QQToast.a(paramAppActivity, paramAppActivity.getString(R.string.dv), 0).a();
        return;
      }
      paramArrayList = new ToPayManagerImpl.4(this, new WeakReference(paramAppActivity), localArrayList);
      if (((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).isSelectMemberActivityInstance(paramAppActivity)) {
        ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QQCustomDialogWtihInputAndChoose$show(paramAppActivity, (String)localObject1, paramArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.ToPayManagerImpl
 * JD-Core Version:    0.7.0.1
 */