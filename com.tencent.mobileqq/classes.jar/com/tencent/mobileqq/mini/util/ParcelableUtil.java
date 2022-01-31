package com.tencent.mobileqq.mini.util;

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
    //   22: istore_3
    //   23: iload_3
    //   24: ifne +26 -> 50
    //   27: iconst_0
    //   28: ifeq -21 -> 7
    //   31: new 34	java/lang/NullPointerException
    //   34: dup
    //   35: invokespecial 35	java/lang/NullPointerException:<init>	()V
    //   38: athrow
    //   39: astore_0
    //   40: ldc 8
    //   42: ldc 37
    //   44: aload_0
    //   45: invokestatic 43	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   48: aconst_null
    //   49: areturn
    //   50: new 45	java/io/FileInputStream
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: astore 5
    //   60: aload 5
    //   62: invokevirtual 52	java/io/FileInputStream:available	()I
    //   65: istore_2
    //   66: iload_2
    //   67: newarray byte
    //   69: astore_1
    //   70: aload 5
    //   72: aload_1
    //   73: iconst_0
    //   74: iload_2
    //   75: invokevirtual 56	java/io/FileInputStream:read	([BII)I
    //   78: pop
    //   79: aload_1
    //   80: invokestatic 62	com/tencent/component/network/downloader/common/Utils:unmarshall	([B)Landroid/os/Parcel;
    //   83: astore 4
    //   85: aload 4
    //   87: astore_1
    //   88: aload 4
    //   90: aload_0
    //   91: invokevirtual 68	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   94: invokevirtual 74	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   97: astore_0
    //   98: aload 4
    //   100: ifnull +8 -> 108
    //   103: aload 4
    //   105: invokevirtual 77	android/os/Parcel:recycle	()V
    //   108: aload 5
    //   110: ifnull +8 -> 118
    //   113: aload 5
    //   115: invokevirtual 80	java/io/FileInputStream:close	()V
    //   118: aload_0
    //   119: areturn
    //   120: astore_1
    //   121: ldc 8
    //   123: ldc 37
    //   125: aload_1
    //   126: invokestatic 43	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: goto -11 -> 118
    //   132: astore_0
    //   133: aconst_null
    //   134: astore 4
    //   136: aload 4
    //   138: astore_1
    //   139: ldc 8
    //   141: ldc 37
    //   143: aload_0
    //   144: invokestatic 43	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   147: aload 4
    //   149: ifnull +8 -> 157
    //   152: aload 4
    //   154: invokevirtual 77	android/os/Parcel:recycle	()V
    //   157: aload 5
    //   159: ifnull -152 -> 7
    //   162: aload 5
    //   164: invokevirtual 80	java/io/FileInputStream:close	()V
    //   167: aconst_null
    //   168: areturn
    //   169: astore_0
    //   170: ldc 8
    //   172: ldc 37
    //   174: aload_0
    //   175: invokestatic 43	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   178: aconst_null
    //   179: areturn
    //   180: astore_0
    //   181: aconst_null
    //   182: astore_1
    //   183: aload_1
    //   184: ifnull +7 -> 191
    //   187: aload_1
    //   188: invokevirtual 77	android/os/Parcel:recycle	()V
    //   191: aload_0
    //   192: athrow
    //   193: astore_1
    //   194: aload 5
    //   196: astore_0
    //   197: ldc 8
    //   199: ldc 37
    //   201: aload_1
    //   202: invokestatic 43	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload_0
    //   206: ifnull -199 -> 7
    //   209: aload_0
    //   210: invokevirtual 80	java/io/FileInputStream:close	()V
    //   213: aconst_null
    //   214: areturn
    //   215: astore_0
    //   216: ldc 8
    //   218: ldc 37
    //   220: aload_0
    //   221: invokestatic 43	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   224: aconst_null
    //   225: areturn
    //   226: astore_0
    //   227: aconst_null
    //   228: astore_1
    //   229: aload_1
    //   230: ifnull +7 -> 237
    //   233: aload_1
    //   234: invokevirtual 80	java/io/FileInputStream:close	()V
    //   237: aload_0
    //   238: athrow
    //   239: astore_1
    //   240: ldc 8
    //   242: ldc 37
    //   244: aload_1
    //   245: invokestatic 43	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   248: goto -11 -> 237
    //   251: astore_0
    //   252: aload 5
    //   254: astore_1
    //   255: goto -26 -> 229
    //   258: astore 4
    //   260: aload_0
    //   261: astore_1
    //   262: aload 4
    //   264: astore_0
    //   265: goto -36 -> 229
    //   268: astore_1
    //   269: aconst_null
    //   270: astore_0
    //   271: goto -74 -> 197
    //   274: astore_0
    //   275: goto -92 -> 183
    //   278: astore_0
    //   279: goto -143 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramClass	java.lang.Class
    //   0	282	1	paramString	String
    //   65	10	2	i	int
    //   22	2	3	bool	boolean
    //   83	70	4	localParcel	android.os.Parcel
    //   258	5	4	localObject	Object
    //   58	195	5	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   31	39	39	java/lang/Throwable
    //   113	118	120	java/lang/Throwable
    //   79	85	132	java/lang/Throwable
    //   162	167	169	java/lang/Throwable
    //   79	85	180	finally
    //   60	79	193	java/lang/Throwable
    //   103	108	193	java/lang/Throwable
    //   152	157	193	java/lang/Throwable
    //   187	191	193	java/lang/Throwable
    //   191	193	193	java/lang/Throwable
    //   209	213	215	java/lang/Throwable
    //   9	23	226	finally
    //   50	60	226	finally
    //   233	237	239	java/lang/Throwable
    //   60	79	251	finally
    //   103	108	251	finally
    //   152	157	251	finally
    //   187	191	251	finally
    //   191	193	251	finally
    //   197	205	258	finally
    //   9	23	268	java/lang/Throwable
    //   50	60	268	java/lang/Throwable
    //   88	98	274	finally
    //   139	147	274	finally
    //   88	98	278	java/lang/Throwable
  }
  
  /* Error */
  public static boolean writeParcelableToFile(android.os.Parcelable paramParcelable, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: iconst_1
    //   9: istore_2
    //   10: aload_0
    //   11: ifnull +10 -> 21
    //   14: aload_1
    //   15: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +7 -> 25
    //   21: iconst_0
    //   22: istore_2
    //   23: iload_2
    //   24: ireturn
    //   25: invokestatic 88	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   28: astore 6
    //   30: aload 6
    //   32: astore_3
    //   33: aload_3
    //   34: aload_0
    //   35: iconst_0
    //   36: invokevirtual 92	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   39: aload_3
    //   40: invokevirtual 96	android/os/Parcel:marshall	()[B
    //   43: astore 6
    //   45: aload 5
    //   47: astore_0
    //   48: new 25	java/io/File
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 28	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore_1
    //   57: aload 5
    //   59: astore_0
    //   60: aload_1
    //   61: invokevirtual 100	java/io/File:getParentFile	()Ljava/io/File;
    //   64: astore 7
    //   66: aload 5
    //   68: astore_0
    //   69: aload 7
    //   71: invokevirtual 32	java/io/File:exists	()Z
    //   74: ifeq +14 -> 88
    //   77: aload 5
    //   79: astore_0
    //   80: aload 7
    //   82: invokevirtual 103	java/io/File:isDirectory	()Z
    //   85: ifne +12 -> 97
    //   88: aload 5
    //   90: astore_0
    //   91: aload 7
    //   93: invokevirtual 106	java/io/File:mkdirs	()Z
    //   96: pop
    //   97: aload 5
    //   99: astore_0
    //   100: aload_1
    //   101: invokevirtual 32	java/io/File:exists	()Z
    //   104: ifeq +13 -> 117
    //   107: aload 5
    //   109: astore_0
    //   110: aload_1
    //   111: invokevirtual 109	java/io/File:isFile	()Z
    //   114: ifne +11 -> 125
    //   117: aload 5
    //   119: astore_0
    //   120: aload_1
    //   121: invokevirtual 112	java/io/File:createNewFile	()Z
    //   124: pop
    //   125: aload 5
    //   127: astore_0
    //   128: new 114	java/io/FileOutputStream
    //   131: dup
    //   132: aload_1
    //   133: iconst_0
    //   134: invokespecial 117	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   137: astore_1
    //   138: aload_1
    //   139: aload 6
    //   141: invokevirtual 121	java/io/FileOutputStream:write	([B)V
    //   144: aload_1
    //   145: invokevirtual 124	java/io/FileOutputStream:flush	()V
    //   148: aload_1
    //   149: ifnull +7 -> 156
    //   152: aload_1
    //   153: invokevirtual 125	java/io/FileOutputStream:close	()V
    //   156: aload_3
    //   157: ifnull -134 -> 23
    //   160: aload_3
    //   161: invokevirtual 77	android/os/Parcel:recycle	()V
    //   164: iconst_1
    //   165: ireturn
    //   166: astore_0
    //   167: ldc 8
    //   169: iconst_1
    //   170: ldc 127
    //   172: aload_0
    //   173: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   176: goto -20 -> 156
    //   179: astore_1
    //   180: aload_3
    //   181: astore_0
    //   182: ldc 8
    //   184: iconst_1
    //   185: ldc 127
    //   187: aload_1
    //   188: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   191: aload_0
    //   192: ifnull +7 -> 199
    //   195: aload_0
    //   196: invokevirtual 77	android/os/Parcel:recycle	()V
    //   199: iconst_0
    //   200: ireturn
    //   201: astore_0
    //   202: aload 4
    //   204: astore_1
    //   205: aload_0
    //   206: astore 4
    //   208: aload_1
    //   209: astore_0
    //   210: ldc 8
    //   212: iconst_1
    //   213: ldc 127
    //   215: aload 4
    //   217: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   220: aload_1
    //   221: ifnull +7 -> 228
    //   224: aload_1
    //   225: invokevirtual 125	java/io/FileOutputStream:close	()V
    //   228: aload_3
    //   229: ifnull -30 -> 199
    //   232: aload_3
    //   233: invokevirtual 77	android/os/Parcel:recycle	()V
    //   236: goto -37 -> 199
    //   239: astore_0
    //   240: ldc 8
    //   242: iconst_1
    //   243: ldc 127
    //   245: aload_0
    //   246: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   249: goto -21 -> 228
    //   252: astore_0
    //   253: aload_3
    //   254: ifnull +7 -> 261
    //   257: aload_3
    //   258: invokevirtual 77	android/os/Parcel:recycle	()V
    //   261: aload_0
    //   262: athrow
    //   263: astore 4
    //   265: aload_0
    //   266: astore_1
    //   267: aload 4
    //   269: astore_0
    //   270: aload_1
    //   271: ifnull +7 -> 278
    //   274: aload_1
    //   275: invokevirtual 125	java/io/FileOutputStream:close	()V
    //   278: aload_0
    //   279: athrow
    //   280: astore_1
    //   281: ldc 8
    //   283: iconst_1
    //   284: ldc 127
    //   286: aload_1
    //   287: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   290: goto -12 -> 278
    //   293: astore_0
    //   294: aconst_null
    //   295: astore_3
    //   296: goto -43 -> 253
    //   299: astore_1
    //   300: aload_0
    //   301: astore_3
    //   302: aload_1
    //   303: astore_0
    //   304: goto -51 -> 253
    //   307: astore_1
    //   308: aload_3
    //   309: astore_0
    //   310: goto -128 -> 182
    //   313: astore_0
    //   314: goto -44 -> 270
    //   317: astore 4
    //   319: goto -111 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	paramParcelable	android.os.Parcelable
    //   0	322	1	paramString	String
    //   9	15	2	bool	boolean
    //   7	302	3	localObject1	Object
    //   1	215	4	localParcelable	android.os.Parcelable
    //   263	5	4	localObject2	Object
    //   317	1	4	localThrowable	java.lang.Throwable
    //   4	122	5	localObject3	Object
    //   28	112	6	localObject4	Object
    //   64	28	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   152	156	166	java/lang/Throwable
    //   33	45	179	java/lang/Throwable
    //   167	176	179	java/lang/Throwable
    //   240	249	179	java/lang/Throwable
    //   278	280	179	java/lang/Throwable
    //   281	290	179	java/lang/Throwable
    //   48	57	201	java/lang/Throwable
    //   60	66	201	java/lang/Throwable
    //   69	77	201	java/lang/Throwable
    //   80	88	201	java/lang/Throwable
    //   91	97	201	java/lang/Throwable
    //   100	107	201	java/lang/Throwable
    //   110	117	201	java/lang/Throwable
    //   120	125	201	java/lang/Throwable
    //   128	138	201	java/lang/Throwable
    //   224	228	239	java/lang/Throwable
    //   33	45	252	finally
    //   152	156	252	finally
    //   167	176	252	finally
    //   224	228	252	finally
    //   240	249	252	finally
    //   274	278	252	finally
    //   278	280	252	finally
    //   281	290	252	finally
    //   48	57	263	finally
    //   60	66	263	finally
    //   69	77	263	finally
    //   80	88	263	finally
    //   91	97	263	finally
    //   100	107	263	finally
    //   110	117	263	finally
    //   120	125	263	finally
    //   128	138	263	finally
    //   210	220	263	finally
    //   274	278	280	java/lang/Throwable
    //   25	30	293	finally
    //   182	191	299	finally
    //   25	30	307	java/lang/Throwable
    //   138	148	313	finally
    //   138	148	317	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.ParcelableUtil
 * JD-Core Version:    0.7.0.1
 */