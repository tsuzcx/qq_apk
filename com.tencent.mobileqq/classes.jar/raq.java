import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.redpacket.mvp.RIJRedPacketProgressPresenter.1;
import com.tencent.qphone.base.util.QLog;
import java.util.TimeZone;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class raq
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private Runnable jdField_a_of_type_JavaLangRunnable;
  @NotNull
  private rae jdField_a_of_type_Rae;
  @Nullable
  private raf jdField_a_of_type_Raf;
  
  public raq(@NotNull rae paramrae)
  {
    this.jdField_a_of_type_Rae = paramrae;
  }
  
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
    this.jdField_a_of_type_Raf = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("RIJRedPacketProgressPresenter", 1, "start timing: rowkey: " + paramString);
    if (this.jdField_a_of_type_Raf != null)
    {
      this.jdField_a_of_type_Raf.setState(1);
      this.jdField_a_of_type_Raf.setProgress(this.jdField_a_of_type_Rae.g() % this.jdField_a_of_type_Rae.d() / this.jdField_a_of_type_Rae.d() * 100.0F);
      this.jdField_a_of_type_Rae.c(paramInt1);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_JavaLangRunnable = new RIJRedPacketProgressPresenter.1(this, paramString, paramInt2);
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void a(raf paramraf)
  {
    this.jdField_a_of_type_Raf = paramraf;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    int i = this.jdField_a_of_type_Rae.b();
    if (!this.jdField_a_of_type_Rae.a()) {}
    while ((i <= 100) && (this.jdField_a_of_type_Rae.g() + i < this.jdField_a_of_type_Rae.h())) {
      return;
    }
    String str = this.jdField_a_of_type_Rae.a();
    this.jdField_a_of_type_Rae.a(str, this.jdField_a_of_type_Rae.a(), i);
    this.jdField_a_of_type_Rae.b(0);
    this.jdField_a_of_type_Rae.a("");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Raf == null) {
      return;
    }
    int i = this.jdField_a_of_type_Rae.g();
    int j = this.jdField_a_of_type_Rae.d();
    if ((i <= 0) || (i >= this.jdField_a_of_type_Rae.h()))
    {
      this.jdField_a_of_type_Raf.setState(0);
      return;
    }
    this.jdField_a_of_type_Raf.setState(1);
    this.jdField_a_of_type_Raf.setProgress(i % j / j * 100.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     raq
 * JD-Core Version:    0.7.0.1
 */