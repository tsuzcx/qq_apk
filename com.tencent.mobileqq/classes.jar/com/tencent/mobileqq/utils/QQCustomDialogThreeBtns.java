package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ListView;

public class QQCustomDialogThreeBtns
  extends ReportDialog
{
  TextView a;
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  LinearLayout f;
  ListView g;
  TextView h;
  String[] i;
  LayoutInflater j;
  DialogInterface.OnClickListener k;
  private BaseAdapter l = new QQCustomDialogThreeBtns.1(this);
  
  public QQCustomDialogThreeBtns(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a()
  {
    b();
  }
  
  private void b()
  {
    TextView localTextView;
    if (this.d.getVisibility() == 0)
    {
      localTextView = this.d;
      return;
    }
    if (this.e.getVisibility() == 0)
    {
      localTextView = this.e;
      return;
    }
    if (this.c.getVisibility() == 0) {
      localTextView = this.c;
    }
  }
  
  protected int a(int paramInt)
  {
    return paramInt;
  }
  
  public QQCustomDialogThreeBtns a(String paramString)
  {
    if (paramString != null)
    {
      this.a.setText(paramString);
      this.a.setVisibility(0);
      paramString = this.i;
      return this;
    }
    this.a.setVisibility(8);
    return this;
  }
  
  public QQCustomDialogThreeBtns a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramString);
    this.c.setVisibility(0);
    this.c.setOnClickListener(new QQCustomDialogThreeBtns.2(this, paramOnClickListener));
    a();
    return this;
  }
  
  public QQCustomDialogThreeBtns b(String paramString)
  {
    if (paramString != null)
    {
      this.b.setText(paramString);
      this.b.setVisibility(0);
      return this;
    }
    this.b.setVisibility(8);
    return this;
  }
  
  public QQCustomDialogThreeBtns b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.e.setVisibility(8);
      return this;
    }
    this.e.setText(paramString);
    this.e.setVisibility(0);
    this.e.setOnClickListener(new QQCustomDialogThreeBtns.3(this, paramOnClickListener));
    a();
    return this;
  }
  
  public QQCustomDialogThreeBtns c(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramString);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new QQCustomDialogThreeBtns.4(this, paramOnClickListener));
    a();
    return this;
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.a = ((TextView)findViewById(2131431880));
    this.b = ((TextView)findViewById(2131431876));
    this.h = ((TextView)findViewById(2131440611));
    this.c = ((TextView)findViewById(2131431864));
    this.e = ((TextView)findViewById(2131431867));
    this.d = ((TextView)findViewById(2131431870));
    this.c.setVisibility(8);
    this.e.setVisibility(8);
    this.d.setVisibility(8);
    this.f = ((LinearLayout)findViewById(2131429603));
    this.g = ((ListView)findViewById(2131437272));
  }
  
  public void setTitle(int paramInt)
  {
    this.a.setText(paramInt);
    this.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogThreeBtns
 * JD-Core Version:    0.7.0.1
 */