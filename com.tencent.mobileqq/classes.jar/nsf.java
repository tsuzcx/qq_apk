import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.VidToSimpleInfoHandler.GetSimpleInfoListEvent;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class nsf
  extends QQUIEventReceiver
{
  public nsf(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull VidToSimpleInfoHandler.GetSimpleInfoListEvent paramGetSimpleInfoListEvent)
  {
    if (paramGetSimpleInfoListEvent.a.isSuccess()) {
      paramQQStoryShareGroupProfileActivity.a.a(paramGetSimpleInfoListEvent);
    }
  }
  
  public Class acceptEventClass()
  {
    return VidToSimpleInfoHandler.GetSimpleInfoListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsf
 * JD-Core Version:    0.7.0.1
 */