package com.tencent.mobileqq.dinifly.model;

import android.os.AsyncTask;
import com.tencent.mobileqq.dinifly.Cancellable;
import com.tencent.mobileqq.dinifly.LottieComposition;

public abstract class CompositionLoader<Params>
  extends AsyncTask<Params, Void, LottieComposition>
  implements Cancellable
{
  public void cancel()
  {
    cancel(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.CompositionLoader
 * JD-Core Version:    0.7.0.1
 */