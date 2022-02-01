import android.os.Handler;
import java.util.TimeZone;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class qrm
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  @NotNull
  private qrk jdField_a_of_type_Qrk;
  @Nullable
  private qrl jdField_a_of_type_Qrl;
  
  private long a(long paramLong)
  {
    return (TimeZone.getDefault().getOffset(paramLong) + paramLong) / 86400000L;
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    long l = paramLong1 - paramLong2;
    return (l < 86400000L) && (l > -86400000L) && (a(paramLong1) == a(paramLong2));
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_Qrk.b();
    if (!this.jdField_a_of_type_Qrk.a()) {}
    while ((i <= 100) && (this.jdField_a_of_type_Qrk.g() + i < this.jdField_a_of_type_Qrk.h())) {
      return;
    }
    String str = this.jdField_a_of_type_Qrk.a();
    this.jdField_a_of_type_Qrk.a(str, this.jdField_a_of_type_Qrk.a(), i);
    this.jdField_a_of_type_Qrk.b(0);
    this.jdField_a_of_type_Qrk.a("");
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Qrl == null) {
      return;
    }
    int i = this.jdField_a_of_type_Qrk.g();
    int j = this.jdField_a_of_type_Qrk.d();
    if ((i <= 0) || (i >= this.jdField_a_of_type_Qrk.h()))
    {
      this.jdField_a_of_type_Qrl.a(0);
      return;
    }
    this.jdField_a_of_type_Qrl.a(1);
    this.jdField_a_of_type_Qrl.a(i % j / j * 100.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qrm
 * JD-Core Version:    0.7.0.1
 */