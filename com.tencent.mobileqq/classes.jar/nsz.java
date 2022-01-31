import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerListAdapter;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class nsz
  extends QQUIEventReceiver
{
  public nsz(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull DateCollectionListPageLoader.GetCollectionListEvent paramGetCollectionListEvent)
  {
    boolean bool1 = false;
    if (!TextUtils.equals(paramStoryPickerFragment.jdField_a_of_type_JavaLangString, paramGetCollectionListEvent.jdField_a_of_type_JavaLangString)) {
      return;
    }
    boolean bool2 = paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
    Object localObject = new ArrayList(paramGetCollectionListEvent.jdField_a_of_type_JavaUtilList.size());
    List localList = paramGetCollectionListEvent.jdField_a_of_type_JavaUtilList;
    int i = 0;
    while (i < localList.size())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)localList.get(i);
      if (localVideoCollectionItem.collectionType == 1)
      {
        int j = 0;
        if (j < localVideoCollectionItem.collectionVideoUIItemList.size())
        {
          VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = (VideoCollectionItem.FakeVideoUIItem)localVideoCollectionItem.collectionVideoUIItemList.get(j);
          if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.contains(localFakeVideoUIItem.jdField_a_of_type_JavaLangString))
          {
            localFakeVideoUIItem.jdField_a_of_type_Boolean = true;
            if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) {
              localFakeVideoUIItem.b = true;
            }
          }
          for (;;)
          {
            j += 1;
            break;
            localFakeVideoUIItem.jdField_a_of_type_Boolean = false;
            if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) {
              localFakeVideoUIItem.b = false;
            } else {
              localFakeVideoUIItem.b = true;
            }
          }
        }
        ((List)localObject).add(localVideoCollectionItem);
      }
      i += 1;
    }
    if ((bool2) && (paramGetCollectionListEvent.e))
    {
      if (!((List)localObject).isEmpty()) {
        break label327;
      }
      paramStoryPickerFragment.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
      if (!paramGetCollectionListEvent.c) {
        break label347;
      }
      paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter.a((List)localObject);
    }
    for (;;)
    {
      if (paramGetCollectionListEvent.c) {
        paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a(bool2);
      }
      localObject = paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a;
      if (!paramGetCollectionListEvent.jdField_a_of_type_Boolean) {
        bool1 = true;
      }
      ((LoadingMoreHelper)localObject).a(bool2, bool1);
      paramStoryPickerFragment.h();
      return;
      label327:
      paramStoryPickerFragment.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(0);
      break;
      label347:
      paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter.b((List)localObject);
    }
  }
  
  public Class acceptEventClass()
  {
    return DateCollectionListPageLoader.GetCollectionListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsz
 * JD-Core Version:    0.7.0.1
 */