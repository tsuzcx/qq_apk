import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class sxe
  implements slx<tai, tbw>
{
  sxe(List paramList) {}
  
  public void a(@NonNull tai paramtai, @Nullable tbw paramtbw, @NonNull ErrorMessage paramErrorMessage)
  {
    urk.b("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond");
    sxf localsxf = new sxf();
    localsxf.jdField_a_of_type_JavaUtilList = new ArrayList(paramtai.jdField_a_of_type_JavaUtilList);
    localsxf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramtbw == null))
    {
      urk.c("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond: get story player tag info failed, error:%s", paramErrorMessage);
      sgi.a().dispatch(localsxf);
      return;
    }
    urk.a("Q.qqstory.net:GetStoryPlayerTagInfoHandler", "onCmdRespond, vid list:%s, response list:%s", this.jdField_a_of_type_JavaUtilList, paramtbw.jdField_a_of_type_JavaUtilList);
    paramErrorMessage = (sqd)sqg.a(5);
    paramtai = paramtai.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtai.hasNext())
    {
      Object localObject = (String)paramtai.next();
      StoryVideoItem localStoryVideoItem = paramErrorMessage.a((String)localObject);
      localObject = sxd.a((String)localObject, paramtbw.jdField_a_of_type_JavaUtilList);
      if (localStoryVideoItem != null)
      {
        if (localObject == null)
        {
          localStoryVideoItem.mTagInfoBase = null;
          localStoryVideoItem.mCompInfoBase = null;
          localStoryVideoItem.mOALinkInfoJson = null;
        }
        for (localStoryVideoItem.mOALinkInfo = null;; localStoryVideoItem.mOALinkInfo = srv.a(localStoryVideoItem.mOALinkInfoJson))
        {
          if (localStoryVideoItem.mTagInfoBase != null) {
            localStoryVideoItem.mTagInfoBase.b = System.currentTimeMillis();
          }
          paramErrorMessage.a(localStoryVideoItem);
          break;
          localStoryVideoItem.mTagInfoBase = ((taj)localObject).jdField_a_of_type_Vil;
          localStoryVideoItem.mCompInfoBase = ((taj)localObject).jdField_a_of_type_Vid;
          localStoryVideoItem.mOALinkInfoJson = ((taj)localObject).b;
        }
      }
    }
    localsxf.b = new ArrayList(paramtbw.jdField_a_of_type_JavaUtilList);
    sgi.a().dispatch(localsxf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sxe
 * JD-Core Version:    0.7.0.1
 */