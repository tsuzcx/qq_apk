import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

class swa
{
  private WeakReference<svz> a;
  
  public swa(svz paramsvz)
  {
    this.a = new WeakReference(paramsvz);
  }
  
  @Nullable
  public svz a()
  {
    return (svz)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swa
 * JD-Core Version:    0.7.0.1
 */