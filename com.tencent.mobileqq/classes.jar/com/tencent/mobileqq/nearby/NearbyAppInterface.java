package com.tencent.mobileqq.nearby;

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
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.nearby.ipc.NearbyProcObserver;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
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

public class NearbyAppInterface
  extends BaseToolAppInterface
  implements IToolProcEventListener
{
  public static boolean a;
  public static boolean b;
  public int a;
  public long a;
  public UserDetailLocalInfo a;
  NearbyAppInterface.MyNetInfoHandler jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface$MyNetInfoHandler = null;
  NearbyEntityManagerFactory jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory;
  public NearbyService a;
  NearbyMyTabCard jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
  Object jdField_a_of_type_JavaLangObject = new Object();
  String jdField_a_of_type_JavaLangString = null;
  Map<Integer, Manager> jdField_a_of_type_JavaUtilMap = new HashMap(20);
  public oidb_0x8dd.SelfInfo a;
  int jdField_b_of_type_Int = -2147483648;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  int c;
  public boolean c;
  int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean = false;
  boolean e = false;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
  }
  
  public NearbyAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_EncounterSvcUserDetailLocalInfo = null;
    this.jdField_c_of_type_Int = 0;
  }
  
  /* Error */
  private String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +13 -> 14
    //   4: aload 4
    //   6: ifnull +8 -> 14
    //   9: aload 5
    //   11: ifnonnull +6 -> 17
    //   14: ldc 85
    //   16: areturn
    //   17: aload_1
    //   18: ldc 87
    //   20: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifeq +13 -> 36
    //   26: aload_2
    //   27: invokevirtual 97	java/lang/String:length	()I
    //   30: ifle +6 -> 36
    //   33: ldc 99
    //   35: areturn
    //   36: aload_1
    //   37: ldc 87
    //   39: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifeq +31 -> 73
    //   45: aload 8
    //   47: invokestatic 105	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne +9 -> 59
    //   53: aload 8
    //   55: invokestatic 111	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   58: pop2
    //   59: aload 9
    //   61: invokestatic 105	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +9 -> 73
    //   67: aload 9
    //   69: invokestatic 111	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   72: pop2
    //   73: aconst_null
    //   74: areturn
    //   75: astore_1
    //   76: ldc 113
    //   78: areturn
    //   79: astore_1
    //   80: ldc 115
    //   82: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	NearbyAppInterface
    //   0	83	1	paramString1	String
    //   0	83	2	paramString2	String
    //   0	83	3	paramString3	String
    //   0	83	4	paramString4	String
    //   0	83	5	paramString5	String
    //   0	83	6	paramInt1	int
    //   0	83	7	paramInt2	int
    //   0	83	8	paramString6	String
    //   0	83	9	paramString7	String
    //   0	83	10	paramString8	String
    //   0	83	11	paramString9	String
    // Exception table:
    //   from	to	target	type
    //   53	59	75	java/lang/Exception
    //   67	73	79	java/lang/Exception
  }
  
  public static void b()
  {
    if (GlobalImageCache.a != null)
    {
      int i = GlobalImageCache.a.size() * 3 / 4;
      GlobalImageCache.a.trimToSize(i);
    }
  }
  
  public NearbyProcManager a()
  {
    return (NearbyProcManager)getManager(NearbyConstants.e);
  }
  
  public NearbyMyTabCard a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard;
  }
  
  public void a()
  {
    NearbyMyTabCard localNearbyMyTabCard = b();
    if (localNearbyMyTabCard != null)
    {
      localNearbyMyTabCard.visitors.clear();
      NearbyMineHelper.a(this, localNearbyMyTabCard);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    NearbySPUtil.a(getAccount(), "sp_nearby_mytab", 0, "key_nearby_mytab_zan_check", Integer.valueOf(this.jdField_b_of_type_Int));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("updatePerfState", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.jdField_c_of_type_Int) });
    }
    if (paramInt1 > this.jdField_c_of_type_Int)
    {
      this.jdField_c_of_type_Int = paramInt1;
      if (this.jdField_c_of_type_Int == 1)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_d_of_type_Int = paramInt2;
      }
    }
  }
  
  public void a(NearbyProcObserver paramNearbyProcObserver)
  {
    NearbyProcManager localNearbyProcManager = (NearbyProcManager)getManager(NearbyConstants.e);
    if (localNearbyProcManager != null) {
      localNearbyProcManager.a(paramNearbyProcObserver);
    }
  }
  
  public void a(NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard != paramNearbyMyTabCard) {
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard = paramNearbyMyTabCard;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    String str = a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    if (!TextUtils.isEmpty(str)) {
      throw new IllegalArgumentException(str);
    }
    ThreadManager.post(new NearbyAppInterface.3(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9), 2, null, false);
  }
  
  public void a(oidb_0x8dd.SelfInfo paramSelfInfo)
  {
    if (paramSelfInfo == null) {
      return;
    }
    this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo = paramSelfInfo;
    if (paramSelfInfo.uint64_tinyid.get() != 0L) {
      NearbySPUtil.a(getAccount(), "self_tinnyid", Long.valueOf(paramSelfInfo.uint64_tinyid.get()));
    }
    if (!TextUtils.isEmpty(paramSelfInfo.bytes_nick.get().toStringUtf8())) {
      NearbySPUtil.a(getAccount(), "self_nick", paramSelfInfo.bytes_nick.get().toStringUtf8());
    }
    if (!TextUtils.isEmpty(paramSelfInfo.str_third_line_info.get())) {
      NearbySPUtil.a(getAccount(), "self_third_line_info", paramSelfInfo.str_third_line_info.get());
    }
    if (!TextUtils.isEmpty(paramSelfInfo.str_third_line_icon.get())) {
      NearbySPUtil.a(getAccount(), "self_third_line_icon", paramSelfInfo.str_third_line_icon.get());
    }
    if (paramSelfInfo.uint32_age.get() != -1) {
      NearbySPUtil.a(getAccount(), "self_age", Integer.valueOf(paramSelfInfo.uint32_age.get()));
    }
    int i;
    if (paramSelfInfo.uint32_gender.get() != -1) {
      switch (paramSelfInfo.uint32_gender.get())
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      NearbySPUtil.a(getAccount(), "self_gender", Integer.valueOf(i));
      a().a(paramSelfInfo);
      return;
      i = 1;
      continue;
      i = 2;
    }
  }
  
  public void addManager(int paramInt, Manager paramManager)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramManager);
  }
  
  public NearbyMyTabCard b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard == null) {
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard = NearbyMineHelper.a(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard;
  }
  
  public void b(NearbyProcObserver paramNearbyProcObserver)
  {
    NearbyProcManager localNearbyProcManager = (NearbyProcManager)getManager(NearbyConstants.e);
    if (localNearbyProcManager != null) {
      localNearbyProcManager.b(paramNearbyProcObserver);
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    String str = a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    if (!TextUtils.isEmpty(str)) {
      throw new IllegalArgumentException(str);
    }
    a().a(false, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  @TargetApi(14)
  public void c()
  {
    try
    {
      AccessibilityManager localAccessibilityManager = (AccessibilityManager)this.app.getSystemService("accessibility");
      boolean bool1 = localAccessibilityManager.isEnabled();
      boolean bool2 = localAccessibilityManager.isTouchExplorationEnabled();
      if ((bool1) && (bool2)) {}
      for (bool1 = true;; bool1 = false)
      {
        AppSetting.jdField_d_of_type_Boolean = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("NearbyAppInterface", 2, "set talkback enable: " + AppSetting.jdField_d_of_type_Boolean);
        }
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected void finalize()
  {
    super.finalize();
    NearbyEntityManagerFactory localNearbyEntityManagerFactory = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory;
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
    if (this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo == null) {
      return getAccount();
    }
    return this.jdField_a_of_type_TencentImOidbCmd0x8ddOidb_0x8dd$SelfInfo.bytes_nick.get().toStringUtf8();
  }
  
  public EntityManagerFactory getEntityManagerFactory()
  {
    return getEntityManagerFactory(getAccount());
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(getAccount()))) {
      throw new IllegalStateException("Can not create a entity factory, the account is not match." + paramString + "!=" + getAccount());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory != null) {
      return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory;
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory = new NearbyEntityManagerFactory(paramString);
        ThreadManager.getSubThreadHandler().postDelayed(new NearbyAppInterface.1(this), 1000L);
      }
      return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory;
    }
  }
  
  public Manager getManager(int paramInt)
  {
    Object localObject1 = (Manager)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    Object localObject3;
    if (localObject1 == null)
    {
      Map localMap = this.jdField_a_of_type_JavaUtilMap;
      if (paramInt == 0) {}
      for (;;)
      {
        Object localObject4;
        try
        {
          localObject1 = new AccountManagerImpl(this);
          if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) == null) {
            break label308;
          }
          localObject4 = (Manager)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
          return localObject4;
        }
        finally {}
        if (paramInt == 1)
        {
          localObject1 = new WtloginManagerImpl(this);
        }
        else if (paramInt == 2)
        {
          localObject3 = new TicketManagerImpl(this);
        }
        else if (paramInt == 3)
        {
          localObject3 = new ProxyIpManagerImpl(this);
        }
        else if (paramInt == NearbyConstants.jdField_b_of_type_Int)
        {
          localObject3 = new NearbyDataManager(this);
        }
        else if (paramInt == NearbyConstants.jdField_c_of_type_Int)
        {
          localObject3 = new NetEngineFactory();
        }
        else if (paramInt == NearbyConstants.e)
        {
          localObject3 = new NearbyProcManager(this);
        }
        else if (paramInt == NearbyConstants.g)
        {
          localObject3 = new OldBigDataChannelManager(this);
        }
        else if (paramInt == NearbyConstants.h)
        {
          localObject3 = new NearbyReportManager(this);
        }
        else if (paramInt == NearbyConstants.i)
        {
          localObject3 = new NearbyFaceScoreManager(this);
        }
        else if (paramInt == NearbyConstants.j)
        {
          localObject3 = new UsingTimeReportManager(this);
        }
        else if (paramInt == NearbyConstants.k)
        {
          localObject3 = new DownloaderFactory(this);
        }
        else if (paramInt == QQManagerFactory.DYNAMIC_AVATAR_MANAGER)
        {
          localObject3 = new DynamicAvatarManager(this);
          continue;
          label308:
          localObject4 = localObject3;
          if (localObject3 != null)
          {
            this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject3);
            localObject4 = localObject3;
          }
        }
      }
    }
    return localObject3;
  }
  
  public MobileQQServiceBase getMobileQQService()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyService;
  }
  
  public String getModuleId()
  {
    return "module_nearby";
  }
  
  public void onBeforeExitProc() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyService = new NearbyService(this);
    ((NearbyProcManager)getManager(NearbyConstants.e)).a();
    ThreadManager.post(new NearbyAppInterface.2(this), 8, null, true);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mHwEngine != null) {
      this.mHwEngine.closeEngine();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        boolean bool = this.jdField_d_of_type_Boolean;
        if (bool) {
          try
          {
            ((IDPCApi)QRoute.api(IDPCApi.class)).unRegisterBroadCast(this);
            synchronized (this.jdField_a_of_type_JavaUtilMap)
            {
              Object localObject2 = this.jdField_a_of_type_JavaUtilMap.keySet();
              if ((localObject2 == null) || (((Set)localObject2).size() <= 0)) {
                break;
              }
              localObject2 = ((Set)localObject2).iterator();
              bool = ((Iterator)localObject2).hasNext();
              if (!bool) {
                break;
              }
              try
              {
                Manager localManager = (Manager)this.jdField_a_of_type_JavaUtilMap.get(((Iterator)localObject2).next());
                if (localManager == null) {
                  continue;
                }
                localManager.onDestroy();
              }
              catch (Exception localException2)
              {
                localException2.printStackTrace();
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
              NearbyUtils.a("NearbyAppInterface", new Object[] { "onDestroy", localException2.toString() });
            }
          }
          catch (Exception localException1)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("NearbyAppInterface", 2, "onDestroy: ", localException1);
            continue;
          }
        }
      }
      this.jdField_d_of_type_Boolean = true;
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
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
  
  public void start(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface$MyNetInfoHandler = new NearbyAppInterface.MyNetInfoHandler(this, null);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface$MyNetInfoHandler);
    super.start(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyAppInterface
 * JD-Core Version:    0.7.0.1
 */