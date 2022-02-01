import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

final class sib
  implements tdu
{
  sib(BaseArticleInfo paramBaseArticleInfo, URL paramURL) {}
  
  public void a(tdw paramtdw, int paramInt) {}
  
  public void a(tdw paramtdw, Throwable paramThrowable)
  {
    QLog.e(sia.a, 2, "preload failed " + this.jdField_a_of_type_JavaNetURL);
  }
  
  public void a(tdw paramtdw, tds paramtds)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.setHasFirstFramePreload(true);
    if (QLog.isColorLevel()) {
      QLog.d(sia.a, 2, "preload success width: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getFirstFrameWidth() + ", height: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getFirstFrameHeight() + ", " + this.jdField_a_of_type_JavaNetURL + ", title: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sib
 * JD-Core Version:    0.7.0.1
 */