import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Iterator;
import java.util.List;

class str
  implements syq<tng, tor>
{
  str(stl paramstl, stu paramstu, String paramString) {}
  
  public void a(@NonNull tng paramtng, @Nullable tor paramtor, @NonNull ErrorMessage paramErrorMessage)
  {
    ved.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response " + paramtor);
    if ((paramErrorMessage.isFail()) || (paramtor == null))
    {
      ved.e("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response error!");
      this.jdField_a_of_type_Stu.a(true);
      return;
    }
    paramtng = (tcw)tcz.a(5);
    if (paramtor.a != null)
    {
      paramErrorMessage = paramtor.a.iterator();
      while (paramErrorMessage.hasNext()) {
        ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
      }
    }
    paramtor.a = paramtng.a(paramtor.a);
    ((stl)tcz.a(28)).a(paramtor.b);
    this.jdField_a_of_type_Stl.c(this.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_Stu.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     str
 * JD-Core Version:    0.7.0.1
 */