import com.tencent.image.AbstractGifImage.DoAccumulativeRunnable;

public class svt
{
  private static int a;
  
  public static void a()
  {
    a = AbstractGifImage.DoAccumulativeRunnable.DELAY;
    AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
  }
  
  public static void b()
  {
    AbstractGifImage.DoAccumulativeRunnable.DELAY = a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     svt
 * JD-Core Version:    0.7.0.1
 */