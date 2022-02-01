package cooperation.ilive.player;

import com.tencent.thumbplayer.api.ITPPlayer;

class IlivePlayerWrapper$23
  implements Runnable
{
  IlivePlayerWrapper$23(IlivePlayerWrapper paramIlivePlayerWrapper) {}
  
  public void run()
  {
    if (IlivePlayerWrapper.j(this.this$0) != null) {
      IlivePlayerWrapper.j(this.this$0).stopAsync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.player.IlivePlayerWrapper.23
 * JD-Core Version:    0.7.0.1
 */