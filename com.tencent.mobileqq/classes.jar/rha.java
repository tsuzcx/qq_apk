import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import org.jetbrains.annotations.NotNull;

class rha
  implements rjx
{
  rha(rgz paramrgz, UgcVideo paramUgcVideo) {}
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status != UgcVideo.STATUS_PAUSE)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverProgress = ((int)paramFloat);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status = UgcVideo.STATUS_UPLOADING;
      if (rgz.a(this.jdField_a_of_type_Rgz) != null) {
        rgz.a(this.jdField_a_of_type_Rgz).a(3, true, false, null);
      }
      if (QLog.isColorLevel()) {
        QLog.i("RIJUGC.UploadCoverTaskStep", 0, "coverProgress =" + paramFloat);
      }
    }
  }
  
  public void a(int paramInt, @NotNull String paramString)
  {
    QLog.e("RIJUGC.UploadCoverTaskStep", 1, "upload cover fail, errCode=" + paramInt + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status != UgcVideo.STATUS_PAUSE)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status = UgcVideo.STATUS_FAILED;
      if (rgz.a(this.jdField_a_of_type_Rgz) != null) {
        rgz.a(this.jdField_a_of_type_Rgz).a(3, false, false, paramString);
      }
      rgz.a(this.jdField_a_of_type_Rgz).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
      this.jdField_a_of_type_Rgz.d();
    }
  }
  
  public void a(String paramString)
  {
    QLog.i("RIJUGC.UploadCoverTaskStep", 1, "upload cover success");
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.UploadCoverTaskStep", 0, "upload cover url=" + paramString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverUrl = paramString;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status != UgcVideo.STATUS_PAUSE)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverProgress = 100;
      if (rgz.a(this.jdField_a_of_type_Rgz) != null) {
        rgz.a(this.jdField_a_of_type_Rgz).a(3, true, true, null);
      }
    }
    rgz.a(this.jdField_a_of_type_Rgz).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
    this.jdField_a_of_type_Rgz.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rha
 * JD-Core Version:    0.7.0.1
 */