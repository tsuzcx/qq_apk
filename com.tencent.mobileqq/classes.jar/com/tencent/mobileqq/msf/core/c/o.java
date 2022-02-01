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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
      localStringBuilder.append("/tencent/audio/");
      b = localStringBuilder.toString();
    }
    return c;
  }
  
  /* Error */
  public void a(o.a parama, byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 70	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   12: astore 5
    //   14: aload 5
    //   16: aload_1
    //   17: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload 5
    //   23: ldc 104
    //   25: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload 5
    //   31: invokestatic 110	android/os/SystemClock:elapsedRealtime	()J
    //   34: invokestatic 116	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   37: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 5
    //   43: ldc 104
    //   45: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 5
    //   51: iload_3
    //   52: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 5
    //   58: ldc 121
    //   60: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 5
    //   66: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: astore_1
    //   70: invokestatic 124	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   73: ldc 126
    //   75: invokevirtual 130	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifne +4 -> 82
    //   81: return
    //   82: new 79	java/io/File
    //   85: dup
    //   86: getstatic 94	com/tencent/mobileqq/msf/core/c/o:b	Ljava/lang/String;
    //   89: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   92: astore 5
    //   94: aload 5
    //   96: invokevirtual 137	java/io/File:exists	()Z
    //   99: ifne +12 -> 111
    //   102: aload 5
    //   104: invokevirtual 140	java/io/File:mkdirs	()Z
    //   107: ifne +4 -> 111
    //   110: return
    //   111: iconst_1
    //   112: istore 4
    //   114: iconst_1
    //   115: istore_3
    //   116: new 70	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   123: astore 5
    //   125: aload 5
    //   127: getstatic 94	com/tencent/mobileqq/msf/core/c/o:b	Ljava/lang/String;
    //   130: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 5
    //   136: aload_1
    //   137: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: new 79	java/io/File
    //   144: dup
    //   145: aload 5
    //   147: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   153: astore 7
    //   155: aconst_null
    //   156: astore 6
    //   158: aconst_null
    //   159: astore 5
    //   161: new 142	java/io/FileOutputStream
    //   164: dup
    //   165: aload 7
    //   167: invokespecial 145	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   170: astore_1
    //   171: aload_1
    //   172: aload_2
    //   173: invokevirtual 149	java/io/FileOutputStream:write	([B)V
    //   176: aload_1
    //   177: invokevirtual 152	java/io/FileOutputStream:flush	()V
    //   180: aload_1
    //   181: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   184: goto +5 -> 189
    //   187: iconst_0
    //   188: istore_3
    //   189: iload_3
    //   190: ifne +78 -> 268
    //   193: aload 7
    //   195: invokevirtual 158	java/io/File:delete	()Z
    //   198: pop
    //   199: return
    //   200: astore 5
    //   202: aload_1
    //   203: astore_2
    //   204: aload 5
    //   206: astore_1
    //   207: goto +12 -> 219
    //   210: goto +40 -> 250
    //   213: goto +48 -> 261
    //   216: astore_1
    //   217: aconst_null
    //   218: astore_2
    //   219: iload 4
    //   221: istore_3
    //   222: aload_2
    //   223: ifnull +15 -> 238
    //   226: aload_2
    //   227: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   230: iload 4
    //   232: istore_3
    //   233: goto +5 -> 238
    //   236: iconst_0
    //   237: istore_3
    //   238: iload_3
    //   239: ifne +9 -> 248
    //   242: aload 7
    //   244: invokevirtual 158	java/io/File:delete	()Z
    //   247: pop
    //   248: aload_1
    //   249: athrow
    //   250: aload_1
    //   251: ifnull -58 -> 193
    //   254: aload_1
    //   255: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   258: goto -65 -> 193
    //   261: aload_1
    //   262: ifnull -69 -> 193
    //   265: goto -11 -> 254
    //   268: return
    //   269: astore_1
    //   270: aload 6
    //   272: astore_1
    //   273: goto -12 -> 261
    //   276: astore_1
    //   277: aload 5
    //   279: astore_1
    //   280: goto -30 -> 250
    //   283: astore_2
    //   284: goto -71 -> 213
    //   287: astore_2
    //   288: goto -78 -> 210
    //   291: astore_1
    //   292: goto -105 -> 187
    //   295: astore_2
    //   296: goto -60 -> 236
    //   299: astore_1
    //   300: goto -107 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	o
    //   0	303	1	parama	o.a
    //   0	303	2	paramArrayOfByte	byte[]
    //   0	303	3	paramInt	int
    //   112	119	4	i1	int
    //   12	148	5	localObject1	Object
    //   200	78	5	localObject2	Object
    //   156	115	6	localObject3	Object
    //   153	90	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   171	180	200	finally
    //   161	171	216	finally
    //   161	171	269	java/io/FileNotFoundException
    //   161	171	276	java/io/IOException
    //   171	180	283	java/io/FileNotFoundException
    //   171	180	287	java/io/IOException
    //   180	184	291	java/io/IOException
    //   226	230	295	java/io/IOException
    //   254	258	299	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.o
 * JD-Core Version:    0.7.0.1
 */