package com.tencent.mobileqq.pluspanel.appinfo;

import ahvi;
import android.content.Intent;
import bgtj;
import bhhr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
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
    return 2130850758;
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
    return BaseApplicationImpl.getContext().getString(2131697454);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (bhhr.q(paramBaseChatPie.getActivity(), paramBaseChatPie.app.getCurrentAccountUin())) {
      TroopPicEffectsEditActivity.a(paramBaseChatPie.getActivity(), paramSessionInfo.curFriendUin, paramSessionInfo.troopUin);
    }
    for (;;)
    {
      bgtj.a("app_entry", "page_clk");
      return;
      bhhr.z(paramBaseChatPie.getActivity(), paramBaseChatPie.app.getCurrentAccountUin());
      paramahvi = new Intent(paramBaseChatPie.getActivity(), TroopPicEffectGuidePicActivity.class);
      paramahvi.putExtra("friendUin", paramSessionInfo.curFriendUin);
      paramahvi.putExtra("troopUin", paramSessionInfo.troopUin);
      paramBaseChatPie.getActivity().startActivity(paramahvi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TroopEffectPicAppInfo
 * JD-Core Version:    0.7.0.1
 */