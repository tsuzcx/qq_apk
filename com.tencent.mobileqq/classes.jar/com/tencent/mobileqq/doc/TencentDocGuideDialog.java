package com.tencent.mobileqq.doc;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class TencentDocGuideDialog
  extends ReportDialog
  implements View.OnClickListener
{
  private TencentDocGuideDialog.Callback a;
  
  public TencentDocGuideDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131953523);
    super.setContentView(2131624345);
    super.setCanceledOnTouchOutside(false);
    super.setCancelable(false);
    super.findViewById(2131430116).setOnClickListener(this);
  }
  
  public void a(TencentDocGuideDialog.Callback paramCallback)
  {
    this.a = paramCallback;
  }
  
  public void onClick(View paramView)
  {
    TencentDocGuideDialog.Callback localCallback = this.a;
    if (localCallback != null) {
      localCallback.a(this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doc.TencentDocGuideDialog
 * JD-Core Version:    0.7.0.1
 */