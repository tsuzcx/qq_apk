import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

class sar
  implements sdo<String>
{
  sar(saq paramsaq, UgcVideo paramUgcVideo) {}
  
  public void a(float paramFloat)
  {
    if ((paramFloat > this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.videoProgress) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status != UgcVideo.STATUS_PAUSE))
    {
      long l1 = System.currentTimeMillis();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.lastUploadSizeUpdateTime != 0L) && (l1 - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.lastUploadSizeUpdateTime > 500L))
      {
        long l2 = ((paramFloat / 100.0F * (float)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fileSize) - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.lastUploadSize) * 1000L / (l1 - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.lastUploadSizeUpdateTime);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.uploadSpeed = (rth.a(l2) + "/S");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.lastUploadSizeUpdateTime = l1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.lastUploadSize = ((paramFloat / 100.0F * (float)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fileSize));
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.videoProgress = ((int)paramFloat);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status = UgcVideo.STATUS_UPLOADING;
      if (QLog.isColorLevel()) {
        QLog.i("RIJUGC.UploadVideoTaskStep", 2, "videoProgress = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.videoProgress + ", speed=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.uploadSpeed);
      }
    }
  }
  
  public void a(int paramInt, @NotNull String paramString)
  {
    rth.a("fail", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
    olh.a("0X800AC66", rth.a(pnn.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo).a("errMsg", paramString).a());
    QLog.e("RIJUGC.UploadVideoTaskStep", 1, "onFailed, errCode=" + paramInt + ", errMsg=" + paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status = UgcVideo.STATUS_FAILED;
    saq.a(this.jdField_a_of_type_Saq).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
    this.jdField_a_of_type_Saq.d();
    saq.a(this.jdField_a_of_type_Saq, false);
  }
  
  public void a(@NotNull String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.videoUploadKey = paramString;
    saq.a(this.jdField_a_of_type_Saq).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
  }
  
  public void b(String paramString)
  {
    rth.a("success", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
    olh.a("0X800AC67", rth.a(pnn.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo).a("from", Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fromForReport)).a("compress_time", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressTime)).a("upload_time", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.uploadTotalCostTime)).a("wait_time", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.userWaitingTotalCostTime)).a());
    QLog.i("RIJUGC.UploadVideoTaskStep", 1, "upload success");
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.UploadVideoTaskStep", 2, "url=" + paramString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.url = paramString;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressProgress = 100;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.videoProgress = 100;
    if (saq.a(this.jdField_a_of_type_Saq) != null) {
      saq.a(this.jdField_a_of_type_Saq).a(2, true, true, null);
    }
    saq.a(this.jdField_a_of_type_Saq).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
    this.jdField_a_of_type_Saq.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sar
 * JD-Core Version:    0.7.0.1
 */