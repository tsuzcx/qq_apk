package com.tencent.mobileqq.kandian.biz.diandian.entryview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.tkd.topicsdk.entry.IEntryViewBridge;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/diandian/entryview/RIJEntryViewBridge;", "Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "context", "Landroid/content/Context;", "from", "", "(Landroid/content/Context;I)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "entryDraftDrawable", "Landroid/graphics/drawable/Drawable;", "getEntryDraftDrawable", "()Landroid/graphics/drawable/Drawable;", "entryDraftNightDrawable", "getEntryDraftNightDrawable", "entryDrawable", "getEntryDrawable", "entryNightDrawable", "getEntryNightDrawable", "isNightStatus", "", "()Z", "onPublishClickListener", "Lkotlin/Function0;", "", "getOnPublishClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnPublishClickListener", "(Lkotlin/jvm/functions/Function0;)V", "isDraftStatus", "innerBundle", "Landroid/os/Bundle;", "loadCircleImage", "view", "Landroid/widget/ImageView;", "path", "", "radius", "onAddPublishViewClicked", "outerBundle", "onCancelViewClicked", "id", "onSuccess", "onFirstSubViewClicked", "onMainEntryViewClicked", "Lcom/tencent/tkd/topicsdk/entry/square/SquareEntryView;", "onPauseViewClicked", "onResumeViewClicked", "onRetryViewClicked", "onSecondSubViewClicked", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJEntryViewBridge
  implements IEntryViewBridge
{
  @Nullable
  private Function0<Unit> a;
  @NotNull
  private Context b;
  private final int c;
  
  public RIJEntryViewBridge(@NotNull Context paramContext, int paramInt)
  {
    this.b = paramContext;
    this.c = paramInt;
  }
  
  @NotNull
  public Drawable a()
  {
    Drawable localDrawable = this.b.getResources().getDrawable(2097479751);
    Intrinsics.checkExpressionValueIsNotNull(localDrawable, "context.resources.getDra…le.tkdp_icon_add_publish)");
    return localDrawable;
  }
  
  public void a(@NotNull Context paramContext, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    RIJEntryViewUtils.a(RIJEntryViewUtils.a, (Activity)paramContext, RIJEntryViewUtils.b(), this.c, -1, null, null, null, 112, null);
    paramContext = this.a;
    if (paramContext != null) {
      paramContext = (Unit)paramContext.invoke();
    }
  }
  
  public void a(@NotNull ImageView paramImageView, @NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramImageView, "view");
    Intrinsics.checkParameterIsNotNull(paramString, "path");
  }
  
  public final void a(@Nullable Function0<Unit> paramFunction0)
  {
    this.a = paramFunction0;
  }
  
  public boolean a(@Nullable Bundle paramBundle)
  {
    return false;
  }
  
  @NotNull
  public Drawable b()
  {
    Drawable localDrawable = this.b.getResources().getDrawable(2097479751);
    Intrinsics.checkExpressionValueIsNotNull(localDrawable, "context.resources.getDra…le.tkdp_icon_add_publish)");
    return localDrawable;
  }
  
  @NotNull
  public Drawable c()
  {
    Drawable localDrawable = this.b.getResources().getDrawable(2097479751);
    Intrinsics.checkExpressionValueIsNotNull(localDrawable, "context.resources.getDra…le.tkdp_icon_add_publish)");
    return localDrawable;
  }
  
  @NotNull
  public Drawable d()
  {
    Drawable localDrawable = this.b.getResources().getDrawable(2097479751);
    Intrinsics.checkExpressionValueIsNotNull(localDrawable, "context.resources.getDra…le.tkdp_icon_add_publish)");
    return localDrawable;
  }
  
  public boolean e()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewBridge
 * JD-Core Version:    0.7.0.1
 */