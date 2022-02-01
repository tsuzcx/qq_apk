import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.avgame.gameroom.stage.guessstar.GuessStarStageView;
import com.tencent.qphone.base.util.QLog;

public class nlt
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public nlt(GuessStarStageView paramGuessStarStageView, String paramString) {}
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.jdField_a_of_type_AndroidWidgetTextView.getWidth() - this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.jdField_a_of_type_AndroidWidgetTextView.getPaddingLeft() - this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.jdField_a_of_type_AndroidWidgetTextView.getPaddingRight();
    if (QLog.isColorLevel())
    {
      QLog.d("GuessStarStageView", 2, "showTopicTips tip = " + this.jdField_a_of_type_JavaLangString);
      QLog.d("GuessStarStageView", 2, "showTopicTips tipWidth  = " + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.jdField_a_of_type_AndroidWidgetTextView.getWidth());
      QLog.d("GuessStarStageView", 2, "showTopicTips caluWidth  = " + i);
    }
    ViewGroup.LayoutParams localLayoutParams;
    if (i > 0)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      if (nqu.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.jdField_a_of_type_AndroidWidgetTextView) <= 1) {
        break label284;
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.jdField_a_of_type_Nkv.a().b());
      localLayoutParams = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localLayoutParams.width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth();
      localLayoutParams.height = (localLayoutParams.width * 130 / 478);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.d("GuessStarStageView", 2, "showTopicTips 130 w = " + localLayoutParams.width + ", h = " + localLayoutParams.height);
      }
    }
    label284:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.jdField_a_of_type_Nkv.a().a());
      localLayoutParams = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localLayoutParams.width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth();
      localLayoutParams.height = (localLayoutParams.width * 110 / 478);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    } while (!QLog.isColorLevel());
    QLog.d("GuessStarStageView", 2, "showTopicTips 110 w = " + localLayoutParams.width + ", h = " + localLayoutParams.height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nlt
 * JD-Core Version:    0.7.0.1
 */