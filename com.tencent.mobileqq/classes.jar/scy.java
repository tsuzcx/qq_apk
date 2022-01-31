import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import mqq.app.MobileQQ;

class scy
  implements bevy
{
  scy(scx paramscx, ArticleInfo paramArticleInfo, int paramInt) {}
  
  public void a(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((scx.a(this.jdField_a_of_type_Scx) == null) || (!scx.a(this.jdField_a_of_type_Scx).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      xxb.b(1, 2131720019);
      bool = false;
    }
    for (;;)
    {
      paramBaseResp = (AppInterface)ors.a();
      sdn.b(paramBaseResp.getApplication().getApplicationContext(), paramBaseResp, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int, -1, false, bool);
      return;
      xxb.b(2, 2131720038);
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     scy
 * JD-Core Version:    0.7.0.1
 */