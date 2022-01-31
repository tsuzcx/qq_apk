package com.tencent.mobileqq.gamecenter.view;

import asmu;
import java.util.List;
import mqq.app.AppRuntime;

public class GameSessionView$1
  implements Runnable
{
  GameSessionView$1(GameSessionView paramGameSessionView) {}
  
  public void run()
  {
    if (GameSessionView.a(this.this$0) == null) {
      return;
    }
    List localList = ((asmu)GameSessionView.a(this.this$0).getManager(358)).a();
    this.this$0.setData(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView.1
 * JD-Core Version:    0.7.0.1
 */