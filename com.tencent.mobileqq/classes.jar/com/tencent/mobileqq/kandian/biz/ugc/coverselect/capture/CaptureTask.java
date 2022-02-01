package com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import java.lang.ref.SoftReference;

public class CaptureTask
  extends AsyncTask<Void, Void, Bitmap>
{
  int a = -2147483648;
  public int b;
  public String c;
  public int d;
  public int e;
  public int f;
  private SoftReference<Bitmap> g;
  private ICaptureProxy h;
  private CaptureTask.OnCaptureCallback i;
  private CaptureTask.OnTaskListener j;
  private int k = 0;
  private Object l = new Object();
  
  public CaptureTask(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, CaptureTask.OnCaptureCallback paramOnCaptureCallback)
  {
    this.b = paramInt1;
    this.c = paramString;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
    this.i = paramOnCaptureCallback;
  }
  
  private void b()
  {
    this.i = null;
    this.j = null;
  }
  
  private void c()
  {
    synchronized (this.l)
    {
      this.l.notifyAll();
      return;
    }
  }
  
  public Bitmap a()
  {
    Object localObject = this.g;
    if ((localObject != null) && (((SoftReference)localObject).get() != null))
    {
      localObject = (Bitmap)this.g.get();
      if (!((Bitmap)localObject).isRecycled()) {
        return localObject;
      }
    }
    this.g = null;
    return null;
  }
  
  protected Bitmap a(Void... arg1)
  {
    ??? = a();
    if (??? != null) {
      return ???;
    }
    this.k += 1;
    Bitmap[] arrayOfBitmap = new Bitmap[1];
    arrayOfBitmap[0] = null;
    this.h.a(this, new CaptureTask.1(this, arrayOfBitmap));
    try
    {
      synchronized (this.l)
      {
        this.l.wait();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      return localObject[0];
    }
  }
  
  protected void a(Bitmap paramBitmap)
  {
    super.onPostExecute(paramBitmap);
    this.g = new SoftReference(paramBitmap);
    CaptureTask.OnTaskListener localOnTaskListener = this.j;
    if (localOnTaskListener != null) {
      localOnTaskListener.b(this);
    }
    if (this.i != null) {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        this.i.a(paramBitmap, this);
      } else {
        this.i.a();
      }
    }
    b();
  }
  
  public void a(CaptureTask.OnTaskListener paramOnTaskListener)
  {
    this.j = paramOnTaskListener;
  }
  
  public void a(ICaptureProxy paramICaptureProxy)
  {
    this.h = paramICaptureProxy;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    b();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    CaptureTask.OnTaskListener localOnTaskListener = this.j;
    if (localOnTaskListener != null) {
      localOnTaskListener.a(this);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CaptureTask{id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", path='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", position=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.CaptureTask
 * JD-Core Version:    0.7.0.1
 */