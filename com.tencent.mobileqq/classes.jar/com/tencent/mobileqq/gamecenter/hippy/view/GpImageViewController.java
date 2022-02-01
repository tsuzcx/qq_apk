package com.tencent.mobileqq.gamecenter.hippy.view;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.gamecenter.view.ImgHeaderView;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.qphone.base.util.QLog;

@HippyController(name="gpImageView")
public class GpImageViewController
  extends HippyViewController<ImgHeaderView>
{
  public static final String CLASS_NAME = "gpImageView";
  private static final String TAG = "GpImageViewController";
  public ImgHeaderView imgHeaderView;
  private int mHippyEngineId = -2147483648;
  
  public View createView(HippyRootView paramHippyRootView, int paramInt, HippyEngineContext paramHippyEngineContext, String paramString, HippyMap paramHippyMap)
  {
    if (paramHippyEngineContext != null) {
      this.mHippyEngineId = paramHippyEngineContext.getEngineId();
    }
    return super.createView(paramHippyRootView, paramInt, paramHippyEngineContext, paramString, paramHippyMap);
  }
  
  protected View createViewImpl(Context paramContext)
  {
    return null;
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    return new ImgHeaderView(paramContext);
  }
  
  public void dispatchFunction(ImgHeaderView paramImgHeaderView, String paramString, HippyArray paramHippyArray)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GpImageViewController dispatchFunction: ");
      localStringBuilder.append(paramString);
      QLog.d("GpImageViewController", 1, localStringBuilder.toString());
    }
    if ("init".equals(paramString))
    {
      paramImgHeaderView.a(paramHippyArray);
      paramImgHeaderView.d();
    }
    else if ("destory".equals(paramString))
    {
      paramImgHeaderView.c();
    }
    super.dispatchFunction(paramImgHeaderView, paramString, paramHippyArray);
  }
  
  public void onAfterUpdateProps(ImgHeaderView paramImgHeaderView)
  {
    paramImgHeaderView.e();
  }
  
  public void onViewDestroy(ImgHeaderView paramImgHeaderView)
  {
    if (paramImgHeaderView != null) {
      paramImgHeaderView.c();
    }
  }
  
  @HippyControllerProps(defaultType="map", name="src")
  public void setSrc(ImgHeaderView paramImgHeaderView, HippyMap paramHippyMap)
  {
    paramImgHeaderView.setSrc(paramHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.view.GpImageViewController
 * JD-Core Version:    0.7.0.1
 */