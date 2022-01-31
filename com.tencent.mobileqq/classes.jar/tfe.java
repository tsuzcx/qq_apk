import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

@SuppressLint({"HandlerLeak"})
class tfe
  extends Handler
{
  WeakReference<tfd> jdField_a_of_type_JavaLangRefWeakReference;
  
  tfe(tfd paramtfd1, tfd paramtfd2)
  {
    tlo.b("WSFallKeyPicMonitor", "init DownloadHandler");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramtfd2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    tlo.b("WSFallKeyPicMonitor", "handleMessage to download");
    if (paramMessage.what == 1)
    {
      if (tfd.a(this.jdField_a_of_type_Tfd) != 4) {
        break label46;
      }
      tfd.a(this.jdField_a_of_type_Tfd);
    }
    for (;;)
    {
      this.jdField_a_of_type_Tfd.b();
      return;
      label46:
      tfd.b(this.jdField_a_of_type_Tfd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tfe
 * JD-Core Version:    0.7.0.1
 */