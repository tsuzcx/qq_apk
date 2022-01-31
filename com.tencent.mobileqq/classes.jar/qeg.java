import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsOptView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

public class qeg
  implements URLDrawable.URLDrawableListener
{
  public qeg(VideoFeedsOptView paramVideoFeedsOptView, URLDrawable paramURLDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof ApngDrawable))
    {
      VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView, (ApngDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
      if (VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView)) {
        break label135;
      }
      VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView).pause();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.getLayoutParams().height = ((int)(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView).getIntrinsicHeight() / 3 * this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.getResources().getDisplayMetrics().density));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.getLayoutParams().width = ((int)(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView).getIntrinsicWidth() / 3 * this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.getResources().getDisplayMetrics().density));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.requestLayout();
      return;
      label135:
      VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView);
      VideoFeedsOptView.a(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView, "2"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qeg
 * JD-Core Version:    0.7.0.1
 */