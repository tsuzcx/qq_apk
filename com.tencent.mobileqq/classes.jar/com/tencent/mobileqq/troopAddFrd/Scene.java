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
import com.tencent.mobileqq.troop.api.handler.ITroopAddFriendHandler;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TroopRecommendUtils;
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
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713447);
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131713451);
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
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return -1;
            }
            return 4;
          }
          return 3;
        }
        return 2;
      }
      return 1;
    }
    return 0;
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
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return "";
            }
            return "atMeOrReplyMe";
          }
          return "newMember";
        }
        return "highFreqInteract";
      }
      return "activeUser";
    }
    return "newJoin";
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
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return "";
            }
            if (paramBoolean) {
              return "greyTips_exp_4";
            }
            return "greyTips_clk_4";
          }
          if (paramBoolean) {
            return "greyTips_exp_3";
          }
          return "greyTips_clk_3";
        }
        if (paramBoolean) {
          return "greyTips_exp_2";
        }
        return "greyTips_clk_2";
      }
      if (paramBoolean) {
        return "greyTips_exp_1";
      }
      return "greyTips_clk_1";
    }
    if (paramBoolean) {
      return "greyTips_exp";
    }
    return "greyTips_clk";
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
    //   45: iload_3
    //   46: ifeq +10 -> 56
    //   49: ldc 160
    //   51: astore 9
    //   53: goto +6 -> 59
    //   56: aconst_null
    //   57: astore 9
    //   59: aload_0
    //   60: invokevirtual 164	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   63: astore 14
    //   65: invokestatic 169	android/os/SystemClock:elapsedRealtime	()J
    //   68: lstore 7
    //   70: aload_0
    //   71: invokevirtual 173	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   74: invokevirtual 179	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   77: astore 13
    //   79: ldc 85
    //   81: invokevirtual 184	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   84: astore 15
    //   86: iconst_5
    //   87: anewarray 68	java/lang/String
    //   90: astore 16
    //   92: aload 16
    //   94: iconst_0
    //   95: ldc 185
    //   97: aastore
    //   98: aload 16
    //   100: iconst_1
    //   101: ldc 187
    //   103: aastore
    //   104: aload 16
    //   106: iconst_2
    //   107: ldc 188
    //   109: aastore
    //   110: aload 16
    //   112: iconst_3
    //   113: ldc 189
    //   115: aastore
    //   116: aload 16
    //   118: iconst_4
    //   119: ldc 190
    //   121: aastore
    //   122: aload_2
    //   123: ifnull +218 -> 341
    //   126: aload_2
    //   127: invokeinterface 196 1 0
    //   132: istore 4
    //   134: iload 4
    //   136: ifle +205 -> 341
    //   139: new 198	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   146: astore 17
    //   148: aload 17
    //   150: ldc 201
    //   152: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 17
    //   158: ldc 207
    //   160: aload_2
    //   161: invokeinterface 196 1 0
    //   166: ldc 209
    //   168: invokestatic 215	java/util/Collections:nCopies	(ILjava/lang/Object;)Ljava/util/List;
    //   171: invokestatic 219	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   174: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 17
    //   180: ldc 221
    //   182: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 17
    //   188: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: astore 17
    //   193: aload_2
    //   194: invokeinterface 196 1 0
    //   199: iconst_1
    //   200: iadd
    //   201: anewarray 68	java/lang/String
    //   204: astore 18
    //   206: aload 18
    //   208: iconst_0
    //   209: aload_1
    //   210: aastore
    //   211: iconst_0
    //   212: istore 4
    //   214: aload_2
    //   215: invokeinterface 196 1 0
    //   220: istore 5
    //   222: iload 4
    //   224: iload 5
    //   226: if_icmpge +36 -> 262
    //   229: iload 4
    //   231: iconst_1
    //   232: iadd
    //   233: istore 5
    //   235: aload 18
    //   237: iload 5
    //   239: aload_2
    //   240: iload 4
    //   242: invokeinterface 228 2 0
    //   247: checkcast 68	java/lang/String
    //   250: aastore
    //   251: iload 5
    //   253: istore 4
    //   255: goto -41 -> 214
    //   258: astore_1
    //   259: goto +717 -> 976
    //   262: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: istore_3
    //   266: iload_3
    //   267: ifeq +51 -> 318
    //   270: new 198	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   277: astore_1
    //   278: aload_1
    //   279: ldc 236
    //   281: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_1
    //   286: aload 17
    //   288: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload_1
    //   293: ldc 238
    //   295: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload_1
    //   300: aload_2
    //   301: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: ldc 243
    //   307: iconst_2
    //   308: aload_1
    //   309: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: goto +3 -> 318
    //   318: aload 13
    //   320: iconst_1
    //   321: aload 15
    //   323: aload 16
    //   325: aload 17
    //   327: aload 18
    //   329: aconst_null
    //   330: aconst_null
    //   331: aload 9
    //   333: aconst_null
    //   334: invokevirtual 253	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   337: astore_1
    //   338: goto +29 -> 367
    //   341: aload 13
    //   343: iconst_1
    //   344: aload 15
    //   346: aload 16
    //   348: ldc 255
    //   350: iconst_1
    //   351: anewarray 68	java/lang/String
    //   354: dup
    //   355: iconst_0
    //   356: aload_1
    //   357: aastore
    //   358: aconst_null
    //   359: aconst_null
    //   360: aload 9
    //   362: aconst_null
    //   363: invokevirtual 253	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   366: astore_1
    //   367: aload_1
    //   368: ifnull +781 -> 1149
    //   371: aload_1
    //   372: astore_2
    //   373: aload_1
    //   374: invokeinterface 260 1 0
    //   379: istore_3
    //   380: iload_3
    //   381: ifeq +768 -> 1149
    //   384: iconst_0
    //   385: istore 4
    //   387: aload_1
    //   388: astore_2
    //   389: aload_1
    //   390: astore 9
    //   392: iload 4
    //   394: istore 5
    //   396: new 85	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   399: dup
    //   400: invokespecial 261	com/tencent/mobileqq/data/troop/TroopMemberInfo:<init>	()V
    //   403: astore 15
    //   405: aload_1
    //   406: astore_2
    //   407: aload_1
    //   408: astore 9
    //   410: iload 4
    //   412: istore 5
    //   414: aload 15
    //   416: aload_1
    //   417: iconst_0
    //   418: invokeinterface 264 2 0
    //   423: putfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   426: aload_1
    //   427: astore_2
    //   428: aload_1
    //   429: astore 9
    //   431: iload 4
    //   433: istore 5
    //   435: aload 15
    //   437: aload_1
    //   438: iconst_1
    //   439: invokeinterface 267 2 0
    //   444: putfield 269	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   447: aload_1
    //   448: astore_2
    //   449: aload_1
    //   450: astore 9
    //   452: iload 4
    //   454: istore 5
    //   456: aload 15
    //   458: aload_1
    //   459: iconst_2
    //   460: invokeinterface 264 2 0
    //   465: putfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   468: aload_1
    //   469: astore_2
    //   470: aload_1
    //   471: astore 9
    //   473: iload 4
    //   475: istore 5
    //   477: aload 15
    //   479: aload_1
    //   480: iconst_3
    //   481: invokeinterface 264 2 0
    //   486: putfield 97	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   489: aload_1
    //   490: astore_2
    //   491: aload_1
    //   492: astore 9
    //   494: iload 4
    //   496: istore 5
    //   498: aload 15
    //   500: aload_1
    //   501: iconst_4
    //   502: invokeinterface 264 2 0
    //   507: putfield 100	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   510: aload_1
    //   511: astore_2
    //   512: aload_1
    //   513: astore 9
    //   515: iload 4
    //   517: istore 5
    //   519: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   522: ifeq +160 -> 682
    //   525: aload_1
    //   526: astore_2
    //   527: aload_1
    //   528: astore 9
    //   530: iload 4
    //   532: istore 5
    //   534: new 198	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   541: astore 16
    //   543: aload_1
    //   544: astore_2
    //   545: aload_1
    //   546: astore 9
    //   548: iload 4
    //   550: istore 5
    //   552: aload 16
    //   554: ldc_w 271
    //   557: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload_1
    //   562: astore_2
    //   563: aload_1
    //   564: astore 9
    //   566: iload 4
    //   568: istore 5
    //   570: aload 16
    //   572: aload 15
    //   574: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   577: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload_1
    //   582: astore_2
    //   583: aload_1
    //   584: astore 9
    //   586: iload 4
    //   588: istore 5
    //   590: aload 16
    //   592: ldc_w 273
    //   595: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload_1
    //   600: astore_2
    //   601: aload_1
    //   602: astore 9
    //   604: iload 4
    //   606: istore 5
    //   608: aload 16
    //   610: aload 15
    //   612: getfield 269	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   615: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload_1
    //   620: astore_2
    //   621: aload_1
    //   622: astore 9
    //   624: iload 4
    //   626: istore 5
    //   628: aload 16
    //   630: ldc_w 278
    //   633: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: pop
    //   637: aload_1
    //   638: astore_2
    //   639: aload_1
    //   640: astore 9
    //   642: iload 4
    //   644: istore 5
    //   646: aload 16
    //   648: aload 12
    //   650: aload 15
    //   652: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   655: invokevirtual 280	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   658: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: aload_1
    //   663: astore_2
    //   664: aload_1
    //   665: astore 9
    //   667: iload 4
    //   669: istore 5
    //   671: ldc 243
    //   673: iconst_2
    //   674: aload 16
    //   676: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   682: aload_1
    //   683: astore_2
    //   684: aload_1
    //   685: astore 9
    //   687: iload 4
    //   689: istore 5
    //   691: aload 12
    //   693: aload 15
    //   695: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   698: invokevirtual 280	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   701: ifne +85 -> 786
    //   704: aload_1
    //   705: astore_2
    //   706: aload_1
    //   707: astore 9
    //   709: iload 4
    //   711: istore 5
    //   713: aload 15
    //   715: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   718: invokestatic 287	com/tencent/mobileqq/util/Utils:d	(Ljava/lang/String;)Z
    //   721: ifeq +65 -> 786
    //   724: aload_1
    //   725: astore_2
    //   726: aload_1
    //   727: astore 9
    //   729: iload 4
    //   731: istore 5
    //   733: aload 15
    //   735: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   738: aload 14
    //   740: invokestatic 291	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   743: ifne +43 -> 786
    //   746: aload_1
    //   747: astore_2
    //   748: aload_1
    //   749: astore 9
    //   751: iload 4
    //   753: istore 5
    //   755: aload_0
    //   756: aload 15
    //   758: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   761: invokestatic 296	com/tencent/mobileqq/troop/utils/RobotUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   764: ifne +22 -> 786
    //   767: aload_1
    //   768: astore_2
    //   769: aload_1
    //   770: astore 9
    //   772: iload 4
    //   774: istore 5
    //   776: aload 10
    //   778: aload 15
    //   780: invokeinterface 300 2 0
    //   785: pop
    //   786: iload 4
    //   788: iconst_1
    //   789: iadd
    //   790: istore 6
    //   792: iload 6
    //   794: istore 4
    //   796: aload_1
    //   797: astore_2
    //   798: aload_1
    //   799: astore 9
    //   801: iload 6
    //   803: istore 5
    //   805: aload_1
    //   806: invokeinterface 303 1 0
    //   811: ifne -424 -> 387
    //   814: aload_1
    //   815: astore_2
    //   816: aload_1
    //   817: astore 9
    //   819: iload 6
    //   821: istore 5
    //   823: aload_1
    //   824: invokeinterface 306 1 0
    //   829: aconst_null
    //   830: astore_1
    //   831: iload 6
    //   833: istore 4
    //   835: goto +3 -> 838
    //   838: aload_1
    //   839: astore_2
    //   840: aload_1
    //   841: astore 9
    //   843: iload 4
    //   845: istore 5
    //   847: aload 13
    //   849: invokevirtual 307	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   852: aload_1
    //   853: astore_2
    //   854: aload_1
    //   855: astore 9
    //   857: iload 4
    //   859: istore 5
    //   861: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   864: ifeq +43 -> 907
    //   867: aload_1
    //   868: astore_2
    //   869: aload_1
    //   870: astore 9
    //   872: iload 4
    //   874: istore 5
    //   876: ldc 243
    //   878: iconst_2
    //   879: invokestatic 313	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   882: ldc_w 315
    //   885: iconst_1
    //   886: anewarray 4	java/lang/Object
    //   889: dup
    //   890: iconst_0
    //   891: invokestatic 169	android/os/SystemClock:elapsedRealtime	()J
    //   894: lload 7
    //   896: lsub
    //   897: invokestatic 321	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   900: aastore
    //   901: invokestatic 325	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   904: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   907: iload 4
    //   909: istore 5
    //   911: aload_1
    //   912: ifnull +131 -> 1043
    //   915: aload_1
    //   916: invokeinterface 306 1 0
    //   921: iload 4
    //   923: istore 5
    //   925: goto +118 -> 1043
    //   928: astore_0
    //   929: iload 4
    //   931: istore 5
    //   933: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   936: ifeq +107 -> 1043
    //   939: goto +90 -> 1029
    //   942: astore_1
    //   943: aload_2
    //   944: astore_0
    //   945: goto +147 -> 1092
    //   948: astore_1
    //   949: aload 9
    //   951: astore_0
    //   952: iload 5
    //   954: istore 4
    //   956: goto +25 -> 981
    //   959: astore_0
    //   960: goto +14 -> 974
    //   963: astore_0
    //   964: goto +10 -> 974
    //   967: astore_0
    //   968: aconst_null
    //   969: astore_2
    //   970: goto +126 -> 1096
    //   973: astore_0
    //   974: aload_0
    //   975: astore_1
    //   976: iconst_0
    //   977: istore 4
    //   979: aconst_null
    //   980: astore_0
    //   981: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   984: ifeq +13 -> 997
    //   987: ldc 243
    //   989: iconst_2
    //   990: ldc_w 327
    //   993: aload_1
    //   994: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   997: iload 4
    //   999: istore 5
    //   1001: aload_0
    //   1002: ifnull +41 -> 1043
    //   1005: aload_0
    //   1006: invokeinterface 306 1 0
    //   1011: iload 4
    //   1013: istore 5
    //   1015: goto +28 -> 1043
    //   1018: astore_0
    //   1019: iload 4
    //   1021: istore 5
    //   1023: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1026: ifeq +17 -> 1043
    //   1029: ldc 243
    //   1031: iconst_2
    //   1032: ldc_w 327
    //   1035: aload_0
    //   1036: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1039: iload 4
    //   1041: istore 5
    //   1043: ldc 243
    //   1045: iconst_1
    //   1046: ldc_w 332
    //   1049: iconst_3
    //   1050: anewarray 4	java/lang/Object
    //   1053: dup
    //   1054: iconst_0
    //   1055: aload 11
    //   1057: getfield 337	com/tencent/mobileqq/data/troop/TroopInfo:troopuin	Ljava/lang/String;
    //   1060: aastore
    //   1061: dup
    //   1062: iconst_1
    //   1063: aload 10
    //   1065: invokeinterface 196 1 0
    //   1070: invokestatic 342	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1073: aastore
    //   1074: dup
    //   1075: iconst_2
    //   1076: iload 5
    //   1078: invokestatic 342	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1081: aastore
    //   1082: invokestatic 345	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1085: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1088: aload 10
    //   1090: areturn
    //   1091: astore_1
    //   1092: aload_0
    //   1093: astore_2
    //   1094: aload_1
    //   1095: astore_0
    //   1096: aload_2
    //   1097: ifnull +29 -> 1126
    //   1100: aload_2
    //   1101: invokeinterface 306 1 0
    //   1106: goto +20 -> 1126
    //   1109: astore_1
    //   1110: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1113: ifeq +13 -> 1126
    //   1116: ldc 243
    //   1118: iconst_2
    //   1119: ldc_w 327
    //   1122: aload_1
    //   1123: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1126: goto +5 -> 1131
    //   1129: aload_0
    //   1130: athrow
    //   1131: goto -2 -> 1129
    //   1134: astore_0
    //   1135: goto -161 -> 974
    //   1138: astore_2
    //   1139: aload_1
    //   1140: astore_0
    //   1141: iconst_0
    //   1142: istore 4
    //   1144: aload_2
    //   1145: astore_1
    //   1146: goto -165 -> 981
    //   1149: iconst_0
    //   1150: istore 4
    //   1152: goto -314 -> 838
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1155	0	paramQQAppInterface	QQAppInterface
    //   0	1155	1	paramString	String
    //   0	1155	2	paramList	List<String>
    //   0	1155	3	paramBoolean	boolean
    //   132	1019	4	i	int
    //   220	857	5	j	int
    //   790	42	6	k	int
    //   68	827	7	l	long
    //   51	899	9	str1	String
    //   7	1082	10	localArrayList	ArrayList
    //   35	1021	11	localTroopInfo	TroopInfo
    //   19	673	12	localFriendsManager	com.tencent.mobileqq.app.FriendsManager
    //   77	771	13	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   63	676	14	str2	String
    //   84	695	15	localObject1	Object
    //   90	585	16	localObject2	Object
    //   146	180	17	localObject3	Object
    //   204	124	18	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   235	251	258	java/lang/Throwable
    //   270	315	258	java/lang/Throwable
    //   915	921	928	java/lang/Throwable
    //   373	380	942	finally
    //   396	405	942	finally
    //   414	426	942	finally
    //   435	447	942	finally
    //   456	468	942	finally
    //   477	489	942	finally
    //   498	510	942	finally
    //   519	525	942	finally
    //   534	543	942	finally
    //   552	561	942	finally
    //   570	581	942	finally
    //   590	599	942	finally
    //   608	619	942	finally
    //   628	637	942	finally
    //   646	662	942	finally
    //   671	682	942	finally
    //   691	704	942	finally
    //   713	724	942	finally
    //   733	746	942	finally
    //   755	767	942	finally
    //   776	786	942	finally
    //   805	814	942	finally
    //   823	829	942	finally
    //   847	852	942	finally
    //   861	867	942	finally
    //   876	907	942	finally
    //   396	405	948	java/lang/Throwable
    //   414	426	948	java/lang/Throwable
    //   435	447	948	java/lang/Throwable
    //   456	468	948	java/lang/Throwable
    //   477	489	948	java/lang/Throwable
    //   498	510	948	java/lang/Throwable
    //   519	525	948	java/lang/Throwable
    //   534	543	948	java/lang/Throwable
    //   552	561	948	java/lang/Throwable
    //   570	581	948	java/lang/Throwable
    //   590	599	948	java/lang/Throwable
    //   608	619	948	java/lang/Throwable
    //   628	637	948	java/lang/Throwable
    //   646	662	948	java/lang/Throwable
    //   671	682	948	java/lang/Throwable
    //   691	704	948	java/lang/Throwable
    //   713	724	948	java/lang/Throwable
    //   733	746	948	java/lang/Throwable
    //   755	767	948	java/lang/Throwable
    //   776	786	948	java/lang/Throwable
    //   805	814	948	java/lang/Throwable
    //   823	829	948	java/lang/Throwable
    //   847	852	948	java/lang/Throwable
    //   861	867	948	java/lang/Throwable
    //   876	907	948	java/lang/Throwable
    //   341	367	959	java/lang/Throwable
    //   318	338	963	java/lang/Throwable
    //   65	92	967	finally
    //   126	134	967	finally
    //   139	206	967	finally
    //   214	222	967	finally
    //   235	251	967	finally
    //   262	266	967	finally
    //   270	315	967	finally
    //   318	338	967	finally
    //   341	367	967	finally
    //   65	92	973	java/lang/Throwable
    //   139	206	973	java/lang/Throwable
    //   214	222	973	java/lang/Throwable
    //   262	266	973	java/lang/Throwable
    //   1005	1011	1018	java/lang/Throwable
    //   981	997	1091	finally
    //   1100	1106	1109	java/lang/Throwable
    //   126	134	1134	java/lang/Throwable
    //   373	380	1138	java/lang/Throwable
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, Scene paramScene)
  {
    Object localObject = a(paramQQAppInterface, paramScene.jdField_c_of_type_JavaLangString);
    if (localObject == null) {
      return;
    }
    int j = ((Integer)localObject[0]).intValue();
    int m = ((Integer)localObject[1]).intValue();
    int i = ((Integer)localObject[2]).intValue();
    paramTroopInfo = (String)localObject[3];
    localObject = (String)localObject[4];
    BatchAddFriendForTroopConfig localBatchAddFriendForTroopConfig = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a();
    float f1 = localBatchAddFriendForTroopConfig.jdField_a_of_type_Float;
    float f2 = j;
    int n = (int)(f1 * f2);
    int k = (int)(localBatchAddFriendForTroopConfig.jdField_b_of_type_Float * f2);
    boolean bool;
    if ((m >= n) && (i >= k) && (i > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("troopBatchAddFrd.Scene", 1, String.format("doInsertGrayTip_V1 check nComFrdCnt_limit_nNonFrdCnt_limit_check=%d_%d_%d_%d_%b_%s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(k), Boolean.valueOf(bool), paramScene.jdField_c_of_type_JavaLangString }));
    if (bool)
    {
      BatchAddFriendData.a(paramQQAppInterface, paramScene.jdField_c_of_type_JavaLangString, m, i, paramTroopInfo, (String)localObject);
      return;
    }
    if ((m < n) && (j != 0))
    {
      paramTroopInfo = String.format(Locale.getDefault(), "%.3f", new Object[] { Float.valueOf(m / f2) });
      m = paramTroopInfo.length();
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "commonFrd", 0, 0, paramScene.jdField_c_of_type_JavaLangString, "", paramTroopInfo.substring(0, m - 1), "");
    }
    if ((i < k) && (j != 0))
    {
      paramTroopInfo = String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf(i / f2) });
      i = paramTroopInfo.length();
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "nonFrd", 0, 0, paramScene.jdField_c_of_type_JavaLangString, "", paramTroopInfo.substring(0, i - 1), "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
    long l = localSharedPreferences.getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", paramQQAppInterface.getCurrentAccountUin(), paramTroopInfo.troopuin }), 0L);
    boolean bool;
    if ((l > 0L) && (l - System.currentTimeMillis() > 86400000L)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.Scene", 2, String.format("dealWithOldTip force_troopUin_invalid=%b_%s_%b seq1_seq2=%d_%d", new Object[] { Boolean.valueOf(paramBoolean), paramTroopInfo.troopuin, Boolean.valueOf(bool), Long.valueOf(paramTroopInfo.dwLastBAFTipMsgUniSeq), Long.valueOf(paramTroopInfo.dwLastBAFTipMsgUniSeq2) }));
    }
    if ((bool) || (paramBoolean))
    {
      int i;
      if (paramTroopInfo.dwLastBAFTipMsgUniSeq != 0L)
      {
        paramQQAppInterface.getMessageFacade().b(paramTroopInfo.troopuin, 1, paramTroopInfo.dwLastBAFTipMsgUniSeq);
        paramTroopInfo.dwLastBAFTipMsgUniSeq = 0L;
        i = 1;
      }
      else
      {
        i = 0;
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
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt > 0) && (paramInt < 6);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool;
    if (paramInt == 1) {
      bool = b(paramQQAppInterface, paramString, paramInt);
    } else {
      bool = c(paramQQAppInterface, paramString, paramInt);
    }
    QLog.isColorLevel();
    return bool;
  }
  
  /* Error */
  public static Object[] a(com.tencent.common.app.AppInterface paramAppInterface, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 142	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   4: invokevirtual 478	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7: checkcast 150	com/tencent/mobileqq/app/FriendsManager
    //   10: astore 23
    //   12: aload_0
    //   13: getstatic 153	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   16: invokevirtual 478	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   19: checkcast 155	com/tencent/mobileqq/app/TroopManager
    //   22: aload_1
    //   23: invokevirtual 158	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   26: astore 21
    //   28: aload 21
    //   30: ifnonnull +34 -> 64
    //   33: invokestatic 481	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   36: ifeq +26 -> 62
    //   39: ldc 243
    //   41: iconst_4
    //   42: invokestatic 313	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   45: ldc_w 483
    //   48: iconst_1
    //   49: anewarray 4	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: aload_1
    //   55: aastore
    //   56: invokestatic 325	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   59: invokestatic 372	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aconst_null
    //   63: areturn
    //   64: aload_0
    //   65: invokevirtual 484	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   68: astore 24
    //   70: aload_0
    //   71: ldc_w 486
    //   74: ldc_w 488
    //   77: invokevirtual 492	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   80: checkcast 486	com/tencent/mobileqq/troop/robot/api/ITroopRobotService
    //   83: astore 25
    //   85: invokestatic 169	android/os/SystemClock:elapsedRealtime	()J
    //   88: lstore 9
    //   90: aload_0
    //   91: invokevirtual 495	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   94: invokevirtual 498	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   97: astore 22
    //   99: aload 22
    //   101: iconst_1
    //   102: ldc 85
    //   104: invokevirtual 184	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   107: iconst_5
    //   108: anewarray 68	java/lang/String
    //   111: dup
    //   112: iconst_0
    //   113: ldc 185
    //   115: aastore
    //   116: dup
    //   117: iconst_1
    //   118: ldc 187
    //   120: aastore
    //   121: dup
    //   122: iconst_2
    //   123: ldc 188
    //   125: aastore
    //   126: dup
    //   127: iconst_3
    //   128: ldc 189
    //   130: aastore
    //   131: dup
    //   132: iconst_4
    //   133: ldc 190
    //   135: aastore
    //   136: ldc 255
    //   138: iconst_1
    //   139: anewarray 68	java/lang/String
    //   142: dup
    //   143: iconst_0
    //   144: aload_1
    //   145: aastore
    //   146: aconst_null
    //   147: aconst_null
    //   148: ldc 160
    //   150: aconst_null
    //   151: invokevirtual 253	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   154: astore 15
    //   156: aload 15
    //   158: ifnull +864 -> 1022
    //   161: aload 15
    //   163: astore 16
    //   165: aload 15
    //   167: invokeinterface 260 1 0
    //   172: istore 11
    //   174: iload 11
    //   176: ifeq +846 -> 1022
    //   179: iconst_0
    //   180: istore_2
    //   181: iconst_0
    //   182: istore_3
    //   183: iconst_0
    //   184: istore 5
    //   186: aconst_null
    //   187: astore 12
    //   189: aconst_null
    //   190: astore 13
    //   192: aconst_null
    //   193: astore_1
    //   194: aconst_null
    //   195: astore_0
    //   196: iload_2
    //   197: istore 6
    //   199: iload 5
    //   201: istore 7
    //   203: aload 15
    //   205: astore 16
    //   207: new 85	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   210: dup
    //   211: invokespecial 261	com/tencent/mobileqq/data/troop/TroopMemberInfo:<init>	()V
    //   214: astore 14
    //   216: iload_2
    //   217: istore 6
    //   219: iload 5
    //   221: istore 7
    //   223: aload 15
    //   225: astore 16
    //   227: aload 14
    //   229: aload 15
    //   231: iconst_0
    //   232: invokeinterface 264 2 0
    //   237: putfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   240: iload_2
    //   241: istore 6
    //   243: iload 5
    //   245: istore 7
    //   247: aload 15
    //   249: astore 16
    //   251: aload 14
    //   253: aload 15
    //   255: iconst_1
    //   256: invokeinterface 267 2 0
    //   261: putfield 269	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   264: iload_2
    //   265: istore 6
    //   267: iload 5
    //   269: istore 7
    //   271: aload 15
    //   273: astore 16
    //   275: aload 14
    //   277: aload 15
    //   279: iconst_2
    //   280: invokeinterface 264 2 0
    //   285: putfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   288: iload_2
    //   289: istore 6
    //   291: iload 5
    //   293: istore 7
    //   295: aload 15
    //   297: astore 16
    //   299: aload 14
    //   301: aload 15
    //   303: iconst_3
    //   304: invokeinterface 264 2 0
    //   309: putfield 97	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   312: iload_2
    //   313: istore 6
    //   315: iload 5
    //   317: istore 7
    //   319: aload 15
    //   321: astore 16
    //   323: aload 14
    //   325: aload 15
    //   327: iconst_4
    //   328: invokeinterface 264 2 0
    //   333: putfield 100	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   336: iload_2
    //   337: istore 6
    //   339: iload 5
    //   341: istore 7
    //   343: aload 15
    //   345: astore 16
    //   347: aload 14
    //   349: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   352: invokestatic 287	com/tencent/mobileqq/util/Utils:d	(Ljava/lang/String;)Z
    //   355: ifeq +451 -> 806
    //   358: iload_2
    //   359: istore 6
    //   361: iload 5
    //   363: istore 7
    //   365: aload 15
    //   367: astore 16
    //   369: aload 14
    //   371: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   374: invokestatic 500	com/tencent/mobileqq/util/Utils:c	(Ljava/lang/String;)Z
    //   377: ifne +429 -> 806
    //   380: iload_2
    //   381: istore 6
    //   383: iload 5
    //   385: istore 7
    //   387: aload 15
    //   389: astore 16
    //   391: aload 14
    //   393: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   396: aload 24
    //   398: invokestatic 291	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   401: istore 11
    //   403: iload 11
    //   405: ifne +401 -> 806
    //   408: aload 25
    //   410: ifnull +53 -> 463
    //   413: iload_2
    //   414: istore 6
    //   416: iload_3
    //   417: istore 7
    //   419: iload 5
    //   421: istore 8
    //   423: aload 12
    //   425: astore 17
    //   427: aload 13
    //   429: astore 18
    //   431: aload_1
    //   432: astore 19
    //   434: aload_0
    //   435: astore 20
    //   437: aload 15
    //   439: astore 16
    //   441: aload 25
    //   443: aload 14
    //   445: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   448: invokeinterface 503 2 0
    //   453: istore 11
    //   455: iload 11
    //   457: ifeq +6 -> 463
    //   460: goto +346 -> 806
    //   463: iload_2
    //   464: istore 6
    //   466: iload 5
    //   468: istore 7
    //   470: aload 15
    //   472: astore 16
    //   474: aload 23
    //   476: aload 14
    //   478: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   481: invokevirtual 280	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   484: ifeq +9 -> 493
    //   487: iload_2
    //   488: istore 4
    //   490: goto +349 -> 839
    //   493: iload_2
    //   494: iconst_1
    //   495: iadd
    //   496: istore 4
    //   498: iload 5
    //   500: istore_2
    //   501: iload 4
    //   503: istore 6
    //   505: iload 5
    //   507: istore 7
    //   509: aload 15
    //   511: astore 16
    //   513: aload 14
    //   515: getfield 269	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   518: ifle +8 -> 526
    //   521: iload 5
    //   523: iconst_1
    //   524: iadd
    //   525: istore_2
    //   526: iload 4
    //   528: istore 6
    //   530: iload_2
    //   531: istore 7
    //   533: aload 15
    //   535: astore 16
    //   537: aload 14
    //   539: getfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   542: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   545: istore 11
    //   547: iload 11
    //   549: ifne +126 -> 675
    //   552: aload 15
    //   554: astore 16
    //   556: aload 14
    //   558: getfield 269	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   561: istore 5
    //   563: iload 5
    //   565: ifle +71 -> 636
    //   568: aload 14
    //   570: astore 16
    //   572: aload_0
    //   573: ifnull +54 -> 627
    //   576: aload 15
    //   578: astore 16
    //   580: aload_0
    //   581: getfield 269	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   584: istore 5
    //   586: aload 15
    //   588: astore 16
    //   590: aload 14
    //   592: getfield 269	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   595: istore 6
    //   597: iload 5
    //   599: iload 6
    //   601: if_icmpge +10 -> 611
    //   604: aload 14
    //   606: astore 16
    //   608: goto +19 -> 627
    //   611: aload_0
    //   612: astore 16
    //   614: goto +13 -> 627
    //   617: astore 17
    //   619: aload_1
    //   620: astore 19
    //   622: aload_0
    //   623: astore_1
    //   624: goto +339 -> 963
    //   627: aload 16
    //   629: astore_0
    //   630: iload_2
    //   631: istore 5
    //   633: goto +206 -> 839
    //   636: aload 13
    //   638: ifnonnull +10 -> 648
    //   641: aload 14
    //   643: astore 13
    //   645: goto +191 -> 836
    //   648: iload 4
    //   650: istore 5
    //   652: iload_3
    //   653: istore 6
    //   655: iload_2
    //   656: istore 7
    //   658: aload 12
    //   660: astore 16
    //   662: goto +160 -> 822
    //   665: astore 17
    //   667: aload_1
    //   668: astore 19
    //   670: aload_0
    //   671: astore_1
    //   672: goto +291 -> 963
    //   675: aload 15
    //   677: astore 16
    //   679: aload 14
    //   681: getfield 269	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   684: istore 5
    //   686: iload 5
    //   688: ifle +69 -> 757
    //   691: aload_1
    //   692: astore 17
    //   694: aload 14
    //   696: astore 16
    //   698: aload 17
    //   700: ifnull +51 -> 751
    //   703: aload 15
    //   705: astore 16
    //   707: aload 17
    //   709: getfield 269	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   712: istore 5
    //   714: aload 15
    //   716: astore 16
    //   718: aload 14
    //   720: getfield 269	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   723: istore 6
    //   725: iload 5
    //   727: iload 6
    //   729: if_icmpge +10 -> 739
    //   732: aload 14
    //   734: astore 16
    //   736: goto +15 -> 751
    //   739: aload 17
    //   741: astore 16
    //   743: goto +8 -> 751
    //   746: astore 14
    //   748: goto +47 -> 795
    //   751: aload 16
    //   753: astore_1
    //   754: goto +82 -> 836
    //   757: iload 4
    //   759: istore 5
    //   761: iload_3
    //   762: istore 6
    //   764: iload_2
    //   765: istore 7
    //   767: aload 12
    //   769: astore 16
    //   771: aload 12
    //   773: ifnonnull +49 -> 822
    //   776: iload 4
    //   778: istore 5
    //   780: iload_3
    //   781: istore 6
    //   783: iload_2
    //   784: istore 7
    //   786: aload 14
    //   788: astore 16
    //   790: goto +32 -> 822
    //   793: astore 14
    //   795: aload_0
    //   796: astore 16
    //   798: aload_1
    //   799: astore_0
    //   800: aload 16
    //   802: astore_1
    //   803: goto +197 -> 1000
    //   806: iload_3
    //   807: iconst_1
    //   808: iadd
    //   809: istore 6
    //   811: aload 12
    //   813: astore 16
    //   815: iload 5
    //   817: istore 7
    //   819: iload_2
    //   820: istore 5
    //   822: aload 16
    //   824: astore 12
    //   826: iload 7
    //   828: istore_2
    //   829: iload 6
    //   831: istore_3
    //   832: iload 5
    //   834: istore 4
    //   836: iload_2
    //   837: istore 5
    //   839: iload 4
    //   841: istore 6
    //   843: iload_3
    //   844: istore 7
    //   846: iload 5
    //   848: istore 8
    //   850: aload 12
    //   852: astore 17
    //   854: aload 13
    //   856: astore 18
    //   858: aload_1
    //   859: astore 19
    //   861: aload_0
    //   862: astore 20
    //   864: aload 15
    //   866: astore 16
    //   868: aload 15
    //   870: invokeinterface 303 1 0
    //   875: ifne +57 -> 932
    //   878: iload 4
    //   880: istore 6
    //   882: iload_3
    //   883: istore 7
    //   885: iload 5
    //   887: istore 8
    //   889: aload 12
    //   891: astore 17
    //   893: aload 13
    //   895: astore 18
    //   897: aload_1
    //   898: astore 19
    //   900: aload_0
    //   901: astore 20
    //   903: aload 15
    //   905: astore 16
    //   907: aload 15
    //   909: invokeinterface 306 1 0
    //   914: aconst_null
    //   915: astore 15
    //   917: iload 4
    //   919: istore_2
    //   920: iload 5
    //   922: istore 4
    //   924: aload_1
    //   925: astore 14
    //   927: aload_0
    //   928: astore_1
    //   929: goto +111 -> 1040
    //   932: iload 4
    //   934: istore_2
    //   935: goto -739 -> 196
    //   938: astore_0
    //   939: aload 20
    //   941: astore_1
    //   942: aload 18
    //   944: astore 13
    //   946: aload 17
    //   948: astore 12
    //   950: iload 8
    //   952: istore_2
    //   953: iload 7
    //   955: istore_3
    //   956: iload 6
    //   958: istore 4
    //   960: aload_0
    //   961: astore 17
    //   963: iload_2
    //   964: istore 5
    //   966: aload 19
    //   968: astore_0
    //   969: iload 4
    //   971: istore_2
    //   972: iload 5
    //   974: istore 4
    //   976: goto +261 -> 1237
    //   979: astore 16
    //   981: aload_1
    //   982: astore 14
    //   984: aload_0
    //   985: astore_1
    //   986: aload 14
    //   988: astore_0
    //   989: iload 7
    //   991: istore_2
    //   992: iload 6
    //   994: istore 4
    //   996: aload 16
    //   998: astore 14
    //   1000: iload_2
    //   1001: istore 5
    //   1003: aload 14
    //   1005: astore 17
    //   1007: iload 4
    //   1009: istore_2
    //   1010: iload 5
    //   1012: istore 4
    //   1014: goto +223 -> 1237
    //   1017: astore 17
    //   1019: goto +201 -> 1220
    //   1022: iconst_0
    //   1023: istore_2
    //   1024: iconst_0
    //   1025: istore 4
    //   1027: iconst_0
    //   1028: istore_3
    //   1029: aconst_null
    //   1030: astore 12
    //   1032: aconst_null
    //   1033: astore 13
    //   1035: aconst_null
    //   1036: astore 14
    //   1038: aconst_null
    //   1039: astore_1
    //   1040: aload 15
    //   1042: astore 16
    //   1044: aload 22
    //   1046: invokevirtual 307	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1049: aload 15
    //   1051: astore 16
    //   1053: invokestatic 481	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1056: ifeq +38 -> 1094
    //   1059: aload 15
    //   1061: astore 16
    //   1063: ldc 243
    //   1065: iconst_4
    //   1066: invokestatic 313	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   1069: ldc_w 505
    //   1072: iconst_1
    //   1073: anewarray 4	java/lang/Object
    //   1076: dup
    //   1077: iconst_0
    //   1078: invokestatic 169	android/os/SystemClock:elapsedRealtime	()J
    //   1081: lload 9
    //   1083: lsub
    //   1084: invokestatic 321	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1087: aastore
    //   1088: invokestatic 325	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1091: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1094: iload_2
    //   1095: istore 7
    //   1097: iload 4
    //   1099: istore 6
    //   1101: iload_3
    //   1102: istore 5
    //   1104: aload 12
    //   1106: astore 17
    //   1108: aload 13
    //   1110: astore 19
    //   1112: aload 14
    //   1114: astore 16
    //   1116: aload_1
    //   1117: astore 18
    //   1119: aload 15
    //   1121: ifnull +275 -> 1396
    //   1124: aload 15
    //   1126: invokeinterface 306 1 0
    //   1131: iload_2
    //   1132: istore 7
    //   1134: iload 4
    //   1136: istore 6
    //   1138: iload_3
    //   1139: istore 5
    //   1141: aload 12
    //   1143: astore 17
    //   1145: aload 13
    //   1147: astore 19
    //   1149: aload 14
    //   1151: astore 16
    //   1153: aload_1
    //   1154: astore 18
    //   1156: goto +240 -> 1396
    //   1159: astore_0
    //   1160: iload_2
    //   1161: istore 7
    //   1163: iload 4
    //   1165: istore 6
    //   1167: iload_3
    //   1168: istore 5
    //   1170: aload 12
    //   1172: astore 17
    //   1174: aload 13
    //   1176: astore 19
    //   1178: aload 14
    //   1180: astore 16
    //   1182: aload_1
    //   1183: astore 18
    //   1185: invokestatic 481	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1188: ifeq +208 -> 1396
    //   1191: aload_0
    //   1192: astore 15
    //   1194: aload 14
    //   1196: astore_0
    //   1197: goto +164 -> 1361
    //   1200: astore 17
    //   1202: aload 14
    //   1204: astore_0
    //   1205: goto +32 -> 1237
    //   1208: astore_0
    //   1209: aconst_null
    //   1210: astore 16
    //   1212: goto +646 -> 1858
    //   1215: astore 17
    //   1217: aconst_null
    //   1218: astore 15
    //   1220: iconst_0
    //   1221: istore_2
    //   1222: iconst_0
    //   1223: istore 4
    //   1225: iconst_0
    //   1226: istore_3
    //   1227: aconst_null
    //   1228: astore 12
    //   1230: aconst_null
    //   1231: astore 13
    //   1233: aconst_null
    //   1234: astore_0
    //   1235: aconst_null
    //   1236: astore_1
    //   1237: aload 15
    //   1239: astore 16
    //   1241: invokestatic 481	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1244: ifeq +18 -> 1262
    //   1247: aload 15
    //   1249: astore 16
    //   1251: ldc 243
    //   1253: iconst_4
    //   1254: ldc_w 507
    //   1257: aload 17
    //   1259: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1262: iload_2
    //   1263: istore 7
    //   1265: iload 4
    //   1267: istore 6
    //   1269: iload_3
    //   1270: istore 5
    //   1272: aload 12
    //   1274: astore 17
    //   1276: aload 13
    //   1278: astore 19
    //   1280: aload_0
    //   1281: astore 16
    //   1283: aload_1
    //   1284: astore 18
    //   1286: aload 15
    //   1288: ifnull +108 -> 1396
    //   1291: aload 15
    //   1293: invokeinterface 306 1 0
    //   1298: iload_2
    //   1299: istore 7
    //   1301: iload 4
    //   1303: istore 6
    //   1305: iload_3
    //   1306: istore 5
    //   1308: aload 12
    //   1310: astore 17
    //   1312: aload 13
    //   1314: astore 19
    //   1316: aload_0
    //   1317: astore 16
    //   1319: aload_1
    //   1320: astore 18
    //   1322: goto +74 -> 1396
    //   1325: astore 14
    //   1327: iload_2
    //   1328: istore 7
    //   1330: iload 4
    //   1332: istore 6
    //   1334: iload_3
    //   1335: istore 5
    //   1337: aload 12
    //   1339: astore 17
    //   1341: aload 13
    //   1343: astore 19
    //   1345: aload_0
    //   1346: astore 16
    //   1348: aload_1
    //   1349: astore 18
    //   1351: invokestatic 481	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1354: ifeq +42 -> 1396
    //   1357: aload 14
    //   1359: astore 15
    //   1361: ldc 243
    //   1363: iconst_4
    //   1364: ldc_w 507
    //   1367: aload 15
    //   1369: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1372: aload_1
    //   1373: astore 18
    //   1375: aload_0
    //   1376: astore 16
    //   1378: aload 13
    //   1380: astore 19
    //   1382: aload 12
    //   1384: astore 17
    //   1386: iload_3
    //   1387: istore 5
    //   1389: iload 4
    //   1391: istore 6
    //   1393: iload_2
    //   1394: istore 7
    //   1396: ldc 82
    //   1398: astore_1
    //   1399: aload 18
    //   1401: ifnull +60 -> 1461
    //   1404: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1407: ifeq +39 -> 1446
    //   1410: new 198	java/lang/StringBuilder
    //   1413: dup
    //   1414: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1417: astore_0
    //   1418: aload_0
    //   1419: ldc_w 509
    //   1422: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: pop
    //   1426: aload_0
    //   1427: aload 18
    //   1429: getfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1432: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1435: pop
    //   1436: ldc 243
    //   1438: iconst_2
    //   1439: aload_0
    //   1440: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1443: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1446: aload 18
    //   1448: getfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1451: astore_1
    //   1452: aload 18
    //   1454: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   1457: astore_0
    //   1458: goto +356 -> 1814
    //   1461: aload 19
    //   1463: ifnull +60 -> 1523
    //   1466: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1469: ifeq +39 -> 1508
    //   1472: new 198	java/lang/StringBuilder
    //   1475: dup
    //   1476: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1479: astore_0
    //   1480: aload_0
    //   1481: ldc_w 511
    //   1484: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1487: pop
    //   1488: aload_0
    //   1489: aload 19
    //   1491: getfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1494: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: pop
    //   1498: ldc 243
    //   1500: iconst_2
    //   1501: aload_0
    //   1502: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1505: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1508: aload 19
    //   1510: getfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1513: astore_1
    //   1514: aload 19
    //   1516: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   1519: astore_0
    //   1520: goto +294 -> 1814
    //   1523: aload 16
    //   1525: ifnull +142 -> 1667
    //   1528: aload 16
    //   1530: getfield 97	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1533: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1536: ifeq +12 -> 1548
    //   1539: aload 16
    //   1541: getfield 100	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1544: astore_0
    //   1545: goto +9 -> 1554
    //   1548: aload 16
    //   1550: getfield 97	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1553: astore_0
    //   1554: aload_0
    //   1555: astore_1
    //   1556: aload 16
    //   1558: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   1561: astore_0
    //   1562: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1565: ifeq +99 -> 1664
    //   1568: new 198	java/lang/StringBuilder
    //   1571: dup
    //   1572: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1575: astore 12
    //   1577: aload 12
    //   1579: ldc_w 511
    //   1582: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1585: pop
    //   1586: aload 12
    //   1588: aload 16
    //   1590: getfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1593: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1596: pop
    //   1597: aload 12
    //   1599: ldc_w 513
    //   1602: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1605: pop
    //   1606: aload 12
    //   1608: aload 16
    //   1610: getfield 100	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1613: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1616: pop
    //   1617: aload 12
    //   1619: ldc_w 515
    //   1622: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1625: pop
    //   1626: aload 12
    //   1628: aload 16
    //   1630: getfield 97	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1633: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1636: pop
    //   1637: aload 12
    //   1639: ldc_w 517
    //   1642: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1645: pop
    //   1646: aload 12
    //   1648: aload_1
    //   1649: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1652: pop
    //   1653: ldc 243
    //   1655: iconst_2
    //   1656: aload 12
    //   1658: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1661: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1664: goto +150 -> 1814
    //   1667: aload 17
    //   1669: ifnull +142 -> 1811
    //   1672: aload 17
    //   1674: getfield 97	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1677: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1680: ifeq +12 -> 1692
    //   1683: aload 17
    //   1685: getfield 100	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1688: astore_0
    //   1689: goto +9 -> 1698
    //   1692: aload 17
    //   1694: getfield 97	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1697: astore_0
    //   1698: aload_0
    //   1699: astore_1
    //   1700: aload 17
    //   1702: getfield 103	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   1705: astore_0
    //   1706: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1709: ifeq +99 -> 1808
    //   1712: new 198	java/lang/StringBuilder
    //   1715: dup
    //   1716: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1719: astore 12
    //   1721: aload 12
    //   1723: ldc_w 511
    //   1726: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1729: pop
    //   1730: aload 12
    //   1732: aload 17
    //   1734: getfield 88	com/tencent/mobileqq/data/troop/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1737: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1740: pop
    //   1741: aload 12
    //   1743: ldc_w 513
    //   1746: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1749: pop
    //   1750: aload 12
    //   1752: aload 17
    //   1754: getfield 100	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1757: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1760: pop
    //   1761: aload 12
    //   1763: ldc_w 515
    //   1766: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1769: pop
    //   1770: aload 12
    //   1772: aload 17
    //   1774: getfield 97	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1777: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1780: pop
    //   1781: aload 12
    //   1783: ldc_w 517
    //   1786: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1789: pop
    //   1790: aload 12
    //   1792: aload_1
    //   1793: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1796: pop
    //   1797: ldc 243
    //   1799: iconst_2
    //   1800: aload 12
    //   1802: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1805: invokestatic 247	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1808: goto +6 -> 1814
    //   1811: ldc 82
    //   1813: astore_0
    //   1814: iconst_5
    //   1815: anewarray 4	java/lang/Object
    //   1818: dup
    //   1819: iconst_0
    //   1820: aload 21
    //   1822: getfield 520	com/tencent/mobileqq/data/troop/TroopInfo:wMemberNum	I
    //   1825: iload 5
    //   1827: isub
    //   1828: invokestatic 342	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1831: aastore
    //   1832: dup
    //   1833: iconst_1
    //   1834: iload 6
    //   1836: invokestatic 342	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1839: aastore
    //   1840: dup
    //   1841: iconst_2
    //   1842: iload 7
    //   1844: invokestatic 342	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1847: aastore
    //   1848: dup
    //   1849: iconst_3
    //   1850: aload_0
    //   1851: aastore
    //   1852: dup
    //   1853: iconst_4
    //   1854: aload_1
    //   1855: aastore
    //   1856: areturn
    //   1857: astore_0
    //   1858: aload 16
    //   1860: ifnull +30 -> 1890
    //   1863: aload 16
    //   1865: invokeinterface 306 1 0
    //   1870: goto +20 -> 1890
    //   1873: astore_1
    //   1874: invokestatic 481	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1877: ifeq +13 -> 1890
    //   1880: ldc 243
    //   1882: iconst_4
    //   1883: ldc_w 507
    //   1886: aload_1
    //   1887: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1890: goto +5 -> 1895
    //   1893: aload_0
    //   1894: athrow
    //   1895: goto -2 -> 1893
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1898	0	paramAppInterface	com.tencent.common.app.AppInterface
    //   0	1898	1	paramString	String
    //   180	1214	2	i	int
    //   182	1205	3	j	int
    //   488	902	4	k	int
    //   184	1644	5	m	int
    //   197	1638	6	n	int
    //   201	1642	7	i1	int
    //   421	530	8	i2	int
    //   88	994	9	l	long
    //   172	376	11	bool	boolean
    //   187	1614	12	localObject1	Object
    //   190	1189	13	localObject2	Object
    //   214	519	14	localTroopMemberInfo	TroopMemberInfo
    //   746	41	14	localThrowable1	java.lang.Throwable
    //   793	1	14	localThrowable2	java.lang.Throwable
    //   925	278	14	localObject3	Object
    //   1325	33	14	localThrowable3	java.lang.Throwable
    //   154	1214	15	localObject4	Object
    //   163	743	16	localObject5	Object
    //   979	18	16	localThrowable4	java.lang.Throwable
    //   1042	822	16	localObject6	Object
    //   425	1	17	localObject7	Object
    //   617	1	17	localThrowable5	java.lang.Throwable
    //   665	1	17	localThrowable6	java.lang.Throwable
    //   692	314	17	localObject8	Object
    //   1017	1	17	localThrowable7	java.lang.Throwable
    //   1106	67	17	localObject9	Object
    //   1200	1	17	localThrowable8	java.lang.Throwable
    //   1215	43	17	localThrowable9	java.lang.Throwable
    //   1274	499	17	localObject10	Object
    //   429	1024	18	localObject11	Object
    //   432	1083	19	localObject12	Object
    //   435	505	20	localAppInterface	com.tencent.common.app.AppInterface
    //   26	1795	21	localTroopInfo	TroopInfo
    //   97	948	22	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   10	465	23	localFriendsManager	com.tencent.mobileqq.app.FriendsManager
    //   68	329	24	str	String
    //   83	359	25	localITroopRobotService	com.tencent.mobileqq.troop.robot.api.ITroopRobotService
    // Exception table:
    //   from	to	target	type
    //   580	586	617	java/lang/Throwable
    //   590	597	617	java/lang/Throwable
    //   556	563	665	java/lang/Throwable
    //   707	714	746	java/lang/Throwable
    //   718	725	746	java/lang/Throwable
    //   679	686	793	java/lang/Throwable
    //   441	455	938	java/lang/Throwable
    //   868	878	938	java/lang/Throwable
    //   907	914	938	java/lang/Throwable
    //   207	216	979	java/lang/Throwable
    //   227	240	979	java/lang/Throwable
    //   251	264	979	java/lang/Throwable
    //   275	288	979	java/lang/Throwable
    //   299	312	979	java/lang/Throwable
    //   323	336	979	java/lang/Throwable
    //   347	358	979	java/lang/Throwable
    //   369	380	979	java/lang/Throwable
    //   391	403	979	java/lang/Throwable
    //   474	487	979	java/lang/Throwable
    //   513	521	979	java/lang/Throwable
    //   537	547	979	java/lang/Throwable
    //   165	174	1017	java/lang/Throwable
    //   1124	1131	1159	java/lang/Throwable
    //   1044	1049	1200	java/lang/Throwable
    //   1053	1059	1200	java/lang/Throwable
    //   1063	1094	1200	java/lang/Throwable
    //   85	156	1208	finally
    //   85	156	1215	java/lang/Throwable
    //   1291	1298	1325	java/lang/Throwable
    //   165	174	1857	finally
    //   207	216	1857	finally
    //   227	240	1857	finally
    //   251	264	1857	finally
    //   275	288	1857	finally
    //   299	312	1857	finally
    //   323	336	1857	finally
    //   347	358	1857	finally
    //   369	380	1857	finally
    //   391	403	1857	finally
    //   441	455	1857	finally
    //   474	487	1857	finally
    //   513	521	1857	finally
    //   537	547	1857	finally
    //   556	563	1857	finally
    //   580	586	1857	finally
    //   590	597	1857	finally
    //   679	686	1857	finally
    //   707	714	1857	finally
    //   718	725	1857	finally
    //   868	878	1857	finally
    //   907	914	1857	finally
    //   1044	1049	1857	finally
    //   1053	1059	1857	finally
    //   1063	1094	1857	finally
    //   1241	1247	1857	finally
    //   1251	1262	1857	finally
    //   1863	1870	1873	java/lang/Throwable
  }
  
  public static int b(int paramInt)
  {
    if (paramInt != 1)
    {
      int i = 2;
      if (paramInt != 2)
      {
        i = 3;
        if (paramInt != 3)
        {
          i = 4;
          if (paramInt != 4) {
            return 1;
          }
        }
      }
      return i;
    }
    return 1;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, Scene paramScene)
  {
    int j = paramScene.jdField_e_of_type_Int;
    int i = paramScene.jdField_d_of_type_Int;
    Object localObject1 = paramScene.jdField_e_of_type_JavaLangString;
    if ((paramQQAppInterface != null) && (paramTroopInfo != null) && (!TextUtils.isEmpty(paramTroopInfo.troopuin)))
    {
      a(paramQQAppInterface, true, paramTroopInfo);
      QLog.i("troopBatchAddFrd.Scene", 1, String.format("doInsertGrayTip_V2 troopUin_type_nonFrdCnt_cmnFrdCnt=%s_%d_%d_%d", new Object[] { paramTroopInfo.troopuin, Integer.valueOf(paramScene.jdField_a_of_type_Int), Integer.valueOf(j), Integer.valueOf(i) }));
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      Object localObject2 = paramQQAppInterface.getMessageFacade().b(paramTroopInfo.troopuin, 1);
      long l1;
      if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
        l1 = ((ChatMessage)((List)localObject2).get(((List)localObject2).size() - 1)).shmsgseq;
      } else {
        l1 = Math.abs(new Random().nextInt());
      }
      long l2 = MessageCache.a();
      if (j > 1) {
        localObject1 = String.format(Locale.getDefault(), jdField_a_of_type_JavaLangString, new Object[] { localObject1, Integer.valueOf(j) });
      } else {
        localObject1 = String.format(Locale.getDefault(), jdField_b_of_type_JavaLangString, new Object[] { localObject1 });
      }
      if (i == 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131713448));
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131713450));
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      localObject2 = HardCodeUtil.a(2131713449);
      j = ((String)localObject1).indexOf((String)localObject2);
      int k = ((String)localObject2).length();
      localObject2 = new UniteGrayTipParam(paramTroopInfo.troopuin, paramTroopInfo.troopuin, (String)localObject1, 1, -5020, 135178, l2);
      ((UniteGrayTipParam)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_action", 24);
      ((Bundle)localObject1).putString("key_action_DATA", paramTroopInfo.troopuin);
      ((Bundle)localObject1).putString("key_a_action_DATA", paramTroopInfo.troopcode);
      ((UniteGrayTipParam)localObject2).a(j, k + j, (Bundle)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(paramScene.jdField_a_of_type_Int));
      ((StringBuilder)localObject1).append("-");
      ((StringBuilder)localObject1).append(paramScene.jdField_d_of_type_JavaLangString);
      ((UniteGrayTipParam)localObject2).jdField_d_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
      localObject1 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject2);
      ((MessageForUniteGrayTip)localObject1).isread = true;
      ((MessageForUniteGrayTip)localObject1).shmsgseq = l1;
      ((MessageForUniteGrayTip)localObject1).mNeedTimeStamp = true;
      ((MessageForUniteGrayTip)localObject1).updateUniteGrayTipMsgData(paramQQAppInterface);
      paramQQAppInterface.getMessageFacade().a((MessageRecord)localObject1, paramQQAppInterface.getCurrentAccountUin());
      paramTroopInfo.dwLastBAFTipMsgUniSeq2 = ((MessageForUniteGrayTip)localObject1).uniseq;
      localTroopManager.b(paramTroopInfo);
      localObject1 = ((ITroopBatchAddFriendService)paramQQAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
      ((TroopBatchAddFriendMgr)localObject1).b(paramScene.jdField_d_of_type_JavaLangString, paramScene.jdField_c_of_type_JavaLangString);
      if (paramScene.jdField_a_of_type_Int == 4) {
        ((TroopBatchAddFriendMgr)localObject1).b(paramScene.jdField_c_of_type_JavaLangString);
      }
      if (i > 0) {
        localObject1 = "0";
      } else {
        localObject1 = "1";
      }
      TroopRecommendUtils.c(paramQQAppInterface, paramTroopInfo.troopuin, l2);
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "Grp_AIO", a(true, paramScene.jdField_a_of_type_Int), 0, 0, paramTroopInfo.troopuin, Integer.toString(paramScene.f), Integer.toString(paramTroopInfo.wMemberNum), (String)localObject1);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("troopBatchAddFrd.Scene", 2, "doInsertGrayTip invalidate params!");
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
    float f1 = ((BatchAddFriendForTroopConfig)localObject).jdField_a_of_type_Float;
    float f2 = i;
    int n = (int)(f1 * f2);
    int k = (int)(((BatchAddFriendForTroopConfig)localObject).jdField_b_of_type_Float * f2);
    boolean bool;
    if ((m >= n) && (j >= k) && (j > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.Scene", 2, String.format("checkTipCondition_V1 nComFrdCnt_limit_nNonFrdCnt_limit_check=%d_%d_%d_%d_%b", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(bool) }));
    }
    if (bool) {
      return true;
    }
    if ((m < n) && (i != 0))
    {
      localObject = String.format(Locale.getDefault(), "%.3f", new Object[] { Float.valueOf(m / f2) });
      m = ((String)localObject).length();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "commonFrd", 0, 0, this.jdField_c_of_type_JavaLangString, "", ((String)localObject).substring(0, m - 1), "");
    }
    if ((j < k) && (i != 0))
    {
      localObject = String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf(j / f2) });
      i = ((String)localObject).length();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "nonFrd", 0, 0, this.jdField_c_of_type_JavaLangString, "", ((String)localObject).substring(0, i - 1), "");
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
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
      if ((l3 <= l1) && (l3 >= 0L))
      {
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
        if (((TroopInfo)localObject).wInsertBAFTipCount != 0)
        {
          if (((TroopInfo)localObject).dwLastInsertBAFTipTime == 0L) {
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
        return true;
      }
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "joinDate", 0, 0, paramString, "", String.valueOf(l3 / 86400L), "");
      return false;
    }
    return false;
  }
  
  public static int c(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return 5;
            }
            return 14;
          }
          return 8;
        }
        return 7;
      }
      return 6;
    }
    return 5;
  }
  
  private boolean c()
  {
    Object localObject = ((ITroopBatchAddFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
    List localList = a();
    if ((localList != null) && (localList.size() != 0))
    {
      this.jdField_d_of_type_JavaLangString = null;
      this.jdField_e_of_type_JavaLangString = null;
      this.jdField_e_of_type_Int = localList.size();
      int i = 0;
      while (i < localList.size())
      {
        TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)localList.get(i);
        this.f = ((TroopBatchAddFriendMgr)localObject).b(localTroopMemberInfo.memberuin);
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
      if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("recommend ");
          ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangString);
          QLog.d("troopBatchAddFrd.Scene", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, "checkTipCondition_V2 already recommended");
      }
      a(localList);
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.Scene", 2, "checkTipCondition_V2 notFrdMems not match");
    }
    return false;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("checkCommCondition");
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = ((TroopManager)localObject).b(paramString);
    if (localTroopInfo == null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append("err:");
      localStringBuilder.append("troopinfo is null");
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    a(paramQQAppInterface, false, localTroopInfo);
    localObject = ((TroopManager)localObject).a();
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((ITroopBatchAddFriendService)paramQQAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
    String str = a(paramInt);
    if (TextUtils.isEmpty(str))
    {
      localStringBuilder.append(" ");
      localStringBuilder.append("err:");
      localStringBuilder.append("type invalid");
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (!localTroopBatchAddFriendMgr.b(str))
    {
      localStringBuilder.append(" ");
      localStringBuilder.append("err:");
      localStringBuilder.append("switch off");
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (!((BatchAddFriendForTroopConfig)localObject).a(localTroopInfo, ((BatchAddFriendForTroopConfig)localObject).jdField_b_of_type_ArrayOfLong))
    {
      localStringBuilder.append(" ");
      localStringBuilder.append("err:");
      localStringBuilder.append("class invalid =");
      localStringBuilder.append(localTroopInfo.dwGroupClassExt);
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (localTroopInfo.wMemberNum > ((BatchAddFriendForTroopConfig)localObject).s)
    {
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "mberNum", 0, 0, localTroopInfo.troopuin, Integer.toString(a(paramInt)), Integer.toString(localTroopInfo.wMemberNum), "");
      localStringBuilder.append(" ");
      localStringBuilder.append("err:");
      localStringBuilder.append("member count");
      localStringBuilder.append(localTroopInfo.wMemberNum);
      localStringBuilder.append(">");
      localStringBuilder.append(((BatchAddFriendForTroopConfig)localObject).s);
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (!localTroopBatchAddFriendMgr.c(paramString))
    {
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "grpNum", 0, 0, localTroopInfo.troopuin, Integer.toString(a(paramInt)), Integer.toString(localTroopInfo.wMemberNum), "");
      localStringBuilder.append(" ");
      localStringBuilder.append("err:");
      localStringBuilder.append("troop cant't insert tips ");
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    localStringBuilder.append(" ");
    localStringBuilder.append("suc");
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
    }
    return true;
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
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("troopBatchAddFrd.Scene", 2, String.format("checkSecurity return %s. net connect err", new Object[] { localTroopInfo.troopuin }));
        }
        return -1;
      }
      ((ITroopAddFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ADD_FRIEND_HANDLER)).a(localTroopInfo.troopuin, localTroopInfo.troopcode, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
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
    Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject1 = ((TroopManager)localObject2).a();
    localObject2 = ((TroopManager)localObject2).b(this.jdField_c_of_type_JavaLangString);
    int n = ((BatchAddFriendForTroopConfig)localObject1).a(this.jdField_a_of_type_Int);
    int i = this.jdField_a_of_type_Int;
    int k = 0;
    int m = 0;
    int j = 0;
    Object localObject3;
    Object localObject4;
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4)
        {
          if (i != 5) {
            return null;
          }
          localObject2 = new ArrayList();
          localObject3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, false);
          i = 0;
          while (i < ((List)localObject3).size())
          {
            localObject1 = (TroopMemberInfo)((List)localObject3).get(i);
            if (((TroopMemberInfo)localObject1).commonFrdCnt < 0)
            {
              if (QLog.isColorLevel())
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("commonFrdCnt org:");
                ((StringBuilder)localObject4).append(((TroopMemberInfo)localObject1).commonFrdCnt);
                QLog.d("troopBatchAddFrd.Scene", 2, ((StringBuilder)localObject4).toString());
              }
              ((TroopMemberInfo)localObject1).commonFrdCnt = 0;
            }
            if (((TroopMemberInfo)localObject1).commonFrdCnt >= n) {
              ((List)localObject2).add(localObject1);
            }
            i += 1;
          }
          localObject1 = localObject2;
          if (((List)localObject2).size() == 0)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject4 = this.jdField_c_of_type_JavaLangString;
            if (((List)localObject3).size() == 0) {
              i = j;
            } else {
              i = ((TroopMemberInfo)((List)localObject3).get(0)).commonFrdCnt;
            }
            ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_addFrd", "", "nonGreyTip", "@_res", 0, 0, (String)localObject4, Integer.toString(i), "", "");
            return localObject2;
          }
        }
        else
        {
          localObject2 = new ArrayList();
          localObject3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, false);
          i = 0;
          while (i < ((List)localObject3).size())
          {
            localObject1 = (TroopMemberInfo)((List)localObject3).get(i);
            if (((TroopMemberInfo)localObject1).commonFrdCnt < 0)
            {
              if (QLog.isColorLevel())
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("commonFrdCnt org:");
                ((StringBuilder)localObject4).append(((TroopMemberInfo)localObject1).commonFrdCnt);
                QLog.d("troopBatchAddFrd.Scene", 2, ((StringBuilder)localObject4).toString());
              }
              ((TroopMemberInfo)localObject1).commonFrdCnt = 0;
            }
            if (((TroopMemberInfo)localObject1).commonFrdCnt >= n) {
              ((List)localObject2).add(localObject1);
            }
            i += 1;
          }
          localObject1 = localObject2;
          if (((List)localObject2).size() == 0)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject4 = this.jdField_c_of_type_JavaLangString;
            if (((List)localObject3).size() == 0) {
              i = k;
            } else {
              i = ((TroopMemberInfo)((List)localObject3).get(0)).commonFrdCnt;
            }
            ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_addFrd", "", "nonGreyTip", "new_res", 0, 0, (String)localObject4, Integer.toString(i), "", "");
            return localObject2;
          }
        }
      }
      else
      {
        localObject2 = new ArrayList();
        localObject3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, true);
        i = 0;
        for (j = 0; i < ((List)localObject3).size(); j = k)
        {
          localObject1 = (TroopMemberInfo)((List)localObject3).get(i);
          if (((TroopMemberInfo)localObject1).commonFrdCnt < 0)
          {
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("commonFrdCnt org:");
              ((StringBuilder)localObject4).append(((TroopMemberInfo)localObject1).commonFrdCnt);
              QLog.d("troopBatchAddFrd.Scene", 2, ((StringBuilder)localObject4).toString());
            }
            ((TroopMemberInfo)localObject1).commonFrdCnt = 0;
          }
          k = j;
          if (((TroopMemberInfo)localObject1).commonFrdCnt >= j) {
            k = ((TroopMemberInfo)localObject1).commonFrdCnt;
          }
          if (((TroopMemberInfo)localObject1).commonFrdCnt >= n) {
            ((List)localObject2).add(localObject1);
          }
          i += 1;
        }
        localObject1 = localObject2;
        if (((List)localObject2).size() == 0)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "discus-res", 0, 0, this.jdField_c_of_type_JavaLangString, Integer.toString(j), Integer.toString(((List)localObject3).size()), "");
          return localObject2;
        }
      }
    }
    else
    {
      localObject1 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, null, true);
      i = 0;
      for (j = 0; i < ((List)localObject1).size(); j = k)
      {
        k = j;
        if (((TroopMemberInfo)((List)localObject1).get(i)).commonFrdCnt > 0) {
          k = j + 1;
        }
        i += 1;
      }
      if (j < n)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject3 = this.jdField_c_of_type_JavaLangString;
        localObject4 = Integer.toString(j);
        if (localObject2 == null) {
          i = m;
        } else {
          i = ((TroopInfo)localObject2).wMemberNum;
        }
        ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_addFrd", "", "nonGreyTip", "actvie-res", 0, 0, (String)localObject3, (String)localObject4, Integer.toString(i), "");
        return null;
      }
    }
    return localObject1;
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
    paramString = this.jdField_a_of_type_ComTencentMobileqqTroopAddFrdScene$OnSceneResultListener;
    if (paramString != null) {
      paramString.b(this);
    }
  }
  
  void a(List<TroopMemberInfo> paramList)
  {
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((ITroopBatchAddFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
    int j = 0;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (localTroopBatchAddFriendMgr.a(((TroopMemberInfo)paramList.next()).memberuin) < 0)
        {
          i = 1;
          break label80;
        }
      }
    }
    int i = 0;
    label80:
    if (i != 0)
    {
      paramList = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_c_of_type_JavaLangString);
      if (paramList == null) {
        i = j;
      } else {
        i = paramList.wMemberNum;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "UinNum_total", 0, 0, this.jdField_c_of_type_JavaLangString, Integer.toString(a(this.jdField_a_of_type_Int)), Integer.toString(i), "");
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    QLog.i("troopBatchAddFrd.Scene", 1, String.format("onStepAndNext troopUin_type_ts_suc_step=%s_%d_%d_%b_%d", new Object[] { this.jdField_c_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    int i;
    if (paramBoolean) {
      i = paramInt;
    } else {
      i = -1;
    }
    this.jdField_b_of_type_Int = i;
    if (this.jdField_b_of_type_Int == 0)
    {
      i = a();
    }
    else if (this.jdField_b_of_type_Int == 1)
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
      i = this.jdField_b_of_type_Int;
      i = -1;
    }
    if (i != -1)
    {
      if (i != 0)
      {
        if (i != 1) {
          return;
        }
        a(true, this.jdField_b_of_type_Int + 1);
      }
    }
    else {
      a(String.format("onStepAndNext err %s_%d_%d_%b_%d", new Object[] { this.jdField_c_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Int != -1) && (this.jdField_b_of_type_Int != 6);
  }
  
  public int b()
  {
    long l = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString }), 0L);
    boolean bool;
    if ((l != 0L) && (System.currentTimeMillis() - l <= 86400000L)) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.Scene", 2, String.format("checkDataTroopMemberList cacheInvalid_ts_type_troopUin=%b_%d_%d_%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_c_of_type_JavaLangString }));
    }
    if (bool)
    {
      int i = ((ITroopBatchAddFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr().a(this.jdField_c_of_type_JavaLangString, l, this.jdField_a_of_type_Int);
      if (i != 0)
      {
        if (i != 1) {
          return -1;
        }
        return 1;
      }
      return 0;
    }
    return 1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSuc troopUin = ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject).append(",type = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(",ts=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      QLog.i("troopBatchAddFrd.Scene", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopAddFrdScene$OnSceneResultListener;
    if (localObject != null) {
      ((Scene.OnSceneResultListener)localObject).a(this);
    }
  }
  
  public int c()
  {
    long l = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_cmnfrds", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString }), 0L);
    BatchAddFriendForTroopConfig localBatchAddFriendForTroopConfig = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a();
    boolean bool;
    if ((l != 0L) && (System.currentTimeMillis() - l <= localBatchAddFriendForTroopConfig.t * 60 * 60 * 1000)) {
      bool = false;
    } else {
      bool = true;
    }
    QLog.d("troopBatchAddFrd.Scene", 1, String.format("checkDataCmnFrdCntList cacheInvalid_ts_type_troopUin=%b_%d_%d_%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_c_of_type_JavaLangString }));
    if ((!bool) && (this.jdField_a_of_type_Int != 4)) {
      return 1;
    }
    int i = ((ITroopBatchAddFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr().a(this.jdField_c_of_type_JavaLangString, l, this.jdField_a_of_type_Int, bool ^ true, this.jdField_a_of_type_JavaUtilList);
    if (i != 0)
    {
      if (i != 1) {
        return -1;
      }
      return 1;
    }
    return 0;
  }
  
  public int d()
  {
    long l = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_remarks", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString }), 0L);
    BatchAddFriendForTroopConfig localBatchAddFriendForTroopConfig = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a();
    boolean bool;
    if ((l != 0L) && (System.currentTimeMillis() - l <= localBatchAddFriendForTroopConfig.u * 60 * 60 * 1000)) {
      bool = false;
    } else {
      bool = true;
    }
    QLog.d("troopBatchAddFrd.Scene", 1, String.format("checkDataRecmdRemarkList cacheInvalid_ts_type_troopUin=%b_%d_%d_%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_c_of_type_JavaLangString }));
    if ((!bool) && (this.jdField_a_of_type_Int != 4)) {
      return 1;
    }
    int i = ((ITroopBatchAddFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr().a(this.jdField_c_of_type_JavaLangString, l, this.jdField_a_of_type_Int, bool ^ true);
    if (i != 0)
    {
      if (i != 1) {
        return -1;
      }
      return 1;
    }
    return 0;
  }
  
  public int e()
  {
    boolean bool;
    if (this.jdField_a_of_type_Int == 1) {
      bool = b();
    } else {
      bool = c();
    }
    QLog.isColorLevel();
    if (bool) {
      return 1;
    }
    return -1;
  }
  
  public int f()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_c_of_type_JavaLangString);
    if (localTroopInfo == null)
    {
      this.jdField_b_of_type_Int = -1;
      return -1;
    }
    if (this.jdField_b_of_type_Int != 5) {
      return -1;
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_c_of_type_JavaLangString, 1);
    if (localList.size() > 0)
    {
      int i = Math.min(localList.size(), 10);
      i = localList.size() - i;
      while (i < localList.size())
      {
        if (AnonymousChatHelper.a((MessageRecord)localList.get(i)))
        {
          bool = true;
          break label134;
        }
        i += 1;
      }
    }
    boolean bool = false;
    label134:
    QLog.d("troopBatchAddFrd.Scene", 1, String.format("insertTip hasAnonymousMsg=%b aioList=%d troopUin=%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localList.size()), this.jdField_c_of_type_JavaLangString }));
    if (bool) {
      return 1;
    }
    if (this.jdField_a_of_type_Int == 1) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopInfo, this);
    } else {
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopInfo, this);
    }
    this.jdField_b_of_type_Int = 6;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopAddFrd.Scene
 * JD-Core Version:    0.7.0.1
 */