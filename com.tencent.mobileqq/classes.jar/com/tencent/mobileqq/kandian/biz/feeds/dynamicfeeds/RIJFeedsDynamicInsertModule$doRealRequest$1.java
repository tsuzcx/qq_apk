package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds;

import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJFeedsDynamicInsertModule$doRealRequest$1
  implements Runnable
{
  RIJFeedsDynamicInsertModule$doRealRequest$1(RIJFeedsDynamicInsertModule paramRIJFeedsDynamicInsertModule, String paramString, Integer paramInteger, ActionType paramActionType, boolean paramBoolean, RIJFeedsDynamicInsertModule.Companion.IFeedsDynamicInsertCallback paramIFeedsDynamicInsertCallback) {}
  
  public final void run()
  {
    String str = this.a;
    if (str != null)
    {
      ToServiceMsg localToServiceMsg = this.this$0.a(this.b, str, this.c, this.d);
      int i = RIJFeedsDynamicInsertModule.a(this.this$0).incrementAndGet();
      HashMap localHashMap = localToServiceMsg.getAttributes();
      Intrinsics.checkExpressionValueIsNotNull(localHashMap, "request.attributes");
      ((Map)localHashMap).put("insert_callback", Integer.valueOf(i));
      localHashMap = localToServiceMsg.getAttributes();
      Intrinsics.checkExpressionValueIsNotNull(localHashMap, "request.attributes");
      ((Map)localHashMap).put("insert_reqsource", this.b);
      localHashMap = localToServiceMsg.getAttributes();
      Intrinsics.checkExpressionValueIsNotNull(localHashMap, "request.attributes");
      ((Map)localHashMap).put("insert_rowkey", str);
      if (this.e != null) {
        ((Map)RIJFeedsDynamicInsertModule.b(this.this$0)).put(Integer.valueOf(i), this.e);
      }
      this.this$0.sendPbReq(localToServiceMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertModule.doRealRequest.1
 * JD-Core Version:    0.7.0.1
 */