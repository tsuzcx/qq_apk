package com.tencent.mobileqq.together;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherParser;
import com.tencent.mobileqq.intervideo.singtogether.TogetherSingDelegate;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherWatchFloatingUtil;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherParser;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.together.delegate.TogetherDelegate;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class TogetherControlManager
  implements Manager
{
  ArrayList<TogetherControlManager.EntryBannerInfo> a = new ArrayList(5);
  SharedPreferences b;
  private final QQAppInterface c;
  private final LruCache<String, Long> d;
  private final HashMap<String, TogetherSession> e;
  private SparseArray<TogetherDelegate> f;
  private final Map<String, TogetherControlManager.CacheHolder> g;
  private ArrayList<TogetherObserver> h;
  private ConcurrentHashMap<Integer, TogetherParser> i;
  private ConcurrentHashMap<Integer, TogetherEntryData> j;
  private TianShuGetAdvCallback k = new TogetherControlManager.1(this);
  private final TroopPushObserver l = new TogetherControlManager.2(this);
  private final TroopMngObserver m = new TogetherControlManager.3(this);
  private FriendListObserver n = new TogetherControlManager.4(this);
  
  public TogetherControlManager(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
    this.d = new LruCache(100);
    this.e = new HashMap(50);
    this.f = new SparseArray();
    this.g = new HashMap(50);
    this.h = new ArrayList(50);
    a(2, new TogetherWatchingDelegate(this.c));
    a(4, new TogetherSingDelegate(this.c));
    e();
    this.c.addObserver(this.m);
    this.c.addObserver(this.l);
    this.c.addObserver(this.n);
    this.b = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0);
  }
  
  public static TogetherControlManager a(QQAppInterface paramQQAppInterface)
  {
    return (TogetherControlManager)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
  }
  
  private String a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if (this.e.get(paramString2) != null)
    {
      if ((paramString1.equals(paramArrayOfString[2])) && (3 != ((TogetherSession)this.e.get(paramString2)).p) && (((TogetherSession)this.e.get(paramString2)).p != 0)) {
        return c(paramArrayOfString[0]);
      }
      if ((paramString1.equals(paramArrayOfString[2])) && (2 == ((TogetherSession)this.e.get(paramString2)).q)) {
        return c(paramArrayOfString[0]);
      }
      if ((!paramString1.equals(paramArrayOfString[2])) && (TogetherWatchFloatingUtil.a(Integer.parseInt(paramArrayOfString[0]), paramArrayOfString[2], Integer.parseInt(paramArrayOfString[1])))) {
        return c(paramArrayOfString[0]);
      }
    }
    return "";
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, @javax.annotation.Nullable Map<String, TogetherSession> paramMap, @javax.annotation.Nullable Bundle paramBundle)
  {
    int i1 = 0;
    while (i1 < this.f.size())
    {
      TogetherDelegate localTogetherDelegate = (TogetherDelegate)this.f.valueAt(i1);
      if (localTogetherDelegate != null) {
        localTogetherDelegate.a(paramContext, paramInt1, paramInt2, paramInt3, paramMap, paramBundle);
      }
      i1 += 1;
    }
  }
  
  private boolean a(int paramInt, Bundle paramBundle)
  {
    QLog.d("TogetherControlManager", 1, new Object[] { "checkParamsIsValid from=", Integer.valueOf(paramInt) });
    if (paramInt == 10) {
      return true;
    }
    paramInt = paramBundle.getInt("category_id", 0);
    String str1 = paramBundle.getString("video_id", "");
    String str2 = paramBundle.getString("title_name", "");
    paramBundle = paramBundle.getString("room_cover", "");
    if ((paramInt != 0) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(paramBundle))) {
      return true;
    }
    QLog.d("TogetherControlManager", 1, new Object[] { "onArkTogetherClick return invalid params videoId=", str1, " categoryId=", Integer.valueOf(paramInt), " titleName:", str2, " roomCover:", paramBundle });
    return false;
  }
  
  private boolean a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3)
  {
    boolean bool = b(paramInt1, paramInt2, paramString);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" isOpen=");
      localStringBuilder.append(bool);
      QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(paramInt1), localStringBuilder.toString() });
    }
    if (!bool)
    {
      a(paramInt3, paramBaseActivity);
      return false;
    }
    paramString = a(paramInt1, paramInt2, paramString);
    if ((paramString != null) && (paramString.p != 3))
    {
      if ((paramString.x != paramLong) && (paramLong != 0L))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(" session.identifyId=");
          localStringBuilder.append(paramString.x);
          localStringBuilder.append(" msg.identify=");
          localStringBuilder.append(paramLong);
          QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(paramInt1), localStringBuilder.toString() });
        }
        a(paramInt3, paramBaseActivity);
        return false;
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(paramInt1), " session=", paramString });
    }
    return false;
  }
  
  private static boolean a(TianShuAccess.RspEntry paramRspEntry)
  {
    return (paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst.size() == 0) || (paramRspEntry.value.lst.get(0) == null) || (((TianShuAccess.AdItem)paramRspEntry.value.lst.get(0)).argList == null) || (((TianShuAccess.AdItem)paramRspEntry.value.lst.get(0)).argList.get() == null);
  }
  
  @org.jetbrains.annotations.Nullable
  private static TianShuAccess.RspEntry b(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp, int paramInt)
  {
    if (paramBoolean)
    {
      if (paramGetAdsRsp == null) {
        return null;
      }
      if (paramGetAdsRsp.mapAds.has()) {
        paramGetAdsRsp = paramGetAdsRsp.mapAds.get();
      } else {
        paramGetAdsRsp = null;
      }
      if (paramGetAdsRsp == null) {
        return null;
      }
      HashMap localHashMap = new HashMap();
      paramGetAdsRsp = paramGetAdsRsp.iterator();
      while (paramGetAdsRsp.hasNext())
      {
        TianShuAccess.RspEntry localRspEntry = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
        if ((localRspEntry != null) && (localRspEntry.key.has())) {
          localHashMap.put(Integer.valueOf(localRspEntry.key.get()), localRspEntry);
        }
      }
      paramGetAdsRsp = (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(paramInt));
      if (a(paramGetAdsRsp)) {
        return null;
      }
      return paramGetAdsRsp;
    }
    return null;
  }
  
  private void b(TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      ((TogetherObserver)localIterator.next()).onUpdate(2, true, paramTroopUnreadMsgInfo);
    }
  }
  
  private boolean b(int paramInt, String paramString)
  {
    Iterator localIterator = this.e.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      String[] arrayOfString = ((String)localObject).split("_");
      localObject = (TogetherSession)this.e.get(localObject);
      if ((arrayOfString.length > 0) && (localObject != null) && (!paramString.equals(arrayOfString[2])) && (2 == ((TogetherSession)localObject).q) && (paramInt == Integer.parseInt(arrayOfString[0]))) {
        return true;
      }
    }
    return false;
  }
  
  private String c(String paramString)
  {
    if (Integer.parseInt(paramString) == 1) {
      return HardCodeUtil.a(2131912319);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131912312));
    localStringBuilder.append(((TogetherDelegate)this.f.get(Integer.parseInt(paramString))).a());
    localStringBuilder.append(HardCodeUtil.a(2131912324));
    return localStringBuilder.toString();
  }
  
  private void c(int paramInt1, int paramInt2, String paramString)
  {
    if (a(paramInt1, paramInt2, paramString) == null) {
      a(paramInt1, paramInt2, paramString, TogetherUtils.a(paramInt1, paramInt2, paramString));
    }
  }
  
  private void e()
  {
    this.i = new ConcurrentHashMap(2);
    this.i.put(Integer.valueOf(2), new WatchTogetherParser(this.c));
    this.i.put(Integer.valueOf(4), new SingTogetherParser(this.c));
  }
  
  public int a(int paramInt, String paramString)
  {
    if (paramString.equals(this.c.getCurrentAccountUin())) {
      return 0;
    }
    int i1 = 0;
    while (i1 < this.f.size())
    {
      int i2 = this.f.keyAt(i1);
      TogetherDelegate localTogetherDelegate = (TogetherDelegate)this.f.valueAt(i1);
      if ((localTogetherDelegate != null) && (b(i2, paramInt, paramString))) {
        return localTogetherDelegate.c();
      }
      i1 += 1;
    }
    return 0;
  }
  
  public long a(int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    localObject = (Long)this.d.get(localObject);
    if (localObject == null) {
      return 0L;
    }
    return ((Long)localObject).longValue();
  }
  
  public <T extends TogetherParser> T a(int paramInt)
  {
    TogetherParser localTogetherParser2 = (TogetherParser)this.i.get(Integer.valueOf(paramInt));
    TogetherParser localTogetherParser1 = localTogetherParser2;
    if (localTogetherParser2 == null) {
      localTogetherParser1 = null;
    }
    return localTogetherParser1;
  }
  
  public <T extends TogetherSession> T a(int paramInt1, int paramInt2, String paramString)
  {
    HashMap localHashMap = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = (TogetherSession)localHashMap.get(localStringBuilder.toString());
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public TroopUnreadMsgInfo a(String paramString)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).getString(paramString, "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = ((String)localObject).split("_");
    if (localObject.length == 2)
    {
      TroopUnreadMsgInfo localTroopUnreadMsgInfo = new TroopUnreadMsgInfo();
      localTroopUnreadMsgInfo.b = paramString;
      localTroopUnreadMsgInfo.d = Integer.valueOf(localObject[0]).intValue();
      localTroopUnreadMsgInfo.c = Integer.valueOf(localObject[1]).intValue();
      return localTroopUnreadMsgInfo;
    }
    return null;
  }
  
  @javax.annotation.Nullable
  public HashMap<String, TogetherSession> a()
  {
    HashMap localHashMap = this.e;
    if (localHashMap != null) {
      return (HashMap)localHashMap.clone();
    }
    return new HashMap();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    ((TogetherOperationHandler)this.c.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).a(paramInt1, paramInt2, paramString, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    this.d.put(paramString, Long.valueOf(paramLong));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, TogetherSession paramTogetherSession)
  {
    HashMap localHashMap = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localHashMap.put(localStringBuilder.toString(), paramTogetherSession);
  }
  
  public void a(int paramInt, BaseActivity paramBaseActivity)
  {
    QQToast.makeText(paramBaseActivity, 1, paramInt, 0).show(paramBaseActivity.getTitleBarHeight());
  }
  
  public void a(int paramInt, TogetherDelegate paramTogetherDelegate)
  {
    this.f.put(paramInt, paramTogetherDelegate);
  }
  
  public void a(Context paramContext, SessionInfo paramSessionInfo, int paramInt)
  {
    int i4 = 0;
    int i3;
    Object localObject;
    if (paramInt != 7)
    {
      i3 = i4;
    }
    else if (paramSessionInfo.a != 1)
    {
      i3 = i4;
      if (paramSessionInfo.a != 0) {}
    }
    else
    {
      int i1;
      if (paramSessionInfo.a == 1) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      int i2 = 0;
      for (;;)
      {
        i3 = i4;
        if (i2 >= this.f.size()) {
          break;
        }
        i3 = this.f.keyAt(i2);
        boolean bool = b(i3, i1, paramSessionInfo.b);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TogetherWatch  isOpen=");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" service=");
        ((StringBuilder)localObject).append(i3);
        QLog.d("TogetherControlManager", 1, ((StringBuilder)localObject).toString());
        if (bool)
        {
          a(i3, i1, paramSessionInfo.b, 1000);
          i3 = i4;
          break;
        }
        i2 += 1;
      }
    }
    while (i3 < this.f.size())
    {
      localObject = (TogetherDelegate)this.f.valueAt(i3);
      if (localObject != null) {
        ((TogetherDelegate)localObject).a(paramContext, paramSessionInfo, paramInt);
      }
      i3 += 1;
    }
  }
  
  public void a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, @javax.annotation.Nullable Bundle paramBundle)
  {
    TogetherDelegate localTogetherDelegate = (TogetherDelegate)this.f.get(paramInt2);
    if (localTogetherDelegate != null)
    {
      if (paramInt2 == 2) {
        if (paramInt3 == 0) {
          a("video_tab", "clk_panelvideo", 0, paramString);
        } else if (paramInt3 == 2) {
          a("video_tab", "clk_setvideo", 0, paramString);
        }
      }
      if (a(paramContext, paramInt2, paramString, paramInt3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlManager", 2, new Object[] { "start serviceType=", Integer.valueOf(paramInt2), " fail because of other together business exist, from=", Integer.valueOf(paramInt3) });
        }
        return;
      }
      c(paramInt2, paramInt1, paramString);
      if (localTogetherDelegate.a(paramContext, paramString, paramInt1, paramInt3, true, a(), paramBundle))
      {
        ((TogetherDelegate)this.f.get(paramInt2)).a(paramContext, paramString, paramInt1, paramInt3, b(paramInt2), paramBundle);
        a(paramContext, paramInt2, 1, paramInt3, a(), paramBundle);
        return;
      }
      paramString = localTogetherDelegate.b();
      if (paramString != null)
      {
        paramString.show();
        return;
      }
      paramContext = new QQCustomDialog(paramContext, 2131953338);
      paramContext.setContentView(2131624611);
      paramString = new StringBuilder();
      paramString.append(HardCodeUtil.a(2131912299));
      paramString.append(((TogetherDelegate)this.f.get(paramInt2)).a());
      paramString.append(HardCodeUtil.a(2131912301));
      paramContext.setTitle(paramString.toString());
      paramString = new StringBuilder();
      paramString.append(HardCodeUtil.a(2131912309));
      paramString.append(((TogetherDelegate)this.f.get(paramInt2)).a());
      paramString.append(HardCodeUtil.a(2131912317));
      paramContext.setMessage(paramString.toString());
      paramContext.setNegativeButton(HardCodeUtil.a(2131899883), new TogetherControlManager.5(this));
      paramContext.show();
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("TogetherDelegate not register! serviceType: ");
    paramContext.append(paramInt2);
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3, Bundle paramBundle)
  {
    if (paramInt3 == 10) {
      a("video_tab", "clk_join_bar", 0, paramString);
    }
    BaseActivity localBaseActivity;
    if (paramBaseActivity == null)
    {
      localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity == null)
      {
        QLog.d("TogetherControlManager", 1, "joinTogetherAndEnter return null activity");
        return;
      }
    }
    else
    {
      localBaseActivity = paramBaseActivity;
    }
    if (!a(localBaseActivity)) {
      return;
    }
    if (paramInt1 == 1)
    {
      ListenTogetherUtils.a(localBaseActivity, paramInt2, paramString, 1, true, paramBundle.getString("song_id", ""));
      return;
    }
    if (paramInt1 == 2)
    {
      if (paramInt2 == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlManager", 2, new Object[] { "join serviceType=", Integer.valueOf(2), " sessionType is error" });
        }
        return;
      }
      a("video_tab", "clk_videoark", 0, paramString);
      if (a(localBaseActivity, paramInt1, paramInt2, paramString, paramInt3, paramBundle)) {
        return;
      }
      if (!a(localBaseActivity, paramInt1, paramInt2, paramString, paramLong, 2131917985)) {
        return;
      }
      paramBundle = ((TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER)).g(paramString);
      paramBaseActivity = (WatchTogetherSession)a(paramInt1, paramInt2, paramString);
      if (paramBundle != null)
      {
        if (paramBaseActivity == null) {
          return;
        }
        paramBundle = TogetherUtils.a(true, paramBundle.isTroopOwner(this.c.getCurrentAccountUin()), paramBundle.isAdmin(), paramBundle.troopowneruin, paramString, paramInt3);
        paramInt1 = paramBaseActivity.u;
        if (paramInt1 != 0)
        {
          if (paramInt1 != 1)
          {
            if (a(localBaseActivity, 2, paramString, paramInt3))
            {
              if (!QLog.isColorLevel()) {
                return;
              }
              QLog.d("TogetherControlManager", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(paramInt3) });
              return;
            }
            a("video_tab", "clk_videoark_suc", 0, paramString);
            TogetherUtils.a(this.c, paramBaseActivity.v, paramBaseActivity.w, null, paramBundle, 1);
            return;
          }
          a("video_tab", "clk_videoark_suc", 0, paramString);
          b(localBaseActivity, paramString, 1, 2, paramInt3, paramBundle);
          return;
        }
        QQToast.makeText(localBaseActivity, 0, 2131890214, 0).show();
      }
    }
    else if (paramInt1 == 4)
    {
      int i1;
      if (paramInt2 == 1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        a("sing_tab", "clk_singark", 0, paramString);
      } else {
        ReportController.b(this.c, "dc00899", "c2c_AIO", "", "sing_tab", "clk_singark", 0, 1, paramString, "", "", "");
      }
      paramBaseActivity = paramString;
      if (!a(localBaseActivity, paramInt1, paramInt2, paramString, paramLong, 2131916688)) {
        return;
      }
      paramBundle = new Bundle();
      String str = this.c.getCurrentAccountUin();
      boolean bool1 = b(paramInt1, paramInt2, paramBaseActivity);
      if (paramInt2 == 1)
      {
        paramBaseActivity = ((TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER)).g(paramBaseActivity);
        if (paramBaseActivity == null) {
          return;
        }
        boolean bool2 = paramBaseActivity.isTroopOwner(str);
        boolean bool3 = paramBaseActivity.isAdmin();
        paramBaseActivity = paramBaseActivity.troopowneruin;
        paramBaseActivity = TogetherUtils.a(bool1, bool2, bool3, paramBaseActivity, paramString, paramInt3);
        paramInt1 = paramInt2;
        paramInt2 = paramInt3;
      }
      else if (paramInt2 == 2)
      {
        paramBaseActivity = TogetherUtils.a(bool1, 9);
        paramInt1 = 2;
        paramInt2 = 9;
      }
      else
      {
        paramBaseActivity = paramBundle;
        paramInt1 = paramInt2;
        paramInt2 = -1;
      }
      b(localBaseActivity, paramString, paramInt1, 4, paramInt2, paramBaseActivity);
    }
  }
  
  public void a(TogetherEntryData paramTogetherEntryData)
  {
    if (this.j == null) {
      this.j = new ConcurrentHashMap(4);
    }
    try
    {
      if (QLog.isColorLevel())
      {
        QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.id=", Integer.valueOf(paramTogetherEntryData.g), "data.isGetFakeData=", Boolean.valueOf(paramTogetherEntryData.n) });
        if (paramTogetherEntryData.n)
        {
          QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.numberOfPeople=", Integer.valueOf(paramTogetherEntryData.o) });
          Iterator localIterator = paramTogetherEntryData.p.iterator();
          while (localIterator.hasNext()) {
            QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.uin=", (String)localIterator.next() });
          }
        }
      }
      if ((paramTogetherEntryData != null) && (paramTogetherEntryData.p != null) && (paramTogetherEntryData.p.size() >= 5))
      {
        int i1 = paramTogetherEntryData.o;
        if (i1 >= 150)
        {
          this.j.put(Integer.valueOf(paramTogetherEntryData.g), paramTogetherEntryData);
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 2, "putFakePanelData error data");
      }
      return;
    }
    catch (Exception paramTogetherEntryData)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData error", paramTogetherEntryData.getMessage() });
      }
    }
  }
  
  public void a(TogetherObserver paramTogetherObserver)
  {
    this.h.remove(paramTogetherObserver);
    this.h.add(paramTogetherObserver);
  }
  
  public void a(TogetherSession paramTogetherSession, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    TogetherDelegate localTogetherDelegate = (TogetherDelegate)this.f.get(paramTogetherSession.l);
    if (localTogetherDelegate != null) {
      localTogetherDelegate.a(paramTogetherSession, paramInt, paramString, paramLong1, paramLong2, paramObject);
    }
  }
  
  public void a(TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).edit();
    String str = paramTroopUnreadMsgInfo.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramTroopUnreadMsgInfo.d);
    localStringBuilder.append("_");
    localStringBuilder.append(paramTroopUnreadMsgInfo.c);
    localEditor.putString(str, localStringBuilder.toString());
    localEditor.apply();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    a(paramTroopUnreadMsgInfo);
    b(paramTroopUnreadMsgInfo);
    a("video_tab", "exp_whitebar", 0, paramTroopUnreadMsgInfo.b);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    QLog.d("TogetherControlManager", 1, new Object[] { "reportTianShu time = ", Long.valueOf(l1), " actionId:", Integer.valueOf(paramInt), " itemId:", paramString2 });
    TianShuReportData localTianShuReportData = new TianShuReportData();
    localTianShuReportData.p = paramInt;
    localTianShuReportData.q = 1;
    localTianShuReportData.h = paramString2;
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append(l1);
    localTianShuReportData.b = paramString2.toString();
    localTianShuReportData.c = 1;
    localTianShuReportData.o = l1;
    localTianShuReportData.f = "tianshu.156";
    localTianShuReportData.g = "tianshu.156";
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    Object localObject = ((TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER)).g(paramString3);
    if (localObject == null) {
      return;
    }
    int i1 = 2;
    if (((TroopInfo)localObject).isAdmin()) {
      i1 = 1;
    }
    if (((TroopInfo)localObject).isTroopOwner(this.c.getCurrentUin())) {
      i1 = 0;
    }
    localObject = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i1);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject, "dc00899", "Grp_AIO", "", paramString1, paramString2, 0, paramInt, paramString3, "", localStringBuilder.toString(), "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 1, new Object[] { "requestEntryBanner size:", Integer.valueOf(this.a.size()) });
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.a = 236;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(localArrayList, this.k);
    if (paramBoolean)
    {
      long l1 = System.currentTimeMillis();
      this.b.edit().putLong("banner_inter", l1).commit();
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 1, new Object[] { "saveBannerInterval ", Long.valueOf(l1) });
      }
    }
  }
  
  public void a(boolean paramBoolean, TogetherSession paramTogetherSession, int paramInt, String paramString)
  {
    ((TogetherOperationHandler)this.c.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).notifyUI(1, paramBoolean, new Object[] { paramTogetherSession, Integer.valueOf(paramInt), paramString });
  }
  
  public boolean a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject;
    if (paramInt1 != 1)
    {
      localObject = ListenTogetherManager.a(this.c);
      if (paramInt2 < 3) {
        paramInt2 = 1;
      } else {
        paramInt2 = 2;
      }
      if (((ListenTogetherManager)localObject).c(paramInt2, paramString))
      {
        QQToast.makeText(paramContext, 1, HardCodeUtil.a(2131912314), 0).show();
        return true;
      }
      if (ListenTogetherManager.a(this.c).e())
      {
        QQToast.makeText(paramContext, 1, HardCodeUtil.a(2131912308), 0).show();
        return true;
      }
    }
    if ((!this.c.isVideoChatting()) && (!QavCameraUsage.b(paramContext)))
    {
      if (this.c.isPttRecordingOrPlaying())
      {
        QQToast.makeText(paramContext, 1, HardCodeUtil.a(2131912305), 1).show();
        return true;
      }
      if (!this.c.isCallIdle())
      {
        QQToast.makeText(paramContext, 1, HardCodeUtil.a(2131912321), 1).show();
        return true;
      }
      localObject = (IAvGameManager)this.c.getRuntimeService(IAvGameManager.class, "");
      if ((localObject != null) && (((IAvGameManager)localObject).isAvGameRoomExist()))
      {
        QQToast.makeText(paramContext, 0, 2131887362, 1).show();
        return true;
      }
      localObject = this.e.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        String[] arrayOfString = str.split("_");
        if ((arrayOfString.length > 0) && (paramInt1 != Integer.parseInt(arrayOfString[0])))
        {
          str = a(paramString, str, arrayOfString);
          if (!TextUtils.isEmpty(str))
          {
            QQToast.makeText(paramContext, 1, str, 0).show();
            return true;
          }
        }
      }
      return false;
    }
    QQToast.makeText(paramContext, 1, HardCodeUtil.a(2131912304), 1).show();
    return true;
  }
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    if (!NetworkUtil.isNetworkAvailable(paramBaseActivity))
    {
      QQToast.makeText(paramBaseActivity, 1, paramBaseActivity.getString(2131892333), 0).show();
      return false;
    }
    return true;
  }
  
  public boolean a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, String paramString, int paramInt3, Bundle paramBundle)
  {
    boolean bool = b(paramInt1, paramInt2, paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" isOpen=");
      localStringBuilder.append(bool);
      QLog.d("TogetherControlManager", 2, new Object[] { "reopenTogetherBusinessWhenClose serviceType=", Integer.valueOf(paramInt1), localStringBuilder.toString() });
    }
    if (bool) {
      return false;
    }
    if (!a(paramInt3, paramBundle)) {
      return false;
    }
    if (a(paramBaseActivity, paramInt1, paramString, paramInt3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 2, "reopenTogetherBusinessWhenClose checkIsOtherBusinessOpen");
      }
      return true;
    }
    if (b(paramInt1, paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 2, "reopenTogetherBusinessWhenClose isSameServiceAndJoinStatus");
      }
      QQToast.makeText(paramBaseActivity, 1, c(String.valueOf(paramInt1)), 0).show(paramBaseActivity.getTitleBarHeight());
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlManager", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of business not open, from=", Integer.valueOf(paramInt3) });
    }
    ((TogetherDelegate)this.f.get(paramInt1)).a(paramBaseActivity, paramString, paramInt2, paramInt3, paramBundle);
    return true;
  }
  
  public TogetherControlManager.CacheHolder b(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(paramInt3);
    String str = ((StringBuilder)localObject).toString();
    localObject = (TogetherControlManager.CacheHolder)this.g.get(str);
    paramString = (String)localObject;
    if (localObject == null)
    {
      paramString = new TogetherControlManager.CacheHolder();
      this.g.put(str, paramString);
    }
    return paramString;
  }
  
  public TogetherControlManager.EntryBannerInfo b()
  {
    if (this.a.size() > 0) {
      return (TogetherControlManager.EntryBannerInfo)this.a.remove(0);
    }
    return null;
  }
  
  @javax.annotation.Nullable
  public HashMap<String, TogetherSession> b(int paramInt)
  {
    if (this.e != null)
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.e.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append("");
        if (str.contains(localStringBuilder.toString())) {
          localHashMap.put(str, this.e.get(str));
        }
      }
      return localHashMap;
    }
    return new HashMap();
  }
  
  public void b(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, @javax.annotation.Nullable Bundle paramBundle)
  {
    TogetherDelegate localTogetherDelegate = (TogetherDelegate)this.f.get(paramInt2);
    if (localTogetherDelegate != null)
    {
      if (paramInt2 == 2) {
        if (paramInt3 == 0) {
          a("video_tab", "clk_panelvideo", 0, paramString);
        } else if (paramInt3 == 2) {
          a("video_tab", "clk_setvideo", 0, paramString);
        }
      }
      if (a(paramContext, paramInt2, paramString, paramInt3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlManager", 2, new Object[] { "start serviceType=", Integer.valueOf(paramInt2), " fail because of other together business exist, from=", Integer.valueOf(paramInt3) });
        }
        return;
      }
      c(paramInt2, paramInt1, paramString);
      if (localTogetherDelegate.a(paramContext, paramString, paramInt1, paramInt3, false, a(), paramBundle))
      {
        ((TogetherDelegate)this.f.get(paramInt2)).b(paramContext, paramString, paramInt1, paramInt3, b(paramInt2), paramBundle);
        a(paramContext, paramInt2, 3, paramInt3, a(), paramBundle);
        return;
      }
      paramString = localTogetherDelegate.b();
      if (paramString != null)
      {
        paramString.show();
        return;
      }
      paramContext = new QQCustomDialog(paramContext, 2131953338);
      paramContext.setContentView(2131624611);
      paramString = new StringBuilder();
      paramString.append(HardCodeUtil.a(2131912313));
      paramString.append(((TogetherDelegate)this.f.get(paramInt2)).a());
      paramString.append(HardCodeUtil.a(2131912303));
      paramContext.setTitle(paramString.toString());
      paramString = new StringBuilder();
      paramString.append(HardCodeUtil.a(2131912300));
      paramString.append(((TogetherDelegate)this.f.get(paramInt2)).a());
      paramString.append(HardCodeUtil.a(2131912310));
      paramContext.setMessage(paramString.toString());
      paramContext.setNegativeButton(HardCodeUtil.a(2131899883), new TogetherControlManager.6(this));
      paramContext.show();
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("TogetherDelegate not register! serviceType: ");
    paramContext.append(paramInt2);
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  public void b(TogetherObserver paramTogetherObserver)
  {
    this.h.remove(paramTogetherObserver);
  }
  
  public void b(TogetherSession paramTogetherSession, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    ((TogetherOperationHandler)this.c.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).notifyUI(0, true, new Object[] { paramTogetherSession, Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramObject });
  }
  
  public void b(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).edit();
    localEditor.remove(paramString);
    localEditor.apply();
  }
  
  public boolean b(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 == 4) {
          return TogetherUtils.a(this.c, paramString, paramInt2, 16777216);
        }
      }
      else if (paramInt2 == 1)
      {
        paramString = ((TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER)).e(paramString);
        if ((paramString != null) && (paramString.isWatchTogetherOpen())) {
          return true;
        }
      }
      return false;
    }
    return ((ListenTogetherManager)this.c.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER)).c(paramInt2, paramString);
  }
  
  public TogetherEntryData c(int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = this.j;
    if (localConcurrentHashMap == null)
    {
      this.j = new ConcurrentHashMap(4);
      return null;
    }
    return (TogetherEntryData)localConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void c()
  {
    ((TogetherOperationHandler)this.c.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).a();
  }
  
  public void c(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    Map localMap = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt3);
    localMap.remove(localStringBuilder.toString());
  }
  
  public String d(int paramInt)
  {
    TogetherDelegate localTogetherDelegate = (TogetherDelegate)this.f.get(paramInt);
    if (localTogetherDelegate == null) {
      return "";
    }
    return localTogetherDelegate.a();
  }
  
  public void d()
  {
    ConcurrentHashMap localConcurrentHashMap = this.j;
    if (localConcurrentHashMap == null)
    {
      this.j = new ConcurrentHashMap(4);
      return;
    }
    localConcurrentHashMap.clear();
  }
  
  public void onDestroy()
  {
    int i1 = 0;
    while (i1 < this.f.size())
    {
      TogetherDelegate localTogetherDelegate = (TogetherDelegate)this.f.valueAt(i1);
      if (localTogetherDelegate != null) {
        localTogetherDelegate.d();
      }
      i1 += 1;
    }
    this.c.removeObserver(this.m);
    this.c.removeObserver(this.l);
    this.c.removeObserver(this.n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherControlManager
 * JD-Core Version:    0.7.0.1
 */