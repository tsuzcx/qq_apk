package com.tencent.mobileqq.conditionsearch.data;

public class AddressHelper
{
  /* Error */
  public static AddressData a(com.tencent.common.app.AppInterface paramAppInterface, java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 21	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +11 -> 16
    //   8: ldc 23
    //   10: iconst_2
    //   11: ldc 25
    //   13: invokestatic 29	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: new 31	java/io/FileInputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 34	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_2
    //   25: new 36	java/io/BufferedReader
    //   28: dup
    //   29: new 38	java/io/InputStreamReader
    //   32: dup
    //   33: aload_2
    //   34: invokespecial 41	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   37: invokespecial 44	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore 4
    //   42: aconst_null
    //   43: astore_1
    //   44: aload 4
    //   46: invokevirtual 48	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnull +203 -> 256
    //   56: aload_1
    //   57: ifnonnull +196 -> 253
    //   60: new 50	com/tencent/mobileqq/conditionsearch/data/AddressData
    //   63: dup
    //   64: invokespecial 51	com/tencent/mobileqq/conditionsearch/data/AddressData:<init>	()V
    //   67: astore_1
    //   68: aload_1
    //   69: aload_0
    //   70: aload 5
    //   72: invokevirtual 54	com/tencent/mobileqq/conditionsearch/data/AddressData:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;)Z
    //   75: ifne +80 -> 155
    //   78: invokestatic 21	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +11 -> 92
    //   84: ldc 23
    //   86: iconst_2
    //   87: ldc 56
    //   89: invokestatic 29	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_1
    //   93: astore_0
    //   94: aload 4
    //   96: invokevirtual 59	java/io/BufferedReader:close	()V
    //   99: aload_2
    //   100: invokevirtual 62	java/io/InputStream:close	()V
    //   103: invokestatic 21	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +11 -> 117
    //   109: ldc 23
    //   111: iconst_2
    //   112: ldc 64
    //   114: invokestatic 29	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload_0
    //   118: areturn
    //   119: astore_0
    //   120: aconst_null
    //   121: astore_1
    //   122: invokestatic 21	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +12 -> 137
    //   128: ldc 23
    //   130: iconst_2
    //   131: ldc 66
    //   133: aload_0
    //   134: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   137: new 71	java/lang/NullPointerException
    //   140: dup
    //   141: invokespecial 72	java/lang/NullPointerException:<init>	()V
    //   144: athrow
    //   145: astore_0
    //   146: aload_0
    //   147: invokevirtual 75	java/lang/Exception:printStackTrace	()V
    //   150: aconst_null
    //   151: areturn
    //   152: astore_0
    //   153: aload_0
    //   154: athrow
    //   155: goto -111 -> 44
    //   158: astore 5
    //   160: invokestatic 21	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq +13 -> 176
    //   166: ldc 23
    //   168: iconst_2
    //   169: ldc 77
    //   171: aload 5
    //   173: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   176: goto -132 -> 44
    //   179: astore_1
    //   180: aload_1
    //   181: invokevirtual 75	java/lang/Exception:printStackTrace	()V
    //   184: goto -81 -> 103
    //   187: astore_0
    //   188: invokestatic 21	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +12 -> 203
    //   194: ldc 23
    //   196: iconst_2
    //   197: ldc 79
    //   199: aload_0
    //   200: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   203: aload 4
    //   205: invokevirtual 59	java/io/BufferedReader:close	()V
    //   208: aload_2
    //   209: invokevirtual 62	java/io/InputStream:close	()V
    //   212: aload_3
    //   213: astore_0
    //   214: goto -111 -> 103
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 75	java/lang/Exception:printStackTrace	()V
    //   222: aload_3
    //   223: astore_0
    //   224: goto -121 -> 103
    //   227: astore_0
    //   228: aload 4
    //   230: invokevirtual 59	java/io/BufferedReader:close	()V
    //   233: aload_2
    //   234: invokevirtual 62	java/io/InputStream:close	()V
    //   237: aload_0
    //   238: athrow
    //   239: astore_1
    //   240: aload_1
    //   241: invokevirtual 75	java/lang/Exception:printStackTrace	()V
    //   244: goto -7 -> 237
    //   247: astore_0
    //   248: aload_2
    //   249: astore_1
    //   250: goto -128 -> 122
    //   253: goto -185 -> 68
    //   256: aload_1
    //   257: astore_0
    //   258: goto -164 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramAppInterface	com.tencent.common.app.AppInterface
    //   0	261	1	paramFile	java.io.File
    //   24	225	2	localFileInputStream	java.io.FileInputStream
    //   1	222	3	localObject	Object
    //   40	189	4	localBufferedReader	java.io.BufferedReader
    //   49	22	5	str	java.lang.String
    //   158	14	5	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   16	25	119	java/io/IOException
    //   137	145	145	java/lang/Exception
    //   16	25	152	finally
    //   25	42	152	finally
    //   122	137	152	finally
    //   68	92	158	java/lang/Exception
    //   94	103	179	java/lang/Exception
    //   44	51	187	java/lang/Exception
    //   60	68	187	java/lang/Exception
    //   160	176	187	java/lang/Exception
    //   203	212	217	java/lang/Exception
    //   44	51	227	finally
    //   60	68	227	finally
    //   68	92	227	finally
    //   160	176	227	finally
    //   188	203	227	finally
    //   228	237	239	java/lang/Exception
    //   25	42	247	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.data.AddressHelper
 * JD-Core Version:    0.7.0.1
 */