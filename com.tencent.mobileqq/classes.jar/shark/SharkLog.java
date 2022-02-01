package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/SharkLog;", "", "()V", "logger", "Lshark/SharkLog$Logger;", "getLogger", "()Lshark/SharkLog$Logger;", "setLogger", "(Lshark/SharkLog$Logger;)V", "d", "", "message", "Lkotlin/Function0;", "", "throwable", "", "Logger", "shark-log"}, k=1, mv={1, 4, 1})
public final class SharkLog
{
  @NotNull
  public static final SharkLog a = new SharkLog();
  @Nullable
  private static volatile SharkLog.Logger b;
  
  @Nullable
  public final SharkLog.Logger a()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.SharkLog
 * JD-Core Version:    0.7.0.1
 */