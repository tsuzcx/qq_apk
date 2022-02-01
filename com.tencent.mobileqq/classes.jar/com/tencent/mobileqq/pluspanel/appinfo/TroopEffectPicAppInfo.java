package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Intent;
import ayfu;
import bfks;
import bfyz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopEffectPicAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130850627;
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
    return BaseApplicationImpl.getContext().getString(2131697177);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (bfyz.q(paramBaseChatPie.getActivity(), paramBaseChatPie.app.getCurrentAccountUin())) {
      TroopPicEffectsEditActivity.a(paramBaseChatPie.getActivity(), paramSessionInfo.curFriendUin, paramSessionInfo.troopUin);
    }
    for (;;)
    {
      bfks.a("app_entry", "page_clk");
      return;
      bfyz.z(paramBaseChatPie.getActivity(), paramBaseChatPie.app.getCurrentAccountUin());
      paramayfu = new Intent(paramBaseChatPie.getActivity(), TroopPicEffectGuidePicActivity.class);
      paramayfu.putExtra("friendUin", paramSessionInfo.curFriendUin);
      paramayfu.putExtra("troopUin", paramSessionInfo.troopUin);
      paramBaseChatPie.getActivity().startActivity(paramayfu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TroopEffectPicAppInfo
 * JD-Core Version:    0.7.0.1
 */