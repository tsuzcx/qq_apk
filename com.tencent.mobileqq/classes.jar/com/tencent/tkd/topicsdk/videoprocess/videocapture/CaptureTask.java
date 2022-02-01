package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.lang.ref.SoftReference;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "Landroid/os/AsyncTask;", "", "Landroid/graphics/Bitmap;", "type", "", "path", "", "position", "width", "height", "captureCallback", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnCaptureCallback;", "(ILjava/lang/String;IIILcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnCaptureCallback;)V", "captureProxy", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ICaptureProxy;", "getHeight", "()I", "id", "getId", "()Ljava/lang/String;", "lock", "Ljava/lang/Object;", "onTaskListener", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnTaskListener;", "getPath", "getPosition", "resultBitmap", "getResultBitmap", "()Landroid/graphics/Bitmap;", "resultBitmapRef", "Ljava/lang/ref/SoftReference;", "tryCount", "getType", "getWidth", "attachCaptureProxy", "iCaptureProxy", "doInBackground", "params", "", "([Lkotlin/Unit;)Landroid/graphics/Bitmap;", "notifyResultBitmap", "onCancelled", "onPostExecute", "bitmap", "onPreExecute", "release", "setOnTaskListener", "toString", "CaptureType", "Companion", "OnCaptureCallback", "OnTaskListener", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CaptureTask
  extends AsyncTask<Unit, Unit, Bitmap>
{
  public static final CaptureTask.Companion a = new CaptureTask.Companion(null);
  @NotNull
  private final String b;
  private SoftReference<Bitmap> c;
  private ICaptureProxy d;
  private CaptureTask.OnTaskListener e;
  private int f;
  private final Object g;
  private final int h;
  @NotNull
  private final String i;
  private final int j;
  private final int k;
  private final int l;
  private CaptureTask.OnCaptureCallback m;
  
  public CaptureTask(int paramInt1, @NotNull String paramString, int paramInt2, int paramInt3, int paramInt4, @Nullable CaptureTask.OnCaptureCallback paramOnCaptureCallback)
  {
    this.h = paramInt1;
    this.i = paramString;
    this.j = paramInt2;
    this.k = paramInt3;
    this.l = paramInt4;
    this.m = paramOnCaptureCallback;
    paramString = UUID.randomUUID().toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "UUID.randomUUID().toString()");
    this.b = paramString;
    this.g = new Object();
  }
  
  private final void f()
  {
    this.m = ((CaptureTask.OnCaptureCallback)null);
    this.e = ((CaptureTask.OnTaskListener)null);
  }
  
  private final void g()
  {
    synchronized (this.g)
    {
      this.g.notifyAll();
      Unit localUnit = Unit.INSTANCE;
      return;
    }
  }
  
  @Nullable
  protected Bitmap a(@NotNull Unit... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "params");
    paramVarArgs = b();
    if (paramVarArgs != null)
    {
      if (paramVarArgs != null) {
        return paramVarArgs;
      }
      paramVarArgs = (Void)null;
    }
    this.f += 1;
    paramVarArgs = new Bitmap[1];
    paramVarArgs[0] = ((Bitmap)null);
    ??? = this.d;
    if (??? != null) {
      ((ICaptureProxy)???).a(this, (CaptureTask.OnCaptureCallback)new CaptureTask.doInBackground.2(this, paramVarArgs));
    }
    try
    {
      synchronized (this.g)
      {
        this.g.wait();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      TLog.d("CaptureTask", localInterruptedException.toString());
      Unit localUnit = Unit.INSTANCE;
      return paramVarArgs[0];
    }
  }
  
  @NotNull
  public final String a()
  {
    return this.b;
  }
  
  protected void a(@Nullable Bitmap paramBitmap)
  {
    super.onPostExecute(paramBitmap);
    this.c = new SoftReference(paramBitmap);
    Object localObject = this.e;
    if (localObject != null) {
      ((CaptureTask.OnTaskListener)localObject).b(this);
    }
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.d("CaptureTask", "onCaptureSuccess");
      localObject = this.m;
      if (localObject != null) {
        ((CaptureTask.OnCaptureCallback)localObject).a(paramBitmap, this);
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCaptureFailed. null: ");
      boolean bool;
      if (paramBitmap == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(", isRecycled: ");
      if (paramBitmap != null) {
        paramBitmap = Boolean.valueOf(paramBitmap.isRecycled());
      } else {
        paramBitmap = null;
      }
      ((StringBuilder)localObject).append(paramBitmap);
      Log.d("CaptureTask", ((StringBuilder)localObject).toString());
      paramBitmap = this.m;
      if (paramBitmap != null) {
        paramBitmap.a();
      }
    }
    f();
  }
  
  public final void a(@NotNull CaptureTask.OnTaskListener paramOnTaskListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnTaskListener, "onTaskListener");
    this.e = paramOnTaskListener;
  }
  
  public final void a(@Nullable ICaptureProxy paramICaptureProxy)
  {
    this.d = paramICaptureProxy;
  }
  
  @Nullable
  public final Bitmap b()
  {
    Object localObject1 = this.c;
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject3 = (Bitmap)((SoftReference)localObject1).get();
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((Bitmap)localObject3).isRecycled() == true) {
          return localObject1;
        }
      }
    }
    Object localObject3 = this.c;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = (Bitmap)((SoftReference)localObject3).get();
    }
    return localObject1;
  }
  
  public final int c()
  {
    return this.j;
  }
  
  public final int d()
  {
    return this.k;
  }
  
  public final int e()
  {
    return this.l;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    f();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    CaptureTask.OnTaskListener localOnTaskListener = this.e;
    if (localOnTaskListener != null) {
      localOnTaskListener.a(this);
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CaptureTask{ id= ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", type= ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", path= ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", position= ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", width= ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", height= ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.CaptureTask
 * JD-Core Version:    0.7.0.1
 */