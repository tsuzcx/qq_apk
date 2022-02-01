package com.tencent.mobileqq.kandian.biz.video.danmaku.render;

import android.graphics.Point;
import com.tencent.mobileqq.danmaku.core.CacheDrawManager;
import com.tencent.mobileqq.danmaku.core.R2LWindow;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.inject.IDanmakuUIConfig;
import com.tencent.mobileqq.danmaku.tool.DanmakuDrawTimer;
import com.tencent.mobileqq.danmaku.tool.PlayerTimer;
import com.tencent.mobileqq.danmaku.tool.TouchPoint;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJDanmakuWindow;", "Lcom/tencent/mobileqq/danmaku/core/R2LWindow;", "danmakuContext", "Lcom/tencent/mobileqq/danmaku/inject/DanmakuContext;", "cacheDrawManager", "Lcom/tencent/mobileqq/danmaku/core/CacheDrawManager;", "comparator", "Ljava/util/Comparator;", "Lcom/tencent/mobileqq/danmaku/data/BaseDanmaku;", "", "Lcom/tencent/mobileqq/danmaku/inject/IDanmakuUIConfig;", "playerTimer", "Lcom/tencent/mobileqq/danmaku/tool/PlayerTimer;", "drawTimer", "Lcom/tencent/mobileqq/danmaku/tool/DanmakuDrawTimer;", "(Lcom/tencent/mobileqq/danmaku/inject/DanmakuContext;Lcom/tencent/mobileqq/danmaku/core/CacheDrawManager;Ljava/util/Comparator;Lcom/tencent/mobileqq/danmaku/tool/PlayerTimer;Lcom/tencent/mobileqq/danmaku/tool/DanmakuDrawTimer;)V", "layout", "", "onClick", "touchPoint", "Lcom/tencent/mobileqq/danmaku/tool/TouchPoint;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuWindow
  extends R2LWindow
{
  public static final RIJDanmakuWindow.Companion a = new RIJDanmakuWindow.Companion(null);
  
  public RIJDanmakuWindow(@Nullable DanmakuContext paramDanmakuContext, @Nullable CacheDrawManager paramCacheDrawManager, @Nullable Comparator<BaseDanmaku<Object, IDanmakuUIConfig>> paramComparator, @Nullable PlayerTimer paramPlayerTimer, @Nullable DanmakuDrawTimer paramDanmakuDrawTimer)
  {
    super(paramDanmakuContext, paramCacheDrawManager, paramComparator, paramPlayerTimer, paramDanmakuDrawTimer);
  }
  
  @Nullable
  public BaseDanmaku<?, ?> a(@Nullable TouchPoint paramTouchPoint)
  {
    if (paramTouchPoint == null) {
      return null;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (List)localIterator.next();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "line");
      BaseDanmaku localBaseDanmaku;
      if ((((Collection)localObject).isEmpty() ^ true))
      {
        localBaseDanmaku = (BaseDanmaku)CollectionsKt.last((List)localObject);
        Intrinsics.checkExpressionValueIsNotNull(localBaseDanmaku, "lastDanamku");
        if ((localBaseDanmaku.d()) && (localBaseDanmaku.a(paramTouchPoint.jdField_a_of_type_AndroidGraphicsPoint.x, paramTouchPoint.jdField_a_of_type_AndroidGraphicsPoint.y, paramTouchPoint.jdField_a_of_type_Int, paramTouchPoint.jdField_a_of_type_Long)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("RIJDanmakuWindow", 2, new Object[] { "onClick:", localBaseDanmaku, "[left:", Float.valueOf(localBaseDanmaku.d()), ",top:", Float.valueOf(localBaseDanmaku.e()), "]" });
          }
          return localBaseDanmaku;
        }
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localBaseDanmaku = (BaseDanmaku)((Iterator)localObject).next();
        Intrinsics.checkExpressionValueIsNotNull(localBaseDanmaku, "danmaku");
        if ((localBaseDanmaku.d()) && (localBaseDanmaku.a(paramTouchPoint.jdField_a_of_type_AndroidGraphicsPoint.x, paramTouchPoint.jdField_a_of_type_AndroidGraphicsPoint.y, paramTouchPoint.jdField_a_of_type_Int, paramTouchPoint.jdField_a_of_type_Long)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("RIJDanmakuWindow", 2, new Object[] { "onClick:", localBaseDanmaku, "[left:", Float.valueOf(localBaseDanmaku.d()), ",top:", Float.valueOf(localBaseDanmaku.e()), "]" });
          }
          return localBaseDanmaku;
        }
      }
    }
    return null;
  }
  
  public void b()
  {
    super.b();
    Iterator localIterator1 = this.b.iterator();
    while (localIterator1.hasNext())
    {
      List localList = (List)localIterator1.next();
      RIJBaseDanmaku localRIJBaseDanmaku = (RIJBaseDanmaku)null;
      Iterator localIterator2 = localList.iterator();
      Object localObject;
      do
      {
        do
        {
          localObject = localRIJBaseDanmaku;
          if (!localIterator2.hasNext()) {
            break;
          }
          localObject = (BaseDanmaku)localIterator2.next();
        } while (!(localObject instanceof RIJBaseDanmaku));
        localObject = (RIJBaseDanmaku)localObject;
      } while (!((RIJBaseDanmaku)localObject).i());
      if (localObject != null)
      {
        localList.remove(localObject);
        localList.add(localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuWindow
 * JD-Core Version:    0.7.0.1
 */