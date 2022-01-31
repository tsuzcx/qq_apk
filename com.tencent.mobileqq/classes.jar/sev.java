import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;

class sev
  implements Animator.AnimatorListener
{
  sev(set paramset, String paramString) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    set.a(this.jdField_a_of_type_Set).setText(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Set.a.title);
    set.b(this.jdField_a_of_type_Set).setText(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Set.a.title);
    set.a(this.jdField_a_of_type_Set).setVisibility(8);
    set.b(this.jdField_a_of_type_Set).setVisibility(0);
    set.a(this.jdField_a_of_type_Set).setTranslationY(Utils.dp2px(43.0D));
    set.b(this.jdField_a_of_type_Set).setTranslationY(0.0F);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sev
 * JD-Core Version:    0.7.0.1
 */