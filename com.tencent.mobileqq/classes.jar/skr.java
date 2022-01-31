import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

@SuppressLint({"HandlerLeak"})
class skr
  extends Handler
{
  WeakReference<skq> jdField_a_of_type_JavaLangRefWeakReference;
  
  skr(skq paramskq1, skq paramskq2)
  {
    snb.b("WSFallKeyPicMonitor", "init DownloadHandler");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramskq2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    snb.b("WSFallKeyPicMonitor", "handleMessage to download");
    if (paramMessage.what == 1)
    {
      if (skq.a(this.jdField_a_of_type_Skq) != 4) {
        break label46;
      }
      skq.a(this.jdField_a_of_type_Skq);
    }
    for (;;)
    {
      this.jdField_a_of_type_Skq.b();
      return;
      label46:
      skq.b(this.jdField_a_of_type_Skq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     skr
 * JD-Core Version:    0.7.0.1
 */