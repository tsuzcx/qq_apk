import android.os.HandlerThread;
import android.os.Process;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.qbar.QbarNativeImpl;
import com.tencent.qphone.base.util.QLog;

public class peh
  extends HandlerThread
{
  public boolean a;
  
  public peh(ScannerView paramScannerView, String paramString)
  {
    super(paramString);
  }
  
  public boolean quit()
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ScannerView", 2, "decode thread quit");
    }
    try
    {
      QbarNativeImpl.b();
      return super.quit();
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ScannerView", 2, localUnsatisfiedLinkError.toString());
        }
      }
    }
  }
  
  public void run()
  {
    Process.setThreadPriority(-20);
    try
    {
      int i = QbarNativeImpl.b(2, 0, "ANY", "UTF-8");
      Object localObject = new int[2];
      localObject[0] = 2;
      localObject[1] = 0;
      int j = QbarNativeImpl.b((int[])localObject, localObject.length);
      localObject = QbarNativeImpl.a();
      if (QLog.isDevelopLevel())
      {
        QLog.d("ScannerView", 4, "init for camera init_result1:" + i + ",init_result2:" + j);
        QLog.d("ScannerView", 4, "version:" + (String)localObject);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ScannerView", 2, localUnsatisfiedLinkError.toString());
        }
      }
    }
    super.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     peh
 * JD-Core Version:    0.7.0.1
 */