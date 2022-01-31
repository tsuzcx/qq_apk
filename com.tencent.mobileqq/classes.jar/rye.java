import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgcache.CacheConstants;
import com.tencent.mobileqq.service.message.MessageCache;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class rye
  implements Runnable
{
  public rye(ChatFragment paramChatFragment, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(CacheConstants.a, 0);
    long l = ((SharedPreferences)localObject).getLong(CacheConstants.d, 0L);
    if ((l == 0L) || (l > System.currentTimeMillis()) || (System.currentTimeMillis() - l > 14400000L)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((SharedPreferences)localObject).edit().putLong(CacheConstants.d, System.currentTimeMillis()).commit();
      }
      if (i != 0)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("entrance", 0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
        this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, this.jdField_a_of_type_Int, i, this.b);
      }
      MessageCache.b.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rye
 * JD-Core Version:    0.7.0.1
 */