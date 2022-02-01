package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.filemanager.FileManagerUtil;
import com.tencent.mobileqq.uniformdownload.filemanager.HttpUrlProcessor;
import com.tencent.mobileqq.uniformdownload.util.UDConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import mqq.app.AppRuntime;

public class UniformDownloaderGenWorker
  implements IHttpCommunicatorListener
{
  public static int a;
  public static String a;
  public static int b;
  public static int c;
  long jdField_a_of_type_Long = 0L;
  private HttpCommunicator jdField_a_of_type_ComTencentMobileqqTransfileHttpCommunicator;
  private UniformDownloaderGen.IUniformDownloaderGenListener jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloaderGen$IUniformDownloaderGenListener = null;
  private HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  private OutputStream jdField_a_of_type_JavaIoOutputStream = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  long jdField_b_of_type_Long = 0L;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private final String jdField_b_of_type_JavaLangString;
  private final long jdField_c_of_type_Long;
  private Object jdField_c_of_type_JavaLangObject = new Object();
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int = jdField_b_of_type_Int;
  private long jdField_d_of_type_Long;
  private Object jdField_d_of_type_JavaLangObject = new Object();
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int = 0;
  private long jdField_e_of_type_Long = 0L;
  private Object jdField_e_of_type_JavaLangObject = new Object();
  private int f = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloaderGenWorker";
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
  }
  
  public UniformDownloaderGenWorker(long paramLong1, AppRuntime paramAppRuntime, String paramString1, long paramLong2, String paramString2, UniformDownloaderGen.IUniformDownloaderGenListener paramIUniformDownloaderGenListener)
  {
    this.jdField_c_of_type_Long = paramLong1;
    this.jdField_b_of_type_JavaLangString = new HttpUrlProcessor(paramAppRuntime, paramString1).a();
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloaderGen$IUniformDownloaderGenListener = paramIUniformDownloaderGenListener;
    this.jdField_d_of_type_Long = paramLong2;
    this.jdField_d_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpCommunicator = ((HttpCommunicator)((IHttpEngineService)paramAppRuntime.getRuntimeService(IHttpEngineService.class, "")).getCommunicator());
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][HttpCommunicator]:" + this.jdField_a_of_type_ComTencentMobileqqTransfileHttpCommunicator.toString());
  }
  
  private int a()
  {
    int i = jdField_b_of_type_Int;
    synchronized (this.jdField_e_of_type_JavaLangObject)
    {
      i = this.jdField_d_of_type_Int;
      return i;
    }
  }
  
  private long a()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      long l = this.jdField_e_of_type_Long;
      return l;
    }
  }
  
  private UniformDownloaderGen.IUniformDownloaderGenListener a()
  {
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      UniformDownloaderGen.IUniformDownloaderGenListener localIUniformDownloaderGenListener = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloaderGen$IUniformDownloaderGenListener;
      return localIUniformDownloaderGenListener;
    }
  }
  
  private HttpMsg a()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      HttpMsg localHttpMsg = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
      return localHttpMsg;
    }
  }
  
  private void a(int paramInt)
  {
    synchronized (this.jdField_e_of_type_JavaLangObject)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. setStatus: " + this.jdField_d_of_type_Int + " -> " + paramInt);
      this.jdField_d_of_type_Int = paramInt;
      return;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    c();
    AppRuntime localAppRuntime = UniformDownloadMgr.a().a();
    if (localAppRuntime != null)
    {
      FileManagerUtil.a(localAppRuntime, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", paramInt, paramString1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", this.jdField_e_of_type_Int, paramString2, null);
      FileManagerUtil.a(localAppRuntime, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", paramInt, paramString1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", this.jdField_e_of_type_Int, paramString2, null);
    }
    for (;;)
    {
      paramString2 = a();
      if (paramString2 != null) {
        paramString2.a(paramInt, paramString1, null);
      }
      return;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 3");
    }
  }
  
  private void a(long paramLong)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_e_of_type_Long = paramLong;
      return;
    }
  }
  
  private void a(UniformDownloaderGen.IUniformDownloaderGenListener paramIUniformDownloaderGenListener)
  {
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloaderGen$IUniformDownloaderGenListener = paramIUniformDownloaderGenListener;
      return;
    }
  }
  
  private void a(HttpMsg paramHttpMsg)
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramHttpMsg;
      return;
    }
  }
  
  private boolean a()
  {
    return jdField_b_of_type_Int == a();
  }
  
  /* Error */
  private boolean a(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: lload_1
    //   6: invokespecial 176	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderGenWorker:a	(J)V
    //   9: new 99	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   16: ldc 178
    //   18: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: lload_1
    //   22: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: ldc 180
    //   27: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 5
    //   35: aload_0
    //   36: getfield 75	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderGenWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   39: ifnull +235 -> 274
    //   42: aload_0
    //   43: getfield 75	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderGenWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   46: ldc 182
    //   48: invokevirtual 188	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   51: ifne +223 -> 274
    //   54: new 99	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   61: aload_0
    //   62: getfield 75	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderGenWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   65: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 190
    //   70: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: lload_1
    //   74: invokestatic 194	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   77: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore 4
    //   85: new 196	com/tencent/mobileqq/utils/httputils/HttpMsg
    //   88: dup
    //   89: aload 4
    //   91: aconst_null
    //   92: aload_0
    //   93: iconst_1
    //   94: invokespecial 199	com/tencent/mobileqq/utils/httputils/HttpMsg:<init>	(Ljava/lang/String;[BLcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;Z)V
    //   97: astore 6
    //   99: ldc 201
    //   101: astore 4
    //   103: invokestatic 207	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   106: invokestatic 212	com/tencent/mobileqq/utils/NetworkUtil:b	(Landroid/content/Context;)I
    //   109: iconst_1
    //   110: if_icmpne +7 -> 117
    //   113: ldc 214
    //   115: astore 4
    //   117: aload 6
    //   119: ldc 216
    //   121: aload 4
    //   123: invokevirtual 220	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload 6
    //   128: ldc 222
    //   130: aload 5
    //   132: invokevirtual 220	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 6
    //   137: iconst_1
    //   138: invokevirtual 225	com/tencent/mobileqq/utils/httputils/HttpMsg:setPriority	(I)V
    //   141: aload_0
    //   142: getfield 79	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderGenWorker:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   145: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   148: ifne +14 -> 162
    //   151: aload 6
    //   153: ldc 232
    //   155: aload_0
    //   156: getfield 79	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderGenWorker:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   159: invokevirtual 220	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload 6
    //   164: iconst_1
    //   165: invokevirtual 236	com/tencent/mobileqq/utils/httputils/HttpMsg:setDataSlice	(Z)V
    //   168: aload 6
    //   170: iconst_5
    //   171: putfield 239	com/tencent/mobileqq/utils/httputils/HttpMsg:fileType	I
    //   174: aload 6
    //   176: iconst_0
    //   177: putfield 242	com/tencent/mobileqq/utils/httputils/HttpMsg:busiType	I
    //   180: aload 6
    //   182: invokestatic 247	java/lang/System:currentTimeMillis	()J
    //   185: invokestatic 194	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   188: putfield 250	com/tencent/mobileqq/utils/httputils/HttpMsg:msgId	Ljava/lang/String;
    //   191: aload 6
    //   193: ldc 252
    //   195: ldc 254
    //   197: invokevirtual 220	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload_0
    //   201: aload 6
    //   203: invokespecial 256	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderGenWorker:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   206: invokestatic 146	com/tencent/mobileqq/uniformdownload/core/UniformDownloadMgr:a	()Lcom/tencent/mobileqq/uniformdownload/core/UniformDownloadMgr;
    //   209: invokevirtual 149	com/tencent/mobileqq/uniformdownload/core/UniformDownloadMgr:a	()Lmqq/app/AppRuntime;
    //   212: ifnonnull +97 -> 309
    //   215: getstatic 26	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderGenWorker:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   218: iconst_1
    //   219: new 99	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   226: ldc 125
    //   228: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_0
    //   232: getfield 65	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderGenWorker:jdField_c_of_type_Long	J
    //   235: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   238: ldc_w 258
    //   241: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: lload_1
    //   245: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   248: ldc_w 260
    //   251: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: lload_1
    //   255: aload_0
    //   256: getfield 77	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderGenWorker:jdField_d_of_type_Long	J
    //   259: ldiv
    //   260: l2i
    //   261: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   264: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 138	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: aload_0
    //   271: monitorexit
    //   272: iload_3
    //   273: ireturn
    //   274: new 99	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   281: aload_0
    //   282: getfield 75	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderGenWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   285: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc_w 262
    //   291: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: lload_1
    //   295: invokestatic 194	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   298: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: astore 4
    //   306: goto -221 -> 85
    //   309: aload_0
    //   310: getfield 97	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderGenWorker:jdField_a_of_type_ComTencentMobileqqTransfileHttpCommunicator	Lcom/tencent/mobileqq/transfile/HttpCommunicator;
    //   313: aload 6
    //   315: invokevirtual 266	com/tencent/mobileqq/transfile/HttpCommunicator:sendMsg	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)I
    //   318: pop
    //   319: getstatic 26	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderGenWorker:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   322: iconst_1
    //   323: new 99	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   330: ldc 125
    //   332: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_0
    //   336: getfield 65	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderGenWorker:jdField_c_of_type_Long	J
    //   339: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   342: ldc_w 268
    //   345: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: lload_1
    //   349: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   352: ldc_w 260
    //   355: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: lload_1
    //   359: aload_0
    //   360: getfield 77	com/tencent/mobileqq/uniformdownload/downloader/UniformDownloaderGenWorker:jdField_d_of_type_Long	J
    //   363: ldiv
    //   364: l2i
    //   365: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   368: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 138	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: iconst_1
    //   375: istore_3
    //   376: goto -106 -> 270
    //   379: astore 4
    //   381: aload_0
    //   382: monitorexit
    //   383: aload 4
    //   385: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	this	UniformDownloaderGenWorker
    //   0	386	1	paramLong	long
    //   1	375	3	bool	boolean
    //   83	222	4	str1	String
    //   379	5	4	localObject	Object
    //   33	98	5	str2	String
    //   97	217	6	localHttpMsg	HttpMsg
    // Exception table:
    //   from	to	target	type
    //   4	85	379	finally
    //   85	99	379	finally
    //   103	113	379	finally
    //   117	162	379	finally
    //   162	270	379	finally
    //   274	306	379	finally
    //   309	374	379	finally
  }
  
  private boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (paramHttpMsg1 == null) {
      return false;
    }
    if (paramHttpMsg2 == null) {
      return true;
    }
    return paramHttpMsg2.permitRetry();
  }
  
  private boolean a(byte[] paramArrayOfByte)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream == null)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. writeFileStream: stream = null:");
          return false;
        }
        this.jdField_a_of_type_JavaIoOutputStream.write(paramArrayOfByte);
        return true;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return false;
      }
    }
  }
  
  private boolean b()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        OutputStream localOutputStream = this.jdField_a_of_type_JavaIoOutputStream;
        if (localOutputStream == null) {
          try
          {
            this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_c_of_type_JavaLangString, true);
            QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. openFileStream: filepath:" + this.jdField_c_of_type_JavaLangString);
            return true;
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. openFileStream: exception");
            localFileNotFoundException.printStackTrace();
            return false;
          }
        }
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. openFileStream: had be opened");
    }
  }
  
  private void c()
  {
    try
    {
      a(jdField_b_of_type_Int);
      d();
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream != null)
        {
          this.jdField_a_of_type_JavaIoOutputStream.close();
          this.jdField_a_of_type_JavaIoOutputStream = null;
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. closeFileStream: filepath:" + this.jdField_c_of_type_JavaLangString);
        }
        for (;;)
        {
          return true;
          QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. closeFileStream.had closed: stream = null:");
        }
        localObject2 = finally;
      }
      catch (IOException localIOException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. closeFileStream: exception");
        localIOException.printStackTrace();
        return false;
      }
    }
  }
  
  private void d()
  {
    HttpMsg localHttpMsg = a();
    if (localHttpMsg != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. stopHttpRequest");
      a(null);
      if (UniformDownloadMgr.a().a() == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. stopHttpRequest failed.APP=null");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileHttpCommunicator.cancelMsg(localHttpMsg);
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. stopHttpRequest: no request");
  }
  
  public void a()
  {
    c();
    a(null);
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start failed. filepath = null. POS:" + paramLong);
      return false;
    }
    if (jdField_a_of_type_Int == a())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start. is runing. POS:" + paramLong);
      return true;
    }
    this.jdField_c_of_type_JavaLangString = paramString;
    if (!b())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start failed. openFileStream failed. POS:" + paramLong);
      paramString = UDConstants.a(8);
      a(8, paramString, paramString);
      return false;
    }
    if (!a(paramLong))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start download failed. POS:" + paramLong);
      paramString = UDConstants.a(6);
      a(6, paramString, paramString);
      return false;
    }
    a(jdField_a_of_type_Int);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start to run download . POS:" + paramLong);
    return true;
  }
  
  public void b()
  {
    a(jdField_c_of_type_Int);
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (a()) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. decode. but had stoped");
    }
    int i;
    do
    {
      long l1;
      do
      {
        for (;;)
        {
          return;
          try
          {
            if ((paramHttpMsg2.getResponseCode() == 206) || (paramHttpMsg2.getResponseCode() == 200)) {
              if (!a(paramHttpMsg2.getRecvData()))
              {
                i = 3;
                paramHttpMsg1 = UDConstants.a(3);
                l1 = 0L;
                if (SystemUtil.a()) {
                  l1 = SystemUtil.a() * 1024L;
                }
                if (l1 < this.jdField_d_of_type_Long - a())
                {
                  QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] write file failed. sd card space is no enough:[" + this.jdField_d_of_type_Long + " " + a() + " " + l1 + "]");
                  i = 9;
                  paramHttpMsg1 = UDConstants.a(9);
                }
                a(i, paramHttpMsg1, paramHttpMsg1);
                return;
              }
            }
          }
          catch (Exception paramHttpMsg1)
          {
            paramHttpMsg1.printStackTrace();
            paramHttpMsg1 = UDConstants.a(12);
            a(12, paramHttpMsg1, paramHttpMsg1);
            return;
          }
        }
        l1 = a() + paramHttpMsg2.getRecvData().length;
        long l2 = paramHttpMsg2.getTotalLen();
        if (this.jdField_d_of_type_Long != l2) {
          this.jdField_d_of_type_Long = l2;
        }
        a(l1);
        this.jdField_b_of_type_Long += paramHttpMsg2.getRecvData().length;
        if (l1 < this.jdField_d_of_type_Long) {
          break;
        }
        if (!c())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].closeFileStream falied.path=" + this.jdField_c_of_type_JavaLangString);
          paramHttpMsg1 = UDConstants.a(4);
          a(4, paramHttpMsg1, paramHttpMsg1);
          return;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].decode >>>>>>>. SUCESSFUL!!!");
        paramHttpMsg1 = a();
      } while (paramHttpMsg1 == null);
      paramHttpMsg2 = new Bundle();
      paramHttpMsg2.putLong("EXT_TRANS_SIZE ", this.jdField_e_of_type_Long);
      paramHttpMsg2.putLong("EXT_TTRANS_SIZE ", this.jdField_b_of_type_Long);
      paramHttpMsg2.putInt("EXT_AUTOTRY_COUNT", this.jdField_e_of_type_Int);
      paramHttpMsg1.a(this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Long, paramHttpMsg2);
      return;
      i = (int)((float)l1 / (float)this.jdField_d_of_type_Long * 100.0F);
      paramHttpMsg1 = a();
    } while (paramHttpMsg1 == null);
    paramHttpMsg1.a(i, null);
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (a())
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError..user puase");
      return;
    }
    if (paramHttpMsg2 == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError.. response=NULL:");
      c();
      paramHttpMsg1 = UDConstants.a(2);
      paramHttpMsg2 = UniformDownloadMgr.a().a();
      if (paramHttpMsg2 != null)
      {
        FileManagerUtil.a(paramHttpMsg2, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 2, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
        FileManagerUtil.a(paramHttpMsg2, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 2, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
      }
      for (;;)
      {
        paramHttpMsg2 = a();
        if (paramHttpMsg2 == null) {
          break;
        }
        paramHttpMsg2.a(2, paramHttpMsg1, null);
        return;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 111");
      }
    }
    Object localObject2 = paramHttpMsg2.getErrorString();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError.. errString:" + (String)localObject1);
    if (jdField_c_of_type_Int == a())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError.. slience pause. may app destroy!!");
      c();
      return;
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      c();
      paramHttpMsg1 = UDConstants.a(5);
      paramHttpMsg2 = UniformDownloadMgr.a().a();
      if (paramHttpMsg2 != null)
      {
        FileManagerUtil.a(paramHttpMsg2, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 5, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
        FileManagerUtil.a(paramHttpMsg2, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 5, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
      }
      for (;;)
      {
        paramHttpMsg2 = a();
        if (paramHttpMsg2 == null) {
          break;
        }
        paramHttpMsg2.a(5, paramHttpMsg1, null);
        return;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 11");
      }
    }
    long l = paramHttpMsg2.errCode;
    int i = paramHttpMsg2.getSerial();
    localObject1 = paramHttpMsg2.getErrorString();
    if ((a(paramHttpMsg1, paramHttpMsg2)) && (this.jdField_e_of_type_Int < 3))
    {
      this.jdField_e_of_type_Int += 1;
      if ((this.f < 3) && (paramHttpMsg2.errCode == 9056))
      {
        this.f += 1;
        this.jdField_e_of_type_Int -= 1;
        label623:
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError. auto retry to download. autoRetry=" + this.jdField_e_of_type_Int + " eofRetry=" + this.f);
        d();
        if (a(a())) {
          break label945;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. auto retry dowload failed.");
        localObject1 = UDConstants.a((int)13L);
        l = 13L;
      }
    }
    for (paramHttpMsg1 = (HttpMsg)localObject1;; paramHttpMsg1 = String.valueOf(i))
    {
      this.jdField_e_of_type_Int = 0;
      this.f = 0;
      c();
      localObject2 = UniformDownloadMgr.a().a();
      if (localObject2 != null)
      {
        if (13L == l) {
          break label1129;
        }
        l = 11L;
        localObject1 = UDConstants.a((int)11L);
        paramHttpMsg1 = (HttpMsg)localObject1;
      }
      label945:
      label1129:
      for (;;)
      {
        FileManagerUtil.a((AppRuntime)localObject2, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", l, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_e_of_type_Int, (String)localObject1, null);
        FileManagerUtil.a((AppRuntime)localObject2, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", paramHttpMsg2.errCode, String.valueOf(paramHttpMsg2.getSerial()), this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_e_of_type_Int, paramHttpMsg2.getErrorString(), null);
        for (;;)
        {
          paramHttpMsg1 = a();
          if (paramHttpMsg1 == null) {
            break;
          }
          paramHttpMsg1.a(6, "downloader fialed", null);
          return;
          this.f = 0;
          break label623;
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. auto retry dowload started.");
          paramHttpMsg1 = UniformDownloadMgr.a().a();
          if (paramHttpMsg1 != null)
          {
            FileManagerUtil.a(paramHttpMsg1, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", paramHttpMsg2.errCode, String.valueOf(paramHttpMsg2.getSerial()), this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_e_of_type_Int, paramHttpMsg2.getErrorString(), null);
            return;
          }
          QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 1");
          return;
          QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 2");
        }
      }
    }
  }
  
  public void handleRedirect(String paramString) {}
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. HttpCommunicator statusChanged. status:" + paramInt);
    if ((5 == paramInt) && (a() < this.jdField_d_of_type_Long))
    {
      c();
      paramHttpMsg1 = UDConstants.a(14);
      AppRuntime localAppRuntime = UniformDownloadMgr.a().a();
      if (localAppRuntime == null) {
        break label208;
      }
      FileManagerUtil.a(localAppRuntime, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 14, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_e_of_type_Int, paramHttpMsg1, null);
      FileManagerUtil.a(localAppRuntime, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 14, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_e_of_type_Int, paramHttpMsg1, null);
    }
    for (;;)
    {
      paramHttpMsg1 = a();
      if (paramHttpMsg1 != null) {
        paramHttpMsg1.a(14, "downloader fialed", null);
      }
      return true;
      label208:
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 2");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderGenWorker
 * JD-Core Version:    0.7.0.1
 */