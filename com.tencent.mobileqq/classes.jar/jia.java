import com.tencent.av.core.IVideoEventListener;
import com.tencent.av.core.VcControllerImpl;

public class jia
  implements Runnable
{
  public jia(VcControllerImpl paramVcControllerImpl) {}
  
  public void run()
  {
    if (this.a.mEventListener != null) {
      this.a.mEventListener.b(this.a.mPreviewW, this.a.mPreviewH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jia
 * JD-Core Version:    0.7.0.1
 */