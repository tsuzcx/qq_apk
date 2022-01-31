import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.vfs.VFSFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class gp
{
  public static String a(long paramLong)
  {
    return bbdw.a(paramLong);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    Bitmap localBitmap;
    if (apug.a(paramString) == 0) {
      localBitmap = gr.a(paramString, 150, 150);
    }
    for (;;)
    {
      if (localBitmap == null)
      {
        return null;
        if (apug.a(paramString) == 2) {
          localBitmap = gr.c(paramString, 150, 150);
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
              apvd.a(localBitmap, paramContext);
              localBitmap.recycle();
              gr.a(paramContext, gr.a(paramString));
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
    paramContext = new VFSFile(bbbr.a(paramContext) + "thumbnails/");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath() + "/" + apug.a(paramString1) + "." + paramString2 + ".JPG";
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
    //   4: new 118	java/io/FileInputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 119	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_1
    //   13: new 121	java/io/BufferedReader
    //   16: dup
    //   17: new 123	java/io/InputStreamReader
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 126	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: invokespecial 129	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_2
    //   29: aload_2
    //   30: invokevirtual 132	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore 5
    //   35: aload_2
    //   36: astore 4
    //   38: aload_1
    //   39: astore_3
    //   40: aload 5
    //   42: ifnull +33 -> 75
    //   45: aload_0
    //   46: aload 5
    //   48: invokevirtual 137	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   51: pop
    //   52: aload_2
    //   53: invokevirtual 132	java/io/BufferedReader:readLine	()Ljava/lang/String;
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
    //   82: invokevirtual 140	java/io/BufferedReader:close	()V
    //   85: aload_3
    //   86: ifnull +7 -> 93
    //   89: aload_3
    //   90: invokevirtual 143	java/io/InputStream:close	()V
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
    //   9: invokevirtual 147	com/tencent/mm/vfs/VFSFile:isFile	()Z
    //   12: ifeq +138 -> 150
    //   15: aload_1
    //   16: invokevirtual 84	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   19: ifeq +8 -> 27
    //   22: aload_1
    //   23: invokevirtual 112	com/tencent/mm/vfs/VFSFile:delete	()Z
    //   26: pop
    //   27: new 149	com/tencent/mm/vfs/VFSFileOutputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 151	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   35: astore 4
    //   37: new 153	com/tencent/mm/vfs/VFSFileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 154	com/tencent/mm/vfs/VFSFileInputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   45: astore 5
    //   47: ldc 155
    //   49: newarray byte
    //   51: astore 6
    //   53: aload 5
    //   55: aload 6
    //   57: invokevirtual 159	com/tencent/mm/vfs/VFSFileInputStream:read	([B)I
    //   60: istore_3
    //   61: iload_3
    //   62: iconst_m1
    //   63: if_icmpeq +67 -> 130
    //   66: aload 4
    //   68: aload 6
    //   70: iconst_0
    //   71: iload_3
    //   72: invokevirtual 163	com/tencent/mm/vfs/VFSFileOutputStream:write	([BII)V
    //   75: aload 4
    //   77: invokevirtual 166	com/tencent/mm/vfs/VFSFileOutputStream:flush	()V
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
    //   105: invokevirtual 167	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 168	com/tencent/mm/vfs/VFSFileInputStream:close	()V
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
    //   137: invokevirtual 167	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   140: aload 5
    //   142: ifnull +8 -> 150
    //   145: aload 5
    //   147: invokevirtual 168	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   150: aload_0
    //   151: invokevirtual 103	com/tencent/mm/vfs/VFSFile:isDirectory	()Z
    //   154: ifeq +101 -> 255
    //   157: aload_0
    //   158: invokevirtual 107	com/tencent/mm/vfs/VFSFile:listFiles	()[Lcom/tencent/mm/vfs/VFSFile;
    //   161: astore_0
    //   162: aload_1
    //   163: invokevirtual 171	com/tencent/mm/vfs/VFSFile:mkdir	()Z
    //   166: pop
    //   167: iload_2
    //   168: aload_0
    //   169: arraylength
    //   170: if_icmpge +85 -> 255
    //   173: aload_0
    //   174: iload_2
    //   175: aaload
    //   176: invokevirtual 175	com/tencent/mm/vfs/VFSFile:getAbsoluteFile	()Lcom/tencent/mm/vfs/VFSFile;
    //   179: new 57	com/tencent/mm/vfs/VFSFile
    //   182: dup
    //   183: new 59	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   190: aload_1
    //   191: invokevirtual 175	com/tencent/mm/vfs/VFSFile:getAbsoluteFile	()Lcom/tencent/mm/vfs/VFSFile;
    //   194: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   197: ldc 92
    //   199: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_0
    //   203: iload_2
    //   204: aaload
    //   205: invokevirtual 181	com/tencent/mm/vfs/VFSFile:getName	()Ljava/lang/String;
    //   208: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokespecial 80	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   217: invokestatic 183	gp:a	(Lcom/tencent/mm/vfs/VFSFile;Lcom/tencent/mm/vfs/VFSFile;)Z
    //   220: pop
    //   221: iload_2
    //   222: iconst_1
    //   223: iadd
    //   224: istore_2
    //   225: goto -58 -> 167
    //   228: astore_0
    //   229: aconst_null
    //   230: astore 4
    //   232: aload 7
    //   234: astore_1
    //   235: aload 4
    //   237: ifnull +8 -> 245
    //   240: aload 4
    //   242: invokevirtual 167	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   245: aload_1
    //   246: ifnull +7 -> 253
    //   249: aload_1
    //   250: invokevirtual 168	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   253: aload_0
    //   254: athrow
    //   255: iconst_1
    //   256: ireturn
    //   257: astore 4
    //   259: goto -119 -> 140
    //   262: astore 4
    //   264: goto -114 -> 150
    //   267: astore_0
    //   268: goto -160 -> 108
    //   271: astore_0
    //   272: iconst_0
    //   273: ireturn
    //   274: astore 4
    //   276: goto -31 -> 245
    //   279: astore_1
    //   280: goto -27 -> 253
    //   283: astore_0
    //   284: aload 7
    //   286: astore_1
    //   287: goto -52 -> 235
    //   290: astore_0
    //   291: aload 5
    //   293: astore_1
    //   294: goto -59 -> 235
    //   297: astore 5
    //   299: aload_0
    //   300: astore 4
    //   302: aload 5
    //   304: astore_0
    //   305: goto -70 -> 235
    //   308: astore 4
    //   310: aconst_null
    //   311: astore_0
    //   312: aload 6
    //   314: astore_1
    //   315: goto -220 -> 95
    //   318: astore_1
    //   319: aload 4
    //   321: astore_0
    //   322: aload_1
    //   323: astore 4
    //   325: aload 6
    //   327: astore_1
    //   328: goto -233 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	paramVFSFile1	VFSFile
    //   0	331	1	paramVFSFile2	VFSFile
    //   7	218	2	i	int
    //   60	12	3	j	int
    //   35	206	4	localObject1	Object
    //   257	1	4	localIOException1	IOException
    //   262	1	4	localIOException2	IOException
    //   274	1	4	localIOException3	IOException
    //   300	1	4	localVFSFile1	VFSFile
    //   308	12	4	localIOException4	IOException
    //   323	1	4	localVFSFile2	VFSFile
    //   45	247	5	localVFSFileInputStream	com.tencent.mm.vfs.VFSFileInputStream
    //   297	6	5	localObject2	Object
    //   4	65	6	arrayOfByte1	byte[]
    //   83	9	6	localIOException5	IOException
    //   118	1	6	localOutOfMemoryError	OutOfMemoryError
    //   125	201	6	arrayOfByte2	byte[]
    //   1	284	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   47	53	83	java/io/IOException
    //   53	61	83	java/io/IOException
    //   66	80	83	java/io/IOException
    //   120	127	83	java/io/IOException
    //   47	53	118	java/lang/OutOfMemoryError
    //   15	27	228	finally
    //   27	37	228	finally
    //   135	140	257	java/io/IOException
    //   145	150	262	java/io/IOException
    //   104	108	267	java/io/IOException
    //   112	116	271	java/io/IOException
    //   240	245	274	java/io/IOException
    //   249	253	279	java/io/IOException
    //   37	47	283	finally
    //   47	53	290	finally
    //   53	61	290	finally
    //   66	80	290	finally
    //   120	127	290	finally
    //   95	100	297	finally
    //   15	27	308	java/io/IOException
    //   27	37	308	java/io/IOException
    //   37	47	318	java/io/IOException
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    return a(new VFSFile(paramFile1), new VFSFile(paramFile2));
  }
  
  public static String b(Context paramContext, String paramString)
  {
    paramContext = new VFSFile(bbbr.a(paramContext) + "thumbnails/");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath() + "/" + apug.a(paramString) + ".JPG";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     gp
 * JD-Core Version:    0.7.0.1
 */