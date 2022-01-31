import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

public class moc
  implements WXShareHelper.WXShareListener
{
  public moc(FastWebShareUtils paramFastWebShareUtils) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((FastWebShareUtils.a(this.a) == null) || (!FastWebShareUtils.a(this.a).equals(paramBaseResp.transaction))) {
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
 * Qualified Name:     moc
 * JD-Core Version:    0.7.0.1
 */