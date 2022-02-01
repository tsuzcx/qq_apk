package dov.com.qq.im.aeeditor.module.edit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.aeeditor.AEEditorModuleManager;

class AEEditorVideoEditFragment$28
  implements DialogInterface.OnClickListener
{
  AEEditorVideoEditFragment$28(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.getActivity().getIntent().putExtra("startTimeEdit", AEEditorVideoEditFragment.a(this.a, false));
    this.a.getActivity().getIntent().putExtra("endTimeEdit", AEEditorVideoEditFragment.b(this.a, false));
    this.a.getActivity().getIntent().putExtra("endSpeedEdit", AEEditorVideoEditFragment.a(this.a, false));
    AEBaseDataReporter.a().p();
    this.a.a().a(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment.28
 * JD-Core Version:    0.7.0.1
 */