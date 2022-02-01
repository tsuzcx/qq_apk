import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import mqq.app.MobileQQ;

class ssj
  implements bjig
{
  ssj(ssi paramssi, ArticleInfo paramArticleInfo, int paramInt) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((ssi.a(this.jdField_a_of_type_Ssi) == null) || (!ssi.a(this.jdField_a_of_type_Ssi).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      zyx.b(1, 2131718139);
      bool = false;
    }
    for (;;)
    {
      paramBaseResp = (AppInterface)ozs.a();
      ssy.b(paramBaseResp.getApplication().getApplicationContext(), paramBaseResp, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int, -1, false, bool);
      return;
      zyx.b(2, 2131718157);
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ssj
 * JD-Core Version:    0.7.0.1
 */