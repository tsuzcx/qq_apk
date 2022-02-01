package com.tencent.mobileqq.guild.chatpie;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildLiveChannelMsgItemLayout;

public class GuildLiveChannelPieAdapter$GuildLiveBubbleOnLongClickListener
  extends GuildPieAdapter.GuildBubbleOnlongClickListener
{
  public GuildLiveChannelPieAdapter$GuildLiveBubbleOnLongClickListener(GuildLiveChannelPieAdapter paramGuildLiveChannelPieAdapter)
  {
    super(paramGuildLiveChannelPieAdapter);
  }
  
  private void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = b(paramView);
    int j = paramMotionEvent.getAction();
    boolean bool = true;
    if ((j == 1) || (paramMotionEvent.getAction() == 3)) {
      bool = false;
    }
    a(paramView, bool);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    paramView.setPressed(paramBoolean);
  }
  
  private View b(View paramView)
  {
    if ((paramView instanceof GuildLiveChannelMsgItemLayout)) {
      return paramView;
    }
    if (paramView == null) {
      return null;
    }
    if ((paramView.getParent() instanceof View)) {
      return b((View)paramView.getParent());
    }
    return null;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    a(paramView, paramMotionEvent);
    return super.onTouch(paramView, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildLiveChannelPieAdapter.GuildLiveBubbleOnLongClickListener
 * JD-Core Version:    0.7.0.1
 */