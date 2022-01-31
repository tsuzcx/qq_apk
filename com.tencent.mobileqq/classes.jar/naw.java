import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.io.File;

public class naw
  extends SimpleJob
{
  public naw(VideoCompositeManager paramVideoCompositeManager, String paramString, long paramLong) {}
  
  protected String a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "start composite vid:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
    paramJobContext = VideoCompositeHelper.a(this.jdField_a_of_type_JavaLangString);
    new File(QQStoryConstant.c).mkdirs();
    paramVarArgs = QQStoryConstant.c + System.currentTimeMillis() + ".mp4";
    new VideoCompositeHelper().a(paramJobContext, paramVarArgs, new nax(this, paramJobContext));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     naw
 * JD-Core Version:    0.7.0.1
 */