import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.qphone.base.util.QLog;

class rgy
  implements qfp
{
  rgy(rgx paramrgx, VideoInfo paramVideoInfo) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == rgx.a(this.jdField_a_of_type_Rgx)) && (paramBoolean) && (!rgx.a(this.jdField_a_of_type_Rgx).k)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.k = paramBoolean;
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.u = paramString;
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.m = this.jdField_a_of_type_Rgx.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRedPacketShareController", 2, "hasSharePacketCallback: title=" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c + ", changed=" + bool + ", permission=" + paramBoolean + ", redPacketId=" + paramString);
      }
      if (bool)
      {
        this.jdField_a_of_type_Rgx.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
        if (rgx.a(this.jdField_a_of_type_Rgx) != null) {
          rgx.a(this.jdField_a_of_type_Rgx).c(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rgy
 * JD-Core Version:    0.7.0.1
 */