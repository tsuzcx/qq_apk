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
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private final LruCache<String, Long> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private SparseArray<TogetherDelegate> jdField_a_of_type_AndroidUtilSparseArray;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new TogetherControlManager.4(this);
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TianShuGetAdvCallback jdField_a_of_type_ComTencentMobileqqTianshuDataTianShuGetAdvCallback = new TogetherControlManager.1(this);
  private final TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new TogetherControlManager.3(this);
  private final TroopPushObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver = new TogetherControlManager.2(this);
  ArrayList<TogetherControlManager.EntryBannerInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private final HashMap<String, TogetherSession> jdField_a_of_type_JavaUtilHashMap;
  private final Map<String, TogetherControlManager.CacheHolder> jdField_a_of_type_JavaUtilMap;
  private ConcurrentHashMap<Integer, TogetherParser> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ArrayList<TogetherObserver> jdField_b_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<Integer, TogetherEntryData> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public TogetherControlManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(100);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(50);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilMap = new HashMap(50);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(50);
    a(2, new TogetherWatchingDelegate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    a(4, new TogetherSingDelegate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0);
  }
  
  public static TogetherControlManager a(QQAppInterface paramQQAppInterface)
  {
    return (TogetherControlManager)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
  }
  
  private String a(String paramString)
  {
    if (Integer.parseInt(paramString) == 1) {
      return HardCodeUtil.a(2131714818);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131714811));
    localStringBuilder.append(((TogetherDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(paramString))).a());
    localStringBuilder.append(HardCodeUtil.a(2131714823));
    return localStringBuilder.toString();
  }
  
  private String a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString2) != null)
    {
      if ((paramString1.equals(paramArrayOfString[2])) && (3 != ((TogetherSession)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).jdField_h_of_type_Int) && (((TogetherSession)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).jdField_h_of_type_Int != 0)) {
        return a(paramArrayOfString[0]);
      }
      if ((paramString1.equals(paramArrayOfString[2])) && (2 == ((TogetherSession)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).i)) {
        return a(paramArrayOfString[0]);
      }
      if ((!paramString1.equals(paramArrayOfString[2])) && (TogetherWatchFloatingUtil.a(Integer.parseInt(paramArrayOfString[0]), paramArrayOfString[2], Integer.parseInt(paramArrayOfString[1])))) {
        return a(paramArrayOfString[0]);
      }
    }
    return "";
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    if (a(paramInt1, paramInt2, paramString) == null) {
      a(paramInt1, paramInt2, paramString, TogetherUtils.a(paramInt1, paramInt2, paramString));
    }
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, @javax.annotation.Nullable Map<String, TogetherSession> paramMap, @javax.annotation.Nullable Bundle paramBundle)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      TogetherDelegate localTogetherDelegate = (TogetherDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localTogetherDelegate != null) {
        localTogetherDelegate.a(paramContext, paramInt1, paramInt2, paramInt3, paramMap, paramBundle);
      }
      i += 1;
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
  
  private boolean a(int paramInt, String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      String[] arrayOfString = ((String)localObject).split("_");
      localObject = (TogetherSession)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if ((arrayOfString.length > 0) && (localObject != null) && (!paramString.equals(arrayOfString[2])) && (2 == ((TogetherSession)localObject).i) && (paramInt == Integer.parseInt(arrayOfString[0]))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3)
  {
    boolean bool = a(paramInt1, paramInt2, paramString);
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
    if ((paramString != null) && (paramString.jdField_h_of_type_Int != 3))
    {
      if ((paramString.d != paramLong) && (paramLong != 0L))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(" session.identifyId=");
          localStringBuilder.append(paramString.d);
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
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((TogetherObserver)localIterator.next()).onUpdate(2, true, paramTroopUnreadMsgInfo);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(2), new WatchTogetherParser(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(4), new SingTogetherParser(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public int a(int paramInt, String paramString)
  {
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return 0;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      int j = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      TogetherDelegate localTogetherDelegate = (TogetherDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localTogetherDelegate != null) && (a(j, paramInt, paramString))) {
        return localTogetherDelegate.a();
      }
      i += 1;
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
    localObject = (Long)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localObject);
    if (localObject == null) {
      return 0L;
    }
    return ((Long)localObject).longValue();
  }
  
  public TogetherControlManager.CacheHolder a(int paramInt1, int paramInt2, String paramString, int paramInt3)
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
    localObject = (TogetherControlManager.CacheHolder)this.jdField_a_of_type_JavaUtilMap.get(str);
    paramString = (String)localObject;
    if (localObject == null)
    {
      paramString = new TogetherControlManager.CacheHolder();
      this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
    }
    return paramString;
  }
  
  public TogetherControlManager.EntryBannerInfo a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (TogetherControlManager.EntryBannerInfo)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    }
    return null;
  }
  
  public TogetherEntryData a(int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap == null)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
      return null;
    }
    return (TogetherEntryData)localConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public <T extends TogetherParser> T a(int paramInt)
  {
    TogetherParser localTogetherParser2 = (TogetherParser)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    TogetherParser localTogetherParser1 = localTogetherParser2;
    if (localTogetherParser2 == null) {
      localTogetherParser1 = null;
    }
    return localTogetherParser1;
  }
  
  public <T extends TogetherSession> T a(int paramInt1, int paramInt2, String paramString)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
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
      localTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString = paramString;
      localTroopUnreadMsgInfo.b = Integer.valueOf(localObject[0]).intValue();
      localTroopUnreadMsgInfo.jdField_a_of_type_Int = Integer.valueOf(localObject[1]).intValue();
      return localTroopUnreadMsgInfo;
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    TogetherDelegate localTogetherDelegate = (TogetherDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localTogetherDelegate == null) {
      return "";
    }
    return localTogetherDelegate.a();
  }
  
  @javax.annotation.Nullable
  public HashMap<String, TogetherSession> a()
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      return (HashMap)localHashMap.clone();
    }
    return new HashMap();
  }
  
  @javax.annotation.Nullable
  public HashMap<String, TogetherSession> a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append("");
        if (str.contains(localStringBuilder.toString())) {
          localHashMap.put(str, this.jdField_a_of_type_JavaUtilHashMap.get(str));
        }
      }
      return localHashMap;
    }
    return new HashMap();
  }
  
  public void a()
  {
    ((TogetherOperationHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).a();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    ((TogetherOperationHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).a(paramInt1, paramInt2, paramString, paramInt3);
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
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, Long.valueOf(paramLong));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, TogetherSession paramTogetherSession)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
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
    QQToast.a(paramBaseActivity, 1, paramInt, 0).b(paramBaseActivity.getTitleBarHeight());
  }
  
  public void a(int paramInt, TogetherDelegate paramTogetherDelegate)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramTogetherDelegate);
  }
  
  public void a(Context paramContext, SessionInfo paramSessionInfo, int paramInt)
  {
    int m = 0;
    int k;
    Object localObject;
    if (paramInt != 7)
    {
      k = m;
    }
    else if (paramSessionInfo.jdField_a_of_type_Int != 1)
    {
      k = m;
      if (paramSessionInfo.jdField_a_of_type_Int != 0) {}
    }
    else
    {
      int i;
      if (paramSessionInfo.jdField_a_of_type_Int == 1) {
        i = 1;
      } else {
        i = 2;
      }
      int j = 0;
      for (;;)
      {
        k = m;
        if (j >= this.jdField_a_of_type_AndroidUtilSparseArray.size()) {
          break;
        }
        k = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(j);
        boolean bool = a(k, i, paramSessionInfo.jdField_a_of_type_JavaLangString);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TogetherWatch  isOpen=");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" service=");
        ((StringBuilder)localObject).append(k);
        QLog.d("TogetherControlManager", 1, ((StringBuilder)localObject).toString());
        if (bool)
        {
          a(k, i, paramSessionInfo.jdField_a_of_type_JavaLangString, 1000);
          k = m;
          break;
        }
        j += 1;
      }
    }
    while (k < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localObject = (TogetherDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k);
      if (localObject != null) {
        ((TogetherDelegate)localObject).a(paramContext, paramSessionInfo, paramInt);
      }
      k += 1;
    }
  }
  
  public void a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, @javax.annotation.Nullable Bundle paramBundle)
  {
    TogetherDelegate localTogetherDelegate = (TogetherDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
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
      a(paramInt2, paramInt1, paramString);
      if (localTogetherDelegate.a(paramContext, paramString, paramInt1, paramInt3, true, a(), paramBundle))
      {
        ((TogetherDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a(paramContext, paramString, paramInt1, paramInt3, a(paramInt2), paramBundle);
        a(paramContext, paramInt2, 1, paramInt3, a(), paramBundle);
        return;
      }
      paramString = localTogetherDelegate.a();
      if (paramString != null)
      {
        paramString.show();
        return;
      }
      paramContext = new QQCustomDialog(paramContext, 2131756189);
      paramContext.setContentView(2131558978);
      paramString = new StringBuilder();
      paramString.append(HardCodeUtil.a(2131714796));
      paramString.append(((TogetherDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a());
      paramString.append(HardCodeUtil.a(2131714798));
      paramContext.setTitle(paramString.toString());
      paramString = new StringBuilder();
      paramString.append(HardCodeUtil.a(2131714807));
      paramString.append(((TogetherDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a());
      paramString.append(HardCodeUtil.a(2131714816));
      paramContext.setMessage(paramString.toString());
      paramContext.setNegativeButton(HardCodeUtil.a(2131714808), new TogetherControlManager.5(this));
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
      if (!a(localBaseActivity, paramInt1, paramInt2, paramString, paramLong, 2131720348)) {
        return;
      }
      paramBundle = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
      paramBaseActivity = (WatchTogetherSession)a(paramInt1, paramInt2, paramString);
      if (paramBundle != null)
      {
        if (paramBaseActivity == null) {
          return;
        }
        paramBundle = TogetherUtils.a(true, paramBundle.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), paramBundle.isAdmin(), paramBundle.troopowneruin, paramString, paramInt3);
        paramInt1 = paramBaseActivity.j;
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
            TogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseActivity.k, paramBaseActivity.jdField_h_of_type_JavaLangString, null, paramBundle, 1);
            return;
          }
          a("video_tab", "clk_videoark_suc", 0, paramString);
          b(localBaseActivity, paramString, 1, 2, paramInt3, paramBundle);
          return;
        }
        QQToast.a(localBaseActivity, 0, 2131693100, 0).a();
      }
    }
    else if (paramInt1 == 4)
    {
      int i;
      if (paramInt2 == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        a("sing_tab", "clk_singark", 0, paramString);
      } else {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "c2c_AIO", "", "sing_tab", "clk_singark", 0, 1, paramString, "", "", "");
      }
      paramBaseActivity = paramString;
      if (!a(localBaseActivity, paramInt1, paramInt2, paramString, paramLong, 2131719152)) {
        return;
      }
      paramBundle = new Bundle();
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      boolean bool1 = a(paramInt1, paramInt2, paramBaseActivity);
      if (paramInt2 == 1)
      {
        paramBaseActivity = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramBaseActivity);
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
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
    }
    try
    {
      if (QLog.isColorLevel())
      {
        QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.id=", Integer.valueOf(paramTogetherEntryData.b), "data.isGetFakeData=", Boolean.valueOf(paramTogetherEntryData.jdField_a_of_type_Boolean) });
        if (paramTogetherEntryData.jdField_a_of_type_Boolean)
        {
          QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.numberOfPeople=", Integer.valueOf(paramTogetherEntryData.f) });
          Iterator localIterator = paramTogetherEntryData.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext()) {
            QLog.d("TogetherControlManager", 2, new Object[] { "putFakePanelData, data.uin=", (String)localIterator.next() });
          }
        }
      }
      if ((paramTogetherEntryData != null) && (paramTogetherEntryData.jdField_a_of_type_JavaUtilArrayList != null) && (paramTogetherEntryData.jdField_a_of_type_JavaUtilArrayList.size() >= 5))
      {
        int i = paramTogetherEntryData.f;
        if (i >= 150)
        {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramTogetherEntryData.b), paramTogetherEntryData);
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
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramTogetherObserver);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramTogetherObserver);
  }
  
  public void a(TogetherSession paramTogetherSession, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    TogetherDelegate localTogetherDelegate = (TogetherDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramTogetherSession.jdField_e_of_type_Int);
    if (localTogetherDelegate != null) {
      localTogetherDelegate.a(paramTogetherSession, paramInt, paramString, paramLong1, paramLong2, paramObject);
    }
  }
  
  public void a(TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).edit();
    String str = paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramTroopUnreadMsgInfo.b);
    localStringBuilder.append("_");
    localStringBuilder.append(paramTroopUnreadMsgInfo.jdField_a_of_type_Int);
    localEditor.putString(str, localStringBuilder.toString());
    localEditor.apply();
  }
  
  public void a(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("togethers_sp", 0).edit();
    localEditor.remove(paramString);
    localEditor.apply();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    a(paramTroopUnreadMsgInfo);
    b(paramTroopUnreadMsgInfo);
    a("video_tab", "exp_whitebar", 0, paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    QLog.d("TogetherControlManager", 1, new Object[] { "reportTianShu time = ", Long.valueOf(l), " actionId:", Integer.valueOf(paramInt), " itemId:", paramString2 });
    TianShuReportData localTianShuReportData = new TianShuReportData();
    localTianShuReportData.d = paramInt;
    localTianShuReportData.jdField_e_of_type_Int = 1;
    localTianShuReportData.g = paramString2;
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append(l);
    localTianShuReportData.b = paramString2.toString();
    localTianShuReportData.jdField_a_of_type_Int = 1;
    localTianShuReportData.jdField_a_of_type_Long = l;
    localTianShuReportData.jdField_e_of_type_JavaLangString = "tianshu.156";
    localTianShuReportData.f = "tianshu.156";
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString3);
    if (localObject == null) {
      return;
    }
    int i = 2;
    if (((TroopInfo)localObject).isAdmin()) {
      i = 1;
    }
    if (((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) {
      i = 0;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject, "dc00899", "Grp_AIO", "", paramString1, paramString2, 0, paramInt, paramString3, "", localStringBuilder.toString(), "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 1, new Object[] { "requestEntryBanner size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) });
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.jdField_a_of_type_Int = 236;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(localArrayList, this.jdField_a_of_type_ComTencentMobileqqTianshuDataTianShuGetAdvCallback);
    if (paramBoolean)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("banner_inter", l).commit();
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 1, new Object[] { "saveBannerInterval ", Long.valueOf(l) });
      }
    }
  }
  
  public void a(boolean paramBoolean, TogetherSession paramTogetherSession, int paramInt, String paramString)
  {
    ((TogetherOperationHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).notifyUI(1, paramBoolean, new Object[] { paramTogetherSession, Integer.valueOf(paramInt), paramString });
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 == 4) {
          return TogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt2, 16777216);
        }
      }
      else if (paramInt2 == 1)
      {
        paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString);
        if ((paramString != null) && (paramString.isWatchTogetherOpen())) {
          return true;
        }
      }
      return false;
    }
    return ((ListenTogetherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER)).a(paramInt2, paramString);
  }
  
  public boolean a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject;
    if (paramInt1 != 1)
    {
      localObject = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramInt2 < 3) {
        paramInt2 = 1;
      } else {
        paramInt2 = 2;
      }
      if (((ListenTogetherManager)localObject).a(paramInt2, paramString))
      {
        QQToast.a(paramContext, 1, HardCodeUtil.a(2131714813), 0).a();
        return true;
      }
      if (ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a())
      {
        QQToast.a(paramContext, 1, HardCodeUtil.a(2131714806), 0).a();
        return true;
      }
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) && (!QavCameraUsage.b(paramContext)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isPttRecordingOrPlaying())
      {
        QQToast.a(paramContext, 1, HardCodeUtil.a(2131714802), 1).a();
        return true;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCallIdle())
      {
        QQToast.a(paramContext, 1, HardCodeUtil.a(2131714820), 1).a();
        return true;
      }
      localObject = (IAvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IAvGameManager.class, "");
      if ((localObject != null) && (((IAvGameManager)localObject).isAvGameRoomExist()))
      {
        QQToast.a(paramContext, 0, 2131690451, 1).a();
        return true;
      }
      localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        String[] arrayOfString = str.split("_");
        if ((arrayOfString.length > 0) && (paramInt1 != Integer.parseInt(arrayOfString[0])))
        {
          str = a(paramString, str, arrayOfString);
          if (!TextUtils.isEmpty(str))
          {
            QQToast.a(paramContext, 1, str, 0).a();
            return true;
          }
        }
      }
      return false;
    }
    QQToast.a(paramContext, 1, HardCodeUtil.a(2131714801), 1).a();
    return true;
  }
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    if (!NetworkUtil.isNetworkAvailable(paramBaseActivity))
    {
      QQToast.a(paramBaseActivity, 1, paramBaseActivity.getString(2131694647), 0).a();
      return false;
    }
    return true;
  }
  
  public boolean a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, String paramString, int paramInt3, Bundle paramBundle)
  {
    boolean bool = a(paramInt1, paramInt2, paramString);
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
    if (a(paramInt1, paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlManager", 2, "reopenTogetherBusinessWhenClose isSameServiceAndJoinStatus");
      }
      QQToast.a(paramBaseActivity, 1, a(String.valueOf(paramInt1)), 0).b(paramBaseActivity.getTitleBarHeight());
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlManager", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of business not open, from=", Integer.valueOf(paramInt3) });
    }
    ((TogetherDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1)).a(paramBaseActivity, paramString, paramInt2, paramInt3, paramBundle);
    return true;
  }
  
  public void b()
  {
    ConcurrentHashMap localConcurrentHashMap = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap == null)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
      return;
    }
    localConcurrentHashMap.clear();
  }
  
  public void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
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
  
  public void b(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, @javax.annotation.Nullable Bundle paramBundle)
  {
    TogetherDelegate localTogetherDelegate = (TogetherDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
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
      a(paramInt2, paramInt1, paramString);
      if (localTogetherDelegate.a(paramContext, paramString, paramInt1, paramInt3, false, a(), paramBundle))
      {
        ((TogetherDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).b(paramContext, paramString, paramInt1, paramInt3, a(paramInt2), paramBundle);
        a(paramContext, paramInt2, 3, paramInt3, a(), paramBundle);
        return;
      }
      paramString = localTogetherDelegate.a();
      if (paramString != null)
      {
        paramString.show();
        return;
      }
      paramContext = new QQCustomDialog(paramContext, 2131756189);
      paramContext.setContentView(2131558978);
      paramString = new StringBuilder();
      paramString.append(HardCodeUtil.a(2131714812));
      paramString.append(((TogetherDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a());
      paramString.append(HardCodeUtil.a(2131714800));
      paramContext.setTitle(paramString.toString());
      paramString = new StringBuilder();
      paramString.append(HardCodeUtil.a(2131714797));
      paramString.append(((TogetherDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2)).a());
      paramString.append(HardCodeUtil.a(2131714809));
      paramContext.setMessage(paramString.toString());
      paramContext.setNegativeButton(HardCodeUtil.a(2131714803), new TogetherControlManager.6(this));
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
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramTogetherObserver);
  }
  
  public void b(TogetherSession paramTogetherSession, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject)
  {
    ((TogetherOperationHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).notifyUI(0, true, new Object[] { paramTogetherSession, Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramObject });
  }
  
  public void onDestroy()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      TogetherDelegate localTogetherDelegate = (TogetherDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localTogetherDelegate != null) {
        localTogetherDelegate.a();
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherControlManager
 * JD-Core Version:    0.7.0.1
 */