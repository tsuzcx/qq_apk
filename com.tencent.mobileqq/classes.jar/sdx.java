import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.qphone.base.util.QLog;

class sdx
  implements Runnable
{
  sdx(sdv paramsdv, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Sdv.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_Sdv.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_JavaLangString, false);
    }
    if (this.jdField_a_of_type_Sdv.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null)
    {
      this.jdField_a_of_type_Sdv.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.a(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "Conversation onUpdateCustomHead uin = " + this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sdx
 * JD-Core Version:    0.7.0.1
 */