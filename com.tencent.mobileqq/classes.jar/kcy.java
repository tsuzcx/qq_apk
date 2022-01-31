import com.tencent.av.ui.VideoLayerUIBase;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

public class kcy
  implements Observer
{
  private WeakReference a;
  
  public kcy(VideoLayerUIBase paramVideoLayerUIBase)
  {
    this.a = new WeakReference(paramVideoLayerUIBase);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    VideoLayerUIBase localVideoLayerUIBase = (VideoLayerUIBase)this.a.get();
    if (localVideoLayerUIBase == null) {
      return;
    }
    VideoLayerUIBase.a(localVideoLayerUIBase, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kcy
 * JD-Core Version:    0.7.0.1
 */