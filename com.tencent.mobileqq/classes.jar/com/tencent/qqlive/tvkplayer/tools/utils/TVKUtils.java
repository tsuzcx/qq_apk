package com.tencent.qqlive.tvkplayer.tools.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaDrm;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.regex.PatternSyntaxException;
import java.util.zip.ZipEntry;

public class TVKUtils
{
  private static String DOT = "\\.";
  private static final String TAG = "TVKUtils[TVKUtils.java]";
  private static String appVersion = "";
  private static int buildNum = -1;
  private static float sDensity;
  private static int sWidth;
  
  /* Error */
  public static byte[] GZIPDeCompress(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +8 -> 9
    //   4: aload_0
    //   5: arraylength
    //   6: ifne +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 39	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 42	java/io/ByteArrayInputStream:<init>	([B)V
    //   19: astore_2
    //   20: new 44	java/io/ByteArrayOutputStream
    //   23: dup
    //   24: invokespecial 45	java/io/ByteArrayOutputStream:<init>	()V
    //   27: astore_3
    //   28: new 47	java/util/zip/GZIPInputStream
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 50	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore_0
    //   37: aload_0
    //   38: astore 4
    //   40: aload_3
    //   41: astore 6
    //   43: aload_2
    //   44: astore 5
    //   46: sipush 8192
    //   49: newarray byte
    //   51: astore 7
    //   53: aload_0
    //   54: astore 4
    //   56: aload_3
    //   57: astore 6
    //   59: aload_2
    //   60: astore 5
    //   62: aload_0
    //   63: aload 7
    //   65: iconst_0
    //   66: sipush 8192
    //   69: invokevirtual 54	java/util/zip/GZIPInputStream:read	([BII)I
    //   72: istore_1
    //   73: iload_1
    //   74: iconst_m1
    //   75: if_icmpeq +67 -> 142
    //   78: aload_0
    //   79: astore 4
    //   81: aload_3
    //   82: astore 6
    //   84: aload_2
    //   85: astore 5
    //   87: aload_3
    //   88: aload 7
    //   90: iconst_0
    //   91: iload_1
    //   92: invokevirtual 58	java/io/ByteArrayOutputStream:write	([BII)V
    //   95: goto -42 -> 53
    //   98: astore 4
    //   100: aload_0
    //   101: astore 4
    //   103: aload_3
    //   104: astore 6
    //   106: aload_2
    //   107: astore 5
    //   109: aload_3
    //   110: invokevirtual 62	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   113: astore 7
    //   115: aload_2
    //   116: ifnull +7 -> 123
    //   119: aload_2
    //   120: invokevirtual 65	java/io/ByteArrayInputStream:close	()V
    //   123: aload_3
    //   124: ifnull +7 -> 131
    //   127: aload_3
    //   128: invokevirtual 66	java/io/ByteArrayOutputStream:close	()V
    //   131: aload_0
    //   132: ifnull +7 -> 139
    //   135: aload_0
    //   136: invokevirtual 67	java/util/zip/GZIPInputStream:close	()V
    //   139: aload 7
    //   141: areturn
    //   142: aload_0
    //   143: astore 4
    //   145: aload_3
    //   146: astore 6
    //   148: aload_2
    //   149: astore 5
    //   151: aload_3
    //   152: invokevirtual 62	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   155: astore 7
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 65	java/io/ByteArrayInputStream:close	()V
    //   165: aload_3
    //   166: ifnull +7 -> 173
    //   169: aload_3
    //   170: invokevirtual 66	java/io/ByteArrayOutputStream:close	()V
    //   173: aload_0
    //   174: ifnull +7 -> 181
    //   177: aload_0
    //   178: invokevirtual 67	java/util/zip/GZIPInputStream:close	()V
    //   181: aload 7
    //   183: areturn
    //   184: astore_0
    //   185: aconst_null
    //   186: astore_0
    //   187: aconst_null
    //   188: astore_3
    //   189: aconst_null
    //   190: astore_2
    //   191: aload_2
    //   192: ifnull +7 -> 199
    //   195: aload_2
    //   196: invokevirtual 65	java/io/ByteArrayInputStream:close	()V
    //   199: aload_3
    //   200: ifnull +7 -> 207
    //   203: aload_3
    //   204: invokevirtual 66	java/io/ByteArrayOutputStream:close	()V
    //   207: aload_0
    //   208: ifnull -199 -> 9
    //   211: aload_0
    //   212: invokevirtual 67	java/util/zip/GZIPInputStream:close	()V
    //   215: aconst_null
    //   216: areturn
    //   217: astore_0
    //   218: aconst_null
    //   219: areturn
    //   220: astore_0
    //   221: aconst_null
    //   222: astore 4
    //   224: aconst_null
    //   225: astore_3
    //   226: aconst_null
    //   227: astore_2
    //   228: aload_2
    //   229: ifnull +7 -> 236
    //   232: aload_2
    //   233: invokevirtual 65	java/io/ByteArrayInputStream:close	()V
    //   236: aload_3
    //   237: ifnull +7 -> 244
    //   240: aload_3
    //   241: invokevirtual 66	java/io/ByteArrayOutputStream:close	()V
    //   244: aload 4
    //   246: ifnull +8 -> 254
    //   249: aload 4
    //   251: invokevirtual 67	java/util/zip/GZIPInputStream:close	()V
    //   254: aload_0
    //   255: athrow
    //   256: astore_0
    //   257: aconst_null
    //   258: areturn
    //   259: astore_0
    //   260: aconst_null
    //   261: astore 4
    //   263: aconst_null
    //   264: astore_3
    //   265: goto -37 -> 228
    //   268: astore_0
    //   269: aconst_null
    //   270: astore 4
    //   272: goto -44 -> 228
    //   275: astore_0
    //   276: aload 6
    //   278: astore_3
    //   279: aload 5
    //   281: astore_2
    //   282: goto -54 -> 228
    //   285: astore_0
    //   286: aconst_null
    //   287: astore_0
    //   288: aconst_null
    //   289: astore_3
    //   290: goto -99 -> 191
    //   293: astore_0
    //   294: aconst_null
    //   295: astore_0
    //   296: goto -105 -> 191
    //   299: astore 4
    //   301: goto -110 -> 191
    //   304: astore_0
    //   305: aconst_null
    //   306: areturn
    //   307: astore_0
    //   308: aconst_null
    //   309: astore_0
    //   310: aconst_null
    //   311: astore_3
    //   312: aconst_null
    //   313: astore_2
    //   314: goto -214 -> 100
    //   317: astore_0
    //   318: aconst_null
    //   319: astore_0
    //   320: aconst_null
    //   321: astore_3
    //   322: goto -222 -> 100
    //   325: astore_0
    //   326: aconst_null
    //   327: astore_0
    //   328: goto -228 -> 100
    //   331: astore_0
    //   332: aconst_null
    //   333: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramArrayOfByte	byte[]
    //   72	20	1	i	int
    //   19	295	2	localObject1	Object
    //   27	295	3	localObject2	Object
    //   38	42	4	arrayOfByte1	byte[]
    //   98	1	4	localEOFException	java.io.EOFException
    //   101	170	4	arrayOfByte2	byte[]
    //   299	1	4	localIOException	IOException
    //   44	236	5	localObject3	Object
    //   41	236	6	localObject4	Object
    //   51	131	7	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   46	53	98	java/io/EOFException
    //   62	73	98	java/io/EOFException
    //   87	95	98	java/io/EOFException
    //   151	157	98	java/io/EOFException
    //   11	20	184	java/io/IOException
    //   195	199	217	java/io/IOException
    //   203	207	217	java/io/IOException
    //   211	215	217	java/io/IOException
    //   11	20	220	finally
    //   232	236	256	java/io/IOException
    //   240	244	256	java/io/IOException
    //   249	254	256	java/io/IOException
    //   20	28	259	finally
    //   28	37	268	finally
    //   46	53	275	finally
    //   62	73	275	finally
    //   87	95	275	finally
    //   109	115	275	finally
    //   151	157	275	finally
    //   20	28	285	java/io/IOException
    //   28	37	293	java/io/IOException
    //   46	53	299	java/io/IOException
    //   62	73	299	java/io/IOException
    //   87	95	299	java/io/IOException
    //   151	157	299	java/io/IOException
    //   119	123	304	java/io/IOException
    //   127	131	304	java/io/IOException
    //   135	139	304	java/io/IOException
    //   11	20	307	java/io/EOFException
    //   20	28	317	java/io/EOFException
    //   28	37	325	java/io/EOFException
    //   161	165	331	java/io/IOException
    //   169	173	331	java/io/IOException
    //   177	181	331	java/io/IOException
  }
  
