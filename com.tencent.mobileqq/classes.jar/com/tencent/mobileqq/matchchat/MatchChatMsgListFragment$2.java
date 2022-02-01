package com.tencent.mobileqq.matchchat;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.limitchat.SignalBombHelper;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.widget.AdvancedTipsBar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class MatchChatMsgListFragment$2
  extends ExtendFriendObserver
{
  MatchChatMsgListFragment$2(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  public void onGetExtendFriendInfo(boolean paramBoolean, Card paramCard)
  {
    if (paramBoolean)
    {
      MatchChatMsgListFragment.a(this.a, paramCard);
      if ((MatchChatMsgListFragment.a(this.a) != null) && (MatchChatMsgUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        if ((!TextUtils.isEmpty(paramCard.declaration)) || (!TextUtils.isEmpty(paramCard.voiceUrl))) {
          break label83;
        }
        MatchChatMsgListFragment.a(this.a).setVisibility(0);
        ExpandReportUtils.a("expose#message_page#data_guide_banner", true, -1L, -1L, null, true, true);
      }
    }
    label83:
    while (!QLog.isColorLevel())
    {
      return;
      MatchChatMsgListFragment.a(this.a).setVisibility(8);
      return;
    }
    QLog.e("MatchChatMsgListFragment", 2, "get expand info error");
  }
  
  public void onGetExtendFriendOnlineState(boolean paramBoolean, List<Long> paramList1, int paramInt, List<Long> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatMsgListFragment", 2, String.format("onGetExtendFriendOnlineState success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    MatchChatMsgListFragment.a(this.a, (ArrayList)paramList1);
  }
  
  public void onUpdateSignalBombPush(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatMsgListFragment", 2, "onUpdateSignalBombPush " + paramBoolean + " " + paramString);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()) && (!MatchChatMsgListFragment.a(this.a))) {
      MatchChatMsgListFragment.a(this.a, SignalBombHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, MatchChatMsgListFragment.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment.2
 * JD-Core Version:    0.7.0.1
 */