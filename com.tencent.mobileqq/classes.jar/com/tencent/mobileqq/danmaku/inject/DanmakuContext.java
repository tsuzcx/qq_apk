package com.tencent.mobileqq.danmaku.inject;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.mobileqq.danmaku.core.AbsWindow;
import com.tencent.mobileqq.danmaku.core.CacheDrawManager;
import com.tencent.mobileqq.danmaku.core.R2LWindow;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.data.DefaultDanmaku;
import com.tencent.mobileqq.danmaku.data.DefaultUIConfig;
import com.tencent.mobileqq.danmaku.data.ViewDanmaku;
import com.tencent.mobileqq.danmaku.render.BaseDanmakuRender;
import com.tencent.mobileqq.danmaku.render.DefaultDanmakuRender;
import com.tencent.mobileqq.danmaku.tool.DanmakuDrawTimer;
import com.tencent.mobileqq.danmaku.tool.DanmakuDrawableCacheManager;
import com.tencent.mobileqq.danmaku.tool.PlayerTimer;
import com.tencent.mobileqq.danmaku.util.DrawUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DanmakuContext
{
  private static DefaultUIConfig jdField_a_of_type_ComTencentMobileqqDanmakuDataDefaultUIConfig;
  private static IDanmakuWindowConfigCreator jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuWindowConfigCreator;
  private static WindowConfig jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig;
  private static final String jdField_a_of_type_JavaLangString = "DanmakuContext";
  private int jdField_a_of_type_Int;
  private final SparseArray<IDanmakuUIConfig> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private IDanmakuClearScreenCallback jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuClearScreenCallback;
  private IDanmakuCreator jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuCreator;
  private IDanmakuDrawableFetcher jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuDrawableFetcher;
  private IDanmakuExposureCallback jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuExposureCallback;
  private IDanmakuLineHeightDecider jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuLineHeightDecider;
  private IDanmakuPlayTimeSupplier jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuPlayTimeSupplier;
  private IDanmakuUIConfigCreator jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuUIConfigCreator;
  private IDanmakuWindowCreator jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuWindowCreator;
  private DefaultDanmakuRender jdField_a_of_type_ComTencentMobileqqDanmakuRenderDefaultDanmakuRender = new DefaultDanmakuRender();
  private final DanmakuDrawableCacheManager<Drawable> jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawableCacheManager;
  private List<BaseDanmakuRender> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  
  private DanmakuContext(DanmakuContext.Builder paramBuilder)
  {
    this.jdField_a_of_type_Boolean = DanmakuContext.Builder.a(paramBuilder);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuPlayTimeSupplier = DanmakuContext.Builder.a(paramBuilder);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuExposureCallback = DanmakuContext.Builder.a(paramBuilder);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuDrawableFetcher = DanmakuContext.Builder.a(paramBuilder);
    jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuWindowConfigCreator = DanmakuContext.Builder.a(paramBuilder);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuUIConfigCreator = DanmakuContext.Builder.a(paramBuilder);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuLineHeightDecider = paramBuilder.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuLineHeightDecider;
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuCreator = paramBuilder.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuCreator;
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuClearScreenCallback = DanmakuContext.Builder.a(paramBuilder);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuWindowCreator = DanmakuContext.Builder.a(paramBuilder);
    this.jdField_a_of_type_Int = DanmakuContext.Builder.a(paramBuilder);
    this.b = DanmakuContext.Builder.b(paramBuilder);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawableCacheManager = new DanmakuDrawableCacheManager();
    a(paramBuilder);
    c();
  }
  
  public static DefaultUIConfig a()
  {
    if (jdField_a_of_type_ComTencentMobileqqDanmakuDataDefaultUIConfig == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqDanmakuDataDefaultUIConfig == null) {
          jdField_a_of_type_ComTencentMobileqqDanmakuDataDefaultUIConfig = new DefaultUIConfig();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqDanmakuDataDefaultUIConfig;
  }
  
  public static DanmakuContext.Builder a()
  {
    return new DanmakuContext.Builder(null);
  }
  
  public static WindowConfig a()
  {
    if (jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig == null) {
      try
      {
        if ((jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig == null) && (jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuWindowConfigCreator != null)) {
          jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig = jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuWindowConfigCreator.a();
        }
      }
      finally {}
    }
    if (jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig == null) {
      jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig = new WindowConfig();
    }
    return jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig;
  }
  
  private void a(DanmakuContext.Builder paramBuilder)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.addAll(DanmakuContext.Builder.a(paramBuilder));
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuPlayTimeSupplier != null) {
        return;
      }
      throw new IllegalArgumentException("Danmaku module need an IDanmakuPlayTimeSupplier or is live setter for computing timeline");
    }
  }
  
  public int a()
  {
    IDanmakuLineHeightDecider localIDanmakuLineHeightDecider = this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuLineHeightDecider;
    if (localIDanmakuLineHeightDecider != null) {
      return localIDanmakuLineHeightDecider.a();
    }
    return (int)Math.ceil(DrawUtils.a(a()));
  }
  
  public long a()
  {
    IDanmakuPlayTimeSupplier localIDanmakuPlayTimeSupplier = this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuPlayTimeSupplier;
    if (localIDanmakuPlayTimeSupplier == null) {
      return -1L;
    }
    return localIDanmakuPlayTimeSupplier.a();
  }
  
  public AbsWindow a(DanmakuContext paramDanmakuContext, CacheDrawManager paramCacheDrawManager, Comparator<BaseDanmaku> paramComparator, PlayerTimer paramPlayerTimer, DanmakuDrawTimer paramDanmakuDrawTimer)
  {
    IDanmakuWindowCreator localIDanmakuWindowCreator = this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuWindowCreator;
    if (localIDanmakuWindowCreator != null) {
      return localIDanmakuWindowCreator.a(paramDanmakuContext, paramCacheDrawManager, paramComparator, paramPlayerTimer, paramDanmakuDrawTimer);
    }
    return new R2LWindow(paramDanmakuContext, paramCacheDrawManager, paramComparator, paramPlayerTimer, paramDanmakuDrawTimer);
  }
  
  public BaseDanmaku a(int paramInt)
  {
    if (paramInt == -2147483647) {
      return new ViewDanmaku(this);
    }
    BaseDanmaku localBaseDanmaku = null;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuCreator;
    if (localObject != null) {
      localBaseDanmaku = ((IDanmakuCreator)localObject).a(this, paramInt);
    }
    localObject = localBaseDanmaku;
    if (localBaseDanmaku == null) {
      localObject = new DefaultDanmaku(this);
    }
    return localObject;
  }
  
  public IDanmakuUIConfig a(int paramInt)
  {
    Object localObject3 = (IDanmakuUIConfig)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      try
      {
        localObject3 = (IDanmakuUIConfig)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = localObject3;
          if (this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuUIConfigCreator != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuUIConfigCreator.a(paramInt);
            this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
          }
        }
      }
      finally {}
    }
    localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = a();
    }
    return localObject3;
  }
  
  public BaseDanmakuRender a(BaseDanmaku paramBaseDanmaku)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      localObject = (BaseDanmakuRender)localIterator.next();
      if (((BaseDanmakuRender)localObject).a(paramBaseDanmaku))
      {
        paramBaseDanmaku = (BaseDanmaku)localObject;
        break label44;
      }
    }
    paramBaseDanmaku = null;
    label44:
    Object localObject = paramBaseDanmaku;
    if (paramBaseDanmaku == null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderDefaultDanmakuRender;
    }
    return localObject;
  }
  
  public List<BaseDanmakuRender> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    IDanmakuClearScreenCallback localIDanmakuClearScreenCallback = this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuClearScreenCallback;
    if (localIDanmakuClearScreenCallback != null) {
      localIDanmakuClearScreenCallback.a();
    }
  }
  
  public void a(BaseDanmaku paramBaseDanmaku)
  {
    IDanmakuExposureCallback localIDanmakuExposureCallback = this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuExposureCallback;
    if (localIDanmakuExposureCallback != null) {
      localIDanmakuExposureCallback.a(paramBaseDanmaku);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (a() < 0L);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawableCacheManager.a(0);
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.inject.DanmakuContext
 * JD-Core Version:    0.7.0.1
 */