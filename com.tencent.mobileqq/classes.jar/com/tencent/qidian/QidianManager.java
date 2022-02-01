package com.tencent.qidian;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.bmqq.app.BmqqBusinessHandler;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
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
    } else {
      a();
    }
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str2 = ContactUtils.f(paramQQAppInterface, paramString);
    String str1;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!str2.equals(paramString)) {}
    }
    else
    {
      paramQQAppInterface = ((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).a(String.valueOf(paramString));
      str1 = str2;
      if (paramQQAppInterface != null) {
        str1 = paramQQAppInterface.nickname;
      }
    }
    return str1;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 147
    //   8: iconst_4
    //   9: ldc 149
    //   11: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 63	com/tencent/qidian/QidianManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   18: invokevirtual 158	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   21: invokevirtual 164	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   24: astore_1
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 167	com/tencent/qidian/QidianManager:a	(Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   30: aload_0
    //   31: aload_1
    //   32: invokespecial 169	com/tencent/qidian/QidianManager:b	(Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 171	com/tencent/qidian/QidianManager:d	(Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   40: aload_0
    //   41: aload_1
    //   42: invokespecial 173	com/tencent/qidian/QidianManager:e	(Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   45: aload_0
    //   46: aload_1
    //   47: invokespecial 175	com/tencent/qidian/QidianManager:c	(Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   50: aload_0
    //   51: aload_1
    //   52: invokespecial 177	com/tencent/qidian/QidianManager:f	(Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   55: goto +48 -> 103
    //   58: astore_2
    //   59: goto +56 -> 115
    //   62: astore_2
    //   63: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +37 -> 103
    //   69: new 179	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   76: astore_3
    //   77: aload_3
    //   78: ldc 182
    //   80: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_3
    //   85: aload_2
    //   86: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   89: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: ldc 147
    //   95: iconst_2
    //   96: aload_3
    //   97: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload_1
    //   104: invokevirtual 200	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   107: getstatic 39	com/tencent/qidian/QidianManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   110: iconst_1
    //   111: invokevirtual 203	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   114: return
    //   115: aload_1
    //   116: invokevirtual 200	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   119: aload_2
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	QidianManager
    //   24	92	1	localEntityManager	EntityManager
    //   58	1	2	localObject	Object
    //   62	58	2	localException	Exception
    //   76	21	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   25	55	58	finally
    //   63	103	58	finally
    //   25	55	62	java/lang/Exception
  }
  
  /* Error */
  public static void a(android.app.Activity paramActivity, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aload 5
    //   5: ifnonnull +9 -> 14
    //   8: aconst_null
    //   9: astore 5
    //   11: goto +16 -> 27
    //   14: aload 5
    //   16: ldc 208
    //   18: invokevirtual 212	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   21: iconst_2
    //   22: invokestatic 218	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   25: astore 5
    //   27: aload_2
    //   28: ifnonnull +9 -> 37
    //   31: ldc 220
    //   33: astore_2
    //   34: goto +14 -> 48
    //   37: aload_2
    //   38: ldc 208
    //   40: invokevirtual 212	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   43: iconst_2
    //   44: invokestatic 218	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   47: astore_2
    //   48: aload_3
    //   49: ifnonnull +10 -> 59
    //   52: ldc 220
    //   54: astore 9
    //   56: goto +15 -> 71
    //   59: aload_3
    //   60: ldc 208
    //   62: invokevirtual 212	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   65: iconst_2
    //   66: invokestatic 218	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   69: astore 9
    //   71: aload 4
    //   73: ifnonnull +9 -> 82
    //   76: ldc 220
    //   78: astore_3
    //   79: goto +72 -> 151
    //   82: aload 4
    //   84: ldc 208
    //   86: invokevirtual 212	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   89: iconst_2
    //   90: invokestatic 218	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   93: astore_3
    //   94: goto +57 -> 151
    //   97: astore 4
    //   99: aload_2
    //   100: astore_3
    //   101: aload 9
    //   103: astore_2
    //   104: goto +34 -> 138
    //   107: astore 4
    //   109: aconst_null
    //   110: astore 9
    //   112: aload_2
    //   113: astore_3
    //   114: aload 9
    //   116: astore_2
    //   117: goto +21 -> 138
    //   120: astore 4
    //   122: aconst_null
    //   123: astore_3
    //   124: aload_3
    //   125: astore_2
    //   126: goto +12 -> 138
    //   129: astore 4
    //   131: aconst_null
    //   132: astore_3
    //   133: aload_3
    //   134: astore_2
    //   135: aload_2
    //   136: astore 5
    //   138: aload 4
    //   140: invokevirtual 223	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   143: aload_2
    //   144: astore 9
    //   146: aload_3
    //   147: astore_2
    //   148: aload 10
    //   150: astore_3
    //   151: new 179	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   158: astore 10
    //   160: iload_1
    //   161: bipush 6
    //   163: if_icmpne +10 -> 173
    //   166: ldc 225
    //   168: astore 4
    //   170: goto +7 -> 177
    //   173: ldc 227
    //   175: astore 4
    //   177: aload 10
    //   179: aload 4
    //   181: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 10
    //   187: ldc 229
    //   189: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 10
    //   195: ldc 231
    //   197: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 10
    //   203: aload 5
    //   205: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 10
    //   211: ldc 233
    //   213: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 10
    //   219: aload_2
    //   220: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 10
    //   226: ldc 235
    //   228: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 10
    //   234: aload 9
    //   236: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 10
    //   242: ldc 237
    //   244: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 10
    //   250: aload_3
    //   251: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 10
    //   257: ldc 239
    //   259: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: iload 8
    //   265: ifeq +9 -> 274
    //   268: ldc 241
    //   270: astore_2
    //   271: goto +6 -> 277
    //   274: ldc 243
    //   276: astore_2
    //   277: aload 10
    //   279: aload_2
    //   280: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 10
    //   286: ldc 245
    //   288: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 10
    //   294: iload 7
    //   296: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 10
    //   302: ldc 250
    //   304: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 10
    //   310: aload 6
    //   312: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: new 252	android/content/Intent
    //   319: dup
    //   320: ldc 254
    //   322: aload 10
    //   324: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 260	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   330: invokespecial 263	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   333: astore_2
    //   334: aload_2
    //   335: ldc_w 265
    //   338: ldc_w 267
    //   341: invokevirtual 271	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   344: pop
    //   345: aload_0
    //   346: aload_2
    //   347: invokevirtual 277	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   350: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramActivity	android.app.Activity
    //   0	351	1	paramInt1	int
    //   0	351	2	paramString1	String
    //   0	351	3	paramString2	String
    //   0	351	4	paramString3	String
    //   0	351	5	paramString4	String
    //   0	351	6	paramString5	String
    //   0	351	7	paramInt2	int
    //   0	351	8	paramBoolean	boolean
    //   54	181	9	str	String
    //   1	322	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   82	94	97	java/io/UnsupportedEncodingException
    //   59	71	107	java/io/UnsupportedEncodingException
    //   37	48	120	java/io/UnsupportedEncodingException
    //   14	27	129	java/io/UnsupportedEncodingException
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
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("updateQidianAccountType ignore uin: ");
          paramQQAppInterface.append(paramString);
          paramQQAppInterface.append(" | cSpecialFlag: ");
          paramQQAppInterface.append(paramInt);
          QLog.d("QidianManager", 2, paramQQAppInterface.toString());
        }
        return;
      }
      if (localQidianManager.g(paramString))
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("updateQidianAccountType requested uin: ");
          paramQQAppInterface.append(paramString);
          paramQQAppInterface.append(" | cSpecialFlag: ");
          paramQQAppInterface.append(paramInt);
          QLog.d("QidianManager", 2, paramQQAppInterface.toString());
        }
        return;
      }
      BmqqAccountType localBmqqAccountType;
      if (bool1) {
        localBmqqAccountType = new BmqqAccountType(paramString, 6);
      } else if (bool2) {
        localBmqqAccountType = new BmqqAccountType(paramString, 1);
      } else if (bool3) {
        localBmqqAccountType = new BmqqAccountType(paramString, 3);
      } else {
        localBmqqAccountType = null;
      }
      localQidianManager.a(localBmqqAccountType);
      if (bool1)
      {
        QidianExternalInfo localQidianExternalInfo = localQidianManager.a(paramString);
        paramString = localQidianManager.a(paramString);
        if ((localQidianExternalInfo == null) || (paramString == null))
        {
          if (UiThreadUtil.a())
          {
            ThreadManager.post(new QidianManager.10(localQidianManager, paramQQAppInterface, localBmqqAccountType), 5, null, true);
            return;
          }
          localQidianManager.b(paramQQAppInterface.getApp().getBaseContext(), localBmqqAccountType);
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface) {}
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
    if (paramArrayOfFriends != null)
    {
      QidianManager localQidianManager = (QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
      if (UiThreadUtil.a())
      {
        ThreadManager.postImmediately(new QidianManager.9(localQidianManager, paramQQAppInterface, paramArrayOfFriends), null, false);
        return;
      }
      localQidianManager.b(paramQQAppInterface, paramArrayOfFriends);
    }
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
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("loadExternalInfo query from db: ");
          ((StringBuilder)localObject).append(localQidianExternalInfo);
          QLog.d("QidianManager", 4, ((StringBuilder)localObject).toString());
        }
        Object localObject = localQidianExternalInfo.uin;
        this.b.put(localObject, localQidianExternalInfo);
      }
    }
  }
  
  /* Error */
  private void a(QidianPAForWpa paramQidianPAForWpa, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 147
    //   8: iconst_2
    //   9: ldc_w 447
    //   12: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 63	com/tencent/qidian/QidianManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   19: invokevirtual 158	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   22: invokevirtual 164	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull +68 -> 95
    //   30: aload_1
    //   31: ifnull +11 -> 42
    //   34: aload_2
    //   35: aload_1
    //   36: invokevirtual 451	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   39: goto +18 -> 57
    //   42: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +12 -> 57
    //   48: ldc 147
    //   50: iconst_2
    //   51: ldc_w 453
    //   54: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +24 -> 84
    //   63: ldc 147
    //   65: iconst_2
    //   66: ldc_w 455
    //   69: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: goto +12 -> 84
    //   75: astore_1
    //   76: goto +13 -> 89
    //   79: astore_1
    //   80: aload_1
    //   81: invokevirtual 456	java/lang/Exception:printStackTrace	()V
    //   84: aload_2
    //   85: invokevirtual 200	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   88: return
    //   89: aload_2
    //   90: invokevirtual 200	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   93: aload_1
    //   94: athrow
    //   95: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +12 -> 110
    //   101: ldc 147
    //   103: iconst_2
    //   104: ldc_w 458
    //   107: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	QidianManager
    //   0	111	1	paramQidianPAForWpa	QidianPAForWpa
    //   0	111	2	paramString1	String
    //   0	111	3	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   34	39	75	finally
    //   42	57	75	finally
    //   57	72	75	finally
    //   80	84	75	finally
    //   34	39	79	java/lang/Exception
    //   42	57	79	java/lang/Exception
    //   57	72	79	java/lang/Exception
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("isNeedReply=")) && (paramString1.contains("QidianKfUin=")))
    {
      Object localObject = Pattern.compile("((?:isNeedReply|isNeedLbs|QidianKfUin|isExt|FromStaff|cqq))=([^\\?&=]+)").matcher(paramString1);
      String str3 = "";
      String str1 = str3;
      String str2 = str1;
      boolean bool2 = false;
      boolean bool1 = false;
      while (((Matcher)localObject).find())
      {
        if ("isNeedReply".equals(((Matcher)localObject).group(1))) {
          bool1 = "true".equals(((Matcher)localObject).group(2));
        } else if ("isNeedLbs".equals(((Matcher)localObject).group(1))) {
          bool2 = "true".equals(((Matcher)localObject).group(2));
        } else if ("QidianKfUin".equals(((Matcher)localObject).group(1))) {
          str3 = ((Matcher)localObject).group(2);
        } else if (("isExt".equals(((Matcher)localObject).group(1))) && (paramInt2 != 2)) {}
        try
        {
          boolean bool3 = Boolean.parseBoolean(((Matcher)localObject).group(2));
          paramInt2 = bool3 ^ true;
        }
        catch (Exception localException)
        {
          label192:
          break label192;
        }
        paramInt2 = 0;
        continue;
        if ("FromStaff".equals(((Matcher)localObject).group(1))) {
          str1 = ((Matcher)localObject).group(2);
        } else if ("cqq".equals(((Matcher)localObject).group(1))) {
          str2 = ((Matcher)localObject).group(2);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isNeedLbs: ");
        ((StringBuilder)localObject).append(bool2);
        ((StringBuilder)localObject).append(" | isNeedReply: ");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(" | masterUin: ");
        ((StringBuilder)localObject).append(str3);
        ((StringBuilder)localObject).append(" | srcType: ");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("QidianManager", 2, ((StringBuilder)localObject).toString());
      }
      if (bool1)
      {
        if (bool2)
        {
          ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new QidianManager.5(this, 1, true, true, 0L, true, false, "QidianManager", paramString1, paramInt1, str3, paramInt2, str1, str2, paramString2));
          return;
        }
        a(paramString1, paramInt1, bool2, 0.0D, 0.0D, str3, paramInt2, str1, str2, paramString2);
      }
    }
    else if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("key is null or don't contain isNeedReply : ");
      paramString2.append(paramString1);
      QLog.d("QidianManager", 2, paramString2.toString());
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  public static boolean a(AppInterface paramAppInterface, Friends paramFriends, int paramInt)
  {
    paramAppInterface = (QidianManager)paramAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramFriends != null)
    {
      bool1 = bool2;
      if (b(paramFriends.cSpecialFlag))
      {
        bool1 = bool2;
        if (paramInt != 1)
        {
          bool1 = bool2;
          if (paramInt != 2)
          {
            bool1 = bool2;
            if (paramInt != 13)
            {
              bool1 = bool2;
              if (paramInt != 10001)
              {
                if (paramInt == 7) {
                  return true;
                }
                bool1 = false;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    return ((QidianManager)paramBaseQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).f(paramString);
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((FriendsManager)localObject).b(paramString);
      if ((localObject != null) && (((Friends)localObject).cSpecialFlag < 0))
      {
        QLog.i("QidianManager", 1, "isSpecialAccountInFriend meet error!!");
        return false;
      }
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if ((((Friends)localObject).cSpecialFlag & paramInt) != 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(MsfSdkUtils.getShortUin(paramString));
          localStringBuilder.append(" isSpecialAccountInFriend isSpecialAccount is true, friendInfo.cSpecialFlag: ");
          localStringBuilder.append(((Friends)localObject).cSpecialFlag);
          localStringBuilder.append(" | flag: ");
          localStringBuilder.append(paramInt);
          QLog.i("QidianManager", 1, localStringBuilder.toString());
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(paramQQAppInterface.getAccount()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QidianManager", 2, "app.getAccount() is null");
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("initParm uin = ");
      paramQQAppInterface.append(paramString);
      QLog.i("QidianManager", 2, paramQQAppInterface.toString());
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QidianManager", 2, "mAllinone is null");
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    paramString1 = str;
    if (TextUtils.isEmpty(str)) {
      paramString1 = paramString3;
    }
    return (!TextUtils.isEmpty(paramString1)) && (paramString1.contains("isNeedReply=")) && (paramString1.contains("QidianKfUin="));
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
  
  private void b(QQAppInterface paramQQAppInterface, Friends[] paramArrayOfFriends)
  {
    try
    {
      k = paramArrayOfFriends.length;
      j = 0;
    }
    catch (Exception paramQQAppInterface)
    {
      try
      {
        int k;
        int j;
        Object localObject1;
        Object localObject2;
        int m;
        Long.parseLong((String)localObject2);
        if (!BmqqSegmentUtil.a((String)localObject2)) {
          return;
        }
        boolean bool1 = b(m);
        boolean bool2 = a(m);
        boolean bool3 = c(m);
        if ((!bool1) && (!bool2) && (!bool3))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("updateQidianAccountType ignore uin: ");
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append(" | cSpecialFlag: ");
            ((StringBuilder)localObject1).append(m);
            QLog.d("QidianManager", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          localObject1 = null;
          if (bool1) {
            localObject1 = new BmqqAccountType((String)localObject2, 6);
          } else if (bool2) {
            localObject1 = new BmqqAccountType((String)localObject2, 1);
          } else if (bool3) {
            localObject1 = new BmqqAccountType((String)localObject2, 3);
          }
          if ((localObject1 != null) && (a((String)localObject2) != ((BmqqAccountType)localObject1).getAccountType()))
          {
            this.jdField_a_of_type_JavaUtilMap.put(localObject2, Integer.valueOf(((BmqqAccountType)localObject1).getAccountType()));
            if (bool1)
            {
              QidianExternalInfo localQidianExternalInfo = a((String)localObject2);
              localObject2 = a((String)localObject2);
              if ((localQidianExternalInfo == null) || (localObject2 == null)) {
                b(paramQQAppInterface.getApp().getBaseContext(), (BmqqAccountType)localObject1);
              }
            }
          }
        }
        j += 1;
      }
      catch (Exception paramQQAppInterface) {}
      paramQQAppInterface = paramQQAppInterface;
      paramQQAppInterface.printStackTrace();
    }
    if (j < k)
    {
      localObject1 = paramArrayOfFriends[j];
      localObject2 = ((Friends)localObject1).uin;
      m = ((Friends)localObject1).cSpecialFlag;
    }
    return;
  }
  
  /* Error */
  private void b(BmqqUserSimpleInfo paramBmqqUserSimpleInfo)
  {
    // Byte code:
    //   0: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 147
    //   8: iconst_2
    //   9: ldc_w 621
    //   12: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 63	com/tencent/qidian/QidianManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   19: invokevirtual 158	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   22: invokevirtual 164	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull +68 -> 95
    //   30: aload_1
    //   31: ifnull +11 -> 42
    //   34: aload_2
    //   35: aload_1
    //   36: invokevirtual 451	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   39: goto +18 -> 57
    //   42: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +12 -> 57
    //   48: ldc 147
    //   50: iconst_2
    //   51: ldc_w 623
    //   54: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +24 -> 84
    //   63: ldc 147
    //   65: iconst_2
    //   66: ldc_w 625
    //   69: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: goto +12 -> 84
    //   75: astore_1
    //   76: goto +13 -> 89
    //   79: astore_1
    //   80: aload_1
    //   81: invokevirtual 456	java/lang/Exception:printStackTrace	()V
    //   84: aload_2
    //   85: invokevirtual 200	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   88: return
    //   89: aload_2
    //   90: invokevirtual 200	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   93: aload_1
    //   94: athrow
    //   95: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +12 -> 110
    //   101: ldc 147
    //   103: iconst_2
    //   104: ldc_w 627
    //   107: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	QidianManager
    //   0	111	1	paramBmqqUserSimpleInfo	BmqqUserSimpleInfo
    //   25	65	2	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   34	39	75	finally
    //   42	57	75	finally
    //   57	72	75	finally
    //   80	84	75	finally
    //   34	39	79	java/lang/Exception
    //   42	57	79	java/lang/Exception
    //   57	72	79	java/lang/Exception
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
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("loadInternalInfo query from db: ");
          ((StringBuilder)localObject).append(localQidianInternalInfo);
          QLog.d("QidianManager", 4, ((StringBuilder)localObject).toString());
        }
        Object localObject = localQidianInternalInfo.uin;
        this.c.put(localObject, localQidianInternalInfo);
      }
    }
  }
  
  /* Error */
  private void b(QidianExternalInfo paramQidianExternalInfo, QidianInternalInfo paramQidianInternalInfo, QidianCorpInfo paramQidianCorpInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    // Byte code:
    //   0: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 147
    //   8: iconst_2
    //   9: ldc_w 634
    //   12: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 63	com/tencent/qidian/QidianManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   19: invokevirtual 158	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   22: invokevirtual 164	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   25: astore 5
    //   27: aload 5
    //   29: ifnull +157 -> 186
    //   32: aload_1
    //   33: ifnull +12 -> 45
    //   36: aload 5
    //   38: aload_1
    //   39: invokevirtual 451	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   42: goto +18 -> 60
    //   45: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   48: ifeq +12 -> 60
    //   51: ldc 147
    //   53: iconst_2
    //   54: ldc_w 636
    //   57: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aload_2
    //   61: ifnull +12 -> 73
    //   64: aload 5
    //   66: aload_2
    //   67: invokevirtual 451	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   70: goto +18 -> 88
    //   73: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +12 -> 88
    //   79: ldc 147
    //   81: iconst_2
    //   82: ldc_w 638
    //   85: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: aload_3
    //   89: ifnull +12 -> 101
    //   92: aload 5
    //   94: aload_3
    //   95: invokevirtual 451	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   98: goto +18 -> 116
    //   101: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +12 -> 116
    //   107: ldc 147
    //   109: iconst_2
    //   110: ldc_w 640
    //   113: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload 4
    //   118: ifnull +13 -> 131
    //   121: aload 5
    //   123: aload 4
    //   125: invokevirtual 451	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   128: goto +18 -> 146
    //   131: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +12 -> 146
    //   137: ldc 147
    //   139: iconst_2
    //   140: ldc_w 642
    //   143: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +24 -> 173
    //   152: ldc 147
    //   154: iconst_2
    //   155: ldc_w 644
    //   158: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: goto +12 -> 173
    //   164: astore_1
    //   165: goto +14 -> 179
    //   168: astore_1
    //   169: aload_1
    //   170: invokevirtual 456	java/lang/Exception:printStackTrace	()V
    //   173: aload 5
    //   175: invokevirtual 200	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   178: return
    //   179: aload 5
    //   181: invokevirtual 200	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   184: aload_1
    //   185: athrow
    //   186: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +12 -> 201
    //   192: ldc 147
    //   194: iconst_2
    //   195: ldc_w 646
    //   198: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	QidianManager
    //   0	202	1	paramQidianExternalInfo	QidianExternalInfo
    //   0	202	2	paramQidianInternalInfo	QidianInternalInfo
    //   0	202	3	paramQidianCorpInfo	QidianCorpInfo
    //   0	202	4	paramQidianProfileUiInfo	QidianProfileUiInfo
    //   25	155	5	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   36	42	164	finally
    //   45	60	164	finally
    //   64	70	164	finally
    //   73	88	164	finally
    //   92	98	164	finally
    //   101	116	164	finally
    //   121	128	164	finally
    //   131	146	164	finally
    //   146	161	164	finally
    //   169	173	164	finally
    //   36	42	168	java/lang/Exception
    //   45	60	168	java/lang/Exception
    //   64	70	168	java/lang/Exception
    //   73	88	168	java/lang/Exception
    //   92	98	168	java/lang/Exception
    //   101	116	168	java/lang/Exception
    //   121	128	168	java/lang/Exception
    //   131	146	168	java/lang/Exception
    //   146	161	168	java/lang/Exception
  }
  
  /* Error */
  private void b(QidianExternalInfo paramQidianExternalInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    // Byte code:
    //   0: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 147
    //   8: iconst_2
    //   9: ldc_w 648
    //   12: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 63	com/tencent/qidian/QidianManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   19: invokevirtual 158	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   22: invokevirtual 164	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +102 -> 129
    //   30: aload_1
    //   31: ifnull +18 -> 49
    //   34: aload_1
    //   35: sipush 1000
    //   38: invokevirtual 652	com/tencent/qidian/data/QidianExternalInfo:setStatus	(I)V
    //   41: aload_3
    //   42: aload_1
    //   43: invokevirtual 451	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   46: goto +18 -> 64
    //   49: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +12 -> 64
    //   55: ldc 147
    //   57: iconst_2
    //   58: ldc_w 654
    //   61: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_2
    //   65: ifnull +11 -> 76
    //   68: aload_3
    //   69: aload_2
    //   70: invokevirtual 451	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   73: goto +18 -> 91
    //   76: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +12 -> 91
    //   82: ldc 147
    //   84: iconst_2
    //   85: ldc_w 656
    //   88: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +24 -> 118
    //   97: ldc 147
    //   99: iconst_2
    //   100: ldc_w 658
    //   103: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: goto +12 -> 118
    //   109: astore_1
    //   110: goto +13 -> 123
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 456	java/lang/Exception:printStackTrace	()V
    //   118: aload_3
    //   119: invokevirtual 200	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   122: return
    //   123: aload_3
    //   124: invokevirtual 200	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   127: aload_1
    //   128: athrow
    //   129: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +12 -> 144
    //   135: ldc 147
    //   137: iconst_2
    //   138: ldc_w 660
    //   141: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	QidianManager
    //   0	145	1	paramQidianExternalInfo	QidianExternalInfo
    //   0	145	2	paramQidianProfileUiInfo	QidianProfileUiInfo
    //   25	99	3	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   34	46	109	finally
    //   49	64	109	finally
    //   68	73	109	finally
    //   76	91	109	finally
    //   91	106	109	finally
    //   114	118	109	finally
    //   34	46	113	java/lang/Exception
    //   49	64	113	java/lang/Exception
    //   68	73	113	java/lang/Exception
    //   76	91	113	java/lang/Exception
    //   91	106	113	java/lang/Exception
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x10) != 0;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
    return (paramQQAppInterface.a(paramString)) || (paramQQAppInterface.f(paramString));
  }
  
  private String c(String paramString)
  {
    if (a(paramString))
    {
      Object localObject = (QidianExternalInfo)this.b.get(paramString);
      if ((localObject != null) && (!TextUtils.isEmpty(((QidianExternalInfo)localObject).masterUin)))
      {
        paramString = (QidianCorpInfo)this.d.get(((QidianExternalInfo)localObject).masterUin);
        if (paramString != null) {
          return paramString.corpName;
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("QidianExternalInfo is null or masterUin is empty for uin: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("QidianManager", 4, ((StringBuilder)localObject).toString());
        return "";
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("QidianManager", 4, "uin is no qidian account");
    }
    return "";
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
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("loadBmqqExtInfo query from db: ");
          ((StringBuilder)localObject).append(localBmqqUserSimpleInfo);
          QLog.d("QidianManager", 4, ((StringBuilder)localObject).toString());
        }
        Object localObject = localBmqqUserSimpleInfo.mBmqqUin;
        this.f.put(localObject, localBmqqUserSimpleInfo);
      }
    }
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt & 0x1) != 0;
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
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("loadCorpInfo query from db: ");
          ((StringBuilder)localObject).append(localQidianCorpInfo);
          QLog.d("QidianManager", 4, ((StringBuilder)localObject).toString());
        }
        Object localObject = localQidianCorpInfo.corpUin;
        this.d.put(localObject, localQidianCorpInfo);
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadQidianProfileUiInfo query from db: ");
          localStringBuilder.append(localQidianProfileUiInfo);
          QLog.d("QidianManager", 4, localStringBuilder.toString());
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
    if (!a(paramString, paramQQAppInterface)) {
      return 5;
    }
    if (f(paramString)) {
      return 6;
    }
    if (CrmUtils.a(paramQQAppInterface, paramString, 0)) {
      return 3;
    }
    if (a(paramString)) {
      return 1;
    }
    if (a(paramString, true)) {
      return 0;
    }
    return 4;
  }
  
  public QidianCorpInfo a(String paramString)
  {
    if (this.d.containsKey(paramString)) {
      return (QidianCorpInfo)this.d.get(paramString);
    }
    return null;
  }
  
  public QidianExternalInfo a(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      return (QidianExternalInfo)this.b.get(paramString);
    }
    return null;
  }
  
  public QidianInternalInfo a(String paramString)
  {
    if (this.c.containsKey(paramString)) {
      return (QidianInternalInfo)this.c.get(paramString);
    }
    return null;
  }
  
  public QidianProfileUiInfo a(String paramString)
  {
    if (this.e.containsKey(paramString)) {
      return (QidianProfileUiInfo)this.e.get(paramString);
    }
    return null;
  }
  
  public String a(Context paramContext, String paramString)
  {
    paramString = c(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return String.format(paramContext.getString(2131698616), new Object[] { paramString });
    }
    return paramContext.getString(2131698615);
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
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1 = String.valueOf(paramLong);
    Object localObject2 = StructMsgFactory.a(paramString.getBytes(), 0);
    if (localObject2 == null) {
      return;
    }
    if (((BaseActivity.sTopActivity instanceof SplashActivity)) || ((BaseActivity.sTopActivity instanceof ChatActivity)))
    {
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity.getChatFragment() == null) {
        return;
      }
      if (!localBaseActivity.getChatFragment().a.a.jdField_a_of_type_JavaLangString.equals(localObject1)) {
        return;
      }
      paramString = (MessageForStructing)MessageRecordFactory.a(-2011);
      paramString.msgtype = -2011;
      paramString.istroop = localBaseActivity.getChatFragment().a.a.jdField_a_of_type_Int;
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
      else
      {
        ((List)this.i.get(localObject1)).add(paramString);
      }
      localObject1 = new ArrayList();
      if (!MessageHandlerUtils.a(paramQQAppInterface, paramString, false))
      {
        ((ArrayList)localObject1).add(paramString);
        paramQQAppInterface.getMessageFacade().b((List)localObject1, String.valueOf(paramQQAppInterface.getCurrentAccountUin()));
      }
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
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1 = paramString.split("\\?");
    if (localObject1.length != 2) {
      return;
    }
    Object localObject2 = localObject1[1].split("&");
    localObject1 = new HashMap();
    int k = localObject2.length;
    int j = 0;
    while (j < k)
    {
      String[] arrayOfString = localObject2[j].split("=");
      if (arrayOfString.length == 2) {
        ((HashMap)localObject1).put(arrayOfString[0], arrayOfString[1]);
      }
      j += 1;
    }
    localObject2 = (String)((HashMap)localObject1).get("aioType");
    localObject1 = (String)((HashMap)localObject1).get("uin");
    if ((TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty((CharSequence)localObject1))) {
      return;
    }
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
    QidianPAForWpa localQidianPAForWpa;
    if (this.g.containsKey(paramString1)) {
      localQidianPAForWpa = (QidianPAForWpa)this.g.get(paramString1);
    } else {
      localQidianPAForWpa = new QidianPAForWpa();
    }
    localQidianPAForWpa.puin = paramString1;
    localQidianPAForWpa.kfuin = paramString2;
    this.g.put(paramString1, localQidianPAForWpa);
    if (UiThreadUtil.a())
    {
      ThreadManager.post(new QidianManager.6(this, localQidianPAForWpa, paramString1, paramString2), 5, null, true);
      return;
    }
    a(localQidianPAForWpa, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = paramString2.equals("1");
    String str = "";
    if (bool)
    {
      paramString2 = str;
    }
    else if (paramString2.equals("2"))
    {
      paramString2 = paramString3;
      paramString3 = "";
    }
    else
    {
      paramString3 = "";
      paramString2 = str;
    }
    ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(paramString1, paramString2, paramString3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = paramString3;
    }
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = paramString4;
    }
    a(paramString2, 1, paramInt, paramString5);
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
    if (paramBmqqAccountType == null) {
      return false;
    }
    paramContext = paramBmqqAccountType.getUin();
    try
    {
      long l = Long.parseLong(paramContext);
      if (!BmqqSegmentUtil.a(paramContext)) {
        return false;
      }
      int j = paramBmqqAccountType.getAccountType();
      if (j != 1)
      {
        if (j != 6) {
          return false;
        }
        ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).d(l);
        return true;
      }
      ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).b(l);
      return true;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public boolean a(String paramString)
  {
    return b(paramString, true);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      Long.parseLong(paramString);
      if (!BmqqSegmentUtil.a(paramString)) {
        return false;
      }
      if ((BmqqSegmentUtil.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!BmqqSegmentUtil.a(null, paramString))) {
        return false;
      }
      if (this.f.containsKey(paramString)) {
        return true;
      }
      if (a(paramString, 1)) {
        return true;
      }
      if (!paramBoolean) {
        a(paramString, false);
      }
      return false;
    }
    catch (Exception paramString) {}
    return false;
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
    if (paramBmqqAccountType == null) {
      return false;
    }
    paramContext = paramBmqqAccountType.getUin();
    try
    {
      long l = Long.parseLong(paramContext);
      if (!BmqqSegmentUtil.a(paramContext)) {
        return false;
      }
      int j = paramBmqqAccountType.getAccountType();
      if (j != 0) {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 6) {
              return false;
            }
            ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).c(l);
            return true;
          }
        }
        else
        {
          ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(l);
          return true;
        }
      }
      ((BmqqBusinessHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.BMQQ_BUSINESS_HANDLER)).a(paramContext);
      return true;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public boolean b(String paramString)
  {
    boolean bool3 = this.b.containsKey(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramString = (QidianExternalInfo)this.b.get(paramString);
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.isShowCall == 1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    try
    {
      Long.parseLong(paramString);
      if (!BmqqSegmentUtil.a(paramString)) {
        return false;
      }
      if ((BmqqSegmentUtil.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!BmqqSegmentUtil.a(null, paramString))) {
        return false;
      }
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        bool1 = bool2;
        if (((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue() != 1) {
          break label105;
        }
      }
      else
      {
        if (!a(paramString, 4)) {
          break label89;
        }
      }
      boolean bool1 = true;
      break label105;
      label89:
      bool1 = bool2;
      if (!paramBoolean)
      {
        a(paramString, false);
        bool1 = bool2;
      }
      label105:
      if ((bool1) && (this.b.get(paramString) == null) && (!paramBoolean))
      {
        if (UiThreadUtil.a())
        {
          ThreadManager.post(new QidianManager.4(this, paramString), 5, null, true);
          return bool1;
        }
        b(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getBaseContext(), new BmqqAccountType(paramString, 1));
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public boolean c(String paramString)
  {
    boolean bool3 = this.b.containsKey(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramString = (QidianExternalInfo)this.b.get(paramString);
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.isShowVideoCall == 1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean c(String paramString, boolean paramBoolean)
  {
    try
    {
      Long.parseLong(paramString);
      if (!BmqqSegmentUtil.a(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "isQidianMaster uin is not in bmqqsegment");
        }
        return false;
      }
      if ((BmqqSegmentUtil.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (BmqqSegmentUtil.a(null, paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "isQidianMaster is bmqquin");
        }
        return false;
      }
      boolean bool1 = a(paramString, 16);
      Object localObject;
      boolean bool2;
      if (!bool1)
      {
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
        {
          if (((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue() == 6)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(paramString));
            ((StringBuilder)localObject).append(" isQidianMaster is qidianmain");
            QLog.i("QidianManager", 1, ((StringBuilder)localObject).toString());
            bool1 = true;
          }
          bool2 = bool1;
          if (!paramBoolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QidianManager", 2, "isQidianMaster not only in cache 0");
            }
            b(paramString);
            bool2 = bool1;
          }
        }
        else
        {
          bool2 = bool1;
          if (!paramBoolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QidianManager", 2, "isQidianMaster not only in cache 1");
            }
            b(paramString);
            bool2 = bool1;
          }
        }
      }
      else
      {
        bool2 = bool1;
        if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
        {
          a(new BmqqAccountType(paramString, 6));
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("QidianManager", 2, "isQidianMaster update account type");
            bool2 = bool1;
          }
        }
      }
      if ((bool2) && (!paramBoolean))
      {
        localObject = a(String.valueOf(paramString));
        QidianProfileUiInfo localQidianProfileUiInfo = a(String.valueOf(paramString));
        if ((localObject == null) || (localQidianProfileUiInfo == null)) {
          if (UiThreadUtil.a())
          {
            ThreadManager.post(new QidianManager.7(this, paramString), 5, null, true);
          }
          else
          {
            b(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getBaseContext(), new BmqqAccountType(paramString, 6));
            if (QLog.isColorLevel()) {
              QLog.d("QidianManager", 2, "isQidianMaster get user detail");
            }
          }
        }
      }
      if (bool2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(paramString));
        ((StringBuilder)localObject).append(" isQidianMaster is true finally");
        QLog.i("QidianManager", 1, ((StringBuilder)localObject).toString());
      }
      return bool2;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public boolean d(String paramString)
  {
    return (!TextUtils.isEmpty(a(paramString))) && (b(paramString));
  }
  
  public boolean e(String paramString)
  {
    boolean bool2 = false;
    try
    {
      Long.parseLong(paramString);
      boolean bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        bool1 = bool2;
        if (((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue() == 3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString) {}
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
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    localObject = this.b;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    localObject = this.c;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    localObject = this.d;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    localObject = this.e;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    localObject = this.f;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    localObject = this.g;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    localObject = this.h;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    localObject = this.i;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianManager
 * JD-Core Version:    0.7.0.1
 */