import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoHelper;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoHelper.GenerateManifestCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.reactive.SimpleObserver;

public class nsl
  extends SimpleObserver
{
  public nsl(QQStoryTakeVideoHelper paramQQStoryTakeVideoHelper, QQStoryTakeVideoHelper.GenerateManifestCallback paramGenerateManifestCallback) {}
  
  public void a(Void paramVoid)
  {
    super.onNext(paramVoid);
    SLog.b("QQStoryTakeVideoHelper", "generate video manifest success.");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a = 2;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper$GenerateManifestCallback.a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    SLog.e("QQStoryTakeVideoHelper", "generate video manifest failed.");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a = -1;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper$GenerateManifestCallback.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsl
 * JD-Core Version:    0.7.0.1
 */