import android.annotation.TargetApi;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.recent.DrawerFrame.IDrawerCallbacks;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.armap.ConversationPullDownActiveBase;
import com.tencent.mobileqq.portal.ConversationHongBao;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class sik
  implements DrawerFrame.IDrawerCallbacks
{
  public sik(Conversation paramConversation) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.d();
    }
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.e();
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("drawerScale", 2, "scale:" + paramFloat);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.l();
    if (this.a.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ConversationPullDownActiveBase localConversationPullDownActiveBase = (ConversationPullDownActiveBase)localIterator.next();
        if (localConversationPullDownActiveBase != null) {
          localConversationPullDownActiveBase.m();
        }
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.N();
    }
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.f();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2)
  {
    Conversation.d(this.a);
    this.a.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.m();
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.M();
    }
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sik
 * JD-Core Version:    0.7.0.1
 */