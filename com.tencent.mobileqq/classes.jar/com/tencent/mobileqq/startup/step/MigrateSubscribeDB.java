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
  BaseApplicationImpl b;
  int c = -1;
  volatile boolean d = true;
  Object e = new Object();
  long f = 0L;
  private List<File> g = null;
  private List<File> h = null;
  private List<File> i = null;
  
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
    //   0: new 66	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 67	java/util/ArrayList:<init>	()V
    //   7: astore 12
    //   9: aload_1
    //   10: ifnonnull +19 -> 29
    //   13: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +11 -> 27
    //   19: ldc 75
    //   21: iconst_2
    //   22: ldc 77
    //   24: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aconst_null
    //   28: areturn
    //   29: new 82	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper
    //   32: dup
    //   33: aload_0
    //   34: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   37: aload_1
    //   38: bipush 17
    //   40: invokespecial 91	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Landroid/content/Context;Ljava/lang/String;I)V
    //   43: astore 14
    //   45: aload 14
    //   47: invokevirtual 95	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   50: ldc 97
    //   52: aconst_null
    //   53: invokevirtual 103	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   56: astore 15
    //   58: aload 15
    //   60: ifnull +646 -> 706
    //   63: aload 15
    //   65: invokeinterface 108 1 0
    //   70: ifeq +544 -> 614
    //   73: aload 15
    //   75: ldc 110
    //   77: invokeinterface 114 2 0
    //   82: istore_3
    //   83: aload 15
    //   85: ldc 116
    //   87: invokeinterface 114 2 0
    //   92: istore 4
    //   94: aload 15
    //   96: ldc 118
    //   98: invokeinterface 114 2 0
    //   103: istore_2
    //   104: aload 15
    //   106: ldc 120
    //   108: invokeinterface 114 2 0
    //   113: istore 5
    //   115: aload 15
    //   117: ldc 122
    //   119: invokeinterface 114 2 0
    //   124: istore 6
    //   126: aload 15
    //   128: ldc 124
    //   130: invokeinterface 114 2 0
    //   135: istore 7
    //   137: aload 15
    //   139: ldc 126
    //   141: invokeinterface 114 2 0
    //   146: istore 8
    //   148: aload 15
    //   150: ldc 128
    //   152: invokeinterface 114 2 0
    //   157: istore 9
    //   159: aload 15
    //   161: ldc 130
    //   163: invokeinterface 114 2 0
    //   168: istore 10
    //   170: aload 15
    //   172: ldc 132
    //   174: invokeinterface 114 2 0
    //   179: istore 11
    //   181: aload 12
    //   183: astore_1
    //   184: aload_0
    //   185: astore 12
    //   187: new 134	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData
    //   190: dup
    //   191: aload 12
    //   193: aconst_null
    //   194: invokespecial 137	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB$1;)V
    //   197: astore 13
    //   199: aload 13
    //   201: aload 12
    //   203: aload 15
    //   205: iload_3
    //   206: invokeinterface 141 2 0
    //   211: invokespecial 143	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   214: putfield 146	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:g	Ljava/lang/String;
    //   217: aload 13
    //   219: aload 12
    //   221: aload 15
    //   223: iload 4
    //   225: invokeinterface 141 2 0
    //   230: invokespecial 143	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   233: putfield 148	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:h	Ljava/lang/String;
    //   236: aload 13
    //   238: aload 12
    //   240: aload 15
    //   242: iload_2
    //   243: invokeinterface 141 2 0
    //   248: invokespecial 143	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   251: putfield 150	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:c	Ljava/lang/String;
    //   254: aload 13
    //   256: aload 15
    //   258: iload 5
    //   260: invokeinterface 154 2 0
    //   265: putfield 156	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:e	J
    //   268: aload 13
    //   270: aload 15
    //   272: iload 6
    //   274: invokeinterface 154 2 0
    //   279: putfield 158	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:d	J
    //   282: aload 13
    //   284: aload 15
    //   286: iload 7
    //   288: invokeinterface 154 2 0
    //   293: putfield 159	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:f	J
    //   296: aload 13
    //   298: aload 12
    //   300: aload 15
    //   302: iload 8
    //   304: invokeinterface 141 2 0
    //   309: invokespecial 143	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   312: putfield 161	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:i	Ljava/lang/String;
    //   315: aload 13
    //   317: aload 12
    //   319: aload 15
    //   321: iload 9
    //   323: invokeinterface 141 2 0
    //   328: invokespecial 143	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   331: putfield 163	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:a	Ljava/lang/String;
    //   334: aload 13
    //   336: aload 12
    //   338: aload 15
    //   340: iload 10
    //   342: invokeinterface 141 2 0
    //   347: invokespecial 143	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   350: putfield 165	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:b	Ljava/lang/String;
    //   353: aload 13
    //   355: aload 15
    //   357: iload 11
    //   359: invokeinterface 169 2 0
    //   364: putfield 172	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:j	I
    //   367: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   370: ifeq +216 -> 586
    //   373: new 174	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   380: astore 12
    //   382: aload 12
    //   384: ldc 177
    //   386: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 12
    //   392: aload 13
    //   394: getfield 146	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:g	Ljava/lang/String;
    //   397: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 12
    //   403: ldc 183
    //   405: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 12
    //   411: aload 13
    //   413: getfield 148	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:h	Ljava/lang/String;
    //   416: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload 12
    //   422: ldc 183
    //   424: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload 12
    //   430: aload 13
    //   432: getfield 150	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:c	Ljava/lang/String;
    //   435: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: aload 12
    //   441: ldc 183
    //   443: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload 12
    //   449: aload 13
    //   451: getfield 156	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:e	J
    //   454: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 12
    //   460: ldc 183
    //   462: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload 12
    //   468: aload 13
    //   470: getfield 158	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:d	J
    //   473: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 12
    //   479: ldc 183
    //   481: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload 12
    //   487: aload 13
    //   489: getfield 159	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:f	J
    //   492: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 12
    //   498: aload 13
    //   500: getfield 161	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:i	Ljava/lang/String;
    //   503: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: aload 12
    //   509: ldc 183
    //   511: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 12
    //   517: aload 13
    //   519: getfield 163	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:a	Ljava/lang/String;
    //   522: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload 12
    //   528: ldc 183
    //   530: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload 12
    //   536: aload 13
    //   538: getfield 165	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:b	Ljava/lang/String;
    //   541: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 12
    //   547: ldc 183
    //   549: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload 12
    //   555: aload 13
    //   557: getfield 172	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:j	I
    //   560: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload 12
    //   566: ldc 191
    //   568: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: ldc 75
    //   574: iconst_2
    //   575: aload 12
    //   577: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   583: goto +3 -> 586
    //   586: aload_1
    //   587: astore 12
    //   589: aload_1
    //   590: aload 13
    //   592: invokeinterface 198 2 0
    //   597: pop
    //   598: aload_1
    //   599: astore 12
    //   601: aload 15
    //   603: invokeinterface 201 1 0
    //   608: ifne +125 -> 733
    //   611: goto +35 -> 646
    //   614: aload 12
    //   616: astore 13
    //   618: aload 13
    //   620: astore_1
    //   621: aload 13
    //   623: astore 12
    //   625: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   628: ifeq +18 -> 646
    //   631: aload 13
    //   633: astore 12
    //   635: ldc 75
    //   637: iconst_2
    //   638: ldc 203
    //   640: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   643: aload 13
    //   645: astore_1
    //   646: aload 15
    //   648: invokeinterface 206 1 0
    //   653: goto +73 -> 726
    //   656: astore 13
    //   658: goto +9 -> 667
    //   661: astore_1
    //   662: goto +35 -> 697
    //   665: astore 13
    //   667: aload 13
    //   669: invokevirtual 209	java/lang/Exception:printStackTrace	()V
    //   672: aload 12
    //   674: astore_1
    //   675: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   678: ifeq -32 -> 646
    //   681: ldc 75
    //   683: iconst_2
    //   684: ldc 211
    //   686: aload 13
    //   688: invokestatic 214	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   691: aload 12
    //   693: astore_1
    //   694: goto -48 -> 646
    //   697: aload 15
    //   699: invokeinterface 206 1 0
    //   704: aload_1
    //   705: athrow
    //   706: aload 12
    //   708: astore_1
    //   709: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   712: ifeq +14 -> 726
    //   715: ldc 75
    //   717: iconst_2
    //   718: ldc 216
    //   720: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   723: aload 12
    //   725: astore_1
    //   726: aload 14
    //   728: invokevirtual 217	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:close	()V
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
    //   103	140	2	j	int
    //   82	124	3	k	int
    //   92	132	4	m	int
    //   113	146	5	n	int
    //   124	149	6	i1	int
    //   135	152	7	i2	int
    //   146	157	8	i3	int
    //   157	165	9	i4	int
    //   168	173	10	i5	int
    //   179	179	11	i6	int
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
    //   0: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +84 -> 87
    //   6: new 174	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   13: astore 22
    //   15: aload 22
    //   17: ldc 222
    //   19: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 22
    //   25: aload_1
    //   26: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 22
    //   32: ldc 224
    //   34: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 22
    //   40: aload_2
    //   41: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 22
    //   47: ldc 226
    //   49: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 22
    //   55: aload_3
    //   56: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 22
    //   62: ldc 231
    //   64: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 22
    //   70: aload 4
    //   72: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: ldc 75
    //   78: iconst_2
    //   79: aload 22
    //   81: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: invokestatic 237	java/lang/System:nanoTime	()J
    //   90: lstore 13
    //   92: new 66	java/util/ArrayList
    //   95: dup
    //   96: invokespecial 67	java/util/ArrayList:<init>	()V
    //   99: astore 24
    //   101: aconst_null
    //   102: astore 23
    //   104: aload_2
    //   105: ifnull +1124 -> 1229
    //   108: aload_3
    //   109: ifnonnull +6 -> 115
    //   112: goto +1117 -> 1229
    //   115: aload_3
    //   116: invokeinterface 240 1 0
    //   121: istore 6
    //   123: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +39 -> 165
    //   129: new 174	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   136: astore 22
    //   138: aload 22
    //   140: ldc 242
    //   142: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 22
    //   148: iload 6
    //   150: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: ldc 75
    //   156: iconst_2
    //   157: aload 22
    //   159: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: iconst_0
    //   166: istore 5
    //   168: aload 23
    //   170: astore 22
    //   172: iload 5
    //   174: iload 6
    //   176: if_icmpge +49 -> 225
    //   179: aload_3
    //   180: iload 5
    //   182: invokeinterface 246 2 0
    //   187: checkcast 134	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData
    //   190: getfield 163	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:a	Ljava/lang/String;
    //   193: aload_2
    //   194: invokevirtual 249	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   197: ifeq +19 -> 216
    //   200: aload_3
    //   201: iload 5
    //   203: invokeinterface 246 2 0
    //   208: checkcast 134	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData
    //   211: astore 22
    //   213: goto +12 -> 225
    //   216: iload 5
    //   218: iconst_1
    //   219: iadd
    //   220: istore 5
    //   222: goto -54 -> 168
    //   225: aload 22
    //   227: ifnull +13 -> 240
    //   230: aload 22
    //   232: getfield 172	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:j	I
    //   235: istore 5
    //   237: goto +6 -> 243
    //   240: iconst_0
    //   241: istore 5
    //   243: iload 5
    //   245: ifle +9 -> 254
    //   248: ldc 251
    //   250: astore_3
    //   251: goto +6 -> 257
    //   254: ldc 253
    //   256: astore_3
    //   257: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq +38 -> 298
    //   263: new 174	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   270: astore 22
    //   272: aload 22
    //   274: ldc 255
    //   276: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 22
    //   282: aload_3
    //   283: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: ldc 75
    //   289: iconst_2
    //   290: aload 22
    //   292: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: new 82	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper
    //   301: dup
    //   302: aload_0
    //   303: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   306: aload_1
    //   307: bipush 80
    //   309: invokespecial 91	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Landroid/content/Context;Ljava/lang/String;I)V
    //   312: astore 22
    //   314: aload 22
    //   316: invokevirtual 95	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   319: astore 23
    //   321: aload 23
    //   323: iconst_0
    //   324: ldc_w 257
    //   327: aconst_null
    //   328: ldc_w 259
    //   331: iconst_1
    //   332: anewarray 51	java/lang/String
    //   335: dup
    //   336: iconst_0
    //   337: aload_2
    //   338: aastore
    //   339: aconst_null
    //   340: aconst_null
    //   341: ldc_w 261
    //   344: aload_3
    //   345: invokevirtual 265	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   348: astore_2
    //   349: aload_2
    //   350: ifnull +788 -> 1138
    //   353: aload_2
    //   354: invokeinterface 108 1 0
    //   359: ifeq +606 -> 965
    //   362: aload_2
    //   363: ldc_w 267
    //   366: invokeinterface 114 2 0
    //   371: istore 11
    //   373: aload_2
    //   374: ldc_w 269
    //   377: invokeinterface 114 2 0
    //   382: istore 10
    //   384: aload_2
    //   385: ldc_w 271
    //   388: invokeinterface 114 2 0
    //   393: istore 9
    //   395: aload_2
    //   396: ldc_w 273
    //   399: invokeinterface 114 2 0
    //   404: istore 7
    //   406: aload_2
    //   407: ldc_w 275
    //   410: invokeinterface 114 2 0
    //   415: istore 6
    //   417: aload_2
    //   418: ldc_w 277
    //   421: invokeinterface 114 2 0
    //   426: istore 8
    //   428: aload_2
    //   429: iload 11
    //   431: invokeinterface 154 2 0
    //   436: lstore 15
    //   438: aload_2
    //   439: iload 10
    //   441: invokeinterface 141 2 0
    //   446: astore 25
    //   448: aload_2
    //   449: iload 9
    //   451: invokeinterface 141 2 0
    //   456: astore_3
    //   457: aload_2
    //   458: iload 7
    //   460: invokeinterface 141 2 0
    //   465: astore_1
    //   466: aload_2
    //   467: iload 6
    //   469: invokeinterface 154 2 0
    //   474: lstore 17
    //   476: aload_2
    //   477: iload 8
    //   479: invokeinterface 154 2 0
    //   484: lstore 19
    //   486: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq +761 -> 1250
    //   492: new 174	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   499: astore 26
    //   501: aload 26
    //   503: ldc_w 279
    //   506: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload 26
    //   512: lload 15
    //   514: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload 26
    //   520: ldc 183
    //   522: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload 26
    //   528: aload 25
    //   530: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload 26
    //   536: ldc 183
    //   538: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload 26
    //   544: aload_3
    //   545: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload 26
    //   551: ldc 183
    //   553: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload 26
    //   559: aload_1
    //   560: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload 26
    //   566: ldc 183
    //   568: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload 26
    //   574: lload 17
    //   576: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload 26
    //   582: ldc 183
    //   584: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload 26
    //   590: lload 19
    //   592: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload 26
    //   598: ldc 191
    //   600: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: ldc 75
    //   606: iconst_2
    //   607: aload 26
    //   609: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   615: goto +3 -> 618
    //   618: aload 25
    //   620: invokestatic 283	com/tencent/biz/pubaccount/subscript/SubscriptUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   623: astore_3
    //   624: aload_3
    //   625: invokestatic 289	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   628: ifne +275 -> 903
    //   631: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   634: ifeq +56 -> 690
    //   637: new 174	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   644: astore 26
    //   646: aload 26
    //   648: ldc_w 291
    //   651: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: aload 26
    //   657: aload 25
    //   659: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: pop
    //   663: aload 26
    //   665: ldc_w 293
    //   668: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload 26
    //   674: aload_3
    //   675: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: ldc 75
    //   681: iconst_2
    //   682: aload 26
    //   684: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   690: ldc_w 295
    //   693: invokestatic 301	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   696: checkcast 295	com/tencent/biz/pubaccount/util/api/IPublicAccountMessageUtil
    //   699: aload_1
    //   700: invokeinterface 305 2 0
    //   705: checkcast 307	com/tencent/mobileqq/data/PAMessage
    //   708: astore 26
    //   710: aload 26
    //   712: ifnull +173 -> 885
    //   715: sipush -3006
    //   718: invokestatic 312	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   721: checkcast 314	com/tencent/mobileqq/data/MessageForPubAccount
    //   724: astore 25
    //   726: aload 25
    //   728: sipush -3006
    //   731: putfield 317	com/tencent/mobileqq/data/MessageForPubAccount:msgtype	I
    //   734: aload 25
    //   736: sipush 1008
    //   739: putfield 320	com/tencent/mobileqq/data/MessageForPubAccount:istroop	I
    //   742: aload 25
    //   744: aload_1
    //   745: putfield 323	com/tencent/mobileqq/data/MessageForPubAccount:msg	Ljava/lang/String;
    //   748: aload 25
    //   750: aload 26
    //   752: putfield 327	com/tencent/mobileqq/data/MessageForPubAccount:mPAMessage	Lcom/tencent/mobileqq/data/PAMessage;
    //   755: goto +8 -> 763
    //   758: astore_1
    //   759: aload_1
    //   760: invokevirtual 209	java/lang/Exception:printStackTrace	()V
    //   763: aload 25
    //   765: ldc_w 295
    //   768: invokestatic 301	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   771: checkcast 295	com/tencent/biz/pubaccount/util/api/IPublicAccountMessageUtil
    //   774: aload 26
    //   776: invokeinterface 331 2 0
    //   781: putfield 335	com/tencent/mobileqq/data/MessageForPubAccount:msgData	[B
    //   784: goto +8 -> 792
    //   787: astore_1
    //   788: aload_1
    //   789: invokevirtual 209	java/lang/Exception:printStackTrace	()V
    //   792: aload 25
    //   794: aload_3
    //   795: putfield 338	com/tencent/mobileqq/data/MessageForPubAccount:frienduin	Ljava/lang/String;
    //   798: aload 25
    //   800: aload_3
    //   801: putfield 341	com/tencent/mobileqq/data/MessageForPubAccount:senderuin	Ljava/lang/String;
    //   804: aload 25
    //   806: aload 4
    //   808: putfield 344	com/tencent/mobileqq/data/MessageForPubAccount:selfuin	Ljava/lang/String;
    //   811: aload 25
    //   813: lload 17
    //   815: putfield 347	com/tencent/mobileqq/data/MessageForPubAccount:time	J
    //   818: aload 25
    //   820: lload 17
    //   822: putfield 350	com/tencent/mobileqq/data/MessageForPubAccount:msgseq	J
    //   825: aload 25
    //   827: aload_0
    //   828: invokespecial 352	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:d	()I
    //   831: i2l
    //   832: putfield 355	com/tencent/mobileqq/data/MessageForPubAccount:shmsgseq	J
    //   835: aload 25
    //   837: aload_0
    //   838: invokespecial 357	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:e	()J
    //   841: putfield 360	com/tencent/mobileqq/data/MessageForPubAccount:msgUid	J
    //   844: iload 5
    //   846: iconst_1
    //   847: isub
    //   848: istore 12
    //   850: iload 5
    //   852: ifle +401 -> 1253
    //   855: iconst_0
    //   856: istore 21
    //   858: goto +3 -> 861
    //   861: aload 25
    //   863: iload 21
    //   865: putfield 363	com/tencent/mobileqq/data/MessageForPubAccount:isread	Z
    //   868: aload 24
    //   870: aload 25
    //   872: invokeinterface 198 2 0
    //   877: pop
    //   878: iload 12
    //   880: istore 5
    //   882: goto +71 -> 953
    //   885: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   888: ifeq +371 -> 1259
    //   891: ldc 75
    //   893: iconst_2
    //   894: ldc_w 365
    //   897: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   900: goto +359 -> 1259
    //   903: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   906: ifeq +353 -> 1259
    //   909: new 174	java/lang/StringBuilder
    //   912: dup
    //   913: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   916: astore_1
    //   917: aload_1
    //   918: ldc_w 367
    //   921: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: pop
    //   925: aload_1
    //   926: aload 25
    //   928: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: pop
    //   932: aload_1
    //   933: ldc_w 369
    //   936: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: pop
    //   940: ldc 75
    //   942: iconst_2
    //   943: aload_1
    //   944: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   947: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   950: goto +309 -> 1259
    //   953: aload_2
    //   954: invokeinterface 201 1 0
    //   959: ifne +303 -> 1262
    //   962: goto +18 -> 980
    //   965: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   968: ifeq +12 -> 980
    //   971: ldc 75
    //   973: iconst_2
    //   974: ldc_w 371
    //   977: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   980: aload_2
    //   981: invokeinterface 206 1 0
    //   986: goto +35 -> 1021
    //   989: astore_1
    //   990: goto +8 -> 998
    //   993: astore_1
    //   994: goto +136 -> 1130
    //   997: astore_1
    //   998: aload_1
    //   999: invokevirtual 209	java/lang/Exception:printStackTrace	()V
    //   1002: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1005: ifeq -25 -> 980
    //   1008: ldc 75
    //   1010: iconst_2
    //   1011: ldc_w 373
    //   1014: aload_1
    //   1015: invokestatic 214	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1018: goto -38 -> 980
    //   1021: aload 24
    //   1023: invokeinterface 240 1 0
    //   1028: ifle +125 -> 1153
    //   1031: iconst_0
    //   1032: istore 5
    //   1034: iload 5
    //   1036: aload 24
    //   1038: invokeinterface 240 1 0
    //   1043: iconst_1
    //   1044: isub
    //   1045: if_icmpge +108 -> 1153
    //   1048: aload 24
    //   1050: invokeinterface 240 1 0
    //   1055: iconst_1
    //   1056: isub
    //   1057: istore 6
    //   1059: iload 6
    //   1061: iload 5
    //   1063: if_icmple +58 -> 1121
    //   1066: aload 24
    //   1068: iload 6
    //   1070: invokeinterface 246 2 0
    //   1075: checkcast 375	com/tencent/mobileqq/data/MessageRecord
    //   1078: getfield 376	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   1081: aload 24
    //   1083: iload 5
    //   1085: invokeinterface 246 2 0
    //   1090: checkcast 375	com/tencent/mobileqq/data/MessageRecord
    //   1093: getfield 376	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   1096: invokevirtual 249	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1099: ifeq +13 -> 1112
    //   1102: aload 24
    //   1104: iload 6
    //   1106: invokeinterface 379 2 0
    //   1111: pop
    //   1112: iload 6
    //   1114: iconst_1
    //   1115: isub
    //   1116: istore 6
    //   1118: goto -59 -> 1059
    //   1121: iload 5
    //   1123: iconst_1
    //   1124: iadd
    //   1125: istore 5
    //   1127: goto -93 -> 1034
    //   1130: aload_2
    //   1131: invokeinterface 206 1 0
    //   1136: aload_1
    //   1137: athrow
    //   1138: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1141: ifeq +12 -> 1153
    //   1144: ldc 75
    //   1146: iconst_2
    //   1147: ldc_w 381
    //   1150: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1153: aload 22
    //   1155: invokevirtual 217	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:close	()V
    //   1158: aload 23
    //   1160: ifnull +11 -> 1171
    //   1163: aload 23
    //   1165: invokevirtual 382	android/database/sqlite/SQLiteDatabase:close	()V
    //   1168: goto +3 -> 1171
    //   1171: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1174: ifeq +52 -> 1226
    //   1177: new 174	java/lang/StringBuilder
    //   1180: dup
    //   1181: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1184: astore_1
    //   1185: aload_1
    //   1186: ldc_w 384
    //   1189: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: pop
    //   1193: aload_1
    //   1194: invokestatic 237	java/lang/System:nanoTime	()J
    //   1197: lload 13
    //   1199: lsub
    //   1200: ldc2_w 385
    //   1203: ldiv
    //   1204: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1207: pop
    //   1208: aload_1
    //   1209: ldc_w 388
    //   1212: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: pop
    //   1216: ldc 75
    //   1218: iconst_2
    //   1219: aload_1
    //   1220: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1223: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1226: aload 24
    //   1228: areturn
    //   1229: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1232: ifeq +12 -> 1244
    //   1235: ldc 75
    //   1237: iconst_2
    //   1238: ldc_w 390
    //   1241: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1244: aconst_null
    //   1245: areturn
    //   1246: astore_1
    //   1247: goto -76 -> 1171
    //   1250: goto -632 -> 618
    //   1253: iconst_1
    //   1254: istore 21
    //   1256: goto -395 -> 861
    //   1259: goto -306 -> 953
    //   1262: goto -834 -> 428
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1265	0	this	MigrateSubscribeDB
    //   0	1265	1	paramString1	String
    //   0	1265	2	paramString2	String
    //   0	1265	3	paramList	List<MigrateSubscribeDB.SubscribeRecentData>
    //   0	1265	4	paramString3	String
    //   166	960	5	j	int
    //   121	996	6	k	int
    //   404	55	7	m	int
    //   426	52	8	n	int
    //   393	57	9	i1	int
    //   382	58	10	i2	int
    //   371	59	11	i3	int
    //   848	31	12	i4	int
    //   90	1108	13	l1	long
    //   436	77	15	l2	long
    //   474	347	17	l3	long
    //   484	107	19	l4	long
    //   856	399	21	bool	boolean
    //   13	1141	22	localObject1	Object
    //   102	1062	23	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   99	1128	24	localArrayList	ArrayList
    //   446	481	25	localObject2	Object
    //   499	276	26	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   748	755	758	java/lang/Exception
    //   763	784	787	java/lang/Exception
    //   428	615	989	java/lang/Exception
    //   618	690	989	java/lang/Exception
    //   690	710	989	java/lang/Exception
    //   715	748	989	java/lang/Exception
    //   759	763	989	java/lang/Exception
    //   788	792	989	java/lang/Exception
    //   792	844	989	java/lang/Exception
    //   861	878	989	java/lang/Exception
    //   885	900	989	java/lang/Exception
    //   903	950	989	java/lang/Exception
    //   953	962	989	java/lang/Exception
    //   965	980	989	java/lang/Exception
    //   353	428	993	finally
    //   428	615	993	finally
    //   618	690	993	finally
    //   690	710	993	finally
    //   715	748	993	finally
    //   748	755	993	finally
    //   759	763	993	finally
    //   763	784	993	finally
    //   788	792	993	finally
    //   792	844	993	finally
    //   861	878	993	finally
    //   885	900	993	finally
    //   903	950	993	finally
    //   953	962	993	finally
    //   965	980	993	finally
    //   998	1018	993	finally
    //   353	428	997	java/lang/Exception
    //   1163	1168	1246	java/lang/Exception
  }
  
  private List<String> a(List<MigrateSubscribeDB.SubscribeRecentData> paramList, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < paramList.size())
    {
      String str = ((MigrateSubscribeDB.SubscribeRecentData)paramList.get(j)).a;
      int k = 0;
      while (k < paramArrayOfString.length)
      {
        if (paramArrayOfString[k].equals(str))
        {
          localArrayList.add(str);
          break;
        }
        k += 1;
      }
      j += 1;
    }
    return localArrayList;
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
      int k = paramArrayOfString.length;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Migrate subscribe subscribeMsgIDs size: ");
        ((StringBuilder)localObject).append(k);
        QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject).toString());
      }
      int j = 0;
      while (j < k)
      {
        localObject = a(paramString1, paramArrayOfString[j], paramList, paramString2);
        a(paramArrayOfString[j], paramList, (List)localObject);
        c((List)localObject, paramEntityManager);
        j += 1;
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
      int k = paramList.size();
      if (QLog.isColorLevel())
      {
        paramList1 = new StringBuilder();
        paramList1.append("updateSubscribeRecentDataList subscribeRecentDataList size: ");
        paramList1.append(k);
        QLog.d("MigrateSubscribeDB", 2, paramList1.toString());
      }
      int j = 0;
      while (j < k)
      {
        if (((MigrateSubscribeDB.SubscribeRecentData)paramList.get(j)).a.equals(paramString))
        {
          paramString = (MigrateSubscribeDB.SubscribeRecentData)paramList.get(j);
          paramString.f = l;
          paramList.set(j, paramString);
          return;
        }
        j += 1;
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
    int k = paramList.size();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("migrateToTroopBar subscribeRecentDataList list size: ");
      ((StringBuilder)localObject1).append(k);
      QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject1).toString());
    }
    int j = 0;
    while (j < k)
    {
      localObject1 = (MigrateSubscribeDB.SubscribeRecentData)paramList.get(j);
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("migrateToTroopBar subscribeRecentData: ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject3 = SubscriptUtil.a(((MigrateSubscribeDB.SubscribeRecentData)localObject1).a);
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject2 = new TroopBarData();
        ((TroopBarData)localObject2).mUin = ((String)localObject3);
        ((TroopBarData)localObject2).mLastMsgTime = ((MigrateSubscribeDB.SubscribeRecentData)localObject1).f;
        ((TroopBarData)localObject2).mLastDraftTime = 0L;
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("migrateToTroopBar subscribeid[");
          ((StringBuilder)localObject3).append(((MigrateSubscribeDB.SubscribeRecentData)localObject1).a);
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
        ((StringBuilder)localObject2).append(((MigrateSubscribeDB.SubscribeRecentData)localObject1).a);
        ((StringBuilder)localObject2).append("]'s uin");
        QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject2).toString());
      }
      j += 1;
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
    boolean bool1 = a;
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
        localStringBuilder.append("8.8.17");
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
    //   4: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 75
    //   12: iconst_2
    //   13: ldc_w 501
    //   16: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: iconst_0
    //   20: ireturn
    //   21: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +42 -> 66
    //   27: new 174	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   34: astore 7
    //   36: aload 7
    //   38: ldc_w 503
    //   41: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 7
    //   47: aload_1
    //   48: invokevirtual 508	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: ldc 75
    //   57: iconst_2
    //   58: aload 7
    //   60: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: invokestatic 237	java/lang/System:nanoTime	()J
    //   69: lstore 4
    //   71: aload_1
    //   72: invokevirtual 511	java/io/File:getName	()Ljava/lang/String;
    //   75: astore 7
    //   77: aconst_null
    //   78: astore 8
    //   80: aconst_null
    //   81: astore 11
    //   83: aload_0
    //   84: getfield 31	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:h	Ljava/util/List;
    //   87: invokeinterface 513 1 0
    //   92: ifne +1563 -> 1655
    //   95: aload_0
    //   96: getfield 33	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:i	Ljava/util/List;
    //   99: invokeinterface 513 1 0
    //   104: ifeq +6 -> 110
    //   107: goto +1548 -> 1655
    //   110: aload 7
    //   112: ldc_w 515
    //   115: ldc_w 470
    //   118: invokevirtual 519	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   121: invokestatic 525	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   124: invokestatic 529	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   127: astore 14
    //   129: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +40 -> 172
    //   135: new 174	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   142: astore 7
    //   144: aload 7
    //   146: ldc_w 531
    //   149: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 7
    //   155: aload 14
    //   157: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: ldc 75
    //   163: iconst_2
    //   164: aload 7
    //   166: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_0
    //   173: getfield 31	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:h	Ljava/util/List;
    //   176: invokeinterface 513 1 0
    //   181: istore 6
    //   183: iload 6
    //   185: ifne +209 -> 394
    //   188: aload_0
    //   189: getfield 31	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:h	Ljava/util/List;
    //   192: invokeinterface 535 1 0
    //   197: astore 9
    //   199: aload 9
    //   201: invokeinterface 540 1 0
    //   206: ifeq +1640 -> 1846
    //   209: aload 9
    //   211: invokeinterface 544 1 0
    //   216: checkcast 505	java/io/File
    //   219: invokevirtual 511	java/io/File:getName	()Ljava/lang/String;
    //   222: astore 7
    //   224: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +40 -> 267
    //   230: new 174	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   237: astore 10
    //   239: aload 10
    //   241: ldc_w 546
    //   244: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 10
    //   250: aload 7
    //   252: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: ldc 75
    //   258: iconst_2
    //   259: aload 10
    //   261: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: aload 7
    //   269: aload 14
    //   271: invokevirtual 549	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   274: ifeq +57 -> 331
    //   277: aload 7
    //   279: astore 10
    //   281: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   284: ifeq +128 -> 412
    //   287: new 174	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   294: astore 9
    //   296: aload 9
    //   298: ldc_w 551
    //   301: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 9
    //   307: aload 7
    //   309: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: ldc 75
    //   315: iconst_2
    //   316: aload 9
    //   318: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload 7
    //   326: astore 10
    //   328: goto +84 -> 412
    //   331: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   334: ifeq -135 -> 199
    //   337: new 174	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   344: astore 10
    //   346: aload 10
    //   348: ldc_w 553
    //   351: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload 10
    //   357: aload 7
    //   359: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload 10
    //   365: ldc_w 555
    //   368: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 10
    //   374: aload 14
    //   376: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: ldc 75
    //   382: iconst_2
    //   383: aload 10
    //   385: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: goto -192 -> 199
    //   394: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +1449 -> 1846
    //   400: ldc 75
    //   402: iconst_2
    //   403: ldc_w 557
    //   406: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: goto +1437 -> 1846
    //   412: aload_0
    //   413: getfield 33	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:i	Ljava/util/List;
    //   416: invokeinterface 513 1 0
    //   421: ifne +209 -> 630
    //   424: aload_0
    //   425: getfield 33	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:i	Ljava/util/List;
    //   428: invokeinterface 535 1 0
    //   433: astore 9
    //   435: aload 9
    //   437: invokeinterface 540 1 0
    //   442: ifeq +1410 -> 1852
    //   445: aload 9
    //   447: invokeinterface 544 1 0
    //   452: checkcast 505	java/io/File
    //   455: invokevirtual 511	java/io/File:getName	()Ljava/lang/String;
    //   458: astore 7
    //   460: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   463: ifeq +40 -> 503
    //   466: new 174	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   473: astore 12
    //   475: aload 12
    //   477: ldc_w 559
    //   480: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 12
    //   486: aload 7
    //   488: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: ldc 75
    //   494: iconst_2
    //   495: aload 12
    //   497: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   503: aload 7
    //   505: aload 14
    //   507: invokevirtual 549	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   510: ifeq +57 -> 567
    //   513: aload 7
    //   515: astore 12
    //   517: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   520: ifeq +128 -> 648
    //   523: new 174	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   530: astore 9
    //   532: aload 9
    //   534: ldc_w 561
    //   537: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 9
    //   543: aload 7
    //   545: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: ldc 75
    //   551: iconst_2
    //   552: aload 9
    //   554: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: aload 7
    //   562: astore 12
    //   564: goto +84 -> 648
    //   567: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq -135 -> 435
    //   573: new 174	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   580: astore 12
    //   582: aload 12
    //   584: ldc_w 563
    //   587: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload 12
    //   593: aload 7
    //   595: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload 12
    //   601: ldc_w 555
    //   604: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload 12
    //   610: aload 14
    //   612: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: ldc 75
    //   618: iconst_2
    //   619: aload 12
    //   621: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   627: goto -192 -> 435
    //   630: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   633: ifeq +1219 -> 1852
    //   636: ldc 75
    //   638: iconst_2
    //   639: ldc_w 565
    //   642: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   645: goto +1207 -> 1852
    //   648: aload 12
    //   650: ifnonnull +20 -> 670
    //   653: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   656: ifeq +1202 -> 1858
    //   659: ldc 75
    //   661: iconst_2
    //   662: ldc_w 567
    //   665: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   668: iconst_1
    //   669: ireturn
    //   670: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   673: ifeq +57 -> 730
    //   676: new 174	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   683: astore 7
    //   685: aload 7
    //   687: ldc_w 569
    //   690: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: aload 7
    //   696: aload 10
    //   698: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: aload 7
    //   704: ldc_w 571
    //   707: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: pop
    //   711: aload 7
    //   713: aload 12
    //   715: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: ldc 75
    //   721: iconst_2
    //   722: aload 7
    //   724: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   730: aload 14
    //   732: invokestatic 576	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   735: astore 9
    //   737: aload 9
    //   739: invokevirtual 582	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   742: astore 7
    //   744: aload 7
    //   746: invokevirtual 586	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   749: astore 13
    //   751: aload 9
    //   753: aload 14
    //   755: invokevirtual 590	com/tencent/mobileqq/persistence/EntityManagerFactory:build	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   758: invokevirtual 596	com/tencent/mobileqq/app/SQLiteOpenHelper:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   761: astore 11
    //   763: aload_0
    //   764: getfield 37	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:d	Z
    //   767: istore 6
    //   769: iload 6
    //   771: ifne +90 -> 861
    //   774: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   777: ifeq +36 -> 813
    //   780: new 174	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   787: astore_1
    //   788: aload_1
    //   789: ldc_w 598
    //   792: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: aload_1
    //   797: aload 14
    //   799: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: ldc 75
    //   805: iconst_2
    //   806: aload_1
    //   807: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   810: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   813: aload 11
    //   815: ifnull +8 -> 823
    //   818: aload 11
    //   820: invokevirtual 601	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   823: aload 7
    //   825: ifnull +8 -> 833
    //   828: aload 7
    //   830: invokevirtual 602	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   833: aload 9
    //   835: ifnull +8 -> 843
    //   838: aload 9
    //   840: invokevirtual 603	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
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
    //   861: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   864: istore 6
    //   866: iload 6
    //   868: ifeq +90 -> 958
    //   871: new 174	java/lang/StringBuilder
    //   874: dup
    //   875: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   878: astore 8
    //   880: aload 8
    //   882: ldc_w 605
    //   885: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: pop
    //   889: aload 8
    //   891: aload 14
    //   893: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload 8
    //   899: ldc_w 607
    //   902: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: pop
    //   906: aload 8
    //   908: aload_1
    //   909: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   912: pop
    //   913: aload 8
    //   915: ldc_w 609
    //   918: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload 8
    //   924: aload 10
    //   926: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: pop
    //   930: aload 8
    //   932: ldc_w 611
    //   935: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: pop
    //   939: aload 8
    //   941: aload 12
    //   943: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: pop
    //   947: ldc 75
    //   949: iconst_2
    //   950: aload 8
    //   952: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   955: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   958: aload 13
    //   960: invokevirtual 616	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   963: aload 7
    //   965: astore_1
    //   966: aload 7
    //   968: astore 8
    //   970: aload_0
    //   971: aload 12
    //   973: invokespecial 618	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)Ljava/util/List;
    //   976: astore 12
    //   978: aload 7
    //   980: astore_1
    //   981: aload 7
    //   983: astore 8
    //   985: aload_0
    //   986: aload 12
    //   988: aload 7
    //   990: invokespecial 620	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:b	(Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   993: aload 7
    //   995: astore_1
    //   996: aload 7
    //   998: astore 8
    //   1000: aload_0
    //   1001: aload 14
    //   1003: invokespecial 623	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:b	(Ljava/lang/String;)V
    //   1006: aload 10
    //   1008: ifnull +62 -> 1070
    //   1011: aload 7
    //   1013: astore_1
    //   1014: aload 7
    //   1016: astore 8
    //   1018: aload_0
    //   1019: aload 10
    //   1021: invokespecial 626	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	(Ljava/lang/String;)[Ljava/lang/String;
    //   1024: astore 15
    //   1026: aload_0
    //   1027: aload 10
    //   1029: aload 14
    //   1031: aload 15
    //   1033: aload 12
    //   1035: aload 7
    //   1037: invokespecial 628	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
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
    //   1077: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1080: ifeq +19 -> 1099
    //   1083: aload 7
    //   1085: astore_1
    //   1086: aload 7
    //   1088: astore 8
    //   1090: ldc 75
    //   1092: iconst_2
    //   1093: ldc_w 630
    //   1096: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1099: aload 7
    //   1101: astore 10
    //   1103: aload 7
    //   1105: astore_1
    //   1106: aload 7
    //   1108: astore 8
    //   1110: aload_0
    //   1111: getfield 31	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:h	Ljava/util/List;
    //   1114: invokeinterface 513 1 0
    //   1119: ifne +306 -> 1425
    //   1122: aload 7
    //   1124: astore_1
    //   1125: aload 7
    //   1127: astore 8
    //   1129: aload_0
    //   1130: getfield 31	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:h	Ljava/util/List;
    //   1133: invokeinterface 535 1 0
    //   1138: astore 15
    //   1140: aload 7
    //   1142: astore 10
    //   1144: aload 7
    //   1146: astore_1
    //   1147: aload 7
    //   1149: astore 8
    //   1151: aload 15
    //   1153: invokeinterface 540 1 0
    //   1158: ifeq +267 -> 1425
    //   1161: aload 7
    //   1163: astore_1
    //   1164: aload 7
    //   1166: astore 8
    //   1168: aload 15
    //   1170: invokeinterface 544 1 0
    //   1175: checkcast 505	java/io/File
    //   1178: invokevirtual 511	java/io/File:getName	()Ljava/lang/String;
    //   1181: astore 10
    //   1183: aload 7
    //   1185: astore_1
    //   1186: aload 7
    //   1188: astore 8
    //   1190: aload_0
    //   1191: aload 10
    //   1193: invokespecial 626	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   1215: invokespecial 632	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/util/List;[Ljava/lang/String;)Ljava/util/List;
    //   1218: invokeinterface 240 1 0
    //   1223: istore_3
    //   1224: iload_3
    //   1225: ifne +6 -> 1231
    //   1228: goto -88 -> 1140
    //   1231: aload 7
    //   1233: astore_1
    //   1234: aload 7
    //   1236: astore 8
    //   1238: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1241: ifeq +99 -> 1340
    //   1244: aload 7
    //   1246: astore_1
    //   1247: aload 7
    //   1249: astore 8
    //   1251: new 174	java/lang/StringBuilder
    //   1254: dup
    //   1255: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1258: astore 16
    //   1260: aload 7
    //   1262: astore_1
    //   1263: aload 7
    //   1265: astore 8
    //   1267: aload 16
    //   1269: ldc_w 634
    //   1272: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: pop
    //   1276: aload 7
    //   1278: astore_1
    //   1279: aload 7
    //   1281: astore 8
    //   1283: aload 16
    //   1285: aload 14
    //   1287: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: pop
    //   1291: aload 7
    //   1293: astore_1
    //   1294: aload 7
    //   1296: astore 8
    //   1298: aload 16
    //   1300: ldc_w 636
    //   1303: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: pop
    //   1307: aload 7
    //   1309: astore_1
    //   1310: aload 7
    //   1312: astore 8
    //   1314: aload 16
    //   1316: aload 10
    //   1318: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1321: pop
    //   1322: aload 7
    //   1324: astore_1
    //   1325: aload 7
    //   1327: astore 8
    //   1329: ldc 75
    //   1331: iconst_2
    //   1332: aload 16
    //   1334: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1337: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1340: aload 7
    //   1342: astore_1
    //   1343: aload 7
    //   1345: astore 8
    //   1347: iload_3
    //   1348: anewarray 51	java/lang/String
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
    //   1373: invokeinterface 246 2 0
    //   1378: checkcast 134	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData
    //   1381: getfield 163	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$SubscribeRecentData:a	Ljava/lang/String;
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
    //   1406: invokespecial 628	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
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
    //   1435: invokespecial 638	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1438: aload_1
    //   1439: astore 8
    //   1441: aload 13
    //   1443: invokevirtual 641	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   1446: aload_1
    //   1447: astore 7
    //   1449: aload 7
    //   1451: astore 8
    //   1453: aload 7
    //   1455: astore 10
    //   1457: aload 13
    //   1459: invokevirtual 644	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
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
    //   1485: invokevirtual 209	java/lang/Exception:printStackTrace	()V
    //   1488: aload_1
    //   1489: astore 7
    //   1491: aload_1
    //   1492: astore 8
    //   1494: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1497: ifeq -48 -> 1449
    //   1500: aload_1
    //   1501: astore 8
    //   1503: ldc 75
    //   1505: iconst_2
    //   1506: ldc_w 646
    //   1509: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1512: aload_1
    //   1513: astore 7
    //   1515: goto -66 -> 1449
    //   1518: aload 11
    //   1520: ifnull +8 -> 1528
    //   1523: aload 11
    //   1525: invokevirtual 601	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   1528: aload 7
    //   1530: ifnull +8 -> 1538
    //   1533: aload 7
    //   1535: invokevirtual 602	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1538: aload 9
    //   1540: ifnull +203 -> 1743
    //   1543: aload 9
    //   1545: invokevirtual 603	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   1548: goto +195 -> 1743
    //   1551: astore 7
    //   1553: aload 8
    //   1555: astore_1
    //   1556: aload_1
    //   1557: astore 8
    //   1559: aload_1
    //   1560: astore 10
    //   1562: aload 13
    //   1564: invokevirtual 644	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
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
    //   1655: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1658: ifeq +12 -> 1670
    //   1661: ldc 75
    //   1663: iconst_2
    //   1664: ldc_w 648
    //   1667: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1697: invokevirtual 209	java/lang/Exception:printStackTrace	()V
    //   1700: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1703: ifeq +12 -> 1715
    //   1706: ldc 75
    //   1708: iconst_2
    //   1709: ldc_w 650
    //   1712: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1715: aload 8
    //   1717: ifnull +8 -> 1725
    //   1720: aload 8
    //   1722: invokevirtual 601	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   1725: aload 7
    //   1727: ifnull +8 -> 1735
    //   1730: aload 7
    //   1732: invokevirtual 602	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1735: aload_1
    //   1736: ifnull +7 -> 1743
    //   1739: aload_1
    //   1740: invokevirtual 603	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   1743: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1746: ifeq +52 -> 1798
    //   1749: new 174	java/lang/StringBuilder
    //   1752: dup
    //   1753: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1756: astore_1
    //   1757: aload_1
    //   1758: ldc_w 652
    //   1761: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: pop
    //   1765: aload_1
    //   1766: invokestatic 237	java/lang/System:nanoTime	()J
    //   1769: lload 4
    //   1771: lsub
    //   1772: ldc2_w 385
    //   1775: ldiv
    //   1776: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1779: pop
    //   1780: aload_1
    //   1781: ldc_w 654
    //   1784: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1787: pop
    //   1788: ldc 75
    //   1790: iconst_2
    //   1791: aload_1
    //   1792: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1795: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1815: invokevirtual 601	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   1818: aload 7
    //   1820: ifnull +8 -> 1828
    //   1823: aload 7
    //   1825: invokevirtual 602	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1828: aload 9
    //   1830: ifnull +8 -> 1838
    //   1833: aload 9
    //   1835: invokevirtual 603	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
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
    //   1354	35	2	j	int
    //   1223	135	3	k	int
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
  
  private void b()
  {
    Object localObject1 = this.g;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = this.b;
      localObject1 = BaseApplicationImpl.getApplication().getAllAccounts();
      if (localObject1 == null) {}
    }
    for (;;)
    {
      int j;
      try
      {
        Object localObject3 = this.b.getRuntime().getAccount();
        HashMap localHashMap = new HashMap(this.g.size());
        Object localObject2 = this.g.iterator();
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
        localObject2 = new ArrayList(this.g.size());
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
        int k = ((List)localObject1).size();
        j = 0;
        if (j < k)
        {
          localObject3 = (SimpleAccount)((List)localObject1).get(j);
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
        this.g = ((List)localObject2);
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
      j += 1;
    }
  }
  
  private void b(String paramString)
  {
    long l = System.nanoTime();
    Object localObject1 = BaseApplicationImpl.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("readinjoy_");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(1);
    localObject2 = ((StringBuilder)localObject2).toString();
    int k = 0;
    int m = ((BaseApplicationImpl)localObject1).getSharedPreferences((String)localObject2, 0).getInt("updated_msg_count", 0);
    if (m == 0)
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
      ((StringBuilder)localObject1).append(m);
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
      int j;
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        j = k;
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("updateFolderUnReadCount jsonArray length: ");
          ((StringBuilder)localObject3).append(((JSONArray)localObject2).length());
          QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject3).toString());
          j = k;
        }
        Object localObject4;
        String str;
        if (j < ((JSONArray)localObject2).length())
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(j);
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
        ((ConcurrentHashMap)localObject1).put(AppConstants.READINJOY_UIN, Integer.valueOf(m));
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
      j += 1;
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
    int j = paramList.size();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("migrateToCoversationInfo subscribeRecentDataList list size: ");
      ((StringBuilder)localObject).append(j);
      QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject).toString());
    }
    j = 0;
    while (j < paramList.size())
    {
      MigrateSubscribeDB.SubscribeRecentData localSubscribeRecentData = (MigrateSubscribeDB.SubscribeRecentData)paramList.get(j);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("migrateToCoversationInfo subscribeRecentData: ");
        ((StringBuilder)localObject).append(localSubscribeRecentData);
        QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject).toString());
      }
      String str = SubscriptUtil.a(localSubscribeRecentData.a);
      if (!TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("migrateToCoversationInfo find subscribeID[");
          ((StringBuilder)localObject).append(localSubscribeRecentData.a);
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
          int k;
          if (localList != null) {
            k = localList.size();
          } else {
            k = 0;
          }
          localStringBuilder.append(k);
          QLog.d("MigrateSubscribeDB", 2, localStringBuilder.toString());
        }
        if ((localList != null) && (localList.size() > 0))
        {
          localObject = (ConversationInfo)localList.get(0);
          ((ConversationInfo)localObject).uin = str;
          ((ConversationInfo)localObject).setUnread(((ConversationInfo)localObject).unreadCount + localSubscribeRecentData.j);
          ((ConversationInfo)localObject).setType(1008);
        }
        else
        {
          ((ConversationInfo)localObject).uin = str;
          ((ConversationInfo)localObject).setUnread(localSubscribeRecentData.j);
          ((ConversationInfo)localObject).setType(1008);
        }
        paramEntityManager.persistOrReplace((Entity)localObject);
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("migrateToCoversationInfo we can't subscribeid[");
        ((StringBuilder)localObject).append(localSubscribeRecentData.a);
        ((StringBuilder)localObject).append("]'s uin");
        QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject).toString());
      }
      j += 1;
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
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "begin getMigrateDBFiles.");
    }
    long l = System.nanoTime();
    this.g = new ArrayList();
    this.h = new ArrayList();
    this.i = new ArrayList();
    Object localObject1 = Pattern.compile("^\\d+\\.db$");
    Pattern localPattern1 = Pattern.compile("^readinjoy_main_\\d+$");
    Pattern localPattern2 = Pattern.compile("^readinjoy_\\d+\\.db$");
    String str = this.b.getFilesDir().getPath();
    Object localObject2 = new StringBuilder();
    int k = str.lastIndexOf("/");
    int j = 0;
    ((StringBuilder)localObject2).append(str.substring(0, k));
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
      k = localObject2.length;
      while (j < k)
      {
        localStringBuilder1 = localObject2[j];
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
          this.g.add(localStringBuilder1);
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
          this.h.add(localStringBuilder1);
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
          this.i.add(localStringBuilder1);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getMigrateDBFiles mReadInJoySubDBFiles ");
            ((StringBuilder)localObject3).append(localStringBuilder1);
            QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject3).toString());
          }
        }
        j += 1;
      }
      Collections.sort(this.g, new MigrateSubscribeDB.1(this));
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
  
  private void c(List<MessageRecord> paramList, EntityManager paramEntityManager)
  {
    long l = System.nanoTime();
    if (paramList == null) {
      return;
    }
    int j = 0;
    while (j < paramList.size())
    {
      paramEntityManager.persistOrReplace((MessageRecord)paramList.get(j));
      j += 1;
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
  
  /* Error */
  private String[] c(String paramString)
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
    //   12: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +12 -> 27
    //   18: ldc 75
    //   20: iconst_2
    //   21: ldc_w 930
    //   24: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aconst_null
    //   28: areturn
    //   29: invokestatic 88	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   32: astore 4
    //   34: new 82	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper
    //   37: dup
    //   38: aload_0
    //   39: aload 4
    //   41: aload_1
    //   42: bipush 80
    //   44: invokespecial 91	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Landroid/content/Context;Ljava/lang/String;I)V
    //   47: astore 6
    //   49: aload 6
    //   51: invokevirtual 95	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   54: astore 4
    //   56: aload 4
    //   58: ldc_w 932
    //   61: aconst_null
    //   62: invokevirtual 103	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore 5
    //   67: aload 5
    //   69: ifnull +179 -> 248
    //   72: aload 8
    //   74: astore_1
    //   75: aload 5
    //   77: invokeinterface 108 1 0
    //   82: ifeq +136 -> 218
    //   85: aload 8
    //   87: astore_1
    //   88: aload 5
    //   90: invokeinterface 935 1 0
    //   95: anewarray 51	java/lang/String
    //   98: astore_3
    //   99: iconst_0
    //   100: istore_2
    //   101: aload_3
    //   102: astore_1
    //   103: aload_3
    //   104: iload_2
    //   105: aload 5
    //   107: iconst_0
    //   108: invokeinterface 141 2 0
    //   113: aastore
    //   114: aload_3
    //   115: astore_1
    //   116: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +80 -> 199
    //   122: aload_3
    //   123: astore_1
    //   124: new 174	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   131: astore 7
    //   133: aload_3
    //   134: astore_1
    //   135: aload 7
    //   137: ldc_w 937
    //   140: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload_3
    //   145: astore_1
    //   146: aload 7
    //   148: iload_2
    //   149: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload_3
    //   154: astore_1
    //   155: aload 7
    //   157: ldc_w 939
    //   160: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_3
    //   165: astore_1
    //   166: aload 7
    //   168: aload_3
    //   169: iload_2
    //   170: aaload
    //   171: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_3
    //   176: astore_1
    //   177: aload 7
    //   179: ldc_w 895
    //   182: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload_3
    //   187: astore_1
    //   188: ldc 75
    //   190: iconst_2
    //   191: aload 7
    //   193: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: iload_2
    //   200: iconst_1
    //   201: iadd
    //   202: istore_2
    //   203: aload_3
    //   204: astore_1
    //   205: aload 5
    //   207: invokeinterface 201 1 0
    //   212: ifne -111 -> 101
    //   215: goto +60 -> 275
    //   218: aload 7
    //   220: astore_3
    //   221: aload 8
    //   223: astore_1
    //   224: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +48 -> 275
    //   230: aload 8
    //   232: astore_1
    //   233: ldc 75
    //   235: iconst_2
    //   236: ldc_w 941
    //   239: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: aload 7
    //   244: astore_3
    //   245: goto +30 -> 275
    //   248: aload 7
    //   250: astore_3
    //   251: aload 8
    //   253: astore_1
    //   254: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq +18 -> 275
    //   260: aload 8
    //   262: astore_1
    //   263: ldc 75
    //   265: iconst_2
    //   266: ldc_w 943
    //   269: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload 7
    //   274: astore_3
    //   275: aload 5
    //   277: ifnull +13 -> 290
    //   280: aload 5
    //   282: invokeinterface 206 1 0
    //   287: goto +3 -> 290
    //   290: aload 4
    //   292: ifnull +8 -> 300
    //   295: aload 4
    //   297: invokevirtual 382	android/database/sqlite/SQLiteDatabase:close	()V
    //   300: aload 6
    //   302: invokevirtual 217	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:close	()V
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
    //   398: invokevirtual 209	java/lang/Exception:printStackTrace	()V
    //   401: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   404: ifeq +14 -> 418
    //   407: ldc 75
    //   409: iconst_2
    //   410: ldc_w 945
    //   413: aload 5
    //   415: invokestatic 214	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   418: aload_1
    //   419: ifnull +12 -> 431
    //   422: aload_1
    //   423: invokeinterface 206 1 0
    //   428: goto +3 -> 431
    //   431: aload_3
    //   432: ifnull +10 -> 442
    //   435: aload_3
    //   436: invokevirtual 382	android/database/sqlite/SQLiteDatabase:close	()V
    //   439: goto +3 -> 442
    //   442: aload 6
    //   444: ifnull +8 -> 452
    //   447: aload 6
    //   449: invokevirtual 217	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:close	()V
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
    //   470: invokeinterface 206 1 0
    //   475: goto +3 -> 478
    //   478: aload 4
    //   480: ifnull +11 -> 491
    //   483: aload 4
    //   485: invokevirtual 382	android/database/sqlite/SQLiteDatabase:close	()V
    //   488: goto +3 -> 491
    //   491: aload 6
    //   493: ifnull +8 -> 501
    //   496: aload 6
    //   498: invokevirtual 217	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$ReadInJoyDBHelper:close	()V
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
    //   100	103	2	j	int
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
  
  private int d()
  {
    return (short)Math.abs(new Random().nextInt()) & 0xFFFF;
  }
  
  private long e()
  {
    return MessageUtils.a(Math.abs(new Random().nextInt()) | 0x0);
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
    this.b = BaseApplicationImpl.sApplication;
    if (this.b == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "doStep fail app is null");
      }
      return super.doStep();
    }
    a = true;
    this.c = 40000;
    long l = System.nanoTime();
    c();
    if (!this.g.isEmpty())
    {
      b();
      localObject = this.g.iterator();
      while (((Iterator)localObject).hasNext())
      {
        File localFile = (File)((Iterator)localObject).next();
        if (!this.d)
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
        this.f += 1L;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doStep Migrate subscribe db total cost = ");
      ((StringBuilder)localObject).append((System.nanoTime() - l) / 1000000L);
      ((StringBuilder)localObject).append(" ms  and Migrate ");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append(" times ");
      QLog.d("MigrateSubscribeDB", 2, ((StringBuilder)localObject).toString());
    }
    return super.doStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.MigrateSubscribeDB
 * JD-Core Version:    0.7.0.1
 */