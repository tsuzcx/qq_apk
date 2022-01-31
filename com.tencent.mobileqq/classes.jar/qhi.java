import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.redpacket.mvp.RIJRedPacketProgressPresenter.1;
import com.tencent.qphone.base.util.QLog;
import java.util.TimeZone;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class qhi
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private Runnable jdField_a_of_type_JavaLangRunnable;
  @NotNull
  private qgw jdField_a_of_type_Qgw;
  @Nullable
  private qgx jdField_a_of_type_Qgx;
  
  public qhi(@NotNull qgw paramqgw)
  {
    this.jdField_a_of_type_Qgw = paramqgw;
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
    this.jdField_a_of_type_Qgx = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("RIJRedPacketProgressPresenter", 1, "start timing: rowkey: " + paramString);
    if (this.jdField_a_of_type_Qgx != null)
    {
      this.jdField_a_of_type_Qgx.setState(1);
      this.jdField_a_of_type_Qgx.setProgress(this.jdField_a_of_type_Qgw.g() % this.jdField_a_of_type_Qgw.d() / this.jdField_a_of_type_Qgw.d() * 100.0F);
      this.jdField_a_of_type_Qgw.c(paramInt1);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_JavaLangRunnable = new RIJRedPacketProgressPresenter.1(this, paramString, paramInt2);
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void a(qgx paramqgx)
  {
    this.jdField_a_of_type_Qgx = paramqgx;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    int i = this.jdField_a_of_type_Qgw.b();
    if (!this.jdField_a_of_type_Qgw.a()) {}
    while ((i <= 100) && (this.jdField_a_of_type_Qgw.g() + i < this.jdField_a_of_type_Qgw.h())) {
      return;
    }
    String str = this.jdField_a_of_type_Qgw.a();
    this.jdField_a_of_type_Qgw.a(str, this.jdField_a_of_type_Qgw.a(), i);
    this.jdField_a_of_type_Qgw.b(0);
    this.jdField_a_of_type_Qgw.a("");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Qgx == null) {
      return;
    }
    int i = this.jdField_a_of_type_Qgw.g();
    int j = this.jdField_a_of_type_Qgw.d();
    if ((i <= 0) || (i >= this.jdField_a_of_type_Qgw.h()))
    {
      this.jdField_a_of_type_Qgx.setState(0);
      return;
    }
    this.jdField_a_of_type_Qgx.setState(1);
    this.jdField_a_of_type_Qgx.setProgress(i % j / j * 100.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qhi
 * JD-Core Version:    0.7.0.1
 */