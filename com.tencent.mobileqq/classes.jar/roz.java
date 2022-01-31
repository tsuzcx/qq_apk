import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;

class roz
  implements Animator.AnimatorListener
{
  roz(rox paramrox, String paramString) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    rox.a(this.jdField_a_of_type_Rox).setText(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Rox.a.title);
    rox.b(this.jdField_a_of_type_Rox).setText(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Rox.a.title);
    rox.a(this.jdField_a_of_type_Rox).setVisibility(8);
    rox.b(this.jdField_a_of_type_Rox).setVisibility(0);
    rox.a(this.jdField_a_of_type_Rox).setTranslationY(Utils.dp2px(43.0D));
    rox.b(this.jdField_a_of_type_Rox).setTranslationY(0.0F);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     roz
 * JD-Core Version:    0.7.0.1
 */