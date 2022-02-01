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
  static AtomicBoolean a = new AtomicBoolean(true);
  private final QQAppInterface b;
  private Map<String, Integer> c;
  private int d;
  private Map<String, Boolean> e;
  private Map<String, Boolean> f;
  private AtomicBoolean g = new AtomicBoolean(false);
  
  public NotifyIdManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    this.e = new ConcurrentHashMap();
    this.f = new ConcurrentHashMap();
    g();
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
    //   11: invokevirtual 55	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   14: invokevirtual 61	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   17: astore_0
    //   18: aload_0
    //   19: ldc 63
    //   21: iconst_2
    //   22: anewarray 65	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: aload_1
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: aload_2
    //   32: aastore
    //   33: invokevirtual 71	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   36: checkcast 63	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   39: astore_1
    //   40: aload_0
    //   41: invokevirtual 74	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   44: aload_1
    //   45: areturn
    //   46: astore_1
    //   47: goto +14 -> 61
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 77	java/lang/Exception:printStackTrace	()V
    //   55: aload_0
    //   56: invokevirtual 74	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   59: aconst_null
    //   60: areturn
    //   61: aload_0
    //   62: invokevirtual 74	com/tencent/mobileqq/persistence/EntityManager:close	()V
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
  
  public static NotifyIdManager a(QQAppInterface paramQQAppInterface)
  {
    return (NotifyIdManager)paramQQAppInterface.getManager(QQManagerFactory.NOTIFY_ID_MANAGER);
  }
  
  public static void a(boolean paramBoolean)
  {
    a.set(paramBoolean);
  }
  
  public static boolean a()
  {
    return a.get();
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    return (ProcessorFactory.a(paramInt)) && (d(paramString));
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
      if (d(paramMessage.frienduin)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static NotifyIdManager b()
  {
    return a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private static boolean d(String paramString)
  {
    return Friends.isValidUin(paramString);
  }
  
  private ColorNickText e(String paramString)
  {
    paramString = new ColorNickText(paramString, 16);
    paramString.setSpan(new ForegroundColorSpan(BaseApplicationImpl.context.getResources().getColor(2131167005)), 0, paramString.length(), 33);
    return paramString;
  }
  
  private void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.c.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append(str);
      localStringBuilder.append("=");
      localStringBuilder.append(this.c.get(str));
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
    localObject = this.b.getCurrentAccountUin();
    this.b.getApp().getSharedPreferences((String)localObject, 4).edit().putString("SP_KEY_CURRENT_NOTIFY_ID_MAP", localStringBuilder.toString()).apply();
  }
  
  private void f()
  {
    String str = this.b.getCurrentAccountUin();
    this.b.getApp().getSharedPreferences(str, 4).edit().putInt("SP_KEY_CURRENT_NOTIFY_ID", this.d).apply();
    if (QLog.isColorLevel()) {
      QLog.d("NotifyIdManager", 2, new Object[] { "saveCurrentIdToSp: invoked. ", " mCurrentMinId: ", Integer.valueOf(this.d) });
    }
  }
  
  private void g()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    Object localObject = this.b.getCurrentAccountUin();
    localObject = this.b.getApp().getSharedPreferences((String)localObject, 4);
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
    this.c = localConcurrentHashMap;
    this.d = ((SharedPreferences)localObject).getInt("SP_KEY_CURRENT_NOTIFY_ID", 512);
  }
  
  public int a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotifyIdManager", 2, new Object[] { "uniqueNotifyIdByUin: invoked. ", " friendUin: ", paramString });
    }
    if (this.c.containsKey(paramString)) {
      return ((Integer)this.c.get(paramString)).intValue();
    }
    this.d += 1;
    if (this.d >= 522) {
      this.d = 512;
    }
    this.c.put(paramString, Integer.valueOf(this.d));
    e();
    f();
    return this.d;
  }
  
  public String a(String paramString, Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.getCurrentAccountUin());
    localStringBuilder.append(paramMessage.frienduin);
    paramMessage = paramString;
    if (QvipSpecialCareUtil.a(localStringBuilder.toString()))
    {
      paramMessage = new StringBuilder();
      paramMessage.append(HardCodeUtil.a(2131905462));
      paramMessage.append(paramString);
      paramMessage = paramMessage.toString();
    }
    return paramMessage;
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
      paramSpannableStringBuilder.append(e(HardCodeUtil.a(2131905461)));
      paramSpannableStringBuilder.append(new ColorNickText(paramMessage.nickName, 16));
    }
  }
  
  public void a(Message paramMessage, SpannableStringBuilder paramSpannableStringBuilder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.getCurrentAccountUin());
    localStringBuilder.append(paramMessage.senderuin);
    if ((QvipSpecialCareUtil.a(localStringBuilder.toString())) && (paramMessage.istroop == 0)) {
      paramSpannableStringBuilder.append(e(HardCodeUtil.a(2131905463)));
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    paramSessionInfo = paramSessionInfo.b;
    if (QLog.isColorLevel()) {
      QLog.d("NotifyIdManager", 2, new Object[] { "onAioResume: invoked. ", " curFriendUin: ", paramSessionInfo });
    }
    c(paramSessionInfo);
    b(paramSessionInfo);
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
      paramString1 = a(this.b, paramString1, paramString2);
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
    boolean bool = a(this.b).a(paramMessage.frienduin, paramMessage.senderuin);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCareTroopMemberMsgText: invoked.  troopMemberIsCared: ");
      ((StringBuilder)localObject).append(bool);
      QLog.i("NotifyIdManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (Boolean)this.e.get(paramMessage.frienduin);
    Boolean localBoolean = (Boolean)this.f.get(paramMessage.frienduin);
    if ((!bool) && ((localObject == null) || (!((Boolean)localObject).booleanValue())))
    {
      if ((paramMessage.bizType != 16) && ((localBoolean == null) || (!localBoolean.booleanValue()))) {
        return paramString;
      }
      if (localBoolean == null) {
        this.f.put(paramMessage.frienduin, Boolean.valueOf(true));
      }
      paramMessage = new StringBuilder();
      paramMessage.append(localResources.getString(2131897522));
      paramMessage.append(paramString);
      return paramMessage.toString();
    }
    if (localObject == null) {
      this.e.put(paramMessage.frienduin, Boolean.valueOf(true));
    }
    paramMessage = new StringBuilder();
    paramMessage.append(HardCodeUtil.a(2131905464));
    paramMessage.append(paramString);
    return paramMessage.toString();
  }
  
  public void b(String paramString)
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
      this.e.remove(paramString);
      this.f.remove(paramString);
    }
  }
  
  public boolean b(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.getCurrentAccountUin());
    localStringBuilder.append(paramMessage.senderuin);
    return QvipSpecialCareUtil.a(localStringBuilder.toString());
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotifyIdManager", 2, "cancelAllNotification: invoked. ");
    }
    ThreadManager.excute(new NotifyIdManager.2(this, QQNotificationManager.getInstance()), 16, null, false);
    this.c.clear();
    e();
  }
  
  public void c(Message paramMessage)
  {
    Handler localHandler = ThreadManager.getUIHandlerV2();
    if ((b(paramMessage)) && (localHandler != null))
    {
      this.g.set(true);
      localHandler.postDelayed(new NotifyIdManager.1(this), 5000L);
    }
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("NotifyIdManager", 2, "cancelNotificationByUin: call stack: ", new RuntimeException());
    }
    Integer localInteger = (Integer)this.c.get(paramString);
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
    this.c.remove(paramString);
    e();
  }
  
  public void d()
  {
    TempGetProfileDetailProcessor localTempGetProfileDetailProcessor = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.b, TempGetProfileDetailProcessor.class);
    if (localTempGetProfileDetailProcessor != null) {
      localTempGetProfileDetailProcessor.getCareBarEnable();
    }
  }
  
  public boolean d(Message paramMessage)
  {
    return (this.g.get()) && (!b(paramMessage));
  }
  
  public void e(Message paramMessage)
  {
    if (paramMessage != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NotifyIdManager", 2, new Object[] { "cancelNotificationByMessage: invoked. ", " message: ", paramMessage });
      }
      if (!f(paramMessage)) {
        c(paramMessage.frienduin);
      }
    }
  }
  
  public boolean f(Message paramMessage)
  {
    return (paramMessage != null) && (paramMessage.counter > 0);
  }
  
  public void onDestroy()
  {
    this.c.clear();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.notification.NotifyIdManager
 * JD-Core Version:    0.7.0.1
 */