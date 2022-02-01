package com.tencent.mobileqq.onlinestatus.view;

import android.content.Context;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.onlinestatus.constellation.ExtensionBizInfoHelper;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "com/tencent/mobileqq/onlinestatus/view/ConstellationView$bindView$4$1$1"}, k=3, mv={1, 1, 16})
final class ConstellationView$bindView$$inlined$apply$lambda$1$1
  extends Lambda
  implements Function0<Unit>
{
  ConstellationView$bindView$$inlined$apply$lambda$1$1(ConstellationView.bindView..inlined.apply.lambda.1 param1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (AppNetConnInfo.isNetSupport())
    {
      ExtensionBizInfoHelper.a.a(ConstellationView.a(this.this$0.a), 1040);
      return;
    }
    QQToast.a((Context)this.this$0.a.a(), 1, 2131719505, 0).a();
    this.this$0.a.a.a(1040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.ConstellationView.bindView..inlined.apply.lambda.1.1
 * JD-Core Version:    0.7.0.1
 */