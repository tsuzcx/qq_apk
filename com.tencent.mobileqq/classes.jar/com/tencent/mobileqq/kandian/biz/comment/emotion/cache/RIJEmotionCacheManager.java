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
  private static final Collection<IRIJEmotionCache> jdField_a_of_type_JavaUtilCollection = new LinkedList();
  private static volatile boolean jdField_a_of_type_Boolean;
  
  @Nullable
  public static Point a(String paramString)
  {
    b();
    Iterator localIterator = jdField_a_of_type_JavaUtilCollection.iterator();
    while (localIterator.hasNext())
    {
      Point localPoint = ((IRIJEmotionCache)localIterator.next()).a(paramString);
      if (localPoint != null) {
        return localPoint;
      }
    }
    return null;
  }
  
  public static RIJBaseEmotionInfo a(String paramString)
  {
    b();
    Iterator localIterator = jdField_a_of_type_JavaUtilCollection.iterator();
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
  
  public static List<? extends RIJBaseEmotionInfo> a()
  {
    b();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = jdField_a_of_type_JavaUtilCollection.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.addAll(((IRIJEmotionCache)localIterator.next()).a());
    }
    return localLinkedList;
  }
  
  public static void a()
  {
    jdField_a_of_type_Boolean = true;
    RIJEmotionDownloader.a();
  }
  
  public static void a(@NonNull IEmoticonMainPanelService.PanelBuilder paramPanelBuilder, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilCollection.iterator();
    while (localIterator.hasNext())
    {
      IRIJEmotionCache localIRIJEmotionCache = (IRIJEmotionCache)localIterator.next();
      paramPanelBuilder.addEmotionInjectionInfo(localIRIJEmotionCache.a(), localIRIJEmotionCache.a(paramIEmoticonMainPanelApp, paramContext, paramEmoticonCallback));
    }
  }
  
  public static void a(IRIJEmotionCache paramIRIJEmotionCache)
  {
    if ((paramIRIJEmotionCache != null) && (!jdField_a_of_type_JavaUtilCollection.contains(paramIRIJEmotionCache))) {
      jdField_a_of_type_JavaUtilCollection.add(paramIRIJEmotionCache);
    }
  }
  
  public static void a(@NonNull Collection<EmotionPanelInfo> paramCollection)
  {
    b();
    Iterator localIterator = jdField_a_of_type_JavaUtilCollection.iterator();
    while (localIterator.hasNext()) {
      paramCollection.add(((IRIJEmotionCache)localIterator.next()).a());
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_JavaUtilCollection.isEmpty() ^ true;
  }
  
  public static void b()
  {
    if (!jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public static void c()
  {
    jdField_a_of_type_JavaUtilCollection.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJEmotionCacheManager
 * JD-Core Version:    0.7.0.1
 */