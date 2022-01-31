import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.Stream;

public class suc
{
  private int jdField_a_of_type_Int = 1;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = true;
  
  public void a(@NonNull ssm paramssm, sug paramsug)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.b)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabVideoPreloaderDataProvider", 2, "下载vidList和VideoInfo");
        }
        Stream.of(paramssm).map(new stc("MsgTabPreloader")).map(new ssz(null)).subscribe(new sud(this, paramsug, paramssm));
      }
    }
    else {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MsgTabVideoPreloaderDataProvider", 2, "只加载vidList");
    }
    Stream.of(paramssm).map(new stc("MsgTabPreloader")).subscribe(new suf(this, paramsug, paramssm));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     suc
 * JD-Core Version:    0.7.0.1
 */