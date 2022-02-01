package com.tencent.wstt.SSCM;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class Utils
{
  public static final int a(Context paramContext)
  {
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {
      return -1;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject != null)
    {
      if (!((NetworkInfo)localObject).isAvailable()) {
        return -1;
      }
      if (((NetworkInfo)localObject).getType() == 1) {
        return 0;
      }
      int i = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType();
      if ((i != 1) && (i != 2) && (i != 4)) {
        return 1;
      }
      return 2;
    }
    return -1;
  }
  
  /* Error */
  public static java.lang.String a()
  {
    // Byte code:
    //   0: invokestatic 50	android/os/Process:myPid	()I
    //   3: istore_0
    //   4: new 52	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   11: astore_1
    //   12: aload_1
    //   13: ldc 55
    //   15: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload_1
    //   20: iload_0
    //   21: invokestatic 65	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   24: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_1
    //   29: ldc 67
    //   31: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_1
    //   36: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore_1
    //   40: ldc 72
    //   42: astore 6
    //   44: new 74	java/io/FileReader
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 77	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   52: astore_2
    //   53: new 79	java/io/BufferedReader
    //   56: dup
    //   57: aload_2
    //   58: sipush 8192
    //   61: invokespecial 82	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   64: astore 5
    //   66: aload 5
    //   68: astore_3
    //   69: aload_2
    //   70: astore 4
    //   72: aload 5
    //   74: invokevirtual 85	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   77: pop
    //   78: aload 5
    //   80: astore_3
    //   81: aload_2
    //   82: astore 4
    //   84: aload 5
    //   86: invokevirtual 85	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   89: pop
    //   90: aload 5
    //   92: astore_3
    //   93: aload_2
    //   94: astore 4
    //   96: aload 5
    //   98: invokevirtual 85	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   101: astore_1
    //   102: aload_1
    //   103: astore 7
    //   105: aload_1
    //   106: ifnull +16 -> 122
    //   109: aload 5
    //   111: astore_3
    //   112: aload_2
    //   113: astore 4
    //   115: aload 5
    //   117: invokevirtual 85	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   120: astore 7
    //   122: aload 6
    //   124: astore_1
    //   125: aload 7
    //   127: ifnull +41 -> 168
    //   130: aload 5
    //   132: astore_3
    //   133: aload_2
    //   134: astore 4
    //   136: aload 7
    //   138: ldc 87
    //   140: invokevirtual 91	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   143: astore_1
    //   144: aload 5
    //   146: astore_3
    //   147: aload_2
    //   148: astore 4
    //   150: aload_1
    //   151: arraylength
    //   152: bipush 9
    //   154: if_icmplt +11 -> 165
    //   157: aload_1
    //   158: bipush 8
    //   160: aaload
    //   161: astore_1
    //   162: goto +6 -> 168
    //   165: ldc 93
    //   167: astore_1
    //   168: aload_1
    //   169: astore_3
    //   170: aload_2
    //   171: invokevirtual 96	java/io/FileReader:close	()V
    //   174: aload_1
    //   175: astore_3
    //   176: aload 5
    //   178: invokevirtual 97	java/io/BufferedReader:close	()V
    //   181: aload_1
    //   182: areturn
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   188: aload_3
    //   189: areturn
    //   190: astore_3
    //   191: aload 5
    //   193: astore_1
    //   194: aload_3
    //   195: astore 5
    //   197: goto +30 -> 227
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_3
    //   203: goto +63 -> 266
    //   206: astore 5
    //   208: aconst_null
    //   209: astore_1
    //   210: goto +17 -> 227
    //   213: astore_1
    //   214: aconst_null
    //   215: astore_3
    //   216: aload_3
    //   217: astore_2
    //   218: goto +48 -> 266
    //   221: astore 5
    //   223: aconst_null
    //   224: astore_2
    //   225: aload_2
    //   226: astore_1
    //   227: aload_1
    //   228: astore_3
    //   229: aload_2
    //   230: astore 4
    //   232: aload 5
    //   234: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   237: aload_2
    //   238: ifnull +10 -> 248
    //   241: aload 6
    //   243: astore_3
    //   244: aload_2
    //   245: invokevirtual 96	java/io/FileReader:close	()V
    //   248: aload_1
    //   249: ifnull +10 -> 259
    //   252: aload 6
    //   254: astore_3
    //   255: aload_1
    //   256: invokevirtual 97	java/io/BufferedReader:close	()V
    //   259: ldc 72
    //   261: areturn
    //   262: astore_1
    //   263: aload 4
    //   265: astore_2
    //   266: aload_2
    //   267: ifnull +10 -> 277
    //   270: aload_2
    //   271: invokevirtual 96	java/io/FileReader:close	()V
    //   274: goto +3 -> 277
    //   277: aload_3
    //   278: ifnull +14 -> 292
    //   281: aload_3
    //   282: invokevirtual 97	java/io/BufferedReader:close	()V
    //   285: goto +7 -> 292
    //   288: aload_2
    //   289: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   292: aload_1
    //   293: athrow
    //   294: astore_2
    //   295: goto -7 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	18	0	i	int
    //   11	171	1	localObject1	Object
    //   183	2	1	localIOException1	java.io.IOException
    //   193	1	1	localObject2	Object
    //   200	1	1	localObject3	Object
    //   209	1	1	localObject4	Object
    //   213	1	1	localObject5	Object
    //   226	30	1	localObject6	Object
    //   262	31	1	localObject7	Object
    //   52	237	2	localObject8	Object
    //   294	1	2	localIOException2	java.io.IOException
    //   68	121	3	localObject9	Object
    //   190	5	3	localIOException3	java.io.IOException
    //   202	80	3	localObject10	Object
    //   70	194	4	localObject11	Object
    //   64	132	5	localObject12	Object
    //   206	1	5	localIOException4	java.io.IOException
    //   221	12	5	localIOException5	java.io.IOException
    //   42	211	6	str	java.lang.String
    //   103	34	7	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   170	174	183	java/io/IOException
    //   176	181	183	java/io/IOException
    //   244	248	183	java/io/IOException
    //   255	259	183	java/io/IOException
    //   72	78	190	java/io/IOException
    //   84	90	190	java/io/IOException
    //   96	102	190	java/io/IOException
    //   115	122	190	java/io/IOException
    //   136	144	190	java/io/IOException
    //   150	157	190	java/io/IOException
    //   53	66	200	finally
    //   53	66	206	java/io/IOException
    //   44	53	213	finally
    //   44	53	221	java/io/IOException
    //   72	78	262	finally
    //   84	90	262	finally
    //   96	102	262	finally
    //   115	122	262	finally
    //   136	144	262	finally
    //   150	157	262	finally
    //   232	237	262	finally
    //   270	274	294	java/io/IOException
    //   281	285	294	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wstt.SSCM.Utils
 * JD-Core Version:    0.7.0.1
 */