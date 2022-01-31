import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.widget.BubblePopupWindow;

class omj
  implements View.OnClickListener
{
  omj(omg paramomg, omt paramomt, TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2, Activity paramActivity, BubblePopupWindow paramBubblePopupWindow) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    int i;
    switch (paramView.getId())
    {
    default: 
      i = -1;
      label50:
      if (this.jdField_a_of_type_Omg.a != null)
      {
        paramView = this.jdField_a_of_type_Omg.a;
        if (!(this.jdField_a_of_type_Omg instanceof ola)) {
          break label251;
        }
      }
      break;
    }
    for (;;)
    {
      paramView.a(j, i, this.jdField_a_of_type_Omt);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      return;
      paramView = (ClipboardManager)paramView.getContext().getSystemService("clipboard");
      if (TextUtils.isEmpty(this.jdField_a_of_type_Omt.a)) {
        break;
      }
      paramView.setText(this.jdField_a_of_type_Omt.a);
      i = -1;
      break label50;
      this.jdField_a_of_type_Omg.d(this.jdField_a_of_type_Omt);
      i = 1;
      break label50;
      this.jdField_a_of_type_Omg.e(this.jdField_a_of_type_Omt);
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_Boolean) {}
      for (paramView = alpo.a(2131713106);; paramView = alpo.a(2131713171))
      {
        localTextView.setText(paramView);
        i = 5;
        break;
      }
      if (this.b)
      {
        this.jdField_a_of_type_Omg.c(this.jdField_a_of_type_Omt);
        i = 4;
        break label50;
      }
      this.jdField_a_of_type_Omg.a(this.jdField_a_of_type_AndroidAppActivity, new omk(this));
      i = 3;
      break label50;
      label251:
      j = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     omj
 * JD-Core Version:    0.7.0.1
 */