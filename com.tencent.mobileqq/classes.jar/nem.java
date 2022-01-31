import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListPullSegment;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest.MsgTabNodeVidListResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;

public class nem
  implements CmdTaskManger.CommandCallback
{
  public nem(MsgTabNodeVidListPullSegment paramMsgTabNodeVidListPullSegment, MsgTabNodeInfo paramMsgTabNodeInfo) {}
  
  public void a(@NonNull MsgTabNodeVidListRequest paramMsgTabNodeVidListRequest, @Nullable MsgTabNodeVidListRequest.MsgTabNodeVidListResponse paramMsgTabNodeVidListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramMsgTabNodeVidListResponse == null) || (paramErrorMessage.isFail()))
    {
      SLog.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, info=" + this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo + ", err=" + paramErrorMessage.getErrorMessage());
      MsgTabNodeVidListPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeVidListPullSegment, new ErrorMessage(101, paramErrorMessage.getErrorMessage()));
      return;
    }
    if (paramMsgTabNodeVidListResponse.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.video_list.size() == 0)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a != 5)
      {
        SLog.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, info=" + this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo + ", err=ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, " + paramErrorMessage.getErrorMessage());
        MsgTabNodeVidListPullSegment.b(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeVidListPullSegment, new ErrorMessage(103, paramErrorMessage.getErrorMessage()));
        return;
      }
      MsgTabNodeVidListPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeVidListPullSegment, paramMsgTabNodeVidListResponse);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "pull succeed, info=" + this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo);
    }
    MsgTabStoryManager.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, paramMsgTabNodeVidListResponse.jdField_a_of_type_ArrayOfByte);
    MsgTabNodeVidListPullSegment.b(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeVidListPullSegment, paramMsgTabNodeVidListResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nem
 * JD-Core Version:    0.7.0.1
 */