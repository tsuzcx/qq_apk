package com.tencent.mobileqq.cmshow.brickengine;

import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.EngineHelper;
import com.tencent.mobileqq.cmshow.engine.EngineState;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class BKScriptService$onNativeEvent$1
  implements Runnable
{
  BKScriptService$onNativeEvent$1(BKScriptService paramBKScriptService, String paramString1, String paramString2) {}
  
  public final void run()
  {
    if (BKScriptService.a(this.this$0).a() == EngineState.DESTROYED)
    {
      localObject1 = BKScriptService.a(this.this$0);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onNativeEvent fail for cmd:");
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append(", respData:");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(" on EngineState.DESTROYED");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = BKScriptService.a(this.this$0);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onNativeEvent cmd:");
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append(", respData:");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(", EngineState:");
      ((StringBuilder)localObject2).append(BKScriptService.a(this.this$0).a());
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.b;
    int i;
    if (localObject1 != null) {
      i = EngineHelper.a.a((String)localObject1);
    } else {
      i = 0;
    }
    localObject1 = ApolloCmdChannel.getInstance();
    Object localObject2 = BKScriptService.a(this.this$0).a();
    if (localObject2 != null)
    {
      ((ApolloCmdChannel)localObject1).callbackFromRequest(((BKRenderService)localObject2).a(), i, this.a, this.b);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.cmshow.brickengine.BKRenderService");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKScriptService.onNativeEvent.1
 * JD-Core Version:    0.7.0.1
 */