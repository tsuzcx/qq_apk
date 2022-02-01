package com.tencent.mobileqq.microapp.widget;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import bgsp;
import com.tencent.mobileqq.microapp.R.drawable;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.apkg.j;
import com.tencent.mobileqq.microapp.apkg.k;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class g
{
  View a;
  ViewGroup b;
  Handler c;
  Runnable d;
  public boolean e;
  public String f;
  public j g;
  public k h;
  public List i;
  private Resources j;
  private LayoutInflater k;
  private Drawable l;
  private CharSequence m;
  private int n;
  private Map o;
  
  private void a(int paramInt)
  {
    if (paramInt != 0) {
      a(this.j.getDrawable(paramInt));
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    this.l = paramDrawable;
  }
  
  private void a(CharSequence paramCharSequence)
  {
    this.m = paramCharSequence;
  }
  
  private void a(boolean paramBoolean)
  {
    this.a = this.k.inflate(R.layout.c, null);
    this.a.setClickable(paramBoolean);
    ImageView localImageView = (ImageView)this.a.findViewById(R.id.n);
    if (this.l != null)
    {
      localImageView.setVisibility(0);
      localImageView.setImageDrawable(this.l);
    }
    for (;;)
    {
      if (this.m != null) {
        ((TextView)this.a.findViewById(R.id.o)).setText(this.m);
      }
      return;
      localImageView.setVisibility(8);
    }
  }
  
  private void b()
  {
    QLog.d("ToastView", 4, "show mParentView=" + this.b + ",toastLayout=" + this.a);
    if ((this.b != null) && (this.a != null))
    {
      this.b.addView(this.a, new ViewGroup.LayoutParams(-1, -1));
      if (this.n > -1) {
        this.c.postDelayed(this.d, this.n);
      }
    }
  }
  
  private void b(int paramInt)
  {
    this.n = paramInt;
  }
  
  private int c(String paramString)
  {
    int i1 = 0;
    if ("success".equals(paramString)) {
      i1 = R.drawable.a;
    }
    do
    {
      return i1;
      if ("warn".equals(paramString)) {
        return R.drawable.b;
      }
      if ("loading".equals(paramString)) {
        return R.drawable.d;
      }
    } while (!"none".equals(paramString));
    return 0;
  }
  
  public String a(String paramString)
  {
    if (bgsp.a(paramString)) {
      return "";
    }
    String str2 = c.n(paramString);
    Iterator localIterator = this.i.iterator();
    label120:
    label123:
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      String str1;
      if (str3.startsWith("/"))
      {
        paramString = str3.substring(1);
        str1 = paramString;
        if (paramString.endsWith("/")) {
          str1 = paramString.substring(0, paramString.length() - 1);
        }
        if (!str2.startsWith("/")) {
          break label120;
        }
      }
      for (paramString = str2.substring(1);; paramString = str2)
      {
        if (!paramString.startsWith(str1)) {
          break label123;
        }
        return str3;
        paramString = str3;
        break;
      }
    }
    return "";
  }
  
  public void a()
  {
    this.c.removeCallbacks(this.d);
    QLog.d("ToastView", 4, "hide mParentView=" + this.b + ",toastLayout=" + this.a);
    if ((this.b != null) && (this.a != null)) {
      this.b.removeView(this.a);
    }
  }
  
  public void a(String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    QLog.d("ToastView", 4, "show iconType=" + paramString1 + ",localIconPath=" + paramString2 + ",msg=" + paramCharSequence + ",duration=" + paramInt + ",mask=" + paramBoolean);
    if (!TextUtils.isEmpty(paramString2)) {
      a(new BitmapDrawable(paramString2));
    }
    for (;;)
    {
      a(paramCharSequence);
      b(paramInt);
      a();
      a(paramBoolean);
      b();
      return;
      a(c(paramString1));
    }
  }
  
  public j b(String paramString)
  {
    paramString = c.n(paramString);
    j localj = (j)this.o.get(paramString);
    paramString = localj;
    if (localj == null) {
      paramString = this.g;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.g
 * JD-Core Version:    0.7.0.1
 */