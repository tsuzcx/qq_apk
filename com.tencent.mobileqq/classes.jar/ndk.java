import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.avgame.gameroom.stage.guessaction.GuessActionStageView;
import com.tencent.qphone.base.util.QLog;

public class ndk
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ndk(GuessActionStageView paramGuessActionStageView, String paramString) {}
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.jdField_a_of_type_AndroidWidgetTextView.getWidth() - this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.jdField_a_of_type_AndroidWidgetTextView.getPaddingLeft() - this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.jdField_a_of_type_AndroidWidgetTextView.getPaddingRight();
    if (QLog.isColorLevel())
    {
      QLog.d("GuessActionStageView", 2, "onUpdateCurTopic content = " + this.jdField_a_of_type_JavaLangString);
      QLog.d("GuessActionStageView", 2, "onUpdateCurTopic contentWidth  = " + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.jdField_a_of_type_AndroidWidgetTextView.getWidth());
      QLog.d("GuessActionStageView", 2, "onUpdateCurTopic caluWidth  = " + i);
    }
    if (i > 0)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      if (nif.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.jdField_a_of_type_AndroidWidgetTextView) > 1)
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.jdField_a_of_type_Ncy.a().b());
        localLayoutParams = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth();
        localLayoutParams.height = (localLayoutParams.width * 130 / 478);
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.jdField_a_of_type_Ncy.a().a());
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth();
    localLayoutParams.height = (localLayoutParams.width * 110 / 478);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ndk
 * JD-Core Version:    0.7.0.1
 */