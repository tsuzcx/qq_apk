package com.tencent.timi.game.profile.impl.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.profile.impl.view.record.MessageSmobaRecordView;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.widget.MediumBoldTextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/impl/view/ProfileMessageViewImpl;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "acquireDescribe", "", "userInfo", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "qquserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "acquireUserView", "Landroid/view/View;", "initView", "", "setAvatarClickListener", "listener", "Landroid/view/View$OnClickListener;", "setUserInfo", "needMonitor", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public class ProfileMessageViewImpl
  extends LinearLayout
{
  private HashMap a;
  
  public ProfileMessageViewImpl(@Nullable Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ProfileMessageViewImpl(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ProfileMessageViewImpl(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private final String a(IUserInfo paramIUserInfo, CommonOuterClass.QQUserId paramQQUserId)
  {
    String str = paramIUserInfo.b(paramQQUserId);
    if (TextUtils.isEmpty((CharSequence)str))
    {
      paramIUserInfo = paramIUserInfo.a(paramQQUserId);
      Intrinsics.checkExpressionValueIsNotNull(paramIUserInfo, "userInfo.constellation(qquserId)");
      return paramIUserInfo;
    }
    if (!TextUtils.isEmpty((CharSequence)paramIUserInfo.a(paramQQUserId)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" | ");
      localStringBuilder.append(paramIUserInfo.a(paramQQUserId));
      return localStringBuilder.toString();
    }
    Intrinsics.checkExpressionValueIsNotNull(str, "city");
    return str;
  }
  
  private final void a(Context paramContext)
  {
    LinearLayout.inflate(paramContext, 2131629469, (ViewGroup)this);
    setOrientation(1);
  }
  
  @Nullable
  public final View a()
  {
    return (RelativeLayout)a(2131449229);
  }
  
  public View a(int paramInt)
  {
    if (this.a == null) {
      this.a = new HashMap();
    }
    View localView2 = (View)this.a.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.a.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void setAvatarClickListener(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
    AvatarRoundImageView localAvatarRoundImageView = (AvatarRoundImageView)a(2131449228);
    if (localAvatarRoundImageView != null) {
      localAvatarRoundImageView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public final void setUserInfo(@NotNull IUserInfo paramIUserInfo, @Nullable CommonOuterClass.QQUserId paramQQUserId, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramIUserInfo, "userInfo");
    Object localObject = (AvatarRoundImageView)a(2131449228);
    if (localObject != null) {
      ((AvatarRoundImageView)localObject).setUserId(paramQQUserId);
    }
    localObject = (AvatarRoundImageView)a(2131449228);
    if (localObject != null) {
      ((AvatarRoundImageView)localObject).setNeedDrawSex(true);
    }
    localObject = (MediumBoldTextView)a(2131449230);
    if (localObject != null) {
      ((MediumBoldTextView)localObject).setText((CharSequence)paramIUserInfo.c(paramQQUserId));
    }
    TextView localTextView = (TextView)a(2131449232);
    if (localTextView != null)
    {
      localObject = paramIUserInfo.c();
      if (localObject != null)
      {
        localObject = ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject).role_name;
        if (localObject != null)
        {
          localObject = ((PBStringField)localObject).get();
          if (localObject != null) {
            break label141;
          }
        }
      }
      localObject = "";
      label141:
      localTextView.setText((CharSequence)localObject);
    }
    paramQQUserId = a(paramIUserInfo, paramQQUserId);
    localObject = (TextView)a(2131431756);
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)paramQQUserId);
    }
    localObject = (TextView)a(2131431756);
    if (localObject != null) {
      ViewExKt.a((View)localObject, TextUtils.isEmpty((CharSequence)paramQQUserId) ^ true);
    }
    paramQQUserId = (MessageSmobaRecordView)a(2131444483);
    if (paramQQUserId != null) {
      paramQQUserId.setUserInfo(paramIUserInfo);
    }
    if ((paramBoolean) && (!paramIUserInfo.e()))
    {
      paramQQUserId = (MessageSmobaRecordView)a(2131444483);
      if (paramQQUserId != null)
      {
        paramIUserInfo = paramIUserInfo.a();
        Intrinsics.checkExpressionValueIsNotNull(paramIUserInfo, "userInfo.uid()");
        paramQQUserId.setUserId(paramIUserInfo.longValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.view.ProfileMessageViewImpl
 * JD-Core Version:    0.7.0.1
 */