package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.mobileqq.microapp.R.style;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public final class d
  extends ReportDialog
  implements View.OnClickListener
{
  TextView a;
  TextView b;
  TextView c;
  TextView d;
  View e;
  Bundle f;
  private boolean g;
  private boolean h;
  
  public d(@NonNull Context paramContext)
  {
    super(paramContext, R.style.a);
    a(paramContext);
  }
  
  private void a(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.a, null);
    setContentView(paramContext);
    this.a = ((TextView)paramContext.findViewById(R.id.h));
    this.b = ((TextView)paramContext.findViewById(R.id.g));
    this.c = ((TextView)paramContext.findViewById(R.id.e));
    this.d = ((TextView)paramContext.findViewById(R.id.f));
    this.e = paramContext.findViewById(R.id.d);
  }
  
  public Bundle a()
  {
    return this.f;
  }
  
  public void a(Bundle paramBundle)
  {
    this.f = paramBundle;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    this.h = false;
    this.g = false;
    TextView localTextView = this.a;
    if (localTextView != null)
    {
      localTextView.setText(paramString1);
      this.a.setContentDescription(paramString1);
    }
    paramString1 = this.b;
    if (paramString1 != null)
    {
      paramString1.setText(paramString2);
      this.b.setContentDescription(paramString2);
    }
    if ((this.c == null) || (!TextUtils.isEmpty(paramString4))) {}
    try
    {
      this.c.setTextColor(Color.parseColor(paramString4));
    }
    catch (IllegalArgumentException paramString1)
    {
      label87:
      break label87;
    }
    this.c.setText(paramString3);
    this.c.setContentDescription(paramString3);
    if (paramOnClickListener != null) {
      this.c.setOnClickListener(paramOnClickListener);
    } else {
      this.c.setOnClickListener(this);
    }
    if ((!paramBoolean) || ((this.d == null) || (!TextUtils.isEmpty(paramString6)))) {}
    try
    {
      this.d.setTextColor(Color.parseColor(paramString6));
    }
    catch (IllegalArgumentException paramString1)
    {
      label163:
      break label163;
    }
    this.d.setText(paramString5);
    this.d.setContentDescription(paramString5);
    if (paramOnClickListener != null)
    {
      this.d.setOnClickListener(paramOnClickListener);
    }
    else
    {
      this.d.setOnClickListener(this);
      break label239;
      paramString1 = this.d;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      paramString1 = this.e;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
    }
    label239:
    show();
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean b()
  {
    return this.h;
  }
  
  public boolean c()
  {
    return this.g;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.e)
    {
      b(true);
      dismiss();
    }
    else if (paramView.getId() == R.id.f)
    {
      a(true);
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.d
 * JD-Core Version:    0.7.0.1
 */