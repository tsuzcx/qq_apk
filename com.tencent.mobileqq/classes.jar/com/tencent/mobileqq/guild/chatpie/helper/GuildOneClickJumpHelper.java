package com.tencent.mobileqq.guild.chatpie.helper;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpStateMachineController;
import com.tencent.mobileqq.activity.aio.oneclickjump.OneClickJumpUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder.Holder;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.GuildListUI;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import mqq.os.MqqHandler;

public class GuildOneClickJumpHelper
  implements ILifeCycleHelper, AbsListView.OnScrollListener
{
  private GuildChatContext a;
  private long b = -1L;
  
  public GuildOneClickJumpHelper(GuildChatContext paramGuildChatContext)
  {
    this.a = paramGuildChatContext;
  }
  
  private void a()
  {
    GuildListUI localGuildListUI = (GuildListUI)this.a.e().b();
    if ((localGuildListUI.a().a() == JumpState.JUMP_SUCCESS) && (localGuildListUI.a().b() != JumpState.GRAY_TIP_CLICK))
    {
      long l = this.a.e().d().o();
      if (this.b != l)
      {
        this.b = l;
        localGuildListUI.d(false);
      }
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = AIOUtils.b(paramView);
    if ((paramView instanceof UniteGrayTipItemBuilder.Holder))
    {
      paramView = (UniteGrayTipItemBuilder.Holder)paramView;
      if (((paramView.q instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)paramView.q).tipParam.i == 131093)) {
        this.a.g().post(new GuildOneClickJumpHelper.1(this, paramBoolean));
      }
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "GuildOneClickJumpHelper";
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
      OneClickJumpUtil.a(this.a.a());
      com.tencent.mobileqq.activity.aio.rebuild.msglist.OneClickJumpMsgFilter.b = -1L;
      this.a.e().b().a(false);
      this.a.e().b().c(false);
      return;
    }
    this.a.e().b().a(false);
    this.a.e().b().c(false);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.ac() < paramInt1)
    {
      a();
      a(this.a.aa(), false);
      return;
    }
    paramInt1 = paramInt1 + paramInt2 - 1;
    if ((paramInt1 < this.a.ad()) && (paramInt1 > 0)) {
      a(this.a.ab(), true);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildOneClickJumpHelper
 * JD-Core Version:    0.7.0.1
 */