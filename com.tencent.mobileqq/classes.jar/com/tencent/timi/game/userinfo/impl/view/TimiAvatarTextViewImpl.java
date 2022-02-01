package com.tencent.timi.game.userinfo.impl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.timi_game.impl.R.styleable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.image.api.IDrawableService;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.span.VerticalCenterSpan;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.view.IUserInfoView;
import com.tencent.timi.game.userinfo.api.view.UserInfoViewWrapper;
import com.tencent.timi.game.userinfo.impl.loader.UserRoleInfoAutoLoader;
import com.tencent.timi.game.userinfo.impl.loader.UserRoleInfoAutoLoader.Companion;
import com.tencent.timi.game.userinfo.impl.util.TimiGameAvatarUtil;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.widget.MediumBoldTextView;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;

public class TimiAvatarTextViewImpl
  extends MediumBoldTextView
  implements IUserInfoView
{
  private UserInfoViewWrapper b;
  private boolean c = false;
  private boolean d = false;
  private CharSequence e;
  private CommonOuterClass.QQUserId f;
  private IUserInfo g;
  private String h = "";
  private boolean i = false;
  private int j = ViewUtils.dpToPx(10.0F);
  private int k = Color.parseColor("#999999");
  private float l = 0.83F;
  private int m = ViewUtils.dpToPx(2.0F);
  private long n = 0L;
  private String o = null;
  private View.OnClickListener p = new TimiAvatarTextViewImpl.1(this);
  
  public TimiAvatarTextViewImpl(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public TimiAvatarTextViewImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  @Nullable
  private Drawable a(String paramString)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    int i1 = this.j;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i1;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i1;
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    try
    {
      paramString = ((IDrawableService)ServiceCenter.a(IDrawableService.class)).a(paramString, (URLDrawable.URLDrawableOptions)localObject);
      return paramString;
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("acquireRoleDrawable error");
      ((StringBuilder)localObject).append(this.o);
      Logger.a("TimiAvatarTextViewImpl", ((StringBuilder)localObject).toString(), paramString);
    }
    return null;
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    setGravity(17);
    if (!isInEditMode()) {
      this.b = new UserInfoViewWrapperImpl(this);
    }
    setMaxLines(1);
    setEllipsize(TextUtils.TruncateAt.END);
    this.a = false;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.eb);
      if (paramAttributeSet != null)
      {
        this.c = paramAttributeSet.getBoolean(R.styleable.ed, false);
        this.d = paramAttributeSet.getBoolean(R.styleable.ec, false);
        this.e = paramAttributeSet.getString(R.styleable.ee);
        this.a = paramAttributeSet.getBoolean(R.styleable.ef, false);
        paramAttributeSet.recycle();
      }
    }
    if (this.c) {
      setOnClickListener(this.p);
    }
  }
  
  private void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      setText(paramString2);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean)
    {
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" • ");
      localStringBuilder.append(paramString2);
      paramString1 = new SpannableString(localStringBuilder.toString());
      i1 = paramString1.length();
      int i2 = paramString2.length();
      paramString1.setSpan(new VerticalCenterSpan((int)(getTextSize() * this.l), this.k), 0, i1 - i2 - 1, 33);
      setText(paramString1);
      return;
    }
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" • ");
    localStringBuilder.append(paramString1);
    paramString1 = new SpannableString(localStringBuilder.toString());
    int i1 = paramString2.length();
    paramString1.setSpan(new VerticalCenterSpan((int)(getTextSize() * this.l), this.k), i1 + 1, paramString1.length(), 33);
    setText(paramString1);
  }
  
  private void b(IUserInfo paramIUserInfo)
  {
    if (System.currentTimeMillis() - this.n < 100L) {
      return;
    }
    this.n = System.currentTimeMillis();
    if ((this.i) && (!paramIUserInfo.e())) {
      UserRoleInfoAutoLoader.a.a().a(Long.valueOf(getUserId()));
    }
  }
  
  private void h()
  {
    setText("王者开黑小助手");
  }
  
  private boolean i()
  {
    CommonOuterClass.QQUserId localQQUserId = this.f;
    return (localQQUserId != null) && (localQQUserId.uid.get() == 2000L);
  }
  
  private String j()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((IUserInfo)localObject).c();
      if (localObject != null) {
        return ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject).role_name.get();
      }
    }
    return "";
  }
  
  private void k()
  {
    this.h = this.g.c(this.f);
    String str = j();
    boolean bool;
    if (((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a() == getUserId()) {
      bool = true;
    } else {
      bool = false;
    }
    if (TextUtils.isEmpty(this.h))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setShowName error name is null ");
      localStringBuilder.append(this.o);
      Logger.b("TimiAvatarTextViewImpl", localStringBuilder.toString());
    }
    if (this.i)
    {
      a(str, bool, this.h);
      if (!TextUtils.isEmpty(str))
      {
        setRoleIcon(bool);
        return;
      }
      setCompoundDrawables(null, null, null, null);
      return;
    }
    setText(this.h);
    setCompoundDrawables(null, null, null, null);
  }
  
  private void setRoleIcon(boolean paramBoolean)
  {
    Object localObject = this.g;
    if ((localObject != null) && (((IUserInfo)localObject).c() != null) && (this.g.e()))
    {
      int i1 = this.g.c().disp_grade_level.get();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://cdn.yes.qq.com/smoba/level/");
      ((StringBuilder)localObject).append(i1);
      localObject = a(((StringBuilder)localObject).toString());
      if (localObject != null)
      {
        i1 = this.j;
        ((Drawable)localObject).setBounds(0, 0, i1, i1);
      }
      if (paramBoolean) {
        setCompoundDrawables((Drawable)localObject, null, null, null);
      } else {
        setCompoundDrawables(null, null, (Drawable)localObject, null);
      }
      setCompoundDrawablePadding(this.m);
    }
  }
  
  public void a(IUserInfo paramIUserInfo)
  {
    if (getUserId() == 0L) {
      return;
    }
    if (paramIUserInfo != null)
    {
      this.g = paramIUserInfo;
      b(paramIUserInfo);
      if (this.d) {
        setTextColor(TimiGameAvatarUtil.a.a(paramIUserInfo.d(this.f)));
      }
      k();
      return;
    }
    c();
    this.g = null;
    if (this.d) {
      setTextColor(TimiGameAvatarUtil.a.a("未知"));
    }
  }
  
  public boolean a()
  {
    return TextUtils.isEmpty(getText());
  }
  
  public void b() {}
  
  public void c()
  {
    Object localObject;
    if (TextUtils.isEmpty(this.e)) {
      localObject = "";
    } else {
      localObject = this.e;
    }
    setText((CharSequence)localObject);
    setCompoundDrawables(null, null, null, null);
  }
  
  public void d()
  {
    c();
  }
  
  public void e()
  {
    this.b.a(0L);
    this.o = "";
  }
  
  public String f()
  {
    return this.h;
  }
  
  public String g()
  {
    IUserInfo localIUserInfo = this.g;
    if (localIUserInfo != null) {
      return localIUserInfo.c(this.f);
    }
    return "";
  }
  
  public CommonOuterClass.QQUserId getQQUserId()
  {
    return this.f;
  }
  
  public long getUserId()
  {
    return this.b.a();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    UserInfoViewWrapper localUserInfoViewWrapper = this.b;
    if (localUserInfoViewWrapper != null) {
      localUserInfoViewWrapper.c();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    UserInfoViewWrapper localUserInfoViewWrapper = this.b;
    if (localUserInfoViewWrapper != null) {
      localUserInfoViewWrapper.d();
    }
  }
  
  public void setClickJumpPersonalPage(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (paramBoolean)
    {
      setOnClickListener(this.p);
      return;
    }
    setOnClickListener(null);
  }
  
  public void setDefaultText(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    if (getUserId() == 0L) {
      c();
    }
  }
  
  public void setShowRoleName(boolean paramBoolean)
  {
    if (getUserId() == 0L) {
      return;
    }
    this.i = paramBoolean;
    if (this.g != null) {
      k();
    }
  }
  
  public void setUserId(CommonOuterClass.QQUserId paramQQUserId)
  {
    this.h = "";
    this.n = 0L;
    this.f = paramQQUserId;
    this.o = Logger.b(paramQQUserId.uid.get());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setUserId ");
    localStringBuilder.append(this.o);
    localStringBuilder.append(",");
    localStringBuilder.append(this.f.user_from.get());
    Logger.b("TimiAvatarTextViewImpl", localStringBuilder.toString());
    if (i())
    {
      this.b.d();
      this.b.b();
      setCompoundDrawables(null, null, null, null);
      h();
      return;
    }
    this.b.a(paramQQUserId.uid.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.view.TimiAvatarTextViewImpl
 * JD-Core Version:    0.7.0.1
 */