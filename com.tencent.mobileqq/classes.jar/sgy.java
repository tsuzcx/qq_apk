import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Iterator;
import java.util.List;

class sgy
  implements slx<tan, tby>
{
  sgy(sgs paramsgs, shb paramshb, String paramString) {}
  
  public void a(@NonNull tan paramtan, @Nullable tby paramtby, @NonNull ErrorMessage paramErrorMessage)
  {
    urk.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response " + paramtby);
    if ((paramErrorMessage.isFail()) || (paramtby == null))
    {
      urk.e("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response error!");
      this.jdField_a_of_type_Shb.a(true);
      return;
    }
    paramtan = (sqd)sqg.a(5);
    if (paramtby.a != null)
    {
      paramErrorMessage = paramtby.a.iterator();
      while (paramErrorMessage.hasNext()) {
        ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
      }
    }
    paramtby.a = paramtan.a(paramtby.a);
    ((sgs)sqg.a(28)).a(paramtby.b);
    this.jdField_a_of_type_Sgs.c(this.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_Shb.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sgy
 * JD-Core Version:    0.7.0.1
 */