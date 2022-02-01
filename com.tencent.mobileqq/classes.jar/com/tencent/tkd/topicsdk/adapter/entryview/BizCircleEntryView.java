package com.tencent.tkd.topicsdk.adapter.entryview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.tkd.topicsdk.entry.IEntryViewBridge;
import com.tencent.tkd.topicsdk.entry.circle.CircleEntryView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/adapter/entryview/BizCircleEntryView;", "Lcom/tencent/tkd/topicsdk/entry/circle/CircleEntryView;", "context", "Landroid/content/Context;", "bridge", "Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "iBundle", "Landroid/os/Bundle;", "oBundle", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;Landroid/os/Bundle;Landroid/os/Bundle;)V", "qq-adapter_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class BizCircleEntryView
  extends CircleEntryView
{
  public BizCircleEntryView(@NotNull Context paramContext, @NotNull IEntryViewBridge paramIEntryViewBridge, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    super(paramContext, paramIEntryViewBridge, paramBundle1, paramBundle2);
    b();
    setAddPublishViewClickListener((View.OnClickListener)new BizCircleEntryView.1(this, paramIEntryViewBridge, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.entryview.BizCircleEntryView
 * JD-Core Version:    0.7.0.1
 */