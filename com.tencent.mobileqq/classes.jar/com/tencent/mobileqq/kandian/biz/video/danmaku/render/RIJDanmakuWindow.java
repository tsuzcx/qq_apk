package com.tencent.mobileqq.kandian.biz.video.danmaku.render;

import android.graphics.Point;
import com.tencent.common.danmaku.core.CacheDrawManager;
import com.tencent.common.danmaku.core.R2LWindow;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.inject.IDanmakuUIConfig;
import com.tencent.common.danmaku.tool.DanmakuDrawTimer;
import com.tencent.common.danmaku.tool.PlayerTimer;
import com.tencent.common.danmaku.tool.TouchPoint;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJDanmakuWindow;", "Lcom/tencent/common/danmaku/core/R2LWindow;", "danmakuContext", "Lcom/tencent/common/danmaku/inject/DanmakuContext;", "cacheDrawManager", "Lcom/tencent/common/danmaku/core/CacheDrawManager;", "comparator", "Ljava/util/Comparator;", "Lcom/tencent/common/danmaku/data/BaseDanmaku;", "", "Lcom/tencent/common/danmaku/inject/IDanmakuUIConfig;", "playerTimer", "Lcom/tencent/common/danmaku/tool/PlayerTimer;", "drawTimer", "Lcom/tencent/common/danmaku/tool/DanmakuDrawTimer;", "(Lcom/tencent/common/danmaku/inject/DanmakuContext;Lcom/tencent/common/danmaku/core/CacheDrawManager;Ljava/util/Comparator;Lcom/tencent/common/danmaku/tool/PlayerTimer;Lcom/tencent/common/danmaku/tool/DanmakuDrawTimer;)V", "layout", "", "onClick", "touchPoint", "Lcom/tencent/common/danmaku/tool/TouchPoint;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuWindow
  extends R2LWindow
{
  public static final RIJDanmakuWindow.Companion k = new RIJDanmakuWindow.Companion(null);
  
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
    Iterator localIterator = new ArrayList((Collection)this.j).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (List)localIterator.next();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "line");
      BaseDanmaku localBaseDanmaku;
      if ((((Collection)localObject).isEmpty() ^ true))
      {
        localBaseDanmaku = (BaseDanmaku)CollectionsKt.last((List)localObject);
        Intrinsics.checkExpressionValueIsNotNull(localBaseDanmaku, "lastDanamku");
        if ((localBaseDanmaku.E()) && (localBaseDanmaku.a(paramTouchPoint.b.x, paramTouchPoint.b.y, paramTouchPoint.c, paramTouchPoint.a)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("RIJDanmakuWindow", 2, new Object[] { "onClick:", localBaseDanmaku, "[left:", Float.valueOf(localBaseDanmaku.s()), ",top:", Float.valueOf(localBaseDanmaku.t()), "]" });
          }
          return localBaseDanmaku;
        }
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localBaseDanmaku = (BaseDanmaku)((Iterator)localObject).next();
        Intrinsics.checkExpressionValueIsNotNull(localBaseDanmaku, "danmaku");
        if ((localBaseDanmaku.E()) && (localBaseDanmaku.a(paramTouchPoint.b.x, paramTouchPoint.b.y, paramTouchPoint.c, paramTouchPoint.a)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("RIJDanmakuWindow", 2, new Object[] { "onClick:", localBaseDanmaku, "[left:", Float.valueOf(localBaseDanmaku.s()), ",top:", Float.valueOf(localBaseDanmaku.t()), "]" });
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
    Iterator localIterator1 = this.j.iterator();
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
      } while (!((RIJBaseDanmaku)localObject).U());
      if (localObject != null)
      {
        localList.remove(localObject);
        localList.add(localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuWindow
 * JD-Core Version:    0.7.0.1
 */