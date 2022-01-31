import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qphone.base.util.QLog;

public class rzb
  implements scc
{
  public rzb(FastWebActivity paramFastWebActivity) {}
  
  public void a(scd paramscd)
  {
    ArticleInfo localArticleInfo = paramscd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    int i = FastWebActivity.e(this.a);
    if (QLog.isColorLevel()) {
      QLog.i(FastWebActivity.a(this.a), 2, "articleInfo" + localArticleInfo);
    }
    sdn.a(localArticleInfo, FastWebActivity.f(this.a), i, paramscd.jdField_a_of_type_Boolean, this.a.b, FastWebActivity.g(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rzb
 * JD-Core Version:    0.7.0.1
 */