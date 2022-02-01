package com.tencent.tkd.topicsdk.publisharticle.selectPopup;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/selectPopup/SelectPopupView;", "Landroid/widget/PopupWindow;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "closeView", "Landroid/widget/ImageView;", "containerView", "Landroid/view/View;", "value", "", "countLimit", "getCountLimit", "()I", "setCountLimit", "(I)V", "countLimitView", "Landroid/widget/TextView;", "Lkotlin/Function0;", "", "onCloseClickListener", "getOnCloseClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnCloseClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onLayoutClickListener", "getOnLayoutClickListener", "setOnLayoutClickListener", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleView", "wording", "getWording", "setWording", "wordingView", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SelectPopupView
  extends PopupWindow
{
  @NotNull
  private String a = "";
  @NotNull
  private String b = "";
  private int c = 12;
  private View d;
  private TextView e;
  private TextView f;
  private ImageView g;
  private TextView h;
  @Nullable
  private Function0<Unit> i;
  @Nullable
  private Function0<Unit> j;
  
  public SelectPopupView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(R.layout.B, null, false);
    View localView = paramAttributeSet.findViewById(R.id.aH);
    Intrinsics.checkExpressionValueIsNotNull(localView, "it.findViewById(R.id.tv_title)");
    this.e = ((TextView)localView);
    localView = paramAttributeSet.findViewById(R.id.aK);
    Intrinsics.checkExpressionValueIsNotNull(localView, "it.findViewById(R.id.tv_wording)");
    this.f = ((TextView)localView);
    localView = paramAttributeSet.findViewById(R.id.B);
    Intrinsics.checkExpressionValueIsNotNull(localView, "it.findViewById(R.id.iv_cancel)");
    this.g = ((ImageView)localView);
    localView = paramAttributeSet.findViewById(R.id.ax);
    Intrinsics.checkExpressionValueIsNotNull(localView, "it.findViewById(R.id.tv_count_limit)");
    this.h = ((TextView)localView);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "LayoutInflater.from(cont…_limit)\n                }");
    this.d = paramAttributeSet;
    setContentView(this.d);
    setWidth(DisplayUtils.a.a(paramContext, 254.0F));
    setHeight(-2);
    if (Build.VERSION.SDK_INT >= 21) {
      setElevation(10.0F);
    }
    setBackgroundDrawable(null);
    this.f.addTextChangedListener((TextWatcher)new SelectPopupView.2(this));
  }
  
  @NotNull
  public final String a()
  {
    return this.b;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.a = paramString;
    this.e.setText((CharSequence)paramString);
  }
  
  public final void a(@Nullable Function0<Unit> paramFunction0)
  {
    this.i = paramFunction0;
    this.g.setOnClickListener((View.OnClickListener)new SelectPopupView.onCloseClickListener.1(paramFunction0));
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.b = paramString;
    this.f.setText((CharSequence)paramString);
  }
  
  public final void b(@Nullable Function0<Unit> paramFunction0)
  {
    this.j = paramFunction0;
    this.d.setOnClickListener((View.OnClickListener)new SelectPopupView.onLayoutClickListener.1(paramFunction0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.selectPopup.SelectPopupView
 * JD-Core Version:    0.7.0.1
 */