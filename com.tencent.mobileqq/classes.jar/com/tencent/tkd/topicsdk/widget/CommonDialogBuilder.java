package com.tencent.tkd.topicsdk.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/CommonDialogBuilder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentMarginBottom", "", "Ljava/lang/Integer;", "getContext", "()Landroid/content/Context;", "mCancelOnTouchOutside", "", "mContentView", "Landroid/view/View;", "mIsForbidBackPress", "mMessage", "", "mMessageTextClickAction", "Lkotlin/Function0;", "", "mMessageViewGravity", "mNegativeButtonCallback", "Lcom/tencent/tkd/topicsdk/widget/CommonDialogBuilder$ICommonDialogListener;", "mNegativeButtonMessage", "", "mNegativeButtonTextColor", "mPositiveButtonCallback", "mPositiveButtonMessage", "mPositiveButtonTextColor", "mTitle", "mTitleTextColor", "titleMarginTop", "cancelOnTouchOutside", "cancel", "marginBottom", "contentView", "create", "Landroid/app/AlertDialog;", "forbidBackPress", "message", "messageTextClickAction", "block", "messageViewGravity", "gravity", "negativeButtonTextColor", "color", "negativeText", "buttonMessage", "negativeButtonCallback", "positiveButtonTextColor", "positiveText", "positiveButtonCallback", "title", "marginTop", "titleTextColor", "CommonDialog", "ICommonDialogListener", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class CommonDialogBuilder
{
  private String a;
  private CharSequence b;
  private String c;
  private String d;
  private CommonDialogBuilder.ICommonDialogListener e;
  private CommonDialogBuilder.ICommonDialogListener f;
  private Function0<Unit> g;
  private Integer h;
  private int i;
  private Integer j;
  private Integer k;
  private boolean l;
  private View m;
  private boolean n;
  private Integer o;
  private Integer p;
  @NotNull
  private final Context q;
  
  public CommonDialogBuilder(@NotNull Context paramContext)
  {
    this.q = paramContext;
    this.i = this.q.getResources().getColor(R.color.a);
    this.l = true;
  }
  
  @NotNull
  public final AlertDialog a()
  {
    CommonDialogBuilder.CommonDialog localCommonDialog = new CommonDialogBuilder.CommonDialog(this.q);
    localCommonDialog.a(this.a);
    localCommonDialog.a(this.h);
    localCommonDialog.setMessage(this.b);
    localCommonDialog.c(this.c);
    localCommonDialog.a(this.e);
    localCommonDialog.b(Integer.valueOf(this.i));
    localCommonDialog.b(this.d);
    localCommonDialog.b(this.f);
    localCommonDialog.c(this.j);
    localCommonDialog.d(this.k);
    localCommonDialog.a(this.g);
    localCommonDialog.a(this.m);
    localCommonDialog.setCanceledOnTouchOutside(this.l);
    localCommonDialog.a(this.n);
    Integer localInteger = this.o;
    if (localInteger != null) {
      localCommonDialog.a(((Number)localInteger).intValue());
    }
    localInteger = this.p;
    if (localInteger != null) {
      localCommonDialog.b(((Number)localInteger).intValue());
    }
    return (AlertDialog)localCommonDialog;
  }
  
  @NotNull
  public final CommonDialogBuilder a(int paramInt)
  {
    this.h = Integer.valueOf(paramInt);
    return this;
  }
  
  @NotNull
  public final CommonDialogBuilder a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "contentView");
    this.m = paramView;
    return this;
  }
  
  @NotNull
  public final CommonDialogBuilder a(@Nullable String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  @NotNull
  public final CommonDialogBuilder a(@Nullable String paramString, @Nullable CommonDialogBuilder.ICommonDialogListener paramICommonDialogListener)
  {
    this.c = paramString;
    this.e = paramICommonDialogListener;
    return this;
  }
  
  @NotNull
  public final CommonDialogBuilder a(boolean paramBoolean)
  {
    this.l = paramBoolean;
    return this;
  }
  
  @NotNull
  public final CommonDialogBuilder b(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  @NotNull
  public final CommonDialogBuilder b(@Nullable String paramString, @Nullable CommonDialogBuilder.ICommonDialogListener paramICommonDialogListener)
  {
    this.d = paramString;
    this.f = paramICommonDialogListener;
    return this;
  }
  
  @NotNull
  public final CommonDialogBuilder c(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.o = Integer.valueOf(paramInt);
      return this;
    }
    throw ((Throwable)new Exception("marginTop can not be negative! if you do not set,the default value is 35dp."));
  }
  
  @NotNull
  public final CommonDialogBuilder d(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.p = Integer.valueOf(paramInt);
      return this;
    }
    throw ((Throwable)new Exception("marginBottom can not be negative! if you do not set,the default value is 35dp."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.CommonDialogBuilder
 * JD-Core Version:    0.7.0.1
 */