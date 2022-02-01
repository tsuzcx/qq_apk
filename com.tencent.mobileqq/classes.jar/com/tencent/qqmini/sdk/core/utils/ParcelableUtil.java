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
    //   45: invokestatic 43	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   80: invokestatic 60	com/tencent/qqmini/sdk/core/utils/ParcelableUtil:unmarshall	([B)Landroid/os/Parcel;
    //   83: astore 4
    //   85: aload 4
    //   87: astore_1
    //   88: aload 4
    //   90: aload_0
    //   91: invokevirtual 66	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   94: invokevirtual 72	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   97: astore_0
    //   98: aload 4
    //   100: ifnull +8 -> 108
    //   103: aload 4
    //   105: invokevirtual 75	android/os/Parcel:recycle	()V
    //   108: aload 5
    //   110: ifnull +8 -> 118
    //   113: aload 5
    //   115: invokevirtual 78	java/io/FileInputStream:close	()V
    //   118: aload_0
    //   119: areturn
    //   120: astore_1
    //   121: ldc 8
    //   123: ldc 37
    //   125: aload_1
    //   126: invokestatic 43	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: goto -11 -> 118
    //   132: astore_0
    //   133: aconst_null
    //   134: astore 4
    //   136: aload 4
    //   138: astore_1
    //   139: ldc 8
    //   141: ldc 37
    //   143: aload_0
    //   144: invokestatic 43	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   147: aload 4
    //   149: ifnull +8 -> 157
    //   152: aload 4
    //   154: invokevirtual 75	android/os/Parcel:recycle	()V
    //   157: aload 5
    //   159: ifnull -152 -> 7
    //   162: aload 5
    //   164: invokevirtual 78	java/io/FileInputStream:close	()V
    //   167: aconst_null
    //   168: areturn
    //   169: astore_0
    //   170: ldc 8
    //   172: ldc 37
    //   174: aload_0
    //   175: invokestatic 43	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   178: aconst_null
    //   179: areturn
    //   180: astore_0
    //   181: aconst_null
    //   182: astore_1
    //   183: aload_1
    //   184: ifnull +7 -> 191
    //   187: aload_1
    //   188: invokevirtual 75	android/os/Parcel:recycle	()V
    //   191: aload_0
    //   192: athrow
    //   193: astore_1
    //   194: aload 5
    //   196: astore_0
    //   197: ldc 8
    //   199: ldc 37
    //   201: aload_1
    //   202: invokestatic 43	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload_0
    //   206: ifnull -199 -> 7
    //   209: aload_0
    //   210: invokevirtual 78	java/io/FileInputStream:close	()V
    //   213: aconst_null
    //   214: areturn
    //   215: astore_0
    //   216: ldc 8
    //   218: ldc 37
    //   220: aload_0
    //   221: invokestatic 43	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   224: aconst_null
    //   225: areturn
    //   226: astore_0
    //   227: aconst_null
    //   228: astore_1
    //   229: aload_1
    //   230: ifnull +7 -> 237
    //   233: aload_1
    //   234: invokevirtual 78	java/io/FileInputStream:close	()V
    //   237: aload_0
    //   238: athrow
    //   239: astore_1
    //   240: ldc 8
    //   242: ldc 37
    //   244: aload_1
    //   245: invokestatic 43	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   83	70	4	localParcel	Parcel
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
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_0
    //   9: ifnull +10 -> 19
    //   12: aload_1
    //   13: invokestatic 23	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +7 -> 23
    //   19: iconst_0
    //   20: istore_2
    //   21: iload_2
    //   22: ireturn
    //   23: invokestatic 86	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   26: astore 6
    //   28: aload 6
    //   30: astore_3
    //   31: aload_3
    //   32: aload_0
    //   33: iconst_0
    //   34: invokevirtual 99	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   37: aload_3
    //   38: invokevirtual 103	android/os/Parcel:marshall	()[B
    //   41: astore 6
    //   43: aload 5
    //   45: astore_0
    //   46: new 25	java/io/File
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 28	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore_1
    //   55: aload 5
    //   57: astore_0
    //   58: aload_1
    //   59: invokevirtual 107	java/io/File:getParentFile	()Ljava/io/File;
    //   62: astore 7
    //   64: aload 5
    //   66: astore_0
    //   67: aload 7
    //   69: invokevirtual 32	java/io/File:exists	()Z
    //   72: ifeq +14 -> 86
    //   75: aload 5
    //   77: astore_0
    //   78: aload 7
    //   80: invokevirtual 110	java/io/File:isDirectory	()Z
    //   83: ifne +12 -> 95
    //   86: aload 5
    //   88: astore_0
    //   89: aload 7
    //   91: invokevirtual 113	java/io/File:mkdirs	()Z
    //   94: pop
    //   95: aload 5
    //   97: astore_0
    //   98: aload_1
    //   99: invokevirtual 32	java/io/File:exists	()Z
    //   102: ifeq +13 -> 115
    //   105: aload 5
    //   107: astore_0
    //   108: aload_1
    //   109: invokevirtual 116	java/io/File:isFile	()Z
    //   112: ifne +11 -> 123
    //   115: aload 5
    //   117: astore_0
    //   118: aload_1
    //   119: invokevirtual 119	java/io/File:createNewFile	()Z
    //   122: pop
    //   123: aload 5
    //   125: astore_0
    //   126: new 121	java/io/FileOutputStream
    //   129: dup
    //   130: aload_1
    //   131: iconst_0
    //   132: invokespecial 124	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   135: astore_1
    //   136: aload_1
    //   137: aload 6
    //   139: invokevirtual 128	java/io/FileOutputStream:write	([B)V
    //   142: aload_1
    //   143: invokevirtual 131	java/io/FileOutputStream:flush	()V
    //   146: iconst_1
    //   147: istore_2
    //   148: aload_1
    //   149: ifnull +7 -> 156
    //   152: aload_1
    //   153: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   156: aload_3
    //   157: ifnull -136 -> 21
    //   160: aload_3
    //   161: invokevirtual 75	android/os/Parcel:recycle	()V
    //   164: iconst_1
    //   165: ireturn
    //   166: astore_0
    //   167: ldc 8
    //   169: ldc 134
    //   171: aload_0
    //   172: invokestatic 43	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   175: goto -19 -> 156
    //   178: astore_1
    //   179: aload_3
    //   180: astore_0
    //   181: ldc 8
    //   183: ldc 134
    //   185: aload_1
    //   186: invokestatic 43	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   189: aload_0
    //   190: ifnull +7 -> 197
    //   193: aload_0
    //   194: invokevirtual 75	android/os/Parcel:recycle	()V
    //   197: iconst_0
    //   198: ireturn
    //   199: astore_0
    //   200: aload 4
    //   202: astore_1
    //   203: aload_0
    //   204: astore 4
    //   206: aload_1
    //   207: astore_0
    //   208: ldc 8
    //   210: ldc 134
    //   212: aload 4
    //   214: invokestatic 43	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   217: aload_1
    //   218: ifnull +7 -> 225
    //   221: aload_1
    //   222: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   225: aload_3
    //   226: ifnull -29 -> 197
    //   229: aload_3
    //   230: invokevirtual 75	android/os/Parcel:recycle	()V
    //   233: goto -36 -> 197
    //   236: astore_0
    //   237: ldc 8
    //   239: ldc 134
    //   241: aload_0
    //   242: invokestatic 43	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   245: goto -20 -> 225
    //   248: astore_0
    //   249: aload_3
    //   250: ifnull +7 -> 257
    //   253: aload_3
    //   254: invokevirtual 75	android/os/Parcel:recycle	()V
    //   257: aload_0
    //   258: athrow
    //   259: astore 4
    //   261: aload_0
    //   262: astore_1
    //   263: aload 4
    //   265: astore_0
    //   266: aload_1
    //   267: ifnull +7 -> 274
    //   270: aload_1
    //   271: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   274: aload_0
    //   275: athrow
    //   276: astore_1
    //   277: ldc 8
    //   279: ldc 134
    //   281: aload_1
    //   282: invokestatic 43	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   285: goto -11 -> 274
    //   288: astore_0
    //   289: aconst_null
    //   290: astore_3
    //   291: goto -42 -> 249
    //   294: astore_1
    //   295: aload_0
    //   296: astore_3
    //   297: aload_1
    //   298: astore_0
    //   299: goto -50 -> 249
    //   302: astore_1
    //   303: aload_3
    //   304: astore_0
    //   305: goto -124 -> 181
    //   308: astore_0
    //   309: goto -43 -> 266
    //   312: astore 4
    //   314: goto -108 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	paramParcelable	android.os.Parcelable
    //   0	317	1	paramString	String
    //   20	128	2	bool	boolean
    //   7	297	3	localObject1	Object
    //   1	212	4	localParcelable	android.os.Parcelable
    //   259	5	4	localObject2	Object
    //   312	1	4	localThrowable	java.lang.Throwable
    //   4	120	5	localObject3	Object
    //   26	112	6	localObject4	Object
    //   62	28	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   152	156	166	java/lang/Throwable
    //   31	43	178	java/lang/Throwable
    //   167	175	178	java/lang/Throwable
    //   237	245	178	java/lang/Throwable
    //   274	276	178	java/lang/Throwable
    //   277	285	178	java/lang/Throwable
    //   46	55	199	java/lang/Throwable
    //   58	64	199	java/lang/Throwable
    //   67	75	199	java/lang/Throwable
    //   78	86	199	java/lang/Throwable
    //   89	95	199	java/lang/Throwable
    //   98	105	199	java/lang/Throwable
    //   108	115	199	java/lang/Throwable
    //   118	123	199	java/lang/Throwable
    //   126	136	199	java/lang/Throwable
    //   221	225	236	java/lang/Throwable
    //   31	43	248	finally
    //   152	156	248	finally
    //   167	175	248	finally
    //   221	225	248	finally
    //   237	245	248	finally
    //   270	274	248	finally
    //   274	276	248	finally
    //   277	285	248	finally
    //   46	55	259	finally
    //   58	64	259	finally
    //   67	75	259	finally
    //   78	86	259	finally
    //   89	95	259	finally
    //   98	105	259	finally
    //   108	115	259	finally
    //   118	123	259	finally
    //   126	136	259	finally
    //   208	217	259	finally
    //   270	274	276	java/lang/Throwable
    //   23	28	288	finally
    //   181	189	294	finally
    //   23	28	302	java/lang/Throwable
    //   136	146	308	finally
    //   136	146	312	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.ParcelableUtil
 * JD-Core Version:    0.7.0.1
 */