package com.tencent.mobileqq.shortvideo.dancemachine;

import android.opengl.GLES20;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.Vec3f;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class BadcaseReportUtils
{
  private static final int BACKWARD_RESERVATION_NUM = 3;
  public static boolean ENABLE_REPORT = false;
  private static final int FORWARD_RESERVATION_NUM = 1;
  private static final int SAMPLE_TIME = 26;
  private static final int TOTAL_TIME = 30;
  private static Key keySpec = new SecretKeySpec(keyValue, "AES");
  private static byte[] keyValue;
  private static BadcaseReportUtils.BadDataFrame sCurrentBadCaseFrame;
  private static int sCurrentFilterKind;
  public static String sDanceFilterID;
  public static String sDanceFilterName;
  private static boolean sHaveFrameCreated;
  private static long sLastSampleSuccessTime;
  public static String sModelData = Build.MODEL;
  private static long sPlayBeginTimeStamp;
  private static BadcaseReportUtils.ReportItemData sReportCallback;
  private static int sReportNumIndex;
  public static int sTotalReportNumber;
  
  static
  {
    ENABLE_REPORT = false;
    sCurrentBadCaseFrame = null;
    sHaveFrameCreated = false;
    sTotalReportNumber = 3;
    sReportNumIndex = 0;
    sLastSampleSuccessTime = 0L;
    sPlayBeginTimeStamp = 0L;
    sCurrentFilterKind = 0;
    keyValue = new byte[] { 22, -35, -45, 25, 98, -55, -45, 10, 35, -45, 25, 26, -95, 25, -35, 48 };
  }
  
  public static void collectionBadCaseDetectCost(long paramLong)
  {
    if (sHaveFrameCreated) {
      sCurrentBadCaseFrame.timeCost = paramLong;
    }
    DanceLog.print("BadcaseReportUtils ", "collectionBadCaseDetectCost sHaveFrameCreated=" + sHaveFrameCreated + " detectCost=" + paramLong);
  }
  
  public static void convertDataFormat(BadcaseReportUtils.BadDataFrame paramBadDataFrame)
  {
    Object localObject1 = new BadcaseReportUtils.BadCaseWriter(paramBadDataFrame.convertedPath);
    Object localObject2 = "" + paramBadDataFrame.problemType;
    int i = ((String)localObject2).length();
    if (i > 0)
    {
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeCString("Problem");
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeBigInt(i + 1);
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeCString((String)localObject2);
    }
    ((BadcaseReportUtils.BadCaseWriter)localObject1).writeCString("Picture");
    ((BadcaseReportUtils.BadCaseWriter)localObject1).writeFile(paramBadDataFrame.picturePath);
    i = sModelData.length();
    if (i > 0)
    {
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeCString("Model");
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeBigInt(i + 1);
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeCString(sModelData);
    }
    localObject2 = "" + paramBadDataFrame.detectPointData;
    i = ((String)localObject2).length();
    if (i > 0)
    {
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeCString("Point");
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeBigInt(i + 1);
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeCString((String)localObject2);
    }
    localObject2 = "" + paramBadDataFrame.timeCost;
    i = ((String)localObject2).length();
    if (i > 0)
    {
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeCString("DetectCost");
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeBigInt(i + 1);
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeCString((String)localObject2);
    }
    localObject2 = "" + sDanceFilterID;
    i = ((String)localObject2).length();
    if (i > 0)
    {
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeCString("FilterID");
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeBigInt(i + 1);
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeCString((String)localObject2);
    }
    localObject2 = "" + sDanceFilterName;
    i = ((String)localObject2).length();
    if (i > 0)
    {
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeCString("FilterName");
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeBigInt(i + 1);
      ((BadcaseReportUtils.BadCaseWriter)localObject1).writeCString((String)localObject2);
    }
    localObject2 = new StringBuilder();
    i = 0;
    BadcaseReportUtils.BadDataItem localBadDataItem;
    while (i < paramBadDataFrame.currentModelCache.size())
    {
      localBadDataItem = (BadcaseReportUtils.BadDataItem)paramBadDataFrame.currentModelCache.get(i);
      ((StringBuilder)localObject2).append(localBadDataItem.boyID);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(localBadDataItem.mIndex);
      ((StringBuilder)localObject2).append(",");
      i += 1;
    }
    i = 0;
    while (i < paramBadDataFrame.currentMatchCache.size())
    {
      localBadDataItem = (BadcaseReportUtils.BadDataItem)paramBadDataFrame.currentMatchCache.get(i);
      ((StringBuilder)localObject2).append(localBadDataItem.boyID);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(localBadDataItem.mIndex);
      ((StringBuilder)localObject2).append(",");
      i += 1;
    }
    if (((StringBuilder)localObject2).length() > 0)
    {
      localObject2 = ((StringBuilder)localObject2).substring(0, ((StringBuilder)localObject2).length() - 1);
      if (((String)localObject2).length() > 0)
      {
        ((BadcaseReportUtils.BadCaseWriter)localObject1).writeCString("boyId");
        ((BadcaseReportUtils.BadCaseWriter)localObject1).writeBigInt(((String)localObject2).length() + 1);
        ((BadcaseReportUtils.BadCaseWriter)localObject1).writeCString((String)localObject2);
      }
    }
    ((BadcaseReportUtils.BadCaseWriter)localObject1).flush();
    paramBadDataFrame.mDataSuccess = ((BadcaseReportUtils.BadCaseWriter)localObject1).mWriteOK;
    ((BadcaseReportUtils.BadCaseWriter)localObject1).release();
    deleteFile(paramBadDataFrame.picturePath);
    if (paramBadDataFrame.mDataSuccess)
    {
      paramBadDataFrame.encPath = (paramBadDataFrame.convertedPath + "_enc");
      localObject1 = new File(paramBadDataFrame.encPath);
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      try
      {
        ((File)localObject1).createNewFile();
        paramBadDataFrame.mEncSuccess = cryptFile(paramBadDataFrame.convertedPath, paramBadDataFrame.encPath);
        DanceLog.print("BadcaseReportUtils ", "cryptFile mEncSuccess=" + paramBadDataFrame.mEncSuccess);
        deleteFile(paramBadDataFrame.convertedPath);
        if (!paramBadDataFrame.mEncSuccess)
        {
          deleteFile(paramBadDataFrame.encPath);
          return;
        }
        paramBadDataFrame.zipPath = (paramBadDataFrame.encPath + ".zip");
        boolean bool = zipFiles(paramBadDataFrame.encPath, paramBadDataFrame.zipPath);
        deleteFile(paramBadDataFrame.encPath);
        DanceLog.print("BadcaseReportUtils ", "convertDataFormat zipSuccess=" + bool);
        paramBadDataFrame.mZipSuccess = bool;
        if (paramBadDataFrame.mZipSuccess) {
          return;
        }
        deleteFile(paramBadDataFrame.zipPath);
        return;
      }
      catch (Exception paramBadDataFrame) {}
    }
    else
    {
      deleteFile(paramBadDataFrame.convertedPath);
    }
  }
  
  public static void crypt(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt, Key paramKey)
  {
    Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    localCipher.init(paramInt, paramKey);
    int k = localCipher.getBlockSize();
    paramInt = localCipher.getOutputSize(k);
    paramKey = new byte[k];
    byte[] arrayOfByte = new byte[paramInt];
    int i = 1;
    paramInt = 0;
    while (i != 0)
    {
      int j = paramInputStream.read(paramKey);
      if (j == k)
      {
        int m = localCipher.update(paramKey, 0, k, arrayOfByte);
        paramInt = j;
        if (paramOutputStream != null)
        {
          paramOutputStream.write(arrayOfByte, 0, m);
          paramInt = j;
        }
      }
      else
      {
        i = 0;
        paramInt = j;
      }
    }
    if (paramInt > 0) {}
    for (paramInputStream = localCipher.doFinal(paramKey, 0, paramInt);; paramInputStream = localCipher.doFinal())
    {
      if (paramOutputStream != null)
      {
        paramOutputStream.write(paramInputStream);
        paramOutputStream.flush();
      }
      return;
    }
  }
  
  /* Error */
  private static boolean cryptFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 319	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: new 322	java/io/FileOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 323	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_0
    //   24: aload_1
    //   25: getstatic 82	com/tencent/mobileqq/shortvideo/dancemachine/BadcaseReportUtils:keySpec	Ljava/security/Key;
    //   28: invokestatic 327	com/tencent/mobileqq/shortvideo/dancemachine/BadcaseReportUtils:encrypt	(Ljava/io/InputStream;Ljava/io/OutputStream;Ljava/security/Key;)Z
    //   31: istore_2
    //   32: aload_0
    //   33: ifnull +7 -> 40
    //   36: aload_0
    //   37: invokevirtual 330	java/io/FileInputStream:close	()V
    //   40: aload_1
    //   41: ifnull +7 -> 48
    //   44: aload_1
    //   45: invokevirtual 331	java/io/FileOutputStream:close	()V
    //   48: iload_2
    //   49: ireturn
    //   50: astore_0
    //   51: aconst_null
    //   52: astore_1
    //   53: ldc 94
    //   55: ldc_w 333
    //   58: aload_0
    //   59: invokestatic 336	com/tencent/mobileqq/shortvideo/dancemachine/utils/DanceLog:print	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   62: aload_3
    //   63: ifnull +7 -> 70
    //   66: aload_3
    //   67: invokevirtual 330	java/io/FileInputStream:close	()V
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 331	java/io/FileOutputStream:close	()V
    //   78: iconst_0
    //   79: ireturn
    //   80: astore_0
    //   81: aconst_null
    //   82: astore_1
    //   83: aload 4
    //   85: astore_3
    //   86: aload_3
    //   87: ifnull +7 -> 94
    //   90: aload_3
    //   91: invokevirtual 330	java/io/FileInputStream:close	()V
    //   94: aload_1
    //   95: ifnull +7 -> 102
    //   98: aload_1
    //   99: invokevirtual 331	java/io/FileOutputStream:close	()V
    //   102: aload_0
    //   103: athrow
    //   104: astore_0
    //   105: goto -65 -> 40
    //   108: astore_0
    //   109: iload_2
    //   110: ireturn
    //   111: astore_0
    //   112: goto -42 -> 70
    //   115: astore_0
    //   116: goto -38 -> 78
    //   119: astore_3
    //   120: goto -26 -> 94
    //   123: astore_1
    //   124: goto -22 -> 102
    //   127: astore 4
    //   129: aconst_null
    //   130: astore_1
    //   131: aload_0
    //   132: astore_3
    //   133: aload 4
    //   135: astore_0
    //   136: goto -50 -> 86
    //   139: astore 4
    //   141: aload_0
    //   142: astore_3
    //   143: aload 4
    //   145: astore_0
    //   146: goto -60 -> 86
    //   149: astore_0
    //   150: goto -64 -> 86
    //   153: astore 4
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_0
    //   158: astore_3
    //   159: aload 4
    //   161: astore_0
    //   162: goto -109 -> 53
    //   165: astore 4
    //   167: aload_0
    //   168: astore_3
    //   169: aload 4
    //   171: astore_0
    //   172: goto -119 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramString1	String
    //   0	175	1	paramString2	String
    //   31	79	2	bool	boolean
    //   4	87	3	localObject1	Object
    //   119	1	3	localException1	Exception
    //   132	37	3	str	String
    //   1	83	4	localObject2	Object
    //   127	7	4	localObject3	Object
    //   139	5	4	localObject4	Object
    //   153	7	4	localException2	Exception
    //   165	5	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   5	14	50	java/lang/Exception
    //   5	14	80	finally
    //   36	40	104	java/lang/Exception
    //   44	48	108	java/lang/Exception
    //   66	70	111	java/lang/Exception
    //   74	78	115	java/lang/Exception
    //   90	94	119	java/lang/Exception
    //   98	102	123	java/lang/Exception
    //   14	23	127	finally
    //   23	32	139	finally
    //   53	62	149	finally
    //   14	23	153	java/lang/Exception
    //   23	32	165	java/lang/Exception
  }
  
  public static boolean decrypt(InputStream paramInputStream, OutputStream paramOutputStream, Key paramKey)
  {
    try
    {
      crypt(paramInputStream, paramOutputStream, 2, paramKey);
      return true;
    }
    catch (Exception paramInputStream)
    {
      DanceLog.print("BadcaseReportUtils ", "decrypt false", paramInputStream);
    }
    return false;
  }
  
  private static void deleteFile(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  public static boolean encrypt(InputStream paramInputStream, OutputStream paramOutputStream, Key paramKey)
  {
    try
    {
      crypt(paramInputStream, paramOutputStream, 1, paramKey);
      return true;
    }
    catch (Exception paramInputStream)
    {
      DanceLog.print("BadcaseReportUtils ", "encrypt false", paramInputStream);
    }
    return false;
  }
  
  public static void finishCurrentFrame(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat)
  {
    if (sHaveFrameCreated)
    {
      boolean bool = needDoReport();
      DanceLog.print("BadcaseReportUtils ", "finishCurrentFrame report=" + bool);
      if (bool)
      {
        sCurrentBadCaseFrame.pictureBuffer = readTextureToByteBuffer(paramInt1, paramInt2, paramInt3);
        sCurrentBadCaseFrame.width = paramInt2;
        sCurrentBadCaseFrame.height = paramInt3;
        poseDataSting(paramArrayOfFloat);
        reportCurrentFrame();
        sReportNumIndex -= 1;
        sLastSampleSuccessTime = SystemClock.uptimeMillis();
      }
    }
    DanceLog.print("BadcaseReportUtils ", "finishCurrentFrame sHaveFrameCreated=" + sHaveFrameCreated);
    releaseCurrentFrame();
  }
  
  public static void initCurrentFrame()
  {
    if (!sHaveFrameCreated)
    {
      sCurrentBadCaseFrame = new BadcaseReportUtils.BadDataFrame();
      sHaveFrameCreated = true;
      DanceLog.print("BadcaseReportUtils ", "initCurrentFrame sHaveFrameCreated=true");
    }
  }
  
  private static void maxBadCaseJudge() {}
  
  private static boolean needDoReport()
  {
    int i = sCurrentBadCaseFrame.currentModelCache.size();
    int j = sCurrentBadCaseFrame.currentMatchCache.size();
    int k = sCurrentBadCaseFrame.currentUserCache.size();
    DanceLog.print("BadcaseReportUtils ", "finishCurrentFrame needDoReport  modelCaseProblem=" + i + " matchCaseProblem=" + j + " userCaseProblem=" + k);
    if ((i > 0) || (j > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      DanceLog.print("BadcaseReportUtils ", "finishCurrentFrame needDoReport  haveBadCase=" + bool);
      if (bool)
      {
        if (i / (j + i) <= 1.6F) {
          break;
        }
        sCurrentBadCaseFrame.problemType = 2;
      }
      return bool;
    }
    sCurrentBadCaseFrame.problemType = 3;
    return bool;
  }
  
  public static boolean needDoSample()
  {
    if ((ENABLE_REPORT) && (sCurrentFilterKind == 1))
    {
      long l = SystemClock.uptimeMillis() - sPlayBeginTimeStamp;
      DanceLog.print("BadcaseReportUtils ", "needDoSample diffTotalTime=" + l + " sReportNumIndex=" + sReportNumIndex);
      if ((l > 1000L) && (l < 27000L) && (sReportNumIndex > 0)) {
        return sampleStrategy();
      }
    }
    return false;
  }
  
  private static void poseDataSting(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
    {
      DanceLog.print("BadcaseReportUtils ", "finishCurrentFrame poseData= null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      localStringBuilder.append(paramArrayOfFloat[i]);
      localStringBuilder.append(",");
      i += 1;
    }
    sCurrentBadCaseFrame.detectPointData = localStringBuilder.substring(0, localStringBuilder.length() - 1);
  }
  
  public static void problemClassification(List<Vec3f> paramList, ResourceManager.Posture paramPosture, int paramInt)
  {
    if (paramPosture == null) {}
    while (!sHaveFrameCreated) {
      return;
    }
    if ((((Vec3f)paramList.get(2)).z == 0.0F) && (((Vec3f)paramList.get(3)).z == 0.0F) && (((Vec3f)paramList.get(4)).z == 0.0F) && (((Vec3f)paramList.get(5)).z == 0.0F) && (((Vec3f)paramList.get(6)).z == 0.0F) && (((Vec3f)paramList.get(7)).z == 0.0F))
    {
      sCurrentBadCaseFrame.currentUserCache.add(new BadcaseReportUtils.BadDataItem(1, paramPosture.id, paramInt));
      DanceLog.print("BadcaseReportUtils ", "problemClassification USER_PROBLEM");
      return;
    }
    Iterator localIterator = paramPosture.gestureConfigs.iterator();
    label164:
    while (localIterator.hasNext())
    {
      Object localObject = ((MatchTemplateConfig)localIterator.next()).keyPoints;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MatchTemplateConfig.KeyPoint localKeyPoint = (MatchTemplateConfig.KeyPoint)((Iterator)localObject).next();
          if (((Vec3f)paramList.get(localKeyPoint.index)).z == 0.0F) {
            DanceLog.print("BadcaseReportUtils ", "problemClassification point.index=" + localKeyPoint.index);
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        sCurrentBadCaseFrame.currentMatchCache.add(new BadcaseReportUtils.BadDataItem(3, paramPosture.id, paramInt));
        DanceLog.print("BadcaseReportUtils ", "problemClassification MATCH_PROBLEM");
        break label164;
      }
      sCurrentBadCaseFrame.currentModelCache.add(new BadcaseReportUtils.BadDataItem(2, paramPosture.id, paramInt));
      DanceLog.print("BadcaseReportUtils ", "problemClassification MODEL_PROBLEM");
      maxBadCaseJudge();
      break label164;
      break;
    }
  }
  
  private static ByteBuffer readTextureToByteBuffer(int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt1 = new int[1];
    int[] arrayOfInt2 = new int[1];
    GLES20.glGetIntegerv(36006, arrayOfInt2, 0);
    GLES20.glGenFramebuffers(1, arrayOfInt1, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt1[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt2 * paramInt3 * 4);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, localByteBuffer);
    GLES20.glFinish();
    GLES20.glBindFramebuffer(36160, arrayOfInt2[0]);
    GLES20.glDeleteFramebuffers(1, arrayOfInt1, 0);
    return localByteBuffer;
  }
  
  public static void registerReport(BadcaseReportUtils.ReportItemData paramReportItemData)
  {
    sReportCallback = paramReportItemData;
  }
  
  public static void releaseCurrentFrame()
  {
    if (sHaveFrameCreated)
    {
      sCurrentBadCaseFrame = null;
      sHaveFrameCreated = false;
      DanceLog.print("BadcaseReportUtils ", "releaseCurrentFrame sHaveFrameCreated=false");
    }
  }
  
  private static void reportCurrentFrame()
  {
    DanceLog.print("BadcaseReportUtils ", "reportCurrentFrame...");
    if (sReportCallback != null) {
      sReportCallback.itemOK(sCurrentBadCaseFrame);
    }
  }
  
  public static void resetSamplingParam()
  {
    sCurrentFilterKind = 0;
    sPlayBeginTimeStamp = 0L;
    sLastSampleSuccessTime = 0L;
    sReportNumIndex = 0;
    DanceLog.print("BadcaseReportUtils ", "resetSamplingParam...");
  }
  
  private static boolean sampleStrategy()
  {
    if (sLastSampleSuccessTime == 0L) {
      DanceLog.print("BadcaseReportUtils ", "sampleStrategy sLastSampleSuccessTime=0");
    }
    long l1;
    long l2;
    do
    {
      return true;
      l1 = (26000.0F / sTotalReportNumber / 2.0F);
      l2 = SystemClock.uptimeMillis() - sLastSampleSuccessTime;
      DanceLog.print("BadcaseReportUtils ", "sampleStrategy timeDiff=" + l2 + " sampleInterval=" + l1);
    } while (l2 > l1);
    return false;
  }
  
  public static void setCurrentRenderFilterKind(int paramInt)
  {
    if ((sCurrentFilterKind == 0) && (paramInt == 1))
    {
      sPlayBeginTimeStamp = SystemClock.uptimeMillis();
      sReportNumIndex = sTotalReportNumber;
      sLastSampleSuccessTime = 0L;
      DanceLog.print("BadcaseReportUtils ", "setCurrentRenderFilterKind enter Play...");
    }
    sCurrentFilterKind = paramInt;
  }
  
  /* Error */
  public static boolean zipFiles(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 322	java/io/FileOutputStream
    //   6: dup
    //   7: new 236	java/io/File
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: invokespecial 545	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   18: astore_1
    //   19: new 547	java/io/BufferedOutputStream
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 550	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore 6
    //   29: new 552	java/util/zip/ZipOutputStream
    //   32: dup
    //   33: aload 6
    //   35: invokespecial 553	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   38: astore 7
    //   40: new 236	java/io/File
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 237	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual 241	java/io/File:exists	()Z
    //   53: ifeq +369 -> 422
    //   56: aload 7
    //   58: new 555	java/util/zip/ZipEntry
    //   61: dup
    //   62: aload_0
    //   63: invokevirtual 558	java/io/File:getName	()Ljava/lang/String;
    //   66: invokespecial 559	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   69: invokevirtual 563	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   72: aload 7
    //   74: bipush 9
    //   76: invokevirtual 566	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   79: new 319	java/io/FileInputStream
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 567	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   87: astore 8
    //   89: sipush 8192
    //   92: newarray byte
    //   94: astore_0
    //   95: aload 8
    //   97: aload_0
    //   98: iconst_0
    //   99: sipush 8192
    //   102: invokevirtual 570	java/io/FileInputStream:read	([BII)I
    //   105: istore_2
    //   106: iload_2
    //   107: iconst_m1
    //   108: if_icmpeq +87 -> 195
    //   111: aload 7
    //   113: aload_0
    //   114: iconst_0
    //   115: iload_2
    //   116: invokevirtual 571	java/util/zip/ZipOutputStream:write	([BII)V
    //   119: goto -24 -> 95
    //   122: astore_0
    //   123: aload 8
    //   125: ifnull +8 -> 133
    //   128: aload 8
    //   130: invokevirtual 330	java/io/FileInputStream:close	()V
    //   133: aload 7
    //   135: ifnull +13 -> 148
    //   138: aload 7
    //   140: invokevirtual 572	java/util/zip/ZipOutputStream:flush	()V
    //   143: aload 7
    //   145: invokevirtual 575	java/util/zip/ZipOutputStream:closeEntry	()V
    //   148: aload_0
    //   149: athrow
    //   150: astore_0
    //   151: aload 6
    //   153: astore_0
    //   154: iconst_0
    //   155: istore_3
    //   156: aload 7
    //   158: astore 6
    //   160: aload 6
    //   162: ifnull +8 -> 170
    //   165: aload 6
    //   167: invokevirtual 576	java/util/zip/ZipOutputStream:close	()V
    //   170: aload_0
    //   171: ifnull +7 -> 178
    //   174: aload_0
    //   175: invokevirtual 577	java/io/BufferedOutputStream:close	()V
    //   178: iload_3
    //   179: istore 4
    //   181: aload_1
    //   182: ifnull +10 -> 192
    //   185: aload_1
    //   186: invokevirtual 331	java/io/FileOutputStream:close	()V
    //   189: iload_3
    //   190: istore 4
    //   192: iload 4
    //   194: ireturn
    //   195: iconst_1
    //   196: istore 5
    //   198: iconst_1
    //   199: istore 4
    //   201: aload 8
    //   203: ifnull +8 -> 211
    //   206: aload 8
    //   208: invokevirtual 330	java/io/FileInputStream:close	()V
    //   211: iload 5
    //   213: istore_3
    //   214: aload 7
    //   216: ifnull +16 -> 232
    //   219: aload 7
    //   221: invokevirtual 572	java/util/zip/ZipOutputStream:flush	()V
    //   224: aload 7
    //   226: invokevirtual 575	java/util/zip/ZipOutputStream:closeEntry	()V
    //   229: iload 5
    //   231: istore_3
    //   232: aload 7
    //   234: ifnull +8 -> 242
    //   237: aload 7
    //   239: invokevirtual 576	java/util/zip/ZipOutputStream:close	()V
    //   242: aload 6
    //   244: ifnull +8 -> 252
    //   247: aload 6
    //   249: invokevirtual 577	java/io/BufferedOutputStream:close	()V
    //   252: iload_3
    //   253: istore 4
    //   255: aload_1
    //   256: ifnull -64 -> 192
    //   259: aload_1
    //   260: invokevirtual 331	java/io/FileOutputStream:close	()V
    //   263: iload_3
    //   264: ireturn
    //   265: astore_0
    //   266: iload_3
    //   267: ireturn
    //   268: astore_0
    //   269: aconst_null
    //   270: astore 7
    //   272: aconst_null
    //   273: astore 6
    //   275: aconst_null
    //   276: astore_1
    //   277: aload 7
    //   279: ifnull +8 -> 287
    //   282: aload 7
    //   284: invokevirtual 576	java/util/zip/ZipOutputStream:close	()V
    //   287: aload 6
    //   289: ifnull +8 -> 297
    //   292: aload 6
    //   294: invokevirtual 577	java/io/BufferedOutputStream:close	()V
    //   297: aload_1
    //   298: ifnull +7 -> 305
    //   301: aload_1
    //   302: invokevirtual 331	java/io/FileOutputStream:close	()V
    //   305: aload_0
    //   306: athrow
    //   307: astore_0
    //   308: goto -66 -> 242
    //   311: astore_0
    //   312: goto -60 -> 252
    //   315: astore 6
    //   317: goto -147 -> 170
    //   320: astore_0
    //   321: goto -143 -> 178
    //   324: astore_0
    //   325: iload_3
    //   326: ireturn
    //   327: astore 7
    //   329: goto -42 -> 287
    //   332: astore 6
    //   334: goto -37 -> 297
    //   337: astore_1
    //   338: goto -33 -> 305
    //   341: astore_0
    //   342: aconst_null
    //   343: astore 7
    //   345: aconst_null
    //   346: astore 6
    //   348: goto -71 -> 277
    //   351: astore_0
    //   352: aconst_null
    //   353: astore 7
    //   355: goto -78 -> 277
    //   358: astore_0
    //   359: goto -82 -> 277
    //   362: astore_0
    //   363: aconst_null
    //   364: astore_0
    //   365: aconst_null
    //   366: astore_1
    //   367: iconst_0
    //   368: istore_3
    //   369: aload 8
    //   371: astore 6
    //   373: goto -213 -> 160
    //   376: astore_0
    //   377: aconst_null
    //   378: astore_0
    //   379: iconst_0
    //   380: istore_3
    //   381: aload 8
    //   383: astore 6
    //   385: goto -225 -> 160
    //   388: astore_0
    //   389: aload 6
    //   391: astore_0
    //   392: iconst_0
    //   393: istore_3
    //   394: aload 8
    //   396: astore 6
    //   398: goto -238 -> 160
    //   401: astore_0
    //   402: aload 6
    //   404: astore_0
    //   405: iload 4
    //   407: istore_3
    //   408: aload 7
    //   410: astore 6
    //   412: goto -252 -> 160
    //   415: astore_0
    //   416: aconst_null
    //   417: astore 8
    //   419: goto -296 -> 123
    //   422: iconst_0
    //   423: istore_3
    //   424: goto -192 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	paramString1	String
    //   0	427	1	paramString2	String
    //   105	11	2	i	int
    //   155	269	3	bool1	boolean
    //   179	227	4	bool2	boolean
    //   196	34	5	bool3	boolean
    //   27	266	6	localObject1	Object
    //   315	1	6	localIOException1	java.io.IOException
    //   332	1	6	localIOException2	java.io.IOException
    //   346	65	6	localObject2	Object
    //   38	245	7	localZipOutputStream	java.util.zip.ZipOutputStream
    //   327	1	7	localIOException3	java.io.IOException
    //   343	66	7	localObject3	Object
    //   1	417	8	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   89	95	122	finally
    //   95	106	122	finally
    //   111	119	122	finally
    //   40	79	150	java/lang/Exception
    //   128	133	150	java/lang/Exception
    //   138	148	150	java/lang/Exception
    //   148	150	150	java/lang/Exception
    //   259	263	265	java/io/IOException
    //   3	19	268	finally
    //   237	242	307	java/io/IOException
    //   247	252	311	java/io/IOException
    //   165	170	315	java/io/IOException
    //   174	178	320	java/io/IOException
    //   185	189	324	java/io/IOException
    //   282	287	327	java/io/IOException
    //   292	297	332	java/io/IOException
    //   301	305	337	java/io/IOException
    //   19	29	341	finally
    //   29	40	351	finally
    //   40	79	358	finally
    //   128	133	358	finally
    //   138	148	358	finally
    //   148	150	358	finally
    //   206	211	358	finally
    //   219	229	358	finally
    //   3	19	362	java/lang/Exception
    //   19	29	376	java/lang/Exception
    //   29	40	388	java/lang/Exception
    //   206	211	401	java/lang/Exception
    //   219	229	401	java/lang/Exception
    //   79	89	415	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils
 * JD-Core Version:    0.7.0.1
 */