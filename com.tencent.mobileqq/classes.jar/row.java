import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;

class row
  implements Animator.AnimatorListener
{
  row(rou paramrou, String paramString) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    rou.a(this.jdField_a_of_type_Rou).setText(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Rou.a.title);
    rou.b(this.jdField_a_of_type_Rou).setText(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Rou.a.title);
    rou.a(this.jdField_a_of_type_Rou).setVisibility(8);
    rou.b(this.jdField_a_of_type_Rou).setVisibility(0);
    rou.a(this.jdField_a_of_type_Rou).setTranslationY(Utils.dp2px(43.0D));
    rou.b(this.jdField_a_of_type_Rou).setTranslationY(0.0F);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     row
 * JD-Core Version:    0.7.0.1
 */