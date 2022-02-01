package cooperation.ilive.player;

import com.tencent.thumbplayer.api.ITPPlayer;

class IlivePlayerWrapper$11
  implements Runnable
{
  public void run()
  {
    if (IlivePlayerWrapper.j(this.this$0) != null) {
      IlivePlayerWrapper.j(this.this$0).release();
    }
    IliveTPPlayerPool.a().a(IlivePlayerWrapper.j(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.player.IlivePlayerWrapper.11
 * JD-Core Version:    0.7.0.1
 */