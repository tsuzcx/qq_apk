package com.tencent.tkd.topicsdk.entry;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "", "entryDraftDrawable", "Landroid/graphics/drawable/Drawable;", "getEntryDraftDrawable", "()Landroid/graphics/drawable/Drawable;", "entryDraftNightDrawable", "getEntryDraftNightDrawable", "entryDrawable", "getEntryDrawable", "entryNightDrawable", "getEntryNightDrawable", "isNightStatus", "", "()Z", "isDraftStatus", "innerBundle", "Landroid/os/Bundle;", "loadCircleImage", "", "view", "Landroid/widget/ImageView;", "path", "", "radius", "", "onAddPublishViewClicked", "context", "Landroid/content/Context;", "openType", "outerBundle", "onCancelViewClicked", "id", "onSuccess", "Lkotlin/Function0;", "onCreateTopicViewClicked", "onFirstSubViewClicked", "onMainEntryViewClicked", "Lcom/tencent/tkd/topicsdk/entry/square/SquareEntryView;", "onPublishArticleViewClicked", "onRetryViewClicked", "onSecondSubViewClicked", "onSecondSubViewLongClicked", "topicsdk-entryview_release"}, k=1, mv={1, 1, 16})
public abstract interface IEntryViewBridge
{
  @NotNull
  public abstract Drawable a();
  
  public abstract void a(@NotNull Context paramContext, int paramInt, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2);
  
  public abstract void a(@NotNull ImageView paramImageView, @NotNull String paramString, int paramInt);
  
  public abstract boolean a();
  
  public abstract boolean a(@Nullable Bundle paramBundle);
  
  @NotNull
  public abstract Drawable b();
  
  @NotNull
  public abstract Drawable c();
  
  @NotNull
  public abstract Drawable d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.IEntryViewBridge
 * JD-Core Version:    0.7.0.1
 */