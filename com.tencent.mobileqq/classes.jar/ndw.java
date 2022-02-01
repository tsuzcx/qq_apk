import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.avgame.gameroom.stage.guesstext.GuessTextStageView;
import com.tencent.qphone.base.util.QLog;

public class ndw
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ndw(GuessTextStageView paramGuessTextStageView, String paramString) {}
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.b.getWidth() - this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.b.getPaddingLeft() - this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.b.getPaddingRight();
    if (QLog.isColorLevel())
    {
      QLog.d("GuessTextStageView", 2, "onShowGameTopicTips tip = " + this.jdField_a_of_type_JavaLangString);
      QLog.d("GuessTextStageView", 2, "onShowGameTopicTips tipWidth  = " + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.b.getWidth());
      QLog.d("GuessTextStageView", 2, "onShowGameTopicTips caluWidth  = " + i);
    }
    ViewGroup.LayoutParams localLayoutParams;
    if (i > 0)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      if (nif.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.b) <= 1) {
        break label282;
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.jdField_a_of_type_Ndv.a().b());
      localLayoutParams = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.jdField_a_of_type_AndroidViewView.getWidth();
      localLayoutParams.height = (localLayoutParams.width * 130 / 478);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.d("GuessTextStageView", 2, "onShowMosaicImageGameTopicTips 130 w = " + localLayoutParams.width + ", h = " + localLayoutParams.height);
      }
    }
    label282:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.jdField_a_of_type_Ndv.a().a());
      localLayoutParams = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.jdField_a_of_type_AndroidViewView.getWidth();
      localLayoutParams.height = (localLayoutParams.width * 110 / 478);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    } while (!QLog.isColorLevel());
    QLog.d("GuessTextStageView", 2, "onShowMosaicImageGameTopicTips 110 w = " + localLayoutParams.width + ", h = " + localLayoutParams.height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ndw
 * JD-Core Version:    0.7.0.1
 */