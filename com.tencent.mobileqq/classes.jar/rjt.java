import android.content.Intent;
import android.os.Handler;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class rjt
  implements Runnable
{
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private String jdField_a_of_type_JavaLangString;
  
  public rjt(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString)
  {
    if (paramAddFriendVerifyActivity.getIntent().getIntExtra("friend_setting", 0) != 0) {
      i = 1;
    }
    this.jdField_a_of_type_JavaLangString = (paramString + "?_wv=1031&troopUin=" + paramAddFriendVerifyActivity.b + "&isVerify=" + i);
  }
  
  public void run()
  {
    if (SearchProtocol.a != -1.0F) {}
    for (long l1 = (SearchProtocol.a * 1000000.0F);; l1 = -1L)
    {
      if (SearchProtocol.b != -1.0F) {}
      for (long l2 = (SearchProtocol.b * 1000000.0F);; l2 = -1L)
      {
        if ((System.currentTimeMillis() - this.jdField_a_of_type_Long < 2000L) && (l1 == -1L) && (l2 == -1L))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.postDelayed(this, 100L);
          return;
        }
        if ((l1 != -1L) && (l2 != -1L)) {
          this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "&lat=" + l1 + "&lon=" + l2);
        }
        Intent localIntent = new Intent();
        localIntent.setAction("start_recomend_page");
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.sendBroadcast(localIntent);
        localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("hide_left_button", true);
        localIntent.putExtra("show_right_close_button", true);
        localIntent.putExtra("finish_animation_up_down", true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.startActivity(localIntent);
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.overridePendingTransition(2131034134, 2131034131);
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.finish();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rjt
 * JD-Core Version:    0.7.0.1
 */