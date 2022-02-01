import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.gif.GifView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

public class psq
  implements URLDrawableDownListener
{
  public psq(GifView paramGifView, long paramLong, AtomicLong paramAtomicLong1, AtomicLong paramAtomicLong2, AtomicLong paramAtomicLong3, AtomicLong paramAtomicLong4, StringBuilder paramStringBuilder, URLDrawable paramURLDrawable) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (GifView.access$000(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView))
    {
      if (!GifView.access$100(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView)) {
        break label116;
      }
      GifView.access$200(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView);
    }
    for (;;)
    {
      QLog.d("gifvideo.GifView", 1, "onLoadFialed! mIsBigImg=" + GifView.access$100(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView) + " w=" + GifView.access$300(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView) + " h=" + GifView.access$400(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView) + " progress: " + this.jdField_a_of_type_JavaLangStringBuilder);
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView;
      paramView.mTryCounts += 1;
      return;
      label116:
      this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(System.currentTimeMillis() + " " + paramInt + " ");
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get() != 0L)
    {
      l1 -= this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get();
      if (this.b.longValue() != 0L) {
        break label362;
      }
    }
    label362:
    for (int i = 1;; i = 0)
    {
      QLog.d("gifvideo.GifView", 2, "gif status: " + i + " file size: " + this.c + " download time: " + this.b + " load time: " + l2);
      QLog.d("gifvideo.GifView", 2, "gif status: " + i + " file size: " + this.c + " download time2: " + this.d + " load time2: " + l1);
      oat.a(null, "", "0X800A148", "0X800A148", 0, i, this.c + "", this.d + "", l1 + "", this.b + " " + l2, false);
      GifView.access$500(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView);
      QLog.d("gifvideo.GifView", 1, "onLoadSuccess! mIsBigImg=" + GifView.access$100(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView) + " w=" + GifView.access$300(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView) + " h=" + GifView.access$400(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView) + " progress: " + this.jdField_a_of_type_JavaLangStringBuilder);
      return;
      l1 = l2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psq
 * JD-Core Version:    0.7.0.1
 */