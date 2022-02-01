package com.tencent.mobileqq.wink.pick.circle.widget;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class WinkCancelableProgressDialog
  extends ReportDialog
{
  private ProgressPieDrawable a;
  private final TextView b;
  private final TextView c;
  
  public WinkCancelableProgressDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131953338);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    setContentView(2131628268);
    this.c = ((TextView)findViewById(2131448382));
    paramContext = (ImageView)findViewById(2131436506);
    this.a = a();
    paramContext.setImageDrawable(this.a);
    this.b = ((TextView)findViewById(2131429815));
  }
  
  private ProgressPieDrawable a()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(getContext());
    localProgressPieDrawable.a(ViewUtils.dip2px(94.0F));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.h(-1711276033);
    localProgressPieDrawable.i(18);
    localProgressPieDrawable.b(true);
    localProgressPieDrawable.d(false);
    localProgressPieDrawable.g(0);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.e(-16722948);
    localProgressPieDrawable.f(872415231);
    localProgressPieDrawable.j(6);
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.D = true;
    localProgressPieDrawable.A = 2;
    return localProgressPieDrawable;
  }
  
  public void a(int paramInt)
  {
    ProgressPieDrawable localProgressPieDrawable = this.a;
    if (localProgressPieDrawable == null) {
      return;
    }
    localProgressPieDrawable.b();
    this.a.d(paramInt);
    localProgressPieDrawable = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("%");
    localProgressPieDrawable.a(localStringBuilder.toString());
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.b.setOnClickListener(paramOnClickListener);
  }
  
  public void a(String paramString)
  {
    this.c.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.widget.WinkCancelableProgressDialog
 * JD-Core Version:    0.7.0.1
 */