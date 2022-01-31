import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.System;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;
import com.tencent.qphone.base.util.QLog;

public class qqa
  extends ContentObserver
{
  private ContentResolver jdField_a_of_type_AndroidContentContentResolver;
  
  public qqa(VideoFeedsListView paramVideoFeedsListView, Handler paramHandler)
  {
    super(paramHandler);
    this.jdField_a_of_type_AndroidContentContentResolver = VideoFeedsListView.a(paramVideoFeedsListView).getContentResolver();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContentResolver.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    int i = Settings.System.getInt(VideoFeedsListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView).getContentResolver(), "accelerometer_rotation", -1);
    if (i == 1) {
      VideoFeedsListView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView, true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "RotationObserver.onChange() : rotateState=" + i);
      }
      return;
      VideoFeedsListView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qqa
 * JD-Core Version:    0.7.0.1
 */