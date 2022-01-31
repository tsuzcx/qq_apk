import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.PlayStartVideoRunnable;
import com.tencent.qphone.base.util.QLog;

public class sqf
  implements osi
{
  public sqf(VideoPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable) {}
  
  public void a(osl paramosl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "UUIDToUrlCallback Callback vid=" + paramosl.jdField_b_of_type_JavaLangString + ", url=" + paramosl.jdField_a_of_type_JavaLangString + ", isH265=" + paramosl.jdField_a_of_type_Boolean + ", isHWCodec=" + paramosl.jdField_b_of_type_Boolean + ", fileBitRate=" + paramosl.c);
    }
    if ((VideoPlayManager.PlayStartVideoRunnable.a(this.a) != null) && (paramosl.jdField_b_of_type_JavaLangString.equals(VideoPlayManager.PlayStartVideoRunnable.a(this.a).a.jdField_a_of_type_JavaLangString))) {
      if (TextUtils.isEmpty(paramosl.jdField_a_of_type_JavaLangString)) {
        if (VideoPlayManager.a(this.a.this$0) != null) {
          VideoPlayManager.a(this.a.this$0).a(null, 123, 107, 0, "UUIDToUrlCallback vid2url ERROR ", null);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (paramosl.jdField_a_of_type_Int == 1)
      {
        VideoPlayManager.PlayStartVideoRunnable.a(this.a).a(paramosl.jdField_b_of_type_JavaLangString, paramosl.jdField_a_of_type_JavaLangString, 1, VideoPlayManager.PlayStartVideoRunnable.a(this.a), 0L, VideoPlayManager.PlayStartVideoRunnable.a(this.a).a.d, paramosl.jdField_b_of_type_Boolean, true, false);
        return;
      }
      VideoPlayManager.PlayStartVideoRunnable.a(this.a).a(paramosl.jdField_b_of_type_JavaLangString, paramosl.jdField_a_of_type_JavaLangString, 2, VideoPlayManager.PlayStartVideoRunnable.a(this.a), 0L, VideoPlayManager.PlayStartVideoRunnable.a(this.a).a.d, paramosl.jdField_b_of_type_Boolean, true, false);
      return;
    }
    QLog.d("Viola.VideoPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramosl.jdField_b_of_type_JavaLangString + " url:" + paramosl.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sqf
 * JD-Core Version:    0.7.0.1
 */