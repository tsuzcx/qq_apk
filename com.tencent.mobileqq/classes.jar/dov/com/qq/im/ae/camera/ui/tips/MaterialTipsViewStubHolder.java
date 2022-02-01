package dov.com.qq.im.ae.camera.ui.tips;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import dov.com.qq.im.ae.camera.ui.BaseViewStubHolder;

public class MaterialTipsViewStubHolder
  extends BaseViewStubHolder
{
  private View jdField_a_of_type_AndroidViewView;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new MaterialTipsViewStubHolder.1(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public MaterialTipsViewStubHolder(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131372366);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372367));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372365));
  }
  
  public void a(String paramString, Bitmap paramBitmap, int paramInt)
  {
    a();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.reset();
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      paramString = this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
      if (paramInt <= 0) {
        break label133;
      }
    }
    label133:
    for (long l = paramInt;; l = 3000L)
    {
      paramString.setStartOffset(l);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(200L);
      this.jdField_a_of_type_AndroidViewView.setAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.startNow();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
    }
  }
  
  public void b()
  {
    if (!a()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(null);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.cancel();
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.tips.MaterialTipsViewStubHolder
 * JD-Core Version:    0.7.0.1
 */