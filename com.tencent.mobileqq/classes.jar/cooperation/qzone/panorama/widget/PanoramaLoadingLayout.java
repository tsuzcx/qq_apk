package cooperation.qzone.panorama.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bdoo;

public class PanoramaLoadingLayout
  extends RelativeLayout
{
  public static final int a;
  public static boolean a;
  public static final int b;
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PanoramaLoadingBackground jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground;
  private PanoramaLoadingBall jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall;
  private PanoramaLoadingBall b;
  
  static
  {
    jdField_a_of_type_Int = bdoo.b(55.0F);
    jdField_b_of_type_Int = bdoo.b(55.0F);
  }
  
  public PanoramaLoadingLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public PanoramaLoadingLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall != null) && (this.jdField_b_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall != null) && (this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground != null))
    {
      this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall.a(60.0F, 0, this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground);
      this.jdField_b_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall.a(60.0F, 1, this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground);
    }
  }
  
  @SuppressLint({"ResourceType"})
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(jdField_a_of_type_Int, jdField_b_of_type_Int);
    localLayoutParams.addRule(13);
    if (this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground == null)
    {
      this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground = new PanoramaLoadingBackground(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground.setId(1);
      addView(this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground, localLayoutParams);
    }
    if (this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall == null)
    {
      this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall = new PanoramaLoadingBall(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall.setRotationX(60.0F);
      addView(this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall, localLayoutParams);
    }
    if (this.jdField_b_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall == null)
    {
      this.jdField_b_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall = new PanoramaLoadingBall(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall.setRotationY(60.0F);
      addView(this.jdField_b_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall, localLayoutParams);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718395));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(2.0F, 2.0F, 2.0F, -16777216);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(3, this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground.getId());
      localLayoutParams.topMargin = (bdoo.a(10.0F) + jdField_a_of_type_Int / 5);
      addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    }
    if (paramBoolean1) {
      a();
    }
    if (paramBoolean2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall != null)
    {
      this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall.a();
      this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall.setRotationX(60.0F);
    }
    if (this.jdField_b_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall != null)
    {
      this.jdField_b_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall.a();
      this.jdField_b_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall.setRotationY(60.0F);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall != null)
    {
      this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall.a();
      removeView(this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall);
    }
    if (this.jdField_b_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall != null)
    {
      this.jdField_b_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall.a();
      removeView(this.jdField_b_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall);
    }
    if (this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground != null) {
      removeView(this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground);
    }
    this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBackground = null;
    this.jdField_a_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall = null;
    this.jdField_b_of_type_CooperationQzonePanoramaWidgetPanoramaLoadingBall = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaLoadingLayout
 * JD-Core Version:    0.7.0.1
 */