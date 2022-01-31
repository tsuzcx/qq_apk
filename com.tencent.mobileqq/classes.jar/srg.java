import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

class srg
  implements slx<srh, sri>
{
  private srg(sre paramsre) {}
  
  public void a(@NonNull srh paramsrh, @Nullable sri paramsri, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramsri != null) && (paramsri.jdField_a_of_type_Int == 0) && (paramErrorMessage.isSuccess()))
    {
      this.a.jdField_a_of_type_JavaUtilList.addAll(paramsri.jdField_a_of_type_JavaUtilList);
      urk.d("VideoFilterManager", "new filter count %d, current total count %d, isEnd=%s, cookie=%s", new Object[] { Integer.valueOf(paramsri.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()), Boolean.valueOf(paramsri.jdField_a_of_type_Boolean), paramsri.jdField_a_of_type_JavaLangString });
      if ((paramsri.jdField_a_of_type_Boolean) || (paramsri.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        urk.d("VideoFilterManager", "get filter full list finish, frequency = %d s", new Object[] { Integer.valueOf(paramsri.b) });
        this.a.a(true, paramsri.b);
        return;
      }
      this.a.c = paramsri.jdField_a_of_type_JavaLangString;
      this.a.c();
      return;
    }
    urk.c("VideoFilterManager", "get filter failed %s", paramErrorMessage);
    this.a.a(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     srg
 * JD-Core Version:    0.7.0.1
 */