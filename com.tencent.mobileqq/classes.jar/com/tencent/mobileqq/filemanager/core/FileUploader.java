package com.tencent.mobileqq.filemanager.core;

import acvr;
import acvs;
import acvt;
import acwq;
import acwr;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FileUploader
  implements acwq
{
  private int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private acwr jdField_a_of_type_Acwr;
  private FileUploader.IFileUploaderSink jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink;
  private FileUploader.IFlowControl jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFlowControl = new acvt(this);
  private final HttpUrlProcessor jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor;
  private InputStream jdField_a_of_type_JavaIoInputStream;
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  
  private FileUploader(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new File(paramString1).length();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(paramQQAppInterface, paramString2);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    this.jdField_a_of_type_Acwr = Md5HttpUploader.a(paramQQAppInterface, this.jdField_a_of_type_Long, paramInt1, paramInt2);
    if (this.jdField_a_of_type_Acwr != null) {
      this.jdField_a_of_type_Acwr.a(this);
    }
  }
  
  private FileUploader(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new File(paramString1).length();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(paramQQAppInterface, paramString4);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    this.jdField_a_of_type_Acwr = FtnUploader.a(paramQQAppInterface, this.jdField_a_of_type_Long, paramInt1, paramInt2, paramString2, paramString3, this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_Acwr != null) {
      this.jdField_a_of_type_Acwr.a(this);
    }
  }
  
  private FileUploader(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, List paramList, String paramString4)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new File(paramString1).length();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(paramQQAppInterface, paramList, paramString4);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    this.jdField_a_of_type_Acwr = FtnUploader.a(paramQQAppInterface, this.jdField_a_of_type_Long, paramInt1, paramInt2, paramString2, paramString3, this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_Acwr != null) {
      this.jdField_a_of_type_Acwr.a(this);
    }
  }
  
  private FileUploader(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, List paramList, String paramString2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new File(paramString1).length();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(paramQQAppInterface, paramList, paramString2);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    this.jdField_a_of_type_Acwr = Md5HttpUploader.a(paramQQAppInterface, this.jdField_a_of_type_Long, paramInt1, paramInt2);
    if (this.jdField_a_of_type_Acwr != null) {
      this.jdField_a_of_type_Acwr.a(this);
    }
  }
  
  public static FileUploader a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
    }
    do
    {
      do
      {
        do
        {
          return null;
          if (paramString1.length() != 0) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
        return null;
        if (paramString2 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is null");
      return null;
      if (paramString2.length() != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is empty");
    return null;
    return new FileUploader(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramString2);
  }
  
  public static FileUploader a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
      return null;
    }
    if (paramString1.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
      }
      return null;
    }
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strCheckSum is null");
      }
      return null;
    }
    if (paramString3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strSHA is null");
      }
      return null;
    }
    if (paramString4 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is null");
      }
      return null;
    }
    if (paramString4.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is empty");
      }
      return null;
    }
    return new FileUploader(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4);
  }
  
  public static FileUploader a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, List paramList, String paramString4)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
      return null;
    }
    if (paramString1.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
      }
      return null;
    }
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strCheckSum is null");
      }
      return null;
    }
    if (paramString3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strSHA is null");
      }
      return null;
    }
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is null");
      }
      return null;
    }
    if (paramList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is empty");
      }
      return null;
    }
    if (paramString4 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is null");
      }
      return null;
    }
    if (paramString4.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is empty");
      }
      return null;
    }
    return new FileUploader(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramList, paramString4);
  }
  
  public static FileUploader a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, List paramList, String paramString2)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
      return null;
    }
    if (paramString1.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
      }
      return null;
    }
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is null");
      }
      return null;
    }
    if (paramList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is empty");
      }
      return null;
    }
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is null");
      }
      return null;
    }
    if (paramString2.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is empty");
      }
      return null;
    }
    return new FileUploader(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramList, paramString2);
  }
  
  private void a(int paramInt)
  {
    String str = null;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    }
    if ((str == null) || (str.length() == 0))
    {
      QLog.i("FtnHttpUploader<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_Long + "] need chang Ip ,but can not get next ip errCode[" + paramInt + "]");
      return;
    }
    this.jdField_b_of_type_JavaLangString = str;
    this.jdField_c_of_type_Int += 1;
    this.jdField_a_of_type_Int = 0;
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaIoInputStream != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      this.jdField_a_of_type_JavaIoInputStream = null;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(this.jdField_a_of_type_JavaLangString);
          return true;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          this.jdField_a_of_type_JavaIoInputStream = null;
          localFileNotFoundException.printStackTrace();
        }
        localIOException = localIOException;
        localIOException.printStackTrace();
      }
    }
    return false;
  }
  
  /* Error */
  private byte[] a(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifne +12 -> 15
    //   6: aload_0
    //   7: invokespecial 193	com/tencent/mobileqq/filemanager/core/FileUploader:a	()Z
    //   10: ifne +32 -> 42
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield 195	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   19: lstore 4
    //   21: lload_1
    //   22: lload 4
    //   24: lcmp
    //   25: ifle +82 -> 107
    //   28: aload_0
    //   29: getfield 176	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   32: lload_1
    //   33: aload_0
    //   34: getfield 195	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   37: lsub
    //   38: invokevirtual 199	java/io/InputStream:skip	(J)J
    //   41: pop2
    //   42: aload_0
    //   43: lload_1
    //   44: putfield 195	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   47: aload_0
    //   48: getfield 32	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFlowControl	Lcom/tencent/mobileqq/filemanager/core/FileUploader$IFlowControl;
    //   51: aload_0
    //   52: getfield 86	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_d_of_type_Long	J
    //   55: aload_0
    //   56: getfield 47	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_b_of_type_Long	J
    //   59: invokeinterface 204 5 0
    //   64: istore_3
    //   65: iload_3
    //   66: newarray byte
    //   68: astore 7
    //   70: aload_0
    //   71: getfield 176	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   74: aload 7
    //   76: iconst_0
    //   77: iload_3
    //   78: invokevirtual 208	java/io/InputStream:read	([BII)I
    //   81: pop
    //   82: aload_0
    //   83: getfield 195	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   86: lstore_1
    //   87: aload_0
    //   88: iload_3
    //   89: i2l
    //   90: lload_1
    //   91: ladd
    //   92: putfield 195	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   95: aload 7
    //   97: areturn
    //   98: astore 7
    //   100: aload 7
    //   102: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   105: aconst_null
    //   106: areturn
    //   107: lload_1
    //   108: aload_0
    //   109: getfield 195	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   112: lcmp
    //   113: ifge -71 -> 42
    //   116: aload_0
    //   117: invokespecial 193	com/tencent/mobileqq/filemanager/core/FileUploader:a	()Z
    //   120: istore 6
    //   122: iload 6
    //   124: ifeq +71 -> 195
    //   127: aload_0
    //   128: getfield 176	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   131: lload_1
    //   132: invokevirtual 199	java/io/InputStream:skip	(J)J
    //   135: pop2
    //   136: goto -94 -> 42
    //   139: astore 7
    //   141: aload_0
    //   142: aconst_null
    //   143: putfield 176	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   146: aload 7
    //   148: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   151: aconst_null
    //   152: areturn
    //   153: astore 7
    //   155: aload 7
    //   157: invokevirtual 209	java/lang/Exception:printStackTrace	()V
    //   160: ldc 96
    //   162: iconst_1
    //   163: new 143	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   170: ldc 211
    //   172: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload 7
    //   177: invokevirtual 212	java/lang/Exception:toString	()Ljava/lang/String;
    //   180: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aconst_null
    //   190: astore 7
    //   192: goto -97 -> 95
    //   195: aconst_null
    //   196: areturn
    //   197: astore 7
    //   199: aconst_null
    //   200: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	FileUploader
    //   0	201	1	paramLong	long
    //   64	25	3	i	int
    //   19	4	4	l	long
    //   120	3	6	bool	boolean
    //   68	28	7	arrayOfByte	byte[]
    //   98	3	7	localIOException1	IOException
    //   139	8	7	localIOException2	IOException
    //   153	23	7	localException1	Exception
    //   190	1	7	localObject	Object
    //   197	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   28	42	98	java/io/IOException
    //   127	136	139	java/io/IOException
    //   70	95	153	java/lang/Exception
    //   6	13	197	java/lang/Exception
    //   15	21	197	java/lang/Exception
    //   28	42	197	java/lang/Exception
    //   42	70	197	java/lang/Exception
    //   100	105	197	java/lang/Exception
    //   107	122	197	java/lang/Exception
    //   127	136	197	java/lang/Exception
    //   141	151	197	java/lang/Exception
    //   155	189	197	java/lang/Exception
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFlowControl = new acvt(this);
    new Handler().postDelayed(new acvs(this), paramInt);
  }
  
  private void b(long paramLong, String paramString)
  {
    String str = "RangSizeError_rangError tSize[" + paramLong + "]<=mSize[" + this.jdField_d_of_type_Long + "], lastRoolbackSize[" + this.jdField_c_of_type_Long + "], retry[" + this.jdField_e_of_type_Int + "]";
    if (paramLong <= this.jdField_c_of_type_Long)
    {
      int i = this.jdField_e_of_type_Int + 1;
      this.jdField_e_of_type_Int = i;
      if (i > 6)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, paramLong, str, paramString);
        return;
      }
    }
    this.jdField_c_of_type_Long = paramLong;
    this.jdField_d_of_type_Long = paramLong;
    new Handler().postDelayed(new acvr(this), 6000L);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(false, paramLong, str, paramString);
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      this.jdField_a_of_type_JavaIoInputStream = null;
      label12:
      this.jdField_a_of_type_Acwr.a();
      return;
    }
    catch (Exception localException)
    {
      break label12;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, 9343, "parseDataErr", null);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (-9527 == paramInt)
    {
      if (paramString1.indexOf("-29602") > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, -29602, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-6101") > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, 9042, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-29120") > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.h();
        return;
      }
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, paramInt, paramString1, paramString2);
      return;
    }
    if (FileHttpUtils.a(paramInt)) {
      a(paramInt);
    }
    if (this.jdField_a_of_type_Int < 8)
    {
      this.jdField_d_of_type_Int += 1;
      if ((this.jdField_b_of_type_Int < 3) && (9056 == paramInt))
      {
        this.jdField_b_of_type_Int += 1;
        if (paramInt != 9056) {
          break label248;
        }
      }
    }
    label248:
    for (int i = 0;; i = 6000)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(false, this.jdField_d_of_type_Long, paramInt, paramString1, paramString2);
      b(i);
      return;
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Int += 1;
      break;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, paramInt, paramString1, paramString2);
      return;
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFlowControl.a();
    if (paramLong <= this.jdField_d_of_type_Long)
    {
      b(paramLong, paramString);
      return;
    }
    if ((this.jdField_d_of_type_Long == 0L) && (paramLong == this.jdField_b_of_type_Long))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a();
      return;
    }
    this.jdField_d_of_type_Long = paramLong;
    if (QLog.isColorLevel()) {
      QLog.i("FtnHttpUploader<FileAssistant>", 2, "send http data size[" + String.valueOf(this.jdField_d_of_type_Long) + "] fileSize[" + this.jdField_b_of_type_Long + "] success!");
    }
    if (paramLong < this.jdField_b_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(paramLong);
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Int = 0;
      a(this.jdField_d_of_type_Long);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.b();
  }
  
  public void a(FileUploader.IFileUploaderSink paramIFileUploaderSink)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink = paramIFileUploaderSink;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, 9062, "UrlOver", null);
  }
  
  public boolean a(long paramLong)
  {
    byte[] arrayOfByte = a(paramLong);
    if (arrayOfByte == null)
    {
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "getSendStreamSlice return null");
      return false;
    }
    return this.jdField_a_of_type_Acwr.a(this.jdField_b_of_type_JavaLangString, paramLong, arrayOfByte);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileUploader
 * JD-Core Version:    0.7.0.1
 */