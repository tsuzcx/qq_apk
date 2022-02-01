package com.tencent.tkd.topicsdk.imagecompress.engine;

import android.graphics.Bitmap;
import com.tencent.tkd.topicsdk.imagecompress.InputStreamProvider;
import com.tencent.tkd.topicsdk.imagecompress.encodedecode.StandardGifDecoder;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.io.CloseableKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/imagecompress/engine/GifEngine;", "Lcom/tencent/tkd/topicsdk/imagecompress/engine/IEngine;", "srcImg", "Lcom/tencent/tkd/topicsdk/imagecompress/InputStreamProvider;", "tagImg", "Ljava/io/File;", "(Lcom/tencent/tkd/topicsdk/imagecompress/InputStreamProvider;Ljava/io/File;)V", "compress", "compressGif", "", "shrinkFrames", "", "Lcom/tencent/tkd/topicsdk/imagecompress/engine/GifEngine$Frame;", "gifDecoder", "Lcom/tencent/tkd/topicsdk/imagecompress/encodedecode/StandardGifDecoder;", "sampleCount", "", "scaleSize", "", "Frame", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class GifEngine
  implements IEngine
{
  private final InputStreamProvider jdField_a_of_type_ComTencentTkdTopicsdkImagecompressInputStreamProvider;
  private final File jdField_a_of_type_JavaIoFile;
  
  public GifEngine(@NotNull InputStreamProvider paramInputStreamProvider, @NotNull File paramFile)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressInputStreamProvider = paramInputStreamProvider;
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  private final List<GifEngine.Frame> a(StandardGifDecoder paramStandardGifDecoder, int paramInt, float paramFloat)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 1;
    }
    int j = paramStandardGifDecoder.a();
    Object localObject2 = (Iterable)RangesKt.until(0, j);
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label103:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((Number)localObject3).intValue() % i == 0) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label103;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList();
    Object localObject3 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      paramInt = ((Number)((Iterator)localObject3).next()).intValue();
      paramStandardGifDecoder.a();
      localObject1 = (Bitmap)null;
      if (paramInt % i != 0) {
        break label539;
      }
      localObject1 = paramStandardGifDecoder.a();
    }
    label539:
    for (;;)
    {
      if (localObject1 != null) {}
      for (localObject1 = new Pair(localObject1, Integer.valueOf(paramInt));; localObject1 = null)
      {
        if (localObject1 != null) {
          ((Collection)localObject2).add(localObject1);
        }
        break;
      }
      localObject1 = (List)localObject2;
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
        Object localObject4 = (Pair)((Iterator)localObject2).next();
        localObject3 = GifEngineKt.a((Bitmap)((Pair)localObject4).getFirst(), paramFloat);
        Object localObject5 = (Iterable)RangesKt.until(((Number)((Pair)localObject4).getSecond()).intValue(), Math.min(j, ((Number)((Pair)localObject4).getSecond()).intValue() + i));
        localObject4 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject5, 10));
        localObject5 = ((Iterable)localObject5).iterator();
        int k;
        for (paramInt = 0; ((Iterator)localObject5).hasNext(); paramInt = k + paramInt)
        {
          k = ((Number)paramStandardGifDecoder.get(((IntIterator)localObject5).nextInt())).intValue();
          ((Collection)localObject4).add(Unit.INSTANCE);
        }
        localObject4 = (List)localObject4;
        ((Collection)localObject1).add(new GifEngine.Frame((Bitmap)localObject3, paramInt));
      }
      return (List)localObject1;
    }
  }
  
  /* Error */
  private final byte[] a()
  {
    // Byte code:
    //   0: new 173	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 51	com/tencent/tkd/topicsdk/imagecompress/engine/GifEngine:jdField_a_of_type_ComTencentTkdTopicsdkImagecompressInputStreamProvider	Lcom/tencent/tkd/topicsdk/imagecompress/InputStreamProvider;
    //   8: invokeinterface 178 1 0
    //   13: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokestatic 187	kotlin/io/FilesKt:readBytes	(Ljava/io/File;)[B
    //   19: astore_1
    //   20: new 58	com/tencent/tkd/topicsdk/imagecompress/encodedecode/StandardGifDecoder
    //   23: dup
    //   24: new 189	com/tencent/tkd/topicsdk/imagecompress/encodedecode/GifBitmapProvider
    //   27: dup
    //   28: new 191	com/tencent/tkd/topicsdk/imagecompress/encodedecode/BitmapPoolAdapter
    //   31: dup
    //   32: invokespecial 192	com/tencent/tkd/topicsdk/imagecompress/encodedecode/BitmapPoolAdapter:<init>	()V
    //   35: checkcast 194	com/tencent/tkd/topicsdk/imagecompress/encodedecode/BitmapPool
    //   38: invokespecial 197	com/tencent/tkd/topicsdk/imagecompress/encodedecode/GifBitmapProvider:<init>	(Lcom/tencent/tkd/topicsdk/imagecompress/encodedecode/BitmapPool;)V
    //   41: checkcast 199	com/tencent/tkd/topicsdk/imagecompress/encodedecode/GifDecoder$BitmapProvider
    //   44: invokespecial 202	com/tencent/tkd/topicsdk/imagecompress/encodedecode/StandardGifDecoder:<init>	(Lcom/tencent/tkd/topicsdk/imagecompress/encodedecode/GifDecoder$BitmapProvider;)V
    //   47: astore_2
    //   48: new 204	com/tencent/tkd/topicsdk/imagecompress/encodedecode/GifHeaderParser
    //   51: dup
    //   52: invokespecial 205	com/tencent/tkd/topicsdk/imagecompress/encodedecode/GifHeaderParser:<init>	()V
    //   55: astore_3
    //   56: aload_3
    //   57: aload_1
    //   58: invokevirtual 208	com/tencent/tkd/topicsdk/imagecompress/encodedecode/GifHeaderParser:a	([B)Lcom/tencent/tkd/topicsdk/imagecompress/encodedecode/GifHeaderParser;
    //   61: pop
    //   62: aload_3
    //   63: invokevirtual 211	com/tencent/tkd/topicsdk/imagecompress/encodedecode/GifHeaderParser:a	()Lcom/tencent/tkd/topicsdk/imagecompress/encodedecode/GifHeader;
    //   66: astore_3
    //   67: aload_3
    //   68: ldc 213
    //   70: invokestatic 216	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   73: aload_2
    //   74: aload_3
    //   75: aload_1
    //   76: invokevirtual 219	com/tencent/tkd/topicsdk/imagecompress/encodedecode/StandardGifDecoder:a	(Lcom/tencent/tkd/topicsdk/imagecompress/encodedecode/GifHeader;[B)V
    //   79: aload_0
    //   80: aload_2
    //   81: iconst_1
    //   82: ldc 220
    //   84: invokespecial 222	com/tencent/tkd/topicsdk/imagecompress/engine/GifEngine:a	(Lcom/tencent/tkd/topicsdk/imagecompress/encodedecode/StandardGifDecoder;IF)Ljava/util/List;
    //   87: astore 5
    //   89: new 224	com/tencent/tkd/topicsdk/imagecompress/encodedecode/AnimatedGifEncoder
    //   92: dup
    //   93: invokespecial 225	com/tencent/tkd/topicsdk/imagecompress/encodedecode/AnimatedGifEncoder:<init>	()V
    //   96: astore_2
    //   97: aconst_null
    //   98: checkcast 227	[B
    //   101: astore_1
    //   102: new 229	java/io/ByteArrayOutputStream
    //   105: dup
    //   106: invokespecial 230	java/io/ByteArrayOutputStream:<init>	()V
    //   109: checkcast 232	java/io/Closeable
    //   112: astore_3
    //   113: aconst_null
    //   114: checkcast 171	java/lang/Throwable
    //   117: astore_1
    //   118: aload_3
    //   119: checkcast 229	java/io/ByteArrayOutputStream
    //   122: astore 4
    //   124: aload_2
    //   125: aload 4
    //   127: checkcast 234	java/io/OutputStream
    //   130: invokevirtual 237	com/tencent/tkd/topicsdk/imagecompress/encodedecode/AnimatedGifEncoder:a	(Ljava/io/OutputStream;)Z
    //   133: pop
    //   134: aload_2
    //   135: iconst_0
    //   136: invokevirtual 240	com/tencent/tkd/topicsdk/imagecompress/encodedecode/AnimatedGifEncoder:b	(I)V
    //   139: aload 5
    //   141: checkcast 69	java/lang/Iterable
    //   144: invokeinterface 78 1 0
    //   149: astore 5
    //   151: aload 5
    //   153: invokeinterface 84 1 0
    //   158: ifeq +45 -> 203
    //   161: aload 5
    //   163: invokeinterface 88 1 0
    //   168: checkcast 163	com/tencent/tkd/topicsdk/imagecompress/engine/GifEngine$Frame
    //   171: astore 6
    //   173: aload_2
    //   174: aload 6
    //   176: invokevirtual 241	com/tencent/tkd/topicsdk/imagecompress/engine/GifEngine$Frame:a	()I
    //   179: invokevirtual 243	com/tencent/tkd/topicsdk/imagecompress/encodedecode/AnimatedGifEncoder:a	(I)V
    //   182: aload_2
    //   183: aload 6
    //   185: invokevirtual 244	com/tencent/tkd/topicsdk/imagecompress/engine/GifEngine$Frame:a	()Landroid/graphics/Bitmap;
    //   188: invokevirtual 247	com/tencent/tkd/topicsdk/imagecompress/encodedecode/AnimatedGifEncoder:a	(Landroid/graphics/Bitmap;)Z
    //   191: pop
    //   192: aload 6
    //   194: invokevirtual 244	com/tencent/tkd/topicsdk/imagecompress/engine/GifEngine$Frame:a	()Landroid/graphics/Bitmap;
    //   197: invokevirtual 250	android/graphics/Bitmap:recycle	()V
    //   200: goto -49 -> 151
    //   203: aload_2
    //   204: invokevirtual 252	com/tencent/tkd/topicsdk/imagecompress/encodedecode/AnimatedGifEncoder:a	()Z
    //   207: pop
    //   208: aload 4
    //   210: invokevirtual 255	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   213: astore_2
    //   214: getstatic 161	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   217: astore 4
    //   219: aload_3
    //   220: aload_1
    //   221: invokestatic 261	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   224: aload_2
    //   225: areturn
    //   226: astore_1
    //   227: aload_1
    //   228: athrow
    //   229: astore_2
    //   230: aload_3
    //   231: aload_1
    //   232: invokestatic 261	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   235: aload_2
    //   236: athrow
    //   237: astore_2
    //   238: goto -8 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	GifEngine
    //   19	202	1	localObject1	Object
    //   226	6	1	localThrowable	Throwable
    //   47	178	2	localObject2	Object
    //   229	7	2	localObject3	Object
    //   237	1	2	localObject4	Object
    //   55	176	3	localObject5	Object
    //   122	96	4	localObject6	Object
    //   87	75	5	localObject7	Object
    //   171	22	6	localFrame	GifEngine.Frame
    // Exception table:
    //   from	to	target	type
    //   118	151	226	java/lang/Throwable
    //   151	200	226	java/lang/Throwable
    //   203	219	226	java/lang/Throwable
    //   227	229	229	finally
    //   118	151	237	finally
    //   151	200	237	finally
    //   203	219	237	finally
  }
  
  @NotNull
  public File a()
  {
    Object localObject2 = a();
    Throwable localThrowable2;
    if (localObject2 != null)
    {
      localCloseable = (Closeable)new FileOutputStream(this.jdField_a_of_type_JavaIoFile);
      localThrowable2 = (Throwable)null;
      localThrowable1 = localThrowable2;
    }
    try
    {
      ((FileOutputStream)localCloseable).write((byte[])localObject2);
      localThrowable1 = localThrowable2;
      localObject2 = Unit.INSTANCE;
      return this.jdField_a_of_type_JavaIoFile;
    }
    catch (Throwable localThrowable3)
    {
      localThrowable1 = localThrowable3;
      throw localThrowable3;
    }
    finally
    {
      CloseableKt.closeFinally(localCloseable, localThrowable1);
    }
    return new File(this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressInputStreamProvider.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.engine.GifEngine
 * JD-Core Version:    0.7.0.1
 */