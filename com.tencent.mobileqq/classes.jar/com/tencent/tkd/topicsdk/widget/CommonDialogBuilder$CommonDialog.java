package com.tencent.tkd.topicsdk.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/CommonDialogBuilder$CommonDialog;", "Landroid/app/AlertDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSplitLine", "Landroid/view/View;", "contentMarginBottom", "", "getContentMarginBottom", "()I", "setContentMarginBottom", "(I)V", "contentMarginBottomView", "customContentView", "getCustomContentView", "()Landroid/view/View;", "setCustomContentView", "(Landroid/view/View;)V", "isForbidBackPress", "", "()Z", "setForbidBackPress", "(Z)V", "mContentLayout", "Landroid/widget/RelativeLayout;", "mMessage", "", "mMessageView", "Landroid/widget/TextView;", "mNegativeButton", "mPositiveButton", "mTitleView", "messageTextClickAction", "Lkotlin/Function0;", "", "getMessageTextClickAction", "()Lkotlin/jvm/functions/Function0;", "setMessageTextClickAction", "(Lkotlin/jvm/functions/Function0;)V", "messageViewGravity", "getMessageViewGravity", "()Ljava/lang/Integer;", "setMessageViewGravity", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "negativeButtonCallback", "Lcom/tencent/tkd/topicsdk/widget/CommonDialogBuilder$ICommonDialogListener;", "getNegativeButtonCallback", "()Lcom/tencent/tkd/topicsdk/widget/CommonDialogBuilder$ICommonDialogListener;", "setNegativeButtonCallback", "(Lcom/tencent/tkd/topicsdk/widget/CommonDialogBuilder$ICommonDialogListener;)V", "negativeButtonMessage", "", "getNegativeButtonMessage", "()Ljava/lang/String;", "setNegativeButtonMessage", "(Ljava/lang/String;)V", "negativeButtonTextColor", "getNegativeButtonTextColor", "setNegativeButtonTextColor", "positiveButtonCallback", "getPositiveButtonCallback", "setPositiveButtonCallback", "positiveButtonMessage", "getPositiveButtonMessage", "setPositiveButtonMessage", "positiveButtonTextColor", "getPositiveButtonTextColor", "setPositiveButtonTextColor", "title", "getTitle", "setTitle", "titleMarginTop", "getTitleMarginTop", "setTitleMarginTop", "titleMarginTopView", "titleTextColor", "getTitleTextColor", "setTitleTextColor", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setMessage", "message", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class CommonDialogBuilder$CommonDialog
  extends AlertDialog
{
  private CharSequence a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private RelativeLayout f;
  private View g;
  private View h;
  private View i;
  @Nullable
  private String j;
  @Nullable
  private String k;
  @Nullable
  private String l;
  @Nullable
  private CommonDialogBuilder.ICommonDialogListener m;
  @Nullable
  private CommonDialogBuilder.ICommonDialogListener n;
  @Nullable
  private Function0<Unit> o;
  @Nullable
  private Integer p;
  @Nullable
  private Integer q;
  @Nullable
  private Integer r;
  @Nullable
  private Integer s;
  @Nullable
  private View t;
  private boolean u;
  private int v;
  private int w;
  
  public CommonDialogBuilder$CommonDialog(@NotNull Context paramContext)
  {
    super(paramContext, R.style.a);
    this.v = DisplayUtils.a.a(35.0F, paramContext);
    this.w = DisplayUtils.a.a(35.0F, paramContext);
  }
  
  @Nullable
  public final CommonDialogBuilder.ICommonDialogListener a()
  {
    return this.m;
  }
  
  public final void a(int paramInt)
  {
    this.v = paramInt;
  }
  
  public final void a(@Nullable View paramView)
  {
    this.t = paramView;
  }
  
  public final void a(@Nullable CommonDialogBuilder.ICommonDialogListener paramICommonDialogListener)
  {
    this.m = paramICommonDialogListener;
  }
  
  public final void a(@Nullable Integer paramInteger)
  {
    this.p = paramInteger;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.j = paramString;
  }
  
  public final void a(@Nullable Function0<Unit> paramFunction0)
  {
    this.o = paramFunction0;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  @Nullable
  public final CommonDialogBuilder.ICommonDialogListener b()
  {
    return this.n;
  }
  
  public final void b(int paramInt)
  {
    this.w = paramInt;
  }
  
  public final void b(@Nullable CommonDialogBuilder.ICommonDialogListener paramICommonDialogListener)
  {
    this.n = paramICommonDialogListener;
  }
  
  public final void b(@Nullable Integer paramInteger)
  {
    this.q = paramInteger;
  }
  
  public final void b(@Nullable String paramString)
  {
    this.k = paramString;
  }
  
  public final void c(@Nullable Integer paramInteger)
  {
    this.r = paramInteger;
  }
  
  public final void c(@Nullable String paramString)
  {
    this.l = paramString;
  }
  
  public final void d(@Nullable Integer paramInteger)
  {
    this.s = paramInteger;
  }
  
  public void onBackPressed()
  {
    if (!this.u) {
      super.onBackPressed();
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.a);
    paramBundle = findViewById(R.id.b);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "findViewById(R.id.contentLayout)");
    this.f = ((RelativeLayout)paramBundle);
    this.b = ((TextView)findViewById(R.id.h));
    this.c = ((TextView)findViewById(R.id.e));
    this.d = ((TextView)findViewById(R.id.g));
    this.e = ((TextView)findViewById(R.id.f));
    paramBundle = findViewById(R.id.a);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "findViewById(R.id.bottomSplitLine)");
    this.g = paramBundle;
    paramBundle = findViewById(R.id.i);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "findViewById(R.id.title_margin_top)");
    this.h = paramBundle;
    paramBundle = findViewById(R.id.c);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "findViewById(R.id.content_margin_Bottom)");
    this.i = paramBundle;
    int i1;
    if (!TextUtils.isEmpty((CharSequence)this.j))
    {
      paramBundle = this.b;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)this.j);
      }
      paramBundle = this.p;
      if (paramBundle != null)
      {
        i1 = ((Number)paramBundle).intValue();
        paramBundle = this.b;
        if (paramBundle != null) {
          paramBundle.setTextColor(i1);
        }
      }
    }
    else
    {
      paramBundle = this.b;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    paramBundle = this.c;
    if (paramBundle != null) {
      paramBundle.setMovementMethod(LinkMovementMethod.getInstance());
    }
    paramBundle = this.c;
    int i2 = 0;
    if (paramBundle != null) {
      paramBundle.setHighlightColor(0);
    }
    Object localObject;
    if (this.t != null)
    {
      paramBundle = this.c;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.f;
      if (paramBundle == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mContentLayout");
      }
      paramBundle.addView(this.t);
    }
    else
    {
      paramBundle = this.a;
      if ((paramBundle != null) && (paramBundle.length() != 0)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if (i1 != 0)
      {
        paramBundle = this.c;
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
      }
      else
      {
        paramBundle = this.c;
        if (paramBundle != null) {
          paramBundle.setVisibility(0);
        }
        paramBundle = this.c;
        if (paramBundle != null) {
          paramBundle.setText(this.a);
        }
        paramBundle = this.c;
        if (paramBundle != null)
        {
          localObject = this.s;
          if (localObject != null) {
            i1 = ((Integer)localObject).intValue();
          } else {
            i1 = 17;
          }
          paramBundle.setGravity(i1);
        }
      }
    }
    paramBundle = this.h;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleMarginTopView");
    }
    paramBundle.getLayoutParams().height = this.v;
    paramBundle = this.i;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("contentMarginBottomView");
    }
    paramBundle.getLayoutParams().height = this.w;
    paramBundle = this.k;
    if (paramBundle != null)
    {
      paramBundle = (CharSequence)paramBundle;
      if (paramBundle.length() > 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        localObject = this.e;
        if (localObject != null) {
          ((TextView)localObject).setText(paramBundle);
        }
        paramBundle = this.r;
        if (paramBundle == null) {
          break label656;
        }
        i1 = ((Number)paramBundle).intValue();
        paramBundle = this.e;
        if (paramBundle == null) {
          break label656;
        }
        paramBundle.setTextColor(i1);
        break label656;
      }
    }
    paramBundle = this.e;
    if (paramBundle != null) {
      paramBundle.setText((CharSequence)"");
    }
    paramBundle = this.e;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.g;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSplitLine");
    }
    paramBundle.setVisibility(8);
    paramBundle = this.d;
    if (paramBundle != null)
    {
      localObject = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      paramBundle.setBackground(((Context)localObject).getResources().getDrawable(R.drawable.e));
    }
    label656:
    paramBundle = this.e;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new CommonDialogBuilder.CommonDialog.onCreate.3(this));
    }
    paramBundle = this.l;
    if (paramBundle != null)
    {
      paramBundle = (CharSequence)paramBundle;
      i1 = i2;
      if (paramBundle.length() > 0) {
        i1 = 1;
      }
      if (i1 != 0)
      {
        localObject = this.d;
        if (localObject != null) {
          ((TextView)localObject).setText(paramBundle);
        }
        paramBundle = this.q;
        if (paramBundle == null) {
          break label835;
        }
        i1 = ((Number)paramBundle).intValue();
        paramBundle = this.d;
        if (paramBundle == null) {
          break label835;
        }
        paramBundle.setTextColor(i1);
        break label835;
      }
    }
    paramBundle = this.d;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.g;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bottomSplitLine");
    }
    paramBundle.setVisibility(8);
    paramBundle = this.e;
    if (paramBundle != null)
    {
      localObject = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      paramBundle.setBackground(((Context)localObject).getResources().getDrawable(R.drawable.e));
    }
    label835:
    paramBundle = this.d;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new CommonDialogBuilder.CommonDialog.onCreate.5(this));
    }
  }
  
  public void setMessage(@Nullable CharSequence paramCharSequence)
  {
    super.setMessage(paramCharSequence);
    this.a = paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.CommonDialogBuilder.CommonDialog
 * JD-Core Version:    0.7.0.1
 */