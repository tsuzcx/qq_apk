package com.tencent.ttpic.filament;

import com.google.android.filament.Engine;

public class IblLoader
{
  public static void destroyIbl(Engine paramEngine, IblLoader.Ibl paramIbl)
  {
    paramEngine.destroySkybox(paramIbl.skybox);
    paramEngine.destroyTexture(paramIbl.skyboxTexture);
    paramEngine.destroyIndirectLight(paramIbl.indirectLight);
    paramEngine.destroyTexture(paramIbl.indirectLightTexture);
  }
  
  /* Error */
  private static android.util.Pair<java.lang.Integer, java.lang.Integer> peekSize(android.content.res.AssetManager paramAssetManager, java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 52	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   9: astore_0
    //   10: new 54	android/graphics/BitmapFactory$Options
    //   13: dup
    //   14: invokespecial 55	android/graphics/BitmapFactory$Options:<init>	()V
    //   17: astore_1
    //   18: aload_1
    //   19: iconst_1
    //   20: putfield 59	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   23: aload_0
    //   24: aconst_null
    //   25: aload_1
    //   26: invokestatic 65	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   29: pop
    //   30: new 67	android/util/Pair
    //   33: dup
    //   34: aload_1
    //   35: getfield 71	android/graphics/BitmapFactory$Options:outWidth	I
    //   38: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: aload_1
    //   42: getfield 80	android/graphics/BitmapFactory$Options:outHeight	I
    //   45: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   48: invokespecial 83	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   51: astore_1
    //   52: aload_0
    //   53: ifnull +14 -> 67
    //   56: aload_0
    //   57: invokevirtual 88	java/io/InputStream:close	()V
    //   60: aload_1
    //   61: areturn
    //   62: astore_0
    //   63: aload_0
    //   64: invokestatic 94	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   67: aload_1
    //   68: areturn
    //   69: astore_1
    //   70: goto +54 -> 124
    //   73: astore_1
    //   74: goto +12 -> 86
    //   77: astore_1
    //   78: aload_2
    //   79: astore_0
    //   80: goto +44 -> 124
    //   83: astore_1
    //   84: aload_3
    //   85: astore_0
    //   86: aload_0
    //   87: astore_2
    //   88: aload_1
    //   89: invokestatic 94	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   92: aload_0
    //   93: ifnull +15 -> 108
    //   96: aload_0
    //   97: invokevirtual 88	java/io/InputStream:close	()V
    //   100: goto +8 -> 108
    //   103: astore_0
    //   104: aload_0
    //   105: invokestatic 94	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   108: new 67	android/util/Pair
    //   111: dup
    //   112: iconst_0
    //   113: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   116: iconst_0
    //   117: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: invokespecial 83	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   123: areturn
    //   124: aload_0
    //   125: ifnull +15 -> 140
    //   128: aload_0
    //   129: invokevirtual 88	java/io/InputStream:close	()V
    //   132: goto +8 -> 140
    //   135: astore_0
    //   136: aload_0
    //   137: invokestatic 94	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramAssetManager	android.content.res.AssetManager
    //   0	142	1	paramString	java.lang.String
    //   3	85	2	localAssetManager	android.content.res.AssetManager
    //   1	84	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   56	60	62	java/io/IOException
    //   10	52	69	finally
    //   10	52	73	java/io/IOException
    //   4	10	77	finally
    //   88	92	77	finally
    //   4	10	83	java/io/IOException
    //   96	100	103	java/io/IOException
    //   128	132	135	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filament.IblLoader
 * JD-Core Version:    0.7.0.1
 */