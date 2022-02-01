package com.tencent.mobileqq.fts.api.impl;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.QQEntityManagerFactory.Builder;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.fts.data.troop.FTSTroopSync;
import com.tencent.mobileqq.fts.data.troop.FTSTroopTime;
import com.tencent.mobileqq.fts.interfaces.IFTSConfig;
import com.tencent.mobileqq.fts.interfaces.IFTSConfig.DefaultConfig;
import com.tencent.mobileqq.fts.operator.FTSIndexOperator;
import com.tencent.mobileqq.fts.operator.FTSMsgOperator;
import com.tencent.mobileqq.fts.operator.FTSNewTroopOperator;
import com.tencent.mobileqq.fts.operator.FTSSyncHandler;
import com.tencent.mobileqq.fts.operator.FTSTroopOperator;
import com.tencent.mobileqq.fts.utils.FTSUtils;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.DBBuildUtil;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class FTSDBRuntimeServiceImpl
  implements IFTSDBRuntimeService
{
  public static final boolean DEBUG_SWITH = false;
  public static volatile boolean ENABLE = true;
  private static final String TAG = "Q.fts.manager";
  private int dpcFlag = -1;
  public volatile boolean isDestroyed = false;
  private volatile boolean isInit = false;
  private final AtomicBoolean isNotDestroying = new AtomicBoolean(true);
  private AppRuntime mApp;
  private FTSDatatbase mDatabase;
  private FTSDatabase mDatabaseV2;
  private IFTSConfig mIFTSConfig;
  private ConcurrentHashMap<Integer, FTSIndexOperator> mOperators = new ConcurrentHashMap();
  public FTSSyncHandler mSyncHandler;
  private HandlerThread mSyncThread;
  private volatile int retryCount = 0;
  
  public FTSDBRuntimeServiceImpl() {}
  
  public FTSDBRuntimeServiceImpl(AppRuntime paramAppRuntime)
  {
    init(paramAppRuntime);
  }
  
  private void destroyInner()
  {
    try
    {
      this.isDestroyed = true;
      this.isInit = false;
      this.mSyncHandler.a();
      this.mSyncThread.quit();
      Iterator localIterator = this.mOperators.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        ((FTSIndexOperator)this.mOperators.get(Integer.valueOf(i))).d();
      }
      if (this.mDatabase != null) {
        this.mDatabase.b();
      }
      if (this.mDatabaseV2 != null) {
        this.mDatabaseV2.a();
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.manager", 2, "FTSDBManager destroy...");
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  /* Error */
  private void init()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 71	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mApp	Lmqq/app/AppRuntime;
    //   4: iconst_0
    //   5: invokestatic 172	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;Z)V
    //   8: aload_0
    //   9: getfield 47	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:isInit	Z
    //   12: ifne +837 -> 849
    //   15: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +311 -> 329
    //   21: aconst_null
    //   22: astore 4
    //   24: aconst_null
    //   25: astore 5
    //   27: aconst_null
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 7
    //   33: ldc 174
    //   35: aconst_null
    //   36: invokestatic 180	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   39: astore_3
    //   40: aload 7
    //   42: astore 4
    //   44: aload 6
    //   46: astore 5
    //   48: aload_3
    //   49: ldc 182
    //   51: aconst_null
    //   52: invokevirtual 186	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore 6
    //   57: ldc 188
    //   59: astore 7
    //   61: aload 6
    //   63: astore 4
    //   65: aload 6
    //   67: astore 5
    //   69: aload 6
    //   71: invokeinterface 193 1 0
    //   76: ifeq +76 -> 152
    //   79: aload 6
    //   81: astore 4
    //   83: aload 6
    //   85: astore 5
    //   87: new 195	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   94: astore 8
    //   96: aload 6
    //   98: astore 4
    //   100: aload 6
    //   102: astore 5
    //   104: aload 8
    //   106: aload 7
    //   108: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 6
    //   114: astore 4
    //   116: aload 6
    //   118: astore 5
    //   120: aload 8
    //   122: aload 6
    //   124: iconst_0
    //   125: invokeinterface 204 2 0
    //   130: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 6
    //   136: astore 4
    //   138: aload 6
    //   140: astore 5
    //   142: aload 8
    //   144: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: astore 7
    //   149: goto -88 -> 61
    //   152: aload 6
    //   154: astore 4
    //   156: aload 6
    //   158: astore 5
    //   160: new 195	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   167: astore 8
    //   169: aload 6
    //   171: astore 4
    //   173: aload 6
    //   175: astore 5
    //   177: aload 8
    //   179: ldc 210
    //   181: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 6
    //   187: astore 4
    //   189: aload 6
    //   191: astore 5
    //   193: aload 8
    //   195: invokestatic 215	com/tencent/mobileqq/utils/DeviceInfoUtil:e	()Ljava/lang/String;
    //   198: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 6
    //   204: astore 4
    //   206: aload 6
    //   208: astore 5
    //   210: aload 8
    //   212: ldc 217
    //   214: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 6
    //   220: astore 4
    //   222: aload 6
    //   224: astore 5
    //   226: aload 8
    //   228: aload 7
    //   230: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 6
    //   236: astore 4
    //   238: aload 6
    //   240: astore 5
    //   242: ldc 15
    //   244: iconst_2
    //   245: aload 8
    //   247: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload 6
    //   255: ifnull +10 -> 265
    //   258: aload 6
    //   260: invokeinterface 220 1 0
    //   265: aload_3
    //   266: ifnull +63 -> 329
    //   269: goto +56 -> 325
    //   272: astore 5
    //   274: goto +10 -> 284
    //   277: goto +32 -> 309
    //   280: astore 5
    //   282: aconst_null
    //   283: astore_3
    //   284: aload 4
    //   286: ifnull +10 -> 296
    //   289: aload 4
    //   291: invokeinterface 220 1 0
    //   296: aload_3
    //   297: ifnull +7 -> 304
    //   300: aload_3
    //   301: invokevirtual 221	android/database/sqlite/SQLiteDatabase:close	()V
    //   304: aload 5
    //   306: athrow
    //   307: aconst_null
    //   308: astore_3
    //   309: aload 5
    //   311: ifnull +10 -> 321
    //   314: aload 5
    //   316: invokeinterface 220 1 0
    //   321: aload_3
    //   322: ifnull +7 -> 329
    //   325: aload_3
    //   326: invokevirtual 221	android/database/sqlite/SQLiteDatabase:close	()V
    //   329: getstatic 226	android/os/Build$VERSION:SDK_INT	I
    //   332: bipush 18
    //   334: if_icmpge +122 -> 456
    //   337: aload_0
    //   338: getfield 71	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mApp	Lmqq/app/AppRuntime;
    //   341: invokestatic 230	com/tencent/mobileqq/fts/utils/FTSUtils:c	(Lmqq/app/AppRuntime;)I
    //   344: istore_2
    //   345: aload_0
    //   346: getfield 71	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mApp	Lmqq/app/AppRuntime;
    //   349: iload_2
    //   350: iconst_1
    //   351: iadd
    //   352: invokestatic 233	com/tencent/mobileqq/fts/utils/FTSUtils:b	(Lmqq/app/AppRuntime;I)V
    //   355: new 195	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   362: astore_3
    //   363: aload_3
    //   364: ldc 235
    //   366: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload_3
    //   371: iload_2
    //   372: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: ldc 15
    //   378: iconst_1
    //   379: aload_3
    //   380: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: iload_2
    //   387: iconst_5
    //   388: if_icmplt +46 -> 434
    //   391: iload_2
    //   392: sipush 200
    //   395: if_icmpge +39 -> 434
    //   398: new 195	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   405: astore_3
    //   406: aload_3
    //   407: ldc 240
    //   409: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload_3
    //   414: iload_2
    //   415: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: ldc 15
    //   421: iconst_1
    //   422: aload_3
    //   423: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 243	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: iconst_0
    //   430: putstatic 245	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:ENABLE	Z
    //   433: return
    //   434: iload_2
    //   435: istore_1
    //   436: iload_2
    //   437: sipush 200
    //   440: if_icmplt +18 -> 458
    //   443: aload_0
    //   444: getfield 71	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mApp	Lmqq/app/AppRuntime;
    //   447: iconst_0
    //   448: invokestatic 233	com/tencent/mobileqq/fts/utils/FTSUtils:b	(Lmqq/app/AppRuntime;I)V
    //   451: iload_2
    //   452: istore_1
    //   453: goto +5 -> 458
    //   456: iconst_0
    //   457: istore_1
    //   458: aload_0
    //   459: getfield 149	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mDatabaseV2	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   462: astore_3
    //   463: aload_3
    //   464: ifnull +7 -> 471
    //   467: aload_3
    //   468: invokevirtual 152	com/tencent/mobileqq/fts/FTSDatabase:a	()V
    //   471: aload_0
    //   472: getfield 142	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mDatabase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   475: astore_3
    //   476: aload_3
    //   477: ifnull +7 -> 484
    //   480: aload_3
    //   481: invokevirtual 147	com/tencent/mobileqq/persistence/fts/FTSDatatbase:b	()V
    //   484: ldc 15
    //   486: iconst_1
    //   487: ldc 247
    //   489: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   492: aload_0
    //   493: new 144	com/tencent/mobileqq/persistence/fts/FTSDatatbase
    //   496: dup
    //   497: aload_0
    //   498: getfield 71	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mApp	Lmqq/app/AppRuntime;
    //   501: invokespecial 249	com/tencent/mobileqq/persistence/fts/FTSDatatbase:<init>	(Lmqq/app/AppRuntime;)V
    //   504: putfield 142	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mDatabase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   507: new 251	com/tencent/mobileqq/fts/v2/logger/QLogger
    //   510: dup
    //   511: invokespecial 252	com/tencent/mobileqq/fts/v2/logger/QLogger:<init>	()V
    //   514: invokestatic 255	com/tencent/mobileqq/fts/FTSDatabase:a	(Lcom/tencent/mobileqq/fts/v2/logger/ILogger;)V
    //   517: aload_0
    //   518: new 257	com/tencent/mobileqq/fts/v2/QFTSDatabase
    //   521: dup
    //   522: invokespecial 258	com/tencent/mobileqq/fts/v2/QFTSDatabase:<init>	()V
    //   525: putfield 149	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mDatabaseV2	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   528: aload_0
    //   529: getfield 142	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mDatabase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   532: invokevirtual 259	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	()V
    //   535: new 195	java/lang/StringBuilder
    //   538: dup
    //   539: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   542: astore_3
    //   543: aload_3
    //   544: aload_0
    //   545: getfield 71	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mApp	Lmqq/app/AppRuntime;
    //   548: invokevirtual 265	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   551: invokevirtual 271	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   554: invokevirtual 276	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   557: ldc_w 278
    //   560: ldc_w 280
    //   563: invokevirtual 286	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   566: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload_3
    //   571: getstatic 289	java/io/File:separator	Ljava/lang/String;
    //   574: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload_3
    //   579: aload_0
    //   580: getfield 71	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mApp	Lmqq/app/AppRuntime;
    //   583: invokevirtual 292	mqq/app/AppRuntime:getCurrentAccountUin	()Ljava/lang/String;
    //   586: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload_3
    //   591: ldc_w 294
    //   594: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: aload_3
    //   599: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: astore_3
    //   603: aload_0
    //   604: getfield 149	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mDatabaseV2	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   607: aload_3
    //   608: invokevirtual 297	com/tencent/mobileqq/fts/FTSDatabase:a	(Ljava/lang/String;)V
    //   611: aload_0
    //   612: getfield 71	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mApp	Lmqq/app/AppRuntime;
    //   615: iconst_1
    //   616: invokestatic 299	com/tencent/mobileqq/fts/utils/FTSUtils:b	(Lmqq/app/AppRuntime;Z)V
    //   619: getstatic 226	android/os/Build$VERSION:SDK_INT	I
    //   622: bipush 18
    //   624: if_icmpge +43 -> 667
    //   627: new 195	java/lang/StringBuilder
    //   630: dup
    //   631: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   634: astore_3
    //   635: aload_3
    //   636: ldc_w 301
    //   639: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload_3
    //   644: iload_1
    //   645: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: ldc 15
    //   651: iconst_1
    //   652: aload_3
    //   653: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   656: invokestatic 243	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   659: aload_0
    //   660: getfield 71	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mApp	Lmqq/app/AppRuntime;
    //   663: iconst_0
    //   664: invokestatic 233	com/tencent/mobileqq/fts/utils/FTSUtils:b	(Lmqq/app/AppRuntime;I)V
    //   667: aload_0
    //   668: getfield 52	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mOperators	Ljava/util/concurrent/ConcurrentHashMap;
    //   671: invokevirtual 106	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   674: invokeinterface 112 1 0
    //   679: astore_3
    //   680: aload_3
    //   681: invokeinterface 117 1 0
    //   686: ifeq +136 -> 822
    //   689: aload_3
    //   690: invokeinterface 121 1 0
    //   695: checkcast 123	java/lang/Integer
    //   698: invokevirtual 127	java/lang/Integer:intValue	()I
    //   701: istore_1
    //   702: aload_0
    //   703: getfield 52	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mOperators	Ljava/util/concurrent/ConcurrentHashMap;
    //   706: iload_1
    //   707: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   710: invokevirtual 135	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   713: checkcast 137	com/tencent/mobileqq/fts/operator/FTSIndexOperator
    //   716: astore 4
    //   718: aload 4
    //   720: ifnonnull +52 -> 772
    //   723: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   726: ifeq +45 -> 771
    //   729: ldc 15
    //   731: iconst_2
    //   732: iconst_4
    //   733: anewarray 4	java/lang/Object
    //   736: dup
    //   737: iconst_0
    //   738: ldc_w 303
    //   741: aastore
    //   742: dup
    //   743: iconst_1
    //   744: iload_1
    //   745: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   748: aastore
    //   749: dup
    //   750: iconst_2
    //   751: ldc_w 305
    //   754: aastore
    //   755: dup
    //   756: iconst_3
    //   757: aload_0
    //   758: getfield 52	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mOperators	Ljava/util/concurrent/ConcurrentHashMap;
    //   761: invokevirtual 308	java/util/concurrent/ConcurrentHashMap:size	()I
    //   764: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   767: aastore
    //   768: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   771: return
    //   772: aload 4
    //   774: aload_0
    //   775: getfield 142	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mDatabase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   778: aload_0
    //   779: getfield 149	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:mDatabaseV2	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   782: invokevirtual 314	com/tencent/mobileqq/fts/operator/FTSIndexOperator:a	(Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;Lcom/tencent/mobileqq/fts/FTSDatabase;)Z
    //   785: ifne -105 -> 680
    //   788: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   791: ifeq +30 -> 821
    //   794: ldc 15
    //   796: iconst_2
    //   797: iconst_2
    //   798: anewarray 4	java/lang/Object
    //   801: dup
    //   802: iconst_0
    //   803: ldc_w 316
    //   806: aastore
    //   807: dup
    //   808: iconst_1
    //   809: aload 4
    //   811: invokevirtual 320	java/lang/Object:getClass	()Ljava/lang/Class;
    //   814: invokevirtual 325	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   817: aastore
    //   818: invokestatic 311	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   821: return
    //   822: aload_0
    //   823: iconst_1
    //   824: putfield 47	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:isInit	Z
    //   827: return
    //   828: astore_3
    //   829: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   832: ifeq +13 -> 845
    //   835: ldc 15
    //   837: iconst_2
    //   838: ldc_w 327
    //   841: aload_3
    //   842: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   845: iconst_0
    //   846: putstatic 245	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:ENABLE	Z
    //   849: return
    //   850: astore_3
    //   851: goto -544 -> 307
    //   854: astore 4
    //   856: goto -579 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	859	0	this	FTSDBRuntimeServiceImpl
    //   435	310	1	i	int
    //   344	108	2	j	int
    //   39	651	3	localObject1	Object
    //   828	14	3	localThrowable	java.lang.Throwable
    //   850	1	3	localException1	java.lang.Exception
    //   22	788	4	localObject2	Object
    //   854	1	4	localException2	java.lang.Exception
    //   25	216	5	localObject3	Object
    //   272	1	5	localObject4	Object
    //   280	35	5	localObject5	Object
    //   28	231	6	localCursor	android.database.Cursor
    //   31	198	7	str	String
    //   94	152	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   48	57	272	finally
    //   69	79	272	finally
    //   87	96	272	finally
    //   104	112	272	finally
    //   120	134	272	finally
    //   142	149	272	finally
    //   160	169	272	finally
    //   177	185	272	finally
    //   193	202	272	finally
    //   210	218	272	finally
    //   226	234	272	finally
    //   242	253	272	finally
    //   33	40	280	finally
    //   528	667	828	java/lang/Throwable
    //   33	40	850	java/lang/Exception
    //   48	57	854	java/lang/Exception
    //   69	79	854	java/lang/Exception
    //   87	96	854	java/lang/Exception
    //   104	112	854	java/lang/Exception
    //   120	134	854	java/lang/Exception
    //   142	149	854	java/lang/Exception
    //   160	169	854	java/lang/Exception
    //   177	185	854	java/lang/Exception
    //   193	202	854	java/lang/Exception
    //   210	218	854	java/lang/Exception
    //   226	234	854	java/lang/Exception
    //   242	253	854	java/lang/Exception
  }
  
  private void init(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mSyncThread = new HandlerThread("QQ_FTS_Sync", 3);
    this.mSyncThread.start();
    this.mSyncHandler = new FTSSyncHandler(this.mSyncThread.getLooper(), this.mApp, this);
    this.mOperators.put(Integer.valueOf(1), new FTSMsgOperator(this.mApp, this.mSyncHandler));
    this.mOperators.put(Integer.valueOf(2), new FTSTroopOperator(this.mApp, this.mSyncHandler));
    this.mOperators.put(Integer.valueOf(4), new FTSNewTroopOperator(this.mApp, this.mSyncHandler));
    initWithDPC();
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.manager", 2, "FTSDBManager structure...");
    }
  }
  
  public static boolean isFTSEnable()
  {
    return ENABLE;
  }
  
  public static void setFTSEnable(boolean paramBoolean)
  {
    ENABLE = paramBoolean;
  }
  
  public void clearFTS()
  {
    this.mDatabase.c();
    this.mDatabaseV2.a();
  }
  
  public void clearFTS(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    FTSUtils.a(paramAppRuntime, paramString);
    Object localObject = DBBuildUtil.getDefaultEntityManagerFactoryBuilder(paramString).build().build(paramString).getWritableDatabase();
    ((SQLiteDatabase)localObject).execSQL("DROP TABLE IF EXISTS msg_upgrade_log;");
    ((SQLiteDatabase)localObject).execSQL("DROP TABLE IF EXISTS msg_sync_log;");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DROP TABLE IF EXISTS ");
    localStringBuilder.append(FTSTroopSync.class.getSimpleName());
    localStringBuilder.append(";");
    ((SQLiteDatabase)localObject).execSQL(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DROP TABLE IF EXISTS ");
    localStringBuilder.append(FTSTroopTime.class.getSimpleName());
    localStringBuilder.append(";");
    ((SQLiteDatabase)localObject).execSQL(localStringBuilder.toString());
    if (!paramBoolean)
    {
      ((FTSDBRuntimeServiceImpl)paramAppRuntime.getRuntimeService(IFTSDBRuntimeService.class, "multi")).clearFTS();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAppRuntime.getApplication().getFilesDir().getAbsolutePath().replace("files", "databases"));
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("-IndexQQMsg.db");
      paramAppRuntime = new File(((StringBuilder)localObject).toString());
      if ((paramAppRuntime.exists()) && (paramAppRuntime.isFile())) {
        paramAppRuntime.delete();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.manager", 2, "FTS clear...");
    }
  }
  
  public long getDBSize()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.mApp.getApplication().getFilesDir().getAbsolutePath().replace("files", "databases"));
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.mApp.getCurrentAccountUin());
    ((StringBuilder)localObject).append("-IndexQQMsg.db");
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists()) {
      return ((File)localObject).length();
    }
    return 0L;
  }
  
  public boolean getEnable()
  {
    return ENABLE;
  }
  
  public FTSDatatbase getFTSDatabase()
  {
    return this.mDatabase;
  }
  
  public FTSDatabase getFTSDatabaseV2()
  {
    return this.mDatabaseV2;
  }
  
  public IFTSConfig getIFTSConfig()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.manager", 2, "getFTSConfig");
    }
    IFTSConfig localIFTSConfig = this.mIFTSConfig;
    Object localObject = localIFTSConfig;
    if (localIFTSConfig == null) {
      localObject = new IFTSConfig.DefaultConfig();
    }
    return localObject;
  }
  
  public FTSIndexOperator getOperator(int paramInt)
  {
    return (FTSIndexOperator)this.mOperators.get(Integer.valueOf(paramInt));
  }
  
  public boolean hasInit()
  {
    try
    {
      boolean bool = this.isInit;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void initWithDPC()
  {
    if (hasInit()) {
      return;
    }
    this.mSyncHandler.post(new FTSDBRuntimeServiceImpl.1(this));
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    init(paramAppRuntime);
  }
  
  public void onDestroy()
  {
    if (this.isNotDestroying.compareAndSet(true, false))
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        this.mSyncHandler.post(new FTSDBRuntimeServiceImpl.2(this));
        return;
      }
      destroyInner();
      this.isNotDestroying.set(true);
    }
  }
  
  public void refreshFTS(int paramInt)
  {
    if (!this.isDestroyed) {
      ((FTSIndexOperator)this.mOperators.get(Integer.valueOf(paramInt))).c();
    }
  }
  
  public void setDPCFlag(int paramInt)
  {
    this.dpcFlag = paramInt;
  }
  
  public void setENABLE(boolean paramBoolean)
  {
    ENABLE = paramBoolean;
  }
  
  public void setIFTSConfig(IFTSConfig paramIFTSConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.manager", 2, "setFTSMsg");
    }
    this.mIFTSConfig = paramIFTSConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.api.impl.FTSDBRuntimeServiceImpl
 * JD-Core Version:    0.7.0.1
 */