package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import com.tencent.common.danmaku.edit.listener.EditDanmakuListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/glue/viola/modules/bridge/UIBridgeInvokeHandler$arouseTkdBarragePublisher$1$dialog$1$1", "Lcom/tencent/common/danmaku/edit/listener/EditDanmakuListener;", "onDanmakuadd", "", "content", "", "onEditDismiss", "onEditExposure", "kandian_feature_impl_release", "com/tencent/mobileqq/kandian/glue/viola/modules/bridge/UIBridgeInvokeHandler$$special$$inlined$apply$lambda$1"}, k=1, mv={1, 1, 16})
public final class UIBridgeInvokeHandler$arouseTkdBarragePublisher$$inlined$let$lambda$1
  implements EditDanmakuListener
{
  UIBridgeInvokeHandler$arouseTkdBarragePublisher$$inlined$let$lambda$1(int paramInt, String paramString1, String paramString2, UIBridgeInvokeHandler paramUIBridgeInvokeHandler, JSONObject paramJSONObject, String paramString3) {}
  
  public void a()
  {
    PublicAccountReportUtils.a(null, null, "0X800BC8E", "0X800BC8E", 0, 0, null, null, null, "", false);
  }
  
  public void a(@Nullable Object paramObject)
  {
    JSONObject localJSONObject = this.e;
    if (localJSONObject != null) {
      localJSONObject.put("text", paramObject);
    }
    paramObject = this.e;
    if (paramObject != null) {
      paramObject.put("type", "1");
    }
    this.d.a(this.f, this.e);
    PublicAccountReportUtils.a(null, null, "0X800BC90", "0X800BC90", 0, 0, null, null, null, "", false);
  }
  
  public void b(@Nullable Object paramObject)
  {
    JSONObject localJSONObject = this.e;
    if (localJSONObject != null) {
      localJSONObject.put("text", paramObject);
    }
    paramObject = this.e;
    if (paramObject != null) {
      paramObject.put("type", "2");
    }
    this.d.a(this.f, this.e);
    PublicAccountReportUtils.a(null, null, "0X800BC8F", "0X800BC8F", 0, 0, null, null, null, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.UIBridgeInvokeHandler.arouseTkdBarragePublisher..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */