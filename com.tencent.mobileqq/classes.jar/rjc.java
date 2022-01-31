import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qphone.base.util.QLog;

public class rjc
  implements rmj
{
  public rjc(FastWebActivity paramFastWebActivity) {}
  
  public void a(rmk paramrmk)
  {
    ArticleInfo localArticleInfo = paramrmk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    int i = FastWebActivity.c(this.a);
    if (QLog.isColorLevel()) {
      QLog.i(FastWebActivity.a(this.a), 2, "articleInfo" + localArticleInfo);
    }
    rnr.a(localArticleInfo, FastWebActivity.d(this.a), i, paramrmk.jdField_a_of_type_Boolean, this.a.b, FastWebActivity.e(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rjc
 * JD-Core Version:    0.7.0.1
 */