import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class stq
  extends SimpleJob<Object>
{
  stq(stl paramstl, String paramString1, String paramString2, stu paramstu)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    stl.a(this.jdField_a_of_type_Stl, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Stu);
    return null;
  }
  
  public int getJobType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     stq
 * JD-Core Version:    0.7.0.1
 */