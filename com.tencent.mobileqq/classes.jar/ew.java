import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ew
{
  public static String a(long paramLong)
  {
    return bacd.a(paramLong);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    Bitmap localBitmap;
    if (apck.a(paramString) == 0) {
      localBitmap = ey.a(paramString, 150, 150);
    }
    for (;;)
    {
      if (localBitmap == null)
      {
        return null;
        if (apck.a(paramString) == 2) {
          localBitmap = ey.c(paramString, 150, 150);
        }
      }
      else
      {
        try
        {
          paramContext = b(paramContext, paramString);
          localBitmap = null;
        }
        catch (FileNotFoundException paramString)
        {
          for (;;)
          {
            try
            {
              apdh.a(localBitmap, paramContext);
              localBitmap.recycle();
              ey.a(paramContext, ey.a(paramString));
              return paramContext;
            }
            catch (IOException paramString)
            {
              continue;
            }
            catch (FileNotFoundException paramString)
            {
              continue;
            }
            paramString = paramString;
            paramContext = null;
            paramString.printStackTrace();
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            paramContext = null;
            paramString.printStackTrace();
          }
        }
        catch (OutOfMemoryError paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
            paramContext = null;
          }
        }
      }
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new File(azzz.a(paramContext) + "thumbnails/");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath() + File.separator + apck.a(paramString1) + "." + paramString2 + ".JPG";
  }
  
  public static void a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          a(arrayOfFile[i]);
          i += 1;
        }
      }
    }
    paramFile.delete();
  }
  
  /* Error */
  public static void a(java.lang.StringBuffer paramStringBuffer, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 117	java/io/FileInputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 118	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_1
    //   13: new 120	java/io/BufferedReader
    //   16: dup
    //   17: new 122	java/io/InputStreamReader
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 125	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: invokespecial 128	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_2
    //   29: aload_2
    //   30: invokevirtual 131	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore 5
    //   35: aload_2
    //   36: astore 4
    //   38: aload_1
    //   39: astore_3
    //   40: aload 5
    //   42: ifnull +33 -> 75
    //   45: aload_0
    //   46: aload 5
    //   48: invokevirtual 136	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   51: pop
    //   52: aload_2
    //   53: invokevirtual 131	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 5
    //   58: goto -23 -> 35
    //   61: astore_3
    //   62: aconst_null
    //   63: astore_0
    //   64: aload_2
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 52	java/io/FileNotFoundException:printStackTrace	()V
    //   70: aload_1
    //   71: astore_3
    //   72: aload_0
    //   73: astore 4
    //   75: aload 4
    //   77: ifnull +8 -> 85
    //   80: aload 4
    //   82: invokevirtual 139	java/io/BufferedReader:close	()V
    //   85: aload_3
    //   86: ifnull +7 -> 93
    //   89: aload_3
    //   90: invokevirtual 142	java/io/InputStream:close	()V
    //   93: return
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_1
    //   97: aload_3
    //   98: astore_2
    //   99: aload_0
    //   100: invokevirtual 53	java/io/IOException:printStackTrace	()V
    //   103: aload_2
    //   104: astore 4
    //   106: aload_1
    //   107: astore_3
    //   108: goto -33 -> 75
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 53	java/io/IOException:printStackTrace	()V
    //   116: goto -31 -> 85
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 53	java/io/IOException:printStackTrace	()V
    //   124: return
    //   125: astore_0
    //   126: aload_3
    //   127: astore_2
    //   128: goto -29 -> 99
    //   131: astore_0
    //   132: goto -33 -> 99
    //   135: astore_3
    //   136: aconst_null
    //   137: astore_0
    //   138: goto -72 -> 66
    //   141: astore_3
    //   142: aload_2
    //   143: astore_0
    //   144: goto -78 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramStringBuffer	java.lang.StringBuffer
    //   0	147	1	paramString	String
    //   3	140	2	localObject1	Object
    //   1	39	3	str1	String
    //   61	6	3	localFileNotFoundException1	FileNotFoundException
    //   71	56	3	str2	String
    //   135	1	3	localFileNotFoundException2	FileNotFoundException
    //   141	1	3	localFileNotFoundException3	FileNotFoundException
    //   36	69	4	localObject2	Object
    //   33	24	5	str3	String
    // Exception table:
    //   from	to	target	type
    //   4	13	61	java/io/FileNotFoundException
    //   4	13	94	java/io/IOException
    //   80	85	111	java/io/IOException
    //   89	93	119	java/io/IOException
    //   13	29	125	java/io/IOException
    //   29	35	131	java/io/IOException
    //   45	58	131	java/io/IOException
    //   13	29	135	java/io/FileNotFoundException
    //   29	35	141	java/io/FileNotFoundException
    //   45	58	141	java/io/FileNotFoundException
  }
  
  /* Error */
  public static boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore_2
    //   8: aload_0
    //   9: invokevirtual 146	java/io/File:isFile	()Z
    //   12: ifeq +138 -> 150
    //   15: aload_1
    //   16: invokevirtual 84	java/io/File:exists	()Z
    //   19: ifeq +8 -> 27
    //   22: aload_1
    //   23: invokevirtual 114	java/io/File:delete	()Z
    //   26: pop
    //   27: new 148	java/io/FileOutputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 150	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: astore 4
    //   37: new 117	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 151	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore 5
    //   47: ldc 152
    //   49: newarray byte
    //   51: astore 6
    //   53: aload 5
    //   55: aload 6
    //   57: invokevirtual 156	java/io/FileInputStream:read	([B)I
    //   60: istore_3
    //   61: iload_3
    //   62: iconst_m1
    //   63: if_icmpeq +67 -> 130
    //   66: aload 4
    //   68: aload 6
    //   70: iconst_0
    //   71: iload_3
    //   72: invokevirtual 160	java/io/FileOutputStream:write	([BII)V
    //   75: aload 4
    //   77: invokevirtual 163	java/io/FileOutputStream:flush	()V
    //   80: goto -27 -> 53
    //   83: astore 6
    //   85: aload 5
    //   87: astore_1
    //   88: aload 4
    //   90: astore_0
    //   91: aload 6
    //   93: astore 4
    //   95: aload 4
    //   97: invokevirtual 53	java/io/IOException:printStackTrace	()V
    //   100: aload_0
    //   101: ifnull +7 -> 108
    //   104: aload_0
    //   105: invokevirtual 164	java/io/FileOutputStream:close	()V
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 165	java/io/FileInputStream:close	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: astore 6
    //   120: sipush 4096
    //   123: newarray byte
    //   125: astore 6
    //   127: goto -74 -> 53
    //   130: aload 4
    //   132: ifnull +8 -> 140
    //   135: aload 4
    //   137: invokevirtual 164	java/io/FileOutputStream:close	()V
    //   140: aload 5
    //   142: ifnull +8 -> 150
    //   145: aload 5
    //   147: invokevirtual 165	java/io/FileInputStream:close	()V
    //   150: aload_0
    //   151: invokevirtual 105	java/io/File:isDirectory	()Z
    //   154: ifeq +102 -> 256
    //   157: aload_0
    //   158: invokevirtual 109	java/io/File:listFiles	()[Ljava/io/File;
    //   161: astore_0
    //   162: aload_1
    //   163: invokevirtual 168	java/io/File:mkdir	()Z
    //   166: pop
    //   167: iload_2
    //   168: aload_0
    //   169: arraylength
    //   170: if_icmpge +86 -> 256
    //   173: aload_0
    //   174: iload_2
    //   175: aaload
    //   176: invokevirtual 172	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   179: new 57	java/io/File
    //   182: dup
    //   183: new 59	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   190: aload_1
    //   191: invokevirtual 172	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   194: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   197: getstatic 94	java/io/File:separator	Ljava/lang/String;
    //   200: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_0
    //   204: iload_2
    //   205: aaload
    //   206: invokevirtual 178	java/io/File:getName	()Ljava/lang/String;
    //   209: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   218: invokestatic 180	ew:a	(Ljava/io/File;Ljava/io/File;)Z
    //   221: pop
    //   222: iload_2
    //   223: iconst_1
    //   224: iadd
    //   225: istore_2
    //   226: goto -59 -> 167
    //   229: astore_0
    //   230: aconst_null
    //   231: astore 4
    //   233: aload 7
    //   235: astore_1
    //   236: aload 4
    //   238: ifnull +8 -> 246
    //   241: aload 4
    //   243: invokevirtual 164	java/io/FileOutputStream:close	()V
    //   246: aload_1
    //   247: ifnull +7 -> 254
    //   250: aload_1
    //   251: invokevirtual 165	java/io/FileInputStream:close	()V
    //   254: aload_0
    //   255: athrow
    //   256: iconst_1
    //   257: ireturn
    //   258: astore 4
    //   260: goto -120 -> 140
    //   263: astore 4
    //   265: goto -115 -> 150
    //   268: astore_0
    //   269: goto -161 -> 108
    //   272: astore_0
    //   273: iconst_0
    //   274: ireturn
    //   275: astore 4
    //   277: goto -31 -> 246
    //   280: astore_1
    //   281: goto -27 -> 254
    //   284: astore_0
    //   285: aload 7
    //   287: astore_1
    //   288: goto -52 -> 236
    //   291: astore_0
    //   292: aload 5
    //   294: astore_1
    //   295: goto -59 -> 236
    //   298: astore 5
    //   300: aload_0
    //   301: astore 4
    //   303: aload 5
    //   305: astore_0
    //   306: goto -70 -> 236
    //   309: astore 4
    //   311: aconst_null
    //   312: astore_0
    //   313: aload 6
    //   315: astore_1
    //   316: goto -221 -> 95
    //   319: astore_1
    //   320: aload 4
    //   322: astore_0
    //   323: aload_1
    //   324: astore 4
    //   326: aload 6
    //   328: astore_1
    //   329: goto -234 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramFile1	File
    //   0	332	1	paramFile2	File
    //   7	219	2	i	int
    //   60	12	3	j	int
    //   35	207	4	localObject1	Object
    //   258	1	4	localIOException1	IOException
    //   263	1	4	localIOException2	IOException
    //   275	1	4	localIOException3	IOException
    //   301	1	4	localFile1	File
    //   309	12	4	localIOException4	IOException
    //   324	1	4	localFile2	File
    //   45	248	5	localFileInputStream	java.io.FileInputStream
    //   298	6	5	localObject2	Object
    //   4	65	6	arrayOfByte1	byte[]
    //   83	9	6	localIOException5	IOException
    //   118	1	6	localOutOfMemoryError	OutOfMemoryError
    //   125	202	6	arrayOfByte2	byte[]
    //   1	285	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   47	53	83	java/io/IOException
    //   53	61	83	java/io/IOException
    //   66	80	83	java/io/IOException
    //   120	127	83	java/io/IOException
    //   47	53	118	java/lang/OutOfMemoryError
    //   15	27	229	finally
    //   27	37	229	finally
    //   135	140	258	java/io/IOException
    //   145	150	263	java/io/IOException
    //   104	108	268	java/io/IOException
    //   112	116	272	java/io/IOException
    //   241	246	275	java/io/IOException
    //   250	254	280	java/io/IOException
    //   37	47	284	finally
    //   47	53	291	finally
    //   53	61	291	finally
    //   66	80	291	finally
    //   120	127	291	finally
    //   95	100	298	finally
    //   15	27	309	java/io/IOException
    //   27	37	309	java/io/IOException
    //   37	47	319	java/io/IOException
  }
  
  public static String b(Context paramContext, String paramString)
  {
    paramContext = new File(azzz.a(paramContext) + "thumbnails/");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath() + File.separator + apck.a(paramString) + ".JPG";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ew
 * JD-Core Version:    0.7.0.1
 */