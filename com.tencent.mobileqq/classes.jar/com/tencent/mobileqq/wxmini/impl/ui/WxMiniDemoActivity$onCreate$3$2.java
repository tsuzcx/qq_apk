package com.tencent.mobileqq.wxmini.impl.ui;

import android.util.Log;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wxmini/impl/ui/WxMiniDemoActivity$onCreate$3$2", "Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;", "onReq", "", "p0", "Lcom/tencent/mm/opensdk/modelbase/BaseReq;", "onResp", "resp", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "wxmini_impl_release"}, k=1, mv={1, 1, 16})
public final class WxMiniDemoActivity$onCreate$3$2
  implements IWXAPIEventHandler
{
  public void onReq(@Nullable BaseReq paramBaseReq) {}
  
  public void onResp(@Nullable BaseResp paramBaseResp)
  {
    if ((paramBaseResp instanceof SendAuth.Resp))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WxaApi.sendCombineAuth, SendAuth.Resp.code=");
      localStringBuilder.append(((SendAuth.Resp)paramBaseResp).code);
      Log.i("RuntimeSDKDemo.WxMiniDemoActivity", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.WxMiniDemoActivity.onCreate.3.2
 * JD-Core Version:    0.7.0.1
 */