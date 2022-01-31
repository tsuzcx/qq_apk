import com.tencent.component.media.image.ImageManager;

public class pgv
  implements Runnable
{
  public pgv(ImageManager paramImageManager) {}
  
  public void run()
  {
    ImageManager.post(new pgw(this), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pgv
 * JD-Core Version:    0.7.0.1
 */