  /* Error */
  public static boolean byte2File(byte[] paramArrayOfByte, int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnull +12 -> 16
    //   7: aload_0
    //   8: arraylength
    //   9: ifeq +7 -> 16
    //   12: iload_1
    //   13: ifne +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_2
    //   19: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifne -6 -> 16
    //   25: aload_3
    //   26: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifne -13 -> 16
    //   32: new 79	java/io/File
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore_2
    //   41: aload_2
    //   42: invokevirtual 86	java/io/File:exists	()Z
    //   45: ifeq +10 -> 55
    //   48: aload_2
    //   49: invokevirtual 89	java/io/File:isDirectory	()Z
    //   52: ifne +10 -> 62
    //   55: aload_2
    //   56: invokevirtual 92	java/io/File:mkdirs	()Z
    //   59: ifeq -43 -> 16
    //   62: new 79	java/io/File
    //   65: dup
    //   66: new 94	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   73: aload_2
    //   74: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: getstatic 102	java/io/File:separator	Ljava/lang/String;
    //   80: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_3
    //   84: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   93: astore_2
    //   94: aload_2
    //   95: invokevirtual 86	java/io/File:exists	()Z
    //   98: ifeq +15 -> 113
    //   101: aload_2
    //   102: invokevirtual 113	java/io/File:length	()J
    //   105: iload_1
    //   106: i2l
    //   107: lcmp
    //   108: ifne +5 -> 113
    //   111: iconst_1
    //   112: ireturn
    //   113: aload_2
    //   114: invokevirtual 86	java/io/File:exists	()Z
    //   117: ifeq +10 -> 127
    //   120: aload_2
    //   121: invokevirtual 116	java/io/File:delete	()Z
    //   124: ifeq -108 -> 16
    //   127: new 118	java/io/FileOutputStream
    //   130: dup
    //   131: aload_2
    //   132: invokespecial 121	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   135: astore_3
    //   136: new 123	java/io/BufferedOutputStream
    //   139: dup
    //   140: aload_3
    //   141: invokespecial 126	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   144: astore 4
    //   146: aload 4
    //   148: aload_0
    //   149: invokevirtual 128	java/io/BufferedOutputStream:write	([B)V
    //   152: aload 4
    //   154: invokevirtual 131	java/io/BufferedOutputStream:flush	()V
    //   157: aload 4
    //   159: ifnull +8 -> 167
    //   162: aload 4
    //   164: invokevirtual 132	java/io/BufferedOutputStream:close	()V
    //   167: aload_3
    //   168: ifnull +7 -> 175
    //   171: aload_3
    //   172: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   175: iconst_1
    //   176: ireturn
    //   177: astore_0
    //   178: ldc 9
    //   180: aload_0
    //   181: invokestatic 139	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: goto -9 -> 175
    //   187: astore_3
    //   188: aconst_null
    //   189: astore_0
    //   190: aload 4
    //   192: astore_2
    //   193: ldc 9
    //   195: aload_3
    //   196: invokestatic 139	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   199: aload_0
    //   200: ifnull +7 -> 207
    //   203: aload_0
    //   204: invokevirtual 132	java/io/BufferedOutputStream:close	()V
    //   207: aload_2
    //   208: ifnull -192 -> 16
    //   211: aload_2
    //   212: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   215: iconst_0
    //   216: ireturn
    //   217: astore_0
    //   218: ldc 9
    //   220: aload_0
    //   221: invokestatic 139	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   224: iconst_0
    //   225: ireturn
    //   226: astore_2
    //   227: aconst_null
    //   228: astore_0
    //   229: aconst_null
    //   230: astore_3
    //   231: aload_0
    //   232: ifnull +7 -> 239
    //   235: aload_0
    //   236: invokevirtual 132	java/io/BufferedOutputStream:close	()V
    //   239: aload_3
    //   240: ifnull +7 -> 247
    //   243: aload_3
    //   244: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   247: aload_2
    //   248: athrow
    //   249: astore_0
    //   250: ldc 9
    //   252: aload_0
    //   253: invokestatic 139	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   256: goto -9 -> 247
    //   259: astore_2
    //   260: aconst_null
    //   261: astore_0
    //   262: goto -31 -> 231
    //   265: astore_2
    //   266: aload 4
    //   268: astore_0
    //   269: goto -38 -> 231
    //   272: astore 4
    //   274: aload_2
    //   275: astore_3
    //   276: aload 4
    //   278: astore_2
    //   279: goto -48 -> 231
    //   282: astore 4
    //   284: aconst_null
    //   285: astore_0
    //   286: aload_3
    //   287: astore_2
    //   288: aload 4
    //   290: astore_3
    //   291: goto -98 -> 193
    //   294: astore_0
    //   295: aload_3
    //   296: astore_2
    //   297: aload_0
    //   298: astore_3
    //   299: aload 4
    //   301: astore_0
    //   302: goto -109 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	paramArrayOfByte	byte[]
    //   0	305	1	paramInt	int
    //   0	305	2	paramString1	String
    //   0	305	3	paramString2	String
    //   1	266	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   272	5	4	localObject	Object
    //   282	18	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   162	167	177	java/lang/Exception
    //   171	175	177	java/lang/Exception
    //   127	136	187	java/lang/Exception
    //   203	207	217	java/lang/Exception
    //   211	215	217	java/lang/Exception
    //   127	136	226	finally
    //   235	239	249	java/lang/Exception
    //   243	247	249	java/lang/Exception
    //   136	146	259	finally
    //   146	157	265	finally
    //   193	199	272	finally
    //   136	146	282	java/lang/Exception
    //   146	157	294	java/lang/Exception
  }
  
