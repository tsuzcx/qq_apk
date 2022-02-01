package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class QQCustomSingleButtonDialog
  extends ReportDialog
{
  TextView a;
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  Button f;
  LinearLayout g;
  ListView h;
  TextView i;
  TextView j;
  ImageView k;
  View l;
  String[] m;
  LayoutInflater n;
  DialogInterface.OnClickListener o;
  private BaseAdapter p = new QQCustomSingleButtonDialog.1(this);
  
  public QQCustomSingleButtonDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected int a(int paramInt)
  {
    return paramInt;
  }
  
  public QQCustomSingleButtonDialog a(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.f.setVisibility(8);
      return this;
    }
    this.f.setBackgroundResource(paramInt1);
    this.f.setContentDescription(getContext().getString(paramInt2));
    this.f.setVisibility(0);
    this.f.setOnClickListener(new QQCustomSingleButtonDialog.3(this, paramOnClickListener));
    a();
    return this;
  }
  
  public QQCustomSingleButtonDialog a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setContentDescription(getContext().getString(paramInt));
    this.d.setVisibility(0);
    this.d.setOnClickListener(new QQCustomSingleButtonDialog.4(this, paramOnClickListener));
    a();
    return this;
  }
  
  public QQCustomSingleButtonDialog a(String paramString)
  {
    if (paramString != null)
    {
      this.a.setText(new QQText(paramString, 5, 24));
      this.b.setContentDescription(paramString);
      this.a.setVisibility(0);
      paramString = this.m;
      return this;
    }
    this.a.setVisibility(8);
    return this;
  }
  
  public QQCustomSingleButtonDialog a(String paramString, float paramFloat)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.b.setText(new QQText(paramString, 5, 20));
      this.b.setContentDescription(paramString);
      this.b.setVisibility(0);
      return this;
    }
    this.b.setVisibility(8);
    return this;
  }
  
  public QQCustomSingleButtonDialog a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(new QQText(paramString, 5, 20));
    this.d.setContentDescription(paramString);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new QQCustomSingleButtonDialog.2(this, paramOnClickListener));
    a();
    return this;
  }
  
  protected void a() {}
  
  public QQCustomSingleButtonDialog b(int paramInt)
  {
    this.b.setText(paramInt);
    this.b.setContentDescription(getContext().getString(paramInt));
    this.b.setVisibility(0);
    return this;
  }
  
  public QQCustomSingleButtonDialog b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.b.setText(paramString);
      this.b.setContentDescription(paramString);
      this.b.setVisibility(0);
      return this;
    }
    this.b.setVisibility(8);
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
    this.c = ((TextView)findViewById(2131431852));
    this.e = ((TextView)findViewById(2131431853));
    this.j = ((TextView)findViewById(2131432265));
    this.i = ((TextView)findViewById(2131440611));
    this.k = ((ImageView)findViewById(2131433674));
    this.l = findViewById(2131433673);
    this.f = ((Button)findViewById(2131431864));
    this.d = ((TextView)findViewById(2131431870));
    this.f.setVisibility(8);
    this.d.setVisibility(8);
    this.g = ((LinearLayout)findViewById(2131429603));
    this.h = ((ListView)findViewById(2131437272));
  }
  
  public void setTitle(int paramInt)
  {
    this.a.setText(paramInt);
    this.b.setContentDescription(getContext().getString(paramInt));
    this.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomSingleButtonDialog
 * JD-Core Version:    0.7.0.1
 */