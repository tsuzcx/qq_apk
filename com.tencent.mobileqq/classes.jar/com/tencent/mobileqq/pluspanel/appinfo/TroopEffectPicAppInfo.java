package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsController;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopEffectPicAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130851187;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 1106194086;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131697708);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (SharedPreUtils.q(paramBaseChatPie.a(), paramBaseChatPie.a.getCurrentAccountUin())) {
      TroopPicEffectsEditActivity.a(paramBaseChatPie.a(), paramSessionInfo.a, paramSessionInfo.b);
    }
    for (;;)
    {
      TroopPicEffectsController.a("app_entry", "page_clk");
      return;
      SharedPreUtils.z(paramBaseChatPie.a(), paramBaseChatPie.a.getCurrentAccountUin());
      paramPlusPanelViewModel = new Intent(paramBaseChatPie.a(), TroopPicEffectGuidePicActivity.class);
      paramPlusPanelViewModel.putExtra("friendUin", paramSessionInfo.a);
      paramPlusPanelViewModel.putExtra("troopUin", paramSessionInfo.b);
      paramBaseChatPie.a().startActivity(paramPlusPanelViewModel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TroopEffectPicAppInfo
 * JD-Core Version:    0.7.0.1
 */