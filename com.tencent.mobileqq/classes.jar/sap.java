import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import org.jetbrains.annotations.NotNull;

class sap
  implements sdm
{
  sap(sao paramsao, UgcVideo paramUgcVideo) {}
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status != UgcVideo.STATUS_PAUSE)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverProgress = ((int)paramFloat);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status = UgcVideo.STATUS_UPLOADING;
      if (sao.a(this.jdField_a_of_type_Sao) != null) {
        sao.a(this.jdField_a_of_type_Sao).a(3, true, false, null);
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
      if (sao.a(this.jdField_a_of_type_Sao) != null) {
        sao.a(this.jdField_a_of_type_Sao).a(3, false, false, paramString);
      }
      sao.a(this.jdField_a_of_type_Sao).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
      this.jdField_a_of_type_Sao.d();
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
      if (sao.a(this.jdField_a_of_type_Sao) != null) {
        sao.a(this.jdField_a_of_type_Sao).a(3, true, true, null);
      }
    }
    sao.a(this.jdField_a_of_type_Sao).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
    this.jdField_a_of_type_Sao.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sap
 * JD-Core Version:    0.7.0.1
 */