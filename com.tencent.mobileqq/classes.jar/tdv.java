import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.CircleProgress;

public class tdv
  implements Runnable
{
  public tdv(LikeRankingListActivity paramLikeRankingListActivity, Card paramCard) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
    this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.a.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tdv
 * JD-Core Version:    0.7.0.1
 */