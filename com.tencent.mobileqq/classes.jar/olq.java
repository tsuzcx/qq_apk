import android.app.Activity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class olq
  extends olu
{
  olq(olp paramolp, int paramInt, long paramLong1, QQFilterRenderManager paramQQFilterRenderManager, HWVideoRecorder paramHWVideoRecorder1, HWVideoRecorder paramHWVideoRecorder2, long paramLong2)
  {
    super(paramInt, paramLong1, paramQQFilterRenderManager, paramHWVideoRecorder1);
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (SlideShowPhotoListManager.a)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
      return;
    }
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowPhotoListManager", 2, "pic num:" + this.jdField_a_of_type_Olp.a.jdField_a_of_type_JavaUtilList.size() + ", encode cost time:" + (l - this.jdField_a_of_type_Long) / 1000L);
    }
    this.jdField_a_of_type_Olp.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.path = paramString;
    localLocalMediaInfo.mMimeType = "video";
    MediaScanner.a(BaseApplicationImpl.getContext()).a(new olr(this, paramString), localLocalMediaInfo);
    StoryReportor.a("video_edit", "slides_done", 0, 0, new String[0]);
    StoryReportor.a("video_edit_slides", "suc_compose", 0, 0, new String[0]);
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    super.a_(paramInt, paramThrowable);
    this.jdField_a_of_type_Olp.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new olt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     olq
 * JD-Core Version:    0.7.0.1
 */