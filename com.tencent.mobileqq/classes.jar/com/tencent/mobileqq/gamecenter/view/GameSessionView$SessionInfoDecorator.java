package com.tencent.mobileqq.gamecenter.view;

import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;

class GameSessionView$SessionInfoDecorator
{
  private final GameCenterSessionInfo a;
  
  GameSessionView$SessionInfoDecorator(GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    this.a = paramGameCenterSessionInfo;
  }
  
  public String a()
  {
    if (this.a.a() == 0) {
      return this.a.a();
    }
    return this.a.g();
  }
  
  public String b()
  {
    if (this.a.a() == 0) {
      return this.a.f();
    }
    return this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView.SessionInfoDecorator
 * JD-Core Version:    0.7.0.1
 */