import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.utils.BaseHandler;
import java.util.HashMap;

public class plh
  extends BroadcastReceiver
{
  public plh(ImageManager paramImageManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == null) {
      return;
    }
    ImageManager.b(null);
    ImageManager.b().clear();
    ImageManager.a(false);
    ImageManager.c().clear();
    ImageManager.a(this.a);
    ImageManager.getCachePath(paramContext);
    ImageManager.a(this.a).post(new pli(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     plh
 * JD-Core Version:    0.7.0.1
 */