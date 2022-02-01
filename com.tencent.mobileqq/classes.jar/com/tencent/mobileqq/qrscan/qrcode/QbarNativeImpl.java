package com.tencent.mobileqq.qrscan.qrcode;

import com.tencent.mobileqq.qrscan.QBarConstants.Reader;
import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.config.ScannerQQCodeConfBean;
import com.tencent.mobileqq.qrscan.config.ScannerQQCodeConfProcessor;
import com.tencent.mobileqq.qrscan.earlydown.QBarModelLoader;
import com.tencent.mobileqq.qrscan.ipc.QRScanResHelper;
import com.tencent.mobileqq.qrscan.minicode.MiniCodeUtil;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.QbarNative.QbarAiModelParam;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class QbarNativeImpl
{
  public static final QBarConstants.Reader a = new QBarConstants.Reader(new int[] { 1 });
  public static final QBarConstants.Reader b = new QBarConstants.Reader(new int[] { 2 });
  public static final QBarConstants.Reader c = new QBarConstants.Reader(new int[] { 2, 1 });
  public static QbarNative d;
  public static QbarNative e;
  private static int f = -1;
  private static int g = -1;
  private static int h;
  private static String i;
  private static String j;
  private static QBarConstants.Reader k;
  private static int l = 0;
  private static boolean m = false;
  
  public static int a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, String.format("Init searchMode=%s scanMode=%s inputCharset=%s outputCharset=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 }));
      }
      boolean bool = MiniCodeUtil.g();
      if (bool) {
        return -1;
      }
      if (paramInt2 == 1)
      {
        if (e != null)
        {
          m = true;
          l = 0;
          e();
        }
        if ((d == null) || (f < 0))
        {
          d = new QbarNative();
          f = d.init(paramInt1, 1, paramString1, paramString2, a(d));
        }
        paramInt1 = f;
      }
      else
      {
        if ((e == null) || (g < 0))
        {
          e = new QbarNative();
          g = e.init(paramInt1, 0, paramString1, paramString2, a(e));
          h = paramInt1;
          i = paramString1;
          j = paramString2;
          m = false;
        }
        paramInt1 = g;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, String.format("Init result=%s ", new Object[] { Integer.valueOf(paramInt1) }));
      }
      return paramInt1;
    }
    finally {}
  }
  
  public static int a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "InitForFile.");
      }
      paramInt = a(paramInt, 1, paramString1, paramString2);
      return paramInt;
    }
    finally {}
  }
  
  public static int a(QBarConstants.Reader paramReader)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "SetReadersForFile.");
      }
      int n = a(paramReader, 1);
      return n;
    }
    finally {}
  }
  
  private static int a(QBarConstants.Reader paramReader, int paramInt)
  {
    try
    {
      int[] arrayOfInt = paramReader.a();
      int n = paramReader.b();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SetReaders. sInitResult=");
        localStringBuilder.append(f);
        localStringBuilder.append(" sQbarNative=");
        localStringBuilder.append(d);
        localStringBuilder.append(" sInitResultForCamera=");
        localStringBuilder.append(g);
        localStringBuilder.append(" sQbarNativeForCamera=");
        localStringBuilder.append(e);
        localStringBuilder.append(" scanMode=");
        localStringBuilder.append(paramInt);
        QLog.d("QbarNativeImpl", 2, localStringBuilder.toString());
      }
      if (paramInt == 1)
      {
        if (d == null)
        {
          paramInt = f;
          return paramInt;
        }
        paramInt = d.setReaders(arrayOfInt, n);
        return paramInt;
      }
      if (e == null)
      {
        paramInt = g;
        return paramInt;
      }
      k = paramReader;
      paramInt = e.setReaders(arrayOfInt, n);
      return paramInt;
    }
    finally {}
  }
  
  public static int a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "GetOneResultForFile.");
      }
      int n = a(paramStringBuilder1, paramStringBuilder2, 1);
      return n;
    }
    finally {}
  }
  
  /* Error */
  private static int a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +94 -> 100
    //   9: new 120	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   16: astore_3
    //   17: aload_3
    //   18: ldc 161
    //   20: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_3
    //   25: getstatic 38	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:f	I
    //   28: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_3
    //   33: ldc 132
    //   35: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_3
    //   40: getstatic 84	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:d	Lcom/tencent/qbar/QbarNative;
    //   43: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_3
    //   48: ldc 137
    //   50: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: getstatic 40	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:g	I
    //   58: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_3
    //   63: ldc 139
    //   65: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_3
    //   70: getstatic 79	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:e	Lcom/tencent/qbar/QbarNative;
    //   73: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_3
    //   78: ldc 141
    //   80: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_3
    //   85: iload_2
    //   86: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: ldc 56
    //   92: iconst_2
    //   93: aload_3
    //   94: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: iload_2
    //   101: iconst_1
    //   102: if_icmpne +18 -> 120
    //   105: getstatic 84	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:d	Lcom/tencent/qbar/QbarNative;
    //   108: ifnonnull +27 -> 135
    //   111: getstatic 38	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:f	I
    //   114: istore_2
    //   115: ldc 2
    //   117: monitorexit
    //   118: iload_2
    //   119: ireturn
    //   120: getstatic 79	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:e	Lcom/tencent/qbar/QbarNative;
    //   123: ifnonnull +12 -> 135
    //   126: getstatic 40	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:g	I
    //   129: istore_2
    //   130: ldc 2
    //   132: monitorexit
    //   133: iload_2
    //   134: ireturn
    //   135: iload_2
    //   136: iconst_1
    //   137: if_icmpne +15 -> 152
    //   140: getstatic 84	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:d	Lcom/tencent/qbar/QbarNative;
    //   143: aload_0
    //   144: aload_1
    //   145: invokevirtual 164	com/tencent/qbar/QbarNative:GetOneResult	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   148: istore_2
    //   149: goto +12 -> 161
    //   152: getstatic 79	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:e	Lcom/tencent/qbar/QbarNative;
    //   155: aload_0
    //   156: aload_1
    //   157: invokevirtual 164	com/tencent/qbar/QbarNative:GetOneResult	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   160: istore_2
    //   161: ldc 2
    //   163: monitorexit
    //   164: iload_2
    //   165: ireturn
    //   166: astore_3
    //   167: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +54 -> 224
    //   173: new 120	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   180: astore 4
    //   182: aload 4
    //   184: ldc 166
    //   186: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 4
    //   192: aload_0
    //   193: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 4
    //   199: ldc 168
    //   201: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 4
    //   207: aload_1
    //   208: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: ldc 56
    //   214: iconst_2
    //   215: aload 4
    //   217: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: aload_3
    //   221: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   224: ldc 2
    //   226: monitorexit
    //   227: iconst_0
    //   228: ireturn
    //   229: astore_0
    //   230: ldc 2
    //   232: monitorexit
    //   233: aload_0
    //   234: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	paramStringBuilder1	StringBuilder
    //   0	235	1	paramStringBuilder2	StringBuilder
    //   0	235	2	paramInt	int
    //   16	78	3	localStringBuilder1	StringBuilder
    //   166	55	3	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   180	36	4	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   140	149	166	java/lang/UnsatisfiedLinkError
    //   152	161	166	java/lang/UnsatisfiedLinkError
    //   3	100	229	finally
    //   105	115	229	finally
    //   120	130	229	finally
    //   140	149	229	finally
    //   152	161	229	finally
    //   167	224	229	finally
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "ScanImageForFile.");
      }
      paramInt1 = a(paramArrayOfByte, paramInt1, paramInt2, 1);
      return paramInt1;
    }
    finally {}
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ScanImage. sInitResult=");
        localStringBuilder.append(f);
        localStringBuilder.append(" sQbarNative=");
        localStringBuilder.append(d);
        localStringBuilder.append(" sInitResultForCamera=");
        localStringBuilder.append(g);
        localStringBuilder.append(" sQbarNativeForCamera=");
        localStringBuilder.append(e);
        localStringBuilder.append(" scanMode=");
        localStringBuilder.append(paramInt3);
        QLog.d("QbarNativeImpl", 2, localStringBuilder.toString());
      }
      if (!a(paramInt1, paramInt2))
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("ScanImage in limit size, return. width=");
        paramArrayOfByte.append(paramInt1);
        paramArrayOfByte.append(" height=");
        paramArrayOfByte.append(paramInt2);
        QLog.i("QbarNativeImpl", 1, paramArrayOfByte.toString());
        return -1;
      }
      if (paramInt3 == 1)
      {
        if (d == null)
        {
          paramInt1 = f;
          return paramInt1;
        }
        paramInt1 = d.scanImage(paramArrayOfByte, paramInt1, paramInt2);
      }
      else
      {
        if (e == null)
        {
          paramInt1 = g;
          return paramInt1;
        }
        paramInt1 = e.scanImage(paramArrayOfByte, paramInt1, paramInt2);
      }
      if (paramInt1 < 0) {
        return -1;
      }
      return 1;
    }
    finally {}
  }
  
  private static QbarNative.QbarAiModelParam a(QbarNative paramQbarNative)
  {
    QbarNative.QbarAiModelParam localQbarAiModelParam = new QbarNative.QbarAiModelParam();
    localQbarAiModelParam.detect_model_bin_path_ = "";
    localQbarAiModelParam.detect_model_param_path_ = "";
    localQbarAiModelParam.superresolution_model_bin_path_ = "";
    localQbarAiModelParam.superresolution_model_param_path_ = "";
    boolean bool1 = ScannerQQCodeConfProcessor.a().a;
    boolean bool2 = QBarModelLoader.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("withQbarAiModelInit isAIModelFileReady=");
    localStringBuilder.append(bool2);
    localStringBuilder.append(", useQBarAIModel=");
    localStringBuilder.append(bool1);
    QLog.i("QbarNativeImpl", 1, localStringBuilder.toString());
    if ((bool1) && (bool2))
    {
      paramQbarNative = new StringBuilder();
      paramQbarNative.append(QBarModelLoader.a());
      paramQbarNative.append(File.separator);
      paramQbarNative.append(QBarModelLoader.a("detect_model.bin"));
      localQbarAiModelParam.detect_model_bin_path_ = paramQbarNative.toString();
      paramQbarNative = new StringBuilder();
      paramQbarNative.append(QBarModelLoader.a());
      paramQbarNative.append(File.separator);
      paramQbarNative.append(QBarModelLoader.a("detect_model.param"));
      localQbarAiModelParam.detect_model_param_path_ = paramQbarNative.toString();
      paramQbarNative = new StringBuilder();
      paramQbarNative.append(QBarModelLoader.a());
      paramQbarNative.append(File.separator);
      paramQbarNative.append(QBarModelLoader.a("srnet.bin"));
      localQbarAiModelParam.superresolution_model_bin_path_ = paramQbarNative.toString();
      paramQbarNative = new StringBuilder();
      paramQbarNative.append(QBarModelLoader.a());
      paramQbarNative.append(File.separator);
      paramQbarNative.append(QBarModelLoader.a("srnet.param"));
      localQbarAiModelParam.superresolution_model_param_path_ = paramQbarNative.toString();
      return localQbarAiModelParam;
    }
    if (!bool2)
    {
      QRScanResHelper.a().a(paramQbarNative);
      QRScanResHelper.a().a(3);
    }
    return localQbarAiModelParam;
  }
  
  public static ArrayList<QBarResult> a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "GetResult.");
      }
      ArrayList localArrayList = a(1);
      return localArrayList;
    }
    finally {}
  }
  
  /* Error */
  private static ArrayList<QBarResult> a(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +95 -> 101
    //   9: new 120	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   16: astore_1
    //   17: aload_1
    //   18: ldc_w 267
    //   21: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_1
    //   26: getstatic 38	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:f	I
    //   29: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_1
    //   34: ldc 132
    //   36: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_1
    //   41: getstatic 84	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:d	Lcom/tencent/qbar/QbarNative;
    //   44: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_1
    //   49: ldc 137
    //   51: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_1
    //   56: getstatic 40	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:g	I
    //   59: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_1
    //   64: ldc 139
    //   66: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_1
    //   71: getstatic 79	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:e	Lcom/tencent/qbar/QbarNative;
    //   74: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_1
    //   79: ldc 141
    //   81: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_1
    //   86: iload_0
    //   87: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: ldc 56
    //   93: iconst_2
    //   94: aload_1
    //   95: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: iload_0
    //   102: iconst_1
    //   103: if_icmpne +16 -> 119
    //   106: getstatic 84	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:d	Lcom/tencent/qbar/QbarNative;
    //   109: astore_1
    //   110: aload_1
    //   111: ifnonnull +21 -> 132
    //   114: ldc 2
    //   116: monitorexit
    //   117: aconst_null
    //   118: areturn
    //   119: getstatic 79	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:e	Lcom/tencent/qbar/QbarNative;
    //   122: astore_1
    //   123: aload_1
    //   124: ifnonnull +8 -> 132
    //   127: ldc 2
    //   129: monitorexit
    //   130: aconst_null
    //   131: areturn
    //   132: iload_0
    //   133: iconst_1
    //   134: if_icmpne +14 -> 148
    //   137: getstatic 84	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:d	Lcom/tencent/qbar/QbarNative;
    //   140: iconst_3
    //   141: invokevirtual 270	com/tencent/qbar/QbarNative:GetResults	(I)Ljava/util/ArrayList;
    //   144: astore_1
    //   145: goto +11 -> 156
    //   148: getstatic 79	com/tencent/mobileqq/qrscan/qrcode/QbarNativeImpl:e	Lcom/tencent/qbar/QbarNative;
    //   151: iconst_3
    //   152: invokevirtual 270	com/tencent/qbar/QbarNative:GetResults	(I)Ljava/util/ArrayList;
    //   155: astore_1
    //   156: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +35 -> 194
    //   162: new 120	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   169: astore_2
    //   170: aload_2
    //   171: ldc_w 272
    //   174: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_2
    //   179: aload_1
    //   180: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: ldc 56
    //   186: iconst_2
    //   187: aload_2
    //   188: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: ldc 2
    //   196: monitorexit
    //   197: aload_1
    //   198: areturn
    //   199: astore_1
    //   200: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq +36 -> 239
    //   206: new 120	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   213: astore_2
    //   214: aload_2
    //   215: ldc_w 274
    //   218: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_2
    //   223: iload_0
    //   224: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: ldc 56
    //   230: iconst_2
    //   231: aload_2
    //   232: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: aload_1
    //   236: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   239: ldc 2
    //   241: monitorexit
    //   242: aconst_null
    //   243: areturn
    //   244: astore_1
    //   245: ldc 2
    //   247: monitorexit
    //   248: aload_1
    //   249: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	paramInt	int
    //   16	182	1	localObject1	Object
    //   199	37	1	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   244	5	1	localObject2	Object
    //   169	63	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   137	145	199	java/lang/UnsatisfiedLinkError
    //   148	156	199	java/lang/UnsatisfiedLinkError
    //   156	194	199	java/lang/UnsatisfiedLinkError
    //   3	101	244	finally
    //   106	110	244	finally
    //   119	123	244	finally
    //   137	145	244	finally
    //   148	156	244	finally
    //   156	194	244	finally
    //   200	239	244	finally
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 20) && (paramInt2 >= 20) && ((paramInt1 >= 32) || (paramInt2 >= 32))) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isValidScanImageSize false, in limit size. width=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" height=");
    localStringBuilder.append(paramInt2);
    QLog.i("QbarNativeImpl", 1, localStringBuilder.toString());
    return false;
  }
  
  private static int b(int paramInt)
  {
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Release. sInitResult=");
          localStringBuilder.append(f);
          localStringBuilder.append(" sQbarNative=");
          localStringBuilder.append(d);
          localStringBuilder.append(" sInitResultForCamera=");
          localStringBuilder.append(g);
          localStringBuilder.append(" sQbarNativeForCamera=");
          localStringBuilder.append(e);
          QLog.d("QbarNativeImpl", 2, localStringBuilder.toString());
        }
        if (paramInt == 1)
        {
          if (d == null) {
            break label285;
          }
          QRScanResHelper.a().b(d);
          paramInt = d.release();
          d = null;
          f = -1;
        }
        else
        {
          if (e == null) {
            break label285;
          }
          QRScanResHelper.a().b(e);
          int n = e.release();
          e = null;
          g = -1;
          paramInt = n;
          if (!m)
          {
            h = -1;
            i = null;
            j = null;
            k = null;
            l = 0;
            paramInt = n;
          }
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Release. After release. sInitResult=");
          localStringBuilder.append(f);
          localStringBuilder.append(" sQbarNative=");
          localStringBuilder.append(d);
          localStringBuilder.append(" sInitResultForCamera=");
          localStringBuilder.append(g);
          localStringBuilder.append(" sQbarNativeForCamera=");
          localStringBuilder.append(e);
          QLog.d("QbarNativeImpl", 2, localStringBuilder.toString());
        }
        return paramInt;
      }
      finally {}
      label285:
      paramInt = -1;
    }
  }
  
  public static int b(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "InitForCamera.");
      }
      paramInt = a(paramInt, 0, paramString1, paramString2);
      return paramInt;
    }
    finally {}
  }
  
  public static int b(QBarConstants.Reader paramReader)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "SetReadersForCamera.");
      }
      int n = a(paramReader, 0);
      return n;
    }
    finally {}
  }
  
  public static int b(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "GetOneResultForCamera.");
      }
      int n = a(paramStringBuilder1, paramStringBuilder2, 0);
      return n;
    }
    finally {}
  }
  
  public static int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "ScanImageForCamera.");
      }
      if (m)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ScanImageForCamera restore before. sInitResult=");
          localStringBuilder.append(f);
          localStringBuilder.append(" sQbarNative=");
          localStringBuilder.append(d);
          localStringBuilder.append(" sInitResultForCamera=");
          localStringBuilder.append(g);
          localStringBuilder.append(" sQbarNativeForCamera=");
          localStringBuilder.append(e);
          localStringBuilder.append(" sCameraRestoreSkipTimes=");
          localStringBuilder.append(l);
          QLog.d("QbarNativeImpl", 2, localStringBuilder.toString());
        }
        if (e == null) {
          if ((d != null) && (l < 3))
          {
            l += 1;
          }
          else if ((i != null) && (j != null) && (k != null))
          {
            b(h, i, j);
            b(k);
          }
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ScanImageForCamera restore after. sInitResult=");
          localStringBuilder.append(f);
          localStringBuilder.append(" sQbarNative=");
          localStringBuilder.append(d);
          localStringBuilder.append(" sInitResultForCamera=");
          localStringBuilder.append(g);
          localStringBuilder.append(" sQbarNativeForCamera=");
          localStringBuilder.append(e);
          localStringBuilder.append(" sCameraRestoreSkipTimes=");
          localStringBuilder.append(l);
          QLog.d("QbarNativeImpl", 2, localStringBuilder.toString());
        }
      }
      paramInt1 = a(paramArrayOfByte, paramInt1, paramInt2, 0);
      return paramInt1;
    }
    finally {}
  }
  
  public static ArrayList<QBarResult> b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "GetResultForCamera.");
      }
      ArrayList localArrayList = a(0);
      return localArrayList;
    }
    finally {}
  }
  
  public static String c()
  {
    try
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("GetVersion. sInitResult=");
        ((StringBuilder)localObject1).append(f);
        ((StringBuilder)localObject1).append(" sQbarNative=");
        ((StringBuilder)localObject1).append(d);
        ((StringBuilder)localObject1).append(" sInitResultForCamera=");
        ((StringBuilder)localObject1).append(g);
        ((StringBuilder)localObject1).append(" sQbarNativeForCamera=");
        ((StringBuilder)localObject1).append(e);
        QLog.d("QbarNativeImpl", 2, ((StringBuilder)localObject1).toString());
      }
      if (d != null)
      {
        localObject1 = d;
        localObject1 = QbarNative.getVersion();
        return localObject1;
      }
      if (e != null)
      {
        localObject1 = e;
        localObject1 = QbarNative.getVersion();
        return localObject1;
      }
      return "";
    }
    finally {}
  }
  
  public static int d()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "ReleaseForFile.");
      }
      int n = b(1);
      return n;
    }
    finally {}
  }
  
  public static int e()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "ReleaseForCamera.");
      }
      int n = b(0);
      return n;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.qrcode.QbarNativeImpl
 * JD-Core Version:    0.7.0.1
 */