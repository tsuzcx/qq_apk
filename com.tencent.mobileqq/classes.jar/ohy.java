import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.widget.BubblePopupWindow;

class ohy
  implements View.OnClickListener
{
  ohy(ohv paramohv, oii paramoii, TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2, Activity paramActivity, BubblePopupWindow paramBubblePopupWindow) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    int i;
    switch (paramView.getId())
    {
    default: 
      i = -1;
      label50:
      if (this.jdField_a_of_type_Ohv.a != null)
      {
        paramView = this.jdField_a_of_type_Ohv.a;
        if (!(this.jdField_a_of_type_Ohv instanceof ogq)) {
          break label251;
        }
      }
      break;
    }
    for (;;)
    {
      paramView.a(j, i, this.jdField_a_of_type_Oii);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      return;
      paramView = (ClipboardManager)paramView.getContext().getSystemService("clipboard");
      if (TextUtils.isEmpty(this.jdField_a_of_type_Oii.a)) {
        break;
      }
      paramView.setText(this.jdField_a_of_type_Oii.a);
      i = -1;
      break label50;
      this.jdField_a_of_type_Ohv.d(this.jdField_a_of_type_Oii);
      i = 1;
      break label50;
      this.jdField_a_of_type_Ohv.e(this.jdField_a_of_type_Oii);
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_Boolean) {}
      for (paramView = ajyc.a(2131712723);; paramView = ajyc.a(2131712788))
      {
        localTextView.setText(paramView);
        i = 5;
        break;
      }
      if (this.b)
      {
        this.jdField_a_of_type_Ohv.c(this.jdField_a_of_type_Oii);
        i = 4;
        break label50;
      }
      this.jdField_a_of_type_Ohv.a(this.jdField_a_of_type_AndroidAppActivity, new ohz(this));
      i = 3;
      break label50;
      label251:
      j = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ohy
 * JD-Core Version:    0.7.0.1
 */