import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.VideoCompositeRec.1;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class svw
  extends QQUIEventReceiver<svl, swo>
{
  public svw(@NonNull svl paramsvl)
  {
    super(paramsvl);
  }
  
  public void a(@NonNull svl paramsvl, @NonNull swo paramswo)
  {
    if (paramswo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ved.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "get event update  vid:%s video path:%s", paramswo.jdField_a_of_type_JavaLangString, paramswo.b);
      Bosses.get().postLightWeightJob(new StoryVideoUploadManager.VideoCompositeRec.1(this, paramsvl, paramswo), 0);
    }
  }
  
  public Class acceptEventClass()
  {
    return swo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svw
 * JD-Core Version:    0.7.0.1
 */