package com.tencent.util.notification;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.notification.struct.ProcessorFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

public class NotifyIdManager
  implements Manager
{
  static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private int jdField_a_of_type_Int;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  private Map<String, Boolean> jdField_b_of_type_JavaUtilMap;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private Map<String, Boolean> c;
  
  public NotifyIdManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.c = new ConcurrentHashMap();
    e();
  }
  
  /* Error */
  public static TroopMemberInfo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +66 -> 67
    //   4: aload_2
    //   5: ifnonnull +5 -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: aload_0
    //   11: invokevirtual 52	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   14: invokevirtual 58	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   17: astore_0
    //   18: aload_0
    //   19: ldc 60
    //   21: iconst_2
    //   22: anewarray 62	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: aload_1
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: aload_2
    //   32: aastore
    //   33: invokevirtual 68	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   36: checkcast 60	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   39: astore_1
    //   40: aload_0
    //   41: invokevirtual 71	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   44: aload_1
    //   45: areturn
    //   46: astore_1
    //   47: goto +14 -> 61
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 74	java/lang/Exception:printStackTrace	()V
    //   55: aload_0
    //   56: invokevirtual 71	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   59: aconst_null
    //   60: areturn
    //   61: aload_0
    //   62: invokevirtual 71	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   65: aload_1
    //   66: athrow
    //   67: aconst_null
    //   68: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	paramQQAppInterface	QQAppInterface
    //   0	69	1	paramString1	String
    //   0	69	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   18	40	46	finally
    //   51	55	46	finally
    //   18	40	50	java/lang/Exception
  }
  
  private ColorNickText a(String paramString)
  {
    paramString = new ColorNickText(paramString, 16);
    paramString.setSpan(new ForegroundColorSpan(BaseApplicationImpl.context.getResources().getColor(2131166272)), 0, paramString.length(), 33);
    return paramString;
  }
  
  public static NotifyIdManager a()
  {
    return a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public static NotifyIdManager a(QQAppInterface paramQQAppInterface)
  {
    return (NotifyIdManager)paramQQAppInterface.getManager(QQManagerFactory.NOTIFY_ID_MANAGER);
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    return (ProcessorFactory.a(paramInt)) && (a(paramString));
  }
  
  public static boolean a(Message paramMessage)
  {
    boolean bool2 = false;
    if (paramMessage == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (ProcessorFactory.a(paramMessage.istroop))
    {
      bool1 = bool2;
      if (a(paramMessage.frienduin)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean a(String paramString)
  {
    return Friends.isValidUin(paramString);
  }
  
  private void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append(str);
      localStringBuilder.append("=");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilMap.get(str));
      localStringBuilder.append(",");
    }
    if (localStringBuilder.length() >= 1) {
      localStringBuilder.delete(localStringBuilder.length() - 1, localStringBuilder.length());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveUinIdMapToSp: invoked.  mapAsString: ");
      ((StringBuilder)localObject).append(localStringBuilder);
      QLog.i("NotifyIdManager", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences((String)localObject, 4).edit().putString("SP_KEY_CURRENT_NOTIFY_ID_MAP", localStringBuilder.toString()).apply();
  }
  
  private void d()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(str, 4).edit().putInt("SP_KEY_CURRENT_NOTIFY_ID", this.jdField_a_of_type_Int).apply();
    if (QLog.isColorLevel()) {
      QLog.d("NotifyIdManager", 2, new Object[] { "saveCurrentIdToSp: invoked. ", " mCurrentMinId: ", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
  }
  
  private void e()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences((String)localObject, 4);
    String str = ((SharedPreferences)localObject).getString("SP_KEY_CURRENT_NOTIFY_ID_MAP", "");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        String[] arrayOfString1 = str.split(",");
        int j = arrayOfString1.length;
        int i = 0;
        while (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("=");
          localConcurrentHashMap.put(arrayOfString2[0], Integer.valueOf(Integer.parseInt(arrayOfString2[1])));
          i += 1;
        }
        if (!QLog.isColorLevel()) {
          break label157;
        }
      }
      catch (Exception localException)
      {
        QLog.e("NotifyIdManager", 1, "restoreUinIdMapFromSp: failed. ", localException);
      }
    } else {
      QLog.d("NotifyIdManager", 2, new Object[] { "restoreUinIdMapFromSp: invoked. ", " mapStr: ", str });
    }
    label157:
    this.jdField_a_of_type_JavaUtilMap = localConcurrentHashMap;
    this.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("SP_KEY_CURRENT_NOTIFY_ID", 512);
  }
  
  public int a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotifyIdManager", 2, new Object[] { "uniqueNotifyIdByUin: invoked. ", " friendUin: ", paramString });
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue();
    }
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int >= 522) {
      this.jdField_a_of_type_Int = 512;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(this.jdField_a_of_type_Int));
    c();
    d();
    return this.jdField_a_of_type_Int;
  }
  
  public String a(String paramString, Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append(paramMessage.frienduin);
    paramMessage = paramString;
    if (QvipSpecialCareUtil.a(localStringBuilder.toString()))
    {
      paramMessage = new StringBuilder();
      paramMessage.append(HardCodeUtil.a(2131707647));
      paramMessage.append(paramString);
      paramMessage = paramMessage.toString();
    }
    return paramMessage;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotifyIdManager", 2, "cancelAllNotification: invoked. ");
    }
    ThreadManager.excute(new NotifyIdManager.2(this, QQNotificationManager.getInstance()), 16, null, false);
    this.jdField_a_of_type_JavaUtilMap.clear();
    c();
  }
  
  public void a(Message paramMessage)
  {
    Handler localHandler = ThreadManager.getUIHandlerV2();
    if ((b(paramMessage)) && (localHandler != null))
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      localHandler.postDelayed(new NotifyIdManager.1(this), 5000L);
    }
  }
  
  public void a(Message paramMessage, Intent paramIntent, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((a(paramMessage.frienduin, paramMessage.senderuin)) && (paramMessage.istroop == 1))
    {
      paramSpannableStringBuilder.clear();
      paramIntent = paramIntent.getStringExtra("uinname");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(paramIntent);
      localStringBuilder.append("]");
      paramSpannableStringBuilder.append(new ColorNickText(localStringBuilder.toString(), 16));
      paramSpannableStringBuilder.append(a(HardCodeUtil.a(2131707646)));
      paramSpannableStringBuilder.append(new ColorNickText(paramMessage.nickName, 16));
    }
  }
  
  public void a(Message paramMessage, SpannableStringBuilder paramSpannableStringBuilder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append(paramMessage.senderuin);
    if ((QvipSpecialCareUtil.a(localStringBuilder.toString())) && (paramMessage.istroop == 0)) {
      paramSpannableStringBuilder.append(a(HardCodeUtil.a(2131707648)));
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    paramSessionInfo = paramSessionInfo.a;
    if (QLog.isColorLevel()) {
      QLog.d("NotifyIdManager", 2, new Object[] { "onAioResume: invoked. ", " curFriendUin: ", paramSessionInfo });
    }
    b(paramSessionInfo);
    a(paramSessionInfo);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearUinNeedShowCareMap: invoked.  friendOrTroopUin: ");
      localStringBuilder.append(paramString);
      QLog.i("NotifyIdManager", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_b_of_type_JavaUtilMap.remove(paramString);
      this.c.remove(paramString);
    }
  }
  
  public boolean a(@Nullable String paramString1, @Nullable String paramString2)
  {
    long l = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      if ((Looper.myLooper() == Looper.getMainLooper()) && (QLog.isColorLevel())) {
        QLog.i("NotifyIdManager", 2, "troopMemberIsCared: invoked. run on ui thread. ");
      }
      paramString1 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("troopMemberIsCared: invoked. cost: ");
        paramString2.append(System.currentTimeMillis() - l);
        QLog.i("NotifyIdManager", 2, paramString2.toString());
      }
      if (paramString1 != null) {
        return paramString1.isTroopFollowed;
      }
    }
    return false;
  }
  
  public String b(String paramString, Message paramMessage)
  {
    Resources localResources = BaseApplication.getContext().getResources();
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessage.frienduin, paramMessage.senderuin);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCareTroopMemberMsgText: invoked.  troopMemberIsCared: ");
      ((StringBuilder)localObject).append(bool);
      QLog.i("NotifyIdManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (Boolean)this.jdField_b_of_type_JavaUtilMap.get(paramMessage.frienduin);
    Boolean localBoolean = (Boolean)this.c.get(paramMessage.frienduin);
    if ((!bool) && ((localObject == null) || (!((Boolean)localObject).booleanValue())))
    {
      if ((paramMessage.bizType != 16) && ((localBoolean == null) || (!localBoolean.booleanValue()))) {
        return paramString;
      }
      if (localBoolean == null) {
        this.c.put(paramMessage.frienduin, Boolean.valueOf(true));
      }
      paramMessage = new StringBuilder();
      paramMessage.append(localResources.getString(2131699491));
      paramMessage.append(paramString);
      return paramMessage.toString();
    }
    if (localObject == null) {
      this.jdField_b_of_type_JavaUtilMap.put(paramMessage.frienduin, Boolean.valueOf(true));
    }
    paramMessage = new StringBuilder();
    paramMessage.append(HardCodeUtil.a(2131707649));
    paramMessage.append(paramString);
    return paramMessage.toString();
  }
  
  public void b()
  {
    TempGetProfileDetailProcessor localTempGetProfileDetailProcessor = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
    if (localTempGetProfileDetailProcessor != null) {
      localTempGetProfileDetailProcessor.getCareBarEnable();
    }
  }
  
  public void b(Message paramMessage)
  {
    if (paramMessage != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NotifyIdManager", 2, new Object[] { "cancelNotificationByMessage: invoked. ", " message: ", paramMessage });
      }
      if (!d(paramMessage)) {
        b(paramMessage.frienduin);
      }
    }
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("NotifyIdManager", 2, "cancelNotificationByUin: call stack: ", new RuntimeException());
    }
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cancelNotificationByUin: invoked.  notifyId: ");
      localStringBuilder.append(localInteger);
      localStringBuilder.append(" friendUin: ");
      localStringBuilder.append(paramString);
      QLog.i("NotifyIdManager", 2, localStringBuilder.toString());
    }
    if (localInteger != null) {
      QQNotificationManager.getInstance().cancel("NotifyIdManager", localInteger.intValue());
    }
    this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    c();
  }
  
  public boolean b(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append(paramMessage.senderuin);
    return QvipSpecialCareUtil.a(localStringBuilder.toString());
  }
  
  public boolean c(Message paramMessage)
  {
    return (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!b(paramMessage));
  }
  
  public boolean d(Message paramMessage)
  {
    return (paramMessage != null) && (paramMessage.counter > 0);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.notification.NotifyIdManager
 * JD-Core Version:    0.7.0.1
 */