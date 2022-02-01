package com.tencent.tkd.topicsdk.entry.controller;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.entry.IEntryViewBridge;
import com.tencent.tkd.topicsdk.entry.circle.CircleEntryView;
import com.tencent.tkd.topicsdk.entry.square.SquareEntryView;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.interfaces.IFloatViewManager;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/entry/controller/BaseEntryViewController;", "Lcom/tencent/tkd/topicsdk/entry/controller/IEntryViewController;", "context", "Landroid/content/Context;", "bridge", "Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "floatViewManager", "Lcom/tencent/tkd/topicsdk/interfaces/IFloatViewManager;", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;Lcom/tencent/tkd/topicsdk/interfaces/IFloatViewManager;)V", "entryViewMap", "Ljava/util/HashMap;", "", "Landroid/view/View;", "Lkotlin/collections/HashMap;", "addEntryView", "", "innerBundle", "Landroid/os/Bundle;", "outerBundle", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "viewId", "getBizView", "style", "", "getEntryViewStatus", "getViewLayoutParam", "Landroid/widget/FrameLayout$LayoutParams;", "getViewStyle", "hideEntryView", "removeEntryView", "showEntryView", "updateEntryViewData", "Companion", "topicsdk-entryview_release"}, k=1, mv={1, 1, 16})
public class BaseEntryViewController
  implements IEntryViewController
{
  public static final BaseEntryViewController.Companion b = new BaseEntryViewController.Companion(null);
  private final HashMap<String, View> a;
  private final Context d;
  private final IEntryViewBridge e;
  private final IFloatViewManager f;
  
  public BaseEntryViewController(@NotNull Context paramContext, @NotNull IEntryViewBridge paramIEntryViewBridge, @NotNull IFloatViewManager paramIFloatViewManager)
  {
    this.d = paramContext;
    this.e = paramIEntryViewBridge;
    this.f = paramIFloatViewManager;
    this.a = new HashMap();
  }
  
  public int a(@Nullable Bundle paramBundle)
  {
    int i = 0;
    if (paramBundle != null) {
      i = paramBundle.getInt("entryStyle", 0);
    }
    return i;
  }
  
  @NotNull
  public View a(int paramInt, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    if (paramInt == 1) {
      return (View)new SquareEntryView(this.d, this.e, paramBundle1, paramBundle2);
    }
    return (View)new CircleEntryView(this.d, this.e, paramBundle1, paramBundle2);
  }
  
  @NotNull
  public FrameLayout.LayoutParams a(int paramInt, @Nullable Bundle paramBundle)
  {
    int k = 0;
    int i;
    if (paramBundle != null) {
      i = paramBundle.getInt("topMargin");
    } else {
      i = 0;
    }
    int j;
    if (paramBundle != null) {
      j = paramBundle.getInt("rightMargin");
    } else {
      j = 0;
    }
    if (paramBundle != null) {
      k = paramBundle.getInt("bottomMargin");
    }
    paramBundle = new FrameLayout.LayoutParams(-2, -2);
    paramBundle.topMargin = i;
    paramBundle.bottomMargin = k;
    paramBundle.rightMargin = (j - DisplayUtils.a.a(this.d, 8.0F));
    if (paramInt == 1) {
      paramInt = 8388661;
    } else {
      paramInt = 8388693;
    }
    paramBundle.gravity = paramInt;
    return paramBundle;
  }
  
  public void a(@Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2, @Nullable Function1<? super String, Unit> paramFunction1)
  {
    int j = a(paramBundle1);
    paramBundle2 = a(j, paramBundle1, paramBundle2);
    String str = UUID.randomUUID().toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "UUID.randomUUID().toString()");
    int i;
    if (paramBundle1 != null) {
      i = paramBundle1.getInt("viewTag");
    } else {
      i = -1;
    }
    ((Map)this.a).put(str, paramBundle2);
    paramBundle2.setTag(Integer.valueOf(i));
    paramBundle2.setVisibility(0);
    ThreadManagerKt.a((Function0)new BaseEntryViewController.addEntryView.2(this, paramBundle2, a(j, paramBundle1), paramFunction1, str));
  }
  
  public void a(@NotNull String paramString, @Nullable Function1<? super String, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "viewId");
    ThreadManagerKt.a((Function0)new BaseEntryViewController.showEntryView.1(this, paramString, paramFunction1));
  }
  
  public void b(@NotNull String paramString, @Nullable Function1<? super String, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "viewId");
    ThreadManagerKt.a((Function0)new BaseEntryViewController.hideEntryView.1(this, paramString, paramFunction1));
  }
  
  public void c(@NotNull String paramString, @Nullable Function1<? super String, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "viewId");
    ThreadManagerKt.a((Function0)new BaseEntryViewController.removeEntryView.1(this, paramString, paramFunction1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.controller.BaseEntryViewController
 * JD-Core Version:    0.7.0.1
 */