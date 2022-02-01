package com.tencent.timi.game.api.impl;

import android.content.DialogInterface;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.ui.widget.EmptyDialog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TimiGameApp$startTask$initTaskWrapper$1$1
  implements Runnable
{
  TimiGameApp$startTask$initTaskWrapper$1$1(TimiGameApp.startTask.initTaskWrapper.1 param1, Ref.ObjectRef paramObjectRef) {}
  
  public final void run()
  {
    if (!((AtomicBoolean)this.a.element).get())
    {
      EmptyDialog localEmptyDialog = (EmptyDialog)this.this$0.d.element;
      if (localEmptyDialog != null)
      {
        localEmptyDialog.show();
        LoadingUtils.a.a((DialogInterface)localEmptyDialog);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.impl.TimiGameApp.startTask.initTaskWrapper.1.1
 * JD-Core Version:    0.7.0.1
 */