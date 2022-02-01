package com.tencent.mobileqq.triton.render.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.render.RenderContext.a;
import com.tencent.mobileqq.triton.sdk.FPSCallback;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class b
  implements RenderContext.a
{
  private TTEngine a;
  private Handler b = new Handler(Looper.getMainLooper());
  private TextView c;
  private CopyOnWriteArrayList<FPSCallback> d = new CopyOnWriteArrayList();
  private int e = 0;
  private long f = 0L;
  
  public b(TTEngine paramTTEngine, ViewGroup paramViewGroup, Context paramContext)
  {
    this.a = paramTTEngine;
    if (this.a.l().isDebug())
    {
      this.c = new TextView(paramContext);
      this.c.setText("60.0");
      this.c.setTextColor(-16711936);
      paramTTEngine = new RelativeLayout.LayoutParams(-2, -2);
      paramTTEngine.addRule(11);
      paramTTEngine.setMargins(0, 50, 50, 0);
      paramViewGroup.addView(this.c, paramTTEngine);
    }
  }
  
  private void a(float paramFloat)
  {
    if (this.a.l().isDebug())
    {
      localObject = this.b;
      if (localObject != null) {
        ((Handler)localObject).post(new b.a(this, paramFloat));
      }
    }
    Object localObject = this.d;
    if ((localObject != null) && (!((CopyOnWriteArrayList)localObject).isEmpty()))
    {
      localObject = this.d.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((FPSCallback)((Iterator)localObject).next()).onFPSChange(paramFloat);
      }
    }
  }
  
  private void b()
  {
    this.e += 1;
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.f;
    if (l2 >= 1000L)
    {
      float f1 = this.e;
      a(1000.0F / (float)l2 * f1);
      this.e = 0;
      this.f = l1;
    }
  }
  
  public void a()
  {
    b();
  }
  
  public void a(FPSCallback paramFPSCallback)
  {
    this.d.add(paramFPSCallback);
  }
  
  public void b(FPSCallback paramFPSCallback)
  {
    this.d.remove(paramFPSCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.c.b
 * JD-Core Version:    0.7.0.1
 */