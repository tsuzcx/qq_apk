import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.VideoCompositeRec.1;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class svz
  extends QQUIEventReceiver<svo, swr>
{
  public svz(@NonNull svo paramsvo)
  {
    super(paramsvo);
  }
  
  public void a(@NonNull svo paramsvo, @NonNull swr paramswr)
  {
    if (paramswr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      veg.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "get event update  vid:%s video path:%s", paramswr.jdField_a_of_type_JavaLangString, paramswr.b);
      Bosses.get().postLightWeightJob(new StoryVideoUploadManager.VideoCompositeRec.1(this, paramsvo, paramswr), 0);
    }
  }
  
  public Class acceptEventClass()
  {
    return swr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svz
 * JD-Core Version:    0.7.0.1
 */