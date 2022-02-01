package cooperation.qzone.util;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtils
{
  public static final int CPY_BUFFER_SIZE = 4096;
  public static final String TAG = "FileUtils";
  public static final int ZIP_BUFFER_SIZE = 4096;
  public static final String ZIP_FILE_EXT = ".zip";
  
  private static String byteArrayToHex(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[16];
    char[] tmp8_6 = arrayOfChar1;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 65;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 66;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 67;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 68;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 69;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 70;
    tmp92_86;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar2[j] = arrayOfChar1[(m >>> 4 & 0xF)];
      j = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  /* Error */
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: new 49	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 52	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: new 54	java/io/BufferedOutputStream
    //   20: dup
    //   21: new 56	java/io/FileOutputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 57	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 60	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore_1
    //   33: sipush 4096
    //   36: newarray byte
    //   38: astore 4
    //   40: aload_0
    //   41: aload 4
    //   43: invokevirtual 64	java/io/FileInputStream:read	([B)I
    //   46: istore_2
    //   47: iconst_m1
    //   48: iload_2
    //   49: if_icmpeq +14 -> 63
    //   52: aload_1
    //   53: aload 4
    //   55: iconst_0
    //   56: iload_2
    //   57: invokevirtual 68	java/io/BufferedOutputStream:write	([BII)V
    //   60: goto -20 -> 40
    //   63: aload_1
    //   64: invokevirtual 71	java/io/BufferedOutputStream:flush	()V
    //   67: iconst_1
    //   68: istore_3
    //   69: aload_1
    //   70: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   73: pop
    //   74: goto +61 -> 135
    //   77: astore 5
    //   79: aload_0
    //   80: astore 4
    //   82: aload 5
    //   84: astore_0
    //   85: goto +27 -> 112
    //   88: goto +42 -> 130
    //   91: astore 6
    //   93: aload 5
    //   95: astore_1
    //   96: aload_0
    //   97: astore 4
    //   99: aload 6
    //   101: astore_0
    //   102: goto +10 -> 112
    //   105: astore_0
    //   106: aconst_null
    //   107: astore 4
    //   109: aload 5
    //   111: astore_1
    //   112: aload_1
    //   113: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   116: pop
    //   117: aload 4
    //   119: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   122: pop
    //   123: aload_0
    //   124: athrow
    //   125: aconst_null
    //   126: astore_0
    //   127: aload 4
    //   129: astore_1
    //   130: aload_1
    //   131: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   134: pop
    //   135: aload_0
    //   136: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   139: pop
    //   140: iload_3
    //   141: ireturn
    //   142: astore_0
    //   143: goto -18 -> 125
    //   146: astore_1
    //   147: aload 4
    //   149: astore_1
    //   150: goto -20 -> 130
    //   153: astore 4
    //   155: goto -67 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramFile1	File
    //   0	158	1	paramFile2	File
    //   46	11	2	i	int
    //   1	140	3	bool	boolean
    //   3	145	4	localObject1	Object
    //   153	1	4	localIOException	IOException
    //   6	1	5	localObject2	Object
    //   77	33	5	localObject3	Object
    //   91	9	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   33	40	77	finally
    //   40	47	77	finally
    //   52	60	77	finally
    //   63	67	77	finally
    //   17	33	91	finally
    //   8	17	105	finally
    //   8	17	142	java/io/IOException
    //   17	33	146	java/io/IOException
    //   33	40	153	java/io/IOException
    //   40	47	153	java/io/IOException
    //   52	60	153	java/io/IOException
    //   63	67	153	java/io/IOException
  }
  
  public static boolean deleteFile(File paramFile)
  {
    int i = 0;
    if (paramFile != null)
    {
      if (paramFile.isFile())
      {
        if (!paramFile.delete())
        {
          paramFile.deleteOnExit();
          return false;
        }
        return true;
      }
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null)
        {
          int j = arrayOfFile.length;
          while (i < j)
          {
            deleteFile(arrayOfFile[i]);
            i += 1;
          }
        }
        return paramFile.delete();
      }
    }
    return false;
  }
  
  public static void doZip(ZipOutputStream paramZipOutputStream, File paramFile, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramZipOutputStream != null) && (paramFile != null))
    {
      if (paramFile.exists())
      {
        if (TextUtils.isEmpty(paramString))
        {
          paramString = paramFile.getName();
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(paramFile.getName());
          paramString = localStringBuilder.toString();
        }
        boolean bool = paramFile.isFile();
        int i = 0;
        if (bool)
        {
          try
          {
            paramFile = new BufferedInputStream(new FileInputStream(paramFile));
            try
            {
              paramZipOutputStream.putNextEntry(new ZipEntry(paramString));
              for (;;)
              {
                i = paramFile.read(paramArrayOfByte, 0, paramArrayOfByte.length);
                if (-1 == i) {
                  break;
                }
                paramZipOutputStream.write(paramArrayOfByte, 0, i);
              }
              DataUtils.closeDataObject(paramFile);
              return;
            }
            catch (IOException paramString)
            {
              paramZipOutputStream = paramFile;
              paramFile = paramString;
            }
            DataUtils.closeDataObject(paramZipOutputStream);
          }
          catch (IOException paramFile)
          {
            paramZipOutputStream = null;
          }
          throw paramFile;
        }
        if (paramFile.isDirectory())
        {
          paramFile = paramFile.listFiles();
          int j = paramFile.length;
          while (i < j)
          {
            doZip(paramZipOutputStream, paramFile[i], paramString, paramArrayOfByte);
            i += 1;
          }
        }
        return;
      }
      throw new FileNotFoundException("Target File is missing");
    }
    paramZipOutputStream = new IOException("I/O Object got NullPointerException");
    for (;;)
    {
      throw paramZipOutputStream;
    }
  }
  
  /* Error */
  private static String encodeFile(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 166
    //   2: astore 6
    //   4: aload_0
    //   5: ifnull +275 -> 280
    //   8: aload_0
    //   9: invokevirtual 170	java/lang/String:length	()I
    //   12: ifne +6 -> 18
    //   15: ldc 166
    //   17: areturn
    //   18: new 81	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 171	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 7
    //   28: aload 7
    //   30: invokevirtual 105	java/io/File:exists	()Z
    //   33: ifeq +216 -> 249
    //   36: aload 7
    //   38: invokevirtual 85	java/io/File:isFile	()Z
    //   41: ifne +6 -> 47
    //   44: goto +205 -> 249
    //   47: aconst_null
    //   48: astore 5
    //   50: aconst_null
    //   51: astore_0
    //   52: aload_0
    //   53: astore 4
    //   55: aload 5
    //   57: astore_3
    //   58: new 130	java/io/BufferedInputStream
    //   61: dup
    //   62: new 49	java/io/FileInputStream
    //   65: dup
    //   66: aload 7
    //   68: invokespecial 52	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: sipush 8192
    //   74: invokespecial 174	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   77: astore 7
    //   79: iload_1
    //   80: ifeq +207 -> 287
    //   83: aload_0
    //   84: astore 4
    //   86: aload 5
    //   88: astore_3
    //   89: new 176	java/util/zip/GZIPInputStream
    //   92: dup
    //   93: aload 7
    //   95: invokespecial 177	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   98: astore_0
    //   99: goto +3 -> 102
    //   102: aload_0
    //   103: astore 4
    //   105: aload_0
    //   106: astore_3
    //   107: ldc 179
    //   109: invokestatic 185	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   112: astore 7
    //   114: aload_0
    //   115: astore 4
    //   117: aload_0
    //   118: astore_3
    //   119: sipush 16384
    //   122: newarray byte
    //   124: astore 5
    //   126: goto +15 -> 141
    //   129: aload_0
    //   130: astore 4
    //   132: aload_0
    //   133: astore_3
    //   134: sipush 4096
    //   137: newarray byte
    //   139: astore 5
    //   141: aload_0
    //   142: astore 4
    //   144: aload_0
    //   145: astore_3
    //   146: aload_0
    //   147: aload 5
    //   149: invokevirtual 188	java/io/InputStream:read	([B)I
    //   152: istore_2
    //   153: iload_2
    //   154: iconst_m1
    //   155: if_icmpeq +20 -> 175
    //   158: aload_0
    //   159: astore 4
    //   161: aload_0
    //   162: astore_3
    //   163: aload 7
    //   165: aload 5
    //   167: iconst_0
    //   168: iload_2
    //   169: invokevirtual 191	java/security/MessageDigest:update	([BII)V
    //   172: goto -31 -> 141
    //   175: aload_0
    //   176: astore 4
    //   178: aload_0
    //   179: astore_3
    //   180: aload 7
    //   182: invokevirtual 195	java/security/MessageDigest:digest	()[B
    //   185: invokestatic 197	cooperation/qzone/util/FileUtils:byteArrayToHex	([B)Ljava/lang/String;
    //   188: astore 5
    //   190: goto +43 -> 233
    //   193: astore_0
    //   194: goto +47 -> 241
    //   197: astore 7
    //   199: aload_3
    //   200: astore 4
    //   202: aload 6
    //   204: astore 5
    //   206: aload_3
    //   207: astore_0
    //   208: invokestatic 202	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq +22 -> 233
    //   214: aload_3
    //   215: astore 4
    //   217: ldc 11
    //   219: iconst_2
    //   220: ldc 204
    //   222: aload 7
    //   224: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   227: aload_3
    //   228: astore_0
    //   229: aload 6
    //   231: astore 5
    //   233: aload_0
    //   234: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   237: pop
    //   238: aload 5
    //   240: areturn
    //   241: aload 4
    //   243: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   246: pop
    //   247: aload_0
    //   248: athrow
    //   249: new 117	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   256: astore_3
    //   257: aload_3
    //   258: ldc 210
    //   260: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload_3
    //   265: aload_0
    //   266: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: ldc 11
    //   272: iconst_2
    //   273: aload_3
    //   274: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 214	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: ldc 166
    //   282: areturn
    //   283: astore_3
    //   284: goto -155 -> 129
    //   287: aload 7
    //   289: astore_0
    //   290: goto -188 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramString	String
    //   0	293	1	paramBoolean	boolean
    //   152	17	2	i	int
    //   57	217	3	localObject1	Object
    //   283	1	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   53	189	4	localObject2	Object
    //   48	191	5	localObject3	Object
    //   2	228	6	str	String
    //   26	155	7	localObject4	Object
    //   197	91	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   58	79	193	finally
    //   89	99	193	finally
    //   107	114	193	finally
    //   119	126	193	finally
    //   134	141	193	finally
    //   146	153	193	finally
    //   163	172	193	finally
    //   180	190	193	finally
    //   208	214	193	finally
    //   217	227	193	finally
    //   58	79	197	java/lang/Exception
    //   89	99	197	java/lang/Exception
    //   107	114	197	java/lang/Exception
    //   119	126	197	java/lang/Exception
    //   134	141	197	java/lang/Exception
    //   146	153	197	java/lang/Exception
    //   163	172	197	java/lang/Exception
    //   180	190	197	java/lang/Exception
    //   119	126	283	java/lang/OutOfMemoryError
  }
  
  public static long getFileSize(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    try
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        long l = paramString.length();
        return l;
      }
      return 0L;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public static String getWebFileSuffix(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf('/');
    if (i != -1) {
      paramString = paramString.substring(i);
    }
    i = paramString.lastIndexOf('.');
    if (i == -1) {
      return "";
    }
    return paramString.substring(i);
  }
  
  /* Error */
  public static String readStringFromFile(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: new 236	java/io/BufferedReader
    //   11: dup
    //   12: new 238	java/io/FileReader
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 239	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   20: invokespecial 242	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: astore_0
    //   24: aload_0
    //   25: astore_1
    //   26: new 117	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   33: astore_2
    //   34: aload_0
    //   35: astore_1
    //   36: aload_0
    //   37: invokevirtual 245	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore 4
    //   42: aload 4
    //   44: ifnull +24 -> 68
    //   47: aload_0
    //   48: astore_1
    //   49: aload_2
    //   50: aload 4
    //   52: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_0
    //   57: astore_1
    //   58: aload_2
    //   59: ldc 247
    //   61: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: goto -31 -> 34
    //   68: aload_0
    //   69: astore_1
    //   70: aload_2
    //   71: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore_2
    //   75: aload_2
    //   76: astore_1
    //   77: goto +24 -> 101
    //   80: astore_2
    //   81: goto +12 -> 93
    //   84: astore_0
    //   85: aconst_null
    //   86: astore_1
    //   87: goto +22 -> 109
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_0
    //   93: aload_0
    //   94: astore_1
    //   95: aload_2
    //   96: invokevirtual 222	java/lang/Exception:printStackTrace	()V
    //   99: aload_3
    //   100: astore_1
    //   101: aload_0
    //   102: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   105: pop
    //   106: aload_1
    //   107: areturn
    //   108: astore_0
    //   109: aload_1
    //   110: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   113: pop
    //   114: goto +5 -> 119
    //   117: aload_0
    //   118: athrow
    //   119: goto -2 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramFile	File
    //   25	85	1	localObject1	Object
    //   33	43	2	localObject2	Object
    //   80	1	2	localException1	Exception
    //   90	6	2	localException2	Exception
    //   1	99	3	localObject3	Object
    //   40	11	4	str	String
    // Exception table:
    //   from	to	target	type
    //   26	34	80	java/lang/Exception
    //   36	42	80	java/lang/Exception
    //   49	56	80	java/lang/Exception
    //   58	65	80	java/lang/Exception
    //   70	75	80	java/lang/Exception
    //   8	24	84	finally
    //   8	24	90	java/lang/Exception
    //   26	34	108	finally
    //   36	42	108	finally
    //   49	56	108	finally
    //   58	65	108	finally
    //   70	75	108	finally
    //   95	99	108	finally
  }
  
  public static String sourceFileMd5(String paramString, boolean paramBoolean)
  {
    paramString = encodeFile(paramString, paramBoolean);
    if (paramString != null) {
      return paramString.toLowerCase();
    }
    return "";
  }
  
  /* Error */
  public static boolean unzip(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: iload 5
    //   8: istore_3
    //   9: aload_0
    //   10: ifnull +296 -> 306
    //   13: iload 5
    //   15: istore_3
    //   16: aload_0
    //   17: invokevirtual 219	java/io/File:length	()J
    //   20: lconst_1
    //   21: lcmp
    //   22: iflt +284 -> 306
    //   25: aload_0
    //   26: invokevirtual 257	java/io/File:canRead	()Z
    //   29: ifne +5 -> 34
    //   32: iconst_0
    //   33: ireturn
    //   34: aload_1
    //   35: invokevirtual 105	java/io/File:exists	()Z
    //   38: ifne +8 -> 46
    //   41: aload_1
    //   42: invokevirtual 260	java/io/File:mkdirs	()Z
    //   45: pop
    //   46: sipush 8192
    //   49: newarray byte
    //   51: astore 10
    //   53: aconst_null
    //   54: astore 6
    //   56: aconst_null
    //   57: astore 8
    //   59: aconst_null
    //   60: astore 9
    //   62: new 262	com/tencent/commonsdk/zip/QZipInputStream
    //   65: dup
    //   66: new 130	java/io/BufferedInputStream
    //   69: dup
    //   70: new 49	java/io/FileInputStream
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 52	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   78: invokespecial 133	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: invokespecial 263	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: astore 7
    //   86: aload 9
    //   88: astore_0
    //   89: aload 7
    //   91: invokevirtual 267	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   94: astore 6
    //   96: aload 6
    //   98: ifnull +149 -> 247
    //   101: aload 6
    //   103: invokevirtual 268	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   106: astore 8
    //   108: aload 8
    //   110: ldc_w 270
    //   113: invokevirtual 273	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   116: ifeq +6 -> 122
    //   119: goto -30 -> 89
    //   122: aload 6
    //   124: invokevirtual 274	java/util/zip/ZipEntry:isDirectory	()Z
    //   127: ifeq +20 -> 147
    //   130: new 81	java/io/File
    //   133: dup
    //   134: aload_1
    //   135: aload 8
    //   137: invokespecial 277	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   140: invokevirtual 260	java/io/File:mkdirs	()Z
    //   143: pop
    //   144: goto -55 -> 89
    //   147: new 81	java/io/File
    //   150: dup
    //   151: aload_1
    //   152: aload 8
    //   154: invokespecial 277	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   157: astore 6
    //   159: aload 6
    //   161: invokevirtual 281	java/io/File:getParentFile	()Ljava/io/File;
    //   164: invokevirtual 260	java/io/File:mkdirs	()Z
    //   167: pop
    //   168: new 54	java/io/BufferedOutputStream
    //   171: dup
    //   172: new 56	java/io/FileOutputStream
    //   175: dup
    //   176: aload 6
    //   178: invokespecial 57	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   181: invokespecial 60	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   184: astore 6
    //   186: aload 7
    //   188: aload 10
    //   190: iconst_0
    //   191: aload 10
    //   193: arraylength
    //   194: invokevirtual 282	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   197: istore_2
    //   198: iconst_m1
    //   199: iload_2
    //   200: if_icmpeq +15 -> 215
    //   203: aload 6
    //   205: aload 10
    //   207: iconst_0
    //   208: iload_2
    //   209: invokevirtual 68	java/io/BufferedOutputStream:write	([BII)V
    //   212: goto -26 -> 186
    //   215: aload 6
    //   217: invokevirtual 71	java/io/BufferedOutputStream:flush	()V
    //   220: aload 6
    //   222: invokevirtual 285	java/io/BufferedOutputStream:close	()V
    //   225: aload 6
    //   227: astore_0
    //   228: goto -139 -> 89
    //   231: astore_1
    //   232: aload 6
    //   234: astore_0
    //   235: goto +38 -> 273
    //   238: aload 6
    //   240: astore_0
    //   241: iload 4
    //   243: istore_3
    //   244: goto +51 -> 295
    //   247: aload 7
    //   249: invokevirtual 288	com/tencent/commonsdk/zip/QZipInputStream:closeEntry	()V
    //   252: aload 7
    //   254: invokevirtual 289	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   257: iconst_1
    //   258: istore_3
    //   259: goto +36 -> 295
    //   262: astore_1
    //   263: goto +10 -> 273
    //   266: astore_1
    //   267: aconst_null
    //   268: astore 7
    //   270: aload 6
    //   272: astore_0
    //   273: aload_0
    //   274: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   277: pop
    //   278: aload 7
    //   280: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   283: pop
    //   284: aload_1
    //   285: athrow
    //   286: aconst_null
    //   287: astore 7
    //   289: aload 8
    //   291: astore_0
    //   292: iload 4
    //   294: istore_3
    //   295: aload_0
    //   296: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   299: pop
    //   300: aload 7
    //   302: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   305: pop
    //   306: iload_3
    //   307: ireturn
    //   308: astore_0
    //   309: goto -23 -> 286
    //   312: astore_1
    //   313: iload 4
    //   315: istore_3
    //   316: goto -21 -> 295
    //   319: astore_0
    //   320: goto -82 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramFile1	File
    //   0	323	1	paramFile2	File
    //   197	12	2	i	int
    //   8	308	3	bool1	boolean
    //   4	310	4	bool2	boolean
    //   1	13	5	bool3	boolean
    //   54	217	6	localObject1	Object
    //   84	217	7	localQZipInputStream	com.tencent.commonsdk.zip.QZipInputStream
    //   57	233	8	str	String
    //   60	27	9	localObject2	Object
    //   51	155	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   186	198	231	finally
    //   203	212	231	finally
    //   215	225	231	finally
    //   89	96	262	finally
    //   101	119	262	finally
    //   122	144	262	finally
    //   147	186	262	finally
    //   247	257	262	finally
    //   62	86	266	finally
    //   62	86	308	java/io/IOException
    //   89	96	312	java/io/IOException
    //   101	119	312	java/io/IOException
    //   122	144	312	java/io/IOException
    //   147	186	312	java/io/IOException
    //   247	257	312	java/io/IOException
    //   186	198	319	java/io/IOException
    //   203	212	319	java/io/IOException
    //   215	225	319	java/io/IOException
  }
  
  /* Error */
  public static java.util.List<File> unzipFiles(File paramFile1, File paramFile2, java.util.Set<String> paramSet)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: ifnull +319 -> 329
    //   13: aload_0
    //   14: invokevirtual 219	java/io/File:length	()J
    //   17: lconst_1
    //   18: lcmp
    //   19: iflt +310 -> 329
    //   22: aload_0
    //   23: invokevirtual 257	java/io/File:canRead	()Z
    //   26: ifne +5 -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: new 293	java/util/ArrayList
    //   34: dup
    //   35: invokespecial 294	java/util/ArrayList:<init>	()V
    //   38: astore 8
    //   40: aload_1
    //   41: invokevirtual 105	java/io/File:exists	()Z
    //   44: ifne +8 -> 52
    //   47: aload_1
    //   48: invokevirtual 260	java/io/File:mkdirs	()Z
    //   51: pop
    //   52: sipush 8192
    //   55: newarray byte
    //   57: astore 9
    //   59: new 262	com/tencent/commonsdk/zip/QZipInputStream
    //   62: dup
    //   63: new 49	java/io/FileInputStream
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 52	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: invokespecial 263	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   74: astore 5
    //   76: aload 7
    //   78: astore_0
    //   79: aload 5
    //   81: invokevirtual 267	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   84: astore 4
    //   86: aload 4
    //   88: ifnull +184 -> 272
    //   91: aload 4
    //   93: invokevirtual 268	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   96: astore 6
    //   98: aload_2
    //   99: aload 6
    //   101: invokeinterface 298 2 0
    //   106: ifne +6 -> 112
    //   109: goto -30 -> 79
    //   112: aload 6
    //   114: ldc_w 270
    //   117: invokevirtual 273	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   120: ifeq +6 -> 126
    //   123: goto -44 -> 79
    //   126: aload 4
    //   128: invokevirtual 274	java/util/zip/ZipEntry:isDirectory	()Z
    //   131: ifeq +34 -> 165
    //   134: new 81	java/io/File
    //   137: dup
    //   138: aload_1
    //   139: aload 6
    //   141: invokespecial 277	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   144: astore 4
    //   146: aload 4
    //   148: invokevirtual 260	java/io/File:mkdirs	()Z
    //   151: pop
    //   152: aload 8
    //   154: aload 4
    //   156: invokeinterface 303 2 0
    //   161: pop
    //   162: goto -83 -> 79
    //   165: new 81	java/io/File
    //   168: dup
    //   169: aload_1
    //   170: aload 6
    //   172: invokespecial 277	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   175: astore 6
    //   177: aload 6
    //   179: invokevirtual 281	java/io/File:getParentFile	()Ljava/io/File;
    //   182: invokevirtual 260	java/io/File:mkdirs	()Z
    //   185: pop
    //   186: new 54	java/io/BufferedOutputStream
    //   189: dup
    //   190: new 56	java/io/FileOutputStream
    //   193: dup
    //   194: aload 6
    //   196: invokespecial 57	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   199: invokespecial 60	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   202: astore 4
    //   204: aload 5
    //   206: aload 9
    //   208: iconst_0
    //   209: aload 9
    //   211: arraylength
    //   212: invokevirtual 282	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   215: istore_3
    //   216: iconst_m1
    //   217: iload_3
    //   218: if_icmpeq +15 -> 233
    //   221: aload 4
    //   223: aload 9
    //   225: iconst_0
    //   226: iload_3
    //   227: invokevirtual 68	java/io/BufferedOutputStream:write	([BII)V
    //   230: goto -26 -> 204
    //   233: aload 4
    //   235: invokevirtual 71	java/io/BufferedOutputStream:flush	()V
    //   238: aload 4
    //   240: invokevirtual 285	java/io/BufferedOutputStream:close	()V
    //   243: aload 8
    //   245: aload 6
    //   247: invokeinterface 303 2 0
    //   252: pop
    //   253: aload 4
    //   255: astore_0
    //   256: goto -177 -> 79
    //   259: astore_1
    //   260: aload 4
    //   262: astore_0
    //   263: goto +33 -> 296
    //   266: aload 4
    //   268: astore_0
    //   269: goto +46 -> 315
    //   272: aload 5
    //   274: invokevirtual 288	com/tencent/commonsdk/zip/QZipInputStream:closeEntry	()V
    //   277: aload 5
    //   279: invokevirtual 289	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   282: goto +33 -> 315
    //   285: astore_1
    //   286: goto +10 -> 296
    //   289: astore_1
    //   290: aconst_null
    //   291: astore 5
    //   293: aload 4
    //   295: astore_0
    //   296: aload_0
    //   297: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   300: pop
    //   301: aload 5
    //   303: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   306: pop
    //   307: aload_1
    //   308: athrow
    //   309: aconst_null
    //   310: astore 5
    //   312: aload 6
    //   314: astore_0
    //   315: aload_0
    //   316: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   319: pop
    //   320: aload 5
    //   322: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   325: pop
    //   326: aload 8
    //   328: areturn
    //   329: aconst_null
    //   330: areturn
    //   331: astore_0
    //   332: goto -23 -> 309
    //   335: astore_1
    //   336: goto -21 -> 315
    //   339: astore_0
    //   340: goto -74 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	paramFile1	File
    //   0	343	1	paramFile2	File
    //   0	343	2	paramSet	java.util.Set<String>
    //   215	12	3	i	int
    //   1	293	4	localObject1	Object
    //   74	247	5	localQZipInputStream	com.tencent.commonsdk.zip.QZipInputStream
    //   4	309	6	localObject2	Object
    //   7	70	7	localObject3	Object
    //   38	289	8	localArrayList	java.util.ArrayList
    //   57	167	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   204	216	259	finally
    //   221	230	259	finally
    //   233	253	259	finally
    //   79	86	285	finally
    //   91	109	285	finally
    //   112	123	285	finally
    //   126	162	285	finally
    //   165	204	285	finally
    //   272	282	285	finally
    //   59	76	289	finally
    //   59	76	331	java/io/IOException
    //   79	86	335	java/io/IOException
    //   91	109	335	java/io/IOException
    //   112	123	335	java/io/IOException
    //   126	162	335	java/io/IOException
    //   165	204	335	java/io/IOException
    //   272	282	335	java/io/IOException
    //   204	216	339	java/io/IOException
    //   221	230	339	java/io/IOException
    //   233	253	339	java/io/IOException
  }
  
  public static boolean zip(File paramFile1, File paramFile2)
  {
    return zip(new File[] { paramFile1 }, paramFile2);
  }
  
  /* Error */
  public static boolean zip(File[] paramArrayOfFile, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +123 -> 124
    //   4: aload_0
    //   5: arraylength
    //   6: iconst_1
    //   7: if_icmplt +117 -> 124
    //   10: aload_1
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 4
    //   22: sipush 4096
    //   25: newarray byte
    //   27: astore 6
    //   29: new 140	java/util/zip/ZipOutputStream
    //   32: dup
    //   33: new 54	java/io/BufferedOutputStream
    //   36: dup
    //   37: new 56	java/io/FileOutputStream
    //   40: dup
    //   41: aload_1
    //   42: iconst_0
    //   43: invokespecial 312	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   46: invokespecial 60	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   49: invokespecial 313	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   52: astore_1
    //   53: aload_0
    //   54: arraylength
    //   55: istore_3
    //   56: iconst_0
    //   57: istore_2
    //   58: iload_2
    //   59: iload_3
    //   60: if_icmpge +20 -> 80
    //   63: aload_1
    //   64: aload_0
    //   65: iload_2
    //   66: aaload
    //   67: aconst_null
    //   68: aload 6
    //   70: invokestatic 150	cooperation/qzone/util/FileUtils:doZip	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;[B)V
    //   73: iload_2
    //   74: iconst_1
    //   75: iadd
    //   76: istore_2
    //   77: goto -19 -> 58
    //   80: aload_1
    //   81: invokevirtual 314	java/util/zip/ZipOutputStream:flush	()V
    //   84: aload_1
    //   85: invokevirtual 315	java/util/zip/ZipOutputStream:closeEntry	()V
    //   88: aload_1
    //   89: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   92: pop
    //   93: iconst_1
    //   94: ireturn
    //   95: astore 4
    //   97: aload_1
    //   98: astore_0
    //   99: aload 4
    //   101: astore_1
    //   102: goto +10 -> 112
    //   105: goto +14 -> 119
    //   108: astore_1
    //   109: aload 4
    //   111: astore_0
    //   112: aload_0
    //   113: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   116: pop
    //   117: aload_1
    //   118: athrow
    //   119: aload_1
    //   120: invokestatic 77	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   123: pop
    //   124: iconst_0
    //   125: ireturn
    //   126: astore_0
    //   127: aload 5
    //   129: astore_1
    //   130: goto -11 -> 119
    //   133: astore_0
    //   134: goto -29 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramArrayOfFile	File[]
    //   0	137	1	paramFile	File
    //   57	20	2	i	int
    //   55	6	3	j	int
    //   20	1	4	localObject1	Object
    //   95	15	4	localObject2	Object
    //   17	111	5	localObject3	Object
    //   27	42	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   53	56	95	finally
    //   63	73	95	finally
    //   80	88	95	finally
    //   22	53	108	finally
    //   22	53	126	java/io/IOException
    //   53	56	133	java/io/IOException
    //   63	73	133	java/io/IOException
    //   80	88	133	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.FileUtils
 * JD-Core Version:    0.7.0.1
 */