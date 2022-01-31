import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Iterator;
import java.util.List;

class stu
  implements syt<tnj, tou>
{
  stu(sto paramsto, stx paramstx, String paramString) {}
  
  public void a(@NonNull tnj paramtnj, @Nullable tou paramtou, @NonNull ErrorMessage paramErrorMessage)
  {
    veg.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response " + paramtou);
    if ((paramErrorMessage.isFail()) || (paramtou == null))
    {
      veg.e("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url response error!");
      this.jdField_a_of_type_Stx.a(true);
      return;
    }
    paramtnj = (tcz)tdc.a(5);
    if (paramtou.a != null)
    {
      paramErrorMessage = paramtou.a.iterator();
      while (paramErrorMessage.hasNext()) {
        ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
      }
    }
    paramtou.a = paramtnj.a(paramtou.a);
    ((sto)tdc.a(28)).a(paramtou.b);
    this.jdField_a_of_type_Sto.c(this.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_Stx.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     stu
 * JD-Core Version:    0.7.0.1
 */