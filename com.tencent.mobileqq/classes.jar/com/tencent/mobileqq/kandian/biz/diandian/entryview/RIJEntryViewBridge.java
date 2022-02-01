package com.tencent.mobileqq.kandian.biz.diandian.entryview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.tkd.topicsdk.entry.IEntryViewBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/diandian/entryview/RIJEntryViewBridge;", "Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "entryDraftDrawable", "Landroid/graphics/drawable/Drawable;", "getEntryDraftDrawable", "()Landroid/graphics/drawable/Drawable;", "entryDraftNightDrawable", "getEntryDraftNightDrawable", "entryDrawable", "getEntryDrawable", "entryNightDrawable", "getEntryNightDrawable", "isNightStatus", "", "()Z", "isDraftStatus", "innerBundle", "Landroid/os/Bundle;", "loadCircleImage", "", "view", "Landroid/widget/ImageView;", "path", "", "radius", "", "onAddPublishViewClicked", "openType", "outerBundle", "onCancelViewClicked", "id", "onSuccess", "Lkotlin/Function0;", "onCreateTopicViewClicked", "onFirstSubViewClicked", "onMainEntryViewClicked", "Lcom/tencent/tkd/topicsdk/entry/square/SquareEntryView;", "onPublishArticleViewClicked", "onRetryViewClicked", "onSecondSubViewClicked", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJEntryViewBridge
  implements IEntryViewBridge
{
  @NotNull
  private Context a;
  
  public RIJEntryViewBridge(@NotNull Context paramContext)
  {
    this.a = paramContext;
  }
  
  @NotNull
  public Drawable a()
  {
    Drawable localDrawable = this.a.getResources().getDrawable(2097479749);
    Intrinsics.checkExpressionValueIsNotNull(localDrawable, "context.resources.getDra…le.tkdp_icon_add_publish)");
    return localDrawable;
  }
  
  public void a(@NotNull Context paramContext, int paramInt, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    RIJEntryViewUtils.a.a((Activity)paramContext, RIJEntryViewUtils.a.a(), null, null, 8, null, -1);
  }
  
  public void a(@NotNull ImageView paramImageView, @NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramImageView, "view");
    Intrinsics.checkParameterIsNotNull(paramString, "path");
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(@Nullable Bundle paramBundle)
  {
    return false;
  }
  
  @NotNull
  public Drawable b()
  {
    Drawable localDrawable = this.a.getResources().getDrawable(2097479749);
    Intrinsics.checkExpressionValueIsNotNull(localDrawable, "context.resources.getDra…le.tkdp_icon_add_publish)");
    return localDrawable;
  }
  
  @NotNull
  public Drawable c()
  {
    Drawable localDrawable = this.a.getResources().getDrawable(2097479749);
    Intrinsics.checkExpressionValueIsNotNull(localDrawable, "context.resources.getDra…le.tkdp_icon_add_publish)");
    return localDrawable;
  }
  
  @NotNull
  public Drawable d()
  {
    Drawable localDrawable = this.a.getResources().getDrawable(2097479749);
    Intrinsics.checkExpressionValueIsNotNull(localDrawable, "context.resources.getDra…le.tkdp_icon_add_publish)");
    return localDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewBridge
 * JD-Core Version:    0.7.0.1
 */