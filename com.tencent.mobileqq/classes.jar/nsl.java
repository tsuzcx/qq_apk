import com.tencent.biz.qqstory.model.QQStoryActivityManager;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class nsl
  implements Runnable
{
  public nsl(StoryPlayVideoActivity paramStoryPlayVideoActivity, QQStoryActivityManager paramQQStoryActivityManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "player activity stack full, size=10, start clear!");
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryModelQQStoryActivityManager.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (QQStoryBaseActivity)((WeakReference)this.jdField_a_of_type_ComTencentBizQqstoryModelQQStoryActivityManager.a.get(localObject)).get();
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity != localObject) && (!((QQStoryBaseActivity)localObject).isFinishing())) {
        ((QQStoryBaseActivity)localObject).finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsl
 * JD-Core Version:    0.7.0.1
 */