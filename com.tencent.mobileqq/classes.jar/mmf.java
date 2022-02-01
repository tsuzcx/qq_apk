import com.tencent.av.ui.VideoLayerUIBase;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

public class mmf
  implements Observer
{
  private WeakReference<VideoLayerUIBase> a;
  
  public mmf(VideoLayerUIBase paramVideoLayerUIBase)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mmf
 * JD-Core Version:    0.7.0.1
 */