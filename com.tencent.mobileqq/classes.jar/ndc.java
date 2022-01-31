import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListPullSegment;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest.MsgTabNodeVidListResponse;
import com.tencent.qphone.base.util.QLog;

public class ndc
  implements CmdTaskManger.CommandCallback
{
  public ndc(MsgTabNodeVidListPullSegment paramMsgTabNodeVidListPullSegment, MsgTabNodeInfo paramMsgTabNodeInfo) {}
  
  public void a(@NonNull MsgTabNodeVidListRequest paramMsgTabNodeVidListRequest, @Nullable MsgTabNodeVidListRequest.MsgTabNodeVidListResponse paramMsgTabNodeVidListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramMsgTabNodeVidListResponse == null) || (paramErrorMessage.isFail()))
    {
      QLog.e("Q.qqstory.msgTab.jobPullVidList", 1, "pull failed, info=" + this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo + ", err=" + paramErrorMessage.getErrorMessage());
      MsgTabNodeVidListPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeVidListPullSegment, new ErrorMessage(101, paramErrorMessage.getErrorMessage()));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "pull succeed, info=" + this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo);
    }
    MsgTabStoryManager.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, paramMsgTabNodeVidListResponse.a);
    MsgTabNodeVidListPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeVidListPullSegment, paramMsgTabNodeVidListResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndc
 * JD-Core Version:    0.7.0.1
 */