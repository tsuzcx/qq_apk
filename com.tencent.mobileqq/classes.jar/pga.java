import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.InvalidationHandler;
import com.tencent.component.media.gif.NewGifDecoder;
import com.tencent.component.media.gif.NewGifDecoder.GifFrame;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.gif.PrepareAndRenderTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class pga
  implements Runnable
{
  public pga(PrepareAndRenderTask paramPrepareAndRenderTask) {}
  
  public void run()
  {
    if (!PrepareAndRenderTask.a(this.a).tryAcquire()) {
      ImageManagerEnv.getLogger().w("PrepareAndRenderTask", new Object[] { "unRender false:no data to render,just return" });
    }
    for (;;)
    {
      return;
      this.a.b.mIsRenderingTriggeredOnDraw = true;
      NewGifDecoder.GifFrame localGifFrame = this.a.b.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.doRender(this.a.b.mBuffer);
      this.a.b.mBuffer = localGifFrame.image;
      PrepareAndRenderTask.a(this.a, localGifFrame.delay);
      this.a.mCurrentIndex = ((this.a.mCurrentIndex + 1) % this.a.b.getNumberOfFrames());
      PrepareAndRenderTask.b(this.a).release();
      if (PrepareAndRenderTask.a(this.a) >= 0L)
      {
        this.a.b.jdField_a_of_type_Long = 0L;
        if ((!this.a.b.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) && (this.a.b.getCurrentFrameIndex() == this.a.b.getNumberOfFrames() - 1)) {
          this.a.b.scheduleSelf(this.a.mNotifyListenersTask, this.a.b.jdField_a_of_type_Long);
        }
      }
      while ((this.a.b.isVisible()) && (!this.a.b.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.hasMessages(0)) && (this.a.b.getCallback() != null))
      {
        this.a.b.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
        return;
        this.a.b.jdField_a_of_type_Long = -9223372036854775808L;
        this.a.b.jdField_a_of_type_Boolean = false;
        ImageManagerEnv.getLogger().w("PrepareAndRenderTask", new Object[] { "decode error: invalidationDelay=" + PrepareAndRenderTask.a(this.a) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pga
 * JD-Core Version:    0.7.0.1
 */