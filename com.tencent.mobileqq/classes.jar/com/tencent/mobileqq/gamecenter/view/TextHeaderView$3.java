package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class TextHeaderView$3
  implements View.OnClickListener
{
  TextHeaderView$3(TextHeaderView paramTextHeaderView, Context paramContext, QQGameMsgInfo paramQQGameMsgInfo, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView)))
    {
      Object localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView));
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      localObject = new HashMap();
      ((Map)localObject).put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.gameAppId);
      ((Map)localObject).put(Integer.valueOf(3), this.jdField_a_of_type_Int + "");
      ((Map)localObject).put(Integer.valueOf(4), "20");
      ((Map)localObject).put(Integer.valueOf(24), this.jdField_a_of_type_JavaLangString);
      GameCenterUtils.a(CmGameUtil.a(), "769", "205019", this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.gameAppId, "76901", "1", "160", (Map)localObject);
      ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).reportGamePubAccountMsgStatus(3, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo.paMsgid, TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewTextHeaderView));
    }
    try
    {
      QQGameHelper.a(118, this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameMsgInfo, this.jdField_a_of_type_Int);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.TextHeaderView.3
 * JD-Core Version:    0.7.0.1
 */