  public static void clearDir(File paramFile)
  {
    if (paramFile.isFile()) {}
    do
    {
      return;
      paramFile = paramFile.listFiles();
    } while (paramFile == null);
    int j = paramFile.length;
    int i = 0;
    label22:
    File localFile;
    if (i < j)
    {
      localFile = paramFile[i];
      if (!localFile.isFile()) {
        break label50;
      }
      localFile.delete();
    }
    for (;;)
    {
      i += 1;
      break label22;
      break;
      label50:
      deleteDir(localFile);
    }
  }
  
  public static long convertDateToTime(String paramString)
  {
    long l = 0L;
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString);
      if (paramString != null) {
        l = paramString.getTime();
      }
      return l;
    }
    catch (Exception paramString)
    {
      TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString);
    }
    return 0L;
  }
  
  public static String convertDefnName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace(";(", "  ").replace(")", "");
  }
  
  /* Error */
  public static void copyAssetsToDst(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_0
    //   6: invokevirtual 189	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   9: aload_1
    //   10: invokevirtual 195	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   13: astore 6
    //   15: aload 6
    //   17: arraylength
    //   18: ifle +154 -> 172
    //   21: new 79	java/io/File
    //   24: dup
    //   25: aload_2
    //   26: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore 5
    //   31: aload 5
    //   33: invokevirtual 86	java/io/File:exists	()Z
    //   36: ifne +9 -> 45
    //   39: aload 5
    //   41: invokevirtual 92	java/io/File:mkdirs	()Z
    //   44: pop
    //   45: aload 6
    //   47: arraylength
    //   48: istore 4
    //   50: iload_3
    //   51: iload 4
    //   53: if_icmpge +84 -> 137
    //   56: aload 6
    //   58: iload_3
    //   59: aaload
    //   60: astore 5
    //   62: aload_1
    //   63: ldc 23
    //   65: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifne +70 -> 138
    //   71: aload_0
    //   72: new 94	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   79: aload_1
    //   80: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: getstatic 102	java/io/File:separator	Ljava/lang/String;
    //   86: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 5
    //   91: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: new 94	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   104: aload_2
    //   105: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: getstatic 102	java/io/File:separator	Ljava/lang/String;
    //   111: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 5
    //   116: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 201	com/tencent/qqlive/tvkplayer/tools/utils/TVKUtils:copyAssetsToDst	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   125: iload_3
    //   126: iconst_1
    //   127: iadd
    //   128: istore_3
    //   129: goto -79 -> 50
    //   132: astore_0
    //   133: aload_0
    //   134: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   137: return
    //   138: aload_0
    //   139: aload 5
    //   141: new 94	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   148: aload_2
    //   149: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: getstatic 102	java/io/File:separator	Ljava/lang/String;
    //   155: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload 5
    //   160: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 201	com/tencent/qqlive/tvkplayer/tools/utils/TVKUtils:copyAssetsToDst	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   169: goto -44 -> 125
    //   172: new 79	java/io/File
    //   175: dup
    //   176: aload_2
    //   177: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   180: astore_2
    //   181: aload_0
    //   182: invokevirtual 189	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   185: aload_1
    //   186: invokevirtual 208	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   189: astore_0
    //   190: new 118	java/io/FileOutputStream
    //   193: dup
    //   194: aload_2
    //   195: invokespecial 121	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   198: astore_2
    //   199: sipush 1024
    //   202: newarray byte
    //   204: astore_1
    //   205: aload_0
    //   206: aload_1
    //   207: invokevirtual 213	java/io/InputStream:read	([B)I
    //   210: istore_3
    //   211: iload_3
    //   212: iconst_m1
    //   213: if_icmpeq +57 -> 270
    //   216: aload_2
    //   217: aload_1
    //   218: iconst_0
    //   219: iload_3
    //   220: invokevirtual 214	java/io/FileOutputStream:write	([BII)V
    //   223: goto -18 -> 205
    //   226: astore 5
    //   228: aload_0
    //   229: astore_1
    //   230: aload_2
    //   231: astore_0
    //   232: aload 5
    //   234: astore_2
    //   235: aload_2
    //   236: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   239: aload_0
    //   240: ifnull +7 -> 247
    //   243: aload_0
    //   244: invokevirtual 216	java/io/FileOutputStream:flush	()V
    //   247: aload_1
    //   248: ifnull +7 -> 255
    //   251: aload_1
    //   252: invokevirtual 217	java/io/InputStream:close	()V
    //   255: aload_0
    //   256: ifnull -119 -> 137
    //   259: aload_0
    //   260: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   263: return
    //   264: astore_0
    //   265: aload_0
    //   266: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   269: return
    //   270: aload_2
    //   271: invokevirtual 216	java/io/FileOutputStream:flush	()V
    //   274: aload_0
    //   275: invokevirtual 217	java/io/InputStream:close	()V
    //   278: aload_2
    //   279: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   282: aload_2
    //   283: ifnull +7 -> 290
    //   286: aload_2
    //   287: invokevirtual 216	java/io/FileOutputStream:flush	()V
    //   290: aload_0
    //   291: ifnull +7 -> 298
    //   294: aload_0
    //   295: invokevirtual 217	java/io/InputStream:close	()V
    //   298: aload_2
    //   299: ifnull -162 -> 137
    //   302: aload_2
    //   303: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   306: return
    //   307: astore_0
    //   308: aload_0
    //   309: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   312: return
    //   313: astore_1
    //   314: aconst_null
    //   315: astore_2
    //   316: aconst_null
    //   317: astore_0
    //   318: aload_2
    //   319: ifnull +7 -> 326
    //   322: aload_2
    //   323: invokevirtual 216	java/io/FileOutputStream:flush	()V
    //   326: aload_0
    //   327: ifnull +7 -> 334
    //   330: aload_0
    //   331: invokevirtual 217	java/io/InputStream:close	()V
    //   334: aload_2
    //   335: ifnull +7 -> 342
    //   338: aload_2
    //   339: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   342: aload_1
    //   343: athrow
    //   344: astore_0
    //   345: aload_0
    //   346: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   349: goto -7 -> 342
    //   352: astore_1
    //   353: aconst_null
    //   354: astore_2
    //   355: goto -37 -> 318
    //   358: astore_1
    //   359: goto -41 -> 318
    //   362: astore_2
    //   363: aload_1
    //   364: astore 5
    //   366: aload_2
    //   367: astore_1
    //   368: aload_0
    //   369: astore_2
    //   370: aload 5
    //   372: astore_0
    //   373: goto -55 -> 318
    //   376: astore_2
    //   377: aconst_null
    //   378: astore_0
    //   379: aload 5
    //   381: astore_1
    //   382: goto -147 -> 235
    //   385: astore_2
    //   386: aconst_null
    //   387: astore 5
    //   389: aload_0
    //   390: astore_1
    //   391: aload 5
    //   393: astore_0
    //   394: goto -159 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	paramContext	Context
    //   0	397	1	paramString1	String
    //   0	397	2	paramString2	String
    //   4	216	3	i	int
    //   48	6	4	j	int
    //   1	158	5	localFile	File
    //   226	7	5	localException	Exception
    //   364	28	5	str	String
    //   13	44	6	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   5	15	132	java/io/IOException
    //   199	205	226	java/lang/Exception
    //   205	211	226	java/lang/Exception
    //   216	223	226	java/lang/Exception
    //   270	282	226	java/lang/Exception
    //   243	247	264	java/io/IOException
    //   251	255	264	java/io/IOException
    //   259	263	264	java/io/IOException
    //   286	290	307	java/io/IOException
    //   294	298	307	java/io/IOException
    //   302	306	307	java/io/IOException
    //   172	190	313	finally
    //   322	326	344	java/io/IOException
    //   330	334	344	java/io/IOException
    //   338	342	344	java/io/IOException
    //   190	199	352	finally
    //   199	205	358	finally
    //   205	211	358	finally
    //   216	223	358	finally
    //   270	282	358	finally
    //   235	239	362	finally
    //   172	190	376	java/lang/Exception
    //   190	199	385	java/lang/Exception
  }
  
  public static int defLevelCompare(String paramString1, String paramString2)
  {
    int i = getDefLevel(paramString1);
    int j = getDefLevel(paramString2);
    if (i > j) {
      return 1;
    }
    if (i == j) {
      return 0;
    }
    return -1;
  }
  
  public static boolean deleteDir(File paramFile)
  {
    boolean bool2 = false;
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      boolean bool1;
      if (arrayOfString == null)
      {
        bool1 = true;
        return bool1;
      }
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label64;
        }
        bool1 = bool2;
        if (!deleteDir(new File(paramFile, arrayOfString[i]))) {
          break;
        }
        i += 1;
      }
    }
    label64:
    return paramFile.delete();
  }
  
  public static void deleteSuffixFiles(File paramFile, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        if ((!paramFile.exists()) || (!paramFile.isFile())) {
          continue;
        }
        paramFile = paramFile.listFiles();
        if (paramFile == null) {
          continue;
        }
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramFile[i];
          String str = localObject.getName();
          if ((localObject.isFile()) && (str.endsWith(paramString)) && (localObject.delete())) {
            Log.e("deleteSuffixFiles", "file delete err, filename:" + str);
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
      }
    }
  }
  
  public static String findPathWithName(String paramString1, String paramString2, File paramFile)
  {
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if (paramFile == null) {
        return "";
      }
      int j = paramFile.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramFile[i];
        if (((File)localObject).isFile()) {
          if (((File)localObject).getName().equals(paramString1)) {}
        }
        do
        {
          do
          {
            i += 1;
            break;
          } while (!((File)localObject).getParentFile().getName().equals(paramString2));
          return ((File)localObject).getAbsolutePath();
          localObject = findPathWithName(paramString1, paramString2, (File)localObject);
        } while (TextUtils.isEmpty((CharSequence)localObject));
        return localObject;
      }
    }
    return "";
  }
  
  public static Activity getActivity(View paramView)
  {
    if (paramView.getRootView().getContext().getClass().getName().contains("com.android.internal.policy.DecorContext")) {
      try
      {
        Field localField = paramView.getRootView().getContext().getClass().getDeclaredField("mPhoneWindow");
        localField.setAccessible(true);
        paramView = localField.get(paramView.getRootView().getContext());
        paramView = (Activity)paramView.getClass().getMethod("getContext", new Class[0]).invoke(paramView, new Object[0]);
        return paramView;
      }
      catch (Exception paramView)
      {
        TVKLogUtil.e("TVKUtils[TVKUtils.java]", "Exception: " + paramView.toString());
        return null;
      }
    }
    try
    {
      paramView = (Activity)paramView.getRootView().getContext();
      return paramView;
    }
    catch (Exception paramView)
    {
      TVKLogUtil.e("TVKUtils[TVKUtils.java]", "Exception: " + paramView.toString());
    }
    return null;
  }
  
  public static String getAppVersion(String paramString)
  {
    if (!TextUtils.isEmpty(appVersion)) {
      return appVersion;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split(DOT);
      str = paramString;
      if (arrayOfString != null)
      {
        str = paramString;
        if (arrayOfString.length != 4) {}
      }
    }
    for (String str = paramString.substring(0, paramString.lastIndexOf("."));; str = "0.0.0")
    {
      appVersion = str;
      return str;
    }
  }
  
  public static int getBuildNumber(String paramString)
  {
    if (-1 != buildNum) {
      return buildNum;
    }
    int j = 0;
    int i = j;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(DOT);
      i = j;
      if (paramString.length != 4) {}
    }
    try
    {
      i = Integer.parseInt(paramString[3]);
      buildNum = i;
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString);
        i = j;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString);
        i = j;
      }
    }
  }
  
  public static String getCpuArch()
  {
    return Build.CPU_ABI;
  }
  
  public static int getDefLevel(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    if (paramString.equals("msd")) {
      return 0;
    }
    if (paramString.equals("sd")) {
      return 1;
    }
    if (paramString.equals("hd")) {
      return 2;
    }
    if (paramString.equals("shd")) {
      return 3;
    }
    if (paramString.equals("fhd")) {
      return 4;
    }
    if (paramString.equals("uhd")) {
      return 5;
    }
    return 6;
  }
  
  public static float getDensity(Context paramContext)
  {
    if (sDensity != 0.0F) {
      return sDensity;
    }
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      sDensity = Math.round(localDisplayMetrics.density * 100.0F) / 100.0F;
      sWidth = Math.max(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels);
      return sDensity;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramContext);
      }
    }
  }
  
  /* Error */
  public static String getMD5(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 408
    //   6: invokestatic 414	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   9: astore_3
    //   10: new 416	java/io/FileInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 417	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_0
    //   21: sipush 8192
    //   24: newarray byte
    //   26: astore 5
    //   28: aload_2
    //   29: astore_0
    //   30: aload_2
    //   31: aload 5
    //   33: invokevirtual 418	java/io/FileInputStream:read	([B)I
    //   36: istore_1
    //   37: iload_1
    //   38: iconst_m1
    //   39: if_icmpeq +39 -> 78
    //   42: aload_2
    //   43: astore_0
    //   44: aload_3
    //   45: aload 5
    //   47: iconst_0
    //   48: iload_1
    //   49: invokevirtual 421	java/security/MessageDigest:update	([BII)V
    //   52: goto -24 -> 28
    //   55: astore_3
    //   56: aload_2
    //   57: astore_0
    //   58: aload_3
    //   59: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   62: aload 4
    //   64: astore_0
    //   65: aload_2
    //   66: ifnull +10 -> 76
    //   69: aload_2
    //   70: invokevirtual 422	java/io/FileInputStream:close	()V
    //   73: aload 4
    //   75: astore_0
    //   76: aload_0
    //   77: areturn
    //   78: aload_2
    //   79: astore_0
    //   80: new 424	java/math/BigInteger
    //   83: dup
    //   84: iconst_1
    //   85: aload_3
    //   86: invokevirtual 427	java/security/MessageDigest:digest	()[B
    //   89: invokespecial 430	java/math/BigInteger:<init>	(I[B)V
    //   92: bipush 16
    //   94: invokevirtual 433	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   97: astore_3
    //   98: aload_3
    //   99: astore_0
    //   100: aload_2
    //   101: ifnull -25 -> 76
    //   104: aload_2
    //   105: invokevirtual 422	java/io/FileInputStream:close	()V
    //   108: aload_3
    //   109: areturn
    //   110: astore_0
    //   111: aload_0
    //   112: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   115: aload_3
    //   116: areturn
    //   117: astore_0
    //   118: aload_0
    //   119: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_2
    //   125: aconst_null
    //   126: astore_0
    //   127: aload_0
    //   128: ifnull +7 -> 135
    //   131: aload_0
    //   132: invokevirtual 422	java/io/FileInputStream:close	()V
    //   135: aload_2
    //   136: athrow
    //   137: astore_0
    //   138: aload_0
    //   139: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   142: goto -7 -> 135
    //   145: astore_2
    //   146: goto -19 -> 127
    //   149: astore_3
    //   150: aconst_null
    //   151: astore_2
    //   152: goto -96 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramFile	File
    //   36	13	1	i	int
    //   18	87	2	localFileInputStream	FileInputStream
    //   124	12	2	localObject1	Object
    //   145	1	2	localObject2	Object
    //   151	1	2	localObject3	Object
    //   9	36	3	localMessageDigest	MessageDigest
    //   55	31	3	localException1	Exception
    //   97	19	3	str	String
    //   149	1	3	localException2	Exception
    //   1	73	4	localObject4	Object
    //   26	20	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   21	28	55	java/lang/Exception
    //   30	37	55	java/lang/Exception
    //   44	52	55	java/lang/Exception
    //   80	98	55	java/lang/Exception
    //   104	108	110	java/io/IOException
    //   69	73	117	java/io/IOException
    //   3	19	124	finally
    //   131	135	137	java/io/IOException
    //   21	28	145	finally
    //   30	37	145	finally
    //   44	52	145	finally
    //   58	62	145	finally
    //   80	98	145	finally
    //   3	19	149	java/lang/Exception
  }
  
  public static boolean getMapValueBool(Map<String, Object> paramMap, String paramString, boolean paramBoolean)
  {
    paramMap = paramMap.get(paramString);
    if (paramMap != null) {
      paramBoolean = ((Boolean)paramMap).booleanValue();
    }
    return paramBoolean;
  }
  
  public static float getMapValueFloat(Map<String, Object> paramMap, String paramString, float paramFloat)
  {
    paramMap = paramMap.get(paramString);
    if (paramMap != null) {
      paramFloat = ((Float)paramMap).floatValue();
    }
    return paramFloat;
  }
  
  public static int getMapValueInteger(Map<String, Object> paramMap, String paramString, int paramInt)
  {
    paramMap = paramMap.get(paramString);
    if (paramMap != null) {
      paramInt = ((Integer)paramMap).intValue();
    }
    return paramInt;
  }
  
  public static long getMapValueLong(Map<String, Object> paramMap, String paramString, long paramLong)
  {
    paramMap = paramMap.get(paramString);
    if (paramMap != null) {
      paramLong = ((Long)paramMap).longValue();
    }
    return paramLong;
  }
  
  public static Object getMapValueObject(Map<String, Object> paramMap, String paramString)
  {
    if (paramMap == null) {
      return null;
    }
    return paramMap.get(paramString);
  }
  
  public static String getMapValueString(Map<String, Object> paramMap, String paramString1, String paramString2)
  {
    paramMap = paramMap.get(paramString1);
    if (paramMap != null) {
      return (String)paramMap;
    }
    return paramString2;
  }
  
  public static String getMd5(String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      int i;
      try
      {
        paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"));
        localStringBuilder = new StringBuilder(40);
        int j = paramString.length;
        i = 0;
        if (i < j)
        {
          int k = paramString[i];
          if ((k & 0xFF) >> 4 == 0) {
            localStringBuilder.append("0").append(Integer.toHexString(k & 0xFF));
          } else {
            localStringBuilder.append(Integer.toHexString(k & 0xFF));
          }
        }
      }
      catch (Exception paramString)
      {
        TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString.toString());
        return null;
      }
      paramString = localStringBuilder.toString();
      return paramString;
      i += 1;
    }
  }
  
  public static String getSafeString(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return str;
  }
  
  public static String getString(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Parameter may not be null");
    }
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new IllegalArgumentException("charset may not be null or empty");
    }
    try
    {
      paramString = new String(paramArrayOfByte, paramInt1, paramInt2, paramString);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return new String(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int getTextureFromBitmap(Context paramContext, String paramString)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2 = localObject4;
    for (;;)
    {
      try
      {
        if (paramString.contains("/"))
        {
          localObject1 = localObject3;
          localObject2 = localObject4;
          paramContext = new FileInputStream(paramString);
          localObject1 = paramContext;
          localObject2 = paramContext;
          paramString = BitmapFactory.decodeStream(paramContext);
          if (paramContext == null) {}
        }
      }
      catch (Throwable paramContext)
      {
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((InputStream)localObject1).close();
          return 0;
        }
        catch (IOException paramContext)
        {
          TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramContext);
          return 0;
        }
      }
      finally
      {
        if (localObject2 == null) {
          continue;
        }
        try
        {
          ((InputStream)localObject2).close();
          throw paramContext;
        }
        catch (IOException paramString)
        {
          TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString);
          continue;
        }
        if (paramString != null) {
          continue;
        }
        GLES20.glDeleteTextures(1, paramContext, 0);
        TVKLogUtil.e("TVKUtils[TVKUtils.java]", "Failed at glGenTextures");
        return 0;
        GLES20.glBindTexture(3553, paramContext[0]);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLUtils.texImage2D(3553, 0, paramString, 0);
        paramString.recycle();
        GLES20.glBindTexture(3553, 0);
      }
      try
      {
        paramContext.close();
        paramContext = new int[1];
        GLES20.glGenTextures(1, paramContext, 0);
        if (paramContext[0] == 0)
        {
          TVKLogUtil.e("TVKUtils[TVKUtils.java]", "Failed at glGenTextures");
          return 0;
          localObject1 = localObject3;
          localObject2 = localObject4;
          paramContext = paramContext.getAssets().open(paramString);
        }
      }
      catch (IOException paramContext)
      {
        TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramContext);
      }
    }
    return paramContext[0];
  }
  
  public static int getsWidth(Context paramContext)
  {
    if (sWidth != 0) {
      return sWidth;
    }
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      sDensity = Math.round(localDisplayMetrics.density * 100.0F) / 100.0F;
      sWidth = Math.max(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels);
      return sWidth;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramContext);
      }
    }
  }
  
  public static boolean isAllowBySample(int paramInt)
  {
    boolean bool = true;
    if ((paramInt < 0) || (paramInt > 100)) {
      TVKLogUtil.w("TVKUtils[TVKUtils.java]", "[isAllowBySample] the sample is illegal, +sample = " + paramInt);
    }
    while (paramInt == 0) {
      return false;
    }
    if (100 == paramInt) {
      return true;
    }
    int i = (int)(Math.random() * 100.0D);
    TVKLogUtil.i("TVKUtils[TVKUtils.java]", "[isAllowBySample] randomNum = " + i);
    if (i < paramInt) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean isCryptoSchemeSupported(UUID paramUUID)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return MediaDrm.isCryptoSchemeSupported(paramUUID);
    }
    return false;
  }
  
  public static boolean isLocalHost(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new URL(paramString).getHost();
        if (!TextUtils.isEmpty(paramString))
        {
          boolean bool = paramString.contains("127.0.0.1");
          if (bool) {
            return true;
          }
        }
      }
      catch (Throwable paramString) {}
    }
    return false;
  }
  
  public static boolean isUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = paramString.split(":");
      return paramString[0].matches("^((https|http|ftp|rtsp|mms)?)");
    }
    catch (PatternSyntaxException paramString) {}
    return false;
  }
  
  public static boolean moveFile(File paramFile1, File paramFile2, String paramString)
  {
    if ((!paramFile1.isDirectory()) || (!paramFile2.isDirectory())) {}
    String[] arrayOfString;
    do
    {
      return false;
      arrayOfString = paramFile1.list();
    } while (arrayOfString == null);
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str = arrayOfString[i];
      if (!str.endsWith(paramString)) {}
      File localFile;
      do
      {
        i += 1;
        break;
        localFile = new File(paramFile1, str);
      } while ((!localFile.isFile()) || (localFile.renameTo(new File(paramFile2, str))));
      return false;
    }
    return true;
  }
  
  private static File newFile(File paramFile, ZipEntry paramZipEntry)
  {
    File localFile = new File(paramFile, paramZipEntry.getName());
    paramFile = paramFile.getCanonicalPath();
    if (!localFile.getCanonicalPath().startsWith(paramFile + File.separator)) {
      throw new IOException("Entry is outside of the target dir: " + paramZipEntry.getName());
    }
    return localFile;
  }
  
  public static double optDouble(String paramString, double paramDouble)
  {
    double d = paramDouble;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      d = Double.parseDouble(paramString);
      return d;
    }
    catch (NumberFormatException paramString)
    {
      TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString);
    }
    return paramDouble;
  }
  
  public static float optFloat(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        float f = Float.parseFloat(paramString);
        return f;
      }
      catch (NumberFormatException paramString)
      {
        TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString);
      }
    }
    return paramInt;
  }
  
  public static int optInt(String paramString, int paramInt)
  {
    int i = paramInt;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString);
    }
    return paramInt;
  }
  
  public static long optLong(String paramString, long paramLong)
  {
    long l = paramLong;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      TVKLogUtil.e("TVKUtils[TVKUtils.java]", paramString);
    }
    return paramLong;
  }
  
  public static String pathRemoveTailSeparator(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.endsWith(File.pathSeparator)) {
      return paramString;
    }
    return paramString.substring(0, paramString.length() - 1);
  }
  
  public static void sendMessage(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    if (paramHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      paramHandler.sendMessage(localMessage);
    }
  }
  
  public static void sendMessageDelay(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    if (paramHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      paramHandler.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  /* Error */
  public static void unzip(String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: sipush 1024
    //   9: newarray byte
    //   11: astore 6
    //   13: new 687	java/util/zip/ZipInputStream
    //   16: dup
    //   17: new 416	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 516	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: invokespecial 688	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_3
    //   29: aload_3
    //   30: invokevirtual 692	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +90 -> 125
    //   38: new 118	java/io/FileOutputStream
    //   41: dup
    //   42: aload_1
    //   43: aload_0
    //   44: invokestatic 694	com/tencent/qqlive/tvkplayer/tools/utils/TVKUtils:newFile	(Ljava/io/File;Ljava/util/zip/ZipEntry;)Ljava/io/File;
    //   47: invokespecial 121	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   50: astore_0
    //   51: aload_3
    //   52: aload 6
    //   54: invokevirtual 695	java/util/zip/ZipInputStream:read	([B)I
    //   57: istore_2
    //   58: iload_2
    //   59: ifle +54 -> 113
    //   62: aload_0
    //   63: aload 6
    //   65: iconst_0
    //   66: iload_2
    //   67: invokevirtual 214	java/io/FileOutputStream:write	([BII)V
    //   70: goto -19 -> 51
    //   73: astore 4
    //   75: aload_3
    //   76: astore_1
    //   77: aload 4
    //   79: astore_3
    //   80: aload_3
    //   81: athrow
    //   82: astore 4
    //   84: aload_1
    //   85: astore_3
    //   86: aload_0
    //   87: astore_1
    //   88: aload 4
    //   90: astore_0
    //   91: aload_1
    //   92: ifnull +7 -> 99
    //   95: aload_1
    //   96: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   99: aload_3
    //   100: ifnull +11 -> 111
    //   103: aload_3
    //   104: invokevirtual 698	java/util/zip/ZipInputStream:closeEntry	()V
    //   107: aload_3
    //   108: invokevirtual 699	java/util/zip/ZipInputStream:close	()V
    //   111: aload_0
    //   112: athrow
    //   113: aload_0
    //   114: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   117: aload_3
    //   118: invokevirtual 692	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   121: astore_0
    //   122: goto -88 -> 34
    //   125: iconst_0
    //   126: ifeq +11 -> 137
    //   129: new 701	java/lang/NullPointerException
    //   132: dup
    //   133: invokespecial 702	java/lang/NullPointerException:<init>	()V
    //   136: athrow
    //   137: aload_3
    //   138: ifnull +11 -> 149
    //   141: aload_3
    //   142: invokevirtual 698	java/util/zip/ZipInputStream:closeEntry	()V
    //   145: aload_3
    //   146: invokevirtual 699	java/util/zip/ZipInputStream:close	()V
    //   149: return
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   155: return
    //   156: astore_1
    //   157: aload_1
    //   158: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   161: goto -50 -> 111
    //   164: astore_0
    //   165: aconst_null
    //   166: astore_3
    //   167: aload 4
    //   169: astore_1
    //   170: goto -79 -> 91
    //   173: astore_0
    //   174: aload 4
    //   176: astore_1
    //   177: goto -86 -> 91
    //   180: astore 4
    //   182: aload_0
    //   183: astore_1
    //   184: aload 4
    //   186: astore_0
    //   187: goto -96 -> 91
    //   190: astore_3
    //   191: aconst_null
    //   192: astore_0
    //   193: aload 5
    //   195: astore_1
    //   196: goto -116 -> 80
    //   199: astore 4
    //   201: aconst_null
    //   202: astore_0
    //   203: aload_3
    //   204: astore_1
    //   205: aload 4
    //   207: astore_3
    //   208: goto -128 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramString	String
    //   0	211	1	paramFile	File
    //   57	10	2	i	int
    //   28	139	3	localObject1	Object
    //   190	14	3	localException1	Exception
    //   207	1	3	localException2	Exception
    //   1	1	4	localObject2	Object
    //   73	5	4	localException3	Exception
    //   82	93	4	localObject3	Object
    //   180	5	4	localObject4	Object
    //   199	7	4	localException4	Exception
    //   4	190	5	localObject5	Object
    //   11	53	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   51	58	73	java/lang/Exception
    //   62	70	73	java/lang/Exception
    //   113	117	73	java/lang/Exception
    //   80	82	82	finally
    //   129	137	150	java/io/IOException
    //   141	149	150	java/io/IOException
    //   95	99	156	java/io/IOException
    //   103	111	156	java/io/IOException
    //   13	29	164	finally
    //   29	34	173	finally
    //   38	51	173	finally
    //   117	122	173	finally
    //   51	58	180	finally
    //   62	70	180	finally
    //   113	117	180	finally
    //   13	29	190	java/lang/Exception
    //   29	34	199	java/lang/Exception
    //   38	51	199	java/lang/Exception
    //   117	122	199	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils
 * JD-Core Version:    0.7.0.1
 */