import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.widget.BubblePopupWindow;

class ohv
  implements View.OnClickListener
{
  ohv(ohs paramohs, oif paramoif, TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2, Activity paramActivity, BubblePopupWindow paramBubblePopupWindow) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    int i;
    switch (paramView.getId())
    {
    default: 
      i = -1;
      label50:
      if (this.jdField_a_of_type_Ohs.a != null)
      {
        paramView = this.jdField_a_of_type_Ohs.a;
        if (!(this.jdField_a_of_type_Ohs instanceof ogn)) {
          break label251;
        }
      }
      break;
    }
    for (;;)
    {
      paramView.a(j, i, this.jdField_a_of_type_Oif);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      return;
      paramView = (ClipboardManager)paramView.getContext().getSystemService("clipboard");
      if (TextUtils.isEmpty(this.jdField_a_of_type_Oif.a)) {
        break;
      }
      paramView.setText(this.jdField_a_of_type_Oif.a);
      i = -1;
      break label50;
      this.jdField_a_of_type_Ohs.d(this.jdField_a_of_type_Oif);
      i = 1;
      break label50;
      this.jdField_a_of_type_Ohs.e(this.jdField_a_of_type_Oif);
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_Boolean) {}
      for (paramView = ajya.a(2131712734);; paramView = ajya.a(2131712799))
      {
        localTextView.setText(paramView);
        i = 5;
        break;
      }
      if (this.b)
      {
        this.jdField_a_of_type_Ohs.c(this.jdField_a_of_type_Oif);
        i = 4;
        break label50;
      }
      this.jdField_a_of_type_Ohs.a(this.jdField_a_of_type_AndroidAppActivity, new ohw(this));
      i = 3;
      break label50;
      label251:
      j = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ohv
 * JD-Core Version:    0.7.0.1
 */