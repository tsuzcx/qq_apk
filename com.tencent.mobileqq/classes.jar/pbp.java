import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

public class pbp
  implements WXShareHelper.WXShareListener
{
  public pbp(WxShareHelperFromReadInjoy paramWxShareHelperFromReadInjoy) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (paramBaseResp.errCode == 0) {}
    for (boolean bool = true;; bool = false)
    {
      WXShareHelper.getInstance().removeObserver(this);
      uhd.a.a(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pbp
 * JD-Core Version:    0.7.0.1
 */