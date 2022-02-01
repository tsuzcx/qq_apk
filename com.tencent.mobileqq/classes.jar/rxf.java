import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import java.util.concurrent.Executor;

public class rxf
  implements ISuperPlayer.OnSeekCompleteListener, rxg
{
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManagerExecutor.getExecutorService(64);
  private rxh jdField_a_of_type_Rxh;
  private rxj jdField_a_of_type_Rxj;
  private rxl jdField_a_of_type_Rxl = new rxm();
  private int b;
  private int c;
  
  private void d()
  {
    e();
    rxh localrxh = new rxh(2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_Rxj);
    this.jdField_a_of_type_Rxh = localrxh;
    localrxh.a(this.jdField_a_of_type_Rxl);
    localrxh.executeOnExecutor(this.jdField_a_of_type_JavaUtilConcurrentExecutor, null);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Rxh != null) {
      this.jdField_a_of_type_Rxh.cancel(true);
    }
    this.jdField_a_of_type_Rxh = null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Rxl != null) {
      this.jdField_a_of_type_Rxl.b();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Rxl.a(paramInt, this);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void a(String paramString, ViewGroup paramViewGroup, rxg paramrxg)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Rxl.a(paramString, paramViewGroup);
    this.jdField_a_of_type_Rxl.a(paramrxg);
    this.jdField_a_of_type_Rxl.a(this);
  }
  
  public void a(rxj paramrxj)
  {
    this.jdField_a_of_type_Rxj = paramrxj;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Rxl != null) {
      this.jdField_a_of_type_Rxl.c();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Rxj = null;
    e();
    this.jdField_a_of_type_Rxl.a();
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxf
 * JD-Core Version:    0.7.0.1
 */