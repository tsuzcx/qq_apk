import android.os.SystemClock;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.armap.ConversationPullDownActiveBase;
import com.tencent.mobileqq.now.enter.ConversationNowController;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import java.util.ArrayList;
import java.util.Iterator;

class slx
  implements Runnable
{
  slx(slw paramslw, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Slw.a.d(true);
    if (this.jdField_a_of_type_Slw.a.j)
    {
      Conversation.a(this.jdField_a_of_type_Slw.a, 800L);
      Object localObject;
      label108:
      ConversationPullDownActiveBase localConversationPullDownActiveBase;
      if (this.jdField_a_of_type_Slw.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
      {
        localObject = this.jdField_a_of_type_Slw.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
        if (this.jdField_a_of_type_Boolean)
        {
          i = 0;
          ((PullRefreshHeader)localObject).a(i);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Slw.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null)
        {
          localObject = this.jdField_a_of_type_Slw.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager;
          if (!this.jdField_a_of_type_Boolean) {
            break label185;
          }
          i = 0;
          ((MsgTabStoryNodeListManager)localObject).a(i);
        }
        if (this.jdField_a_of_type_Slw.a.jdField_a_of_type_JavaUtilArrayList == null) {
          break label195;
        }
        localObject = this.jdField_a_of_type_Slw.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        label140:
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localConversationPullDownActiveBase = (ConversationPullDownActiveBase)((Iterator)localObject).next();
        } while (localConversationPullDownActiveBase == null);
        if (!this.jdField_a_of_type_Boolean) {
          break label190;
        }
      }
      label185:
      label190:
      for (int i = 0;; i = 2)
      {
        localConversationPullDownActiveBase.b(i);
        break label140;
        i = 2;
        break;
        i = 2;
        break label108;
      }
      label195:
      if (Conversation.a(this.jdField_a_of_type_Slw.a) != null) {
        Conversation.a(this.jdField_a_of_type_Slw.a).a(this.jdField_a_of_type_Boolean);
      }
    }
    if (this.jdField_a_of_type_Slw.a.c > 0L) {
      StartupTracker.a("Conversation_PullToRefresh_cbSwitchToUI", SystemClock.uptimeMillis() - this.jdField_a_of_type_Slw.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     slx
 * JD-Core Version:    0.7.0.1
 */