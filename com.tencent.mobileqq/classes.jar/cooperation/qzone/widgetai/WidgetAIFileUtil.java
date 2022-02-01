package cooperation.qzone.widgetai;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.File;

public class WidgetAIFileUtil
{
  public static final String PIC_SAVE_DIR = VFSAssistantUtils.getSDKPrivatePath("QzonePet");
  private static final String TAG = "WidgetAIFileUtil";
  
  /* Error */
  public static boolean copyFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 31	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 5
    //   15: new 36	java/io/BufferedInputStream
    //   18: dup
    //   19: new 38	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 39	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 42	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   30: astore_0
    //   31: new 44	java/io/BufferedOutputStream
    //   34: dup
    //   35: new 46	java/io/FileOutputStream
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 47	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   43: invokespecial 50	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   46: astore_1
    //   47: aload 5
    //   49: invokevirtual 54	java/io/File:exists	()Z
    //   52: ifeq +83 -> 135
    //   55: sipush 8192
    //   58: newarray byte
    //   60: astore_3
    //   61: aload_0
    //   62: aload_3
    //   63: invokevirtual 58	java/io/BufferedInputStream:read	([B)I
    //   66: istore_2
    //   67: iload_2
    //   68: iconst_m1
    //   69: if_icmpeq +66 -> 135
    //   72: aload_1
    //   73: aload_3
    //   74: iconst_0
    //   75: iload_2
    //   76: invokevirtual 62	java/io/BufferedOutputStream:write	([BII)V
    //   79: goto -18 -> 61
    //   82: astore 4
    //   84: aload_0
    //   85: astore_3
    //   86: aload 4
    //   88: astore_0
    //   89: ldc 9
    //   91: new 64	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   98: ldc 67
    //   100: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_0
    //   104: invokevirtual 75	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   107: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 84	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   116: pop
    //   117: aload_0
    //   118: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   121: aload_1
    //   122: invokevirtual 90	java/io/BufferedOutputStream:flush	()V
    //   125: aload_1
    //   126: invokevirtual 93	java/io/BufferedOutputStream:close	()V
    //   129: aload_3
    //   130: invokevirtual 94	java/io/BufferedInputStream:close	()V
    //   133: iconst_0
    //   134: ireturn
    //   135: aload_1
    //   136: invokevirtual 90	java/io/BufferedOutputStream:flush	()V
    //   139: aload_1
    //   140: invokevirtual 93	java/io/BufferedOutputStream:close	()V
    //   143: aload_0
    //   144: invokevirtual 94	java/io/BufferedInputStream:close	()V
    //   147: iconst_1
    //   148: ireturn
    //   149: astore_0
    //   150: ldc 9
    //   152: aload_0
    //   153: invokestatic 98	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   156: invokestatic 84	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   159: pop
    //   160: goto -13 -> 147
    //   163: astore_0
    //   164: ldc 9
    //   166: aload_0
    //   167: invokestatic 98	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   170: invokestatic 84	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   173: pop
    //   174: iconst_0
    //   175: ireturn
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_1
    //   179: aload 4
    //   181: astore_3
    //   182: aload_1
    //   183: invokevirtual 90	java/io/BufferedOutputStream:flush	()V
    //   186: aload_1
    //   187: invokevirtual 93	java/io/BufferedOutputStream:close	()V
    //   190: aload_3
    //   191: invokevirtual 94	java/io/BufferedInputStream:close	()V
    //   194: aload_0
    //   195: athrow
    //   196: astore_1
    //   197: ldc 9
    //   199: aload_1
    //   200: invokestatic 98	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   203: invokestatic 84	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   206: pop
    //   207: goto -13 -> 194
    //   210: astore 4
    //   212: aconst_null
    //   213: astore_1
    //   214: aload_0
    //   215: astore_3
    //   216: aload 4
    //   218: astore_0
    //   219: goto -37 -> 182
    //   222: astore 4
    //   224: aload_0
    //   225: astore_3
    //   226: aload 4
    //   228: astore_0
    //   229: goto -47 -> 182
    //   232: astore_0
    //   233: goto -51 -> 182
    //   236: astore_0
    //   237: aconst_null
    //   238: astore_1
    //   239: goto -150 -> 89
    //   242: astore 4
    //   244: aconst_null
    //   245: astore_1
    //   246: aload_0
    //   247: astore_3
    //   248: aload 4
    //   250: astore_0
    //   251: goto -162 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramString1	String
    //   0	254	1	paramString2	String
    //   66	10	2	i	int
    //   4	244	3	localObject1	Object
    //   1	1	4	localObject2	Object
    //   82	98	4	localException1	java.lang.Exception
    //   210	7	4	localObject3	Object
    //   222	5	4	localObject4	Object
    //   242	7	4	localException2	java.lang.Exception
    //   13	35	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   47	61	82	java/lang/Exception
    //   61	67	82	java/lang/Exception
    //   72	79	82	java/lang/Exception
    //   135	147	149	java/lang/Exception
    //   121	133	163	java/lang/Exception
    //   5	31	176	finally
    //   182	194	196	java/lang/Exception
    //   31	47	210	finally
    //   47	61	222	finally
    //   61	67	222	finally
    //   72	79	222	finally
    //   89	121	232	finally
    //   5	31	236	java/lang/Exception
    //   31	47	242	java/lang/Exception
  }
  
  public static Bitmap createWhiteBitmap(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[paramInt1 * paramInt2];
    int i = 0;
    while (i < paramInt2)
    {
      int j = 0;
      while (j < paramInt1)
      {
        arrayOfInt[(i * paramInt1 + j)] = -1;
        j += 1;
      }
      i += 1;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    localBitmap.setPixels(arrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
    return localBitmap;
  }
  
  public static boolean deleteDirectory(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.endsWith(File.separator)) {
      localObject = paramString + File.separator;
    }
    paramString = new File((String)localObject);
    if ((!paramString.exists()) || (!paramString.isDirectory())) {
      break label112;
    }
    label59:
    do
    {
      return false;
      localObject = paramString.listFiles();
    } while (localObject == null);
    int j = 1;
    int i = 0;
    for (;;)
    {
      if (i < localObject.length)
      {
        if (localObject[i].isFile())
        {
          bool = deleteFile(localObject[i].getAbsolutePath());
          j = bool;
          if (bool) {
            break label140;
          }
          j = bool;
        }
      }
      else
      {
        label112:
        if (j == 0) {
          break label59;
        }
        return paramString.delete();
      }
      boolean bool = deleteDirectory(localObject[i].getAbsolutePath());
      j = bool;
      if (!bool) {
        break;
      }
      j = bool;
      label140:
      i += 1;
    }
  }
  
  public static boolean deleteFile(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.isFile()) && (paramString.exists())) {
      return paramString.delete();
    }
    return false;
  }
  
  public static int getFileType(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return 0;
      if (paramString.endsWith(".atlas")) {
        return 1;
      }
      if (paramString.endsWith(".json")) {
        return 2;
      }
    } while (!paramString.endsWith(".png"));
    return 4;
  }
  
  public static Bitmap mergeBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3)
  {
    Bitmap localBitmap;
    if (paramBitmap1 == null) {
      localBitmap = null;
    }
    do
    {
      return localBitmap;
      localBitmap = paramBitmap1;
    } while (paramBitmap2 == null);
    int i;
    if (paramInt3 == 0) {
      i = paramBitmap1.getWidth();
    }
    for (paramInt3 = paramBitmap1.getHeight() + paramBitmap2.getHeight();; paramInt3 = Math.max(paramBitmap1.getHeight(), paramBitmap2.getHeight()))
    {
      localBitmap = Bitmap.createBitmap(i, paramInt3, paramBitmap1.getConfig());
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawBitmap(paramBitmap1, new Matrix(), null);
      localCanvas.drawBitmap(paramBitmap2, paramInt1, paramInt2, null);
      return localBitmap;
      i = Math.max(paramBitmap1.getWidth(), paramBitmap2.getWidth());
    }
  }
  
  private static void reportToMM(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {}
  
  /* Error */
  public static String saveBitmapToMediaStore(String paramString, Bitmap paramBitmap, android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +14 -> 15
    //   4: aload_2
    //   5: ifnull +10 -> 15
    //   8: aload_0
    //   9: invokestatic 203	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: ldc 9
    //   19: ldc 205
    //   21: invokestatic 84	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   24: pop
    //   25: new 31	java/io/File
    //   28: dup
    //   29: getstatic 21	cooperation/qzone/widgetai/WidgetAIFileUtil:PIC_SAVE_DIR	Ljava/lang/String;
    //   32: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 54	java/io/File:exists	()Z
    //   42: ifne +160 -> 202
    //   45: aload 5
    //   47: invokevirtual 208	java/io/File:mkdirs	()Z
    //   50: pop
    //   51: new 31	java/io/File
    //   54: dup
    //   55: new 64	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   62: getstatic 21	cooperation/qzone/widgetai/WidgetAIFileUtil:PIC_SAVE_DIR	Ljava/lang/String;
    //   65: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: getstatic 121	java/io/File:separator	Ljava/lang/String;
    //   71: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_0
    //   75: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: astore 7
    //   86: aload 7
    //   88: invokevirtual 54	java/io/File:exists	()Z
    //   91: ifeq +9 -> 100
    //   94: aload 7
    //   96: invokevirtual 145	java/io/File:delete	()Z
    //   99: pop
    //   100: iconst_0
    //   101: istore 4
    //   103: new 46	java/io/FileOutputStream
    //   106: dup
    //   107: aload 7
    //   109: invokespecial 211	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   112: astore 6
    //   114: aload 6
    //   116: astore 5
    //   118: aload_1
    //   119: getstatic 217	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   122: bipush 100
    //   124: aload 6
    //   126: invokevirtual 221	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   129: pop
    //   130: aload 6
    //   132: astore 5
    //   134: aload 6
    //   136: invokevirtual 222	java/io/FileOutputStream:flush	()V
    //   139: aload 6
    //   141: astore 5
    //   143: ldc 9
    //   145: ldc 224
    //   147: invokestatic 227	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   150: pop
    //   151: iload 4
    //   153: istore_3
    //   154: aload 6
    //   156: ifnull +11 -> 167
    //   159: aload 6
    //   161: invokevirtual 228	java/io/FileOutputStream:close	()V
    //   164: iload 4
    //   166: istore_3
    //   167: iload_3
    //   168: ifne -153 -> 15
    //   171: aload_2
    //   172: invokevirtual 234	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   175: aload 7
    //   177: invokevirtual 139	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   180: aload_0
    //   181: aconst_null
    //   182: invokestatic 240	android/provider/MediaStore$Images$Media:insertImage	(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   185: pop
    //   186: aload_2
    //   187: aload 7
    //   189: invokevirtual 139	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   192: invokestatic 246	com/tencent/mobileqq/utils/kapalaiadapter/FileProvider7Helper:savePhotoToSysAlbum	(Landroid/content/Context;Ljava/lang/String;)Landroid/net/Uri;
    //   195: pop
    //   196: aload 7
    //   198: invokevirtual 139	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   201: areturn
    //   202: aload 5
    //   204: invokevirtual 129	java/io/File:isDirectory	()Z
    //   207: ifne -156 -> 51
    //   210: aload 5
    //   212: invokevirtual 145	java/io/File:delete	()Z
    //   215: pop
    //   216: aload 5
    //   218: invokevirtual 208	java/io/File:mkdirs	()Z
    //   221: pop
    //   222: goto -171 -> 51
    //   225: astore_1
    //   226: aload_1
    //   227: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   230: iload 4
    //   232: istore_3
    //   233: goto -66 -> 167
    //   236: astore_1
    //   237: aconst_null
    //   238: astore 6
    //   240: aload 6
    //   242: astore 5
    //   244: aload_1
    //   245: invokevirtual 248	java/io/FileNotFoundException:printStackTrace	()V
    //   248: aload 6
    //   250: ifnull +104 -> 354
    //   253: aload 6
    //   255: invokevirtual 228	java/io/FileOutputStream:close	()V
    //   258: iconst_1
    //   259: istore_3
    //   260: goto -93 -> 167
    //   263: astore_1
    //   264: aload_1
    //   265: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   268: iconst_1
    //   269: istore_3
    //   270: goto -103 -> 167
    //   273: astore_1
    //   274: aconst_null
    //   275: astore 6
    //   277: aload 6
    //   279: astore 5
    //   281: aload_1
    //   282: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   285: aload 6
    //   287: ifnull +67 -> 354
    //   290: aload 6
    //   292: invokevirtual 228	java/io/FileOutputStream:close	()V
    //   295: iconst_1
    //   296: istore_3
    //   297: goto -130 -> 167
    //   300: astore_1
    //   301: aload_1
    //   302: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   305: iconst_1
    //   306: istore_3
    //   307: goto -140 -> 167
    //   310: astore_0
    //   311: aconst_null
    //   312: astore 5
    //   314: aload 5
    //   316: ifnull +8 -> 324
    //   319: aload 5
    //   321: invokevirtual 228	java/io/FileOutputStream:close	()V
    //   324: aload_0
    //   325: athrow
    //   326: astore_1
    //   327: aload_1
    //   328: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   331: goto -7 -> 324
    //   334: astore_0
    //   335: aload_0
    //   336: invokevirtual 248	java/io/FileNotFoundException:printStackTrace	()V
    //   339: goto -153 -> 186
    //   342: astore_0
    //   343: goto -29 -> 314
    //   346: astore_1
    //   347: goto -70 -> 277
    //   350: astore_1
    //   351: goto -111 -> 240
    //   354: iconst_1
    //   355: istore_3
    //   356: goto -189 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	paramString	String
    //   0	359	1	paramBitmap	Bitmap
    //   0	359	2	paramContext	android.content.Context
    //   153	203	3	i	int
    //   101	130	4	j	int
    //   35	285	5	localObject	Object
    //   112	179	6	localFileOutputStream	java.io.FileOutputStream
    //   84	113	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   159	164	225	java/io/IOException
    //   103	114	236	java/io/FileNotFoundException
    //   253	258	263	java/io/IOException
    //   103	114	273	java/io/IOException
    //   290	295	300	java/io/IOException
    //   103	114	310	finally
    //   319	324	326	java/io/IOException
    //   171	186	334	java/io/FileNotFoundException
    //   118	130	342	finally
    //   134	139	342	finally
    //   143	151	342	finally
    //   244	248	342	finally
    //   281	285	342	finally
    //   118	130	346	java/io/IOException
    //   134	139	346	java/io/IOException
    //   143	151	346	java/io/IOException
    //   118	130	350	java/io/FileNotFoundException
    //   134	139	350	java/io/FileNotFoundException
    //   143	151	350	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widgetai.WidgetAIFileUtil
 * JD-Core Version:    0.7.0.1
 */