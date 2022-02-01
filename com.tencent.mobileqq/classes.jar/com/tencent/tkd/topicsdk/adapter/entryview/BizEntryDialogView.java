package com.tencent.tkd.topicsdk.adapter.entryview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.tkd.topicsdk.entry.dialog.BaseEntryDialogView;
import com.tencent.tkd.topicsdk.qq_adapter.R.id;
import com.tencent.tkd.topicsdk.qq_adapter.R.layout;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/adapter/entryview/BizEntryDialogView;", "Lcom/tencent/tkd/topicsdk/entry/dialog/BaseEntryDialogView;", "context", "Landroid/content/Context;", "isDraftStatus", "", "(Landroid/content/Context;Z)V", "doOnCreate", "", "getLayoutId", "", "initCancelLayout", "qq-adapter_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class BizEntryDialogView
  extends BaseEntryDialogView
{
  private final boolean a;
  
  public BizEntryDialogView(@NotNull Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.a = paramBoolean;
  }
  
  private final void b()
  {
    ((ImageView)a().findViewById(R.id.g)).setOnClickListener((View.OnClickListener)new BizEntryDialogView.initCancelLayout.1(this));
  }
  
  public int a()
  {
    return R.layout.c;
  }
  
  public void a()
  {
    super.a();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.entryview.BizEntryDialogView
 * JD-Core Version:    0.7.0.1
 */