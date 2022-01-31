import android.widget.SeekBar;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager.VideoPlayParam;

class mpq
  implements Runnable
{
  mpq(mpp parammpp, FastWebVideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetSeekBar != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.b != null))
    {
      if (this.jdField_a_of_type_Long != 0L) {
        break label81;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    }
    for (;;)
    {
      if (this.c > 0L) {
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.b, this.c);
      }
      return;
      label81:
      if (this.b != 0L)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)((float)this.b * 100.0F / (float)this.jdField_a_of_type_Long + 0.5D));
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetTextView, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mpq
 * JD-Core Version:    0.7.0.1
 */