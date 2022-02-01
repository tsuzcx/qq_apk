package com.tencent.mobileqq.troop.utils;

import amoo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import asdg;
import asdm;
import asgz;
import asnl;
import aszt;
import atas;
import bbko;
import bebc;
import becp;
import bees;
import befa;
import befc;
import bfaw;
import bfay;
import bfbb;
import bfbm;
import bfbn;
import bfbo;
import bfbp;
import bfbq;
import bfbr;
import bfbs;
import bfbv;
import bfbw;
import bfdx;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import mqq.manager.ProxyIpManager;
import zrj;
import zrw;
import zrz;
import zsa;
import zsb;
import zsc;
import zse;

public class TroopFileTransferManager
  implements INetInfoHandler
{
  private static Map<Long, TroopFileTransferManager> c;
  protected long a;
  private bfbb jdField_a_of_type_Bfbb;
  public QQAppInterface a;
  public Map<UUID, TroopFileTransferManager.Item> a;
  private ProxyIpManager jdField_a_of_type_MqqManagerProxyIpManager;
  private zrw jdField_a_of_type_Zrw = new bfbp(this);
  private zrz jdField_a_of_type_Zrz = new bfbr(this);
  private zsa jdField_a_of_type_Zsa = new bfbq(this);
  private zsb jdField_a_of_type_Zsb = new bfbo(this);
  private zsc jdField_a_of_type_Zsc = new bfbm(this);
  private zse jdField_a_of_type_Zse = new bfbn(this);
  public bfbv[] a;
  protected long b;
  public Map<UUID, Integer> b;
  private zrz b;
  protected boolean b;
  protected long c;
  protected long d;
  public long e;
  private volatile long f;
  
  public TroopFileTransferManager()
  {
    this.jdField_b_of_type_Zrz = new bfbs(this);
    this.jdField_a_of_type_ArrayOfBfbv = new bfbv[] { new bfbv(1), new bfbv(1), new bfbv(2), new bfbv(2), new bfbv(2) };
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
      bfbw.a(paramQQAppInterface);
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
        localObject2 = new bees(paramQQAppInterface, paramLong);
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
      if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1)
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
    bfaw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, paramItem.FileName, paramItem.Status, paramInt);
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
  
  private final void f(TroopFileTransferManager.Item paramItem)
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
  
  /* Error */
  public final becp a(FileManagerEntity paramFileManagerEntity, int paramInt1, int paramInt2, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 239	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lbfbb;
    //   6: aload_1
    //   7: getfield 244	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileName	Ljava/lang/String;
    //   10: aload_1
    //   11: getfield 247	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileSize	J
    //   14: bipush 102
    //   16: invokevirtual 252	bfbb:a	(Ljava/lang/String;JI)Lbebc;
    //   19: astore 6
    //   21: invokestatic 218	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +33 -> 57
    //   27: ldc 220
    //   29: iconst_2
    //   30: new 254	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 257
    //   40: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload 6
    //   45: invokevirtual 267	bebc:toString	()Ljava/lang/String;
    //   48: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload 6
    //   59: ifnonnull +9 -> 68
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: areturn
    //   68: aload_0
    //   69: invokevirtual 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()V
    //   72: aload 6
    //   74: aload_1
    //   75: getfield 273	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strThumbPath	Ljava/lang/String;
    //   78: putfield 275	bebc:i	Ljava/lang/String;
    //   81: aload 6
    //   83: aload_1
    //   84: getfield 278	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strMiddleThumPath	Ljava/lang/String;
    //   87: putfield 281	bebc:k	Ljava/lang/String;
    //   90: aload 6
    //   92: aload_1
    //   93: getfield 284	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strLargeThumPath	Ljava/lang/String;
    //   96: putfield 286	bebc:j	Ljava/lang/String;
    //   99: new 200	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   102: dup
    //   103: aload 6
    //   105: invokespecial 289	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lbebc;)V
    //   108: astore 6
    //   110: aload_0
    //   111: aload 6
    //   113: invokevirtual 291	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   116: aload 6
    //   118: iload_3
    //   119: putfield 294	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:RandomNum	I
    //   122: aload 6
    //   124: lload 4
    //   126: putfield 297	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   129: aload 6
    //   131: iload_2
    //   132: putfield 300	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardBusId	I
    //   135: aload 6
    //   137: iconst_4
    //   138: putfield 208	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   141: aload 6
    //   143: aload_1
    //   144: invokevirtual 303	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   147: putfield 306	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   150: aload 6
    //   152: aload_1
    //   153: getfield 309	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   156: putfield 312	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:entrySessionID	J
    //   159: aload 6
    //   161: aload_1
    //   162: getfield 315	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   165: putfield 318	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   168: aload 6
    //   170: aload_1
    //   171: getfield 321	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   174: putfield 324	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   177: aload_0
    //   178: aload 6
    //   180: iconst_4
    //   181: iconst_0
    //   182: invokevirtual 327	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   185: aload 6
    //   187: aload_0
    //   188: getfield 182	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   191: invokevirtual 331	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lbecp;
    //   194: astore_1
    //   195: goto -131 -> 64
    //   198: astore_1
    //   199: aload_0
    //   200: monitorexit
    //   201: aload_1
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	TroopFileTransferManager
    //   0	203	1	paramFileManagerEntity	FileManagerEntity
    //   0	203	2	paramInt1	int
    //   0	203	3	paramInt2	int
    //   0	203	4	paramLong	long
    //   19	167	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	57	198	finally
    //   68	195	198	finally
  }
  
  public final becp a(String paramString)
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
        str = befa.a(paramString);
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
  
  public becp a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt1, int paramInt2, long paramLong3)
  {
    return null;
  }
  
  public becp a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    return null;
  }
  
  /* Error */
  public final becp a(String paramString1, String paramString2, String paramString3, long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 239	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lbfbb;
    //   6: aload_1
    //   7: aload_2
    //   8: lload 4
    //   10: bipush 102
    //   12: invokevirtual 360	bfbb:c	(Ljava/lang/String;Ljava/lang/String;JI)Lbebc;
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
    //   27: invokevirtual 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()V
    //   30: new 200	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 289	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lbebc;)V
    //   38: astore_1
    //   39: aload_0
    //   40: aload_1
    //   41: invokevirtual 291	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   44: aload_1
    //   45: iload 7
    //   47: putfield 294	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:RandomNum	I
    //   50: aload_1
    //   51: lload 8
    //   53: putfield 297	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   56: aload_1
    //   57: iload 6
    //   59: putfield 300	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardBusId	I
    //   62: aload_1
    //   63: iconst_4
    //   64: putfield 208	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   67: aload_1
    //   68: aload_3
    //   69: putfield 306	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   72: aload_0
    //   73: aload_1
    //   74: iconst_4
    //   75: iconst_0
    //   76: invokevirtual 327	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   79: aload_1
    //   80: aload_0
    //   81: getfield 182	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   84: invokevirtual 331	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lbecp;
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
  public final becp a(String paramString1, String paramString2, String paramString3, long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, FileManagerEntity paramFileManagerEntity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 239	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lbfbb;
    //   6: aload_2
    //   7: lload 4
    //   9: bipush 102
    //   11: invokevirtual 252	bfbb:a	(Ljava/lang/String;JI)Lbebc;
    //   14: astore_1
    //   15: invokestatic 218	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +32 -> 50
    //   21: ldc 220
    //   23: iconst_2
    //   24: new 254	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 363
    //   34: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 267	bebc:toString	()Ljava/lang/String;
    //   41: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_1
    //   51: ifnonnull +9 -> 60
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: areturn
    //   60: aload_0
    //   61: invokevirtual 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()V
    //   64: new 200	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 289	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lbebc;)V
    //   72: astore_1
    //   73: aload_0
    //   74: aload_1
    //   75: invokevirtual 291	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   78: aload_1
    //   79: iload 7
    //   81: putfield 294	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:RandomNum	I
    //   84: aload_1
    //   85: lload 8
    //   87: putfield 297	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   90: aload_1
    //   91: iload 6
    //   93: putfield 300	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardBusId	I
    //   96: aload_1
    //   97: iconst_4
    //   98: putfield 208	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   101: aload_1
    //   102: aload_3
    //   103: putfield 306	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   106: aload_1
    //   107: lload 10
    //   109: putfield 312	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:entrySessionID	J
    //   112: aload 12
    //   114: ifnull +48 -> 162
    //   117: aload_1
    //   118: aload 12
    //   120: getfield 315	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   123: putfield 318	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   126: aload_1
    //   127: aload 12
    //   129: getfield 321	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   132: putfield 324	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   135: aload_1
    //   136: aload 12
    //   138: getfield 366	com/tencent/mobileqq/filemanager/data/FileManagerEntity:yybApkPackageName	Ljava/lang/String;
    //   141: putfield 367	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:yybApkPackageName	Ljava/lang/String;
    //   144: aload_1
    //   145: aload 12
    //   147: getfield 370	com/tencent/mobileqq/filemanager/data/FileManagerEntity:yybApkName	Ljava/lang/String;
    //   150: putfield 371	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:yybApkName	Ljava/lang/String;
    //   153: aload_1
    //   154: aload 12
    //   156: getfield 374	com/tencent/mobileqq/filemanager/data/FileManagerEntity:yybApkIconUrl	Ljava/lang/String;
    //   159: putfield 375	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:yybApkIconUrl	Ljava/lang/String;
    //   162: aload_0
    //   163: aload_1
    //   164: iconst_4
    //   165: iconst_0
    //   166: invokevirtual 327	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   169: aload_1
    //   170: aload_0
    //   171: getfield 182	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   174: invokevirtual 331	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lbecp;
    //   177: astore_1
    //   178: goto -122 -> 56
    //   181: astore_1
    //   182: aload_0
    //   183: monitorexit
    //   184: aload_1
    //   185: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	TroopFileTransferManager
    //   0	186	1	paramString1	String
    //   0	186	2	paramString2	String
    //   0	186	3	paramString3	String
    //   0	186	4	paramLong1	long
    //   0	186	6	paramInt1	int
    //   0	186	7	paramInt2	int
    //   0	186	8	paramLong2	long
    //   0	186	10	paramLong3	long
    //   0	186	12	paramFileManagerEntity	FileManagerEntity
    // Exception table:
    //   from	to	target	type
    //   2	50	181	finally
    //   60	112	181	finally
    //   117	162	181	finally
    //   162	178	181	finally
  }
  
  public becp a(String paramString, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  /* Error */
  public final becp a(UUID paramUUID)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()V
    //   6: aload_0
    //   7: getfield 345	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   10: aload_1
    //   11: invokeinterface 96 2 0
    //   16: checkcast 200	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
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
    //   32: getfield 182	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   35: invokevirtual 331	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lbecp;
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
  
  public bfbb a()
  {
    if (this.jdField_a_of_type_Bfbb == null) {
      this.jdField_a_of_type_Bfbb = bfbb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e);
    }
    return this.jdField_a_of_type_Bfbb;
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
    return null;
  }
  
  public final Collection<becp> a()
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
  
  public final List<becp> a()
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
  
  public final void a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString1, String paramString2, long paramLong3, String paramString3, boolean paramBoolean, long paramLong4, atas paramatas)
  {
    a(paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramString1, paramString2, paramLong3, paramString3, paramBoolean, paramLong4, paramatas, 0L, 0, null);
  }
  
  public final void a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString1, String paramString2, long paramLong3, String paramString3, boolean paramBoolean, long paramLong4, atas paramatas, long paramLong5, int paramInt4, Bundle paramBundle)
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
        if (this.jdField_a_of_type_Bfbb == null) {
          this.jdField_a_of_type_Bfbb = a();
        }
        Object localObject = this.jdField_a_of_type_Bfbb.a(paramString3);
        if (localObject != null)
        {
          paramInt2 = ((bebc)localObject).jdField_a_of_type_Int;
          break label375;
          localObject = ???.a(paramString1, paramLong3, paramInt2);
          if (localObject != null) {}
        }
        else
        {
          paramInt2 = 102;
          break label375;
          if ((paramInt3 != 7) && (paramInt3 != 6003)) {
            break label369;
          }
          i = 38;
          continue;
        }
        c();
        localObject = new TroopFileTransferManager.Item((bebc)localObject);
        a((TroopFileTransferManager.Item)localObject);
        ((TroopFileTransferManager.Item)localObject).RandomNum = j;
        ((TroopFileTransferManager.Item)localObject).ForwardPath = paramString3;
        ((TroopFileTransferManager.Item)localObject).ForwardTroopuin = paramLong1;
        ((TroopFileTransferManager.Item)localObject).mForwardCallback = paramatas;
        if (paramBundle != null)
        {
          if (paramBundle.containsKey("yyb_apk_package_name_key")) {
            ((TroopFileTransferManager.Item)localObject).yybApkPackageName = paramBundle.getString("yyb_apk_package_name_key", "");
          }
          if (paramBundle.containsKey("yyb_apk_name_key")) {
            ((TroopFileTransferManager.Item)localObject).yybApkName = paramBundle.getString("yyb_apk_name_key", "");
          }
          if (paramBundle.containsKey("yyb_apk_icon_url_key")) {
            ((TroopFileTransferManager.Item)localObject).yybApkIconUrl = paramBundle.getString("yyb_apk_icon_url_key", "");
          }
        }
        if (!paramBoolean)
        {
          paramLong1 = paramatas.a(String.valueOf(paramLong2), paramInt3, String.valueOf(paramLong1), paramInt2, paramString3, paramString1, paramString2, paramLong3, paramInt1, paramLong5, paramInt4);
          ((TroopFileTransferManager.Item)localObject).ForwardBusId = paramInt2;
          ((TroopFileTransferManager.Item)localObject).BusId = i;
          zrj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.e, (TroopFileTransferManager.Item)localObject, paramLong2, paramLong1, this.jdField_b_of_type_Zrz);
          return;
          paramString1 = finally;
          throw paramString1;
        }
        paramLong1 = paramLong4;
        continue;
        i = 3;
      }
      finally {}
      label369:
      continue;
      label375:
      if (paramInt3 == 3000) {
        i = 106;
      }
    }
  }
  
  public void a(bebc parambebc) {}
  
  protected final void a(becp parambecp, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    FileManagerEntity localFileManagerEntity = aszt.a(parambecp);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(parambecp.jdField_b_of_type_Long);
    localFileManagerEntity.peerNick = ContactUtils.getTroopNickNameByTroopCode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (bbko.a() * 1000L);
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
        localFileManagerEntity.strFileSha3 = asnl.a(aszt.c(parambecp.a));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = asnl.a(aszt.a(parambecp.a));
      }
    }
    localFileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(aszt.e(parambecp.a));
    try
    {
      localFileManagerEntity.localModifyTime = new File(parambecp.a).lastModified();
      label221:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
      return;
    }
    catch (Exception parambecp)
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
  
  public void a(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2) {}
  
  public void a(TroopFileTransferManager.Item paramItem, int paramInt, bfay parambfay) {}
  
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
        if ((1 == NetworkUtil.getSystemNetwork(BaseApplication.getContext())) || (paramInt != 128)) {
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
      zrj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, paramItem, paramInt, paramBoolean, false, this.jdField_a_of_type_Zsa);
      if ((paramBoolean) || (paramInt != 0)) {
        break;
      }
      bfdx.b();
      break;
      a(paramItem, 8);
      localObject = (bebc)a().jdField_c_of_type_JavaUtilMap.get(paramItem.FilePath);
      if (localObject != null)
      {
        bebc localbebc = (bebc)a().jdField_c_of_type_JavaUtilMap.get(((bebc)localObject).f);
        if (localbebc != null)
        {
          ((bebc)localObject).e = 8;
          localbebc.a((bebc)localObject);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt) {}
  
  public void a(Collection<String> paramCollection, boolean paramBoolean) {}
  
  public void a(List<becp> paramList) {}
  
  public void a(UUID paramUUID) {}
  
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
    //   3: getfield 627	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_b_of_type_Boolean	Z
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
    //   18: getfield 116	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: aload_0
    //   22: getfield 345	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   25: aload_0
    //   26: getfield 182	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   29: invokestatic 632	bezv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/Map;J)Z
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
          break label1023;
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
          break label818;
        }
        i = 207;
        switch (paramInt)
        {
        default: 
          if (TextUtils.isEmpty(str))
          {
            if (!TextUtils.isEmpty(paramString3)) {
              break label792;
            }
            paramUUID = new bfay(paramString1.FileName, this.e, 5, 207);
            a(paramString1, 5, paramUUID);
            return true;
          }
        case -20001: 
        case -20000: 
        case -403: 
          paramUUID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong);
          if (paramUUID == null)
          {
            if (!TextUtils.isEmpty(paramString3))
            {
              a(paramString1, 5, new bfay(paramString1.FileName, this.e, 5, 704, paramString3));
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
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramUUID, 27);
            if (QLog.isColorLevel()) {
              QLog.e("TroopFileTransferManager", 2, String.format("retCode:%d is, change busid to 104, try ForwardFromOfflineFile again!", new Object[] { Integer.valueOf(paramInt) }));
            }
            return true;
          }
          if (paramUUID.nOpType != 26) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(104, paramUUID);
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
      new Handler(Looper.getMainLooper()).postDelayed(new TroopFileTransferManager.10(this, paramString1), 1000L);
      return true;
      if ((!TextUtils.isEmpty(paramString1.LocalFile)) && (new File(paramString1.LocalFile).exists()))
      {
        a(paramString1, 0);
        paramString1.BusId = 102;
        this.jdField_a_of_type_ArrayOfBfbv[0].a(new TroopFileTransferManager.TaskScan(this, paramString1));
        return true;
      }
      i = 603;
      continue;
      i = 705;
      continue;
      a(paramString1, 5, new bfay(paramString1.FileName, this.e, 5, 704, paramString3));
      return true;
      label792:
      paramUUID = new bfay(paramString1.FileName, this.e, 5, 704, paramString3);
      continue;
      label818:
      if (TextUtils.isEmpty(str))
      {
        if (TextUtils.isEmpty(paramString3)) {}
        for (paramUUID = new bfay(paramString1.FileName, this.e, 5, 207);; paramUUID = new bfay(paramString1.FileName, this.e, 5, 704, paramString3))
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
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramString1.entrySessionID);
      if (paramString2 != null)
      {
        paramString2.strTroopFilePath = str;
        paramString3 = aszt.e(paramString2);
        paramString2.strQRUrl = paramString3;
        paramString1.strQRUrl = paramString3;
      }
      if (this.jdField_a_of_type_Bfbb != null) {
        this.jdField_a_of_type_Bfbb.a(paramUUID.b, paramUUID);
      }
      a(paramString1, 6, 0);
      c(paramString1);
      return true;
      label1023:
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
        i = befc.jdField_a_of_type_Int;
        localStringBuilder = new StringBuilder().append("[");
        if (paramItem.Id != null) {}
        for (str = paramItem.Id.toString();; str = "null")
        {
          befc.b("TroopFileTransferManager", i, str + "] check localfile is not exsit. set to nodownload state");
          a(paramItem, 7);
          bool1 = true;
          break;
        }
      }
      int i = befc.jdField_a_of_type_Int;
      StringBuilder localStringBuilder = new StringBuilder().append("[");
      if (paramItem.Id != null) {}
      for (String str = paramItem.Id.toString();; str = "null")
      {
        befc.b("TroopFileTransferManager", i, str + "] check localfile=null. set to nodownload state");
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
        paramString1.LocalFile = (AppConstants.SDCARD_FILE_SAVE_PATH + paramString2);
        b(paramString1);
        ((amoo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(22)).a(paramString1.getInfo(this.e));
        bool = true;
      }
      finally {}
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong, int paramInt, zsa paramzsa)
  {
    synchronized (a()) {}
    label167:
    for (;;)
    {
      try
      {
        bebc localbebc = ???.a(paramString1, paramString2, paramLong, paramInt);
        if (localbebc == null) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopFileTransferManager", 2, "startDownload==>" + localbebc.toString());
        }
        c();
        paramString1 = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(localbebc.jdField_a_of_type_JavaUtilUUID);
        if (paramString1 != null) {
          break label167;
        }
        paramString1 = new TroopFileTransferManager.Item(localbebc);
        a(paramString1);
        paramString1.FileName = paramString2;
        paramString1.ProgressTotal = paramLong;
        paramString1.ProgressValue = localbebc.d;
        zrj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, paramString1, 0, false, true, paramzsa);
        return true;
      }
      finally {}
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean a(UUID paramUUID)
  {
    return false;
  }
  
  public boolean a(UUID paramUUID, int paramInt)
  {
    return false;
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
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 627	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_b_of_type_Boolean	Z
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
    //   18: invokevirtual 839	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()Z
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
    //   5: getfield 842	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   8: ifeq +28 -> 36
    //   11: aload_1
    //   12: getfield 842	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   15: iconst_1
    //   16: if_icmpne +15 -> 31
    //   19: iconst_2
    //   20: istore_2
    //   21: aload_0
    //   22: aload_1
    //   23: iload_2
    //   24: invokevirtual 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
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
    return false;
  }
  
  public void c() {}
  
  public void c(TroopFileTransferManager.Item paramItem)
  {
    zrj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, paramItem, this.jdField_a_of_type_Zsb);
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
    //   5: getfield 842	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   8: ifeq +30 -> 38
    //   11: aload_1
    //   12: getfield 842	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   15: iconst_1
    //   16: if_icmpne +16 -> 32
    //   19: bipush 9
    //   21: istore_2
    //   22: aload_0
    //   23: aload_1
    //   24: iload_2
    //   25: invokevirtual 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
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
    return false;
  }
  
  protected void d() {}
  
  public void d(TroopFileTransferManager.Item paramItem) {}
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null;
  }
  
  public boolean d(UUID paramUUID)
  {
    return false;
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
    zrj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, paramItem, this.jdField_a_of_type_Zse);
  }
  
  public boolean e(UUID paramUUID)
  {
    return false;
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
            break label260;
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
      f(paramUUID);
      boolean bool = true;
      continue;
      continue;
      label260:
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
  
  /* Error */
  protected final void h()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 80	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:f	J
    //   8: lconst_0
    //   9: lcmp
    //   10: ifne +31 -> 41
    //   13: aload_0
    //   14: invokestatic 903	android/os/SystemClock:uptimeMillis	()J
    //   17: putfield 80	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:f	J
    //   20: iload_1
    //   21: ifeq +17 -> 38
    //   24: new 905	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$11
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 906	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$11:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;)V
    //   32: iconst_5
    //   33: aconst_null
    //   34: iconst_1
    //   35: invokestatic 109	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
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
        label26:
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
            break label154;
            if (i == 0) {
              break label26;
            }
            bfaw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, 107);
            break label26;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager
 * JD-Core Version:    0.7.0.1
 */