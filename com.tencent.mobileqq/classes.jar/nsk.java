import android.app.Activity;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoHelper;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoHelper.GenerateManifestCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;

public class nsk
  implements QQStoryTakeVideoHelper.GenerateManifestCallback
{
  public nsk(QQStoryTakeVideoHelper paramQQStoryTakeVideoHelper, PublishParam paramPublishParam, String paramString, int paramInt) {}
  
  public void a()
  {
    SLog.c("QQStoryTakeVideoHelper", "generate manifest file success.start publishing.");
    QQStoryTakeVideoHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public void b()
  {
    SLog.e("QQStoryTakeVideoHelper", "generate manifest file error. let's exit.");
    QQStoryTakeVideoHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper).finish();
    QQStoryTakeVideoHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper).overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsk
 * JD-Core Version:    0.7.0.1
 */