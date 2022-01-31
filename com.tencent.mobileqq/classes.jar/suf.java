import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Collections;
import java.util.List;

class suf
  extends SimpleObserver<List<tfv>>
{
  suf(suc paramsuc, sug paramsug, ssm paramssm) {}
  
  public void a(List<tfv> paramList)
  {
    super.onNext(paramList);
    if (this.jdField_a_of_type_Sug != null) {
      this.jdField_a_of_type_Sug.a(this.jdField_a_of_type_Ssm, Collections.emptyList());
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (this.jdField_a_of_type_Sug != null) {
      this.jdField_a_of_type_Sug.a(this.jdField_a_of_type_Ssm, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     suf
 * JD-Core Version:    0.7.0.1
 */