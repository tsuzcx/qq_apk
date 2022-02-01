package cooperation.ilive.share;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class IliveShareHelper$6
  implements WXShareHelper.WXShareListener
{
  IliveShareHelper$6(IliveShareHelper paramIliveShareHelper) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (IliveShareHelper.access$600(this.this$0) != null)
    {
      if (!IliveShareHelper.access$600(this.this$0).equals(paramBaseResp.transaction)) {
        return;
      }
      int i = paramBaseResp.errCode;
      if (i != -2)
      {
        if (i != 0)
        {
          QQToast.a(this.this$0.mHostActivity, 1, HardCodeUtil.a(2131714445), 0).a();
          return;
        }
        QQToast.a(this.this$0.mHostActivity, 2, HardCodeUtil.a(2131714447), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.share.IliveShareHelper.6
 * JD-Core Version:    0.7.0.1
 */