import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import mqq.app.MobileQQ;

class tbn
  implements bihh
{
  tbn(tbm paramtbm, ArticleInfo paramArticleInfo, int paramInt) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((tbm.a(this.jdField_a_of_type_Tbm) == null) || (!tbm.a(this.jdField_a_of_type_Tbm).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      zvc.b(1, 2131718007);
      bool = false;
    }
    for (;;)
    {
      paramBaseResp = (AppInterface)pha.a();
      tcc.b(paramBaseResp.getApplication().getApplicationContext(), paramBaseResp, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int, -1, false, bool);
      return;
      zvc.b(2, 2131718025);
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tbn
 * JD-Core Version:    0.7.0.1
 */