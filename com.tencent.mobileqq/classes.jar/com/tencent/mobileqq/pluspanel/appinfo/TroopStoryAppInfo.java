package com.tencent.mobileqq.pluspanel.appinfo;

import ahvi;
import android.content.Intent;
import android.net.Uri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.BaseApplication;
import ykv;
import zcl;

public class TroopStoryAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130842545;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 1105981808;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131697514);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramahvi = zcl.a(null, this.url, paramSessionInfo.curFriendUin);
    paramSessionInfo = new Intent(paramBaseChatPie.getActivity(), JumpActivity.class);
    paramSessionInfo.setData(Uri.parse(paramahvi));
    paramBaseChatPie.getActivity().startActivity(paramSessionInfo);
    ykv.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TroopStoryAppInfo
 * JD-Core Version:    0.7.0.1
 */