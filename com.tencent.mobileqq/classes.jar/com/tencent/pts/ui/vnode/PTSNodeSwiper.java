package com.tencent.pts.ui.vnode;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.view.PTSSwiperView;
import com.tencent.pts.utils.PTSValueConvertUtil;

public class PTSNodeSwiper
  extends PTSNodeVirtual<PTSSwiperView>
{
  private final String ATTRIBUTE_AUTOPLAY = "autoplay";
  private final String ATTRIBUTE_CIRCULAR = "circular";
  private final String ATTRIBUTE_CURRENT = "current";
  private final String ATTRIBUTE_DURATION = "duration";
  private final String ATTRIBUTE_INDICATOR_ACTIVE_COLOR = "indicator-active-color";
  private final String ATTRIBUTE_INDICATOR_COLOR = "indicator-color";
  private final String ATTRIBUTE_INDICATOR_DOTS = "indicator-dots";
  private final String ATTRIBUTE_INTERVAL = "interval";
  private final String ATTRIBUTE_PTS_INDICATOR_BOTTOM = "pts:indicator-bottom";
  private final String ATTRIBUTE_PTS_INDICATOR_GAP = "pts:indicator-gap";
  private final String ATTRIBUTE_PTS_INDICATOR_HEIGHT = "pts:indicator-height";
  private final String ATTRIBUTE_PTS_INDICATOR_RADIUS = "pts:indicator-radius";
  private final String ATTRIBUTE_PTS_INDICATOR_WIDTH = "pts:indicator-width";
  
  private PTSNodeSwiper(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  public PTSSwiperView initView()
  {
    return new PTSSwiperView(this);
  }
  
  public void resetAll() {}
  
  protected boolean setAttribute(String paramString, Object paramObject)
  {
    if (super.setAttribute(paramString, paramObject)) {
      return true;
    }
    if ("indicator-dots".equalsIgnoreCase(paramString))
    {
      ((PTSSwiperView)getView()).setIndicatorVisible(PTSValueConvertUtil.getBoolean(paramObject));
      return true;
    }
    if ("indicator-color".equalsIgnoreCase(paramString))
    {
      ((PTSSwiperView)getView()).setIndicatorNormalColor(PTSValueConvertUtil.getColor(paramObject));
      return true;
    }
    if ("indicator-active-color".equalsIgnoreCase(paramString))
    {
      ((PTSSwiperView)getView()).setIndicatorFocusedColor(PTSValueConvertUtil.getColor(paramObject));
      return true;
    }
    if ("autoplay".equalsIgnoreCase(paramString))
    {
      ((PTSSwiperView)getView()).setAutoPlay(PTSValueConvertUtil.getBoolean(paramObject));
      return true;
    }
    if ("interval".equalsIgnoreCase(paramString))
    {
      ((PTSSwiperView)getView()).setAutoPlayInterval(PTSValueConvertUtil.getInt(paramObject));
      return true;
    }
    if ("duration".equalsIgnoreCase(paramString))
    {
      ((PTSSwiperView)getView()).setAutoPlayDuration(PTSValueConvertUtil.getInt(paramObject));
      return true;
    }
    if ("circular".equalsIgnoreCase(paramString))
    {
      ((PTSSwiperView)getView()).setCircularAutoPlay(PTSValueConvertUtil.getBoolean(paramObject));
      return true;
    }
    if ("pts:indicator-width".equalsIgnoreCase(paramString))
    {
      ((PTSSwiperView)getView()).setIndicatorWidth(PTSValueConvertUtil.getFloat(paramObject));
      return true;
    }
    if ("pts:indicator-height".equalsIgnoreCase(paramString))
    {
      ((PTSSwiperView)getView()).setIndicatorHeight(PTSValueConvertUtil.getFloat(paramObject));
      return true;
    }
    if ("pts:indicator-gap".equalsIgnoreCase(paramString))
    {
      ((PTSSwiperView)getView()).setIndicatorGap(PTSValueConvertUtil.getFloat(paramObject));
      return true;
    }
    if ("pts:indicator-bottom".equalsIgnoreCase(paramString))
    {
      ((PTSSwiperView)getView()).setIndicatorMarginBottom(PTSValueConvertUtil.getFloat(paramObject));
      return true;
    }
    if ("pts:indicator-radius".equalsIgnoreCase(paramString))
    {
      ((PTSSwiperView)getView()).setIndicatorRadius(PTSValueConvertUtil.getFloat(paramObject));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeSwiper
 * JD-Core Version:    0.7.0.1
 */