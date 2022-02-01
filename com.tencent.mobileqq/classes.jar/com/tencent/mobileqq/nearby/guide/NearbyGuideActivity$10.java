package com.tencent.mobileqq.nearby.guide;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileCardConstants;

class NearbyGuideActivity$10
  implements View.OnClickListener
{
  NearbyGuideActivity$10(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.mPromptDialog != null) && (!this.a.isFinishing()))
    {
      this.a.mPromptDialog.dismiss();
      paramView = this.a;
      paramView.mPromptDialog = null;
      paramView.showProcessDialog(HardCodeUtil.a(2131707218));
      if (this.a.mCardHandler == null)
      {
        paramView = this.a;
        paramView.mCardHandler = ((INearbyCardHandler)paramView.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER));
      }
      this.a.mCardHandler.a(NearbyProfileCardConstants.a, 5);
      this.a.doClickReport("0X8005909");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.10
 * JD-Core Version:    0.7.0.1
 */