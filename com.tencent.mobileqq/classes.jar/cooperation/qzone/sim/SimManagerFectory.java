package cooperation.qzone.sim;

import anac;
import anad;

public class SimManagerFectory
{
  public static SimManager a(String paramString, int paramInt)
  {
    if (paramInt >= 24) {
      return new anad();
    }
    return new anac();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.sim.SimManagerFectory
 * JD-Core Version:    0.7.0.1
 */