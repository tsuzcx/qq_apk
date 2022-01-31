import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

@SuppressLint({"HandlerLeak"})
class sku
  extends Handler
{
  WeakReference<skt> jdField_a_of_type_JavaLangRefWeakReference;
  
  sku(skt paramskt1, skt paramskt2)
  {
    sne.b("WSFallKeyPicMonitor", "init DownloadHandler");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramskt2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    sne.b("WSFallKeyPicMonitor", "handleMessage to download");
    if (paramMessage.what == 1)
    {
      if (skt.a(this.jdField_a_of_type_Skt) != 4) {
        break label46;
      }
      skt.a(this.jdField_a_of_type_Skt);
    }
    for (;;)
    {
      this.jdField_a_of_type_Skt.b();
      return;
      label46:
      skt.b(this.jdField_a_of_type_Skt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sku
 * JD-Core Version:    0.7.0.1
 */