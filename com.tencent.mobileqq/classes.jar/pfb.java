import com.tencent.component.media.image.ImageManager;

public class pfb
  implements Runnable
{
  public pfb(ImageManager paramImageManager) {}
  
  public void run()
  {
    ImageManager.post(new pfc(this), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pfb
 * JD-Core Version:    0.7.0.1
 */