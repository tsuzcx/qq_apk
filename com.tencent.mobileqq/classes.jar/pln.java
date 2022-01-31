import com.tencent.component.media.image.ImageManager;

public class pln
  implements Runnable
{
  public pln(ImageManager paramImageManager) {}
  
  public void run()
  {
    ImageManager.post(new plo(this), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pln
 * JD-Core Version:    0.7.0.1
 */