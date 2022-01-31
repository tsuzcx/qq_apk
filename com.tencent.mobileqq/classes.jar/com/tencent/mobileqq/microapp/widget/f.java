package com.tencent.mobileqq.microapp.widget;

import android.app.Dialog;
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

public final class f
  extends Dialog
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
  
  public f(@NonNull Context paramContext)
  {
    super(paramContext, R.style.b);
    a(paramContext);
  }
  
  private void a(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.a, null);
    setContentView(paramContext);
    this.a = ((TextView)paramContext.findViewById(R.id.q));
    this.b = ((TextView)paramContext.findViewById(R.id.p));
    this.c = ((TextView)paramContext.findViewById(R.id.n));
    this.d = ((TextView)paramContext.findViewById(R.id.o));
    this.e = paramContext.findViewById(R.id.m);
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
    if (this.a != null)
    {
      this.a.setText(paramString1);
      this.a.setContentDescription(paramString1);
    }
    if (this.b != null)
    {
      this.b.setText(paramString2);
      this.b.setContentDescription(paramString2);
    }
    if ((this.c == null) || (!TextUtils.isEmpty(paramString4))) {}
    try
    {
      this.c.setTextColor(Color.parseColor(paramString4));
      label83:
      this.c.setText(paramString3);
      this.c.setContentDescription(paramString3);
      if (paramOnClickListener != null) {
        this.c.setOnClickListener(paramOnClickListener);
      }
      for (;;)
      {
        if ((!paramBoolean) || ((this.d == null) || (!TextUtils.isEmpty(paramString6)))) {}
        try
        {
          this.d.setTextColor(Color.parseColor(paramString6));
          label145:
          this.d.setText(paramString5);
          this.d.setContentDescription(paramString5);
          if (paramOnClickListener != null) {
            this.d.setOnClickListener(paramOnClickListener);
          }
          for (;;)
          {
            show();
            return;
            this.c.setOnClickListener(this);
            break;
            this.d.setOnClickListener(this);
            continue;
            if (this.d != null) {
              this.d.setVisibility(8);
            }
            if (this.e != null) {
              this.e.setVisibility(8);
            }
          }
        }
        catch (IllegalArgumentException paramString1)
        {
          break label145;
        }
      }
    }
    catch (IllegalArgumentException paramString1)
    {
      break label83;
    }
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
    if (paramView.getId() == R.id.n)
    {
      b(true);
      dismiss();
    }
    while (paramView.getId() != R.id.o) {
      return;
    }
    a(true);
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.f
 * JD-Core Version:    0.7.0.1
 */