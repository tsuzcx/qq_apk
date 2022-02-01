package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TeamWorkMiniMsgUser
  extends MiniMsgUser
{
  String a = "";
  int b = -1;
  String c = "";
  MiniMsgUserParam d;
  Activity e;
  
  public TeamWorkMiniMsgUser(Activity paramActivity, MiniMsgUserParam paramMiniMsgUserParam, String paramString1, int paramInt, String paramString2)
  {
    super(paramActivity, paramMiniMsgUserParam);
    this.a = paramString1;
    this.b = paramInt;
    this.d = paramMiniMsgUserParam;
    this.e = paramActivity;
    this.c = paramString2;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (((MiniMsgUserParam)localObject).actionCallback != null) {
        this.d.actionCallback.onOpenMiniAIOCallback();
      }
      localObject = this.a;
      int i = this.b;
      if ((i != -1) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        MiniChatActivity.a(this.e, i, (String)localObject, this.c);
        hideUnread();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void updateUnreadCountSync(int paramInt)
  {
    super.updateUnreadCountSync(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkMiniMsgUser
 * JD-Core Version:    0.7.0.1
 */