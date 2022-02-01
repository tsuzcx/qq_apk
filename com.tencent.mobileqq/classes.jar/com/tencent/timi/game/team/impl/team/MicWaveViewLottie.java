package com.tencent.timi.game.team.impl.team;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.dinifly.RenderMode;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.SafeLottieAnimationView;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.userinfo.api.view.IUserInfoView;
import com.tencent.timi.game.userinfo.api.view.UserInfoViewWrapper;
import trpc.yes.common.CommonOuterClass.QQUserId;

public class MicWaveViewLottie
  extends FrameLayout
  implements IUserInfoView
{
  UserInfoViewWrapper a;
  SafeLottieAnimationView b;
  private boolean c = false;
  private CommonOuterClass.QQUserId d;
  private String e = "lottie/tg_voice_anim_male.json";
  
  public MicWaveViewLottie(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  public MicWaveViewLottie(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f();
  }
  
  public MicWaveViewLottie(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f();
  }
  
  private void a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "lottie/tg_voice_anim_female.json";
    } else {
      str = "lottie/tg_voice_anim_male.json";
    }
    if (!str.equals(this.e))
    {
      this.e = str;
      this.b.setAnimation(this.e);
    }
  }
  
  private void f()
  {
    this.a = ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).a(this);
    this.b = new SafeLottieAnimationView(getContext());
    if (DeviceInfoUtil.S()) {
      this.b.setRenderMode(RenderMode.SOFTWARE);
    }
    addView(this.b, new FrameLayout.LayoutParams(-1, -1));
    this.b.setImageAssetsFolder("lottie");
    this.b.setRepeatCount(0);
    this.b.addAnimatorListener(new MicWaveViewLottie.1(this));
    this.b.setAnimation(this.e);
  }
  
  public void a(IUserInfo paramIUserInfo)
  {
    boolean bool;
    if ((paramIUserInfo != null) && (TextUtils.equals(paramIUserInfo.d(this.d), "女"))) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    a(false);
  }
  
  public void c()
  {
    a(false);
  }
  
  public void d()
  {
    a(false);
  }
  
  public void e()
  {
    if (this.c) {
      return;
    }
    this.b.setVisibility(0);
    this.b.playAnimation();
  }
  
  public void setUid(long paramLong)
  {
    this.a.a(paramLong);
    this.b.setVisibility(0);
  }
  
  public void setUserId(CommonOuterClass.QQUserId paramQQUserId)
  {
    this.d = paramQQUserId;
    this.a.a(paramQQUserId.uid.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.MicWaveViewLottie
 * JD-Core Version:    0.7.0.1
 */