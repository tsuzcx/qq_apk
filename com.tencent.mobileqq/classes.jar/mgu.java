import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.ViewHolder;
import java.util.ArrayList;

class mgu
  implements Animation.AnimationListener
{
  mgu(mgt parammgt, ArrayList paramArrayList, Object paramObject) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Mgt.a.f.post(new mgv(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mgu
 * JD-Core Version:    0.7.0.1
 */