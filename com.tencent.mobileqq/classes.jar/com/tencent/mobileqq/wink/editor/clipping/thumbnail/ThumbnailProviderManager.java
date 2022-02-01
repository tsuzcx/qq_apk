package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.LruCache;
import com.tencent.logger.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailProviderManager;", "", "()V", "B_TO_KB", "", "DEFAULT_BITMAP_COLOR", "", "DEFAULT_HEIGHT", "", "DEFAULT_WIDTH", "MAX_SIZE", "TAG", "cacheSize", "getCacheSize", "()I", "defaultBitmap", "Landroid/graphics/Bitmap;", "generateHandler", "Landroid/os/Handler;", "getGenerateHandler", "()Landroid/os/Handler;", "generateHandler$delegate", "Lkotlin/Lazy;", "groupAssetIdMapping", "", "", "height", "lruCache", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailProviderManager$VideoThumbLruCache;", "runnableHandler", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IRunnableHandler;", "subVideoThumbListener", "com/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailProviderManager$subVideoThumbListener$1", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailProviderManager$subVideoThumbListener$1;", "videoThumbAssetProviders", "", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailAssetProvider;", "videoThumbListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IThumbnailGeneratedListener;", "width", "addProvider", "", "assetModelList", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbAssetModel;", "groupId", "addProviderIfNeed", "findCallback", "Lkotlin/Function1;", "crateProvider", "resourceModel", "assetPath", "dp2px", "dpValue", "getBitmapByTime", "timeMs", "", "tag", "getDefaultBitmap", "initWidthAndHeight", "pause", "registerListener", "listener", "release", "releaseGroup", "sourceList", "exceptList", "releaseProviderByAssetPath", "reset", "resetProvider", "resume", "setDefaultBitmap", "bitmap", "unRegisterListener", "VideoThumbLruCache", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ThumbnailProviderManager
{
  public static final ThumbnailProviderManager a;
  private static final List<ThumbnailAssetProvider> b;
  private static Bitmap c;
  private static int d;
  private static int e;
  private static final CopyOnWriteArrayList<IThumbnailGeneratedListener> f;
  private static final ThumbnailProviderManager.subVideoThumbListener.1 g;
  private static final Map<String, List<String>> h;
  private static final ThumbnailProviderManager.VideoThumbLruCache i;
  private static final Lazy j;
  private static final IRunnableHandler k;
  
  static
  {
    ThumbnailProviderManager localThumbnailProviderManager = new ThumbnailProviderManager();
    a = localThumbnailProviderManager;
    b = (List)new ArrayList();
    f = new CopyOnWriteArrayList();
    g = new ThumbnailProviderManager.subVideoThumbListener.1();
    h = (Map)new LinkedHashMap();
    i = new ThumbnailProviderManager.VideoThumbLruCache(10240);
    j = LazyKt.lazy((Function0)ThumbnailProviderManager.generateHandler.2.INSTANCE);
    k = (IRunnableHandler)new ThumbnailProviderManager.runnableHandler.1();
    d = localThumbnailProviderManager.a(56.0F);
    e = localThumbnailProviderManager.a(56.0F);
    Bitmap localBitmap = Bitmap.createBitmap(d, e, Bitmap.Config.ARGB_8888);
    localBitmap.eraseColor(Color.parseColor("#4dffffff"));
    Intrinsics.checkExpressionValueIsNotNull(localBitmap, "bitmap");
    localThumbnailProviderManager.a(localBitmap);
  }
  
  private final int a(float paramFloat)
  {
    Resources localResources = Resources.getSystem();
    Intrinsics.checkExpressionValueIsNotNull(localResources, "Resources.getSystem()");
    return MathKt.roundToInt(paramFloat * localResources.getDisplayMetrics().density);
  }
  
  private final ThumbnailAssetProvider a(String paramString1, ThumbAssetModel paramThumbAssetModel, String paramString2)
  {
    Logger localLogger = Logger.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resetProvider can't find:");
    localStringBuilder.append(paramString2);
    localLogger.a("VideoThumbProviderManager", localStringBuilder.toString());
    paramString1 = new ThumbnailAssetProvider(paramString1, paramThumbAssetModel, (LruCache)i, k, d, e);
    paramString1.a((IThumbnailGeneratedListener)g);
    paramString1.a(c);
    return paramString1;
  }
  
  private final void a(List<ThumbnailAssetProvider> paramList, String paramString, List<String> paramList1)
  {
    Object localObject2 = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      ThumbnailAssetProvider localThumbnailAssetProvider = (ThumbnailAssetProvider)localObject3;
      int m;
      if ((Intrinsics.areEqual(localThumbnailAssetProvider.e(), paramString)) && (!paramList1.contains(localThumbnailAssetProvider.a()))) {
        m = 1;
      } else {
        m = 0;
      }
      if (m != 0) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    paramString = ((Iterable)localObject1).iterator();
    while (paramString.hasNext())
    {
      paramList1 = (ThumbnailAssetProvider)paramString.next();
      if (paramList1.d())
      {
        localObject1 = Logger.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("release provider:");
        ((StringBuilder)localObject2).append(paramList1.a());
        ((Logger)localObject1).a("VideoThumbProviderManager", ((StringBuilder)localObject2).toString());
        paramList.remove(paramList1);
        paramList1.b();
      }
      else
      {
        localObject1 = Logger.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("can't release provider:");
        ((StringBuilder)localObject2).append(paramList1.a());
        ((Logger)localObject1).a("VideoThumbProviderManager", ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private final void a(List<ThumbAssetModel> paramList, String paramString, Function1<? super ThumbnailAssetProvider, Unit> paramFunction1)
  {
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (ThumbAssetModel)localIterator.next();
      String str = ((ThumbAssetModel)localObject1).a();
      Object localObject2 = ((Iterable)b).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramList = ((Iterator)localObject2).next();
        if (Intrinsics.areEqual(str, ((ThumbnailAssetProvider)paramList).a())) {
          break label91;
        }
      }
      paramList = null;
      label91:
      paramList = (ThumbnailAssetProvider)paramList;
      if (paramList == null)
      {
        paramList = a.a(paramString, (ThumbAssetModel)localObject1, str);
        b.add(paramList);
      }
      else
      {
        localObject1 = Logger.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("resetProvider find:");
        ((StringBuilder)localObject2).append(str);
        ((Logger)localObject1).a("VideoThumbProviderManager", ((StringBuilder)localObject2).toString());
        if (paramFunction1 != null) {
          paramList = (Unit)paramFunction1.invoke(paramList);
        }
      }
    }
  }
  
  private final Handler b()
  {
    return (Handler)j.getValue();
  }
  
  private final void b(List<ThumbAssetModel> paramList, String paramString)
  {
    Logger.a.a("VideoThumbProviderManager", "resetProvider start");
    a(paramList, paramString, null);
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(((ThumbAssetModel)((Iterator)localObject).next()).a());
    }
    paramList = (List)paramList;
    a(b, paramString, paramList);
    h.remove(paramString);
    h.put(paramString, paramList);
  }
  
  @Nullable
  public final Bitmap a()
  {
    return c;
  }
  
  @Nullable
  public final Bitmap a(long paramLong, @Nullable Object paramObject, @Nullable String paramString)
  {
    if ((e == 0) && (d == 0)) {
      return c;
    }
    if (b.isEmpty()) {
      return c;
    }
    Iterator localIterator = ((Iterable)b).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (Intrinsics.areEqual(paramString, ((ThumbnailAssetProvider)localObject).a()))
      {
        paramString = localObject;
        break label89;
      }
    }
    paramString = null;
    label89:
    paramString = (ThumbnailAssetProvider)paramString;
    if (paramString != null) {
      return paramString.a(paramLong, paramObject);
    }
    return c;
  }
  
  public final void a(@NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    c = paramBitmap;
    Iterator localIterator = ((Iterable)b).iterator();
    while (localIterator.hasNext()) {
      ((ThumbnailAssetProvider)localIterator.next()).a(paramBitmap);
    }
  }
  
  public final void a(@NotNull IThumbnailGeneratedListener paramIThumbnailGeneratedListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIThumbnailGeneratedListener, "listener");
    if (!f.contains(paramIThumbnailGeneratedListener))
    {
      f.add(paramIThumbnailGeneratedListener);
      Logger.a.a("VideoThumbProviderManager", "registerListener addSuccess");
    }
  }
  
  public final void a(@NotNull List<ThumbAssetModel> paramList, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "assetModelList");
    Intrinsics.checkParameterIsNotNull(paramString, "groupId");
    if ((d != 0) && (e != 0)) {
      b(paramList, paramString);
    }
  }
  
  public final void b(@NotNull IThumbnailGeneratedListener paramIThumbnailGeneratedListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIThumbnailGeneratedListener, "listener");
    boolean bool = f.remove(paramIThumbnailGeneratedListener);
    paramIThumbnailGeneratedListener = Logger.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unRegisterListener removeSuccess:");
    localStringBuilder.append(bool);
    paramIThumbnailGeneratedListener.a("VideoThumbProviderManager", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderManager
 * JD-Core Version:    0.7.0.1
 */