package com.tencent.mtt.hippy.views.image;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.ImageNode;
import com.tencent.mtt.hippy.dom.node.StyleNode;
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
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.startsWith("hpfile://"))
      {
        paramString = paramString.replace("hpfile://./", "");
        if (paramHippyInstanceContext.getBundleLoader() != null) {
          paramHippyInstanceContext = paramHippyInstanceContext.getBundleLoader().getPath();
        } else {
          paramHippyInstanceContext = null;
        }
        if (paramHippyInstanceContext == null) {
          return null;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramHippyInstanceContext.subSequence(0, paramHippyInstanceContext.lastIndexOf(File.separator) + 1));
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  protected StyleNode createNode(boolean paramBoolean)
  {
    return new ImageNode(paramBoolean);
  }
  
  protected View createViewImpl(Context paramContext)
  {
    return new HippyImageView(paramContext);
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    paramContext = new HippyImageView(paramContext);
    if (paramHippyMap != null) {
      paramContext.setInitProps(paramHippyMap);
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
  
  @HippyControllerProps(defaultType="string", name="defaultSource")
  public void setDefaultSource(HippyImageView paramHippyImageView, String paramString)
  {
    paramHippyImageView.setHippyViewDefaultSource(getInnerPath((HippyInstanceContext)paramHippyImageView.getContext(), paramString));
  }
  
  @HippyControllerProps(defaultType="string", name="imageType")
  public void setImageType(HippyImageView paramHippyImageView, String paramString)
  {
    paramHippyImageView.setImageType(paramString);
  }
  
  @HippyControllerProps(defaultType="boolean", name="onError")
  public void setOnError(HippyImageView paramHippyImageView, boolean paramBoolean)
  {
    paramHippyImageView.setImageEventEnable(HippyImageView.ImageEvent.ONERROR.ordinal(), paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="onLoad")
  public void setOnLoad(HippyImageView paramHippyImageView, boolean paramBoolean)
  {
    paramHippyImageView.setImageEventEnable(HippyImageView.ImageEvent.ONLOAD.ordinal(), paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="onLoadEnd")
  public void setOnLoadEnd(HippyImageView paramHippyImageView, boolean paramBoolean)
  {
    paramHippyImageView.setImageEventEnable(HippyImageView.ImageEvent.ONLOAD_END.ordinal(), paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="onLoadStart")
  public void setOnLoadStart(HippyImageView paramHippyImageView, boolean paramBoolean)
  {
    paramHippyImageView.setImageEventEnable(HippyImageView.ImageEvent.ONLOAD_START.ordinal(), paramBoolean);
  }
  
  @HippyControllerProps(defaultString="fitXY", defaultType="string", name="resizeMode")
  public void setResizeMode(HippyImageView paramHippyImageView, String paramString)
  {
    if ("contain".equals(paramString)) {
      paramString = AsyncImageView.ScaleType.CENTER_INSIDE;
    }
    for (;;)
    {
      paramHippyImageView.setScaleType(paramString);
      return;
      if ("cover".equals(paramString)) {
        paramString = AsyncImageView.ScaleType.CENTER_CROP;
      } else if ("center".equals(paramString)) {
        paramString = AsyncImageView.ScaleType.CENTER;
      } else if ("origin".equals(paramString)) {
        paramString = AsyncImageView.ScaleType.ORIGIN;
      } else if ("repeat".equals(paramString)) {
        paramString = AsyncImageView.ScaleType.REPEAT;
      } else {
        paramString = AsyncImageView.ScaleType.FIT_XY;
      }
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="tintColor")
  public void setTintColor(HippyImageView paramHippyImageView, int paramInt)
  {
    paramHippyImageView.setTintColor(paramInt);
  }
  
  @HippyControllerProps(defaultType="string", name="src")
  public void setUrl(HippyImageView paramHippyImageView, String paramString)
  {
    paramHippyImageView.setUrl(getInnerPath((HippyInstanceContext)paramHippyImageView.getContext(), paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.image.HippyImageViewController
 * JD-Core Version:    0.7.0.1
 */