package com.tencent.mobileqq.util;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

class ImageWorker$BitmapWorkerTask
  extends AsyncTask<Object, Void, Drawable>
{
  private Object b;
  private boolean c;
  private final WeakReference<View> d;
  
  private View a()
  {
    View localView = (View)this.d.get();
    if (!this.c) {
      return localView;
    }
    if (this == ImageWorker.a(this.a, localView)) {
      return localView;
    }
    return null;
  }
  
  protected Drawable a(Object... paramVarArgs)
  {
    this.b = paramVarArgs[0];
    String str = String.valueOf(this.b);
    ImageCreator localImageCreator = (ImageCreator)paramVarArgs[1];
    this.c = ((Boolean)paramVarArgs[2]).booleanValue();
    if ((ImageWorker.b(this.a) != null) && (!isCancelled()) && (a() != null)) {
      ImageWorker.c(this.a);
    }
    if ((!isCancelled()) && (a() != null) && (!ImageWorker.c(this.a))) {}
    try
    {
      paramVarArgs = localImageCreator.a();
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      label101:
      break label101;
    }
    if (ImageWorker.b(this.a) != null) {
      ImageWorker.b(this.a).a();
    }
    System.gc();
    Thread.yield();
    try
    {
      paramVarArgs = localImageCreator.a();
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      label137:
      break label137;
    }
    QLog.w("ImageWorker", 2, "OutOfMemoryError!!!!!");
    paramVarArgs = null;
    if ((ImageWorker.b(this.a) != null) && (paramVarArgs != null)) {
      ImageWorker.b(this.a).a(str, paramVarArgs);
    }
    return paramVarArgs;
  }
  
  protected void a(Drawable paramDrawable)
  {
    View localView = a();
    ImageWorker.Tag localTag = (ImageWorker.Tag)ImageWorker.d(this.a).remove(localView);
    if ((isCancelled()) || (ImageWorker.c(this.a))) {
      paramDrawable = null;
    }
    if (localView != null) {
      if (paramDrawable == null)
      {
        if ((localTag != null) && (localTag.a != null)) {
          localTag.a.a(localView, null);
        }
      }
      else {
        ImageWorker.a(this.a, this.c, localView, paramDrawable, localTag);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.ImageWorker.BitmapWorkerTask
 * JD-Core Version:    0.7.0.1
 */