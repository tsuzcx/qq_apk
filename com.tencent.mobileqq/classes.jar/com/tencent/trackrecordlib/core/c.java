package com.tencent.trackrecordlib.core;

import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import com.tencent.trackrecordlib.c.b;
import java.util.LinkedList;
import org.json.JSONObject;

public class c
{
  private static final String a = c.class.getSimpleName();
  private static LinkedList<String> b = new LinkedList();
  private static int c = 0;
  private static long d = 0L;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private long k;
  private int l = -1;
  private int m = -1;
  private float n;
  private float o;
  
  public static c a()
  {
    return c.a.a();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = Math.abs(paramFloat1 - this.n);
    paramFloat2 = Math.abs(paramFloat2 - this.o);
    return (paramFloat1 > 10.0F) || (paramFloat2 > 10.0F);
  }
  
  private boolean a(long paramLong)
  {
    return paramLong - this.k > com.tencent.trackrecordlib.g.c.e;
  }
  
  private boolean a(View paramView)
  {
    return ((paramView instanceof EditText)) && ((((EditText)paramView).getTransformationMethod() instanceof PasswordTransformationMethod));
  }
  
  private void b(b paramb)
  {
    if ((c > 0) && (paramb != null))
    {
      paramb = paramb.e().toString();
      try
      {
        if (d < c)
        {
          b.addLast(paramb + "\r\n");
          d += 1L;
          return;
        }
        b.removeFirst();
        b.addLast(paramb + "\r\n");
        return;
      }
      catch (Throwable paramb)
      {
        Log.e(a, "写入事件队列失败！");
        paramb.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt)
  {
    c = paramInt;
  }
  
  public void a(View paramView, int paramInt)
  {
    d.a(new c.3(this, paramInt, paramView));
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    d.a(new c.1(this, paramInt1, paramInt2, paramLong1, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramLong2, paramView));
  }
  
  public void a(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    d.a(new c.2(this, paramKeyEvent));
  }
  
  public void a(View paramView, int paramInt, String paramString1, String paramString2)
  {
    d.a(new c.9(this, paramInt, paramView, paramString1, paramString2));
  }
  
  public void a(b paramb)
  {
    d.a(new c.8(this, paramb));
  }
  
  String b()
  {
    if (c > 0) {
      return b.toString();
    }
    return "noCachedEvents";
  }
  
  public void b(int paramInt)
  {
    d.a(new c.5(this, paramInt));
  }
  
  public void c()
  {
    d.a(new c.4(this));
  }
  
  public void d()
  {
    d.a(new c.6(this));
  }
  
  public void e()
  {
    d.a(new c.7(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.c
 * JD-Core Version:    0.7.0.1
 */