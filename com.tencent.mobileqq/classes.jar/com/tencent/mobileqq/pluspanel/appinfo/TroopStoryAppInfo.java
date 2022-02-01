package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Intent;
import android.net.Uri;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopStoryAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130843543;
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
    return BaseApplicationImpl.getContext().getString(2131895547);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramPlusPanelViewModel = TroopStoryUtil.a(null, this.url, paramSessionInfo.b);
    paramSessionInfo = new Intent(paramBaseChatPie.aX(), JumpActivity.class);
    paramSessionInfo.setData(Uri.parse(paramPlusPanelViewModel));
    paramBaseChatPie.aX().startActivity(paramSessionInfo);
    StoryReportor.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TroopStoryAppInfo
 * JD-Core Version:    0.7.0.1
 */