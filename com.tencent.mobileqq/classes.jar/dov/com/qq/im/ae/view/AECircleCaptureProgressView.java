package dov.com.qq.im.ae.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import bmcd;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;

public class AECircleCaptureProgressView
  extends FrameLayout
{
  private int jdField_a_of_type_Int = AIOUtils.dp2px(98.0F, getResources());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private AnimationQIMCircleProgress jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress;
  @NonNull
  private final float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 1.0F };
  private int jdField_b_of_type_Int = AIOUtils.dp2px(98.0F, getResources());
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  @NonNull
  private float[] jdField_b_of_type_ArrayOfFloat = { 0.0F, 1.0F };
  
  public AECircleCaptureProgressView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AECircleCaptureProgressView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AECircleCaptureProgressView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private float a(float paramFloat, @NonNull float[] paramArrayOfFloat)
  {
    return paramArrayOfFloat[0] + (paramArrayOfFloat[1] - paramArrayOfFloat[0]) * paramFloat;
  }
  
  private void a(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(paramContext).inflate(2131558484, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369243));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369294));
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress = ((AnimationQIMCircleProgress)findViewById(2131362879));
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress != null) {
      return this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a();
    }
    return 0;
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.getLayoutParams();
    localLayoutParams.width = ((int)(this.jdField_b_of_type_Int * paramFloat));
    localLayoutParams.height = ((int)(this.jdField_b_of_type_Int * paramFloat));
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setAlpha(a(bmcd.a(paramFloat), this.jdField_b_of_type_ArrayOfFloat));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress != null) {
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress != null) {
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, @NonNull bmcd parambmcd)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(parambmcd.jdField_a_of_type_Int);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(parambmcd.d);
    }
    this.jdField_b_of_type_ArrayOfFloat = parambmcd.jdField_a_of_type_ArrayOfFloat;
    if (this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress != null)
    {
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.a(paramBoolean, parambmcd);
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setAlpha(this.jdField_b_of_type_ArrayOfFloat[0]);
    }
  }
  
  public void setCenterScaleValue(float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = ((int)(this.jdField_a_of_type_Int * paramFloat));
    localLayoutParams.height = ((int)(this.jdField_a_of_type_Int * paramFloat));
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    paramFloat = a(bmcd.b(paramFloat), this.jdField_a_of_type_ArrayOfFloat);
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(paramFloat);
    this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F - paramFloat);
  }
  
  public void setCenterView()
  {
    if (this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress != null) {
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setCenterView();
    }
  }
  
  public void setProgress(float paramFloat)
  {
    if (this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress != null) {
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setProgress(paramFloat);
    }
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    if (this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress != null) {
      this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress.setStrokeWidth(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.view.AECircleCaptureProgressView
 * JD-Core Version:    0.7.0.1
 */