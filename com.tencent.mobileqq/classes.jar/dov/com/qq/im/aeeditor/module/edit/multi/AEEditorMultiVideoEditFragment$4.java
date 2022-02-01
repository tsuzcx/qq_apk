package dov.com.qq.im.aeeditor.module.edit.multi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.aeeditor.AEEditorModuleManager;

class AEEditorMultiVideoEditFragment$4
  implements DialogInterface.OnClickListener
{
  AEEditorMultiVideoEditFragment$4(AEEditorMultiVideoEditFragment paramAEEditorMultiVideoEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AEBaseDataReporter.a().p();
    this.a.getArguments().putSerializable("resource_model", null);
    this.a.getArguments().putSerializable("resource_model", AEEditorMultiVideoEditFragment.a(this.a));
    this.a.a().a(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiVideoEditFragment.4
 * JD-Core Version:    0.7.0.1
 */