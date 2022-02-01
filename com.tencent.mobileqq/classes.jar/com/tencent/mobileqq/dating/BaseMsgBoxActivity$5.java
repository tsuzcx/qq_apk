package com.tencent.mobileqq.dating;

import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewStub;
import com.tencent.mobileqq.activity.NearbyActivityHelper;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class BaseMsgBoxActivity$5
  implements Handler.Callback
{
  BaseMsgBoxActivity$5(BaseMsgBoxActivity paramBaseMsgBoxActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      this.a.mIsNeedShowRedDot = true;
      i = paramMessage.arg1;
      paramMessage = this.a;
      paramMessage.mUnReadMsgNum = i;
      if (paramMessage.mUnReadMsgNum < 0) {
        this.a.mIsNeedShowRedDot = false;
      }
      if ((this.a.mMsgTabRedTouch != null) && (this.a.mIsNeedShowRedDot))
      {
        NearbyActivityHelper.a(this.a.mMsgTabRedTouch, this.a.mUnReadMsgNum);
        return false;
      }
    }
    else if ((!this.a.isListViewScrolling()) && (this.a.mDragHost.a() == -1) && (paramMessage.obj != null))
    {
      paramMessage = (List)paramMessage.obj;
      this.a.mRecentAdapter.a(paramMessage);
      this.a.mRecentListData.clear();
      this.a.mRecentListData.addAll(paramMessage);
      this.a.onRefreshRecentListData();
      int j = this.a.getUnReadMsgNum(paramMessage);
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.a.app.getCurrentAccountUin(), "nearby_msg_tab_last_num", Integer.valueOf(j));
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("BaseMsgBoxActivity, MSG_REFRESH_LIST_UI, lastUnReadNum=");
        ((StringBuilder)localObject).append(this.a.mUnReadMsgNum);
        ((StringBuilder)localObject).append(", newUnReadNum=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", msgList.size=");
        if (paramMessage == null) {
          i = 0;
        } else {
          i = paramMessage.size();
        }
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", showRedDot=");
        ((StringBuilder)localObject).append(this.a.mIsNeedShowRedDot);
        QLog.d("nearby.msgbox.tab", 2, ((StringBuilder)localObject).toString());
      }
      if (this.a.isFromNearby)
      {
        localObject = this.a.mUIHandler.obtainMessage(1);
        this.a.mUIHandler.removeMessages(1);
        ((Message)localObject).arg1 = j;
        this.a.mUIHandler.sendMessageDelayed((Message)localObject, 500L);
        if (paramMessage.size() == 0) {
          this.a.mEmptyTipLayout.setVisibility(0);
        } else {
          this.a.mEmptyTipLayout.setVisibility(8);
        }
        if (BaseMsgBoxActivity.access$000(this.a)) {
          this.a.mFooterView.setVisibility(8);
        } else {
          this.a.mFooterView.setVisibility(0);
        }
      }
      if (!this.a.mInitUI)
      {
        this.a.mLoadingView.setVisibility(8);
        this.a.mInitUI = true;
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("init ui cost time : ");
          paramMessage.append(System.currentTimeMillis() - this.a.mInitUITime);
          QLog.d("Q.msg_box", 2, paramMessage.toString());
          return false;
        }
      }
    }
    else
    {
      this.a.mNeedRefreshList = true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity.5
 * JD-Core Version:    0.7.0.1
 */