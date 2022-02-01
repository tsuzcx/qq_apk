package com.tencent.qg.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class Utils
{
  /* Error */
  public static void copyDataFile(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 19	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: invokevirtual 25	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   7: aload_2
    //   8: invokevirtual 31	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   11: astore 9
    //   13: new 33	java/io/File
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 10
    //   23: aload 10
    //   25: invokevirtual 40	java/io/File:isFile	()Z
    //   28: ifeq +12 -> 40
    //   31: aload 10
    //   33: invokevirtual 43	java/io/File:exists	()Z
    //   36: ifeq +4 -> 40
    //   39: return
    //   40: aload 10
    //   42: invokevirtual 46	java/io/File:mkdirs	()Z
    //   45: pop
    //   46: aconst_null
    //   47: astore 5
    //   49: iconst_0
    //   50: istore_3
    //   51: iload_3
    //   52: aload 9
    //   54: arraylength
    //   55: if_icmpge +487 -> 542
    //   58: aload 9
    //   60: iload_3
    //   61: aaload
    //   62: astore 6
    //   64: aload_2
    //   65: invokevirtual 52	java/lang/String:length	()I
    //   68: ifeq +56 -> 124
    //   71: aload_0
    //   72: invokevirtual 53	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   75: astore 7
    //   77: new 55	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   84: astore 8
    //   86: aload 8
    //   88: aload_2
    //   89: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 8
    //   95: ldc 62
    //   97: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 8
    //   103: aload 6
    //   105: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload 7
    //   111: aload 8
    //   113: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokevirtual 70	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   119: astore 8
    //   121: goto +14 -> 135
    //   124: aload_0
    //   125: invokevirtual 53	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   128: aload 6
    //   130: invokevirtual 70	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   133: astore 8
    //   135: aload 5
    //   137: astore 7
    //   139: new 33	java/io/File
    //   142: dup
    //   143: aload 10
    //   145: aload 6
    //   147: invokespecial 73	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   150: astore 6
    //   152: aload 5
    //   154: astore 7
    //   156: aload 6
    //   158: invokevirtual 43	java/io/File:exists	()Z
    //   161: ifeq +13 -> 174
    //   164: aload 5
    //   166: astore 7
    //   168: aload 6
    //   170: invokevirtual 76	java/io/File:delete	()Z
    //   173: pop
    //   174: aload 5
    //   176: astore 7
    //   178: new 78	java/io/FileOutputStream
    //   181: dup
    //   182: aload 6
    //   184: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   187: astore 6
    //   189: sipush 1024
    //   192: newarray byte
    //   194: astore 5
    //   196: aload 8
    //   198: aload 5
    //   200: invokevirtual 87	java/io/InputStream:read	([B)I
    //   203: istore 4
    //   205: iload 4
    //   207: ifle +16 -> 223
    //   210: aload 6
    //   212: aload 5
    //   214: iconst_0
    //   215: iload 4
    //   217: invokevirtual 93	java/io/OutputStream:write	([BII)V
    //   220: goto -24 -> 196
    //   223: aload 8
    //   225: ifnull +11 -> 236
    //   228: aload 8
    //   230: invokevirtual 96	java/io/InputStream:close	()V
    //   233: goto +3 -> 236
    //   236: aload 6
    //   238: invokevirtual 99	java/io/OutputStream:flush	()V
    //   241: aload 6
    //   243: invokevirtual 100	java/io/OutputStream:close	()V
    //   246: goto +8 -> 254
    //   249: aload 5
    //   251: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   254: goto +277 -> 531
    //   257: astore_0
    //   258: aload 6
    //   260: astore 7
    //   262: goto +82 -> 344
    //   265: astore 7
    //   267: aload 6
    //   269: astore 5
    //   271: aload 7
    //   273: astore 6
    //   275: goto +9 -> 284
    //   278: astore_0
    //   279: goto +65 -> 344
    //   282: astore 6
    //   284: aload 5
    //   286: astore 7
    //   288: aload 6
    //   290: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   293: aload 8
    //   295: ifnull +11 -> 306
    //   298: aload 8
    //   300: invokevirtual 96	java/io/InputStream:close	()V
    //   303: goto +3 -> 306
    //   306: aload 5
    //   308: astore 6
    //   310: aload 5
    //   312: ifnull +219 -> 531
    //   315: aload 5
    //   317: invokevirtual 99	java/io/OutputStream:flush	()V
    //   320: aload 5
    //   322: invokevirtual 100	java/io/OutputStream:close	()V
    //   325: aload 5
    //   327: astore 6
    //   329: goto +202 -> 531
    //   332: aload 6
    //   334: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   337: aload 5
    //   339: astore 6
    //   341: goto +190 -> 531
    //   344: aload 8
    //   346: ifnull +11 -> 357
    //   349: aload 8
    //   351: invokevirtual 96	java/io/InputStream:close	()V
    //   354: goto +3 -> 357
    //   357: aload 7
    //   359: ifnull +20 -> 379
    //   362: aload 7
    //   364: invokevirtual 99	java/io/OutputStream:flush	()V
    //   367: aload 7
    //   369: invokevirtual 100	java/io/OutputStream:close	()V
    //   372: goto +7 -> 379
    //   375: aload_1
    //   376: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   379: aload_0
    //   380: athrow
    //   381: astore 7
    //   383: aload 7
    //   385: invokevirtual 103	java/io/IOException:printStackTrace	()V
    //   388: aload_2
    //   389: invokevirtual 52	java/lang/String:length	()I
    //   392: ifne +53 -> 445
    //   395: new 55	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   402: astore 7
    //   404: aload 7
    //   406: aload_1
    //   407: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload 7
    //   413: aload 6
    //   415: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload 7
    //   421: ldc 62
    //   423: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload_0
    //   428: aload 7
    //   430: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: aload 6
    //   435: invokestatic 105	com/tencent/qg/sdk/Utils:copyDataFile	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   438: aload 5
    //   440: astore 6
    //   442: goto +89 -> 531
    //   445: new 55	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   452: astore 7
    //   454: aload 7
    //   456: aload_1
    //   457: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload 7
    //   463: aload 6
    //   465: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 7
    //   471: ldc 62
    //   473: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 7
    //   479: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: astore 7
    //   484: new 55	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   491: astore 8
    //   493: aload 8
    //   495: aload_2
    //   496: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload 8
    //   502: ldc 62
    //   504: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload 8
    //   510: aload 6
    //   512: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload_0
    //   517: aload 7
    //   519: aload 8
    //   521: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokestatic 105	com/tencent/qg/sdk/Utils:copyDataFile	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   527: aload 5
    //   529: astore 6
    //   531: iload_3
    //   532: iconst_1
    //   533: iadd
    //   534: istore_3
    //   535: aload 6
    //   537: astore 5
    //   539: goto -488 -> 51
    //   542: return
    //   543: astore_0
    //   544: return
    //   545: astore 5
    //   547: goto -298 -> 249
    //   550: astore 6
    //   552: goto -220 -> 332
    //   555: astore_1
    //   556: goto -181 -> 375
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	559	0	paramContext	Context
    //   0	559	1	paramString1	String
    //   0	559	2	paramString2	String
    //   50	485	3	i	int
    //   203	13	4	j	int
    //   47	491	5	localObject1	Object
    //   545	1	5	localIOException1	java.io.IOException
    //   62	212	6	localObject2	Object
    //   282	7	6	localIOException2	java.io.IOException
    //   308	228	6	localObject3	Object
    //   550	1	6	localIOException3	java.io.IOException
    //   75	186	7	localObject4	Object
    //   265	7	7	localIOException4	java.io.IOException
    //   286	82	7	localObject5	Object
    //   381	3	7	localIOException5	java.io.IOException
    //   402	116	7	localObject6	Object
    //   84	436	8	localObject7	Object
    //   11	48	9	arrayOfString	String[]
    //   21	123	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   189	196	257	finally
    //   196	205	257	finally
    //   210	220	257	finally
    //   189	196	265	java/io/IOException
    //   196	205	265	java/io/IOException
    //   210	220	265	java/io/IOException
    //   139	152	278	finally
    //   156	164	278	finally
    //   168	174	278	finally
    //   178	189	278	finally
    //   288	293	278	finally
    //   139	152	282	java/io/IOException
    //   156	164	282	java/io/IOException
    //   168	174	282	java/io/IOException
    //   178	189	282	java/io/IOException
    //   64	121	381	java/io/IOException
    //   124	135	381	java/io/IOException
    //   0	13	543	java/io/IOException
    //   228	233	545	java/io/IOException
    //   236	246	545	java/io/IOException
    //   298	303	550	java/io/IOException
    //   315	325	550	java/io/IOException
    //   349	354	555	java/io/IOException
    //   362	372	555	java/io/IOException
  }
  
  public static void copyDataFiles(Context paramContext, String paramString1, String paramString2)
  {
    copyDataFile(paramContext, paramString1, paramString2);
  }
  
  public static Bitmap readPixesToBitmap(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = ByteBuffer.allocate(paramInt1 * paramInt2 * 4);
    GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, (Buffer)localObject);
    GLES20.glFinish();
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    ((ByteBuffer)localObject).rewind();
    localBitmap.copyPixelsFromBuffer((Buffer)localObject);
    if (paramBoolean)
    {
      localObject = new Matrix();
      ((Matrix)localObject).postScale(1.0F, -1.0F);
      localObject = Bitmap.createBitmap(localBitmap, 0, 0, paramInt1, paramInt2, (Matrix)localObject, true);
      localBitmap.recycle();
      return localObject;
    }
    return localBitmap;
  }
  
  public static Bitmap readTextureToBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    return readTextureToBitmap(paramInt1, paramInt2, paramInt3, false);
  }
  
  public static Bitmap readTextureToBitmap(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject2 = new int[1];
    int[] arrayOfInt = new int[1];
    GLES20.glGetIntegerv(36006, arrayOfInt, 0);
    GLES20.glGenFramebuffers(1, (int[])localObject2, 0);
    GLES20.glBindFramebuffer(36160, localObject2[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    Object localObject1 = ByteBuffer.allocate(paramInt2 * paramInt3 * 4);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, (Buffer)localObject1);
    GLES20.glFinish();
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    GLES20.glDeleteFramebuffers(1, (int[])localObject2, 0);
    localObject2 = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    ((ByteBuffer)localObject1).rewind();
    ((Bitmap)localObject2).copyPixelsFromBuffer((Buffer)localObject1);
    if (paramBoolean)
    {
      localObject1 = new Matrix();
      ((Matrix)localObject1).postScale(1.0F, -1.0F);
      localObject1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, paramInt2, paramInt3, (Matrix)localObject1, true);
      ((Bitmap)localObject2).recycle();
      return localObject1;
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.Utils
 * JD-Core Version:    0.7.0.1
 */