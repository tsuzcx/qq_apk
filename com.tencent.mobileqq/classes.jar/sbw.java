import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.qphone.base.util.QLog;

class sbw
  implements qyx
{
  sbw(sbv paramsbv, VideoInfo paramVideoInfo) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == sbv.a(this.jdField_a_of_type_Sbv)) && (paramBoolean) && (!sbv.a(this.jdField_a_of_type_Sbv).k)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.k = paramBoolean;
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.w = paramString;
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.m = this.jdField_a_of_type_Sbv.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRedPacketShareController", 2, "hasSharePacketCallback: title=" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c + ", changed=" + bool + ", permission=" + paramBoolean + ", redPacketId=" + paramString);
      }
      if (bool)
      {
        this.jdField_a_of_type_Sbv.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
        if (sbv.a(this.jdField_a_of_type_Sbv) != null) {
          sbv.a(this.jdField_a_of_type_Sbv).c(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbw
 * JD-Core Version:    0.7.0.1
 */