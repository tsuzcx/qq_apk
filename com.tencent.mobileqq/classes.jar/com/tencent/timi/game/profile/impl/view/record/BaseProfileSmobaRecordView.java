package com.tencent.timi.game.profile.impl.view.record;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.image.api.IDrawableService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.ISmobaService;
import com.tencent.timi.game.ui.widget.rc.RCImageView;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.userinfo.api.view.IUserInfoView;
import com.tencent.timi.game.userinfo.api.view.UserInfoViewWrapper;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;
import trpc.yes.common.GameDataServerOuterClass.SmobaLadderGrade;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/impl/view/record/BaseProfileSmobaRecordView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/timi/game/userinfo/api/view/IUserInfoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "levelUrl", "", "smobaGameRoleExtInfo", "Ltrpc/yes/common/GameDataServerOuterClass$SmobaGameRoleInfo;", "smobaHeroBaseUrl", "userInfoViewWrapper", "Lcom/tencent/timi/game/userinfo/api/view/UserInfoViewWrapper;", "acquireGoodAtPosition", "acquireLevelName", "acquireLevelUrl", "acquireTotalMVP", "acquireTotalRace", "acquireUsuallyHeroList", "", "acquireWinRatio", "Landroid/text/SpannableString;", "textView", "Landroid/widget/TextView;", "convertZeroToString", "content", "formatWinRatio", "number", "getUserId", "", "hasRoleInfo", "", "initView", "", "isViewContentEmpty", "onAttachedToWindow", "onDetachedFromWindow", "processDecimal", "refreshUI", "renderIfAdminUser", "renderIfUidInvalid", "renderIfUidNotReady", "renderWithUserInfo", "allUserInfoModel", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "setDescirbeView", "firstDescribeItem", "Landroid/view/View;", "secondDescribeItem", "thirdDescribeItem", "setDescribeItemContent", "view", "titleResId", "setHeroList", "heroListNullText", "roleLinear", "Landroid/widget/LinearLayout;", "setUserId", "userId", "setUserInfo", "userInfo", "setViewImageUrl", "Landroid/widget/ImageView;", "url", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class BaseProfileSmobaRecordView
  extends RelativeLayout
  implements IUserInfoView
{
  private UserInfoViewWrapper a;
  private GameDataServerOuterClass.SmobaGameRoleInfo b;
  private final String c = "https://cdn.yes.qq.com/smoba/hero/";
  private final String d = "https://cdn.yes.qq.com/smoba/level/";
  private HashMap e;
  
  public BaseProfileSmobaRecordView(@NotNull Context paramContext)
  {
    super(paramContext);
    i();
  }
  
  public BaseProfileSmobaRecordView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    i();
  }
  
  public BaseProfileSmobaRecordView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    i();
  }
  
  private final SpannableString a(int paramInt, TextView paramTextView)
  {
    if (paramInt % 100 == 0)
    {
      paramInt /= 100;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append('%');
      return a(((StringBuilder)localObject).toString(), paramTextView, 1);
    }
    Object localObject = StringCompanionObject.INSTANCE;
    localObject = new Object[1];
    localObject[0] = Float.valueOf(paramInt / 100.0F);
    localObject = String.format("%.2f", Arrays.copyOf((Object[])localObject, localObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('%');
    return a(localStringBuilder.toString(), paramTextView, 3);
  }
  
  private final SpannableString a(TextView paramTextView)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject).win_num;
      if (localObject != null)
      {
        i = ((PBUInt32Field)localObject).get();
        break label36;
      }
    }
    int i = 0;
    label36:
    int j = l();
    if (j > 0)
    {
      double d1 = i;
      Double.isNaN(d1);
      double d2 = j;
      Double.isNaN(d2);
      i = MathKt.roundToInt(d1 * 10000.0D / d2);
      if (i > 0) {
        return a(i, paramTextView);
      }
    }
    return new SpannableString((CharSequence)"--");
  }
  
  private final SpannableString a(String paramString, TextView paramTextView, int paramInt)
  {
    SpannableString localSpannableString = new SpannableString((CharSequence)paramString);
    if ((paramString.length() > paramInt) && (paramTextView != null))
    {
      localSpannableString.setSpan(new AbsoluteSizeSpan((int)paramTextView.getTextSize()), 0, paramString.length() - paramInt, 33);
      localSpannableString.setSpan(new AbsoluteSizeSpan((int)UITools.a(getContext(), 12.0F)), paramString.length() - paramInt, paramString.length(), 33);
    }
    return localSpannableString;
  }
  
  private final void a(View paramView, int paramInt, SpannableString paramSpannableString)
  {
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(2131435952);
      if (localTextView != null) {
        localTextView.setText(paramInt);
      }
    }
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(2131435950);
      if (paramView != null) {
        paramView.setText((CharSequence)paramSpannableString);
      }
    }
  }
  
  private final void a(View paramView, int paramInt, String paramString)
  {
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(2131435952);
      if (localTextView != null) {
        localTextView.setText(paramInt);
      }
    }
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(2131435950);
      if (paramView != null) {
        paramView.setText((CharSequence)paramString);
      }
    }
  }
  
  private final void i()
  {
    this.a = ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).a((IUserInfoView)this);
  }
  
  private final boolean j()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject).role_name;
      if (localObject != null)
      {
        localObject = ((PBStringField)localObject).get();
        break label28;
      }
    }
    localObject = null;
    label28:
    return TextUtils.isEmpty((CharSequence)localObject) ^ true;
  }
  
  private final List<String> k()
  {
    List localList = (List)new ArrayList();
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject).display_hero_list;
      if (localObject != null)
      {
        localObject = ((PBRepeatField)localObject).get();
        if (localObject != null)
        {
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            Integer localInteger = (Integer)((Iterator)localObject).next();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.c);
            localStringBuilder.append(localInteger);
            localList.add(localStringBuilder.toString());
          }
        }
      }
    }
    return localList;
  }
  
  private final int l()
  {
    Object localObject = this.b;
    int k = 0;
    if (localObject != null)
    {
      localObject = ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject).win_num;
      if (localObject != null)
      {
        i = ((PBUInt32Field)localObject).get();
        break label36;
      }
    }
    int i = 0;
    label36:
    localObject = this.b;
    int j = k;
    if (localObject != null)
    {
      localObject = ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject).lose_num;
      j = k;
      if (localObject != null) {
        j = ((PBUInt32Field)localObject).get();
      }
    }
    return i + j;
  }
  
  private final int m()
  {
    Object localObject = this.b;
    int k = 0;
    if (localObject != null)
    {
      localObject = ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject).win_mvp;
      if (localObject != null)
      {
        i = ((PBUInt32Field)localObject).get();
        break label36;
      }
    }
    int i = 0;
    label36:
    localObject = this.b;
    int j = k;
    if (localObject != null)
    {
      localObject = ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject).lose_mvp;
      j = k;
      if (localObject != null) {
        j = ((PBUInt32Field)localObject).get();
      }
    }
    return i + j;
  }
  
  @NotNull
  protected final String a(int paramInt)
  {
    if (paramInt != 0) {
      return String.valueOf(paramInt);
    }
    return "--";
  }
  
  protected final void a(@NotNull View paramView1, @NotNull View paramView2, @NotNull View paramView3)
  {
    Intrinsics.checkParameterIsNotNull(paramView1, "firstDescribeItem");
    Intrinsics.checkParameterIsNotNull(paramView2, "secondDescribeItem");
    Intrinsics.checkParameterIsNotNull(paramView3, "thirdDescribeItem");
    a(paramView1, 2131917203, a(l()));
    a(paramView2, 2131917204, a((TextView)paramView2.findViewById(2131435950)));
    a(paramView3, 2131917202, a(m()));
  }
  
  protected final void a(@Nullable View paramView, @Nullable LinearLayout paramLinearLayout)
  {
    Object localObject1 = k();
    if (((List)localObject1).isEmpty())
    {
      if (paramView != null) {
        ViewExKt.a(paramView, true);
      }
      if (paramLinearLayout != null) {
        ViewExKt.a((View)paramLinearLayout, false);
      }
    }
    else
    {
      if (paramView != null) {
        ViewExKt.a(paramView, false);
      }
      if (paramLinearLayout != null) {
        ViewExKt.a((View)paramLinearLayout, true);
      }
      if (paramLinearLayout != null) {
        paramLinearLayout.removeAllViews();
      }
      int i = (int)UITools.a(getContext(), 2.0F);
      int j = (int)UITools.a(getContext(), 24.0F);
      int k = (int)UITools.a(getContext(), 4.0F);
      paramView = ((Iterable)localObject1).iterator();
      while (paramView.hasNext())
      {
        Object localObject2 = (String)paramView.next();
        localObject1 = new RCImageView(getContext());
        ((RCImageView)localObject1).setRadius(k);
        a((ImageView)localObject1, (String)localObject2);
        ((RCImageView)localObject1).setPadding(i, i, i, i);
        localObject2 = new ViewGroup.LayoutParams(j, j);
        if (paramLinearLayout != null) {
          paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
      }
    }
  }
  
  protected final void a(@NotNull ImageView paramImageView, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramImageView, "$this$setViewImageUrl");
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)new ColorDrawable(0));
      localURLDrawableOptions.mFailedDrawable = ((Drawable)new ColorDrawable(0));
      if (paramImageView.getMeasuredWidth() > 0)
      {
        localURLDrawableOptions.mRequestWidth = paramImageView.getMeasuredWidth();
        localURLDrawableOptions.mRequestHeight = paramImageView.getMeasuredHeight();
      }
      try
      {
        paramImageView.setImageDrawable((Drawable)((IDrawableService)ServiceCenter.a(IDrawableService.class)).a(paramString, localURLDrawableOptions));
        return;
      }
      catch (Exception paramImageView)
      {
        paramString = new StringBuilder();
        paramString.append("setImageDrawable error ");
        paramString.append(paramImageView);
        Logger.c("BaseProfileSmobaRecordView", paramString.toString());
      }
    }
  }
  
  public void a(@Nullable IUserInfo paramIUserInfo)
  {
    if (paramIUserInfo != null) {
      paramIUserInfo = paramIUserInfo.c();
    } else {
      paramIUserInfo = null;
    }
    this.b = paramIUserInfo;
    ViewExKt.a(this, j());
    e();
  }
  
  public boolean a()
  {
    return getUserId() == 0L;
  }
  
  public View b(int paramInt)
  {
    if (this.e == null) {
      this.e = new HashMap();
    }
    View localView2 = (View)this.e.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.e.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    c();
  }
  
  public abstract void e();
  
  @Nullable
  public final String f()
  {
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject1 = ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject1).display_branch_list;
      if (localObject1 != null)
      {
        Object localObject2 = ((PBRepeatField)localObject1).get();
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject1 = (ISmobaService)ServiceCenter.a(ISmobaService.class);
          localObject2 = ((List)localObject2).get(0);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "it[0]");
          return ((ISmobaService)localObject1).f(((Number)localObject2).intValue());
        }
      }
    }
    return "--";
  }
  
  @NotNull
  protected final String g()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject).disp_grade_level;
      if (localObject != null)
      {
        int i = ((PBUInt32Field)localObject).get();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.d);
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("_b");
        return ((StringBuilder)localObject).toString();
      }
    }
    Logger.c("BaseProfileSmobaRecordView", "acquireLevelUrl error ");
    return "";
  }
  
  public final long getUserId()
  {
    UserInfoViewWrapper localUserInfoViewWrapper = this.a;
    if (localUserInfoViewWrapper != null) {
      return localUserInfoViewWrapper.a();
    }
    return 0L;
  }
  
  @NotNull
  protected final String h()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((GameDataServerOuterClass.SmobaGameRoleInfo)localObject).disp_grade_level;
      if (localObject != null)
      {
        int i = ((PBUInt32Field)localObject).get();
        localObject = ((ISmobaService)ServiceCenter.a(ISmobaService.class)).d(i);
        if (localObject != null)
        {
          localObject = ((GameDataServerOuterClass.SmobaLadderGrade)localObject).grade_level_name;
          if (localObject != null)
          {
            localObject = ((PBStringField)localObject).get();
            if (localObject != null) {
              return localObject;
            }
          }
        }
        return "";
      }
    }
    Logger.c("BaseProfileSmobaRecordView", "acquireLevelName error ");
    return "";
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
  
  public final void setUserId(long paramLong)
  {
    UserInfoViewWrapper localUserInfoViewWrapper = this.a;
    if (localUserInfoViewWrapper != null) {
      localUserInfoViewWrapper.a(paramLong);
    }
  }
  
  public final void setUserInfo(@NotNull IUserInfo paramIUserInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramIUserInfo, "userInfo");
    a(paramIUserInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.view.record.BaseProfileSmobaRecordView
 * JD-Core Version:    0.7.0.1
 */