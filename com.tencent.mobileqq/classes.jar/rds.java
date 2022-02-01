import android.view.ViewGroup;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import java.util.concurrent.Executor;

public class rds
  implements ISuperPlayer.OnSeekCompleteListener, rdt
{
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor = aoik.a(64);
  private rdu jdField_a_of_type_Rdu;
  private rdw jdField_a_of_type_Rdw;
  private rdy jdField_a_of_type_Rdy = new rdz();
  private int b;
  private int c;
  
  private void d()
  {
    e();
    rdu localrdu = new rdu(2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_Rdw);
    this.jdField_a_of_type_Rdu = localrdu;
    localrdu.a(this.jdField_a_of_type_Rdy);
    localrdu.executeOnExecutor(this.jdField_a_of_type_JavaUtilConcurrentExecutor, null);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Rdu != null) {
      this.jdField_a_of_type_Rdu.cancel(true);
    }
    this.jdField_a_of_type_Rdu = null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Rdy != null) {
      this.jdField_a_of_type_Rdy.b();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Rdy.a(paramInt, this);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void a(String paramString, ViewGroup paramViewGroup, rdt paramrdt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Rdy.a(paramString, paramViewGroup);
    this.jdField_a_of_type_Rdy.a(paramrdt);
    this.jdField_a_of_type_Rdy.a(this);
  }
  
  public void a(rdw paramrdw)
  {
    this.jdField_a_of_type_Rdw = paramrdw;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Rdy != null) {
      this.jdField_a_of_type_Rdy.c();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Rdw = null;
    e();
    this.jdField_a_of_type_Rdy.a();
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rds
 * JD-Core Version:    0.7.0.1
 */