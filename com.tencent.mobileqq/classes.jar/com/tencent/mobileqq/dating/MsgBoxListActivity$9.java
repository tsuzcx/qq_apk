package com.tencent.mobileqq.dating;

import android.os.Bundle;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.qphone.base.util.QLog;

class MsgBoxListActivity$9
  extends MsgBoxProtocol.LastFeedObserver
{
  MsgBoxListActivity$9(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt, long paramLong, boolean paramBoolean2, Bundle paramBundle)
  {
    if (!paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MsgBoxListActivity", 2, "onGetInteractLastFeed = false");
      }
      return;
    }
    if (paramBoolean2)
    {
      this.a.app.getInterFollowMgr().addMessage(paramString, 0, paramInt, paramLong, 1);
    }
    else if (this.a.app.getInterFollowMgr().isInMsgBoxRecentList(AppConstants.MSG_BOX_INTERACT_UIN, this.a.mBoxMsgType))
    {
      paramInt = this.a.app.getConversationFacade().a(AppConstants.MSG_BOX_INTERACT_UIN, this.a.mBoxMsgType);
      this.a.app.getMessageFacade().a(this.a.mBoxUIN, this.a.mBoxMsgType, AppConstants.MSG_BOX_INTERACT_UIN, this.a.app.getCurrentAccountUin());
      if (paramInt > 0)
      {
        RecentUtil.b(this.a.app, AppConstants.MSG_BOX_INTERACT_UIN, this.a.mBoxMsgType);
        this.a.app.getMessageFacade().a(AppConstants.MSG_BOX_INTERACT_UIN, this.a.mBoxMsgType, true, true);
      }
    }
    if (!this.a.isFinishing()) {
      this.a.refreshListGlobal();
    }
  }
  
  protected void b(boolean paramBoolean1, String paramString, int paramInt, long paramLong, boolean paramBoolean2, Bundle paramBundle)
  {
    if (!paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MsgBoxListActivity", 2, "onGetInteractLastFeed = false");
      }
      return;
    }
    if (paramBoolean2)
    {
      this.a.app.getInterFollowMgr().addMessage(paramString, 0, paramInt, paramLong, 2);
    }
    else if (this.a.app.getInterFollowMgr().isInMsgBoxRecentList(AppConstants.MSG_BOX_FOLLOW_UIN, this.a.mBoxMsgType))
    {
      paramInt = this.a.app.getConversationFacade().a(AppConstants.MSG_BOX_FOLLOW_UIN, this.a.mBoxMsgType);
      this.a.app.getMessageFacade().a(this.a.mBoxUIN, this.a.mBoxMsgType, AppConstants.MSG_BOX_FOLLOW_UIN, this.a.app.getCurrentAccountUin());
      if (paramInt > 0)
      {
        RecentUtil.b(this.a.app, AppConstants.MSG_BOX_FOLLOW_UIN, this.a.mBoxMsgType);
        this.a.app.getMessageFacade().a(AppConstants.MSG_BOX_FOLLOW_UIN, this.a.mBoxMsgType, true, true);
      }
    }
    if (!this.a.isFinishing()) {
      this.a.refreshListGlobal();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity.9
 * JD-Core Version:    0.7.0.1
 */