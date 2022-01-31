package cooperation.qzone.sim;

import amjx;
import amjy;

public class SimManagerFectory
{
  public static SimManager a(String paramString, int paramInt)
  {
    if (paramInt >= 24) {
      return new amjy();
    }
    return new amjx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.sim.SimManagerFectory
 * JD-Core Version:    0.7.0.1
 */