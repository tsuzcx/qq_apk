import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import java.util.concurrent.Executor;

public class rks
  implements ISuperPlayer.OnSeekCompleteListener, rkt
{
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManagerExecutor.getExecutorService(64);
  private rku jdField_a_of_type_Rku;
  private rkw jdField_a_of_type_Rkw;
  private rky jdField_a_of_type_Rky = new rkz();
  private int b;
  private int c;
  
  private void d()
  {
    e();
    rku localrku = new rku(2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_Rkw);
    this.jdField_a_of_type_Rku = localrku;
    localrku.a(this.jdField_a_of_type_Rky);
    localrku.executeOnExecutor(this.jdField_a_of_type_JavaUtilConcurrentExecutor, null);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Rku != null) {
      this.jdField_a_of_type_Rku.cancel(true);
    }
    this.jdField_a_of_type_Rku = null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Rky != null) {
      this.jdField_a_of_type_Rky.b();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Rky.a(paramInt, this);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void a(String paramString, ViewGroup paramViewGroup, rkt paramrkt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Rky.a(paramString, paramViewGroup);
    this.jdField_a_of_type_Rky.a(paramrkt);
    this.jdField_a_of_type_Rky.a(this);
  }
  
  public void a(rkw paramrkw)
  {
    this.jdField_a_of_type_Rkw = paramrkw;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Rky != null) {
      this.jdField_a_of_type_Rky.c();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Rkw = null;
    e();
    this.jdField_a_of_type_Rky.a();
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rks
 * JD-Core Version:    0.7.0.1
 */