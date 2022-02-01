import com.tencent.av.redpacket.ui.RedPacketShareFragment;
import com.tencent.av.redpacket.ui.RedPacketShareFragment.3;
import com.tencent.av.redpacket.ui.RedPacketShareFragment.3.1;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

public class lvg
  implements WXShareHelper.WXShareListener
{
  public lvg(RedPacketShareFragment.3.1 param1) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((RedPacketShareFragment.d(this.a.a.this$0) == null) || (!RedPacketShareFragment.d(this.a.a.this$0).equals(paramBaseResp.transaction))) {
      return;
    }
    QLog.d("RedPacketShareFragment", 1, "WL_DEBUG ActionSheetAdapter.CHANNEL_WX_FRIEND onWXShareResp resp.errCode = " + paramBaseResp.errCode);
    switch (paramBaseResp.errCode)
    {
    }
    for (;;)
    {
      WXShareHelper.getInstance().removeObserver(this);
      return;
      RedPacketShareFragment.a("0X8008CF8", 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lvg
 * JD-Core Version:    0.7.0.1
 */