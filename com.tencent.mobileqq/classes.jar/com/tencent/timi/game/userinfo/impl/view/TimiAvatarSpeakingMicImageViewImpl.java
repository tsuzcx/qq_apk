package com.tencent.timi.game.userinfo.impl.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.timi_game.impl.R.styleable;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.view.IUserInfoView;
import com.tencent.timi.game.userinfo.api.view.UserInfoViewWrapper;
import com.tencent.timi.game.userinfo.impl.util.TimiGameAvatarUtil;
import trpc.yes.common.CommonOuterClass.QQUserId;

public class TimiAvatarSpeakingMicImageViewImpl
  extends ImageView
  implements IUserInfoView
{
  private Drawable a;
  private Drawable b;
  private Drawable c;
  private Drawable d;
  private Drawable e;
  private Drawable f;
  private Drawable g;
  private Drawable h;
  private Drawable i;
  private Drawable j;
  private Drawable k;
  private Drawable l;
  private CommonOuterClass.QQUserId m;
  private UserInfoViewWrapper n;
  private boolean o = false;
  private boolean p = true;
  private boolean q;
  private boolean r;
  private View.OnClickListener s = new TimiAvatarSpeakingMicImageViewImpl.1(this);
  
  public TimiAvatarSpeakingMicImageViewImpl(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public TimiAvatarSpeakingMicImageViewImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private Drawable a(int paramInt)
  {
    return TimiGameAvatarUtil.a.a(paramInt, this);
  }
  
  private void a(Context paramContext)
  {
    this.a = a(2130853134);
    this.b = paramContext.getResources().getDrawable(2130853068);
    this.c = this.a;
    this.d = paramContext.getResources().getDrawable(2130853066);
    this.e = paramContext.getResources().getDrawable(2130853067);
    this.f = this.d;
    this.g = paramContext.getResources().getDrawable(2130853069);
    this.h = paramContext.getResources().getDrawable(2130853070);
    this.i = this.g;
    this.j = paramContext.getResources().getDrawable(2130853065);
    this.k = paramContext.getResources().getDrawable(2130853137);
    this.l = this.j;
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    a(paramContext);
    this.n = new UserInfoViewWrapperImpl(this);
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.eb);
      if (paramContext != null)
      {
        this.o = paramContext.getBoolean(R.styleable.ed, false);
        paramContext.recycle();
      }
    }
    if (this.o) {
      setOnClickListener(this.s);
    }
  }
  
  private boolean b(IUserInfo paramIUserInfo)
  {
    return (paramIUserInfo != null) && ("男".equals(paramIUserInfo.d(this.m)));
  }
  
  private boolean c(IUserInfo paramIUserInfo)
  {
    return (paramIUserInfo != null) && ("女".equals(paramIUserInfo.d(this.m)));
  }
  
  public void a(IUserInfo paramIUserInfo)
  {
    if (this.q)
    {
      if (b(paramIUserInfo)) {
        paramIUserInfo = this.a;
      } else if (c(paramIUserInfo)) {
        paramIUserInfo = this.b;
      } else {
        paramIUserInfo = this.c;
      }
      setImageDrawable(paramIUserInfo);
    }
    else
    {
      if (b(paramIUserInfo)) {
        paramIUserInfo = this.d;
      } else if (c(paramIUserInfo)) {
        paramIUserInfo = this.e;
      } else {
        paramIUserInfo = this.f;
      }
      setImageDrawable(paramIUserInfo);
    }
    setBackgroundColor(16777215);
    setVisibility(0);
  }
  
  public boolean a()
  {
    return getUserId() == 0L;
  }
  
  public void b()
  {
    setImageDrawable(null);
    setVisibility(8);
  }
  
  public void c()
  {
    setImageDrawable(null);
    setVisibility(8);
  }
  
  public void d()
  {
    c();
  }
  
  public void e()
  {
    this.n.a(0L);
  }
  
  public long getUserId()
  {
    return this.n.a();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.n.c();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.n.d();
  }
  
  public void setAutoVisible(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setData(CommonOuterClass.QQUserId paramQQUserId, boolean paramBoolean)
  {
    this.m = paramQQUserId;
    setData(paramQQUserId, paramBoolean, true);
  }
  
  public void setData(CommonOuterClass.QQUserId paramQQUserId, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.m = paramQQUserId;
    this.q = paramBoolean1;
    this.r = paramBoolean2;
    this.n.a(paramQQUserId.uid.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.view.TimiAvatarSpeakingMicImageViewImpl
 * JD-Core Version:    0.7.0.1
 */