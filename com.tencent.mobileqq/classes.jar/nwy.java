import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class nwy
  extends QQUIEventReceiver
{
  public nwy(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if ((paramUpdateUserInfoEvent.errorInfo.isSuccess()) && (paramUpdateUserInfoEvent.a != null) && (!paramUpdateUserInfoEvent.a.isEmpty()) && (paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null))
    {
      if (!paramQQStoryShareGroupProfileActivity.g) {
        break label54;
      }
      paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a.notifyDataSetChanged();
    }
    label54:
    int j;
    do
    {
      return;
      j = 0;
      int i = j;
      Object localObject;
      if (paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.headerUnionIdList != null)
      {
        i = j;
        if (!paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.headerUnionIdList.isEmpty())
        {
          localObject = paramUpdateUserInfoEvent.a.iterator();
          QQUserUIItem localQQUserUIItem;
          do
          {
            i = j;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
          } while (!paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.headerUnionIdList.contains(localQQUserUIItem.uid));
          i = 1;
        }
      }
      j = i;
      if (!TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.d))
      {
        paramUpdateUserInfoEvent = paramUpdateUserInfoEvent.a.iterator();
        do
        {
          j = i;
          if (!paramUpdateUserInfoEvent.hasNext()) {
            break;
          }
          localObject = (QQUserUIItem)paramUpdateUserInfoEvent.next();
        } while (!paramQQStoryShareGroupProfileActivity.d.equals(((QQUserUIItem)localObject).uid));
        j = 1;
      }
    } while (j == 0);
    QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwy
 * JD-Core Version:    0.7.0.1
 */