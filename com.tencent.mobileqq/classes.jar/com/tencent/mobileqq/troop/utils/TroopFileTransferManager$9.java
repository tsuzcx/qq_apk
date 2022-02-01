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
    paramString1 = HardCodeUtil.a(2131715105);
    paramInt1 = 706;
    break label187;
    if ((!TextUtils.isEmpty(paramItem.LocalFile)) && (new File(paramItem.LocalFile).exists()))
    {
      this.a.a(paramItem, 0);
      paramItem.BusId = 102;
      this.a.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$TaskPool[0].a(new TroopFileTransferManager.TaskScan(this.a, paramItem));
      return;
    }
    paramString1 = paramString3;
    paramInt1 = 603;
    break label187;
    if (paramItem.BusId == 102)
    {
      paramItem.BusId = 104;
      TroopFileProtocol.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.a.e, paramItem, this.a.e, 0L, TroopFileTransferManager.a(this.a));
      return;
    }
    paramString1 = paramString3;
    paramInt1 = 204;
    for (;;)
    {
      label187:
      paramString1 = new TroopFileError.SimpleErrorInfo(paramItem.FileName, paramItem.ForwardTroopuin, 5, paramInt1, paramString1);
      this.a.a(paramItem, 5, paramString1);
      paramItem = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramItem.entrySessionID);
      if (paramItem != null)
      {
        long l = paramItem.structMsgSeq;
        paramItem = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
        paramString1 = new StringBuilder();
        paramString1.append("");
        paramString1.append(this.a.e);
        paramItem.b(paramString1.toString(), 1, l);
      }
      return;
      label414:
      do
      {
        new Handler(Looper.getMainLooper()).post(new TroopFileTransferManager.9.1(this));
        paramItem.FilePath = paramString1;
        paramString2 = paramItem.getInfo(this.a.e);
        if (paramString2 != null) {
          paramString2.e = paramString1;
        }
        paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramItem.entrySessionID);
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
    //   2: ldc 230
    //   4: invokevirtual 236	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   7: lstore 8
    //   9: ldc 105
    //   11: monitorenter
    //   12: invokestatic 239	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Ljava/util/Map;
    //   15: lload 8
    //   17: invokestatic 244	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   20: invokeinterface 250 2 0
    //   25: checkcast 105	com/tencent/mobileqq/troop/utils/TroopFileTransferManager
    //   28: astore 10
    //   30: aload 10
    //   32: ifnonnull +49 -> 81
    //   35: invokestatic 21	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   38: ifeq +39 -> 77
    //   41: new 171	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   48: astore 4
    //   50: aload 4
    //   52: ldc 252
    //   54: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 4
    //   60: lload 8
    //   62: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: ldc 23
    //   68: iconst_4
    //   69: aload 4
    //   71: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: ldc 105
    //   79: monitorexit
    //   80: return
    //   81: ldc 105
    //   83: monitorexit
    //   84: aload 7
    //   86: ldc_w 257
    //   89: invokevirtual 261	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 11
    //   94: aload 11
    //   96: ifnonnull +4 -> 100
    //   99: return
    //   100: aload 11
    //   102: invokestatic 265	java/util/UUID:fromString	(Ljava/lang/String;)Ljava/util/UUID;
    //   105: astore 12
    //   107: aload 10
    //   109: monitorenter
    //   110: aload 10
    //   112: getfield 268	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   115: aload 12
    //   117: invokeinterface 250 2 0
    //   122: checkcast 29	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   125: astore 12
    //   127: aload 12
    //   129: ifnonnull +50 -> 179
    //   132: invokestatic 21	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   135: ifeq +40 -> 175
    //   138: new 171	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   145: astore 4
    //   147: aload 4
    //   149: ldc_w 270
    //   152: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 4
    //   158: aload 11
    //   160: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: ldc 23
    //   166: iconst_4
    //   167: aload 4
    //   169: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aload 10
    //   177: monitorexit
    //   178: return
    //   179: aload 10
    //   181: monitorexit
    //   182: invokestatic 21	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   185: ifeq +26 -> 211
    //   188: ldc 23
    //   190: iconst_4
    //   191: ldc_w 272
    //   194: iconst_1
    //   195: anewarray 27	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: iload_2
    //   201: invokestatic 39	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   204: aastore
    //   205: invokestatic 45	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   208: invokestatic 49	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: aload 12
    //   213: getfield 112	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   216: bipush 25
    //   218: if_icmpne +18 -> 236
    //   221: aload_0
    //   222: aload 12
    //   224: iload_2
    //   225: iload_3
    //   226: aload 4
    //   228: aload 5
    //   230: aload 6
    //   232: invokevirtual 274	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$9:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   235: return
    //   236: aload 12
    //   238: getfield 112	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   241: bipush 102
    //   243: if_icmpeq +68 -> 311
    //   246: aload 12
    //   248: getfield 112	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   251: bipush 104
    //   253: if_icmpne +6 -> 259
    //   256: goto +55 -> 311
    //   259: aload 12
    //   261: getfield 112	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   264: iconst_3
    //   265: if_icmpeq +23 -> 288
    //   268: aload 12
    //   270: getfield 112	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   273: bipush 106
    //   275: if_icmpeq +13 -> 288
    //   278: aload 12
    //   280: getfield 112	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   283: bipush 38
    //   285: if_icmpne +40 -> 325
    //   288: aload_0
    //   289: aload 12
    //   291: iload_2
    //   292: iload_3
    //   293: aload 4
    //   295: aload 5
    //   297: aload 6
    //   299: aload 7
    //   301: ldc_w 276
    //   304: invokevirtual 236	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   307: invokespecial 278	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$9:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   310: return
    //   311: aload_0
    //   312: aload 12
    //   314: iload_2
    //   315: iload_3
    //   316: aload 4
    //   318: aload 5
    //   320: aload 6
    //   322: invokevirtual 280	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$9:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   325: return
    //   326: astore 4
    //   328: aload 10
    //   330: monitorexit
    //   331: aload 4
    //   333: athrow
    //   334: astore 4
    //   336: ldc 105
    //   338: monitorexit
    //   339: aload 4
    //   341: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	this	9
    //   0	342	1	paramBoolean	boolean
    //   0	342	2	paramInt1	int
    //   0	342	3	paramInt2	int
    //   0	342	4	paramString1	String
    //   0	342	5	paramString2	String
    //   0	342	6	paramString3	String
    //   0	342	7	paramBundle	android.os.Bundle
    //   7	54	8	l	long
    //   28	301	10	localTroopFileTransferManager	TroopFileTransferManager
    //   92	67	11	str	String
    //   105	208	12	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   110	127	326	finally
    //   132	175	326	finally
    //   175	178	326	finally
    //   179	182	326	finally
    //   328	331	326	finally
    //   12	30	334	finally
    //   35	77	334	finally
    //   77	80	334	finally
    //   81	84	334	finally
    //   336	339	334	finally
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
      TroopFileProtocol.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.a.e, paramItem, this.a.e, 0L, TroopFileTransferManager.a(this.a));
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
    paramString1 = new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.a.e, 5, paramInt1, paramString3);
    this.a.a(paramItem, 5, paramString1);
    return;
    paramString1 = new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.a.e, 5, 602);
    this.a.a(paramItem, 5, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.9
 * JD-Core Version:    0.7.0.1
 */