import android.os.Handler;
import com.tencent.biz.now.NowVideoView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class kql
  extends Thread
{
  public kql(NowVideoView paramNowVideoView) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    for (;;)
    {
      if ((this != null) && (!this.a.jdField_a_of_type_Boolean))
      {
        if ((this.a.jdField_a_of_type_Long != 0L) && (System.currentTimeMillis() - this.a.jdField_a_of_type_Long > 2000L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("NowVideoView", 2, "no draw for Now");
          }
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1003);
        }
      }
      else
      {
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return;
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
        continue;
      }
      try
      {
        Thread.sleep(1000L);
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kql
 * JD-Core Version:    0.7.0.1
 */