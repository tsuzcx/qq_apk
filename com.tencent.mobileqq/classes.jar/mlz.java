import com.tencent.av.ui.VideoLayerUIBase;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

public class mlz
  implements Observer
{
  private WeakReference<VideoLayerUIBase> a;
  
  public mlz(VideoLayerUIBase paramVideoLayerUIBase)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mlz
 * JD-Core Version:    0.7.0.1
 */