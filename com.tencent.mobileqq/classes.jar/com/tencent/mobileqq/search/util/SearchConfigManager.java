package com.tencent.mobileqq.search.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import avwb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SearchConfigManager
{
  public static String configSwitch;
  public static int contactSearchFieldBaseBit;
  public static int contactSearchIndexBaseBit;
  public static int contactSearchPinyinBaseBit;
  public static int contactSearchRecentBaseBit;
  public static int contactSearchTypeBaseBit;
  public static String curUin = "";
  public static int engineOrderFavorite;
  public static int engineOrderFeature = 6;
  public static int engineOrderFile;
  public static int engineOrderFunction;
  public static int engineOrderMessage;
  public static int engineOrderNetSearch;
  public static int engineOrderPeople = 7;
  public static int engineOrderPublicAccount;
  public static long fieldAlias;
  public static long fieldDiscussionMemberRemark;
  public static long fieldInteRemark;
  public static long fieldMobileNo;
  public static long fieldNewTroopCard;
  public static long fieldNewTroopNickName;
  public static long fieldNickName;
  public static long fieldPhoneContactName;
  public static long fieldPublicAccountDisplayName;
  public static long fieldPublicAccountMark;
  public static long fieldPublicAccountName;
  public static long fieldPublicAccountSummary;
  public static long fieldRemark;
  public static long fieldTroopCard;
  public static long fieldTroopName;
  public static long fieldUin;
  public static long filedDiscussionName;
  public static long indexEqual;
  public static long indexMiddle;
  public static long indexStart;
  public static volatile boolean isConfigLoaded;
  public static int mStructMsgPicSwitch;
  public static boolean needSeparate;
  public static long recentTrue;
  public static int sReduceDiscussionWeight;
  public static Map<String, Integer> searchEngineOrder;
  public static long stringOrigin;
  public static long stringPinyin;
  public static int troopDurationUnderNotWifi;
  public static int troopDurationUnderWifi;
  public static int troopMemberLimit;
  public static String troopMemberUpdateConfigStr;
  public static ArrayList<avwb> troopMemberUpdateConfigs;
  public static long typeCircleContact;
  public static long typeDiscussion;
  public static long typeDiscussionConversation;
  public static long typeDiscussionConversationMatchMember;
  public static long typeDiscussionConversationMatchTitle;
  public static long typeDiscussionMatchMemberFull;
  public static long typeDiscussionMember;
  public static long typeFriend;
  public static long typeFriendConversation;
  public static long typeFriendNotOftenContact;
  public static long typeFriendSpecialCare;
  public static long typeGlobalTroop;
  public static long typeGlobalTroopConversation;
  public static long typeGlobalTroopMember;
  public static long typeNewTroop;
  public static long typeNewTroopMember;
  public static long typePhoneContact;
  public static long typePublicAccount;
  public static long typePublicAccountConversation;
  public static long typeQidianMaster;
  public static long typeTool;
  public static long typeTroop;
  public static long typeTroopConversation;
  public static long typeTroopMember;
  public static long typeUnbindPhoneContact;
  public static int voiceSearchSwitch;
  
  static
  {
    engineOrderMessage = 5;
    engineOrderPublicAccount = 4;
    engineOrderFavorite = 3;
    engineOrderFile = 2;
    engineOrderNetSearch = 1;
    contactSearchPinyinBaseBit = 58;
    contactSearchRecentBaseBit = 48;
    contactSearchIndexBaseBit = 40;
    contactSearchTypeBaseBit = 32;
    contactSearchFieldBaseBit = 24;
    stringOrigin = 2L;
    stringPinyin = 1L;
    recentTrue = 1L;
    indexEqual = 3L;
    indexStart = 2L;
    indexMiddle = 1L;
    fieldPublicAccountName = 12L;
    fieldPublicAccountMark = 11L;
    fieldPublicAccountSummary = 10L;
    fieldPublicAccountDisplayName = 9L;
    filedDiscussionName = 8L;
    fieldTroopName = 8L;
    fieldRemark = 8L;
    fieldNewTroopNickName = 8L;
    fieldNewTroopCard = 8L;
    fieldDiscussionMemberRemark = 7L;
    fieldInteRemark = 6L;
    fieldNickName = 5L;
    fieldPhoneContactName = 4L;
    fieldAlias = 3L;
    fieldUin = 2L;
    fieldMobileNo = 1L;
    fieldTroopCard = 6L;
    typeFriendConversation = 15L;
    typeTroopConversation = 15L;
    typeDiscussionConversationMatchTitle = 15L;
    typeDiscussionConversation = 15L;
    typeFriendSpecialCare = 14L;
    typeFriend = 13L;
    typeFriendNotOftenContact = 12L;
    typeNewTroopMember = 12L;
    typeDiscussionMember = 11L;
    typePhoneContact = 10L;
    typeDiscussionMatchMemberFull = 9L;
    typeDiscussionConversationMatchMember = 8L;
    typeNewTroop = 8L;
    typeDiscussion = 7L;
    typeTroop = 7L;
    typeQidianMaster = 6L;
    typeTroopMember = 6L;
    typeTool = 4L;
    typePublicAccountConversation = 4L;
    typePublicAccount = 3L;
    typeUnbindPhoneContact = 2L;
    typeCircleContact = 1L;
    typeGlobalTroopMember = 9L;
    typeGlobalTroop = 7L;
    typeGlobalTroopConversation = 8L;
    troopMemberLimit = 70;
    troopDurationUnderWifi = 24;
    troopDurationUnderNotWifi = 72;
    searchEngineOrder = new HashMap();
    sReduceDiscussionWeight = 1;
    troopMemberUpdateConfigStr = "0|100|1|3,101|500|7|15";
    troopMemberUpdateConfigs = a("0|100|1|3,101|500|7|15");
  }
  
  private static ArrayList<avwb> a(String paramString)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("SearchConfigManager", 2, "parseTroopMemberUpdateSetting, config: " + paramString);
    }
    Object localObject1;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      return localObject1;
      ArrayList localArrayList = new ArrayList();
      try
      {
        String[] arrayOfString = paramString.split(",");
        localObject1 = localArrayList;
        if (arrayOfString != null)
        {
          localObject1 = localArrayList;
          if (arrayOfString.length > 0)
          {
            int j = arrayOfString.length;
            for (;;)
            {
              localObject1 = localArrayList;
              if (i >= j) {
                break;
              }
              localObject1 = arrayOfString[i].trim().split("\\|");
              if ((localObject1 != null) && (localObject1.length == 4))
              {
                avwb localavwb = new avwb();
                localavwb.a = Integer.valueOf(localObject1[0]).intValue();
                localavwb.b = Integer.valueOf(localObject1[1]).intValue();
                localavwb.c = (Integer.valueOf(localObject1[2]).intValue() * 24);
                localavwb.d = (Integer.valueOf(localObject1[3]).intValue() * 24);
                localArrayList.add(localavwb);
              }
              i += 1;
            }
            Object localObject2;
            if (paramString.equals("0|100|1|3,101|500|7|15")) {}
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("SearchConfigManager", 2, "parseTroopMemberUpdateSetting error");
        }
        localObject2 = localArrayList;
      }
    }
    return a("0|100|1|3,101|500|7|15");
  }
  
  private static void a()
  {
    engineOrderPeople = 6;
    engineOrderMessage = 5;
    engineOrderPublicAccount = 4;
    engineOrderFavorite = 3;
    engineOrderFile = 2;
    engineOrderNetSearch = 1;
    contactSearchPinyinBaseBit = 58;
    contactSearchRecentBaseBit = 48;
    contactSearchIndexBaseBit = 40;
    contactSearchTypeBaseBit = 32;
    contactSearchFieldBaseBit = 24;
    stringOrigin = 2L;
    stringPinyin = 1L;
    recentTrue = 1L;
    indexEqual = 3L;
    indexStart = 2L;
    indexMiddle = 1L;
    fieldPublicAccountName = 12L;
    fieldPublicAccountMark = 11L;
    fieldPublicAccountSummary = 10L;
    fieldPublicAccountDisplayName = 9L;
    filedDiscussionName = 8L;
    fieldTroopName = 8L;
    fieldRemark = 8L;
    fieldNewTroopNickName = 8L;
    fieldNewTroopCard = 8L;
    fieldDiscussionMemberRemark = 7L;
    fieldInteRemark = 6L;
    fieldNickName = 5L;
    fieldPhoneContactName = 4L;
    fieldAlias = 3L;
    fieldUin = 2L;
    fieldMobileNo = 1L;
    fieldTroopCard = 6L;
    typeFriendConversation = 15L;
    typeTroopConversation = 15L;
    typeDiscussionConversationMatchTitle = 15L;
    typeDiscussionConversation = 15L;
    typeFriendSpecialCare = 14L;
    typeFriend = 13L;
    typeFriendNotOftenContact = 12L;
    typeNewTroopMember = 12L;
    typeDiscussionMember = 11L;
    typePhoneContact = 10L;
    typeDiscussionMatchMemberFull = 9L;
    typeDiscussionConversationMatchMember = 8L;
    typeNewTroop = 8L;
    typeDiscussion = 7L;
    typeTroop = 7L;
    typeTroopMember = 6L;
    typeTool = 4L;
    typePublicAccountConversation = 4L;
    typePublicAccount = 3L;
    typeUnbindPhoneContact = 2L;
    typeCircleContact = 1L;
    typeGlobalTroopMember = 9L;
    typeGlobalTroop = 7L;
    typeGlobalTroopConversation = 8L;
    troopMemberLimit = 70;
    troopDurationUnderWifi = 24;
    troopDurationUnderNotWifi = 72;
    sReduceDiscussionWeight = 1;
    troopMemberUpdateConfigStr = "0|100|1|3,101|500|7|15";
    troopMemberUpdateConfigs = a("0|100|1|3,101|500|7|15");
    searchEngineOrder = new HashMap();
    voiceSearchSwitch = 0;
    needSeparate = false;
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +13 -> 19
    //   9: ldc_w 277
    //   12: iconst_2
    //   13: ldc_w 371
    //   16: invokestatic 374	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 378	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   23: astore_0
    //   24: aload_0
    //   25: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +726 -> 754
    //   31: aload_0
    //   32: getstatic 265	com/tencent/mobileqq/search/util/SearchConfigManager:curUin	Ljava/lang/String;
    //   35: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   38: ifne +716 -> 754
    //   41: aload_0
    //   42: putstatic 265	com/tencent/mobileqq/search/util/SearchConfigManager:curUin	Ljava/lang/String;
    //   45: iconst_1
    //   46: putstatic 380	com/tencent/mobileqq/search/util/SearchConfigManager:isConfigLoaded	Z
    //   49: iconst_0
    //   50: putstatic 358	com/tencent/mobileqq/search/util/SearchConfigManager:voiceSearchSwitch	I
    //   53: invokestatic 386	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   56: new 279	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   63: aload_0
    //   64: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 388
    //   70: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc_w 390
    //   76: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: iconst_0
    //   83: invokevirtual 394	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   86: astore_0
    //   87: aload_0
    //   88: ldc_w 395
    //   91: ldc_w 263
    //   94: invokeinterface 401 3 0
    //   99: putstatic 403	com/tencent/mobileqq/search/util/SearchConfigManager:configSwitch	Ljava/lang/String;
    //   102: ldc_w 405
    //   105: getstatic 403	com/tencent/mobileqq/search/util/SearchConfigManager:configSwitch	Ljava/lang/String;
    //   108: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   111: ifne +13 -> 124
    //   114: invokestatic 407	com/tencent/mobileqq/search/util/SearchConfigManager:a	()V
    //   117: invokestatic 410	avin:a	()V
    //   120: ldc 2
    //   122: monitorexit
    //   123: return
    //   124: aload_0
    //   125: invokeinterface 414 1 0
    //   130: astore_0
    //   131: aload_0
    //   132: ifnull +283 -> 415
    //   135: aload_0
    //   136: invokeinterface 420 1 0
    //   141: invokeinterface 426 1 0
    //   146: astore 5
    //   148: aload 5
    //   150: invokeinterface 431 1 0
    //   155: ifeq +260 -> 415
    //   158: aload 5
    //   160: invokeinterface 435 1 0
    //   165: checkcast 307	java/lang/String
    //   168: astore 6
    //   170: ldc 2
    //   172: aload 6
    //   174: invokevirtual 441	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   177: astore 7
    //   179: aload_0
    //   180: aload 6
    //   182: invokeinterface 445 2 0
    //   187: checkcast 307	java/lang/String
    //   190: astore 8
    //   192: aload 8
    //   194: ifnull -46 -> 148
    //   197: aload 7
    //   199: invokevirtual 451	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   202: ldc_w 307
    //   205: if_acmpne +38 -> 243
    //   208: aload 7
    //   210: aconst_null
    //   211: aload 8
    //   213: invokevirtual 455	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   216: goto -68 -> 148
    //   219: astore 6
    //   221: aload 6
    //   223: invokevirtual 456	java/lang/NoSuchFieldException:printStackTrace	()V
    //   226: goto -78 -> 148
    //   229: astore_0
    //   230: aload_0
    //   231: invokevirtual 346	java/lang/Exception:printStackTrace	()V
    //   234: goto -114 -> 120
    //   237: astore_0
    //   238: ldc 2
    //   240: monitorexit
    //   241: aload_0
    //   242: athrow
    //   243: aload 7
    //   245: invokevirtual 451	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   248: getstatic 460	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   251: if_acmpne +38 -> 289
    //   254: aload 7
    //   256: aconst_null
    //   257: aload 8
    //   259: invokestatic 464	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   262: invokestatic 467	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: invokevirtual 455	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   268: goto -120 -> 148
    //   271: astore 6
    //   273: aload 6
    //   275: invokevirtual 468	java/lang/IllegalAccessException:printStackTrace	()V
    //   278: goto -130 -> 148
    //   281: astore_0
    //   282: aload_0
    //   283: invokevirtual 469	java/lang/Error:printStackTrace	()V
    //   286: goto -166 -> 120
    //   289: aload 7
    //   291: invokevirtual 451	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   294: getstatic 472	java/lang/Long:TYPE	Ljava/lang/Class;
    //   297: if_acmpne -149 -> 148
    //   300: aload 8
    //   302: invokestatic 476	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   305: lstore_3
    //   306: lload_3
    //   307: lconst_0
    //   308: lcmp
    //   309: ifle +38 -> 347
    //   312: lload_3
    //   313: ldc2_w 477
    //   316: lcmp
    //   317: ifge +30 -> 347
    //   320: aload 7
    //   322: aconst_null
    //   323: aload 8
    //   325: invokestatic 476	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   328: invokestatic 481	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   331: invokevirtual 455	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   334: goto -186 -> 148
    //   337: astore 6
    //   339: aload 6
    //   341: invokevirtual 482	java/lang/NumberFormatException:printStackTrace	()V
    //   344: goto -196 -> 148
    //   347: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq -202 -> 148
    //   353: ldc_w 277
    //   356: iconst_2
    //   357: new 279	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   364: ldc_w 484
    //   367: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload 6
    //   372: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: ldc_w 486
    //   378: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload 8
    //   383: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 351	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: goto -244 -> 148
    //   395: astore 6
    //   397: aload 6
    //   399: invokevirtual 346	java/lang/Exception:printStackTrace	()V
    //   402: goto -254 -> 148
    //   405: astore 6
    //   407: aload 6
    //   409: invokevirtual 469	java/lang/Error:printStackTrace	()V
    //   412: goto -264 -> 148
    //   415: invokestatic 488	com/tencent/mobileqq/search/util/SearchConfigManager:b	()V
    //   418: getstatic 249	com/tencent/mobileqq/search/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   421: ldc_w 490
    //   424: getstatic 92	com/tencent/mobileqq/search/util/SearchConfigManager:engineOrderPeople	I
    //   427: invokestatic 467	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   430: invokeinterface 494 3 0
    //   435: pop
    //   436: getstatic 249	com/tencent/mobileqq/search/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   439: ldc_w 496
    //   442: getstatic 94	com/tencent/mobileqq/search/util/SearchConfigManager:engineOrderMessage	I
    //   445: invokestatic 467	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   448: invokeinterface 494 3 0
    //   453: pop
    //   454: getstatic 249	com/tencent/mobileqq/search/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   457: ldc_w 498
    //   460: getstatic 94	com/tencent/mobileqq/search/util/SearchConfigManager:engineOrderMessage	I
    //   463: invokestatic 467	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   466: invokeinterface 494 3 0
    //   471: pop
    //   472: getstatic 249	com/tencent/mobileqq/search/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   475: ldc_w 500
    //   478: getstatic 96	com/tencent/mobileqq/search/util/SearchConfigManager:engineOrderPublicAccount	I
    //   481: invokestatic 467	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   484: invokeinterface 494 3 0
    //   489: pop
    //   490: getstatic 249	com/tencent/mobileqq/search/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   493: ldc_w 502
    //   496: getstatic 98	com/tencent/mobileqq/search/util/SearchConfigManager:engineOrderFavorite	I
    //   499: invokestatic 467	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   502: invokeinterface 494 3 0
    //   507: pop
    //   508: getstatic 249	com/tencent/mobileqq/search/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   511: ldc_w 504
    //   514: getstatic 100	com/tencent/mobileqq/search/util/SearchConfigManager:engineOrderFile	I
    //   517: invokestatic 467	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   520: invokeinterface 494 3 0
    //   525: pop
    //   526: getstatic 249	com/tencent/mobileqq/search/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   529: ldc_w 506
    //   532: getstatic 102	com/tencent/mobileqq/search/util/SearchConfigManager:engineOrderNetSearch	I
    //   535: invokestatic 467	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   538: invokeinterface 494 3 0
    //   543: pop
    //   544: getstatic 249	com/tencent/mobileqq/search/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   547: ldc_w 508
    //   550: getstatic 90	com/tencent/mobileqq/search/util/SearchConfigManager:engineOrderFeature	I
    //   553: invokestatic 467	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   556: invokeinterface 494 3 0
    //   561: pop
    //   562: getstatic 249	com/tencent/mobileqq/search/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   565: ldc_w 510
    //   568: getstatic 512	com/tencent/mobileqq/search/util/SearchConfigManager:engineOrderFunction	I
    //   571: invokestatic 467	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   574: invokeinterface 494 3 0
    //   579: pop
    //   580: invokestatic 410	avin:a	()V
    //   583: getstatic 255	com/tencent/mobileqq/search/util/SearchConfigManager:troopMemberUpdateConfigStr	Ljava/lang/String;
    //   586: invokestatic 259	com/tencent/mobileqq/search/util/SearchConfigManager:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   589: putstatic 261	com/tencent/mobileqq/search/util/SearchConfigManager:troopMemberUpdateConfigs	Ljava/util/ArrayList;
    //   592: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   595: ifeq +13 -> 608
    //   598: ldc_w 277
    //   601: iconst_2
    //   602: ldc_w 514
    //   605: invokestatic 374	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   611: ifeq +143 -> 754
    //   614: new 279	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   621: astore_0
    //   622: aload_0
    //   623: ldc_w 277
    //   626: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: aload_0
    //   631: ldc_w 516
    //   634: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: ldc 2
    //   640: invokevirtual 520	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   643: astore 5
    //   645: aload 5
    //   647: arraylength
    //   648: istore_2
    //   649: iconst_0
    //   650: istore_1
    //   651: iload_1
    //   652: iload_2
    //   653: if_icmpge +63 -> 716
    //   656: aload 5
    //   658: iload_1
    //   659: aaload
    //   660: astore 6
    //   662: aload_0
    //   663: aload 6
    //   665: invokevirtual 523	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   668: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload_0
    //   673: ldc_w 486
    //   676: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload_0
    //   681: aload 6
    //   683: aconst_null
    //   684: invokevirtual 524	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   687: invokevirtual 527	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   690: pop
    //   691: aload_0
    //   692: ldc_w 529
    //   695: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: pop
    //   699: iload_1
    //   700: iconst_1
    //   701: iadd
    //   702: istore_1
    //   703: goto -52 -> 651
    //   706: astore 6
    //   708: aload 6
    //   710: invokevirtual 468	java/lang/IllegalAccessException:printStackTrace	()V
    //   713: goto -22 -> 691
    //   716: aload_0
    //   717: ldc_w 531
    //   720: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: pop
    //   724: ldc_w 277
    //   727: iconst_2
    //   728: new 279	java/lang/StringBuilder
    //   731: dup
    //   732: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   735: ldc_w 533
    //   738: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: aload_0
    //   742: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokestatic 374	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   754: invokestatic 538	alzw:a	()Lalzw;
    //   757: sipush 414
    //   760: invokevirtual 541	alzw:a	(I)Ljava/lang/Object;
    //   763: checkcast 543	amcn
    //   766: astore_0
    //   767: aload_0
    //   768: ifnull -648 -> 120
    //   771: aload_0
    //   772: invokevirtual 545	amcn:a	()Z
    //   775: putstatic 360	com/tencent/mobileqq/search/util/SearchConfigManager:needSeparate	Z
    //   778: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   781: ifeq -661 -> 120
    //   784: ldc_w 277
    //   787: iconst_2
    //   788: new 279	java/lang/StringBuilder
    //   791: dup
    //   792: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   795: ldc_w 547
    //   798: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: getstatic 360	com/tencent/mobileqq/search/util/SearchConfigManager:needSeparate	Z
    //   804: invokevirtual 550	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   807: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   810: invokestatic 374	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   813: goto -693 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	816	0	paramQQAppInterface	QQAppInterface
    //   650	53	1	i	int
    //   648	6	2	j	int
    //   305	8	3	l	long
    //   146	511	5	localObject1	Object
    //   168	13	6	str1	String
    //   219	3	6	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   271	3	6	localIllegalAccessException1	java.lang.IllegalAccessException
    //   337	34	6	localNumberFormatException	java.lang.NumberFormatException
    //   395	3	6	localException	Exception
    //   405	3	6	localError	java.lang.Error
    //   660	22	6	localObject2	Object
    //   706	3	6	localIllegalAccessException2	java.lang.IllegalAccessException
    //   177	144	7	localField	java.lang.reflect.Field
    //   190	192	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   170	192	219	java/lang/NoSuchFieldException
    //   197	216	219	java/lang/NoSuchFieldException
    //   243	268	219	java/lang/NoSuchFieldException
    //   289	306	219	java/lang/NoSuchFieldException
    //   320	334	219	java/lang/NoSuchFieldException
    //   347	392	219	java/lang/NoSuchFieldException
    //   3	19	229	java/lang/Exception
    //   19	120	229	java/lang/Exception
    //   124	131	229	java/lang/Exception
    //   135	148	229	java/lang/Exception
    //   148	170	229	java/lang/Exception
    //   221	226	229	java/lang/Exception
    //   273	278	229	java/lang/Exception
    //   339	344	229	java/lang/Exception
    //   397	402	229	java/lang/Exception
    //   407	412	229	java/lang/Exception
    //   415	608	229	java/lang/Exception
    //   608	649	229	java/lang/Exception
    //   662	680	229	java/lang/Exception
    //   680	691	229	java/lang/Exception
    //   691	699	229	java/lang/Exception
    //   708	713	229	java/lang/Exception
    //   716	754	229	java/lang/Exception
    //   754	767	229	java/lang/Exception
    //   771	813	229	java/lang/Exception
    //   3	19	237	finally
    //   19	120	237	finally
    //   124	131	237	finally
    //   135	148	237	finally
    //   148	170	237	finally
    //   170	192	237	finally
    //   197	216	237	finally
    //   221	226	237	finally
    //   230	234	237	finally
    //   243	268	237	finally
    //   273	278	237	finally
    //   282	286	237	finally
    //   289	306	237	finally
    //   320	334	237	finally
    //   339	344	237	finally
    //   347	392	237	finally
    //   397	402	237	finally
    //   407	412	237	finally
    //   415	608	237	finally
    //   608	649	237	finally
    //   662	680	237	finally
    //   680	691	237	finally
    //   691	699	237	finally
    //   708	713	237	finally
    //   716	754	237	finally
    //   754	767	237	finally
    //   771	813	237	finally
    //   170	192	271	java/lang/IllegalAccessException
    //   197	216	271	java/lang/IllegalAccessException
    //   243	268	271	java/lang/IllegalAccessException
    //   289	306	271	java/lang/IllegalAccessException
    //   320	334	271	java/lang/IllegalAccessException
    //   347	392	271	java/lang/IllegalAccessException
    //   3	19	281	java/lang/Error
    //   19	120	281	java/lang/Error
    //   124	131	281	java/lang/Error
    //   135	148	281	java/lang/Error
    //   148	170	281	java/lang/Error
    //   221	226	281	java/lang/Error
    //   273	278	281	java/lang/Error
    //   339	344	281	java/lang/Error
    //   397	402	281	java/lang/Error
    //   407	412	281	java/lang/Error
    //   415	608	281	java/lang/Error
    //   608	649	281	java/lang/Error
    //   662	680	281	java/lang/Error
    //   680	691	281	java/lang/Error
    //   691	699	281	java/lang/Error
    //   708	713	281	java/lang/Error
    //   716	754	281	java/lang/Error
    //   754	767	281	java/lang/Error
    //   771	813	281	java/lang/Error
    //   170	192	337	java/lang/NumberFormatException
    //   197	216	337	java/lang/NumberFormatException
    //   243	268	337	java/lang/NumberFormatException
    //   289	306	337	java/lang/NumberFormatException
    //   320	334	337	java/lang/NumberFormatException
    //   347	392	337	java/lang/NumberFormatException
    //   170	192	395	java/lang/Exception
    //   197	216	395	java/lang/Exception
    //   243	268	395	java/lang/Exception
    //   289	306	395	java/lang/Exception
    //   320	334	395	java/lang/Exception
    //   347	392	395	java/lang/Exception
    //   170	192	405	java/lang/Error
    //   197	216	405	java/lang/Error
    //   243	268	405	java/lang/Error
    //   289	306	405	java/lang/Error
    //   320	334	405	java/lang/Error
    //   347	392	405	java/lang/Error
    //   680	691	706	java/lang/IllegalAccessException
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "_" + "sp_search_config", 0).edit();
    paramQQAppInterface.clear();
    paramQQAppInterface.commit();
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc_w 277
    //   9: iconst_2
    //   10: new 279	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 568
    //   20: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_2
    //   24: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 294	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_2
    //   34: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifeq +4 -> 41
    //   40: return
    //   41: invokestatic 386	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   44: new 279	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   51: aload_1
    //   52: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 388
    //   58: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 390
    //   64: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: iconst_0
    //   71: invokevirtual 394	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   74: invokeinterface 555 1 0
    //   79: astore_0
    //   80: new 570	org/json/JSONObject
    //   83: dup
    //   84: aload_2
    //   85: invokespecial 573	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   88: astore_1
    //   89: aload_1
    //   90: ldc_w 395
    //   93: invokevirtual 576	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   96: putstatic 403	com/tencent/mobileqq/search/util/SearchConfigManager:configSwitch	Ljava/lang/String;
    //   99: ldc_w 405
    //   102: getstatic 403	com/tencent/mobileqq/search/util/SearchConfigManager:configSwitch	Ljava/lang/String;
    //   105: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifne +30 -> 138
    //   111: aload_0
    //   112: ldc_w 395
    //   115: ldc_w 578
    //   118: invokeinterface 582 3 0
    //   123: pop
    //   124: aload_0
    //   125: invokeinterface 563 1 0
    //   130: pop
    //   131: return
    //   132: astore_0
    //   133: aload_0
    //   134: invokevirtual 583	org/json/JSONException:printStackTrace	()V
    //   137: return
    //   138: aload_1
    //   139: ldc_w 584
    //   142: invokevirtual 588	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   145: ifeq +48 -> 193
    //   148: aload_1
    //   149: ldc_w 584
    //   152: invokevirtual 591	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   155: istore_3
    //   156: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +30 -> 189
    //   162: ldc_w 277
    //   165: iconst_2
    //   166: new 279	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 593
    //   176: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload_3
    //   180: invokevirtual 596	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 374	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: iload_3
    //   190: invokestatic 601	atqm:a	(I)V
    //   193: aload_1
    //   194: invokevirtual 604	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   197: astore_2
    //   198: aload_2
    //   199: invokeinterface 431 1 0
    //   204: ifeq +77 -> 281
    //   207: aload_2
    //   208: invokeinterface 435 1 0
    //   213: checkcast 307	java/lang/String
    //   216: astore 4
    //   218: aload_0
    //   219: aload 4
    //   221: aload_1
    //   222: aload 4
    //   224: invokevirtual 607	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   227: checkcast 307	java/lang/String
    //   230: invokeinterface 582 3 0
    //   235: pop
    //   236: goto -38 -> 198
    //   239: astore 4
    //   241: aload 4
    //   243: invokevirtual 583	org/json/JSONException:printStackTrace	()V
    //   246: goto -48 -> 198
    //   249: astore_0
    //   250: aload_0
    //   251: invokevirtual 346	java/lang/Exception:printStackTrace	()V
    //   254: return
    //   255: astore 4
    //   257: aload 4
    //   259: invokevirtual 346	java/lang/Exception:printStackTrace	()V
    //   262: goto -64 -> 198
    //   265: astore_0
    //   266: aload_0
    //   267: invokevirtual 469	java/lang/Error:printStackTrace	()V
    //   270: return
    //   271: astore 4
    //   273: aload 4
    //   275: invokevirtual 469	java/lang/Error:printStackTrace	()V
    //   278: goto -80 -> 198
    //   281: aload_0
    //   282: invokeinterface 563 1 0
    //   287: pop
    //   288: ldc_w 263
    //   291: putstatic 265	com/tencent/mobileqq/search/util/SearchConfigManager:curUin	Ljava/lang/String;
    //   294: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	paramQQAppInterface	QQAppInterface
    //   0	295	1	paramString1	String
    //   0	295	2	paramString2	String
    //   155	35	3	i	int
    //   216	7	4	str	String
    //   239	3	4	localJSONException	org.json.JSONException
    //   255	3	4	localException	Exception
    //   271	3	4	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   41	131	132	org/json/JSONException
    //   138	189	132	org/json/JSONException
    //   189	193	132	org/json/JSONException
    //   193	198	132	org/json/JSONException
    //   198	218	132	org/json/JSONException
    //   241	246	132	org/json/JSONException
    //   257	262	132	org/json/JSONException
    //   273	278	132	org/json/JSONException
    //   281	294	132	org/json/JSONException
    //   218	236	239	org/json/JSONException
    //   41	131	249	java/lang/Exception
    //   138	189	249	java/lang/Exception
    //   189	193	249	java/lang/Exception
    //   193	198	249	java/lang/Exception
    //   198	218	249	java/lang/Exception
    //   241	246	249	java/lang/Exception
    //   257	262	249	java/lang/Exception
    //   273	278	249	java/lang/Exception
    //   281	294	249	java/lang/Exception
    //   218	236	255	java/lang/Exception
    //   41	131	265	java/lang/Error
    //   138	189	265	java/lang/Error
    //   189	193	265	java/lang/Error
    //   193	198	265	java/lang/Error
    //   198	218	265	java/lang/Error
    //   241	246	265	java/lang/Error
    //   257	262	265	java/lang/Error
    //   273	278	265	java/lang/Error
    //   281	294	265	java/lang/Error
    //   218	236	271	java/lang/Error
  }
  
  private static void b()
  {
    int k = 1;
    if ((contactSearchPinyinBaseBit <= 0) || (contactSearchPinyinBaseBit >= 64))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SearchConfigManager", 2, "Value is invalid : contactSearchPinyinBaseBit=" + contactSearchPinyinBaseBit);
      }
      contactSearchPinyinBaseBit = 58;
    }
    if ((contactSearchRecentBaseBit <= 0) || (contactSearchRecentBaseBit >= 64))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SearchConfigManager", 2, "Value is invalid : contactSearchRecentBaseBit=" + contactSearchRecentBaseBit);
      }
      contactSearchRecentBaseBit = 48;
    }
    if ((contactSearchIndexBaseBit <= 0) || (contactSearchIndexBaseBit >= 64))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SearchConfigManager", 2, "Value is invalid : contactSearchIndexBaseBit=" + contactSearchIndexBaseBit);
      }
      contactSearchIndexBaseBit = 40;
    }
    if ((contactSearchTypeBaseBit <= 0) || (contactSearchTypeBaseBit >= 64))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SearchConfigManager", 2, "Value is invalid : contactSearchTypeBaseBit=" + contactSearchTypeBaseBit);
      }
      contactSearchTypeBaseBit = 32;
    }
    if ((contactSearchFieldBaseBit <= 0) || (contactSearchFieldBaseBit >= 64))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SearchConfigManager", 2, "Value is invalid : contactSearchFieldBaseBit=" + contactSearchFieldBaseBit);
      }
      contactSearchFieldBaseBit = 24;
    }
    int[] arrayOfInt = new int[6];
    arrayOfInt[0] = contactSearchPinyinBaseBit;
    arrayOfInt[1] = contactSearchRecentBaseBit;
    arrayOfInt[2] = contactSearchIndexBaseBit;
    arrayOfInt[3] = contactSearchTypeBaseBit;
    arrayOfInt[4] = contactSearchFieldBaseBit;
    arrayOfInt[5] = 64;
    Arrays.sort(arrayOfInt);
    int i = 1;
    for (;;)
    {
      int j = k;
      if (i < arrayOfInt.length)
      {
        if (arrayOfInt[i] - arrayOfInt[(i - 1)] < 6) {
          j = 0;
        }
      }
      else
      {
        if (j == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SearchConfigManager", 2, "Value is invalid : interval < 6 : contactSearchPinyinBaseBit=" + contactSearchPinyinBaseBit + ";contactSearchRecentBaseBit=" + contactSearchRecentBaseBit + ";contactSearchIndexBaseBit=" + contactSearchIndexBaseBit + ";contactSearchTypeBaseBit=" + contactSearchTypeBaseBit + ";contactSearchFieldBaseBit=" + contactSearchFieldBaseBit);
          }
          contactSearchPinyinBaseBit = 58;
          contactSearchRecentBaseBit = 48;
          contactSearchIndexBaseBit = 40;
          contactSearchTypeBaseBit = 32;
          contactSearchFieldBaseBit = 24;
        }
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchConfigManager
 * JD-Core Version:    0.7.0.1
 */