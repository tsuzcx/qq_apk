import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.qphone.base.util.BaseApplication;

public class fi
{
  private static String a = "9u23fh$jkf^%43hj";
  private static String b = "1234567890123456";
  
  public static long a()
  {
    WifiManager localWifiManager = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (!localWifiManager.isWifiEnabled()) {
      return 0L;
    }
    try
    {
      int i = localWifiManager.getConnectionInfo().getIpAddress();
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0L;
  }
  
  public static String a(long paramLong)
  {
    if (paramLong > 4294967295L) {
      throw new IllegalArgumentException("invalid ip");
    }
    long l = paramLong;
    if (paramLong < 0L)
    {
      paramLong += 4294967296L;
      l = paramLong;
      if (paramLong < 0L) {
        throw new IllegalArgumentException("invalid ip");
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i <= 3)
    {
      int j = i * 8;
      localStringBuilder.append((255 << j & l) >> j);
      if (i < 3) {
        localStringBuilder.append(".");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: ldc2_w 90
    //   3: lstore_3
    //   4: aconst_null
    //   5: astore 9
    //   7: ldc 93
    //   9: invokestatic 99	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   12: astore 10
    //   14: new 101	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore 8
    //   24: aload 8
    //   26: astore 7
    //   28: new 104	com/tencent/mm/vfs/VFSFile
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 105	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   36: invokevirtual 108	com/tencent/mm/vfs/VFSFile:length	()J
    //   39: lstore 5
    //   41: lload 5
    //   43: ldc2_w 90
    //   46: lcmp
    //   47: ifle +260 -> 307
    //   50: aload 8
    //   52: astore 7
    //   54: sipush 1024
    //   57: newarray byte
    //   59: astore_0
    //   60: lload_3
    //   61: lconst_0
    //   62: lcmp
    //   63: ifle +78 -> 141
    //   66: aload 8
    //   68: astore 7
    //   70: aload 8
    //   72: aload_0
    //   73: invokevirtual 114	java/io/InputStream:read	([B)I
    //   76: istore_2
    //   77: iload_2
    //   78: iconst_m1
    //   79: if_icmpeq +62 -> 141
    //   82: iload_2
    //   83: istore_1
    //   84: iload_2
    //   85: i2l
    //   86: lload_3
    //   87: lcmp
    //   88: ifle +6 -> 94
    //   91: lload_3
    //   92: l2i
    //   93: istore_1
    //   94: lload_3
    //   95: iload_1
    //   96: i2l
    //   97: lsub
    //   98: lstore_3
    //   99: aload 8
    //   101: astore 7
    //   103: aload 10
    //   105: aload_0
    //   106: iconst_0
    //   107: iload_1
    //   108: invokevirtual 118	java/security/MessageDigest:update	([BII)V
    //   111: goto -51 -> 60
    //   114: astore_0
    //   115: aload 8
    //   117: astore 7
    //   119: aload_0
    //   120: invokevirtual 119	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   123: aload 9
    //   125: astore_0
    //   126: aload 8
    //   128: ifnull +11 -> 139
    //   131: aload 8
    //   133: invokevirtual 122	java/io/InputStream:close	()V
    //   136: aload 9
    //   138: astore_0
    //   139: aload_0
    //   140: areturn
    //   141: aload 8
    //   143: astore 7
    //   145: aload 8
    //   147: invokevirtual 122	java/io/InputStream:close	()V
    //   150: aload 8
    //   152: astore 7
    //   154: aload 10
    //   156: invokevirtual 126	java/security/MessageDigest:digest	()[B
    //   159: astore_0
    //   160: aload_0
    //   161: astore 7
    //   163: aload 7
    //   165: astore_0
    //   166: aload 8
    //   168: ifnull -29 -> 139
    //   171: aload 8
    //   173: invokevirtual 122	java/io/InputStream:close	()V
    //   176: aload 7
    //   178: areturn
    //   179: astore_0
    //   180: aload_0
    //   181: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   184: aload 7
    //   186: areturn
    //   187: astore_0
    //   188: aload_0
    //   189: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_0
    //   195: aconst_null
    //   196: astore 8
    //   198: aload 8
    //   200: astore 7
    //   202: aload_0
    //   203: invokevirtual 128	java/io/FileNotFoundException:printStackTrace	()V
    //   206: aload 9
    //   208: astore_0
    //   209: aload 8
    //   211: ifnull -72 -> 139
    //   214: aload 8
    //   216: invokevirtual 122	java/io/InputStream:close	()V
    //   219: aconst_null
    //   220: areturn
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   226: aconst_null
    //   227: areturn
    //   228: astore_0
    //   229: aconst_null
    //   230: astore 8
    //   232: aload 8
    //   234: astore 7
    //   236: aload_0
    //   237: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   240: aload 9
    //   242: astore_0
    //   243: aload 8
    //   245: ifnull -106 -> 139
    //   248: aload 8
    //   250: invokevirtual 122	java/io/InputStream:close	()V
    //   253: aconst_null
    //   254: areturn
    //   255: astore_0
    //   256: aload_0
    //   257: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   260: aconst_null
    //   261: areturn
    //   262: astore_0
    //   263: aconst_null
    //   264: astore 7
    //   266: aload 7
    //   268: ifnull +8 -> 276
    //   271: aload 7
    //   273: invokevirtual 122	java/io/InputStream:close	()V
    //   276: aload_0
    //   277: athrow
    //   278: astore 7
    //   280: aload 7
    //   282: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   285: goto -9 -> 276
    //   288: astore_0
    //   289: goto -23 -> 266
    //   292: astore_0
    //   293: goto -61 -> 232
    //   296: astore_0
    //   297: goto -99 -> 198
    //   300: astore_0
    //   301: aconst_null
    //   302: astore 8
    //   304: goto -189 -> 115
    //   307: lload 5
    //   309: lstore_3
    //   310: goto -260 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	paramString	String
    //   83	25	1	i	int
    //   76	9	2	j	int
    //   3	307	3	l1	long
    //   39	269	5	l2	long
    //   26	246	7	localObject1	Object
    //   278	3	7	localIOException	java.io.IOException
    //   22	281	8	localFileInputStream	java.io.FileInputStream
    //   5	236	9	localObject2	Object
    //   12	143	10	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   28	41	114	java/security/NoSuchAlgorithmException
    //   54	60	114	java/security/NoSuchAlgorithmException
    //   70	77	114	java/security/NoSuchAlgorithmException
    //   103	111	114	java/security/NoSuchAlgorithmException
    //   145	150	114	java/security/NoSuchAlgorithmException
    //   154	160	114	java/security/NoSuchAlgorithmException
    //   171	176	179	java/io/IOException
    //   131	136	187	java/io/IOException
    //   7	24	194	java/io/FileNotFoundException
    //   214	219	221	java/io/IOException
    //   7	24	228	java/io/IOException
    //   248	253	255	java/io/IOException
    //   7	24	262	finally
    //   271	276	278	java/io/IOException
    //   28	41	288	finally
    //   54	60	288	finally
    //   70	77	288	finally
    //   103	111	288	finally
    //   119	123	288	finally
    //   145	150	288	finally
    //   154	160	288	finally
    //   202	206	288	finally
    //   236	240	288	finally
    //   28	41	292	java/io/IOException
    //   54	60	292	java/io/IOException
    //   70	77	292	java/io/IOException
    //   103	111	292	java/io/IOException
    //   145	150	292	java/io/IOException
    //   154	160	292	java/io/IOException
    //   28	41	296	java/io/FileNotFoundException
    //   54	60	296	java/io/FileNotFoundException
    //   70	77	296	java/io/FileNotFoundException
    //   103	111	296	java/io/FileNotFoundException
    //   145	150	296	java/io/FileNotFoundException
    //   154	160	296	java/io/FileNotFoundException
    //   7	24	300	java/security/NoSuchAlgorithmException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     fi
 * JD-Core Version:    0.7.0.1
 */