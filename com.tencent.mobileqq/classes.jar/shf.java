import android.os.SystemClock;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.armap.ConversationPullDownActiveBase;
import com.tencent.mobileqq.now.enter.ConversationNowController;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import java.util.ArrayList;
import java.util.Iterator;

class shf
  implements Runnable
{
  shf(she paramshe, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_She.a.d(true);
    if (this.jdField_a_of_type_She.a.i)
    {
      Conversation.a(this.jdField_a_of_type_She.a, 800L);
      Object localObject;
      label102:
      ConversationPullDownActiveBase localConversationPullDownActiveBase;
      if (this.jdField_a_of_type_She.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
      {
        localObject = this.jdField_a_of_type_She.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
        if (this.jdField_a_of_type_Boolean)
        {
          i = 0;
          ((PullRefreshHeader)localObject).a(i);
        }
      }
      else
      {
        if (this.jdField_a_of_type_She.a.jdField_a_of_type_JavaUtilArrayList == null) {
          break label152;
        }
        localObject = this.jdField_a_of_type_She.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localConversationPullDownActiveBase = (ConversationPullDownActiveBase)((Iterator)localObject).next();
        } while (localConversationPullDownActiveBase == null);
        if (!this.jdField_a_of_type_Boolean) {
          break label147;
        }
      }
      label147:
      for (int i = 0;; i = 2)
      {
        localConversationPullDownActiveBase.b(i);
        break label102;
        i = 2;
        break;
      }
      label152:
      if (Conversation.a(this.jdField_a_of_type_She.a) != null) {
        Conversation.a(this.jdField_a_of_type_She.a).a(this.jdField_a_of_type_Boolean);
      }
    }
    if (this.jdField_a_of_type_She.a.b > 0L) {
      StartupTracker.a("Conversation_PullToRefresh_cbSwitchToUI", SystemClock.uptimeMillis() - this.jdField_a_of_type_She.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     shf
 * JD-Core Version:    0.7.0.1
 */