package com.tencent.mobileqq.startup.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import antf;
import bcsa;
import bdjh;
import bdji;
import bdjj;
import bnrf;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import twh;

public class MigrateSubscribeDB
  extends Step
{
  public static boolean a;
  int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long = 0L;
  BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private List<File> jdField_a_of_type_JavaUtilList;
  private List<File> jdField_b_of_type_JavaUtilList;
  volatile boolean jdField_b_of_type_Boolean = true;
  private List<File> c;
  
  private int a()
  {
    return (short)Math.abs(new Random().nextInt()) & 0xFFFF;
  }
  
  private long a()
  {
    return bcsa.a(Math.abs(new Random().nextInt()) | 0x0);
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
  
  private List<bdjj> a(String paramString)
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
    bdji localbdji = new bdji(this, BaseApplication.getContext(), paramString, 17);
    paramString = localbdji.getReadableDatabase().rawQuery("select * from RecentSubscribeData order by mLastMsgTime DESC", null);
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
        bdjj localbdjj = new bdjj(this, null);
        localbdjj.d = a(paramString.getString(i));
        localbdjj.e = a(paramString.getString(j));
        localbdjj.jdField_c_of_type_JavaLangString = a(paramString.getString(k));
        localbdjj.jdField_b_of_type_Long = paramString.getLong(m);
        localbdjj.jdField_a_of_type_Long = paramString.getLong(n);
        localbdjj.jdField_c_of_type_Long = paramString.getLong(i1);
        localbdjj.f = a(paramString.getString(i2));
        localbdjj.jdField_a_of_type_JavaLangString = a(paramString.getString(i3));
        localbdjj.jdField_b_of_type_JavaLangString = a(paramString.getString(i4));
        localbdjj.jdField_a_of_type_Int = paramString.getInt(i5);
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "read Subscribe RecentDataResults:(mDraft,mDraftTime,mLastMsg,mLastMsgID,mLastMsgTime,mLastReorderTime,mSubscribeHeadUrl,mSubscribeID,mSubscribeName,mUnreadCount)=(" + localbdjj.d + "," + localbdjj.e + "," + localbdjj.jdField_c_of_type_JavaLangString + "," + localbdjj.jdField_b_of_type_Long + "," + localbdjj.jdField_a_of_type_Long + "," + localbdjj.jdField_c_of_type_Long + localbdjj.f + "," + localbdjj.jdField_a_of_type_JavaLangString + "," + localbdjj.jdField_b_of_type_JavaLangString + "," + localbdjj.jdField_a_of_type_Int + ")");
        }
        localArrayList.add(localbdjj);
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
      if (localbdji == null) {
        break;
      }
      localbdji.close();
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
  private List<MessageRecord> a(String paramString1, String paramString2, List<bdjj> paramList, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +56 -> 59
    //   6: ldc 82
    //   8: iconst_2
    //   9: new 181	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   16: ldc 229
    //   18: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 231
    //   27: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_2
    //   31: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 233
    //   36: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_3
    //   40: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: ldc 238
    //   45: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload 4
    //   50: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: invokestatic 243	java/lang/System:nanoTime	()J
    //   62: lstore 13
    //   64: new 73	java/util/ArrayList
    //   67: dup
    //   68: invokespecial 74	java/util/ArrayList:<init>	()V
    //   71: astore 22
    //   73: aload_2
    //   74: ifnull +7 -> 81
    //   77: aload_3
    //   78: ifnonnull +19 -> 97
    //   81: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +11 -> 95
    //   87: ldc 82
    //   89: iconst_2
    //   90: ldc 245
    //   92: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aconst_null
    //   96: areturn
    //   97: aload_3
    //   98: invokeinterface 248 1 0
    //   103: istore 6
    //   105: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +29 -> 137
    //   111: ldc 82
    //   113: iconst_2
    //   114: new 181	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   121: ldc 250
    //   123: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: iload 6
    //   128: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: iconst_0
    //   138: istore 5
    //   140: iload 5
    //   142: iload 6
    //   144: if_icmpge +960 -> 1104
    //   147: aload_3
    //   148: iload 5
    //   150: invokeinterface 254 2 0
    //   155: checkcast 142	bdjj
    //   158: getfield 173	bdjj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   161: aload_2
    //   162: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   165: ifeq +677 -> 842
    //   168: aload_3
    //   169: iload 5
    //   171: invokeinterface 254 2 0
    //   176: checkcast 142	bdjj
    //   179: astore_3
    //   180: aload_3
    //   181: ifnull +917 -> 1098
    //   184: aload_3
    //   185: getfield 179	bdjj:jdField_a_of_type_Int	I
    //   188: istore 5
    //   190: ldc_w 259
    //   193: astore_3
    //   194: iload 5
    //   196: ifle +7 -> 203
    //   199: ldc_w 261
    //   202: astore_3
    //   203: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +29 -> 235
    //   209: ldc 82
    //   211: iconst_2
    //   212: new 181	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   219: ldc_w 263
    //   222: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_3
    //   226: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: new 90	bdji
    //   238: dup
    //   239: aload_0
    //   240: invokestatic 96	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   243: aload_1
    //   244: bipush 80
    //   246: invokespecial 99	bdji:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Landroid/content/Context;Ljava/lang/String;I)V
    //   249: astore_1
    //   250: aload_1
    //   251: invokevirtual 103	bdji:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   254: astore 23
    //   256: aload 23
    //   258: iconst_0
    //   259: ldc_w 265
    //   262: aconst_null
    //   263: ldc_w 267
    //   266: iconst_1
    //   267: anewarray 59	java/lang/String
    //   270: dup
    //   271: iconst_0
    //   272: aload_2
    //   273: aastore
    //   274: aconst_null
    //   275: aconst_null
    //   276: ldc_w 269
    //   279: aload_3
    //   280: invokevirtual 273	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   283: astore_2
    //   284: aload_2
    //   285: ifnull +726 -> 1011
    //   288: aload_2
    //   289: invokeinterface 116 1 0
    //   294: ifeq +690 -> 984
    //   297: aload_2
    //   298: ldc_w 275
    //   301: invokeinterface 122 2 0
    //   306: istore 7
    //   308: aload_2
    //   309: ldc_w 277
    //   312: invokeinterface 122 2 0
    //   317: istore 8
    //   319: aload_2
    //   320: ldc_w 279
    //   323: invokeinterface 122 2 0
    //   328: istore 9
    //   330: aload_2
    //   331: ldc_w 281
    //   334: invokeinterface 122 2 0
    //   339: istore 10
    //   341: aload_2
    //   342: ldc_w 283
    //   345: invokeinterface 122 2 0
    //   350: istore 11
    //   352: aload_2
    //   353: ldc_w 285
    //   356: invokeinterface 122 2 0
    //   361: istore 12
    //   363: aload_2
    //   364: iload 7
    //   366: invokeinterface 163 2 0
    //   371: lstore 15
    //   373: aload_2
    //   374: iload 8
    //   376: invokeinterface 149 2 0
    //   381: astore 25
    //   383: aload_2
    //   384: iload 9
    //   386: invokeinterface 149 2 0
    //   391: astore_3
    //   392: aload_2
    //   393: iload 10
    //   395: invokeinterface 149 2 0
    //   400: astore 24
    //   402: aload_2
    //   403: iload 11
    //   405: invokeinterface 163 2 0
    //   410: lstore 17
    //   412: aload_2
    //   413: iload 12
    //   415: invokeinterface 163 2 0
    //   420: lstore 19
    //   422: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq +84 -> 509
    //   428: ldc 82
    //   430: iconst_2
    //   431: new 181	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 287
    //   441: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: lload 15
    //   446: invokevirtual 193	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   449: ldc 190
    //   451: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload 25
    //   456: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: ldc 190
    //   461: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_3
    //   465: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: ldc 190
    //   470: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload 24
    //   475: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: ldc 190
    //   480: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: lload 17
    //   485: invokevirtual 193	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   488: ldc 190
    //   490: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: lload 19
    //   495: invokevirtual 193	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   498: ldc 198
    //   500: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   509: aload 25
    //   511: invokestatic 291	twh:a	(Ljava/lang/String;)Ljava/lang/String;
    //   514: astore_3
    //   515: aload_3
    //   516: invokestatic 297	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   519: ifne +415 -> 934
    //   522: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   525: ifeq +40 -> 565
    //   528: ldc 82
    //   530: iconst_2
    //   531: new 181	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   538: ldc_w 299
    //   541: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload 25
    //   546: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: ldc_w 301
    //   552: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload_3
    //   556: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: aload 24
    //   567: invokestatic 306	txr:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PAMessage;
    //   570: astore 26
    //   572: aload 26
    //   574: ifnull +342 -> 916
    //   577: sipush -3006
    //   580: invokestatic 311	bcry:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   583: checkcast 313	com/tencent/mobileqq/data/MessageForPubAccount
    //   586: astore 25
    //   588: aload 25
    //   590: sipush -3006
    //   593: putfield 316	com/tencent/mobileqq/data/MessageForPubAccount:msgtype	I
    //   596: aload 25
    //   598: sipush 1008
    //   601: putfield 319	com/tencent/mobileqq/data/MessageForPubAccount:istroop	I
    //   604: aload 25
    //   606: aload 24
    //   608: putfield 322	com/tencent/mobileqq/data/MessageForPubAccount:msg	Ljava/lang/String;
    //   611: aload 25
    //   613: aload 26
    //   615: putfield 326	com/tencent/mobileqq/data/MessageForPubAccount:mPAMessage	Lcom/tencent/mobileqq/data/PAMessage;
    //   618: aload 25
    //   620: aload 26
    //   622: invokestatic 329	txr:a	(Lcom/tencent/mobileqq/data/PAMessage;)[B
    //   625: putfield 333	com/tencent/mobileqq/data/MessageForPubAccount:msgData	[B
    //   628: aload 25
    //   630: aload_3
    //   631: putfield 336	com/tencent/mobileqq/data/MessageForPubAccount:frienduin	Ljava/lang/String;
    //   634: aload 25
    //   636: aload_3
    //   637: putfield 339	com/tencent/mobileqq/data/MessageForPubAccount:senderuin	Ljava/lang/String;
    //   640: aload 25
    //   642: aload 4
    //   644: putfield 342	com/tencent/mobileqq/data/MessageForPubAccount:selfuin	Ljava/lang/String;
    //   647: aload 25
    //   649: lload 17
    //   651: putfield 345	com/tencent/mobileqq/data/MessageForPubAccount:time	J
    //   654: aload 25
    //   656: lload 17
    //   658: putfield 348	com/tencent/mobileqq/data/MessageForPubAccount:msgseq	J
    //   661: aload 25
    //   663: aload_0
    //   664: invokespecial 350	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	()I
    //   667: i2l
    //   668: putfield 353	com/tencent/mobileqq/data/MessageForPubAccount:shmsgseq	J
    //   671: aload 25
    //   673: aload_0
    //   674: invokespecial 355	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	()J
    //   677: putfield 358	com/tencent/mobileqq/data/MessageForPubAccount:msgUid	J
    //   680: iload 5
    //   682: ifle +228 -> 910
    //   685: iconst_0
    //   686: istore 21
    //   688: aload 25
    //   690: iload 21
    //   692: putfield 361	com/tencent/mobileqq/data/MessageForPubAccount:isread	Z
    //   695: aload 22
    //   697: aload 25
    //   699: invokeinterface 205 2 0
    //   704: pop
    //   705: iload 5
    //   707: iconst_1
    //   708: isub
    //   709: istore 5
    //   711: goto +398 -> 1109
    //   714: aload_2
    //   715: invokeinterface 208 1 0
    //   720: istore 21
    //   722: iload 6
    //   724: istore 5
    //   726: iload 21
    //   728: ifne -365 -> 363
    //   731: aload_2
    //   732: invokeinterface 211 1 0
    //   737: aload 22
    //   739: ifnull +287 -> 1026
    //   742: aload 22
    //   744: invokeinterface 248 1 0
    //   749: ifle +277 -> 1026
    //   752: iconst_0
    //   753: istore 5
    //   755: iload 5
    //   757: aload 22
    //   759: invokeinterface 248 1 0
    //   764: iconst_1
    //   765: isub
    //   766: if_icmpge +260 -> 1026
    //   769: aload 22
    //   771: invokeinterface 248 1 0
    //   776: iconst_1
    //   777: isub
    //   778: istore 6
    //   780: iload 6
    //   782: iload 5
    //   784: if_icmple +218 -> 1002
    //   787: aload 22
    //   789: iload 6
    //   791: invokeinterface 254 2 0
    //   796: checkcast 363	com/tencent/mobileqq/data/MessageRecord
    //   799: getfield 364	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   802: aload 22
    //   804: iload 5
    //   806: invokeinterface 254 2 0
    //   811: checkcast 363	com/tencent/mobileqq/data/MessageRecord
    //   814: getfield 364	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   817: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   820: ifeq +13 -> 833
    //   823: aload 22
    //   825: iload 6
    //   827: invokeinterface 367 2 0
    //   832: pop
    //   833: iload 6
    //   835: iconst_1
    //   836: isub
    //   837: istore 6
    //   839: goto -59 -> 780
    //   842: iload 5
    //   844: iconst_1
    //   845: iadd
    //   846: istore 5
    //   848: goto -708 -> 140
    //   851: astore 24
    //   853: aload 24
    //   855: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   858: goto -240 -> 618
    //   861: astore_3
    //   862: aload_3
    //   863: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   866: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   869: ifeq +13 -> 882
    //   872: ldc 82
    //   874: iconst_2
    //   875: ldc_w 369
    //   878: aload_3
    //   879: invokestatic 222	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   882: aload_2
    //   883: invokeinterface 211 1 0
    //   888: goto -151 -> 737
    //   891: astore 24
    //   893: aload 24
    //   895: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   898: goto -270 -> 628
    //   901: astore_1
    //   902: aload_2
    //   903: invokeinterface 211 1 0
    //   908: aload_1
    //   909: athrow
    //   910: iconst_1
    //   911: istore 21
    //   913: goto -225 -> 688
    //   916: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   919: ifeq +197 -> 1116
    //   922: ldc 82
    //   924: iconst_2
    //   925: ldc_w 371
    //   928: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   931: goto +185 -> 1116
    //   934: iload 5
    //   936: istore 6
    //   938: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   941: ifeq -227 -> 714
    //   944: ldc 82
    //   946: iconst_2
    //   947: new 181	java/lang/StringBuilder
    //   950: dup
    //   951: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   954: ldc_w 373
    //   957: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: aload 25
    //   962: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: ldc_w 375
    //   968: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   974: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   977: iload 5
    //   979: istore 6
    //   981: goto -267 -> 714
    //   984: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   987: ifeq -256 -> 731
    //   990: ldc 82
    //   992: iconst_2
    //   993: ldc_w 377
    //   996: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   999: goto -268 -> 731
    //   1002: iload 5
    //   1004: iconst_1
    //   1005: iadd
    //   1006: istore 5
    //   1008: goto -253 -> 755
    //   1011: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1014: ifeq +12 -> 1026
    //   1017: ldc 82
    //   1019: iconst_2
    //   1020: ldc_w 379
    //   1023: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1026: aload_1
    //   1027: ifnull +7 -> 1034
    //   1030: aload_1
    //   1031: invokevirtual 212	bdji:close	()V
    //   1034: aload 23
    //   1036: ifnull +8 -> 1044
    //   1039: aload 23
    //   1041: invokevirtual 380	android/database/sqlite/SQLiteDatabase:close	()V
    //   1044: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1047: ifeq +44 -> 1091
    //   1050: ldc 82
    //   1052: iconst_2
    //   1053: new 181	java/lang/StringBuilder
    //   1056: dup
    //   1057: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   1060: ldc_w 382
    //   1063: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: invokestatic 243	java/lang/System:nanoTime	()J
    //   1069: lload 13
    //   1071: lsub
    //   1072: ldc2_w 383
    //   1075: ldiv
    //   1076: invokevirtual 193	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1079: ldc_w 386
    //   1082: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1088: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1091: aload 22
    //   1093: areturn
    //   1094: astore_1
    //   1095: goto -51 -> 1044
    //   1098: iconst_0
    //   1099: istore 5
    //   1101: goto -911 -> 190
    //   1104: aconst_null
    //   1105: astore_3
    //   1106: goto -926 -> 180
    //   1109: iload 5
    //   1111: istore 6
    //   1113: goto -399 -> 714
    //   1116: goto -7 -> 1109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1119	0	this	MigrateSubscribeDB
    //   0	1119	1	paramString1	String
    //   0	1119	2	paramString2	String
    //   0	1119	3	paramList	List<bdjj>
    //   0	1119	4	paramString3	String
    //   138	972	5	i	int
    //   103	1009	6	j	int
    //   306	59	7	k	int
    //   317	58	8	m	int
    //   328	57	9	n	int
    //   339	55	10	i1	int
    //   350	54	11	i2	int
    //   361	53	12	i3	int
    //   62	1008	13	l1	long
    //   371	74	15	l2	long
    //   410	247	17	l3	long
    //   420	74	19	l4	long
    //   686	226	21	bool	boolean
    //   71	1021	22	localArrayList	ArrayList
    //   254	786	23	localSQLiteDatabase	SQLiteDatabase
    //   400	207	24	str	String
    //   851	3	24	localException1	Exception
    //   891	3	24	localException2	Exception
    //   381	580	25	localObject	Object
    //   570	51	26	localPAMessage	com.tencent.mobileqq.data.PAMessage
    // Exception table:
    //   from	to	target	type
    //   611	618	851	java/lang/Exception
    //   288	363	861	java/lang/Exception
    //   363	509	861	java/lang/Exception
    //   509	565	861	java/lang/Exception
    //   565	572	861	java/lang/Exception
    //   577	611	861	java/lang/Exception
    //   628	680	861	java/lang/Exception
    //   688	705	861	java/lang/Exception
    //   714	722	861	java/lang/Exception
    //   853	858	861	java/lang/Exception
    //   893	898	861	java/lang/Exception
    //   916	931	861	java/lang/Exception
    //   938	977	861	java/lang/Exception
    //   984	999	861	java/lang/Exception
    //   618	628	891	java/lang/Exception
    //   288	363	901	finally
    //   363	509	901	finally
    //   509	565	901	finally
    //   565	572	901	finally
    //   577	611	901	finally
    //   611	618	901	finally
    //   618	628	901	finally
    //   628	680	901	finally
    //   688	705	901	finally
    //   714	722	901	finally
    //   853	858	901	finally
    //   862	882	901	finally
    //   893	898	901	finally
    //   916	931	901	finally
    //   938	977	901	finally
    //   984	999	901	finally
    //   1039	1044	1094	java/lang/Exception
  }
  
  private List<String> a(List<bdjj> paramList, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((bdjj)paramList.get(i)).jdField_a_of_type_JavaLangString;
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
    if (bnrf.b()) {
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
        ((ConcurrentHashMap)localObject1).put(antf.ar, Integer.valueOf(j));
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
        if (bnrf.b()) {
          QLog.i("MigrateSubscribeDB", 2, "updateFolderUnReadCount, put troopbar new list ( newMsgStr ): " + (String)localObject1);
        }
      }
      label632:
      break;
      label634:
      int i = 0;
    }
  }
  
  private void a(String paramString1, String paramString2, String[] paramArrayOfString, List<bdjj> paramList, EntityManager paramEntityManager)
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
  
  private void a(String paramString, List<bdjj> paramList, List<MessageRecord> paramList1)
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
        if (((bdjj)paramList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString))
        {
          paramString = (bdjj)paramList.get(i);
          paramString.jdField_c_of_type_Long = l;
          paramList.set(i, paramString);
          return;
        }
        i += 1;
      }
    }
  }
  
  private void a(List<bdjj> paramList, EntityManager paramEntityManager)
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
        bdjj localbdjj = (bdjj)paramList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar subscribeRecentData: " + localbdjj);
        }
        String str = twh.a(localbdjj.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(str))
        {
          TroopBarData localTroopBarData = new TroopBarData();
          localTroopBarData.mUin = str;
          localTroopBarData.mLastMsgTime = localbdjj.jdField_c_of_type_Long;
          localTroopBarData.mLastDraftTime = 0L;
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar subscribeid[" + localbdjj.jdField_a_of_type_JavaLangString + "] create new TroopBarData: " + localTroopBarData);
          }
          paramEntityManager.persistOrReplace(localTroopBarData);
        }
        for (;;)
        {
          i += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar we can't subscribeid[" + localbdjj.jdField_a_of_type_JavaLangString + "]'s uin");
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
        QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate oldVersion: " + str + " : curVersion: " + "8.4.5");
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
    //   4: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 82
    //   12: iconst_2
    //   13: ldc_w 688
    //   16: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: iconst_0
    //   20: istore 6
    //   22: iload 6
    //   24: ireturn
    //   25: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +32 -> 60
    //   31: ldc 82
    //   33: iconst_2
    //   34: new 181	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   41: ldc_w 690
    //   44: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: invokevirtual 693	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: invokestatic 243	java/lang/System:nanoTime	()J
    //   63: lstore 4
    //   65: aload_1
    //   66: invokevirtual 437	java/io/File:getName	()Ljava/lang/String;
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
    //   96: getfield 695	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   99: invokeinterface 393 1 0
    //   104: ifne +15 -> 119
    //   107: aload_0
    //   108: getfield 697	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	Ljava/util/List;
    //   111: invokeinterface 393 1 0
    //   116: ifeq +57 -> 173
    //   119: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +12 -> 134
    //   125: ldc 82
    //   127: iconst_2
    //   128: ldc_w 699
    //   131: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: iconst_0
    //   135: istore 6
    //   137: iconst_0
    //   138: ifeq +11 -> 149
    //   141: new 701	java/lang/NullPointerException
    //   144: dup
    //   145: invokespecial 702	java/lang/NullPointerException:<init>	()V
    //   148: athrow
    //   149: iconst_0
    //   150: ifeq +11 -> 161
    //   153: new 701	java/lang/NullPointerException
    //   156: dup
    //   157: invokespecial 702	java/lang/NullPointerException:<init>	()V
    //   160: athrow
    //   161: iconst_0
    //   162: ifeq -140 -> 22
    //   165: new 701	java/lang/NullPointerException
    //   168: dup
    //   169: invokespecial 702	java/lang/NullPointerException:<init>	()V
    //   172: athrow
    //   173: aload 11
    //   175: ldc_w 439
    //   178: ldc_w 441
    //   181: invokevirtual 445	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   184: invokestatic 708	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   187: invokestatic 711	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   190: astore 17
    //   192: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +30 -> 225
    //   198: ldc 82
    //   200: iconst_2
    //   201: new 181	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 713
    //   211: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 17
    //   216: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload_0
    //   226: getfield 695	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   229: invokeinterface 393 1 0
    //   234: ifne +471 -> 705
    //   237: aload_0
    //   238: getfield 695	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   241: invokeinterface 423 1 0
    //   246: astore 7
    //   248: aload 7
    //   250: invokeinterface 428 1 0
    //   255: ifeq +1222 -> 1477
    //   258: aload 7
    //   260: invokeinterface 432 1 0
    //   265: checkcast 434	java/io/File
    //   268: invokevirtual 437	java/io/File:getName	()Ljava/lang/String;
    //   271: astore 11
    //   273: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +30 -> 306
    //   279: ldc 82
    //   281: iconst_2
    //   282: new 181	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   289: ldc_w 715
    //   292: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 11
    //   297: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload 11
    //   308: aload 17
    //   310: invokevirtual 718	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   313: ifeq +241 -> 554
    //   316: aload 11
    //   318: astore 7
    //   320: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +1157 -> 1480
    //   326: ldc 82
    //   328: iconst_2
    //   329: new 181	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 720
    //   339: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload 11
    //   344: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   353: aload 11
    //   355: astore 7
    //   357: goto +1123 -> 1480
    //   360: aload_0
    //   361: getfield 697	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	Ljava/util/List;
    //   364: invokeinterface 393 1 0
    //   369: ifne +454 -> 823
    //   372: aload_0
    //   373: getfield 697	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	Ljava/util/List;
    //   376: invokeinterface 423 1 0
    //   381: astore 7
    //   383: aload 7
    //   385: invokeinterface 428 1 0
    //   390: ifeq +1081 -> 1471
    //   393: aload 7
    //   395: invokeinterface 432 1 0
    //   400: checkcast 434	java/io/File
    //   403: invokevirtual 437	java/io/File:getName	()Ljava/lang/String;
    //   406: astore 13
    //   408: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +30 -> 441
    //   414: ldc 82
    //   416: iconst_2
    //   417: new 181	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   424: ldc_w 722
    //   427: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload 13
    //   432: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: aload 13
    //   443: aload 17
    //   445: invokevirtual 718	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   448: ifeq +328 -> 776
    //   451: aload 13
    //   453: astore 7
    //   455: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   458: ifeq +1029 -> 1487
    //   461: ldc 82
    //   463: iconst_2
    //   464: new 181	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   471: ldc_w 724
    //   474: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload 13
    //   479: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   488: aload 13
    //   490: astore 7
    //   492: goto +995 -> 1487
    //   495: aload 13
    //   497: ifnonnull +352 -> 849
    //   500: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +12 -> 515
    //   506: ldc 82
    //   508: iconst_2
    //   509: ldc_w 726
    //   512: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: iconst_1
    //   516: istore 6
    //   518: iconst_0
    //   519: ifeq +11 -> 530
    //   522: new 701	java/lang/NullPointerException
    //   525: dup
    //   526: invokespecial 702	java/lang/NullPointerException:<init>	()V
    //   529: athrow
    //   530: iconst_0
    //   531: ifeq +11 -> 542
    //   534: new 701	java/lang/NullPointerException
    //   537: dup
    //   538: invokespecial 702	java/lang/NullPointerException:<init>	()V
    //   541: athrow
    //   542: iconst_0
    //   543: ifeq -521 -> 22
    //   546: new 701	java/lang/NullPointerException
    //   549: dup
    //   550: invokespecial 702	java/lang/NullPointerException:<init>	()V
    //   553: athrow
    //   554: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   557: ifeq -309 -> 248
    //   560: ldc 82
    //   562: iconst_2
    //   563: new 181	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   570: ldc_w 728
    //   573: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload 11
    //   578: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: ldc_w 730
    //   584: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload 17
    //   589: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: goto -350 -> 248
    //   601: astore 10
    //   603: aconst_null
    //   604: astore 7
    //   606: aconst_null
    //   607: astore_1
    //   608: aload 10
    //   610: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   613: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   616: ifeq +12 -> 628
    //   619: ldc 82
    //   621: iconst_2
    //   622: ldc_w 732
    //   625: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: aload 7
    //   630: ifnull +8 -> 638
    //   633: aload 7
    //   635: invokevirtual 735	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   638: aload 8
    //   640: ifnull +8 -> 648
    //   643: aload 8
    //   645: invokevirtual 736	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   648: aload_1
    //   649: ifnull +7 -> 656
    //   652: aload_1
    //   653: invokevirtual 739	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   656: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   659: ifeq +44 -> 703
    //   662: ldc 82
    //   664: iconst_2
    //   665: new 181	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   672: ldc_w 741
    //   675: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: invokestatic 243	java/lang/System:nanoTime	()J
    //   681: lload 4
    //   683: lsub
    //   684: ldc2_w 383
    //   687: ldiv
    //   688: invokevirtual 193	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   691: ldc_w 743
    //   694: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   703: iconst_1
    //   704: ireturn
    //   705: aload 7
    //   707: astore 11
    //   709: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   712: ifeq -352 -> 360
    //   715: ldc 82
    //   717: iconst_2
    //   718: ldc_w 745
    //   721: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   751: invokevirtual 735	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   754: aload 8
    //   756: ifnull +8 -> 764
    //   759: aload 8
    //   761: invokevirtual 736	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   764: aload 7
    //   766: ifnull +8 -> 774
    //   769: aload 7
    //   771: invokevirtual 739	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   774: aload_1
    //   775: athrow
    //   776: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   779: ifeq -396 -> 383
    //   782: ldc 82
    //   784: iconst_2
    //   785: new 181	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   792: ldc_w 747
    //   795: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload 13
    //   800: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: ldc_w 730
    //   806: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: aload 17
    //   811: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   820: goto -437 -> 383
    //   823: aload 16
    //   825: astore 13
    //   827: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   830: ifeq -335 -> 495
    //   833: ldc 82
    //   835: iconst_2
    //   836: ldc_w 749
    //   839: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   842: aload 16
    //   844: astore 13
    //   846: goto -351 -> 495
    //   849: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   852: ifeq +41 -> 893
    //   855: ldc 82
    //   857: iconst_2
    //   858: new 181	java/lang/StringBuilder
    //   861: dup
    //   862: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   865: ldc_w 751
    //   868: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: aload 11
    //   873: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: ldc_w 753
    //   879: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: aload 13
    //   884: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   893: new 755	com/tencent/mobileqq/data/QQEntityManagerFactory
    //   896: dup
    //   897: aload 17
    //   899: invokespecial 756	com/tencent/mobileqq/data/QQEntityManagerFactory:<init>	(Ljava/lang/String;)V
    //   902: astore 7
    //   904: aload 15
    //   906: astore 10
    //   908: aload 12
    //   910: astore 9
    //   912: aload 7
    //   914: invokevirtual 760	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   917: astore 8
    //   919: aload 8
    //   921: astore 10
    //   923: aload 8
    //   925: astore 9
    //   927: aload 8
    //   929: invokevirtual 764	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   932: astore 15
    //   934: aload 8
    //   936: astore 10
    //   938: aload 8
    //   940: astore 9
    //   942: aload 7
    //   944: aload 17
    //   946: invokevirtual 768	com/tencent/mobileqq/persistence/EntityManagerFactory:build	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   949: invokevirtual 774	com/tencent/mobileqq/app/SQLiteOpenHelper:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   952: astore 12
    //   954: aload_0
    //   955: getfield 22	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_Boolean	Z
    //   958: ifne +71 -> 1029
    //   961: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   964: ifeq +30 -> 994
    //   967: ldc 82
    //   969: iconst_2
    //   970: new 181	java/lang/StringBuilder
    //   973: dup
    //   974: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   977: ldc_w 776
    //   980: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: aload 17
    //   985: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   991: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   994: iconst_0
    //   995: istore 6
    //   997: aload 12
    //   999: ifnull +8 -> 1007
    //   1002: aload 12
    //   1004: invokevirtual 735	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   1007: aload 8
    //   1009: ifnull +8 -> 1017
    //   1012: aload 8
    //   1014: invokevirtual 736	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1017: aload 7
    //   1019: ifnull -997 -> 22
    //   1022: aload 7
    //   1024: invokevirtual 739	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   1027: iconst_0
    //   1028: ireturn
    //   1029: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1032: ifeq +62 -> 1094
    //   1035: ldc 82
    //   1037: iconst_2
    //   1038: new 181	java/lang/StringBuilder
    //   1041: dup
    //   1042: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   1045: ldc_w 778
    //   1048: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: aload 17
    //   1053: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: ldc_w 780
    //   1059: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: aload_1
    //   1063: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1066: ldc_w 782
    //   1069: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: aload 11
    //   1074: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: ldc_w 784
    //   1080: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: aload 13
    //   1085: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1091: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1094: aload 15
    //   1096: invokevirtual 789	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   1099: aload_0
    //   1100: aload 13
    //   1102: invokespecial 791	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)Ljava/util/List;
    //   1105: astore_1
    //   1106: aload_0
    //   1107: aload_1
    //   1108: aload 8
    //   1110: invokespecial 793	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:b	(Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1113: aload_0
    //   1114: aload 17
    //   1116: invokespecial 795	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)V
    //   1119: aload 11
    //   1121: ifnull +70 -> 1191
    //   1124: aload_0
    //   1125: aload 11
    //   1127: aload 17
    //   1129: aload_0
    //   1130: aload 11
    //   1132: invokespecial 798	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1135: aload_1
    //   1136: aload 8
    //   1138: invokespecial 800	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1141: aload_0
    //   1142: aload_1
    //   1143: aload 8
    //   1145: invokespecial 802	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1148: aload 15
    //   1150: invokevirtual 804	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   1153: aload 15
    //   1155: invokevirtual 807	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1158: aload 12
    //   1160: ifnull +8 -> 1168
    //   1163: aload 12
    //   1165: invokevirtual 735	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   1168: aload 8
    //   1170: ifnull +8 -> 1178
    //   1173: aload 8
    //   1175: invokevirtual 736	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1178: aload 7
    //   1180: ifnull -524 -> 656
    //   1183: aload 7
    //   1185: invokevirtual 739	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   1188: goto -532 -> 656
    //   1191: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1194: ifeq +12 -> 1206
    //   1197: ldc 82
    //   1199: iconst_2
    //   1200: ldc_w 809
    //   1203: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1206: aload_0
    //   1207: getfield 695	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   1210: invokeinterface 393 1 0
    //   1215: ifne -74 -> 1141
    //   1218: aload_0
    //   1219: getfield 695	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   1222: invokeinterface 423 1 0
    //   1227: astore 10
    //   1229: aload 10
    //   1231: invokeinterface 428 1 0
    //   1236: ifeq -95 -> 1141
    //   1239: aload 10
    //   1241: invokeinterface 432 1 0
    //   1246: checkcast 434	java/io/File
    //   1249: invokevirtual 437	java/io/File:getName	()Ljava/lang/String;
    //   1252: astore 9
    //   1254: aload_0
    //   1255: aload 9
    //   1257: invokespecial 798	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1260: astore 11
    //   1262: aload 11
    //   1264: ifnull -35 -> 1229
    //   1267: aload_0
    //   1268: aload_1
    //   1269: aload 11
    //   1271: invokespecial 811	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/util/List;[Ljava/lang/String;)Ljava/util/List;
    //   1274: invokeinterface 248 1 0
    //   1279: istore_3
    //   1280: iload_3
    //   1281: ifeq -52 -> 1229
    //   1284: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1287: ifeq +41 -> 1328
    //   1290: ldc 82
    //   1292: iconst_2
    //   1293: new 181	java/lang/StringBuilder
    //   1296: dup
    //   1297: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   1300: ldc_w 813
    //   1303: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: aload 17
    //   1308: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: ldc_w 815
    //   1314: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: aload 9
    //   1319: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1322: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1325: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1328: iload_3
    //   1329: anewarray 59	java/lang/String
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
    //   1346: invokeinterface 254 2 0
    //   1351: checkcast 142	bdjj
    //   1354: getfield 173	bdjj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   1375: invokespecial 800	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1378: goto -149 -> 1229
    //   1381: astore_1
    //   1382: aload_1
    //   1383: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   1386: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1389: ifeq +12 -> 1401
    //   1392: ldc 82
    //   1394: iconst_2
    //   1395: ldc_w 817
    //   1398: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1401: aload 15
    //   1403: invokevirtual 807	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1406: goto -248 -> 1158
    //   1409: astore_1
    //   1410: aload 15
    //   1412: invokevirtual 807	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
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
    //   63	619	4	l	long
    //   20	976	6	bool	boolean
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
    //   17: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +16 -> 36
    //   23: ldc 82
    //   25: iconst_2
    //   26: ldc_w 819
    //   29: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload 5
    //   34: astore 4
    //   36: aload 4
    //   38: areturn
    //   39: invokestatic 96	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   42: astore 4
    //   44: new 90	bdji
    //   47: dup
    //   48: aload_0
    //   49: aload 4
    //   51: aload_1
    //   52: bipush 80
    //   54: invokespecial 99	bdji:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Landroid/content/Context;Ljava/lang/String;I)V
    //   57: astore 6
    //   59: aload 6
    //   61: invokevirtual 103	bdji:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   64: astore 5
    //   66: aload 5
    //   68: ldc_w 821
    //   71: aconst_null
    //   72: invokevirtual 111	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
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
    //   96: invokeinterface 116 1 0
    //   101: ifeq +194 -> 295
    //   104: aload 4
    //   106: astore 8
    //   108: aload 5
    //   110: astore 9
    //   112: aload 6
    //   114: astore 10
    //   116: aload 4
    //   118: invokeinterface 824 1 0
    //   123: anewarray 59	java/lang/String
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
    //   146: invokeinterface 149 2 0
    //   151: aastore
    //   152: aload 4
    //   154: astore 8
    //   156: aload 5
    //   158: astore 9
    //   160: aload 6
    //   162: astore 10
    //   164: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +59 -> 226
    //   170: aload 4
    //   172: astore 8
    //   174: aload 5
    //   176: astore 9
    //   178: aload 6
    //   180: astore 10
    //   182: ldc 82
    //   184: iconst_2
    //   185: new 181	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 826
    //   195: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: iload_2
    //   199: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: ldc_w 828
    //   205: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_1
    //   209: iload_2
    //   210: aaload
    //   211: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc_w 830
    //   217: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   244: invokeinterface 208 1 0
    //   249: istore_3
    //   250: iload_3
    //   251: ifne -122 -> 129
    //   254: aload 4
    //   256: ifnull +10 -> 266
    //   259: aload 4
    //   261: invokeinterface 211 1 0
    //   266: aload 5
    //   268: ifnull +8 -> 276
    //   271: aload 5
    //   273: invokevirtual 380	android/database/sqlite/SQLiteDatabase:close	()V
    //   276: aload_1
    //   277: astore 4
    //   279: aload 6
    //   281: ifnull -245 -> 36
    //   284: aload 6
    //   286: invokevirtual 212	bdji:close	()V
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
    //   310: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq -59 -> 254
    //   316: aload 4
    //   318: astore 8
    //   320: aload 5
    //   322: astore 9
    //   324: aload 6
    //   326: astore 10
    //   328: ldc 82
    //   330: iconst_2
    //   331: ldc_w 832
    //   334: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   357: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   360: aload 4
    //   362: astore 8
    //   364: aload 5
    //   366: astore 9
    //   368: aload 6
    //   370: astore 10
    //   372: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +25 -> 400
    //   378: aload 4
    //   380: astore 8
    //   382: aload 5
    //   384: astore 9
    //   386: aload 6
    //   388: astore 10
    //   390: ldc 82
    //   392: iconst_2
    //   393: ldc_w 834
    //   396: aload_1
    //   397: invokestatic 222	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   400: aload 4
    //   402: ifnull +10 -> 412
    //   405: aload 4
    //   407: invokeinterface 211 1 0
    //   412: aload 5
    //   414: ifnull +8 -> 422
    //   417: aload 5
    //   419: invokevirtual 380	android/database/sqlite/SQLiteDatabase:close	()V
    //   422: aload 7
    //   424: astore 4
    //   426: aload 6
    //   428: ifnull -392 -> 36
    //   431: aload 6
    //   433: invokevirtual 212	bdji:close	()V
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
    //   458: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   461: ifeq -207 -> 254
    //   464: aload 4
    //   466: astore 8
    //   468: aload 5
    //   470: astore 9
    //   472: aload 6
    //   474: astore 10
    //   476: ldc 82
    //   478: iconst_2
    //   479: ldc_w 836
    //   482: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   511: invokeinterface 211 1 0
    //   516: aload 5
    //   518: ifnull +8 -> 526
    //   521: aload 5
    //   523: invokevirtual 380	android/database/sqlite/SQLiteDatabase:close	()V
    //   526: aload 6
    //   528: ifnull +8 -> 536
    //   531: aload 6
    //   533: invokevirtual 212	bdji:close	()V
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
      Collections.sort(this.jdField_a_of_type_JavaUtilList, new bdjh(this));
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
  
  private void b(List<bdjj> paramList, EntityManager paramEntityManager)
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
        bdjj localbdjj = (bdjj)paramList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo subscribeRecentData: " + localbdjj);
        }
        String str = twh.a(localbdjj.jdField_a_of_type_JavaLangString);
        ConversationInfo localConversationInfo;
        int j;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo find subscribeID[" + localbdjj.jdField_a_of_type_JavaLangString + "]'s uin: " + str);
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
            localConversationInfo.unreadCount += localbdjj.jdField_a_of_type_Int;
            localConversationInfo.type = 1008;
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
          localConversationInfo.unreadCount = localbdjj.jdField_a_of_type_Int;
          localConversationInfo.type = 1008;
          break label340;
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo we can't subscribeid[" + localbdjj.jdField_a_of_type_JavaLangString + "]'s uin");
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