package com.tencent.mobileqq.kandian.biz.feedspopup;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinGuideView;
import com.tencent.mobileqq.utils.SharedPreUtils;

class RIJSkinOperationPopupStep$3
  implements View.OnClickListener
{
  RIJSkinOperationPopupStep$3(RIJSkinOperationPopupStep paramRIJSkinOperationPopupStep, FrameLayout paramFrameLayout, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    RIJSkinOperationPopupStep.b(this.d).a();
    this.a.removeView(RIJSkinOperationPopupStep.b(this.d));
    RIJSkinOperationPopupStep.a(this.d, null);
    if (QQManagerFactory.READ_INJOY_SKIN_MANAGER == this.b) {
      SharedPreUtils.u(RIJSkinOperationPopupStep.a(this.d), this.c.getCurrentAccountUin(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feedspopup.RIJSkinOperationPopupStep.3
 * JD-Core Version:    0.7.0.1
 */