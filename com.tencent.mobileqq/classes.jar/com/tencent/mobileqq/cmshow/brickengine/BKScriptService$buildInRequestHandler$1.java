package com.tencent.mobileqq.cmshow.brickengine;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.channel.HandleResult;
import com.tencent.mobileqq.apollo.channel.IRequestHandler;
import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.EngineHelper;
import com.tencent.mobileqq.cmshow.engine.EngineState;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/cmshow/brickengine/BKScriptService$buildInRequestHandler$1", "Lcom/tencent/mobileqq/apollo/channel/IRequestHandler;", "getHandlePriority", "", "handleCmd", "Lcom/tencent/mobileqq/apollo/channel/HandleResult;", "jsState", "", "cmd", "", "reqData", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class BKScriptService$buildInRequestHandler$1
  implements IRequestHandler
{
  public int a()
  {
    return 100;
  }
  
  @Nullable
  public HandleResult a(long paramLong, @Nullable String paramString1, @Nullable String paramString2)
  {
    boolean bool = TextUtils.isEmpty((CharSequence)paramString1);
    String str = null;
    if (bool) {
      return null;
    }
    if (BKScriptService.a(this.a).a() == EngineState.DESTROYED)
    {
      str = BKScriptService.a(this.a);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("buildInRequestHandler handleCmd:");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", reqData:");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(" fail on EngineState.DESTROYED");
      QLog.w(str, 1, ((StringBuilder)localObject1).toString());
      return null;
    }
    Object localObject1 = BKScriptService.a(this.a).a();
    if (localObject1 != null)
    {
      if (((BKRenderService)localObject1).a() != paramLong) {
        return null;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = BKScriptService.a(this.a);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this);
        ((StringBuilder)localObject2).append(" handleCmd, jsState:");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append(", cmd:");
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append(", reqData:");
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(", EngineState:");
        ((StringBuilder)localObject2).append(BKScriptService.a(this.a).a());
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = this.a;
      Object localObject2 = EngineHelper.a;
      if (paramString1 == null) {
        Intrinsics.throwNpe();
      }
      paramString2 = ((BKScriptService)localObject1).a(((EngineHelper)localObject2).a(paramString1, paramString2));
      paramString1 = str;
      if (paramString2 != null)
      {
        paramString1 = new HandleResult();
        paramString1.a = paramString2;
      }
      return paramString1;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.cmshow.brickengine.BKRenderService");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKScriptService.buildInRequestHandler.1
 * JD-Core Version:    0.7.0.1
 */