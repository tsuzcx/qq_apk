import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

final class sgj
  implements sym
{
  sgj(BaseArticleInfo paramBaseArticleInfo, URL paramURL) {}
  
  public void a(syo paramsyo, int paramInt) {}
  
  public void a(syo paramsyo, Throwable paramThrowable)
  {
    QLog.e(sgi.a, 2, "preload failed " + this.jdField_a_of_type_JavaNetURL);
  }
  
  public void a(syo paramsyo, syk paramsyk)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.setHasFirstFramePreload(true);
    if (QLog.isColorLevel()) {
      QLog.d(sgi.a, 2, "preload success width: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getFirstFrameWidth() + ", height: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getFirstFrameHeight() + ", " + this.jdField_a_of_type_JavaNetURL + ", title: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgj
 * JD-Core Version:    0.7.0.1
 */