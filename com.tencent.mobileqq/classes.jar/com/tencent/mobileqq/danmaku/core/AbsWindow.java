package com.tencent.mobileqq.danmaku.core;

import android.graphics.Canvas;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.render.BaseDanmakuRender;
import com.tencent.mobileqq.danmaku.render.DanmakuDrawer;
import com.tencent.mobileqq.danmaku.render.IDMViewOverlayDrawer;
import com.tencent.mobileqq.danmaku.tool.DanmakuDrawTimer;
import com.tencent.mobileqq.danmaku.tool.PlayerTimer;
import com.tencent.mobileqq.danmaku.tool.TouchPoint;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public abstract class AbsWindow
{
  protected int a;
  protected CacheDrawManager a;
  protected DanmakuContext a;
  protected final DanmakuDrawer a;
  protected DanmakuDrawTimer a;
  protected PlayerTimer a;
  private ArrayList<IDMViewOverlayDrawer> a;
  protected final List<BaseDanmaku> a;
  protected final TreeSet<BaseDanmaku> a;
  
  protected AbsWindow(DanmakuContext paramDanmakuContext, CacheDrawManager paramCacheDrawManager, Comparator<BaseDanmaku> paramComparator, PlayerTimer paramPlayerTimer, DanmakuDrawTimer paramDanmakuDrawTimer)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext = paramDanmakuContext;
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager = paramCacheDrawManager;
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer = paramPlayerTimer;
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer = paramDanmakuDrawTimer;
    this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderDanmakuDrawer = new DanmakuDrawer(paramCacheDrawManager);
    this.jdField_a_of_type_JavaUtilTreeSet = new TreeSet(paramComparator);
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    a();
  }
  
  public static AbsWindow a(DanmakuContext paramDanmakuContext, CacheDrawManager paramCacheDrawManager, Comparator<BaseDanmaku> paramComparator, PlayerTimer paramPlayerTimer, DanmakuDrawTimer paramDanmakuDrawTimer)
  {
    return paramDanmakuContext.a(paramDanmakuContext, paramCacheDrawManager, paramComparator, paramPlayerTimer, paramDanmakuDrawTimer);
  }
  
  private void a(Canvas paramCanvas, DanmakuContext paramDanmakuContext, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (paramCanvas != null))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IDMViewOverlayDrawer)((Iterator)localObject).next()).a(paramCanvas, paramDanmakuContext, paramLong);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public abstract BaseDanmaku a(TouchPoint paramTouchPoint);
  
  public List<BaseDanmaku> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, long paramLong)
  {
    b(paramCanvas, paramLong);
    a(paramCanvas, this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext, paramLong);
  }
  
  protected void a(Canvas paramCanvas, BaseDanmaku paramBaseDanmaku)
  {
    BaseDanmakuRender localBaseDanmakuRender = this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.a(paramBaseDanmaku);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderDanmakuDrawer.a(paramCanvas, paramBaseDanmaku, this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext, localBaseDanmakuRender);
    paramBaseDanmaku.f();
  }
  
  public void a(BaseDanmaku paramBaseDanmaku)
  {
    this.jdField_a_of_type_JavaUtilTreeSet.add(paramBaseDanmaku);
  }
  
  public void a(DanmakuDrawTimer paramDanmakuDrawTimer)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer = paramDanmakuDrawTimer;
  }
  
  public abstract void b();
  
  public abstract void b(Canvas paramCanvas, long paramLong);
  
  public void b(BaseDanmaku paramBaseDanmaku)
  {
    paramBaseDanmaku.c(true);
    paramBaseDanmaku.d(true);
    float f = paramBaseDanmaku.h();
    DanmakuMeasureManager.a(this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext, paramBaseDanmaku);
    paramBaseDanmaku.c((paramBaseDanmaku.h() + paramBaseDanmaku.f()) / (f + paramBaseDanmaku.f()));
  }
  
  public abstract void c();
  
  public abstract void c(BaseDanmaku paramBaseDanmaku);
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public abstract void d(BaseDanmaku paramBaseDanmaku);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.AbsWindow
 * JD-Core Version:    0.7.0.1
 */