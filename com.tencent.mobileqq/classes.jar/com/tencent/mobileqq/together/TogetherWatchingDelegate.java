package com.tencent.mobileqq.together;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.TogetherConfigureBean;
import com.tencent.mobileqq.config.business.WatchTogetherBean;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherManager;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.together.delegate.TogetherDelegate;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import javax.annotation.Nullable;

public class TogetherWatchingDelegate
  implements TogetherDelegate
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  WatchTogetherManager jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherManager;
  private TogetherObserver jdField_a_of_type_ComTencentMobileqqTogetherTogetherObserver = new TogetherWatchingDelegate.1(this);
  
  public TogetherWatchingDelegate(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherObserver);
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    if (paramInt1 == 8) {}
    for (String str = "exp_openframe";; str = "exp_joinbar")
    {
      a(paramString, str);
      DialogUtil.a(paramContext, 230, null, paramContext.getResources().getString(2131699315), paramContext.getResources().getString(2131690800), paramContext.getResources().getString(2131691410), new TogetherWatchingDelegate.2(this, paramString, paramInt1, paramBundle, paramInt2, paramContext), new TogetherWatchingDelegate.3(this, paramString, paramInt1)).show();
      return;
    }
  }
  
  private void a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    TogetherConfigureBean localTogetherConfigureBean = (TogetherConfigureBean)QConfigManager.a().a(535);
    if (localTogetherConfigureBean == null) {}
    TroopInfo localTroopInfo;
    for (int i = 0;; i = localTogetherConfigureBean.a.a())
    {
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
      if ((i != 0) && (localTroopInfo != null)) {
        break;
      }
      QQToast.a(paramContext, 0, 2131693140, 0).a();
      if (QLog.isColorLevel()) {
        QLog.d("WatchTogetherManager", 2, new Object[] { "reopenCategoryPage version=", Integer.valueOf(i), " troopInfo=", localTroopInfo });
      }
      return;
    }
    paramString = TogetherUtils.a(false, localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), localTroopInfo.isAdmin(), localTroopInfo.troopowneruin, paramString, paramInt2);
    TogetherUtils.a(paramContext, localTogetherConfigureBean.a.b(), localTogetherConfigureBean.a.a(), localTogetherConfigureBean.a.b(), paramString, paramInt1);
  }
  
  private void a(Context paramContext, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing()))
    {
      QLog.e("WatchTogetherManager", 1, "topActivity is null or finishing");
      return;
    }
    a(paramString2, "exp_unableframe");
    DialogUtil.a(localBaseActivity, 230, null, paramString3, paramContext.getResources().getString(2131694257), paramContext.getResources().getString(2131694615), new TogetherWatchingDelegate.4(this, paramString2), new TogetherWatchingDelegate.5(this, paramString2, paramString1, paramInt1, paramInt2)).show();
  }
  
  private void a(Bundle paramBundle, String paramString, int paramInt1, int paramInt2)
  {
    int i = paramBundle.getInt("category_id", 0);
    String str1 = paramBundle.getString("video_id", "");
    String str2 = paramBundle.getString("title_name", "");
    paramBundle = paramBundle.getString("room_cover", "");
    ((TogetherOperationHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).a(i, str1, str2, paramBundle, 1, paramString, paramInt1, paramInt2);
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString2);
    if (localTroopInfo == null)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 0, 2131693140, 0).a();
      if (QLog.isColorLevel()) {
        QLog.d("WatchTogetherManager", 2, new Object[] { "reopenVideoRoom troopInfo=", localTroopInfo });
      }
      return;
    }
    paramString2 = TogetherUtils.a(false, localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), localTroopInfo.isAdmin(), localTroopInfo.troopowneruin, paramString2, paramInt2);
    TogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString1, null, paramString2, paramInt1);
  }
  
  private void a(String paramString1, String paramString2)
  {
    ((TogetherControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a("video_tab", paramString2, 0, paramString1);
  }
  
  public int a()
  {
    return 7;
  }
  
  public WatchTogetherManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherManager = ((WatchTogetherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WATCH_LIVE_TOGETHER));
    }
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherManager;
  }
  
  public QQCustomDialog a()
  {
    return null;
  }
  
  public String a()
  {
    return TogetherConstants.b;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherObserver);
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, @Nullable Map<String, TogetherSession> paramMap, @Nullable Bundle paramBundle)
  {
    QLog.i("WatchTogetherManager", 1, "notifySessionChange  serviceType = " + paramInt1 + " from = " + paramInt3);
  }
  
  public void a(Context paramContext, SessionInfo paramSessionInfo, int paramInt)
  {
    if (paramInt == 6) {
      a().a();
    }
  }
  
  public void a(Context paramContext, String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    a(paramContext, paramInt2, paramInt1, paramString, paramBundle);
  }
  
  public void a(TogetherSession paramTogetherSession, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    QLog.i("WatchTogetherManager", 1, "onPushMessageReceive");
    a().a((WatchTogetherSession)paramTogetherSession, paramInt);
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, Map<String, TogetherSession> paramMap, @Nullable Bundle paramBundle)
  {
    if (paramInt2 == 0) {}
    for (paramContext = "2";; paramContext = "")
    {
      QLog.i("WatchTogetherManager", 1, "start  groupuin = " + paramString + " miniapp_from = " + paramContext);
      WatchTogetherSession localWatchTogetherSession = (WatchTogetherSession)paramMap.get("2_1_" + paramString);
      paramMap = localWatchTogetherSession;
      if (localWatchTogetherSession == null) {}
      try
      {
        paramMap = (WatchTogetherSession)TogetherUtils.a(2, 1, paramString);
        a().a(paramContext, paramMap, paramBundle);
        return false;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramMap = localWatchTogetherSession;
        }
      }
    }
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Map<String, TogetherSession> paramMap, @Nullable Bundle paramBundle)
  {
    return true;
  }
  
  public boolean b(Context paramContext, String paramString, int paramInt1, int paramInt2, Map<String, TogetherSession> paramMap, @Nullable Bundle paramBundle)
  {
    paramContext = (WatchTogetherSession)paramMap.get("2_1_" + paramString);
    QLog.i("WatchTogetherManager", 1, "join  groupuin = " + paramString + " from = " + paramInt2);
    if (paramInt2 == 2) {
      a().a("4", paramContext, paramBundle);
    }
    while (((paramInt2 != 1) && (paramInt2 != 8)) || (paramContext == null)) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramContext.a)) && (!paramContext.a.contains("fromid"))) {
      paramContext.a = (paramContext.a + "&fromid=" + "10011");
    }
    a().a(paramContext, paramBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherWatchingDelegate
 * JD-Core Version:    0.7.0.1
 */