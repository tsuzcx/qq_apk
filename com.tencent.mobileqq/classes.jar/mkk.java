import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.qphone.base.util.QLog;

class mkk
  implements Runnable
{
  mkk(mkj parammkj, boolean paramBoolean, int paramInt, FastWebShareInfo paramFastWebShareInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      FastWebShareUtils localFastWebShareUtils = FastWebActivity.a(this.jdField_a_of_type_Mkj.a);
      ArticleInfo localArticleInfo = FastWebActivity.a(this.jdField_a_of_type_Mkj.a);
      int i = this.jdField_a_of_type_Int;
      FastWebActivity localFastWebActivity = this.jdField_a_of_type_Mkj.a;
      String str2 = FastWebActivity.a(this.jdField_a_of_type_Mkj.a).mArticleContentUrl;
      if (FastWebActivity.a(this.jdField_a_of_type_Mkj.a)) {}
      for (String str1 = "0X8008994";; str1 = "0X800898D")
      {
        localFastWebShareUtils.a(localArticleInfo, i, localFastWebActivity, str2, str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebShareInfo.a(this.jdField_a_of_type_Int));
        return;
      }
    }
    QRUtils.a(1, 2131435463);
    QLog.d("Q.readinjoy.fast_web", 2, "shareJson get false ! action : " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mkk
 * JD-Core Version:    0.7.0.1
 */