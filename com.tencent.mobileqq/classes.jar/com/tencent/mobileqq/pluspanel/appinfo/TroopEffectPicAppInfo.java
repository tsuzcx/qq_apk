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
    return 2130853338;
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
    return BaseApplicationImpl.getContext().getString(2131895487);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (SharedPreUtils.bf(paramBaseChatPie.aX(), paramBaseChatPie.d.getCurrentAccountUin()))
    {
      TroopPicEffectsEditActivity.a(paramBaseChatPie.aX(), paramSessionInfo.b, paramSessionInfo.c);
    }
    else
    {
      SharedPreUtils.bg(paramBaseChatPie.aX(), paramBaseChatPie.d.getCurrentAccountUin());
      paramPlusPanelViewModel = new Intent(paramBaseChatPie.aX(), TroopPicEffectGuidePicActivity.class);
      paramPlusPanelViewModel.putExtra("friendUin", paramSessionInfo.b);
      paramPlusPanelViewModel.putExtra("troopUin", paramSessionInfo.c);
      paramBaseChatPie.aX().startActivity(paramPlusPanelViewModel);
    }
    TroopPicEffectsController.a("app_entry", "page_clk");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TroopEffectPicAppInfo
 * JD-Core Version:    0.7.0.1
 */