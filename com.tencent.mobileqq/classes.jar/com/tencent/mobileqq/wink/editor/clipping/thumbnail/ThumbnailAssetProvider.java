package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.tencent.logger.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailAssetProvider;", "", "groupId", "", "resourceModel", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbAssetModel;", "lruCache", "Landroid/util/LruCache;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/LRUKey;", "", "handler", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IRunnableHandler;", "coverWidth", "coverHeight", "(Ljava/lang/String;Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbAssetModel;Landroid/util/LruCache;Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IRunnableHandler;II)V", "assetPath", "getAssetPath", "()Ljava/lang/String;", "cache", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailAssetCache;", "cacheHelper", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ICacheInterface;", "cacheSize", "", "getCacheSize", "()J", "defaultBitmap", "Landroid/graphics/Bitmap;", "defaultVideoThumbListener", "com/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailAssetProvider$defaultVideoThumbListener$1", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailAssetProvider$defaultVideoThumbListener$1;", "generator", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorSupplier;", "generatorHelper", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IThumbnailGenerator;", "getGroupId", "refCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "getResourceModel", "()Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbAssetModel;", "sourceTimeDuration", "getSourceTimeDuration", "tagTable", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "userVideoThumbListener", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IThumbnailGeneratedListener;", "canRelease", "", "getBitmapByAbsoluteTime", "timeUs", "tag", "getBitmapByNearbyTime", "nearbyTime", "getNormalizedSeekTime", "duration", "pause", "", "refDecrease", "refIncrease", "release", "releaseBitmap", "time", "resume", "sendGenerateRequest", "timeMs", "setDefaultBitmap", "bitmap", "setThumbnailListener", "videoThumbListener", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ThumbnailAssetProvider
{
  public static final ThumbnailAssetProvider.Companion a = new ThumbnailAssetProvider.Companion(null);
  private final ThumbnailAssetProvider.defaultVideoThumbListener.1 b;
  private IThumbnailGeneratedListener c;
  private final ICacheInterface d;
  private final ThumbnailAssetCache e;
  private Bitmap f;
  private final ConcurrentHashMap<String, CopyOnWriteArrayList<Object>> g;
  private final AtomicInteger h;
  private final IThumbnailGenerator i;
  private final ThumbnailGeneratorSupplier j;
  @NotNull
  private final String k;
  @NotNull
  private final ThumbAssetModel l;
  
  public ThumbnailAssetProvider(@NotNull String paramString, @NotNull ThumbAssetModel paramThumbAssetModel, @NotNull LruCache<LRUKey, Integer> paramLruCache, @NotNull IRunnableHandler paramIRunnableHandler, int paramInt1, int paramInt2)
  {
    this.k = paramString;
    this.l = paramThumbAssetModel;
    this.b = new ThumbnailAssetProvider.defaultVideoThumbListener.1(this);
    this.g = new ConcurrentHashMap();
    this.h = new AtomicInteger(0);
    paramString = new ThumbnailAssetCache(this.l.a(), paramLruCache);
    this.d = ((ICacheInterface)new ThumbnailVideoCacheHelper(paramString));
    this.e = paramString;
    this.j = new ThumbnailGeneratorSupplier((IThumbnailGeneratedListener)this.b, paramInt2, paramInt1, paramIRunnableHandler);
    this.i = ((IThumbnailGenerator)new ThumbnailGeneratorHelper(this.j, this.l));
  }
  
  private final long a(long paramLong1, long paramLong2)
  {
    long l3 = 1000000;
    long l2 = paramLong1 / l3;
    long l1 = l2;
    if (paramLong1 % l3 >= 500000) {
      l1 = l2 + 1L;
    }
    paramLong1 = l1 * l3;
    l1 = 0L;
    if (paramLong1 < 0L) {
      paramLong1 = l1;
    }
    l1 = paramLong1;
    if (paramLong1 > paramLong2) {
      l1 = paramLong2 - 100000;
    }
    return l1;
  }
  
  private final void a(Object paramObject, long paramLong)
  {
    Object localObject1 = String.valueOf(paramLong);
    Object localObject2 = (CopyOnWriteArrayList)this.g.get(localObject1);
    if (localObject2 != null)
    {
      if (!((CopyOnWriteArrayList)localObject2).contains(paramObject)) {
        ((CopyOnWriteArrayList)localObject2).add(paramObject);
      }
      return;
    }
    localObject2 = new CopyOnWriteArrayList();
    ((CopyOnWriteArrayList)localObject2).add(paramObject);
    ((Map)this.g).put(localObject1, localObject2);
    localObject1 = Logger.a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("sendGenerateRequest time:");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append(",Object:");
    ((StringBuilder)localObject2).append(paramObject);
    ((Logger)localObject1).a("VideoThumbAssetProvider", ((StringBuilder)localObject2).toString());
    this.i.a(paramLong);
  }
  
  private final Bitmap b(long paramLong, Object paramObject)
  {
    BitmapPoint localBitmapPoint = this.d.a(paramLong);
    Bitmap localBitmap;
    if (localBitmapPoint != null) {
      localBitmap = localBitmapPoint.a();
    } else {
      localBitmap = null;
    }
    if (localBitmap == null)
    {
      a(paramObject, paramLong);
      return this.f;
    }
    if (localBitmapPoint.b() != paramLong) {
      a(paramObject, paramLong);
    }
    return localBitmapPoint.a();
  }
  
  private final long f()
  {
    return this.l.c();
  }
  
  @Nullable
  public final Bitmap a(long paramLong, @Nullable Object paramObject)
  {
    if (this.l.b() == 1) {
      return b(0L, paramObject);
    }
    return b(a(paramLong, f()), paramObject);
  }
  
  @NotNull
  public final String a()
  {
    return this.l.a();
  }
  
  public final void a(long paramLong)
  {
    this.d.b(paramLong);
  }
  
  public final void a(@Nullable Bitmap paramBitmap)
  {
    this.f = paramBitmap;
  }
  
  public final void a(@Nullable IThumbnailGeneratedListener paramIThumbnailGeneratedListener)
  {
    this.c = paramIThumbnailGeneratedListener;
  }
  
  public final void b()
  {
    Logger localLogger = Logger.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release:");
    localStringBuilder.append(this.l.a());
    localLogger.a("VideoThumbAssetProvider", localStringBuilder.toString());
    this.i.a();
    this.d.a();
  }
  
  public final void c()
  {
    this.h.getAndIncrement();
  }
  
  public final boolean d()
  {
    return this.h.get() <= 0;
  }
  
  @NotNull
  public final String e()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailAssetProvider
 * JD-Core Version:    0.7.0.1
 */