import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabCheckActiveRequest;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabCheckActiveRequest.MsgTabCheckActiveResponse;
import com.tencent.qphone.base.util.QLog;

public class ndd
  implements CmdTaskManger.CommandCallback
{
  public ndd(MsgTabStoryNodeConfigManager paramMsgTabStoryNodeConfigManager, QQStoryHandler paramQQStoryHandler, QQStoryManager paramQQStoryManager) {}
  
  public void a(@NonNull MsgTabCheckActiveRequest paramMsgTabCheckActiveRequest, @Nullable MsgTabCheckActiveRequest.MsgTabCheckActiveResponse paramMsgTabCheckActiveResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramMsgTabCheckActiveResponse == null))
    {
      QLog.w("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 1, "get active fail" + paramErrorMessage.getErrorMessage());
      return;
    }
    if (paramMsgTabCheckActiveResponse.b == 1)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager.a(true);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.b(2);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager.a = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "active value is " + paramMsgTabCheckActiveResponse.b);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.a(paramMsgTabCheckActiveResponse.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndd
 * JD-Core Version:    0.7.0.1
 */