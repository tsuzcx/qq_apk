import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class scc
  implements bbsh
{
  scc(String paramString) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a == null) || (!this.a.equals(paramBaseResp.transaction))) {
      return;
    }
    BaseApplicationImpl.getContext();
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      vvp.a(1, 2131653595);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      vvp.a(2, 2131653612);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     scc
 * JD-Core Version:    0.7.0.1
 */