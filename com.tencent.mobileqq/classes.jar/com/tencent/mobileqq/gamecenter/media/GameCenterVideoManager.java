package com.tencent.mobileqq.gamecenter.media;

public class GameCenterVideoManager
{
  private static GameCenterVideoManager a;
  private GameCenterVideoViewController b;
  
  public static GameCenterVideoManager a()
  {
    try
    {
      if (a == null) {
        a = new GameCenterVideoManager();
      }
      GameCenterVideoManager localGameCenterVideoManager = a;
      return localGameCenterVideoManager;
    }
    finally {}
  }
  
  public void a(GameCenterVideoViewController paramGameCenterVideoViewController)
  {
    GameCenterVideoViewController localGameCenterVideoViewController = this.b;
    if ((localGameCenterVideoViewController != null) && (localGameCenterVideoViewController != null) && (localGameCenterVideoViewController != paramGameCenterVideoViewController) && (localGameCenterVideoViewController != null))
    {
      localGameCenterVideoViewController.stop();
      this.b.release();
    }
    this.b = paramGameCenterVideoViewController;
  }
  
  public GameCenterVideoViewController b()
  {
    return this.b;
  }
  
  public void c()
  {
    GameCenterVideoViewController localGameCenterVideoViewController = this.b;
    if (localGameCenterVideoViewController != null)
    {
      localGameCenterVideoViewController.stop();
      this.b.release();
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoManager
 * JD-Core Version:    0.7.0.1
 */