package com.tencent.mobileqq.matchchat;

import android.text.TextUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.AdvancedTipsBar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class MatchChatMsgListFragment$1
  extends ExpandObserver
{
  MatchChatMsgListFragment$1(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  protected void a(boolean paramBoolean, Card paramCard)
  {
    if (paramBoolean)
    {
      if ((MatchChatMsgListFragment.a(this.a) != null) && (MatchChatMsgUtil.b(this.a.a)))
      {
        if ((TextUtils.isEmpty(paramCard.declaration)) && (TextUtils.isEmpty(paramCard.voiceUrl)))
        {
          MatchChatMsgListFragment.a(this.a).setVisibility(0);
          ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#message_page#data_guide_banner", true, -1L, -1L, null, true, true);
          return;
        }
        MatchChatMsgListFragment.a(this.a).setVisibility(8);
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e("MatchChatMsgListFragment", 2, "get expand info error");
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateSignalBombPush ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      QLog.d("MatchChatMsgListFragment", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(boolean paramBoolean, List<Long> paramList1, int paramInt, List<Long> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatMsgListFragment", 2, String.format("onGetExtendFriendOnlineState success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    MatchChatMsgListFragment.a(this.a, (ArrayList)paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment.1
 * JD-Core Version:    0.7.0.1
 */