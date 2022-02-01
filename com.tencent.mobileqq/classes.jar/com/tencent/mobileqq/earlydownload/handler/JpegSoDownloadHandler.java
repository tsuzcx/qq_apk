package com.tencent.mobileqq.earlydownload.handler;

import android.os.Build;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.JpegSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;

public class JpegSoDownloadHandler
  extends EarlyHandler
{
  QQAppInterface h = null;
  long i = 0L;
  boolean j = true;
  
  public JpegSoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super(w(), paramQQAppInterface);
    this.h = paramQQAppInterface;
  }
  
  public static String w()
  {
    if ("armeabi-v7a".equalsIgnoreCase(Build.CPU_ABI)) {
      return "qq.android.pic.jpeg.so_v7_820";
    }
    return "qq.android.pic.jpeg.so_v5_820";
  }
  
  public Class<? extends XmlData> a()
  {
    return JpegSoData.class;
  }
  
  public void a(XmlData paramXmlData)
  {
    if ((QLog.isColorLevel()) && (paramXmlData != null) && ((paramXmlData instanceof JpegSoData))) {
      QLog.d("QJpegSoDownloadHandler", 2, new Object[] { "doOnServerResp, xmlData=", paramXmlData });
    }
    super.a(paramXmlData);
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 78	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokestatic 84	com/tencent/mobileqq/pic/JpegSoLoad:getJpegSolibPath	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore 6
    //   8: new 86	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   15: astore 5
    //   17: aload 5
    //   19: aload 6
    //   21: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 5
    //   27: ldc 95
    //   29: invokestatic 99	com/tencent/mobileqq/pic/JpegSoLoad:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 5
    //   38: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore 5
    //   43: iconst_0
    //   44: istore 4
    //   46: iconst_0
    //   47: istore_3
    //   48: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +54 -> 105
    //   54: new 86	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   61: astore 7
    //   63: aload 7
    //   65: ldc 104
    //   67: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 7
    //   73: aload_1
    //   74: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 7
    //   80: ldc 106
    //   82: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 7
    //   88: aload 5
    //   90: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: ldc 59
    //   96: iconst_2
    //   97: aload 7
    //   99: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload_1
    //   106: aload 6
    //   108: iconst_0
    //   109: invokestatic 115	com/tencent/mobileqq/utils/FileUtils:uncompressZip	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   112: aload 5
    //   114: invokestatic 120	com/tencent/mobileqq/scribble/ScribbleUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 6
    //   119: aload_0
    //   120: invokevirtual 123	com/tencent/mobileqq/earlydownload/handler/JpegSoDownloadHandler:h	()Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;
    //   123: astore 7
    //   125: iload_3
    //   126: istore_2
    //   127: aload 7
    //   129: instanceof 48
    //   132: ifeq +91 -> 223
    //   135: aload 7
    //   137: checkcast 48	com/tencent/mobileqq/earlydownload/xmldata/JpegSoData
    //   140: astore 7
    //   142: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +58 -> 203
    //   148: new 86	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   155: astore 8
    //   157: aload 8
    //   159: ldc 125
    //   161: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 8
    //   167: aload 6
    //   169: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 8
    //   175: ldc 127
    //   177: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 8
    //   183: aload 7
    //   185: getfield 130	com/tencent/mobileqq/earlydownload/xmldata/JpegSoData:SO_MD5	Ljava/lang/String;
    //   188: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: ldc 59
    //   194: iconst_2
    //   195: aload 8
    //   197: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: iload_3
    //   204: istore_2
    //   205: aload 6
    //   207: aload 7
    //   209: getfield 130	com/tencent/mobileqq/earlydownload/xmldata/JpegSoData:SO_MD5	Ljava/lang/String;
    //   212: invokevirtual 40	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   215: ifeq +8 -> 223
    //   218: invokestatic 135	com/tencent/mobileqq/pic/JpegCompressor:jpegcompressLoadSo	()V
    //   221: iconst_1
    //   222: istore_2
    //   223: iload_2
    //   224: ifne +14 -> 238
    //   227: aload 5
    //   229: invokestatic 138	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   232: pop
    //   233: aload_1
    //   234: invokestatic 138	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   237: pop
    //   238: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +100 -> 341
    //   244: new 86	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   251: astore 5
    //   253: goto +62 -> 315
    //   256: astore 6
    //   258: goto +89 -> 347
    //   261: astore 6
    //   263: aload 6
    //   265: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   268: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +15 -> 286
    //   274: ldc 59
    //   276: iconst_2
    //   277: aload 6
    //   279: iconst_0
    //   280: anewarray 61	java/lang/Object
    //   283: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   286: aload 5
    //   288: invokestatic 138	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   291: pop
    //   292: aload_1
    //   293: invokestatic 138	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   296: pop
    //   297: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +41 -> 341
    //   303: new 86	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   310: astore 5
    //   312: iload 4
    //   314: istore_2
    //   315: aload 5
    //   317: ldc 147
    //   319: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 5
    //   325: iload_2
    //   326: invokevirtual 150	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: ldc 59
    //   332: iconst_2
    //   333: aload 5
    //   335: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload_0
    //   342: aload_1
    //   343: invokespecial 152	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	(Ljava/lang/String;)V
    //   346: return
    //   347: aload 5
    //   349: invokestatic 138	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   352: pop
    //   353: aload_1
    //   354: invokestatic 138	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   357: pop
    //   358: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq +34 -> 395
    //   364: new 86	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   371: astore_1
    //   372: aload_1
    //   373: ldc 147
    //   375: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload_1
    //   380: iconst_0
    //   381: invokevirtual 150	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: ldc 59
    //   387: iconst_2
    //   388: aload_1
    //   389: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: aload 6
    //   397: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	JpegSoDownloadHandler
    //   0	398	1	paramString	String
    //   126	200	2	bool1	boolean
    //   47	157	3	bool2	boolean
    //   44	269	4	bool3	boolean
    //   15	333	5	localObject1	Object
    //   6	200	6	str	String
    //   256	1	6	localObject2	Object
    //   261	135	6	localException	java.lang.Exception
    //   61	147	7	localObject3	Object
    //   155	41	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   48	105	256	finally
    //   105	125	256	finally
    //   127	203	256	finally
    //   205	221	256	finally
    //   263	286	256	finally
    //   48	105	261	java/lang/Exception
    //   105	125	261	java/lang/Exception
    //   127	203	261	java/lang/Exception
    //   205	221	261	java/lang/Exception
  }
  
  public void a(boolean paramBoolean)
  {
    if (h().loadState == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QJpegSoDownloadHandler", 2, "is in downloading");
      }
    }
    else {
      super.a(paramBoolean);
    }
  }
  
  public String b()
  {
    return "qjpegDownloadSoDuration";
  }
  
  public int c()
  {
    return 10043;
  }
  
  public String d()
  {
    return null;
  }
  
  public boolean e()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.JpegSoDownloadHandler
 * JD-Core Version:    0.7.0.1
 */