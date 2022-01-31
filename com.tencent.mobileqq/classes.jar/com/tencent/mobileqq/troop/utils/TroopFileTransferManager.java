package com.tencent.mobileqq.troop.utils;

import alof;
import aloz;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import aqsb;
import aqtj;
import aqwl;
import aqxi;
import area;
import arrr;
import arso;
import arss;
import arsx;
import ayzl;
import bbsa;
import bbtn;
import bbvc;
import bbvj;
import bbvl;
import bclp;
import bcmp;
import bcmr;
import bcmu;
import bcnf;
import bcng;
import bcnh;
import bcni;
import bcnj;
import bcnk;
import bcnl;
import bcnm;
import bcnq;
import bcnr;
import bcnt;
import bcpr;
import bdgc;
import bdhb;
import bdhe;
import bdin;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.ProxyIpManager;
import ytu;
import yud;
import yuh;
import yui;
import yuj;
import yuk;
import yum;

public class TroopFileTransferManager
  implements INetInfoHandler
{
  private static Map<Long, TroopFileTransferManager> jdField_c_of_type_JavaUtilMap;
  protected long a;
  private bcmu jdField_a_of_type_Bcmu;
  public QQAppInterface a;
  public Map<UUID, TroopFileTransferManager.Item> a;
  private ProxyIpManager jdField_a_of_type_MqqManagerProxyIpManager;
  private yud jdField_a_of_type_Yud = new bcnm(this);
  private yuh jdField_a_of_type_Yuh = new bcnh(this);
  private yui jdField_a_of_type_Yui = new bcng(this);
  private yuj jdField_a_of_type_Yuj = new bcnl(this);
  private yuk jdField_a_of_type_Yuk = new bcnj(this);
  private yum jdField_a_of_type_Yum = new bcnk(this);
  public bcnq[] a;
  protected long b;
  public Map<UUID, Integer> b;
  private yuh b;
  protected boolean b;
  protected long c;
  protected long d;
  public long e;
  protected long f;
  private volatile long g;
  
  static
  {
    if (!TroopFileTransferManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_c_of_type_Boolean = bool;
      return;
    }
  }
  
  public TroopFileTransferManager()
  {
    this.jdField_b_of_type_Yuh = new bcni(this);
    this.jdField_a_of_type_ArrayOfBcnq = new bcnq[] { new bcnq(1), new bcnq(1), new bcnq(2), new bcnq(2), new bcnq(2) };
  }
  
  public static TroopFileTransferManager a(long paramLong)
  {
    try
    {
      TroopFileTransferManager localTroopFileTransferManager = (TroopFileTransferManager)jdField_c_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      return localTroopFileTransferManager;
    }
    finally {}
  }
  
  public static TroopFileTransferManager a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      if (jdField_c_of_type_JavaUtilMap == null)
      {
        jdField_c_of_type_JavaUtilMap = new HashMap();
        ThreadManager.post(new TroopFileTransferManager.1(), 2, null, true);
      }
      bcnr.a(paramQQAppInterface);
      Object localObject2 = (TroopFileTransferManager)jdField_c_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      Object localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((TroopFileTransferManager)localObject2).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
        {
          ((TroopFileTransferManager)localObject2).b();
          localObject1 = null;
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new bbvc(paramQQAppInterface, paramLong);
        ((TroopFileTransferManager)localObject2).a();
        ThreadManager.post(new TroopFileTransferManager.2((TroopFileTransferManager)localObject2), 8, null, true);
        jdField_c_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localObject2);
      }
      return localObject2;
    }
    finally {}
  }
  
  private void a(int paramInt, long paramLong)
  {
    try
    {
      if (bdin.b(BaseApplication.getContext()) == 1)
      {
        if (paramInt == 0) {
          this.jdField_b_of_type_Long += paramLong;
        }
        for (;;)
        {
          return;
          if (paramInt == 1) {
            this.jdField_a_of_type_Long += paramLong;
          }
        }
      }
      if (paramInt != 0) {
        break label75;
      }
    }
    finally {}
    this.d += paramLong;
    for (;;)
    {
      g();
      break;
      label75:
      if (paramInt == 1) {
        this.jdField_c_of_type_Long += paramLong;
      }
    }
  }
  
  public static void a(long paramLong)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = jdField_c_of_type_JavaUtilMap.values().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        TroopFileTransferManager localTroopFileTransferManager = (TroopFileTransferManager)localIterator.next();
        if (localTroopFileTransferManager.e == paramLong) {
          localTroopFileTransferManager.d();
        } else {
          localTroopFileTransferManager.j();
        }
      }
      finally {}
    }
  }
  
  private final void b(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    bcmp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, paramItem.FileName, paramItem.Status, paramInt);
  }
  
  private void c(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2)
  {
    if (paramItem == null) {
      return;
    }
    switch (paramInt1)
    {
    case 4: 
    case 5: 
    case 7: 
    case 8: 
    default: 
      return;
    case 2: 
    case 6: 
      bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "upload", true, paramItem.transferBeginTime, paramItem.UploadIp, this.e + "", arso.a(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.uploadUrl, paramItem.rspHeadStr, paramItem.retryTimes);
      return;
    case 10: 
      bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "download", false, paramItem.transferBeginTime, paramItem.DownloadIp, this.e + "", arso.a(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.downUrlStr4Report, paramItem.rspHeadStr, paramItem.retryTimes);
      return;
    case 9: 
    case 11: 
      bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "download", true, paramItem.transferBeginTime, paramItem.DownloadIp, this.e + "", arso.a(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.downUrlStr4Report, paramItem.rspHeadStr, paramItem.retryTimes);
      return;
    }
    bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "upload", false, paramItem.transferBeginTime, paramItem.UploadIp, this.e + "", arso.a(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.uploadUrl, paramItem.rspHeadStr, paramItem.retryTimes);
  }
  
  public static void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopFileTransferManager", 2, "TroopFileTransferManager.ReleaseAll called!");
    }
    try
    {
      if (jdField_c_of_type_JavaUtilMap == null) {
        return;
      }
      Iterator localIterator = jdField_c_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileTransferManager)localIterator.next()).b();
      }
      jdField_c_of_type_JavaUtilMap.clear();
    }
    finally {}
  }
  
  private final void h(TroopFileTransferManager.Item paramItem)
  {
    paramItem.ErrorCode = 0;
    a(paramItem, 12);
  }
  
  public static void i()
  {
    try
    {
      Iterator localIterator = jdField_c_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileTransferManager)localIterator.next()).j();
      }
    }
    finally {}
  }
  
  public int a(FileManagerEntity paramFileManagerEntity)
  {
    return 0;
  }
  
  public final bbtn a(String paramString)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    for (;;)
    {
      try
      {
        c();
        str = bbvj.a(paramString);
        if (str == null) {
          break label120;
        }
        if (str.length() != 0) {
          break label117;
        }
      }
      finally {}
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      if (localIterator.hasNext())
      {
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
        if ((!paramString.equals(localItem.FilePath)) && (!str.equals(localItem.FilePath))) {
          continue;
        }
        paramString = localItem.getInfo(this.e);
        break;
      }
      paramString = null;
      break;
      label117:
      continue;
      label120:
      String str = "0";
    }
  }
  
  public bbtn a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt1, int paramInt2, long paramLong3)
  {
    synchronized (a()) {}
  }
  
  /* Error */
  public bbtn a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 332	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lbcmu;
    //   4: astore 7
    //   6: aload 7
    //   8: monitorenter
    //   9: aload_0
    //   10: monitorenter
    //   11: aload 7
    //   13: aload_1
    //   14: aload_2
    //   15: lload_3
    //   16: iload 5
    //   18: invokevirtual 394	bcmu:a	(Ljava/lang/String;Ljava/lang/String;JI)Lbbsa;
    //   21: astore 8
    //   23: aload 8
    //   25: ifnonnull +10 -> 35
    //   28: aload_0
    //   29: monitorexit
    //   30: aload 7
    //   32: monitorexit
    //   33: aconst_null
    //   34: areturn
    //   35: invokestatic 287	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   38: ifeq +34 -> 72
    //   41: ldc_w 289
    //   44: iconst_2
    //   45: new 232	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 396
    //   55: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload 8
    //   60: invokevirtual 399	bbsa:toString	()Ljava/lang/String;
    //   63: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 294	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_0
    //   73: invokevirtual 307	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()V
    //   76: aload_0
    //   77: getfield 318	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   80: aload 8
    //   82: getfield 402	bbsa:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   85: invokeinterface 106 2 0
    //   90: checkcast 208	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   93: astore 6
    //   95: aload 6
    //   97: ifnonnull +152 -> 249
    //   100: new 208	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   103: dup
    //   104: aload 8
    //   106: invokespecial 340	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lbbsa;)V
    //   109: astore_1
    //   110: aload_0
    //   111: aload_1
    //   112: invokevirtual 342	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   115: aload_1
    //   116: aload_2
    //   117: putfield 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   120: aload_1
    //   121: lload_3
    //   122: putfield 260	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   125: aload_1
    //   126: lconst_0
    //   127: putfield 405	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   130: aload_2
    //   131: invokestatic 251	arso:a	(Ljava/lang/String;)Ljava/lang/String;
    //   134: astore_2
    //   135: aload_1
    //   136: getfield 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   139: invokestatic 410	arrr:a	(Ljava/lang/String;)I
    //   142: iconst_2
    //   143: if_icmpne +174 -> 317
    //   146: aload_0
    //   147: getfield 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   150: invokestatic 415	arsx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   153: ifeq +164 -> 317
    //   156: aload_0
    //   157: getfield 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   160: invokevirtual 418	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   163: invokevirtual 422	com/tencent/qphone/base/util/BaseApplication:getBaseContext	()Landroid/content/Context;
    //   166: new 424	bcnn
    //   169: dup
    //   170: aload_0
    //   171: aload_1
    //   172: invokespecial 426	bcnn:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   175: invokestatic 431	aqxi:a	(Landroid/content/Context;Laqxn;)V
    //   178: aload_0
    //   179: getfield 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   182: ldc_w 433
    //   185: ldc 239
    //   187: ldc 239
    //   189: ldc_w 435
    //   192: ldc_w 437
    //   195: iconst_0
    //   196: iconst_0
    //   197: ldc 239
    //   199: new 232	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   206: aload_0
    //   207: getfield 189	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   210: invokevirtual 237	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   213: ldc 239
    //   215: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: aload_2
    //   222: ldc 239
    //   224: invokestatic 442	azqs:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload_1
    //   228: aload_0
    //   229: getfield 189	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   232: invokevirtual 326	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lbbtn;
    //   235: astore_1
    //   236: aload_0
    //   237: monitorexit
    //   238: aload 7
    //   240: monitorexit
    //   241: aload_1
    //   242: areturn
    //   243: astore_1
    //   244: aload 7
    //   246: monitorexit
    //   247: aload_1
    //   248: athrow
    //   249: aload 6
    //   251: astore_1
    //   252: aload 6
    //   254: getfield 216	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   257: bipush 7
    //   259: if_icmpeq -144 -> 115
    //   262: aload 6
    //   264: getfield 216	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   267: bipush 11
    //   269: if_icmpne +17 -> 286
    //   272: aload 6
    //   274: astore_1
    //   275: aload 8
    //   277: getfield 444	bbsa:h	Ljava/lang/String;
    //   280: invokestatic 449	bdhb:a	(Ljava/lang/String;)Z
    //   283: ifeq -168 -> 115
    //   286: aload 6
    //   288: getfield 216	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   291: bipush 6
    //   293: if_icmpne +17 -> 310
    //   296: aload 6
    //   298: astore_1
    //   299: aload 8
    //   301: getfield 444	bbsa:h	Ljava/lang/String;
    //   304: invokestatic 449	bdhb:a	(Ljava/lang/String;)Z
    //   307: ifeq -192 -> 115
    //   310: aload_0
    //   311: monitorexit
    //   312: aload 7
    //   314: monitorexit
    //   315: aconst_null
    //   316: areturn
    //   317: aload_0
    //   318: aload_1
    //   319: iconst_0
    //   320: iconst_0
    //   321: invokevirtual 452	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;IZ)V
    //   324: goto -146 -> 178
    //   327: astore_1
    //   328: aload_0
    //   329: monitorexit
    //   330: aload_1
    //   331: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	TroopFileTransferManager
    //   0	332	1	paramString1	String
    //   0	332	2	paramString2	String
    //   0	332	3	paramLong	long
    //   0	332	5	paramInt	int
    //   93	204	6	localItem	TroopFileTransferManager.Item
    //   4	309	7	localbcmu	bcmu
    //   21	279	8	localbbsa	bbsa
    // Exception table:
    //   from	to	target	type
    //   9	11	243	finally
    //   30	33	243	finally
    //   238	241	243	finally
    //   244	247	243	finally
    //   312	315	243	finally
    //   330	332	243	finally
    //   11	23	327	finally
    //   28	30	327	finally
    //   35	72	327	finally
    //   72	95	327	finally
    //   100	115	327	finally
    //   115	178	327	finally
    //   178	238	327	finally
    //   252	272	327	finally
    //   275	286	327	finally
    //   286	296	327	finally
    //   299	310	327	finally
    //   310	312	327	finally
    //   317	324	327	finally
    //   328	330	327	finally
  }
  
  /* Error */
  public final bbtn a(String paramString1, String paramString2, String paramString3, long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 332	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lbcmu;
    //   6: aload_1
    //   7: aload_2
    //   8: lload 4
    //   10: bipush 102
    //   12: invokevirtual 455	bcmu:c	(Ljava/lang/String;Ljava/lang/String;JI)Lbbsa;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +9 -> 26
    //   20: aconst_null
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: invokevirtual 307	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()V
    //   30: new 208	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 340	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lbbsa;)V
    //   38: astore_1
    //   39: aload_0
    //   40: aload_1
    //   41: invokevirtual 342	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   44: aload_1
    //   45: iload 7
    //   47: putfield 345	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:RandomNum	I
    //   50: aload_1
    //   51: lload 8
    //   53: putfield 351	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   56: aload_1
    //   57: iload 6
    //   59: putfield 354	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardBusId	I
    //   62: aload_1
    //   63: iconst_4
    //   64: putfield 216	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   67: aload_1
    //   68: aload_3
    //   69: putfield 357	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   72: aload_0
    //   73: aload_1
    //   74: iconst_4
    //   75: iconst_0
    //   76: invokevirtual 390	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   79: aload_1
    //   80: aload_0
    //   81: getfield 189	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   84: invokevirtual 326	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lbbtn;
    //   87: astore_1
    //   88: goto -66 -> 22
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	TroopFileTransferManager
    //   0	96	1	paramString1	String
    //   0	96	2	paramString2	String
    //   0	96	3	paramString3	String
    //   0	96	4	paramLong1	long
    //   0	96	6	paramInt1	int
    //   0	96	7	paramInt2	int
    //   0	96	8	paramLong2	long
    // Exception table:
    //   from	to	target	type
    //   2	16	91	finally
    //   26	88	91	finally
  }
  
  /* Error */
  public final bbtn a(String paramString1, String paramString2, String paramString3, long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, FileManagerEntity paramFileManagerEntity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 332	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lbcmu;
    //   6: aload_2
    //   7: lload 4
    //   9: bipush 102
    //   11: invokevirtual 337	bcmu:a	(Ljava/lang/String;JI)Lbbsa;
    //   14: astore_1
    //   15: invokestatic 287	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +33 -> 51
    //   21: ldc_w 289
    //   24: iconst_2
    //   25: new 232	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 458
    //   35: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 399	bbsa:toString	()Ljava/lang/String;
    //   42: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 294	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_1
    //   52: ifnonnull +9 -> 61
    //   55: aconst_null
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: areturn
    //   61: aload_0
    //   62: invokevirtual 307	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()V
    //   65: new 208	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 340	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lbbsa;)V
    //   73: astore_1
    //   74: aload_0
    //   75: aload_1
    //   76: invokevirtual 342	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   79: aload_1
    //   80: iload 7
    //   82: putfield 345	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:RandomNum	I
    //   85: aload_1
    //   86: lload 8
    //   88: putfield 351	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   91: aload_1
    //   92: iload 6
    //   94: putfield 354	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardBusId	I
    //   97: aload_1
    //   98: iconst_4
    //   99: putfield 216	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   102: aload_1
    //   103: aload_3
    //   104: putfield 357	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   107: aload_1
    //   108: lload 10
    //   110: putfield 360	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:entrySessionID	J
    //   113: aload 12
    //   115: ifnull +21 -> 136
    //   118: aload_1
    //   119: aload 12
    //   121: getfield 463	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   124: putfield 379	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   127: aload_1
    //   128: aload 12
    //   130: getfield 466	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   133: putfield 383	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   136: aload_0
    //   137: aload_1
    //   138: iconst_4
    //   139: iconst_0
    //   140: invokevirtual 390	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   143: aload_1
    //   144: aload_0
    //   145: getfield 189	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   148: invokevirtual 326	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lbbtn;
    //   151: astore_1
    //   152: goto -95 -> 57
    //   155: astore_1
    //   156: aload_0
    //   157: monitorexit
    //   158: aload_1
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	TroopFileTransferManager
    //   0	160	1	paramString1	String
    //   0	160	2	paramString2	String
    //   0	160	3	paramString3	String
    //   0	160	4	paramLong1	long
    //   0	160	6	paramInt1	int
    //   0	160	7	paramInt2	int
    //   0	160	8	paramLong2	long
    //   0	160	10	paramLong3	long
    //   0	160	12	paramFileManagerEntity	FileManagerEntity
    // Exception table:
    //   from	to	target	type
    //   2	51	155	finally
    //   61	113	155	finally
    //   118	136	155	finally
    //   136	152	155	finally
  }
  
  public bbtn a(String paramString, boolean paramBoolean, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      paramString = ???.b(paramString);
      if (paramString == null) {
        return null;
      }
      c();
      paramString = new TroopFileTransferManager.Item(paramString);
      a(paramString);
      paramString.BusId = 102;
      paramString.isFromAIO = paramBoolean;
      paramString.RandomNum = paramInt;
      if (bdin.a(BaseApplication.getContext()) == 0)
      {
        a(paramString, 3, 106);
        paramString = paramString.getInfo(this.e);
        return paramString;
        paramString = finally;
        throw paramString;
      }
      this.jdField_a_of_type_ArrayOfBcnq[0].a(new TroopFileTransferManager.TaskScan(this, paramString));
      paramString = paramString.getInfo(this.e);
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public final bbtn a(UUID paramUUID)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 307	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()V
    //   6: aload_0
    //   7: getfield 318	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   10: aload_1
    //   11: invokeinterface 106 2 0
    //   16: checkcast 208	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   19: astore_1
    //   20: aload_1
    //   21: ifnonnull +9 -> 30
    //   24: aconst_null
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_1
    //   31: aload_0
    //   32: getfield 189	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   35: invokevirtual 326	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lbbtn;
    //   38: astore_1
    //   39: goto -13 -> 26
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	TroopFileTransferManager
    //   0	47	1	paramUUID	UUID
    // Exception table:
    //   from	to	target	type
    //   2	20	42	finally
    //   30	39	42	finally
  }
  
  public bcmu a()
  {
    if (this.jdField_a_of_type_Bcmu == null) {
      this.jdField_a_of_type_Bcmu = bcmu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e);
    }
    return this.jdField_a_of_type_Bcmu;
  }
  
  public TroopFileTransferManager.Item a(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        Map localMap = this.jdField_a_of_type_JavaUtilMap;
        if (localMap == null)
        {
          paramUUID = null;
          return paramUUID;
        }
        if (paramUUID == null) {
          throw new NullPointerException("TroopFileTransferManager getItem id is Null");
        }
      }
      finally {}
      paramUUID = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
    }
  }
  
  public TroopFileTransferManager.Item a(UUID paramUUID, boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileTransferManager", 1, Thread.currentThread().getName() + "removeitem:[" + paramUUID + "]");
      }
      paramUUID = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
      if ((paramBoolean) && (paramUUID != null)) {
        h();
      }
      return paramUUID;
    }
    finally {}
  }
  
  public final Collection<bbtn> a()
  {
    try
    {
      c();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((TroopFileTransferManager.Item)localIterator.next()).getInfo(this.e));
      }
    }
    finally {}
    return localCollection;
  }
  
  public final List<bbtn> a()
  {
    try
    {
      c();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
        if ((localItem != null) && (localItem.FilePath != null)) {
          localArrayList.add(localItem.getInfo(this.e));
        }
      }
    }
    finally {}
    return localList;
  }
  
  protected ProxyIpManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    if (this.jdField_a_of_type_MqqManagerProxyIpManager == null) {
      this.jdField_a_of_type_MqqManagerProxyIpManager = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3));
    }
    return this.jdField_a_of_type_MqqManagerProxyIpManager;
  }
  
  protected void a() {}
  
  public final void a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString1, String paramString2, long paramLong3, String paramString3, boolean paramBoolean, long paramLong4, arss paramarss)
  {
    a(paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramString1, paramString2, paramLong3, paramString3, paramBoolean, paramLong4, paramarss, 0L, 0);
  }
  
  public final void a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString1, String paramString2, long paramLong3, String paramString3, boolean paramBoolean, long paramLong4, arss paramarss, long paramLong5, int paramInt4)
  {
    int j = Math.abs(new Random().nextInt());
    synchronized (a())
    {
      if ((paramInt2 == 102) || (paramInt2 == 104)) {}
    }
    for (;;)
    {
      int i;
      try
      {
        if (this.jdField_a_of_type_Bcmu == null) {
          this.jdField_a_of_type_Bcmu = a();
        }
        Object localObject = this.jdField_a_of_type_Bcmu.a(paramString3);
        if (localObject != null)
        {
          paramInt2 = ((bbsa)localObject).jdField_a_of_type_Int;
          break label289;
          localObject = ???.a(paramString1, paramLong3, paramInt2);
          if (localObject != null) {}
        }
        else
        {
          paramInt2 = 102;
          break label289;
          if ((paramInt3 != 7) && (paramInt3 != 6003)) {
            break label283;
          }
          i = 38;
          continue;
        }
        c();
        localObject = new TroopFileTransferManager.Item((bbsa)localObject);
        a((TroopFileTransferManager.Item)localObject);
        ((TroopFileTransferManager.Item)localObject).RandomNum = j;
        ((TroopFileTransferManager.Item)localObject).ForwardPath = paramString3;
        ((TroopFileTransferManager.Item)localObject).ForwardTroopuin = paramLong1;
        ((TroopFileTransferManager.Item)localObject).mForwardCallback = paramarss;
        if (!paramBoolean)
        {
          paramLong1 = paramarss.a(String.valueOf(paramLong2), paramInt3, String.valueOf(paramLong1), paramInt2, paramString3, paramString1, paramString2, paramLong3, paramInt1, paramLong5, paramInt4);
          ((TroopFileTransferManager.Item)localObject).ForwardBusId = paramInt2;
          ((TroopFileTransferManager.Item)localObject).BusId = i;
          ytu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.e, (TroopFileTransferManager.Item)localObject, paramLong2, paramLong1, this.jdField_b_of_type_Yuh);
          return;
          paramString1 = finally;
          throw paramString1;
        }
        paramLong1 = paramLong4;
        continue;
        i = 3;
      }
      finally {}
      label283:
      continue;
      label289:
      if (paramInt3 == 3000) {
        i = 106;
      }
    }
  }
  
  public void a(bbsa parambbsa) {}
  
  protected final void a(bbtn parambbtn, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    FileManagerEntity localFileManagerEntity = arrr.a(parambbtn);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(parambbtn.jdField_b_of_type_Long);
    localFileManagerEntity.peerNick = bdgc.o(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (ayzl.a() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = paramBoolean;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = this.e;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = area.a(arrr.b(parambbtn.a));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = area.a(arrr.a(parambbtn.a));
      }
    }
    localFileManagerEntity.str10Md5 = bdhe.a(arrr.d(parambbtn.a));
    try
    {
      localFileManagerEntity.localModifyTime = new File(parambbtn.a).lastModified();
      label221:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      return;
    }
    catch (Exception parambbtn)
    {
      break label221;
    }
  }
  
  protected void a(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramItem);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  public final void a(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    a(paramItem, paramInt, 0);
  }
  
  public void a(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    try
    {
      if (paramItem.Status != paramInt1) {
        bool = true;
      }
      paramItem.IsNewStatus = bool;
      if (paramItem.IsNewStatus) {
        c(paramItem, paramInt1, paramInt2);
      }
      paramItem.Status = paramInt1;
      paramItem.ErrorCode = paramInt2;
      paramItem.Pausing = 0;
      if (paramItem.W2MPause == 1) {
        paramItem.W2MPause = 0;
      }
      h();
      paramItem.StatusUpdateTimeMs = 0L;
      d(paramItem);
      paramItem.IsNewStatus = false;
      b(paramItem, paramInt2);
      return;
    }
    finally {}
  }
  
  public void a(TroopFileTransferManager.Item paramItem, int paramInt, bcmr parambcmr)
  {
    boolean bool = false;
    try
    {
      if (paramItem.Status != paramInt) {
        bool = true;
      }
      paramItem.IsNewStatus = bool;
      paramItem.Status = paramInt;
      paramItem.ErrorCode = parambcmr.jdField_a_of_type_Int;
      paramItem.Pausing = 0;
      if (paramItem.W2MPause == 1) {
        paramItem.W2MPause = 0;
      }
      h();
      paramItem.StatusUpdateTimeMs = 0L;
      d(paramItem);
      paramItem.IsNewStatus = false;
      bcmp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambcmr);
      return;
    }
    finally {}
  }
  
  protected void a(TroopFileTransferManager.Item paramItem, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    try
    {
      localObject = paramItem.FilePath;
      if (localObject == null) {}
      for (;;)
      {
        return;
        if (paramInt == 0) {
          break;
        }
        if ((1 == bdin.a(BaseApplication.getContext())) || (paramInt != 128)) {
          break label59;
        }
        paramItem.ThumbnailDownloading_Small = false;
        paramItem.ThumbnailFileTimeMS_Small = 0L;
      }
      if (!paramBoolean) {}
    }
    finally {}
    for (;;)
    {
      label59:
      ytu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, paramItem, paramInt, paramBoolean, false, this.jdField_a_of_type_Yui);
      if ((paramBoolean) || (paramInt != 0)) {
        break;
      }
      bcpr.b();
      break;
      a(paramItem, 8);
      localObject = (bbsa)a().jdField_c_of_type_JavaUtilMap.get(paramItem.FilePath);
      if (localObject != null)
      {
        bbsa localbbsa = (bbsa)a().jdField_c_of_type_JavaUtilMap.get(((bbsa)localObject).f);
        if (localbbsa != null)
        {
          ((bbsa)localObject).e = 8;
          localbbsa.a((bbsa)localObject);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      paramString2 = ???.a(paramString2, paramLong, 25);
      if (paramString2 == null)
      {
        return;
        paramString1 = finally;
        throw paramString1;
      }
      c();
      paramString2 = new TroopFileTransferManager.Item(paramString2);
      a(paramString2);
      paramString2.ForwardPath = paramString1;
      paramString2.ForwardTroopuin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
      paramString2.ForwardBusId = paramInt;
      paramString2.Status = 4;
      paramString2.BusId = 25;
      ytu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.e, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), 0L, this.jdField_b_of_type_Yuh);
      return;
    }
    finally {}
  }
  
  public void a(Collection<String> paramCollection, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject;
      synchronized (a())
      {
        try
        {
          if (bdin.a(BaseApplication.getContext()) == 0)
          {
            i = 1;
            paramCollection = paramCollection.iterator();
            if (!paramCollection.hasNext()) {
              break;
            }
            localObject = ???.b((String)paramCollection.next());
            if (localObject == null) {
              continue;
            }
            c();
            localObject = new TroopFileTransferManager.Item((bbsa)localObject);
            a((TroopFileTransferManager.Item)localObject);
            ((TroopFileTransferManager.Item)localObject).BusId = 102;
            ((TroopFileTransferManager.Item)localObject).isFromAIO = paramBoolean;
            if (i == 0) {
              break label125;
            }
            a((TroopFileTransferManager.Item)localObject, 3, 106);
            continue;
            paramCollection = finally;
          }
        }
        finally {}
      }
      int i = 0;
      continue;
      label125:
      this.jdField_a_of_type_ArrayOfBcnq[0].a(new TroopFileTransferManager.TaskScan(this, (TroopFileTransferManager.Item)localObject));
    }
  }
  
  public void a(List<bbtn> paramList) {}
  
  /* Error */
  public void a(UUID paramUUID)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 307	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 318	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 106 2 0
    //   18: checkcast 208	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: new 749	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$3
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: invokespecial 750	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$3:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   33: iconst_5
    //   34: aconst_null
    //   35: iconst_0
    //   36: invokestatic 119	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	TroopFileTransferManager
    //   0	52	1	paramUUID	UUID
    // Exception table:
    //   from	to	target	type
    //   8	24	42	finally
    //   43	45	42	finally
    //   2	8	47	finally
    //   24	39	47	finally
    //   45	47	47	finally
  }
  
  public final void a(UUID paramUUID, String paramString)
  {
    try
    {
      paramUUID = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
      if (paramUUID != null)
      {
        paramUUID.FilePath = paramString;
        paramUUID.BusId = 102;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  protected boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 753	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_b_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: aload_0
    //   22: getfield 318	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   25: aload_0
    //   26: getfield 189	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   29: invokestatic 758	bclp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/Map;J)Z
    //   32: istore_1
    //   33: goto -20 -> 13
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	TroopFileTransferManager
    //   6	27	1	bool	boolean
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	36	finally
    //   17	33	36	finally
  }
  
  public boolean a(long paramLong, UUID paramUUID, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    String str;
    synchronized (a())
    {
      str = paramString2;
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          str = paramString2;
          if (!paramString2.startsWith("/")) {
            str = "/" + paramString2;
          }
        }
        if (QLog.isColorLevel())
        {
          paramString2 = "";
          if (paramUUID != null) {
            paramString2 = paramUUID.toString();
          }
          QLog.d("TroopFileTransferManager", 2, String.format("finishCopyFrom - sessionId: %s, UUID: %s retCode: %d strNewPath:%s strErrorMsg:%s", new Object[] { paramLong + "", paramString2, Integer.valueOf(paramInt), str, paramString3 }));
        }
        paramString2 = null;
        if (paramUUID != null) {
          paramString2 = ???.a(paramUUID);
        }
        if (paramString1 == null) {
          break label1025;
        }
        paramUUID = ???.a(paramString1);
        if (paramUUID == null) {
          return false;
        }
        c();
        paramString1 = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID.jdField_a_of_type_JavaUtilUUID);
        if (paramString1 == null)
        {
          return false;
          paramUUID = finally;
          throw paramUUID;
        }
        if (paramString1.Status != 4) {
          return false;
        }
        if (paramInt >= 0) {
          break label820;
        }
        i = 207;
        switch (paramInt)
        {
        default: 
          if (TextUtils.isEmpty(str))
          {
            if (!TextUtils.isEmpty(paramString3)) {
              break label794;
            }
            paramUUID = new bcmr(paramString1.FileName, this.e, 5, 207);
            a(paramString1, 5, paramUUID);
            return true;
          }
        case -20001: 
        case -20000: 
        case -403: 
          paramUUID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
          if (paramUUID == null)
          {
            if (!TextUtils.isEmpty(paramString3))
            {
              a(paramString1, 5, new bcmr(paramString1.FileName, this.e, 5, 704, paramString3));
              return false;
            }
            QLog.e("TroopFileTransferManager", 1, "finishCopyFrom, but entity is null!!!sessionId:" + paramLong);
            a(paramString1, 5, i);
            return true;
          }
          if (paramUUID.busId == 104) {
            continue;
          }
          paramUUID.busId = 104;
          paramString1.BusId = 104;
          if (paramUUID.nOpType == 27)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramUUID, 27);
            if (QLog.isColorLevel()) {
              QLog.e("TroopFileTransferManager", 2, String.format("retCode:%d is, change busid to 104, try ForwardFromOfflineFile again!", new Object[] { Integer.valueOf(paramInt) }));
            }
            return true;
          }
          if (paramUUID.nOpType != 26) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(104, paramUUID);
          break;
        case -3: 
          i = 202;
        }
      }
      finally {}
      continue;
      int i = 600;
      continue;
      i = 701;
      continue;
      new Handler(Looper.getMainLooper()).postDelayed(new TroopFileTransferManager.14(this, paramString1), 1000L);
      return true;
      if ((!TextUtils.isEmpty(paramString1.LocalFile)) && (new File(paramString1.LocalFile).exists()))
      {
        a(paramString1, 0);
        paramString1.BusId = 102;
        this.jdField_a_of_type_ArrayOfBcnq[0].a(new TroopFileTransferManager.TaskScan(this, paramString1));
        return true;
      }
      i = 603;
      continue;
      i = 705;
      continue;
      a(paramString1, 5, new bcmr(paramString1.FileName, this.e, 5, 704, paramString3));
      return true;
      label794:
      paramUUID = new bcmr(paramString1.FileName, this.e, 5, 704, paramString3);
      continue;
      label820:
      if (TextUtils.isEmpty(str))
      {
        if (TextUtils.isEmpty(paramString3)) {}
        for (paramUUID = new bcmr(paramString1.FileName, this.e, 5, 207);; paramUUID = new bcmr(paramString1.FileName, this.e, 5, 704, paramString3))
        {
          a(paramString1, 5, paramUUID);
          return true;
        }
      }
      paramUUID.b = str;
      paramString1.FilePath = str;
      paramString2 = paramString1.getInfo(this.e);
      if (paramString2 != null) {
        paramString2.e = str;
      }
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1.entrySessionID);
      if (paramString2 != null)
      {
        paramString2.strTroopFilePath = str;
        paramString3 = arrr.e(paramString2);
        paramString2.strQRUrl = paramString3;
        paramString1.strQRUrl = paramString3;
      }
      if (this.jdField_a_of_type_Bcmu != null) {
        this.jdField_a_of_type_Bcmu.a(paramUUID.b, paramUUID);
      }
      a(paramString1, 6, 0);
      c(paramString1);
      return true;
      label1025:
      paramUUID = paramString2;
    }
  }
  
  protected final boolean a(TroopFileTransferManager.Item paramItem)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = true;
    if (paramItem == null) {}
    do
    {
      do
      {
        do
        {
          return bool2;
          switch (paramItem.Status)
          {
          default: 
            bool2 = bool1;
          }
        } while (paramItem.ThumbnailDownloading_Small);
        bool2 = bool1;
      } while (paramItem.ThumbnailDownloading_Large);
      bool2 = bool1;
    } while (paramItem.ThumbnailDownloading_Middle);
    if ((paramItem.HasThumbnailFile_Small) && (!a(paramItem, 128))) {
      bool2 = bool3;
    }
    for (;;)
    {
      return bool2;
      if (!TextUtils.isEmpty(paramItem.LocalFile))
      {
        if (new File(paramItem.LocalFile).exists()) {
          break;
        }
        i = bbvl.jdField_a_of_type_Int;
        localStringBuilder = new StringBuilder().append("[");
        if (paramItem.Id != null) {}
        for (str = paramItem.Id.toString();; str = "null")
        {
          bbvl.b("TroopFileTransferManager", i, str + "] check localfile is not exsit. set to nodownload state");
          a(paramItem, 7);
          bool1 = true;
          break;
        }
      }
      int i = bbvl.jdField_a_of_type_Int;
      StringBuilder localStringBuilder = new StringBuilder().append("[");
      if (paramItem.Id != null) {}
      for (String str = paramItem.Id.toString();; str = "null")
      {
        bbvl.b("TroopFileTransferManager", i, str + "] check localfile=null. set to nodownload state");
        a(paramItem, 7);
        bool1 = true;
        break;
      }
      if (paramItem.HasThumbnailFile_Large)
      {
        bool2 = bool3;
        if (!a(paramItem, 640)) {}
      }
      else if (paramItem.HasThumbnailFile_Middle)
      {
        bool2 = bool3;
        if (!a(paramItem, 383)) {}
      }
      else
      {
        bool2 = bool1;
      }
    }
  }
  
  protected boolean a(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    String str = paramItem.getThumbnailFile(this.e, paramInt);
    if (paramInt == 128)
    {
      paramItem.HasThumbnailFile_Small = bdhb.b(str);
      if (paramItem.HasThumbnailFile_Small) {
        paramItem.ThumbnailFileTimeMS_Small = 0L;
      }
      return paramItem.HasThumbnailFile_Small;
    }
    if (paramInt == 640)
    {
      paramItem.HasThumbnailFile_Large = bdhb.b(str);
      if (paramItem.HasThumbnailFile_Large) {
        paramItem.ThumbnailFileTimeMS_Large = 0L;
      }
      return paramItem.HasThumbnailFile_Large;
    }
    if (paramInt == 383)
    {
      paramItem.HasThumbnailFile_Middle = bdhb.b(str);
      if (paramItem.HasThumbnailFile_Middle) {
        paramItem.ThumbnailFileTimeMS_Middle = 0L;
      }
      return paramItem.HasThumbnailFile_Middle;
    }
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    boolean bool;
    if (paramString1 == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        paramString1 = UUID.fromString(paramString1);
        if (paramString1 == null)
        {
          bool = false;
          continue;
        }
        c();
        paramString1 = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
        if (paramString1 == null)
        {
          bool = false;
          continue;
        }
        paramString1.NameForSave = paramString2;
        paramString1.LocalFile = (alof.bm + paramString2);
        b(paramString1);
        ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(paramString1.getInfo(this.e));
        bool = true;
      }
      finally {}
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    bbsa localbbsa;
    synchronized (a()) {}
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    synchronized (a()) {}
    try
    {
      int i = arrr.a(arso.a(paramString2));
      if ((i != 0) && (i != 2)) {
        return false;
      }
      bbsa localbbsa = ???.a(paramString1, paramString2, 0L, paramInt1);
      if (localbbsa == null)
      {
        return false;
        paramString1 = finally;
        throw paramString1;
      }
      c();
      paramString2 = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(localbbsa.jdField_a_of_type_JavaUtilUUID);
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        paramString1 = new TroopFileTransferManager.Item(localbbsa);
        a(paramString1);
      }
      b(paramString1, paramInt2, i);
      return true;
    }
    finally {}
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong, int paramInt, yui paramyui)
  {
    synchronized (a()) {}
    label168:
    for (;;)
    {
      try
      {
        bbsa localbbsa = ???.a(paramString1, paramString2, paramLong, paramInt);
        if (localbbsa == null) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopFileTransferManager", 2, "startDownload==>" + localbbsa.toString());
        }
        c();
        paramString1 = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(localbbsa.jdField_a_of_type_JavaUtilUUID);
        if (paramString1 != null) {
          break label168;
        }
        paramString1 = new TroopFileTransferManager.Item(localbbsa);
        a(paramString1);
        paramString1.FileName = paramString2;
        paramString1.ProgressTotal = paramLong;
        paramString1.ProgressValue = localbbsa.d;
        ytu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, paramString1, 0, false, true, paramyui);
        return true;
      }
      finally {}
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean a(UUID arg1)
  {
    for (;;)
    {
      TroopFileTransferManager.Item localItem;
      try
      {
        c();
        localItem = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(???);
        if (localItem == null)
        {
          bool = false;
          return bool;
        }
        switch (localItem.Status)
        {
        case 0: 
          if (!QLog.isDevelopLevel()) {
            break label213;
          }
          QLog.d("TroopFileTransferManager", 4, "error status SuspendUpload");
        }
      }
      finally {}
      bcnq[] arrayOfbcnq = this.jdField_a_of_type_ArrayOfBcnq;
      int j = arrayOfbcnq.length;
      int i = 0;
      if (i < j) {
        synchronized (arrayOfbcnq[i])
        {
          Iterator localIterator = ???.a.iterator();
          if (localIterator.hasNext())
          {
            TroopFileTransferManager.Task localTask = (TroopFileTransferManager.Task)localIterator.next();
            if ((localTask.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item != localItem) || (!localTask.jdField_a_of_type_Boolean)) {
              continue;
            }
            ???.a.remove(localTask);
            a(localItem, 2);
            bool = true;
            continue;
          }
          i += 1;
        }
      }
      localObject.Pausing = 1;
      boolean bool = true;
      continue;
      continue;
      label213:
      bool = false;
    }
  }
  
  public boolean a(UUID paramUUID, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      bbsa localbbsa = ???.a(paramUUID);
      if (localbbsa == null) {
        return false;
      }
      int i = arrr.a(arso.a(localbbsa.c));
      if ((i != 0) && (i != 2))
      {
        return false;
        paramUUID = finally;
        throw paramUUID;
      }
      ThreadManager.post(new TroopFileTransferManager.9(this, paramUUID, localbbsa, paramInt, i), 5, null, true);
      return true;
    }
    finally {}
  }
  
  public final boolean a(UUID paramUUID, int paramInt, String paramString1, String paramString2)
  {
    return a(0L, paramUUID, null, paramInt, paramString1, paramString2);
  }
  
  public final int[] a()
  {
    for (;;)
    {
      try
      {
        c();
        int[] arrayOfInt1 = new int[2];
        int[] tmp11_10 = arrayOfInt1;
        tmp11_10[0] = 0;
        int[] tmp15_11 = tmp11_10;
        tmp15_11[1] = 0;
        tmp15_11;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
        if (!localIterator.hasNext()) {
          break label127;
        }
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
        if (localItem == null) {
          continue;
        }
        switch (localItem.Status)
        {
        case 0: 
        case 1: 
          arrayOfInt1[0] += 1;
          arrayOfInt1[1] += 1;
          break;
        case 2: 
        case 3: 
          arrayOfInt2[0] += 1;
        }
      }
      finally {}
      continue;
      label127:
      return arrayOfInt2;
    }
  }
  
  protected void b()
  {
    e();
    AppNetConnInfo.unregisterNetInfoHandler(this);
  }
  
  public void b(TroopFileTransferManager.Item paramItem)
  {
    h();
  }
  
  protected final void b(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2)
  {
    if (!paramItem.canFetchThumbnailFile(paramInt1)) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopFileTransferManager", 1, "_fetchThumbnail error, times limit. fileId[" + paramItem.Id + "] thumbSize[" + paramInt1 + "]");
      }
    }
    do
    {
      return;
      if (!a(paramItem, paramInt1)) {
        break;
      }
      paramItem.StatusUpdateTimeMs = 0L;
      d(paramItem);
    } while (!QLog.isColorLevel());
    QLog.e("TroopFileTransferManager", 1, "_fetchThumbnail error, thumb already exist. fileId[" + paramItem.Id + "] thumbSize[" + paramInt1 + "]");
    return;
    if (QLog.isColorLevel()) {
      QLog.e("TroopFileTransferManager", 1, "_fetchThumbnail request suc: fileId[" + paramItem.Id + "] thumbSize[" + paramInt1 + "]");
    }
    if (paramInt1 == 128)
    {
      paramItem.ThumbnailDownloading_Small = true;
      paramItem.ThumbnailFileTimeMS_Small = SystemClock.uptimeMillis();
    }
    for (;;)
    {
      if ((paramInt2 == 2) && (QLog.isColorLevel())) {
        QLog.d(".troop.troop_file_video.thumb", 2, "_fetchThumbnail:" + paramItem.FileName + ", localFile=" + paramItem.LocalFile);
      }
      if ((paramItem.LocalFile == null) || (!new File(paramItem.LocalFile).exists())) {
        break;
      }
      this.jdField_a_of_type_ArrayOfBcnq[1].a(new TroopFileTransferManager.TaskGenThumbnail(this, paramItem, paramInt1));
      return;
      if (paramInt1 == 640)
      {
        paramItem.ThumbnailDownloading_Large = true;
        paramItem.ThumbnailFileTimeMS_Large = SystemClock.uptimeMillis();
      }
      else if (paramInt1 == 383)
      {
        paramItem.ThumbnailDownloading_Middle = true;
        paramItem.ThumbnailFileTimeMS_Middle = SystemClock.uptimeMillis();
      }
    }
    if ((paramInt1 == 383) && (arso.b(paramItem.getThumbnailFile(this.e, 640))))
    {
      this.jdField_a_of_type_ArrayOfBcnq[1].a(new TroopFileTransferManager.TaskGenThumbnail(this, paramItem, paramInt1));
      return;
    }
    a(paramItem, paramInt1, false);
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 753	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_b_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: invokevirtual 1009	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()Z
    //   21: istore_1
    //   22: goto -9 -> 13
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	TroopFileTransferManager
    //   6	16	1	bool	boolean
    //   25	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   17	22	25	finally
  }
  
  /* Error */
  public final boolean b(TroopFileTransferManager.Item paramItem)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: getfield 695	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   8: ifeq +28 -> 36
    //   11: aload_1
    //   12: getfield 695	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   15: iconst_1
    //   16: if_icmpne +15 -> 31
    //   19: iconst_2
    //   20: istore_2
    //   21: aload_0
    //   22: aload_1
    //   23: iload_2
    //   24: invokevirtual 302	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_3
    //   30: ireturn
    //   31: iconst_3
    //   32: istore_2
    //   33: goto -12 -> 21
    //   36: iconst_0
    //   37: istore_3
    //   38: goto -11 -> 27
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	TroopFileTransferManager
    //   0	46	1	paramItem	TroopFileTransferManager.Item
    //   20	13	2	i	int
    //   1	37	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	19	41	finally
    //   21	27	41	finally
  }
  
  public boolean b(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        c();
        paramUUID = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
        if (paramUUID == null)
        {
          bool = false;
          return bool;
        }
        switch (paramUUID.Status)
        {
        case 2: 
          if (!QLog.isDevelopLevel()) {
            break label134;
          }
          QLog.d("TroopFileTransferManager", 4, "error status ResumeUpload");
        }
      }
      finally {}
      if (paramUUID.Md5 == null)
      {
        this.jdField_a_of_type_ArrayOfBcnq[0].a(new TroopFileTransferManager.TaskScan(this, paramUUID));
      }
      else if (paramUUID.FilePath == null)
      {
        e(paramUUID);
      }
      else
      {
        f(paramUUID);
        break label139;
        continue;
        label134:
        bool = false;
        continue;
      }
      label139:
      boolean bool = true;
    }
  }
  
  public void c()
  {
    try
    {
      boolean bool = this.jdField_b_of_type_Boolean;
      if (bool) {
        label11:
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      List localList = bclp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e);
      this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
      this.jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
      if ((!jdField_c_of_type_Boolean) && (localList == null)) {
        throw new AssertionError();
      }
    }
    finally {}
    Object localObject2;
    if (localObject1 != null)
    {
      localIterator = localObject1.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (TroopFileTansferItemEntity)localIterator.next();
        if ((((TroopFileTansferItemEntity)localObject2).Id != null) && ((TextUtils.isEmpty(((TroopFileTansferItemEntity)localObject2).FilePath)) || (((TroopFileTansferItemEntity)localObject2).FilePath.startsWith("/")))) {
          this.jdField_a_of_type_JavaUtilMap.put(((TroopFileTansferItemEntity)localObject2).Id, new TroopFileTransferManager.Item((TroopFileTansferItemEntity)localObject2));
        }
      }
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext()) {
        localObject2 = (TroopFileTransferManager.Item)localIterator.next();
      }
      switch (((TroopFileTransferManager.Item)localObject2).Status)
      {
      case 0: 
      case 1: 
        ((TroopFileTransferManager.Item)localObject2).Status = 3;
        break;
      case 8: 
        ((TroopFileTransferManager.Item)localObject2).Status = 10;
        continue;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          ThreadManager.post(new TroopFileTransferManager.15(this), 8, null, true);
          break label11;
        }
        if (!c()) {
          break label11;
        }
        h();
        break label11;
      }
    }
  }
  
  public void c(TroopFileTransferManager.Item paramItem)
  {
    ytu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, paramItem, this.jdField_a_of_type_Yuj);
  }
  
  public final boolean c()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_JavaUtilMap.values();
      localObject1 = ((Collection)localObject1).iterator();
      for (boolean bool = false; ((Iterator)localObject1).hasNext(); bool = a((TroopFileTransferManager.Item)((Iterator)localObject1).next()) | bool) {}
      return bool;
    }
    finally {}
  }
  
  /* Error */
  public final boolean c(TroopFileTransferManager.Item paramItem)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: getfield 695	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   8: ifeq +30 -> 38
    //   11: aload_1
    //   12: getfield 695	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   15: iconst_1
    //   16: if_icmpne +16 -> 32
    //   19: bipush 9
    //   21: istore_2
    //   22: aload_0
    //   23: aload_1
    //   24: iload_2
    //   25: invokevirtual 302	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: bipush 10
    //   34: istore_2
    //   35: goto -13 -> 22
    //   38: iconst_0
    //   39: istore_3
    //   40: goto -12 -> 28
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	TroopFileTransferManager
    //   0	48	1	paramItem	TroopFileTransferManager.Item
    //   21	14	2	i	int
    //   1	39	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	19	43	finally
    //   22	28	43	finally
  }
  
  public boolean c(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        c();
        paramUUID = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
        if (paramUUID == null)
        {
          bool = false;
          return bool;
        }
        switch (paramUUID.Status)
        {
        case 9: 
        case 10: 
          if (paramUUID.isZipInnerFile)
          {
            a(paramUUID, 8);
            this.jdField_a_of_type_ArrayOfBcnq[3].a(new TroopFileTransferManager.TaskHttpDownload(this, paramUUID));
          }
          else if ((arrr.a(paramUUID.FileName) == 2) && (arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
          {
            aqxi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), new bcnf(this, paramUUID));
          }
          break;
        }
      }
      finally {}
      a(paramUUID, 0, false);
      break label157;
      boolean bool = false;
      continue;
      label157:
      bool = true;
    }
  }
  
  protected void d()
  {
    for (;;)
    {
      TroopFileTransferManager.Item localItem;
      try
      {
        c();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
        if (!localIterator.hasNext()) {
          break label149;
        }
        localItem = (TroopFileTransferManager.Item)localIterator.next();
        if (localItem.W2MPause != 2) {
          continue;
        }
        localItem.W2MPause = 0;
        switch (localItem.Status)
        {
        case 0: 
        case 1: 
        case 8: 
          localItem.Pausing = 0;
          break;
        case 2: 
          b(localItem.Id);
        }
      }
      finally {}
      continue;
      c(localItem.Id);
      continue;
      label149:
      return;
    }
  }
  
  public void d(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      long l1 = SystemClock.uptimeMillis() - this.f;
      long l2 = SystemClock.uptimeMillis() - paramItem.StatusUpdateTimeMs;
      if ((this.f == 0L) || (paramItem.StatusUpdateTimeMs == 0L) || (l2 > 5000L) || (l2 < 0L) || (l1 > 1000L) || (l1 < 0L))
      {
        this.f = (l1 + this.f);
        paramItem.StatusUpdateTimeMs += l2;
        ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(paramItem.getInfo(this.e));
      }
      return;
    }
    finally {}
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null;
  }
  
  public boolean d(UUID arg1)
  {
    try
    {
      c();
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(???);
      if (localItem == null) {}
      for (boolean bool = false;; bool = false)
      {
        return bool;
        if (localItem.Status == 8) {
          break;
        }
      }
      bcnq[] arrayOfbcnq = this.jdField_a_of_type_ArrayOfBcnq;
      int k = arrayOfbcnq.length;
      int j = 0;
      int i = 0;
      if (j < k) {}
      for (;;)
      {
        synchronized (arrayOfbcnq[j])
        {
          Iterator localIterator = ???.a.iterator();
          if (localIterator.hasNext())
          {
            TroopFileTransferManager.Task localTask = (TroopFileTransferManager.Task)localIterator.next();
            if ((localTask.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item == localItem) && (localTask.jdField_b_of_type_Boolean))
            {
              ???.a.remove(localTask);
              a(localItem, 9);
              i = 1;
              if (i != 0)
              {
                if ((arrr.a(localItem.FileName) == 2) && (arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
                {
                  aqxi.a(localItem.FilePath);
                  a(localItem, 9);
                }
                localItem.Pausing = 1;
                bool = true;
                break;
              }
              j += 1;
            }
          }
        }
      }
    }
    finally {}
  }
  
  protected void e()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilMap != null)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
          if (localIterator.hasNext())
          {
            TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
            switch (localItem.Status)
            {
            case 0: 
            case 1: 
            case 8: 
              localItem.Pausing = -1;
              continue;
            }
          }
        }
      }
      finally {}
      return;
    }
  }
  
  public void e(TroopFileTransferManager.Item paramItem)
  {
    a(paramItem, 1);
    ytu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, paramItem, this.jdField_a_of_type_Yum);
  }
  
  public boolean e(UUID paramUUID)
  {
    bbsa localbbsa;
    TroopFileTransferManager.Item localItem;
    synchronized (a()) {}
  }
  
  protected void f(TroopFileTransferManager.Item paramItem)
  {
    a(paramItem, 1);
    ytu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, paramItem, this.jdField_a_of_type_Yuk);
  }
  
  public final boolean f(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        c();
        paramUUID = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
        if (paramUUID == null)
        {
          bool = false;
          return bool;
        }
        switch (paramUUID.Status)
        {
        case 4: 
        case 5: 
        case 8: 
          if (!QLog.isDevelopLevel()) {
            break label262;
          }
          QLog.e("TroopFileTransferManager", 4, "deleteItem error, status:" + paramUUID.Status);
        }
      }
      finally {}
      if (paramUUID.TmpFile != null) {
        new File(paramUUID.TmpFile).delete();
      }
      paramUUID.deleteThumbnailFile(this.e, 128);
      paramUUID.deleteThumbnailFile(this.e, 640);
      paramUUID.deleteThumbnailFile(this.e, 383);
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileTransferManager", 4, "delete " + paramUUID.Id + "[" + paramUUID.FilePath + "]" + paramUUID.Status);
      }
      h(paramUUID);
      boolean bool = true;
      continue;
      continue;
      label262:
      bool = false;
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Long != 0L)
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        l1 = this.jdField_a_of_type_Long;
        localQQAppInterface.sendAppDataIncerment(str, new String[] { "param_WIFIGroupFileDownloadFlow", "param_WIFIFlow", "param_Flow" }, l1);
        if (QLog.isDevelopLevel()) {
          QLog.d("param_WIFIGroupFileDownloadFlow", 4, this.jdField_a_of_type_Long + "");
        }
        this.jdField_a_of_type_Long = 0L;
      }
      if (this.jdField_b_of_type_Long != 0L)
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        l1 = this.jdField_b_of_type_Long;
        localQQAppInterface.sendAppDataIncerment(str, new String[] { "param_WIFIGroupFileUploadFlow", "param_WIFIFlow", "param_Flow" }, l1);
        this.jdField_b_of_type_Long = 0L;
      }
      if ((this.d != 0L) || (this.jdField_c_of_type_Long != 0L))
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        l1 = this.jdField_c_of_type_Long;
        long l2 = this.d;
        localQQAppInterface.sendAppDataIncerment(str, new String[] { "param_XGFileFlow", "param_XGFlow", "param_Flow" }, l1 + l2);
      }
      if (this.jdField_c_of_type_Long != 0L)
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        l1 = this.jdField_c_of_type_Long;
        localQQAppInterface.sendAppDataIncerment(str, new String[] { "param_XGGroupFileDownloadFlow", "param_XGFlow", "param_Flow" }, l1);
        if (QLog.isDevelopLevel()) {
          QLog.d("param_XGGroupFileDownloadFlow", 4, this.jdField_c_of_type_Long + "");
        }
        this.jdField_c_of_type_Long = 0L;
      }
    } while (this.d == 0L);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    long l1 = this.d;
    localQQAppInterface.sendAppDataIncerment(str, new String[] { "param_XGGroupFileUploadFlow", "param_XGFlow", "param_Flow" }, l1);
    if (QLog.isDevelopLevel()) {
      QLog.d("param_XGGroupFileUploadFlow", 4, this.d + "");
    }
    this.d = 0L;
  }
  
  protected final void g(TroopFileTransferManager.Item paramItem)
  {
    a(paramItem, 0, true);
  }
  
  /* Error */
  protected final void h()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 90	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   8: lconst_0
    //   9: lcmp
    //   10: ifne +31 -> 41
    //   13: aload_0
    //   14: invokestatic 996	android/os/SystemClock:uptimeMillis	()J
    //   17: putfield 90	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   20: iload_1
    //   21: ifeq +17 -> 38
    //   24: new 1111	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$16
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 1112	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$16:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;)V
    //   32: iconst_5
    //   33: aconst_null
    //   34: iconst_1
    //   35: invokestatic 119	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: iconst_0
    //   42: istore_1
    //   43: goto -30 -> 13
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	TroopFileTransferManager
    //   1	42	1	i	int
    //   46	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	13	46	finally
    //   13	20	46	finally
    //   24	38	46	finally
  }
  
  protected void j()
  {
    try
    {
      c();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
        if (localItem.W2MPause == 2) {
          localItem.W2MPause = 1;
        }
      }
    }
    finally {}
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileTransferManager", 4, "onNetNone2Mobile");
    }
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileTransferManager", 4, "onNetWifi2Mobile");
      }
      boolean bool = this.jdField_b_of_type_Boolean;
      if (!bool) {
        label27:
        return;
      }
      int i = 0;
      paramString = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      for (;;)
      {
        TroopFileTransferManager.Item localItem;
        if (paramString.hasNext()) {
          localItem = (TroopFileTransferManager.Item)paramString.next();
        }
        switch (localItem.Status)
        {
        case 0: 
        case 1: 
        case 8: 
          if (localItem.Pausing == 0)
          {
            localItem.Pausing = 1;
            localItem.W2MPause = 2;
            i = 1;
            break label158;
            if (i == 0) {
              break label27;
            }
            bcmp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, 107);
            break label27;
          }
          break;
        }
      }
    }
    finally {}
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileTransferManager", 4, "onNetWifi2None");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager
 * JD-Core Version:    0.7.0.1
 */