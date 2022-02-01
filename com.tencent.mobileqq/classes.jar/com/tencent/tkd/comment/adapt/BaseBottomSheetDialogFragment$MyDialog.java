package com.tencent.tkd.comment.adapt;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tkd.comment.util.CommonUtil;

class BaseBottomSheetDialogFragment$MyDialog
  extends ReportDialog
{
  private DialogInterface.OnDismissListener dismissListener;
  private DialogInterface.OnCancelListener onCancelListener;
  
  BaseBottomSheetDialogFragment$MyDialog(BaseBottomSheetDialogFragment paramBaseBottomSheetDialogFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void dismiss()
  {
    BaseBottomSheetDialogFragment.access$200(this.this$0, this, BaseBottomSheetDialogFragment.access$100(this.this$0));
  }
  
  public void setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.onCancelListener = paramOnCancelListener;
    super.setOnCancelListener(new BaseBottomSheetDialogFragment.MyDialog.WrappedCancelListener(this, paramOnCancelListener));
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.dismissListener = paramOnDismissListener;
    super.setOnDismissListener(new BaseBottomSheetDialogFragment.MyDialog.WrappedDismissDialogListener(this, paramOnDismissListener));
  }
  
  public void show()
  {
    if (this.this$0.needHideNavigationBar())
    {
      Window localWindow = getWindow();
      localWindow.setFlags(8, 8);
      super.show();
      CommonUtil.hideNavigationBar(localWindow);
      localWindow.clearFlags(8);
      return;
    }
    super.show();
  }
  
  void superDismiss()
  {
    super.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.adapt.BaseBottomSheetDialogFragment.MyDialog
 * JD-Core Version:    0.7.0.1
 */