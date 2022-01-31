import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

public class swd
  implements Runnable
{
  public swd(LikeRankingListActivity paramLikeRankingListActivity, String paramString) {}
  
  public void run()
  {
    Card localCard = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_JavaLangString);
    if (localCard != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.a(localCard);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LikeRankingListActivity", 2, "update cover card = null");
    }
    byte b = (byte)SharedPreUtils.al(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.getApplication(), this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.app.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 1, 0L, (byte)1, 0L, 0L, null, "", 0L | 1L | 0x20 | 0x2000, 3022, null, b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     swd
 * JD-Core Version:    0.7.0.1
 */