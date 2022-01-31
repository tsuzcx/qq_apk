import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.QQAppInterface;

public class nji
  extends QQStoryObserver
{
  public nji(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  public void a()
  {
    SLog.b(MsgTabStoryNodeListManager.a(), "msg: MSG_ON_STORY_MSGTAB_DATA_LOADED");
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      SLog.e(MsgTabStoryNodeListManager.a(), "[ERROR] onMsgTabStoryDataLoaded() app is null!");
    }
    MsgTabStoryManager localMsgTabStoryManager = (MsgTabStoryManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(250);
    if (localMsgTabStoryManager.a())
    {
      this.a.i();
      return;
    }
    if (localMsgTabStoryManager.b())
    {
      this.a.h();
      localMsgTabStoryManager.a();
      this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a("exp_hide", true, false);
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a("exp_hide", true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nji
 * JD-Core Version:    0.7.0.1
 */