import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

class sjh
{
  private WeakReference<sjg> a;
  
  public sjh(sjg paramsjg)
  {
    this.a = new WeakReference(paramsjg);
  }
  
  @Nullable
  public sjg a()
  {
    return (sjg)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sjh
 * JD-Core Version:    0.7.0.1
 */