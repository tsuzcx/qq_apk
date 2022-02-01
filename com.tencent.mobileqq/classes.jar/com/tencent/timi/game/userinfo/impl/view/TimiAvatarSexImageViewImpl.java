package com.tencent.timi.game.userinfo.impl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.timi_game.impl.R.styleable;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.view.IUserInfoView;
import com.tencent.timi.game.userinfo.api.view.UserInfoViewWrapper;
import com.tencent.timi.game.userinfo.impl.util.TimiGameAvatarUtil;
import trpc.yes.common.CommonOuterClass.QQUserId;

public class TimiAvatarSexImageViewImpl
  extends ImageView
  implements IUserInfoView
{
  private UserInfoViewWrapper a;
  private boolean b = false;
  private boolean c = true;
  private CommonOuterClass.QQUserId d;
  private View.OnClickListener e = new TimiAvatarSexImageViewImpl.1(this);
  
  public TimiAvatarSexImageViewImpl(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public TimiAvatarSexImageViewImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
    setScaleType(ImageView.ScaleType.CENTER_INSIDE);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    this.a = new UserInfoViewWrapperImpl(this);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.dZ);
      if (paramAttributeSet != null)
      {
        this.b = paramAttributeSet.getBoolean(R.styleable.ea, false);
        paramAttributeSet.recycle();
      }
    }
    if (this.b) {
      setOnClickListener(this.e);
    }
  }
  
  private Drawable b(IUserInfo paramIUserInfo)
  {
    if (paramIUserInfo != null) {
      return TimiGameAvatarUtil.a.a(this, paramIUserInfo.d(this.d));
    }
    return null;
  }
  
  public void a(IUserInfo paramIUserInfo)
  {
    int i = 8;
    if (paramIUserInfo != null)
    {
      paramIUserInfo = b(paramIUserInfo);
      if (this.c)
      {
        if (paramIUserInfo != null) {
          i = 0;
        }
        setVisibility(i);
      }
      setImageDrawable(paramIUserInfo);
      return;
    }
    setImageDrawable(null);
    setVisibility(8);
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
  
  public long getUserId()
  {
    return this.a.a();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.a.c();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.d();
  }
  
  public void setAutoVisible(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setClickJumpPersonalPage(boolean paramBoolean)
  {
    this.b = paramBoolean;
    if (paramBoolean)
    {
      setOnClickListener(this.e);
      return;
    }
    setOnClickListener(null);
  }
  
  public void setUserId(CommonOuterClass.QQUserId paramQQUserId)
  {
    this.d = paramQQUserId;
    this.a.a(paramQQUserId.uid.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.view.TimiAvatarSexImageViewImpl
 * JD-Core Version:    0.7.0.1
 */