import android.os.SystemClock;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.InvalidationHandler;
import com.tencent.component.media.gif.NewGifDecoder;
import com.tencent.component.media.gif.NewGifDecoder.GifFrame;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.ImageTaskBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class peh
  extends pej
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  public int mCurrentIndex = 0;
  protected final Runnable mNotifyListenersTask = new pei(this);
  protected boolean mReported = false;
  
  public peh(NewGifDrawable paramNewGifDrawable)
  {
    super(paramNewGifDrawable);
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a(int paramInt, NewGifDrawable paramNewGifDrawable)
  {
    if ((paramNewGifDrawable == null) || (paramNewGifDrawable.getNumberOfFrames() == 0)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingFailCountReport", "performance", "gif_play_fail_count", paramInt);
    ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingFailCountReport", "performance", "gif_play_frame_count", paramNewGifDrawable.getNumberOfFrames());
    localHashMap.put("f_networkstate", String.valueOf(ImageManagerEnv.g().getNetWorkState()));
    localHashMap.put("gif_play_fail_count", String.valueOf(paramInt));
    localHashMap.put("f_frame_count", String.valueOf(paramNewGifDrawable.getNumberOfFrames()));
    if (paramNewGifDrawable.getNumberOfFrames() != 0) {
      localHashMap.put("fail_frame", String.valueOf(paramInt * 1.0D / paramNewGifDrawable.getNumberOfFrames()));
    }
    ImageManagerEnv.g().statisticCollectorReport("gifPlayingFailCountReport", localHashMap);
  }
  
  private void a(boolean paramBoolean, long paramLong, NewGifDrawable paramNewGifDrawable)
  {
    HashMap localHashMap = new HashMap();
    int i;
    if (paramBoolean)
    {
      i = 1;
      localHashMap.put("is_gif_playing", String.valueOf(i));
      localHashMap.put("first_frame_render_cost", String.valueOf(paramLong));
      localHashMap.put("networkstate", String.valueOf(ImageManagerEnv.g().getNetWorkState()));
      if (!paramBoolean) {
        break label141;
      }
      ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "gif_play_first_frame_cost", (int)paramLong);
      ImageManagerEnv.getLogger().d("gifPlayingReport", new Object[] { "gif_play time:" + paramLong });
      localHashMap.put("gif_play_first_frame_cost", String.valueOf(paramLong));
    }
    for (;;)
    {
      ImageManagerEnv.g().statisticCollectorReport("gifPlayingReportNew", localHashMap);
      return;
      i = 0;
      break;
      label141:
      ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "normal_Play_first_frame_cost", (int)paramLong);
      ImageManagerEnv.getLogger().d("gifPlayingReport", new Object[] { "normal_Play time:" + paramLong });
      localHashMap.put("normal_Play_first_frame_cost", String.valueOf(paramLong));
      localHashMap.put("n_frameCount", String.valueOf(paramNewGifDrawable.getNumberOfFrames()));
      localHashMap.put("n_size", String.valueOf(paramNewGifDrawable.getAllocationByteCount()));
    }
  }
  
  public void doWork()
  {
    for (;;)
    {
      Long localLong1;
      try
      {
        if (this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.getCurrentModel() == 4)
        {
          ImageManagerEnv.getLogger().d("NewGifDrawable", new Object[] { "doWork | ====mCurrentIndex:" + this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.getCurrentFrameIndex() + " mGifDrawable.isEndDownload:" + this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.isEndDownload + " mHashcode:" + this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.mHashcode });
          NewGifDecoder.GifFrame localGifFrame1 = this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.nextForGifPlay(this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.mBuffer, this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.isEndDownload);
          long l2;
          if (!this.mReported)
          {
            localLong1 = (Long)ImageTaskBuilder.stampMap.remove(this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.getUrl());
            Long localLong2 = (Long)ImageTaskBuilder.stampMap2.remove(this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.getUrl());
            if (localLong1 != null)
            {
              l1 = localLong1.longValue();
              l2 = System.currentTimeMillis() - l1;
              if (localLong2 == null) {
                break label761;
              }
              l1 = System.currentTimeMillis() - localLong2.longValue();
              ImageManagerEnv.getLogger().d("NewGifDrawable", new Object[] { "1 first_frame_render_cost2: " + l1 });
              ImageManagerEnv.getLogger().d("NewGifDrawable", new Object[] { "1 first_frame_render_cost: " + l2 });
              if (l1 == 0L) {
                continue;
              }
              a(true, l1, this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable);
              this.mReported = true;
            }
          }
          ImageManagerEnv.getLogger().d("NewGifDrawable", new Object[] { "doWork | ====invalidationDelay:" + localGifFrame1.delay });
          if ((localGifFrame1 != null) && (localGifFrame1.delay == -1L))
          {
            if (this.jdField_a_of_type_Boolean) {
              this.jdField_a_of_type_Int += 1;
            }
            return;
            l1 = l2;
            continue;
          }
          if (!this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_Boolean = true;
          }
          if ((!this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.isEndDownload))
          {
            this.jdField_b_of_type_Boolean = true;
            a(this.jdField_a_of_type_Int, this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable);
          }
          this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.mIsRenderingTriggeredOnDraw = true;
          this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.mBuffer = localGifFrame1.image;
          this.jdField_a_of_type_Long = localGifFrame1.delay;
          if (this.jdField_a_of_type_Long < 0L) {
            break label740;
          }
          this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.jdField_a_of_type_Long = (SystemClock.uptimeMillis() + this.jdField_a_of_type_Long);
          if ((!this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) && (this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.getCurrentFrameIndex() == this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.getNumberOfFrames() - 1)) {
            this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.scheduleSelf(this.mNotifyListenersTask, this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.jdField_a_of_type_Long);
          }
          if ((!this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.isVisible()) || (this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.hasMessages(0)) || (this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.getCallback() == null)) {
            continue;
          }
          this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
          continue;
        }
        this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.mIsRenderingTriggeredOnDraw = true;
      }
      finally {}
      NewGifDecoder.GifFrame localGifFrame2 = this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.jdField_a_of_type_ComTencentComponentMediaGifNewGifDecoder.next(this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.mBuffer);
      if (!this.mReported)
      {
        localLong1 = (Long)ImageTaskBuilder.stampMap.remove(this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.getUrl());
        if (localLong1 != null)
        {
          l1 = localLong1.longValue();
          l1 = System.currentTimeMillis() - l1;
          ImageManagerEnv.getLogger().d("NewGifDrawable", new Object[] { "2 first_frame_render_cost: " + l1 });
          a(false, l1, this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable);
          this.mReported = true;
        }
      }
      this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.mBuffer = localGifFrame2.image;
      this.jdField_a_of_type_Long = localGifFrame2.delay;
      this.mCurrentIndex = ((this.mCurrentIndex + 1) % this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.getNumberOfFrames());
      continue;
      label740:
      this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.jdField_a_of_type_Long = -9223372036854775808L;
      this.jdField_b_of_type_ComTencentComponentMediaGifNewGifDrawable.jdField_a_of_type_Boolean = false;
      continue;
      label761:
      long l1 = 0L;
    }
  }
  
  public long getFrameDelay()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void waitFinish() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     peh
 * JD-Core Version:    0.7.0.1
 */