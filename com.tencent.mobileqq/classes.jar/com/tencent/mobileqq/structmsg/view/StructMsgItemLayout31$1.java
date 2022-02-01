package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StructMsgItemLayout31$1
  implements View.OnClickListener
{
  StructMsgItemLayout31$1(StructMsgItemLayout31 paramStructMsgItemLayout31, String paramString1, Context paramContext, String paramString2, String paramString3) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      int i = this.jdField_a_of_type_JavaLangString.indexOf(':');
      if (i != -1)
      {
        Object localObject = this.jdField_a_of_type_JavaLangString.substring(0, i);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).toLowerCase();
          try
          {
            if ((((String)localObject).compareTo("http") != 0) && (((String)localObject).compareTo("https") != 0))
            {
              if (((String)localObject).compareTo("mqqapi") == 0)
              {
                localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class);
                ((Intent)localObject).setData(Uri.parse(this.jdField_a_of_type_JavaLangString));
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
              }
            }
            else
            {
              localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
              ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
            }
          }
          catch (Throwable localThrowable)
          {
            if (QLog.isDevelopLevel()) {
              localThrowable.printStackTrace();
            }
          }
          ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "public.tailad.click", 0, 0, "", ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getString(this.b, "walletPubMsgTail_busiType", ""), this.c, "");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout31.1
 * JD-Core Version:    0.7.0.1
 */