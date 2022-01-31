import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class nui
  implements View.OnClickListener
{
  nui(nuh paramnuh, int paramInt, JSONObject paramJSONObject, Context paramContext, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if ((nuh.a(this.jdField_a_of_type_Nuh) != null) && (nuh.a(this.jdField_a_of_type_Nuh).isShowing())) {
        nuh.a(this.jdField_a_of_type_Nuh).dismiss();
      }
      return;
      paramView = this.jdField_a_of_type_OrgJsonJSONObject.optString("action_url", "");
      if (!bdnn.a(paramView))
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        localIntent.putExtra("url", paramView);
        localIntent.putExtra("big_brother_source_key", "biz_src_gzh_qqgw");
        ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivity(localIntent);
        continue;
        ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForArkApp))
        {
          paramView = (MessageForArkApp)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if (paramView.arkContainer != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("EcshopAdHelper", 2, "doOnEvent ARKAPP_TYPE_DESTROY");
            }
            paramView.arkContainer.doOnEvent(2);
          }
        }
        ((nud)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(139)).a(8, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131692458), 1).a();
        continue;
        ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForArkApp))
        {
          paramView = (MessageForArkApp)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if (paramView.arkContainer != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("EcshopAdHelper", 2, "doOnEvent ARKAPP_TYPE_DESTROY");
            }
            paramView.arkContainer.doOnEvent(2);
          }
        }
        ((nud)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(139)).a(7, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131692458), 1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nui
 * JD-Core Version:    0.7.0.1
 */