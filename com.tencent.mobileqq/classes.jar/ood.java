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
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ood
  implements View.OnClickListener
{
  ood(oob paramoob, Context paramContext, TextView paramTextView, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    int k;
    int m;
    try
    {
      ViewGroup localViewGroup = (ViewGroup)((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().mAIORootView.findViewById(2131362716);
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
      oob.a(this.jdField_a_of_type_Oob, localObject[0]);
      oob.b(this.jdField_a_of_type_Oob, localObject[1]);
      k = oob.a(this.jdField_a_of_type_Oob).getContentView().getMeasuredHeight();
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopAdHelper", 2, "popheight: " + k);
      }
      m = this.jdField_a_of_type_AndroidWidgetTextView.getHeight();
      if (oob.a(this.jdField_a_of_type_Oob) - i + m + k <= j) {
        break label322;
      }
    }
    oob.a(this.jdField_a_of_type_Oob).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847112));
    oob.a(this.jdField_a_of_type_Oob).showAtLocation(this.jdField_a_of_type_AndroidWidgetTextView, 0, oob.b(this.jdField_a_of_type_Oob), oob.a(this.jdField_a_of_type_Oob) - k);
    for (;;)
    {
      ((onx)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER)).a(9, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      localObject = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).alpha = 0.5F;
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      oob.a(this.jdField_a_of_type_Oob).setOnDismissListener(new ooe(this));
      break;
      label322:
      oob.a(this.jdField_a_of_type_Oob).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847111));
      oob.a(this.jdField_a_of_type_Oob).showAtLocation(this.jdField_a_of_type_AndroidWidgetTextView, 0, oob.b(this.jdField_a_of_type_Oob), m + oob.a(this.jdField_a_of_type_Oob));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ood
 * JD-Core Version:    0.7.0.1
 */