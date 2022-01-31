package com.tencent.mobileqq.msf.core.c;

import android.os.Environment;
import java.io.File;

public class o
{
  public static final String a = "VideoProxyRateReport";
  static String b = "";
  static o c;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  public static final int i = 5;
  public static final int j = 6;
  public static final int k = 7;
  public static final int l = 8;
  public static final int m = 9;
  public static final int n = 10;
  public static final int o = 11;
  public static final int p = 12;
  public static final int q = 13;
  public static final int r = 14;
  public static final int s = 15;
  public static final int t = 16;
  public static final int u = 17;
  public static final int v = 18;
  public static final int w = 19;
  public static final int x = 20;
  public static final int y = 100;
  
  public static o a()
  {
    if (c == null)
    {
      c = new o();
      b = Environment.getExternalStorageDirectory().getPath() + "/tencent/audio/";
    }
    return c;
  }
  
  /* Error */
  public void a(a parama, byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_2
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: new 74	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   15: aload_1
    //   16: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: ldc 106
    //   21: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokestatic 112	android/os/SystemClock:elapsedRealtime	()J
    //   27: invokestatic 118	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   30: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 106
    //   35: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: iload_3
    //   39: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: ldc 123
    //   44: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore_1
    //   51: invokestatic 126	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   54: ldc 128
    //   56: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: ifeq -52 -> 7
    //   62: new 83	java/io/File
    //   65: dup
    //   66: getstatic 64	com/tencent/mobileqq/msf/core/c/o:b	Ljava/lang/String;
    //   69: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore 5
    //   74: aload 5
    //   76: invokevirtual 139	java/io/File:exists	()Z
    //   79: ifne +11 -> 90
    //   82: aload 5
    //   84: invokevirtual 142	java/io/File:mkdirs	()Z
    //   87: ifeq -80 -> 7
    //   90: new 83	java/io/File
    //   93: dup
    //   94: new 74	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   101: getstatic 64	com/tencent/mobileqq/msf/core/c/o:b	Ljava/lang/String;
    //   104: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   117: astore 6
    //   119: aconst_null
    //   120: astore 5
    //   122: aload 6
    //   124: ifnull -117 -> 7
    //   127: new 144	java/io/FileOutputStream
    //   130: dup
    //   131: aload 6
    //   133: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   136: astore_1
    //   137: aload_1
    //   138: aload_2
    //   139: invokevirtual 151	java/io/FileOutputStream:write	([B)V
    //   142: aload_1
    //   143: invokevirtual 154	java/io/FileOutputStream:flush	()V
    //   146: aload_1
    //   147: ifnull +7 -> 154
    //   150: aload_1
    //   151: invokevirtual 157	java/io/FileOutputStream:close	()V
    //   154: iconst_1
    //   155: istore_3
    //   156: iload_3
    //   157: ifne -150 -> 7
    //   160: aload 6
    //   162: invokevirtual 160	java/io/File:delete	()Z
    //   165: pop
    //   166: return
    //   167: astore_1
    //   168: aload 5
    //   170: astore_2
    //   171: aload_2
    //   172: ifnull +7 -> 179
    //   175: aload_2
    //   176: invokevirtual 157	java/io/FileOutputStream:close	()V
    //   179: iconst_1
    //   180: istore_3
    //   181: iload_3
    //   182: ifne +9 -> 191
    //   185: aload 6
    //   187: invokevirtual 160	java/io/File:delete	()Z
    //   190: pop
    //   191: aload_1
    //   192: athrow
    //   193: astore_1
    //   194: aconst_null
    //   195: astore_1
    //   196: aload_1
    //   197: ifnull -37 -> 160
    //   200: aload_1
    //   201: invokevirtual 157	java/io/FileOutputStream:close	()V
    //   204: goto -44 -> 160
    //   207: astore_1
    //   208: goto -48 -> 160
    //   211: astore_1
    //   212: aconst_null
    //   213: astore_1
    //   214: aload_1
    //   215: ifnull -55 -> 160
    //   218: aload_1
    //   219: invokevirtual 157	java/io/FileOutputStream:close	()V
    //   222: goto -62 -> 160
    //   225: astore_1
    //   226: goto -66 -> 160
    //   229: astore_2
    //   230: iload 4
    //   232: istore_3
    //   233: goto -52 -> 181
    //   236: astore_1
    //   237: iconst_0
    //   238: istore_3
    //   239: goto -83 -> 156
    //   242: astore 5
    //   244: aload_1
    //   245: astore_2
    //   246: aload 5
    //   248: astore_1
    //   249: goto -78 -> 171
    //   252: astore_2
    //   253: goto -39 -> 214
    //   256: astore_2
    //   257: goto -61 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	o
    //   0	260	1	parama	a
    //   0	260	2	paramArrayOfByte	byte[]
    //   0	260	3	paramInt	int
    //   1	230	4	i1	int
    //   72	97	5	localFile1	File
    //   242	5	5	localObject	Object
    //   117	69	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   127	137	167	finally
    //   127	137	193	java/io/FileNotFoundException
    //   200	204	207	java/io/IOException
    //   127	137	211	java/io/IOException
    //   218	222	225	java/io/IOException
    //   175	179	229	java/io/IOException
    //   150	154	236	java/io/IOException
    //   137	146	242	finally
    //   137	146	252	java/io/IOException
    //   137	146	256	java/io/FileNotFoundException
  }
  
  public static enum a
  {
    public static a a(String paramString)
    {
      return (a)Enum.valueOf(a.class, paramString);
    }
    
    public static a[] a()
    {
      return (a[])j.clone();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.o
 * JD-Core Version:    0.7.0.1
 */