import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.System;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;
import com.tencent.qphone.base.util.QLog;

public class sag
  extends ContentObserver
{
  private ContentResolver jdField_a_of_type_AndroidContentContentResolver;
  
  public sag(VideoFeedsListView paramVideoFeedsListView, Handler paramHandler)
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
    boolean bool = true;
    super.onChange(paramBoolean);
    int i = Settings.System.getInt(VideoFeedsListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView).getContentResolver(), "accelerometer_rotation", -1);
    VideoFeedsListView localVideoFeedsListView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView;
    if (i == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      VideoFeedsListView.b(localVideoFeedsListView, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsListView", 2, "RotationObserver.onChange() : rotateState=" + i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sag
 * JD-Core Version:    0.7.0.1
 */