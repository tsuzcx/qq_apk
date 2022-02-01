package com.tencent.qqmini.sdk.core.utils;

import android.os.Parcel;

public class ParcelableUtil
{
  private static final String TAG = "ParcelableUtil";
  
  /* Error */
  public static <T extends android.os.Parcelable> T readParcelableFromFile(java.lang.Class paramClass, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 25	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 28	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_1
    //   18: aload_1
    //   19: invokevirtual 32	java/io/File:exists	()Z
    //   22: ifne +5 -> 27
    //   25: aconst_null
    //   26: areturn
    //   27: new 34	java/io/FileInputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 37	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: astore_3
    //   36: aload_3
    //   37: astore_1
    //   38: aload_3
    //   39: invokevirtual 41	java/io/FileInputStream:available	()I
    //   42: istore_2
    //   43: aload_3
    //   44: astore_1
    //   45: iload_2
    //   46: newarray byte
    //   48: astore 4
    //   50: aload_3
    //   51: astore_1
    //   52: aload_3
    //   53: aload 4
    //   55: iconst_0
    //   56: iload_2
    //   57: invokevirtual 45	java/io/FileInputStream:read	([BII)I
    //   60: pop
    //   61: aload 4
    //   63: invokestatic 49	com/tencent/qqmini/sdk/core/utils/ParcelableUtil:unmarshall	([B)Landroid/os/Parcel;
    //   66: astore 4
    //   68: aload 4
    //   70: astore_1
    //   71: aload 4
    //   73: aload_0
    //   74: invokevirtual 55	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   77: invokevirtual 61	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   80: astore_0
    //   81: aload 4
    //   83: ifnull +10 -> 93
    //   86: aload_3
    //   87: astore_1
    //   88: aload 4
    //   90: invokevirtual 64	android/os/Parcel:recycle	()V
    //   93: aload_3
    //   94: invokevirtual 67	java/io/FileInputStream:close	()V
    //   97: aload_0
    //   98: areturn
    //   99: astore_1
    //   100: ldc 8
    //   102: ldc 69
    //   104: aload_1
    //   105: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_0
    //   109: areturn
    //   110: astore 4
    //   112: aload_1
    //   113: astore_0
    //   114: goto +51 -> 165
    //   117: astore_1
    //   118: aload 4
    //   120: astore_0
    //   121: aload_1
    //   122: astore 4
    //   124: goto +14 -> 138
    //   127: astore 4
    //   129: aconst_null
    //   130: astore_0
    //   131: goto +34 -> 165
    //   134: astore 4
    //   136: aconst_null
    //   137: astore_0
    //   138: aload_0
    //   139: astore_1
    //   140: ldc 8
    //   142: ldc 69
    //   144: aload 4
    //   146: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   149: aload_0
    //   150: ifnull +9 -> 159
    //   153: aload_3
    //   154: astore_1
    //   155: aload_0
    //   156: invokevirtual 64	android/os/Parcel:recycle	()V
    //   159: aload_3
    //   160: invokevirtual 67	java/io/FileInputStream:close	()V
    //   163: aconst_null
    //   164: areturn
    //   165: aload_0
    //   166: ifnull +9 -> 175
    //   169: aload_3
    //   170: astore_1
    //   171: aload_0
    //   172: invokevirtual 64	android/os/Parcel:recycle	()V
    //   175: aload_3
    //   176: astore_1
    //   177: aload 4
    //   179: athrow
    //   180: astore 4
    //   182: aload_3
    //   183: astore_0
    //   184: goto +13 -> 197
    //   187: astore_0
    //   188: aconst_null
    //   189: astore_1
    //   190: goto +40 -> 230
    //   193: astore 4
    //   195: aconst_null
    //   196: astore_0
    //   197: aload_0
    //   198: astore_1
    //   199: ldc 8
    //   201: ldc 69
    //   203: aload 4
    //   205: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   208: aload_0
    //   209: ifnull +18 -> 227
    //   212: aload_0
    //   213: invokevirtual 67	java/io/FileInputStream:close	()V
    //   216: aconst_null
    //   217: areturn
    //   218: astore_0
    //   219: ldc 8
    //   221: ldc 69
    //   223: aload_0
    //   224: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   227: aconst_null
    //   228: areturn
    //   229: astore_0
    //   230: aload_1
    //   231: ifnull +19 -> 250
    //   234: aload_1
    //   235: invokevirtual 67	java/io/FileInputStream:close	()V
    //   238: goto +12 -> 250
    //   241: astore_1
    //   242: ldc 8
    //   244: ldc 69
    //   246: aload_1
    //   247: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   250: aload_0
    //   251: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramClass	java.lang.Class
    //   0	252	1	paramString	String
    //   42	15	2	i	int
    //   35	148	3	localFileInputStream	java.io.FileInputStream
    //   48	41	4	localObject1	Object
    //   110	9	4	localObject2	Object
    //   122	1	4	str	String
    //   127	1	4	localObject3	Object
    //   134	44	4	localThrowable1	java.lang.Throwable
    //   180	1	4	localThrowable2	java.lang.Throwable
    //   193	11	4	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   93	97	99	java/lang/Throwable
    //   71	81	110	finally
    //   140	149	110	finally
    //   71	81	117	java/lang/Throwable
    //   61	68	127	finally
    //   61	68	134	java/lang/Throwable
    //   38	43	180	java/lang/Throwable
    //   45	50	180	java/lang/Throwable
    //   52	61	180	java/lang/Throwable
    //   88	93	180	java/lang/Throwable
    //   155	159	180	java/lang/Throwable
    //   171	175	180	java/lang/Throwable
    //   177	180	180	java/lang/Throwable
    //   9	25	187	finally
    //   27	36	187	finally
    //   9	25	193	java/lang/Throwable
    //   27	36	193	java/lang/Throwable
    //   159	163	218	java/lang/Throwable
    //   212	216	218	java/lang/Throwable
    //   38	43	229	finally
    //   45	50	229	finally
    //   52	61	229	finally
    //   88	93	229	finally
    //   155	159	229	finally
    //   171	175	229	finally
    //   177	180	229	finally
    //   199	208	229	finally
    //   234	238	241	java/lang/Throwable
  }
  
