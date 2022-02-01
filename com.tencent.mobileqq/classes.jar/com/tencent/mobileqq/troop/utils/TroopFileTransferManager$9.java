package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqCopyToObserver;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.UUID;

class TroopFileTransferManager$9
  extends TroopFileReqCopyToObserver
{
  TroopFileTransferManager$9(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  private final void a(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopFileTransferManager", 4, String.format("onRspCopyToOffline -fileName: %s ,- retCode: %d, -retMsg: %s", new Object[] { paramItem.FileName, Integer.valueOf(paramInt1), paramString2 }));
      }
      if (paramInt1 != 0)
      {
        if (paramItem.mForwardCallback != null) {
          paramItem.mForwardCallback.a(false, paramLong, paramInt1, paramString3, paramItem.Id.toString(), String.valueOf(paramItem.ForwardTroopuin), "");
        }
      }
      else if (paramItem.mForwardCallback != null) {
        paramItem.mForwardCallback.a(true, paramLong, paramInt1, "", paramItem.Id.toString(), String.valueOf(paramItem.ForwardTroopuin), paramString1);
      }
      return;
    }
    finally {}
  }
  
  public final void a(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    label47:
    label127:
    try
    {
      if (!QLog.isDevelopLevel()) {
        break label414;
      }
      QLog.e("TroopFileTransferManager", 4, String.format("onRspCopyToGroup - retCode: %d", new Object[] { Integer.valueOf(paramInt1) }));
    }
    finally {}
    paramString1 = HardCodeUtil.a(2131912593);
    paramInt1 = 706;
    break label187;
    if ((!TextUtils.isEmpty(paramItem.LocalFile)) && (new File(paramItem.LocalFile).exists()))
    {
      this.a.b(paramItem, 0);
      paramItem.BusId = 102;
      this.a.i[0].a(new TroopFileTransferManager.TaskScan(this.a, paramItem));
      return;
    }
    paramString1 = paramString3;
    paramInt1 = 603;
    break label187;
    if (paramItem.BusId == 102)
    {
      paramItem.BusId = 104;
      TroopFileProtocol.a(this.a.j, false, this.a.k, paramItem, this.a.k, 0L, TroopFileTransferManager.b(this.a));
      return;
    }
    paramString1 = paramString3;
    paramInt1 = 204;
    for (;;)
    {
      label187:
      paramString1 = new TroopFileError.SimpleErrorInfo(paramItem.FileName, paramItem.ForwardTroopuin, 5, paramInt1, paramString1);
      this.a.a(paramItem, 5, paramString1);
      paramItem = this.a.j.getFileManagerDataCenter().a(paramItem.entrySessionID);
      if (paramItem != null)
      {
        long l = paramItem.structMsgSeq;
        paramItem = this.a.j.getMessageFacade();
        paramString1 = new StringBuilder();
        paramString1.append("");
        paramString1.append(this.a.k);
        paramItem.h(paramString1.toString(), 1, l);
      }
      return;
      label414:
      do
      {
        new Handler(Looper.getMainLooper()).post(new TroopFileTransferManager.9.1(this));
        paramItem.FilePath = paramString1;
        paramString2 = paramItem.getInfo(this.a.k);
        if (paramString2 != null) {
          paramString2.r = paramString1;
        }
        paramString2 = this.a.j.getFileManagerDataCenter().a(paramItem.entrySessionID);
        if (paramString2 != null) {
          paramString2.strTroopFilePath = paramString1;
        }
        this.a.a(paramItem, 7, 0);
        this.a.c(paramItem);
        return;
      } while (paramInt1 >= 0);
      if ((paramInt1 == -20001) || (paramInt1 == -20000)) {
        break label127;
      }
      if (paramInt1 == -6101) {
        break label47;
      }
      if (paramInt1 == -403) {
        break label127;
      }
      if (paramInt1 == -36) {
        break;
      }
      if (paramInt1 != -30)
      {
        if ((paramInt1 != -25) && (paramInt1 != -22))
        {
          if ((paramInt1 != -139) && (paramInt1 != -138))
          {
            if (paramInt1 != -4)
            {
              if (paramInt1 != -3)
              {
                paramString1 = paramString3;
                paramInt1 = 207;
              }
              else
              {
                paramString1 = paramString3;
                paramInt1 = 202;
              }
            }
            else
            {
              paramString1 = paramString3;
              paramInt1 = 600;
            }
          }
          else
          {
            paramString1 = paramString3;
            paramInt1 = -139;
          }
        }
        else
        {
          paramString1 = paramString3;
          paramInt1 = 701;
        }
      }
      else
      {
        paramString1 = paramString3;
        paramInt1 = 705;
      }
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload 7
    //   2: ldc 235
    //   4: invokevirtual 241	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   7: lstore 8
    //   9: ldc 105
    //   11: monitorenter
    //   12: invokestatic 245	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:t	()Ljava/util/Map;
    //   15: lload 8
    //   17: invokestatic 250	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   20: invokeinterface 256 2 0
    //   25: checkcast 105	com/tencent/mobileqq/troop/utils/TroopFileTransferManager
    //   28: astore 10
    //   30: aload 10
    //   32: ifnonnull +50 -> 82
    //   35: invokestatic 21	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   38: ifeq +40 -> 78
    //   41: new 175	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   48: astore 4
    //   50: aload 4
    //   52: ldc_w 258
    //   55: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 4
    //   61: lload 8
    //   63: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: ldc 23
    //   69: iconst_4
    //   70: aload 4
    //   72: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 260	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: ldc 105
    //   80: monitorexit
    //   81: return
    //   82: ldc 105
    //   84: monitorexit
    //   85: aload 7
    //   87: ldc_w 262
    //   90: invokevirtual 266	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   93: astore 11
    //   95: aload 11
    //   97: ifnonnull +4 -> 101
    //   100: return
    //   101: aload 11
    //   103: invokestatic 270	java/util/UUID:fromString	(Ljava/lang/String;)Ljava/util/UUID;
    //   106: astore 12
    //   108: aload 10
    //   110: monitorenter
    //   111: aload 10
    //   113: getfield 274	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:l	Ljava/util/Map;
    //   116: aload 12
    //   118: invokeinterface 256 2 0
    //   123: checkcast 29	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   126: astore 12
    //   128: aload 12
    //   130: ifnonnull +50 -> 180
    //   133: invokestatic 21	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   136: ifeq +40 -> 176
    //   139: new 175	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   146: astore 4
    //   148: aload 4
    //   150: ldc_w 276
    //   153: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 4
    //   159: aload 11
    //   161: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: ldc 23
    //   167: iconst_4
    //   168: aload 4
    //   170: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 260	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload 10
    //   178: monitorexit
    //   179: return
    //   180: aload 10
    //   182: monitorexit
    //   183: invokestatic 21	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   186: ifeq +26 -> 212
    //   189: ldc 23
    //   191: iconst_4
    //   192: ldc_w 278
    //   195: iconst_1
    //   196: anewarray 27	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: iload_2
    //   202: invokestatic 39	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   205: aastore
    //   206: invokestatic 45	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   209: invokestatic 49	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload 12
    //   214: getfield 113	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   217: bipush 25
    //   219: if_icmpne +18 -> 237
    //   222: aload_0
    //   223: aload 12
    //   225: iload_2
    //   226: iload_3
    //   227: aload 4
    //   229: aload 5
    //   231: aload 6
    //   233: invokevirtual 280	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$9:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   236: return
    //   237: aload 12
    //   239: getfield 113	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   242: bipush 102
    //   244: if_icmpeq +68 -> 312
    //   247: aload 12
    //   249: getfield 113	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   252: bipush 104
    //   254: if_icmpne +6 -> 260
    //   257: goto +55 -> 312
    //   260: aload 12
    //   262: getfield 113	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   265: iconst_3
    //   266: if_icmpeq +23 -> 289
    //   269: aload 12
    //   271: getfield 113	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   274: bipush 106
    //   276: if_icmpeq +13 -> 289
    //   279: aload 12
    //   281: getfield 113	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   284: bipush 38
    //   286: if_icmpne +40 -> 326
    //   289: aload_0
    //   290: aload 12
    //   292: iload_2
    //   293: iload_3
    //   294: aload 4
    //   296: aload 5
    //   298: aload 6
    //   300: aload 7
    //   302: ldc_w 282
    //   305: invokevirtual 241	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   308: invokespecial 284	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$9:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   311: return
    //   312: aload_0
    //   313: aload 12
    //   315: iload_2
    //   316: iload_3
    //   317: aload 4
    //   319: aload 5
    //   321: aload 6
    //   323: invokevirtual 286	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$9:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   326: return
    //   327: astore 4
    //   329: aload 10
    //   331: monitorexit
    //   332: aload 4
    //   334: athrow
    //   335: astore 4
    //   337: ldc 105
    //   339: monitorexit
    //   340: aload 4
    //   342: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	9
    //   0	343	1	paramBoolean	boolean
    //   0	343	2	paramInt1	int
    //   0	343	3	paramInt2	int
    //   0	343	4	paramString1	String
    //   0	343	5	paramString2	String
    //   0	343	6	paramString3	String
    //   0	343	7	paramBundle	android.os.Bundle
    //   7	55	8	l	long
    //   28	302	10	localTroopFileTransferManager	TroopFileTransferManager
    //   93	67	11	str	String
    //   106	208	12	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   111	128	327	finally
    //   133	176	327	finally
    //   176	179	327	finally
    //   180	183	327	finally
    //   329	332	327	finally
    //   12	30	335	finally
    //   35	78	335	finally
    //   78	81	335	finally
    //   82	85	335	finally
    //   337	340	335	finally
  }
  
  public final void b(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopFileTransferManager", 4, String.format("onRspCopyToWeiyun - retCode: %d", new Object[] { Integer.valueOf(paramInt1) }));
      }
      ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(paramInt1);
      if (paramInt1 == 0) {
        break label225;
      }
      if ((paramInt1 != -20001) && (paramInt1 != -20000))
      {
        if (paramInt1 == -6101) {
          break label309;
        }
        if (paramInt1 != -403)
        {
          if (paramInt1 == -30) {
            break label302;
          }
          if ((paramInt1 == -25) || (paramInt1 == -22)) {
            break label295;
          }
          if (paramInt1 == -3) {
            break label288;
          }
          if (paramInt1 == 1053) {
            break label281;
          }
          if ((paramInt1 != 1054) || (TextUtils.isEmpty(paramString3))) {
            break label274;
          }
          paramInt1 = 704;
          break label187;
        }
      }
      if (paramItem.BusId != 102) {
        break label281;
      }
      paramItem.BusId = 104;
      TroopFileProtocol.a(this.a.j, false, this.a.k, paramItem, this.a.k, 0L, TroopFileTransferManager.b(this.a));
      return;
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          label187:
          label225:
          throw paramItem;
        }
        label274:
        paramInt1 = 601;
        continue;
        label281:
        paramInt1 = 702;
        continue;
        label288:
        paramInt1 = 202;
        continue;
        label295:
        paramInt1 = 701;
        continue;
        label302:
        paramInt1 = 705;
        continue;
        label309:
        paramInt1 = 703;
      }
    }
    paramString1 = new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.a.k, 5, paramInt1, paramString3);
    this.a.a(paramItem, 5, paramString1);
    return;
    paramString1 = new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.a.k, 5, 602);
    this.a.a(paramItem, 5, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.9
 * JD-Core Version:    0.7.0.1
 */