package com.tencent.mtt.hippy.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mtt.hippy.b.d;
import com.tencent.mtt.hippy.b.d.a;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.net.URI;
import org.json.JSONObject;

public class o
  implements d.a
{
  private d a;
  private j b;
  private o.a c;
  private boolean d;
  private Handler e;
  private Runnable f = new o.1(this);
  
  public o(j paramj)
  {
    this.b = paramj;
    this.d = false;
    this.e = new Handler(Looper.getMainLooper());
  }
  
  private void c()
  {
    this.a = new d(URI.create(this.b.a()), this, null);
    this.a.a();
  }
  
  private void d()
  {
    this.e.removeCallbacks(this.f);
    this.e.postDelayed(this.f, 2000L);
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.b();
    }
    this.c = null;
    this.d = false;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!this.d) {
      return;
    }
    d();
  }
  
  public void a(o.a parama)
  {
    if ((this.a == null) || (!this.a.c())) {
      c();
    }
    this.c = parama;
    this.d = true;
  }
  
  public void a(Exception paramException)
  {
    if (!this.d) {
      return;
    }
    d();
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  public void b()
  {
    this.e.post(new o.2(this));
  }
  
  public void b(String paramString)
  {
    do
    {
      try
      {
        paramString = new JSONObject(paramString).optString("action");
        if (this.c == null) {
          return;
        }
      }
      catch (Exception paramString)
      {
        LogUtils.e("hippy_console", "revceive invalid live reload msg");
        return;
      }
    } while (!paramString.equals("compileSuccess"));
    this.e.post(new o.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.o
 * JD-Core Version:    0.7.0.1
 */