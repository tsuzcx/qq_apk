package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.widget.AnimationView;

public class GuildQQWalletMsgItemBuilder$QWalletMsgHolderBase
  extends BaseGuildMsgViewBuild.ViewHolder
  implements IQWalletMsgHolder
{
  public RelativeLayout a;
  public RelativeLayout b;
  public RelativeLayout c;
  public RelativeLayout d;
  public LinearLayout e;
  public RelativeLayout f;
  public TextView g;
  public TextView h;
  public ImageView i;
  public AnimationView n;
  public AnimationView o;
  public TextView p;
  public RelativeLayout s;
  public long t = 0L;
  public String u = "";
  
  public GuildQQWalletMsgItemBuilder$QWalletMsgHolderBase(GuildQQWalletMsgItemBuilder paramGuildQQWalletMsgItemBuilder) {}
  
  public MessageForQQWalletMsg a()
  {
    return (MessageForQQWalletMsg)this.q;
  }
  
  public void a(long paramLong)
  {
    this.t = paramLong;
  }
  
  public void a(ImageView paramImageView)
  {
    this.i = paramImageView;
  }
  
  public void a(LinearLayout paramLinearLayout)
  {
    this.e = paramLinearLayout;
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    this.a = paramRelativeLayout;
  }
  
  public void a(TextView paramTextView)
  {
    this.g = paramTextView;
  }
  
  public void a(AnimationView paramAnimationView)
  {
    this.n = paramAnimationView;
  }
  
  public RelativeLayout b()
  {
    return this.a;
  }
  
  public void b(RelativeLayout paramRelativeLayout)
  {
    this.b = paramRelativeLayout;
  }
  
  public void b(TextView paramTextView)
  {
    this.h = paramTextView;
  }
  
  public void b(AnimationView paramAnimationView)
  {
    this.o = paramAnimationView;
  }
  
  public TextView c()
  {
    return this.p;
  }
  
  public void c(RelativeLayout paramRelativeLayout)
  {
    this.c = paramRelativeLayout;
  }
  
  public void c(TextView paramTextView)
  {
    this.p = paramTextView;
  }
  
  public RelativeLayout d()
  {
    return this.c;
  }
  
  public void d(RelativeLayout paramRelativeLayout)
  {
    this.d = paramRelativeLayout;
  }
  
  public RelativeLayout e()
  {
    return this.d;
  }
  
  public void e(RelativeLayout paramRelativeLayout)
  {
    this.f = paramRelativeLayout;
  }
  
  public LinearLayout f()
  {
    return this.e;
  }
  
  public void f(RelativeLayout paramRelativeLayout)
  {
    this.s = paramRelativeLayout;
  }
  
  public TextView g()
  {
    return this.g;
  }
  
  public TextView h()
  {
    return this.h;
  }
  
  public ImageView i()
  {
    return this.i;
  }
  
  public RelativeLayout j()
  {
    return this.s;
  }
  
  public AnimationView k()
  {
    return this.n;
  }
  
  public AnimationView l()
  {
    return this.o;
  }
  
  public long m()
  {
    return this.t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildQQWalletMsgItemBuilder.QWalletMsgHolderBase
 * JD-Core Version:    0.7.0.1
 */