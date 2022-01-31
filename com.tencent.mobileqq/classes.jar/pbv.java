import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.gif.GifView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

public class pbv
  implements URLDrawableDownListener
{
  public pbv(GifView paramGifView, long paramLong, AtomicLong paramAtomicLong1, AtomicLong paramAtomicLong2, AtomicLong paramAtomicLong3, AtomicLong paramAtomicLong4, URLDrawable paramURLDrawable) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (GifView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView))
    {
      if (!GifView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView)) {
        break label104;
      }
      GifView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView);
    }
    for (;;)
    {
      QLog.d("gifvideo.GifView", 1, "onLoadFialed! mIsBigImg=" + GifView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView) + " w=" + GifView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView) + " h=" + GifView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView));
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView;
      paramView.a += 1;
      return;
      label104:
      this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get() != 0L)
    {
      l1 -= this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get();
      if (this.b.longValue() != 0L) {
        break label289;
      }
    }
    label289:
    for (int i = 1;; i = 0)
    {
      QLog.d("gifvideo.GifView", 2, "gif status: " + i + " file size: " + this.c + " download time: " + this.b + " load time: " + l2);
      QLog.d("gifvideo.GifView", 2, "gif status: " + i + " file size: " + this.c + " download time2: " + this.d + " load time2: " + l1);
      nrt.a(null, "", "0X800A148", "0X800A148", 0, i, this.c + "", this.d + "", l1 + "", this.b + " " + l2, false);
      GifView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView);
      return;
      l1 = l2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pbv
 * JD-Core Version:    0.7.0.1
 */