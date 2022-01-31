import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.qphone.base.util.BaseApplication;

public class tgj
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private View jdField_b_of_type_AndroidViewView;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private AnimationSet jdField_b_of_type_AndroidViewAnimationAnimationSet;
  private Animation c;
  private Animation d;
  private Animation e;
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewView == null)) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setSelected(true);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null) {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(BaseApplication.getContext(), 2130772173);
      }
      if (this.c == null)
      {
        this.c = AnimationUtils.loadAnimation(BaseApplication.getContext(), 2130772175);
        this.c.setStartOffset(40L);
      }
      if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(BaseApplication.getContext(), 2130772174);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setStartOffset(250L);
      }
      if (this.d == null)
      {
        this.d = AnimationUtils.loadAnimation(BaseApplication.getContext(), 2130772176);
        this.d.setStartOffset(290L);
      }
      if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
        this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.c);
      }
      if (this.jdField_b_of_type_AndroidViewAnimationAnimationSet == null)
      {
        this.jdField_b_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
        this.jdField_b_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        this.jdField_b_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.d);
      }
      this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimationSet);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setSelected(false);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    if (this.e == null) {
      this.e = AnimationUtils.loadAnimation(BaseApplication.getContext(), 2130772177);
    }
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.e);
  }
  
  public stSimpleMetaFeed a()
  {
    return this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.cancel();
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = null;
    }
    if (this.jdField_b_of_type_AndroidViewAnimationAnimationSet != null)
    {
      this.jdField_b_of_type_AndroidViewAnimationAnimationSet.cancel();
      this.jdField_b_of_type_AndroidViewAnimationAnimationSet = null;
    }
    if (this.e != null)
    {
      this.e.cancel();
      this.e = null;
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, View paramView1, View paramView2, TextView paramTextView, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_b_of_type_AndroidViewView = paramView2;
    a(paramBoolean, paramInt);
    a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setSelected(paramBoolean);
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (paramInt > 0) {
        rdm.a(this.jdField_a_of_type_AndroidWidgetTextView, paramInt, "0");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131691286));
  }
  
  public View b()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tgj
 * JD-Core Version:    0.7.0.1
 */