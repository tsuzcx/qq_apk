import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import org.jetbrains.annotations.NotNull;

class quz
  implements qxc
{
  quz(quy paramquy, UgcVideo paramUgcVideo) {}
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status != UgcVideo.STATUS_PAUSE)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverProgress = ((int)paramFloat);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.status = UgcVideo.STATUS_UPLOADING;
      if (quy.a(this.jdField_a_of_type_Quy) != null) {
        quy.a(this.jdField_a_of_type_Quy).a(3, true, false, null);
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
      if (quy.a(this.jdField_a_of_type_Quy) != null) {
        quy.a(this.jdField_a_of_type_Quy).a(3, false, false, paramString);
      }
      quy.a(this.jdField_a_of_type_Quy).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
      this.jdField_a_of_type_Quy.d();
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
      if (quy.a(this.jdField_a_of_type_Quy) != null) {
        quy.a(this.jdField_a_of_type_Quy).a(3, true, true, null);
      }
    }
    quy.a(this.jdField_a_of_type_Quy).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
    this.jdField_a_of_type_Quy.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     quz
 * JD-Core Version:    0.7.0.1
 */