package com.tencent.tkd.topicsdk.widget.dialog;

import android.content.Context;
import android.view.View;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.common.InputMethodUtils;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class SimpleMessageDialog$onAttachedToWindow$1
  implements Runnable
{
  SimpleMessageDialog$onAttachedToWindow$1(SimpleMessageDialog paramSimpleMessageDialog) {}
  
  public final void run()
  {
    SimpleMessageDialog.a(this.this$0).requestFocus();
    Object localObject1 = SimpleMessageDialog.a(this.this$0);
    Object localObject2 = DisplayUtils.a;
    Context localContext = this.this$0.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = ((DisplayUtils)localObject2).a(localContext);
    localObject2 = DisplayUtils.a;
    localContext = this.this$0.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((RichEditText)localObject1).setMinWidth(i - ((DisplayUtils)localObject2).a(localContext, 150.0F));
    localObject1 = InputMethodUtils.a;
    localObject2 = this.this$0.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    ((InputMethodUtils)localObject1).a((Context)localObject2, (View)SimpleMessageDialog.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.dialog.SimpleMessageDialog.onAttachedToWindow.1
 * JD-Core Version:    0.7.0.1
 */