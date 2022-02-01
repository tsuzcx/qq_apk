import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public abstract class lio
{
  protected int a;
  protected long a;
  protected VideoAppInterface a;
  protected String a;
  protected int b;
  protected long b;
  
  public lio(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public abstract int a(String paramString);
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = Build.MODEL.toLowerCase();
    this.jdField_a_of_type_Int = Build.VERSION.SDK_INT;
    this.jdField_a_of_type_Long = llq.d();
    this.jdField_b_of_type_Int = llq.e();
    this.jdField_b_of_type_Long = DeviceInfoUtil.getSystemTotalMemory();
  }
  
  public abstract boolean a(int paramInt, String paramString);
  
  public abstract boolean a(String paramString);
  
  public abstract void b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lio
 * JD-Core Version:    0.7.0.1
 */