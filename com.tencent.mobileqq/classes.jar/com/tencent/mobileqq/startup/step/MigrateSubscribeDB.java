package com.tencent.mobileqq.startup.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.subscript.SubscriptUtil;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.remote.SimpleAccount;
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

public class MigrateSubscribeDB
  extends Step
{
  public static boolean a = false;
  int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long = 0L;
  BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private List<File> jdField_a_of_type_JavaUtilList = null;
  private List<File> jdField_b_of_type_JavaUtilList = null;
  volatile boolean jdField_b_of_type_Boolean = true;
  private List<File> c = null;
  
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
      return null;
    }
    String str = paramObject.toString();
    paramObject = str;
    if (str.length() > 0) {
      paramObject = SecurityUtile.decode(str);
    }
    return paramObject;
  }
  
  /* Error */
  private List<MigrateSubscribeDB.SubscribeRecentData> a(String paramString)
  {
    // Byte code:
    //   0: new 81	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 82	java/util/ArrayList:<init>	()V
    //   7: astore 12
    //   9: aload_1
    //   10: ifnonnull +19 -> 29
    //   13: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +11 -> 27
    //   19: ldc 90
    //   21: iconst_2
    //   22: ldc 92
    //   24: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aconst_null
    //   28: areturn
    //   29: new 98	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper
    //   32: dup
    //   33: aload_0
    //   34: invokestatic 104	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   37: aload_1
    //   38: bipush 17
    //   40: invokespecial 107	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Landroid/content/Context;Ljava/lang/String;I)V
    //   43: astore 14
    //   45: aload 14
    //   47: invokevirtual 111	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   50: ldc 113
    //   52: aconst_null
    //   53: invokevirtual 119	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   56: astore 15
    //   58: aload 15
    //   60: ifnull +646 -> 706
    //   63: aload 15
    //   65: invokeinterface 124 1 0
    //   70: ifeq +544 -> 614
    //   73: aload 15
    //   75: ldc 126
    //   77: invokeinterface 130 2 0
    //   82: istore_3
    //   83: aload 15
    //   85: ldc 132
    //   87: invokeinterface 130 2 0
    //   92: istore 4
    //   94: aload 15
    //   96: ldc 134
    //   98: invokeinterface 130 2 0
    //   103: istore_2
    //   104: aload 15
    //   106: ldc 136
    //   108: invokeinterface 130 2 0
    //   113: istore 5
    //   115: aload 15
    //   117: ldc 138
    //   119: invokeinterface 130 2 0
    //   124: istore 6
    //   126: aload 15
    //   128: ldc 140
    //   130: invokeinterface 130 2 0
    //   135: istore 7
    //   137: aload 15
    //   139: ldc 142
    //   141: invokeinterface 130 2 0
    //   146: istore 8
    //   148: aload 15
    //   150: ldc 144
    //   152: invokeinterface 130 2 0
    //   157: istore 9
    //   159: aload 15
    //   161: ldc 146
    //   163: invokeinterface 130 2 0
    //   168: istore 10
    //   170: aload 15
    //   172: ldc 148
    //   174: invokeinterface 130 2 0
    //   179: istore 11
    //   181: aload 12
    //   183: astore_1
    //   184: aload_0
    //   185: astore 12
    //   187: new 150	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData
    //   190: dup
    //   191: aload 12
    //   193: aconst_null
    //   194: invokespecial 153	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB$1;)V
    //   197: astore 13
    //   199: aload 13
    //   201: aload 12
    //   203: aload 15
    //   205: iload_3
    //   206: invokeinterface 157 2 0
    //   211: invokespecial 159	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   214: putfield 162	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:d	Ljava/lang/String;
    //   217: aload 13
    //   219: aload 12
    //   221: aload 15
    //   223: iload 4
    //   225: invokeinterface 157 2 0
    //   230: invokespecial 159	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   233: putfield 165	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:e	Ljava/lang/String;
    //   236: aload 13
    //   238: aload 12
    //   240: aload 15
    //   242: iload_2
    //   243: invokeinterface 157 2 0
    //   248: invokespecial 159	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   251: putfield 167	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   254: aload 13
    //   256: aload 15
    //   258: iload 5
    //   260: invokeinterface 171 2 0
    //   265: putfield 173	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_b_of_type_Long	J
    //   268: aload 13
    //   270: aload 15
    //   272: iload 6
    //   274: invokeinterface 171 2 0
    //   279: putfield 174	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_a_of_type_Long	J
    //   282: aload 13
    //   284: aload 15
    //   286: iload 7
    //   288: invokeinterface 171 2 0
    //   293: putfield 176	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_c_of_type_Long	J
    //   296: aload 13
    //   298: aload 12
    //   300: aload 15
    //   302: iload 8
    //   304: invokeinterface 157 2 0
    //   309: invokespecial 159	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   312: putfield 179	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:f	Ljava/lang/String;
    //   315: aload 13
    //   317: aload 12
    //   319: aload 15
    //   321: iload 9
    //   323: invokeinterface 157 2 0
    //   328: invokespecial 159	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   331: putfield 181	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   334: aload 13
    //   336: aload 12
    //   338: aload 15
    //   340: iload 10
    //   342: invokeinterface 157 2 0
    //   347: invokespecial 159	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   350: putfield 183	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   353: aload 13
    //   355: aload 15
    //   357: iload 11
    //   359: invokeinterface 186 2 0
    //   364: putfield 187	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_a_of_type_Int	I
    //   367: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   370: ifeq +216 -> 586
    //   373: new 189	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   380: astore 12
    //   382: aload 12
    //   384: ldc 192
    //   386: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 12
    //   392: aload 13
    //   394: getfield 162	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:d	Ljava/lang/String;
    //   397: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 12
    //   403: ldc 198
    //   405: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 12
    //   411: aload 13
    //   413: getfield 165	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:e	Ljava/lang/String;
    //   416: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload 12
    //   422: ldc 198
    //   424: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload 12
    //   430: aload 13
    //   432: getfield 167	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   435: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: aload 12
    //   441: ldc 198
    //   443: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload 12
    //   449: aload 13
    //   451: getfield 173	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_b_of_type_Long	J
    //   454: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 12
    //   460: ldc 198
    //   462: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload 12
    //   468: aload 13
    //   470: getfield 174	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_a_of_type_Long	J
    //   473: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 12
    //   479: ldc 198
    //   481: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload 12
    //   487: aload 13
    //   489: getfield 176	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_c_of_type_Long	J
    //   492: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 12
    //   498: aload 13
    //   500: getfield 179	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:f	Ljava/lang/String;
    //   503: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: aload 12
    //   509: ldc 198
    //   511: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 12
    //   517: aload 13
    //   519: getfield 181	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   522: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload 12
    //   528: ldc 198
    //   530: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload 12
    //   536: aload 13
    //   538: getfield 183	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   541: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 12
    //   547: ldc 198
    //   549: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload 12
    //   555: aload 13
    //   557: getfield 187	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_a_of_type_Int	I
    //   560: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload 12
    //   566: ldc 206
    //   568: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: ldc 90
    //   574: iconst_2
    //   575: aload 12
    //   577: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   583: goto +3 -> 586
    //   586: aload_1
    //   587: astore 12
    //   589: aload_1
    //   590: aload 13
    //   592: invokeinterface 213 2 0
    //   597: pop
    //   598: aload_1
    //   599: astore 12
    //   601: aload 15
    //   603: invokeinterface 216 1 0
    //   608: ifne +125 -> 733
    //   611: goto +35 -> 646
    //   614: aload 12
    //   616: astore 13
    //   618: aload 13
    //   620: astore_1
    //   621: aload 13
    //   623: astore 12
    //   625: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   628: ifeq +18 -> 646
    //   631: aload 13
    //   633: astore 12
    //   635: ldc 90
    //   637: iconst_2
    //   638: ldc 218
    //   640: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   643: aload 13
    //   645: astore_1
    //   646: aload 15
    //   648: invokeinterface 221 1 0
    //   653: goto +73 -> 726
    //   656: astore 13
    //   658: goto +9 -> 667
    //   661: astore_1
    //   662: goto +35 -> 697
    //   665: astore 13
    //   667: aload 13
    //   669: invokevirtual 224	java/lang/Exception:printStackTrace	()V
    //   672: aload 12
    //   674: astore_1
    //   675: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   678: ifeq -32 -> 646
    //   681: ldc 90
    //   683: iconst_2
    //   684: ldc 226
    //   686: aload 13
    //   688: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   691: aload 12
    //   693: astore_1
    //   694: goto -48 -> 646
    //   697: aload 15
    //   699: invokeinterface 221 1 0
    //   704: aload_1
    //   705: athrow
    //   706: aload 12
    //   708: astore_1
    //   709: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   712: ifeq +14 -> 726
    //   715: ldc 90
    //   717: iconst_2
    //   718: ldc 231
    //   720: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   723: aload 12
    //   725: astore_1
    //   726: aload 14
    //   728: invokevirtual 232	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:close	()V
    //   731: aload_1
    //   732: areturn
    //   733: goto -549 -> 184
    //   736: astore 13
    //   738: aload_1
    //   739: astore 12
    //   741: goto -74 -> 667
    //   744: astore_1
    //   745: goto -78 -> 667
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	748	0	this	MigrateSubscribeDB
    //   0	748	1	paramString	String
    //   103	140	2	i	int
    //   82	124	3	j	int
    //   92	132	4	k	int
    //   113	146	5	m	int
    //   124	149	6	n	int
    //   135	152	7	i1	int
    //   146	157	8	i2	int
    //   157	165	9	i3	int
    //   168	173	10	i4	int
    //   179	179	11	i5	int
    //   7	733	12	localObject1	Object
    //   197	447	13	localObject2	Object
    //   656	1	13	localException1	Exception
    //   665	22	13	localException2	Exception
    //   736	1	13	localException3	Exception
    //   43	684	14	localReadInJoyDBHelper	MigrateSubscribeDB.ReadInJoyDBHelper
    //   56	642	15	localCursor	android.database.Cursor
    // Exception table:
    //   from	to	target	type
    //   589	598	656	java/lang/Exception
    //   601	611	656	java/lang/Exception
    //   625	631	656	java/lang/Exception
    //   635	643	656	java/lang/Exception
    //   63	181	661	finally
    //   187	583	661	finally
    //   589	598	661	finally
    //   601	611	661	finally
    //   625	631	661	finally
    //   635	643	661	finally
    //   667	672	661	finally
    //   675	691	661	finally
    //   63	181	665	java/lang/Exception
    //   187	583	736	java/lang/Exception
  }
  
  /* Error */
  private List<MessageRecord> a(String paramString1, String paramString2, List<MigrateSubscribeDB.SubscribeRecentData> paramList, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +84 -> 87
    //   6: new 189	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   13: astore 22
    //   15: aload 22
    //   17: ldc 237
    //   19: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 22
    //   25: aload_1
    //   26: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 22
    //   32: ldc 239
    //   34: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 22
    //   40: aload_2
    //   41: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 22
    //   47: ldc 241
    //   49: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 22
    //   55: aload_3
    //   56: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 22
    //   62: ldc 246
    //   64: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 22
    //   70: aload 4
    //   72: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: ldc 90
    //   78: iconst_2
    //   79: aload 22
    //   81: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: invokestatic 251	java/lang/System:nanoTime	()J
    //   90: lstore 13
    //   92: new 81	java/util/ArrayList
    //   95: dup
    //   96: invokespecial 82	java/util/ArrayList:<init>	()V
    //   99: astore 24
    //   101: aconst_null
    //   102: astore 23
    //   104: aload_2
    //   105: ifnull +1128 -> 1233
    //   108: aload_3
    //   109: ifnonnull +6 -> 115
    //   112: goto +1121 -> 1233
    //   115: aload_3
    //   116: invokeinterface 254 1 0
    //   121: istore 6
    //   123: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +40 -> 166
    //   129: new 189	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   136: astore 22
    //   138: aload 22
    //   140: ldc_w 256
    //   143: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 22
    //   149: iload 6
    //   151: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: ldc 90
    //   157: iconst_2
    //   158: aload 22
    //   160: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: iconst_0
    //   167: istore 5
    //   169: aload 23
    //   171: astore 22
    //   173: iload 5
    //   175: iload 6
    //   177: if_icmpge +49 -> 226
    //   180: aload_3
    //   181: iload 5
    //   183: invokeinterface 260 2 0
    //   188: checkcast 150	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData
    //   191: getfield 181	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   194: aload_2
    //   195: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   198: ifeq +19 -> 217
    //   201: aload_3
    //   202: iload 5
    //   204: invokeinterface 260 2 0
    //   209: checkcast 150	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData
    //   212: astore 22
    //   214: goto +12 -> 226
    //   217: iload 5
    //   219: iconst_1
    //   220: iadd
    //   221: istore 5
    //   223: goto -54 -> 169
    //   226: aload 22
    //   228: ifnull +13 -> 241
    //   231: aload 22
    //   233: getfield 187	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_a_of_type_Int	I
    //   236: istore 5
    //   238: goto +6 -> 244
    //   241: iconst_0
    //   242: istore 5
    //   244: iload 5
    //   246: ifle +10 -> 256
    //   249: ldc_w 265
    //   252: astore_3
    //   253: goto +7 -> 260
    //   256: ldc_w 267
    //   259: astore_3
    //   260: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +39 -> 302
    //   266: new 189	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   273: astore 22
    //   275: aload 22
    //   277: ldc_w 269
    //   280: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 22
    //   286: aload_3
    //   287: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: ldc 90
    //   293: iconst_2
    //   294: aload 22
    //   296: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: new 98	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper
    //   305: dup
    //   306: aload_0
    //   307: invokestatic 104	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   310: aload_1
    //   311: bipush 80
    //   313: invokespecial 107	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Landroid/content/Context;Ljava/lang/String;I)V
    //   316: astore 22
    //   318: aload 22
    //   320: invokevirtual 111	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   323: astore 23
    //   325: aload 23
    //   327: iconst_0
    //   328: ldc_w 271
    //   331: aconst_null
    //   332: ldc_w 273
    //   335: iconst_1
    //   336: anewarray 67	java/lang/String
    //   339: dup
    //   340: iconst_0
    //   341: aload_2
    //   342: aastore
    //   343: aconst_null
    //   344: aconst_null
    //   345: ldc_w 275
    //   348: aload_3
    //   349: invokevirtual 279	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   352: astore_2
    //   353: aload_2
    //   354: ifnull +788 -> 1142
    //   357: aload_2
    //   358: invokeinterface 124 1 0
    //   363: ifeq +606 -> 969
    //   366: aload_2
    //   367: ldc_w 281
    //   370: invokeinterface 130 2 0
    //   375: istore 11
    //   377: aload_2
    //   378: ldc_w 283
    //   381: invokeinterface 130 2 0
    //   386: istore 10
    //   388: aload_2
    //   389: ldc_w 285
    //   392: invokeinterface 130 2 0
    //   397: istore 9
    //   399: aload_2
    //   400: ldc_w 287
    //   403: invokeinterface 130 2 0
    //   408: istore 7
    //   410: aload_2
    //   411: ldc_w 289
    //   414: invokeinterface 130 2 0
    //   419: istore 6
    //   421: aload_2
    //   422: ldc_w 291
    //   425: invokeinterface 130 2 0
    //   430: istore 8
    //   432: aload_2
    //   433: iload 11
    //   435: invokeinterface 171 2 0
    //   440: lstore 15
    //   442: aload_2
    //   443: iload 10
    //   445: invokeinterface 157 2 0
    //   450: astore 25
    //   452: aload_2
    //   453: iload 9
    //   455: invokeinterface 157 2 0
    //   460: astore_3
    //   461: aload_2
    //   462: iload 7
    //   464: invokeinterface 157 2 0
    //   469: astore_1
    //   470: aload_2
    //   471: iload 6
    //   473: invokeinterface 171 2 0
    //   478: lstore 17
    //   480: aload_2
    //   481: iload 8
    //   483: invokeinterface 171 2 0
    //   488: lstore 19
    //   490: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   493: ifeq +761 -> 1254
    //   496: new 189	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   503: astore 26
    //   505: aload 26
    //   507: ldc_w 293
    //   510: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload 26
    //   516: lload 15
    //   518: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: aload 26
    //   524: ldc 198
    //   526: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload 26
    //   532: aload 25
    //   534: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload 26
    //   540: ldc 198
    //   542: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: aload 26
    //   548: aload_3
    //   549: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload 26
    //   555: ldc 198
    //   557: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload 26
    //   563: aload_1
    //   564: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: aload 26
    //   570: ldc 198
    //   572: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: pop
    //   576: aload 26
    //   578: lload 17
    //   580: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload 26
    //   586: ldc 198
    //   588: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload 26
    //   594: lload 19
    //   596: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload 26
    //   602: ldc 206
    //   604: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: ldc 90
    //   610: iconst_2
    //   611: aload 26
    //   613: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   619: goto +3 -> 622
    //   622: aload 25
    //   624: invokestatic 297	com/tencent/biz/pubaccount/subscript/SubscriptUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   627: astore_3
    //   628: aload_3
    //   629: invokestatic 303	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   632: ifne +275 -> 907
    //   635: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   638: ifeq +56 -> 694
    //   641: new 189	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   648: astore 26
    //   650: aload 26
    //   652: ldc_w 305
    //   655: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: aload 26
    //   661: aload 25
    //   663: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: aload 26
    //   669: ldc_w 307
    //   672: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: aload 26
    //   678: aload_3
    //   679: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: ldc 90
    //   685: iconst_2
    //   686: aload 26
    //   688: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   694: ldc_w 309
    //   697: invokestatic 315	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   700: checkcast 309	com/tencent/biz/pubaccount/util/api/IPublicAccountMessageUtil
    //   703: aload_1
    //   704: invokeinterface 319 2 0
    //   709: checkcast 321	com/tencent/mobileqq/data/PAMessage
    //   712: astore 26
    //   714: aload 26
    //   716: ifnull +173 -> 889
    //   719: sipush -3006
    //   722: invokestatic 326	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   725: checkcast 328	com/tencent/mobileqq/data/MessageForPubAccount
    //   728: astore 25
    //   730: aload 25
    //   732: sipush -3006
    //   735: putfield 331	com/tencent/mobileqq/data/MessageForPubAccount:msgtype	I
    //   738: aload 25
    //   740: sipush 1008
    //   743: putfield 334	com/tencent/mobileqq/data/MessageForPubAccount:istroop	I
    //   746: aload 25
    //   748: aload_1
    //   749: putfield 337	com/tencent/mobileqq/data/MessageForPubAccount:msg	Ljava/lang/String;
    //   752: aload 25
    //   754: aload 26
    //   756: putfield 341	com/tencent/mobileqq/data/MessageForPubAccount:mPAMessage	Lcom/tencent/mobileqq/data/PAMessage;
    //   759: goto +8 -> 767
    //   762: astore_1
    //   763: aload_1
    //   764: invokevirtual 224	java/lang/Exception:printStackTrace	()V
    //   767: aload 25
    //   769: ldc_w 309
    //   772: invokestatic 315	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   775: checkcast 309	com/tencent/biz/pubaccount/util/api/IPublicAccountMessageUtil
    //   778: aload 26
    //   780: invokeinterface 345 2 0
    //   785: putfield 349	com/tencent/mobileqq/data/MessageForPubAccount:msgData	[B
    //   788: goto +8 -> 796
    //   791: astore_1
    //   792: aload_1
    //   793: invokevirtual 224	java/lang/Exception:printStackTrace	()V
    //   796: aload 25
    //   798: aload_3
    //   799: putfield 352	com/tencent/mobileqq/data/MessageForPubAccount:frienduin	Ljava/lang/String;
    //   802: aload 25
    //   804: aload_3
    //   805: putfield 355	com/tencent/mobileqq/data/MessageForPubAccount:senderuin	Ljava/lang/String;
    //   808: aload 25
    //   810: aload 4
    //   812: putfield 358	com/tencent/mobileqq/data/MessageForPubAccount:selfuin	Ljava/lang/String;
    //   815: aload 25
    //   817: lload 17
    //   819: putfield 361	com/tencent/mobileqq/data/MessageForPubAccount:time	J
    //   822: aload 25
    //   824: lload 17
    //   826: putfield 364	com/tencent/mobileqq/data/MessageForPubAccount:msgseq	J
    //   829: aload 25
    //   831: aload_0
    //   832: invokespecial 366	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	()I
    //   835: i2l
    //   836: putfield 369	com/tencent/mobileqq/data/MessageForPubAccount:shmsgseq	J
    //   839: aload 25
    //   841: aload_0
    //   842: invokespecial 371	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	()J
    //   845: putfield 374	com/tencent/mobileqq/data/MessageForPubAccount:msgUid	J
    //   848: iload 5
    //   850: iconst_1
    //   851: isub
    //   852: istore 12
    //   854: iload 5
    //   856: ifle +401 -> 1257
    //   859: iconst_0
    //   860: istore 21
    //   862: goto +3 -> 865
    //   865: aload 25
    //   867: iload 21
    //   869: putfield 377	com/tencent/mobileqq/data/MessageForPubAccount:isread	Z
    //   872: aload 24
    //   874: aload 25
    //   876: invokeinterface 213 2 0
    //   881: pop
    //   882: iload 12
    //   884: istore 5
    //   886: goto +71 -> 957
    //   889: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   892: ifeq +371 -> 1263
    //   895: ldc 90
    //   897: iconst_2
    //   898: ldc_w 379
    //   901: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   904: goto +359 -> 1263
    //   907: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   910: ifeq +353 -> 1263
    //   913: new 189	java/lang/StringBuilder
    //   916: dup
    //   917: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   920: astore_1
    //   921: aload_1
    //   922: ldc_w 381
    //   925: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: aload_1
    //   930: aload 25
    //   932: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: pop
    //   936: aload_1
    //   937: ldc_w 383
    //   940: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: pop
    //   944: ldc 90
    //   946: iconst_2
    //   947: aload_1
    //   948: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   951: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   954: goto +309 -> 1263
    //   957: aload_2
    //   958: invokeinterface 216 1 0
    //   963: ifne +303 -> 1266
    //   966: goto +18 -> 984
    //   969: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   972: ifeq +12 -> 984
    //   975: ldc 90
    //   977: iconst_2
    //   978: ldc_w 385
    //   981: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   984: aload_2
    //   985: invokeinterface 221 1 0
    //   990: goto +35 -> 1025
    //   993: astore_1
    //   994: goto +8 -> 1002
    //   997: astore_1
    //   998: goto +136 -> 1134
    //   1001: astore_1
    //   1002: aload_1
    //   1003: invokevirtual 224	java/lang/Exception:printStackTrace	()V
    //   1006: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1009: ifeq -25 -> 984
    //   1012: ldc 90
    //   1014: iconst_2
    //   1015: ldc_w 387
    //   1018: aload_1
    //   1019: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1022: goto -38 -> 984
    //   1025: aload 24
    //   1027: invokeinterface 254 1 0
    //   1032: ifle +125 -> 1157
    //   1035: iconst_0
    //   1036: istore 5
    //   1038: iload 5
    //   1040: aload 24
    //   1042: invokeinterface 254 1 0
    //   1047: iconst_1
    //   1048: isub
    //   1049: if_icmpge +108 -> 1157
    //   1052: aload 24
    //   1054: invokeinterface 254 1 0
    //   1059: iconst_1
    //   1060: isub
    //   1061: istore 6
    //   1063: iload 6
    //   1065: iload 5
    //   1067: if_icmple +58 -> 1125
    //   1070: aload 24
    //   1072: iload 6
    //   1074: invokeinterface 260 2 0
    //   1079: checkcast 389	com/tencent/mobileqq/data/MessageRecord
    //   1082: getfield 390	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   1085: aload 24
    //   1087: iload 5
    //   1089: invokeinterface 260 2 0
    //   1094: checkcast 389	com/tencent/mobileqq/data/MessageRecord
    //   1097: getfield 390	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   1100: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1103: ifeq +13 -> 1116
    //   1106: aload 24
    //   1108: iload 6
    //   1110: invokeinterface 393 2 0
    //   1115: pop
    //   1116: iload 6
    //   1118: iconst_1
    //   1119: isub
    //   1120: istore 6
    //   1122: goto -59 -> 1063
    //   1125: iload 5
    //   1127: iconst_1
    //   1128: iadd
    //   1129: istore 5
    //   1131: goto -93 -> 1038
    //   1134: aload_2
    //   1135: invokeinterface 221 1 0
    //   1140: aload_1
    //   1141: athrow
    //   1142: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1145: ifeq +12 -> 1157
    //   1148: ldc 90
    //   1150: iconst_2
    //   1151: ldc_w 395
    //   1154: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1157: aload 22
    //   1159: invokevirtual 232	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:close	()V
    //   1162: aload 23
    //   1164: ifnull +11 -> 1175
    //   1167: aload 23
    //   1169: invokevirtual 396	android/database/sqlite/SQLiteDatabase:close	()V
    //   1172: goto +3 -> 1175
    //   1175: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1178: ifeq +52 -> 1230
    //   1181: new 189	java/lang/StringBuilder
    //   1184: dup
    //   1185: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   1188: astore_1
    //   1189: aload_1
    //   1190: ldc_w 398
    //   1193: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: pop
    //   1197: aload_1
    //   1198: invokestatic 251	java/lang/System:nanoTime	()J
    //   1201: lload 13
    //   1203: lsub
    //   1204: ldc2_w 399
    //   1207: ldiv
    //   1208: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1211: pop
    //   1212: aload_1
    //   1213: ldc_w 402
    //   1216: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: pop
    //   1220: ldc 90
    //   1222: iconst_2
    //   1223: aload_1
    //   1224: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1227: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1230: aload 24
    //   1232: areturn
    //   1233: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1236: ifeq +12 -> 1248
    //   1239: ldc 90
    //   1241: iconst_2
    //   1242: ldc_w 404
    //   1245: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1248: aconst_null
    //   1249: areturn
    //   1250: astore_1
    //   1251: goto -76 -> 1175
    //   1254: goto -632 -> 622
    //   1257: iconst_1
    //   1258: istore 21
    //   1260: goto -395 -> 865
    //   1263: goto -306 -> 957
    //   1266: goto -834 -> 432
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1269	0	this	MigrateSubscribeDB
    //   0	1269	1	paramString1	String
    //   0	1269	2	paramString2	String
    //   0	1269	3	paramList	List<MigrateSubscribeDB.SubscribeRecentData>
    //   0	1269	4	paramString3	String
    //   167	963	5	i	int
    //   121	1000	6	j	int
    //   408	55	7	k	int
    //   430	52	8	m	int
    //   397	57	9	n	int
    //   386	58	10	i1	int
    //   375	59	11	i2	int
    //   852	31	12	i3	int
    //   90	1112	13	l1	long
    //   440	77	15	l2	long
    //   478	347	17	l3	long
    //   488	107	19	l4	long
    //   860	399	21	bool	boolean
    //   13	1145	22	localObject1	Object
    //   102	1066	23	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   99	1132	24	localArrayList	ArrayList
    //   450	481	25	localObject2	Object
    //   503	276	26	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   752	759	762	java/lang/Exception
    //   767	788	791	java/lang/Exception
    //   432	619	993	java/lang/Exception
    //   622	694	993	java/lang/Exception
    //   694	714	993	java/lang/Exception
    //   719	752	993	java/lang/Exception
    //   763	767	993	java/lang/Exception
    //   792	796	993	java/lang/Exception
    //   796	848	993	java/lang/Exception
    //   865	882	993	java/lang/Exception
    //   889	904	993	java/lang/Exception
    //   907	954	993	java/lang/Exception
    //   957	966	993	java/lang/Exception
    //   969	984	993	java/lang/Exception
    //   357	432	997	finally
    //   432	619	997	finally
    //   622	694	997	finally
    //   694	714	997	finally
    //   719	752	997	finally
    //   752	759	997	finally
    //   763	767	997	finally
    //   767	788	997	finally
    //   792	796	997	finally
    //   796	848	997	finally
    //   865	882	997	finally
    //   889	904	997	finally
    //   907	954	997	finally
    //   957	966	997	finally
    //   969	984	997	finally
    //   1002	1022	997	finally
    //   357	432	1001	java/lang/Exception
    //   1167	1172	1250	java/lang/Exception
  }
  
  private List<String> a(List<MigrateSubscribeDB.SubscribeRecentData> paramList, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      String str = ((MigrateSubscribeDB.SubscribeRecentData)paramList.get(i)).jdField_a_of_type_JavaLangString;
      int j = 0;
      while (j < paramArrayOfString.length)
      {
        if (paramArrayOfString[j].equals(str))
        {
          localArrayList.add(str);
          break;
        }
        j += 1;
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
      localObject1 = BaseApplicationImpl.getApplication().getAllAccounts();
      if (localObject1 == null) {}
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject3 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime().getAccount();
        HashMap localHashMap = new HashMap(this.jdField_a_of_type_JavaUtilList.size());
        Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        Object localObject4;
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = (File)((Iterator)localObject2).next();
          if (localObject4 == null) {
            continue;
          }
          localHashMap.put(((File)localObject4).getName().replace(".db", ""), localObject4);
          continue;
        }
        localObject2 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("sorMainDbFiles currentUin: ");
          ((StringBuilder)localObject4).append((String)localObject3);
          QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject4).toString());
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = (File)localHashMap.remove(localObject3);
          if (localObject3 != null) {
            ((List)localObject2).add(localObject3);
          }
        }
        int j = ((List)localObject1).size();
        i = 0;
        if (i < j)
        {
          localObject3 = (SimpleAccount)((List)localObject1).get(i);
          if ((localObject3 == null) || (((SimpleAccount)localObject3).getUin() == null)) {
            break label449;
          }
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("sorMainDbFiles uin: ");
            ((StringBuilder)localObject4).append(((SimpleAccount)localObject3).getUin());
            QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject4).toString());
          }
          localObject3 = (File)localHashMap.remove(((SimpleAccount)localObject3).getUin());
          if (localObject3 == null) {
            break label449;
          }
          ((List)localObject2).add(localObject3);
          break label449;
        }
        localObject1 = localHashMap.values().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          ((List)localObject2).add((File)((Iterator)localObject1).next());
          continue;
        }
        this.jdField_a_of_type_JavaUtilList = ((List)localObject2);
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break label448;
        }
      }
      QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles error", localException);
      return;
      if (QLog.isColorLevel())
      {
        QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles no account login");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles mUinMainDBFiles is empty");
        }
      }
      label448:
      return;
      label449:
      i += 1;
    }
  }
  
  private void a(String paramString)
  {
    long l = System.nanoTime();
    Object localObject1 = BaseApplicationImpl.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("readinjoy_");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(1);
    localObject2 = ((StringBuilder)localObject2).toString();
    int j = 0;
    int k = ((BaseApplicationImpl)localObject1).getSharedPreferences((String)localObject2, 0).getInt("updated_msg_count", 0);
    if (k == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount readInJoyUnreadCount == 0");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateFolderUnReadCount readinjoy new unread count: ");
      ((StringBuilder)localObject1).append(k);
      QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject1).toString());
    }
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences(paramString, 0);
    localObject2 = paramString.getString("troopbar_assist_new_unread_list", "");
    if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateFolderUnReadCount, get troopbar new unread list ( newMsgStr ): ");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.i("MigrateSubscribeDB", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new ConcurrentHashMap();
    for (;;)
    {
      int i;
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        i = j;
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("updateFolderUnReadCount jsonArray length: ");
          ((StringBuilder)localObject3).append(((JSONArray)localObject2).length());
          QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject3).toString());
          i = j;
        }
        Object localObject4;
        String str;
        if (i < ((JSONArray)localObject2).length())
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(i);
          localObject4 = ((JSONObject)localObject3).keys();
          if (!((Iterator)localObject4).hasNext()) {
            break label760;
          }
          str = (String)((Iterator)localObject4).next();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateFolderUnReadCount newMsgMap put key: ");
            localStringBuilder.append(str);
            localStringBuilder.append(" | value: ");
            localStringBuilder.append(((JSONObject)localObject3).getInt(str));
            QLog.d("MigrateSubscribeDB", 2, localStringBuilder.toString());
          }
          ((ConcurrentHashMap)localObject1).put(str, Integer.valueOf(((JSONObject)localObject3).getInt(str)));
          continue;
        }
        ((ConcurrentHashMap)localObject1).put(AppConstants.READINJOY_UIN, Integer.valueOf(k));
        localObject2 = ((ConcurrentHashMap)localObject1).keySet().iterator();
        Object localObject3 = new JSONArray();
        if (((Iterator)localObject2).hasNext())
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
          continue;
        }
        localObject1 = ((JSONArray)localObject3).toString();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateFolderUnReadCount save newMsgStr into sp:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject2).toString());
        }
        paramString = paramString.edit();
        paramString.putString("troopbar_assist_new_unread_list", (String)localObject1);
        paramString.commit();
        if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("updateFolderUnReadCount, put troopbar new list ( newMsgStr ): ");
          paramString.append((String)localObject1);
          QLog.i("MigrateSubscribeDB", 2, paramString.toString());
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("updateFolderUnReadCount:");
          ((StringBuilder)localObject1).append(paramString.toString());
          QLog.e("MigrateSubscribeDB", 2, ((StringBuilder)localObject1).toString(), paramString);
        }
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("updateFolderUnReadCount total cost = ");
        paramString.append((System.nanoTime() - l) / 1000000L);
        paramString.append(" ms ");
        QLog.d("MigrateSubscribeDB", 2, paramString.toString());
      }
      return;
      label760:
      i += 1;
    }
  }
  
  private void a(String paramString1, String paramString2, String[] paramArrayOfString, List<MigrateSubscribeDB.SubscribeRecentData> paramList, EntityManager paramEntityManager)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MigrateAllToMessageRecord  fileName is : ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("uinStr : ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject).toString());
    }
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Migrate subscribe subscribeMsgIDs size: ");
        ((StringBuilder)localObject).append(j);
        QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject).toString());
      }
      int i = 0;
      while (i < j)
      {
        localObject = a(paramString1, paramArrayOfString[i], paramList, paramString2);
        a(paramArrayOfString[i], paramList, (List)localObject);
        c((List)localObject, paramEntityManager);
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "Migrate subscribe subscribeMsgIDs is null");
    }
  }
  
  private void a(String paramString, List<MigrateSubscribeDB.SubscribeRecentData> paramList, List<MessageRecord> paramList1)
  {
    if ((paramString != null) && (paramList != null) && (paramList1 != null) && (paramList1.size() > 0))
    {
      long l = ((MessageRecord)paramList1.get(paramList1.size() - 1)).time;
      int j = paramList.size();
      if (QLog.isColorLevel())
      {
        paramList1 = new StringBuilder();
        paramList1.append("updateSubscribeRecentDataList subscribeRecentDataList size: ");
        paramList1.append(j);
        QLog.d("MigrateSubscribeDB", 2, paramList1.toString());
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
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "updateSubscribeRecentDataList subscribleID is null or subscribeRecentDataList is null or subscribeMsgList is null");
    }
  }
  
  private void a(List<MigrateSubscribeDB.SubscribeRecentData> paramList, EntityManager paramEntityManager)
  {
    long l = System.nanoTime();
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar fail subscribeRecentDataList is null");
      }
      return;
    }
    int j = paramList.size();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("migrateToTroopBar subscribeRecentDataList list size: ");
      ((StringBuilder)localObject1).append(j);
      QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject1).toString());
    }
    int i = 0;
    while (i < j)
    {
      localObject1 = (MigrateSubscribeDB.SubscribeRecentData)paramList.get(i);
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("migrateToTroopBar subscribeRecentData: ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject3 = SubscriptUtil.a(((MigrateSubscribeDB.SubscribeRecentData)localObject1).jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject2 = new TroopBarData();
        ((TroopBarData)localObject2).mUin = ((String)localObject3);
        ((TroopBarData)localObject2).mLastMsgTime = ((MigrateSubscribeDB.SubscribeRecentData)localObject1).jdField_c_of_type_Long;
        ((TroopBarData)localObject2).mLastDraftTime = 0L;
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("migrateToTroopBar subscribeid[");
          ((StringBuilder)localObject3).append(((MigrateSubscribeDB.SubscribeRecentData)localObject1).jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject3).append("] create new TroopBarData: ");
          ((StringBuilder)localObject3).append(localObject2);
          QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject3).toString());
        }
        paramEntityManager.persistOrReplace((Entity)localObject2);
      }
      else if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("migrateToTroopBar we can't subscribeid[");
        ((StringBuilder)localObject2).append(((MigrateSubscribeDB.SubscribeRecentData)localObject1).jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append("]'s uin");
        QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject2).toString());
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("migrateToTroopBar total cost = ");
      paramList.append((System.nanoTime() - l) / 1000000L);
      paramList.append(" ms ");
      QLog.d("MigrateSubscribeDB", 2, paramList.toString());
    }
  }
  
  public static boolean a()
  {
    boolean bool1 = jdField_a_of_type_Boolean;
    boolean bool2 = false;
    Object localObject;
    if (!bool1)
    {
      localObject = BaseApplicationImpl.sApplication.getSharedPreferences("contact_bind_info_global", 0).getString("last_phone_version_popped", "");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNeedUpdate oldVersion: ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" : curVersion: ");
        localStringBuilder.append("8.7.0");
        QLog.d("MigrateSubscribeDB", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (((String)localObject).startsWith("5.7"))
        {
          bool1 = true;
        }
        else
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate oldVersion isn't start with 5.7");
            bool1 = bool2;
          }
        }
      }
      else
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate oldVersion is empty");
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate no need run again");
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedUpdate isNeed: ");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  /* Error */
  private boolean a(File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +20 -> 21
    //   4: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 90
    //   12: iconst_2
    //   13: ldc_w 703
    //   16: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: iconst_0
    //   20: ireturn
    //   21: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +42 -> 66
    //   27: new 189	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   34: astore 7
    //   36: aload 7
    //   38: ldc_w 705
    //   41: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 7
    //   47: aload_1
    //   48: invokevirtual 708	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: ldc 90
    //   57: iconst_2
    //   58: aload 7
    //   60: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: invokestatic 251	java/lang/System:nanoTime	()J
    //   69: lstore 4
    //   71: aload_1
    //   72: invokevirtual 453	java/io/File:getName	()Ljava/lang/String;
    //   75: astore 7
    //   77: aconst_null
    //   78: astore 8
    //   80: aconst_null
    //   81: astore 11
    //   83: aload_0
    //   84: getfield 25	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   87: invokeinterface 409 1 0
    //   92: ifne +1563 -> 1655
    //   95: aload_0
    //   96: getfield 27	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	Ljava/util/List;
    //   99: invokeinterface 409 1 0
    //   104: ifeq +6 -> 110
    //   107: goto +1548 -> 1655
    //   110: aload 7
    //   112: ldc_w 455
    //   115: ldc_w 457
    //   118: invokevirtual 461	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   121: invokestatic 714	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   124: invokestatic 717	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   127: astore 14
    //   129: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +40 -> 172
    //   135: new 189	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   142: astore 7
    //   144: aload 7
    //   146: ldc_w 719
    //   149: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 7
    //   155: aload 14
    //   157: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: ldc 90
    //   163: iconst_2
    //   164: aload 7
    //   166: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_0
    //   173: getfield 25	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   176: invokeinterface 409 1 0
    //   181: istore 6
    //   183: iload 6
    //   185: ifne +209 -> 394
    //   188: aload_0
    //   189: getfield 25	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   192: invokeinterface 439 1 0
    //   197: astore 9
    //   199: aload 9
    //   201: invokeinterface 444 1 0
    //   206: ifeq +1640 -> 1846
    //   209: aload 9
    //   211: invokeinterface 448 1 0
    //   216: checkcast 450	java/io/File
    //   219: invokevirtual 453	java/io/File:getName	()Ljava/lang/String;
    //   222: astore 7
    //   224: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +40 -> 267
    //   230: new 189	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   237: astore 10
    //   239: aload 10
    //   241: ldc_w 721
    //   244: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 10
    //   250: aload 7
    //   252: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: ldc 90
    //   258: iconst_2
    //   259: aload 10
    //   261: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: aload 7
    //   269: aload 14
    //   271: invokevirtual 724	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   274: ifeq +57 -> 331
    //   277: aload 7
    //   279: astore 10
    //   281: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   284: ifeq +128 -> 412
    //   287: new 189	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   294: astore 9
    //   296: aload 9
    //   298: ldc_w 726
    //   301: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 9
    //   307: aload 7
    //   309: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: ldc 90
    //   315: iconst_2
    //   316: aload 9
    //   318: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload 7
    //   326: astore 10
    //   328: goto +84 -> 412
    //   331: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   334: ifeq -135 -> 199
    //   337: new 189	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   344: astore 10
    //   346: aload 10
    //   348: ldc_w 728
    //   351: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload 10
    //   357: aload 7
    //   359: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload 10
    //   365: ldc_w 730
    //   368: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 10
    //   374: aload 14
    //   376: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: ldc 90
    //   382: iconst_2
    //   383: aload 10
    //   385: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: goto -192 -> 199
    //   394: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +1449 -> 1846
    //   400: ldc 90
    //   402: iconst_2
    //   403: ldc_w 732
    //   406: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: goto +1437 -> 1846
    //   412: aload_0
    //   413: getfield 27	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	Ljava/util/List;
    //   416: invokeinterface 409 1 0
    //   421: ifne +209 -> 630
    //   424: aload_0
    //   425: getfield 27	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	Ljava/util/List;
    //   428: invokeinterface 439 1 0
    //   433: astore 9
    //   435: aload 9
    //   437: invokeinterface 444 1 0
    //   442: ifeq +1410 -> 1852
    //   445: aload 9
    //   447: invokeinterface 448 1 0
    //   452: checkcast 450	java/io/File
    //   455: invokevirtual 453	java/io/File:getName	()Ljava/lang/String;
    //   458: astore 7
    //   460: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   463: ifeq +40 -> 503
    //   466: new 189	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   473: astore 12
    //   475: aload 12
    //   477: ldc_w 734
    //   480: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 12
    //   486: aload 7
    //   488: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: ldc 90
    //   494: iconst_2
    //   495: aload 12
    //   497: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   503: aload 7
    //   505: aload 14
    //   507: invokevirtual 724	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   510: ifeq +57 -> 567
    //   513: aload 7
    //   515: astore 12
    //   517: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   520: ifeq +128 -> 648
    //   523: new 189	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   530: astore 9
    //   532: aload 9
    //   534: ldc_w 736
    //   537: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 9
    //   543: aload 7
    //   545: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: ldc 90
    //   551: iconst_2
    //   552: aload 9
    //   554: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: aload 7
    //   562: astore 12
    //   564: goto +84 -> 648
    //   567: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq -135 -> 435
    //   573: new 189	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   580: astore 12
    //   582: aload 12
    //   584: ldc_w 738
    //   587: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload 12
    //   593: aload 7
    //   595: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload 12
    //   601: ldc_w 730
    //   604: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload 12
    //   610: aload 14
    //   612: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: ldc 90
    //   618: iconst_2
    //   619: aload 12
    //   621: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   627: goto -192 -> 435
    //   630: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   633: ifeq +1219 -> 1852
    //   636: ldc 90
    //   638: iconst_2
    //   639: ldc_w 740
    //   642: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   645: goto +1207 -> 1852
    //   648: aload 12
    //   650: ifnonnull +20 -> 670
    //   653: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   656: ifeq +1202 -> 1858
    //   659: ldc 90
    //   661: iconst_2
    //   662: ldc_w 742
    //   665: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   668: iconst_1
    //   669: ireturn
    //   670: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   673: ifeq +57 -> 730
    //   676: new 189	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   683: astore 7
    //   685: aload 7
    //   687: ldc_w 744
    //   690: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: aload 7
    //   696: aload 10
    //   698: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: aload 7
    //   704: ldc_w 746
    //   707: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: pop
    //   711: aload 7
    //   713: aload 12
    //   715: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: ldc 90
    //   721: iconst_2
    //   722: aload 7
    //   724: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   730: aload 14
    //   732: invokestatic 751	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   735: astore 9
    //   737: aload 9
    //   739: invokevirtual 757	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   742: astore 7
    //   744: aload 7
    //   746: invokevirtual 761	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   749: astore 13
    //   751: aload 9
    //   753: aload 14
    //   755: invokevirtual 765	com/tencent/mobileqq/persistence/EntityManagerFactory:build	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   758: invokevirtual 771	com/tencent/mobileqq/app/SQLiteOpenHelper:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   761: astore 11
    //   763: aload_0
    //   764: getfield 31	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_Boolean	Z
    //   767: istore 6
    //   769: iload 6
    //   771: ifne +90 -> 861
    //   774: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   777: ifeq +36 -> 813
    //   780: new 189	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   787: astore_1
    //   788: aload_1
    //   789: ldc_w 773
    //   792: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: aload_1
    //   797: aload 14
    //   799: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: ldc 90
    //   805: iconst_2
    //   806: aload_1
    //   807: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   810: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   813: aload 11
    //   815: ifnull +8 -> 823
    //   818: aload 11
    //   820: invokevirtual 776	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   823: aload 7
    //   825: ifnull +8 -> 833
    //   828: aload 7
    //   830: invokevirtual 777	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   833: aload 9
    //   835: ifnull +8 -> 843
    //   838: aload 9
    //   840: invokevirtual 778	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   843: iconst_0
    //   844: ireturn
    //   845: astore_1
    //   846: aload 11
    //   848: astore 8
    //   850: goto +958 -> 1808
    //   853: astore_1
    //   854: aload 11
    //   856: astore 8
    //   858: goto +784 -> 1642
    //   861: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   864: istore 6
    //   866: iload 6
    //   868: ifeq +90 -> 958
    //   871: new 189	java/lang/StringBuilder
    //   874: dup
    //   875: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   878: astore 8
    //   880: aload 8
    //   882: ldc_w 780
    //   885: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: pop
    //   889: aload 8
    //   891: aload 14
    //   893: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload 8
    //   899: ldc_w 782
    //   902: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: pop
    //   906: aload 8
    //   908: aload_1
    //   909: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   912: pop
    //   913: aload 8
    //   915: ldc_w 784
    //   918: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload 8
    //   924: aload 10
    //   926: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: pop
    //   930: aload 8
    //   932: ldc_w 786
    //   935: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: pop
    //   939: aload 8
    //   941: aload 12
    //   943: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: pop
    //   947: ldc 90
    //   949: iconst_2
    //   950: aload 8
    //   952: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   955: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   958: aload 13
    //   960: invokevirtual 791	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   963: aload 7
    //   965: astore_1
    //   966: aload 7
    //   968: astore 8
    //   970: aload_0
    //   971: aload 12
    //   973: invokespecial 793	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)Ljava/util/List;
    //   976: astore 12
    //   978: aload 7
    //   980: astore_1
    //   981: aload 7
    //   983: astore 8
    //   985: aload_0
    //   986: aload 12
    //   988: aload 7
    //   990: invokespecial 795	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:b	(Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   993: aload 7
    //   995: astore_1
    //   996: aload 7
    //   998: astore 8
    //   1000: aload_0
    //   1001: aload 14
    //   1003: invokespecial 797	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)V
    //   1006: aload 10
    //   1008: ifnull +62 -> 1070
    //   1011: aload 7
    //   1013: astore_1
    //   1014: aload 7
    //   1016: astore 8
    //   1018: aload_0
    //   1019: aload 10
    //   1021: invokespecial 800	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1024: astore 15
    //   1026: aload_0
    //   1027: aload 10
    //   1029: aload 14
    //   1031: aload 15
    //   1033: aload 12
    //   1035: aload 7
    //   1037: invokespecial 802	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1040: aload 7
    //   1042: astore_1
    //   1043: goto +385 -> 1428
    //   1046: astore 8
    //   1048: aload 7
    //   1050: astore_1
    //   1051: aload 8
    //   1053: astore 7
    //   1055: goto +501 -> 1556
    //   1058: astore 8
    //   1060: aload 7
    //   1062: astore_1
    //   1063: aload 8
    //   1065: astore 7
    //   1067: goto +413 -> 1480
    //   1070: aload 7
    //   1072: astore_1
    //   1073: aload 7
    //   1075: astore 8
    //   1077: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1080: ifeq +19 -> 1099
    //   1083: aload 7
    //   1085: astore_1
    //   1086: aload 7
    //   1088: astore 8
    //   1090: ldc 90
    //   1092: iconst_2
    //   1093: ldc_w 804
    //   1096: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1099: aload 7
    //   1101: astore 10
    //   1103: aload 7
    //   1105: astore_1
    //   1106: aload 7
    //   1108: astore 8
    //   1110: aload_0
    //   1111: getfield 25	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   1114: invokeinterface 409 1 0
    //   1119: ifne +306 -> 1425
    //   1122: aload 7
    //   1124: astore_1
    //   1125: aload 7
    //   1127: astore 8
    //   1129: aload_0
    //   1130: getfield 25	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   1133: invokeinterface 439 1 0
    //   1138: astore 15
    //   1140: aload 7
    //   1142: astore 10
    //   1144: aload 7
    //   1146: astore_1
    //   1147: aload 7
    //   1149: astore 8
    //   1151: aload 15
    //   1153: invokeinterface 444 1 0
    //   1158: ifeq +267 -> 1425
    //   1161: aload 7
    //   1163: astore_1
    //   1164: aload 7
    //   1166: astore 8
    //   1168: aload 15
    //   1170: invokeinterface 448 1 0
    //   1175: checkcast 450	java/io/File
    //   1178: invokevirtual 453	java/io/File:getName	()Ljava/lang/String;
    //   1181: astore 10
    //   1183: aload 7
    //   1185: astore_1
    //   1186: aload 7
    //   1188: astore 8
    //   1190: aload_0
    //   1191: aload 10
    //   1193: invokespecial 800	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1196: astore 16
    //   1198: aload 16
    //   1200: ifnull +222 -> 1422
    //   1203: aload 7
    //   1205: astore_1
    //   1206: aload 7
    //   1208: astore 8
    //   1210: aload_0
    //   1211: aload 12
    //   1213: aload 16
    //   1215: invokespecial 806	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/util/List;[Ljava/lang/String;)Ljava/util/List;
    //   1218: invokeinterface 254 1 0
    //   1223: istore_3
    //   1224: iload_3
    //   1225: ifne +6 -> 1231
    //   1228: goto -88 -> 1140
    //   1231: aload 7
    //   1233: astore_1
    //   1234: aload 7
    //   1236: astore 8
    //   1238: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1241: ifeq +99 -> 1340
    //   1244: aload 7
    //   1246: astore_1
    //   1247: aload 7
    //   1249: astore 8
    //   1251: new 189	java/lang/StringBuilder
    //   1254: dup
    //   1255: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   1258: astore 16
    //   1260: aload 7
    //   1262: astore_1
    //   1263: aload 7
    //   1265: astore 8
    //   1267: aload 16
    //   1269: ldc_w 808
    //   1272: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: pop
    //   1276: aload 7
    //   1278: astore_1
    //   1279: aload 7
    //   1281: astore 8
    //   1283: aload 16
    //   1285: aload 14
    //   1287: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: pop
    //   1291: aload 7
    //   1293: astore_1
    //   1294: aload 7
    //   1296: astore 8
    //   1298: aload 16
    //   1300: ldc_w 810
    //   1303: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: pop
    //   1307: aload 7
    //   1309: astore_1
    //   1310: aload 7
    //   1312: astore 8
    //   1314: aload 16
    //   1316: aload 10
    //   1318: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1321: pop
    //   1322: aload 7
    //   1324: astore_1
    //   1325: aload 7
    //   1327: astore 8
    //   1329: ldc 90
    //   1331: iconst_2
    //   1332: aload 16
    //   1334: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1337: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1340: aload 7
    //   1342: astore_1
    //   1343: aload 7
    //   1345: astore 8
    //   1347: iload_3
    //   1348: anewarray 67	java/lang/String
    //   1351: astore 16
    //   1353: iconst_0
    //   1354: istore_2
    //   1355: iload_2
    //   1356: iload_3
    //   1357: if_icmpge +35 -> 1392
    //   1360: aload 7
    //   1362: astore_1
    //   1363: aload 7
    //   1365: astore 8
    //   1367: aload 16
    //   1369: iload_2
    //   1370: aload 12
    //   1372: iload_2
    //   1373: invokeinterface 260 2 0
    //   1378: checkcast 150	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData
    //   1381: getfield 181	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1384: aastore
    //   1385: iload_2
    //   1386: iconst_1
    //   1387: iadd
    //   1388: istore_2
    //   1389: goto -34 -> 1355
    //   1392: aload 7
    //   1394: astore_1
    //   1395: aload_0
    //   1396: aload 10
    //   1398: aload 14
    //   1400: aload 16
    //   1402: aload 12
    //   1404: aload 7
    //   1406: invokespecial 802	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1409: goto +13 -> 1422
    //   1412: astore 7
    //   1414: goto +142 -> 1556
    //   1417: astore 7
    //   1419: goto +61 -> 1480
    //   1422: goto -282 -> 1140
    //   1425: aload 10
    //   1427: astore_1
    //   1428: aload_1
    //   1429: astore 8
    //   1431: aload_0
    //   1432: aload 12
    //   1434: aload_1
    //   1435: invokespecial 812	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1438: aload_1
    //   1439: astore 8
    //   1441: aload 13
    //   1443: invokevirtual 814	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   1446: aload_1
    //   1447: astore 7
    //   1449: aload 7
    //   1451: astore 8
    //   1453: aload 7
    //   1455: astore 10
    //   1457: aload 13
    //   1459: invokevirtual 817	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1462: goto +56 -> 1518
    //   1465: astore 7
    //   1467: goto +13 -> 1480
    //   1470: astore 7
    //   1472: goto +84 -> 1556
    //   1475: astore 7
    //   1477: aload 8
    //   1479: astore_1
    //   1480: aload_1
    //   1481: astore 8
    //   1483: aload 7
    //   1485: invokevirtual 224	java/lang/Exception:printStackTrace	()V
    //   1488: aload_1
    //   1489: astore 7
    //   1491: aload_1
    //   1492: astore 8
    //   1494: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1497: ifeq -48 -> 1449
    //   1500: aload_1
    //   1501: astore 8
    //   1503: ldc 90
    //   1505: iconst_2
    //   1506: ldc_w 819
    //   1509: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1512: aload_1
    //   1513: astore 7
    //   1515: goto -66 -> 1449
    //   1518: aload 11
    //   1520: ifnull +8 -> 1528
    //   1523: aload 11
    //   1525: invokevirtual 776	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   1528: aload 7
    //   1530: ifnull +8 -> 1538
    //   1533: aload 7
    //   1535: invokevirtual 777	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1538: aload 9
    //   1540: ifnull +203 -> 1743
    //   1543: aload 9
    //   1545: invokevirtual 778	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   1548: goto +195 -> 1743
    //   1551: astore 7
    //   1553: aload 8
    //   1555: astore_1
    //   1556: aload_1
    //   1557: astore 8
    //   1559: aload_1
    //   1560: astore 10
    //   1562: aload 13
    //   1564: invokevirtual 817	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1567: aload_1
    //   1568: astore 8
    //   1570: aload_1
    //   1571: astore 10
    //   1573: aload 7
    //   1575: athrow
    //   1576: astore_1
    //   1577: aload 8
    //   1579: astore 7
    //   1581: aload 11
    //   1583: astore 8
    //   1585: goto +223 -> 1808
    //   1588: astore_1
    //   1589: aload 10
    //   1591: astore 7
    //   1593: aload 11
    //   1595: astore 8
    //   1597: goto +45 -> 1642
    //   1600: astore_1
    //   1601: aload 11
    //   1603: astore 8
    //   1605: goto +203 -> 1808
    //   1608: astore_1
    //   1609: aload 11
    //   1611: astore 8
    //   1613: goto +29 -> 1642
    //   1616: astore_1
    //   1617: goto +191 -> 1808
    //   1620: astore_1
    //   1621: aconst_null
    //   1622: astore 8
    //   1624: goto +18 -> 1642
    //   1627: astore_1
    //   1628: aconst_null
    //   1629: astore 7
    //   1631: goto +177 -> 1808
    //   1634: astore_1
    //   1635: aconst_null
    //   1636: astore 7
    //   1638: aload 7
    //   1640: astore 8
    //   1642: aload 9
    //   1644: astore 10
    //   1646: aload_1
    //   1647: astore 9
    //   1649: aload 10
    //   1651: astore_1
    //   1652: goto +43 -> 1695
    //   1655: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1658: ifeq +12 -> 1670
    //   1661: ldc 90
    //   1663: iconst_2
    //   1664: ldc_w 821
    //   1667: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1670: iconst_0
    //   1671: ireturn
    //   1672: astore_1
    //   1673: aconst_null
    //   1674: astore 7
    //   1676: aload 7
    //   1678: astore 9
    //   1680: goto +128 -> 1808
    //   1683: astore 9
    //   1685: aconst_null
    //   1686: astore 7
    //   1688: aload 7
    //   1690: astore 8
    //   1692: aload 11
    //   1694: astore_1
    //   1695: aload 9
    //   1697: invokevirtual 224	java/lang/Exception:printStackTrace	()V
    //   1700: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1703: ifeq +12 -> 1715
    //   1706: ldc 90
    //   1708: iconst_2
    //   1709: ldc_w 823
    //   1712: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1715: aload 8
    //   1717: ifnull +8 -> 1725
    //   1720: aload 8
    //   1722: invokevirtual 776	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   1725: aload 7
    //   1727: ifnull +8 -> 1735
    //   1730: aload 7
    //   1732: invokevirtual 777	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1735: aload_1
    //   1736: ifnull +7 -> 1743
    //   1739: aload_1
    //   1740: invokevirtual 778	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   1743: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1746: ifeq +52 -> 1798
    //   1749: new 189	java/lang/StringBuilder
    //   1752: dup
    //   1753: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   1756: astore_1
    //   1757: aload_1
    //   1758: ldc_w 825
    //   1761: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: pop
    //   1765: aload_1
    //   1766: invokestatic 251	java/lang/System:nanoTime	()J
    //   1769: lload 4
    //   1771: lsub
    //   1772: ldc2_w 399
    //   1775: ldiv
    //   1776: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1779: pop
    //   1780: aload_1
    //   1781: ldc_w 827
    //   1784: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1787: pop
    //   1788: ldc 90
    //   1790: iconst_2
    //   1791: aload_1
    //   1792: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1795: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1798: iconst_1
    //   1799: ireturn
    //   1800: astore 10
    //   1802: aload_1
    //   1803: astore 9
    //   1805: aload 10
    //   1807: astore_1
    //   1808: aload 8
    //   1810: ifnull +8 -> 1818
    //   1813: aload 8
    //   1815: invokevirtual 776	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   1818: aload 7
    //   1820: ifnull +8 -> 1828
    //   1823: aload 7
    //   1825: invokevirtual 777	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1828: aload 9
    //   1830: ifnull +8 -> 1838
    //   1833: aload 9
    //   1835: invokevirtual 778	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   1838: goto +5 -> 1843
    //   1841: aload_1
    //   1842: athrow
    //   1843: goto -2 -> 1841
    //   1846: aconst_null
    //   1847: astore 10
    //   1849: goto -1437 -> 412
    //   1852: aconst_null
    //   1853: astore 12
    //   1855: goto -1207 -> 648
    //   1858: iconst_1
    //   1859: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1860	0	this	MigrateSubscribeDB
    //   0	1860	1	paramFile	File
    //   1354	35	2	i	int
    //   1223	135	3	j	int
    //   69	1701	4	l	long
    //   181	686	6	bool	boolean
    //   34	1371	7	localObject1	Object
    //   1412	1	7	localObject2	Object
    //   1417	1	7	localException1	Exception
    //   1447	7	7	localFile1	File
    //   1465	1	7	localException2	Exception
    //   1470	1	7	localObject3	Object
    //   1475	9	7	localException3	Exception
    //   1489	45	7	localFile2	File
    //   1551	23	7	localObject4	Object
    //   1579	245	7	localObject5	Object
    //   78	939	8	localObject6	Object
    //   1046	6	8	localObject7	Object
    //   1058	6	8	localException4	Exception
    //   1075	739	8	localObject8	Object
    //   197	1482	9	localObject9	Object
    //   1683	13	9	localException5	Exception
    //   1803	31	9	localFile3	File
    //   237	1413	10	localObject10	Object
    //   1800	6	10	localObject11	Object
    //   1847	1	10	localObject12	Object
    //   81	1612	11	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    //   473	1381	12	localObject13	Object
    //   749	814	13	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   127	1272	14	str	String
    //   1024	145	15	localObject14	Object
    //   1196	205	16	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   774	813	845	finally
    //   871	958	845	finally
    //   774	813	853	java/lang/Exception
    //   871	958	853	java/lang/Exception
    //   1026	1040	1046	finally
    //   1026	1040	1058	java/lang/Exception
    //   1395	1409	1412	finally
    //   1395	1409	1417	java/lang/Exception
    //   1431	1438	1465	java/lang/Exception
    //   1441	1446	1465	java/lang/Exception
    //   970	978	1470	finally
    //   985	993	1470	finally
    //   1000	1006	1470	finally
    //   1018	1026	1470	finally
    //   1077	1083	1470	finally
    //   1090	1099	1470	finally
    //   1110	1122	1470	finally
    //   1129	1140	1470	finally
    //   1151	1161	1470	finally
    //   1168	1183	1470	finally
    //   1190	1198	1470	finally
    //   1210	1224	1470	finally
    //   1238	1244	1470	finally
    //   1251	1260	1470	finally
    //   1267	1276	1470	finally
    //   1283	1291	1470	finally
    //   1298	1307	1470	finally
    //   1314	1322	1470	finally
    //   1329	1340	1470	finally
    //   1347	1353	1470	finally
    //   1367	1385	1470	finally
    //   970	978	1475	java/lang/Exception
    //   985	993	1475	java/lang/Exception
    //   1000	1006	1475	java/lang/Exception
    //   1018	1026	1475	java/lang/Exception
    //   1077	1083	1475	java/lang/Exception
    //   1090	1099	1475	java/lang/Exception
    //   1110	1122	1475	java/lang/Exception
    //   1129	1140	1475	java/lang/Exception
    //   1151	1161	1475	java/lang/Exception
    //   1168	1183	1475	java/lang/Exception
    //   1190	1198	1475	java/lang/Exception
    //   1210	1224	1475	java/lang/Exception
    //   1238	1244	1475	java/lang/Exception
    //   1251	1260	1475	java/lang/Exception
    //   1267	1276	1475	java/lang/Exception
    //   1283	1291	1475	java/lang/Exception
    //   1298	1307	1475	java/lang/Exception
    //   1314	1322	1475	java/lang/Exception
    //   1329	1340	1475	java/lang/Exception
    //   1347	1353	1475	java/lang/Exception
    //   1367	1385	1475	java/lang/Exception
    //   1431	1438	1551	finally
    //   1441	1446	1551	finally
    //   1483	1488	1551	finally
    //   1494	1500	1551	finally
    //   1503	1512	1551	finally
    //   1457	1462	1576	finally
    //   1562	1567	1576	finally
    //   1573	1576	1576	finally
    //   1457	1462	1588	java/lang/Exception
    //   1562	1567	1588	java/lang/Exception
    //   1573	1576	1588	java/lang/Exception
    //   763	769	1600	finally
    //   861	866	1600	finally
    //   958	963	1600	finally
    //   763	769	1608	java/lang/Exception
    //   861	866	1608	java/lang/Exception
    //   958	963	1608	java/lang/Exception
    //   744	763	1616	finally
    //   744	763	1620	java/lang/Exception
    //   737	744	1627	finally
    //   737	744	1634	java/lang/Exception
    //   83	107	1672	finally
    //   110	172	1672	finally
    //   172	183	1672	finally
    //   188	199	1672	finally
    //   199	267	1672	finally
    //   267	277	1672	finally
    //   281	324	1672	finally
    //   331	391	1672	finally
    //   394	409	1672	finally
    //   412	435	1672	finally
    //   435	503	1672	finally
    //   503	513	1672	finally
    //   517	560	1672	finally
    //   567	627	1672	finally
    //   630	645	1672	finally
    //   653	668	1672	finally
    //   670	730	1672	finally
    //   730	737	1672	finally
    //   1655	1670	1672	finally
    //   83	107	1683	java/lang/Exception
    //   110	172	1683	java/lang/Exception
    //   172	183	1683	java/lang/Exception
    //   188	199	1683	java/lang/Exception
    //   199	267	1683	java/lang/Exception
    //   267	277	1683	java/lang/Exception
    //   281	324	1683	java/lang/Exception
    //   331	391	1683	java/lang/Exception
    //   394	409	1683	java/lang/Exception
    //   412	435	1683	java/lang/Exception
    //   435	503	1683	java/lang/Exception
    //   503	513	1683	java/lang/Exception
    //   517	560	1683	java/lang/Exception
    //   567	627	1683	java/lang/Exception
    //   630	645	1683	java/lang/Exception
    //   653	668	1683	java/lang/Exception
    //   670	730	1683	java/lang/Exception
    //   730	737	1683	java/lang/Exception
    //   1655	1670	1683	java/lang/Exception
    //   1695	1715	1800	finally
  }
  
  /* Error */
  private String[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 7
    //   8: aload_1
    //   9: ifnonnull +20 -> 29
    //   12: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +12 -> 27
    //   18: ldc 90
    //   20: iconst_2
    //   21: ldc_w 829
    //   24: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aconst_null
    //   28: areturn
    //   29: invokestatic 104	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   32: astore 4
    //   34: new 98	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper
    //   37: dup
    //   38: aload_0
    //   39: aload 4
    //   41: aload_1
    //   42: bipush 80
    //   44: invokespecial 107	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Landroid/content/Context;Ljava/lang/String;I)V
    //   47: astore 6
    //   49: aload 6
    //   51: invokevirtual 111	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   54: astore 4
    //   56: aload 4
    //   58: ldc_w 831
    //   61: aconst_null
    //   62: invokevirtual 119	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore 5
    //   67: aload 5
    //   69: ifnull +179 -> 248
    //   72: aload 8
    //   74: astore_1
    //   75: aload 5
    //   77: invokeinterface 124 1 0
    //   82: ifeq +136 -> 218
    //   85: aload 8
    //   87: astore_1
    //   88: aload 5
    //   90: invokeinterface 834 1 0
    //   95: anewarray 67	java/lang/String
    //   98: astore_3
    //   99: iconst_0
    //   100: istore_2
    //   101: aload_3
    //   102: astore_1
    //   103: aload_3
    //   104: iload_2
    //   105: aload 5
    //   107: iconst_0
    //   108: invokeinterface 157 2 0
    //   113: aastore
    //   114: aload_3
    //   115: astore_1
    //   116: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +80 -> 199
    //   122: aload_3
    //   123: astore_1
    //   124: new 189	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   131: astore 7
    //   133: aload_3
    //   134: astore_1
    //   135: aload 7
    //   137: ldc_w 836
    //   140: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload_3
    //   145: astore_1
    //   146: aload 7
    //   148: iload_2
    //   149: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload_3
    //   154: astore_1
    //   155: aload 7
    //   157: ldc_w 838
    //   160: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_3
    //   165: astore_1
    //   166: aload 7
    //   168: aload_3
    //   169: iload_2
    //   170: aaload
    //   171: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_3
    //   176: astore_1
    //   177: aload 7
    //   179: ldc_w 840
    //   182: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload_3
    //   187: astore_1
    //   188: ldc 90
    //   190: iconst_2
    //   191: aload 7
    //   193: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: iload_2
    //   200: iconst_1
    //   201: iadd
    //   202: istore_2
    //   203: aload_3
    //   204: astore_1
    //   205: aload 5
    //   207: invokeinterface 216 1 0
    //   212: ifne -111 -> 101
    //   215: goto +60 -> 275
    //   218: aload 7
    //   220: astore_3
    //   221: aload 8
    //   223: astore_1
    //   224: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +48 -> 275
    //   230: aload 8
    //   232: astore_1
    //   233: ldc 90
    //   235: iconst_2
    //   236: ldc_w 842
    //   239: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: aload 7
    //   244: astore_3
    //   245: goto +30 -> 275
    //   248: aload 7
    //   250: astore_3
    //   251: aload 8
    //   253: astore_1
    //   254: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq +18 -> 275
    //   260: aload 8
    //   262: astore_1
    //   263: ldc 90
    //   265: iconst_2
    //   266: ldc_w 844
    //   269: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload 7
    //   274: astore_3
    //   275: aload 5
    //   277: ifnull +13 -> 290
    //   280: aload 5
    //   282: invokeinterface 221 1 0
    //   287: goto +3 -> 290
    //   290: aload 4
    //   292: ifnull +8 -> 300
    //   295: aload 4
    //   297: invokevirtual 396	android/database/sqlite/SQLiteDatabase:close	()V
    //   300: aload 6
    //   302: invokevirtual 232	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:close	()V
    //   305: aload_3
    //   306: areturn
    //   307: astore_1
    //   308: aload 5
    //   310: astore_3
    //   311: goto +154 -> 465
    //   314: astore 7
    //   316: aload 4
    //   318: astore_3
    //   319: aload_1
    //   320: astore 4
    //   322: aload 5
    //   324: astore_1
    //   325: aload 7
    //   327: astore 5
    //   329: goto +67 -> 396
    //   332: astore_1
    //   333: aconst_null
    //   334: astore_3
    //   335: goto +130 -> 465
    //   338: astore 5
    //   340: aconst_null
    //   341: astore_1
    //   342: aload 4
    //   344: astore_3
    //   345: aload_1
    //   346: astore 4
    //   348: goto +48 -> 396
    //   351: astore_1
    //   352: aconst_null
    //   353: astore 4
    //   355: aload 4
    //   357: astore_3
    //   358: goto +107 -> 465
    //   361: astore 5
    //   363: aconst_null
    //   364: astore 4
    //   366: aload 4
    //   368: astore_1
    //   369: goto +27 -> 396
    //   372: astore_1
    //   373: aconst_null
    //   374: astore 4
    //   376: aload 4
    //   378: astore_3
    //   379: aload_3
    //   380: astore 6
    //   382: goto +83 -> 465
    //   385: astore 5
    //   387: aconst_null
    //   388: astore 4
    //   390: aload 4
    //   392: astore_1
    //   393: aload_1
    //   394: astore 6
    //   396: aload 5
    //   398: invokevirtual 224	java/lang/Exception:printStackTrace	()V
    //   401: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   404: ifeq +14 -> 418
    //   407: ldc 90
    //   409: iconst_2
    //   410: ldc_w 846
    //   413: aload 5
    //   415: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   418: aload_1
    //   419: ifnull +12 -> 431
    //   422: aload_1
    //   423: invokeinterface 221 1 0
    //   428: goto +3 -> 431
    //   431: aload_3
    //   432: ifnull +10 -> 442
    //   435: aload_3
    //   436: invokevirtual 396	android/database/sqlite/SQLiteDatabase:close	()V
    //   439: goto +3 -> 442
    //   442: aload 6
    //   444: ifnull +8 -> 452
    //   447: aload 6
    //   449: invokevirtual 232	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:close	()V
    //   452: aload 4
    //   454: areturn
    //   455: astore 5
    //   457: aload_3
    //   458: astore 4
    //   460: aload_1
    //   461: astore_3
    //   462: aload 5
    //   464: astore_1
    //   465: aload_3
    //   466: ifnull +12 -> 478
    //   469: aload_3
    //   470: invokeinterface 221 1 0
    //   475: goto +3 -> 478
    //   478: aload 4
    //   480: ifnull +11 -> 491
    //   483: aload 4
    //   485: invokevirtual 396	android/database/sqlite/SQLiteDatabase:close	()V
    //   488: goto +3 -> 491
    //   491: aload 6
    //   493: ifnull +8 -> 501
    //   496: aload 6
    //   498: invokevirtual 232	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:close	()V
    //   501: goto +5 -> 506
    //   504: aload_1
    //   505: athrow
    //   506: goto -2 -> 504
    //   509: astore_1
    //   510: goto -220 -> 290
    //   513: astore_1
    //   514: goto -214 -> 300
    //   517: astore_1
    //   518: goto -213 -> 305
    //   521: astore_1
    //   522: goto -91 -> 431
    //   525: astore_1
    //   526: goto -84 -> 442
    //   529: astore_1
    //   530: aload 4
    //   532: areturn
    //   533: astore_3
    //   534: goto -56 -> 478
    //   537: astore_3
    //   538: goto -47 -> 491
    //   541: astore_3
    //   542: goto -41 -> 501
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	545	0	this	MigrateSubscribeDB
    //   0	545	1	paramString	String
    //   100	103	2	i	int
    //   4	466	3	localObject1	Object
    //   533	1	3	localException1	Exception
    //   537	1	3	localException2	Exception
    //   541	1	3	localException3	Exception
    //   32	499	4	localObject2	Object
    //   65	263	5	localObject3	Object
    //   338	1	5	localException4	Exception
    //   361	1	5	localException5	Exception
    //   385	29	5	localException6	Exception
    //   455	8	5	localObject4	Object
    //   47	450	6	localObject5	Object
    //   6	267	7	localStringBuilder	StringBuilder
    //   314	12	7	localException7	Exception
    //   1	260	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   75	85	307	finally
    //   88	99	307	finally
    //   103	114	307	finally
    //   116	122	307	finally
    //   124	133	307	finally
    //   135	144	307	finally
    //   146	153	307	finally
    //   155	164	307	finally
    //   166	175	307	finally
    //   177	186	307	finally
    //   188	199	307	finally
    //   205	215	307	finally
    //   224	230	307	finally
    //   233	242	307	finally
    //   254	260	307	finally
    //   263	272	307	finally
    //   75	85	314	java/lang/Exception
    //   88	99	314	java/lang/Exception
    //   103	114	314	java/lang/Exception
    //   116	122	314	java/lang/Exception
    //   124	133	314	java/lang/Exception
    //   135	144	314	java/lang/Exception
    //   146	153	314	java/lang/Exception
    //   155	164	314	java/lang/Exception
    //   166	175	314	java/lang/Exception
    //   177	186	314	java/lang/Exception
    //   188	199	314	java/lang/Exception
    //   205	215	314	java/lang/Exception
    //   224	230	314	java/lang/Exception
    //   233	242	314	java/lang/Exception
    //   254	260	314	java/lang/Exception
    //   263	272	314	java/lang/Exception
    //   56	67	332	finally
    //   56	67	338	java/lang/Exception
    //   49	56	351	finally
    //   49	56	361	java/lang/Exception
    //   34	49	372	finally
    //   34	49	385	java/lang/Exception
    //   396	418	455	finally
    //   280	287	509	java/lang/Exception
    //   295	300	513	java/lang/Exception
    //   300	305	517	java/lang/Exception
    //   422	428	521	java/lang/Exception
    //   435	439	525	java/lang/Exception
    //   447	452	529	java/lang/Exception
    //   469	475	533	java/lang/Exception
    //   483	488	537	java/lang/Exception
    //   496	501	541	java/lang/Exception
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "begin getMigrateDBFiles.");
    }
    long l = System.nanoTime();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.c = new ArrayList();
    Object localObject1 = Pattern.compile("^\\d+\\.db$");
    Pattern localPattern1 = Pattern.compile("^readinjoy_main_\\d+$");
    Pattern localPattern2 = Pattern.compile("^readinjoy_\\d+\\.db$");
    String str = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getFilesDir().getPath();
    Object localObject2 = new StringBuilder();
    int j = str.lastIndexOf("/");
    int i = 0;
    ((StringBuilder)localObject2).append(str.substring(0, j));
    ((StringBuilder)localObject2).append("/databases");
    str = ((StringBuilder)localObject2).toString();
    localObject2 = new File(str);
    StringBuilder localStringBuilder1;
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getMigrateDBFiles we will list files in folder: ");
      localStringBuilder1.append(str);
      QLog.d("MigrateSubscribeDB", 2, localStringBuilder1.toString());
    }
    localObject2 = ((File)localObject2).listFiles();
    if (localObject2 != null)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("getMigrateDBFiles dbFiles length: ");
        localStringBuilder1.append(localObject2.length);
        QLog.d("MigrateSubscribeDB", 2, localStringBuilder1.toString());
      }
      j = localObject2.length;
      while (i < j)
      {
        localStringBuilder1 = localObject2[i];
        Object localObject3 = localStringBuilder1.getName();
        StringBuilder localStringBuilder2;
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("getMigrateDBFiles find file[");
          localStringBuilder2.append((String)localObject3);
          localStringBuilder2.append("] in folder[");
          localStringBuilder2.append(str);
          localStringBuilder2.append("]");
          QLog.d("MigrateSubscribeDB", 2, localStringBuilder2.toString());
        }
        if (((Pattern)localObject1).matcher((CharSequence)localObject3).find())
        {
          this.jdField_a_of_type_JavaUtilList.add(localStringBuilder1);
          if (QLog.isColorLevel())
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("getMigrateDBFiles mUinMainDBFiles ");
            localStringBuilder2.append(localStringBuilder1);
            QLog.d("MigrateSubscribeDB", 2, localStringBuilder2.toString());
          }
        }
        if (localPattern1.matcher((CharSequence)localObject3).find())
        {
          this.jdField_b_of_type_JavaUtilList.add(localStringBuilder1);
          if (QLog.isColorLevel())
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("getMigrateDBFiles mReadInJoyMainDBFiles ");
            localStringBuilder2.append(localStringBuilder1);
            QLog.d("MigrateSubscribeDB", 2, localStringBuilder2.toString());
          }
        }
        if (localPattern2.matcher((CharSequence)localObject3).find())
        {
          this.c.add(localStringBuilder1);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getMigrateDBFiles mReadInJoySubDBFiles ");
            ((StringBuilder)localObject3).append(localStringBuilder1);
            QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject3).toString());
          }
        }
        i += 1;
      }
      Collections.sort(this.jdField_a_of_type_JavaUtilList, new MigrateSubscribeDB.1(this));
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doStep get Migrate db files cost = ");
        ((StringBuilder)localObject1).append((System.nanoTime() - l) / 1000000L);
        ((StringBuilder)localObject1).append("ms");
        QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles dbFiles is null");
    }
  }
  
  private void b(List<MigrateSubscribeDB.SubscribeRecentData> paramList, EntityManager paramEntityManager)
  {
    long l = System.nanoTime();
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo fail subscribeRecentDataList is null");
      }
      return;
    }
    int i = paramList.size();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("migrateToCoversationInfo subscribeRecentDataList list size: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject).toString());
    }
    i = 0;
    while (i < paramList.size())
    {
      MigrateSubscribeDB.SubscribeRecentData localSubscribeRecentData = (MigrateSubscribeDB.SubscribeRecentData)paramList.get(i);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("migrateToCoversationInfo subscribeRecentData: ");
        ((StringBuilder)localObject).append(localSubscribeRecentData);
        QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject).toString());
      }
      String str = SubscriptUtil.a(localSubscribeRecentData.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("migrateToCoversationInfo find subscribeID[");
          ((StringBuilder)localObject).append(localSubscribeRecentData.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append("]'s uin: ");
          ((StringBuilder)localObject).append(str);
          QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject).toString());
        }
        localObject = new ConversationInfo();
        List localList = paramEntityManager.query(ConversationInfo.class, false, "uin=? and type=?", new String[] { str, String.valueOf(1008) }, null, null, null, null);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("migrateToCoversationInfo dataList size: ");
          int j;
          if (localList != null) {
            j = localList.size();
          } else {
            j = 0;
          }
          localStringBuilder.append(j);
          QLog.d("MigrateSubscribeDB", 2, localStringBuilder.toString());
        }
        if ((localList != null) && (localList.size() > 0))
        {
          localObject = (ConversationInfo)localList.get(0);
          ((ConversationInfo)localObject).uin = str;
          ((ConversationInfo)localObject).setUnread(((ConversationInfo)localObject).unreadCount + localSubscribeRecentData.jdField_a_of_type_Int);
          ((ConversationInfo)localObject).setType(1008);
        }
        else
        {
          ((ConversationInfo)localObject).uin = str;
          ((ConversationInfo)localObject).setUnread(localSubscribeRecentData.jdField_a_of_type_Int);
          ((ConversationInfo)localObject).setType(1008);
        }
        paramEntityManager.persistOrReplace((Entity)localObject);
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("migrateToCoversationInfo we can't subscribeid[");
        ((StringBuilder)localObject).append(localSubscribeRecentData.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append("]'s uin");
        QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject).toString());
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("migrateToCoversationInfo total cost = ");
      paramList.append((System.nanoTime() - l) / 1000000L);
      paramList.append(" ms ");
      QLog.d("MigrateSubscribeDB", 2, paramList.toString());
    }
  }
  
  private void c(List<MessageRecord> paramList, EntityManager paramEntityManager)
  {
    long l = System.nanoTime();
    if (paramList == null) {
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      paramEntityManager.persistOrReplace((MessageRecord)paramList.get(i));
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("migrateToMsgRecord total cost = ");
      paramList.append((System.nanoTime() - l) / 1000000L);
      paramList.append(" ms ");
      QLog.d("MigrateSubscribeDB", 2, paramList.toString());
    }
  }
  
  protected boolean doStep()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("begin do Step for MigrateSubscribeDB.");
      ((StringBuilder)localObject).append(BaseApplicationImpl.sProcessId);
      QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject).toString());
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
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      a();
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        File localFile = (File)((Iterator)localObject).next();
        if (!this.jdField_b_of_type_Boolean)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MigrateSubscribeDB", 2, "doStep foreach mUinMainDBFiles，but timeout！");
          break;
        }
        if (!a(localFile)) {
          break;
        }
        this.jdField_a_of_type_Long += 1L;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doStep Migrate subscribe db total cost = ");
      ((StringBuilder)localObject).append((System.nanoTime() - l) / 1000000L);
      ((StringBuilder)localObject).append(" ms  and Migrate ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(" times ");
      QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject).toString());
    }
    return super.doStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.MigrateSubscribeDB
 * JD-Core Version:    0.7.0.1
 */