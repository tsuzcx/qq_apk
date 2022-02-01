package com.tencent.mobileqq.vas.hippy.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.qphone.base.util.QLog;

@HippyController(name="LottieView")
public class HippyLottieViewController
  extends HippyViewController<HippyLottieView>
{
  public static final String CLASS_NAME = "LottieView";
  private static final String TAG = "HippyLottieViewController";
  
  protected View createViewImpl(Context paramContext)
  {
    return null;
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    paramContext = new HippyLottieView(paramContext);
    paramContext.a(paramHippyMap);
    return paramContext;
  }
  
  public void dispatchFunction(HippyLottieView paramHippyLottieView, String paramString, HippyArray paramHippyArray)
  {
    if ("play".equals(paramString)) {
      paramHippyLottieView.c();
    } else if ("resume".equals(paramString)) {
      paramHippyLottieView.d();
    } else if ("pause".equals(paramString)) {
      paramHippyLottieView.e();
    }
    super.dispatchFunction(paramHippyLottieView, paramString, paramHippyArray);
  }
  
  public void onAfterUpdateProps(HippyLottieView paramHippyLottieView)
  {
    paramHippyLottieView.f();
  }
  
  public void onViewDestroy(HippyLottieView paramHippyLottieView)
  {
    QLog.d("HippyLottieViewController", 1, "onViewDestroy");
    super.onViewDestroy(paramHippyLottieView);
    if (paramHippyLottieView != null) {
      paramHippyLottieView.b();
    }
  }
  
  @HippyControllerProps(defaultType="number", name="endFrame")
  public void setEndFrame(HippyLottieView paramHippyLottieView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HippyLottieViewController", 1, "setEndFrame call");
    }
    paramHippyLottieView.setEndFrame(paramInt);
  }
  
  @HippyControllerProps(defaultType="boolean", name="isFitFullXY")
  public void setIsFitFullXY(HippyLottieView paramHippyLottieView, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HippyLottieViewController", 1, "setIsFitFullXY call");
    }
    if (paramBoolean) {
      paramHippyLottieView.setFitFullScreenXY();
    }
  }
  
  @HippyControllerProps(defaultType="number", name="repeatCount")
  public void setRepeatCount(HippyLottieView paramHippyLottieView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HippyLottieViewController", 1, "setRepeatCount call");
    }
    paramHippyLottieView.setRepeatCount(paramInt);
  }
  
  @HippyControllerProps(defaultType="number", name="speed")
  public void setSpeed(HippyLottieView paramHippyLottieView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HippyLottieViewController", 1, "setSpeed call");
    }
    paramHippyLottieView.setSpeed(paramInt);
  }
  
  @HippyControllerProps(defaultType="string", name="src")
  public void setSrc(HippyLottieView paramHippyLottieView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HippyLottieViewController", 1, "setSrc call");
    }
    paramHippyLottieView.setSrc(paramString);
  }
  
  @HippyControllerProps(defaultType="number", name="startFrame")
  public void setStartFrame(HippyLottieView paramHippyLottieView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HippyLottieViewController", 1, "setStartFrame call");
    }
    paramHippyLottieView.setStartFrame(paramInt);
  }
  
  @HippyControllerProps(defaultType="string", name="zipSrc")
  public void setZipSrc(HippyLottieView paramHippyLottieView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HippyLottieViewController", 1, "setZipSrc call");
    }
    if (!TextUtils.isEmpty(paramString)) {
      paramHippyLottieView.setZipSrc(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.HippyLottieViewController
 * JD-Core Version:    0.7.0.1
 */