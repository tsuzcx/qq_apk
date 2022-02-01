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
import com.tencent.mobileqq.microapp.R.drawable;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.apkg.j;
import com.tencent.mobileqq.microapp.apkg.k;
import com.tencent.mobileqq.utils.StringUtil;
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
    else
    {
      localImageView.setVisibility(8);
    }
    if (this.m != null) {
      ((TextView)this.a.findViewById(R.id.o)).setText(this.m);
    }
  }
  
  private void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("show mParentView=");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(",toastLayout=");
    ((StringBuilder)localObject).append(this.a);
    QLog.d("ToastView", 4, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null)
    {
      View localView = this.a;
      if (localView != null)
      {
        ((ViewGroup)localObject).addView(localView, new ViewGroup.LayoutParams(-1, -1));
        int i1 = this.n;
        if (i1 > -1) {
          this.c.postDelayed(this.d, i1);
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    this.n = paramInt;
  }
  
  private int c(String paramString)
  {
    if ("success".equals(paramString)) {
      return R.drawable.a;
    }
    if ("warn".equals(paramString)) {
      return R.drawable.b;
    }
    if ("loading".equals(paramString)) {
      return R.drawable.d;
    }
    if ("none".equals(paramString)) {}
    return 0;
  }
  
  public String a(String paramString)
  {
    if (StringUtil.a(paramString)) {
      return "";
    }
    String str2 = c.n(paramString);
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      if (str3.startsWith("/")) {
        paramString = str3.substring(1);
      } else {
        paramString = str3;
      }
      String str1 = paramString;
      if (paramString.endsWith("/")) {
        str1 = paramString.substring(0, paramString.length() - 1);
      }
      if (str2.startsWith("/")) {
        paramString = str2.substring(1);
      } else {
        paramString = str2;
      }
      if (paramString.startsWith(str1)) {
        return str3;
      }
    }
    return "";
  }
  
  public void a()
  {
    this.c.removeCallbacks(this.d);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hide mParentView=");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(",toastLayout=");
    ((StringBuilder)localObject).append(this.a);
    QLog.d("ToastView", 4, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null)
    {
      View localView = this.a;
      if (localView != null) {
        ((ViewGroup)localObject).removeView(localView);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("show iconType=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",localIconPath=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",msg=");
    localStringBuilder.append(paramCharSequence);
    localStringBuilder.append(",duration=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",mask=");
    localStringBuilder.append(paramBoolean);
    QLog.d("ToastView", 4, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString2)) {
      a(new BitmapDrawable(paramString2));
    } else {
      a(c(paramString1));
    }
    a(paramCharSequence);
    b(paramInt);
    a();
    a(paramBoolean);
    b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.g
 * JD-Core Version:    0.7.0.1
 */