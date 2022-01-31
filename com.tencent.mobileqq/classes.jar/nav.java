import android.annotation.TargetApi;
import android.os.SystemClock;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;

@TargetApi(14)
public class nav
  extends ExecuteBinResponseCallback
{
  private long jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  private VideoCompositeHelper.VideoCompositeCallBack jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$VideoCompositeCallBack;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public nav(String paramString1, String paramString2, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$VideoCompositeCallBack = paramVideoCompositeCallBack;
  }
  
  public void a(String paramString)
  {
    SLog.a(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "combine music success take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long));
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$VideoCompositeCallBack.a(0, "", this.b);
    FileUtils.g(this.jdField_a_of_type_JavaLangString);
  }
  
  public void b(String paramString)
  {
    if (paramString.equals(String.valueOf(941001))) {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$VideoCompositeCallBack.a(941001, paramString, "");
    }
    for (;;)
    {
      SLog.d(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "combine audio fail %s", new Object[] { paramString });
      FileUtils.g(this.jdField_a_of_type_JavaLangString);
      return;
      if (paramString.equals(String.valueOf(941002))) {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$VideoCompositeCallBack.a(941002, paramString, "");
      } else {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$VideoCompositeCallBack.a(941000, paramString, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nav
 * JD-Core Version:    0.7.0.1
 */