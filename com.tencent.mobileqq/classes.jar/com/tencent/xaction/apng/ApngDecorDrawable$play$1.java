package com.tencent.xaction.apng;

import com.tencent.image.ApngImage;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ApngDecorDrawable$play$1
  implements Runnable
{
  ApngDecorDrawable$play$1(ApngDecorDrawable paramApngDecorDrawable) {}
  
  public final void run()
  {
    ApngImage.playByTag(ApngDecorDrawable.access$getTmpId$p(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.apng.ApngDecorDrawable.play.1
 * JD-Core Version:    0.7.0.1
 */