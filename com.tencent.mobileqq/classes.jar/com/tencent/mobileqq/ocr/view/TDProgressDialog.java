package com.tencent.mobileqq.ocr.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class TDProgressDialog
  extends ReportDialog
{
  private Context a;
  private TDCircleProgressView b;
  private LayoutInflater c;
  private View d;
  private TextView e;
  private TextView f;
  private View g;
  
  public TDProgressDialog(Context paramContext)
  {
    super(paramContext, 2131953338);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    this.c = LayoutInflater.from(paramContext);
    this.d = this.c.inflate(2131625550, null);
    setCancelable(false);
    this.b = ((TDCircleProgressView)this.d.findViewById(2131430730));
    this.b.setCurrent(0);
    this.e = ((TextView)this.d.findViewById(2131448353));
    this.g = this.d.findViewById(2131449305);
    this.f = ((TextView)this.d.findViewById(2131448309));
  }
  
  public void a(int paramInt)
  {
    this.b.setCurrent(paramInt);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null) {
      this.f.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.e.setText(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    this.f.setVisibility(i);
    this.g.setVisibility(i);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setContentView(this.d);
    int i;
    if (this.f.getVisibility() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    float f1 = this.a.getResources().getDisplayMetrics().density;
    localLayoutParams.width = ((int)(320.0F * f1 + 0.5F));
    if (i == 0) {
      localLayoutParams.height = ((int)(f1 * 145.0F + 0.5F));
    } else {
      localLayoutParams.height = ((int)(f1 * 200.0F + 0.5F));
    }
    paramBundle.setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.TDProgressDialog
 * JD-Core Version:    0.7.0.1
 */