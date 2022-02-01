package com.tencent.mobileqq.gamecenter.view;

import android.os.Handler;
import avds;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.List;
import mqq.app.AppRuntime;

public class GameSessionView$1
  implements Runnable
{
  GameSessionView$1(GameSessionView paramGameSessionView) {}
  
  public void run()
  {
    if (GameSessionView.a(this.this$0) == null) {}
    avds localavds;
    List localList;
    do
    {
      return;
      localavds = (avds)GameSessionView.a(this.this$0).getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
      localList = localavds.a();
      if (localavds.c()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(GameSessionView.a, 0, "[setData] gray is not open. return.");
    return;
    if (!GameSessionView.a(this.this$0))
    {
      GameSessionView.a(this.this$0, 1);
      GameSessionView.a(this.this$0, localavds.c);
      GameSessionView.b(this.this$0, true);
    }
    GameSessionView.a(this.this$0).post(new GameSessionView.1.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView.1
 * JD-Core Version:    0.7.0.1
 */