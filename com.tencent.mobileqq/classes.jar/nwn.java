import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.widget.BubblePopupWindow;

class nwn
  implements View.OnClickListener
{
  nwn(nwk paramnwk, nwx paramnwx, TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2, Activity paramActivity, BubblePopupWindow paramBubblePopupWindow) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    int i;
    switch (paramView.getId())
    {
    default: 
      i = -1;
      label50:
      if (this.jdField_a_of_type_Nwk.a != null)
      {
        paramView = this.jdField_a_of_type_Nwk.a;
        if (!(this.jdField_a_of_type_Nwk instanceof nvf)) {
          break label251;
        }
      }
      break;
    }
    for (;;)
    {
      paramView.a(j, i, this.jdField_a_of_type_Nwx);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      return;
      paramView = (ClipboardManager)paramView.getContext().getSystemService("clipboard");
      if (TextUtils.isEmpty(this.jdField_a_of_type_Nwx.a)) {
        break;
      }
      paramView.setText(this.jdField_a_of_type_Nwx.a);
      i = -1;
      break label50;
      this.jdField_a_of_type_Nwk.d(this.jdField_a_of_type_Nwx);
      i = 1;
      break label50;
      this.jdField_a_of_type_Nwk.e(this.jdField_a_of_type_Nwx);
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_Boolean) {}
      for (paramView = ajjy.a(2131646935);; paramView = ajjy.a(2131647000))
      {
        localTextView.setText(paramView);
        i = 5;
        break;
      }
      if (this.b)
      {
        this.jdField_a_of_type_Nwk.c(this.jdField_a_of_type_Nwx);
        i = 4;
        break label50;
      }
      this.jdField_a_of_type_Nwk.a(this.jdField_a_of_type_AndroidAppActivity, new nwo(this));
      i = 3;
      break label50;
      label251:
      j = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nwn
 * JD-Core Version:    0.7.0.1
 */