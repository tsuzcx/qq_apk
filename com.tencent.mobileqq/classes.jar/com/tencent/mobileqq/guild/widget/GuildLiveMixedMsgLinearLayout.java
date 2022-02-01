package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildReplyTextItemBuilder;

public class GuildLiveMixedMsgLinearLayout
  extends GuildMixedMsgLinearLayout
{
  public GuildLiveMixedMsgLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public GuildLiveMixedMsgLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected int getAnimationTextViewColorId()
  {
    return 2131166220;
  }
  
  protected int getMsgTextColorId()
  {
    return 2131166220;
  }
  
  protected ViewGroup getReplySourceLayout()
  {
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(getContext()).inflate(2131625074, null);
    return GuildReplyTextItemBuilder.a(getContext(), localViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.GuildLiveMixedMsgLinearLayout
 * JD-Core Version:    0.7.0.1
 */