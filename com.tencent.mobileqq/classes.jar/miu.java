import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;

class miu
  implements Runnable
{
  miu(mit parammit, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangString.equals(VideoPreDownloadMgr.a(this.jdField_a_of_type_Mit.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr)))
    {
      if (this.jdField_a_of_type_Mit.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(this.b, this.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.i(VideoPreDownloadMgr.a(), 2, "innerDoPreDownload() 缓冲已存在，跳过, vid=" + this.jdField_a_of_type_JavaLangString);
        }
        VideoPreDownloadMgr.a(this.jdField_a_of_type_Mit.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr, null);
        VideoPreDownloadMgr.a(this.jdField_a_of_type_Mit.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
      }
    }
    else {
      return;
    }
    VideoPreDownloadMgr.a(this.jdField_a_of_type_Mit.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Mit.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     miu
 * JD-Core Version:    0.7.0.1
 */