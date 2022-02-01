import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class odn
  implements View.OnClickListener
{
  odn(odl paramodl, Context paramContext, TextView paramTextView, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    int k;
    int m;
    try
    {
      ViewGroup localViewGroup = (ViewGroup)((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().c.findViewById(2131362680);
      if (localViewGroup == null)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = null;
      }
      int[] arrayOfInt = new int[2];
      ((ViewGroup)localObject).getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[1];
      int j = ((ViewGroup)localObject).getHeight();
      localObject = new int[2];
      this.jdField_a_of_type_AndroidWidgetTextView.getLocationOnScreen((int[])localObject);
      odl.a(this.jdField_a_of_type_Odl, localObject[0]);
      odl.b(this.jdField_a_of_type_Odl, localObject[1]);
      k = odl.a(this.jdField_a_of_type_Odl).getContentView().getMeasuredHeight();
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopAdHelper", 2, "popheight: " + k);
      }
      m = this.jdField_a_of_type_AndroidWidgetTextView.getHeight();
      if (odl.a(this.jdField_a_of_type_Odl) - i + m + k <= j) {
        break label322;
      }
    }
    odl.a(this.jdField_a_of_type_Odl).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847089));
    odl.a(this.jdField_a_of_type_Odl).showAtLocation(this.jdField_a_of_type_AndroidWidgetTextView, 0, odl.b(this.jdField_a_of_type_Odl), odl.a(this.jdField_a_of_type_Odl) - k);
    for (;;)
    {
      ((odh)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(139)).a(9, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      localObject = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).alpha = 0.5F;
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      odl.a(this.jdField_a_of_type_Odl).setOnDismissListener(new odo(this));
      break;
      label322:
      odl.a(this.jdField_a_of_type_Odl).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847088));
      odl.a(this.jdField_a_of_type_Odl).showAtLocation(this.jdField_a_of_type_AndroidWidgetTextView, 0, odl.b(this.jdField_a_of_type_Odl), m + odl.a(this.jdField_a_of_type_Odl));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odn
 * JD-Core Version:    0.7.0.1
 */