package com.tencent.mobileqq.qwallet.hb.aio.viewholder;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.widget.AnimationView;

public class QWalletMsgHolderBase
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
  public AnimationView j;
  public AnimationView k;
  public TextView l;
  public RelativeLayout m;
  public long n = 0L;
  public String o = "";
  public MessageForQQWalletMsg p;
  
  public MessageForQQWalletMsg a()
  {
    return this.p;
  }
  
  public void a(long paramLong)
  {
    this.n = paramLong;
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
    this.j = paramAnimationView;
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
    this.k = paramAnimationView;
  }
  
  public TextView c()
  {
    return this.l;
  }
  
  public void c(RelativeLayout paramRelativeLayout)
  {
    this.c = paramRelativeLayout;
  }
  
  public void c(TextView paramTextView)
  {
    this.l = paramTextView;
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
    this.m = paramRelativeLayout;
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
    return this.m;
  }
  
  public AnimationView k()
  {
    return this.j;
  }
  
  public AnimationView l()
  {
    return this.k;
  }
  
  public long m()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.QWalletMsgHolderBase
 * JD-Core Version:    0.7.0.1
 */