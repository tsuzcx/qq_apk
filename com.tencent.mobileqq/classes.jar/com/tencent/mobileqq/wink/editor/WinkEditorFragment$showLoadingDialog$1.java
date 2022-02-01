package com.tencent.mobileqq.wink.editor;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.wink.editor.view.ProgressView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$showLoadingDialog$1
  implements Runnable
{
  WinkEditorFragment$showLoadingDialog$1(WinkEditorFragment paramWinkEditorFragment, FragmentActivity paramFragmentActivity, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean, CharSequence paramCharSequence) {}
  
  public final void run()
  {
    Object localObject = this.this$0.requireActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "requireActivity()");
    if (((FragmentActivity)localObject).isFinishing())
    {
      AEQLog.c("BasePartFragment", "Activity has been destroy.");
      return;
    }
    if (WinkEditorFragment.s(this.this$0) == null)
    {
      WinkEditorFragment.a(this.this$0, new ProgressView((Context)this.a));
      localObject = this.this$0;
      WinkEditorFragment.a((WinkEditorFragment)localObject, new ReportDialog((Context)((WinkEditorFragment)localObject).getActivity()));
      localObject = WinkEditorFragment.s(this.this$0);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((Dialog)localObject).getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
      localObject = WinkEditorFragment.s(this.this$0);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((Dialog)localObject).setCanceledOnTouchOutside(false);
      localObject = WinkEditorFragment.s(this.this$0);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((Dialog)localObject).requestWindowFeature(1);
      localObject = WinkEditorFragment.s(this.this$0);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((Dialog)localObject).setContentView((View)WinkEditorFragment.t(this.this$0));
      localObject = WinkEditorFragment.s(this.this$0);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((Dialog)localObject).setOnDismissListener(this.b);
    }
    else
    {
      localObject = WinkEditorFragment.s(this.this$0);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((Dialog)localObject).dismiss();
    }
    localObject = WinkEditorFragment.s(this.this$0);
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((Dialog)localObject).setCancelable(this.c);
    WinkEditorFragment.t(this.this$0).setProgressText(this.d);
    localObject = WinkEditorFragment.s(this.this$0);
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((Dialog)localObject).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.showLoadingDialog.1
 * JD-Core Version:    0.7.0.1
 */