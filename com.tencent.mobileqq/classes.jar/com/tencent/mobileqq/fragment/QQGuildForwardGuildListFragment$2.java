package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.adapter.QQGuildChannelItemView;
import com.tencent.mobileqq.adapter.QQGuildForwardSelectionGuildListAdapter;
import com.tencent.mobileqq.adapter.QQGuildForwardSelectionGuildListAdapter.ChildViewHolder;
import com.tencent.mobileqq.adapter.QQGuildForwardSelectionGuildListAdapter.IForwardGuildListAdapterCallback;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.QQGuildChannelEntry;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.selectmember.ResultRecord;
import java.util.Map;

class QQGuildForwardGuildListFragment$2
  implements QQGuildForwardSelectionGuildListAdapter.IForwardGuildListAdapterCallback
{
  QQGuildForwardGuildListFragment$2(QQGuildForwardGuildListFragment paramQQGuildForwardGuildListFragment) {}
  
  private Bundle a(QQGuildChannelEntry paramQQGuildChannelEntry)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramQQGuildChannelEntry.uin);
    localBundle.putString("guild_id", paramQQGuildChannelEntry.guildId);
    localBundle.putInt("uintype", 10014);
    localBundle.putString("uinname", paramQQGuildChannelEntry.name);
    localBundle.putParcelableArrayList("forward_multi_target", null);
    paramQQGuildChannelEntry = QQGuildForwardGuildListFragment.e(this.a).getIntent().getStringExtra("choose_friend_confirmTitle");
    String str = QQGuildForwardGuildListFragment.e(this.a).getIntent().getStringExtra("choose_friend_confirmContent");
    localBundle.putBoolean("choose_friend_needConfirm", true);
    localBundle.putString("choose_friend_confirmTitle", paramQQGuildChannelEntry);
    localBundle.putString("choose_friend_confirmContent", str);
    return localBundle;
  }
  
  private void b(View paramView)
  {
    paramView = ((QQGuildChannelItemView)paramView).h;
    if (paramView.uinType == 10016) {
      return;
    }
    if (b(paramView.uin, paramView.getUinType())) {
      QQGuildForwardGuildListFragment.a(this.a, paramView.uin, paramView.getUinType());
    } else {
      QQGuildForwardGuildListFragment.a(this.a, paramView);
    }
    QQGuildForwardGuildListFragment.a(this.a).notifyDataSetChanged();
  }
  
  private boolean b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return QQGuildForwardGuildListFragment.c(this.a).containsKey(QQGuildForwardGuildListFragment.b(this.a, paramString, paramInt));
  }
  
  private void c(View paramView)
  {
    paramView = (QQGuildForwardSelectionGuildListAdapter.ChildViewHolder)paramView.getTag();
    if (paramView != null)
    {
      paramView = paramView.a;
      if ((paramView instanceof QQGuildChannelEntry))
      {
        paramView = (QQGuildChannelEntry)paramView;
        if (paramView.type == 10016) {
          return;
        }
        QQGuildForwardGuildListFragment.d(this.a).a(ForwardAbility.ForwardAbilityType.b.intValue(), a(paramView));
      }
    }
  }
  
  public void a(View paramView)
  {
    if (QQGuildForwardGuildListFragment.b(this.a))
    {
      b(paramView);
      return;
    }
    c(paramView);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return b(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQGuildForwardGuildListFragment.2
 * JD-Core Version:    0.7.0.1
 */