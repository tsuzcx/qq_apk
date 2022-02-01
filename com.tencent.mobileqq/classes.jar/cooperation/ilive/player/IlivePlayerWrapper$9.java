package cooperation.ilive.player;

import android.view.Surface;
import com.tencent.thumbplayer.api.ITPPlayer;

class IlivePlayerWrapper$9
  implements Runnable
{
  IlivePlayerWrapper$9(IlivePlayerWrapper paramIlivePlayerWrapper, Surface paramSurface) {}
  
  public void run()
  {
    if (IlivePlayerWrapper.a(this.this$0) != null) {
      IlivePlayerWrapper.a(this.this$0).setSurface(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.player.IlivePlayerWrapper.9
 * JD-Core Version:    0.7.0.1
 */