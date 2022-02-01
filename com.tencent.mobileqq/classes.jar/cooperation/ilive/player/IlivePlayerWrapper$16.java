package cooperation.ilive.player;

import com.tencent.thumbplayer.api.ITPPlayer;

class IlivePlayerWrapper$16
  implements Runnable
{
  IlivePlayerWrapper$16(IlivePlayerWrapper paramIlivePlayerWrapper, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (IlivePlayerWrapper.j(this.this$0) != null) {
      IlivePlayerWrapper.j(this.this$0).seekTo(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.player.IlivePlayerWrapper.16
 * JD-Core Version:    0.7.0.1
 */