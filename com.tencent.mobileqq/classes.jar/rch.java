import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;

class rch
  implements Animator.AnimatorListener
{
  rch(rcf paramrcf, String paramString) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    rcf.a(this.jdField_a_of_type_Rcf).setText(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Rcf.a.title);
    rcf.b(this.jdField_a_of_type_Rcf).setText(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Rcf.a.title);
    rcf.a(this.jdField_a_of_type_Rcf).setVisibility(8);
    rcf.b(this.jdField_a_of_type_Rcf).setVisibility(0);
    rcf.a(this.jdField_a_of_type_Rcf).setTranslationY(Utils.dp2px(43.0D));
    rcf.b(this.jdField_a_of_type_Rcf).setTranslationY(0.0F);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rch
 * JD-Core Version:    0.7.0.1
 */