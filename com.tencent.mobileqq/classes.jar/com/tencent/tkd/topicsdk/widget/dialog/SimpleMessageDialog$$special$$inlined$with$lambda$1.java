package com.tencent.tkd.topicsdk.widget.dialog;

import android.text.Editable;
import android.widget.TextView;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "curCount", "", "invoke", "com/tencent/tkd/topicsdk/widget/dialog/SimpleMessageDialog$1$1"}, k=3, mv={1, 1, 16})
final class SimpleMessageDialog$$special$$inlined$with$lambda$1
  extends Lambda
  implements Function1<Integer, Unit>
{
  SimpleMessageDialog$$special$$inlined$with$lambda$1(SimpleMessageDialog paramSimpleMessageDialog)
  {
    super(1);
  }
  
  public final void invoke(int paramInt)
  {
    SimpleMessageDialog.b(this.this$0).setText((CharSequence)String.valueOf(this.this$0.a() - paramInt));
    Editable localEditable = SimpleMessageDialog.a(this.this$0).getText();
    Intrinsics.checkExpressionValueIsNotNull(localEditable, "contentView.text");
    boolean bool;
    if (StringsKt.trim((CharSequence)localEditable).length() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    SimpleMessageDialog.a(this.this$0, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.dialog.SimpleMessageDialog..special..inlined.with.lambda.1
 * JD-Core Version:    0.7.0.1
 */