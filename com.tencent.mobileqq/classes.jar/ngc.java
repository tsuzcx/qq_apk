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

class ngc
  implements View.OnClickListener
{
  ngc(nga paramnga, Context paramContext, TextView paramTextView, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    int k;
    int m;
    try
    {
      paramView = (ViewGroup)((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().c.findViewById(2131297012);
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
      nga.a(this.jdField_a_of_type_Nga, paramView[0]);
      nga.b(this.jdField_a_of_type_Nga, paramView[1]);
      k = nga.a(this.jdField_a_of_type_Nga).getContentView().getMeasuredHeight();
      if (QLog.isColorLevel()) {
        QLog.i("parsons", 2, "popheight: " + k);
      }
      m = this.jdField_a_of_type_AndroidWidgetTextView.getHeight();
      if (nga.a(this.jdField_a_of_type_Nga) - i + m + k <= j) {
        break label300;
      }
    }
    nga.a(this.jdField_a_of_type_Nga).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846008));
    nga.a(this.jdField_a_of_type_Nga).showAtLocation(this.jdField_a_of_type_AndroidWidgetTextView, 0, nga.b(this.jdField_a_of_type_Nga), nga.a(this.jdField_a_of_type_Nga) - k);
    for (;;)
    {
      ((nfw)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(139)).a(9, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      paramView = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getAttributes();
      paramView.alpha = 0.5F;
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().setAttributes(paramView);
      nga.a(this.jdField_a_of_type_Nga).setOnDismissListener(new ngd(this));
      return;
      label300:
      nga.a(this.jdField_a_of_type_Nga).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846007));
      nga.a(this.jdField_a_of_type_Nga).showAtLocation(this.jdField_a_of_type_AndroidWidgetTextView, 0, nga.b(this.jdField_a_of_type_Nga), m + nga.a(this.jdField_a_of_type_Nga));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngc
 * JD-Core Version:    0.7.0.1
 */