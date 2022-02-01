package com.tencent.timi.game.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.ui.utils.ResUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/widget/CommonDialog$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "backPressEnable", "", "cancleOnOutside", "customMargins", "", "customMsgView", "Landroid/view/View;", "lightMode", "mDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "message", "", "messageGravity", "", "messageMaxLine", "negativeBtnCanDismiss", "negativeButtonClickListener", "Landroid/content/DialogInterface$OnClickListener;", "negativeButtonText", "negativeButtonTextColorId", "positiveBtnCanDismiss", "positiveButtonClickListener", "positiveButtonText", "positiveButtonTextColorId", "subTitle", "subTitleGravity", "title", "titleGravity", "b", "build", "Lcom/tencent/timi/game/ui/widget/CommonDialog;", "cancelOnOutside", "view", "leftMargin", "topMargin", "rightMargin", "bottomMargin", "dismissListener", "listener", "light", "gravity", "maxLine", "negativeButtonColorResId", "colorResId", "text", "positiveButtonColorResId", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class CommonDialog$Builder
{
  private String a;
  private String b;
  private int c;
  private int d;
  private String e;
  private int f;
  private String g;
  private String h;
  @ColorRes
  private int i;
  private int j;
  private boolean k;
  private boolean l;
  private DialogInterface.OnClickListener m;
  private DialogInterface.OnClickListener n;
  private DialogInterface.OnDismissListener o;
  private View p;
  private int[] q;
  private boolean r;
  private boolean s;
  private boolean t;
  private int u;
  private final Context v;
  
  public CommonDialog$Builder(@NotNull Context paramContext)
  {
    this.v = paramContext;
    this.c = 17;
    this.d = 17;
    this.f = 8388611;
    this.g = "确定";
    this.h = "暂不";
    this.l = true;
    this.q = new int[4];
    this.r = true;
    this.s = true;
    this.u = 3;
  }
  
  @NotNull
  public final Builder a(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  @NotNull
  public final Builder a(@Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    this.m = paramOnClickListener;
    return this;
  }
  
  @NotNull
  public final Builder a(@Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.o = paramOnDismissListener;
    return this;
  }
  
  @NotNull
  public final Builder a(@Nullable View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.p = paramView;
    paramView = this.q;
    paramView[0] = paramInt1;
    paramView[1] = paramInt2;
    paramView[2] = paramInt3;
    paramView[3] = paramInt4;
    return this;
  }
  
  @NotNull
  public final Builder a(@Nullable String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  @NotNull
  public final Builder a(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }
  
  @NotNull
  public final CommonDialog a()
  {
    CommonDialog localCommonDialog = new CommonDialog(this.v, null);
    Dialog localDialog = (Dialog)localCommonDialog;
    Object localObject1 = (TextView)localDialog.findViewById(2131447478);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "dialog.titleView");
    ((TextView)localObject1).setText((CharSequence)this.a);
    localObject1 = (TextView)localDialog.findViewById(2131438153);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "dialog.messageView");
    ((TextView)localObject1).setText((CharSequence)this.e);
    localObject1 = (TextView)localDialog.findViewById(2131438153);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "dialog.messageView");
    ((TextView)localObject1).setMaxLines(this.u);
    localObject1 = (TextView)localDialog.findViewById(2131447478);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "titleView");
    localObject1 = (View)localObject1;
    Object localObject2 = (CharSequence)this.a;
    int i2 = 0;
    int i1;
    if ((localObject2 != null) && (!StringsKt.isBlank((CharSequence)localObject2))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    ViewExKt.a((View)localObject1, i1 ^ 0x1);
    localObject1 = (TextView)localDialog.findViewById(2131446516);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "subTitleView");
    localObject1 = (View)localObject1;
    localObject2 = (CharSequence)this.b;
    if ((localObject2 != null) && (!StringsKt.isBlank((CharSequence)localObject2))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    ViewExKt.a((View)localObject1, i1 ^ 0x1);
    localObject1 = (TextView)localDialog.findViewById(2131447478);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "titleView");
    ((TextView)localObject1).setText((CharSequence)this.a);
    localObject1 = (TextView)localDialog.findViewById(2131447478);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "titleView");
    ((TextView)localObject1).setGravity(this.c);
    localObject1 = (TextView)localDialog.findViewById(2131446516);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "subTitleView");
    ((TextView)localObject1).setText((CharSequence)this.b);
    localObject1 = (TextView)localDialog.findViewById(2131446516);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "subTitleView");
    ((TextView)localObject1).setGravity(this.d);
    if (this.p == null)
    {
      localObject1 = (TextView)localDialog.findViewById(2131438153);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "messageView");
      localObject1 = (View)localObject1;
      localObject2 = (CharSequence)this.e;
      if ((localObject2 != null) && (!StringsKt.isBlank((CharSequence)localObject2))) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      ViewExKt.a((View)localObject1, i1 ^ 0x1);
      localObject1 = (TextView)localDialog.findViewById(2131438153);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "messageView");
      ((TextView)localObject1).setText((CharSequence)this.e);
      localObject1 = (TextView)localDialog.findViewById(2131438153);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "messageView");
      ((TextView)localObject1).setGravity(this.f);
    }
    else
    {
      ((FrameLayout)localDialog.findViewById(2131431324)).removeAllViews();
      localObject1 = new FrameLayout.LayoutParams(-1, -2);
      localObject2 = this.q;
      ((FrameLayout.LayoutParams)localObject1).leftMargin = localObject2[0];
      ((FrameLayout.LayoutParams)localObject1).topMargin = localObject2[1];
      ((FrameLayout.LayoutParams)localObject1).rightMargin = localObject2[2];
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = localObject2[3];
      ((FrameLayout)localDialog.findViewById(2131431324)).addView(this.p, (ViewGroup.LayoutParams)localObject1);
    }
    localObject1 = (TextView)localDialog.findViewById(2131439179);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "negativeButton");
    localObject1 = (View)localObject1;
    localObject2 = (CharSequence)this.h;
    if ((localObject2 != null) && (!StringsKt.isBlank((CharSequence)localObject2))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    ViewExKt.a((View)localObject1, i1 ^ 0x1);
    localObject1 = localDialog.findViewById(2131449393);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "verticalDivider");
    localObject2 = (CharSequence)this.h;
    if (localObject2 != null)
    {
      i1 = i2;
      if (!StringsKt.isBlank((CharSequence)localObject2)) {}
    }
    else
    {
      i1 = 1;
    }
    ViewExKt.a((View)localObject1, i1 ^ 0x1);
    localObject1 = (TextView)localDialog.findViewById(2131440535);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "positiveButton");
    ((TextView)localObject1).setText((CharSequence)this.g);
    localObject1 = (TextView)localDialog.findViewById(2131439179);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "negativeButton");
    ((TextView)localObject1).setText((CharSequence)this.h);
    if (this.i > 0) {
      ((TextView)localDialog.findViewById(2131440535)).setTextColor(ResUtils.b(this.i));
    }
    if (this.j > 0) {
      ((TextView)localDialog.findViewById(2131439179)).setTextColor(ResUtils.b(this.j));
    }
    ((TextView)localDialog.findViewById(2131440535)).setOnClickListener((View.OnClickListener)new CommonDialog.Builder.build..inlined.apply.lambda.1(localCommonDialog, this));
    ((TextView)localDialog.findViewById(2131439179)).setOnClickListener((View.OnClickListener)new CommonDialog.Builder.build..inlined.apply.lambda.2(localCommonDialog, this));
    localCommonDialog.setOnDismissListener(this.o);
    localCommonDialog.setCanceledOnTouchOutside(this.k);
    CommonDialog.a(localCommonDialog, this.l);
    CommonDialog.b(localCommonDialog, this.t);
    return localCommonDialog;
  }
  
  @NotNull
  public final Builder b(@Nullable DialogInterface.OnClickListener paramOnClickListener)
  {
    this.n = paramOnClickListener;
    return this;
  }
  
  @NotNull
  public final Builder b(@Nullable String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  @NotNull
  public final Builder b(boolean paramBoolean)
  {
    this.t = paramBoolean;
    return this;
  }
  
  @NotNull
  public final Builder c(@Nullable String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  @NotNull
  public final Builder c(boolean paramBoolean)
  {
    this.r = paramBoolean;
    return this;
  }
  
  @NotNull
  public final Builder d(@Nullable String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  @NotNull
  public final Builder d(boolean paramBoolean)
  {
    this.s = paramBoolean;
    return this;
  }
  
  @NotNull
  public final Builder e(@Nullable String paramString)
  {
    this.h = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.CommonDialog.Builder
 * JD-Core Version:    0.7.0.1
 */