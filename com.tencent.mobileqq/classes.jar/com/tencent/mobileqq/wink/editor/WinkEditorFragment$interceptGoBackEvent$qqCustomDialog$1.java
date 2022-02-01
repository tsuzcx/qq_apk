package com.tencent.mobileqq.wink.editor;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"}, k=3, mv={1, 1, 16})
final class WinkEditorFragment$interceptGoBackEvent$qqCustomDialog$1
  implements DialogInterface.OnClickListener
{
  WinkEditorFragment$interceptGoBackEvent$qqCustomDialog$1(WinkEditorFragment paramWinkEditorFragment) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    WinkEditorFragment.c(this.a).a(this.a.getContext());
    this.a.requireActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorFragment.interceptGoBackEvent.qqCustomDialog.1
 * JD-Core Version:    0.7.0.1
 */