import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class swn
  extends SimpleJob<Object>
{
  swn(swm paramswm, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (this.a.jdField_a_of_type_Swp == null) {
      this.a.jdField_a_of_type_Swp = new swp(this.a, this.a.d);
    }
    this.a.jdField_a_of_type_JavaLangString = "";
    swm.a(this.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swn
 * JD-Core Version:    0.7.0.1
 */