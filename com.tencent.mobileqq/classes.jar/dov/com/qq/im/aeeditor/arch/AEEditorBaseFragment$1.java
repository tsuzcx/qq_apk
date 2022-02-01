package dov.com.qq.im.aeeditor.arch;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import bnzb;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import dov.com.qq.im.aeeditor.view.ProgressView;

class AEEditorBaseFragment$1
  implements Runnable
{
  AEEditorBaseFragment$1(AEEditorBaseFragment paramAEEditorBaseFragment, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean, CharSequence paramCharSequence) {}
  
  public void run()
  {
    if (this.this$0.getActivity().isFinishing())
    {
      bnzb.c(AEEditorBaseFragment.b(), "Activity has been destroy.");
      return;
    }
    if (this.this$0.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.this$0.jdField_a_of_type_DovComQqImAeeditorViewProgressView = new ProgressView(this.jdField_a_of_type_AndroidContentContext);
      this.this$0.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_AndroidContentContext);
      this.this$0.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      this.this$0.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.this$0.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.this$0.jdField_a_of_type_AndroidAppDialog.setContentView(this.this$0.jdField_a_of_type_DovComQqImAeeditorViewProgressView);
      this.this$0.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_AndroidAppDialog.setCancelable(this.jdField_a_of_type_Boolean);
      this.this$0.jdField_a_of_type_DovComQqImAeeditorViewProgressView.setProgressText(this.jdField_a_of_type_JavaLangCharSequence);
      this.this$0.jdField_a_of_type_AndroidAppDialog.show();
      return;
      this.this$0.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */