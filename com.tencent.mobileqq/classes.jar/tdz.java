import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

class tdz
  implements syq<tea, teb>
{
  private tdz(tdx paramtdx) {}
  
  public void a(@NonNull tea paramtea, @Nullable teb paramteb, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramteb != null) && (paramteb.jdField_a_of_type_Int == 0) && (paramErrorMessage.isSuccess()))
    {
      this.a.jdField_a_of_type_JavaUtilList.addAll(paramteb.jdField_a_of_type_JavaUtilList);
      ved.d("VideoFilterManager", "new filter count %d, current total count %d, isEnd=%s, cookie=%s", new Object[] { Integer.valueOf(paramteb.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()), Boolean.valueOf(paramteb.jdField_a_of_type_Boolean), paramteb.jdField_a_of_type_JavaLangString });
      if ((paramteb.jdField_a_of_type_Boolean) || (paramteb.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        ved.d("VideoFilterManager", "get filter full list finish, frequency = %d s", new Object[] { Integer.valueOf(paramteb.b) });
        this.a.a(true, paramteb.b);
        return;
      }
      this.a.c = paramteb.jdField_a_of_type_JavaLangString;
      this.a.c();
      return;
    }
    ved.c("VideoFilterManager", "get filter failed %s", paramErrorMessage);
    this.a.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdz
 * JD-Core Version:    0.7.0.1
 */