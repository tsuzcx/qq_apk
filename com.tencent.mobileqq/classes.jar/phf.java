import com.tencent.component.media.image.ImageManager;

public class phf
  implements Runnable
{
  public phf(ImageManager paramImageManager) {}
  
  public void run()
  {
    ImageManager.post(ImageManager.a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     phf
 * JD-Core Version:    0.7.0.1
 */