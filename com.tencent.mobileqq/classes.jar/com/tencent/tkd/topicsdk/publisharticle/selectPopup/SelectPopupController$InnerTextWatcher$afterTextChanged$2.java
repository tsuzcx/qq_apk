package com.tencent.tkd.topicsdk.publisharticle.selectPopup;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "type", "", "invoke"}, k=3, mv={1, 1, 16})
final class SelectPopupController$InnerTextWatcher$afterTextChanged$2
  extends Lambda
  implements Function1<Integer, Unit>
{
  SelectPopupController$InnerTextWatcher$afterTextChanged$2(SelectPopupController.InnerTextWatcher paramInnerTextWatcher)
  {
    super(1);
  }
  
  public final void invoke(int paramInt)
  {
    SelectPopupView localSelectPopupView = SelectPopupController.a(this.this$0.a);
    if (paramInt == 1) {
      localSelectPopupView.a(SelectPopupController.a(this.this$0.a).a(this.this$0.a(), paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.selectPopup.SelectPopupController.InnerTextWatcher.afterTextChanged.2
 * JD-Core Version:    0.7.0.1
 */