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
    //   63: invokestatic 51	com/tencent/component/network/downloader/common/Utils:unmarshall	([B)Landroid/os/Parcel;
    //   66: astore 4
    //   68: aload 4
    //   70: astore_1
    //   71: aload 4
    //   73: aload_0
    //   74: invokevirtual 57	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   77: invokevirtual 63	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   80: astore_0
    //   81: aload 4
    //   83: ifnull +10 -> 93
    //   86: aload_3
    //   87: astore_1
    //   88: aload 4
    //   90: invokevirtual 66	android/os/Parcel:recycle	()V
    //   93: aload_3
    //   94: invokevirtual 69	java/io/FileInputStream:close	()V
    //   97: aload_0
    //   98: areturn
    //   99: astore_1
    //   100: ldc 8
    //   102: ldc 71
    //   104: aload_1
    //   105: invokestatic 77	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   142: ldc 71
    //   144: aload 4
    //   146: invokestatic 77	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   149: aload_0
    //   150: ifnull +9 -> 159
    //   153: aload_3
    //   154: astore_1
    //   155: aload_0
    //   156: invokevirtual 66	android/os/Parcel:recycle	()V
    //   159: aload_3
    //   160: invokevirtual 69	java/io/FileInputStream:close	()V
    //   163: aconst_null
    //   164: areturn
    //   165: aload_0
    //   166: ifnull +9 -> 175
    //   169: aload_3
    //   170: astore_1
    //   171: aload_0
    //   172: invokevirtual 66	android/os/Parcel:recycle	()V
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
    //   201: ldc 71
    //   203: aload 4
    //   205: invokestatic 77	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   208: aload_0
    //   209: ifnull +18 -> 227
    //   212: aload_0
    //   213: invokevirtual 69	java/io/FileInputStream:close	()V
    //   216: aconst_null
    //   217: areturn
    //   218: astore_0
    //   219: ldc 8
    //   221: ldc 71
    //   223: aload_0
    //   224: invokestatic 77	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   227: aconst_null
    //   228: areturn
    //   229: astore_0
    //   230: aload_1
    //   231: ifnull +19 -> 250
    //   234: aload_1
    //   235: invokevirtual 69	java/io/FileInputStream:close	()V
    //   238: goto +12 -> 250
    //   241: astore_1
    //   242: ldc 8
    //   244: ldc 71
    //   246: aload_1
    //   247: invokestatic 77	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
  
  /* Error */
  public static boolean writeParcelableToFile(android.os.Parcelable paramParcelable, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +303 -> 304
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
    //   24: invokestatic 85	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   27: astore_3
    //   28: aload_3
    //   29: aload_0
    //   30: iconst_0
    //   31: invokevirtual 89	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   34: aload_3
    //   35: invokevirtual 93	android/os/Parcel:marshall	()[B
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
    //   55: invokevirtual 97	java/io/File:getParentFile	()Ljava/io/File;
    //   58: astore 6
    //   60: aload 5
    //   62: astore_0
    //   63: aload 6
    //   65: invokevirtual 32	java/io/File:exists	()Z
    //   68: ifeq +14 -> 82
    //   71: aload 5
    //   73: astore_0
    //   74: aload 6
    //   76: invokevirtual 100	java/io/File:isDirectory	()Z
    //   79: ifne +12 -> 91
    //   82: aload 5
    //   84: astore_0
    //   85: aload 6
    //   87: invokevirtual 103	java/io/File:mkdirs	()Z
    //   90: pop
    //   91: aload 5
    //   93: astore_0
    //   94: aload_1
    //   95: invokevirtual 32	java/io/File:exists	()Z
    //   98: ifeq +13 -> 111
    //   101: aload 5
    //   103: astore_0
    //   104: aload_1
    //   105: invokevirtual 106	java/io/File:isFile	()Z
    //   108: ifne +11 -> 119
    //   111: aload 5
    //   113: astore_0
    //   114: aload_1
    //   115: invokevirtual 109	java/io/File:createNewFile	()Z
    //   118: pop
    //   119: aload 5
    //   121: astore_0
    //   122: new 111	java/io/FileOutputStream
    //   125: dup
    //   126: aload_1
    //   127: iconst_0
    //   128: invokespecial 114	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   131: astore_1
    //   132: aload_1
    //   133: aload_2
    //   134: invokevirtual 118	java/io/FileOutputStream:write	([B)V
    //   137: aload_1
    //   138: invokevirtual 121	java/io/FileOutputStream:flush	()V
    //   141: aload_1
    //   142: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   145: goto +13 -> 158
    //   148: astore_0
    //   149: ldc 8
    //   151: iconst_1
    //   152: ldc 124
    //   154: aload_0
    //   155: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   158: aload_3
    //   159: ifnull +7 -> 166
    //   162: aload_3
    //   163: invokevirtual 66	android/os/Parcel:recycle	()V
    //   166: iconst_1
    //   167: ireturn
    //   168: astore_2
    //   169: aload_1
    //   170: astore_0
    //   171: aload_2
    //   172: astore_1
    //   173: goto +57 -> 230
    //   176: astore_2
    //   177: goto +11 -> 188
    //   180: astore_1
    //   181: goto +49 -> 230
    //   184: astore_2
    //   185: aload 4
    //   187: astore_1
    //   188: aload_1
    //   189: astore_0
    //   190: ldc 8
    //   192: iconst_1
    //   193: ldc 124
    //   195: aload_2
    //   196: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   199: aload_1
    //   200: ifnull +20 -> 220
    //   203: aload_1
    //   204: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   207: goto +13 -> 220
    //   210: astore_0
    //   211: ldc 8
    //   213: iconst_1
    //   214: ldc 124
    //   216: aload_0
    //   217: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   220: aload_3
    //   221: ifnull +71 -> 292
    //   224: aload_3
    //   225: invokevirtual 66	android/os/Parcel:recycle	()V
    //   228: iconst_0
    //   229: ireturn
    //   230: aload_0
    //   231: ifnull +20 -> 251
    //   234: aload_0
    //   235: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   238: goto +13 -> 251
    //   241: astore_0
    //   242: ldc 8
    //   244: iconst_1
    //   245: ldc 124
    //   247: aload_0
    //   248: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   251: aload_1
    //   252: athrow
    //   253: astore_0
    //   254: goto +40 -> 294
    //   257: astore_1
    //   258: aload_3
    //   259: astore_0
    //   260: goto +13 -> 273
    //   263: astore_0
    //   264: aload_2
    //   265: astore_3
    //   266: goto +28 -> 294
    //   269: astore_1
    //   270: aload 6
    //   272: astore_0
    //   273: aload_0
    //   274: astore_2
    //   275: ldc 8
    //   277: iconst_1
    //   278: ldc 124
    //   280: aload_1
    //   281: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   284: aload_0
    //   285: ifnull +7 -> 292
    //   288: aload_0
    //   289: invokevirtual 66	android/os/Parcel:recycle	()V
    //   292: iconst_0
    //   293: ireturn
    //   294: aload_3
    //   295: ifnull +7 -> 302
    //   298: aload_3
    //   299: invokevirtual 66	android/os/Parcel:recycle	()V
    //   302: aload_0
    //   303: athrow
    //   304: iconst_0
    //   305: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	paramParcelable	android.os.Parcelable
    //   0	306	1	paramString	String
    //   17	117	2	arrayOfByte	byte[]
    //   168	4	2	localObject1	Object
    //   176	1	2	localThrowable1	java.lang.Throwable
    //   184	81	2	localThrowable2	java.lang.Throwable
    //   274	1	2	localParcelable	android.os.Parcelable
    //   27	272	3	localObject2	Object
    //   14	172	4	localObject3	Object
    //   22	98	5	localObject4	Object
    //   19	252	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   141	145	148	java/lang/Throwable
    //   132	141	168	finally
    //   132	141	176	java/lang/Throwable
    //   42	51	180	finally
    //   54	60	180	finally
    //   63	71	180	finally
    //   74	82	180	finally
    //   85	91	180	finally
    //   94	101	180	finally
    //   104	111	180	finally
    //   114	119	180	finally
    //   122	132	180	finally
    //   190	199	180	finally
    //   42	51	184	java/lang/Throwable
    //   54	60	184	java/lang/Throwable
    //   63	71	184	java/lang/Throwable
    //   74	82	184	java/lang/Throwable
    //   85	91	184	java/lang/Throwable
    //   94	101	184	java/lang/Throwable
    //   104	111	184	java/lang/Throwable
    //   114	119	184	java/lang/Throwable
    //   122	132	184	java/lang/Throwable
    //   203	207	210	java/lang/Throwable
    //   234	238	241	java/lang/Throwable
    //   28	39	253	finally
    //   141	145	253	finally
    //   149	158	253	finally
    //   203	207	253	finally
    //   211	220	253	finally
    //   234	238	253	finally
    //   242	251	253	finally
    //   251	253	253	finally
    //   28	39	257	java/lang/Throwable
    //   149	158	257	java/lang/Throwable
    //   211	220	257	java/lang/Throwable
    //   242	251	257	java/lang/Throwable
    //   251	253	257	java/lang/Throwable
    //   24	28	263	finally
    //   275	284	263	finally
    //   24	28	269	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.ParcelableUtil
 * JD-Core Version:    0.7.0.1
 */