import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.lebasearch.widget.ScrolledTabHost;

public class nfy
  implements Animation.AnimationListener
{
  public nfy(ScrolledTabHost paramScrolledTabHost, View paramView1, View paramView2, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.b.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost.a(this.jdField_a_of_type_Int);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nfy
 * JD-Core Version:    0.7.0.1
 */