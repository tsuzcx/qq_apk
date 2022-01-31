package com.tencent.ttpic.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.ttpic.filter.FaceOffFilter;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.filter.VideoFilterBase;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VideoFileUtil
{
  private static final String PIC_POSTFIX_JPEG = ".jpg";
  private static final String PIC_POSTFIX_PNG = ".png";
  private static final String PIC_POSTFIX_WEBP = ".webp";
  public static final AssetFileComparator SIMPLE_ASSET_COMPARATOR = new AssetFileComparator()
  {
    public boolean equals(Context paramAnonymousContext, String paramAnonymousString, File paramAnonymousFile)
    {
      long l = VideoFileUtil.getAssetLength(paramAnonymousContext, paramAnonymousString);
      return (l != -1L) && (l == paramAnonymousFile.length());
    }
  };
  private static final String TAG = VideoFileUtil.class.getSimpleName();
  
  /* Error */
  public static String checkAssetsPhoto(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokevirtual 57	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: astore_0
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 63	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: astore_2
    //   20: aload_2
    //   21: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   24: aload_1
    //   25: areturn
    //   26: astore_2
    //   27: aconst_null
    //   28: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   31: aload_1
    //   32: ldc 71
    //   34: invokevirtual 77	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   37: iconst_m1
    //   38: if_icmpeq +68 -> 106
    //   41: new 79	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   48: aload_1
    //   49: iconst_0
    //   50: aload_1
    //   51: bipush 46
    //   53: invokevirtual 83	java/lang/String:lastIndexOf	(I)I
    //   56: iconst_1
    //   57: iadd
    //   58: invokevirtual 87	java/lang/String:substring	(II)Ljava/lang/String;
    //   61: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 93
    //   66: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore_1
    //   73: aload_0
    //   74: aload_1
    //   75: invokevirtual 63	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   78: astore_0
    //   79: aload_0
    //   80: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   83: aload_1
    //   84: areturn
    //   85: astore_0
    //   86: aconst_null
    //   87: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   90: aload_0
    //   91: athrow
    //   92: astore_0
    //   93: aconst_null
    //   94: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   97: aconst_null
    //   98: areturn
    //   99: astore_0
    //   100: aconst_null
    //   101: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   104: aload_0
    //   105: athrow
    //   106: new 79	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   113: aload_1
    //   114: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc 15
    //   119: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_2
    //   126: aload_0
    //   127: aload_2
    //   128: invokevirtual 63	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   131: astore_3
    //   132: aload_3
    //   133: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   136: aload_2
    //   137: areturn
    //   138: astore_2
    //   139: aconst_null
    //   140: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   143: new 79	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   150: aload_1
    //   151: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc 21
    //   156: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: astore_2
    //   163: aload_0
    //   164: aload_2
    //   165: invokevirtual 63	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   168: astore_3
    //   169: aload_3
    //   170: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   173: aload_2
    //   174: areturn
    //   175: astore_0
    //   176: aconst_null
    //   177: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   180: aload_0
    //   181: athrow
    //   182: astore_2
    //   183: aconst_null
    //   184: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   187: new 79	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   194: aload_1
    //   195: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc 18
    //   200: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: astore_1
    //   207: aload_0
    //   208: aload_1
    //   209: invokevirtual 63	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   212: astore_0
    //   213: aload_0
    //   214: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   217: aload_1
    //   218: areturn
    //   219: astore_0
    //   220: aconst_null
    //   221: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   224: aload_0
    //   225: athrow
    //   226: astore_0
    //   227: aconst_null
    //   228: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   231: aconst_null
    //   232: areturn
    //   233: astore_0
    //   234: aconst_null
    //   235: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   238: aload_0
    //   239: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramContext	Context
    //   0	240	1	paramString	String
    //   19	2	2	localInputStream1	InputStream
    //   26	1	2	localIOException1	IOException
    //   125	12	2	str1	String
    //   138	1	2	localIOException2	IOException
    //   162	12	2	str2	String
    //   182	1	2	localIOException3	IOException
    //   131	39	3	localInputStream2	InputStream
    // Exception table:
    //   from	to	target	type
    //   14	20	26	java/io/IOException
    //   14	20	85	finally
    //   73	79	92	java/io/IOException
    //   73	79	99	finally
    //   126	132	138	java/io/IOException
    //   126	132	175	finally
    //   163	169	182	java/io/IOException
    //   163	169	219	finally
    //   207	213	226	java/io/IOException
    //   207	213	233	finally
  }
  
  public static String checkPhoto(String paramString)
  {
    String str1;
    if (TextUtils.isEmpty(paramString)) {
      str1 = null;
    }
    String str2;
    do
    {
      do
      {
        do
        {
          return str1;
          str1 = paramString;
        } while (new File(paramString).exists());
        str1 = paramString;
      } while (paramString.substring(paramString.lastIndexOf("/")).lastIndexOf(".") != -1);
      str1 = paramString + ".jpg";
      if (new File(str1).exists()) {
        return str1;
      }
      str2 = paramString + ".png";
      str1 = paramString;
    } while (!new File(str2).exists());
    return str2;
  }
  
  private static void closeSilently(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2)
  {
    return copyAssets(paramContext, paramString1, paramString2, SIMPLE_ASSET_COMPARATOR);
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2, AssetFileComparator paramAssetFileComparator)
  {
    return performCopyAssetsFile(paramContext, paramString1, paramString2, paramAssetFileComparator);
  }
  
  /* Error */
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore 5
    //   17: aload_1
    //   18: invokevirtual 107	java/io/File:exists	()Z
    //   21: ifeq +8 -> 29
    //   24: aload_1
    //   25: invokevirtual 136	java/io/File:delete	()Z
    //   28: pop
    //   29: new 138	java/io/FileOutputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore_1
    //   38: new 143	java/io/BufferedInputStream
    //   41: dup
    //   42: new 145	java/io/FileInputStream
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   50: invokespecial 148	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   53: astore_0
    //   54: invokestatic 154	com/tencent/ttpic/util/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/util/ByteArrayPool;
    //   57: sipush 4096
    //   60: invokevirtual 158	com/tencent/ttpic/util/ByteArrayPool:getBuf	(I)[B
    //   63: astore_3
    //   64: aload_0
    //   65: aload_3
    //   66: invokevirtual 162	java/io/BufferedInputStream:read	([B)I
    //   69: istore_2
    //   70: iload_2
    //   71: iconst_m1
    //   72: if_icmpeq +42 -> 114
    //   75: aload_1
    //   76: aload_3
    //   77: iconst_0
    //   78: iload_2
    //   79: invokevirtual 166	java/io/FileOutputStream:write	([BII)V
    //   82: aload_1
    //   83: invokevirtual 169	java/io/FileOutputStream:flush	()V
    //   86: goto -22 -> 64
    //   89: astore_3
    //   90: aload_0
    //   91: astore_3
    //   92: aload_1
    //   93: astore_0
    //   94: aload_3
    //   95: astore_1
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 170	java/io/FileOutputStream:close	()V
    //   104: aload_1
    //   105: ifnull +7 -> 112
    //   108: aload_1
    //   109: invokevirtual 171	java/io/BufferedInputStream:close	()V
    //   112: iconst_0
    //   113: ireturn
    //   114: invokestatic 154	com/tencent/ttpic/util/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/util/ByteArrayPool;
    //   117: aload_3
    //   118: invokevirtual 175	com/tencent/ttpic/util/ByteArrayPool:returnBuf	([B)V
    //   121: aload_1
    //   122: ifnull +7 -> 129
    //   125: aload_1
    //   126: invokevirtual 170	java/io/FileOutputStream:close	()V
    //   129: aload_0
    //   130: ifnull +137 -> 267
    //   133: aload_0
    //   134: invokevirtual 171	java/io/BufferedInputStream:close	()V
    //   137: iconst_1
    //   138: ireturn
    //   139: astore_0
    //   140: iconst_1
    //   141: ireturn
    //   142: astore_0
    //   143: aload 8
    //   145: astore_0
    //   146: aload 4
    //   148: astore_1
    //   149: aload_0
    //   150: ifnull +7 -> 157
    //   153: aload_0
    //   154: invokevirtual 170	java/io/FileOutputStream:close	()V
    //   157: aload_1
    //   158: ifnull -46 -> 112
    //   161: aload_1
    //   162: invokevirtual 171	java/io/BufferedInputStream:close	()V
    //   165: iconst_0
    //   166: ireturn
    //   167: astore_0
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_0
    //   171: aload 7
    //   173: astore_1
    //   174: aload_1
    //   175: ifnull +7 -> 182
    //   178: aload_1
    //   179: invokevirtual 170	java/io/FileOutputStream:close	()V
    //   182: aload_3
    //   183: ifnull +7 -> 190
    //   186: aload_3
    //   187: invokevirtual 171	java/io/BufferedInputStream:close	()V
    //   190: aload_0
    //   191: athrow
    //   192: astore_1
    //   193: goto -64 -> 129
    //   196: astore_0
    //   197: goto -93 -> 104
    //   200: astore_0
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_0
    //   204: goto -47 -> 157
    //   207: astore_1
    //   208: goto -26 -> 182
    //   211: astore_1
    //   212: goto -22 -> 190
    //   215: astore_0
    //   216: goto -42 -> 174
    //   219: astore 4
    //   221: aload_0
    //   222: astore_3
    //   223: aload 4
    //   225: astore_0
    //   226: goto -52 -> 174
    //   229: astore_0
    //   230: aload_1
    //   231: astore_0
    //   232: aload 4
    //   234: astore_1
    //   235: goto -86 -> 149
    //   238: astore_3
    //   239: aload_1
    //   240: astore_3
    //   241: aload_0
    //   242: astore_1
    //   243: aload_3
    //   244: astore_0
    //   245: goto -96 -> 149
    //   248: astore_0
    //   249: aload 5
    //   251: astore_1
    //   252: aload 6
    //   254: astore_0
    //   255: goto -159 -> 96
    //   258: astore_0
    //   259: aload_1
    //   260: astore_0
    //   261: aload 5
    //   263: astore_1
    //   264: goto -168 -> 96
    //   267: iconst_1
    //   268: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	paramFile1	File
    //   0	269	1	paramFile2	File
    //   69	10	2	i	int
    //   13	64	3	arrayOfByte	byte[]
    //   89	1	3	localIOException	IOException
    //   91	132	3	localFile1	File
    //   238	1	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   240	4	3	localFile2	File
    //   10	137	4	localObject1	Object
    //   219	14	4	localObject2	Object
    //   15	247	5	localObject3	Object
    //   7	246	6	localObject4	Object
    //   4	168	7	localObject5	Object
    //   1	143	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   54	64	89	java/io/IOException
    //   64	70	89	java/io/IOException
    //   75	86	89	java/io/IOException
    //   114	121	89	java/io/IOException
    //   133	137	139	java/io/IOException
    //   17	29	142	java/lang/OutOfMemoryError
    //   29	38	142	java/lang/OutOfMemoryError
    //   161	165	167	java/io/IOException
    //   17	29	170	finally
    //   29	38	170	finally
    //   125	129	192	java/io/IOException
    //   100	104	196	java/io/IOException
    //   108	112	200	java/io/IOException
    //   153	157	203	java/io/IOException
    //   178	182	207	java/io/IOException
    //   186	190	211	java/io/IOException
    //   38	54	215	finally
    //   54	64	219	finally
    //   64	70	219	finally
    //   75	86	219	finally
    //   114	121	219	finally
    //   38	54	229	java/lang/OutOfMemoryError
    //   54	64	238	java/lang/OutOfMemoryError
    //   64	70	238	java/lang/OutOfMemoryError
    //   75	86	238	java/lang/OutOfMemoryError
    //   114	121	238	java/lang/OutOfMemoryError
    //   17	29	248	java/io/IOException
    //   29	38	248	java/io/IOException
    //   38	54	258	java/io/IOException
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    boolean bool = false;
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {}
    try
    {
      copyFile(paramString1, createFile(paramString2));
      bool = true;
      return bool;
    }
    catch (IOException paramString1) {}
    return false;
  }
  
  public static File createFile(String paramString)
    throws IOException
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if ((paramString.getParentFile() == null) || (paramString.getParentFile().exists())) {
        break label50;
      }
      if (paramString.getParentFile().mkdirs()) {
        paramString.createNewFile();
      }
    }
    return paramString;
    label50:
    paramString.createNewFile();
    return paramString;
  }
  
  public static void delete(File paramFile)
  {
    delete(paramFile, false);
  }
  
  public static void delete(File paramFile, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        return;
        if (paramFile.isFile())
        {
          paramFile.delete();
          return;
        }
        arrayOfFile = paramFile.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        delete(arrayOfFile[i], paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramFile.delete();
  }
  
  public static void deleteFiles(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return;
      paramString1 = new File(paramString1).listFiles(new FilenameFilter()
      {
        public boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          if (TextUtils.isEmpty(this.val$suffix)) {
            return true;
          }
          return paramAnonymousString.endsWith(this.val$suffix);
        }
      });
      if (paramString1 != null)
      {
        int j = paramString1.length;
        int i = 0;
        while (i < j)
        {
          paramString1[i].delete();
          i += 1;
        }
      }
    }
  }
  
  public static void deleteFilesStartWithGivenString(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (paramString1.getParentFile().exists())
    {
      paramString1 = paramString1.getParentFile().listFiles();
      if (paramString1 != null) {
        break label32;
      }
    }
    for (;;)
    {
      return;
      label32:
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString1[i];
        if (localObject.getName().startsWith(paramString2)) {
          localObject.delete();
        }
        i += 1;
      }
    }
  }
  
  public static boolean exists(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("assets://")) && (!new File(paramString).exists())) {
      return false;
    }
    return true;
  }
  
  public static List<String> getAllPngFileNames(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString == null) {}
    do
    {
      for (;;)
      {
        return localArrayList;
        if (paramString.startsWith("assets://")) {
          try
          {
            paramString = VideoGlobalContext.getContext().getAssets().list(VideoUtil.getRealPath(paramString));
            if (paramString != null)
            {
              int j = paramString.length;
              int i = 0;
              while (i < j)
              {
                Object localObject = paramString[i];
                if (localObject.endsWith(".png")) {
                  localArrayList.add(localObject);
                }
                i += 1;
              }
              paramString = new File(paramString).list(VideoMaterialUtil.mPngFilter);
            }
          }
          catch (IOException paramString)
          {
            paramString.printStackTrace();
            return localArrayList;
          }
        }
      }
    } while (paramString == null);
    localArrayList.addAll(Arrays.asList(paramString));
    return localArrayList;
  }
  
  public static long getAssetLength(Context paramContext, String paramString)
  {
    AssetManager localAssetManager = paramContext.getAssets();
    try
    {
      l = localAssetManager.openFd(paramString).getLength();
      return l;
    }
    catch (IOException paramContext)
    {
      long l;
      String str = null;
      paramContext = null;
      try
      {
        paramString = localAssetManager.open(paramString);
        paramContext = paramString;
        str = paramString;
        int i = paramString.available();
        l = i;
        return l;
      }
      catch (IOException paramString)
      {
        return -1L;
      }
      finally
      {
        closeSilently(str);
      }
    }
  }
  
  /* Error */
  public static String load(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore_3
    //   7: new 145	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: astore_1
    //   16: aload_0
    //   17: invokevirtual 303	java/io/File:length	()J
    //   20: l2i
    //   21: newarray byte
    //   23: astore_0
    //   24: aload_1
    //   25: aload_0
    //   26: invokevirtual 304	java/io/InputStream:read	([B)I
    //   29: pop
    //   30: new 73	java/lang/String
    //   33: dup
    //   34: aload_0
    //   35: ldc_w 306
    //   38: invokespecial 309	java/lang/String:<init>	([BLjava/lang/String;)V
    //   41: astore_0
    //   42: aload_1
    //   43: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: aload_3
    //   50: astore_0
    //   51: aload_0
    //   52: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   55: aconst_null
    //   56: areturn
    //   57: astore_1
    //   58: aload 4
    //   60: astore_0
    //   61: aload_0
    //   62: astore_2
    //   63: getstatic 34	com/tencent/ttpic/util/VideoFileUtil:TAG	Ljava/lang/String;
    //   66: aload_1
    //   67: invokevirtual 310	java/lang/Exception:toString	()Ljava/lang/String;
    //   70: invokestatic 316	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   73: pop
    //   74: aload_0
    //   75: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   78: goto -23 -> 55
    //   81: astore_0
    //   82: aload_2
    //   83: invokestatic 69	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   86: aload_0
    //   87: athrow
    //   88: astore_0
    //   89: aload_1
    //   90: astore_2
    //   91: goto -9 -> 82
    //   94: astore_2
    //   95: aload_1
    //   96: astore_0
    //   97: aload_2
    //   98: astore_1
    //   99: goto -38 -> 61
    //   102: astore_0
    //   103: aload_1
    //   104: astore_0
    //   105: goto -54 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramFile	File
    //   15	28	1	localFileInputStream	java.io.FileInputStream
    //   57	39	1	localException1	java.lang.Exception
    //   98	6	1	localException2	java.lang.Exception
    //   4	87	2	localObject1	Object
    //   94	4	2	localException3	java.lang.Exception
    //   6	44	3	localObject2	Object
    //   1	58	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	48	java/io/FileNotFoundException
    //   7	16	57	java/lang/Exception
    //   7	16	81	finally
    //   63	74	81	finally
    //   16	42	88	finally
    //   16	42	94	java/lang/Exception
    //   16	42	102	java/io/FileNotFoundException
  }
  
  public static String load(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    if (paramString1.startsWith("assets://")) {
      return loadAssetsString(VideoGlobalContext.getContext(), VideoUtil.getRealPath(paramString1) + File.separator + paramString2);
    }
    return load(new File(paramString1 + File.separator + paramString2));
  }
  
  public static String loadAssetsString(Context paramContext, String paramString)
  {
    localStringBuilder = new StringBuilder();
    try
    {
      paramContext = new BufferedReader(new InputStreamReader(paramContext.getAssets().open(paramString), "UTF-8"));
      for (;;)
      {
        paramString = paramContext.readLine();
        if (paramString == null) {
          break;
        }
        localStringBuilder.append(paramString);
        localStringBuilder.append("\n");
      }
      return localStringBuilder.toString();
    }
    catch (IOException paramContext)
    {
      paramContext = paramContext;
      paramContext.printStackTrace();
      return localStringBuilder.toString();
      paramContext.close();
      return localStringBuilder.toString();
    }
    finally {}
  }
  
  public static void loadImageView(ImageView paramImageView, String paramString)
  {
    if ((paramImageView == null) || (paramString == null)) {}
    do
    {
      return;
      if (paramString.startsWith("assets://")) {
        try
        {
          paramImageView.setImageDrawable(Drawable.createFromStream(VideoGlobalContext.getContext().getAssets().open(VideoUtil.getRealPath(paramString)), null));
          return;
        }
        catch (IOException paramImageView)
        {
          return;
        }
      }
      paramString = VideoBitmapUtil.decodeSampleBitmap(VideoGlobalContext.getContext(), VideoUtil.getRealPath(paramString), 2147483647, 2147483647);
    } while (!VideoBitmapUtil.isLegal(paramString));
    paramImageView.setImageBitmap(paramString);
  }
  
  public static String loadResourceString(String paramString)
  {
    localStringBuilder = new StringBuilder();
    try
    {
      paramString = new BufferedReader(new InputStreamReader(VideoFileUtil.class.getResourceAsStream(paramString), "UTF-8"));
      for (;;)
      {
        String str = paramString.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
        localStringBuilder.append("\n");
      }
      return localStringBuilder.toString();
    }
    catch (IOException paramString)
    {
      paramString = paramString;
      paramString.printStackTrace();
      return localStringBuilder.toString();
      paramString.close();
      return localStringBuilder.toString();
    }
    finally {}
  }
  
  public static boolean needCopy(VideoFilterBase paramVideoFilterBase)
  {
    if (paramVideoFilterBase == null) {
      return false;
    }
    if ((paramVideoFilterBase instanceof NormalVideoFilter)) {
      return ((NormalVideoFilter)paramVideoFilterBase).needCopyTex();
    }
    return paramVideoFilterBase instanceof FaceOffFilter;
  }
  
  /* Error */
  private static boolean performCopyAssetsFile(Context paramContext, String paramString1, String paramString2, AssetFileComparator paramAssetFileComparator)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_2
    //   8: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: invokevirtual 57	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   20: astore 14
    //   22: new 100	java/io/File
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore 13
    //   32: aconst_null
    //   33: astore 12
    //   35: aconst_null
    //   36: astore 11
    //   38: aconst_null
    //   39: astore 8
    //   41: aconst_null
    //   42: astore 10
    //   44: aconst_null
    //   45: astore 9
    //   47: aload 11
    //   49: astore_2
    //   50: aload 10
    //   52: astore 6
    //   54: aload 12
    //   56: astore 7
    //   58: aload 13
    //   60: invokevirtual 107	java/io/File:exists	()Z
    //   63: ifeq +80 -> 143
    //   66: aload_3
    //   67: ifnull +41 -> 108
    //   70: aload 11
    //   72: astore_2
    //   73: aload 10
    //   75: astore 6
    //   77: aload 12
    //   79: astore 7
    //   81: aload_3
    //   82: aload_0
    //   83: aload_1
    //   84: aload 13
    //   86: invokeinterface 389 4 0
    //   91: istore 5
    //   93: iload 5
    //   95: ifeq +13 -> 108
    //   98: aconst_null
    //   99: invokestatic 292	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   102: aconst_null
    //   103: invokestatic 292	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   106: iconst_1
    //   107: ireturn
    //   108: aload 11
    //   110: astore_2
    //   111: aload 10
    //   113: astore 6
    //   115: aload 12
    //   117: astore 7
    //   119: aload 13
    //   121: invokevirtual 392	java/io/File:isDirectory	()Z
    //   124: ifeq +19 -> 143
    //   127: aload 11
    //   129: astore_2
    //   130: aload 10
    //   132: astore 6
    //   134: aload 12
    //   136: astore 7
    //   138: aload 13
    //   140: invokestatic 394	com/tencent/ttpic/util/VideoFileUtil:delete	(Ljava/io/File;)V
    //   143: aload 11
    //   145: astore_2
    //   146: aload 10
    //   148: astore 6
    //   150: aload 12
    //   152: astore 7
    //   154: aload 13
    //   156: invokevirtual 186	java/io/File:getParentFile	()Ljava/io/File;
    //   159: astore_0
    //   160: aload 11
    //   162: astore_2
    //   163: aload 10
    //   165: astore 6
    //   167: aload 12
    //   169: astore 7
    //   171: aload_0
    //   172: invokevirtual 199	java/io/File:isFile	()Z
    //   175: ifeq +18 -> 193
    //   178: aload 11
    //   180: astore_2
    //   181: aload 10
    //   183: astore 6
    //   185: aload 12
    //   187: astore 7
    //   189: aload_0
    //   190: invokestatic 394	com/tencent/ttpic/util/VideoFileUtil:delete	(Ljava/io/File;)V
    //   193: aload 11
    //   195: astore_2
    //   196: aload 10
    //   198: astore 6
    //   200: aload 12
    //   202: astore 7
    //   204: aload_0
    //   205: invokevirtual 107	java/io/File:exists	()Z
    //   208: ifne +35 -> 243
    //   211: aload 11
    //   213: astore_2
    //   214: aload 10
    //   216: astore 6
    //   218: aload 12
    //   220: astore 7
    //   222: aload_0
    //   223: invokevirtual 189	java/io/File:mkdirs	()Z
    //   226: istore 5
    //   228: iload 5
    //   230: ifne +13 -> 243
    //   233: aconst_null
    //   234: invokestatic 292	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   237: aconst_null
    //   238: invokestatic 292	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   241: iconst_0
    //   242: ireturn
    //   243: aload 11
    //   245: astore_2
    //   246: aload 10
    //   248: astore 6
    //   250: aload 12
    //   252: astore 7
    //   254: aload 14
    //   256: aload_1
    //   257: invokevirtual 63	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   260: astore_0
    //   261: aload_0
    //   262: astore_2
    //   263: aload 10
    //   265: astore 6
    //   267: aload_0
    //   268: astore 7
    //   270: aload_0
    //   271: invokevirtual 290	java/io/InputStream:available	()I
    //   274: istore 4
    //   276: iload 4
    //   278: ifgt +20 -> 298
    //   281: iconst_0
    //   282: istore 5
    //   284: aload 9
    //   286: astore_1
    //   287: aload_0
    //   288: invokestatic 292	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   291: aload_1
    //   292: invokestatic 292	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   295: iload 5
    //   297: ireturn
    //   298: aload_0
    //   299: astore_2
    //   300: aload 10
    //   302: astore 6
    //   304: aload_0
    //   305: astore 7
    //   307: new 396	java/io/BufferedOutputStream
    //   310: dup
    //   311: new 138	java/io/FileOutputStream
    //   314: dup
    //   315: aload 13
    //   317: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   320: invokespecial 399	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   323: astore_1
    //   324: sipush 1024
    //   327: newarray byte
    //   329: astore_2
    //   330: aload_0
    //   331: aload_2
    //   332: invokevirtual 304	java/io/InputStream:read	([B)I
    //   335: istore 4
    //   337: iload 4
    //   339: ifle +35 -> 374
    //   342: aload_1
    //   343: aload_2
    //   344: iconst_0
    //   345: iload 4
    //   347: invokevirtual 402	java/io/OutputStream:write	([BII)V
    //   350: goto -20 -> 330
    //   353: astore_2
    //   354: aload_0
    //   355: astore_2
    //   356: aload_1
    //   357: astore 6
    //   359: aload 13
    //   361: invokestatic 394	com/tencent/ttpic/util/VideoFileUtil:delete	(Ljava/io/File;)V
    //   364: aload_0
    //   365: invokestatic 292	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   368: aload_1
    //   369: invokestatic 292	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   372: iconst_0
    //   373: ireturn
    //   374: iconst_1
    //   375: istore 5
    //   377: goto -90 -> 287
    //   380: astore_1
    //   381: aload_2
    //   382: astore_0
    //   383: aload_0
    //   384: invokestatic 292	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   387: aload 6
    //   389: invokestatic 292	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   392: aload_1
    //   393: athrow
    //   394: astore_2
    //   395: aload_1
    //   396: astore 6
    //   398: aload_2
    //   399: astore_1
    //   400: goto -17 -> 383
    //   403: astore_0
    //   404: aload 7
    //   406: astore_0
    //   407: aload 8
    //   409: astore_1
    //   410: goto -56 -> 354
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	paramContext	Context
    //   0	413	1	paramString1	String
    //   0	413	2	paramString2	String
    //   0	413	3	paramAssetFileComparator	AssetFileComparator
    //   274	72	4	i	int
    //   91	285	5	bool	boolean
    //   52	345	6	localObject1	Object
    //   56	349	7	localObject2	Object
    //   39	369	8	localObject3	Object
    //   45	240	9	localObject4	Object
    //   42	259	10	localObject5	Object
    //   36	208	11	localObject6	Object
    //   33	218	12	localObject7	Object
    //   30	330	13	localFile	File
    //   20	235	14	localAssetManager	AssetManager
    // Exception table:
    //   from	to	target	type
    //   324	330	353	java/lang/Throwable
    //   330	337	353	java/lang/Throwable
    //   342	350	353	java/lang/Throwable
    //   58	66	380	finally
    //   81	93	380	finally
    //   119	127	380	finally
    //   138	143	380	finally
    //   154	160	380	finally
    //   171	178	380	finally
    //   189	193	380	finally
    //   204	211	380	finally
    //   222	228	380	finally
    //   254	261	380	finally
    //   270	276	380	finally
    //   307	324	380	finally
    //   359	364	380	finally
    //   324	330	394	finally
    //   330	337	394	finally
    //   342	350	394	finally
    //   58	66	403	java/lang/Throwable
    //   81	93	403	java/lang/Throwable
    //   119	127	403	java/lang/Throwable
    //   138	143	403	java/lang/Throwable
    //   154	160	403	java/lang/Throwable
    //   171	178	403	java/lang/Throwable
    //   189	193	403	java/lang/Throwable
    //   204	211	403	java/lang/Throwable
    //   222	228	403	java/lang/Throwable
    //   254	261	403	java/lang/Throwable
    //   270	276	403	java/lang/Throwable
    //   307	324	403	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] readFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore 11
    //   15: aconst_null
    //   16: astore 9
    //   18: aload_0
    //   19: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifeq +5 -> 27
    //   25: aconst_null
    //   26: areturn
    //   27: new 100	java/io/File
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 12
    //   37: aload 12
    //   39: invokevirtual 107	java/io/File:exists	()Z
    //   42: ifne +5 -> 47
    //   45: aconst_null
    //   46: areturn
    //   47: aload 11
    //   49: astore 4
    //   51: aload 10
    //   53: astore 5
    //   55: aload 12
    //   57: invokevirtual 303	java/io/File:length	()J
    //   60: l2i
    //   61: istore_2
    //   62: aload 11
    //   64: astore 4
    //   66: aload 10
    //   68: astore 5
    //   70: new 406	java/io/ByteArrayOutputStream
    //   73: dup
    //   74: iload_2
    //   75: invokespecial 409	java/io/ByteArrayOutputStream:<init>	(I)V
    //   78: astore_0
    //   79: new 145	java/io/FileInputStream
    //   82: dup
    //   83: aload 12
    //   85: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   88: astore 5
    //   90: iconst_0
    //   91: istore_1
    //   92: iload_2
    //   93: sipush 4096
    //   96: if_icmpge +42 -> 138
    //   99: invokestatic 154	com/tencent/ttpic/util/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/util/ByteArrayPool;
    //   102: sipush 4096
    //   105: invokevirtual 158	com/tencent/ttpic/util/ByteArrayPool:getBuf	(I)[B
    //   108: astore 4
    //   110: iload_1
    //   111: iload_2
    //   112: if_icmpge +56 -> 168
    //   115: aload 5
    //   117: aload 4
    //   119: invokevirtual 410	java/io/FileInputStream:read	([B)I
    //   122: istore_3
    //   123: aload_0
    //   124: aload 4
    //   126: iconst_0
    //   127: iload_3
    //   128: invokevirtual 411	java/io/ByteArrayOutputStream:write	([BII)V
    //   131: iload_1
    //   132: iload_3
    //   133: iadd
    //   134: istore_1
    //   135: goto -25 -> 110
    //   138: invokestatic 154	com/tencent/ttpic/util/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/util/ByteArrayPool;
    //   141: sipush 12288
    //   144: invokevirtual 158	com/tencent/ttpic/util/ByteArrayPool:getBuf	(I)[B
    //   147: astore 4
    //   149: goto -39 -> 110
    //   152: astore 4
    //   154: invokestatic 154	com/tencent/ttpic/util/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/util/ByteArrayPool;
    //   157: sipush 4096
    //   160: invokevirtual 158	com/tencent/ttpic/util/ByteArrayPool:getBuf	(I)[B
    //   163: astore 4
    //   165: goto -55 -> 110
    //   168: invokestatic 154	com/tencent/ttpic/util/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/util/ByteArrayPool;
    //   171: aload 4
    //   173: invokevirtual 175	com/tencent/ttpic/util/ByteArrayPool:returnBuf	([B)V
    //   176: aload_0
    //   177: invokevirtual 415	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   180: astore 4
    //   182: aload_0
    //   183: ifnull +7 -> 190
    //   186: aload_0
    //   187: invokevirtual 416	java/io/ByteArrayOutputStream:close	()V
    //   190: aload 5
    //   192: ifnull +8 -> 200
    //   195: aload 5
    //   197: invokevirtual 417	java/io/FileInputStream:close	()V
    //   200: aload 4
    //   202: areturn
    //   203: astore_0
    //   204: getstatic 34	com/tencent/ttpic/util/VideoFileUtil:TAG	Ljava/lang/String;
    //   207: ldc_w 419
    //   210: aload_0
    //   211: invokestatic 422	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   214: pop
    //   215: goto -15 -> 200
    //   218: astore 7
    //   220: aload 9
    //   222: astore_0
    //   223: aload_0
    //   224: astore 4
    //   226: aload 6
    //   228: astore 5
    //   230: getstatic 34	com/tencent/ttpic/util/VideoFileUtil:TAG	Ljava/lang/String;
    //   233: ldc_w 424
    //   236: aload 7
    //   238: invokestatic 422	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   241: pop
    //   242: aload_0
    //   243: ifnull +7 -> 250
    //   246: aload_0
    //   247: invokevirtual 416	java/io/ByteArrayOutputStream:close	()V
    //   250: aload 8
    //   252: astore 4
    //   254: aload 6
    //   256: ifnull -56 -> 200
    //   259: aload 6
    //   261: invokevirtual 417	java/io/FileInputStream:close	()V
    //   264: aload 8
    //   266: astore 4
    //   268: goto -68 -> 200
    //   271: astore_0
    //   272: getstatic 34	com/tencent/ttpic/util/VideoFileUtil:TAG	Ljava/lang/String;
    //   275: ldc_w 419
    //   278: aload_0
    //   279: invokestatic 422	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   282: pop
    //   283: aload 8
    //   285: astore 4
    //   287: goto -87 -> 200
    //   290: astore_0
    //   291: aload 4
    //   293: ifnull +8 -> 301
    //   296: aload 4
    //   298: invokevirtual 416	java/io/ByteArrayOutputStream:close	()V
    //   301: aload 5
    //   303: ifnull +8 -> 311
    //   306: aload 5
    //   308: invokevirtual 417	java/io/FileInputStream:close	()V
    //   311: aload_0
    //   312: athrow
    //   313: astore 4
    //   315: getstatic 34	com/tencent/ttpic/util/VideoFileUtil:TAG	Ljava/lang/String;
    //   318: ldc_w 419
    //   321: aload 4
    //   323: invokestatic 422	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   326: pop
    //   327: goto -16 -> 311
    //   330: astore 6
    //   332: aload_0
    //   333: astore 4
    //   335: aload 7
    //   337: astore 5
    //   339: aload 6
    //   341: astore_0
    //   342: goto -51 -> 291
    //   345: astore 6
    //   347: aload_0
    //   348: astore 4
    //   350: aload 6
    //   352: astore_0
    //   353: goto -62 -> 291
    //   356: astore 7
    //   358: goto -135 -> 223
    //   361: astore 7
    //   363: aload 5
    //   365: astore 6
    //   367: goto -144 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	paramString	String
    //   91	44	1	i	int
    //   61	52	2	j	int
    //   122	12	3	k	int
    //   49	99	4	localObject1	Object
    //   152	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   163	134	4	localObject2	Object
    //   313	9	4	localIOException	IOException
    //   333	16	4	str	String
    //   53	311	5	localObject3	Object
    //   10	250	6	localObject4	Object
    //   330	10	6	localObject5	Object
    //   345	6	6	localObject6	Object
    //   365	1	6	localObject7	Object
    //   7	1	7	localObject8	Object
    //   218	118	7	localException1	java.lang.Exception
    //   356	1	7	localException2	java.lang.Exception
    //   361	1	7	localException3	java.lang.Exception
    //   1	283	8	localObject9	Object
    //   16	205	9	localObject10	Object
    //   4	63	10	localObject11	Object
    //   13	50	11	localObject12	Object
    //   35	49	12	localFile	File
    // Exception table:
    //   from	to	target	type
    //   99	110	152	java/lang/OutOfMemoryError
    //   138	149	152	java/lang/OutOfMemoryError
    //   186	190	203	java/io/IOException
    //   195	200	203	java/io/IOException
    //   55	62	218	java/lang/Exception
    //   70	79	218	java/lang/Exception
    //   246	250	271	java/io/IOException
    //   259	264	271	java/io/IOException
    //   55	62	290	finally
    //   70	79	290	finally
    //   230	242	290	finally
    //   296	301	313	java/io/IOException
    //   306	311	313	java/io/IOException
    //   79	90	330	finally
    //   99	110	345	finally
    //   115	131	345	finally
    //   138	149	345	finally
    //   154	165	345	finally
    //   168	182	345	finally
    //   79	90	356	java/lang/Exception
    //   99	110	361	java/lang/Exception
    //   115	131	361	java/lang/Exception
    //   138	149	361	java/lang/Exception
    //   154	165	361	java/lang/Exception
    //   168	182	361	java/lang/Exception
  }
  
  public static abstract interface AssetFileComparator
  {
    public abstract boolean equals(Context paramContext, String paramString, File paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoFileUtil
 * JD-Core Version:    0.7.0.1
 */