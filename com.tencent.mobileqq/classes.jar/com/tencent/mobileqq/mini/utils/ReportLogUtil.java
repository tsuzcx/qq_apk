package com.tencent.mobileqq.mini.utils;

import bhpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.mini.appbrand.utils.MiniLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class ReportLogUtil
{
  private static final String TAG = "ReportLogUtil";
  private static SimpleDateFormat timeFormatter = new SimpleDateFormat("yy-MM-dd HH_mm_ss");
  
  public static void compressAndUploadLog(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new ReportLogUtil.2(MiniLog.getMiniLogFolderPath(paramString), paramString));
  }
  
  public static void uploadLog(String paramString, ReportLogUtil.UploadLogListener paramUploadLogListener)
  {
    if (!new File(paramString).exists()) {
      QLog.d("ReportLogUtil", 2, "file not exist. ");
    }
    TransferRequest localTransferRequest;
    do
    {
      return;
      localTransferRequest = new TransferRequest();
      localTransferRequest.mIsUp = true;
      localTransferRequest.mLocalPath = paramString;
      localTransferRequest.mCommandId = 65;
      localTransferRequest.mUniseq = ((Math.random() * 1000000.0D));
      localTransferRequest.mPeerUin = "0";
      localTransferRequest.mSelfUin = String.valueOf(bhpc.a().a());
      localTransferRequest.mFileType = 24;
      localTransferRequest.mRichTag = "miniAppUserLog";
      paramString = new Bdh_extinfo.CommFileExtReq();
      paramString.uint32_action_type.set(0);
      paramString.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString() + ".zip"));
      localTransferRequest.mExtentionInfo = paramString.toByteArray();
      paramString = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(paramString instanceof QQAppInterface));
    paramString = (QQAppInterface)paramString;
    paramUploadLogListener = new ReportLogUtil.MiniAppTransHandler(ThreadManagerV2.getFileThreadLooper(), paramUploadLogListener);
    paramUploadLogListener.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    paramString.getTransFileController().addHandle(paramUploadLogListener);
    paramString.getTransFileController().transferAsync(localTransferRequest);
  }
  
  public static void uploadLogAndReport(String paramString1, String paramString2)
  {
    File localFile = new File(paramString2);
    if (!localFile.exists())
    {
      QLog.e("ReportLogUtil", 1, "log not exist.");
      return;
    }
    long l = localFile.length();
    if (l <= 0L)
    {
      QLog.e("ReportLogUtil", 1, "log file size error: " + l);
      return;
    }
    uploadLog(paramString2, new ReportLogUtil.1(paramString2, paramString1, l));
  }
  
  /* Error */
  public static void zipFiles(java.util.ArrayList<com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.LogFile> paramArrayList, String paramString)
  {
    // Byte code:
    //   0: new 253	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 255	java/io/FileOutputStream
    //   7: dup
    //   8: new 55	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 258	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: invokespecial 261	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_1
    //   23: new 263	java/util/zip/ZipOutputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 264	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore 11
    //   33: iconst_0
    //   34: istore_2
    //   35: aload_0
    //   36: invokevirtual 270	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   39: astore_0
    //   40: aload_0
    //   41: invokeinterface 275 1 0
    //   46: ifeq +255 -> 301
    //   49: aload_0
    //   50: invokeinterface 279 1 0
    //   55: checkcast 281	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile
    //   58: astore 12
    //   60: aload 12
    //   62: invokevirtual 282	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:exists	()Z
    //   65: ifeq +312 -> 377
    //   68: aload 11
    //   70: new 284	java/util/zip/ZipEntry
    //   73: dup
    //   74: new 144	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   81: aload 12
    //   83: invokevirtual 287	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:getName	()Ljava/lang/String;
    //   86: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 12
    //   91: getfield 290	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:stuffix	Ljava/lang/String;
    //   94: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokespecial 291	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   103: invokevirtual 295	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   106: aload 11
    //   108: bipush 9
    //   110: invokevirtual 298	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   113: aload 12
    //   115: invokevirtual 299	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:length	()J
    //   118: lstore 9
    //   120: new 301	java/io/FileInputStream
    //   123: dup
    //   124: aload 12
    //   126: invokespecial 302	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   129: astore 12
    //   131: sipush 20480
    //   134: newarray byte
    //   136: astore 13
    //   138: lconst_0
    //   139: lstore 5
    //   141: aload 12
    //   143: aload 13
    //   145: iconst_0
    //   146: sipush 20480
    //   149: invokevirtual 306	java/io/FileInputStream:read	([BII)I
    //   152: istore 4
    //   154: iload 4
    //   156: iconst_m1
    //   157: if_icmpeq +39 -> 196
    //   160: aload 11
    //   162: aload 13
    //   164: iconst_0
    //   165: iload 4
    //   167: invokevirtual 310	java/util/zip/ZipOutputStream:write	([BII)V
    //   170: iconst_1
    //   171: istore_3
    //   172: iconst_1
    //   173: istore_2
    //   174: lload 5
    //   176: iload 4
    //   178: i2l
    //   179: ladd
    //   180: lstore 7
    //   182: lload 7
    //   184: lstore 5
    //   186: lload 7
    //   188: lload 9
    //   190: lcmp
    //   191: iflt -50 -> 141
    //   194: iload_3
    //   195: istore_2
    //   196: aload 12
    //   198: invokevirtual 313	java/io/FileInputStream:close	()V
    //   201: aload 11
    //   203: invokevirtual 316	java/util/zip/ZipOutputStream:flush	()V
    //   206: aload 11
    //   208: invokevirtual 319	java/util/zip/ZipOutputStream:closeEntry	()V
    //   211: goto +166 -> 377
    //   214: astore_0
    //   215: aload 12
    //   217: invokevirtual 313	java/io/FileInputStream:close	()V
    //   220: aload 11
    //   222: invokevirtual 316	java/util/zip/ZipOutputStream:flush	()V
    //   225: aload 11
    //   227: invokevirtual 319	java/util/zip/ZipOutputStream:closeEntry	()V
    //   230: aload_0
    //   231: athrow
    //   232: astore_0
    //   233: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq +30 -> 266
    //   239: ldc 8
    //   241: iconst_2
    //   242: new 144	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   249: ldc_w 324
    //   252: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_0
    //   256: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: aload_0
    //   263: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   266: aload_1
    //   267: invokevirtual 332	java/io/BufferedOutputStream:close	()V
    //   270: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +12 -> 285
    //   276: ldc 8
    //   278: iconst_2
    //   279: ldc_w 334
    //   282: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +12 -> 300
    //   291: ldc 8
    //   293: iconst_2
    //   294: ldc_w 336
    //   297: invokestatic 338	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: return
    //   301: iload_2
    //   302: ifeq +8 -> 310
    //   305: aload 11
    //   307: invokevirtual 339	java/util/zip/ZipOutputStream:close	()V
    //   310: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq +12 -> 325
    //   316: ldc 8
    //   318: iconst_2
    //   319: ldc_w 341
    //   322: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   325: aload_1
    //   326: invokevirtual 332	java/io/BufferedOutputStream:close	()V
    //   329: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq -47 -> 285
    //   335: ldc 8
    //   337: iconst_2
    //   338: ldc_w 334
    //   341: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: goto -59 -> 285
    //   347: astore_0
    //   348: aload_0
    //   349: invokevirtual 344	java/io/IOException:printStackTrace	()V
    //   352: goto -67 -> 285
    //   355: astore_0
    //   356: aload_1
    //   357: invokevirtual 332	java/io/BufferedOutputStream:close	()V
    //   360: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +12 -> 375
    //   366: ldc 8
    //   368: iconst_2
    //   369: ldc_w 334
    //   372: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: aload_0
    //   376: athrow
    //   377: goto -337 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramArrayList	java.util.ArrayList<com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.LogFile>
    //   0	380	1	paramString	String
    //   34	268	2	i	int
    //   171	24	3	j	int
    //   152	25	4	k	int
    //   139	46	5	l1	long
    //   180	7	7	l2	long
    //   118	71	9	l3	long
    //   31	275	11	localZipOutputStream	java.util.zip.ZipOutputStream
    //   58	158	12	localObject	Object
    //   136	27	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   131	138	214	finally
    //   141	154	214	finally
    //   160	170	214	finally
    //   35	40	232	java/io/IOException
    //   40	131	232	java/io/IOException
    //   196	211	232	java/io/IOException
    //   215	232	232	java/io/IOException
    //   305	310	232	java/io/IOException
    //   310	325	232	java/io/IOException
    //   0	33	347	java/io/IOException
    //   266	285	347	java/io/IOException
    //   325	344	347	java/io/IOException
    //   356	375	347	java/io/IOException
    //   375	377	347	java/io/IOException
    //   35	40	355	finally
    //   40	131	355	finally
    //   196	211	355	finally
    //   215	232	355	finally
    //   233	266	355	finally
    //   305	310	355	finally
    //   310	325	355	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.ReportLogUtil
 * JD-Core Version:    0.7.0.1
 */