package com.tencent.qidian;

import akvx;
import akvy;
import akvz;
import akwa;
import akwb;
import akwc;
import akwd;
import akwe;
import akwf;
import akwg;
import akwh;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.bmqq.app.BmqqBusinessHandler;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
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
  private List a;
  public Map a;
  public Map b;
  public Map c;
  public Map d;
  public Map e;
  public Map f;
  public Map g;
  public Map h;
  public Map i;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public QidianManager(AppInterface paramAppInterface)
  {
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
      ThreadManager.getSubThreadHandler().post(new akvx(this));
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
    String str = ContactUtils.n(paramQQAppInterface, paramString);
    if ((TextUtils.isEmpty(str)) || (str.equals(paramString)))
    {
      paramQQAppInterface = ((QidianManager)paramQQAppInterface.getManager(164)).a(String.valueOf(paramString));
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
      c(localEntityManager);
      e(localEntityManager);
      f(localEntityManager);
      d(localEntityManager);
      g(localEntityManager);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QidianManager", 2, "QidianManager get data from db error: " + localException.getMessage());
        }
        localEntityManager.a();
      }
    }
    finally
    {
      localEntityManager.a();
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
    //   12: ifnonnull +204 -> 216
    //   15: ldc 192
    //   17: astore 9
    //   19: aload_3
    //   20: ifnonnull +211 -> 231
    //   23: ldc 192
    //   25: astore_2
    //   26: aload 4
    //   28: ifnonnull +217 -> 245
    //   31: ldc 192
    //   33: astore_3
    //   34: new 171	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   41: astore 10
    //   43: iload_1
    //   44: bipush 6
    //   46: if_icmpne +233 -> 279
    //   49: ldc 194
    //   51: astore 4
    //   53: aload 10
    //   55: aload 4
    //   57: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 10
    //   63: ldc 196
    //   65: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 10
    //   71: ldc 198
    //   73: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload 5
    //   78: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 10
    //   84: ldc 200
    //   86: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 9
    //   91: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 10
    //   97: ldc 202
    //   99: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_2
    //   103: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 10
    //   109: ldc 204
    //   111: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_3
    //   115: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 10
    //   121: ldc 206
    //   123: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: astore_3
    //   127: iload 8
    //   129: ifeq +158 -> 287
    //   132: ldc 208
    //   134: astore_2
    //   135: aload_3
    //   136: aload_2
    //   137: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 10
    //   143: ldc 210
    //   145: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload 7
    //   150: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 10
    //   156: ldc 215
    //   158: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 6
    //   163: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: new 217	android/content/Intent
    //   170: dup
    //   171: ldc 219
    //   173: aload 10
    //   175: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 225	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   181: invokespecial 228	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   184: astore_2
    //   185: aload_2
    //   186: ldc 230
    //   188: ldc 232
    //   190: invokevirtual 236	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   193: pop
    //   194: aload_0
    //   195: aload_2
    //   196: invokevirtual 242	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   199: return
    //   200: aload 5
    //   202: ldc 244
    //   204: invokevirtual 248	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   207: iconst_2
    //   208: invokestatic 254	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   211: astore 5
    //   213: goto -202 -> 11
    //   216: aload_2
    //   217: ldc 244
    //   219: invokevirtual 248	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   222: iconst_2
    //   223: invokestatic 254	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   226: astore 9
    //   228: goto -209 -> 19
    //   231: aload_3
    //   232: ldc 244
    //   234: invokevirtual 248	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   237: iconst_2
    //   238: invokestatic 254	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   241: astore_2
    //   242: goto -216 -> 26
    //   245: aload 4
    //   247: ldc 244
    //   249: invokevirtual 248	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   252: iconst_2
    //   253: invokestatic 254	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   256: astore_3
    //   257: goto -223 -> 34
    //   260: astore_3
    //   261: aconst_null
    //   262: astore 9
    //   264: aconst_null
    //   265: astore 5
    //   267: aconst_null
    //   268: astore_2
    //   269: aload_3
    //   270: invokevirtual 257	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   273: aload 10
    //   275: astore_3
    //   276: goto -242 -> 34
    //   279: ldc_w 259
    //   282: astore 4
    //   284: goto -231 -> 53
    //   287: ldc_w 261
    //   290: astore_2
    //   291: goto -156 -> 135
    //   294: astore_3
    //   295: aconst_null
    //   296: astore 9
    //   298: aconst_null
    //   299: astore_2
    //   300: goto -31 -> 269
    //   303: astore_3
    //   304: aconst_null
    //   305: astore_2
    //   306: goto -37 -> 269
    //   309: astore_3
    //   310: goto -41 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	paramActivity	android.app.Activity
    //   0	313	1	paramInt1	int
    //   0	313	2	paramString1	String
    //   0	313	3	paramString2	String
    //   0	313	4	paramString3	String
    //   0	313	5	paramString4	String
    //   0	313	6	paramString5	String
    //   0	313	7	paramInt2	int
    //   0	313	8	paramBoolean	boolean
    //   17	280	9	str	String
    //   1	273	10	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   200	213	260	java/io/UnsupportedEncodingException
    //   216	228	294	java/io/UnsupportedEncodingException
    //   231	242	303	java/io/UnsupportedEncodingException
    //   245	257	309	java/io/UnsupportedEncodingException
  }
  
  public static void a(Context paramContext, ArrayList paramArrayList)
  {
    Object localObject = paramContext.getPackageManager();
    if (new Intent().setPackage("com.tencent.qidian").setData(Uri.parse("qdapi://")).resolveActivity((PackageManager)localObject) != null)
    {
      localObject = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = paramContext.getString(2131430113);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_b_of_type_Int = 2130841678;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).c = 19;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
      paramArrayList.add(localObject);
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
        QidianManager localQidianManager = (QidianManager)paramQQAppInterface.getManager(164);
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
            ThreadManager.post(new akvz(localQidianManager, paramQQAppInterface, localBmqqAccountType), 5, null, true);
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
      ((QidianManager)paramQQAppInterface.getManager(164)).h.put(paramString1, paramString2);
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends[] paramArrayOfFriends)
  {
    QidianManager localQidianManager;
    if (paramArrayOfFriends != null)
    {
      localQidianManager = (QidianManager)paramQQAppInterface.getManager(164);
      if (UiThreadUtil.a()) {
        ThreadManager.postImmediately(new akvy(localQidianManager, paramQQAppInterface, paramArrayOfFriends), null, false);
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
    paramEntityManager = paramEntityManager.a(BmqqAccountType.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        BmqqAccountType localBmqqAccountType = (BmqqAccountType)paramEntityManager.next();
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 4, "loadAccountType query from db: " + localBmqqAccountType);
        }
        String str = localBmqqAccountType.getUin();
        int j = localBmqqAccountType.getAccountType();
        this.jdField_a_of_type_JavaUtilMap.put(str, Integer.valueOf(j));
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
          paramString1.b(paramQidianPAForWpa);
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
          paramString1.a();
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
          break label364;
        }
        SosoInterface.a(new akwe(this, 1, true, true, 0L, true, false, "QidianManager", paramString1, paramInt1, str3, paramInt2, str2, str1, paramString2));
      }
    }
    label364:
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
    paramQQAppInterface = (QidianManager)paramQQAppInterface.getManager(164);
    boolean bool1 = bool2;
    if (paramFriends != null)
    {
      bool1 = bool2;
      if (b(paramFriends.cSpecialFlag)) {
        if ((paramInt != 1) && (paramInt != 2) && (paramInt != 13) && (paramInt != 10001)) {
          break label61;
        }
      }
    }
    label61:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    return ((((QidianManager)paramQQAppInterface.getManager(164)).a(paramMessageRecord.frienduin)) || (paramMessageRecord.istroop == 1024)) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("is_eman_sc_message")));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((QidianManager)paramQQAppInterface.getManager(164)).e(paramString);
  }
  
  private boolean a(String paramString, int paramInt)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(50);
    if (localFriendsManager != null)
    {
      paramString = localFriendsManager.a(paramString);
      if ((paramString != null) && ((paramString.cSpecialFlag & paramInt) != 0)) {
        return true;
      }
    }
    return false;
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
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (QidianManager)paramQQAppInterface.getManager(164);
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
  
  private void b(QQAppInterface paramQQAppInterface, Friends[] paramArrayOfFriends)
  {
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    EntityTransaction localEntityTransaction;
    if (localEntityManager != null) {
      localEntityTransaction = localEntityManager.a();
    }
    for (;;)
    {
      int j;
      Object localObject1;
      Object localObject2;
      boolean bool3;
      try
      {
        localEntityTransaction.a();
        int k = paramArrayOfFriends.length;
        j = 0;
        if (j >= k) {
          break label365;
        }
        localObject1 = paramArrayOfFriends[j];
        localObject2 = ((Friends)localObject1).uin;
        int m = ((Friends)localObject1).cSpecialFlag;
        try
        {
          Long.parseLong((String)localObject2);
          bool1 = BmqqSegmentUtil.a((String)localObject2);
          if (!bool1) {
            return;
          }
        }
        catch (Exception paramQQAppInterface)
        {
          return;
        }
        bool1 = b(m);
        bool2 = a(m);
        bool3 = c(m);
        if ((!bool1) && (!bool2) && (!bool3))
        {
          if (!QLog.isColorLevel()) {
            break label381;
          }
          QLog.d("QidianManager", 2, "updateQidianAccountType ignore uin: " + (String)localObject2 + " | cSpecialFlag: " + m);
          break label381;
        }
        localObject1 = null;
        if (!bool1) {
          continue;
        }
        localObject1 = new BmqqAccountType((String)localObject2, 6);
      }
      catch (Exception paramQQAppInterface)
      {
        boolean bool1;
        boolean bool2;
        QidianExternalInfo localQidianExternalInfo;
        paramQQAppInterface.printStackTrace();
        return;
        if (!bool2) {
          break label345;
        }
        localObject1 = new BmqqAccountType((String)localObject2, 1);
        continue;
      }
      finally
      {
        localEntityTransaction.b();
        localEntityManager.a();
      }
      if ((localObject1 != null) && (a((String)localObject2) != ((BmqqAccountType)localObject1).getAccountType()))
      {
        this.jdField_a_of_type_JavaUtilMap.put(localObject2, Integer.valueOf(((BmqqAccountType)localObject1).getAccountType()));
        localEntityManager.b((Entity)localObject1);
        if (bool1)
        {
          localQidianExternalInfo = a((String)localObject2);
          localObject2 = a((String)localObject2);
          if ((localQidianExternalInfo == null) || (localObject2 == null))
          {
            b(paramQQAppInterface.getApp().getBaseContext(), (BmqqAccountType)localObject1);
            break label381;
            label345:
            if (!bool3) {
              continue;
            }
            localObject1 = new BmqqAccountType((String)localObject2, 3);
            continue;
            label365:
            localEntityTransaction.c();
            localEntityTransaction.b();
            localEntityManager.a();
            return;
          }
        }
      }
      label381:
      j += 1;
    }
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
          localEntityManager.b(paramBmqqUserSimpleInfo);
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
          localEntityManager.a();
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
    paramEntityManager = paramEntityManager.a(QidianExternalInfo.class);
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
        localEntityManager.b(paramQidianExternalInfo);
        if (paramQidianInternalInfo == null) {
          break label124;
        }
        localEntityManager.b(paramQidianInternalInfo);
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
        localEntityManager.a();
      }
      if (paramQidianCorpInfo != null)
      {
        localEntityManager.b(paramQidianCorpInfo);
        if (paramQidianProfileUiInfo == null) {
          break label168;
        }
        localEntityManager.b(paramQidianProfileUiInfo);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread success");
        }
        localEntityManager.a();
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
          localEntityManager.b(paramQidianExternalInfo);
          if (paramQidianProfileUiInfo == null) {
            continue;
          }
          localEntityManager.b(paramQidianProfileUiInfo);
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
          localEntityManager.a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread success");
        }
        localEntityManager.a();
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
    return ((QidianManager)paramQQAppInterface.getManager(164)).f(paramString);
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
    paramEntityManager = paramEntityManager.a(QidianInternalInfo.class);
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
  
  public static boolean c(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (QidianManager)paramQQAppInterface.getManager(164);
    return (paramQQAppInterface.a(paramString)) || (paramQQAppInterface.f(paramString));
  }
  
  private void d(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.a(BmqqUserSimpleInfo.class);
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
  
  private void e(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.a(QidianCorpInfo.class);
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
  
  private void f(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.a(QidianProfileUiInfo.class);
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
  
  private void g(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.a(QidianPAForWpa.class);
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
      return String.format(paramContext.getString(2131435851), new Object[] { paramString });
    }
    return paramContext.getString(2131435850);
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
      paramQQAppInterface.a().c((List)localObject1, String.valueOf(paramQQAppInterface.getCurrentAccountUin()));
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
      ThreadManager.post(new akwb(this, paramBmqqUserSimpleInfo), 5, null, true);
      return;
    }
    b(paramBmqqUserSimpleInfo);
  }
  
  public void a(QidianManager.OnLbsStateChangedListener paramOnLbsStateChangedListener)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramOnLbsStateChangedListener)) {
      this.jdField_a_of_type_JavaUtilList.add(paramOnLbsStateChangedListener);
    }
  }
  
  public void a(BmqqAccountType paramBmqqAccountType)
  {
    if (paramBmqqAccountType != null)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramBmqqAccountType.getUin(), Integer.valueOf(paramBmqqAccountType.getAccountType()));
      if (!UiThreadUtil.a()) {
        break label47;
      }
      ThreadManager.post(new akwa(this, paramBmqqAccountType), 5, null, true);
    }
    label47:
    EntityManager localEntityManager;
    do
    {
      return;
      localEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
    } while (localEntityManager == null);
    try
    {
      localEntityManager.b(paramBmqqAccountType);
      return;
    }
    finally
    {
      localEntityManager.a();
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
      ThreadManager.post(new akwc(this, paramQidianExternalInfo, paramQidianInternalInfo, paramQidianCorpInfo, paramQidianProfileUiInfo), 5, null, true);
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
      ThreadManager.post(new akwh(this, paramQidianExternalInfo, paramQidianProfileUiInfo), 5, null, true);
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
          ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().b(paramString, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, boolean paramBoolean, double paramDouble1, double paramDouble2, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(85)).a(paramString1, paramInt1, paramBoolean, 0.0D, 0.0D, paramString2, paramInt2, paramString3, paramString4, paramString5);
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
      ThreadManager.post(new akwf(this, localQidianPAForWpa, paramString1, paramString2), 5, null, true);
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
      ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(85)).a(paramString1, paramString2, paramString3);
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
    if ((!BmqqSegmentUtil.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (BmqqSegmentUtil.a(null, paramString))) {
      ((CardHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(2)).a(paramString, paramBoolean);
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
            ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(85)).b(l);
            return true;
          }
          ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(85)).d(l);
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
  
  public void b(QidianManager.OnLbsStateChangedListener paramOnLbsStateChangedListener)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramOnLbsStateChangedListener)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramOnLbsStateChangedListener);
    }
  }
  
  public void b(String paramString)
  {
    ((CardHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(2)).e(paramString);
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
            ((BmqqBusinessHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(37)).a(paramContext);
            return true;
          case 1: 
            ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(85)).a(l);
            return true;
          }
          ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(85)).c(l);
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
      ThreadManager.post(new akwd(this, paramString), 5, null, true);
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
    boolean bool1;
    for (boolean bool2 = false;; bool2 = bool1) {
      try
      {
        Long.parseLong(paramString);
        if (!BmqqSegmentUtil.a(paramString)) {}
        while ((BmqqSegmentUtil.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (BmqqSegmentUtil.a(null, paramString))) {
          return bool2;
        }
        bool1 = a(paramString, 16);
        if (!bool1) {
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
          {
            if (((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue() != 6) {
              continue;
            }
            bool2 = true;
            bool1 = bool2;
            if (!paramBoolean)
            {
              b(paramString);
              bool1 = bool2;
            }
          }
        }
        for (;;)
        {
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          bool2 = bool1;
          if (paramBoolean) {
            break;
          }
          QidianExternalInfo localQidianExternalInfo = a(String.valueOf(paramString));
          QidianProfileUiInfo localQidianProfileUiInfo = a(String.valueOf(paramString));
          if (localQidianExternalInfo != null)
          {
            bool2 = bool1;
            if (localQidianProfileUiInfo != null) {
              break;
            }
          }
          if (!UiThreadUtil.a()) {
            break label211;
          }
          ThreadManager.post(new akwg(this, paramString), 5, null, true);
          return bool1;
          if (!paramBoolean)
          {
            b(paramString);
            continue;
            if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
              a(new BmqqAccountType(paramString, 6));
            }
          }
        }
        label211:
        b(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getBaseContext(), new BmqqAccountType(paramString, 6));
        return bool1;
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
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.qidian.QidianManager
 * JD-Core Version:    0.7.0.1
 */