import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

class swd
{
  private WeakReference<swc> a;
  
  public swd(swc paramswc)
  {
    this.a = new WeakReference(paramswc);
  }
  
  @Nullable
  public swc a()
  {
    return (swc)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swd
 * JD-Core Version:    0.7.0.1
 */