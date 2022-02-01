package com.tencent.mobileqq.guild.chatpie.helper;

import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatAdapter1.BubbleOnlongClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.GuildChatPie;
import com.tencent.mobileqq.guild.chatpie.GuildChatPieFoldStatusListener;
import com.tencent.mobileqq.guild.chatpie.GuildHelperProvider;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.AbsGestureListener;
import com.tencent.mobileqq.guild.message.chatpie.IGuildMenuEventCallBack;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class GuildMsgMenuHelper
  implements ILifeCycleHelper
{
  protected GuildChatContext a;
  private ChatMessage b;
  private BottomSheetDialogFragment c;
  private GuildChatPieFoldStatusListener d = new GuildMsgMenuHelper.1(this);
  private AbsGestureListener e = new GuildMsgMenuHelper.2(this);
  private IGuildMenuEventCallBack f = new GuildMsgMenuHelper.3(this);
  
  public GuildMsgMenuHelper(GuildChatContext paramGuildChatContext)
  {
    this.a = paramGuildChatContext;
  }
  
  private void b()
  {
    ((GuildHelperProvider)this.a.d()).a(this.d);
    ((GuildChatPie)this.a.n()).a(this.e);
  }
  
  private void c()
  {
    BottomSheetDialogFragment localBottomSheetDialogFragment = this.c;
    if (localBottomSheetDialogFragment != null) {
      localBottomSheetDialogFragment.dismiss();
    }
    this.b = null;
    ((GuildHelperProvider)this.a.d()).b(this.d);
    ((GuildChatPie)this.a.n()).b(this.e);
  }
  
  private void d()
  {
    BottomSheetDialogFragment localBottomSheetDialogFragment = this.c;
    if (localBottomSheetDialogFragment != null) {
      localBottomSheetDialogFragment.dismiss();
    }
  }
  
  private void e() {}
  
  public ChatMessage a()
  {
    return this.b;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.a.n().aX().getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (!((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).isAioFullyOpen((MainFragment)localObject)) {
      return;
    }
    localObject = null;
    ChatXListView localChatXListView = this.a.n().U;
    if (localChatXListView == null) {
      return;
    }
    int j = localChatXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject = localChatXListView.getChildAt(i);
      if (((View)localObject).getBottom() > paramMotionEvent.getY()) {
        break;
      }
      i += 1;
    }
    if (localObject != null)
    {
      if (((View)localObject).getBottom() < paramMotionEvent.getY()) {
        return;
      }
      this.a.n().V.f.onLongClick((View)localObject);
    }
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    BottomSheetDialogFragment localBottomSheetDialogFragment = this.c;
    if (localBottomSheetDialogFragment != null) {
      localBottomSheetDialogFragment.dismiss();
    }
    paramQQCustomMenu = ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildChatPieMenuDialog(this.a.a(), this.a.b(), paramQQCustomMenu, paramChatMessage, this.f);
    if (!(paramQQCustomMenu instanceof BottomSheetDialogFragment)) {
      return;
    }
    this.c = ((BottomSheetDialogFragment)paramQQCustomMenu);
    this.b = paramChatMessage;
    this.a.n().V.notifyDataSetChanged();
  }
  
  public String getTag()
  {
    return "GuildMsgMenuHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      c();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildMsgMenuHelper
 * JD-Core Version:    0.7.0.1
 */