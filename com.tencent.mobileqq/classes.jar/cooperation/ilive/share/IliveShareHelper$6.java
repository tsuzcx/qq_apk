package cooperation.ilive.share;

import amtj;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class IliveShareHelper$6
  implements WXShareHelper.WXShareListener
{
  IliveShareHelper$6(IliveShareHelper paramIliveShareHelper) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((IliveShareHelper.access$600(this.this$0) == null) || (!IliveShareHelper.access$600(this.this$0).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(this.this$0.mHostActivity, 1, amtj.a(2131713681), 0).a();
      return;
    }
    QQToast.a(this.this$0.mHostActivity, 2, amtj.a(2131713683), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.share.IliveShareHelper.6
 * JD-Core Version:    0.7.0.1
 */