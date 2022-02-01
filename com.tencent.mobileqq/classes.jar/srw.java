import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qphone.base.util.QLog;

public class srw
  implements svk
{
  public srw(FastWebActivity paramFastWebActivity) {}
  
  public void a(svl paramsvl)
  {
    ArticleInfo localArticleInfo = paramsvl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    int i = FastWebActivity.f(this.a);
    if (QLog.isColorLevel()) {
      QLog.i("FastWebActivity", 2, "articleInfo" + localArticleInfo);
    }
    swy.a(localArticleInfo, FastWebActivity.g(this.a), i, paramsvl.jdField_a_of_type_Boolean, this.a.b, FastWebActivity.h(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     srw
 * JD-Core Version:    0.7.0.1
 */