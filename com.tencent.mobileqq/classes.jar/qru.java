import android.view.ViewGroup;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import java.util.concurrent.Executor;

public class qru
  implements ISuperPlayer.OnSeekCompleteListener, qrv
{
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor = amdp.a(64);
  private qrw jdField_a_of_type_Qrw;
  private qry jdField_a_of_type_Qry;
  private qsa jdField_a_of_type_Qsa = new qsb();
  private int b;
  private int c;
  
  private void d()
  {
    e();
    qrw localqrw = new qrw(2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_Qry);
    this.jdField_a_of_type_Qrw = localqrw;
    localqrw.a(this.jdField_a_of_type_Qsa);
    localqrw.executeOnExecutor(this.jdField_a_of_type_JavaUtilConcurrentExecutor, null);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Qrw != null) {
      this.jdField_a_of_type_Qrw.cancel(true);
    }
    this.jdField_a_of_type_Qrw = null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Qsa != null) {
      this.jdField_a_of_type_Qsa.b();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Qsa.a(paramInt, this);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void a(String paramString, ViewGroup paramViewGroup, qrv paramqrv)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Qsa.a(paramString, paramViewGroup);
    this.jdField_a_of_type_Qsa.a(paramqrv);
    this.jdField_a_of_type_Qsa.a(this);
  }
  
  public void a(qry paramqry)
  {
    this.jdField_a_of_type_Qry = paramqry;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Qsa != null) {
      this.jdField_a_of_type_Qsa.c();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Qry = null;
    e();
    this.jdField_a_of_type_Qsa.a();
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qru
 * JD-Core Version:    0.7.0.1
 */