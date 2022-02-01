package cooperation.qzone.zipanimate;

import android.graphics.drawable.BitmapDrawable;
import java.util.concurrent.CopyOnWriteArrayList;

class ZipDrawableLoader$3
  implements Runnable
{
  ZipDrawableLoader$3(ZipDrawableLoader paramZipDrawableLoader, int paramInt, ZipFrameLoadedListener paramZipFrameLoadedListener) {}
  
  public void run()
  {
    int j = this.val$frameIndex;
    int i = j;
    if (j < ZipDrawableLoader.access$500(this.this$0)) {
      i = j + ZipDrawableLoader.access$600(this.this$0).size();
    }
    if (i - ZipDrawableLoader.access$500(this.this$0) > ZipDrawableLoader.access$700(this.this$0)) {
      return;
    }
    if (this.val$frameIndex >= ZipDrawableLoader.access$600(this.this$0).size()) {
      return;
    }
    AnimationFrame localAnimationFrame = null;
    synchronized (this.this$0)
    {
      if (this.val$frameIndex < ZipDrawableLoader.access$600(this.this$0).size()) {
        localAnimationFrame = (AnimationFrame)ZipDrawableLoader.access$600(this.this$0).get(this.val$frameIndex);
      }
      if (localAnimationFrame != null)
      {
        if (localAnimationFrame.mBitmapDrawable == null)
        {
          ??? = ZipDrawableLoader.access$800(this.this$0, localAnimationFrame.path);
          if (??? != null)
          {
            j = ((BitmapDrawable)???).getIntrinsicWidth();
            i = ((BitmapDrawable)???).getIntrinsicHeight();
            j = (int)(j * ZipDrawableLoader.access$900(this.this$0));
            i = (int)(i * ZipDrawableLoader.access$900(this.this$0));
            if (ZipDrawableLoader.access$1000(this.this$0) != null) {
              ((BitmapDrawable)???).setBounds(ZipDrawableLoader.access$1000(this.this$0));
            } else {
              ((BitmapDrawable)???).setBounds(0, 0, j, i);
            }
            localAnimationFrame.mBitmapDrawable = ((BitmapDrawable)???);
          }
        }
        if (!this.this$0.mFirstFrameLoaded)
        {
          ??? = this.this$0;
          ((ZipDrawableLoader)???).mFirstFrameLoaded = true;
          if (ZipDrawableLoader.access$1100((ZipDrawableLoader)???) != null) {
            ZipDrawableLoader.access$1100(this.this$0).onZipFirstFrameLoaded(localAnimationFrame.mBitmapDrawable);
          }
        }
        ??? = this.val$ls;
        if (??? != null) {
          ((ZipFrameLoadedListener)???).onLoaded(this.val$frameIndex, localAnimationFrame.mBitmapDrawable);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipDrawableLoader.3
 * JD-Core Version:    0.7.0.1
 */