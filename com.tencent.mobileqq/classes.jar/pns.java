import com.tencent.component.media.photogif.QzoneAnimationDrawable;

public class pns
  implements Runnable
{
  private pns(QzoneAnimationDrawable paramQzoneAnimationDrawable) {}
  
  public void run()
  {
    if (!QzoneAnimationDrawable.b(this.a)) {
      QzoneAnimationDrawable.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pns
 * JD-Core Version:    0.7.0.1
 */