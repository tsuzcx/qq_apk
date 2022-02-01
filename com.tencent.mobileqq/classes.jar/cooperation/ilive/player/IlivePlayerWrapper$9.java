package cooperation.ilive.player;

import android.view.Surface;
import com.tencent.thumbplayer.api.ITPPlayer;

class IlivePlayerWrapper$9
  implements Runnable
{
  IlivePlayerWrapper$9(IlivePlayerWrapper paramIlivePlayerWrapper, Surface paramSurface) {}
  
  public void run()
  {
    if (IlivePlayerWrapper.j(this.this$0) != null) {
      IlivePlayerWrapper.j(this.this$0).setSurface(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.player.IlivePlayerWrapper.9
 * JD-Core Version:    0.7.0.1
 */