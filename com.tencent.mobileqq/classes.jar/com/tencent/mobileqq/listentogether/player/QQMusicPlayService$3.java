package com.tencent.mobileqq.listentogether.player;

final class QQMusicPlayService$3
  implements Runnable
{
  public void run()
  {
    synchronized (this.a)
    {
      this.b[0] = QQMusicPlayService.b();
      this.a.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayService.3
 * JD-Core Version:    0.7.0.1
 */