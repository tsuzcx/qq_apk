package org.apache.commons.io;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

@Deprecated
public class FileSystemUtils
{
  private static final String DF;
  private static final int INIT_PROBLEM = -1;
  private static final FileSystemUtils INSTANCE = new FileSystemUtils();
  private static final int OS;
  private static final int OTHER = 0;
  private static final int POSIX_UNIX = 3;
  private static final int UNIX = 2;
  private static final int WINDOWS = 1;
  
  static
  {
    str3 = "df";
    try
    {
      str1 = System.getProperty("os.name");
      if (str1 != null)
      {
        String str4 = str1.toLowerCase(Locale.ENGLISH);
        boolean bool = str4.contains("windows");
        j = 3;
        if (bool)
        {
          i = 1;
          str1 = str3;
          break label219;
        }
        if ((str4.contains("linux")) || (str4.contains("mpe/ix")) || (str4.contains("freebsd")) || (str4.contains("openbsd")) || (str4.contains("irix")) || (str4.contains("digital unix")) || (str4.contains("unix")) || (str4.contains("mac os x"))) {
          break label248;
        }
        if ((str4.contains("sun os")) || (str4.contains("sunos")) || (str4.contains("solaris"))) {
          break label240;
        }
        str1 = str3;
        i = j;
        if (str4.contains("hp-ux")) {
          break label219;
        }
        if (!str4.contains("aix")) {
          break label232;
        }
        str1 = str3;
        i = j;
        break label219;
      }
      throw new IOException("os.name not found");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        int j;
        continue;
        int i = 0;
        String str2 = str3;
        continue;
        str2 = "/usr/xpg4/bin/df";
        i = j;
        continue;
        i = 2;
        str2 = str3;
      }
    }
    i = -1;
    str1 = str3;
    label219:
    OS = i;
    DF = str1;
  }
  
  @Deprecated
  public static long freeSpace(String paramString)
  {
    return INSTANCE.freeSpaceOS(paramString, OS, false, -1L);
  }
  
  @Deprecated
  public static long freeSpaceKb()
  {
    return freeSpaceKb(-1L);
  }
  
  @Deprecated
  public static long freeSpaceKb(long paramLong)
  {
    return freeSpaceKb(new File(".").getAbsolutePath(), paramLong);
  }
  
  @Deprecated
  public static long freeSpaceKb(String paramString)
  {
    return freeSpaceKb(paramString, -1L);
  }
  
  @Deprecated
  public static long freeSpaceKb(String paramString, long paramLong)
  {
    return INSTANCE.freeSpaceOS(paramString, OS, true, paramLong);
  }
  
  long freeSpaceOS(String paramString, int paramInt, boolean paramBoolean, long paramLong)
  {
    if (paramString != null)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt == 3) {
              return freeSpaceUnix(paramString, paramBoolean, true, paramLong);
            }
            throw new IllegalStateException("Exception caught when determining operating system");
          }
          return freeSpaceUnix(paramString, paramBoolean, false, paramLong);
        }
        if (paramBoolean) {
          return freeSpaceWindows(paramString, paramLong) / 1024L;
        }
        return freeSpaceWindows(paramString, paramLong);
      }
      throw new IllegalStateException("Unsupported operating system");
    }
    throw new IllegalArgumentException("Path must not be null");
  }
  
  long freeSpaceUnix(String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (!paramString.isEmpty())
    {
      Object localObject1 = "-";
      if (paramBoolean1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("-");
        ((StringBuilder)localObject1).append("k");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      Object localObject2 = localObject1;
      if (paramBoolean2)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("P");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).length() > 1)
      {
        localObject1 = new String[3];
        localObject1[0] = DF;
        localObject1[1] = localObject2;
        localObject1[2] = paramString;
      }
      else
      {
        localObject1 = new String[2];
        localObject1[0] = DF;
        localObject1[1] = paramString;
      }
      localObject2 = performCommand((String[])localObject1, 3, paramLong);
      if (((List)localObject2).size() >= 2)
      {
        localObject1 = new StringTokenizer((String)((List)localObject2).get(1), " ");
        if (((StringTokenizer)localObject1).countTokens() < 4)
        {
          if ((((StringTokenizer)localObject1).countTokens() == 1) && (((List)localObject2).size() >= 3))
          {
            localObject1 = new StringTokenizer((String)((List)localObject2).get(2), " ");
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Command line '");
            ((StringBuilder)localObject1).append(DF);
            ((StringBuilder)localObject1).append("' did not return data as expected for path '");
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("'- check path is valid");
            throw new IOException(((StringBuilder)localObject1).toString());
          }
        }
        else {
          ((StringTokenizer)localObject1).nextToken();
        }
        ((StringTokenizer)localObject1).nextToken();
        ((StringTokenizer)localObject1).nextToken();
        return parseBytes(((StringTokenizer)localObject1).nextToken(), paramString);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Command line '");
      ((StringBuilder)localObject1).append(DF);
      ((StringBuilder)localObject1).append("' did not return info as expected for path '");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("'- response was ");
      ((StringBuilder)localObject1).append(localObject2);
      throw new IOException(((StringBuilder)localObject1).toString());
    }
    throw new IllegalArgumentException("Path must not be empty");
  }
  
  long freeSpaceWindows(String paramString, long paramLong)
  {
    Object localObject = FilenameUtils.normalize(paramString, false);
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (((String)localObject).length() > 0)
      {
        paramString = (String)localObject;
        if (((String)localObject).charAt(0) != '"')
        {
          paramString = new StringBuilder();
          paramString.append("\"");
          paramString.append((String)localObject);
          paramString.append("\"");
          paramString = paramString.toString();
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dir /a /-c ");
      ((StringBuilder)localObject).append(paramString);
      localObject = performCommand(new String[] { "cmd.exe", "/C", ((StringBuilder)localObject).toString() }, 2147483647, paramLong);
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        String str = (String)((List)localObject).get(i);
        if (str.length() > 0) {
          return parseDir(str, paramString);
        }
        i -= 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Command line 'dir /-c' did not return any info for path '");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("'");
      throw new IOException(((StringBuilder)localObject).toString());
    }
    paramString = new IllegalArgumentException(paramString);
    for (;;)
    {
      throw paramString;
    }
  }
  
  Process openProcess(String[] paramArrayOfString)
  {
    return Runtime.getRuntime().exec(paramArrayOfString);
  }
  
  long parseBytes(String paramString1, String paramString2)
  {
    try
    {
      long l = Long.parseLong(paramString1);
      if (l >= 0L) {
        return l;
      }
      paramString1 = new StringBuilder();
      paramString1.append("Command line '");
      paramString1.append(DF);
      paramString1.append("' did not find free space in response for path '");
      paramString1.append(paramString2);
      paramString1.append("'- check path is valid");
      throw new IOException(paramString1.toString());
    }
    catch (NumberFormatException paramString1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Command line '");
      localStringBuilder.append(DF);
      localStringBuilder.append("' did not return numeric data as expected for path '");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("'- check path is valid");
      throw new IOException(localStringBuilder.toString(), paramString1);
    }
  }
  
  long parseDir(String paramString1, String paramString2)
  {
    int i = paramString1.length() - 1;
    int m;
    for (;;)
    {
      m = 0;
      if (i < 0) {
        break;
      }
      if (Character.isDigit(paramString1.charAt(i)))
      {
        j = i + 1;
        break label49;
      }
      i -= 1;
    }
    int j = 0;
    label49:
    while (i >= 0)
    {
      char c = paramString1.charAt(i);
      if ((!Character.isDigit(c)) && (c != ',') && (c != '.'))
      {
        k = i + 1;
        break label101;
      }
      i -= 1;
    }
    int k = 0;
    label101:
    if (i >= 0)
    {
      paramString1 = new StringBuilder(paramString1.substring(k, j));
      i = m;
      while (i < paramString1.length())
      {
        if ((paramString1.charAt(i) != ',') && (paramString1.charAt(i) != '.')) {
          break label180;
        }
        j = i - 1;
        paramString1.deleteCharAt(i);
        i = j;
        i += 1;
      }
      return parseBytes(paramString1.toString(), paramString2);
    }
    label180:
    paramString1 = new StringBuilder();
    paramString1.append("Command line 'dir /-c' did not return valid info for path '");
    paramString1.append(paramString2);
    paramString1.append("'");
    paramString1 = new IOException(paramString1.toString());
    for (;;)
    {
      throw paramString1;
    }
  }
  
  /* Error */
  List<String> performCommand(String[] paramArrayOfString, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: new 289	java/util/ArrayList
    //   3: dup
    //   4: bipush 20
    //   6: invokespecial 292	java/util/ArrayList:<init>	(I)V
    //   9: astore 12
    //   11: aconst_null
    //   12: astore 11
    //   14: lload_3
    //   15: invokestatic 298	org/apache/commons/io/ThreadMonitor:start	(J)Ljava/lang/Thread;
    //   18: astore 9
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 300	org/apache/commons/io/FileSystemUtils:openProcess	([Ljava/lang/String;)Ljava/lang/Process;
    //   25: astore 7
    //   27: aload 7
    //   29: invokevirtual 306	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   32: astore 6
    //   34: aload 7
    //   36: invokevirtual 310	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   39: astore 5
    //   41: aload 7
    //   43: invokevirtual 313	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   46: astore 10
    //   48: new 315	java/io/BufferedReader
    //   51: dup
    //   52: new 317	java/io/InputStreamReader
    //   55: dup
    //   56: aload 6
    //   58: invokestatic 323	java/nio/charset/Charset:defaultCharset	()Ljava/nio/charset/Charset;
    //   61: invokespecial 326	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   64: invokespecial 329	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   67: astore 11
    //   69: aload 11
    //   71: invokevirtual 332	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   74: astore 8
    //   76: aload 8
    //   78: ifnull +43 -> 121
    //   81: aload 12
    //   83: invokeinterface 179 1 0
    //   88: iload_2
    //   89: if_icmpge +32 -> 121
    //   92: aload 12
    //   94: aload 8
    //   96: getstatic 46	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   99: invokevirtual 52	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   102: invokevirtual 335	java/lang/String:trim	()Ljava/lang/String;
    //   105: invokeinterface 339 2 0
    //   110: pop
    //   111: aload 11
    //   113: invokevirtual 332	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   116: astore 8
    //   118: goto -42 -> 76
    //   121: aload 7
    //   123: invokevirtual 342	java/lang/Process:waitFor	()I
    //   126: pop
    //   127: aload 9
    //   129: invokestatic 346	org/apache/commons/io/ThreadMonitor:stop	(Ljava/lang/Thread;)V
    //   132: aload 7
    //   134: invokevirtual 349	java/lang/Process:exitValue	()I
    //   137: ifne +148 -> 285
    //   140: aload 12
    //   142: invokeinterface 350 1 0
    //   147: ifne +97 -> 244
    //   150: aload 11
    //   152: invokevirtual 353	java/io/BufferedReader:close	()V
    //   155: aload 6
    //   157: invokevirtual 356	java/io/InputStream:close	()V
    //   160: aload 5
    //   162: astore 6
    //   164: aload 5
    //   166: ifnull +22 -> 188
    //   169: aload 5
    //   171: astore 9
    //   173: aload 5
    //   175: astore 11
    //   177: aload 5
    //   179: invokevirtual 359	java/io/OutputStream:close	()V
    //   182: aconst_null
    //   183: astore 6
    //   185: goto +3 -> 188
    //   188: aload 10
    //   190: astore 5
    //   192: aload 10
    //   194: ifnull +19 -> 213
    //   197: aload 6
    //   199: astore 9
    //   201: aload 6
    //   203: astore 11
    //   205: aload 10
    //   207: invokevirtual 356	java/io/InputStream:close	()V
    //   210: aconst_null
    //   211: astore 5
    //   213: aconst_null
    //   214: invokestatic 365	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   217: aload 6
    //   219: invokestatic 368	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   222: aload 5
    //   224: invokestatic 365	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   227: aconst_null
    //   228: invokestatic 370	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   231: aload 7
    //   233: ifnull +8 -> 241
    //   236: aload 7
    //   238: invokevirtual 373	java/lang/Process:destroy	()V
    //   241: aload 12
    //   243: areturn
    //   244: new 154	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   251: astore 8
    //   253: aload 8
    //   255: ldc_w 375
    //   258: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 8
    //   264: aload_1
    //   265: invokestatic 381	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   268: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: new 86	java/io/IOException
    //   275: dup
    //   276: aload 8
    //   278: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokespecial 91	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   284: athrow
    //   285: new 154	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   292: astore 8
    //   294: aload 8
    //   296: ldc_w 383
    //   299: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 8
    //   305: aload 7
    //   307: invokevirtual 349	java/lang/Process:exitValue	()I
    //   310: invokevirtual 385	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 8
    //   316: ldc_w 387
    //   319: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 8
    //   325: aload_1
    //   326: invokestatic 381	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   329: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: new 86	java/io/IOException
    //   336: dup
    //   337: aload 8
    //   339: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokespecial 91	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   345: athrow
    //   346: astore 9
    //   348: aload 7
    //   350: astore 8
    //   352: aload 5
    //   354: astore 7
    //   356: aload 11
    //   358: astore_1
    //   359: aload 9
    //   361: astore 5
    //   363: goto +289 -> 652
    //   366: astore 12
    //   368: aload 6
    //   370: astore 8
    //   372: aload 5
    //   374: astore 9
    //   376: aload 11
    //   378: astore 5
    //   380: aload 12
    //   382: astore 6
    //   384: goto +126 -> 510
    //   387: astore 9
    //   389: aconst_null
    //   390: astore_1
    //   391: aload 7
    //   393: astore 8
    //   395: aload 5
    //   397: astore 7
    //   399: aload 9
    //   401: astore 5
    //   403: goto +249 -> 652
    //   406: astore 11
    //   408: aconst_null
    //   409: astore 12
    //   411: aload 6
    //   413: astore 8
    //   415: aload 5
    //   417: astore 9
    //   419: aload 12
    //   421: astore 5
    //   423: aload 11
    //   425: astore 6
    //   427: goto +83 -> 510
    //   430: astore 9
    //   432: aconst_null
    //   433: astore_1
    //   434: goto +105 -> 539
    //   437: astore 10
    //   439: aconst_null
    //   440: astore 8
    //   442: aload 6
    //   444: astore 11
    //   446: aload 5
    //   448: astore 9
    //   450: aload 10
    //   452: astore 5
    //   454: goto +36 -> 490
    //   457: astore 9
    //   459: aconst_null
    //   460: astore 5
    //   462: goto +74 -> 536
    //   465: astore 5
    //   467: goto +13 -> 480
    //   470: astore 9
    //   472: goto +58 -> 530
    //   475: astore 5
    //   477: aconst_null
    //   478: astore 6
    //   480: aconst_null
    //   481: astore 9
    //   483: aconst_null
    //   484: astore 8
    //   486: aload 6
    //   488: astore 11
    //   490: aload 8
    //   492: astore 10
    //   494: aload 5
    //   496: astore 6
    //   498: aload 10
    //   500: astore 5
    //   502: aload 8
    //   504: astore 10
    //   506: aload 11
    //   508: astore 8
    //   510: aload 7
    //   512: astore 11
    //   514: aload 9
    //   516: astore 7
    //   518: aload 5
    //   520: astore 9
    //   522: goto +58 -> 580
    //   525: astore 9
    //   527: aconst_null
    //   528: astore 7
    //   530: aconst_null
    //   531: astore 6
    //   533: aconst_null
    //   534: astore 5
    //   536: aload 5
    //   538: astore_1
    //   539: aload_1
    //   540: astore 11
    //   542: aload 7
    //   544: astore 8
    //   546: aload 5
    //   548: astore 7
    //   550: aload_1
    //   551: astore 10
    //   553: aload 11
    //   555: astore_1
    //   556: aload 9
    //   558: astore 5
    //   560: goto +92 -> 652
    //   563: astore 6
    //   565: aconst_null
    //   566: astore 8
    //   568: aload 8
    //   570: astore 7
    //   572: aload 7
    //   574: astore 10
    //   576: aload 10
    //   578: astore 9
    //   580: new 154	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   587: astore 5
    //   589: aload 5
    //   591: ldc_w 389
    //   594: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: aload 5
    //   600: aload_1
    //   601: invokestatic 381	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   604: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload 5
    //   610: ldc_w 391
    //   613: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: pop
    //   617: aload 5
    //   619: lload_3
    //   620: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: new 86	java/io/IOException
    //   627: dup
    //   628: aload 5
    //   630: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: aload 6
    //   635: invokespecial 266	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   638: athrow
    //   639: astore 5
    //   641: aload 9
    //   643: astore_1
    //   644: aload 8
    //   646: astore 6
    //   648: aload 11
    //   650: astore 8
    //   652: aload 6
    //   654: invokestatic 365	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   657: aload 7
    //   659: invokestatic 368	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   662: aload 10
    //   664: invokestatic 365	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   667: aload_1
    //   668: invokestatic 370	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   671: aload 8
    //   673: ifnull +8 -> 681
    //   676: aload 8
    //   678: invokevirtual 373	java/lang/Process:destroy	()V
    //   681: goto +6 -> 687
    //   684: aload 5
    //   686: athrow
    //   687: goto -3 -> 684
    //   690: astore 5
    //   692: aconst_null
    //   693: astore 6
    //   695: aload 6
    //   697: astore_1
    //   698: aload 7
    //   700: astore 8
    //   702: aload 9
    //   704: astore 7
    //   706: goto -54 -> 652
    //   709: astore 6
    //   711: aconst_null
    //   712: astore 8
    //   714: aload 8
    //   716: astore 5
    //   718: aload 11
    //   720: astore 9
    //   722: goto -212 -> 510
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	725	0	this	FileSystemUtils
    //   0	725	1	paramArrayOfString	String[]
    //   0	725	2	paramInt	int
    //   0	725	3	paramLong	long
    //   39	422	5	localObject1	Object
    //   465	1	5	localInterruptedException1	java.lang.InterruptedException
    //   475	20	5	localInterruptedException2	java.lang.InterruptedException
    //   500	129	5	localObject2	Object
    //   639	46	5	localObject3	Object
    //   690	1	5	localObject4	Object
    //   716	1	5	localObject5	Object
    //   32	500	6	localObject6	Object
    //   563	71	6	localInterruptedException3	java.lang.InterruptedException
    //   646	50	6	localObject7	Object
    //   709	1	6	localInterruptedException4	java.lang.InterruptedException
    //   25	680	7	localObject8	Object
    //   74	641	8	localObject9	Object
    //   18	182	9	localObject10	Object
    //   346	14	9	localObject11	Object
    //   374	1	9	localObject12	Object
    //   387	13	9	localObject13	Object
    //   417	1	9	localObject14	Object
    //   430	1	9	localObject15	Object
    //   448	1	9	localObject16	Object
    //   457	1	9	localObject17	Object
    //   470	1	9	localObject18	Object
    //   481	40	9	localObject19	Object
    //   525	32	9	localObject20	Object
    //   578	143	9	localObject21	Object
    //   46	160	10	localInputStream	java.io.InputStream
    //   437	14	10	localInterruptedException5	java.lang.InterruptedException
    //   492	171	10	localObject22	Object
    //   12	365	11	localObject23	Object
    //   406	18	11	localInterruptedException6	java.lang.InterruptedException
    //   444	275	11	localObject24	Object
    //   9	233	12	localArrayList	java.util.ArrayList
    //   366	15	12	localInterruptedException7	java.lang.InterruptedException
    //   409	11	12	localObject25	Object
    // Exception table:
    //   from	to	target	type
    //   69	76	346	finally
    //   81	118	346	finally
    //   121	155	346	finally
    //   244	285	346	finally
    //   285	346	346	finally
    //   69	76	366	java/lang/InterruptedException
    //   81	118	366	java/lang/InterruptedException
    //   121	155	366	java/lang/InterruptedException
    //   244	285	366	java/lang/InterruptedException
    //   285	346	366	java/lang/InterruptedException
    //   48	69	387	finally
    //   155	160	387	finally
    //   48	69	406	java/lang/InterruptedException
    //   155	160	406	java/lang/InterruptedException
    //   41	48	430	finally
    //   41	48	437	java/lang/InterruptedException
    //   34	41	457	finally
    //   34	41	465	java/lang/InterruptedException
    //   27	34	470	finally
    //   27	34	475	java/lang/InterruptedException
    //   14	27	525	finally
    //   14	27	563	java/lang/InterruptedException
    //   580	639	639	finally
    //   177	182	690	finally
    //   205	210	690	finally
    //   177	182	709	java/lang/InterruptedException
    //   205	210	709	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.FileSystemUtils
 * JD-Core Version:    0.7.0.1
 */