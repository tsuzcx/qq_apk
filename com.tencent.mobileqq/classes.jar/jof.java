import com.tencent.av.redpacket.ui.RedPacketShareFragment;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

class jof
  implements WXShareHelper.WXShareListener
{
  jof(joe paramjoe) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((RedPacketShareFragment.d(this.a.a.a) == null) || (!RedPacketShareFragment.d(this.a.a.a).equals(paramBaseResp.transaction))) {
      return;
    }
    QLog.d("RedPacketShareFragment", 1, "WL_DEBUG ActionSheetAdapter.CHANNEL_WX_FRIEND onWXShareResp resp.errCode = " + paramBaseResp.errCode);
    switch (paramBaseResp.errCode)
    {
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      RedPacketShareFragment.a("0X8008CF8", 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jof
 * JD-Core Version:    0.7.0.1
 */