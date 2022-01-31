import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.utils.UITools;
import com.tencent.qphone.base.util.QLog;

public class kab
  extends AnimatorListenerAdapter
{
  public kab(QavPanel paramQavPanel, String paramString, int paramInt1, int paramInt2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    QavPanel.a(this.jdField_a_of_type_ComTencentAvUiQavPanel);
    if ((this.jdField_a_of_type_ComTencentAvUiQavPanel.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = QavPanel.a(this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b);
      float f = UITools.a(this.jdField_a_of_type_ComTencentAvUiQavPanel.getContext(), -10.0F);
      paramAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiQavPanel.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView, "translationY", new float[] { 0.0F, f });
      paramAnimator.setDuration(500L);
      paramAnimator.start();
    }
    if (QLog.isColorLevel()) {
      QLog.e("QavPanel", 2, "showEffectOperateAnimation onAnimationEnd");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.jdField_d_of_type_Boolean = true;
    paramAnimator = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvUiQavPanel.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
    if (paramAnimator != null) {
      paramAnimator.c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kab
 * JD-Core Version:    0.7.0.1
 */