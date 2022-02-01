package com.tencent.tkd.topicsdk.publisharticle.selectPopup;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "selectionStart", "", "<anonymous parameter 1>", "invoke"}, k=3, mv={1, 1, 16})
final class SelectPopupController$selectionChangeListener$1
  extends Lambda
  implements Function2<Integer, Integer, Unit>
{
  SelectPopupController$selectionChangeListener$1(SelectPopupController paramSelectPopupController)
  {
    super(2);
  }
  
  public final void invoke(int paramInt1, int paramInt2)
  {
    if (SelectPopupController.a(this.this$0).isShowing())
    {
      if ((paramInt1 > SelectPopupController.a(this.this$0)) && (paramInt1 <= SelectPopupController.a(this.this$0) + SelectPopupController.b(this.this$0) + 1)) {
        paramInt1 = 0;
      } else {
        paramInt1 = 1;
      }
      if (paramInt1 != 0) {
        this.this$0.a(1);
      }
      paramInt1 = SelectPopupController.c(this.this$0);
      SelectPopupController.c(this.this$0, false, false, 3, null);
      if (SelectPopupController.c(this.this$0) < paramInt1)
      {
        SelectPopupController.a(this.this$0, false, true);
        return;
      }
      if (paramInt1 < SelectPopupController.c(this.this$0)) {
        SelectPopupController.a(this.this$0, true, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.selectPopup.SelectPopupController.selectionChangeListener.1
 * JD-Core Version:    0.7.0.1
 */