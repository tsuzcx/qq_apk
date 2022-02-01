package com.tencent.mobileqq.troopAddFrd;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendData;
import com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendForTroopConfig;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import mqq.app.AppRuntime;

public class Scene
{
  public static final String a;
  public static final String b;
  public int a;
  public long a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopBatchAddFriendMgr jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr;
  private Scene.OnSceneResultListener jdField_a_of_type_ComTencentMobileqqTroopAddFrdScene$OnSceneResultListener;
  public List<String> a;
  public volatile int b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713480);
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131713484);
  }
  
  public Scene(QQAppInterface paramQQAppInterface, String paramString, int paramInt, Scene.OnSceneResultListener paramOnSceneResultListener, List<String> paramList)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr;
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqTroopAddFrdScene$OnSceneResultListener = paramOnSceneResultListener;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    }
    return 4;
  }
  
  public static int a(String paramString)
  {
    if ("newJoin".equalsIgnoreCase(paramString)) {
      return 1;
    }
    if ("activeUser".equalsIgnoreCase(paramString)) {
      return 2;
    }
    if ("highFreqInteract".equalsIgnoreCase(paramString)) {
      return 3;
    }
    if ("newMember".equalsIgnoreCase(paramString)) {
      return 4;
    }
    if ("atMeOrReplyMe".equalsIgnoreCase(paramString)) {
      return 5;
    }
    return 0;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "newJoin";
    case 2: 
      return "activeUser";
    case 3: 
      return "highFreqInteract";
    case 4: 
      return "newMember";
    }
    return "atMeOrReplyMe";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo)
  {
    if (!TextUtils.isEmpty(paramTroopMemberInfo.recommendRemark)) {
      return paramTroopMemberInfo.recommendRemark;
    }
    if (!TextUtils.isEmpty(paramTroopMemberInfo.troopnick)) {
      return paramTroopMemberInfo.troopnick;
    }
    if (!TextUtils.isEmpty(paramTroopMemberInfo.friendnick)) {
      return paramTroopMemberInfo.friendnick;
    }
    return paramTroopMemberInfo.memberuin;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split("-");
    if (paramString.length > paramInt) {
      return paramString[paramInt];
    }
    return "";
  }
  
  public static String a(boolean paramBoolean, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      if (paramBoolean) {
        return "greyTips_exp";
      }
      return "greyTips_clk";
    case 2: 
      if (paramBoolean) {
        return "greyTips_exp_1";
      }
      return "greyTips_clk_1";
    case 3: 
      if (paramBoolean) {
        return "greyTips_exp_2";
      }
      return "greyTips_clk_2";
    case 4: 
      if (paramBoolean) {
        return "greyTips_exp_3";
      }
      return "greyTips_clk_3";
    }
    if (paramBoolean) {
      return "greyTips_exp_4";
    }
    return "greyTips_clk_4";
  }
  
  /* Error */
  public static List<TroopMemberInfo> a(QQAppInterface paramQQAppInterface, String paramString, List<String> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 136	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 137	java/util/ArrayList:<init>	()V
    //   7: astore 10
    //   9: aload_0
    //   10: getstatic 142	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   13: invokevirtual 148	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   16: checkcast 150	com/tencent/mobileqq/app/FriendsManager
    //   19: astore 12
    //   21: aload_0
    //   22: getstatic 153	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   25: invokevirtual 148	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   28: checkcast 155	com/tencent/mobileqq/app/TroopManager
    //   31: aload_1
    //   32: invokevirtual 158	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   35: astore 11
    //   37: aload 11
    //   39: ifnonnull +6 -> 45
    //   42: aload 10
    //   44: areturn
    //   45: aconst_null
    //   46: astore 9
    //   48: iload_3
    //   49: ifeq +7 -> 56
    //   52: ldc 160
    //   54: astore 9
    //   56: aload_0
    //   57: invokevirtual 164	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   60: astore 14
    //   62: invokestatic 169	android/os/SystemClock:elapsedRealtime	()J
    //   65: lstore 7
    //   67: aload_0
    //   68: invokevirtual 173	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   71: invokevirtual 179	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   74: astore 13
    //   76: ldc 85
    //   78: invokevirtual 184	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   81: astore 15
    //   83: iconst_5
    //   84: anewarray 68	java/lang/String
    //   87: astore 16
    //   89: aload 16
    //   91: iconst_0
    //   92: ldc 185
    //   94: aastore
    //   95: aload 16
    //   97: iconst_1
    //   98: ldc 187
    //   100: aastore
    //   101: aload 16
    //   103: iconst_2
    //   104: ldc 188
    //   106: aastore
    //   107: aload 16
    //   109: iconst_3
    //   110: ldc 189
    //   112: aastore
    //   113: aload 16
    //   115: iconst_4
    //   116: ldc 190
    //   118: aastore
    //   119: aload_2
    //   120: ifnull +683 -> 803
    //   123: aload_2
    //   124: invokeinterface 196 1 0
    //   129: ifle +674 -> 803
    //   132: new 198	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   139: ldc 201
    //   141: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 207
    //   146: aload_2
    //   147: invokeinterface 196 1 0
    //   152: ldc 209
    //   154: invokestatic 215	java/util/Collections:nCopies	(ILjava/lang/Object;)Ljava/util/List;
    //   157: invokestatic 219	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   160: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc 221
    //   165: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore 17
    //   173: aload_2
    //   174: invokeinterface 196 1 0
    //   179: iconst_1
    //   180: iadd
    //   181: anewarray 68	java/lang/String
    //   184: astore 18
    //   186: aload 18
    //   188: iconst_0
    //   189: aload_1
    //   190: aastore
    //   191: iconst_0
    //   192: istore 4
    //   194: iload 4
    //   196: aload_2
    //   197: invokeinterface 196 1 0
    //   202: if_icmpge +30 -> 232
    //   205: aload 18
    //   207: iload 4
    //   209: iconst_1
    //   210: iadd
    //   211: aload_2
    //   212: iload 4
    //   214: invokeinterface 228 2 0
    //   219: checkcast 68	java/lang/String
    //   222: aastore
    //   223: iload 4
    //   225: iconst_1
    //   226: iadd
    //   227: istore 4
    //   229: goto -35 -> 194
    //   232: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +38 -> 273
    //   238: ldc 236
    //   240: iconst_2
    //   241: new 198	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   248: ldc 238
    //   250: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 17
    //   255: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc 240
    //   260: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_2
    //   264: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: aload 13
    //   275: iconst_1
    //   276: aload 15
    //   278: aload 16
    //   280: aload 17
    //   282: aload 18
    //   284: aconst_null
    //   285: aconst_null
    //   286: aload 9
    //   288: aconst_null
    //   289: invokevirtual 253	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   292: astore_1
    //   293: aload_1
    //   294: ifnull +690 -> 984
    //   297: aload_1
    //   298: astore_2
    //   299: aload_1
    //   300: invokeinterface 258 1 0
    //   305: istore_3
    //   306: iload_3
    //   307: ifeq +677 -> 984
    //   310: iconst_0
    //   311: istore 4
    //   313: aload_1
    //   314: astore_2
    //   315: iload 4
    //   317: istore 5
    //   319: aload_1
    //   320: astore 9
    //   322: new 85	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   325: dup
    //   326: invokespecial 259	com/tencent/mobileqq/data/troop/TroopMemberInfo:<init>	()V
    //   329: astore 15
    //   331: aload_1
    //   332: astore_2
    //   333: iload 4
    //   335: istore 5
    //   337: aload_1
    //   338: astore 9
    //   340: aload 15
    //   342: aload_1
    //   343: iconst_0
    //   344: invokeinterface 262 2 0
    //   349: putfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   352: aload_1
    //   353: astore_2
    //   354: iload 4
    //   356: istore 5
    //   358: aload_1
    //   359: astore 9
    //   361: aload 15
    //   363: aload_1
    //   364: iconst_1
    //   365: invokeinterface 265 2 0
    //   370: putfield 267	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   373: aload_1
    //   374: astore_2
    //   375: iload 4
    //   377: istore 5
    //   379: aload_1
    //   380: astore 9
    //   382: aload 15
    //   384: aload_1
    //   385: iconst_2
    //   386: invokeinterface 262 2 0
    //   391: putfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   394: aload_1
    //   395: astore_2
    //   396: iload 4
    //   398: istore 5
    //   400: aload_1
    //   401: astore 9
    //   403: aload 15
    //   405: aload_1
    //   406: iconst_3
    //   407: invokeinterface 262 2 0
    //   412: putfield 97	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   415: aload_1
    //   416: astore_2
    //   417: iload 4
    //   419: istore 5
    //   421: aload_1
    //   422: astore 9
    //   424: aload 15
    //   426: aload_1
    //   427: iconst_4
    //   428: invokeinterface 262 2 0
    //   433: putfield 100	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   436: aload_1
    //   437: astore_2
    //   438: iload 4
    //   440: istore 5
    //   442: aload_1
    //   443: astore 9
    //   445: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   448: ifeq +75 -> 523
    //   451: aload_1
    //   452: astore_2
    //   453: iload 4
    //   455: istore 5
    //   457: aload_1
    //   458: astore 9
    //   460: ldc 236
    //   462: iconst_2
    //   463: new 198	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 269
    //   473: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload 15
    //   478: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   481: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: ldc_w 271
    //   487: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload 15
    //   492: getfield 267	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   495: invokevirtual 274	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   498: ldc_w 276
    //   501: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload 12
    //   506: aload 15
    //   508: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   511: invokevirtual 278	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   514: invokevirtual 281	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   517: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: aload_1
    //   524: astore_2
    //   525: iload 4
    //   527: istore 5
    //   529: aload_1
    //   530: astore 9
    //   532: aload 12
    //   534: aload 15
    //   536: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   539: invokevirtual 278	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   542: ifne +85 -> 627
    //   545: aload_1
    //   546: astore_2
    //   547: iload 4
    //   549: istore 5
    //   551: aload_1
    //   552: astore 9
    //   554: aload 15
    //   556: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   559: invokestatic 285	com/tencent/mobileqq/util/Utils:d	(Ljava/lang/String;)Z
    //   562: ifeq +65 -> 627
    //   565: aload_1
    //   566: astore_2
    //   567: iload 4
    //   569: istore 5
    //   571: aload_1
    //   572: astore 9
    //   574: aload 15
    //   576: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   579: aload 14
    //   581: invokestatic 289	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   584: ifne +43 -> 627
    //   587: aload_1
    //   588: astore_2
    //   589: iload 4
    //   591: istore 5
    //   593: aload_1
    //   594: astore 9
    //   596: aload_0
    //   597: aload 15
    //   599: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   602: invokestatic 294	com/tencent/mobileqq/troop/utils/RobotUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   605: ifne +22 -> 627
    //   608: aload_1
    //   609: astore_2
    //   610: iload 4
    //   612: istore 5
    //   614: aload_1
    //   615: astore 9
    //   617: aload 10
    //   619: aload 15
    //   621: invokeinterface 298 2 0
    //   626: pop
    //   627: iload 4
    //   629: iconst_1
    //   630: iadd
    //   631: istore 6
    //   633: iload 6
    //   635: istore 4
    //   637: aload_1
    //   638: astore_2
    //   639: iload 6
    //   641: istore 5
    //   643: aload_1
    //   644: astore 9
    //   646: aload_1
    //   647: invokeinterface 301 1 0
    //   652: ifne -339 -> 313
    //   655: aload_1
    //   656: astore_2
    //   657: iload 6
    //   659: istore 5
    //   661: aload_1
    //   662: astore 9
    //   664: aload_1
    //   665: invokeinterface 304 1 0
    //   670: aconst_null
    //   671: astore_1
    //   672: iload 6
    //   674: istore 4
    //   676: aload_1
    //   677: astore_2
    //   678: iload 4
    //   680: istore 5
    //   682: aload_1
    //   683: astore 9
    //   685: aload 13
    //   687: invokevirtual 305	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   690: aload_1
    //   691: astore_2
    //   692: iload 4
    //   694: istore 5
    //   696: aload_1
    //   697: astore 9
    //   699: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   702: ifeq +43 -> 745
    //   705: aload_1
    //   706: astore_2
    //   707: iload 4
    //   709: istore 5
    //   711: aload_1
    //   712: astore 9
    //   714: ldc 236
    //   716: iconst_2
    //   717: invokestatic 311	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   720: ldc_w 313
    //   723: iconst_1
    //   724: anewarray 4	java/lang/Object
    //   727: dup
    //   728: iconst_0
    //   729: invokestatic 169	android/os/SystemClock:elapsedRealtime	()J
    //   732: lload 7
    //   734: lsub
    //   735: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   738: aastore
    //   739: invokestatic 323	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   742: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   745: aload_1
    //   746: ifnull +235 -> 981
    //   749: aload_1
    //   750: invokeinterface 304 1 0
    //   755: ldc 236
    //   757: iconst_1
    //   758: ldc_w 325
    //   761: iconst_3
    //   762: anewarray 4	java/lang/Object
    //   765: dup
    //   766: iconst_0
    //   767: aload 11
    //   769: getfield 330	com/tencent/mobileqq/data/troop/TroopInfo:troopuin	Ljava/lang/String;
    //   772: aastore
    //   773: dup
    //   774: iconst_1
    //   775: aload 10
    //   777: invokeinterface 196 1 0
    //   782: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   785: aastore
    //   786: dup
    //   787: iconst_2
    //   788: iload 4
    //   790: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   793: aastore
    //   794: invokestatic 338	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   797: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   800: aload 10
    //   802: areturn
    //   803: aload 13
    //   805: iconst_1
    //   806: aload 15
    //   808: aload 16
    //   810: ldc_w 340
    //   813: iconst_1
    //   814: anewarray 68	java/lang/String
    //   817: dup
    //   818: iconst_0
    //   819: aload_1
    //   820: aastore
    //   821: aconst_null
    //   822: aconst_null
    //   823: aload 9
    //   825: aconst_null
    //   826: invokevirtual 253	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   829: astore_1
    //   830: goto -537 -> 293
    //   833: astore_0
    //   834: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   837: ifeq +13 -> 850
    //   840: ldc 236
    //   842: iconst_2
    //   843: ldc_w 342
    //   846: aload_0
    //   847: invokestatic 345	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   850: goto -95 -> 755
    //   853: astore_0
    //   854: aconst_null
    //   855: astore_1
    //   856: iconst_0
    //   857: istore 5
    //   859: aload_1
    //   860: astore_2
    //   861: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   864: ifeq +15 -> 879
    //   867: aload_1
    //   868: astore_2
    //   869: ldc 236
    //   871: iconst_2
    //   872: ldc_w 342
    //   875: aload_0
    //   876: invokestatic 345	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   879: iload 5
    //   881: istore 4
    //   883: aload_1
    //   884: ifnull -129 -> 755
    //   887: aload_1
    //   888: invokeinterface 304 1 0
    //   893: iload 5
    //   895: istore 4
    //   897: goto -142 -> 755
    //   900: astore_0
    //   901: iload 5
    //   903: istore 4
    //   905: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   908: ifeq -153 -> 755
    //   911: ldc 236
    //   913: iconst_2
    //   914: ldc_w 342
    //   917: aload_0
    //   918: invokestatic 345	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   921: iload 5
    //   923: istore 4
    //   925: goto -170 -> 755
    //   928: astore_0
    //   929: aconst_null
    //   930: astore_2
    //   931: aload_2
    //   932: ifnull +9 -> 941
    //   935: aload_2
    //   936: invokeinterface 304 1 0
    //   941: aload_0
    //   942: athrow
    //   943: astore_1
    //   944: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   947: ifeq -6 -> 941
    //   950: ldc 236
    //   952: iconst_2
    //   953: ldc_w 342
    //   956: aload_1
    //   957: invokestatic 345	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   960: goto -19 -> 941
    //   963: astore_0
    //   964: goto -33 -> 931
    //   967: astore_0
    //   968: iconst_0
    //   969: istore 5
    //   971: goto -112 -> 859
    //   974: astore_0
    //   975: aload 9
    //   977: astore_1
    //   978: goto -119 -> 859
    //   981: goto -226 -> 755
    //   984: iconst_0
    //   985: istore 4
    //   987: goto -311 -> 676
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	990	0	paramQQAppInterface	QQAppInterface
    //   0	990	1	paramString	String
    //   0	990	2	paramList	List<String>
    //   0	990	3	paramBoolean	boolean
    //   192	794	4	i	int
    //   317	653	5	j	int
    //   631	42	6	k	int
    //   65	668	7	l	long
    //   46	930	9	str1	String
    //   7	794	10	localArrayList	ArrayList
    //   35	733	11	localTroopInfo	TroopInfo
    //   19	514	12	localFriendsManager	com.tencent.mobileqq.app.FriendsManager
    //   74	730	13	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   60	520	14	str2	String
    //   81	726	15	localObject	Object
    //   87	722	16	arrayOfString1	String[]
    //   171	110	17	str3	String
    //   184	99	18	arrayOfString2	String[]
    // Exception table:
    //   from	to	target	type
    //   749	755	833	java/lang/Throwable
    //   62	89	853	java/lang/Throwable
    //   123	186	853	java/lang/Throwable
    //   194	223	853	java/lang/Throwable
    //   232	273	853	java/lang/Throwable
    //   273	293	853	java/lang/Throwable
    //   803	830	853	java/lang/Throwable
    //   887	893	900	java/lang/Throwable
    //   62	89	928	finally
    //   123	186	928	finally
    //   194	223	928	finally
    //   232	273	928	finally
    //   273	293	928	finally
    //   803	830	928	finally
    //   935	941	943	java/lang/Throwable
    //   299	306	963	finally
    //   322	331	963	finally
    //   340	352	963	finally
    //   361	373	963	finally
    //   382	394	963	finally
    //   403	415	963	finally
    //   424	436	963	finally
    //   445	451	963	finally
    //   460	523	963	finally
    //   532	545	963	finally
    //   554	565	963	finally
    //   574	587	963	finally
    //   596	608	963	finally
    //   617	627	963	finally
    //   646	655	963	finally
    //   664	670	963	finally
    //   685	690	963	finally
    //   699	705	963	finally
    //   714	745	963	finally
    //   861	867	963	finally
    //   869	879	963	finally
    //   299	306	967	java/lang/Throwable
    //   322	331	974	java/lang/Throwable
    //   340	352	974	java/lang/Throwable
    //   361	373	974	java/lang/Throwable
    //   382	394	974	java/lang/Throwable
    //   403	415	974	java/lang/Throwable
    //   424	436	974	java/lang/Throwable
    //   445	451	974	java/lang/Throwable
    //   460	523	974	java/lang/Throwable
    //   532	545	974	java/lang/Throwable
    //   554	565	974	java/lang/Throwable
    //   574	587	974	java/lang/Throwable
    //   596	608	974	java/lang/Throwable
    //   617	627	974	java/lang/Throwable
    //   646	655	974	java/lang/Throwable
    //   664	670	974	java/lang/Throwable
    //   685	690	974	java/lang/Throwable
    //   699	705	974	java/lang/Throwable
    //   714	745	974	java/lang/Throwable
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, Scene paramScene)
  {
    Object localObject = a(paramQQAppInterface, paramScene.jdField_c_of_type_JavaLangString);
    if (localObject == null) {}
    int j;
    int k;
    do
    {
      return;
      i = ((Integer)localObject[0]).intValue();
      int m = ((Integer)localObject[1]).intValue();
      j = ((Integer)localObject[2]).intValue();
      paramTroopInfo = (String)localObject[3];
      localObject = (String)localObject[4];
      BatchAddFriendForTroopConfig localBatchAddFriendForTroopConfig = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a();
      int n = (int)(localBatchAddFriendForTroopConfig.jdField_a_of_type_Float * i);
      k = (int)(localBatchAddFriendForTroopConfig.jdField_b_of_type_Float * i);
      if ((m >= n) && (j >= k) && (j > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.d("troopBatchAddFrd.Scene", 1, String.format("doInsertGrayTip_V1 check nComFrdCnt_limit_nNonFrdCnt_limit_check=%d_%d_%d_%d_%b_%s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(bool), paramScene.jdField_c_of_type_JavaLangString }));
        if (!bool) {
          break;
        }
        BatchAddFriendData.a(paramQQAppInterface, paramScene.jdField_c_of_type_JavaLangString, m, j, paramTroopInfo, (String)localObject);
        return;
      }
      if ((m < n) && (i != 0))
      {
        paramTroopInfo = String.format(Locale.getDefault(), "%.3f", new Object[] { Float.valueOf(m / i) });
        m = paramTroopInfo.length();
        ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "commonFrd", 0, 0, paramScene.jdField_c_of_type_JavaLangString, "", paramTroopInfo.substring(0, m - 1), "");
      }
    } while ((j >= k) || (i == 0));
    paramTroopInfo = String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf(j / i) });
    int i = paramTroopInfo.length();
    ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "nonFrd", 0, 0, paramScene.jdField_c_of_type_JavaLangString, "", paramTroopInfo.substring(0, i - 1), "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
    long l = localSharedPreferences.getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", paramQQAppInterface.getCurrentAccountUin(), paramTroopInfo.troopuin }), 0L);
    if ((l > 0L) && (l - System.currentTimeMillis() > 86400000L)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, String.format("dealWithOldTip force_troopUin_invalid=%b_%s_%b seq1_seq2=%d_%d", new Object[] { Boolean.valueOf(paramBoolean), paramTroopInfo.troopuin, Boolean.valueOf(bool), Long.valueOf(paramTroopInfo.dwLastBAFTipMsgUniSeq), Long.valueOf(paramTroopInfo.dwLastBAFTipMsgUniSeq2) }));
      }
      if ((bool) || (paramBoolean))
      {
        int i = 0;
        if (paramTroopInfo.dwLastBAFTipMsgUniSeq != 0L)
        {
          paramQQAppInterface.getMessageFacade().b(paramTroopInfo.troopuin, 1, paramTroopInfo.dwLastBAFTipMsgUniSeq);
          paramTroopInfo.dwLastBAFTipMsgUniSeq = 0L;
          i = 1;
        }
        if (paramTroopInfo.dwLastBAFTipMsgUniSeq2 != 0L)
        {
          paramQQAppInterface.getMessageFacade().b(paramTroopInfo.troopuin, 1, paramTroopInfo.dwLastBAFTipMsgUniSeq2);
          paramTroopInfo.dwLastBAFTipMsgUniSeq2 = 0L;
          i = 1;
        }
        if (i != 0) {
          ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramTroopInfo);
        }
        if (bool)
        {
          paramQQAppInterface = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_security_check_flag", paramQQAppInterface.getCurrentAccountUin(), paramTroopInfo.troopuin });
          localSharedPreferences.edit().putInt(paramQQAppInterface, 0).apply();
        }
      }
      return;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt > 0) && (paramInt < 6);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramInt == 1) {}
    for (boolean bool = b(paramQQAppInterface, paramString, paramInt);; bool = c(paramQQAppInterface, paramString, paramInt))
    {
      if (QLog.isColorLevel()) {}
      return bool;
    }
  }
  
  /* Error */
  public static Object[] a(com.tencent.common.app.AppInterface paramAppInterface, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 142	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   4: invokevirtual 478	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7: checkcast 150	com/tencent/mobileqq/app/FriendsManager
    //   10: astore 17
    //   12: aload_0
    //   13: getstatic 153	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   16: invokevirtual 478	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   19: checkcast 155	com/tencent/mobileqq/app/TroopManager
    //   22: aload_1
    //   23: invokevirtual 158	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   26: astore 20
    //   28: aload 20
    //   30: ifnonnull +34 -> 64
    //   33: invokestatic 481	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   36: ifeq +26 -> 62
    //   39: ldc 236
    //   41: iconst_4
    //   42: invokestatic 311	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   45: ldc_w 483
    //   48: iconst_1
    //   49: anewarray 4	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: aload_1
    //   55: aastore
    //   56: invokestatic 323	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   59: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aconst_null
    //   63: areturn
    //   64: aload_0
    //   65: invokevirtual 484	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   68: astore 19
    //   70: aload_0
    //   71: getstatic 487	com/tencent/mobileqq/app/QQManagerFactory:TROOP_ROBOT_MANAGER	I
    //   74: invokevirtual 478	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   77: checkcast 489	com/tencent/mobileqq/troop/utils/TroopRobotManager
    //   80: astore 21
    //   82: invokestatic 169	android/os/SystemClock:elapsedRealtime	()J
    //   85: lstore 9
    //   87: aload_0
    //   88: invokevirtual 492	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   91: invokevirtual 495	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   94: astore 18
    //   96: aload 18
    //   98: iconst_1
    //   99: ldc 85
    //   101: invokevirtual 184	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   104: iconst_5
    //   105: anewarray 68	java/lang/String
    //   108: dup
    //   109: iconst_0
    //   110: ldc 185
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: ldc 187
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: ldc 188
    //   122: aastore
    //   123: dup
    //   124: iconst_3
    //   125: ldc 189
    //   127: aastore
    //   128: dup
    //   129: iconst_4
    //   130: ldc 190
    //   132: aastore
    //   133: ldc_w 340
    //   136: iconst_1
    //   137: anewarray 68	java/lang/String
    //   140: dup
    //   141: iconst_0
    //   142: aload_1
    //   143: aastore
    //   144: aconst_null
    //   145: aconst_null
    //   146: ldc 160
    //   148: aconst_null
    //   149: invokevirtual 253	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   152: astore 12
    //   154: aload 12
    //   156: ifnull +1542 -> 1698
    //   159: aload 12
    //   161: invokeinterface 258 1 0
    //   166: istore 11
    //   168: iload 11
    //   170: ifeq +1528 -> 1698
    //   173: aconst_null
    //   174: astore 16
    //   176: aconst_null
    //   177: astore 14
    //   179: aconst_null
    //   180: astore_1
    //   181: aconst_null
    //   182: astore_0
    //   183: iconst_0
    //   184: istore_3
    //   185: iconst_0
    //   186: istore 5
    //   188: iconst_0
    //   189: istore_2
    //   190: iload_3
    //   191: istore 7
    //   193: iload 5
    //   195: istore 6
    //   197: new 85	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   200: dup
    //   201: invokespecial 259	com/tencent/mobileqq/data/troop/TroopMemberInfo:<init>	()V
    //   204: astore 13
    //   206: iload_3
    //   207: istore 7
    //   209: iload 5
    //   211: istore 6
    //   213: aload 13
    //   215: aload 12
    //   217: iconst_0
    //   218: invokeinterface 262 2 0
    //   223: putfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   226: iload_3
    //   227: istore 7
    //   229: iload 5
    //   231: istore 6
    //   233: aload 13
    //   235: aload 12
    //   237: iconst_1
    //   238: invokeinterface 265 2 0
    //   243: putfield 267	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   246: iload_3
    //   247: istore 7
    //   249: iload 5
    //   251: istore 6
    //   253: aload 13
    //   255: aload 12
    //   257: iconst_2
    //   258: invokeinterface 262 2 0
    //   263: putfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   266: iload_3
    //   267: istore 7
    //   269: iload 5
    //   271: istore 6
    //   273: aload 13
    //   275: aload 12
    //   277: iconst_3
    //   278: invokeinterface 262 2 0
    //   283: putfield 97	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   286: iload_3
    //   287: istore 7
    //   289: iload 5
    //   291: istore 6
    //   293: aload 13
    //   295: aload 12
    //   297: iconst_4
    //   298: invokeinterface 262 2 0
    //   303: putfield 100	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   306: iload_3
    //   307: istore 7
    //   309: iload 5
    //   311: istore 6
    //   313: aload 13
    //   315: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   318: invokestatic 285	com/tencent/mobileqq/util/Utils:d	(Ljava/lang/String;)Z
    //   321: ifeq +70 -> 391
    //   324: iload_3
    //   325: istore 7
    //   327: iload 5
    //   329: istore 6
    //   331: aload 13
    //   333: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   336: invokestatic 497	com/tencent/mobileqq/util/Utils:c	(Ljava/lang/String;)Z
    //   339: ifne +52 -> 391
    //   342: iload_3
    //   343: istore 7
    //   345: iload 5
    //   347: istore 6
    //   349: aload 13
    //   351: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   354: aload 19
    //   356: invokestatic 289	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   359: ifne +32 -> 391
    //   362: aload 21
    //   364: ifnull +290 -> 654
    //   367: iload_3
    //   368: istore 7
    //   370: iload 5
    //   372: istore 6
    //   374: aload 21
    //   376: aload 13
    //   378: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   381: invokevirtual 498	com/tencent/mobileqq/troop/utils/TroopRobotManager:b	(Ljava/lang/String;)Z
    //   384: istore 11
    //   386: iload 11
    //   388: ifeq +266 -> 654
    //   391: aload_1
    //   392: astore 15
    //   394: iload_3
    //   395: istore 6
    //   397: iload 5
    //   399: istore_3
    //   400: iload_2
    //   401: iconst_1
    //   402: iadd
    //   403: istore 4
    //   405: iload 6
    //   407: istore_2
    //   408: aload_0
    //   409: astore_1
    //   410: aload 16
    //   412: astore 13
    //   414: aload 15
    //   416: astore_0
    //   417: aload 12
    //   419: invokeinterface 301 1 0
    //   424: ifne +1251 -> 1675
    //   427: aload 12
    //   429: invokeinterface 304 1 0
    //   434: aconst_null
    //   435: astore 15
    //   437: aload_0
    //   438: astore 16
    //   440: aload 13
    //   442: astore 12
    //   444: aload 15
    //   446: astore_0
    //   447: aload_0
    //   448: astore 17
    //   450: aload 18
    //   452: invokevirtual 305	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   455: aload_0
    //   456: astore 17
    //   458: invokestatic 481	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   461: ifeq +37 -> 498
    //   464: aload_0
    //   465: astore 17
    //   467: ldc 236
    //   469: iconst_4
    //   470: invokestatic 311	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   473: ldc_w 500
    //   476: iconst_1
    //   477: anewarray 4	java/lang/Object
    //   480: dup
    //   481: iconst_0
    //   482: invokestatic 169	android/os/SystemClock:elapsedRealtime	()J
    //   485: lload 9
    //   487: lsub
    //   488: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   491: aastore
    //   492: invokestatic 323	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   495: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: aload 12
    //   500: astore 18
    //   502: aload 14
    //   504: astore 15
    //   506: aload 16
    //   508: astore 19
    //   510: aload_1
    //   511: astore 17
    //   513: iload_2
    //   514: istore 5
    //   516: iload_3
    //   517: istore 6
    //   519: iload 4
    //   521: istore 7
    //   523: aload_0
    //   524: ifnull +34 -> 558
    //   527: aload_0
    //   528: invokeinterface 304 1 0
    //   533: iload 4
    //   535: istore 7
    //   537: iload_3
    //   538: istore 6
    //   540: iload_2
    //   541: istore 5
    //   543: aload_1
    //   544: astore 17
    //   546: aload 16
    //   548: astore 19
    //   550: aload 14
    //   552: astore 15
    //   554: aload 12
    //   556: astore 18
    //   558: aload 18
    //   560: ifnull +659 -> 1219
    //   563: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq +33 -> 599
    //   569: ldc 236
    //   571: iconst_2
    //   572: new 198	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   579: ldc_w 502
    //   582: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload 18
    //   587: getfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   590: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   599: aload 18
    //   601: getfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   604: astore_1
    //   605: aload 18
    //   607: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   610: astore_0
    //   611: iconst_5
    //   612: anewarray 4	java/lang/Object
    //   615: dup
    //   616: iconst_0
    //   617: aload 20
    //   619: getfield 505	com/tencent/mobileqq/data/troop/TroopInfo:wMemberNum	I
    //   622: iload 7
    //   624: isub
    //   625: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   628: aastore
    //   629: dup
    //   630: iconst_1
    //   631: iload 6
    //   633: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   636: aastore
    //   637: dup
    //   638: iconst_2
    //   639: iload 5
    //   641: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   644: aastore
    //   645: dup
    //   646: iconst_3
    //   647: aload_0
    //   648: aastore
    //   649: dup
    //   650: iconst_4
    //   651: aload_1
    //   652: aastore
    //   653: areturn
    //   654: iload_3
    //   655: istore 7
    //   657: iload 5
    //   659: istore 6
    //   661: aload 17
    //   663: aload 13
    //   665: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   668: invokevirtual 278	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   671: ifeq +26 -> 697
    //   674: aload_1
    //   675: astore 13
    //   677: aload_0
    //   678: astore_1
    //   679: iload_2
    //   680: istore 4
    //   682: aload 13
    //   684: astore_0
    //   685: aload 16
    //   687: astore 13
    //   689: iload_3
    //   690: istore_2
    //   691: iload 5
    //   693: istore_3
    //   694: goto -277 -> 417
    //   697: iload_3
    //   698: iconst_1
    //   699: iadd
    //   700: istore 4
    //   702: iload 5
    //   704: istore_3
    //   705: iload 4
    //   707: istore 7
    //   709: iload 5
    //   711: istore 6
    //   713: aload 13
    //   715: getfield 267	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   718: ifle +8 -> 726
    //   721: iload 5
    //   723: iconst_1
    //   724: iadd
    //   725: istore_3
    //   726: iload 4
    //   728: istore 7
    //   730: iload_3
    //   731: istore 6
    //   733: aload 13
    //   735: getfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   738: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   741: ifne +46 -> 787
    //   744: iload 4
    //   746: istore 7
    //   748: iload_3
    //   749: istore 6
    //   751: aload 13
    //   753: getfield 267	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   756: ifle +1015 -> 1771
    //   759: aload 16
    //   761: ifnull +989 -> 1750
    //   764: iload 4
    //   766: istore 7
    //   768: iload_3
    //   769: istore 6
    //   771: aload 16
    //   773: getfield 267	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   776: aload 13
    //   778: getfield 267	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   781: if_icmpge +962 -> 1743
    //   784: goto +938 -> 1722
    //   787: iload 4
    //   789: istore 7
    //   791: iload_3
    //   792: istore 6
    //   794: aload 13
    //   796: getfield 267	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   799: ifle +108 -> 907
    //   802: aload 14
    //   804: ifnull +74 -> 878
    //   807: iload 4
    //   809: istore 7
    //   811: iload_3
    //   812: istore 6
    //   814: aload 14
    //   816: getfield 267	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   819: istore 5
    //   821: iload 4
    //   823: istore 7
    //   825: iload_3
    //   826: istore 6
    //   828: aload 13
    //   830: getfield 267	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   833: istore 8
    //   835: iload 5
    //   837: iload 8
    //   839: if_icmpge +32 -> 871
    //   842: aload 13
    //   844: astore 14
    //   846: aload_1
    //   847: astore 13
    //   849: aload_0
    //   850: astore_1
    //   851: iload_2
    //   852: istore 5
    //   854: aload 13
    //   856: astore_0
    //   857: aload 16
    //   859: astore 13
    //   861: iload 4
    //   863: istore_2
    //   864: iload 5
    //   866: istore 4
    //   868: goto -451 -> 417
    //   871: aload 14
    //   873: astore 13
    //   875: goto -33 -> 842
    //   878: aload 13
    //   880: astore 14
    //   882: aload_1
    //   883: astore 13
    //   885: aload_0
    //   886: astore_1
    //   887: iload_2
    //   888: istore 5
    //   890: aload 13
    //   892: astore_0
    //   893: aload 16
    //   895: astore 13
    //   897: iload 4
    //   899: istore_2
    //   900: iload 5
    //   902: istore 4
    //   904: goto -487 -> 417
    //   907: aload_0
    //   908: ifnonnull +742 -> 1650
    //   911: iload_2
    //   912: istore 5
    //   914: aload_1
    //   915: astore_0
    //   916: aload 13
    //   918: astore_1
    //   919: aload 16
    //   921: astore 13
    //   923: iload 4
    //   925: istore_2
    //   926: iload 5
    //   928: istore 4
    //   930: goto -513 -> 417
    //   933: astore_0
    //   934: aload 12
    //   936: astore 18
    //   938: aload 14
    //   940: astore 15
    //   942: aload 16
    //   944: astore 19
    //   946: aload_1
    //   947: astore 17
    //   949: iload_2
    //   950: istore 5
    //   952: iload_3
    //   953: istore 6
    //   955: iload 4
    //   957: istore 7
    //   959: invokestatic 481	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   962: ifeq -404 -> 558
    //   965: ldc 236
    //   967: iconst_4
    //   968: ldc_w 507
    //   971: aload_0
    //   972: invokestatic 345	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   975: aload 12
    //   977: astore 18
    //   979: aload 14
    //   981: astore 15
    //   983: aload 16
    //   985: astore 19
    //   987: aload_1
    //   988: astore 17
    //   990: iload_2
    //   991: istore 5
    //   993: iload_3
    //   994: istore 6
    //   996: iload 4
    //   998: istore 7
    //   1000: goto -442 -> 558
    //   1003: astore 15
    //   1005: aconst_null
    //   1006: astore_0
    //   1007: aconst_null
    //   1008: astore 12
    //   1010: aconst_null
    //   1011: astore 13
    //   1013: aconst_null
    //   1014: astore 14
    //   1016: aconst_null
    //   1017: astore_1
    //   1018: iconst_0
    //   1019: istore_2
    //   1020: iconst_0
    //   1021: istore_3
    //   1022: iconst_0
    //   1023: istore 4
    //   1025: aload_0
    //   1026: astore 17
    //   1028: invokestatic 481	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1031: ifeq +17 -> 1048
    //   1034: aload_0
    //   1035: astore 17
    //   1037: ldc 236
    //   1039: iconst_4
    //   1040: ldc_w 507
    //   1043: aload 15
    //   1045: invokestatic 345	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1048: aload 12
    //   1050: astore 18
    //   1052: aload 13
    //   1054: astore 15
    //   1056: aload 14
    //   1058: astore 19
    //   1060: aload_1
    //   1061: astore 17
    //   1063: iload_2
    //   1064: istore 5
    //   1066: iload_3
    //   1067: istore 6
    //   1069: iload 4
    //   1071: istore 7
    //   1073: aload_0
    //   1074: ifnull -516 -> 558
    //   1077: aload_0
    //   1078: invokeinterface 304 1 0
    //   1083: aload 12
    //   1085: astore 18
    //   1087: aload 13
    //   1089: astore 15
    //   1091: aload 14
    //   1093: astore 19
    //   1095: aload_1
    //   1096: astore 17
    //   1098: iload_2
    //   1099: istore 5
    //   1101: iload_3
    //   1102: istore 6
    //   1104: iload 4
    //   1106: istore 7
    //   1108: goto -550 -> 558
    //   1111: astore_0
    //   1112: aload 12
    //   1114: astore 18
    //   1116: aload 13
    //   1118: astore 15
    //   1120: aload 14
    //   1122: astore 19
    //   1124: aload_1
    //   1125: astore 17
    //   1127: iload_2
    //   1128: istore 5
    //   1130: iload_3
    //   1131: istore 6
    //   1133: iload 4
    //   1135: istore 7
    //   1137: invokestatic 481	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1140: ifeq -582 -> 558
    //   1143: ldc 236
    //   1145: iconst_4
    //   1146: ldc_w 507
    //   1149: aload_0
    //   1150: invokestatic 345	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1153: aload 12
    //   1155: astore 18
    //   1157: aload 13
    //   1159: astore 15
    //   1161: aload 14
    //   1163: astore 19
    //   1165: aload_1
    //   1166: astore 17
    //   1168: iload_2
    //   1169: istore 5
    //   1171: iload_3
    //   1172: istore 6
    //   1174: iload 4
    //   1176: istore 7
    //   1178: goto -620 -> 558
    //   1181: astore_0
    //   1182: aconst_null
    //   1183: astore 12
    //   1185: aload 12
    //   1187: ifnull +10 -> 1197
    //   1190: aload 12
    //   1192: invokeinterface 304 1 0
    //   1197: aload_0
    //   1198: athrow
    //   1199: astore_1
    //   1200: invokestatic 481	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1203: ifeq -6 -> 1197
    //   1206: ldc 236
    //   1208: iconst_4
    //   1209: ldc_w 507
    //   1212: aload_1
    //   1213: invokestatic 345	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1216: goto -19 -> 1197
    //   1219: aload 19
    //   1221: ifnull +54 -> 1275
    //   1224: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1227: ifeq +33 -> 1260
    //   1230: ldc 236
    //   1232: iconst_2
    //   1233: new 198	java/lang/StringBuilder
    //   1236: dup
    //   1237: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1240: ldc_w 509
    //   1243: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: aload 19
    //   1248: getfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1251: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1257: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1260: aload 19
    //   1262: getfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1265: astore_1
    //   1266: aload 19
    //   1268: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   1271: astore_0
    //   1272: goto -661 -> 611
    //   1275: aload 15
    //   1277: ifnull +124 -> 1401
    //   1280: aload 15
    //   1282: getfield 97	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1285: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1288: ifeq +104 -> 1392
    //   1291: aload 15
    //   1293: getfield 100	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1296: astore_0
    //   1297: aload 15
    //   1299: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   1302: astore 13
    //   1304: aload_0
    //   1305: astore 12
    //   1307: aload 13
    //   1309: astore_1
    //   1310: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1313: ifeq +203 -> 1516
    //   1316: ldc 236
    //   1318: iconst_2
    //   1319: new 198	java/lang/StringBuilder
    //   1322: dup
    //   1323: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1326: ldc_w 509
    //   1329: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: aload 15
    //   1334: getfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1337: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: ldc_w 511
    //   1343: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1346: aload 15
    //   1348: getfield 100	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1351: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: ldc_w 513
    //   1357: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1360: aload 15
    //   1362: getfield 97	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1365: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: ldc_w 515
    //   1371: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: aload_0
    //   1375: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1381: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1384: aload_0
    //   1385: astore_1
    //   1386: aload 13
    //   1388: astore_0
    //   1389: goto -778 -> 611
    //   1392: aload 15
    //   1394: getfield 97	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1397: astore_0
    //   1398: goto -101 -> 1297
    //   1401: aload 17
    //   1403: ifnull +238 -> 1641
    //   1406: aload 17
    //   1408: getfield 97	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1411: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1414: ifeq +110 -> 1524
    //   1417: aload 17
    //   1419: getfield 100	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1422: astore_0
    //   1423: aload 17
    //   1425: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   1428: astore 13
    //   1430: aload_0
    //   1431: astore 12
    //   1433: aload 13
    //   1435: astore_1
    //   1436: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1439: ifeq +77 -> 1516
    //   1442: ldc 236
    //   1444: iconst_2
    //   1445: new 198	java/lang/StringBuilder
    //   1448: dup
    //   1449: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1452: ldc_w 509
    //   1455: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1458: aload 17
    //   1460: getfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1463: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: ldc_w 511
    //   1469: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1472: aload 17
    //   1474: getfield 100	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1477: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: ldc_w 513
    //   1483: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1486: aload 17
    //   1488: getfield 97	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1491: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: ldc_w 515
    //   1497: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1500: aload_0
    //   1501: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1504: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1507: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1510: aload 13
    //   1512: astore_1
    //   1513: aload_0
    //   1514: astore 12
    //   1516: aload_1
    //   1517: astore_0
    //   1518: aload 12
    //   1520: astore_1
    //   1521: goto -910 -> 611
    //   1524: aload 17
    //   1526: getfield 97	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1529: astore_0
    //   1530: goto -107 -> 1423
    //   1533: astore_0
    //   1534: goto -349 -> 1185
    //   1537: astore_0
    //   1538: aload 17
    //   1540: astore 12
    //   1542: goto -357 -> 1185
    //   1545: astore 15
    //   1547: aload 12
    //   1549: astore_0
    //   1550: aconst_null
    //   1551: astore 12
    //   1553: aconst_null
    //   1554: astore 13
    //   1556: aconst_null
    //   1557: astore_1
    //   1558: iconst_0
    //   1559: istore_2
    //   1560: iconst_0
    //   1561: istore_3
    //   1562: iconst_0
    //   1563: istore 4
    //   1565: aconst_null
    //   1566: astore 14
    //   1568: goto -543 -> 1025
    //   1571: astore 15
    //   1573: aload_0
    //   1574: astore 16
    //   1576: aload 12
    //   1578: astore_0
    //   1579: aload 13
    //   1581: astore 12
    //   1583: aload 14
    //   1585: astore 13
    //   1587: aload 16
    //   1589: astore 14
    //   1591: goto -566 -> 1025
    //   1594: astore 15
    //   1596: aload_0
    //   1597: astore 17
    //   1599: iload 6
    //   1601: istore_3
    //   1602: iload_2
    //   1603: istore 4
    //   1605: aload 12
    //   1607: astore_0
    //   1608: aload 16
    //   1610: astore 12
    //   1612: aload 14
    //   1614: astore 13
    //   1616: aload_1
    //   1617: astore 14
    //   1619: aload 17
    //   1621: astore_1
    //   1622: iload 7
    //   1624: istore_2
    //   1625: goto -600 -> 1025
    //   1628: astore 15
    //   1630: aload 14
    //   1632: astore 13
    //   1634: aload 16
    //   1636: astore 14
    //   1638: goto -613 -> 1025
    //   1641: ldc 82
    //   1643: astore_0
    //   1644: ldc 82
    //   1646: astore_1
    //   1647: goto -1036 -> 611
    //   1650: aload_1
    //   1651: astore 13
    //   1653: aload_0
    //   1654: astore_1
    //   1655: iload_2
    //   1656: istore 5
    //   1658: aload 13
    //   1660: astore_0
    //   1661: aload 16
    //   1663: astore 13
    //   1665: iload 4
    //   1667: istore_2
    //   1668: iload 5
    //   1670: istore 4
    //   1672: goto -1255 -> 417
    //   1675: iload_3
    //   1676: istore 5
    //   1678: aload_1
    //   1679: astore 15
    //   1681: aload 13
    //   1683: astore 16
    //   1685: aload_0
    //   1686: astore_1
    //   1687: aload 15
    //   1689: astore_0
    //   1690: iload_2
    //   1691: istore_3
    //   1692: iload 4
    //   1694: istore_2
    //   1695: goto -1505 -> 190
    //   1698: aload 12
    //   1700: astore_0
    //   1701: aconst_null
    //   1702: astore 12
    //   1704: aconst_null
    //   1705: astore 14
    //   1707: aconst_null
    //   1708: astore_1
    //   1709: iconst_0
    //   1710: istore_2
    //   1711: iconst_0
    //   1712: istore_3
    //   1713: iconst_0
    //   1714: istore 4
    //   1716: aconst_null
    //   1717: astore 16
    //   1719: goto -1272 -> 447
    //   1722: aload_1
    //   1723: astore 15
    //   1725: aload_0
    //   1726: astore_1
    //   1727: iload_2
    //   1728: istore 5
    //   1730: aload 15
    //   1732: astore_0
    //   1733: iload 4
    //   1735: istore_2
    //   1736: iload 5
    //   1738: istore 4
    //   1740: goto -1323 -> 417
    //   1743: aload 16
    //   1745: astore 13
    //   1747: goto -25 -> 1722
    //   1750: aload_1
    //   1751: astore 15
    //   1753: aload_0
    //   1754: astore_1
    //   1755: iload_2
    //   1756: istore 5
    //   1758: aload 15
    //   1760: astore_0
    //   1761: iload 4
    //   1763: istore_2
    //   1764: iload 5
    //   1766: istore 4
    //   1768: goto -1351 -> 417
    //   1771: aload_1
    //   1772: ifnonnull -122 -> 1650
    //   1775: aload_0
    //   1776: astore_1
    //   1777: iload_2
    //   1778: istore 5
    //   1780: aload 13
    //   1782: astore_0
    //   1783: aload 16
    //   1785: astore 13
    //   1787: iload 4
    //   1789: istore_2
    //   1790: iload 5
    //   1792: istore 4
    //   1794: goto -1377 -> 417
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1797	0	paramAppInterface	com.tencent.common.app.AppInterface
    //   0	1797	1	paramString	String
    //   189	1601	2	i	int
    //   184	1529	3	j	int
    //   403	1390	4	k	int
    //   186	1605	5	m	int
    //   195	1405	6	n	int
    //   191	1432	7	i1	int
    //   833	7	8	i2	int
    //   85	401	9	l	long
    //   166	221	11	bool	boolean
    //   152	1551	12	localObject1	Object
    //   204	1582	13	localObject2	Object
    //   177	1529	14	localObject3	Object
    //   392	590	15	localObject4	Object
    //   1003	41	15	localThrowable1	java.lang.Throwable
    //   1054	339	15	localObject5	Object
    //   1545	1	15	localThrowable2	java.lang.Throwable
    //   1571	1	15	localThrowable3	java.lang.Throwable
    //   1594	1	15	localThrowable4	java.lang.Throwable
    //   1628	1	15	localThrowable5	java.lang.Throwable
    //   1679	80	15	str	String
    //   174	1610	16	localObject6	Object
    //   10	1610	17	localObject7	Object
    //   94	1062	18	localObject8	Object
    //   68	1199	19	localObject9	Object
    //   26	592	20	localTroopInfo	TroopInfo
    //   80	295	21	localTroopRobotManager	com.tencent.mobileqq.troop.utils.TroopRobotManager
    // Exception table:
    //   from	to	target	type
    //   527	533	933	java/lang/Throwable
    //   82	154	1003	java/lang/Throwable
    //   1077	1083	1111	java/lang/Throwable
    //   82	154	1181	finally
    //   1190	1197	1199	java/lang/Throwable
    //   159	168	1533	finally
    //   197	206	1533	finally
    //   213	226	1533	finally
    //   233	246	1533	finally
    //   253	266	1533	finally
    //   273	286	1533	finally
    //   293	306	1533	finally
    //   313	324	1533	finally
    //   331	342	1533	finally
    //   349	362	1533	finally
    //   374	386	1533	finally
    //   417	434	1533	finally
    //   661	674	1533	finally
    //   713	721	1533	finally
    //   733	744	1533	finally
    //   751	759	1533	finally
    //   771	784	1533	finally
    //   794	802	1533	finally
    //   814	821	1533	finally
    //   828	835	1533	finally
    //   450	455	1537	finally
    //   458	464	1537	finally
    //   467	498	1537	finally
    //   1028	1034	1537	finally
    //   1037	1048	1537	finally
    //   159	168	1545	java/lang/Throwable
    //   417	434	1571	java/lang/Throwable
    //   197	206	1594	java/lang/Throwable
    //   213	226	1594	java/lang/Throwable
    //   233	246	1594	java/lang/Throwable
    //   253	266	1594	java/lang/Throwable
    //   273	286	1594	java/lang/Throwable
    //   293	306	1594	java/lang/Throwable
    //   313	324	1594	java/lang/Throwable
    //   331	342	1594	java/lang/Throwable
    //   349	362	1594	java/lang/Throwable
    //   374	386	1594	java/lang/Throwable
    //   661	674	1594	java/lang/Throwable
    //   713	721	1594	java/lang/Throwable
    //   733	744	1594	java/lang/Throwable
    //   751	759	1594	java/lang/Throwable
    //   771	784	1594	java/lang/Throwable
    //   794	802	1594	java/lang/Throwable
    //   814	821	1594	java/lang/Throwable
    //   828	835	1594	java/lang/Throwable
    //   450	455	1628	java/lang/Throwable
    //   458	464	1628	java/lang/Throwable
    //   467	498	1628	java/lang/Throwable
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    case 4: 
      return 5;
    }
    return 6;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, Scene paramScene)
  {
    int j = paramScene.jdField_e_of_type_Int;
    int i = paramScene.jdField_d_of_type_Int;
    Object localObject1 = paramScene.jdField_e_of_type_JavaLangString;
    if ((paramQQAppInterface == null) || (paramTroopInfo == null) || (TextUtils.isEmpty(paramTroopInfo.troopuin)))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, "doInsertGrayTip invalidate params!");
      }
      return;
    }
    a(paramQQAppInterface, true, paramTroopInfo);
    QLog.i("troopBatchAddFrd.Scene", 1, String.format("doInsertGrayTip_V2 troopUin_type_nonFrdCnt_cmnFrdCnt=%s_%d_%d_%d", new Object[] { paramTroopInfo.troopuin, Integer.valueOf(paramScene.jdField_a_of_type_Int), Integer.valueOf(j), Integer.valueOf(i) }));
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject2 = paramQQAppInterface.getMessageFacade().a(paramTroopInfo.troopuin, 1);
    long l1;
    long l2;
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      l1 = ((ChatMessage)((List)localObject2).get(((List)localObject2).size() - 1)).shmsgseq;
      l2 = MessageCache.a();
      if (j <= 1) {
        break label596;
      }
      localObject1 = String.format(Locale.getDefault(), jdField_a_of_type_JavaLangString, new Object[] { localObject1, Integer.valueOf(j) });
      label209:
      if (i != 0) {
        break label619;
      }
    }
    label596:
    label619:
    for (localObject1 = (String)localObject1 + HardCodeUtil.a(2131713481);; localObject1 = (String)localObject1 + HardCodeUtil.a(2131713483))
    {
      localObject2 = HardCodeUtil.a(2131713482);
      j = ((String)localObject1).indexOf((String)localObject2);
      int k = ((String)localObject2).length();
      localObject2 = new UniteGrayTipParam(paramTroopInfo.troopuin, paramTroopInfo.troopuin, (String)localObject1, 1, -5020, 135178, l2);
      ((UniteGrayTipParam)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_action", 24);
      ((Bundle)localObject1).putString("key_action_DATA", paramTroopInfo.troopuin);
      ((Bundle)localObject1).putString("key_a_action_DATA", paramTroopInfo.troopcode);
      ((UniteGrayTipParam)localObject2).a(j, j + k, (Bundle)localObject1);
      ((UniteGrayTipParam)localObject2).jdField_d_of_type_JavaLangString = (a(paramScene.jdField_a_of_type_Int) + "-" + paramScene.jdField_d_of_type_JavaLangString);
      localObject1 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject2);
      ((MessageForUniteGrayTip)localObject1).isread = true;
      ((MessageForUniteGrayTip)localObject1).shmsgseq = l1;
      ((MessageForUniteGrayTip)localObject1).mNeedTimeStamp = true;
      ((MessageForUniteGrayTip)localObject1).updateUniteGrayTipMsgData(paramQQAppInterface);
      paramQQAppInterface.getMessageFacade().a((MessageRecord)localObject1, paramQQAppInterface.getCurrentAccountUin());
      paramTroopInfo.dwLastBAFTipMsgUniSeq2 = ((MessageForUniteGrayTip)localObject1).uniseq;
      localTroopManager.b(paramTroopInfo);
      localObject1 = ((TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a();
      ((TroopBatchAddFriendMgr)localObject1).b(paramScene.jdField_d_of_type_JavaLangString, paramScene.jdField_c_of_type_JavaLangString);
      if (paramScene.jdField_a_of_type_Int == 4) {
        ((TroopBatchAddFriendMgr)localObject1).b(paramScene.jdField_c_of_type_JavaLangString);
      }
      localObject1 = "1";
      if (i > 0) {
        localObject1 = "0";
      }
      TroopUtils.c(paramQQAppInterface, paramTroopInfo.troopuin, l2);
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "Grp_AIO", a(true, paramScene.jdField_a_of_type_Int), 0, 0, paramTroopInfo.troopuin, Integer.toString(paramScene.f), Integer.toString(paramTroopInfo.wMemberNum), (String)localObject1);
      return;
      l1 = Math.abs(new Random().nextInt());
      break;
      localObject1 = String.format(Locale.getDefault(), jdField_b_of_type_JavaLangString, new Object[] { localObject1 });
      break label209;
    }
  }
  
  private boolean b()
  {
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, "checkTipCondition_V1 data=null");
      }
      return false;
    }
    int i = ((Integer)localObject[0]).intValue();
    int m = ((Integer)localObject[1]).intValue();
    int j = ((Integer)localObject[2]).intValue();
    localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a();
    int n = (int)(((BatchAddFriendForTroopConfig)localObject).jdField_a_of_type_Float * i);
    int k = (int)(((BatchAddFriendForTroopConfig)localObject).jdField_b_of_type_Float * i);
    if ((m >= n) && (j >= k) && (j > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, String.format("checkTipCondition_V1 nComFrdCnt_limit_nNonFrdCnt_limit_check=%d_%d_%d_%d_%b", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(bool) }));
      }
      if (!bool) {
        break;
      }
      return true;
    }
    if ((m < n) && (i != 0))
    {
      localObject = String.format(Locale.getDefault(), "%.3f", new Object[] { Float.valueOf(m / i) });
      m = ((String)localObject).length();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "commonFrd", 0, 0, this.jdField_c_of_type_JavaLangString, "", ((String)localObject).substring(0, m - 1), "");
    }
    if ((j < k) && (i != 0))
    {
      localObject = String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf(j / i) });
      i = ((String)localObject).length();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "nonFrd", 0, 0, this.jdField_c_of_type_JavaLangString, "", ((String)localObject).substring(0, i - 1), "");
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    BatchAddFriendForTroopConfig localBatchAddFriendForTroopConfig = ((TroopManager)localObject).a();
    if (localBatchAddFriendForTroopConfig.jdField_a_of_type_Int != 1) {
      return false;
    }
    localObject = ((TroopManager)localObject).b(paramString);
    if (localObject == null) {
      return false;
    }
    a(paramQQAppInterface, false, (TroopInfo)localObject);
    if (!localBatchAddFriendForTroopConfig.a((TroopInfo)localObject, BatchAddFriendForTroopConfig.jdField_a_of_type_ArrayOfLong)) {
      return false;
    }
    if (((TroopInfo)localObject).dwCmdUinJoinTime < localBatchAddFriendForTroopConfig.jdField_a_of_type_Long)
    {
      if ((QLog.isDevelopLevel()) && (((TroopInfo)localObject).dwCmdUinJoinTime == 0L)) {
        QLog.d("troopBatchAddFrd.Scene", 4, String.format(Locale.getDefault(), "checkCommCondition_V1 troop[%s] dwCmdUinJoinTime is 0!", new Object[] { paramString }));
      }
      return false;
    }
    if (TextUtils.equals(((TroopInfo)localObject).troopowneruin, paramQQAppInterface.getCurrentAccountUin())) {
      return false;
    }
    long l1 = localBatchAddFriendForTroopConfig.jdField_c_of_type_Int * 86400;
    long l2 = NetConnInfoCenter.getServerTime();
    long l3 = l2 - ((TroopInfo)localObject).dwCmdUinJoinTime;
    if ((l3 > l1) || (l3 < 0L))
    {
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "joinDate", 0, 0, paramString, "", String.valueOf(l3 / 86400L), "");
      return false;
    }
    if (((TroopInfo)localObject).wMemberNum > localBatchAddFriendForTroopConfig.jdField_b_of_type_Int)
    {
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "mberNum", 0, 0, paramString, "", String.valueOf(((TroopInfo)localObject).wMemberNum), "");
      return false;
    }
    if (((TroopInfo)localObject).wClickBAFTipCount != 0) {
      return false;
    }
    if (((TroopInfo)localObject).wInsertBAFTipCount >= localBatchAddFriendForTroopConfig.jdField_d_of_type_Int) {
      return false;
    }
    if ((((TroopInfo)localObject).wInsertBAFTipCount == 0) || (((TroopInfo)localObject).dwLastInsertBAFTipTime == 0L)) {
      return true;
    }
    if (l2 - ((TroopInfo)localObject).dwLastInsertBAFTipTime > 86400L) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.Scene", 2, "ONE_DAY_SECOND ");
    }
    return BatchAddFriendData.a(((TroopInfo)localObject).dwLastInsertBAFTipTime, l2);
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    }
    return 4;
  }
  
  private boolean c()
  {
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a();
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, "checkTipCondition_V2 notFrdMems not match");
      }
      return false;
    }
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_e_of_type_Int = localList.size();
    int i = 0;
    while (i < localList.size())
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)localList.get(i);
      this.f = localTroopBatchAddFriendMgr.b(localTroopMemberInfo.memberuin);
      if ((this.f >= 0) && (this.jdField_d_of_type_JavaLangString == null))
      {
        this.jdField_d_of_type_JavaLangString = localTroopMemberInfo.memberuin;
        this.jdField_e_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopMemberInfo);
        this.jdField_c_of_type_Int = localTroopMemberInfo.commonFrdCnt;
      }
      if (localTroopMemberInfo.commonFrdCnt > this.jdField_d_of_type_Int) {
        this.jdField_d_of_type_Int = localTroopMemberInfo.commonFrdCnt;
      }
      i += 1;
    }
    if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, "checkTipCondition_V2 already recommended");
      }
      a(localList);
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.Scene", 2, "recommend " + this.jdField_d_of_type_JavaLangString);
    }
    return true;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("checkCommCondition");
    localStringBuilder.append(" ").append(paramString).append("_").append(paramInt);
    Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = ((TroopManager)localObject).b(paramString);
    if (localTroopInfo == null)
    {
      localStringBuilder.append(" ").append("err:").append("troopinfo is null");
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    a(paramQQAppInterface, false, localTroopInfo);
    localObject = ((TroopManager)localObject).a();
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a();
    String str = a(paramInt);
    if (TextUtils.isEmpty(str))
    {
      localStringBuilder.append(" ").append("err:").append("type invalid");
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (!localTroopBatchAddFriendMgr.b(str))
    {
      localStringBuilder.append(" ").append("err:").append("switch off");
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (!((BatchAddFriendForTroopConfig)localObject).a(localTroopInfo, ((BatchAddFriendForTroopConfig)localObject).jdField_b_of_type_ArrayOfLong))
    {
      localStringBuilder.append(" ").append("err:").append("class invalid =").append(localTroopInfo.dwGroupClassExt);
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (localTroopInfo.wMemberNum > ((BatchAddFriendForTroopConfig)localObject).s)
    {
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "mberNum", 0, 0, localTroopInfo.troopuin, Integer.toString(a(paramInt)), Integer.toString(localTroopInfo.wMemberNum), "");
      localStringBuilder.append(" ").append("err:").append("member count").append(localTroopInfo.wMemberNum).append(">").append(((BatchAddFriendForTroopConfig)localObject).s);
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (!localTroopBatchAddFriendMgr.c(paramString))
    {
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "grpNum", 0, 0, localTroopInfo.troopuin, Integer.toString(a(paramInt)), Integer.toString(localTroopInfo.wMemberNum), "");
      localStringBuilder.append(" ").append("err:").append("troop cant't insert tips ");
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    localStringBuilder.append(" ").append("suc");
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
    }
    return true;
  }
  
  public static int d(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 5;
    case 2: 
      return 6;
    case 3: 
      return 7;
    case 4: 
      return 8;
    }
    return 14;
  }
  
  public int a()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_c_of_type_JavaLangString);
    if (localTroopInfo == null) {
      return -1;
    }
    int i = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getInt(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_security_check_flag", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString }), 0);
    if (i == 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, "checkSecurity need execute security check!");
      }
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("troopBatchAddFrd.Scene", 2, String.format("checkSecurity return %s. net connect err", new Object[] { localTroopInfo.troopuin }));
        }
        return -1;
      }
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(localTroopInfo.troopuin, localTroopInfo.troopcode, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
      return 0;
    }
    if (i != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, String.format(Locale.getDefault(), "checkSecurity fail value: %s", new Object[] { Integer.valueOf(i) }));
      }
      return -1;
    }
    return 1;
  }
  
  List<TroopMemberInfo> a()
  {
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject2 = ((TroopManager)localObject1).a();
    localObject1 = ((TroopManager)localObject1).b(this.jdField_c_of_type_JavaLangString);
    int k = ((BatchAddFriendForTroopConfig)localObject2).a(this.jdField_a_of_type_Int);
    int j;
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    case 2: 
      localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, null, true);
      j = 0;
      i = 0;
      if (j < ((List)localObject2).size())
      {
        if (((TroopMemberInfo)((List)localObject2).get(j)).commonFrdCnt <= 0) {
          break label855;
        }
        i += 1;
      }
      break;
    }
    label849:
    label855:
    for (;;)
    {
      j += 1;
      break;
      if (i < k)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        Object localObject3 = this.jdField_c_of_type_JavaLangString;
        String str = Integer.toString(i);
        if (localObject1 == null) {}
        for (i = 0;; i = ((TroopInfo)localObject1).wMemberNum)
        {
          ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_addFrd", "", "nonGreyTip", "actvie-res", 0, 0, (String)localObject3, str, Integer.toString(i), "");
          return null;
        }
        localObject1 = new ArrayList();
        localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, true);
        j = 0;
        i = 0;
        if (j < ((List)localObject2).size())
        {
          localObject3 = (TroopMemberInfo)((List)localObject2).get(j);
          if (((TroopMemberInfo)localObject3).commonFrdCnt < 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("troopBatchAddFrd.Scene", 2, "commonFrdCnt org:" + ((TroopMemberInfo)localObject3).commonFrdCnt);
            }
            ((TroopMemberInfo)localObject3).commonFrdCnt = 0;
          }
          if (((TroopMemberInfo)localObject3).commonFrdCnt < i) {
            break label849;
          }
          i = ((TroopMemberInfo)localObject3).commonFrdCnt;
        }
        for (;;)
        {
          if (((TroopMemberInfo)localObject3).commonFrdCnt >= k) {
            ((List)localObject1).add(localObject3);
          }
          j += 1;
          break;
          if (((List)localObject1).size() == 0)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "discus-res", 0, 0, this.jdField_c_of_type_JavaLangString, Integer.toString(i), Integer.toString(((List)localObject2).size()), "");
            return localObject1;
            localObject1 = new ArrayList();
            localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, false);
            i = 0;
            while (i < ((List)localObject2).size())
            {
              localObject3 = (TroopMemberInfo)((List)localObject2).get(i);
              if (((TroopMemberInfo)localObject3).commonFrdCnt < 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("troopBatchAddFrd.Scene", 2, "commonFrdCnt org:" + ((TroopMemberInfo)localObject3).commonFrdCnt);
                }
                ((TroopMemberInfo)localObject3).commonFrdCnt = 0;
              }
              if (((TroopMemberInfo)localObject3).commonFrdCnt >= k) {
                ((List)localObject1).add(localObject3);
              }
              i += 1;
            }
            if (((List)localObject1).size() == 0)
            {
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              str = this.jdField_c_of_type_JavaLangString;
              if (((List)localObject2).size() == 0) {}
              for (i = 0;; i = ((TroopMemberInfo)((List)localObject2).get(0)).commonFrdCnt)
              {
                ReportController.b((AppRuntime)localObject3, "dc00899", "Grp_addFrd", "", "nonGreyTip", "new_res", 0, 0, str, Integer.toString(i), "", "");
                return localObject1;
              }
              localObject1 = new ArrayList();
              localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, false);
              i = 0;
              while (i < ((List)localObject2).size())
              {
                localObject3 = (TroopMemberInfo)((List)localObject2).get(i);
                if (((TroopMemberInfo)localObject3).commonFrdCnt < 0)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("troopBatchAddFrd.Scene", 2, "commonFrdCnt org:" + ((TroopMemberInfo)localObject3).commonFrdCnt);
                  }
                  ((TroopMemberInfo)localObject3).commonFrdCnt = 0;
                }
                if (((TroopMemberInfo)localObject3).commonFrdCnt >= k) {
                  ((List)localObject1).add(localObject3);
                }
                i += 1;
              }
              if (((List)localObject1).size() == 0)
              {
                localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                str = this.jdField_c_of_type_JavaLangString;
                if (((List)localObject2).size() == 0) {}
                for (i = 0;; i = ((TroopMemberInfo)((List)localObject2).get(0)).commonFrdCnt)
                {
                  ReportController.b((AppRuntime)localObject3, "dc00899", "Grp_addFrd", "", "nonGreyTip", "@_res", 0, 0, str, Integer.toString(i), "", "");
                  return localObject1;
                }
              }
              return localObject1;
            }
            return localObject1;
          }
          return localObject1;
        }
      }
      return localObject2;
    }
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Int == 5) {
      b();
    }
    if (this.jdField_b_of_type_Int != 0) {
      return;
    }
    a(true, 0);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_Int = -1;
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.Scene", 2, String.format("onErr %s", new Object[] { paramString }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopAddFrdScene$OnSceneResultListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopAddFrdScene$OnSceneResultListener.b(this);
    }
  }
  
  void a(List<TroopMemberInfo> paramList)
  {
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
      } while (localTroopBatchAddFriendMgr.a(((TroopMemberInfo)paramList.next()).memberuin) >= 0);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramList = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_c_of_type_JavaLangString);
        if (paramList != null) {
          break label142;
        }
      }
      label142:
      for (i = 0;; i = paramList.wMemberNum)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "UinNum_total", 0, 0, this.jdField_c_of_type_JavaLangString, Integer.toString(a(this.jdField_a_of_type_Int)), Integer.toString(i), "");
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    int j = -1;
    QLog.i("troopBatchAddFrd.Scene", 1, String.format("onStepAndNext troopUin_type_ts_suc_step=%s_%d_%d_%b_%d", new Object[] { this.jdField_c_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    int i;
    if (paramBoolean)
    {
      i = paramInt;
      label66:
      this.jdField_b_of_type_Int = i;
      if (this.jdField_b_of_type_Int != 0) {
        break label118;
      }
      i = a();
    }
    for (;;)
    {
      switch (i)
      {
      case 0: 
      default: 
        return;
        i = -1;
        break label66;
        label118:
        if (this.jdField_b_of_type_Int == 1)
        {
          i = b();
        }
        else if (this.jdField_b_of_type_Int == 2)
        {
          i = c();
        }
        else if (this.jdField_b_of_type_Int == 3)
        {
          i = e();
        }
        else if (this.jdField_b_of_type_Int == 4)
        {
          i = d();
        }
        else
        {
          if (this.jdField_b_of_type_Int == 5)
          {
            b();
            return;
          }
          i = j;
          if (this.jdField_b_of_type_Int == -1) {
            i = j;
          }
        }
        break;
      }
    }
    a(String.format("onStepAndNext err %s_%d_%d_%b_%d", new Object[] { this.jdField_c_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    return;
    a(true, this.jdField_b_of_type_Int + 1);
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Int != -1) && (this.jdField_b_of_type_Int != 6);
  }
  
  public int b()
  {
    int j = 1;
    long l = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString }), 0L);
    if ((l == 0L) || (System.currentTimeMillis() - l > 86400000L)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, String.format("checkDataTroopMemberList cacheInvalid_ts_type_troopUin=%b_%d_%d_%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_c_of_type_JavaLangString }));
      }
      int i = j;
      if (bool) {
        i = j;
      }
      switch (((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a().a(this.jdField_c_of_type_JavaLangString, l, this.jdField_a_of_type_Int))
      {
      default: 
        i = -1;
      case 1: 
        return i;
      }
    }
    return 0;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.Scene", 2, "onSuc troopUin = " + this.jdField_c_of_type_JavaLangString + ",type = " + this.jdField_a_of_type_Int + ",ts=" + this.jdField_a_of_type_Long);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopAddFrdScene$OnSceneResultListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopAddFrdScene$OnSceneResultListener.a(this);
    }
  }
  
  public int c()
  {
    int j = 1;
    long l = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_cmnfrds", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString }), 0L);
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a();
    label110:
    int i;
    String str;
    int k;
    if ((l == 0L) || (System.currentTimeMillis() - l > ((BatchAddFriendForTroopConfig)localObject).t * 60 * 60 * 1000))
    {
      bool = true;
      QLog.d("troopBatchAddFrd.Scene", 1, String.format("checkDataCmnFrdCntList cacheInvalid_ts_type_troopUin=%b_%d_%d_%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_c_of_type_JavaLangString }));
      if (!bool)
      {
        i = j;
        if (this.jdField_a_of_type_Int != 4) {}
      }
      else
      {
        localObject = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a();
        str = this.jdField_c_of_type_JavaLangString;
        k = this.jdField_a_of_type_Int;
        if (!bool) {
          break label262;
        }
      }
    }
    label262:
    for (boolean bool = false;; bool = true)
    {
      i = j;
      switch (((TroopBatchAddFriendMgr)localObject).a(str, l, k, bool, this.jdField_a_of_type_JavaUtilList))
      {
      default: 
        i = -1;
      case 1: 
        return i;
        bool = false;
        break label110;
      }
    }
    return 0;
  }
  
  public int d()
  {
    int j = 1;
    long l = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_remarks", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString }), 0L);
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a();
    label110:
    int i;
    String str;
    int k;
    if ((l == 0L) || (System.currentTimeMillis() - l > ((BatchAddFriendForTroopConfig)localObject).u * 60 * 60 * 1000))
    {
      bool = true;
      QLog.d("troopBatchAddFrd.Scene", 1, String.format("checkDataRecmdRemarkList cacheInvalid_ts_type_troopUin=%b_%d_%d_%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_c_of_type_JavaLangString }));
      if (!bool)
      {
        i = j;
        if (this.jdField_a_of_type_Int != 4) {}
      }
      else
      {
        localObject = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a();
        str = this.jdField_c_of_type_JavaLangString;
        k = this.jdField_a_of_type_Int;
        if (!bool) {
          break label258;
        }
      }
    }
    label258:
    for (boolean bool = false;; bool = true)
    {
      i = j;
      switch (((TroopBatchAddFriendMgr)localObject).a(str, l, k, bool))
      {
      default: 
        i = -1;
      case 1: 
        return i;
        bool = false;
        break label110;
      }
    }
    return 0;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_Int == 1) {}
    for (boolean bool = b(); (!QLog.isColorLevel()) || (bool); bool = c()) {
      return 1;
    }
    return -1;
  }
  
  public int f()
  {
    int j = 1;
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_c_of_type_JavaLangString);
    int i;
    if (localTroopInfo == null)
    {
      this.jdField_b_of_type_Int = -1;
      i = -1;
      return i;
    }
    if (this.jdField_b_of_type_Int != 5) {
      return -1;
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_c_of_type_JavaLangString, 1);
    if (localList.size() > 0)
    {
      i = Math.min(localList.size(), 10);
      i = localList.size() - i;
      if (i < localList.size()) {
        if (!AnonymousChatHelper.a((MessageRecord)localList.get(i))) {}
      }
    }
    for (boolean bool = true;; bool = false)
    {
      QLog.d("troopBatchAddFrd.Scene", 1, String.format("insertTip hasAnonymousMsg=%b aioList=%d troopUin=%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localList.size()), this.jdField_c_of_type_JavaLangString }));
      i = j;
      if (bool) {
        break;
      }
      if (this.jdField_a_of_type_Int == 1) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopInfo, this);
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = 6;
        return 0;
        i += 1;
        break;
        b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopInfo, this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopAddFrd.Scene
 * JD-Core Version:    0.7.0.1
 */