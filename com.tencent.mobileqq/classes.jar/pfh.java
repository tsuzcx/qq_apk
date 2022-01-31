import android.os.Looper;
import android.os.Message;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.utils.BaseHandler;

public class pfh
  extends BaseHandler
{
  public pfh(ImageManager paramImageManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      ImageManager.a(this.a, paramMessage);
      return;
    case 1: 
      ImageManager.b(this.a, paramMessage);
      return;
    }
    ImageManager.c(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pfh
 * JD-Core Version:    0.7.0.1
 */