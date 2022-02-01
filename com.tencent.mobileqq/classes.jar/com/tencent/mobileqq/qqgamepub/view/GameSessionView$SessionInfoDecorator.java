package com.tencent.mobileqq.qqgamepub.view;

import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;

class GameSessionView$SessionInfoDecorator
{
  private final GameCenterSessionInfo a;
  
  GameSessionView$SessionInfoDecorator(GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    this.a = paramGameCenterSessionInfo;
  }
  
  public String a()
  {
    if (this.a.f() == 0) {
      return this.a.a();
    }
    return this.a.j();
  }
  
  public String b()
  {
    if (this.a.f() == 0) {
      return this.a.i();
    }
    return this.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameSessionView.SessionInfoDecorator
 * JD-Core Version:    0.7.0.1
 */