package com.tencent.mobileqq.startup.step;

import aifg;
import aifh;
import aifi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.subscript.SubscriptUtil;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MigrateSubscribeDB
  extends Step
{
  public static boolean a;
  int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long = 0L;
  BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private List jdField_a_of_type_JavaUtilList;
  private List jdField_b_of_type_JavaUtilList;
  volatile boolean jdField_b_of_type_Boolean = true;
  private List c;
  
  private int a()
  {
    return (short)Math.abs(new Random().nextInt()) & 0xFFFF;
  }
  
  private long a()
  {
    return MessageUtils.a(Math.abs(new Random().nextInt()) | 0x0);
  }
  
  private String a(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    String str;
    do
    {
      return paramObject;
      str = paramObject.toString();
      paramObject = str;
    } while (str.length() <= 0);
    return SecurityUtile.b(str);
  }
  
  private List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "getSubscribeRecentDataList fail readInJoySubDBName is null");
      }
      paramString = null;
      return paramString;
    }
    aifh localaifh = new aifh(this, BaseApplication.getContext(), paramString, 17);
    paramString = localaifh.getReadableDatabase().rawQuery("select * from RecentSubscribeData order by mLastMsgTime DESC", null);
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        if (!paramString.moveToFirst()) {
          continue;
        }
        int i = paramString.getColumnIndex("mDraft");
        int j = paramString.getColumnIndex("mDraftTime");
        int k = paramString.getColumnIndex("mLastMsg");
        int m = paramString.getColumnIndex("mLastMsgID");
        int n = paramString.getColumnIndex("mLastMsgTime");
        int i1 = paramString.getColumnIndex("mLastReorderTime");
        int i2 = paramString.getColumnIndex("mSubscribeHeadUrl");
        int i3 = paramString.getColumnIndex("mSubscribeID");
        int i4 = paramString.getColumnIndex("mSubscribeName");
        int i5 = paramString.getColumnIndex("mUnreadCount");
        aifi localaifi = new aifi(this, null);
        localaifi.d = a(paramString.getString(i));
        localaifi.e = a(paramString.getString(j));
        localaifi.jdField_c_of_type_JavaLangString = a(paramString.getString(k));
        localaifi.jdField_b_of_type_Long = paramString.getLong(m);
        localaifi.jdField_a_of_type_Long = paramString.getLong(n);
        localaifi.jdField_c_of_type_Long = paramString.getLong(i1);
        localaifi.f = a(paramString.getString(i2));
        localaifi.jdField_a_of_type_JavaLangString = a(paramString.getString(i3));
        localaifi.jdField_b_of_type_JavaLangString = a(paramString.getString(i4));
        localaifi.jdField_a_of_type_Int = paramString.getInt(i5);
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "read Subscribe RecentDataResults:(mDraft,mDraftTime,mLastMsg,mLastMsgID,mLastMsgTime,mLastReorderTime,mSubscribeHeadUrl,mSubscribeID,mSubscribeName,mUnreadCount)=(" + localaifi.d + "," + localaifi.e + "," + localaifi.jdField_c_of_type_JavaLangString + "," + localaifi.jdField_b_of_type_Long + "," + localaifi.jdField_a_of_type_Long + "," + localaifi.jdField_c_of_type_Long + localaifi.f + "," + localaifi.jdField_a_of_type_JavaLangString + "," + localaifi.jdField_b_of_type_JavaLangString + "," + localaifi.jdField_a_of_type_Int + ")");
        }
        localArrayList.add(localaifi);
        boolean bool = paramString.moveToNext();
        if (bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MigrateSubscribeDB", 2, "read Subscribe Recent Datas Exception", localException);
        paramString.close();
        continue;
      }
      finally
      {
        paramString.close();
      }
      paramString = localArrayList;
      if (localaifh == null) {
        break;
      }
      localaifh.close();
      return localArrayList;
      if (QLog.isColorLevel())
      {
        QLog.d("MigrateSubscribeDB", 2, "getSubscribeRecentDataList select from RecentSubscribeData no data");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "getSubscribeRecentDataList fail curSubReadInJoy is null");
        }
      }
    }
  }
  
  /* Error */
  private List a(String paramString1, String paramString2, List paramList, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +56 -> 59
    //   6: ldc 80
    //   8: iconst_2
    //   9: new 179	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   16: ldc 225
    //   18: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 227
    //   27: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_2
    //   31: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 229
    //   36: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_3
    //   40: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: ldc 234
    //   45: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload 4
    //   50: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: invokestatic 239	java/lang/System:nanoTime	()J
    //   62: lstore 13
    //   64: new 71	java/util/ArrayList
    //   67: dup
    //   68: invokespecial 72	java/util/ArrayList:<init>	()V
    //   71: astore 22
    //   73: aload_2
    //   74: ifnull +7 -> 81
    //   77: aload_3
    //   78: ifnonnull +19 -> 97
    //   81: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +11 -> 95
    //   87: ldc 80
    //   89: iconst_2
    //   90: ldc 241
    //   92: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aconst_null
    //   96: areturn
    //   97: aload_3
    //   98: invokeinterface 244 1 0
    //   103: istore 6
    //   105: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +29 -> 137
    //   111: ldc 80
    //   113: iconst_2
    //   114: new 179	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   121: ldc 246
    //   123: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: iload 6
    //   128: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: iconst_0
    //   138: istore 5
    //   140: iload 5
    //   142: iload 6
    //   144: if_icmpge +959 -> 1103
    //   147: aload_3
    //   148: iload 5
    //   150: invokeinterface 250 2 0
    //   155: checkcast 140	aifi
    //   158: getfield 171	aifi:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   161: aload_2
    //   162: invokevirtual 253	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   165: ifeq +676 -> 841
    //   168: aload_3
    //   169: iload 5
    //   171: invokeinterface 250 2 0
    //   176: checkcast 140	aifi
    //   179: astore_3
    //   180: aload_3
    //   181: ifnull +916 -> 1097
    //   184: aload_3
    //   185: getfield 177	aifi:jdField_a_of_type_Int	I
    //   188: istore 5
    //   190: ldc 255
    //   192: astore_3
    //   193: iload 5
    //   195: ifle +7 -> 202
    //   198: ldc_w 257
    //   201: astore_3
    //   202: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +29 -> 234
    //   208: ldc 80
    //   210: iconst_2
    //   211: new 179	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   218: ldc_w 259
    //   221: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_3
    //   225: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: new 88	aifh
    //   237: dup
    //   238: aload_0
    //   239: invokestatic 94	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   242: aload_1
    //   243: bipush 80
    //   245: invokespecial 97	aifh:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Landroid/content/Context;Ljava/lang/String;I)V
    //   248: astore_1
    //   249: aload_1
    //   250: invokevirtual 101	aifh:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   253: astore 23
    //   255: aload 23
    //   257: iconst_0
    //   258: ldc_w 261
    //   261: aconst_null
    //   262: ldc_w 263
    //   265: iconst_1
    //   266: anewarray 58	java/lang/String
    //   269: dup
    //   270: iconst_0
    //   271: aload_2
    //   272: aastore
    //   273: aconst_null
    //   274: aconst_null
    //   275: ldc_w 265
    //   278: aload_3
    //   279: invokevirtual 269	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   282: astore_2
    //   283: aload_2
    //   284: ifnull +726 -> 1010
    //   287: aload_2
    //   288: invokeinterface 114 1 0
    //   293: ifeq +690 -> 983
    //   296: aload_2
    //   297: ldc_w 271
    //   300: invokeinterface 120 2 0
    //   305: istore 7
    //   307: aload_2
    //   308: ldc_w 273
    //   311: invokeinterface 120 2 0
    //   316: istore 8
    //   318: aload_2
    //   319: ldc_w 275
    //   322: invokeinterface 120 2 0
    //   327: istore 9
    //   329: aload_2
    //   330: ldc_w 277
    //   333: invokeinterface 120 2 0
    //   338: istore 10
    //   340: aload_2
    //   341: ldc_w 279
    //   344: invokeinterface 120 2 0
    //   349: istore 11
    //   351: aload_2
    //   352: ldc_w 281
    //   355: invokeinterface 120 2 0
    //   360: istore 12
    //   362: aload_2
    //   363: iload 7
    //   365: invokeinterface 161 2 0
    //   370: lstore 15
    //   372: aload_2
    //   373: iload 8
    //   375: invokeinterface 147 2 0
    //   380: astore 25
    //   382: aload_2
    //   383: iload 9
    //   385: invokeinterface 147 2 0
    //   390: astore_3
    //   391: aload_2
    //   392: iload 10
    //   394: invokeinterface 147 2 0
    //   399: astore 24
    //   401: aload_2
    //   402: iload 11
    //   404: invokeinterface 161 2 0
    //   409: lstore 17
    //   411: aload_2
    //   412: iload 12
    //   414: invokeinterface 161 2 0
    //   419: lstore 19
    //   421: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq +84 -> 508
    //   427: ldc 80
    //   429: iconst_2
    //   430: new 179	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   437: ldc_w 283
    //   440: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: lload 15
    //   445: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   448: ldc 188
    //   450: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload 25
    //   455: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: ldc 188
    //   460: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload_3
    //   464: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: ldc 188
    //   469: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload 24
    //   474: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: ldc 188
    //   479: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: lload 17
    //   484: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   487: ldc 188
    //   489: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: lload 19
    //   494: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   497: ldc 196
    //   499: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: aload 25
    //   510: invokestatic 287	com/tencent/biz/pubaccount/subscript/SubscriptUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   513: astore_3
    //   514: aload_3
    //   515: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   518: ifne +415 -> 933
    //   521: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   524: ifeq +40 -> 564
    //   527: ldc 80
    //   529: iconst_2
    //   530: new 179	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   537: ldc_w 295
    //   540: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 25
    //   545: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: ldc_w 297
    //   551: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: aload_3
    //   555: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: aload 24
    //   566: invokestatic 302	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PAMessage;
    //   569: astore 26
    //   571: aload 26
    //   573: ifnull +342 -> 915
    //   576: sipush -3006
    //   579: invokestatic 307	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   582: checkcast 309	com/tencent/mobileqq/data/MessageForPubAccount
    //   585: astore 25
    //   587: aload 25
    //   589: sipush -3006
    //   592: putfield 312	com/tencent/mobileqq/data/MessageForPubAccount:msgtype	I
    //   595: aload 25
    //   597: sipush 1008
    //   600: putfield 315	com/tencent/mobileqq/data/MessageForPubAccount:istroop	I
    //   603: aload 25
    //   605: aload 24
    //   607: putfield 318	com/tencent/mobileqq/data/MessageForPubAccount:msg	Ljava/lang/String;
    //   610: aload 25
    //   612: aload 26
    //   614: putfield 322	com/tencent/mobileqq/data/MessageForPubAccount:mPAMessage	Lcom/tencent/mobileqq/data/PAMessage;
    //   617: aload 25
    //   619: aload 26
    //   621: invokestatic 325	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lcom/tencent/mobileqq/data/PAMessage;)[B
    //   624: putfield 329	com/tencent/mobileqq/data/MessageForPubAccount:msgData	[B
    //   627: aload 25
    //   629: aload_3
    //   630: putfield 332	com/tencent/mobileqq/data/MessageForPubAccount:frienduin	Ljava/lang/String;
    //   633: aload 25
    //   635: aload_3
    //   636: putfield 335	com/tencent/mobileqq/data/MessageForPubAccount:senderuin	Ljava/lang/String;
    //   639: aload 25
    //   641: aload 4
    //   643: putfield 338	com/tencent/mobileqq/data/MessageForPubAccount:selfuin	Ljava/lang/String;
    //   646: aload 25
    //   648: lload 17
    //   650: putfield 341	com/tencent/mobileqq/data/MessageForPubAccount:time	J
    //   653: aload 25
    //   655: lload 17
    //   657: putfield 344	com/tencent/mobileqq/data/MessageForPubAccount:msgseq	J
    //   660: aload 25
    //   662: aload_0
    //   663: invokespecial 346	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	()I
    //   666: i2l
    //   667: putfield 349	com/tencent/mobileqq/data/MessageForPubAccount:shmsgseq	J
    //   670: aload 25
    //   672: aload_0
    //   673: invokespecial 351	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	()J
    //   676: putfield 354	com/tencent/mobileqq/data/MessageForPubAccount:msgUid	J
    //   679: iload 5
    //   681: ifle +228 -> 909
    //   684: iconst_0
    //   685: istore 21
    //   687: aload 25
    //   689: iload 21
    //   691: putfield 357	com/tencent/mobileqq/data/MessageForPubAccount:isread	Z
    //   694: aload 22
    //   696: aload 25
    //   698: invokeinterface 203 2 0
    //   703: pop
    //   704: iload 5
    //   706: iconst_1
    //   707: isub
    //   708: istore 5
    //   710: goto +398 -> 1108
    //   713: aload_2
    //   714: invokeinterface 206 1 0
    //   719: istore 21
    //   721: iload 6
    //   723: istore 5
    //   725: iload 21
    //   727: ifne -365 -> 362
    //   730: aload_2
    //   731: invokeinterface 209 1 0
    //   736: aload 22
    //   738: ifnull +287 -> 1025
    //   741: aload 22
    //   743: invokeinterface 244 1 0
    //   748: ifle +277 -> 1025
    //   751: iconst_0
    //   752: istore 5
    //   754: iload 5
    //   756: aload 22
    //   758: invokeinterface 244 1 0
    //   763: iconst_1
    //   764: isub
    //   765: if_icmpge +260 -> 1025
    //   768: aload 22
    //   770: invokeinterface 244 1 0
    //   775: iconst_1
    //   776: isub
    //   777: istore 6
    //   779: iload 6
    //   781: iload 5
    //   783: if_icmple +218 -> 1001
    //   786: aload 22
    //   788: iload 6
    //   790: invokeinterface 250 2 0
    //   795: checkcast 359	com/tencent/mobileqq/data/MessageRecord
    //   798: getfield 360	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   801: aload 22
    //   803: iload 5
    //   805: invokeinterface 250 2 0
    //   810: checkcast 359	com/tencent/mobileqq/data/MessageRecord
    //   813: getfield 360	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   816: invokevirtual 253	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   819: ifeq +13 -> 832
    //   822: aload 22
    //   824: iload 6
    //   826: invokeinterface 363 2 0
    //   831: pop
    //   832: iload 6
    //   834: iconst_1
    //   835: isub
    //   836: istore 6
    //   838: goto -59 -> 779
    //   841: iload 5
    //   843: iconst_1
    //   844: iadd
    //   845: istore 5
    //   847: goto -707 -> 140
    //   850: astore 24
    //   852: aload 24
    //   854: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   857: goto -240 -> 617
    //   860: astore_3
    //   861: aload_3
    //   862: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   865: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   868: ifeq +13 -> 881
    //   871: ldc 80
    //   873: iconst_2
    //   874: ldc_w 365
    //   877: aload_3
    //   878: invokestatic 220	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   881: aload_2
    //   882: invokeinterface 209 1 0
    //   887: goto -151 -> 736
    //   890: astore 24
    //   892: aload 24
    //   894: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   897: goto -270 -> 627
    //   900: astore_1
    //   901: aload_2
    //   902: invokeinterface 209 1 0
    //   907: aload_1
    //   908: athrow
    //   909: iconst_1
    //   910: istore 21
    //   912: goto -225 -> 687
    //   915: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   918: ifeq +197 -> 1115
    //   921: ldc 80
    //   923: iconst_2
    //   924: ldc_w 367
    //   927: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   930: goto +185 -> 1115
    //   933: iload 5
    //   935: istore 6
    //   937: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   940: ifeq -227 -> 713
    //   943: ldc 80
    //   945: iconst_2
    //   946: new 179	java/lang/StringBuilder
    //   949: dup
    //   950: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   953: ldc_w 369
    //   956: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: aload 25
    //   961: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: ldc_w 371
    //   967: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   976: iload 5
    //   978: istore 6
    //   980: goto -267 -> 713
    //   983: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   986: ifeq -256 -> 730
    //   989: ldc 80
    //   991: iconst_2
    //   992: ldc_w 373
    //   995: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   998: goto -268 -> 730
    //   1001: iload 5
    //   1003: iconst_1
    //   1004: iadd
    //   1005: istore 5
    //   1007: goto -253 -> 754
    //   1010: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1013: ifeq +12 -> 1025
    //   1016: ldc 80
    //   1018: iconst_2
    //   1019: ldc_w 375
    //   1022: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1025: aload_1
    //   1026: ifnull +7 -> 1033
    //   1029: aload_1
    //   1030: invokevirtual 210	aifh:close	()V
    //   1033: aload 23
    //   1035: ifnull +8 -> 1043
    //   1038: aload 23
    //   1040: invokevirtual 376	android/database/sqlite/SQLiteDatabase:close	()V
    //   1043: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1046: ifeq +44 -> 1090
    //   1049: ldc 80
    //   1051: iconst_2
    //   1052: new 179	java/lang/StringBuilder
    //   1055: dup
    //   1056: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   1059: ldc_w 378
    //   1062: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: invokestatic 239	java/lang/System:nanoTime	()J
    //   1068: lload 13
    //   1070: lsub
    //   1071: ldc2_w 379
    //   1074: ldiv
    //   1075: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1078: ldc_w 382
    //   1081: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1087: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1090: aload 22
    //   1092: areturn
    //   1093: astore_1
    //   1094: goto -51 -> 1043
    //   1097: iconst_0
    //   1098: istore 5
    //   1100: goto -910 -> 190
    //   1103: aconst_null
    //   1104: astore_3
    //   1105: goto -925 -> 180
    //   1108: iload 5
    //   1110: istore 6
    //   1112: goto -399 -> 713
    //   1115: goto -7 -> 1108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1118	0	this	MigrateSubscribeDB
    //   0	1118	1	paramString1	String
    //   0	1118	2	paramString2	String
    //   0	1118	3	paramList	List
    //   0	1118	4	paramString3	String
    //   138	971	5	i	int
    //   103	1008	6	j	int
    //   305	59	7	k	int
    //   316	58	8	m	int
    //   327	57	9	n	int
    //   338	55	10	i1	int
    //   349	54	11	i2	int
    //   360	53	12	i3	int
    //   62	1007	13	l1	long
    //   370	74	15	l2	long
    //   409	247	17	l3	long
    //   419	74	19	l4	long
    //   685	226	21	bool	boolean
    //   71	1020	22	localArrayList	ArrayList
    //   253	786	23	localSQLiteDatabase	SQLiteDatabase
    //   399	207	24	str	String
    //   850	3	24	localException1	Exception
    //   890	3	24	localException2	Exception
    //   380	580	25	localObject	Object
    //   569	51	26	localPAMessage	com.tencent.mobileqq.data.PAMessage
    // Exception table:
    //   from	to	target	type
    //   610	617	850	java/lang/Exception
    //   287	362	860	java/lang/Exception
    //   362	508	860	java/lang/Exception
    //   508	564	860	java/lang/Exception
    //   564	571	860	java/lang/Exception
    //   576	610	860	java/lang/Exception
    //   627	679	860	java/lang/Exception
    //   687	704	860	java/lang/Exception
    //   713	721	860	java/lang/Exception
    //   852	857	860	java/lang/Exception
    //   892	897	860	java/lang/Exception
    //   915	930	860	java/lang/Exception
    //   937	976	860	java/lang/Exception
    //   983	998	860	java/lang/Exception
    //   617	627	890	java/lang/Exception
    //   287	362	900	finally
    //   362	508	900	finally
    //   508	564	900	finally
    //   564	571	900	finally
    //   576	610	900	finally
    //   610	617	900	finally
    //   617	627	900	finally
    //   627	679	900	finally
    //   687	704	900	finally
    //   713	721	900	finally
    //   852	857	900	finally
    //   861	881	900	finally
    //   892	897	900	finally
    //   915	930	900	finally
    //   937	976	900	finally
    //   983	998	900	finally
    //   1038	1043	1093	java/lang/Exception
  }
  
  private List a(List paramList, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((aifi)paramList.get(i)).jdField_a_of_type_JavaLangString;
      int j = 0;
      for (;;)
      {
        if (j < paramArrayOfString.length)
        {
          if (paramArrayOfString[j].equals(str)) {
            localArrayList.add(str);
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    return localArrayList;
  }
  
  private void a()
  {
    Object localObject3;
    HashMap localHashMap;
    Object localObject2;
    int j;
    int i;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
      localObject1 = BaseApplicationImpl.getApplication().getAllAccounts();
      if (localObject1 != null)
      {
        try
        {
          localObject3 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime().getAccount();
          localHashMap = new HashMap(this.jdField_a_of_type_JavaUtilList.size());
          localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            File localFile = (File)((Iterator)localObject2).next();
            if (localFile != null)
            {
              localHashMap.put(localFile.getName().replace(".db", ""), localFile);
              continue;
              return;
            }
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles error", localException);
          }
        }
        localObject2 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles currentUin: " + (String)localObject3);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = (File)localHashMap.remove(localObject3);
          if (localObject3 != null) {
            ((List)localObject2).add(localObject3);
          }
        }
        j = localException.size();
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        localObject3 = (SimpleAccount)localException.get(i);
        if ((localObject3 != null) && (((SimpleAccount)localObject3).getUin() != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles uin: " + ((SimpleAccount)localObject3).getUin());
          }
          localObject3 = (File)localHashMap.remove(((SimpleAccount)localObject3).getUin());
          if (localObject3 != null) {
            ((List)localObject2).add(localObject3);
          }
        }
      }
      else
      {
        Iterator localIterator = localHashMap.values().iterator();
        while (localIterator.hasNext()) {
          ((List)localObject2).add((File)localIterator.next());
        }
        this.jdField_a_of_type_JavaUtilList = ((List)localObject2);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles no account login");
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles mUinMainDBFiles is empty");
        return;
      }
      i += 1;
    }
  }
  
  private void a(String paramString)
  {
    long l = System.nanoTime();
    int j = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_" + paramString + "_" + 1, 0).getInt("updated_msg_count", 0);
    if (j == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount readInJoyUnreadCount == 0");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount readinjoy new unread count: " + j);
    }
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences(paramString, 0);
    Object localObject2 = paramString.getString("troopbar_assist_new_unread_list", "");
    if (ReadInJoyHelper.b()) {
      QLog.i("MigrateSubscribeDB", 2, "updateFolderUnReadCount, get troopbar new unread list ( newMsgStr ): " + (String)localObject2);
    }
    Object localObject1 = new ConcurrentHashMap();
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      String str;
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        if (!QLog.isColorLevel()) {
          break label634;
        }
        QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount jsonArray length: " + ((JSONArray)localObject2).length());
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (!QLog.isColorLevel()) {
          break label376;
        }
        QLog.e("MigrateSubscribeDB", 2, "updateFolderUnReadCount:" + paramString.toString(), paramString);
      }
      if (i < ((JSONArray)localObject2).length())
      {
        localObject3 = ((JSONArray)localObject2).getJSONObject(i);
        localObject4 = ((JSONObject)localObject3).keys();
        if (((Iterator)localObject4).hasNext())
        {
          str = (String)((Iterator)localObject4).next();
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount newMsgMap put key: " + str + " | value: " + ((JSONObject)localObject3).getInt(str));
          }
          ((ConcurrentHashMap)localObject1).put(str, Integer.valueOf(((JSONObject)localObject3).getInt(str)));
          continue;
        }
      }
      for (;;)
      {
        label376:
        if (!QLog.isColorLevel()) {
          break label632;
        }
        QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount total cost = " + (System.nanoTime() - l) / 1000000L + " ms ");
        return;
        i += 1;
        break;
        ((ConcurrentHashMap)localObject1).put(AppConstants.aj, Integer.valueOf(j));
        localObject2 = ((ConcurrentHashMap)localObject1).keySet().iterator();
        localObject3 = new JSONArray();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = new JSONObject();
          str = (String)((Iterator)localObject2).next();
          try
          {
            ((JSONObject)localObject4).put(str, ((ConcurrentHashMap)localObject1).get(str));
            ((JSONArray)localObject3).put(localObject4);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        localObject1 = ((JSONArray)localObject3).toString();
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount save newMsgStr into sp:" + (String)localObject1);
        }
        paramString = paramString.edit();
        paramString.putString("troopbar_assist_new_unread_list", (String)localObject1);
        paramString.commit();
        if (ReadInJoyHelper.b()) {
          QLog.i("MigrateSubscribeDB", 2, "updateFolderUnReadCount, put troopbar new list ( newMsgStr ): " + (String)localObject1);
        }
      }
      label632:
      break;
      label634:
      int i = 0;
    }
  }
  
  private void a(String paramString1, String paramString2, String[] paramArrayOfString, List paramList, EntityManager paramEntityManager)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "MigrateAllToMessageRecord  fileName is : " + paramString1 + "uinStr : " + paramString2);
    }
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "Migrate subscribe subscribeMsgIDs size: " + j);
      }
      int i = 0;
      while (i < j)
      {
        List localList = a(paramString1, paramArrayOfString[i], paramList, paramString2);
        a(paramArrayOfString[i], paramList, localList);
        c(localList, paramEntityManager);
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "Migrate subscribe subscribeMsgIDs is null");
    }
  }
  
  private void a(String paramString, List paramList1, List paramList2)
  {
    if ((paramString == null) || (paramList1 == null) || (paramList2 == null) || (paramList2.size() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "updateSubscribeRecentDataList subscribleID is null or subscribeRecentDataList is null or subscribeMsgList is null");
      }
    }
    for (;;)
    {
      return;
      long l = ((MessageRecord)paramList2.get(paramList2.size() - 1)).time;
      int j = paramList1.size();
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "updateSubscribeRecentDataList subscribeRecentDataList size: " + j);
      }
      int i = 0;
      while (i < j)
      {
        if (((aifi)paramList1.get(i)).jdField_a_of_type_JavaLangString.equals(paramString))
        {
          paramString = (aifi)paramList1.get(i);
          paramString.jdField_c_of_type_Long = l;
          paramList1.set(i, paramString);
          return;
        }
        i += 1;
      }
    }
  }
  
  private void a(List paramList, EntityManager paramEntityManager)
  {
    long l = System.nanoTime();
    if (paramList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar fail subscribeRecentDataList is null");
      }
    }
    do
    {
      return;
      int j = paramList.size();
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar subscribeRecentDataList list size: " + j);
      }
      int i = 0;
      if (i < j)
      {
        aifi localaifi = (aifi)paramList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar subscribeRecentData: " + localaifi);
        }
        String str = SubscriptUtil.a(localaifi.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(str))
        {
          TroopBarData localTroopBarData = new TroopBarData();
          localTroopBarData.mUin = str;
          localTroopBarData.mLastMsgTime = localaifi.jdField_c_of_type_Long;
          localTroopBarData.mLastDraftTime = 0L;
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar subscribeid[" + localaifi.jdField_a_of_type_JavaLangString + "] create new TroopBarData: " + localTroopBarData);
          }
          paramEntityManager.b(localTroopBarData);
        }
        for (;;)
        {
          i += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar we can't subscribeid[" + localaifi.jdField_a_of_type_JavaLangString + "]'s uin");
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar total cost = " + (System.nanoTime() - l) / 1000000L + " ms ");
  }
  
  /* Error */
  private boolean a(File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +24 -> 25
    //   4: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 80
    //   12: iconst_2
    //   13: ldc_w 646
    //   16: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: iconst_0
    //   20: istore 4
    //   22: iload 4
    //   24: ireturn
    //   25: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +32 -> 60
    //   31: ldc 80
    //   33: iconst_2
    //   34: new 179	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   41: ldc_w 648
    //   44: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: invokevirtual 651	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: invokestatic 239	java/lang/System:nanoTime	()J
    //   63: lstore 5
    //   65: aload_1
    //   66: invokevirtual 431	java/io/File:getName	()Ljava/lang/String;
    //   69: astore 11
    //   71: aconst_null
    //   72: astore 7
    //   74: aconst_null
    //   75: astore 16
    //   77: aconst_null
    //   78: astore 10
    //   80: aconst_null
    //   81: astore 9
    //   83: aconst_null
    //   84: astore 15
    //   86: aconst_null
    //   87: astore 12
    //   89: aconst_null
    //   90: astore 8
    //   92: aconst_null
    //   93: astore 14
    //   95: aload_0
    //   96: getfield 653	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   99: invokeinterface 387 1 0
    //   104: ifne +15 -> 119
    //   107: aload_0
    //   108: getfield 655	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	Ljava/util/List;
    //   111: invokeinterface 387 1 0
    //   116: ifeq +57 -> 173
    //   119: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +12 -> 134
    //   125: ldc 80
    //   127: iconst_2
    //   128: ldc_w 657
    //   131: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: iconst_0
    //   135: istore 4
    //   137: iconst_0
    //   138: ifeq +11 -> 149
    //   141: new 659	java/lang/NullPointerException
    //   144: dup
    //   145: invokespecial 660	java/lang/NullPointerException:<init>	()V
    //   148: athrow
    //   149: iconst_0
    //   150: ifeq +11 -> 161
    //   153: new 659	java/lang/NullPointerException
    //   156: dup
    //   157: invokespecial 660	java/lang/NullPointerException:<init>	()V
    //   160: athrow
    //   161: iconst_0
    //   162: ifeq -140 -> 22
    //   165: new 659	java/lang/NullPointerException
    //   168: dup
    //   169: invokespecial 660	java/lang/NullPointerException:<init>	()V
    //   172: athrow
    //   173: aload 11
    //   175: ldc_w 433
    //   178: ldc_w 435
    //   181: invokevirtual 439	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   184: invokestatic 666	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   187: invokestatic 669	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   190: astore 17
    //   192: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +30 -> 225
    //   198: ldc 80
    //   200: iconst_2
    //   201: new 179	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 671
    //   211: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 17
    //   216: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload_0
    //   226: getfield 653	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   229: invokeinterface 387 1 0
    //   234: ifne +471 -> 705
    //   237: aload_0
    //   238: getfield 653	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   241: invokeinterface 417 1 0
    //   246: astore 7
    //   248: aload 7
    //   250: invokeinterface 422 1 0
    //   255: ifeq +1222 -> 1477
    //   258: aload 7
    //   260: invokeinterface 426 1 0
    //   265: checkcast 428	java/io/File
    //   268: invokevirtual 431	java/io/File:getName	()Ljava/lang/String;
    //   271: astore 11
    //   273: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +30 -> 306
    //   279: ldc 80
    //   281: iconst_2
    //   282: new 179	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   289: ldc_w 673
    //   292: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 11
    //   297: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload 11
    //   308: aload 17
    //   310: invokevirtual 676	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   313: ifeq +241 -> 554
    //   316: aload 11
    //   318: astore 7
    //   320: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +1157 -> 1480
    //   326: ldc 80
    //   328: iconst_2
    //   329: new 179	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 678
    //   339: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload 11
    //   344: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   353: aload 11
    //   355: astore 7
    //   357: goto +1123 -> 1480
    //   360: aload_0
    //   361: getfield 655	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	Ljava/util/List;
    //   364: invokeinterface 387 1 0
    //   369: ifne +454 -> 823
    //   372: aload_0
    //   373: getfield 655	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	Ljava/util/List;
    //   376: invokeinterface 417 1 0
    //   381: astore 7
    //   383: aload 7
    //   385: invokeinterface 422 1 0
    //   390: ifeq +1081 -> 1471
    //   393: aload 7
    //   395: invokeinterface 426 1 0
    //   400: checkcast 428	java/io/File
    //   403: invokevirtual 431	java/io/File:getName	()Ljava/lang/String;
    //   406: astore 13
    //   408: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +30 -> 441
    //   414: ldc 80
    //   416: iconst_2
    //   417: new 179	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   424: ldc_w 680
    //   427: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload 13
    //   432: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: aload 13
    //   443: aload 17
    //   445: invokevirtual 676	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   448: ifeq +328 -> 776
    //   451: aload 13
    //   453: astore 7
    //   455: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   458: ifeq +1029 -> 1487
    //   461: ldc 80
    //   463: iconst_2
    //   464: new 179	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   471: ldc_w 682
    //   474: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload 13
    //   479: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   488: aload 13
    //   490: astore 7
    //   492: goto +995 -> 1487
    //   495: aload 13
    //   497: ifnonnull +352 -> 849
    //   500: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +12 -> 515
    //   506: ldc 80
    //   508: iconst_2
    //   509: ldc_w 684
    //   512: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: iconst_1
    //   516: istore 4
    //   518: iconst_0
    //   519: ifeq +11 -> 530
    //   522: new 659	java/lang/NullPointerException
    //   525: dup
    //   526: invokespecial 660	java/lang/NullPointerException:<init>	()V
    //   529: athrow
    //   530: iconst_0
    //   531: ifeq +11 -> 542
    //   534: new 659	java/lang/NullPointerException
    //   537: dup
    //   538: invokespecial 660	java/lang/NullPointerException:<init>	()V
    //   541: athrow
    //   542: iconst_0
    //   543: ifeq -521 -> 22
    //   546: new 659	java/lang/NullPointerException
    //   549: dup
    //   550: invokespecial 660	java/lang/NullPointerException:<init>	()V
    //   553: athrow
    //   554: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   557: ifeq -309 -> 248
    //   560: ldc 80
    //   562: iconst_2
    //   563: new 179	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   570: ldc_w 686
    //   573: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload 11
    //   578: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: ldc_w 688
    //   584: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload 17
    //   589: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: goto -350 -> 248
    //   601: astore 10
    //   603: aconst_null
    //   604: astore 7
    //   606: aconst_null
    //   607: astore_1
    //   608: aload 10
    //   610: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   613: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   616: ifeq +12 -> 628
    //   619: ldc 80
    //   621: iconst_2
    //   622: ldc_w 690
    //   625: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: aload 7
    //   630: ifnull +8 -> 638
    //   633: aload 7
    //   635: invokevirtual 694	com/tencent/mobileqq/app/SQLiteDatabase:c	()V
    //   638: aload 8
    //   640: ifnull +8 -> 648
    //   643: aload 8
    //   645: invokevirtual 696	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   648: aload_1
    //   649: ifnull +7 -> 656
    //   652: aload_1
    //   653: invokevirtual 699	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   656: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   659: ifeq +44 -> 703
    //   662: ldc 80
    //   664: iconst_2
    //   665: new 179	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   672: ldc_w 701
    //   675: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: invokestatic 239	java/lang/System:nanoTime	()J
    //   681: lload 5
    //   683: lsub
    //   684: ldc2_w 379
    //   687: ldiv
    //   688: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   691: ldc_w 703
    //   694: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   703: iconst_1
    //   704: ireturn
    //   705: aload 7
    //   707: astore 11
    //   709: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   712: ifeq -352 -> 360
    //   715: ldc 80
    //   717: iconst_2
    //   718: ldc_w 705
    //   721: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   724: aload 7
    //   726: astore 11
    //   728: goto -368 -> 360
    //   731: astore_1
    //   732: aload 10
    //   734: astore 7
    //   736: aload 9
    //   738: astore 8
    //   740: aload 14
    //   742: astore 9
    //   744: aload 9
    //   746: ifnull +8 -> 754
    //   749: aload 9
    //   751: invokevirtual 694	com/tencent/mobileqq/app/SQLiteDatabase:c	()V
    //   754: aload 8
    //   756: ifnull +8 -> 764
    //   759: aload 8
    //   761: invokevirtual 696	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   764: aload 7
    //   766: ifnull +8 -> 774
    //   769: aload 7
    //   771: invokevirtual 699	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   774: aload_1
    //   775: athrow
    //   776: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   779: ifeq -396 -> 383
    //   782: ldc 80
    //   784: iconst_2
    //   785: new 179	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   792: ldc_w 707
    //   795: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload 13
    //   800: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: ldc_w 688
    //   806: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: aload 17
    //   811: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   820: goto -437 -> 383
    //   823: aload 16
    //   825: astore 13
    //   827: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   830: ifeq -335 -> 495
    //   833: ldc 80
    //   835: iconst_2
    //   836: ldc_w 709
    //   839: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   842: aload 16
    //   844: astore 13
    //   846: goto -351 -> 495
    //   849: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   852: ifeq +41 -> 893
    //   855: ldc 80
    //   857: iconst_2
    //   858: new 179	java/lang/StringBuilder
    //   861: dup
    //   862: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   865: ldc_w 711
    //   868: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: aload 11
    //   873: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: ldc_w 713
    //   879: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: aload 13
    //   884: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   893: new 715	com/tencent/mobileqq/data/QQEntityManagerFactory
    //   896: dup
    //   897: aload 17
    //   899: invokespecial 716	com/tencent/mobileqq/data/QQEntityManagerFactory:<init>	(Ljava/lang/String;)V
    //   902: astore 7
    //   904: aload 15
    //   906: astore 10
    //   908: aload 12
    //   910: astore 9
    //   912: aload 7
    //   914: invokevirtual 720	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   917: astore 8
    //   919: aload 8
    //   921: astore 10
    //   923: aload 8
    //   925: astore 9
    //   927: aload 8
    //   929: invokevirtual 723	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   932: astore 15
    //   934: aload 8
    //   936: astore 10
    //   938: aload 8
    //   940: astore 9
    //   942: aload 7
    //   944: aload 17
    //   946: invokevirtual 727	com/tencent/mobileqq/persistence/EntityManagerFactory:build	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   949: invokevirtual 732	com/tencent/mobileqq/app/SQLiteOpenHelper:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   952: astore 12
    //   954: aload_0
    //   955: getfield 21	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_Boolean	Z
    //   958: ifne +71 -> 1029
    //   961: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   964: ifeq +30 -> 994
    //   967: ldc 80
    //   969: iconst_2
    //   970: new 179	java/lang/StringBuilder
    //   973: dup
    //   974: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   977: ldc_w 734
    //   980: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: aload 17
    //   985: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   991: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   994: iconst_0
    //   995: istore 4
    //   997: aload 12
    //   999: ifnull +8 -> 1007
    //   1002: aload 12
    //   1004: invokevirtual 694	com/tencent/mobileqq/app/SQLiteDatabase:c	()V
    //   1007: aload 8
    //   1009: ifnull +8 -> 1017
    //   1012: aload 8
    //   1014: invokevirtual 696	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1017: aload 7
    //   1019: ifnull -997 -> 22
    //   1022: aload 7
    //   1024: invokevirtual 699	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   1027: iconst_0
    //   1028: ireturn
    //   1029: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1032: ifeq +62 -> 1094
    //   1035: ldc 80
    //   1037: iconst_2
    //   1038: new 179	java/lang/StringBuilder
    //   1041: dup
    //   1042: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   1045: ldc_w 736
    //   1048: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: aload 17
    //   1053: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: ldc_w 738
    //   1059: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: aload_1
    //   1063: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1066: ldc_w 740
    //   1069: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: aload 11
    //   1074: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: ldc_w 742
    //   1080: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: aload 13
    //   1085: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1091: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1094: aload 15
    //   1096: invokevirtual 745	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   1099: aload_0
    //   1100: aload 13
    //   1102: invokespecial 747	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)Ljava/util/List;
    //   1105: astore_1
    //   1106: aload_0
    //   1107: aload_1
    //   1108: aload 8
    //   1110: invokespecial 749	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:b	(Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1113: aload_0
    //   1114: aload 17
    //   1116: invokespecial 751	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)V
    //   1119: aload 11
    //   1121: ifnull +70 -> 1191
    //   1124: aload_0
    //   1125: aload 11
    //   1127: aload 17
    //   1129: aload_0
    //   1130: aload 11
    //   1132: invokespecial 754	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1135: aload_1
    //   1136: aload 8
    //   1138: invokespecial 756	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1141: aload_0
    //   1142: aload_1
    //   1143: aload 8
    //   1145: invokespecial 758	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1148: aload 15
    //   1150: invokevirtual 759	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   1153: aload 15
    //   1155: invokevirtual 761	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   1158: aload 12
    //   1160: ifnull +8 -> 1168
    //   1163: aload 12
    //   1165: invokevirtual 694	com/tencent/mobileqq/app/SQLiteDatabase:c	()V
    //   1168: aload 8
    //   1170: ifnull +8 -> 1178
    //   1173: aload 8
    //   1175: invokevirtual 696	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1178: aload 7
    //   1180: ifnull -524 -> 656
    //   1183: aload 7
    //   1185: invokevirtual 699	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   1188: goto -532 -> 656
    //   1191: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1194: ifeq +12 -> 1206
    //   1197: ldc 80
    //   1199: iconst_2
    //   1200: ldc_w 763
    //   1203: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1206: aload_0
    //   1207: getfield 653	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   1210: invokeinterface 387 1 0
    //   1215: ifne -74 -> 1141
    //   1218: aload_0
    //   1219: getfield 653	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   1222: invokeinterface 417 1 0
    //   1227: astore 10
    //   1229: aload 10
    //   1231: invokeinterface 422 1 0
    //   1236: ifeq -95 -> 1141
    //   1239: aload 10
    //   1241: invokeinterface 426 1 0
    //   1246: checkcast 428	java/io/File
    //   1249: invokevirtual 431	java/io/File:getName	()Ljava/lang/String;
    //   1252: astore 9
    //   1254: aload_0
    //   1255: aload 9
    //   1257: invokespecial 754	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1260: astore 11
    //   1262: aload 11
    //   1264: ifnull -35 -> 1229
    //   1267: aload_0
    //   1268: aload_1
    //   1269: aload 11
    //   1271: invokespecial 765	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/util/List;[Ljava/lang/String;)Ljava/util/List;
    //   1274: invokeinterface 244 1 0
    //   1279: istore_3
    //   1280: iload_3
    //   1281: ifeq -52 -> 1229
    //   1284: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1287: ifeq +41 -> 1328
    //   1290: ldc 80
    //   1292: iconst_2
    //   1293: new 179	java/lang/StringBuilder
    //   1296: dup
    //   1297: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   1300: ldc_w 767
    //   1303: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: aload 17
    //   1308: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: ldc_w 769
    //   1314: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: aload 9
    //   1319: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1322: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1325: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1328: iload_3
    //   1329: anewarray 58	java/lang/String
    //   1332: astore 11
    //   1334: iconst_0
    //   1335: istore_2
    //   1336: iload_2
    //   1337: iload_3
    //   1338: if_icmpge +27 -> 1365
    //   1341: aload 11
    //   1343: iload_2
    //   1344: aload_1
    //   1345: iload_2
    //   1346: invokeinterface 250 2 0
    //   1351: checkcast 140	aifi
    //   1354: getfield 171	aifi:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1357: aastore
    //   1358: iload_2
    //   1359: iconst_1
    //   1360: iadd
    //   1361: istore_2
    //   1362: goto -26 -> 1336
    //   1365: aload_0
    //   1366: aload 9
    //   1368: aload 17
    //   1370: aload 11
    //   1372: aload_1
    //   1373: aload 8
    //   1375: invokespecial 756	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1378: goto -149 -> 1229
    //   1381: astore_1
    //   1382: aload_1
    //   1383: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   1386: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1389: ifeq +12 -> 1401
    //   1392: ldc 80
    //   1394: iconst_2
    //   1395: ldc_w 771
    //   1398: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1401: aload 15
    //   1403: invokevirtual 761	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   1406: goto -248 -> 1158
    //   1409: astore_1
    //   1410: aload 15
    //   1412: invokevirtual 761	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   1415: aload_1
    //   1416: athrow
    //   1417: astore_1
    //   1418: aload 12
    //   1420: astore 9
    //   1422: goto -678 -> 744
    //   1425: astore_1
    //   1426: aload 14
    //   1428: astore 9
    //   1430: aload 10
    //   1432: astore 8
    //   1434: goto -690 -> 744
    //   1437: astore 10
    //   1439: aload 7
    //   1441: astore 9
    //   1443: aload_1
    //   1444: astore 7
    //   1446: aload 10
    //   1448: astore_1
    //   1449: goto -705 -> 744
    //   1452: astore 10
    //   1454: aconst_null
    //   1455: astore 8
    //   1457: aload 7
    //   1459: astore_1
    //   1460: aload 8
    //   1462: astore 7
    //   1464: aload 9
    //   1466: astore 8
    //   1468: goto -860 -> 608
    //   1471: aconst_null
    //   1472: astore 7
    //   1474: goto +13 -> 1487
    //   1477: aconst_null
    //   1478: astore 7
    //   1480: aload 7
    //   1482: astore 11
    //   1484: goto -1124 -> 360
    //   1487: aload 7
    //   1489: astore 13
    //   1491: goto -996 -> 495
    //   1494: astore 10
    //   1496: aload 7
    //   1498: astore_1
    //   1499: aload 12
    //   1501: astore 7
    //   1503: goto -895 -> 608
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1506	0	this	MigrateSubscribeDB
    //   0	1506	1	paramFile	File
    //   1335	27	2	i	int
    //   1279	60	3	j	int
    //   20	976	4	bool	boolean
    //   63	619	5	l	long
    //   72	1430	7	localObject1	Object
    //   90	1377	8	localObject2	Object
    //   81	1384	9	localObject3	Object
    //   78	1	10	localObject4	Object
    //   601	132	10	localException1	Exception
    //   906	525	10	localObject5	Object
    //   1437	10	10	localObject6	Object
    //   1452	1	10	localException2	Exception
    //   1494	1	10	localException3	Exception
    //   69	1414	11	localObject7	Object
    //   87	1413	12	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    //   406	1084	13	localObject8	Object
    //   93	1334	14	localObject9	Object
    //   84	1327	15	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   75	768	16	localObject10	Object
    //   190	1179	17	str	String
    // Exception table:
    //   from	to	target	type
    //   95	119	601	java/lang/Exception
    //   119	134	601	java/lang/Exception
    //   173	225	601	java/lang/Exception
    //   225	248	601	java/lang/Exception
    //   248	306	601	java/lang/Exception
    //   306	316	601	java/lang/Exception
    //   320	353	601	java/lang/Exception
    //   360	383	601	java/lang/Exception
    //   383	441	601	java/lang/Exception
    //   441	451	601	java/lang/Exception
    //   455	488	601	java/lang/Exception
    //   500	515	601	java/lang/Exception
    //   554	598	601	java/lang/Exception
    //   709	724	601	java/lang/Exception
    //   776	820	601	java/lang/Exception
    //   827	842	601	java/lang/Exception
    //   849	893	601	java/lang/Exception
    //   893	904	601	java/lang/Exception
    //   95	119	731	finally
    //   119	134	731	finally
    //   173	225	731	finally
    //   225	248	731	finally
    //   248	306	731	finally
    //   306	316	731	finally
    //   320	353	731	finally
    //   360	383	731	finally
    //   383	441	731	finally
    //   441	451	731	finally
    //   455	488	731	finally
    //   500	515	731	finally
    //   554	598	731	finally
    //   709	724	731	finally
    //   776	820	731	finally
    //   827	842	731	finally
    //   849	893	731	finally
    //   893	904	731	finally
    //   1099	1119	1381	java/lang/Exception
    //   1124	1141	1381	java/lang/Exception
    //   1141	1153	1381	java/lang/Exception
    //   1191	1206	1381	java/lang/Exception
    //   1206	1229	1381	java/lang/Exception
    //   1229	1262	1381	java/lang/Exception
    //   1267	1280	1381	java/lang/Exception
    //   1284	1328	1381	java/lang/Exception
    //   1328	1334	1381	java/lang/Exception
    //   1341	1358	1381	java/lang/Exception
    //   1365	1378	1381	java/lang/Exception
    //   1099	1119	1409	finally
    //   1124	1141	1409	finally
    //   1141	1153	1409	finally
    //   1191	1206	1409	finally
    //   1206	1229	1409	finally
    //   1229	1262	1409	finally
    //   1267	1280	1409	finally
    //   1284	1328	1409	finally
    //   1328	1334	1409	finally
    //   1341	1358	1409	finally
    //   1365	1378	1409	finally
    //   1382	1401	1409	finally
    //   954	994	1417	finally
    //   1029	1094	1417	finally
    //   1094	1099	1417	finally
    //   1153	1158	1417	finally
    //   1401	1406	1417	finally
    //   1410	1417	1417	finally
    //   912	919	1425	finally
    //   927	934	1425	finally
    //   942	954	1425	finally
    //   608	628	1437	finally
    //   912	919	1452	java/lang/Exception
    //   927	934	1452	java/lang/Exception
    //   942	954	1452	java/lang/Exception
    //   954	994	1494	java/lang/Exception
    //   1029	1094	1494	java/lang/Exception
    //   1094	1099	1494	java/lang/Exception
    //   1153	1158	1494	java/lang/Exception
    //   1401	1406	1494	java/lang/Exception
    //   1410	1417	1494	java/lang/Exception
  }
  
  /* Error */
  private String[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_1
    //   10: ifnonnull +29 -> 39
    //   13: aload 5
    //   15: astore 4
    //   17: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +16 -> 36
    //   23: ldc 80
    //   25: iconst_2
    //   26: ldc_w 773
    //   29: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload 5
    //   34: astore 4
    //   36: aload 4
    //   38: areturn
    //   39: invokestatic 94	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   42: astore 4
    //   44: new 88	aifh
    //   47: dup
    //   48: aload_0
    //   49: aload 4
    //   51: aload_1
    //   52: bipush 80
    //   54: invokespecial 97	aifh:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Landroid/content/Context;Ljava/lang/String;I)V
    //   57: astore 6
    //   59: aload 6
    //   61: invokevirtual 101	aifh:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   64: astore 5
    //   66: aload 5
    //   68: ldc_w 775
    //   71: aconst_null
    //   72: invokevirtual 109	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore 4
    //   77: aload 4
    //   79: ifnull +364 -> 443
    //   82: aload 4
    //   84: astore 8
    //   86: aload 5
    //   88: astore 9
    //   90: aload 6
    //   92: astore 10
    //   94: aload 4
    //   96: invokeinterface 114 1 0
    //   101: ifeq +194 -> 295
    //   104: aload 4
    //   106: astore 8
    //   108: aload 5
    //   110: astore 9
    //   112: aload 6
    //   114: astore 10
    //   116: aload 4
    //   118: invokeinterface 778 1 0
    //   123: anewarray 58	java/lang/String
    //   126: astore_1
    //   127: iconst_0
    //   128: istore_2
    //   129: aload 4
    //   131: astore 8
    //   133: aload 5
    //   135: astore 9
    //   137: aload 6
    //   139: astore 10
    //   141: aload_1
    //   142: iload_2
    //   143: aload 4
    //   145: iconst_0
    //   146: invokeinterface 147 2 0
    //   151: aastore
    //   152: aload 4
    //   154: astore 8
    //   156: aload 5
    //   158: astore 9
    //   160: aload 6
    //   162: astore 10
    //   164: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +59 -> 226
    //   170: aload 4
    //   172: astore 8
    //   174: aload 5
    //   176: astore 9
    //   178: aload 6
    //   180: astore 10
    //   182: ldc 80
    //   184: iconst_2
    //   185: new 179	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 780
    //   195: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: iload_2
    //   199: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: ldc_w 782
    //   205: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_1
    //   209: iload_2
    //   210: aaload
    //   211: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc_w 784
    //   217: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: iload_2
    //   227: iconst_1
    //   228: iadd
    //   229: istore_2
    //   230: aload 4
    //   232: astore 8
    //   234: aload 5
    //   236: astore 9
    //   238: aload 6
    //   240: astore 10
    //   242: aload 4
    //   244: invokeinterface 206 1 0
    //   249: istore_3
    //   250: iload_3
    //   251: ifne -122 -> 129
    //   254: aload 4
    //   256: ifnull +10 -> 266
    //   259: aload 4
    //   261: invokeinterface 209 1 0
    //   266: aload 5
    //   268: ifnull +8 -> 276
    //   271: aload 5
    //   273: invokevirtual 376	android/database/sqlite/SQLiteDatabase:close	()V
    //   276: aload_1
    //   277: astore 4
    //   279: aload 6
    //   281: ifnull -245 -> 36
    //   284: aload 6
    //   286: invokevirtual 210	aifh:close	()V
    //   289: aload_1
    //   290: areturn
    //   291: astore 4
    //   293: aload_1
    //   294: areturn
    //   295: aload 11
    //   297: astore_1
    //   298: aload 4
    //   300: astore 8
    //   302: aload 5
    //   304: astore 9
    //   306: aload 6
    //   308: astore 10
    //   310: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq -59 -> 254
    //   316: aload 4
    //   318: astore 8
    //   320: aload 5
    //   322: astore 9
    //   324: aload 6
    //   326: astore 10
    //   328: ldc 80
    //   330: iconst_2
    //   331: ldc_w 786
    //   334: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: aload 11
    //   339: astore_1
    //   340: goto -86 -> 254
    //   343: astore_1
    //   344: aload 4
    //   346: astore 8
    //   348: aload 5
    //   350: astore 9
    //   352: aload 6
    //   354: astore 10
    //   356: aload_1
    //   357: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   360: aload 4
    //   362: astore 8
    //   364: aload 5
    //   366: astore 9
    //   368: aload 6
    //   370: astore 10
    //   372: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +25 -> 400
    //   378: aload 4
    //   380: astore 8
    //   382: aload 5
    //   384: astore 9
    //   386: aload 6
    //   388: astore 10
    //   390: ldc 80
    //   392: iconst_2
    //   393: ldc_w 788
    //   396: aload_1
    //   397: invokestatic 220	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   400: aload 4
    //   402: ifnull +10 -> 412
    //   405: aload 4
    //   407: invokeinterface 209 1 0
    //   412: aload 5
    //   414: ifnull +8 -> 422
    //   417: aload 5
    //   419: invokevirtual 376	android/database/sqlite/SQLiteDatabase:close	()V
    //   422: aload 7
    //   424: astore 4
    //   426: aload 6
    //   428: ifnull -392 -> 36
    //   431: aload 6
    //   433: invokevirtual 210	aifh:close	()V
    //   436: aload 7
    //   438: areturn
    //   439: astore_1
    //   440: aload 7
    //   442: areturn
    //   443: aload 11
    //   445: astore_1
    //   446: aload 4
    //   448: astore 8
    //   450: aload 5
    //   452: astore 9
    //   454: aload 6
    //   456: astore 10
    //   458: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   461: ifeq -207 -> 254
    //   464: aload 4
    //   466: astore 8
    //   468: aload 5
    //   470: astore 9
    //   472: aload 6
    //   474: astore 10
    //   476: ldc 80
    //   478: iconst_2
    //   479: ldc_w 790
    //   482: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: aload 11
    //   487: astore_1
    //   488: goto -234 -> 254
    //   491: astore_1
    //   492: aload 10
    //   494: astore 6
    //   496: aload 9
    //   498: astore 5
    //   500: aload 8
    //   502: astore 4
    //   504: aload 4
    //   506: ifnull +10 -> 516
    //   509: aload 4
    //   511: invokeinterface 209 1 0
    //   516: aload 5
    //   518: ifnull +8 -> 526
    //   521: aload 5
    //   523: invokevirtual 376	android/database/sqlite/SQLiteDatabase:close	()V
    //   526: aload 6
    //   528: ifnull +8 -> 536
    //   531: aload 6
    //   533: invokevirtual 210	aifh:close	()V
    //   536: aload_1
    //   537: athrow
    //   538: astore 4
    //   540: goto -274 -> 266
    //   543: astore 4
    //   545: goto -269 -> 276
    //   548: astore_1
    //   549: goto -137 -> 412
    //   552: astore_1
    //   553: goto -131 -> 422
    //   556: astore 4
    //   558: goto -42 -> 516
    //   561: astore 4
    //   563: goto -37 -> 526
    //   566: astore 4
    //   568: goto -32 -> 536
    //   571: astore_1
    //   572: aconst_null
    //   573: astore 4
    //   575: aconst_null
    //   576: astore 5
    //   578: aconst_null
    //   579: astore 6
    //   581: goto -77 -> 504
    //   584: astore_1
    //   585: aconst_null
    //   586: astore 4
    //   588: aconst_null
    //   589: astore 5
    //   591: goto -87 -> 504
    //   594: astore_1
    //   595: aconst_null
    //   596: astore 4
    //   598: goto -94 -> 504
    //   601: astore_1
    //   602: aconst_null
    //   603: astore 4
    //   605: aconst_null
    //   606: astore 5
    //   608: aconst_null
    //   609: astore 6
    //   611: goto -267 -> 344
    //   614: astore_1
    //   615: aconst_null
    //   616: astore 4
    //   618: aconst_null
    //   619: astore 5
    //   621: goto -277 -> 344
    //   624: astore_1
    //   625: aconst_null
    //   626: astore 4
    //   628: goto -284 -> 344
    //   631: astore 8
    //   633: aload_1
    //   634: astore 7
    //   636: aload 8
    //   638: astore_1
    //   639: goto -295 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	642	0	this	MigrateSubscribeDB
    //   0	642	1	paramString	String
    //   128	102	2	i	int
    //   249	2	3	bool	boolean
    //   15	263	4	localObject1	Object
    //   291	115	4	localException1	Exception
    //   424	86	4	localObject2	Object
    //   538	1	4	localException2	Exception
    //   543	1	4	localException3	Exception
    //   556	1	4	localException4	Exception
    //   561	1	4	localException5	Exception
    //   566	1	4	localException6	Exception
    //   573	54	4	localObject3	Object
    //   7	613	5	localObject4	Object
    //   57	553	6	localObject5	Object
    //   4	631	7	localObject6	Object
    //   84	417	8	localObject7	Object
    //   631	6	8	localException7	Exception
    //   88	409	9	localObject8	Object
    //   92	401	10	localObject9	Object
    //   1	485	11	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   284	289	291	java/lang/Exception
    //   94	104	343	java/lang/Exception
    //   116	127	343	java/lang/Exception
    //   310	316	343	java/lang/Exception
    //   328	337	343	java/lang/Exception
    //   458	464	343	java/lang/Exception
    //   476	485	343	java/lang/Exception
    //   431	436	439	java/lang/Exception
    //   94	104	491	finally
    //   116	127	491	finally
    //   141	152	491	finally
    //   164	170	491	finally
    //   182	226	491	finally
    //   242	250	491	finally
    //   310	316	491	finally
    //   328	337	491	finally
    //   356	360	491	finally
    //   372	378	491	finally
    //   390	400	491	finally
    //   458	464	491	finally
    //   476	485	491	finally
    //   259	266	538	java/lang/Exception
    //   271	276	543	java/lang/Exception
    //   405	412	548	java/lang/Exception
    //   417	422	552	java/lang/Exception
    //   509	516	556	java/lang/Exception
    //   521	526	561	java/lang/Exception
    //   531	536	566	java/lang/Exception
    //   44	59	571	finally
    //   59	66	584	finally
    //   66	77	594	finally
    //   44	59	601	java/lang/Exception
    //   59	66	614	java/lang/Exception
    //   66	77	624	java/lang/Exception
    //   141	152	631	java/lang/Exception
    //   164	170	631	java/lang/Exception
    //   182	226	631	java/lang/Exception
    //   242	250	631	java/lang/Exception
  }
  
  private void b()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "begin getMigrateDBFiles.");
    }
    long l = System.nanoTime();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.c = new ArrayList();
    Pattern localPattern1 = Pattern.compile("^\\d+\\.db$");
    Pattern localPattern2 = Pattern.compile("^readinjoy_main_\\d+$");
    Pattern localPattern3 = Pattern.compile("^readinjoy_\\d+\\.db$");
    String str1 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getFilesDir().getPath();
    str1 = str1.substring(0, str1.lastIndexOf("/")) + "/databases";
    Object localObject1 = new File(str1);
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles we will list files in folder: " + str1);
    }
    localObject1 = ((File)localObject1).listFiles();
    if (localObject1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles dbFiles length: " + localObject1.length);
      }
      j = localObject1.length;
      while (i < j)
      {
        localObject2 = localObject1[i];
        str2 = localObject2.getName();
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles find file[" + str2 + "] in folder[" + str1 + "]");
        }
        if (localPattern1.matcher(str2).find())
        {
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles mUinMainDBFiles " + localObject2);
          }
        }
        if (localPattern2.matcher(str2).find())
        {
          this.jdField_b_of_type_JavaUtilList.add(localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles mReadInJoyMainDBFiles " + localObject2);
          }
        }
        if (localPattern3.matcher(str2).find())
        {
          this.c.add(localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles mReadInJoySubDBFiles " + localObject2);
          }
        }
        i += 1;
      }
      Collections.sort(this.jdField_a_of_type_JavaUtilList, new aifg(this));
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "doStep get Migrate db files cost = " + (System.nanoTime() - l) / 1000000L + "ms");
      }
    }
    while (!QLog.isColorLevel())
    {
      int j;
      Object localObject2;
      String str2;
      return;
    }
    QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles dbFiles is null");
  }
  
  private void b(List paramList, EntityManager paramEntityManager)
  {
    long l = System.nanoTime();
    if (paramList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo fail subscribeRecentDataList is null");
      }
    }
    label265:
    label340:
    label359:
    do
    {
      return;
      int i = paramList.size();
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo subscribeRecentDataList list size: " + i);
      }
      i = 0;
      if (i < paramList.size())
      {
        aifi localaifi = (aifi)paramList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo subscribeRecentData: " + localaifi);
        }
        String str = SubscriptUtil.a(localaifi.jdField_a_of_type_JavaLangString);
        ConversationInfo localConversationInfo;
        int j;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo find subscribeID[" + localaifi.jdField_a_of_type_JavaLangString + "]'s uin: " + str);
          }
          localConversationInfo = new ConversationInfo();
          List localList = paramEntityManager.a(ConversationInfo.class, false, "uin=? and type=?", new String[] { str, String.valueOf(1008) }, null, null, null, null);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("migrateToCoversationInfo dataList size: ");
            if (localList != null)
            {
              j = localList.size();
              QLog.d("MigrateSubscribeDB", 2, j);
            }
          }
          else
          {
            if ((localList == null) || (localList.size() <= 0)) {
              break label359;
            }
            localConversationInfo = (ConversationInfo)localList.get(0);
            localConversationInfo.uin = str;
            localConversationInfo.unreadCount += localaifi.jdField_a_of_type_Int;
            localConversationInfo.type = 1008;
            paramEntityManager.b(localConversationInfo);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label265;
          localConversationInfo.uin = str;
          localConversationInfo.unreadCount = localaifi.jdField_a_of_type_Int;
          localConversationInfo.type = 1008;
          break label340;
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo we can't subscribeid[" + localaifi.jdField_a_of_type_JavaLangString + "]'s uin");
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo total cost = " + (System.nanoTime() - l) / 1000000L + " ms ");
  }
  
  public static boolean b()
  {
    boolean bool2 = false;
    boolean bool1;
    if (!jdField_a_of_type_Boolean)
    {
      String str = BaseApplicationImpl.sApplication.getSharedPreferences("contact_bind_info_global", 0).getString("last_phone_version_popped", "");
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate oldVersion: " + str + " : curVersion: " + "7.6.3");
      }
      if (!TextUtils.isEmpty(str)) {
        if (str.startsWith("5.7")) {
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate isNeed: " + bool1);
      }
      return bool1;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate oldVersion isn't start with 5.7");
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate oldVersion is empty");
          bool1 = bool2;
          continue;
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate no need run again");
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  private void c(List paramList, EntityManager paramEntityManager)
  {
    long l = System.nanoTime();
    if (paramList == null) {}
    do
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        paramEntityManager.b((MessageRecord)paramList.get(i));
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MigrateSubscribeDB", 2, "migrateToMsgRecord total cost = " + (System.nanoTime() - l) / 1000000L + " ms ");
  }
  
  protected boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "begin do Step for MigrateSubscribeDB." + BaseApplicationImpl.sProcessId);
    }
    if (!b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "No need do update action");
      }
      return super.a();
    }
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = BaseApplicationImpl.sApplication;
    if (this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "doStep fail app is null");
      }
      return super.a();
    }
    jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 40000;
    long l = System.nanoTime();
    b();
    Iterator localIterator;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      a();
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    for (;;)
    {
      File localFile;
      if (localIterator.hasNext())
      {
        localFile = (File)localIterator.next();
        if (this.jdField_b_of_type_Boolean) {
          break label245;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "doStep foreach mUinMainDBFiles，but timeout！");
        }
      }
      label245:
      while (!a(localFile))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "doStep Migrate subscribe db total cost = " + (System.nanoTime() - l) / 1000000L + " ms  and Migrate " + this.jdField_a_of_type_Long + " times ");
        }
        return super.a();
      }
      this.jdField_a_of_type_Long += 1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.MigrateSubscribeDB
 * JD-Core Version:    0.7.0.1
 */