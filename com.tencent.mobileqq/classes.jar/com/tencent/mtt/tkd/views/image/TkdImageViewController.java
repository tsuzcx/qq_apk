package com.tencent.mtt.tkd.views.image;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.image.HippyImageViewController;

@HippyController(name="tkdImage")
public class TkdImageViewController
  extends HippyImageViewController
{
  public static final String CLASS_NAME = "tkdImage";
  
  public View createViewImpl(Context paramContext)
  {
    return new TkdImageView(paramContext);
  }
  
  public View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    paramContext = new TkdImageView(paramContext);
    if (paramHippyMap != null) {
      paramContext.setIniProps(paramHippyMap);
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.tkd.views.image.TkdImageViewController
 * JD-Core Version:    0.7.0.1
 */