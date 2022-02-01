package com.tencent.tkd.topicsdk.entry.controller;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/entry/controller/IEntryViewController;", "", "addEntryView", "", "innerBundle", "Landroid/os/Bundle;", "outerBundle", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "viewId", "getBizView", "Landroid/view/View;", "style", "", "getEntryViewStatus", "getViewStyle", "hideEntryView", "removeEntryView", "showEntryView", "updateEntryViewData", "Companion", "EntryViewStyle", "topicsdk-entryview_release"}, k=1, mv={1, 1, 16})
public abstract interface IEntryViewController
{
  public static final IEntryViewController.Companion a = IEntryViewController.Companion.a;
  
  public abstract void a(@NotNull String paramString, @Nullable Function1<? super String, Unit> paramFunction1);
  
  public abstract void b(@NotNull String paramString, @Nullable Function1<? super String, Unit> paramFunction1);
  
  public abstract void c(@NotNull String paramString, @Nullable Function1<? super String, Unit> paramFunction1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.controller.IEntryViewController
 * JD-Core Version:    0.7.0.1
 */