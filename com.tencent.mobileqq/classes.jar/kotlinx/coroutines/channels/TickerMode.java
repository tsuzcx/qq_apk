package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.ObsoleteCoroutinesApi;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/TickerMode;", "", "(Ljava/lang/String;I)V", "FIXED_PERIOD", "FIXED_DELAY", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@ObsoleteCoroutinesApi
public enum TickerMode
{
  static
  {
    TickerMode localTickerMode1 = new TickerMode("FIXED_PERIOD", 0);
    FIXED_PERIOD = localTickerMode1;
    TickerMode localTickerMode2 = new TickerMode("FIXED_DELAY", 1);
    FIXED_DELAY = localTickerMode2;
    $VALUES = new TickerMode[] { localTickerMode1, localTickerMode2 };
  }
  
  private TickerMode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.TickerMode
 * JD-Core Version:    0.7.0.1
 */