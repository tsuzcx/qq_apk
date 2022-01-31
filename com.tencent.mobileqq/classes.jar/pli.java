import com.tencent.component.media.image.ImageManager;
import java.util.concurrent.ConcurrentHashMap;

class pli
  implements Runnable
{
  pli(plh paramplh) {}
  
  public void run()
  {
    ImageManager.b(false);
    ImageManager.a(this.a.a, 0L);
    ImageManager.a(this.a.a).clear();
    ImageManager.a().clear();
    ImageManager.b().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pli
 * JD-Core Version:    0.7.0.1
 */