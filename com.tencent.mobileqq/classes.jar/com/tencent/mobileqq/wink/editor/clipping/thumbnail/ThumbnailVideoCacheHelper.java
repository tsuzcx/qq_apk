package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import android.util.LruCache;
import androidx.annotation.RequiresApi;
import com.tencent.logger.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailVideoCacheHelper;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ICacheInterface;", "cache", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailAssetCache;", "(Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailAssetCache;)V", "bitmapList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/BitmapPoint;", "getBitmapList$qq_wink_impl_release", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "addThumbnail", "", "startTimeUs", "", "bitmap", "Landroid/graphics/Bitmap;", "getCacheSize", "getThumbnail", "timeUs", "release", "releaseLowMemory", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ThumbnailVideoCacheHelper
  implements ICacheInterface
{
  @NotNull
  private final CopyOnWriteArrayList<BitmapPoint> a;
  private final ThumbnailAssetCache b;
  
  public ThumbnailVideoCacheHelper(@NotNull ThumbnailAssetCache paramThumbnailAssetCache)
  {
    this.b = paramThumbnailAssetCache;
    this.a = new CopyOnWriteArrayList();
  }
  
  @Nullable
  public BitmapPoint a(long paramLong)
  {
    Iterator localIterator = ((Iterable)this.a).iterator();
    if (!localIterator.hasNext())
    {
      localObject1 = null;
    }
    else
    {
      localObject1 = localIterator.next();
      if (localIterator.hasNext())
      {
        long l1 = Math.abs(((BitmapPoint)localObject1).b() - paramLong);
        Object localObject2 = localObject1;
        do
        {
          Object localObject3 = localIterator.next();
          long l3 = Math.abs(((BitmapPoint)localObject3).b() - paramLong);
          localObject1 = localObject2;
          long l2 = l1;
          if (l1 > l3)
          {
            localObject1 = localObject3;
            l2 = l3;
          }
          localObject2 = localObject1;
          l1 = l2;
        } while (localIterator.hasNext());
      }
    }
    Object localObject1 = (BitmapPoint)localObject1;
    if (localObject1 != null)
    {
      this.b.b().get(new LRUKey(this.b.a(), paramLong));
      return localObject1;
    }
    return null;
  }
  
  public void a()
  {
    Iterator localIterator = ((Iterable)this.a).iterator();
    while (localIterator.hasNext())
    {
      BitmapPoint localBitmapPoint = (BitmapPoint)localIterator.next();
      Bitmap localBitmap = localBitmapPoint.a();
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
      this.b.b().remove(new LRUKey(this.b.a(), localBitmapPoint.b()));
    }
    this.a.clear();
  }
  
  @RequiresApi(19)
  public void a(long paramLong, @NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    Object localObject1 = Logger.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("addCover: ");
    ((StringBuilder)localObject2).append(paramLong);
    ((Logger)localObject1).a("ThumbnailVideoCacheHelper", ((StringBuilder)localObject2).toString());
    localObject2 = new BitmapPoint(paramBitmap, paramLong);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).addAll((Collection)this.a);
    ((ArrayList)localObject1).add(localObject2);
    localObject2 = (List)localObject1;
    if (((List)localObject2).size() > 1) {
      CollectionsKt.sortWith((List)localObject2, (Comparator)new ThumbnailVideoCacheHelper.addThumbnail..inlined.sortBy.1());
    }
    this.a.clear();
    this.a.addAll((Collection)localObject1);
    this.b.b().put(new LRUKey(this.b.a(), paramLong), Integer.valueOf(paramBitmap.getAllocationByteCount()));
  }
  
  public void b(long paramLong)
  {
    Object localObject2 = ((Iterable)this.a).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      int i;
      if (((BitmapPoint)localObject1).b() == paramLong) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        break label63;
      }
    }
    Object localObject1 = null;
    label63:
    localObject1 = (BitmapPoint)localObject1;
    if (localObject1 != null)
    {
      this.a.remove(localObject1);
      localObject2 = ((BitmapPoint)localObject1).a();
      if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
      {
        Logger localLogger = Logger.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("bitmap recycle:");
        localStringBuilder.append(((BitmapPoint)localObject1).b());
        localLogger.a("ThumbnailVideoCacheHelper", localStringBuilder.toString());
        ((Bitmap)localObject2).recycle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailVideoCacheHelper
 * JD-Core Version:    0.7.0.1
 */