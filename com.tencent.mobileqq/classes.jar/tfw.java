import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class tfw
  implements syq<tgl, tgm>
{
  tfw(tfv paramtfv, tff paramtff) {}
  
  public void a(@NonNull tgl paramtgl, @Nullable tgm paramtgm, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramtgm == null) || (paramErrorMessage.isFail()))
    {
      ved.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, err=" + paramErrorMessage.getErrorMessage() + " node:" + this.jdField_a_of_type_Tff);
      tfv.a(this.jdField_a_of_type_Tfv, paramErrorMessage);
      return;
    }
    if (paramtgm.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.video_list.size() == 0)
    {
      if (this.jdField_a_of_type_Tff.jdField_a_of_type_Int != 5)
      {
        ved.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, info=" + this.jdField_a_of_type_Tff + ", err=ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, " + paramErrorMessage.getErrorMessage());
        tfv.b(this.jdField_a_of_type_Tfv, new ErrorMessage(103, paramErrorMessage.getErrorMessage()));
        return;
      }
      tfv.a(this.jdField_a_of_type_Tfv, tfv.a(paramtgm.jdField_a_of_type_JavaUtilList));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "pull succeed, info=" + this.jdField_a_of_type_Tff);
    }
    tfy.a(this.jdField_a_of_type_Tff, paramtgm.jdField_a_of_type_ArrayOfByte);
    paramtgl = tfv.a(paramtgm.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Tff.jdField_a_of_type_Int == 12) {}
    tfv.b(this.jdField_a_of_type_Tfv, paramtgl);
    if (this.jdField_a_of_type_Tff.jdField_a_of_type_Int == 12) {
      if (this.jdField_a_of_type_Tfv.a != null)
      {
        this.jdField_a_of_type_Tfv.a.c = paramtgm.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
        paramtgl = this.jdField_a_of_type_Tfv.a;
        if (paramtgm.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.is_end.get() <= 0) {
          break label345;
        }
      }
    }
    label345:
    for (boolean bool = true;; bool = false)
    {
      paramtgl.a = bool;
      this.jdField_a_of_type_Tff.i = paramtgm.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
      if (!QLog.isColorLevel()) {
        break;
      }
      ved.a("Q.qqstory.msgTab.jobPullVidList", "MsgTabNodeVidListPullSegment::runSegment() use net resp %s, %s", this.jdField_a_of_type_Tff.jdField_a_of_type_JavaLangString, paramtgm.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfw
 * JD-Core Version:    0.7.0.1
 */