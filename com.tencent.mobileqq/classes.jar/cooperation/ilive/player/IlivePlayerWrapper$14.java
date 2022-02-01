package cooperation.ilive.player;

import com.tencent.thumbplayer.api.ITPPlayer;

class IlivePlayerWrapper$14
  implements Runnable
{
  IlivePlayerWrapper$14(IlivePlayerWrapper paramIlivePlayerWrapper) {}
  
  public void run()
  {
    IlivePlayerWrapper.j(this.this$0).setOnPreparedListener(null);
    IlivePlayerWrapper.j(this.this$0).setOnInfoListener(null);
    IlivePlayerWrapper.j(this.this$0).setOnErrorListener(null);
    IlivePlayerWrapper.j(this.this$0).setOnCompletionListener(null);
    IlivePlayerWrapper.j(this.this$0).setOnSeekCompleteListener(null);
    IlivePlayerWrapper.j(this.this$0).reset();
    IliveAsyncHandlerManager.a().a(IlivePlayerWrapper.l(this.this$0));
    IliveTPPlayerPool.a().a(IlivePlayerWrapper.j(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.player.IlivePlayerWrapper.14
 * JD-Core Version:    0.7.0.1
 */