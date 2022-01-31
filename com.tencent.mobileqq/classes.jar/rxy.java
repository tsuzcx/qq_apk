import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

@SuppressLint({"HandlerLeak"})
class rxy
  extends Handler
{
  WeakReference<rxx> jdField_a_of_type_JavaLangRefWeakReference;
  
  rxy(rxx paramrxx1, rxx paramrxx2)
  {
    sai.b("WSFallKeyPicMonitor", "init DownloadHandler");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramrxx2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    sai.b("WSFallKeyPicMonitor", "handleMessage to download");
    if (paramMessage.what == 1)
    {
      if (rxx.a(this.jdField_a_of_type_Rxx) != 4) {
        break label46;
      }
      rxx.a(this.jdField_a_of_type_Rxx);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rxx.b();
      return;
      label46:
      rxx.b(this.jdField_a_of_type_Rxx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxy
 * JD-Core Version:    0.7.0.1
 */