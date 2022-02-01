package com.tencent.mobileqq.guild.chatpie.quickAt;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadHolder.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.chatpie.view.GuildVasAvatar;
import com.tencent.widget.ThemeLabelTextView;

public class GuildAtListAdapter$ViewHolder
  extends FacePreloadHolder.ViewHolder
{
  final CheckBox a;
  public final TextView b;
  int c;
  final View d;
  final RelativeLayout e;
  private GuildVasAvatar f;
  private final RelativeLayout g;
  private final ThemeLabelTextView h;
  
  GuildAtListAdapter$ViewHolder(View paramView, QQAppInterface paramQQAppInterface)
  {
    this.f = ((GuildVasAvatar)paramView.findViewById(2131436404));
    this.f.setAppInterface(paramQQAppInterface);
    this.g = ((RelativeLayout)paramView.findViewById(2131436054));
    this.b = ((TextView)paramView.findViewById(2131448598));
    this.a = ((CheckBox)paramView.findViewById(2131439016));
    this.h = ((ThemeLabelTextView)paramView.findViewById(2131448580));
    this.d = paramView.findViewById(2131448716);
    this.e = ((RelativeLayout)paramView.findViewById(2131428273));
  }
  
  public void a()
  {
    Object localObject = this.b.getContext().getResources();
    this.b.setTextColor(((Resources)localObject).getColor(2131166220));
    localObject = this.g;
    if (localObject != null) {
      ((RelativeLayout)localObject).setBackgroundResource(2130840885);
    }
    localObject = this.e;
    if (localObject != null) {
      ((RelativeLayout)localObject).setBackgroundResource(2130840885);
    }
    localObject = this.d;
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2130840859);
    }
    this.a.setBackgroundResource(2130840883);
  }
  
  public void a(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setTextColor(paramTextView.getContext().getResources().getColor(2131166223));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.quickAt.GuildAtListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */