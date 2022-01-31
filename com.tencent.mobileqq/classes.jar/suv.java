import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class suv
  extends QQUIEventReceiver<suo, sqy>
{
  public suv(@NonNull suo paramsuo)
  {
    super(paramsuo);
  }
  
  public void a(@NonNull suo paramsuo, @NonNull sqy paramsqy)
  {
    urk.a(this.TAG, "onEvent, %s", String.valueOf(paramsqy));
    ssm localssm = paramsuo.a.a(3, "");
    if ((localssm != null) && (paramsqy.jdField_b_of_type_JavaLangString.equals(localssm.jdField_e_of_type_JavaLangString)))
    {
      urk.b(this.TAG, "onEvent, guideInfoNode read");
      paramsuo = new stu();
      paramsuo.jdField_b_of_type_JavaLangString = localssm.jdField_a_of_type_JavaLangString;
      paramsuo.c = localssm.jdField_a_of_type_Int;
      paramsuo.d = 5;
      paramsuo.jdField_b_of_type_Long = localssm.jdField_e_of_type_Long;
      slv.a().a(paramsuo, null);
      return;
    }
    paramsuo.a.a(paramsqy.jdField_a_of_type_JavaLangString, paramsqy.jdField_a_of_type_Long);
  }
  
  public Class acceptEventClass()
  {
    return sqy.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     suv
 * JD-Core Version:    0.7.0.1
 */