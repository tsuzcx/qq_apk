package cooperation.qzone.sim;

import anhr;
import anhs;

public class SimManagerFectory
{
  public static SimManager a(String paramString, int paramInt)
  {
    if (paramInt >= 24) {
      return new anhs();
    }
    return new anhr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.sim.SimManagerFectory
 * JD-Core Version:    0.7.0.1
 */