import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.widget.QQMapView;

public class mze
  implements Animation.AnimationListener
{
  public mze(PoiMapActivity paramPoiMapActivity, TranslateAnimation paramTranslateAnimation1, Dialog paramDialog, int paramInt, TranslateAnimation paramTranslateAnimation2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity).getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams2 = PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity).getLayoutParams();
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation)
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      localLayoutParams.height = (this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.getHeight() + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a(this.jdField_a_of_type_Int / 2, true);
    }
    for (;;)
    {
      localLayoutParams1.height = -1;
      localLayoutParams2.height = -1;
      PoiMapActivity.b(this.jdField_a_of_type_ComTencentBizPoiMapActivity).setLayoutParams(localLayoutParams2);
      PoiMapActivity.b(this.jdField_a_of_type_ComTencentBizPoiMapActivity).setLayoutParams(localLayoutParams1);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.setLayoutParams(localLayoutParams);
      PoiMapActivity.c(this.jdField_a_of_type_ComTencentBizPoiMapActivity).setEnabled(true);
      if ((this.jdField_a_of_type_ComTencentBizPoiMapActivity.h) && (paramAnimation == this.b)) {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity.i();
      }
      return;
      if (paramAnimation == this.b)
      {
        localLayoutParams.height = (this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.getHeight() - this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentBizPoiMapActivity.a(-this.jdField_a_of_type_Int / 2, true);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mze
 * JD-Core Version:    0.7.0.1
 */