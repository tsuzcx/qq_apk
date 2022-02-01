import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.av.wtogether.fragment.AVGroupFileSelectFragment;
import com.tencent.av.wtogether.view.QBaseContentView;

public class mzc
  implements DialogInterface.OnDismissListener
{
  public mzc(AVGroupFileSelectFragment paramAVGroupFileSelectFragment, int paramInt, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AVGroupFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVGroupFileSelectFragment).offsetTopAndBottom(-this.jdField_a_of_type_Int);
    AVGroupFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVGroupFileSelectFragment).setVisibility(0);
    AVGroupFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVGroupFileSelectFragment).startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    AVGroupFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVGroupFileSelectFragment, null);
    AVGroupFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVGroupFileSelectFragment).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mzc
 * JD-Core Version:    0.7.0.1
 */