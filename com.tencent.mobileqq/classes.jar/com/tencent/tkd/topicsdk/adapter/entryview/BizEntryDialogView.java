package com.tencent.tkd.topicsdk.adapter.entryview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.tkd.topicsdk.entry.dialog.BaseEntryDialogView;
import com.tencent.tkd.topicsdk.qq_adapter.R.id;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/adapter/entryview/BizEntryDialogView;", "Lcom/tencent/tkd/topicsdk/entry/dialog/BaseEntryDialogView;", "context", "Landroid/content/Context;", "isDraftStatus", "", "(Landroid/content/Context;Z)V", "initCancelLayout", "", "onAttachedToWindow", "Companion", "qq-adapter_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class BizEntryDialogView
  extends BaseEntryDialogView
{
  public static final BizEntryDialogView.Companion a = new BizEntryDialogView.Companion(null);
  private final boolean b;
  
  public BizEntryDialogView(@NotNull Context paramContext, boolean paramBoolean)
  {
    super(paramContext, a.a());
    this.b = paramBoolean;
  }
  
  private final void a()
  {
    ((ImageView)getContainerView().findViewById(R.id.o)).setOnClickListener((View.OnClickListener)new BizEntryDialogView.initCancelLayout.1(this));
  }
  
  protected void onAttachedToWindow()
  {
    a();
    super.onAttachedToWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.entryview.BizEntryDialogView
 * JD-Core Version:    0.7.0.1
 */