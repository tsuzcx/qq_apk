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
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokevirtual 19	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   7: invokevirtual 25	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   10: aload_2
    //   11: invokevirtual 31	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   14: astore 10
    //   16: new 33	java/io/File
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 11
    //   26: aload 11
    //   28: invokevirtual 40	java/io/File:isFile	()Z
    //   31: ifeq +12 -> 43
    //   34: aload 11
    //   36: invokevirtual 43	java/io/File:exists	()Z
    //   39: ifeq +4 -> 43
    //   42: return
    //   43: aload 11
    //   45: invokevirtual 46	java/io/File:mkdirs	()Z
    //   48: ifne +3 -> 51
    //   51: iconst_0
    //   52: istore_3
    //   53: iload_3
    //   54: aload 10
    //   56: arraylength
    //   57: if_icmpge -15 -> 42
    //   60: aload 10
    //   62: iload_3
    //   63: aaload
    //   64: astore 6
    //   66: aload_2
    //   67: invokevirtual 52	java/lang/String:length	()I
    //   70: ifeq +179 -> 249
    //   73: aload_0
    //   74: invokevirtual 53	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   77: new 55	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   84: aload_2
    //   85: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 62
    //   90: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload 6
    //   95: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokevirtual 70	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   104: astore 8
    //   106: new 33	java/io/File
    //   109: dup
    //   110: aload 11
    //   112: aload 6
    //   114: invokespecial 73	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   117: astore 6
    //   119: aload 6
    //   121: invokevirtual 43	java/io/File:exists	()Z
    //   124: ifeq +9 -> 133
    //   127: aload 6
    //   129: invokevirtual 76	java/io/File:delete	()Z
    //   132: pop
    //   133: new 78	java/io/FileOutputStream
    //   136: dup
    //   137: aload 6
    //   139: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   142: astore 7
    //   144: aload 7
    //   146: astore 6
    //   148: sipush 1024
    //   151: newarray byte
    //   153: astore 5
    //   155: aload 7
    //   157: astore 6
    //   159: aload 8
    //   161: aload 5
    //   163: invokevirtual 87	java/io/InputStream:read	([B)I
    //   166: istore 4
    //   168: iload 4
    //   170: ifle +199 -> 369
    //   173: aload 7
    //   175: astore 6
    //   177: aload 7
    //   179: aload 5
    //   181: iconst_0
    //   182: iload 4
    //   184: invokevirtual 93	java/io/OutputStream:write	([BII)V
    //   187: goto -32 -> 155
    //   190: astore 9
    //   192: aload 7
    //   194: astore 5
    //   196: aload 5
    //   198: astore 6
    //   200: aload 9
    //   202: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   205: aload 8
    //   207: ifnull +8 -> 215
    //   210: aload 8
    //   212: invokevirtual 99	java/io/InputStream:close	()V
    //   215: aload 5
    //   217: astore 6
    //   219: aload 5
    //   221: ifnull +17 -> 238
    //   224: aload 5
    //   226: invokevirtual 102	java/io/OutputStream:flush	()V
    //   229: aload 5
    //   231: invokevirtual 103	java/io/OutputStream:close	()V
    //   234: aload 5
    //   236: astore 6
    //   238: iload_3
    //   239: iconst_1
    //   240: iadd
    //   241: istore_3
    //   242: aload 6
    //   244: astore 5
    //   246: goto -193 -> 53
    //   249: aload_0
    //   250: invokevirtual 53	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   253: aload 6
    //   255: invokevirtual 70	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   258: astore 8
    //   260: goto -154 -> 106
    //   263: astore 7
    //   265: aload 7
    //   267: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   270: aload_2
    //   271: invokevirtual 52	java/lang/String:length	()I
    //   274: ifne +40 -> 314
    //   277: aload_0
    //   278: new 55	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   285: aload_1
    //   286: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload 6
    //   291: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc 62
    //   296: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: aload 6
    //   304: invokestatic 105	com/tencent/qg/sdk/Utils:copyDataFile	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload 5
    //   309: astore 6
    //   311: goto -73 -> 238
    //   314: aload_0
    //   315: new 55	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   322: aload_1
    //   323: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload 6
    //   328: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: ldc 62
    //   333: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: new 55	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   346: aload_2
    //   347: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc 62
    //   352: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload 6
    //   357: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 105	com/tencent/qg/sdk/Utils:copyDataFile	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   366: goto -59 -> 307
    //   369: aload 8
    //   371: ifnull +8 -> 379
    //   374: aload 8
    //   376: invokevirtual 99	java/io/InputStream:close	()V
    //   379: aload 7
    //   381: astore 6
    //   383: aload 7
    //   385: ifnull -147 -> 238
    //   388: aload 7
    //   390: invokevirtual 102	java/io/OutputStream:flush	()V
    //   393: aload 7
    //   395: invokevirtual 103	java/io/OutputStream:close	()V
    //   398: aload 7
    //   400: astore 6
    //   402: goto -164 -> 238
    //   405: astore 5
    //   407: aload 5
    //   409: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   412: aload 7
    //   414: astore 6
    //   416: goto -178 -> 238
    //   419: astore 6
    //   421: aload 6
    //   423: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   426: aload 5
    //   428: astore 6
    //   430: goto -192 -> 238
    //   433: astore_0
    //   434: aload 6
    //   436: astore 5
    //   438: aload 8
    //   440: ifnull +8 -> 448
    //   443: aload 8
    //   445: invokevirtual 99	java/io/InputStream:close	()V
    //   448: aload 5
    //   450: ifnull +13 -> 463
    //   453: aload 5
    //   455: invokevirtual 102	java/io/OutputStream:flush	()V
    //   458: aload 5
    //   460: invokevirtual 103	java/io/OutputStream:close	()V
    //   463: aload_0
    //   464: athrow
    //   465: astore_1
    //   466: aload_1
    //   467: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   470: goto -7 -> 463
    //   473: astore_0
    //   474: goto -36 -> 438
    //   477: astore 9
    //   479: goto -283 -> 196
    //   482: astore_0
    //   483: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	paramContext	Context
    //   0	484	1	paramString1	String
    //   0	484	2	paramString2	String
    //   52	190	3	i	int
    //   166	17	4	j	int
    //   1	307	5	localObject1	Object
    //   405	22	5	localIOException1	java.io.IOException
    //   436	23	5	localObject2	Object
    //   64	351	6	localObject3	Object
    //   419	3	6	localIOException2	java.io.IOException
    //   428	7	6	localIOException3	java.io.IOException
    //   142	51	7	localFileOutputStream	java.io.FileOutputStream
    //   263	150	7	localIOException4	java.io.IOException
    //   104	340	8	localInputStream	java.io.InputStream
    //   190	11	9	localIOException5	java.io.IOException
    //   477	1	9	localIOException6	java.io.IOException
    //   14	47	10	arrayOfString	String[]
    //   24	87	11	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   148	155	190	java/io/IOException
    //   159	168	190	java/io/IOException
    //   177	187	190	java/io/IOException
    //   66	106	263	java/io/IOException
    //   249	260	263	java/io/IOException
    //   374	379	405	java/io/IOException
    //   388	398	405	java/io/IOException
    //   210	215	419	java/io/IOException
    //   224	234	419	java/io/IOException
    //   148	155	433	finally
    //   159	168	433	finally
    //   177	187	433	finally
    //   200	205	433	finally
    //   443	448	465	java/io/IOException
    //   453	463	465	java/io/IOException
    //   106	133	473	finally
    //   133	144	473	finally
    //   106	133	477	java/io/IOException
    //   133	144	477	java/io/IOException
    //   3	16	482	java/io/IOException
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
    localObject = localBitmap;
    if (paramBoolean)
    {
      localObject = new Matrix();
      ((Matrix)localObject).postScale(1.0F, -1.0F);
      localObject = Bitmap.createBitmap(localBitmap, 0, 0, paramInt1, paramInt2, (Matrix)localObject, true);
      localBitmap.recycle();
    }
    return localObject;
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
    localObject1 = localObject2;
    if (paramBoolean)
    {
      localObject1 = new Matrix();
      ((Matrix)localObject1).postScale(1.0F, -1.0F);
      localObject1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, paramInt2, paramInt3, (Matrix)localObject1, true);
      ((Bitmap)localObject2).recycle();
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qg.sdk.Utils
 * JD-Core Version:    0.7.0.1
 */