package com.tencent.tkd.topicsdk.entry;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "", "entryDraftDrawable", "Landroid/graphics/drawable/Drawable;", "getEntryDraftDrawable", "()Landroid/graphics/drawable/Drawable;", "entryDraftNightDrawable", "getEntryDraftNightDrawable", "entryDrawable", "getEntryDrawable", "entryNightDrawable", "getEntryNightDrawable", "theme", "", "getTheme", "()I", "setTheme", "(I)V", "onAddPublishViewClicked", "", "view", "Lcom/tencent/tkd/topicsdk/entry/EntryView;", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "innerBundle", "Landroid/os/Bundle;", "outerBundle", "onCreateTopicViewClicked", "onPublishArticleViewClicked", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface IEntryViewBridge
{
  public static final IEntryViewBridge.Companion a = IEntryViewBridge.Companion.a;
  
  @NotNull
  public abstract Drawable a();
  
  public abstract void a(@NotNull EntryView paramEntryView, @Nullable GlobalPublisherConfig paramGlobalPublisherConfig, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2);
  
  @NotNull
  public abstract Drawable b();
  
  public abstract void b(@NotNull EntryView paramEntryView, @Nullable GlobalPublisherConfig paramGlobalPublisherConfig, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2);
  
  @NotNull
  public abstract Drawable c();
  
  public abstract void c(@NotNull EntryView paramEntryView, @Nullable GlobalPublisherConfig paramGlobalPublisherConfig, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2);
  
  @NotNull
  public abstract Drawable d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.IEntryViewBridge
 * JD-Core Version:    0.7.0.1
 */