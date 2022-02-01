package com.tencent.mobileqq.kandian.biz.comment.emotion.cache;

import android.content.Context;
import android.graphics.Point;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.RIJBaseEmotionInfo;
import com.tencent.mobileqq.kandian.biz.comment.emotion.download.RIJEmotionDownloader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RIJEmotionCacheManager
{
  public static long a;
  private static final Collection<IRIJEmotionCache> b = new LinkedList();
  private static volatile boolean c;
  
  @Nullable
  public static Point a(String paramString)
  {
    b();
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      Point localPoint = ((IRIJEmotionCache)localIterator.next()).b(paramString);
      if (localPoint != null) {
        return localPoint;
      }
    }
    return null;
  }
  
  public static void a()
  {
    c = true;
    RIJEmotionDownloader.a();
  }
  
  public static void a(@NonNull IEmoticonMainPanelService.PanelBuilder paramPanelBuilder, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      IRIJEmotionCache localIRIJEmotionCache = (IRIJEmotionCache)localIterator.next();
      paramPanelBuilder.addEmotionInjectionInfo(localIRIJEmotionCache.b(), localIRIJEmotionCache.a(paramIEmoticonMainPanelApp, paramContext, paramEmoticonCallback));
    }
  }
  
  public static void a(IRIJEmotionCache paramIRIJEmotionCache)
  {
    if ((paramIRIJEmotionCache != null) && (!b.contains(paramIRIJEmotionCache))) {
      b.add(paramIRIJEmotionCache);
    }
  }
  
  public static void a(@NonNull Collection<EmotionPanelInfo> paramCollection)
  {
    b();
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      paramCollection.add(((IRIJEmotionCache)localIterator.next()).a());
    }
  }
  
  public static RIJBaseEmotionInfo b(String paramString)
  {
    b();
    Iterator localIterator = b.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      RIJBaseEmotionInfo localRIJBaseEmotionInfo = ((IRIJEmotionCache)localIterator.next()).a(paramString);
      localObject = localRIJBaseEmotionInfo;
      if (localRIJBaseEmotionInfo != null) {
        localObject = localRIJBaseEmotionInfo;
      }
    }
    return localObject;
  }
  
  public static void b()
  {
    if (!c) {
      a();
    }
  }
  
  public static void c()
  {
    b.clear();
  }
  
  public static boolean d()
  {
    return b.isEmpty() ^ true;
  }
  
  public static List<? extends RIJBaseEmotionInfo> e()
  {
    b();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.addAll(((IRIJEmotionCache)localIterator.next()).c());
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJEmotionCacheManager
 * JD-Core Version:    0.7.0.1
 */