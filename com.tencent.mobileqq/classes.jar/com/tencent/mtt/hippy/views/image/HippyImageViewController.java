package com.tencent.mtt.hippy.views.image;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.supportui.views.asyncimage.AsyncImageView.ScaleType;
import java.io.File;

@HippyController(name="Image")
public class HippyImageViewController
  extends HippyViewController<HippyImageView>
{
  public static final String CLASS_NAME = "Image";
  
  private static String getInnerPath(HippyInstanceContext paramHippyInstanceContext, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = paramString;
    if (paramString != null)
    {
      localObject1 = paramString;
      if (paramString.startsWith("hpfile://"))
      {
        paramString = paramString.replace("hpfile://./", "");
        if (paramHippyInstanceContext.getBundleLoader() == null) {
          break label90;
        }
      }
    }
    label90:
    for (paramHippyInstanceContext = paramHippyInstanceContext.getBundleLoader().getPath();; paramHippyInstanceContext = null)
    {
      if (paramHippyInstanceContext == null) {}
      for (paramHippyInstanceContext = localObject2;; paramHippyInstanceContext = paramHippyInstanceContext.subSequence(0, paramHippyInstanceContext.lastIndexOf(File.separator) + 1) + paramString)
      {
        localObject1 = paramHippyInstanceContext;
        return localObject1;
      }
    }
  }
  
  public View createViewImpl(Context paramContext)
  {
    return new HippyImageView(paramContext);
  }
  
  public View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    paramContext = new HippyImageView(paramContext);
    if (paramHippyMap != null) {
      paramContext.setIniProps(paramHippyMap);
    }
    return paramContext;
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="backgroundColor")
  public void setBackgroundColor(HippyImageView paramHippyImageView, int paramInt)
  {
    paramHippyImageView.setBackgroundColor(paramInt);
  }
  
  @HippyControllerProps(defaultType="map", name="capInsets")
  public void setCapInsets(HippyImageView paramHippyImageView, HippyMap paramHippyMap)
  {
    if (paramHippyMap == null)
    {
      paramHippyImageView.setNinePatchCoordinate(true, 0, 0, 0, 0);
      return;
    }
    int i = paramHippyMap.getInt("top");
    int j = paramHippyMap.getInt("left");
    int k = paramHippyMap.getInt("bottom");
    paramHippyImageView.setNinePatchCoordinate(false, j, i, paramHippyMap.getInt("right"), k);
  }
  
  @HippyControllerProps(defaultString="", defaultType="string", name="defaultSource")
  public void setDefaultSource(HippyImageView paramHippyImageView, String paramString)
  {
    paramHippyImageView.setHippyViewDefaultSource(getInnerPath((HippyInstanceContext)paramHippyImageView.getContext(), paramString));
  }
  
  @HippyControllerProps(defaultString="", defaultType="string", name="imageType")
  public void setImageType(HippyImageView paramHippyImageView, String paramString)
  {
    paramHippyImageView.setImageType(paramString);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onError")
  public void setOnError(HippyImageView paramHippyImageView, boolean paramBoolean)
  {
    paramHippyImageView.setImageEventEnable(HippyImageView.ImageEvent.ONERROR.ordinal(), paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onLoad")
  public void setOnLoad(HippyImageView paramHippyImageView, boolean paramBoolean)
  {
    paramHippyImageView.setImageEventEnable(HippyImageView.ImageEvent.ONLOAD.ordinal(), paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onLoadEnd")
  public void setOnLoadEnd(HippyImageView paramHippyImageView, boolean paramBoolean)
  {
    paramHippyImageView.setImageEventEnable(HippyImageView.ImageEvent.ONLOAD_END.ordinal(), paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onLoadStart")
  public void setOnLoadStart(HippyImageView paramHippyImageView, boolean paramBoolean)
  {
    paramHippyImageView.setImageEventEnable(HippyImageView.ImageEvent.ONLOAD_START.ordinal(), paramBoolean);
  }
  
  @HippyControllerProps(defaultNumber=-1.0D, defaultType="number", name="repeatCount")
  public void setRepeatCount(HippyImageView paramHippyImageView, int paramInt)
  {
    paramHippyImageView.setRepeatCount(paramInt);
  }
  
  @HippyControllerProps(defaultString="fitXY", defaultType="string", name="resizeMode")
  public void setResizeMode(HippyImageView paramHippyImageView, String paramString)
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
    if ("repeat".equals(paramString))
    {
      paramHippyImageView.setScaleType(AsyncImageView.ScaleType.REPEAT);
      return;
    }
    paramHippyImageView.setScaleType(AsyncImageView.ScaleType.FIT_XY);
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="tintColor")
  public void setTintColor(HippyImageView paramHippyImageView, int paramInt)
  {
    paramHippyImageView.setTintColor(paramInt);
  }
  
  @HippyControllerProps(defaultString="", defaultType="string", name="src")
  public void setUrl(HippyImageView paramHippyImageView, String paramString)
  {
    paramHippyImageView.setUrl(getInnerPath((HippyInstanceContext)paramHippyImageView.getContext(), paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.image.HippyImageViewController
 * JD-Core Version:    0.7.0.1
 */