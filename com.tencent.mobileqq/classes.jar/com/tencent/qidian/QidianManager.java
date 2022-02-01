package com.tencent.qidian;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.bmqq.app.BmqqBusinessHandler;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianInternalInfo;
import com.tencent.qidian.data.QidianPAForWpa;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class QidianManager
  implements Manager
{
  public static final AtomicBoolean a;
  public AppInterface a;
  private List<QidianManager.OnLbsStateChangedListener> a;
  public Map<String, Integer> a;
  public Map<String, QidianExternalInfo> b = null;
  public Map<String, QidianInternalInfo> c = null;
  public Map<String, QidianCorpInfo> d = null;
  public Map<String, QidianProfileUiInfo> e = null;
  public Map<String, BmqqUserSimpleInfo> f = null;
  public Map<String, QidianPAForWpa> g = null;
  public Map<String, String> h = null;
  public Map<String, List<MessageRecord>> i = null;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public QidianManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.b = new HashMap();
    this.c = new HashMap();
    this.f = new HashMap();
    this.d = new HashMap();
    this.e = new HashMap();
    this.g = new HashMap();
    this.i = new HashMap();
    this.h = new HashMap();
    if (UiThreadUtil.a()) {
      ThreadManager.getSubThreadHandler().post(new QidianManager.1(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
      return;
      a();
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = ContactUtils.m(paramQQAppInterface, paramString);
    if ((TextUtils.isEmpty(str)) || (str.equals(paramString)))
    {
      paramQQAppInterface = ((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).a(String.valueOf(paramString));
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.nickname;
      }
    }
    return str;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 4, "initial ...");
    }
    localEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      a(localEntityManager);
      b(localEntityManager);
      d(localEntityManager);
      e(localEntityManager);
      c(localEntityManager);
      f(localEntityManager);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QidianManager", 2, "QidianManager get data from db error: " + localException.getMessage());
        }
        localEntityManager.close();
      }
    }
    finally
    {
      localEntityManager.close();
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  /* Error */
  public static void a(android.app.Activity paramActivity, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aload 5
    //   5: ifnonnull +195 -> 200
    //   8: aconst_null
    //   9: astore 5
    //   11: aload_2
    //   12: ifnonnull +205 -> 217
    //   15: ldc 208
    //   17: astore 9
    //   19: aload_3
    //   20: ifnonnull +213 -> 233
    //   23: ldc 208
    //   25: astore_2
    //   26: aload 4
    //   28: ifnonnull +220 -> 248
    //   31: ldc 208
    //   33: astore_3
    //   34: new 187	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   41: astore 10
    //   43: iload_1
    //   44: bipush 6
    //   46: if_icmpne +237 -> 283
    //   49: ldc 210
    //   51: astore 4
    //   53: aload 10
    //   55: aload 4
    //   57: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 10
    //   63: ldc 212
    //   65: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 10
    //   71: ldc 214
    //   73: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload 5
    //   78: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 10
    //   84: ldc 216
    //   86: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 9
    //   91: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 10
    //   97: ldc 218
    //   99: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_2
    //   103: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 10
    //   109: ldc 220
    //   111: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_3
    //   115: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 10
    //   121: ldc 222
    //   123: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: astore_3
    //   127: iload 8
    //   129: ifeq +162 -> 291
    //   132: ldc 224
    //   134: astore_2
    //   135: aload_3
    //   136: aload_2
    //   137: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 10
    //   143: ldc 226
    //   145: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload 7
    //   150: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 10
    //   156: ldc 231
    //   158: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 6
    //   163: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: new 233	android/content/Intent
    //   170: dup
    //   171: ldc 235
    //   173: aload 10
    //   175: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 241	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   181: invokespecial 244	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   184: astore_2
    //   185: aload_2
    //   186: ldc 246
    //   188: ldc 248
    //   190: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   193: pop
    //   194: aload_0
    //   195: aload_2
    //   196: invokevirtual 258	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   199: return
    //   200: aload 5
    //   202: ldc_w 260
    //   205: invokevirtual 264	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   208: iconst_2
    //   209: invokestatic 270	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   212: astore 5
    //   214: goto -203 -> 11
    //   217: aload_2
    //   218: ldc_w 260
    //   221: invokevirtual 264	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   224: iconst_2
    //   225: invokestatic 270	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   228: astore 9
    //   230: goto -211 -> 19
    //   233: aload_3
    //   234: ldc_w 260
    //   237: invokevirtual 264	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   240: iconst_2
    //   241: invokestatic 270	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   244: astore_2
    //   245: goto -219 -> 26
    //   248: aload 4
    //   250: ldc_w 260
    //   253: invokevirtual 264	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   256: iconst_2
    //   257: invokestatic 270	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   260: astore_3
    //   261: goto -227 -> 34
    //   264: astore_3
    //   265: aconst_null
    //   266: astore 9
    //   268: aconst_null
    //   269: astore 5
    //   271: aconst_null
    //   272: astore_2
    //   273: aload_3
    //   274: invokevirtual 273	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   277: aload 10
    //   279: astore_3
    //   280: goto -246 -> 34
    //   283: ldc_w 275
    //   286: astore 4
    //   288: goto -235 -> 53
    //   291: ldc_w 277
    //   294: astore_2
    //   295: goto -160 -> 135
    //   298: astore_3
    //   299: aconst_null
    //   300: astore 9
    //   302: aconst_null
    //   303: astore_2
    //   304: goto -31 -> 273
    //   307: astore_3
    //   308: aconst_null
    //   309: astore_2
    //   310: goto -37 -> 273
    //   313: astore_3
    //   314: goto -41 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	paramActivity	android.app.Activity
    //   0	317	1	paramInt1	int
    //   0	317	2	paramString1	String
    //   0	317	3	paramString2	String
    //   0	317	4	paramString3	String
    //   0	317	5	paramString4	String
    //   0	317	6	paramString5	String
    //   0	317	7	paramInt2	int
    //   0	317	8	paramBoolean	boolean
    //   17	284	9	str	String
    //   1	277	10	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   200	214	264	java/io/UnsupportedEncodingException
    //   217	230	298	java/io/UnsupportedEncodingException
    //   233	245	307	java/io/UnsupportedEncodingException
    //   248	261	313	java/io/UnsupportedEncodingException
  }
  
  public static void a(Context paramContext, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    paramContext = paramContext.getPackageManager();
    if (new Intent().setPackage("com.tencent.qidian").setData(Uri.parse("qdapi://")).resolveActivity(paramContext) != null) {
      paramArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(19));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        Long.parseLong(paramString);
        if (!BmqqSegmentUtil.a(paramString)) {
          return;
        }
        QidianManager localQidianManager = (QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
        boolean bool1 = b(paramInt);
        boolean bool2 = a(paramInt);
        boolean bool3 = c(paramInt);
        if ((!bool1) && (!bool2) && (!bool3))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QidianManager", 2, "updateQidianAccountType ignore uin: " + paramString + " | cSpecialFlag: " + paramInt);
          return;
        }
        if (localQidianManager.g(paramString))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QidianManager", 2, "updateQidianAccountType requested uin: " + paramString + " | cSpecialFlag: " + paramInt);
          return;
        }
        if (bool1)
        {
          localBmqqAccountType = new BmqqAccountType(paramString, 6);
          localQidianManager.a(localBmqqAccountType);
          if (!bool1) {
            continue;
          }
          QidianExternalInfo localQidianExternalInfo = localQidianManager.a(paramString);
          paramString = localQidianManager.a(paramString);
          if ((localQidianExternalInfo != null) && (paramString != null)) {
            continue;
          }
          if (UiThreadUtil.a()) {
            ThreadManager.post(new QidianManager.10(localQidianManager, paramQQAppInterface, localBmqqAccountType), 5, null, true);
          }
        }
        else
        {
          if (bool2)
          {
            localBmqqAccountType = new BmqqAccountType(paramString, 1);
            continue;
          }
          if (!bool3) {
            break label283;
          }
          localBmqqAccountType = new BmqqAccountType(paramString, 3);
          continue;
        }
        localQidianManager.b(paramQQAppInterface.getApp().getBaseContext(), localBmqqAccountType);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
      label283:
      BmqqAccountType localBmqqAccountType = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends)
  {
    if (paramFriends == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QidianManager", 2, "updateQidianAccountType friend is null");
      }
      return;
    }
    a(paramQQAppInterface, paramFriends.cSpecialFlag, paramFriends.uin);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    try
    {
      Long.parseLong(paramString1);
      if (!BmqqSegmentUtil.a(paramString1)) {
        return;
      }
      ((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).h.put(paramString1, paramString2);
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends[] paramArrayOfFriends)
  {
    QidianManager localQidianManager;
    if (paramArrayOfFriends != null)
    {
      localQidianManager = (QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
      if (UiThreadUtil.a()) {
        ThreadManager.postImmediately(new QidianManager.9(localQidianManager, paramQQAppInterface, paramArrayOfFriends), null, false);
      }
    }
    else
    {
      return;
    }
    localQidianManager.b(paramQQAppInterface, paramArrayOfFriends);
  }
  
  private void a(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.query(QidianExternalInfo.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        QidianExternalInfo localQidianExternalInfo = (QidianExternalInfo)paramEntityManager.next();
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 4, "loadExternalInfo query from db: " + localQidianExternalInfo);
        }
        String str = localQidianExternalInfo.uin;
        this.b.put(str, localQidianExternalInfo);
      }
    }
  }
  
  private void a(QidianPAForWpa paramQidianPAForWpa, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "updateQidianPAForWpa");
    }
    paramString1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    if (paramString1 != null) {
      if (paramQidianPAForWpa == null) {}
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          paramString1.persistOrReplace(paramQidianPAForWpa);
          if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "updateQidianPAForWpa success");
          }
          return;
        }
        catch (Exception paramQidianPAForWpa)
        {
          paramQidianPAForWpa.printStackTrace();
          return;
        }
        finally
        {
          paramString1.close();
        }
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "updateQidianPAForWpa uiInfo is null");
        }
      }
    }
    QLog.d("QidianManager", 2, "updateQidianPAForWpa em is null");
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("isNeedReply=")) && (paramString1.contains("QidianKfUin=")))
    {
      bool1 = false;
      bool2 = false;
      str3 = "";
      str2 = "";
      str1 = "";
      localMatcher = Pattern.compile("((?:isNeedReply|isNeedLbs|QidianKfUin|isExt|FromStaff|cqq))=([^\\?&=]+)").matcher(paramString1);
      while (localMatcher.find()) {
        if ("isNeedReply".equals(localMatcher.group(1))) {
          bool2 = "true".equals(localMatcher.group(2));
        } else if ("isNeedLbs".equals(localMatcher.group(1))) {
          bool1 = "true".equals(localMatcher.group(2));
        } else if ("QidianKfUin".equals(localMatcher.group(1))) {
          str3 = localMatcher.group(2);
        } else if ("isExt".equals(localMatcher.group(1)))
        {
          if (paramInt2 == 2) {
            try
            {
              bool3 = Boolean.parseBoolean(localMatcher.group(2));
              if (bool3)
              {
                paramInt2 = 0;
                continue;
              }
              paramInt2 = 1;
            }
            catch (Exception localException)
            {
              paramInt2 = 0;
            }
          }
        }
        else if ("FromStaff".equals(localMatcher.group(1))) {
          str2 = localMatcher.group(2);
        } else if ("cqq".equals(localMatcher.group(1))) {
          str1 = localMatcher.group(2);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QidianManager", 2, "isNeedLbs: " + bool1 + " | isNeedReply: " + bool2 + " | masterUin: " + str3 + " | srcType: " + paramInt2);
      }
      if (bool2)
      {
        if (!bool1) {
          break label375;
        }
        ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new QidianManager.5(this, 1, true, true, 0L, true, false, "QidianManager", paramString1, paramInt1, str3, paramInt2, str2, str1, paramString2));
      }
    }
    label375:
    while (!QLog.isColorLevel())
    {
      boolean bool1;
      boolean bool2;
      String str3;
      String str2;
      String str1;
      Matcher localMatcher;
      boolean bool3;
      return;
      a(paramString1, paramInt1, bool1, 0.0D, 0.0D, str3, paramInt2, str2, str1, paramString2);
      return;
    }
    QLog.d("QidianManager", 2, "key is null or don't contain isNeedReply : " + paramString1);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Friends paramFriends, int paramInt)
  {
    boolean bool2 = true;
    paramQQAppInterface = (QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
    boolean bool1 = bool2;
    if (paramFriends != null)
    {
      bool1 = bool2;
      if (b(paramFriends.cSpecialFlag)) {
        if ((paramInt != 1) && (paramInt != 2) && (paramInt != 13) && (paramInt != 10001) && (paramInt != 7)) {
          break label67;
        }
      }
    }
    label67:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    return ((((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).a(paramMessageRecord.frienduin)) || (paramMessageRecord.istroop == 1024)) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("is_eman_sc_message")));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).e(paramString);
  }
  
  private boolean a(String paramString, int paramInt)
  {
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject != null)
    {
      localObject = ((FriendsManager)localObject).b(paramString);
      if ((localObject != null) && (((Friends)localObject).cSpecialFlag < 0))
      {
        QLog.i("QidianManager", 1, "isSpecialAccountInFriend meet error!!");
        return false;
      }
      if ((localObject != null) && ((((Friends)localObject).cSpecialFlag & paramInt) != 0)) {
        QLog.i("QidianManager", 1, MsfSdkUtils.getShortUin(paramString) + " isSpecialAccountInFriend isSpecialAccount is true, friendInfo.cSpecialFlag: " + ((Friends)localObject).cSpecialFlag + " | flag: " + paramInt);
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(paramQQAppInterface.getAccount())) {
      if (QLog.isColorLevel()) {
        QLog.i("QidianManager", 2, "app.getAccount() is null");
      }
    }
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("QidianManager", 2, "initParm uin = " + paramString);
      }
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QidianManager", 2, "mAllinone is null");
    return false;
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (!TextUtils.isEmpty(paramString2)) {
        break label50;
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramString3)) && (paramString3.contains("isNeedReply=")) && (paramString3.contains("QidianKfUin=")))
      {
        return true;
        paramString2 = paramString1;
        break;
      }
      return false;
      label50:
      paramString3 = paramString2;
    }
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
    if (paramQQAppInterface.f(paramString)) {
      if (paramQQAppInterface.b.containsKey(paramString))
      {
        paramQQAppInterface = (QidianExternalInfo)paramQQAppInterface.b.get(paramString);
        if (paramQQAppInterface != null) {
          return paramQQAppInterface.masterUin;
        }
      }
      else if (paramQQAppInterface.h.containsKey(paramString))
      {
        return (String)paramQQAppInterface.h.get(paramString);
      }
    }
    return "";
  }
  
  /* Error */
  private void b(QQAppInterface paramQQAppInterface, Friends[] paramArrayOfFriends)
  {
    // Byte code:
    //   0: aload_2
    //   1: arraylength
    //   2: istore 4
    //   4: iconst_0
    //   5: istore_3
    //   6: iload_3
    //   7: iload 4
    //   9: if_icmpge +275 -> 284
    //   12: aload_2
    //   13: iload_3
    //   14: aaload
    //   15: astore 9
    //   17: aload 9
    //   19: getfield 383	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   22: astore 10
    //   24: aload 9
    //   26: getfield 380	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   29: istore 5
    //   31: aload 10
    //   33: invokestatic 319	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   36: pop2
    //   37: aload 10
    //   39: invokestatic 324	com/tencent/biz/bmqq/util/BmqqSegmentUtil:a	(Ljava/lang/String;)Z
    //   42: ifne +4 -> 46
    //   45: return
    //   46: iload 5
    //   48: invokestatic 327	com/tencent/qidian/QidianManager:b	(I)Z
    //   51: istore 6
    //   53: iload 5
    //   55: invokestatic 329	com/tencent/qidian/QidianManager:a	(I)Z
    //   58: istore 7
    //   60: iload 5
    //   62: invokestatic 331	com/tencent/qidian/QidianManager:c	(I)Z
    //   65: istore 8
    //   67: iload 6
    //   69: ifne +60 -> 129
    //   72: iload 7
    //   74: ifne +55 -> 129
    //   77: iload 8
    //   79: ifne +50 -> 129
    //   82: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +200 -> 285
    //   88: ldc 147
    //   90: iconst_2
    //   91: new 187	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 333
    //   101: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload 10
    //   106: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 335
    //   112: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: iload 5
    //   117: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: goto +159 -> 285
    //   129: aconst_null
    //   130: astore 9
    //   132: iload 6
    //   134: ifeq +109 -> 243
    //   137: new 341	com/tencent/qidian/data/BmqqAccountType
    //   140: dup
    //   141: aload 10
    //   143: bipush 6
    //   145: invokespecial 344	com/tencent/qidian/data/BmqqAccountType:<init>	(Ljava/lang/String;I)V
    //   148: astore 9
    //   150: aload 9
    //   152: ifnull +133 -> 285
    //   155: aload_0
    //   156: aload 10
    //   158: invokevirtual 606	com/tencent/qidian/QidianManager:a	(Ljava/lang/String;)I
    //   161: aload 9
    //   163: invokevirtual 610	com/tencent/qidian/data/BmqqAccountType:getAccountType	()I
    //   166: if_icmpeq +119 -> 285
    //   169: aload_0
    //   170: getfield 45	com/tencent/qidian/QidianManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   173: aload 10
    //   175: aload 9
    //   177: invokevirtual 610	com/tencent/qidian/data/BmqqAccountType:getAccountType	()I
    //   180: invokestatic 615	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   183: invokeinterface 392 3 0
    //   188: pop
    //   189: iload 6
    //   191: ifeq +94 -> 285
    //   194: aload_0
    //   195: aload 10
    //   197: invokevirtual 132	com/tencent/qidian/QidianManager:a	(Ljava/lang/String;)Lcom/tencent/qidian/data/QidianExternalInfo;
    //   200: astore 11
    //   202: aload_0
    //   203: aload 10
    //   205: invokevirtual 350	com/tencent/qidian/QidianManager:a	(Ljava/lang/String;)Lcom/tencent/qidian/data/QidianProfileUiInfo;
    //   208: astore 10
    //   210: aload 11
    //   212: ifnull +8 -> 220
    //   215: aload 10
    //   217: ifnonnull +68 -> 285
    //   220: aload_0
    //   221: aload_1
    //   222: invokevirtual 362	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   225: invokevirtual 368	com/tencent/qphone/base/util/BaseApplication:getBaseContext	()Landroid/content/Context;
    //   228: aload 9
    //   230: invokevirtual 371	com/tencent/qidian/QidianManager:b	(Landroid/content/Context;Lcom/tencent/qidian/data/BmqqAccountType;)Z
    //   233: pop
    //   234: goto +51 -> 285
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 456	java/lang/Exception:printStackTrace	()V
    //   242: return
    //   243: iload 7
    //   245: ifeq +18 -> 263
    //   248: new 341	com/tencent/qidian/data/BmqqAccountType
    //   251: dup
    //   252: aload 10
    //   254: iconst_1
    //   255: invokespecial 344	com/tencent/qidian/data/BmqqAccountType:<init>	(Ljava/lang/String;I)V
    //   258: astore 9
    //   260: goto -110 -> 150
    //   263: iload 8
    //   265: ifeq -115 -> 150
    //   268: new 341	com/tencent/qidian/data/BmqqAccountType
    //   271: dup
    //   272: aload 10
    //   274: iconst_3
    //   275: invokespecial 344	com/tencent/qidian/data/BmqqAccountType:<init>	(Ljava/lang/String;I)V
    //   278: astore 9
    //   280: goto -130 -> 150
    //   283: astore_1
    //   284: return
    //   285: iload_3
    //   286: iconst_1
    //   287: iadd
    //   288: istore_3
    //   289: goto -283 -> 6
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	QidianManager
    //   0	292	1	paramQQAppInterface	QQAppInterface
    //   0	292	2	paramArrayOfFriends	Friends[]
    //   5	284	3	j	int
    //   2	8	4	k	int
    //   29	87	5	m	int
    //   51	139	6	bool1	boolean
    //   58	186	7	bool2	boolean
    //   65	199	8	bool3	boolean
    //   15	264	9	localObject1	Object
    //   22	251	10	localObject2	Object
    //   200	11	11	localQidianExternalInfo	QidianExternalInfo
    // Exception table:
    //   from	to	target	type
    //   0	4	237	java/lang/Exception
    //   17	31	237	java/lang/Exception
    //   37	45	237	java/lang/Exception
    //   46	67	237	java/lang/Exception
    //   82	126	237	java/lang/Exception
    //   137	150	237	java/lang/Exception
    //   155	189	237	java/lang/Exception
    //   194	210	237	java/lang/Exception
    //   220	234	237	java/lang/Exception
    //   248	260	237	java/lang/Exception
    //   268	280	237	java/lang/Exception
    //   31	37	283	java/lang/Exception
  }
  
  private void b(BmqqUserSimpleInfo paramBmqqUserSimpleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "updateBmqqExtInfo");
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    if (localEntityManager != null) {
      if (paramBmqqUserSimpleInfo == null) {}
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          localEntityManager.persistOrReplace(paramBmqqUserSimpleInfo);
          if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "updateBmqqExtInfo success");
          }
          return;
        }
        catch (Exception paramBmqqUserSimpleInfo)
        {
          paramBmqqUserSimpleInfo.printStackTrace();
          return;
        }
        finally
        {
          localEntityManager.close();
        }
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "updateBmqqExtInfo uiInfo is null");
        }
      }
    }
    QLog.d("QidianManager", 2, "updateBmqqExtInfo em is null");
  }
  
  private void b(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.query(QidianInternalInfo.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        QidianInternalInfo localQidianInternalInfo = (QidianInternalInfo)paramEntityManager.next();
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 4, "loadInternalInfo query from db: " + localQidianInternalInfo);
        }
        String str = localQidianInternalInfo.uin;
        this.c.put(str, localQidianInternalInfo);
      }
    }
  }
  
  private void b(QidianExternalInfo paramQidianExternalInfo, QidianInternalInfo paramQidianInternalInfo, QidianCorpInfo paramQidianCorpInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread");
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    if (localEntityManager != null) {
      if (paramQidianExternalInfo == null) {}
    }
    label62:
    label124:
    while (!QLog.isColorLevel())
    {
      try
      {
        localEntityManager.persistOrReplace(paramQidianExternalInfo);
        if (paramQidianInternalInfo == null) {
          break label124;
        }
        localEntityManager.persistOrReplace(paramQidianInternalInfo);
      }
      catch (Exception paramQidianExternalInfo)
      {
        for (;;)
        {
          paramQidianExternalInfo.printStackTrace();
          return;
          if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "saveQidianIntInfoInSubThread internalInfo is null");
          }
        }
      }
      finally
      {
        localEntityManager.close();
      }
      if (paramQidianCorpInfo != null)
      {
        localEntityManager.persistOrReplace(paramQidianCorpInfo);
        if (paramQidianProfileUiInfo == null) {
          break label168;
        }
        localEntityManager.persistOrReplace(paramQidianProfileUiInfo);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread success");
        }
        localEntityManager.close();
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread externalInfo is null");
        break;
        if (!QLog.isColorLevel()) {
          break label62;
        }
        QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread corpInfo is null");
        break label62;
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread uiInfo is null");
        }
      }
    }
    label168:
    QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread em is null");
  }
  
  private void b(QidianExternalInfo paramQidianExternalInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread");
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    if (localEntityManager != null) {
      if (paramQidianExternalInfo == null) {}
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          paramQidianExternalInfo.setStatus(1000);
          localEntityManager.persistOrReplace(paramQidianExternalInfo);
          if (paramQidianProfileUiInfo == null) {
            continue;
          }
          localEntityManager.persistOrReplace(paramQidianProfileUiInfo);
        }
        catch (Exception paramQidianExternalInfo)
        {
          paramQidianExternalInfo.printStackTrace();
          return;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread uiInfo is null");
          continue;
        }
        finally
        {
          localEntityManager.close();
        }
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread success");
        }
        localEntityManager.close();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread externalInfo is null");
        }
      }
    }
    QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread em is null");
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x10) != 0;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).f(paramString);
  }
  
  private String c(String paramString)
  {
    String str = "";
    if (a(paramString))
    {
      QidianExternalInfo localQidianExternalInfo = (QidianExternalInfo)this.b.get(paramString);
      if ((localQidianExternalInfo != null) && (!TextUtils.isEmpty(localQidianExternalInfo.masterUin)))
      {
        paramString = (QidianCorpInfo)this.d.get(localQidianExternalInfo.masterUin);
        if (paramString == null) {
          break label122;
        }
      }
    }
    label122:
    for (paramString = paramString.corpName;; paramString = "")
    {
      str = paramString;
      do
      {
        do
        {
          return str;
        } while (!QLog.isColorLevel());
        QLog.d("QidianManager", 4, "QidianExternalInfo is null or masterUin is empty for uin: " + paramString);
        return "";
      } while (!QLog.isColorLevel());
      QLog.d("QidianManager", 4, "uin is no qidian account");
      return "";
    }
  }
  
  private void c(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.query(BmqqUserSimpleInfo.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        BmqqUserSimpleInfo localBmqqUserSimpleInfo = (BmqqUserSimpleInfo)paramEntityManager.next();
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 4, "loadBmqqExtInfo query from db: " + localBmqqUserSimpleInfo);
        }
        String str = localBmqqUserSimpleInfo.mBmqqUin;
        this.f.put(str, localBmqqUserSimpleInfo);
      }
    }
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
    return (paramQQAppInterface.a(paramString)) || (paramQQAppInterface.f(paramString));
  }
  
  private void d(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.query(QidianCorpInfo.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        QidianCorpInfo localQidianCorpInfo = (QidianCorpInfo)paramEntityManager.next();
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 4, "loadCorpInfo query from db: " + localQidianCorpInfo);
        }
        String str = localQidianCorpInfo.corpUin;
        this.d.put(str, localQidianCorpInfo);
      }
    }
  }
  
  private void e(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.query(QidianProfileUiInfo.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        QidianProfileUiInfo localQidianProfileUiInfo = (QidianProfileUiInfo)paramEntityManager.next();
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 4, "loadQidianProfileUiInfo query from db: " + localQidianProfileUiInfo);
        }
        this.e.put(localQidianProfileUiInfo.uin, localQidianProfileUiInfo);
      }
    }
  }
  
  private void f(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.query(QidianPAForWpa.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        QidianPAForWpa localQidianPAForWpa = (QidianPAForWpa)paramEntityManager.next();
        this.g.put(localQidianPAForWpa.puin, localQidianPAForWpa);
      }
    }
  }
  
  public int a(String paramString)
  {
    return ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue();
  }
  
  public int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    int j = 1;
    if (!a(paramString, paramQQAppInterface)) {
      j = 5;
    }
    do
    {
      return j;
      if (f(paramString)) {
        return 6;
      }
      if (CrmUtils.b(paramQQAppInterface, paramString, 0)) {
        return 3;
      }
    } while (a(paramString));
    if (a(paramString, true)) {
      return 0;
    }
    return 4;
  }
  
  public QidianCorpInfo a(String paramString)
  {
    QidianCorpInfo localQidianCorpInfo = null;
    if (this.d.containsKey(paramString)) {
      localQidianCorpInfo = (QidianCorpInfo)this.d.get(paramString);
    }
    return localQidianCorpInfo;
  }
  
  public QidianExternalInfo a(String paramString)
  {
    QidianExternalInfo localQidianExternalInfo = null;
    if (this.b.containsKey(paramString)) {
      localQidianExternalInfo = (QidianExternalInfo)this.b.get(paramString);
    }
    return localQidianExternalInfo;
  }
  
  public QidianInternalInfo a(String paramString)
  {
    QidianInternalInfo localQidianInternalInfo = null;
    if (this.c.containsKey(paramString)) {
      localQidianInternalInfo = (QidianInternalInfo)this.c.get(paramString);
    }
    return localQidianInternalInfo;
  }
  
  public QidianProfileUiInfo a(String paramString)
  {
    QidianProfileUiInfo localQidianProfileUiInfo = null;
    if (this.e.containsKey(paramString)) {
      localQidianProfileUiInfo = (QidianProfileUiInfo)this.e.get(paramString);
    }
    return localQidianProfileUiInfo;
  }
  
  public String a(Context paramContext, String paramString)
  {
    paramString = c(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return String.format(paramContext.getString(2131698550), new Object[] { paramString });
    }
    return paramContext.getString(2131698549);
  }
  
  public String a(String paramString)
  {
    if (this.b.containsKey(paramString))
    {
      paramString = (QidianExternalInfo)this.b.get(paramString);
      if (paramString != null) {
        return paramString.masterUin;
      }
    }
    return "";
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    Object localObject2;
    FragmentActivity localFragmentActivity;
    do
    {
      do
      {
        return;
        localObject1 = String.valueOf(paramLong);
        localObject2 = StructMsgFactory.a(paramString.getBytes(), 0);
      } while ((localObject2 == null) || ((!(BaseActivity.sTopActivity instanceof SplashActivity)) && (!(BaseActivity.sTopActivity instanceof ChatActivity))));
      localFragmentActivity = (FragmentActivity)BaseActivity.sTopActivity;
    } while ((localFragmentActivity.getChatFragment() == null) || (!localFragmentActivity.getChatFragment().a.a.jdField_a_of_type_JavaLangString.equals(localObject1)));
    paramString = (MessageForStructing)MessageRecordFactory.a(-2011);
    paramString.msgtype = -2011;
    paramString.istroop = localFragmentActivity.getChatFragment().a.a.jdField_a_of_type_Int;
    paramString.issend = 0;
    paramString.isread = true;
    paramString.selfuin = paramQQAppInterface.getCurrentAccountUin();
    paramString.mIsParsed = true;
    paramString.frienduin = ((String)localObject1);
    paramString.senderuin = ((String)localObject1);
    paramString.structingMsg = ((AbsStructMsg)localObject2);
    paramString.msgData = ((AbsStructMsg)localObject2).getBytes();
    paramString.saveExtInfoToExtStr("is_eman_sc_message", "1");
    if (this.i.get(localObject1) == null)
    {
      localObject2 = new ArrayList();
      ((List)localObject2).add(paramString);
      this.i.put(localObject1, localObject2);
    }
    for (;;)
    {
      localObject1 = new ArrayList();
      if (MessageHandlerUtils.a(paramQQAppInterface, paramString, false)) {
        break;
      }
      ((ArrayList)localObject1).add(paramString);
      paramQQAppInterface.getMessageFacade().b((List)localObject1, String.valueOf(paramQQAppInterface.getCurrentAccountUin()));
      return;
      ((List)this.i.get(localObject1)).add(paramString);
    }
  }
  
  public void a(BmqqUserSimpleInfo paramBmqqUserSimpleInfo)
  {
    if (paramBmqqUserSimpleInfo != null) {
      this.f.put(paramBmqqUserSimpleInfo.mBmqqUin, paramBmqqUserSimpleInfo);
    }
    if (UiThreadUtil.a())
    {
      ThreadManager.post(new QidianManager.2(this, paramBmqqUserSimpleInfo), 5, null, true);
      return;
    }
    b(paramBmqqUserSimpleInfo);
  }
  
  public void a(BmqqAccountType paramBmqqAccountType)
  {
    if (paramBmqqAccountType != null) {
      this.jdField_a_of_type_JavaUtilMap.put(paramBmqqAccountType.getUin(), Integer.valueOf(paramBmqqAccountType.getAccountType()));
    }
  }
  
  public void a(QidianExternalInfo paramQidianExternalInfo, QidianInternalInfo paramQidianInternalInfo, QidianCorpInfo paramQidianCorpInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    if (paramQidianExternalInfo != null) {
      this.b.put(paramQidianExternalInfo.uin, paramQidianExternalInfo);
    }
    if (paramQidianCorpInfo != null) {
      this.d.put(paramQidianCorpInfo.corpUin, paramQidianCorpInfo);
    }
    if (paramQidianProfileUiInfo != null) {
      this.e.put(paramQidianProfileUiInfo.uin, paramQidianProfileUiInfo);
    }
    if (paramQidianInternalInfo != null) {
      this.c.put(paramQidianInternalInfo.uin, paramQidianInternalInfo);
    }
    if (UiThreadUtil.a())
    {
      ThreadManager.post(new QidianManager.3(this, paramQidianExternalInfo, paramQidianInternalInfo, paramQidianCorpInfo, paramQidianProfileUiInfo), 5, null, true);
      return;
    }
    b(paramQidianExternalInfo, paramQidianInternalInfo, paramQidianCorpInfo, paramQidianProfileUiInfo);
  }
  
  public void a(QidianExternalInfo paramQidianExternalInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    if (paramQidianExternalInfo != null) {
      this.b.put(paramQidianExternalInfo.uin, paramQidianExternalInfo);
    }
    if (paramQidianProfileUiInfo != null) {
      this.e.put(paramQidianProfileUiInfo.uin, paramQidianProfileUiInfo);
    }
    if (UiThreadUtil.a())
    {
      ThreadManager.post(new QidianManager.8(this, paramQidianExternalInfo, paramQidianProfileUiInfo), 5, null, true);
      return;
    }
    b(paramQidianExternalInfo, paramQidianProfileUiInfo);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = paramString.split("\\?");
      } while (localObject1.length != 2);
      localObject2 = localObject1[1].split("&");
      localObject1 = new HashMap();
      int k = localObject2.length;
      int j = 0;
      if (j < k)
      {
        String[] arrayOfString = localObject2[j].split("=");
        if (arrayOfString.length != 2) {}
        for (;;)
        {
          j += 1;
          break;
          ((HashMap)localObject1).put(arrayOfString[0], arrayOfString[1]);
        }
      }
      localObject2 = (String)((HashMap)localObject1).get("aioType");
      localObject1 = (String)((HashMap)localObject1).get("uin");
    } while ((TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty((CharSequence)localObject1)));
    a(paramString, (String)localObject2, (String)localObject1);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = (List)this.i.get(paramString);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord != null) && (paramInt == localMessageRecord.istroop)) {
          ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getMessageFacade().b(paramString, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, boolean paramBoolean, double paramDouble1, double paramDouble2, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(paramString1, paramInt1, paramBoolean, 0.0D, 0.0D, paramString2, paramInt2, paramString3, paramString4, paramString5);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.g.containsKey(paramString1)) {}
    for (QidianPAForWpa localQidianPAForWpa = (QidianPAForWpa)this.g.get(paramString1);; localQidianPAForWpa = new QidianPAForWpa())
    {
      localQidianPAForWpa.puin = paramString1;
      localQidianPAForWpa.kfuin = paramString2;
      this.g.put(paramString1, localQidianPAForWpa);
      if (!UiThreadUtil.a()) {
        break;
      }
      ThreadManager.post(new QidianManager.6(this, localQidianPAForWpa, paramString1, paramString2), 5, null, true);
      return;
    }
    a(localQidianPAForWpa, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    String str = "";
    if (paramString2.equals("1")) {
      paramString2 = str;
    }
    for (;;)
    {
      ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(paramString1, paramString2, paramString3);
      return;
      if (paramString2.equals("2"))
      {
        paramString2 = paramString3;
        paramString3 = "";
      }
      else
      {
        paramString3 = "";
        paramString2 = str;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(paramString3)) {
        break label31;
      }
    }
    for (;;)
    {
      a(paramString4, 1, paramInt, paramString5);
      return;
      paramString3 = paramString2;
      break;
      label31:
      paramString4 = paramString3;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((!BmqqSegmentUtil.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (BmqqSegmentUtil.a(null, paramString)))
    {
      TempGetProfileDetailProcessor localTempGetProfileDetailProcessor = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.jdField_a_of_type_ComTencentCommonAppAppInterface, TempGetProfileDetailProcessor.class);
      if (localTempGetProfileDetailProcessor != null) {
        localTempGetProfileDetailProcessor.getQidianExt(paramString, paramBoolean);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((QidianManager.OnLbsStateChangedListener)localIterator.next()).a(paramBoolean);
    }
  }
  
  public boolean a(Context paramContext, BmqqAccountType paramBmqqAccountType)
  {
    if (paramBmqqAccountType == null) {}
    for (;;)
    {
      return false;
      paramContext = paramBmqqAccountType.getUin();
      try
      {
        long l = Long.parseLong(paramContext);
        if (BmqqSegmentUtil.a(paramContext))
        {
          switch (paramBmqqAccountType.getAccountType())
          {
          default: 
            return false;
          case 1: 
            ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).b(l);
            return true;
          }
          ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).d(l);
          return true;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return b(paramString, true);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    try
    {
      Long.parseLong(paramString);
      if (!BmqqSegmentUtil.a(paramString)) {}
      while ((BmqqSegmentUtil.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!BmqqSegmentUtil.a(null, paramString))) {
        return false;
      }
      if (this.f.containsKey(paramString)) {}
      for (;;)
      {
        return bool;
        if (!a(paramString, 1))
        {
          if (!paramBoolean) {
            a(paramString, false);
          }
          bool = false;
        }
      }
      return false;
    }
    catch (Exception paramString) {}
  }
  
  public String b(String paramString)
  {
    paramString = (QidianPAForWpa)this.g.get(paramString);
    if (paramString != null) {
      return paramString.kfuin;
    }
    return null;
  }
  
  public void b(String paramString)
  {
    TempGetProfileDetailProcessor localTempGetProfileDetailProcessor = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.jdField_a_of_type_ComTencentCommonAppAppInterface, TempGetProfileDetailProcessor.class);
    if (localTempGetProfileDetailProcessor != null) {
      localTempGetProfileDetailProcessor.getQidianMaster(paramString);
    }
  }
  
  public boolean b(Context paramContext, BmqqAccountType paramBmqqAccountType)
  {
    if (paramBmqqAccountType == null) {}
    for (;;)
    {
      return false;
      paramContext = paramBmqqAccountType.getUin();
      try
      {
        long l = Long.parseLong(paramContext);
        if (BmqqSegmentUtil.a(paramContext))
        {
          switch (paramBmqqAccountType.getAccountType())
          {
          case 3: 
          case 4: 
          case 5: 
          default: 
            return false;
          case 0: 
          case 2: 
            ((BmqqBusinessHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.BMQQ_BUSINESS_HANDLER)).a(paramContext);
            return true;
          case 1: 
            ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(l);
            return true;
          }
          ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).c(l);
          return true;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b.containsKey(paramString))
    {
      paramString = (QidianExternalInfo)this.b.get(paramString);
      bool1 = bool2;
      if (paramString != null) {
        if (paramString.isShowCall != 1) {
          break label49;
        }
      }
    }
    label49:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    boolean bool2;
    try
    {
      Long.parseLong(paramString);
      if (!BmqqSegmentUtil.a(paramString))
      {
        bool2 = false;
        return bool2;
      }
    }
    catch (Exception paramString)
    {
      return false;
    }
    if ((BmqqSegmentUtil.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!BmqqSegmentUtil.a(null, paramString))) {
      return false;
    }
    boolean bool1;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      if (((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue() != 1) {
        break label152;
      }
      bool1 = true;
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      bool2 = bool1;
      if (this.b.get(paramString) != null) {
        break;
      }
      bool2 = bool1;
      if (paramBoolean) {
        break;
      }
      if (!UiThreadUtil.a()) {
        break label157;
      }
      ThreadManager.post(new QidianManager.4(this, paramString), 5, null, true);
      return bool1;
      if (a(paramString, 4))
      {
        bool1 = true;
      }
      else
      {
        if (!paramBoolean) {
          a(paramString, false);
        }
        label152:
        bool1 = false;
      }
    }
    label157:
    b(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getBaseContext(), new BmqqAccountType(paramString, 1));
    return bool1;
  }
  
  public boolean c(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b.containsKey(paramString))
    {
      paramString = (QidianExternalInfo)this.b.get(paramString);
      bool1 = bool2;
      if (paramString != null) {
        if (paramString.isShowVideoCall != 1) {
          break label49;
        }
      }
    }
    label49:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean c(String paramString, boolean paramBoolean)
  {
    boolean bool1 = false;
    label393:
    for (;;)
    {
      try
      {
        Long.parseLong(paramString);
        if (!BmqqSegmentUtil.a(paramString))
        {
          paramBoolean = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("QidianManager", 2, "isQidianMaster uin is not in bmqqsegment");
            paramBoolean = bool1;
          }
          return paramBoolean;
        }
        if ((BmqqSegmentUtil.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (BmqqSegmentUtil.a(null, paramString)))
        {
          paramBoolean = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("QidianManager", 2, "isQidianMaster is bmqquin");
            return false;
          }
        }
        else
        {
          bool1 = a(paramString, 16);
          boolean bool2;
          if (!bool1)
          {
            if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
            {
              if (((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue() != 6) {
                break label393;
              }
              QLog.i("QidianManager", 1, MsfSdkUtils.getShortUin(paramString) + " isQidianMaster is qidianmain");
              bool2 = true;
              bool1 = bool2;
              if (!paramBoolean)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QidianManager", 2, "isQidianMaster not only in cache 0");
                }
                b(paramString);
                bool1 = bool2;
              }
              if ((bool1) && (!paramBoolean))
              {
                QidianExternalInfo localQidianExternalInfo = a(String.valueOf(paramString));
                QidianProfileUiInfo localQidianProfileUiInfo = a(String.valueOf(paramString));
                if ((localQidianExternalInfo == null) || (localQidianProfileUiInfo == null))
                {
                  if (!UiThreadUtil.a()) {
                    continue;
                  }
                  ThreadManager.post(new QidianManager.7(this, paramString), 5, null, true);
                }
              }
              paramBoolean = bool1;
              if (!bool1) {
                continue;
              }
              QLog.i("QidianManager", 1, MsfSdkUtils.getShortUin(paramString) + " isQidianMaster is true finally");
              return bool1;
            }
            if (!paramBoolean)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QidianManager", 2, "isQidianMaster not only in cache 1");
              }
              b(paramString);
              continue;
            }
          }
          else if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
          {
            a(new BmqqAccountType(paramString, 6));
            if (QLog.isColorLevel()) {
              QLog.d("QidianManager", 2, "isQidianMaster update account type");
            }
          }
          continue;
          b(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getBaseContext(), new BmqqAccountType(paramString, 6));
          if (QLog.isColorLevel())
          {
            QLog.d("QidianManager", 2, "isQidianMaster get user detail");
            continue;
            bool2 = bool1;
          }
        }
      }
      catch (Exception paramString)
      {
        return false;
      }
    }
  }
  
  public boolean d(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(a(paramString)))
    {
      bool1 = bool2;
      if (b(paramString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean e(String paramString)
  {
    try
    {
      Long.parseLong(paramString);
      if ((this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue() == 3)) {
        return true;
      }
    }
    catch (Exception paramString)
    {
      return false;
    }
    return false;
  }
  
  public boolean f(String paramString)
  {
    return c(paramString, true);
  }
  
  public boolean g(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 4, "onDestroyd ...");
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    if (this.b != null) {
      this.b.clear();
    }
    if (this.c != null) {
      this.c.clear();
    }
    if (this.d != null) {
      this.d.clear();
    }
    if (this.e != null) {
      this.e.clear();
    }
    if (this.f != null) {
      this.f.clear();
    }
    if (this.g != null) {
      this.g.clear();
    }
    if (this.h != null) {
      this.h.clear();
    }
    if (this.i != null) {
      this.i.clear();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.QidianManager
 * JD-Core Version:    0.7.0.1
 */