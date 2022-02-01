package com.tencent.mobileqq.nearby.api.impl;

import EncounterSvc.UserDetailLocalInfo;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.NearbyEntityManagerFactory;
import com.tencent.mobileqq.nearby.NearbyFaceScoreManager;
import com.tencent.mobileqq.nearby.NearbyReportManager;
import com.tencent.mobileqq.nearby.NearbyTransFileControllerImpl;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.IFactoryApi;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.api.INearbyTransFileController;
import com.tencent.mobileqq.nearby.api.IOldBigDataChannelManager;
import com.tencent.mobileqq.nearby.api.IService;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.nearby.ipc.INearbyProcObserver;
import com.tencent.mobileqq.nearpeople.api.INearbyMineHelper;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.troop.widget.UsingTimeReportManager;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AccountManagerImpl;
import mqq.app.IToolProcEventListener;
import mqq.app.MobileQQ;
import mqq.app.ProxyIpManagerImpl;
import mqq.app.TicketManagerImpl;
import mqq.app.WtloginManagerImpl;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

public class NearbyAppInterfaceImpl
  extends BaseToolAppInterface
  implements INearbyAppInterface, IToolProcEventListener
{
  public static final String TAG = "NearbyAppInterface";
  private static boolean sEnableFreshPreload = true;
  private static boolean sEnableFreshStaticLayout = true;
  NearbyEntityManagerFactory emFactory;
  boolean mCloseRn = false;
  boolean mDPCInit = false;
  String mDpcCloseRn = null;
  private Object mEmFactoryLock = new Object();
  private int mLastTabIndex = 0;
  Object mLock = new Object();
  private boolean mNeedStoreAnchorage = true;
  private NetEngineFactory mNetEngineFactory = null;
  private int mPerfState = 0;
  private long mPreLoadTime;
  private int mPreloadFrom = 0;
  private oidb_0x8dd.SelfInfo mSelfRespEncounterInfo;
  private IService mService;
  private UserDetailLocalInfo mUdlInfo = null;
  int mVoteRedDotState = -2147483648;
  Map<Integer, Manager> managers = new HashMap(20);
  NearbyMyTabCard myTabCard;
  NearbyAppInterfaceImpl.MyNetInfoHandler netHandler = null;
  private INearbyTransFileController transFileController;
  
  public NearbyAppInterfaceImpl(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  private String checkClickEventParam(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if ((paramString2 != null) && (paramString4 != null) && (paramString5 != null))
    {
      if ((paramString1.equals("CliOper")) && (paramString2.length() > 0)) {
        return "mainAction is not empty";
      }
      if ((paramString1.equals("CliOper")) && (TextUtils.isEmpty(paramString6))) {}
    }
    try
    {
      Long.parseLong(paramString6);
    }
    catch (Exception paramString1)
    {
      label62:
      break label62;
    }
    return "r2 must be a numeric string";
    if (!TextUtils.isEmpty(paramString7)) {}
    try
    {
      Long.parseLong(paramString7);
    }
    catch (Exception paramString1)
    {
      label82:
      break label82;
    }
    return "r3 must be a numeric string";
    return null;
    return "mainAction or subAction or actionName may not be null";
  }
  
  public static void freePartBitmapCache()
  {
    if (GlobalImageCache.a != null)
    {
      int i = GlobalImageCache.a.size() * 3 / 4;
      GlobalImageCache.a.trimToSize(i);
    }
  }
  
  public static boolean issEnableFreshPreload()
  {
    return sEnableFreshPreload;
  }
  
  public static boolean issEnableFreshStaticLayout()
  {
    return sEnableFreshStaticLayout;
  }
  
  public static void setsEnableFreshPreload(boolean paramBoolean)
  {
    sEnableFreshPreload = paramBoolean;
  }
  
  public static void setsEnableFreshStaticLayout(boolean paramBoolean)
  {
    sEnableFreshStaticLayout = paramBoolean;
  }
  
  public void addManager(int paramInt, Manager paramManager)
  {
    if (this.managers.get(Integer.valueOf(paramInt)) != null) {
      return;
    }
    this.managers.put(Integer.valueOf(paramInt), paramManager);
  }
  
  public void addNearbyProcObserver(INearbyProcObserver paramINearbyProcObserver)
  {
    INearbyProcManager localINearbyProcManager = (INearbyProcManager)getManager(NearbyConstants.e);
    if (localINearbyProcManager != null) {
      localINearbyProcManager.a(paramINearbyProcObserver);
    }
  }
  
  public void clearMyTabCardVisitorInfo()
  {
    NearbyMyTabCard localNearbyMyTabCard = getMyTabCard();
    if (localNearbyMyTabCard != null)
    {
      localNearbyMyTabCard.visitors.clear();
      ((INearbyMineHelper)QRoute.api(INearbyMineHelper.class)).storeNearbyMyTabCard(this, localNearbyMyTabCard);
    }
  }
  
  public void finalize()
  {
    super.finalize();
    NearbyEntityManagerFactory localNearbyEntityManagerFactory = this.emFactory;
    if (localNearbyEntityManagerFactory != null) {
      localNearbyEntityManagerFactory.close();
    }
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public String getCurrentNickname()
  {
    if (getmSelfRespEncounterInfo() == null) {
      return getAccount();
    }
    return getmSelfRespEncounterInfo().bytes_nick.get().toStringUtf8();
  }
  
  public EntityManagerFactory getEntityManagerFactory()
  {
    return getEntityManagerFactory(getAccount());
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(getAccount())))
    {
      ??? = this.emFactory;
      if (??? != null) {
        return ???;
      }
      synchronized (this.mEmFactoryLock)
      {
        if (this.emFactory == null)
        {
          this.emFactory = new NearbyEntityManagerFactory(paramString);
          ThreadManager.getSubThreadHandler().postDelayed(new NearbyAppInterfaceImpl.1(this), 1000L);
        }
        return this.emFactory;
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("Can not create a entity factory, the account is not match.");
    ((StringBuilder)???).append(paramString);
    ((StringBuilder)???).append("!=");
    ((StringBuilder)???).append(getAccount());
    throw new IllegalStateException(((StringBuilder)???).toString());
  }
  
  public Manager getManager(int paramInt)
  {
    Object localObject1 = (Manager)this.managers.get(Integer.valueOf(paramInt));
    Map localMap;
    if (localObject1 == null)
    {
      localMap = this.managers;
      if (paramInt != 0) {}
    }
    try
    {
      localObject1 = new AccountManagerImpl(this);
      break label287;
      if (paramInt == 1)
      {
        localObject1 = new WtloginManagerImpl(this);
      }
      else if (paramInt == 2)
      {
        localObject1 = new TicketManagerImpl(this);
      }
      else if (paramInt == 3)
      {
        localObject1 = new ProxyIpManagerImpl(this);
      }
      else if (paramInt == NearbyConstants.b)
      {
        localObject1 = new NearbyDataManager(this);
      }
      else if (paramInt == NearbyConstants.c)
      {
        localObject1 = new NetEngineFactory();
      }
      else if (paramInt == NearbyConstants.e)
      {
        localObject1 = (Manager)((IFactoryApi)QRoute.api(IFactoryApi.class)).getNearbyProcManager(this);
      }
      else if (paramInt == NearbyConstants.g)
      {
        localObject1 = (IOldBigDataChannelManager)QRoute.api(IOldBigDataChannelManager.class);
        ((IOldBigDataChannelManager)localObject1).init(this);
        localObject1 = (Manager)localObject1;
      }
      else if (paramInt == NearbyConstants.h)
      {
        localObject1 = new NearbyReportManager(this);
      }
      else if (paramInt == NearbyConstants.i)
      {
        localObject1 = new NearbyFaceScoreManager(this);
      }
      else if (paramInt == NearbyConstants.j)
      {
        localObject1 = new UsingTimeReportManager(this);
      }
      else if (paramInt == NearbyConstants.k)
      {
        localObject1 = new DownloaderFactory(this);
      }
      else if (paramInt == QQManagerFactory.DYNAMIC_AVATAR_MANAGER)
      {
        localObject1 = new DynamicAvatarManager(this);
      }
      label287:
      Object localObject3;
      if (this.managers.get(Integer.valueOf(paramInt)) != null)
      {
        localObject3 = (Manager)this.managers.get(Integer.valueOf(paramInt));
      }
      else
      {
        localObject3 = localObject1;
        if (localObject1 != null)
        {
          this.managers.put(Integer.valueOf(paramInt), localObject1);
          localObject3 = localObject1;
        }
      }
      return localObject3;
    }
    finally
    {
      label351:
      break label351;
    }
    throw ((Throwable)localObject1);
    return localObject1;
  }
  
  public MobileQQServiceBase getMobileQQService()
  {
    return (MobileQQServiceBase)getmService();
  }
  
  public String getModuleId()
  {
    return "module_nearby";
  }
  
  public NearbyMyTabCard getMyTabCard()
  {
    if (this.myTabCard == null) {
      this.myTabCard = ((INearbyMineHelper)QRoute.api(INearbyMineHelper.class)).readNearbyMyTabCardFromLocal(this);
    }
    return this.myTabCard;
  }
  
  public NearbyMyTabCard getMyTabCardCache()
  {
    return this.myTabCard;
  }
  
  public INearbyProcManager getNearbyProcManager()
  {
    return (INearbyProcManager)getManager(NearbyConstants.e);
  }
  
  public INearbyTransFileController getTransFileController()
  {
    if (this.transFileController == null) {
      this.transFileController = new NearbyTransFileControllerImpl((INearbyAppInterface)this.app);
    }
    return this.transFileController;
  }
  
  public int getVoteRedDotState()
  {
    if (this.mVoteRedDotState == -2147483648) {
      this.mVoteRedDotState = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(getAccount(), "sp_nearby_mytab", 0, "key_nearby_mytab_zan_check", Integer.valueOf(0))).intValue();
    }
    return this.mVoteRedDotState;
  }
  
  public int getmLastTabIndex()
  {
    return this.mLastTabIndex;
  }
  
  public int getmPerfState()
  {
    return this.mPerfState;
  }
  
  public long getmPreLoadTime()
  {
    return this.mPreLoadTime;
  }
  
  public int getmPreloadFrom()
  {
    return this.mPreloadFrom;
  }
  
  public oidb_0x8dd.SelfInfo getmSelfRespEncounterInfo()
  {
    return this.mSelfRespEncounterInfo;
  }
  
  public IService getmService()
  {
    return this.mService;
  }
  
  public UserDetailLocalInfo getmUdlInfo()
  {
    return this.mUdlInfo;
  }
  
  public boolean isCloseRn()
  {
    boolean bool1;
    Object localObject;
    if (this.mDpcCloseRn == null)
    {
      this.mDpcCloseRn = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.nearby_react_native_config.name(), "0");
      boolean bool2 = NearbyUtils.b();
      bool1 = true;
      if (bool2) {
        NearbyUtils.a("NearbyAppInterface", new Object[] { "isCloseRn", this.mDpcCloseRn });
      }
      localObject = this.mDpcCloseRn;
      if (localObject != null)
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject == null) || (localObject.length <= 0)) {}
      }
    }
    for (;;)
    {
      try
      {
        if (Integer.parseInt(localObject[0]) != 1) {
          break label123;
        }
        this.mCloseRn = bool1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return this.mCloseRn;
      label123:
      bool1 = false;
    }
  }
  
  public boolean isSVip()
  {
    return false;
  }
  
  public boolean isVip()
  {
    return false;
  }
  
  public boolean ismNeedStoreAnchorage()
  {
    return this.mNeedStoreAnchorage;
  }
  
  public void nearbyReportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    String str = checkClickEventParam(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    if (TextUtils.isEmpty(str))
    {
      getNearbyProcManager().a(false, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
      return;
    }
    throw new IllegalArgumentException(str);
  }
  
  public void onBeforeExitProc() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setmService(new ServiceImpl(this));
    ((INearbyProcManager)getManager(NearbyConstants.e)).a();
    ThreadManager.post(new NearbyAppInterfaceImpl.2(this), 8, null, true);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mHwEngine != null) {
      this.mHwEngine.closeEngine();
    }
    synchronized (this.mLock)
    {
      boolean bool = this.mDPCInit;
      if (bool)
      {
        try
        {
          ((IDPCApi)QRoute.api(IDPCApi.class)).unRegisterBroadCast(this);
        }
        catch (Exception localException1)
        {
          if (!QLog.isColorLevel()) {
            break label77;
          }
        }
        QLog.e("NearbyAppInterface", 2, "onDestroy: ", localException1);
      }
      else
      {
        this.mDPCInit = true;
      }
      label77:
      synchronized (this.managers)
      {
        Object localObject2 = this.managers.keySet();
        if ((localObject2 != null) && (((Set)localObject2).size() > 0))
        {
          localObject2 = ((Set)localObject2).iterator();
          for (;;)
          {
            bool = ((Iterator)localObject2).hasNext();
            if (!bool) {
              break;
            }
            try
            {
              Manager localManager = (Manager)this.managers.get(((Iterator)localObject2).next());
              if (localManager == null) {
                continue;
              }
              localManager.onDestroy();
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
            }
            if (QLog.isColorLevel()) {
              NearbyUtils.a("NearbyAppInterface", new Object[] { "onDestroy", localException2.toString() });
            }
          }
        }
        this.managers.clear();
        return;
      }
    }
    for (;;)
    {
      throw localObject4;
    }
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    NearbyUtils.a("onReceiveAccountAction", new Object[0]);
    if ("mqq.intent.action.ACCOUNT_KICKED".equals(paramString)) {
      ((UsingTimeReportManager)getManager(NearbyConstants.j)).a();
    }
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    NearbyUtils.a("onReceiveLegalExitProcAction", new Object[0]);
    return false;
  }
  
  public void removeNearbyProcObserver(INearbyProcObserver paramINearbyProcObserver)
  {
    INearbyProcManager localINearbyProcManager = (INearbyProcManager)getManager(NearbyConstants.e);
    if (localINearbyProcManager != null) {
      localINearbyProcManager.b(paramINearbyProcObserver);
    }
  }
  
  public void reportClickEventAsync(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    String str = checkClickEventParam(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    if (TextUtils.isEmpty(str))
    {
      ThreadManager.post(new NearbyAppInterfaceImpl.3(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9), 2, null, false);
      return;
    }
    throw new IllegalArgumentException(str);
  }
  
  public void saveSelfRespEncounterInfo(Object paramObject)
  {
    paramObject = (oidb_0x8dd.SelfInfo)paramObject;
    if (paramObject == null) {
      return;
    }
    setmSelfRespEncounterInfo(paramObject);
    if (paramObject.uint64_tinyid.get() != 0L) {
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(getAccount(), "self_tinnyid", Long.valueOf(paramObject.uint64_tinyid.get()));
    }
    if (!TextUtils.isEmpty(paramObject.bytes_nick.get().toStringUtf8())) {
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(getAccount(), "self_nick", paramObject.bytes_nick.get().toStringUtf8());
    }
    if (!TextUtils.isEmpty(paramObject.str_third_line_info.get())) {
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(getAccount(), "self_third_line_info", paramObject.str_third_line_info.get());
    }
    if (!TextUtils.isEmpty(paramObject.str_third_line_icon.get())) {
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(getAccount(), "self_third_line_icon", paramObject.str_third_line_icon.get());
    }
    if (paramObject.uint32_age.get() != -1) {
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(getAccount(), "self_age", Integer.valueOf(paramObject.uint32_age.get()));
    }
    if (paramObject.uint32_gender.get() != -1)
    {
      int j = paramObject.uint32_gender.get();
      int i = 1;
      if (j != 0) {
        if (j != 1) {
          i = 0;
        } else {
          i = 2;
        }
      }
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(getAccount(), "self_gender", Integer.valueOf(i));
    }
    getNearbyProcManager().a(paramObject);
  }
  
  @TargetApi(14)
  public void setTalkbackSwitch()
  {
    for (;;)
    {
      try
      {
        Object localObject = (AccessibilityManager)this.app.getSystemService("accessibility");
        bool1 = ((AccessibilityManager)localObject).isEnabled();
        boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
        if ((bool1) && (bool2))
        {
          bool1 = true;
          AppSetting.d = bool1;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("set talkback enable: ");
            ((StringBuilder)localObject).append(AppSetting.d);
            QLog.d("NearbyAppInterface", 2, ((StringBuilder)localObject).toString());
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      boolean bool1 = false;
    }
  }
  
  public void setmLastTabIndex(int paramInt)
  {
    this.mLastTabIndex = paramInt;
  }
  
  public void setmNeedStoreAnchorage(boolean paramBoolean)
  {
    this.mNeedStoreAnchorage = paramBoolean;
  }
  
  public void setmPerfState(int paramInt)
  {
    this.mPerfState = paramInt;
  }
  
  public void setmPreLoadTime(long paramLong)
  {
    this.mPreLoadTime = paramLong;
  }
  
  public void setmPreloadFrom(int paramInt)
  {
    this.mPreloadFrom = paramInt;
  }
  
  public void setmSelfRespEncounterInfo(Object paramObject)
  {
    this.mSelfRespEncounterInfo = ((oidb_0x8dd.SelfInfo)paramObject);
  }
  
  public void setmService(IService paramIService)
  {
    this.mService = paramIService;
  }
  
  public void setmUdlInfo(UserDetailLocalInfo paramUserDetailLocalInfo)
  {
    this.mUdlInfo = paramUserDetailLocalInfo;
  }
  
  public void start(boolean paramBoolean)
  {
    this.netHandler = new NearbyAppInterfaceImpl.MyNetInfoHandler(this, null);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.netHandler);
    super.start(paramBoolean);
  }
  
  public void updateMyTabCard(NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (this.myTabCard != paramNearbyMyTabCard) {
      this.myTabCard = paramNearbyMyTabCard;
    }
  }
  
  public void updatePerfState(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("updatePerfState", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(getmPerfState()) });
    }
    if (paramInt1 > getmPerfState())
    {
      setmPerfState(paramInt1);
      if (getmPerfState() == 1)
      {
        setmPreLoadTime(System.currentTimeMillis());
        setmPreloadFrom(paramInt2);
      }
    }
  }
  
  public void writeVoteRedDotState(int paramInt)
  {
    this.mVoteRedDotState = paramInt;
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(getAccount(), "sp_nearby_mytab", 0, "key_nearby_mytab_zan_check", Integer.valueOf(this.mVoteRedDotState));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbyAppInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */