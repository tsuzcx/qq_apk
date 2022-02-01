package com.tencent.tkd.topicsdk.adapter.entryview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.entry.IEntryViewBridge;
import com.tencent.tkd.topicsdk.entry.controller.BaseEntryViewController;
import com.tencent.tkd.topicsdk.interfaces.IFloatViewManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/adapter/entryview/BizEntryViewController;", "Lcom/tencent/tkd/topicsdk/entry/controller/BaseEntryViewController;", "context", "Landroid/content/Context;", "bridge", "Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "floatViewManager", "Lcom/tencent/tkd/topicsdk/interfaces/IFloatViewManager;", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;Lcom/tencent/tkd/topicsdk/interfaces/IFloatViewManager;)V", "getBizView", "Landroid/view/View;", "style", "", "innerBundle", "Landroid/os/Bundle;", "outerBundle", "getViewLayoutParam", "Landroid/widget/FrameLayout$LayoutParams;", "Companion", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class BizEntryViewController
  extends BaseEntryViewController
{
  public static final BizEntryViewController.Companion a = new BizEntryViewController.Companion(null);
  private final Context d;
  private final IEntryViewBridge e;
  
  public BizEntryViewController(@NotNull Context paramContext, @NotNull IEntryViewBridge paramIEntryViewBridge, @NotNull IFloatViewManager paramIFloatViewManager)
  {
    super(paramContext, paramIEntryViewBridge, paramIFloatViewManager);
    this.d = paramContext;
    this.e = paramIEntryViewBridge;
  }
  
  @NotNull
  public View a(int paramInt, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    ImageView localImageView = new ImageView(this.d);
    localImageView.setContentDescription((CharSequence)"腰部入口");
    localImageView.setImageDrawable(this.e.c());
    localImageView.setOnClickListener((View.OnClickListener)new BizEntryViewController.getBizView..inlined.apply.lambda.1(localImageView, this, paramBundle1, paramBundle2));
    return (View)localImageView;
  }
  
  @NotNull
  public FrameLayout.LayoutParams a(int paramInt, @Nullable Bundle paramBundle)
  {
    int m = 0;
    int i;
    if (paramBundle != null) {
      i = paramBundle.getInt("rightMargin");
    } else {
      i = 0;
    }
    int j;
    if (paramBundle != null) {
      j = paramBundle.getInt("bottomMargin");
    } else {
      j = 0;
    }
    if (paramBundle != null) {
      paramInt = paramBundle.getInt("width");
    } else {
      paramInt = 0;
    }
    int k = paramInt;
    if (paramInt == 0) {
      k = DisplayUtils.a.a(this.d, 48.0F);
    }
    paramInt = m;
    if (paramBundle != null) {
      paramInt = paramBundle.getInt("height");
    }
    m = paramInt;
    if (paramInt == 0) {
      m = DisplayUtils.a.a(this.d, 48.0F);
    }
    paramBundle = new FrameLayout.LayoutParams(k, m);
    paramBundle.rightMargin = i;
    paramBundle.bottomMargin = j;
    paramBundle.gravity = 8388693;
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.entryview.BizEntryViewController
 * JD-Core Version:    0.7.0.1
 */