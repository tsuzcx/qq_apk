package com.tencent.tkd.topicsdk.imagecompress.engine;

import android.graphics.Bitmap;
import com.tencent.tkd.topicsdk.imagecompress.InputStreamProvider;
import com.tencent.tkd.topicsdk.imagecompress.encodedecode.StandardGifDecoder;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/imagecompress/engine/GifEngine;", "Lcom/tencent/tkd/topicsdk/imagecompress/engine/IEngine;", "srcImg", "Lcom/tencent/tkd/topicsdk/imagecompress/InputStreamProvider;", "tagImg", "Ljava/io/File;", "(Lcom/tencent/tkd/topicsdk/imagecompress/InputStreamProvider;Ljava/io/File;)V", "compress", "compressGif", "", "shrinkFrames", "", "Lcom/tencent/tkd/topicsdk/imagecompress/engine/GifEngine$Frame;", "gifDecoder", "Lcom/tencent/tkd/topicsdk/imagecompress/encodedecode/StandardGifDecoder;", "sampleCount", "", "scaleSize", "", "Frame", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class GifEngine
  implements IEngine
{
  private final InputStreamProvider a;
  private final File b;
  
  public GifEngine(@NotNull InputStreamProvider paramInputStreamProvider, @NotNull File paramFile)
  {
    this.a = paramInputStreamProvider;
    this.b = paramFile;
  }
  
  private final List<GifEngine.Frame> a(StandardGifDecoder paramStandardGifDecoder, int paramInt, float paramFloat)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 1;
    }
    int j = paramStandardGifDecoder.b();
    Object localObject2 = (Iterable)RangesKt.until(0, j);
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((Number)localObject3).intValue() % i == 0) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (Iterable)localObject1;
    Object localObject3 = (Collection)new ArrayList();
    Object localObject4 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      paramInt = ((Number)((Iterator)localObject4).next()).intValue();
      paramStandardGifDecoder.a();
      localObject2 = null;
      localObject1 = (Bitmap)null;
      if (paramInt % i == 0) {
        localObject1 = paramStandardGifDecoder.c();
      }
      if (localObject1 != null) {
        localObject2 = new Pair(localObject1, Integer.valueOf(paramInt));
      }
      if (localObject2 != null) {
        ((Collection)localObject3).add(localObject2);
      }
    }
    localObject1 = (List)localObject3;
    localObject3 = (Iterable)RangesKt.until(0, j);
    localObject2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(Integer.valueOf(paramStandardGifDecoder.a(((IntIterator)localObject3).nextInt())));
    }
    paramStandardGifDecoder = (List)localObject2;
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (Pair)((Iterator)localObject2).next();
      localObject3 = GifEngineKt.a((Bitmap)((Pair)localObject4).getFirst(), paramFloat);
      Object localObject5 = (Iterable)RangesKt.until(((Number)((Pair)localObject4).getSecond()).intValue(), Math.min(j, ((Number)((Pair)localObject4).getSecond()).intValue() + i));
      localObject4 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      paramInt = 0;
      while (((Iterator)localObject5).hasNext())
      {
        paramInt += ((Number)paramStandardGifDecoder.get(((IntIterator)localObject5).nextInt())).intValue();
        ((Collection)localObject4).add(Unit.INSTANCE);
      }
      localObject4 = (List)localObject4;
      ((Collection)localObject1).add(new GifEngine.Frame((Bitmap)localObject3, paramInt));
    }
    return (List)localObject1;
  }
  
  /* Error */
  private final byte[] b()
  {
    // Byte code:
    //   0: new 175	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 52	com/tencent/tkd/topicsdk/imagecompress/engine/GifEngine:a	Lcom/tencent/tkd/topicsdk/imagecompress/InputStreamProvider;
    //   8: invokeinterface 181 1 0
    //   13: invokespecial 184	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokestatic 190	kotlin/io/FilesKt:readBytes	(Ljava/io/File;)[B
    //   19: astore_1
    //   20: new 59	com/tencent/tkd/topicsdk/imagecompress/encodedecode/StandardGifDecoder
    //   23: dup
    //   24: new 192	com/tencent/tkd/topicsdk/imagecompress/encodedecode/GifBitmapProvider
    //   27: dup
    //   28: new 194	com/tencent/tkd/topicsdk/imagecompress/encodedecode/BitmapPoolAdapter
    //   31: dup
    //   32: invokespecial 195	com/tencent/tkd/topicsdk/imagecompress/encodedecode/BitmapPoolAdapter:<init>	()V
    //   35: checkcast 197	com/tencent/tkd/topicsdk/imagecompress/encodedecode/BitmapPool
    //   38: invokespecial 200	com/tencent/tkd/topicsdk/imagecompress/encodedecode/GifBitmapProvider:<init>	(Lcom/tencent/tkd/topicsdk/imagecompress/encodedecode/BitmapPool;)V
    //   41: checkcast 202	com/tencent/tkd/topicsdk/imagecompress/encodedecode/GifDecoder$BitmapProvider
    //   44: invokespecial 205	com/tencent/tkd/topicsdk/imagecompress/encodedecode/StandardGifDecoder:<init>	(Lcom/tencent/tkd/topicsdk/imagecompress/encodedecode/GifDecoder$BitmapProvider;)V
    //   47: astore_2
    //   48: new 207	com/tencent/tkd/topicsdk/imagecompress/encodedecode/GifHeaderParser
    //   51: dup
    //   52: invokespecial 208	com/tencent/tkd/topicsdk/imagecompress/encodedecode/GifHeaderParser:<init>	()V
    //   55: astore_3
    //   56: aload_3
    //   57: aload_1
    //   58: invokevirtual 211	com/tencent/tkd/topicsdk/imagecompress/encodedecode/GifHeaderParser:a	([B)Lcom/tencent/tkd/topicsdk/imagecompress/encodedecode/GifHeaderParser;
    //   61: pop
    //   62: aload_3
    //   63: invokevirtual 214	com/tencent/tkd/topicsdk/imagecompress/encodedecode/GifHeaderParser:a	()Lcom/tencent/tkd/topicsdk/imagecompress/encodedecode/GifHeader;
    //   66: astore_3
    //   67: aload_3
    //   68: ldc 216
    //   70: invokestatic 219	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   73: aload_2
    //   74: aload_3
    //   75: aload_1
    //   76: invokevirtual 222	com/tencent/tkd/topicsdk/imagecompress/encodedecode/StandardGifDecoder:a	(Lcom/tencent/tkd/topicsdk/imagecompress/encodedecode/GifHeader;[B)V
    //   79: aload_0
    //   80: aload_2
    //   81: iconst_1
    //   82: ldc 223
    //   84: invokespecial 225	com/tencent/tkd/topicsdk/imagecompress/engine/GifEngine:a	(Lcom/tencent/tkd/topicsdk/imagecompress/encodedecode/StandardGifDecoder;IF)Ljava/util/List;
    //   87: astore 6
    //   89: new 227	com/tencent/tkd/topicsdk/imagecompress/encodedecode/AnimatedGifEncoder
    //   92: dup
    //   93: invokespecial 228	com/tencent/tkd/topicsdk/imagecompress/encodedecode/AnimatedGifEncoder:<init>	()V
    //   96: astore 4
    //   98: aconst_null
    //   99: checkcast 230	[B
    //   102: astore_1
    //   103: new 232	java/io/ByteArrayOutputStream
    //   106: dup
    //   107: invokespecial 233	java/io/ByteArrayOutputStream:<init>	()V
    //   110: checkcast 235	java/io/Closeable
    //   113: astore_3
    //   114: aconst_null
    //   115: checkcast 173	java/lang/Throwable
    //   118: astore_2
    //   119: aload_2
    //   120: astore_1
    //   121: aload_3
    //   122: checkcast 232	java/io/ByteArrayOutputStream
    //   125: astore 5
    //   127: aload_2
    //   128: astore_1
    //   129: aload 4
    //   131: aload 5
    //   133: checkcast 237	java/io/OutputStream
    //   136: invokevirtual 240	com/tencent/tkd/topicsdk/imagecompress/encodedecode/AnimatedGifEncoder:a	(Ljava/io/OutputStream;)Z
    //   139: pop
    //   140: aload_2
    //   141: astore_1
    //   142: aload 4
    //   144: iconst_0
    //   145: invokevirtual 242	com/tencent/tkd/topicsdk/imagecompress/encodedecode/AnimatedGifEncoder:b	(I)V
    //   148: aload_2
    //   149: astore_1
    //   150: aload 6
    //   152: checkcast 70	java/lang/Iterable
    //   155: invokeinterface 79 1 0
    //   160: astore 6
    //   162: aload_2
    //   163: astore_1
    //   164: aload 6
    //   166: invokeinterface 85 1 0
    //   171: ifeq +55 -> 226
    //   174: aload_2
    //   175: astore_1
    //   176: aload 6
    //   178: invokeinterface 89 1 0
    //   183: checkcast 165	com/tencent/tkd/topicsdk/imagecompress/engine/GifEngine$Frame
    //   186: astore 7
    //   188: aload_2
    //   189: astore_1
    //   190: aload 4
    //   192: aload 7
    //   194: invokevirtual 243	com/tencent/tkd/topicsdk/imagecompress/engine/GifEngine$Frame:b	()I
    //   197: invokevirtual 245	com/tencent/tkd/topicsdk/imagecompress/encodedecode/AnimatedGifEncoder:a	(I)V
    //   200: aload_2
    //   201: astore_1
    //   202: aload 4
    //   204: aload 7
    //   206: invokevirtual 247	com/tencent/tkd/topicsdk/imagecompress/engine/GifEngine$Frame:a	()Landroid/graphics/Bitmap;
    //   209: invokevirtual 250	com/tencent/tkd/topicsdk/imagecompress/encodedecode/AnimatedGifEncoder:a	(Landroid/graphics/Bitmap;)Z
    //   212: pop
    //   213: aload_2
    //   214: astore_1
    //   215: aload 7
    //   217: invokevirtual 247	com/tencent/tkd/topicsdk/imagecompress/engine/GifEngine$Frame:a	()Landroid/graphics/Bitmap;
    //   220: invokevirtual 253	android/graphics/Bitmap:recycle	()V
    //   223: goto -61 -> 162
    //   226: aload_2
    //   227: astore_1
    //   228: aload 4
    //   230: invokevirtual 255	com/tencent/tkd/topicsdk/imagecompress/encodedecode/AnimatedGifEncoder:a	()Z
    //   233: pop
    //   234: aload_2
    //   235: astore_1
    //   236: aload 5
    //   238: invokevirtual 258	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   241: astore 4
    //   243: aload_2
    //   244: astore_1
    //   245: getstatic 163	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   248: astore 5
    //   250: aload_3
    //   251: aload_2
    //   252: invokestatic 264	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   255: aload 4
    //   257: areturn
    //   258: astore_2
    //   259: goto +8 -> 267
    //   262: astore_2
    //   263: aload_2
    //   264: astore_1
    //   265: aload_2
    //   266: athrow
    //   267: aload_3
    //   268: aload_1
    //   269: invokestatic 264	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   272: goto +5 -> 277
    //   275: aload_2
    //   276: athrow
    //   277: goto -2 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	GifEngine
    //   19	250	1	localObject1	Object
    //   47	205	2	localObject2	Object
    //   258	1	2	localObject3	Object
    //   262	14	2	localThrowable	java.lang.Throwable
    //   55	213	3	localObject4	Object
    //   96	160	4	localObject5	Object
    //   125	124	5	localObject6	Object
    //   87	90	6	localObject7	Object
    //   186	30	7	localFrame	GifEngine.Frame
    // Exception table:
    //   from	to	target	type
    //   121	127	258	finally
    //   129	140	258	finally
    //   142	148	258	finally
    //   150	162	258	finally
    //   164	174	258	finally
    //   176	188	258	finally
    //   190	200	258	finally
    //   202	213	258	finally
    //   215	223	258	finally
    //   228	234	258	finally
    //   236	243	258	finally
    //   245	250	258	finally
    //   265	267	258	finally
    //   121	127	262	java/lang/Throwable
    //   129	140	262	java/lang/Throwable
    //   142	148	262	java/lang/Throwable
    //   150	162	262	java/lang/Throwable
    //   164	174	262	java/lang/Throwable
    //   176	188	262	java/lang/Throwable
    //   190	200	262	java/lang/Throwable
    //   202	213	262	java/lang/Throwable
    //   215	223	262	java/lang/Throwable
    //   228	234	262	java/lang/Throwable
    //   236	243	262	java/lang/Throwable
    //   245	250	262	java/lang/Throwable
  }
  
  /* Error */
  @NotNull
  public File a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 267	com/tencent/tkd/topicsdk/imagecompress/engine/GifEngine:b	()[B
    //   4: astore 4
    //   6: aload 4
    //   8: ifnull +67 -> 75
    //   11: new 269	java/io/FileOutputStream
    //   14: dup
    //   15: aload_0
    //   16: getfield 54	com/tencent/tkd/topicsdk/imagecompress/engine/GifEngine:b	Ljava/io/File;
    //   19: invokespecial 272	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   22: checkcast 235	java/io/Closeable
    //   25: astore_3
    //   26: aconst_null
    //   27: checkcast 173	java/lang/Throwable
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: aload_3
    //   34: checkcast 269	java/io/FileOutputStream
    //   37: aload 4
    //   39: invokevirtual 276	java/io/FileOutputStream:write	([B)V
    //   42: aload_2
    //   43: astore_1
    //   44: getstatic 163	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   47: astore 4
    //   49: aload_3
    //   50: aload_2
    //   51: invokestatic 264	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   54: aload_0
    //   55: getfield 54	com/tencent/tkd/topicsdk/imagecompress/engine/GifEngine:b	Ljava/io/File;
    //   58: areturn
    //   59: astore_2
    //   60: goto +8 -> 68
    //   63: astore_2
    //   64: aload_2
    //   65: astore_1
    //   66: aload_2
    //   67: athrow
    //   68: aload_3
    //   69: aload_1
    //   70: invokestatic 264	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   73: aload_2
    //   74: athrow
    //   75: new 175	java/io/File
    //   78: dup
    //   79: aload_0
    //   80: getfield 52	com/tencent/tkd/topicsdk/imagecompress/engine/GifEngine:a	Lcom/tencent/tkd/topicsdk/imagecompress/InputStreamProvider;
    //   83: invokeinterface 181 1 0
    //   88: invokespecial 184	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	GifEngine
    //   32	38	1	localThrowable1	java.lang.Throwable
    //   30	21	2	localThrowable2	java.lang.Throwable
    //   59	1	2	localObject1	Object
    //   63	11	2	localThrowable3	java.lang.Throwable
    //   25	44	3	localCloseable	java.io.Closeable
    //   4	44	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   33	42	59	finally
    //   44	49	59	finally
    //   66	68	59	finally
    //   33	42	63	java/lang/Throwable
    //   44	49	63	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.engine.GifEngine
 * JD-Core Version:    0.7.0.1
 */