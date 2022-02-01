package com.tencent.tkd.topicsdk.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"}, k=3, mv={1, 1, 16})
final class SimpleMessageDialog$onDismissListener$2
  implements DialogInterface.OnCancelListener
{
  SimpleMessageDialog$onDismissListener$2(SimpleMessageDialog paramSimpleMessageDialog, Function2 paramFunction2) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
    if (paramDialogInterface != null) {
      paramDialogInterface = (Unit)paramDialogInterface.invoke(SimpleMessageDialog.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogSimpleMessageDialog).getText().toString(), Integer.valueOf(1));
    }
    SimpleMessageDialog.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogSimpleMessageDialog).setText((CharSequence)"");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.dialog.SimpleMessageDialog.onDismissListener.2
 * JD-Core Version:    0.7.0.1
 */