package com.tencent.mobileqq.businessCard.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class BusinessCardEditActivity$12
  implements ActionSheet.OnButtonClickListener
{
  BusinessCardEditActivity$12(BusinessCardEditActivity paramBusinessCardEditActivity, String paramString, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        paramView = this.a;
        if ((paramView != null) && (paramView.length() > 0))
        {
          paramView = new Intent();
          paramView.setAction("android.intent.action.SENDTO");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("smsto:");
          localStringBuilder.append(this.a);
          paramView.setData(Uri.parse(localStringBuilder.toString()));
          this.c.getActivity().startActivity(paramView);
        }
        else
        {
          this.c.a(2131890884, 1);
        }
      }
    }
    else
    {
      paramView = this.a;
      if ((paramView != null) && (paramView.length() > 0))
      {
        paramView = new StringBuilder();
        paramView.append("tel:");
        paramView.append(this.a);
        paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramView.toString()));
        this.c.getActivity().startActivity(paramView);
        this.c.app.getCallFacade().b(this.a);
      }
      else
      {
        this.c.a(2131890884, 1);
      }
    }
    this.b.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.12
 * JD-Core Version:    0.7.0.1
 */