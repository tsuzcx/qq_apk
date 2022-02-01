package com.tencent.pts.ui.vnode;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.view.PTSSwiperView;
import com.tencent.pts.utils.PTSDeviceUtil;
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
  private final String ATTRIBUTE_PTS_INDICATOR_DOTS_GAP = "pts:indicator-dots-gap";
  private final String ATTRIBUTE_PTS_INDICATOR_DOTS_HEIGHT = "pts:indicator-dots-height";
  private final String ATTRIBUTE_PTS_INDICATOR_DOTS_RADIUS = "pts:indicator-dots-radius";
  private final String ATTRIBUTE_PTS_INDICATOR_DOTS_WIDTH = "pts:indicator-dots-width";
  private boolean autoPlay = false;
  private int autoPlayDuration = 500;
  private int autoPlayInterval = 5000;
  private boolean circular = false;
  private int indicatorFocusedColor = -16777216;
  private float indicatorGap = PTSDeviceUtil.dp2pxInt(4.0F);
  private float indicatorHeight = PTSDeviceUtil.dp2pxInt(3.0F);
  private float indicatorMarginBottom = PTSDeviceUtil.dp2pxInt(12.0F);
  private int indicatorNormalColor = 1275068416;
  private float indicatorRadius = PTSDeviceUtil.dp2px(2.5F);
  private float indicatorWidth = PTSDeviceUtil.dp2pxInt(16.0F);
  private boolean showIndicatorDots = false;
  
  public PTSNodeSwiper(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  protected void onParseValueFinished()
  {
    super.onParseValueFinished();
    PTSSwiperView localPTSSwiperView = (PTSSwiperView)getView();
    localPTSSwiperView.setIndicatorVisible(this.showIndicatorDots);
    localPTSSwiperView.setIndicatorNormalColor(this.indicatorNormalColor);
    localPTSSwiperView.setIndicatorFocusedColor(this.indicatorFocusedColor);
    localPTSSwiperView.setAutoPlay(this.autoPlay);
    localPTSSwiperView.setAutoPlayInterval(this.autoPlayInterval);
    localPTSSwiperView.setAutoPlayDuration(this.autoPlayDuration);
    localPTSSwiperView.setCircular(this.circular);
    localPTSSwiperView.setIndicatorWidth(this.indicatorWidth);
    localPTSSwiperView.setIndicatorHeight(this.indicatorHeight);
    localPTSSwiperView.setIndicatorGap(this.indicatorGap);
    localPTSSwiperView.setIndicatorMarginBottom(this.indicatorMarginBottom);
    localPTSSwiperView.setIndicatorRadius(this.indicatorRadius);
  }
  
  protected boolean setAttribute(String paramString, Object paramObject)
  {
    if (super.setAttribute(paramString, paramObject)) {
      return true;
    }
    if ("indicator-dots".equalsIgnoreCase(paramString))
    {
      this.showIndicatorDots = PTSValueConvertUtil.getBoolean(paramObject);
      return true;
    }
    if ("indicator-color".equalsIgnoreCase(paramString))
    {
      this.indicatorNormalColor = PTSValueConvertUtil.getColor(paramObject);
      return true;
    }
    if ("indicator-active-color".equalsIgnoreCase(paramString))
    {
      this.indicatorFocusedColor = PTSValueConvertUtil.getColor(paramObject);
      return true;
    }
    if ("autoplay".equalsIgnoreCase(paramString))
    {
      this.autoPlay = PTSValueConvertUtil.getBoolean(paramObject);
      return true;
    }
    if ("interval".equalsIgnoreCase(paramString))
    {
      this.autoPlayInterval = PTSValueConvertUtil.getInt(paramObject);
      return true;
    }
    if ("duration".equalsIgnoreCase(paramString))
    {
      this.autoPlayDuration = PTSValueConvertUtil.getInt(paramObject);
      return true;
    }
    if ("circular".equalsIgnoreCase(paramString))
    {
      this.circular = PTSValueConvertUtil.getBoolean(paramObject);
      return true;
    }
    if ("pts:indicator-dots-width".equalsIgnoreCase(paramString))
    {
      this.indicatorWidth = PTSValueConvertUtil.getFloat(paramObject);
      return true;
    }
    if ("pts:indicator-dots-height".equalsIgnoreCase(paramString))
    {
      this.indicatorHeight = PTSValueConvertUtil.getFloat(paramObject);
      return true;
    }
    if ("pts:indicator-dots-gap".equalsIgnoreCase(paramString))
    {
      this.indicatorGap = PTSValueConvertUtil.getFloat(paramObject);
      return true;
    }
    if ("pts:indicator-bottom".equalsIgnoreCase(paramString))
    {
      this.indicatorMarginBottom = PTSValueConvertUtil.getFloat(paramObject);
      return true;
    }
    if ("pts:indicator-dots-radius".equalsIgnoreCase(paramString))
    {
      this.indicatorRadius = PTSValueConvertUtil.getFloat(paramObject);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeSwiper
 * JD-Core Version:    0.7.0.1
 */