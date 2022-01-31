import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qphone.base.util.QLog;

public class riz
  implements rmg
{
  public riz(FastWebActivity paramFastWebActivity) {}
  
  public void a(rmh paramrmh)
  {
    ArticleInfo localArticleInfo = paramrmh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    int i = FastWebActivity.c(this.a);
    if (QLog.isColorLevel()) {
      QLog.i(FastWebActivity.a(this.a), 2, "articleInfo" + localArticleInfo);
    }
    rno.a(localArticleInfo, FastWebActivity.d(this.a), i, paramrmh.jdField_a_of_type_Boolean, this.a.b, FastWebActivity.e(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     riz
 * JD-Core Version:    0.7.0.1
 */