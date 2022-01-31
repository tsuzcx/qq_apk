import android.os.Handler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.POIPostersRequestCallback;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.Collections;
import java.util.List;

public class oec
  implements DoodleEmojiManager.POIPostersRequestCallback
{
  public oec(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void a(int paramInt, List paramList)
  {
    SLog.b("Q.qqstory.publish.edit.StoryDoodle", "onPOIPostersRequestResult callback");
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    List localList = paramList;
    if (paramList == null) {
      localList = Collections.EMPTY_LIST;
    }
    Dispatchers.get().dispatch(new DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent(paramInt, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oec
 * JD-Core Version:    0.7.0.1
 */