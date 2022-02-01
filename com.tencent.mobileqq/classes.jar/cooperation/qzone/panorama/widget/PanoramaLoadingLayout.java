package cooperation.qzone.panorama.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;

public class PanoramaLoadingLayout
  extends RelativeLayout
{
  public static final int ANIMATION_TIME = 300;
  public static final int HEIGHT = ViewUtils.dpToPx(55.0F);
  private static final String TAG = "PanoramaLoadingLayout";
  public static final int WIDTH = ViewUtils.dpToPx(55.0F);
  public static boolean isPanoramaLoading = false;
  private Context context;
  private PanoramaLoadingBall horizontalPanoramaLoadingBall;
  private PanoramaLoadingBackground panoramaLoadingBackground;
  private TextView tvToast;
  private PanoramaLoadingBall verticalPanoramaLoadingBall;
  
  public PanoramaLoadingLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
  }
  
  public PanoramaLoadingLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public void onRecycled()
  {
    Object localObject = this.horizontalPanoramaLoadingBall;
    if (localObject != null)
    {
      ((PanoramaLoadingBall)localObject).stopTimer();
      removeView(this.horizontalPanoramaLoadingBall);
    }
    localObject = this.verticalPanoramaLoadingBall;
    if (localObject != null)
    {
      ((PanoramaLoadingBall)localObject).stopTimer();
      removeView(this.verticalPanoramaLoadingBall);
    }
    localObject = this.panoramaLoadingBackground;
    if (localObject != null) {
      removeView((View)localObject);
    }
    this.panoramaLoadingBackground = null;
    this.horizontalPanoramaLoadingBall = null;
    this.verticalPanoramaLoadingBall = null;
  }
  
  @SuppressLint({"ResourceType"})
  public void showLoading(boolean paramBoolean1, boolean paramBoolean2)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(WIDTH, HEIGHT);
    localLayoutParams.addRule(13);
    if (this.panoramaLoadingBackground == null)
    {
      this.panoramaLoadingBackground = new PanoramaLoadingBackground(this.context);
      this.panoramaLoadingBackground.setId(1);
      addView(this.panoramaLoadingBackground, localLayoutParams);
    }
    if (this.horizontalPanoramaLoadingBall == null)
    {
      this.horizontalPanoramaLoadingBall = new PanoramaLoadingBall(this.context);
      this.horizontalPanoramaLoadingBall.setRotationX(60.0F);
      addView(this.horizontalPanoramaLoadingBall, localLayoutParams);
    }
    if (this.verticalPanoramaLoadingBall == null)
    {
      this.verticalPanoramaLoadingBall = new PanoramaLoadingBall(this.context);
      this.verticalPanoramaLoadingBall.setRotationY(60.0F);
      addView(this.verticalPanoramaLoadingBall, localLayoutParams);
    }
    if (this.tvToast == null)
    {
      this.tvToast = new TextView(this.context);
      this.tvToast.setText(this.context.getResources().getString(2131914891));
      this.tvToast.setTextColor(-1);
      this.tvToast.setTextSize(14.0F);
      this.tvToast.setShadowLayer(2.0F, 2.0F, 2.0F, -16777216);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(3, this.panoramaLoadingBackground.getId());
      localLayoutParams.topMargin = (ViewUtils.dip2px(10.0F) + WIDTH / 5);
      addView(this.tvToast, localLayoutParams);
    }
    if (paramBoolean1) {
      startRotateAnimate();
    }
    if (paramBoolean2)
    {
      this.tvToast.setVisibility(0);
      return;
    }
    this.tvToast.setVisibility(8);
  }
  
  public void startRotateAnimate()
  {
    PanoramaLoadingBall localPanoramaLoadingBall = this.horizontalPanoramaLoadingBall;
    if ((localPanoramaLoadingBall != null) && (this.verticalPanoramaLoadingBall != null))
    {
      PanoramaLoadingBackground localPanoramaLoadingBackground = this.panoramaLoadingBackground;
      if (localPanoramaLoadingBackground != null)
      {
        localPanoramaLoadingBall.startRotate(60.0F, 0, localPanoramaLoadingBackground);
        this.verticalPanoramaLoadingBall.startRotate(60.0F, 1, this.panoramaLoadingBackground);
      }
    }
  }
  
  public void stopRotateAnimate()
  {
    PanoramaLoadingBall localPanoramaLoadingBall = this.horizontalPanoramaLoadingBall;
    if (localPanoramaLoadingBall != null)
    {
      localPanoramaLoadingBall.stopTimer();
      this.horizontalPanoramaLoadingBall.setRotationX(60.0F);
    }
    localPanoramaLoadingBall = this.verticalPanoramaLoadingBall;
    if (localPanoramaLoadingBall != null)
    {
      localPanoramaLoadingBall.stopTimer();
      this.verticalPanoramaLoadingBall.setRotationY(60.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaLoadingLayout
 * JD-Core Version:    0.7.0.1
 */