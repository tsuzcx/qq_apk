import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.VidToSimpleInfoHandler.GetSimpleInfoListEvent;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerListAdapter;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class nxq
  extends QQUIEventReceiver
{
  public nxq(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull VidToSimpleInfoHandler.GetSimpleInfoListEvent paramGetSimpleInfoListEvent)
  {
    SLog.b(this.TAG, "GetSimpleInfoListEventReceiver. event=%s", paramGetSimpleInfoListEvent.toString());
    if ((paramGetSimpleInfoListEvent.errorInfo.isSuccess()) && (paramGetSimpleInfoListEvent.jdField_a_of_type_JavaUtilList != null) && (!paramGetSimpleInfoListEvent.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = paramGetSimpleInfoListEvent.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = (VideoCollectionItem.FakeVideoUIItem)localIterator.next();
        if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.contains(localFakeVideoUIItem.jdField_a_of_type_JavaLangString)) {
          localFakeVideoUIItem.jdField_a_of_type_Boolean = true;
        }
      }
      paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter.a(paramGetSimpleInfoListEvent.jdField_a_of_type_JavaLangString, paramGetSimpleInfoListEvent.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return VidToSimpleInfoHandler.GetSimpleInfoListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxq
 * JD-Core Version:    0.7.0.1
 */