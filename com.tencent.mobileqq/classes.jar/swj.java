import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import mqq.app.MobileQQ;

class swj
  implements WXShareHelper.WXShareListener
{
  swj(swi paramswi, ArticleInfo paramArticleInfo, int paramInt) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((swi.a(this.jdField_a_of_type_Swi) == null) || (!swi.a(this.jdField_a_of_type_Swi).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      yyi.b(1, 2131718380);
      bool = false;
    }
    for (;;)
    {
      paramBaseResp = (AppInterface)pay.a();
      swy.b(paramBaseResp.getApplication().getApplicationContext(), paramBaseResp, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int, -1, false, bool);
      return;
      yyi.b(2, 2131718398);
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swj
 * JD-Core Version:    0.7.0.1
 */