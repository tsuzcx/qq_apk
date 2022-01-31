import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.authorize.JsonConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class kla
  extends Handler
{
  public kla(JsonConfig paramJsonConfig, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "clear mJsApiWhiteList");
      }
      this.a.a.clear();
    } while (!(paramMessage.obj instanceof ConcurrentHashMap));
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "update new mJsApiWhiteList!");
    }
    this.a.a.putAll((ConcurrentHashMap)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kla
 * JD-Core Version:    0.7.0.1
 */