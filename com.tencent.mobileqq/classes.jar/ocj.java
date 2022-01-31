import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.CommonPicUploadFragment;
import com.tencent.biz.qqstory.takevideo.dancemachine.PKVideoSharer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;

public class ocj
  implements Runnable
{
  public ocj(CommonPicUploadFragment paramCommonPicUploadFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    CommonPicUploadFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCommonPicUploadFragment).sendEmptyMessage(1001);
    if (CommonPicUploadFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCommonPicUploadFragment) == 2)
    {
      String str = RecentDanceConfigMgr.a();
      str = CapturePtvTemplateManager.jdField_a_of_type_JavaLangString + str + File.separator;
      str = str + "qq_richmedia_capture_dance_share_bg.png";
      CommonPicUploadFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCommonPicUploadFragment, PKVideoSharer.a(str, 2130843176, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCommonPicUploadFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCommonPicUploadFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 200), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCommonPicUploadFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname(), this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCommonPicUploadFragment.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
    }
    if (!TextUtils.isEmpty(CommonPicUploadFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCommonPicUploadFragment)))
    {
      CommonPicUploadFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCommonPicUploadFragment, SystemClock.elapsedRealtime());
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCommonPicUploadFragment.b(CommonPicUploadFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCommonPicUploadFragment));
      CommonPicUploadFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCommonPicUploadFragment).sendEmptyMessageDelayed(1002, 10000L);
      return;
    }
    CommonPicUploadFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCommonPicUploadFragment).sendEmptyMessage(1003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocj
 * JD-Core Version:    0.7.0.1
 */