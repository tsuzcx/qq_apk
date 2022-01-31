import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetUserGroupUnionIDHandler.GetUserGroupUnionIDEvent;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.model.GroupID;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class nww
  extends QQUIEventReceiver
{
  public nww(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull GetUserGroupUnionIDHandler.GetUserGroupUnionIDEvent paramGetUserGroupUnionIDEvent)
  {
    if ((TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.b)) && (!TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.c)) && (paramGetUserGroupUnionIDEvent.errorInfo.isSuccess()) && (!paramGetUserGroupUnionIDEvent.a.isEmpty()))
    {
      paramGetUserGroupUnionIDEvent = paramGetUserGroupUnionIDEvent.a.iterator();
      while (paramGetUserGroupUnionIDEvent.hasNext())
      {
        GroupID localGroupID = (GroupID)paramGetUserGroupUnionIDEvent.next();
        if (paramQQStoryShareGroupProfileActivity.c.equals(localGroupID.a))
        {
          paramQQStoryShareGroupProfileActivity.b = localGroupID.b;
          if (QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity)) {
            break label111;
          }
        }
      }
    }
    label111:
    for (boolean bool = true;; bool = false)
    {
      QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, bool);
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return GetUserGroupUnionIDHandler.GetUserGroupUnionIDEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nww
 * JD-Core Version:    0.7.0.1
 */