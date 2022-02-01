package com.tencent.mobileqq.transfile;

import admh;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class ShortVideoUploadABTest
{
  private static final boolean S_ENABLE_AB_TEST = true;
  private static final String TAG = "ShortVideoUploadABTest";
  public static long _ABTestOldClickTime;
  public static long _ABTestOldCompressCost;
  public static long _ABTestOldRecordTime;
  public static long _ABTestOldThumbCost;
  public static Object sABLock = new Object();
  public static boolean sEnablePreUpload = true;
  public static ShortVideoUploadABTest.ABTestInfo sLastNew;
  public static ShortVideoUploadABTest.ABTestInfo sLastOld;
  public static HashMap<Long, ShortVideoUploadABTest.ABTestInfo> sLogMarkerAB = new HashMap();
  
  public static boolean canPerformABTest(int paramInt, String paramString)
  {
    if (!isEnableAbTest()) {}
    do
    {
      return false;
      if ((paramInt == 0) && ("51640996".equalsIgnoreCase(paramString))) {
        return true;
      }
    } while ((paramInt != 1) || (!"498450958".equalsIgnoreCase(paramString)));
    return true;
  }
  
  public static void doSendABTestMessage(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    if ((!canPerformABTest(paramSessionInfo.curType, paramSessionInfo.curFriendUin)) || (paramString == null)) {
      return;
    }
    admh.b(paramQQAppInterface, paramContext, paramSessionInfo, paramString);
  }
  
  /* Error */
  @android.annotation.TargetApi(10)
  public static void dumpABTestInfo(QQAppInterface paramQQAppInterface, ShortVideoUploadABTest.ABTestInfo paramABTestInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 86	com/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo:uinType	I
    //   4: aload_1
    //   5: getfield 89	com/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo:peerUin	Ljava/lang/String;
    //   8: invokestatic 69	com/tencent/mobileqq/transfile/ShortVideoUploadABTest:canPerformABTest	(ILjava/lang/String;)Z
    //   11: ifne +4 -> 15
    //   14: return
    //   15: aload_1
    //   16: getfield 92	com/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo:strDstPath	Ljava/lang/String;
    //   19: astore 4
    //   21: aload 4
    //   23: ifnull +208 -> 231
    //   26: aload 4
    //   28: invokevirtual 96	java/lang/String:length	()I
    //   31: ifle +200 -> 231
    //   34: aload_1
    //   35: new 98	java/io/File
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: invokevirtual 104	java/io/File:length	()J
    //   47: putfield 107	com/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo:lSizeMergeC	J
    //   50: getstatic 112	android/os/Build$VERSION:SDK_INT	I
    //   53: bipush 10
    //   55: if_icmplt +226 -> 281
    //   58: new 114	android/media/MediaMetadataRetriever
    //   61: dup
    //   62: invokespecial 115	android/media/MediaMetadataRetriever:<init>	()V
    //   65: astore_3
    //   66: aload_3
    //   67: astore_2
    //   68: aload_3
    //   69: aload 4
    //   71: invokevirtual 118	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   74: aload_3
    //   75: astore_2
    //   76: aload_1
    //   77: aload_3
    //   78: bipush 9
    //   80: invokevirtual 122	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   83: invokestatic 128	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   86: invokevirtual 131	java/lang/Long:longValue	()J
    //   89: putfield 134	com/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo:lDuraMergeC	J
    //   92: aload_3
    //   93: astore_2
    //   94: aload_3
    //   95: invokevirtual 137	android/media/MediaMetadataRetriever:release	()V
    //   98: aload_3
    //   99: ifnull +7 -> 106
    //   102: aload_3
    //   103: invokevirtual 137	android/media/MediaMetadataRetriever:release	()V
    //   106: aload_1
    //   107: aload_1
    //   108: getfield 140	com/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo:lFiniTime	J
    //   111: aload_1
    //   112: getfield 143	com/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo:lClickTime	J
    //   115: lsub
    //   116: ldc2_w 144
    //   119: lsub
    //   120: putfield 148	com/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo:lUserWait	J
    //   123: aload_1
    //   124: aload_1
    //   125: getfield 148	com/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo:lUserWait	J
    //   128: l2f
    //   129: aload_1
    //   130: getfield 151	com/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo:iDuration	I
    //   133: i2f
    //   134: fdiv
    //   135: putfield 155	com/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo:fCompCode	F
    //   138: aload_1
    //   139: getfield 158	com/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo:abType	I
    //   142: iconst_1
    //   143: if_icmpne +117 -> 260
    //   146: aload_1
    //   147: invokestatic 162	com/tencent/mobileqq/transfile/ShortVideoUploadABTest:dumpNewInfoString	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo;)Ljava/lang/String;
    //   150: astore_2
    //   151: aload_1
    //   152: putstatic 164	com/tencent/mobileqq/transfile/ShortVideoUploadABTest:sLastNew	Lcom/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo;
    //   155: new 60	com/tencent/mobileqq/activity/aio/SessionInfo
    //   158: dup
    //   159: invokespecial 165	com/tencent/mobileqq/activity/aio/SessionInfo:<init>	()V
    //   162: astore_3
    //   163: aload_3
    //   164: aload_1
    //   165: getfield 86	com/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo:uinType	I
    //   168: putfield 64	com/tencent/mobileqq/activity/aio/SessionInfo:curType	I
    //   171: aload_3
    //   172: aload_1
    //   173: getfield 89	com/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo:peerUin	Ljava/lang/String;
    //   176: putfield 67	com/tencent/mobileqq/activity/aio/SessionInfo:curFriendUin	Ljava/lang/String;
    //   179: aload_0
    //   180: invokestatic 169	com/tencent/mobileqq/transfile/ShortVideoUploadABTest:performABTest	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   183: aload_0
    //   184: invokestatic 175	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   187: invokevirtual 179	com/tencent/qphone/base/util/BaseApplication:getBaseContext	()Landroid/content/Context;
    //   190: aload_3
    //   191: aload_2
    //   192: invokestatic 181	com/tencent/mobileqq/transfile/ShortVideoUploadABTest:doSendABTestMessage	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/mobileqq/activity/aio/SessionInfo;Ljava/lang/String;)V
    //   195: return
    //   196: astore 4
    //   198: aconst_null
    //   199: astore_3
    //   200: aload_3
    //   201: astore_2
    //   202: aload 4
    //   204: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   207: aload_3
    //   208: ifnull -102 -> 106
    //   211: aload_3
    //   212: invokevirtual 137	android/media/MediaMetadataRetriever:release	()V
    //   215: goto -109 -> 106
    //   218: astore_0
    //   219: aconst_null
    //   220: astore_2
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 137	android/media/MediaMetadataRetriever:release	()V
    //   229: aload_0
    //   230: athrow
    //   231: ldc 11
    //   233: iconst_2
    //   234: new 186	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   241: ldc 189
    //   243: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload 4
    //   248: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: goto -151 -> 106
    //   260: aload_1
    //   261: invokestatic 206	com/tencent/mobileqq/transfile/ShortVideoUploadABTest:dumpOldInfoString	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo;)Ljava/lang/String;
    //   264: astore_2
    //   265: aload_1
    //   266: putstatic 208	com/tencent/mobileqq/transfile/ShortVideoUploadABTest:sLastOld	Lcom/tencent/mobileqq/transfile/ShortVideoUploadABTest$ABTestInfo;
    //   269: goto -114 -> 155
    //   272: astore_0
    //   273: goto -52 -> 221
    //   276: astore 4
    //   278: goto -78 -> 200
    //   281: aconst_null
    //   282: astore_3
    //   283: goto -185 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramQQAppInterface	QQAppInterface
    //   0	286	1	paramABTestInfo	ShortVideoUploadABTest.ABTestInfo
    //   67	198	2	localObject1	Object
    //   65	218	3	localObject2	Object
    //   19	51	4	str	String
    //   196	51	4	localException1	java.lang.Exception
    //   276	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   50	66	196	java/lang/Exception
    //   50	66	218	finally
    //   68	74	272	finally
    //   76	92	272	finally
    //   94	98	272	finally
    //   202	207	272	finally
    //   68	74	276	java/lang/Exception
    //   76	92	276	java/lang/Exception
    //   94	98	276	java/lang/Exception
  }
  
  public static String dumpNewInfoString(ShortVideoUploadABTest.ABTestInfo paramABTestInfo)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("(Andr)新方案\n结果:");
    String str;
    if (paramABTestInfo.iErrCode == 0)
    {
      str = "成功";
      localStringBuilder2 = localStringBuilder2.append(str);
      if (paramABTestInfo.iErrCode != 0) {
        break label451;
      }
      str = "";
      label44:
      localStringBuilder2.append(str).append("\n");
      localStringBuilder2 = localStringBuilder1.append("等待:");
      if (paramABTestInfo.lUserWait >= 0L) {
        break label462;
      }
      str = "0";
      label76:
      localStringBuilder2.append(str).append("ms");
      if (paramABTestInfo.lUserWait >= 0L) {
        break label473;
      }
      localStringBuilder1.append("(").append(paramABTestInfo.lUserWait).append(")\n");
      label116:
      localStringBuilder1.append("Rollback:").append(paramABTestInfo.iRollback).append("\n");
      localStringBuilder1.append("录制时长:").append(paramABTestInfo.lRecordTime).append("ms\n");
      localStringBuilder1.append("合成指令:").append(paramABTestInfo.sMergeRequest).append("ms\n");
      localStringBuilder1.append("合成:").append("mqq_").append(paramABTestInfo.lCostMergeC).append("ms,  svr_").append(paramABTestInfo.lCostMergeS).append("ms\n");
      localStringBuilder1.append("时长:").append("mqq_").append(paramABTestInfo.lDuraMergeC).append("ms,  svr_").append(paramABTestInfo.lDuraMergeS).append("s\n");
      localStringBuilder1.append("Size:").append("mqq_").append(paramABTestInfo.lSizeMergeC / 1024L).append("KB,  svr_").append(paramABTestInfo.lSizeMergeS / 1024L).append("KB\n");
      localStringBuilder1.append("落地:").append(paramABTestInfo.lCostFront).append("ms\n");
      localStringBuilder1.append("upload:").append(paramABTestInfo.lCostUpload + "ms\n");
      int i = NetworkCenter.getInstance().getNetType();
      if (i == -1) {
        break label483;
      }
      localStringBuilder1.append("Net:").append(com.tencent.mobileqq.app.AppConstants.NET_TYPE_NAME[i]).append("\n");
    }
    for (;;)
    {
      localStringBuilder1.append("分片耗时:").append(paramABTestInfo.sliceCost).append("\n");
      localStringBuilder1.append("uniSeq:").append(paramABTestInfo.lSessionId).append("\n");
      localStringBuilder1.append("版本:").append(AppSetting.b());
      return localStringBuilder1.toString();
      str = "失败-";
      break;
      label451:
      str = String.valueOf(paramABTestInfo.iErrCode);
      break label44;
      label462:
      str = String.valueOf(paramABTestInfo.lUserWait);
      break label76;
      label473:
      localStringBuilder1.append("\n");
      break label116;
      label483:
      localStringBuilder1.append("Net:").append("None").append("\n");
    }
  }
  
  public static String dumpOldInfoString(ShortVideoUploadABTest.ABTestInfo paramABTestInfo)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("(Andr)老方案\n");
    String str;
    if (paramABTestInfo.iErrCode == 0)
    {
      str = "成功";
      localStringBuilder2 = localStringBuilder2.append(str);
      if (paramABTestInfo.iErrCode != 0) {
        break label332;
      }
      str = "";
      label45:
      localStringBuilder2.append(str).append("\n");
      localStringBuilder1.append("等待:").append(paramABTestInfo.lUserWait).append("ms\n");
      localStringBuilder1.append("时长:").append(paramABTestInfo.iDuration).append("s\n");
      localStringBuilder1.append("Size:").append(paramABTestInfo.lFileSize / 1024L).append("KB").append("\n");
      localStringBuilder1.append("AIO跳转:").append("400ms\n");
      localStringBuilder1.append("合成:").append(paramABTestInfo.lOldCostMerge).append("ms\n");
      localStringBuilder1.append("缩略图:").append(paramABTestInfo.lCostThumb).append("ms\n");
      localStringBuilder1.append("Processor:").append(paramABTestInfo.lCostUpload + "ms\n");
      localStringBuilder1.append("落地:").append(paramABTestInfo.lCostFront).append("ms\n");
      localStringBuilder1.append("MD5:").append(paramABTestInfo.md5).append("\n");
      int i = NetworkCenter.getInstance().getNetType();
      if (i == -1) {
        break label362;
      }
      localStringBuilder1.append("Net:").append(com.tencent.mobileqq.app.AppConstants.NET_TYPE_NAME[i]).append("\n");
    }
    for (;;)
    {
      localStringBuilder1.append("StepInfo:").append(paramABTestInfo.steps).append("\n");
      localStringBuilder1.append("版本:").append(AppSetting.b());
      return localStringBuilder1.toString();
      str = "失败(";
      break;
      label332:
      str = String.valueOf(paramABTestInfo.iErrCode) + ")";
      break label45;
      label362:
      localStringBuilder1.append("Net:").append("None").append("\n");
    }
  }
  
  public static boolean getABTestPreuploadSwitcher(int paramInt, String paramString)
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = sEnablePreUpload;
    if (canPerformABTest(paramInt, paramString)) {
      if (sEnablePreUpload) {
        break label62;
      }
    }
    label62:
    for (bool1 = bool3;; bool1 = false)
    {
      sEnablePreUpload = bool1;
      QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : sEnablePreUpload" + sEnablePreUpload);
      bool1 = bool2;
      return bool1;
    }
  }
  
  public static ShortVideoUploadABTest.ABTestInfo getOrCreateABTestInfo(long paramLong)
  {
    synchronized (sABLock)
    {
      ShortVideoUploadABTest.ABTestInfo localABTestInfo2 = (ShortVideoUploadABTest.ABTestInfo)sLogMarkerAB.get(Long.valueOf(paramLong));
      ShortVideoUploadABTest.ABTestInfo localABTestInfo1 = localABTestInfo2;
      if (localABTestInfo2 == null) {
        localABTestInfo1 = new ShortVideoUploadABTest.ABTestInfo();
      }
      sLogMarkerAB.put(Long.valueOf(paramLong), localABTestInfo1);
      return localABTestInfo1;
    }
  }
  
  public static boolean isEnableAbTest()
  {
    return false;
  }
  
  public static void performABTest(QQAppInterface paramQQAppInterface)
  {
    synchronized (sABLock)
    {
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      if ((sLastNew != null) && (sLastOld != null))
      {
        sLastNew.fCompCode = ((float)sLastNew.lUserWait);
        sLastOld.fCompCode = ((float)sLastOld.lUserWait);
        QLog.d("ShortVideoUploadABTest", 2, "VideoABTest :  performABTest : New :" + sLastNew.fCompCode + " Old:" + sLastOld.fCompCode);
        localStringBuilder1 = new StringBuilder("(Andr)新老对比结果:\n");
        localStringBuilder2 = localStringBuilder1.append("新方案:").append("用户等待:");
        if (sLastNew.lUserWait >= 0L) {
          break label303;
        }
      }
      label303:
      for (Object localObject1 = "0";; localObject1 = String.valueOf(sLastNew.lUserWait))
      {
        localStringBuilder2.append((String)localObject1).append("ms,时长:").append(sLastNew.iDuration).append("s").append("\n");
        localStringBuilder1.append("老方案:").append("用户等待:").append(sLastOld.lUserWait).append("ms,时长:").append(sLastOld.iDuration).append("s").append("\n");
        localStringBuilder1.append("----------\n结论:");
        if (sLastNew.fCompCode > sLastOld.fCompCode) {
          break;
        }
        localStringBuilder1.append("新方案更优");
        localObject1 = new SessionInfo();
        ((SessionInfo)localObject1).curType = sLastNew.uinType;
        ((SessionInfo)localObject1).curFriendUin = sLastNew.peerUin;
        ThreadManager.getUIHandler().postDelayed(new ShortVideoUploadABTest.1(paramQQAppInterface, (SessionInfo)localObject1, localStringBuilder1), 200L);
        sLastNew = null;
        sLastOld = null;
        return;
      }
      localStringBuilder1.append("老方案更优");
    }
  }
  
  public static void updateClickTime(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3)
  {
    synchronized (sABLock)
    {
      ShortVideoUploadABTest.ABTestInfo localABTestInfo = getOrCreateABTestInfo(paramLong1);
      if (localABTestInfo.lClickTime == 0L)
      {
        QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : uinSeq" + paramLong1 + " Show at " + SystemClock.uptimeMillis());
        localABTestInfo.lClickTime = paramLong2;
        localABTestInfo.lRecordTime = ((int)paramLong3);
        if ((localABTestInfo.lFiniTime != 0L) && (localABTestInfo.lCostMergeC != 0L)) {
          dumpABTestInfo(paramQQAppInterface, localABTestInfo);
        }
      }
      else
      {
        return;
      }
      QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : uinSeq" + paramLong1 + " Wait for : Merge_" + localABTestInfo.lCostMergeC + " Fini_" + localABTestInfo.lFiniTime);
    }
  }
  
  public static void updateCompressInfo(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString)
  {
    synchronized (sABLock)
    {
      ShortVideoUploadABTest.ABTestInfo localABTestInfo = getOrCreateABTestInfo(paramLong1);
      if (localABTestInfo.lCostMergeC == 0L)
      {
        QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : uinSeq" + paramLong1 + " updateCompressInfo : mergeCost: " + paramLong2 + " path:" + paramString);
        localABTestInfo.lCostMergeC = (paramLong2 / 1000L);
        localABTestInfo.strDstPath = paramString;
        if ((localABTestInfo.lFiniTime != 0L) && (localABTestInfo.lClickTime != 0L)) {
          dumpABTestInfo(paramQQAppInterface, localABTestInfo);
        }
      }
      else
      {
        return;
      }
      QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : uinSeq" + paramLong1 + " Wait for : Fini_" + localABTestInfo.lFiniTime + " Click_" + localABTestInfo.lClickTime);
    }
  }
  
  public static void updateTransTime(QQAppInterface paramQQAppInterface, int paramInt1, String arg2, long paramLong, int paramInt2)
  {
    if (!canPerformABTest(paramInt1, ???)) {
      return;
    }
    for (;;)
    {
      ShortVideoUploadABTest.ABTestInfo localABTestInfo;
      synchronized (sABLock)
      {
        localABTestInfo = getOrCreateABTestInfo(paramLong);
        if (localABTestInfo.lFiniTime == 0L)
        {
          QLog.d("ShortVideoUploadABTest", 2, "VideoABTest :  uinSeq" + paramLong + " FinishAt " + SystemClock.uptimeMillis());
          localABTestInfo.lFiniTime = SystemClock.uptimeMillis();
          if (paramInt2 != 3) {
            break label180;
          }
          localABTestInfo.abType = 1;
          if ((localABTestInfo.lClickTime != 0L) && (localABTestInfo.lCostMergeC != 0L)) {
            dumpABTestInfo(paramQQAppInterface, localABTestInfo);
          }
        }
        else
        {
          return;
        }
      }
      QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : uinSeq" + paramLong + " Wait for : Merge_" + localABTestInfo.lCostMergeC + " Click_" + localABTestInfo.lClickTime);
      continue;
      label180:
      localABTestInfo.abType = 0;
      if (localABTestInfo.lClickTime != 0L) {
        dumpABTestInfo(paramQQAppInterface, localABTestInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadABTest
 * JD-Core Version:    0.7.0.1
 */