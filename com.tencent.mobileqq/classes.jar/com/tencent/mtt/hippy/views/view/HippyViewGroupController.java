package com.tencent.mtt.hippy.views.view;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.uimanager.HippyGroupController;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.supportui.views.asyncimage.AsyncImageView.ScaleType;
import java.util.WeakHashMap;

@HippyController(name="View")
public class HippyViewGroupController
  extends HippyGroupController<HippyViewGroup>
{
  public static final String CLASS_NAME = "View";
  public static WeakHashMap<View, Integer> mZIndexHash = new WeakHashMap();
  
  public static Integer getViewZIndex(View paramView)
  {
    return (Integer)mZIndexHash.get(paramView);
  }
  
  public static void removeViewZIndex(View paramView)
  {
    mZIndexHash.remove(paramView);
  }
  
  public static void setViewZIndex(View paramView, int paramInt)
  {
    mZIndexHash.put(paramView, Integer.valueOf(paramInt));
  }
  
  public View createViewImpl(Context paramContext)
  {
    return new HippyViewGroup(paramContext);
  }
  
  @HippyControllerProps(defaultString="", defaultType="string", name="backgroundImage")
  public void setBackgroundImage(HippyViewGroup paramHippyViewGroup, String paramString)
  {
    paramHippyViewGroup.setUrl(paramString);
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="backgroundPositionX")
  public void setBackgroundImagePositionX(HippyViewGroup paramHippyViewGroup, int paramInt)
  {
    paramHippyViewGroup.setImagePositionX((int)PixelUtil.dp2px(paramInt));
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="backgroundPositionY")
  public void setBackgroundImagePositionY(HippyViewGroup paramHippyViewGroup, int paramInt)
  {
    paramHippyViewGroup.setImagePositionY((int)PixelUtil.dp2px(paramInt));
  }
  
  @HippyControllerProps(defaultString="origin", defaultType="string", name="backgroundSize")
  public void setBackgroundImageSize(HippyImageView paramHippyImageView, String paramString)
  {
    if ("contain".equals(paramString))
    {
      paramHippyImageView.setScaleType(AsyncImageView.ScaleType.CENTER_INSIDE);
      return;
    }
    if ("cover".equals(paramString))
    {
      paramHippyImageView.setScaleType(AsyncImageView.ScaleType.CENTER_CROP);
      return;
    }
    if ("center".equals(paramString))
    {
      paramHippyImageView.setScaleType(AsyncImageView.ScaleType.CENTER);
      return;
    }
    if ("origin".equals(paramString))
    {
      paramHippyImageView.setScaleType(AsyncImageView.ScaleType.ORIGIN);
      return;
    }
    paramHippyImageView.setScaleType(AsyncImageView.ScaleType.FIT_XY);
  }
  
  @HippyControllerProps(defaultString="visible", defaultType="string", name="overflow")
  public void setOverflow(HippyViewGroup paramHippyViewGroup, String paramString)
  {
    paramHippyViewGroup.setOverflow(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.view.HippyViewGroupController
 * JD-Core Version:    0.7.0.1
 */