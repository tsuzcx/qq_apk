package com.tencent.mobileqq.troop.filemanager.upload;

import ajnf;
import ajng;
import ajnh;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FtnUploader;
import com.tencent.mobileqq.filemanager.core.IHttpUploadSink;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferRetryController;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferRetryController.ITroopFileTransferRetrySink;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.HostInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TroopFileUploader
  implements IHttpUploadSink, TroopFileTransferRetryController.ITroopFileTransferRetrySink
{
  protected int a;
  protected final long a;
  protected ajnh a;
  public FtnUploader a;
  protected final TroopFileTransferRetryController a;
  protected TroopFileUploader.ITroopFileUploaderSink a;
  private InputStream jdField_a_of_type_JavaIoInputStream;
  protected final String a;
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  protected final long b;
  protected String b;
  private boolean b;
  protected int c;
  protected long c;
  protected String c;
  private long d;
  private long e;
  
  protected TroopFileUploader(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_Ajnh = new ajnh(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new File(paramString1).length();
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController = new TroopFileTransferRetryController(paramQQAppInterface, paramString4, this.jdField_a_of_type_Long, this);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController.a();
    paramString1 = TroopFileTransferUtil.a(this.jdField_b_of_type_JavaLangString);
    if (paramString1 != null)
    {
      this.jdField_c_of_type_JavaLangString = paramString1.jdField_a_of_type_JavaLangString;
      this.jdField_b_of_type_Int = paramString1.jdField_a_of_type_Int;
      this.jdField_c_of_type_Int = paramString1.jdField_b_of_type_Int;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFtnUploader = FtnUploader.a(paramQQAppInterface, this.jdField_a_of_type_Long, 1, 0, paramString2, paramString3, this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFtnUploader != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFtnUploader.a(this);
    }
  }
  
  protected TroopFileUploader(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, List paramList, String paramString4)
  {
    this.jdField_a_of_type_Ajnh = new ajnh(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new File(paramString1).length();
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController = new TroopFileTransferRetryController(paramQQAppInterface, paramList, paramString4, this.jdField_a_of_type_Long, this);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController.a();
    paramString1 = TroopFileTransferUtil.a(this.jdField_b_of_type_JavaLangString);
    if (paramString1 != null)
    {
      this.jdField_c_of_type_JavaLangString = paramString1.jdField_a_of_type_JavaLangString;
      this.jdField_b_of_type_Int = paramString1.jdField_a_of_type_Int;
      this.jdField_c_of_type_Int = paramString1.jdField_b_of_type_Int;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFtnUploader = FtnUploader.a(paramQQAppInterface, this.jdField_a_of_type_Long, 1, 0, paramString2, paramString3, this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFtnUploader != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFtnUploader.a(this);
    }
  }
  
  public static TroopFileUploader a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = "";
    if (paramString1 == null) {
      str = "strFilePath is null";
    }
    while (!TextUtils.isEmpty(str))
    {
      TroopFileTransferUtil.Log.a("TroopFileUploader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getFileUploader " + str);
      return null;
      if (paramString1.length() == 0) {
        str = "strFilePath is empty";
      } else if (paramString2 == null) {
        str = "strCheckSum is null";
      } else if (paramString3 == null) {
        str = "strSHA is null";
      } else if (paramString4 == null) {
        str = "lstUrl is null";
      } else if (paramString4.length() == 0) {
        str = "lstUrl is empty";
      }
    }
    return new TroopFileUploader(paramQQAppInterface, paramLong, paramString1, paramString2, paramString3, paramString4);
  }
  
  public static TroopFileUploader a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, List paramList, String paramString4)
  {
    String str = "";
    if (paramString1 == null) {
      str = "strFilePath is null";
    }
    while (!TextUtils.isEmpty(str))
    {
      TroopFileTransferUtil.Log.a("TroopFileUploader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getFileUploader " + str);
      return null;
      if (paramString1.length() == 0) {
        str = "strFilePath is empty";
      } else if (paramString2 == null) {
        str = "strCheckSum is null";
      } else if (paramString3 == null) {
        str = "strSHA is null";
      } else if (paramList == null) {
        str = "lstUrl is null";
      } else if (paramList.size() == 0) {
        str = "lstUrl is empty";
      } else if (paramString4 == null) {
        str = "urlParams is null";
      } else if (paramString4.length() == 0) {
        str = "urlParams is empty";
      }
    }
    return new TroopFileUploader(paramQQAppInterface, paramLong, paramString1, paramString2, paramString3, paramList, paramString4);
  }
  
  private boolean a(long paramLong)
  {
    byte[] arrayOfByte = a(paramLong);
    if (arrayOfByte == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] sendFile. getSendStreamSlice return null");
      ThreadManager.post(new ajnf(this), 5, null, true);
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFtnUploader.a(this.jdField_b_of_type_JavaLangString, paramLong, arrayOfByte);
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
    //   7: invokespecial 195	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploader:c	()Z
    //   10: ifne +32 -> 42
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield 197	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploader:e	J
    //   19: lstore 4
    //   21: lload_1
    //   22: lload 4
    //   24: lcmp
    //   25: ifle +80 -> 105
    //   28: aload_0
    //   29: getfield 159	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploader:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   32: lload_1
    //   33: aload_0
    //   34: getfield 197	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploader:e	J
    //   37: lsub
    //   38: invokevirtual 203	java/io/InputStream:skip	(J)J
    //   41: pop2
    //   42: aload_0
    //   43: lload_1
    //   44: putfield 197	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploader:e	J
    //   47: aload_0
    //   48: getfield 34	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploader:jdField_a_of_type_Ajnh	Lajnh;
    //   51: aload_0
    //   52: getfield 96	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploader:d	J
    //   55: aload_0
    //   56: getfield 49	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploader:jdField_b_of_type_Long	J
    //   59: invokevirtual 206	ajnh:a	(JJ)I
    //   62: istore_3
    //   63: iload_3
    //   64: newarray byte
    //   66: astore 7
    //   68: aload_0
    //   69: getfield 159	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploader:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   72: aload 7
    //   74: iconst_0
    //   75: iload_3
    //   76: invokevirtual 210	java/io/InputStream:read	([BII)I
    //   79: pop
    //   80: aload_0
    //   81: getfield 197	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploader:e	J
    //   84: lstore_1
    //   85: aload_0
    //   86: iload_3
    //   87: i2l
    //   88: lload_1
    //   89: ladd
    //   90: putfield 197	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploader:e	J
    //   93: aload 7
    //   95: areturn
    //   96: astore 7
    //   98: aload 7
    //   100: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   103: aconst_null
    //   104: areturn
    //   105: lload_1
    //   106: aload_0
    //   107: getfield 197	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploader:e	J
    //   110: lcmp
    //   111: ifge -69 -> 42
    //   114: aload_0
    //   115: invokespecial 195	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploader:c	()Z
    //   118: istore 6
    //   120: iload 6
    //   122: ifeq +71 -> 193
    //   125: aload_0
    //   126: getfield 159	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploader:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   129: lload_1
    //   130: invokevirtual 203	java/io/InputStream:skip	(J)J
    //   133: pop2
    //   134: goto -92 -> 42
    //   137: astore 7
    //   139: aload_0
    //   140: aconst_null
    //   141: putfield 159	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploader:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   144: aload 7
    //   146: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   149: aconst_null
    //   150: areturn
    //   151: astore 7
    //   153: aload 7
    //   155: invokevirtual 214	java/lang/Exception:printStackTrace	()V
    //   158: ldc 109
    //   160: iconst_1
    //   161: new 114	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   168: ldc 216
    //   170: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload 7
    //   175: invokevirtual 217	java/lang/Exception:toString	()Ljava/lang/String;
    //   178: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aconst_null
    //   188: astore 7
    //   190: goto -97 -> 93
    //   193: aconst_null
    //   194: areturn
    //   195: astore 7
    //   197: aconst_null
    //   198: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	TroopFileUploader
    //   0	199	1	paramLong	long
    //   62	25	3	i	int
    //   19	4	4	l	long
    //   118	3	6	bool	boolean
    //   66	28	7	arrayOfByte	byte[]
    //   96	3	7	localIOException1	IOException
    //   137	8	7	localIOException2	IOException
    //   151	23	7	localException1	Exception
    //   188	1	7	localObject	Object
    //   195	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   28	42	96	java/io/IOException
    //   125	134	137	java/io/IOException
    //   68	93	151	java/lang/Exception
    //   6	13	195	java/lang/Exception
    //   15	21	195	java/lang/Exception
    //   28	42	195	java/lang/Exception
    //   42	68	195	java/lang/Exception
    //   98	103	195	java/lang/Exception
    //   105	120	195	java/lang/Exception
    //   125	134	195	java/lang/Exception
    //   139	149	195	java/lang/Exception
    //   153	187	195	java/lang/Exception
  }
  
  private void b(long paramLong, String paramString)
  {
    String str = "RangSizeError_rangError tSize[" + paramLong + "]<=mSize[" + this.d + "], lastRoolbackSize[" + this.jdField_c_of_type_Long + "], retry[" + this.jdField_a_of_type_Int + "]";
    TroopFileTransferUtil.Log.c("TroopFileUploader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] processRollback" + str);
    if (paramLong <= this.jdField_c_of_type_Long)
    {
      int i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      if (i > 6)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploader$ITroopFileUploaderSink.a(true, paramLong, str, paramString);
        return;
      }
    }
    this.jdField_c_of_type_Long = paramLong;
    this.d = paramLong;
    new Handler().postDelayed(new ajng(this), 6000L);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploader$ITroopFileUploaderSink.a(false, paramLong, str, paramString);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    TroopFileTransferUtil.Log.c("TroopFileUploader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] reSend mstrUrl:" + this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Ajnh = new ajnh(this);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploader$ITroopFileUploaderSink != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploader$ITroopFileUploaderSink.i();
    }
    this.d = 0L;
    a(0L);
  }
  
  private boolean c()
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
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController.a();
  }
  
  public long a()
  {
    return 6000L;
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFtnUploader.a();
      this.jdField_a_of_type_Boolean = true;
      TroopFileTransferUtil.Log.c("TroopFileUploader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] cancelTask");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(true, this.d, 9343, "parseDataErr", null);
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
        a(true, this.d, -29602, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-6101") > 0)
      {
        a(true, this.d, 9042, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-29120") > 0)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploader$ITroopFileUploaderSink.h();
        return;
      }
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      a(true, this.d, paramInt, paramString1, paramString2);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    TroopFileTransferUtil.Log.a("TroopFileUploader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] onErr errCode:" + paramInt + " errMsg:" + paramString1 + " rspHeader:" + paramString2);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController.a(this.jdField_b_of_type_JavaLangString, paramInt, false))
    {
      a(false, this.d, paramInt, paramString1, paramString2);
      return;
    }
    a(true, this.d, paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Ajnh.a();
    if (paramLong <= this.d)
    {
      b(paramLong, paramString);
      return;
    }
    if ((this.d == 0L) && (paramLong == this.jdField_b_of_type_Long))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploader$ITroopFileUploaderSink.f();
      return;
    }
    this.d = paramLong;
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileUploader", 2, "send http data size[" + String.valueOf(this.d) + "] fileSize[" + this.jdField_b_of_type_Long + "] success!");
    }
    if (paramLong < this.jdField_b_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploader$ITroopFileUploaderSink.a(paramLong);
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController.a(this.jdField_b_of_type_JavaLangString);
      }
      a(this.d);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploader$ITroopFileUploaderSink.g();
  }
  
  public void a(TroopFileUploader.ITroopFileUploaderSink paramITroopFileUploaderSink)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploader$ITroopFileUploaderSink = paramITroopFileUploaderSink;
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    paramHttpMsg.a("User-Agent", "TroopFile");
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(true, this.d, 9062, "UrlOver", null);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploader$ITroopFileUploaderSink.a(paramBoolean, paramLong, paramInt, paramString1, paramString2);
  }
  
  public boolean a()
  {
    TroopFileTransferUtil.Log.c("TroopFileUploader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] upload url:" + this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = false;
    return a(0L);
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploader$ITroopFileUploaderSink.f();
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      TroopFileTransferUtil.Log.c("TroopFileUploader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] onRetry but stoped");
      return;
    }
    int i = 0;
    if (!this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(paramString))
    {
      i = 1;
      TroopFileTransferUtil.Log.c("TroopFileUploader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] onRetry urlChanged");
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    if (i != 0)
    {
      paramString = TroopFileTransferUtil.a(this.jdField_b_of_type_JavaLangString);
      if (paramString != null)
      {
        this.jdField_c_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
        this.jdField_b_of_type_Int = paramString.jdField_a_of_type_Int;
        this.jdField_c_of_type_Int = paramString.jdField_b_of_type_Int;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploader$ITroopFileUploaderSink.a(this.jdField_b_of_type_JavaLangString);
    }
    c();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController.a();
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploader
 * JD-Core Version:    0.7.0.1
 */