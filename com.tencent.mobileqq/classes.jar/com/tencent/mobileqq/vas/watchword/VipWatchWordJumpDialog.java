package com.tencent.mobileqq.vas.watchword;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJWatchWordJumpDialog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/watchword/VipWatchWordJumpDialog;", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJWatchWordJumpDialog;", "parent", "Landroid/view/ViewGroup;", "userName", "", "shareMsg", "jumpAction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "clickType", "", "(Landroid/view/ViewGroup;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "createView", "Landroid/view/View;", "getText", "textView", "Landroid/widget/TextView;", "maxWidth", "str1", "str2", "initOnClickListener", "initView", "onClick", "v", "setCoverUrl", "portrait", "url", "setTitle", "text", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VipWatchWordJumpDialog
  extends RIJWatchWordJumpDialog
{
  private final String a;
  private final String b;
  
  public VipWatchWordJumpDialog(@NotNull ViewGroup paramViewGroup, @NotNull String paramString1, @NotNull String paramString2, @Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    super(paramViewGroup, paramFunction1);
    this.a = paramString1;
    this.b = paramString2;
    d();
    c();
  }
  
  private final void c()
  {
    ImageView localImageView = (ImageView)a(2131381434);
    if (localImageView != null) {
      localImageView.setOnClickListener((View.OnClickListener)this);
    }
  }
  
  private final void d()
  {
    TextView localTextView = (TextView)a(2131381083);
    if (localTextView != null) {
      localTextView.setText((CharSequence)a(localTextView, ScreenUtil.a(236.0F), this.a, this.b));
    }
  }
  
  @Nullable
  public final String a(@NotNull TextView paramTextView, int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "textView");
    Intrinsics.checkParameterIsNotNull(paramString1, "str1");
    Intrinsics.checkParameterIsNotNull(paramString2, "str2");
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView = paramString1 + paramString2;
    if (Layout.getDesiredWidth((CharSequence)paramTextView, localTextPaint) < paramInt) {}
    label154:
    for (;;)
    {
      return paramTextView;
      int i = paramString1.length() - 1;
      for (;;)
      {
        if (i < 1) {
          break label154;
        }
        paramTextView = new StringBuilder();
        String str = paramString1.substring(0, i);
        Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        str = str + "..." + paramString2;
        float f = Layout.getDesiredWidth((CharSequence)str, localTextPaint);
        paramTextView = str;
        if (paramInt > f) {
          break;
        }
        i -= 1;
        paramTextView = str;
      }
    }
  }
  
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = ((Drawable)new ColorDrawable(0));
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((Drawable)new ColorDrawable(0));
    paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    localObject = (ImageView)a(2131373150);
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable((Drawable)paramString);
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    TextView localTextView = (TextView)a(2131379536);
    if (localTextView != null) {
      localTextView.setText((CharSequence)paramString);
    }
  }
  
  @NotNull
  public View b()
  {
    View localView = LayoutInflater.from(a().getContext()).inflate(2131561737, a(), false);
    Intrinsics.checkExpressionValueIsNotNull(localView, "LayoutInflater.from(pare…mp_dialog, parent, false)");
    return localView;
  }
  
  public void onClick(@Nullable View paramView)
  {
    super.onClick(paramView);
    if (Intrinsics.areEqual(paramView, a(2131381434)))
    {
      Object localObject = a();
      if (localObject != null) {
        localObject = (Unit)((Function1)localObject).invoke(Integer.valueOf(1));
      }
      b(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.watchword.VipWatchWordJumpDialog
 * JD-Core Version:    0.7.0.1
 */