import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class suu
  extends QQUIEventReceiver<suo, tna>
{
  public suu(@NonNull suo paramsuo)
  {
    super(paramsuo);
  }
  
  public void a(@NonNull suo paramsuo, @NonNull tna paramtna)
  {
    if ((paramsuo.a.a().equals(paramtna.jdField_a_of_type_JavaLangString)) && ((paramtna.jdField_a_of_type_Tjs instanceof tkg))) {
      paramsuo.a(((tkg)paramtna.jdField_a_of_type_Tjs).a(), paramtna.b);
    }
  }
  
  public Class acceptEventClass()
  {
    return tna.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     suu
 * JD-Core Version:    0.7.0.1
 */