import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.gif.GifView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

public class pbu
  implements URLDrawable.DownloadListener
{
  public pbu(GifView paramGifView, AtomicLong paramAtomicLong1, AtomicLong paramAtomicLong2, long paramLong, AtomicLong paramAtomicLong3, AtomicLong paramAtomicLong4, URLDrawable paramURLDrawable) {}
  
  public void onFileDownloadFailed(int paramInt)
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
      GifView localGifView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseGifGifView;
      localGifView.a += 1;
      return;
      label104:
      this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
    }
  }
  
  public void onFileDownloadStarted()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(System.currentTimeMillis());
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    this.b.set(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    this.c.set(System.currentTimeMillis() - this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get());
    this.d.set(paramLong);
    QLog.d("gifvideo.GifView", 1, "gif download success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pbu
 * JD-Core Version:    0.7.0.1
 */