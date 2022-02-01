package com.tencent.timi.game.userinfo.impl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.timi_game.impl.R.styleable;
import com.tencent.timi.game.ui.utils.ResUtils;
import com.tencent.timi.game.ui.widget.TimiRoundImageView;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.view.IUserInfoView;
import com.tencent.timi.game.userinfo.api.view.UserInfoViewWrapper;
import com.tencent.timi.game.userinfo.impl.util.TimiGameAvatarUtil;
import com.tencent.timi.game.userinfo.impl.view.widget.InnerSexView;
import com.tencent.timi.game.utils.Logger;
import mqq.os.MqqHandler;
import trpc.yes.common.CommonOuterClass.QQUserId;

public class TimiAvatarRoundImageViewImpl
  extends FrameLayout
  implements IUserInfoView
{
  UserInfoViewWrapper a;
  public View.OnClickListener b;
  private int c;
  private int d = 128;
  private boolean e = false;
  private boolean f = true;
  private boolean g = false;
  private Drawable h;
  private TimiAvatarRoundImageViewImpl.OnAvatarClickListener i;
  private CommonOuterClass.QQUserId j;
  private TimiRoundImageView k;
  private InnerSexView l;
  private String m = null;
  private final View.OnClickListener n = new TimiAvatarRoundImageViewImpl.1(this);
  
  public TimiAvatarRoundImageViewImpl(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public TimiAvatarRoundImageViewImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private Drawable a(int paramInt)
  {
    return TimiGameAvatarUtil.a.a(paramInt, this);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    setWillNotDraw(false);
    this.k = new TimiRoundImageView(paramContext);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    addView(this.k, paramContext);
    this.c = 2130853132;
    this.a = new UserInfoViewWrapperImpl(this);
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.dW);
      if (paramContext != null)
      {
        this.e = paramContext.getBoolean(R.styleable.dX, false);
        this.f = paramContext.getBoolean(R.styleable.dY, false);
        paramContext.recycle();
      }
    }
    if (this.f) {
      setBackgroundDrawable(a(2130853133));
    }
    if (this.e)
    {
      setOnClickListener(this.n);
      return;
    }
    setOnClickListener(new TimiAvatarRoundImageViewImpl.2(this));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAvatarUrl error");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",");
      localStringBuilder.append(this.m);
      Logger.c("TimiAvatarRoundImageViewImpl", localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAvatarUrl ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",");
      localStringBuilder.append(this.m);
      Logger.a("TimiAvatarRoundImageViewImpl", localStringBuilder.toString());
    }
    TimiGameAvatarUtil.a.a(paramString, this.k, this.d);
  }
  
  private String b(IUserInfo paramIUserInfo)
  {
    CommonOuterClass.QQUserId localQQUserId = this.j;
    if (localQQUserId != null) {
      return paramIUserInfo.e(localQQUserId);
    }
    return "";
  }
  
  private boolean f()
  {
    CommonOuterClass.QQUserId localQQUserId = this.j;
    return (localQQUserId != null) && (localQQUserId.uid.get() == 2000L);
  }
  
  private void g()
  {
    this.k.setImageDrawable(ResUtils.a(2130853061));
  }
  
  private void h()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("drawSex ");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(this.m);
    Logger.a("TimiAvatarRoundImageViewImpl", ((StringBuilder)localObject).toString());
    if (this.g)
    {
      if (this.l == null)
      {
        this.l = new InnerSexView(getContext());
        localObject = new ViewGroup.LayoutParams(-1, -1);
        addView(this.l, (ViewGroup.LayoutParams)localObject);
      }
      this.l.setVisibility(0);
      this.l.setSexInco(this.h);
      return;
    }
    i();
  }
  
  private void i()
  {
    InnerSexView localInnerSexView = this.l;
    if (localInnerSexView != null) {
      localInnerSexView.setVisibility(8);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
  
  public void a(IUserInfo paramIUserInfo)
  {
    if (getUserId() == 0L) {
      return;
    }
    if (paramIUserInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("renderWithUserInfo ");
      localStringBuilder.append(this.m);
      Logger.a("TimiAvatarRoundImageViewImpl", localStringBuilder.toString());
      this.h = TimiGameAvatarUtil.a.b(this, paramIUserInfo.d(this.j));
      paramIUserInfo = b(paramIUserInfo);
      if (!TextUtils.isEmpty(paramIUserInfo)) {
        a(paramIUserInfo, true);
      } else {
        c();
      }
      h();
      return;
    }
    c();
    paramIUserInfo = new StringBuilder();
    paramIUserInfo.append("renderWithUserInfo null ");
    paramIUserInfo.append(this.m);
    Logger.a("TimiAvatarRoundImageViewImpl", paramIUserInfo.toString());
  }
  
  public boolean a()
  {
    return (this.k.getDrawable() == null) || (this.k.getDrawable().getIntrinsicWidth() < 0) || (this.k.getDrawable().getIntrinsicHeight() < 0);
  }
  
  public void b()
  {
    a("", true);
  }
  
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("renderIfUidInvalid ");
    localStringBuilder.append(this.m);
    Logger.a("TimiAvatarRoundImageViewImpl", localStringBuilder.toString());
    this.h = null;
    this.k.setImageResource(this.c);
    i();
  }
  
  public void d()
  {
    c();
  }
  
  public void e()
  {
    this.a.a(0L);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showDefaultImage ");
    localStringBuilder.append(this.m);
    Logger.a("TimiAvatarRoundImageViewImpl", localStringBuilder.toString());
    i();
    this.m = "";
  }
  
  public long getUserId()
  {
    return this.a.a();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    UserInfoViewWrapper localUserInfoViewWrapper = this.a;
    if (localUserInfoViewWrapper != null) {
      localUserInfoViewWrapper.c();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    UserInfoViewWrapper localUserInfoViewWrapper = this.a;
    if (localUserInfoViewWrapper != null) {
      localUserInfoViewWrapper.d();
    }
  }
  
  public void setAvatarSize(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setAvatarUrl(String paramString)
  {
    this.h = null;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      if (!TextUtils.isEmpty(paramString))
      {
        a(paramString, false);
        return;
      }
      c();
      return;
    }
    ThreadManager.getUIHandler().post(new TimiAvatarRoundImageViewImpl.3(this, paramString));
  }
  
  public void setClickJumpPersonalPage(boolean paramBoolean)
  {
    this.e = paramBoolean;
    setOnClickListener(new TimiAvatarRoundImageViewImpl.4(this, paramBoolean));
  }
  
  public void setDefaultImage(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setNeedDefaultBg(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setNeedDrawSex(boolean paramBoolean)
  {
    this.g = paramBoolean;
    h();
  }
  
  public void setOnAvatarClickListener(TimiAvatarRoundImageViewImpl.OnAvatarClickListener paramOnAvatarClickListener)
  {
    this.i = paramOnAvatarClickListener;
  }
  
  public void setUserId(CommonOuterClass.QQUserId paramQQUserId)
  {
    Logger.a("TimiAvatarRoundImageViewImpl", "setUserId ");
    this.j = paramQQUserId;
    this.m = Logger.b(paramQQUserId.uid.get());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setUserId ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(",");
    localStringBuilder.append(this.j.user_from.get());
    Logger.b("TimiAvatarRoundImageViewImpl", localStringBuilder.toString());
    if (f())
    {
      this.a.d();
      this.a.b();
      i();
      g();
      return;
    }
    this.a.a(paramQQUserId.uid.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.view.TimiAvatarRoundImageViewImpl
 * JD-Core Version:    0.7.0.1
 */