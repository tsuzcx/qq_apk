import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class fd
{
  public static String a(long paramLong)
  {
    return bfvi.a(paramLong);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    Bitmap localBitmap;
    if (aszt.a(paramString) == 0) {
      localBitmap = ff.a(paramString, 150, 150);
    }
    for (;;)
    {
      if (localBitmap == null)
      {
        return null;
        if (aszt.a(paramString) == 2) {
          localBitmap = ff.c(paramString, 150, 150);
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
              FileUtil.writeBitmapToFile(localBitmap, paramContext);
              localBitmap.recycle();
              ff.a(paramContext, ff.a(paramString));
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
    paramContext = new VFSFile(bftf.a(paramContext) + "thumbnails/");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath() + "/" + aszt.a(paramString1) + "." + paramString2 + ".JPG";
  }
  
  public static void a(VFSFile paramVFSFile)
  {
    if (paramVFSFile.isDirectory())
    {
      VFSFile[] arrayOfVFSFile = paramVFSFile.listFiles();
      if ((arrayOfVFSFile != null) && (arrayOfVFSFile.length > 0))
      {
        int i = 0;
        while (i < arrayOfVFSFile.length)
        {
          a(arrayOfVFSFile[i]);
          i += 1;
        }
      }
    }
    paramVFSFile.delete();
  }
  
  public static void a(File paramFile)
  {
    a(new VFSFile(paramFile));
  }
  
  /* Error */
  public static void a(java.lang.StringBuffer paramStringBuffer, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 119	java/io/FileInputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 120	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_1
    //   13: new 122	java/io/BufferedReader
    //   16: dup
    //   17: new 124	java/io/InputStreamReader
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 127	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: invokespecial 130	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_2
    //   29: aload_2
    //   30: invokevirtual 133	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore 5
    //   35: aload_2
    //   36: astore 4
    //   38: aload_1
    //   39: astore_3
    //   40: aload 5
    //   42: ifnull +33 -> 75
    //   45: aload_0
    //   46: aload 5
    //   48: invokevirtual 138	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   51: pop
    //   52: aload_2
    //   53: invokevirtual 133	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 5
    //   58: goto -23 -> 35
    //   61: astore_3
    //   62: aconst_null
    //   63: astore_0
    //   64: aload_2
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 53	java/io/FileNotFoundException:printStackTrace	()V
    //   70: aload_1
    //   71: astore_3
    //   72: aload_0
    //   73: astore 4
    //   75: aload 4
    //   77: ifnull +8 -> 85
    //   80: aload 4
    //   82: invokevirtual 141	java/io/BufferedReader:close	()V
    //   85: aload_3
    //   86: ifnull +7 -> 93
    //   89: aload_3
    //   90: invokevirtual 144	java/io/InputStream:close	()V
    //   93: return
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_1
    //   97: aload_3
    //   98: astore_2
    //   99: aload_0
    //   100: invokevirtual 54	java/io/IOException:printStackTrace	()V
    //   103: aload_2
    //   104: astore 4
    //   106: aload_1
    //   107: astore_3
    //   108: goto -33 -> 75
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 54	java/io/IOException:printStackTrace	()V
    //   116: goto -31 -> 85
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 54	java/io/IOException:printStackTrace	()V
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
  public static boolean a(VFSFile paramVFSFile1, VFSFile paramVFSFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore_2
    //   8: aload_0
    //   9: invokevirtual 148	com/tencent/mm/vfs/VFSFile:isFile	()Z
    //   12: ifeq +149 -> 161
    //   15: aload_1
    //   16: invokevirtual 85	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   19: ifeq +19 -> 38
    //   22: aload_0
    //   23: invokevirtual 91	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   26: aload_1
    //   27: invokevirtual 91	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   30: invokestatic 153	bajv:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_1
    //   34: invokevirtual 113	com/tencent/mm/vfs/VFSFile:delete	()Z
    //   37: pop
    //   38: new 155	com/tencent/mm/vfs/VFSFileOutputStream
    //   41: dup
    //   42: aload_1
    //   43: invokespecial 157	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   46: astore 4
    //   48: new 159	com/tencent/mm/vfs/VFSFileInputStream
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 160	com/tencent/mm/vfs/VFSFileInputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   56: astore 5
    //   58: ldc 161
    //   60: newarray byte
    //   62: astore 6
    //   64: aload 5
    //   66: aload 6
    //   68: invokevirtual 165	com/tencent/mm/vfs/VFSFileInputStream:read	([B)I
    //   71: istore_3
    //   72: iload_3
    //   73: iconst_m1
    //   74: if_icmpeq +67 -> 141
    //   77: aload 4
    //   79: aload 6
    //   81: iconst_0
    //   82: iload_3
    //   83: invokevirtual 169	com/tencent/mm/vfs/VFSFileOutputStream:write	([BII)V
    //   86: aload 4
    //   88: invokevirtual 172	com/tencent/mm/vfs/VFSFileOutputStream:flush	()V
    //   91: goto -27 -> 64
    //   94: astore 6
    //   96: aload 5
    //   98: astore_1
    //   99: aload 4
    //   101: astore_0
    //   102: aload 6
    //   104: astore 4
    //   106: aload 4
    //   108: invokevirtual 54	java/io/IOException:printStackTrace	()V
    //   111: aload_0
    //   112: ifnull +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 173	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   119: aload_1
    //   120: ifnull +7 -> 127
    //   123: aload_1
    //   124: invokevirtual 174	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   127: iconst_0
    //   128: ireturn
    //   129: astore 6
    //   131: sipush 4096
    //   134: newarray byte
    //   136: astore 6
    //   138: goto -74 -> 64
    //   141: aload 4
    //   143: ifnull +8 -> 151
    //   146: aload 4
    //   148: invokevirtual 173	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   151: aload 5
    //   153: ifnull +8 -> 161
    //   156: aload 5
    //   158: invokevirtual 174	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   161: aload_0
    //   162: invokevirtual 104	com/tencent/mm/vfs/VFSFile:isDirectory	()Z
    //   165: ifeq +101 -> 266
    //   168: aload_0
    //   169: invokevirtual 108	com/tencent/mm/vfs/VFSFile:listFiles	()[Lcom/tencent/mm/vfs/VFSFile;
    //   172: astore_0
    //   173: aload_1
    //   174: invokevirtual 177	com/tencent/mm/vfs/VFSFile:mkdir	()Z
    //   177: pop
    //   178: iload_2
    //   179: aload_0
    //   180: arraylength
    //   181: if_icmpge +85 -> 266
    //   184: aload_0
    //   185: iload_2
    //   186: aaload
    //   187: invokevirtual 181	com/tencent/mm/vfs/VFSFile:getAbsoluteFile	()Lcom/tencent/mm/vfs/VFSFile;
    //   190: new 58	com/tencent/mm/vfs/VFSFile
    //   193: dup
    //   194: new 60	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   201: aload_1
    //   202: invokevirtual 181	com/tencent/mm/vfs/VFSFile:getAbsoluteFile	()Lcom/tencent/mm/vfs/VFSFile;
    //   205: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   208: ldc 93
    //   210: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_0
    //   214: iload_2
    //   215: aaload
    //   216: invokevirtual 187	com/tencent/mm/vfs/VFSFile:getName	()Ljava/lang/String;
    //   219: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokespecial 81	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   228: invokestatic 189	fd:a	(Lcom/tencent/mm/vfs/VFSFile;Lcom/tencent/mm/vfs/VFSFile;)Z
    //   231: pop
    //   232: iload_2
    //   233: iconst_1
    //   234: iadd
    //   235: istore_2
    //   236: goto -58 -> 178
    //   239: astore_0
    //   240: aconst_null
    //   241: astore 4
    //   243: aload 7
    //   245: astore_1
    //   246: aload 4
    //   248: ifnull +8 -> 256
    //   251: aload 4
    //   253: invokevirtual 173	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   256: aload_1
    //   257: ifnull +7 -> 264
    //   260: aload_1
    //   261: invokevirtual 174	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   264: aload_0
    //   265: athrow
    //   266: iconst_1
    //   267: ireturn
    //   268: astore 4
    //   270: goto -119 -> 151
    //   273: astore 4
    //   275: goto -114 -> 161
    //   278: astore_0
    //   279: goto -160 -> 119
    //   282: astore_0
    //   283: iconst_0
    //   284: ireturn
    //   285: astore 4
    //   287: goto -31 -> 256
    //   290: astore_1
    //   291: goto -27 -> 264
    //   294: astore_0
    //   295: aload 7
    //   297: astore_1
    //   298: goto -52 -> 246
    //   301: astore_0
    //   302: aload 5
    //   304: astore_1
    //   305: goto -59 -> 246
    //   308: astore 5
    //   310: aload_0
    //   311: astore 4
    //   313: aload 5
    //   315: astore_0
    //   316: goto -70 -> 246
    //   319: astore 4
    //   321: aconst_null
    //   322: astore_0
    //   323: aload 6
    //   325: astore_1
    //   326: goto -220 -> 106
    //   329: astore_1
    //   330: aload 4
    //   332: astore_0
    //   333: aload_1
    //   334: astore 4
    //   336: aload 6
    //   338: astore_1
    //   339: goto -233 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	paramVFSFile1	VFSFile
    //   0	342	1	paramVFSFile2	VFSFile
    //   7	229	2	i	int
    //   71	12	3	j	int
    //   46	206	4	localObject1	Object
    //   268	1	4	localIOException1	IOException
    //   273	1	4	localIOException2	IOException
    //   285	1	4	localIOException3	IOException
    //   311	1	4	localVFSFile1	VFSFile
    //   319	12	4	localIOException4	IOException
    //   334	1	4	localVFSFile2	VFSFile
    //   56	247	5	localVFSFileInputStream	com.tencent.mm.vfs.VFSFileInputStream
    //   308	6	5	localObject2	Object
    //   4	76	6	arrayOfByte1	byte[]
    //   94	9	6	localIOException5	IOException
    //   129	1	6	localOutOfMemoryError	OutOfMemoryError
    //   136	201	6	arrayOfByte2	byte[]
    //   1	295	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   58	64	94	java/io/IOException
    //   64	72	94	java/io/IOException
    //   77	91	94	java/io/IOException
    //   131	138	94	java/io/IOException
    //   58	64	129	java/lang/OutOfMemoryError
    //   15	38	239	finally
    //   38	48	239	finally
    //   146	151	268	java/io/IOException
    //   156	161	273	java/io/IOException
    //   115	119	278	java/io/IOException
    //   123	127	282	java/io/IOException
    //   251	256	285	java/io/IOException
    //   260	264	290	java/io/IOException
    //   48	58	294	finally
    //   58	64	301	finally
    //   64	72	301	finally
    //   77	91	301	finally
    //   131	138	301	finally
    //   106	111	308	finally
    //   15	38	319	java/io/IOException
    //   38	48	319	java/io/IOException
    //   48	58	329	java/io/IOException
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    return a(new VFSFile(paramFile1), new VFSFile(paramFile2));
  }
  
  public static String b(Context paramContext, String paramString)
  {
    paramContext = new VFSFile(bftf.a(paramContext) + "thumbnails/");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath() + "/" + aszt.a(paramString) + ".JPG";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     fd
 * JD-Core Version:    0.7.0.1
 */