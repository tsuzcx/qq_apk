package com.tencent.timi.game.component.chat.input;

import android.content.Context;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onSoftInputChanged"}, k=3, mv={1, 1, 16})
final class TimiBaseInputView$layoutListener$1
  implements KeyboardUtils.OnSoftInputChangedListener
{
  TimiBaseInputView$layoutListener$1(TimiBaseInputView paramTimiBaseInputView) {}
  
  public final void a(int paramInt)
  {
    if (paramInt > 0)
    {
      TimiInputUtil localTimiInputUtil = TimiInputUtil.a;
      BaseApplication localBaseApplication = MobileQQ.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "MobileQQ.getContext()");
      localTimiInputUtil.a((Context)localBaseApplication, paramInt);
      TimiBaseInputView.a(this.a, paramInt);
      this.a.setState(2);
      return;
    }
    if (this.a.getCurrentState() == 2) {
      this.a.setState(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.TimiBaseInputView.layoutListener.1
 * JD-Core Version:    0.7.0.1
 */