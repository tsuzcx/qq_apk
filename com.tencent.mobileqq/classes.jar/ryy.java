import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.PlayStartVideoRunnable;
import com.tencent.qphone.base.util.QLog;

public class ryy
  implements onx
{
  public ryy(VideoPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable) {}
  
  public void a(ooa paramooa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "UUIDToUrlCallback Callback vid=" + paramooa.jdField_b_of_type_JavaLangString + ", url=" + paramooa.jdField_a_of_type_JavaLangString + ", isH265=" + paramooa.jdField_a_of_type_Boolean + ", isHWCodec=" + paramooa.jdField_b_of_type_Boolean + ", fileBitRate=" + paramooa.c);
    }
    if ((VideoPlayManager.PlayStartVideoRunnable.a(this.a) != null) && (paramooa.jdField_b_of_type_JavaLangString.equals(VideoPlayManager.PlayStartVideoRunnable.a(this.a).a.jdField_a_of_type_JavaLangString))) {
      if (TextUtils.isEmpty(paramooa.jdField_a_of_type_JavaLangString)) {
        if (VideoPlayManager.a(this.a.this$0) != null) {
          VideoPlayManager.a(this.a.this$0).a(null, 123, 107, 0, "UUIDToUrlCallback vid2url ERROR ", null);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (paramooa.jdField_a_of_type_Int == 1)
      {
        VideoPlayManager.PlayStartVideoRunnable.a(this.a).a(paramooa.jdField_b_of_type_JavaLangString, paramooa.jdField_a_of_type_JavaLangString, 1, VideoPlayManager.PlayStartVideoRunnable.a(this.a), 0L, VideoPlayManager.PlayStartVideoRunnable.a(this.a).a.d, paramooa.jdField_b_of_type_Boolean, true, false);
        return;
      }
      VideoPlayManager.PlayStartVideoRunnable.a(this.a).a(paramooa.jdField_b_of_type_JavaLangString, paramooa.jdField_a_of_type_JavaLangString, 2, VideoPlayManager.PlayStartVideoRunnable.a(this.a), 0L, VideoPlayManager.PlayStartVideoRunnable.a(this.a).a.d, paramooa.jdField_b_of_type_Boolean, true, false);
      return;
    }
    QLog.d("Viola.VideoPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramooa.jdField_b_of_type_JavaLangString + " url:" + paramooa.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ryy
 * JD-Core Version:    0.7.0.1
 */