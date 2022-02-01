package com.tencent.timi.game.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class LogMsgChecker$check$1
  implements Runnable
{
  public final void run()
  {
    synchronized (LogMsgChecker.a(LogMsgChecker.a))
    {
      Object localObject1 = LogMsgChecker.a(LogMsgChecker.a, this.a);
      boolean bool = ((LogMsgChecker.ValidCheckResult)localObject1).a();
      if (bool) {
        return;
      }
      bool = LogMsgChecker.a(LogMsgChecker.a).contains(this.b);
      if (bool) {
        return;
      }
      LogMsgChecker.a(LogMsgChecker.a).add(this.b);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((LogMsgChecker.ValidCheckResult)localObject1).b());
      localStringBuilder.append(" \n");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" \noriginMsg:");
      localStringBuilder.append(this.a);
      QLog.e("LogMsgChecker_", 4, localStringBuilder.toString());
      localObject1 = Unit.INSTANCE;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.LogMsgChecker.check.1
 * JD-Core Version:    0.7.0.1
 */