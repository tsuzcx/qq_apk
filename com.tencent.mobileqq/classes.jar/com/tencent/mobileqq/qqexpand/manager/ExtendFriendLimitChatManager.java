package com.tencent.mobileqq.qqexpand.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qqexpand.bean.match.MatchFeedInfo;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.bean.match.TagInfo;
import com.tencent.mobileqq.qqexpand.match.LimitChatProtoStateMachine;
import com.tencent.mobileqq.qqexpand.match.LimitChatProtoStateMachine.LimitChatMachineListener;
import com.tencent.mobileqq.qqexpand.match.LimitChatUiStateMachine;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class ExtendFriendLimitChatManager
  implements IExpandLimitChatManager, Manager
{
  static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  protected SharedPreferences a;
  private final LruCache<String, ExpandFriendData> jdField_a_of_type_AndroidUtilLruCache = new LruCache(50);
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private MatchInfo jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo;
  public LimitChatProtoStateMachine.LimitChatMachineListener a;
  LimitChatProtoStateMachine jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine;
  LimitChatUiStateMachine jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine;
  private final ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new ExtendFriendLimitChatManager.2(this);
  public String a;
  private WeakReference<ExtendFriendLimitChatManager.LimitChatMatchListener> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private String d;
  
  public ExtendFriendLimitChatManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine$LimitChatMachineListener = new ExtendFriendLimitChatManager.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ExtendFriendLimitChatManager", 2, "getMatchSexTypeFromSp with null app");
      return 0;
    }
    Object localObject = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramQQAppInterface.getCurrentAccountUin());
    int i;
    if (localObject == null)
    {
      QLog.i("ExtendFriendLimitChatManager", 2, "获取自己的资料卡性别，缓存中未获取到，使用默认值随机");
      i = 0;
    }
    else
    {
      int j = ((Card)localObject).shGender;
      i = 1;
      if (j == 0) {
        i = 2;
      } else if (((Card)localObject).shGender != 1) {
        i = 0;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("获取自己的资料卡性别，defaultSex:");
      ((StringBuilder)localObject).append(i);
      QLog.i("ExtendFriendLimitChatManager", 2, ((StringBuilder)localObject).toString());
    }
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("sp_match_sex_type", i);
  }
  
  public static Boolean a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramBaseQQAppInterface == null)
    {
      QLog.e("ExtendFriendLimitChatManager", 2, "getMatchSwitchFlagFromSp with null app");
      return Boolean.valueOf(false);
    }
    paramBaseQQAppInterface = Boolean.valueOf(paramBaseQQAppInterface.getApp().getSharedPreferences(paramBaseQQAppInterface.getCurrentAccountUin(), 0).getBoolean("sp_voice_match_switch_flag", false));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getVoiceMatch ");
    localStringBuilder.append(paramBaseQQAppInterface);
    QLog.d("ExtendFriendLimitChatManager", 2, localStringBuilder.toString());
    return paramBaseQQAppInterface;
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getMatchSexTypeFromSp : ");
    localStringBuilder.append(paramInt);
    QLog.i("ExtendFriendLimitChatManager", 2, localStringBuilder.toString());
    if (paramBaseQQAppInterface == null)
    {
      QLog.e("ExtendFriendLimitChatManager", 2, "setMatchSexTypeToSp with null app");
      return;
    }
    paramBaseQQAppInterface = paramBaseQQAppInterface.getApp().getSharedPreferences(paramBaseQQAppInterface.getCurrentAccountUin(), 0).edit();
    if (paramBaseQQAppInterface != null) {
      paramBaseQQAppInterface.putInt("sp_match_sex_type", paramInt).apply();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Boolean paramBoolean)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ExtendFriendLimitChatManager", 2, "setMatchSwitchToSp with null app");
      return;
    }
    paramQQAppInterface = SharedPreUtils.g(paramQQAppInterface.getCurrentAccountUin()).edit();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.putBoolean("sp_match_switch_type", paramBoolean.booleanValue()).apply();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ArrayList<TagInfo> paramArrayList)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ExtendFriendLimitChatManager", 2, "setTaglistToSp with null app");
      return;
    }
    paramArrayList = TagInfo.a(paramArrayList);
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    if ((paramArrayList != null) && (paramQQAppInterface != null)) {
      paramQQAppInterface.putString("sp_tagList", paramArrayList).apply();
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Boolean paramBoolean)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ExtendFriendLimitChatManager", 2, "setVoiceMatchSwitchFlagToSp with null app");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVoiceMatch ");
    localStringBuilder.append(paramBoolean);
    QLog.d("ExtendFriendLimitChatManager", 2, localStringBuilder.toString());
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.putBoolean("sp_voice_match_switch_flag", paramBoolean.booleanValue()).apply();
    }
  }
  
  private void e()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject1 == null) {
      return;
    }
    try
    {
      localObject1 = ((QQAppInterface)localObject1).getProxyManager().a();
      Object localObject3 = ((RecentUserProxy)localObject1).a(false);
      Object localObject2 = new ArrayList();
      if ((localObject3 != null) && (((List)localObject3).size() > 0))
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
          if ((localRecentUser.getType() == 1044) && (!localRecentUser.uin.equals(AppConstants.MATCH_CHAT_UIN))) {
            ((List)localObject2).add(localRecentUser);
          }
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[initLimitChatBox] toBeRemoved.size:");
        ((StringBuilder)localObject3).append(((List)localObject2).size());
        QLog.i("ExtendFriendLimitChatManager", 1, ((StringBuilder)localObject3).toString());
      }
      if (((List)localObject2).size() > 0)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((RecentUserProxy)localObject1).a((RecentUser)((Iterator)localObject2).next());
        }
      }
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("init_matchchat_folder", false).commit();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ExtendFriendLimitChatManager", 1, localThrowable, new Object[0]);
    }
  }
  
  public int a()
  {
    return a().a();
  }
  
  public ExpandFriendData a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    Object localObject1 = localObject2;
    if (localEntityManager != null)
    {
      localObject1 = localObject2;
      if (localEntityManager.isOpen()) {
        localObject1 = (ExpandFriendData)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(ExpandFriendData.class, paramString);
      }
    }
    return localObject1;
  }
  
  public ExpandFriendData a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("ExtendFriendLimitChatManager", 1, "getExpandFriendDataCache but uin is empty");
      return null;
    }
    ExpandFriendData localExpandFriendData2 = (ExpandFriendData)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
    ExpandFriendData localExpandFriendData1 = localExpandFriendData2;
    if (localExpandFriendData2 == null)
    {
      localExpandFriendData1 = localExpandFriendData2;
      if (paramBoolean)
      {
        localExpandFriendData2 = a(paramString);
        localExpandFriendData1 = localExpandFriendData2;
        if (localExpandFriendData2 != null)
        {
          this.jdField_a_of_type_AndroidUtilLruCache.put(paramString, localExpandFriendData2);
          localExpandFriendData1 = localExpandFriendData2;
        }
      }
    }
    return localExpandFriendData1;
  }
  
  public LimitChatProtoStateMachine a()
  {
    ??? = this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine;
    if (??? != null) {
      return ???;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine != null)
      {
        localLimitChatProtoStateMachine = this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine;
        return localLimitChatProtoStateMachine;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine = new LimitChatProtoStateMachine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine$LimitChatMachineListener);
      LimitChatProtoStateMachine localLimitChatProtoStateMachine = this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine;
      return localLimitChatProtoStateMachine;
    }
  }
  
  public LimitChatUiStateMachine a()
  {
    ??? = this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine;
    if (??? != null) {
      return ???;
    }
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine != null)
      {
        localLimitChatUiStateMachine = this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine;
        return localLimitChatUiStateMachine;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine = new LimitChatUiStateMachine(this);
      LimitChatUiStateMachine localLimitChatUiStateMachine = this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine;
      return localLimitChatUiStateMachine;
    }
  }
  
  public Object a(String paramString, int paramInt)
  {
    paramString = a(paramString, true);
    if (paramString != null) {
      return paramString.getAttribute(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    if ((localEntityManager != null) && (localEntityManager.isOpen())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.drop(ExpandFriendData.class);
    }
  }
  
  public void a(int paramInt)
  {
    a().b(101, paramInt);
  }
  
  public void a(ExpandFriendData paramExpandFriendData)
  {
    if ((paramExpandFriendData != null) && (!TextUtils.isEmpty(paramExpandFriendData.matchUin)))
    {
      this.jdField_a_of_type_AndroidUtilLruCache.put(paramExpandFriendData.matchUin, paramExpandFriendData);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
      if ((localObject != null) && (((EntityManager)localObject).isOpen())) {
        if (paramExpandFriendData.getStatus() == 1000) {
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramExpandFriendData);
        } else if (paramExpandFriendData.getStatus() == 1001) {
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramExpandFriendData);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateExpandFriendData ");
        ((StringBuilder)localObject).append(paramExpandFriendData);
        QLog.d("ExtendFriendLimitChatManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    QLog.w("ExtendFriendLimitChatManager", 1, "updateExpandFriendData but expandFriendData is empty");
  }
  
  public void a(TagInfo paramTagInfo)
  {
    int i;
    if (paramTagInfo != null) {
      i = paramTagInfo.a;
    } else {
      i = 1;
    }
    a().b(102, i);
  }
  
  public void a(ExtendFriendLimitChatManager.LimitChatMatchListener paramLimitChatMatchListener)
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramLimitChatMatchListener);
  }
  
  public void a(String paramString, int paramInt, Object paramObject)
  {
    ExpandFriendData localExpandFriendData2 = a(paramString, true);
    ExpandFriendData localExpandFriendData1 = localExpandFriendData2;
    if (localExpandFriendData2 == null) {
      localExpandFriendData1 = new ExpandFriendData(paramString);
    }
    try
    {
      localExpandFriendData1.setAttribute(paramInt, paramObject);
      a(localExpandFriendData1);
      return;
    }
    catch (Exception paramString)
    {
      paramObject = new StringBuilder();
      paramObject.append("updateExpandFriendDataSingleAttribute error: ");
      paramObject.append(paramString);
      QLog.w("ExtendFriendLimitChatManager", 1, paramObject.toString());
    }
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(String.valueOf(paramString1), String.valueOf(paramString2), paramArrayOfByte);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, MatchFeedInfo paramMatchFeedInfo)
  {
    paramMatchFeedInfo = new StringBuilder();
    paramMatchFeedInfo.append("handleGetSquareStrangerList onGetMatchFeedInfo success = ");
    paramMatchFeedInfo.append(paramBoolean);
    QLog.i("ExtendFriendLimitChat", 2, paramMatchFeedInfo.toString());
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.d = paramString3;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getBoolean("init_matchchat_folder", true);
    }
    return false;
  }
  
  public boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendLimitChatManager", 2, "showRealNameAuthDialog");
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = paramContext.getString(2131699196);
      }
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_c_of_type_JavaLangString = paramContext.getString(2131699194);
      }
      if (TextUtils.isEmpty(this.d)) {
        this.d = "https://ti.qq.com/realname/index.html";
      }
      paramContext = DialogUtil.a(paramContext, 230, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, paramContext.getString(2131699195), paramContext.getString(2131699197), new ExtendFriendLimitChatManager.3(this, paramContext), new ExtendFriendLimitChatManager.4(this));
      paramContext.setCancelable(false);
      paramContext.show();
      return true;
    }
    return false;
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramBaseQQAppInterface == null)
    {
      QLog.e("ExtendFriendLimitChatManager", 2, "getMatchSwitchOpenFromSp with null app");
      return true;
    }
    return SharedPreUtils.g(paramBaseQQAppInterface.getCurrentAccountUin()).getBoolean("sp_match_switch_type", false);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo = null;
  }
  
  public boolean b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    boolean bool;
    if (paramBaseQQAppInterface != null)
    {
      bool = a(paramBaseQQAppInterface).booleanValue();
      if (bool)
      {
        paramBaseQQAppInterface = (IExpandManager)paramBaseQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        if (paramBaseQQAppInterface != null) {
          bool = paramBaseQQAppInterface.j();
        }
      }
      else
      {
        QLog.d("ExtendFriendLimitChatManager", 2, "is voiceMatchShowToUser xinyong not enough  ");
      }
    }
    else
    {
      bool = false;
    }
    paramBaseQQAppInterface = new StringBuilder();
    paramBaseQQAppInterface.append("is voiceMatch ShowToUser ");
    paramBaseQQAppInterface.append(bool);
    QLog.d("ExtendFriendLimitChatManager", 2, paramBaseQQAppInterface.toString());
    return bool;
  }
  
  public void c()
  {
    a().a(103);
  }
  
  public void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[initManager], threadId:");
    localStringBuilder.append(Thread.currentThread().getId());
    QLog.i("ExtendFriendLimitChatManager", 1, localStringBuilder.toString());
    if (a()) {
      e();
    }
  }
  
  public void onDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine;
    if (localObject != null)
    {
      ((LimitChatProtoStateMachine)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      ((WeakReference)localObject).clear();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager
 * JD-Core Version:    0.7.0.1
 */