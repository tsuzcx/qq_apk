import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class swo
  extends SimpleJob<Object>
{
  swo(swm paramswm, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (this.a.jdField_a_of_type_Swp == null) {
      this.a.jdField_a_of_type_Swp = new swp(this.a, this.a.d);
    }
    this.a.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_Swp.jdField_a_of_type_JavaLangString;
    swm.a(this.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swo
 * JD-Core Version:    0.7.0.1
 */