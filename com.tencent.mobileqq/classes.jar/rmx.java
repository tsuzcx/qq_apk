import android.view.ViewGroup;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import java.util.concurrent.Executor;

public class rmx
  implements ISuperPlayer.OnSeekCompleteListener, rmy
{
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor = anvy.a(64);
  private rmz jdField_a_of_type_Rmz;
  private rnb jdField_a_of_type_Rnb;
  private rnd jdField_a_of_type_Rnd = new rne();
  private int b;
  private int c;
  
  private void d()
  {
    e();
    rmz localrmz = new rmz(2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_Rnb);
    this.jdField_a_of_type_Rmz = localrmz;
    localrmz.a(this.jdField_a_of_type_Rnd);
    localrmz.executeOnExecutor(this.jdField_a_of_type_JavaUtilConcurrentExecutor, null);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Rmz != null) {
      this.jdField_a_of_type_Rmz.cancel(true);
    }
    this.jdField_a_of_type_Rmz = null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Rnd != null) {
      this.jdField_a_of_type_Rnd.b();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Rnd.a(paramInt, this);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void a(String paramString, ViewGroup paramViewGroup, rmy paramrmy)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Rnd.a(paramString, paramViewGroup);
    this.jdField_a_of_type_Rnd.a(paramrmy);
    this.jdField_a_of_type_Rnd.a(this);
  }
  
  public void a(rnb paramrnb)
  {
    this.jdField_a_of_type_Rnb = paramrnb;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Rnd != null) {
      this.jdField_a_of_type_Rnd.c();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Rnb = null;
    e();
    this.jdField_a_of_type_Rnd.a();
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rmx
 * JD-Core Version:    0.7.0.1
 */