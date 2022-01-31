import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class nuj
  implements View.OnClickListener
{
  nuj(nuh paramnuh, Context paramContext, TextView paramTextView, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    int k;
    int m;
    try
    {
      paramView = (ViewGroup)((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().c.findViewById(2131362578);
      if (paramView == null) {
        return;
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView = null;
      }
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[1];
      int j = paramView.getHeight();
      paramView = new int[2];
      this.jdField_a_of_type_AndroidWidgetTextView.getLocationOnScreen(paramView);
      nuh.a(this.jdField_a_of_type_Nuh, paramView[0]);
      nuh.b(this.jdField_a_of_type_Nuh, paramView[1]);
      k = nuh.a(this.jdField_a_of_type_Nuh).getContentView().getMeasuredHeight();
      if (QLog.isColorLevel()) {
        QLog.i("parsons", 2, "popheight: " + k);
      }
      m = this.jdField_a_of_type_AndroidWidgetTextView.getHeight();
      if (nuh.a(this.jdField_a_of_type_Nuh) - i + m + k <= j) {
        break label300;
      }
    }
    nuh.a(this.jdField_a_of_type_Nuh).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846574));
    nuh.a(this.jdField_a_of_type_Nuh).showAtLocation(this.jdField_a_of_type_AndroidWidgetTextView, 0, nuh.b(this.jdField_a_of_type_Nuh), nuh.a(this.jdField_a_of_type_Nuh) - k);
    for (;;)
    {
      ((nud)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(139)).a(9, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      paramView = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getAttributes();
      paramView.alpha = 0.5F;
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().setAttributes(paramView);
      nuh.a(this.jdField_a_of_type_Nuh).setOnDismissListener(new nuk(this));
      return;
      label300:
      nuh.a(this.jdField_a_of_type_Nuh).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846573));
      nuh.a(this.jdField_a_of_type_Nuh).showAtLocation(this.jdField_a_of_type_AndroidWidgetTextView, 0, nuh.b(this.jdField_a_of_type_Nuh), m + nuh.a(this.jdField_a_of_type_Nuh));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nuj
 * JD-Core Version:    0.7.0.1
 */