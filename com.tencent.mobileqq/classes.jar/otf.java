import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

public class otf
  implements WXShareHelper.WXShareListener
{
  public otf(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.g == null) || (!this.a.g.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QRUtils.a(1, 2131435303);
      return;
    }
    QRUtils.a(2, 2131435302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otf
 * JD-Core Version:    0.7.0.1
 */