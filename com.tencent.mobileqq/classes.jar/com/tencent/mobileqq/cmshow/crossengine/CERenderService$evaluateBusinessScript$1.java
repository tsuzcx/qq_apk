package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class CERenderService$evaluateBusinessScript$1
  implements Runnable
{
  CERenderService$evaluateBusinessScript$1(CERenderService paramCERenderService) {}
  
  public final void run()
  {
    Object localObject = CERenderService.a(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("evaluateBusinessScript , scene: ");
    localStringBuilder.append(CERenderService.a(this.this$0).a());
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    CERenderService.a(this.this$0).a(true);
    localObject = CERenderService.a(this.this$0).a();
    if (localObject != null)
    {
      ((CEScriptService)localObject).a();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.cmshow.crossengine.CEScriptService");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CERenderService.evaluateBusinessScript.1
 * JD-Core Version:    0.7.0.1
 */