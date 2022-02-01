package com.tencent.xaction.api.util;

import android.graphics.BitmapFactory.Options;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/BitmapUtil$Companion;", "", "()V", "calculateInSampleSize", "", "options", "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "loadBitmap", "Landroid/graphics/Bitmap;", "resources", "Landroid/content/res/Resources;", "path", "", "isAssets", "", "wh", "", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class BitmapUtil$Companion
{
  @JvmStatic
  public final int a(@NotNull BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramOptions, "options");
    int j = 1;
    int i = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != ScreenUnit.a.a())
        {
          if (paramInt2 == ScreenUnit.a.a()) {
            return 1;
          }
          j = paramOptions.outHeight;
          int k = paramOptions.outWidth;
          for (;;)
          {
            m = i;
            if (j <= paramInt2) {
              break;
            }
            m = i;
            if (k <= paramInt1) {
              break;
            }
            int n = MathKt.roundToInt(j / paramInt2);
            m = MathKt.roundToInt(k / paramInt1);
            if (n <= m) {
              n = m;
            }
            m = i;
            if (n < 2) {
              break;
            }
            k >>= 1;
            j >>= 1;
            i <<= 1;
          }
        }
      }
    }
    return m;
  }
  
  /* Error */
  @JvmStatic
  @org.jetbrains.annotations.Nullable
  public final android.graphics.Bitmap a(@org.jetbrains.annotations.Nullable android.content.res.Resources paramResources, @NotNull java.lang.String paramString, @NotNull BitmapFactory.Options paramOptions, boolean paramBoolean, @org.jetbrains.annotations.Nullable int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 84
    //   3: invokestatic 48	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_3
    //   7: ldc 42
    //   9: invokestatic 48	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_3
    //   13: sipush 320
    //   16: putfield 87	android/graphics/BitmapFactory$Options:inDensity	I
    //   19: aload_1
    //   20: ifnull +14 -> 34
    //   23: aload_3
    //   24: aload_1
    //   25: invokevirtual 93	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   28: getfield 98	android/util/DisplayMetrics:densityDpi	I
    //   31: putfield 101	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   34: iload 4
    //   36: ifeq +31 -> 67
    //   39: aload_1
    //   40: ifnonnull +5 -> 45
    //   43: aconst_null
    //   44: areturn
    //   45: new 103	java/io/BufferedInputStream
    //   48: dup
    //   49: aload_1
    //   50: invokevirtual 107	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   53: aload_2
    //   54: invokevirtual 113	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   57: invokespecial 116	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: checkcast 118	java/io/InputStream
    //   63: astore_1
    //   64: goto +41 -> 105
    //   67: new 120	java/io/File
    //   70: dup
    //   71: aload_2
    //   72: invokespecial 123	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: invokevirtual 127	java/io/File:exists	()Z
    //   78: ifne +5 -> 83
    //   81: aconst_null
    //   82: areturn
    //   83: new 103	java/io/BufferedInputStream
    //   86: dup
    //   87: new 129	java/io/FileInputStream
    //   90: dup
    //   91: aload_2
    //   92: invokespecial 130	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   95: checkcast 118	java/io/InputStream
    //   98: invokespecial 116	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   101: checkcast 118	java/io/InputStream
    //   104: astore_1
    //   105: aconst_null
    //   106: checkcast 132	android/graphics/Bitmap
    //   109: astore 6
    //   111: aload 5
    //   113: ifnull +39 -> 152
    //   116: aload_3
    //   117: iconst_1
    //   118: putfield 136	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   121: aload_2
    //   122: aload_3
    //   123: invokestatic 142	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   126: pop
    //   127: aload_3
    //   128: iconst_0
    //   129: putfield 136	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   132: aload_3
    //   133: aload_0
    //   134: checkcast 2	com/tencent/xaction/api/util/BitmapUtil$Companion
    //   137: aload_3
    //   138: aload 5
    //   140: iconst_0
    //   141: iaload
    //   142: aload 5
    //   144: iconst_1
    //   145: iaload
    //   146: invokevirtual 144	com/tencent/xaction/api/util/BitmapUtil$Companion:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   149: putfield 147	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   152: aload_1
    //   153: aconst_null
    //   154: aload_3
    //   155: invokestatic 151	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   158: astore_3
    //   159: aload_3
    //   160: astore_2
    //   161: aload_1
    //   162: invokevirtual 154	java/io/InputStream:close	()V
    //   165: aload_3
    //   166: areturn
    //   167: astore_1
    //   168: aload_1
    //   169: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   172: aload_2
    //   173: areturn
    //   174: astore_2
    //   175: goto +49 -> 224
    //   178: astore_2
    //   179: ldc 158
    //   181: iconst_1
    //   182: ldc 160
    //   184: aload_2
    //   185: checkcast 162	java/lang/Throwable
    //   188: invokestatic 167	com/tencent/xaction/log/QLog:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   191: aload 6
    //   193: astore_2
    //   194: aload_1
    //   195: invokevirtual 154	java/io/InputStream:close	()V
    //   198: aload 6
    //   200: areturn
    //   201: astore_2
    //   202: ldc 158
    //   204: iconst_1
    //   205: ldc 169
    //   207: aload_2
    //   208: checkcast 162	java/lang/Throwable
    //   211: invokestatic 167	com/tencent/xaction/log/QLog:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   214: aload 6
    //   216: astore_2
    //   217: aload_1
    //   218: invokevirtual 154	java/io/InputStream:close	()V
    //   221: aload 6
    //   223: areturn
    //   224: aload_1
    //   225: invokevirtual 154	java/io/InputStream:close	()V
    //   228: goto +8 -> 236
    //   231: astore_1
    //   232: aload_1
    //   233: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   236: aload_2
    //   237: athrow
    //   238: astore_1
    //   239: ldc 158
    //   241: iconst_1
    //   242: ldc 171
    //   244: aload_1
    //   245: checkcast 162	java/lang/Throwable
    //   248: invokestatic 167	com/tencent/xaction/log/QLog:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   251: aconst_null
    //   252: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	Companion
    //   0	253	1	paramResources	android.content.res.Resources
    //   0	253	2	paramString	java.lang.String
    //   0	253	3	paramOptions	BitmapFactory.Options
    //   0	253	4	paramBoolean	boolean
    //   0	253	5	paramArrayOfInt	int[]
    //   109	113	6	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   161	165	167	java/io/IOException
    //   194	198	167	java/io/IOException
    //   217	221	167	java/io/IOException
    //   116	152	174	finally
    //   152	159	174	finally
    //   179	191	174	finally
    //   202	214	174	finally
    //   116	152	178	java/lang/OutOfMemoryError
    //   152	159	178	java/lang/OutOfMemoryError
    //   116	152	201	java/lang/Exception
    //   152	159	201	java/lang/Exception
    //   224	228	231	java/io/IOException
    //   45	64	238	java/lang/Exception
    //   67	81	238	java/lang/Exception
    //   83	105	238	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.util.BitmapUtil.Companion
 * JD-Core Version:    0.7.0.1
 */