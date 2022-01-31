import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

class tec
  implements syt<ted, tee>
{
  private tec(tea paramtea) {}
  
  public void a(@NonNull ted paramted, @Nullable tee paramtee, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramtee != null) && (paramtee.jdField_a_of_type_Int == 0) && (paramErrorMessage.isSuccess()))
    {
      this.a.jdField_a_of_type_JavaUtilList.addAll(paramtee.jdField_a_of_type_JavaUtilList);
      veg.d("VideoFilterManager", "new filter count %d, current total count %d, isEnd=%s, cookie=%s", new Object[] { Integer.valueOf(paramtee.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()), Boolean.valueOf(paramtee.jdField_a_of_type_Boolean), paramtee.jdField_a_of_type_JavaLangString });
      if ((paramtee.jdField_a_of_type_Boolean) || (paramtee.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        veg.d("VideoFilterManager", "get filter full list finish, frequency = %d s", new Object[] { Integer.valueOf(paramtee.b) });
        this.a.a(true, paramtee.b);
        return;
      }
      this.a.c = paramtee.jdField_a_of_type_JavaLangString;
      this.a.c();
      return;
    }
    veg.c("VideoFilterManager", "get filter failed %s", paramErrorMessage);
    this.a.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tec
 * JD-Core Version:    0.7.0.1
 */