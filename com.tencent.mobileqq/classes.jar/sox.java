import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

public class sox
  implements WXShareHelper.WXShareListener
{
  public sox(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.a == null) || (!this.a.a.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QRUtils.a(1, 2131435319);
      return;
    }
    QRUtils.a(2, 2131435318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sox
 * JD-Core Version:    0.7.0.1
 */