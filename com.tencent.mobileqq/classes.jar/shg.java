import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;

class shg
  implements Runnable
{
  shg(she paramshe, boolean paramBoolean) {}
  
  public void run()
  {
    Conversation.a(this.jdField_a_of_type_She.a, 800L);
    PullRefreshHeader localPullRefreshHeader;
    if (this.jdField_a_of_type_She.a.a != null)
    {
      localPullRefreshHeader = this.jdField_a_of_type_She.a.a;
      if (!this.jdField_a_of_type_Boolean) {
        break label66;
      }
    }
    label66:
    for (int i = 0;; i = 2)
    {
      localPullRefreshHeader.a(i);
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ConversationTab[onRefleshRecentListFinished_ui]");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     shg
 * JD-Core Version:    0.7.0.1
 */