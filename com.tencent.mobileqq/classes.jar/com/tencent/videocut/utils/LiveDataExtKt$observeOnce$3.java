package com.tencent.videocut.utils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "run"}, k=3, mv={1, 4, 2})
final class LiveDataExtKt$observeOnce$3
  implements Runnable
{
  public final void run()
  {
    this.a.observeForever((Observer)new LiveDataExtKt.observeOnce.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.LiveDataExtKt.observeOnce.3
 * JD-Core Version:    0.7.0.1
 */