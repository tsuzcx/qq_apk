package com.tencent.mobileqq.pluspanel;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class AIOPanelIconItem
  implements Comparable<AIOPanelIconItem>
{
  public int a;
  public int b;
  public String c;
  public String d;
  public String e;
  public int f;
  public int g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public Drawable m;
  public Drawable n;
  public int o;
  public int[] p;
  
  public AIOPanelIconItem() {}
  
  public AIOPanelIconItem(AIOPanelIconItem paramAIOPanelIconItem)
  {
    this.a = paramAIOPanelIconItem.a;
    this.b = paramAIOPanelIconItem.b;
    this.c = paramAIOPanelIconItem.c;
    this.d = paramAIOPanelIconItem.d;
    this.e = paramAIOPanelIconItem.e;
    this.f = paramAIOPanelIconItem.f;
    this.g = paramAIOPanelIconItem.g;
    this.h = paramAIOPanelIconItem.h;
    this.i = paramAIOPanelIconItem.i;
    this.j = paramAIOPanelIconItem.j;
    this.k = paramAIOPanelIconItem.k;
    this.l = paramAIOPanelIconItem.l;
    this.m = paramAIOPanelIconItem.m;
    this.n = paramAIOPanelIconItem.n;
    this.o = paramAIOPanelIconItem.o;
    this.p = paramAIOPanelIconItem.p;
  }
  
  public int a(AIOPanelIconItem paramAIOPanelIconItem)
  {
    if (paramAIOPanelIconItem != null) {
      return this.f - paramAIOPanelIconItem.f;
    }
    return 0;
  }
  
  public Drawable a()
  {
    try
    {
      if ((this.m == null) && (!TextUtils.isEmpty(this.i)) && (!TextUtils.isEmpty(this.j)))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        URLDrawable localURLDrawable = URLDrawable.getDrawable(this.i, (URLDrawable.URLDrawableOptions)localObject);
        localObject = URLDrawable.getDrawable(this.j, (URLDrawable.URLDrawableOptions)localObject);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { -16842908, -16842913, -16842919 }, localURLDrawable);
        localStateListDrawable.addState(new int[] { -16842908, 16842913, -16842919 }, (Drawable)localObject);
        this.m = localStateListDrawable;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AIOPanelIconItem", 1, localThrowable, new Object[0]);
    }
    return this.m;
  }
  
  public Drawable b()
  {
    try
    {
      if ((this.n == null) && (!TextUtils.isEmpty(this.k)) && (!TextUtils.isEmpty(this.l)))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        URLDrawable localURLDrawable = URLDrawable.getDrawable(this.k, (URLDrawable.URLDrawableOptions)localObject);
        localObject = URLDrawable.getDrawable(this.l, (URLDrawable.URLDrawableOptions)localObject);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { -16842908, -16842913, -16842919 }, localURLDrawable);
        localStateListDrawable.addState(new int[] { -16842908, 16842913, -16842919 }, (Drawable)localObject);
        this.n = localStateListDrawable;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AIOPanelIconItem", 1, localThrowable, new Object[0]);
    }
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.AIOPanelIconItem
 * JD-Core Version:    0.7.0.1
 */