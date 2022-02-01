package com.tencent.mobileqq.startup.step;

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
  private List<File> jdField_a_of_type_JavaUtilList = null;
  private List<File> jdField_b_of_type_JavaUtilList = null;
  volatile boolean jdField_b_of_type_Boolean = true;
  private List<File> c = null;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
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
    return SecurityUtile.decode(str);
  }
  
  private List<MigrateSubscribeDB.SubscribeRecentData> a(String paramString)
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
    MigrateSubscribeDB.ReadInJoyDBHelper localReadInJoyDBHelper = new MigrateSubscribeDB.ReadInJoyDBHelper(this, BaseApplication.getContext(), paramString, 17);
    paramString = localReadInJoyDBHelper.getReadableDatabase().rawQuery("select * from RecentSubscribeData order by mLastMsgTime DESC", null);
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
        MigrateSubscribeDB.SubscribeRecentData localSubscribeRecentData = new MigrateSubscribeDB.SubscribeRecentData(this, null);
        localSubscribeRecentData.d = a(paramString.getString(i));
        localSubscribeRecentData.e = a(paramString.getString(j));
        localSubscribeRecentData.jdField_c_of_type_JavaLangString = a(paramString.getString(k));
        localSubscribeRecentData.jdField_b_of_type_Long = paramString.getLong(m);
        localSubscribeRecentData.jdField_a_of_type_Long = paramString.getLong(n);
        localSubscribeRecentData.jdField_c_of_type_Long = paramString.getLong(i1);
        localSubscribeRecentData.f = a(paramString.getString(i2));
        localSubscribeRecentData.jdField_a_of_type_JavaLangString = a(paramString.getString(i3));
        localSubscribeRecentData.jdField_b_of_type_JavaLangString = a(paramString.getString(i4));
        localSubscribeRecentData.jdField_a_of_type_Int = paramString.getInt(i5);
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "read Subscribe RecentDataResults:(mDraft,mDraftTime,mLastMsg,mLastMsgID,mLastMsgTime,mLastReorderTime,mSubscribeHeadUrl,mSubscribeID,mSubscribeName,mUnreadCount)=(" + localSubscribeRecentData.d + "," + localSubscribeRecentData.e + "," + localSubscribeRecentData.jdField_c_of_type_JavaLangString + "," + localSubscribeRecentData.jdField_b_of_type_Long + "," + localSubscribeRecentData.jdField_a_of_type_Long + "," + localSubscribeRecentData.jdField_c_of_type_Long + localSubscribeRecentData.f + "," + localSubscribeRecentData.jdField_a_of_type_JavaLangString + "," + localSubscribeRecentData.jdField_b_of_type_JavaLangString + "," + localSubscribeRecentData.jdField_a_of_type_Int + ")");
        }
        localArrayList.add(localSubscribeRecentData);
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
      if (localReadInJoyDBHelper == null) {
        break;
      }
      localReadInJoyDBHelper.close();
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
  private List<MessageRecord> a(String paramString1, String paramString2, List<MigrateSubscribeDB.SubscribeRecentData> paramList, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +56 -> 59
    //   6: ldc 91
    //   8: iconst_2
    //   9: new 190	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   16: ldc 238
    //   18: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 240
    //   27: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_2
    //   31: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 242
    //   36: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_3
    //   40: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: ldc 247
    //   45: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload 4
    //   50: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: invokestatic 252	java/lang/System:nanoTime	()J
    //   62: lstore 13
    //   64: new 82	java/util/ArrayList
    //   67: dup
    //   68: invokespecial 83	java/util/ArrayList:<init>	()V
    //   71: astore 22
    //   73: aload_2
    //   74: ifnull +7 -> 81
    //   77: aload_3
    //   78: ifnonnull +19 -> 97
    //   81: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +11 -> 95
    //   87: ldc 91
    //   89: iconst_2
    //   90: ldc 254
    //   92: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aconst_null
    //   96: areturn
    //   97: aload_3
    //   98: invokeinterface 257 1 0
    //   103: istore 6
    //   105: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +30 -> 138
    //   111: ldc 91
    //   113: iconst_2
    //   114: new 190	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   121: ldc_w 259
    //   124: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: iload 6
    //   129: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: iconst_0
    //   139: istore 5
    //   141: iload 5
    //   143: iload 6
    //   145: if_icmpge +982 -> 1127
    //   148: aload_3
    //   149: iload 5
    //   151: invokeinterface 263 2 0
    //   156: checkcast 151	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData
    //   159: getfield 182	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   162: aload_2
    //   163: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   166: ifeq +699 -> 865
    //   169: aload_3
    //   170: iload 5
    //   172: invokeinterface 263 2 0
    //   177: checkcast 151	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData
    //   180: astore_3
    //   181: aload_3
    //   182: ifnull +939 -> 1121
    //   185: aload_3
    //   186: getfield 188	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_a_of_type_Int	I
    //   189: istore 5
    //   191: ldc_w 268
    //   194: astore_3
    //   195: iload 5
    //   197: ifle +7 -> 204
    //   200: ldc_w 270
    //   203: astore_3
    //   204: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +29 -> 236
    //   210: ldc 91
    //   212: iconst_2
    //   213: new 190	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 272
    //   223: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_3
    //   227: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: new 99	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper
    //   239: dup
    //   240: aload_0
    //   241: invokestatic 105	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   244: aload_1
    //   245: bipush 80
    //   247: invokespecial 108	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Landroid/content/Context;Ljava/lang/String;I)V
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual 112	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   255: astore 23
    //   257: aload 23
    //   259: iconst_0
    //   260: ldc_w 274
    //   263: aconst_null
    //   264: ldc_w 276
    //   267: iconst_1
    //   268: anewarray 68	java/lang/String
    //   271: dup
    //   272: iconst_0
    //   273: aload_2
    //   274: aastore
    //   275: aconst_null
    //   276: aconst_null
    //   277: ldc_w 278
    //   280: aload_3
    //   281: invokevirtual 282	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   284: astore_2
    //   285: aload_2
    //   286: ifnull +748 -> 1034
    //   289: aload_2
    //   290: invokeinterface 125 1 0
    //   295: ifeq +712 -> 1007
    //   298: aload_2
    //   299: ldc_w 284
    //   302: invokeinterface 131 2 0
    //   307: istore 7
    //   309: aload_2
    //   310: ldc_w 286
    //   313: invokeinterface 131 2 0
    //   318: istore 8
    //   320: aload_2
    //   321: ldc_w 288
    //   324: invokeinterface 131 2 0
    //   329: istore 9
    //   331: aload_2
    //   332: ldc_w 290
    //   335: invokeinterface 131 2 0
    //   340: istore 10
    //   342: aload_2
    //   343: ldc_w 292
    //   346: invokeinterface 131 2 0
    //   351: istore 11
    //   353: aload_2
    //   354: ldc_w 294
    //   357: invokeinterface 131 2 0
    //   362: istore 12
    //   364: aload_2
    //   365: iload 7
    //   367: invokeinterface 172 2 0
    //   372: lstore 15
    //   374: aload_2
    //   375: iload 8
    //   377: invokeinterface 158 2 0
    //   382: astore 25
    //   384: aload_2
    //   385: iload 9
    //   387: invokeinterface 158 2 0
    //   392: astore_3
    //   393: aload_2
    //   394: iload 10
    //   396: invokeinterface 158 2 0
    //   401: astore 24
    //   403: aload_2
    //   404: iload 11
    //   406: invokeinterface 172 2 0
    //   411: lstore 17
    //   413: aload_2
    //   414: iload 12
    //   416: invokeinterface 172 2 0
    //   421: lstore 19
    //   423: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   426: ifeq +84 -> 510
    //   429: ldc 91
    //   431: iconst_2
    //   432: new 190	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   439: ldc_w 296
    //   442: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: lload 15
    //   447: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   450: ldc 199
    //   452: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload 25
    //   457: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: ldc 199
    //   462: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_3
    //   466: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: ldc 199
    //   471: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: aload 24
    //   476: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: ldc 199
    //   481: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: lload 17
    //   486: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   489: ldc 199
    //   491: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: lload 19
    //   496: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   499: ldc 207
    //   501: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   510: aload 25
    //   512: invokestatic 300	com/tencent/biz/pubaccount/subscript/SubscriptUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   515: astore_3
    //   516: aload_3
    //   517: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   520: ifne +437 -> 957
    //   523: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq +40 -> 566
    //   529: ldc 91
    //   531: iconst_2
    //   532: new 190	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   539: ldc_w 308
    //   542: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: aload 25
    //   547: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: ldc_w 310
    //   553: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload_3
    //   557: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: ldc_w 312
    //   569: invokestatic 318	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   572: checkcast 312	com/tencent/biz/pubaccount/util/api/IPublicAccountMessageUtil
    //   575: aload 24
    //   577: invokeinterface 322 2 0
    //   582: astore 26
    //   584: aload 26
    //   586: ifnull +353 -> 939
    //   589: sipush -3006
    //   592: invokestatic 327	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   595: checkcast 329	com/tencent/mobileqq/data/MessageForPubAccount
    //   598: astore 25
    //   600: aload 25
    //   602: sipush -3006
    //   605: putfield 332	com/tencent/mobileqq/data/MessageForPubAccount:msgtype	I
    //   608: aload 25
    //   610: sipush 1008
    //   613: putfield 335	com/tencent/mobileqq/data/MessageForPubAccount:istroop	I
    //   616: aload 25
    //   618: aload 24
    //   620: putfield 338	com/tencent/mobileqq/data/MessageForPubAccount:msg	Ljava/lang/String;
    //   623: aload 25
    //   625: aload 26
    //   627: putfield 342	com/tencent/mobileqq/data/MessageForPubAccount:mPAMessage	Lcom/tencent/mobileqq/data/PAMessage;
    //   630: aload 25
    //   632: ldc_w 312
    //   635: invokestatic 318	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   638: checkcast 312	com/tencent/biz/pubaccount/util/api/IPublicAccountMessageUtil
    //   641: aload 26
    //   643: invokeinterface 346 2 0
    //   648: putfield 350	com/tencent/mobileqq/data/MessageForPubAccount:msgData	[B
    //   651: aload 25
    //   653: aload_3
    //   654: putfield 353	com/tencent/mobileqq/data/MessageForPubAccount:frienduin	Ljava/lang/String;
    //   657: aload 25
    //   659: aload_3
    //   660: putfield 356	com/tencent/mobileqq/data/MessageForPubAccount:senderuin	Ljava/lang/String;
    //   663: aload 25
    //   665: aload 4
    //   667: putfield 359	com/tencent/mobileqq/data/MessageForPubAccount:selfuin	Ljava/lang/String;
    //   670: aload 25
    //   672: lload 17
    //   674: putfield 362	com/tencent/mobileqq/data/MessageForPubAccount:time	J
    //   677: aload 25
    //   679: lload 17
    //   681: putfield 365	com/tencent/mobileqq/data/MessageForPubAccount:msgseq	J
    //   684: aload 25
    //   686: aload_0
    //   687: invokespecial 367	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	()I
    //   690: i2l
    //   691: putfield 370	com/tencent/mobileqq/data/MessageForPubAccount:shmsgseq	J
    //   694: aload 25
    //   696: aload_0
    //   697: invokespecial 372	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	()J
    //   700: putfield 375	com/tencent/mobileqq/data/MessageForPubAccount:msgUid	J
    //   703: iload 5
    //   705: ifle +228 -> 933
    //   708: iconst_0
    //   709: istore 21
    //   711: aload 25
    //   713: iload 21
    //   715: putfield 378	com/tencent/mobileqq/data/MessageForPubAccount:isread	Z
    //   718: aload 22
    //   720: aload 25
    //   722: invokeinterface 214 2 0
    //   727: pop
    //   728: iload 5
    //   730: iconst_1
    //   731: isub
    //   732: istore 5
    //   734: goto +398 -> 1132
    //   737: aload_2
    //   738: invokeinterface 217 1 0
    //   743: istore 21
    //   745: iload 6
    //   747: istore 5
    //   749: iload 21
    //   751: ifne -387 -> 364
    //   754: aload_2
    //   755: invokeinterface 220 1 0
    //   760: aload 22
    //   762: ifnull +287 -> 1049
    //   765: aload 22
    //   767: invokeinterface 257 1 0
    //   772: ifle +277 -> 1049
    //   775: iconst_0
    //   776: istore 5
    //   778: iload 5
    //   780: aload 22
    //   782: invokeinterface 257 1 0
    //   787: iconst_1
    //   788: isub
    //   789: if_icmpge +260 -> 1049
    //   792: aload 22
    //   794: invokeinterface 257 1 0
    //   799: iconst_1
    //   800: isub
    //   801: istore 6
    //   803: iload 6
    //   805: iload 5
    //   807: if_icmple +218 -> 1025
    //   810: aload 22
    //   812: iload 6
    //   814: invokeinterface 263 2 0
    //   819: checkcast 380	com/tencent/mobileqq/data/MessageRecord
    //   822: getfield 381	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   825: aload 22
    //   827: iload 5
    //   829: invokeinterface 263 2 0
    //   834: checkcast 380	com/tencent/mobileqq/data/MessageRecord
    //   837: getfield 381	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   840: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   843: ifeq +13 -> 856
    //   846: aload 22
    //   848: iload 6
    //   850: invokeinterface 384 2 0
    //   855: pop
    //   856: iload 6
    //   858: iconst_1
    //   859: isub
    //   860: istore 6
    //   862: goto -59 -> 803
    //   865: iload 5
    //   867: iconst_1
    //   868: iadd
    //   869: istore 5
    //   871: goto -730 -> 141
    //   874: astore 24
    //   876: aload 24
    //   878: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   881: goto -251 -> 630
    //   884: astore_3
    //   885: aload_3
    //   886: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   889: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   892: ifeq +13 -> 905
    //   895: ldc 91
    //   897: iconst_2
    //   898: ldc_w 386
    //   901: aload_3
    //   902: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   905: aload_2
    //   906: invokeinterface 220 1 0
    //   911: goto -151 -> 760
    //   914: astore 24
    //   916: aload 24
    //   918: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   921: goto -270 -> 651
    //   924: astore_1
    //   925: aload_2
    //   926: invokeinterface 220 1 0
    //   931: aload_1
    //   932: athrow
    //   933: iconst_1
    //   934: istore 21
    //   936: goto -225 -> 711
    //   939: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   942: ifeq +197 -> 1139
    //   945: ldc 91
    //   947: iconst_2
    //   948: ldc_w 388
    //   951: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   954: goto +185 -> 1139
    //   957: iload 5
    //   959: istore 6
    //   961: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   964: ifeq -227 -> 737
    //   967: ldc 91
    //   969: iconst_2
    //   970: new 190	java/lang/StringBuilder
    //   973: dup
    //   974: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   977: ldc_w 390
    //   980: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: aload 25
    //   985: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: ldc_w 392
    //   991: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   997: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1000: iload 5
    //   1002: istore 6
    //   1004: goto -267 -> 737
    //   1007: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1010: ifeq -256 -> 754
    //   1013: ldc 91
    //   1015: iconst_2
    //   1016: ldc_w 394
    //   1019: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1022: goto -268 -> 754
    //   1025: iload 5
    //   1027: iconst_1
    //   1028: iadd
    //   1029: istore 5
    //   1031: goto -253 -> 778
    //   1034: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1037: ifeq +12 -> 1049
    //   1040: ldc 91
    //   1042: iconst_2
    //   1043: ldc_w 396
    //   1046: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1049: aload_1
    //   1050: ifnull +7 -> 1057
    //   1053: aload_1
    //   1054: invokevirtual 221	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:close	()V
    //   1057: aload 23
    //   1059: ifnull +8 -> 1067
    //   1062: aload 23
    //   1064: invokevirtual 397	android/database/sqlite/SQLiteDatabase:close	()V
    //   1067: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1070: ifeq +44 -> 1114
    //   1073: ldc 91
    //   1075: iconst_2
    //   1076: new 190	java/lang/StringBuilder
    //   1079: dup
    //   1080: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1083: ldc_w 399
    //   1086: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: invokestatic 252	java/lang/System:nanoTime	()J
    //   1092: lload 13
    //   1094: lsub
    //   1095: ldc2_w 400
    //   1098: ldiv
    //   1099: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1102: ldc_w 403
    //   1105: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1111: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1114: aload 22
    //   1116: areturn
    //   1117: astore_1
    //   1118: goto -51 -> 1067
    //   1121: iconst_0
    //   1122: istore 5
    //   1124: goto -933 -> 191
    //   1127: aconst_null
    //   1128: astore_3
    //   1129: goto -948 -> 181
    //   1132: iload 5
    //   1134: istore 6
    //   1136: goto -399 -> 737
    //   1139: goto -7 -> 1132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1142	0	this	MigrateSubscribeDB
    //   0	1142	1	paramString1	String
    //   0	1142	2	paramString2	String
    //   0	1142	3	paramList	List<MigrateSubscribeDB.SubscribeRecentData>
    //   0	1142	4	paramString3	String
    //   139	994	5	i	int
    //   103	1032	6	j	int
    //   307	59	7	k	int
    //   318	58	8	m	int
    //   329	57	9	n	int
    //   340	55	10	i1	int
    //   351	54	11	i2	int
    //   362	53	12	i3	int
    //   62	1031	13	l1	long
    //   372	74	15	l2	long
    //   411	269	17	l3	long
    //   421	74	19	l4	long
    //   709	226	21	bool	boolean
    //   71	1044	22	localArrayList	ArrayList
    //   255	808	23	localSQLiteDatabase	SQLiteDatabase
    //   401	218	24	str	String
    //   874	3	24	localException1	Exception
    //   914	3	24	localException2	Exception
    //   382	602	25	localObject	Object
    //   582	60	26	localPAMessage	com.tencent.mobileqq.data.PAMessage
    // Exception table:
    //   from	to	target	type
    //   623	630	874	java/lang/Exception
    //   289	364	884	java/lang/Exception
    //   364	510	884	java/lang/Exception
    //   510	566	884	java/lang/Exception
    //   566	584	884	java/lang/Exception
    //   589	623	884	java/lang/Exception
    //   651	703	884	java/lang/Exception
    //   711	728	884	java/lang/Exception
    //   737	745	884	java/lang/Exception
    //   876	881	884	java/lang/Exception
    //   916	921	884	java/lang/Exception
    //   939	954	884	java/lang/Exception
    //   961	1000	884	java/lang/Exception
    //   1007	1022	884	java/lang/Exception
    //   630	651	914	java/lang/Exception
    //   289	364	924	finally
    //   364	510	924	finally
    //   510	566	924	finally
    //   566	584	924	finally
    //   589	623	924	finally
    //   623	630	924	finally
    //   630	651	924	finally
    //   651	703	924	finally
    //   711	728	924	finally
    //   737	745	924	finally
    //   876	881	924	finally
    //   885	905	924	finally
    //   916	921	924	finally
    //   939	954	924	finally
    //   961	1000	924	finally
    //   1007	1022	924	finally
    //   1062	1067	1117	java/lang/Exception
  }
  
  private List<String> a(List<MigrateSubscribeDB.SubscribeRecentData> paramList, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((MigrateSubscribeDB.SubscribeRecentData)paramList.get(i)).jdField_a_of_type_JavaLangString;
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
        ((ConcurrentHashMap)localObject1).put(AppConstants.READINJOY_UIN, Integer.valueOf(j));
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
  
  private void a(String paramString1, String paramString2, String[] paramArrayOfString, List<MigrateSubscribeDB.SubscribeRecentData> paramList, EntityManager paramEntityManager)
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
  
  private void a(String paramString, List<MigrateSubscribeDB.SubscribeRecentData> paramList, List<MessageRecord> paramList1)
  {
    if ((paramString == null) || (paramList == null) || (paramList1 == null) || (paramList1.size() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "updateSubscribeRecentDataList subscribleID is null or subscribeRecentDataList is null or subscribeMsgList is null");
      }
    }
    for (;;)
    {
      return;
      long l = ((MessageRecord)paramList1.get(paramList1.size() - 1)).time;
      int j = paramList.size();
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "updateSubscribeRecentDataList subscribeRecentDataList size: " + j);
      }
      int i = 0;
      while (i < j)
      {
        if (((MigrateSubscribeDB.SubscribeRecentData)paramList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString))
        {
          paramString = (MigrateSubscribeDB.SubscribeRecentData)paramList.get(i);
          paramString.jdField_c_of_type_Long = l;
          paramList.set(i, paramString);
          return;
        }
        i += 1;
      }
    }
  }
  
  private void a(List<MigrateSubscribeDB.SubscribeRecentData> paramList, EntityManager paramEntityManager)
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
        MigrateSubscribeDB.SubscribeRecentData localSubscribeRecentData = (MigrateSubscribeDB.SubscribeRecentData)paramList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar subscribeRecentData: " + localSubscribeRecentData);
        }
        String str = SubscriptUtil.a(localSubscribeRecentData.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(str))
        {
          TroopBarData localTroopBarData = new TroopBarData();
          localTroopBarData.mUin = str;
          localTroopBarData.mLastMsgTime = localSubscribeRecentData.jdField_c_of_type_Long;
          localTroopBarData.mLastDraftTime = 0L;
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar subscribeid[" + localSubscribeRecentData.jdField_a_of_type_JavaLangString + "] create new TroopBarData: " + localTroopBarData);
          }
          paramEntityManager.persistOrReplace(localTroopBarData);
        }
        for (;;)
        {
          i += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar we can't subscribeid[" + localSubscribeRecentData.jdField_a_of_type_JavaLangString + "]'s uin");
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar total cost = " + (System.nanoTime() - l) / 1000000L + " ms ");
  }
  
  public static boolean a()
  {
    boolean bool2 = false;
    boolean bool1;
    if (!jdField_a_of_type_Boolean)
    {
      String str = BaseApplicationImpl.sApplication.getSharedPreferences("contact_bind_info_global", 0).getString("last_phone_version_popped", "");
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate oldVersion: " + str + " : curVersion: " + "8.5.5");
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
  
  /* Error */
  private boolean a(File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +24 -> 25
    //   4: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 91
    //   12: iconst_2
    //   13: ldc_w 701
    //   16: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: iconst_0
    //   20: istore 4
    //   22: iload 4
    //   24: ireturn
    //   25: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +32 -> 60
    //   31: ldc 91
    //   33: iconst_2
    //   34: new 190	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   41: ldc_w 703
    //   44: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: invokevirtual 706	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: invokestatic 252	java/lang/System:nanoTime	()J
    //   63: lstore 5
    //   65: aload_1
    //   66: invokevirtual 452	java/io/File:getName	()Ljava/lang/String;
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
    //   96: getfield 26	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   99: invokeinterface 408 1 0
    //   104: ifne +15 -> 119
    //   107: aload_0
    //   108: getfield 28	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	Ljava/util/List;
    //   111: invokeinterface 408 1 0
    //   116: ifeq +57 -> 173
    //   119: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +12 -> 134
    //   125: ldc 91
    //   127: iconst_2
    //   128: ldc_w 708
    //   131: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: iconst_0
    //   135: istore 4
    //   137: iconst_0
    //   138: ifeq +11 -> 149
    //   141: new 710	java/lang/NullPointerException
    //   144: dup
    //   145: invokespecial 711	java/lang/NullPointerException:<init>	()V
    //   148: athrow
    //   149: iconst_0
    //   150: ifeq +11 -> 161
    //   153: new 710	java/lang/NullPointerException
    //   156: dup
    //   157: invokespecial 711	java/lang/NullPointerException:<init>	()V
    //   160: athrow
    //   161: iconst_0
    //   162: ifeq -140 -> 22
    //   165: new 710	java/lang/NullPointerException
    //   168: dup
    //   169: invokespecial 711	java/lang/NullPointerException:<init>	()V
    //   172: athrow
    //   173: aload 11
    //   175: ldc_w 454
    //   178: ldc_w 456
    //   181: invokevirtual 460	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   184: invokestatic 717	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   187: invokestatic 720	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   190: astore 17
    //   192: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +30 -> 225
    //   198: ldc 91
    //   200: iconst_2
    //   201: new 190	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 722
    //   211: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 17
    //   216: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload_0
    //   226: getfield 26	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   229: invokeinterface 408 1 0
    //   234: ifne +471 -> 705
    //   237: aload_0
    //   238: getfield 26	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   241: invokeinterface 438 1 0
    //   246: astore 7
    //   248: aload 7
    //   250: invokeinterface 443 1 0
    //   255: ifeq +1218 -> 1473
    //   258: aload 7
    //   260: invokeinterface 447 1 0
    //   265: checkcast 449	java/io/File
    //   268: invokevirtual 452	java/io/File:getName	()Ljava/lang/String;
    //   271: astore 11
    //   273: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +30 -> 306
    //   279: ldc 91
    //   281: iconst_2
    //   282: new 190	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   289: ldc_w 724
    //   292: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 11
    //   297: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload 11
    //   308: aload 17
    //   310: invokevirtual 727	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   313: ifeq +241 -> 554
    //   316: aload 11
    //   318: astore 7
    //   320: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +1153 -> 1476
    //   326: ldc 91
    //   328: iconst_2
    //   329: new 190	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 729
    //   339: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload 11
    //   344: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   353: aload 11
    //   355: astore 7
    //   357: goto +1119 -> 1476
    //   360: aload_0
    //   361: getfield 28	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	Ljava/util/List;
    //   364: invokeinterface 408 1 0
    //   369: ifne +454 -> 823
    //   372: aload_0
    //   373: getfield 28	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	Ljava/util/List;
    //   376: invokeinterface 438 1 0
    //   381: astore 7
    //   383: aload 7
    //   385: invokeinterface 443 1 0
    //   390: ifeq +1077 -> 1467
    //   393: aload 7
    //   395: invokeinterface 447 1 0
    //   400: checkcast 449	java/io/File
    //   403: invokevirtual 452	java/io/File:getName	()Ljava/lang/String;
    //   406: astore 13
    //   408: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +30 -> 441
    //   414: ldc 91
    //   416: iconst_2
    //   417: new 190	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   424: ldc_w 731
    //   427: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload 13
    //   432: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: aload 13
    //   443: aload 17
    //   445: invokevirtual 727	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   448: ifeq +328 -> 776
    //   451: aload 13
    //   453: astore 7
    //   455: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   458: ifeq +1025 -> 1483
    //   461: ldc 91
    //   463: iconst_2
    //   464: new 190	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   471: ldc_w 733
    //   474: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload 13
    //   479: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   488: aload 13
    //   490: astore 7
    //   492: goto +991 -> 1483
    //   495: aload 13
    //   497: ifnonnull +352 -> 849
    //   500: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +12 -> 515
    //   506: ldc 91
    //   508: iconst_2
    //   509: ldc_w 735
    //   512: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: iconst_1
    //   516: istore 4
    //   518: iconst_0
    //   519: ifeq +11 -> 530
    //   522: new 710	java/lang/NullPointerException
    //   525: dup
    //   526: invokespecial 711	java/lang/NullPointerException:<init>	()V
    //   529: athrow
    //   530: iconst_0
    //   531: ifeq +11 -> 542
    //   534: new 710	java/lang/NullPointerException
    //   537: dup
    //   538: invokespecial 711	java/lang/NullPointerException:<init>	()V
    //   541: athrow
    //   542: iconst_0
    //   543: ifeq -521 -> 22
    //   546: new 710	java/lang/NullPointerException
    //   549: dup
    //   550: invokespecial 711	java/lang/NullPointerException:<init>	()V
    //   553: athrow
    //   554: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   557: ifeq -309 -> 248
    //   560: ldc 91
    //   562: iconst_2
    //   563: new 190	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   570: ldc_w 737
    //   573: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload 11
    //   578: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: ldc_w 739
    //   584: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload 17
    //   589: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: goto -350 -> 248
    //   601: astore 10
    //   603: aconst_null
    //   604: astore 7
    //   606: aconst_null
    //   607: astore_1
    //   608: aload 10
    //   610: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   613: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   616: ifeq +12 -> 628
    //   619: ldc 91
    //   621: iconst_2
    //   622: ldc_w 741
    //   625: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: aload 7
    //   630: ifnull +8 -> 638
    //   633: aload 7
    //   635: invokevirtual 744	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   638: aload 8
    //   640: ifnull +8 -> 648
    //   643: aload 8
    //   645: invokevirtual 745	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   648: aload_1
    //   649: ifnull +7 -> 656
    //   652: aload_1
    //   653: invokevirtual 748	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   656: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   659: ifeq +44 -> 703
    //   662: ldc 91
    //   664: iconst_2
    //   665: new 190	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   672: ldc_w 750
    //   675: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: invokestatic 252	java/lang/System:nanoTime	()J
    //   681: lload 5
    //   683: lsub
    //   684: ldc2_w 400
    //   687: ldiv
    //   688: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   691: ldc_w 752
    //   694: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   703: iconst_1
    //   704: ireturn
    //   705: aload 7
    //   707: astore 11
    //   709: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   712: ifeq -352 -> 360
    //   715: ldc 91
    //   717: iconst_2
    //   718: ldc_w 754
    //   721: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   751: invokevirtual 744	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   754: aload 8
    //   756: ifnull +8 -> 764
    //   759: aload 8
    //   761: invokevirtual 745	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   764: aload 7
    //   766: ifnull +8 -> 774
    //   769: aload 7
    //   771: invokevirtual 748	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   774: aload_1
    //   775: athrow
    //   776: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   779: ifeq -396 -> 383
    //   782: ldc 91
    //   784: iconst_2
    //   785: new 190	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   792: ldc_w 756
    //   795: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload 13
    //   800: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: ldc_w 739
    //   806: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: aload 17
    //   811: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   820: goto -437 -> 383
    //   823: aload 16
    //   825: astore 13
    //   827: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   830: ifeq -335 -> 495
    //   833: ldc 91
    //   835: iconst_2
    //   836: ldc_w 758
    //   839: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   842: aload 16
    //   844: astore 13
    //   846: goto -351 -> 495
    //   849: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   852: ifeq +41 -> 893
    //   855: ldc 91
    //   857: iconst_2
    //   858: new 190	java/lang/StringBuilder
    //   861: dup
    //   862: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   865: ldc_w 760
    //   868: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: aload 11
    //   873: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: ldc_w 762
    //   879: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: aload 13
    //   884: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   893: aload 17
    //   895: invokestatic 767	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   898: astore 7
    //   900: aload 15
    //   902: astore 10
    //   904: aload 12
    //   906: astore 9
    //   908: aload 7
    //   910: invokevirtual 771	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   913: astore 8
    //   915: aload 8
    //   917: astore 10
    //   919: aload 8
    //   921: astore 9
    //   923: aload 8
    //   925: invokevirtual 775	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   928: astore 15
    //   930: aload 8
    //   932: astore 10
    //   934: aload 8
    //   936: astore 9
    //   938: aload 7
    //   940: aload 17
    //   942: invokevirtual 779	com/tencent/mobileqq/persistence/EntityManagerFactory:build	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   945: invokevirtual 785	com/tencent/mobileqq/app/SQLiteOpenHelper:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   948: astore 12
    //   950: aload_0
    //   951: getfield 32	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_Boolean	Z
    //   954: ifne +71 -> 1025
    //   957: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   960: ifeq +30 -> 990
    //   963: ldc 91
    //   965: iconst_2
    //   966: new 190	java/lang/StringBuilder
    //   969: dup
    //   970: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   973: ldc_w 787
    //   976: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: aload 17
    //   981: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   990: iconst_0
    //   991: istore 4
    //   993: aload 12
    //   995: ifnull +8 -> 1003
    //   998: aload 12
    //   1000: invokevirtual 744	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   1003: aload 8
    //   1005: ifnull +8 -> 1013
    //   1008: aload 8
    //   1010: invokevirtual 745	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1013: aload 7
    //   1015: ifnull -993 -> 22
    //   1018: aload 7
    //   1020: invokevirtual 748	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   1023: iconst_0
    //   1024: ireturn
    //   1025: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1028: ifeq +62 -> 1090
    //   1031: ldc 91
    //   1033: iconst_2
    //   1034: new 190	java/lang/StringBuilder
    //   1037: dup
    //   1038: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1041: ldc_w 789
    //   1044: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: aload 17
    //   1049: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: ldc_w 791
    //   1055: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: aload_1
    //   1059: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1062: ldc_w 793
    //   1065: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: aload 11
    //   1070: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: ldc_w 795
    //   1076: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1079: aload 13
    //   1081: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1087: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1090: aload 15
    //   1092: invokevirtual 800	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   1095: aload_0
    //   1096: aload 13
    //   1098: invokespecial 802	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)Ljava/util/List;
    //   1101: astore_1
    //   1102: aload_0
    //   1103: aload_1
    //   1104: aload 8
    //   1106: invokespecial 804	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:b	(Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1109: aload_0
    //   1110: aload 17
    //   1112: invokespecial 806	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)V
    //   1115: aload 11
    //   1117: ifnull +70 -> 1187
    //   1120: aload_0
    //   1121: aload 11
    //   1123: aload 17
    //   1125: aload_0
    //   1126: aload 11
    //   1128: invokespecial 809	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1131: aload_1
    //   1132: aload 8
    //   1134: invokespecial 811	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1137: aload_0
    //   1138: aload_1
    //   1139: aload 8
    //   1141: invokespecial 813	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1144: aload 15
    //   1146: invokevirtual 815	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   1149: aload 15
    //   1151: invokevirtual 818	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1154: aload 12
    //   1156: ifnull +8 -> 1164
    //   1159: aload 12
    //   1161: invokevirtual 744	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   1164: aload 8
    //   1166: ifnull +8 -> 1174
    //   1169: aload 8
    //   1171: invokevirtual 745	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1174: aload 7
    //   1176: ifnull -520 -> 656
    //   1179: aload 7
    //   1181: invokevirtual 748	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   1184: goto -528 -> 656
    //   1187: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1190: ifeq +12 -> 1202
    //   1193: ldc 91
    //   1195: iconst_2
    //   1196: ldc_w 820
    //   1199: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1202: aload_0
    //   1203: getfield 26	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   1206: invokeinterface 408 1 0
    //   1211: ifne -74 -> 1137
    //   1214: aload_0
    //   1215: getfield 26	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   1218: invokeinterface 438 1 0
    //   1223: astore 9
    //   1225: aload 9
    //   1227: invokeinterface 443 1 0
    //   1232: ifeq -95 -> 1137
    //   1235: aload 9
    //   1237: invokeinterface 447 1 0
    //   1242: checkcast 449	java/io/File
    //   1245: invokevirtual 452	java/io/File:getName	()Ljava/lang/String;
    //   1248: astore 10
    //   1250: aload_0
    //   1251: aload 10
    //   1253: invokespecial 809	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1256: astore 11
    //   1258: aload 11
    //   1260: ifnull -35 -> 1225
    //   1263: aload_0
    //   1264: aload_1
    //   1265: aload 11
    //   1267: invokespecial 822	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/util/List;[Ljava/lang/String;)Ljava/util/List;
    //   1270: invokeinterface 257 1 0
    //   1275: istore_3
    //   1276: iload_3
    //   1277: ifeq -52 -> 1225
    //   1280: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1283: ifeq +41 -> 1324
    //   1286: ldc 91
    //   1288: iconst_2
    //   1289: new 190	java/lang/StringBuilder
    //   1292: dup
    //   1293: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1296: ldc_w 824
    //   1299: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: aload 17
    //   1304: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: ldc_w 826
    //   1310: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: aload 10
    //   1315: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1321: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1324: iload_3
    //   1325: anewarray 68	java/lang/String
    //   1328: astore 11
    //   1330: iconst_0
    //   1331: istore_2
    //   1332: iload_2
    //   1333: iload_3
    //   1334: if_icmpge +27 -> 1361
    //   1337: aload 11
    //   1339: iload_2
    //   1340: aload_1
    //   1341: iload_2
    //   1342: invokeinterface 263 2 0
    //   1347: checkcast 151	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData
    //   1350: getfield 182	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1353: aastore
    //   1354: iload_2
    //   1355: iconst_1
    //   1356: iadd
    //   1357: istore_2
    //   1358: goto -26 -> 1332
    //   1361: aload_0
    //   1362: aload 10
    //   1364: aload 17
    //   1366: aload 11
    //   1368: aload_1
    //   1369: aload 8
    //   1371: invokespecial 811	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1374: goto -149 -> 1225
    //   1377: astore_1
    //   1378: aload_1
    //   1379: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   1382: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1385: ifeq +12 -> 1397
    //   1388: ldc 91
    //   1390: iconst_2
    //   1391: ldc_w 828
    //   1394: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1397: aload 15
    //   1399: invokevirtual 818	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1402: goto -248 -> 1154
    //   1405: astore_1
    //   1406: aload 15
    //   1408: invokevirtual 818	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1411: aload_1
    //   1412: athrow
    //   1413: astore_1
    //   1414: aload 12
    //   1416: astore 9
    //   1418: goto -674 -> 744
    //   1421: astore_1
    //   1422: aload 14
    //   1424: astore 9
    //   1426: aload 10
    //   1428: astore 8
    //   1430: goto -686 -> 744
    //   1433: astore 10
    //   1435: aload 7
    //   1437: astore 9
    //   1439: aload_1
    //   1440: astore 7
    //   1442: aload 10
    //   1444: astore_1
    //   1445: goto -701 -> 744
    //   1448: astore 10
    //   1450: aconst_null
    //   1451: astore 8
    //   1453: aload 7
    //   1455: astore_1
    //   1456: aload 8
    //   1458: astore 7
    //   1460: aload 9
    //   1462: astore 8
    //   1464: goto -856 -> 608
    //   1467: aconst_null
    //   1468: astore 7
    //   1470: goto +13 -> 1483
    //   1473: aconst_null
    //   1474: astore 7
    //   1476: aload 7
    //   1478: astore 11
    //   1480: goto -1120 -> 360
    //   1483: aload 7
    //   1485: astore 13
    //   1487: goto -992 -> 495
    //   1490: astore 10
    //   1492: aload 7
    //   1494: astore_1
    //   1495: aload 12
    //   1497: astore 7
    //   1499: goto -891 -> 608
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1502	0	this	MigrateSubscribeDB
    //   0	1502	1	paramFile	File
    //   1331	27	2	i	int
    //   1275	60	3	j	int
    //   20	972	4	bool	boolean
    //   63	619	5	l	long
    //   72	1426	7	localObject1	Object
    //   90	1373	8	localObject2	Object
    //   81	1380	9	localObject3	Object
    //   78	1	10	localObject4	Object
    //   601	132	10	localException1	Exception
    //   902	525	10	localObject5	Object
    //   1433	10	10	localObject6	Object
    //   1448	1	10	localException2	Exception
    //   1490	1	10	localException3	Exception
    //   69	1410	11	localObject7	Object
    //   87	1409	12	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    //   406	1080	13	localObject8	Object
    //   93	1330	14	localObject9	Object
    //   84	1323	15	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   75	768	16	localObject10	Object
    //   190	1175	17	str	String
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
    //   893	900	601	java/lang/Exception
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
    //   893	900	731	finally
    //   1095	1115	1377	java/lang/Exception
    //   1120	1137	1377	java/lang/Exception
    //   1137	1149	1377	java/lang/Exception
    //   1187	1202	1377	java/lang/Exception
    //   1202	1225	1377	java/lang/Exception
    //   1225	1258	1377	java/lang/Exception
    //   1263	1276	1377	java/lang/Exception
    //   1280	1324	1377	java/lang/Exception
    //   1324	1330	1377	java/lang/Exception
    //   1337	1354	1377	java/lang/Exception
    //   1361	1374	1377	java/lang/Exception
    //   1095	1115	1405	finally
    //   1120	1137	1405	finally
    //   1137	1149	1405	finally
    //   1187	1202	1405	finally
    //   1202	1225	1405	finally
    //   1225	1258	1405	finally
    //   1263	1276	1405	finally
    //   1280	1324	1405	finally
    //   1324	1330	1405	finally
    //   1337	1354	1405	finally
    //   1361	1374	1405	finally
    //   1378	1397	1405	finally
    //   950	990	1413	finally
    //   1025	1090	1413	finally
    //   1090	1095	1413	finally
    //   1149	1154	1413	finally
    //   1397	1402	1413	finally
    //   1406	1413	1413	finally
    //   908	915	1421	finally
    //   923	930	1421	finally
    //   938	950	1421	finally
    //   608	628	1433	finally
    //   908	915	1448	java/lang/Exception
    //   923	930	1448	java/lang/Exception
    //   938	950	1448	java/lang/Exception
    //   950	990	1490	java/lang/Exception
    //   1025	1090	1490	java/lang/Exception
    //   1090	1095	1490	java/lang/Exception
    //   1149	1154	1490	java/lang/Exception
    //   1397	1402	1490	java/lang/Exception
    //   1406	1413	1490	java/lang/Exception
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
    //   17: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +16 -> 36
    //   23: ldc 91
    //   25: iconst_2
    //   26: ldc_w 830
    //   29: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload 5
    //   34: astore 4
    //   36: aload 4
    //   38: areturn
    //   39: invokestatic 105	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   42: astore 4
    //   44: new 99	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper
    //   47: dup
    //   48: aload_0
    //   49: aload 4
    //   51: aload_1
    //   52: bipush 80
    //   54: invokespecial 108	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Landroid/content/Context;Ljava/lang/String;I)V
    //   57: astore 6
    //   59: aload 6
    //   61: invokevirtual 112	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   64: astore 5
    //   66: aload 5
    //   68: ldc_w 832
    //   71: aconst_null
    //   72: invokevirtual 120	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
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
    //   96: invokeinterface 125 1 0
    //   101: ifeq +194 -> 295
    //   104: aload 4
    //   106: astore 8
    //   108: aload 5
    //   110: astore 9
    //   112: aload 6
    //   114: astore 10
    //   116: aload 4
    //   118: invokeinterface 835 1 0
    //   123: anewarray 68	java/lang/String
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
    //   146: invokeinterface 158 2 0
    //   151: aastore
    //   152: aload 4
    //   154: astore 8
    //   156: aload 5
    //   158: astore 9
    //   160: aload 6
    //   162: astore 10
    //   164: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +59 -> 226
    //   170: aload 4
    //   172: astore 8
    //   174: aload 5
    //   176: astore 9
    //   178: aload 6
    //   180: astore 10
    //   182: ldc 91
    //   184: iconst_2
    //   185: new 190	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 837
    //   195: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: iload_2
    //   199: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: ldc_w 839
    //   205: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_1
    //   209: iload_2
    //   210: aaload
    //   211: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc_w 841
    //   217: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   244: invokeinterface 217 1 0
    //   249: istore_3
    //   250: iload_3
    //   251: ifne -122 -> 129
    //   254: aload 4
    //   256: ifnull +10 -> 266
    //   259: aload 4
    //   261: invokeinterface 220 1 0
    //   266: aload 5
    //   268: ifnull +8 -> 276
    //   271: aload 5
    //   273: invokevirtual 397	android/database/sqlite/SQLiteDatabase:close	()V
    //   276: aload_1
    //   277: astore 4
    //   279: aload 6
    //   281: ifnull -245 -> 36
    //   284: aload 6
    //   286: invokevirtual 221	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:close	()V
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
    //   310: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq -59 -> 254
    //   316: aload 4
    //   318: astore 8
    //   320: aload 5
    //   322: astore 9
    //   324: aload 6
    //   326: astore 10
    //   328: ldc 91
    //   330: iconst_2
    //   331: ldc_w 843
    //   334: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   357: invokevirtual 226	java/lang/Exception:printStackTrace	()V
    //   360: aload 4
    //   362: astore 8
    //   364: aload 5
    //   366: astore 9
    //   368: aload 6
    //   370: astore 10
    //   372: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +25 -> 400
    //   378: aload 4
    //   380: astore 8
    //   382: aload 5
    //   384: astore 9
    //   386: aload 6
    //   388: astore 10
    //   390: ldc 91
    //   392: iconst_2
    //   393: ldc_w 845
    //   396: aload_1
    //   397: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   400: aload 4
    //   402: ifnull +10 -> 412
    //   405: aload 4
    //   407: invokeinterface 220 1 0
    //   412: aload 5
    //   414: ifnull +8 -> 422
    //   417: aload 5
    //   419: invokevirtual 397	android/database/sqlite/SQLiteDatabase:close	()V
    //   422: aload 7
    //   424: astore 4
    //   426: aload 6
    //   428: ifnull -392 -> 36
    //   431: aload 6
    //   433: invokevirtual 221	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:close	()V
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
    //   458: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   461: ifeq -207 -> 254
    //   464: aload 4
    //   466: astore 8
    //   468: aload 5
    //   470: astore 9
    //   472: aload 6
    //   474: astore 10
    //   476: ldc 91
    //   478: iconst_2
    //   479: ldc_w 847
    //   482: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   511: invokeinterface 220 1 0
    //   516: aload 5
    //   518: ifnull +8 -> 526
    //   521: aload 5
    //   523: invokevirtual 397	android/database/sqlite/SQLiteDatabase:close	()V
    //   526: aload 6
    //   528: ifnull +8 -> 536
    //   531: aload 6
    //   533: invokevirtual 221	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:close	()V
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
      Collections.sort(this.jdField_a_of_type_JavaUtilList, new MigrateSubscribeDB.1(this));
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
  
  private void b(List<MigrateSubscribeDB.SubscribeRecentData> paramList, EntityManager paramEntityManager)
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
        MigrateSubscribeDB.SubscribeRecentData localSubscribeRecentData = (MigrateSubscribeDB.SubscribeRecentData)paramList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo subscribeRecentData: " + localSubscribeRecentData);
        }
        String str = SubscriptUtil.a(localSubscribeRecentData.jdField_a_of_type_JavaLangString);
        ConversationInfo localConversationInfo;
        int j;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo find subscribeID[" + localSubscribeRecentData.jdField_a_of_type_JavaLangString + "]'s uin: " + str);
          }
          localConversationInfo = new ConversationInfo();
          List localList = paramEntityManager.query(ConversationInfo.class, false, "uin=? and type=?", new String[] { str, String.valueOf(1008) }, null, null, null, null);
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
            localConversationInfo.setUnread(localConversationInfo.unreadCount + localSubscribeRecentData.jdField_a_of_type_Int);
            localConversationInfo.setType(1008);
            paramEntityManager.persistOrReplace(localConversationInfo);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label265;
          localConversationInfo.uin = str;
          localConversationInfo.setUnread(localSubscribeRecentData.jdField_a_of_type_Int);
          localConversationInfo.setType(1008);
          break label340;
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo we can't subscribeid[" + localSubscribeRecentData.jdField_a_of_type_JavaLangString + "]'s uin");
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo total cost = " + (System.nanoTime() - l) / 1000000L + " ms ");
  }
  
  private void c(List<MessageRecord> paramList, EntityManager paramEntityManager)
  {
    long l = System.nanoTime();
    if (paramList == null) {}
    do
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        paramEntityManager.persistOrReplace((MessageRecord)paramList.get(i));
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MigrateSubscribeDB", 2, "migrateToMsgRecord total cost = " + (System.nanoTime() - l) / 1000000L + " ms ");
  }
  
  protected boolean doStep()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "begin do Step for MigrateSubscribeDB." + BaseApplicationImpl.sProcessId);
    }
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "No need do update action");
      }
      return super.doStep();
    }
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = BaseApplicationImpl.sApplication;
    if (this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "doStep fail app is null");
      }
      return super.doStep();
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
        return super.doStep();
      }
      this.jdField_a_of_type_Long += 1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.MigrateSubscribeDB
 * JD-Core Version:    0.7.0.1
 */