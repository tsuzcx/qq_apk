package com.tencent.tkd.topicsdk.publisharticle.selectPopup;

import android.app.Activity;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "invoke", "com/tencent/tkd/topicsdk/publisharticle/selectPopup/SelectPopupController$Companion$init$1$2$2", "com/tencent/tkd/topicsdk/publisharticle/selectPopup/SelectPopupController$Companion$$special$$inlined$also$lambda$2"}, k=3, mv={1, 1, 16})
final class SelectPopupController$Companion$init$$inlined$apply$lambda$2
  extends Lambda
  implements Function0<Unit>
{
  SelectPopupController$Companion$init$$inlined$apply$lambda$2(SelectPopupController paramSelectPopupController, RichEditText paramRichEditText, Activity paramActivity, ISelectPopupModel paramISelectPopupModel)
  {
    super(0);
  }
  
  public final void invoke()
  {
    int i;
    if (((CharSequence)SelectPopupController.c(this.$this_apply$inlined).a()).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.$this_apply$inlined.a(3);
      return;
    }
    Object localObject = this.$model$inlined.a(SelectPopupController.c(this.$this_apply$inlined).a());
    Function3 localFunction3 = this.$this_apply$inlined.a();
    if (localFunction3 != null) {
      localObject = (Unit)localFunction3.invoke(Integer.valueOf(SelectPopupController.a(this.$this_apply$inlined)), Boolean.valueOf(false), localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.selectPopup.SelectPopupController.Companion.init..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */