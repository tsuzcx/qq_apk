import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

class roc
  implements rqz<String>
{
  roc(rob paramrob, UgcVideo paramUgcVideo) {}
  
  public void a(float paramFloat)
  {
    if ((paramFloat > this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.videoProgress) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status != UgcVideo.STATUS_PAUSE))
    {
      long l1 = System.currentTimeMillis();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.lastUploadSizeUpdateTime != 0L) && (l1 - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.lastUploadSizeUpdateTime > 500L))
      {
        long l2 = ((paramFloat / 100.0F * (float)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fileSize) - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.lastUploadSize) * 1000L / (l1 - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.lastUploadSizeUpdateTime);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.uploadSpeed = (rha.a(l2) + "/S");
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
    rha.a("fail", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
    odq.a("0X800AC66", rha.a(pay.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo).a("errMsg", paramString).a());
    QLog.e("RIJUGC.UploadVideoTaskStep", 1, "onFailed, errCode=" + paramInt + ", errMsg=" + paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status = UgcVideo.STATUS_FAILED;
    rob.a(this.jdField_a_of_type_Rob).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
    this.jdField_a_of_type_Rob.d();
    rob.a(this.jdField_a_of_type_Rob, false);
  }
  
  public void a(@NotNull String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.videoUploadKey = paramString;
    rob.a(this.jdField_a_of_type_Rob).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
  }
  
  public void b(String paramString)
  {
    rha.a("success", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
    odq.a("0X800AC67", rha.a(pay.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo).a("from", Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fromForReport)).a("compress_time", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressTime)).a("upload_time", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.uploadTotalCostTime)).a("wait_time", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.userWaitingTotalCostTime)).a());
    QLog.i("RIJUGC.UploadVideoTaskStep", 1, "upload success");
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.UploadVideoTaskStep", 2, "url=" + paramString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.url = paramString;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.compressProgress = 100;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.videoProgress = 100;
    if (rob.a(this.jdField_a_of_type_Rob) != null) {
      rob.a(this.jdField_a_of_type_Rob).a(2, true, true, null);
    }
    rob.a(this.jdField_a_of_type_Rob).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
    this.jdField_a_of_type_Rob.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     roc
 * JD-Core Version:    0.7.0.1
 */