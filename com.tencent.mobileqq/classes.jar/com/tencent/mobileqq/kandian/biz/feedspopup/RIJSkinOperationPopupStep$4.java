package com.tencent.mobileqq.kandian.biz.feedspopup;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.skin.GuideData;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinGuideView;
import com.tencent.mobileqq.kandian.biz.skin.RefreshData;
import com.tencent.mobileqq.kandian.biz.skin.entity.SkinData;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class RIJSkinOperationPopupStep$4
  implements View.OnClickListener
{
  RIJSkinOperationPopupStep$4(RIJSkinOperationPopupStep paramRIJSkinOperationPopupStep, QQAppInterface paramQQAppInterface, FrameLayout paramFrameLayout, GuideData paramGuideData) {}
  
  public void onClick(View paramView)
  {
    paramView = (ReadInJoyRefreshManager)this.a.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
    if (paramView.d() == 1)
    {
      paramView.a(false);
      paramView = paramView.a(RIJSkinOperationPopupStep.a(this.d), 0);
      if (paramView != null)
      {
        paramView.isShown = false;
        SharedPreUtils.f(RIJSkinOperationPopupStep.a(this.d), this.a.getCurrentAccountUin(), paramView.toJson().toString(), 0);
      }
    }
    RIJSkinOperationPopupStep.b(this.d).a();
    this.b.removeView(RIJSkinOperationPopupStep.b(this.d));
    RIJSkinOperationPopupStep.a(this.d, null);
    SharedPreUtils.u(RIJSkinOperationPopupStep.a(this.d), this.a.getCurrentAccountUin(), this.c.skinData.toJson().toString());
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("set skin: id = ");
      paramView.append(this.c.skinData.id);
      QLog.d("RIJSkinOperationPopupStep", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feedspopup.RIJSkinOperationPopupStep.4
 * JD-Core Version:    0.7.0.1
 */