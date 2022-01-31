import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.VideoCompositeRec.1;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class sjd
  extends QQUIEventReceiver<sis, sjv>
{
  public sjd(@NonNull sis paramsis)
  {
    super(paramsis);
  }
  
  public void a(@NonNull sis paramsis, @NonNull sjv paramsjv)
  {
    if (paramsjv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      urk.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "get event update  vid:%s video path:%s", paramsjv.jdField_a_of_type_JavaLangString, paramsjv.b);
      Bosses.get().postLightWeightJob(new StoryVideoUploadManager.VideoCompositeRec.1(this, paramsis, paramsjv), 0);
    }
  }
  
  public Class acceptEventClass()
  {
    return sjv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sjd
 * JD-Core Version:    0.7.0.1
 */