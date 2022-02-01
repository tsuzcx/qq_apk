package com.tencent.mobileqq.mini.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.mini.appbrand.utils.MiniLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.adapter.CommonDataAdapter;
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
    if (StringUtil.a(paramString)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new ReportLogUtil.2(MiniLog.getMiniLogFolderPath(paramString), paramString));
  }
  
  public static void uploadLog(String paramString, ReportLogUtil.UploadLogListener paramUploadLogListener)
  {
    if (!new File(paramString).exists())
    {
      QLog.d("ReportLogUtil", 2, "file not exist. ");
      return;
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mCommandId = 65;
    localTransferRequest.mUniseq = ((Math.random() * 1000000.0D));
    localTransferRequest.mPeerUin = "0";
    localTransferRequest.mSelfUin = String.valueOf(CommonDataAdapter.a().a());
    localTransferRequest.mFileType = 24;
    localTransferRequest.mRichTag = "miniAppUserLog";
    paramString = new Bdh_extinfo.CommFileExtReq();
    paramString.uint32_action_type.set(0);
    PBBytesField localPBBytesField = paramString.bytes_uuid;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UUID.randomUUID().toString());
    localStringBuilder.append(".zip");
    localPBBytesField.set(ByteStringMicro.copyFromUtf8(localStringBuilder.toString()));
    localTransferRequest.mExtentionInfo = paramString.toByteArray();
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString instanceof QQAppInterface))
    {
      paramString = (QQAppInterface)paramString;
      paramUploadLogListener = new ReportLogUtil.MiniAppTransHandler(ThreadManagerV2.getFileThreadLooper(), paramUploadLogListener);
      paramUploadLogListener.addFilter(new Class[] { BDHCommonUploadProcessor.class });
      ((ITransFileController)paramString.getRuntimeService(ITransFileController.class)).addHandle(paramUploadLogListener);
      ((ITransFileController)paramString.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
    }
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
      paramString1 = new StringBuilder();
      paramString1.append("log file size error: ");
      paramString1.append(l);
      QLog.e("ReportLogUtil", 1, paramString1.toString());
      return;
    }
    uploadLog(paramString2, new ReportLogUtil.1(paramString2, paramString1, l));
  }
  
  /* Error */
  public static void zipFiles(java.util.ArrayList<com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.LogFile> paramArrayList, String paramString)
  {
    // Byte code:
    //   0: new 252	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 254	java/io/FileOutputStream
    //   7: dup
    //   8: new 55	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 257	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: invokespecial 260	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_1
    //   23: new 262	java/util/zip/ZipOutputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 263	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore 8
    //   33: aload_0
    //   34: invokevirtual 269	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   37: astore_0
    //   38: iconst_0
    //   39: istore_2
    //   40: aload_0
    //   41: invokeinterface 274 1 0
    //   46: ifeq +196 -> 242
    //   49: aload_0
    //   50: invokeinterface 278 1 0
    //   55: checkcast 280	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile
    //   58: astore 9
    //   60: iload_2
    //   61: istore_3
    //   62: aload 9
    //   64: invokevirtual 281	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:exists	()Z
    //   67: ifeq +324 -> 391
    //   70: new 143	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   77: astore 10
    //   79: aload 10
    //   81: aload 9
    //   83: invokevirtual 284	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:getName	()Ljava/lang/String;
    //   86: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 10
    //   92: aload 9
    //   94: getfield 287	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:stuffix	Ljava/lang/String;
    //   97: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 8
    //   103: new 289	java/util/zip/ZipEntry
    //   106: dup
    //   107: aload 10
    //   109: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 290	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   115: invokevirtual 294	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   118: aload 8
    //   120: bipush 9
    //   122: invokevirtual 297	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   125: aload 9
    //   127: invokevirtual 298	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:length	()J
    //   130: lstore 6
    //   132: new 300	java/io/FileInputStream
    //   135: dup
    //   136: aload 9
    //   138: invokespecial 301	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   141: astore 9
    //   143: sipush 20480
    //   146: newarray byte
    //   148: astore 10
    //   150: lconst_0
    //   151: lstore 4
    //   153: aload 9
    //   155: aload 10
    //   157: iconst_0
    //   158: sipush 20480
    //   161: invokevirtual 305	java/io/FileInputStream:read	([BII)I
    //   164: istore_3
    //   165: iload_3
    //   166: iconst_m1
    //   167: if_icmpeq +37 -> 204
    //   170: aload 8
    //   172: aload 10
    //   174: iconst_0
    //   175: iload_3
    //   176: invokevirtual 309	java/util/zip/ZipOutputStream:write	([BII)V
    //   179: lload 4
    //   181: iload_3
    //   182: i2l
    //   183: ladd
    //   184: lstore 4
    //   186: lload 4
    //   188: lload 6
    //   190: lcmp
    //   191: iflt +8 -> 199
    //   194: iconst_1
    //   195: istore_2
    //   196: goto +8 -> 204
    //   199: iconst_1
    //   200: istore_2
    //   201: goto -48 -> 153
    //   204: aload 9
    //   206: invokevirtual 312	java/io/FileInputStream:close	()V
    //   209: aload 8
    //   211: invokevirtual 315	java/util/zip/ZipOutputStream:flush	()V
    //   214: aload 8
    //   216: invokevirtual 318	java/util/zip/ZipOutputStream:closeEntry	()V
    //   219: iload_2
    //   220: istore_3
    //   221: goto +170 -> 391
    //   224: astore_0
    //   225: aload 9
    //   227: invokevirtual 312	java/io/FileInputStream:close	()V
    //   230: aload 8
    //   232: invokevirtual 315	java/util/zip/ZipOutputStream:flush	()V
    //   235: aload 8
    //   237: invokevirtual 318	java/util/zip/ZipOutputStream:closeEntry	()V
    //   240: aload_0
    //   241: athrow
    //   242: iload_2
    //   243: ifeq +8 -> 251
    //   246: aload 8
    //   248: invokevirtual 319	java/util/zip/ZipOutputStream:close	()V
    //   251: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   254: ifeq +12 -> 266
    //   257: ldc 8
    //   259: iconst_2
    //   260: ldc_w 324
    //   263: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: aload_1
    //   267: invokevirtual 325	java/io/BufferedOutputStream:close	()V
    //   270: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +102 -> 375
    //   276: ldc 8
    //   278: iconst_2
    //   279: ldc_w 327
    //   282: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: goto +90 -> 375
    //   288: astore_0
    //   289: goto +60 -> 349
    //   292: astore_0
    //   293: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   296: ifeq +40 -> 336
    //   299: new 143	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   306: astore 8
    //   308: aload 8
    //   310: ldc_w 329
    //   313: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 8
    //   319: aload_0
    //   320: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: ldc 8
    //   326: iconst_2
    //   327: aload 8
    //   329: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: aload_0
    //   333: invokestatic 336	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   336: aload_1
    //   337: invokevirtual 325	java/io/BufferedOutputStream:close	()V
    //   340: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +32 -> 375
    //   346: goto -70 -> 276
    //   349: aload_1
    //   350: invokevirtual 325	java/io/BufferedOutputStream:close	()V
    //   353: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +12 -> 368
    //   359: ldc 8
    //   361: iconst_2
    //   362: ldc_w 327
    //   365: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: aload_0
    //   369: athrow
    //   370: astore_0
    //   371: aload_0
    //   372: invokevirtual 339	java/io/IOException:printStackTrace	()V
    //   375: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq +12 -> 390
    //   381: ldc 8
    //   383: iconst_2
    //   384: ldc_w 341
    //   387: invokestatic 343	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: return
    //   391: iload_3
    //   392: istore_2
    //   393: goto -353 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	paramArrayList	java.util.ArrayList<com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.LogFile>
    //   0	396	1	paramString	String
    //   39	354	2	i	int
    //   61	331	3	j	int
    //   151	36	4	l1	long
    //   130	59	6	l2	long
    //   31	297	8	localObject1	Object
    //   58	168	9	localObject2	Object
    //   77	96	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   143	150	224	finally
    //   153	165	224	finally
    //   170	179	224	finally
    //   33	38	288	finally
    //   40	60	288	finally
    //   62	143	288	finally
    //   204	219	288	finally
    //   225	242	288	finally
    //   246	251	288	finally
    //   251	266	288	finally
    //   293	336	288	finally
    //   33	38	292	java/io/IOException
    //   40	60	292	java/io/IOException
    //   62	143	292	java/io/IOException
    //   204	219	292	java/io/IOException
    //   225	242	292	java/io/IOException
    //   246	251	292	java/io/IOException
    //   251	266	292	java/io/IOException
    //   0	33	370	java/io/IOException
    //   266	276	370	java/io/IOException
    //   276	285	370	java/io/IOException
    //   336	346	370	java/io/IOException
    //   349	368	370	java/io/IOException
    //   368	370	370	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.ReportLogUtil
 * JD-Core Version:    0.7.0.1
 */