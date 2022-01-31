import UserGrowth.stGlobalConfig;
import UserGrowth.stNotificationRsp;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

public class sjk
  implements snn
{
  public sjk(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void a(String paramString, int paramInt)
  {
    if (WSRecommendFragment.a(this.a) == null) {}
    for (int i = 1;; i = WSRecommendFragment.a(this.a).link_strategy_type)
    {
      sng.a(this.a.getActivity(), "biz_src_jc_gzh_weishi", paramString, 1, i, WSRecommendFragment.a(this.a, WSRecommendFragment.a(this.a)));
      smq.a(4, 114, 0, null, null);
      sms.a(114, paramInt, WSRecommendFragment.a(this.a).cid);
      WSPublicAccReport.getInstance().reportMsgEntry("gzh_click", paramInt, 1000003, WSRecommendFragment.a(this.a).cid);
      return;
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    onk.e(this.a.getActivity(), paramString);
    sms.a(140, paramInt, WSRecommendFragment.a(this.a).cid);
    WSPublicAccReport.getInstance().reportMsgEntry("gzh_click", paramInt, 1000004, WSRecommendFragment.a(this.a).cid);
  }
  
  public void c(String paramString, int paramInt)
  {
    if (WSRecommendFragment.a(this.a) == null) {}
    for (int i = 1;; i = WSRecommendFragment.a(this.a).link_strategy_type)
    {
      paramString = WSRecommendFragment.a(this.a, i);
      skq.a(this.a.getActivity(), paramString, false);
      sms.a(115, paramInt, WSRecommendFragment.a(this.a).cid);
      WSPublicAccReport.getInstance().reportMsgEntry("gzh_click", paramInt, 1000002, WSRecommendFragment.a(this.a).cid);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sjk
 * JD-Core Version:    0.7.0.1
 */