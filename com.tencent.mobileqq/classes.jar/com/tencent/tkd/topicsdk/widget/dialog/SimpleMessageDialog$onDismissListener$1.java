package com.tencent.tkd.topicsdk.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class SimpleMessageDialog$onDismissListener$1
  implements View.OnClickListener
{
  SimpleMessageDialog$onDismissListener$1(SimpleMessageDialog paramSimpleMessageDialog, Function2 paramFunction2) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
    if (paramView != null) {
      paramView = (Unit)paramView.invoke(SimpleMessageDialog.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogSimpleMessageDialog).getText().toString(), Integer.valueOf(2));
    }
    SimpleMessageDialog.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogSimpleMessageDialog).setText((CharSequence)"");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogSimpleMessageDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.dialog.SimpleMessageDialog.onDismissListener.1
 * JD-Core Version:    0.7.0.1
 */