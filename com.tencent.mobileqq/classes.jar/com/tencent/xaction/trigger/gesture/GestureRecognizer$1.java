package com.tencent.xaction.trigger.gesture;

import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GestureRecognizer$1
  implements Runnable
{
  GestureRecognizer$1(GestureRecognizer paramGestureRecognizer, File paramFile) {}
  
  public final void run()
  {
    GestureLibrary localGestureLibrary = GestureLibraries.fromFile(this.a);
    if (localGestureLibrary.load())
    {
      GestureRecognizer.a(this.this$0, localGestureLibrary);
      GestureRecognizer.a(this.this$0).set(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.trigger.gesture.GestureRecognizer.1
 * JD-Core Version:    0.7.0.1
 */