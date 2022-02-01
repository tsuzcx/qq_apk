package kotlin.concurrent;

import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class TimersKt$timerTask$1
  extends TimerTask
{
  public TimersKt$timerTask$1(Function1 paramFunction1) {}
  
  public void run()
  {
    this.$action.invoke(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.concurrent.TimersKt.timerTask.1
 * JD-Core Version:    0.7.0.1
 */