  public static Parcel unmarshall(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    if (paramArrayOfByte == null) {
      return localParcel;
    }
    try
    {
      localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      localParcel.setDataPosition(0);
      return localParcel;
    }
    catch (Exception paramArrayOfByte) {}
    return localParcel;
  }
  
  /* Error */
  public static boolean writeParcelableToFile(android.os.Parcelable paramParcelable, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +298 -> 299
    //   4: aload_1
    //   5: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aconst_null
    //   14: astore 4
    //   16: aconst_null
    //   17: astore_2
    //   18: aconst_null
    //   19: astore 6
    //   21: aconst_null
    //   22: astore 5
    //   24: invokestatic 83	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   27: astore_3
    //   28: aload_3
    //   29: aload_0
    //   30: iconst_0
    //   31: invokevirtual 96	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   34: aload_3
    //   35: invokevirtual 100	android/os/Parcel:marshall	()[B
    //   38: astore_2
    //   39: aload 5
    //   41: astore_0
    //   42: new 25	java/io/File
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 28	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore_1
    //   51: aload 5
    //   53: astore_0
    //   54: aload_1
    //   55: invokevirtual 104	java/io/File:getParentFile	()Ljava/io/File;
    //   58: astore 6
    //   60: aload 5
    //   62: astore_0
    //   63: aload 6
    //   65: invokevirtual 32	java/io/File:exists	()Z
    //   68: ifeq +14 -> 82
    //   71: aload 5
    //   73: astore_0
    //   74: aload 6
    //   76: invokevirtual 107	java/io/File:isDirectory	()Z
    //   79: ifne +12 -> 91
    //   82: aload 5
    //   84: astore_0
    //   85: aload 6
    //   87: invokevirtual 110	java/io/File:mkdirs	()Z
    //   90: pop
    //   91: aload 5
    //   93: astore_0
    //   94: aload_1
    //   95: invokevirtual 32	java/io/File:exists	()Z
    //   98: ifeq +13 -> 111
    //   101: aload 5
    //   103: astore_0
    //   104: aload_1
    //   105: invokevirtual 113	java/io/File:isFile	()Z
    //   108: ifne +11 -> 119
    //   111: aload 5
    //   113: astore_0
    //   114: aload_1
    //   115: invokevirtual 116	java/io/File:createNewFile	()Z
    //   118: pop
    //   119: aload 5
    //   121: astore_0
    //   122: new 118	java/io/FileOutputStream
    //   125: dup
    //   126: aload_1
    //   127: iconst_0
    //   128: invokespecial 121	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   131: astore_1
    //   132: aload_1
    //   133: aload_2
    //   134: invokevirtual 125	java/io/FileOutputStream:write	([B)V
    //   137: aload_1
    //   138: invokevirtual 128	java/io/FileOutputStream:flush	()V
    //   141: aload_1
    //   142: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   145: goto +12 -> 157
    //   148: astore_0
    //   149: ldc 8
    //   151: ldc 131
    //   153: aload_0
    //   154: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   157: aload_3
    //   158: ifnull +7 -> 165
    //   161: aload_3
    //   162: invokevirtual 64	android/os/Parcel:recycle	()V
    //   165: iconst_1
    //   166: ireturn
    //   167: astore_2
    //   168: aload_1
    //   169: astore_0
    //   170: aload_2
    //   171: astore_1
    //   172: goto +55 -> 227
    //   175: astore_2
    //   176: goto +11 -> 187
    //   179: astore_1
    //   180: goto +47 -> 227
    //   183: astore_2
    //   184: aload 4
    //   186: astore_1
    //   187: aload_1
    //   188: astore_0
    //   189: ldc 8
    //   191: ldc 131
    //   193: aload_2
    //   194: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   197: aload_1
    //   198: ifnull +19 -> 217
    //   201: aload_1
    //   202: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   205: goto +12 -> 217
    //   208: astore_0
    //   209: ldc 8
    //   211: ldc 131
    //   213: aload_0
    //   214: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   217: aload_3
    //   218: ifnull +69 -> 287
    //   221: aload_3
    //   222: invokevirtual 64	android/os/Parcel:recycle	()V
    //   225: iconst_0
    //   226: ireturn
    //   227: aload_0
    //   228: ifnull +19 -> 247
    //   231: aload_0
    //   232: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   235: goto +12 -> 247
    //   238: astore_0
    //   239: ldc 8
    //   241: ldc 131
    //   243: aload_0
    //   244: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   247: aload_1
    //   248: athrow
    //   249: astore_0
    //   250: goto +39 -> 289
    //   253: astore_1
    //   254: aload_3
    //   255: astore_0
    //   256: goto +13 -> 269
    //   259: astore_0
    //   260: aload_2
    //   261: astore_3
    //   262: goto +27 -> 289
    //   265: astore_1
    //   266: aload 6
    //   268: astore_0
    //   269: aload_0
    //   270: astore_2
    //   271: ldc 8
    //   273: ldc 131
    //   275: aload_1
    //   276: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   279: aload_0
    //   280: ifnull +7 -> 287
    //   283: aload_0
    //   284: invokevirtual 64	android/os/Parcel:recycle	()V
    //   287: iconst_0
    //   288: ireturn
    //   289: aload_3
    //   290: ifnull +7 -> 297
    //   293: aload_3
    //   294: invokevirtual 64	android/os/Parcel:recycle	()V
    //   297: aload_0
    //   298: athrow
    //   299: iconst_0
    //   300: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramParcelable	android.os.Parcelable
    //   0	301	1	paramString	String
    //   17	117	2	arrayOfByte	byte[]
    //   167	4	2	localObject1	Object
    //   175	1	2	localThrowable1	java.lang.Throwable
    //   183	78	2	localThrowable2	java.lang.Throwable
    //   270	1	2	localParcelable	android.os.Parcelable
    //   27	267	3	localObject2	Object
    //   14	171	4	localObject3	Object
    //   22	98	5	localObject4	Object
    //   19	248	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   141	145	148	java/lang/Throwable
    //   132	141	167	finally
    //   132	141	175	java/lang/Throwable
    //   42	51	179	finally
    //   54	60	179	finally
    //   63	71	179	finally
    //   74	82	179	finally
    //   85	91	179	finally
    //   94	101	179	finally
    //   104	111	179	finally
    //   114	119	179	finally
    //   122	132	179	finally
    //   189	197	179	finally
    //   42	51	183	java/lang/Throwable
    //   54	60	183	java/lang/Throwable
    //   63	71	183	java/lang/Throwable
    //   74	82	183	java/lang/Throwable
    //   85	91	183	java/lang/Throwable
    //   94	101	183	java/lang/Throwable
    //   104	111	183	java/lang/Throwable
    //   114	119	183	java/lang/Throwable
    //   122	132	183	java/lang/Throwable
    //   201	205	208	java/lang/Throwable
    //   231	235	238	java/lang/Throwable
    //   28	39	249	finally
    //   141	145	249	finally
    //   149	157	249	finally
    //   201	205	249	finally
    //   209	217	249	finally
    //   231	235	249	finally
    //   239	247	249	finally
    //   247	249	249	finally
    //   28	39	253	java/lang/Throwable
    //   149	157	253	java/lang/Throwable
    //   209	217	253	java/lang/Throwable
    //   239	247	253	java/lang/Throwable
    //   247	249	253	java/lang/Throwable
    //   24	28	259	finally
    //   271	279	259	finally
    //   24	28	265	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.ParcelableUtil
 * JD-Core Version:    0.7.0.1
 */