import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class std
  implements slx<sts, stt>
{
  std(stc paramstc, ssm paramssm) {}
  
  public void a(@NonNull sts paramsts, @Nullable stt paramstt, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramstt == null) || (paramErrorMessage.isFail()))
    {
      urk.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, err=" + paramErrorMessage.getErrorMessage() + " node:" + this.jdField_a_of_type_Ssm);
      stc.a(this.jdField_a_of_type_Stc, paramErrorMessage);
      return;
    }
    if (paramstt.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.video_list.size() == 0)
    {
      if (this.jdField_a_of_type_Ssm.jdField_a_of_type_Int != 5)
      {
        urk.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, info=" + this.jdField_a_of_type_Ssm + ", err=ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, " + paramErrorMessage.getErrorMessage());
        stc.b(this.jdField_a_of_type_Stc, new ErrorMessage(103, paramErrorMessage.getErrorMessage()));
        return;
      }
      stc.a(this.jdField_a_of_type_Stc, stc.a(paramstt.jdField_a_of_type_JavaUtilList));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "pull succeed, info=" + this.jdField_a_of_type_Ssm);
    }
    stf.a(this.jdField_a_of_type_Ssm, paramstt.jdField_a_of_type_ArrayOfByte);
    paramsts = stc.a(paramstt.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Ssm.jdField_a_of_type_Int == 12) {}
    stc.b(this.jdField_a_of_type_Stc, paramsts);
    if (this.jdField_a_of_type_Ssm.jdField_a_of_type_Int == 12) {
      if (this.jdField_a_of_type_Stc.a != null)
      {
        this.jdField_a_of_type_Stc.a.c = paramstt.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
        paramsts = this.jdField_a_of_type_Stc.a;
        if (paramstt.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.is_end.get() <= 0) {
          break label345;
        }
      }
    }
    label345:
    for (boolean bool = true;; bool = false)
    {
      paramsts.a = bool;
      this.jdField_a_of_type_Ssm.i = paramstt.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
      if (!QLog.isColorLevel()) {
        break;
      }
      urk.a("Q.qqstory.msgTab.jobPullVidList", "MsgTabNodeVidListPullSegment::runSegment() use net resp %s, %s", this.jdField_a_of_type_Ssm.jdField_a_of_type_JavaLangString, paramstt.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     std
 * JD-Core Version:    0.7.0.1
 */