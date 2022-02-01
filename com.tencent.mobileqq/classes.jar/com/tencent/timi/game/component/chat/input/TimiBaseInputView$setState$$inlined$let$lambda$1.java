package com.tencent.timi.game.component.chat.input;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/timi/game/component/chat/input/TimiBaseInputView$setState$1$1"}, k=3, mv={1, 1, 16})
final class TimiBaseInputView$setState$$inlined$let$lambda$1
  implements Runnable
{
  TimiBaseInputView$setState$$inlined$let$lambda$1(TimiBaseInputView paramTimiBaseInputView) {}
  
  public final void run()
  {
    Object localObject1 = TimiBaseInputView.c(this.this$0);
    if (localObject1 != null) {
      localObject1 = ((Context)localObject1).getSystemService("input_method");
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof InputMethodManager)) {
      localObject2 = null;
    }
    localObject1 = (InputMethodManager)localObject2;
    localObject2 = TimiBaseInputView.d(this.this$0);
    if (localObject2 != null)
    {
      localObject2 = ((View)localObject2).getWindowToken();
      if ((localObject2 != null) && (localObject1 != null)) {
        ((InputMethodManager)localObject1).hideSoftInputFromWindow((IBinder)localObject2, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.TimiBaseInputView.setState..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */