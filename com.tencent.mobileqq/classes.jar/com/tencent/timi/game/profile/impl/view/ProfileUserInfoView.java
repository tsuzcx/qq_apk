package com.tencent.timi.game.profile.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarSexImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/impl/view/ProfileUserInfoView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarTextView", "Lcom/tencent/timi/game/userinfo/api/view/AvatarTextView;", "roundImageView", "Lcom/tencent/timi/game/userinfo/api/view/AvatarRoundImageView;", "sexImageView", "Lcom/tencent/timi/game/userinfo/api/view/AvatarSexImageView;", "acquireShowName", "", "initView", "", "setData", "userId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileUserInfoView
  extends LinearLayout
{
  private AvatarRoundImageView a;
  private AvatarTextView b;
  private AvatarSexImageView c;
  
  public ProfileUserInfoView(@NotNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ProfileUserInfoView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ProfileUserInfoView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private final void a(Context paramContext)
  {
    LinearLayout.inflate(paramContext, 2131629473, (ViewGroup)this);
    setOrientation(1);
    this.a = ((AvatarRoundImageView)findViewById(2131445171));
    this.b = ((AvatarTextView)findViewById(2131429002));
    this.c = ((AvatarSexImageView)findViewById(2131445736));
  }
  
  @NotNull
  public final String a()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((AvatarTextView)localObject).f();
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  public final void setData(@NotNull CommonOuterClass.QQUserId paramQQUserId)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "userId");
    Object localObject = this.a;
    if (localObject != null) {
      ((AvatarRoundImageView)localObject).setUserId(paramQQUserId);
    }
    localObject = this.b;
    if (localObject != null) {
      ((AvatarTextView)localObject).setUserId(paramQQUserId);
    }
    localObject = this.c;
    if (localObject != null) {
      ((AvatarSexImageView)localObject).setUserId(paramQQUserId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.view.ProfileUserInfoView
 * JD-Core Version:    0.7.0.1
 */