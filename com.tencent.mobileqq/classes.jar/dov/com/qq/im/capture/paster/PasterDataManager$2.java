package dov.com.qq.im.capture.paster;

import android.os.Handler;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.POIPosterItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.POIPostersRequestCallback;
import java.util.Collections;
import java.util.List;

class PasterDataManager$2
  implements DoodleEmojiManager.POIPostersRequestCallback
{
  PasterDataManager$2(PasterDataManager paramPasterDataManager) {}
  
  public void a(int paramInt, List<POIPosterItem> paramList)
  {
    SLog.b("PasterDataManager", "onPOIPostersRequestResult callback");
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    Object localObject = paramList;
    if (paramList == null) {
      localObject = Collections.EMPTY_LIST;
    }
    StoryDispatcher.a().dispatch(new DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent(paramInt, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.PasterDataManager.2
 * JD-Core Version:    0.7.0.1
 */