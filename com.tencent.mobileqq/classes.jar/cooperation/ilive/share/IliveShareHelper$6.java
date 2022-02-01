package cooperation.ilive.share;

import anni;
import bihh;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;

class IliveShareHelper$6
  implements bihh
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
      QQToast.a(this.this$0.mHostActivity, 1, anni.a(2131713340), 0).a();
      return;
    }
    QQToast.a(this.this$0.mHostActivity, 2, anni.a(2131713342), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.share.IliveShareHelper.6
 * JD-Core Version:    0.7.0.1
 */