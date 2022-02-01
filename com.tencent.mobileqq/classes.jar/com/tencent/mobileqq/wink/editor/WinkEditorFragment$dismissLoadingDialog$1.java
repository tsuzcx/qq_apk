package com.tencent.mobileqq.wink.editor;

import android.app.Dialog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$dismissLoadingDialog$1
  implements Runnable
{
  WinkEditorFragment$dismissLoadingDialog$1(WinkEditorFragment paramWinkEditorFragment) {}
  
  public final void run()
  {
    Dialog localDialog = WinkEditorFragment.s(this.this$0);
    if (localDialog != null) {
      localDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.dismissLoadingDialog.1
 * JD-Core Version:    0.7.0.1
 */