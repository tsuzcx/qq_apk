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
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return false;
      case 0: 
        ((PTSSwiperView)getView()).setIndicatorVisible(PTSValueConvertUtil.getBoolean(paramObject));
        return true;
        if (paramString.equals("indicator-dots"))
        {
          i = 0;
          continue;
          if (paramString.equals("indicator-color"))
          {
            i = 1;
            continue;
            if (paramString.equals("indicator-active-color"))
            {
              i = 2;
              continue;
              if (paramString.equals("autoplay"))
              {
                i = 3;
                continue;
                if (paramString.equals("interval"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("duration"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("circular"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("pts:indicator-width"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("pts:indicator-height"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("pts:indicator-gap"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("pts:indicator-bottom"))
                            {
                              i = 10;
                              continue;
                              if (paramString.equals("pts:indicator-radius")) {
                                i = 11;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    ((PTSSwiperView)getView()).setIndicatorNormalColor(PTSValueConvertUtil.getColor(paramObject));
    return true;
    ((PTSSwiperView)getView()).setIndicatorFocusedColor(PTSValueConvertUtil.getColor(paramObject));
    return true;
    ((PTSSwiperView)getView()).setAutoPlay(PTSValueConvertUtil.getBoolean(paramObject));
    return true;
    ((PTSSwiperView)getView()).setAutoPlayInterval(PTSValueConvertUtil.getInt(paramObject));
    return true;
    ((PTSSwiperView)getView()).setAutoPlayDuration(PTSValueConvertUtil.getInt(paramObject));
    return true;
    ((PTSSwiperView)getView()).setCircularAutoPlay(PTSValueConvertUtil.getBoolean(paramObject));
    return true;
    ((PTSSwiperView)getView()).setIndicatorWidth(PTSValueConvertUtil.getFloat(paramObject));
    return true;
    ((PTSSwiperView)getView()).setIndicatorHeight(PTSValueConvertUtil.getFloat(paramObject));
    return true;
    ((PTSSwiperView)getView()).setIndicatorGap(PTSValueConvertUtil.getFloat(paramObject));
    return true;
    ((PTSSwiperView)getView()).setIndicatorMarginBottom(PTSValueConvertUtil.getFloat(paramObject));
    return true;
    ((PTSSwiperView)getView()).setIndicatorRadius(PTSValueConvertUtil.getFloat(paramObject));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeSwiper
 * JD-Core Version:    0.7.0.1
 */