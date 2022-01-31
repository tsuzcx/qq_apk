import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qphone.base.util.QLog;

public class qwl
  implements qzr
{
  public qwl(FastWebActivity paramFastWebActivity) {}
  
  public void a(qzs paramqzs)
  {
    ArticleInfo localArticleInfo = paramqzs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    int i = FastWebActivity.b(this.a);
    if (QLog.isColorLevel()) {
      QLog.i(FastWebActivity.a(this.a), 2, "articleInfo" + localArticleInfo);
    }
    raz.a(localArticleInfo, FastWebActivity.c(this.a), i, paramqzs.jdField_a_of_type_Boolean, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qwl
 * JD-Core Version:    0.7.0.1
 */