package com.tencent.mobileqq.kandian.biz.ugc.finishdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/finishdialog/KanDianPublishFinishGuideDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "dismiss", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setTranslucentStatusBar", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KanDianPublishFinishGuideDialog
  extends Dialog
{
  @NotNull
  private final Activity a;
  
  public KanDianPublishFinishGuideDialog(@NotNull Activity paramActivity)
  {
    super((Context)paramActivity, 16973833);
    this.a = paramActivity;
  }
  
  private final void a()
  {
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        View localView = localWindow.getDecorView();
        Intrinsics.checkExpressionValueIsNotNull(localView, "decorView");
        localView.setSystemUiVisibility(1280);
        localWindow.addFlags(-2147483648);
        localWindow.setStatusBarColor(0);
        return;
      }
      if (Build.VERSION.SDK_INT == 19) {
        localWindow.addFlags(67108864);
      }
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    this.a.finish();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      localWindow.requestFeature(1);
      localWindow.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      localWindow.setLayout(-1, -1);
      setCanceledOnTouchOutside(false);
      setCancelable(true);
    }
    a();
    super.onCreate(paramBundle);
    setContentView(2097610752);
    paramBundle = RIJTransMergeKanDianReport.g().addTime();
    paramBundle.addString("uin", RIJQQAppInterfaceUtil.d());
    findViewById(2097545242).setOnClickListener((View.OnClickListener)new KanDianPublishFinishGuideDialog.onCreate.2(this, paramBundle));
    findViewById(2097545339).setOnClickListener((View.OnClickListener)new KanDianPublishFinishGuideDialog.onCreate.3(this, paramBundle));
    findViewById(2097545289).setOnClickListener((View.OnClickListener)new KanDianPublishFinishGuideDialog.onCreate.4(this, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.finishdialog.KanDianPublishFinishGuideDialog
 * JD-Core Version:    0.7.0.1
 */