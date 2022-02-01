package cooperation.qzone.sim;

public class SimManagerFectory
{
  public static SimManager createProduct(String paramString, int paramInt)
  {
    if (paramInt >= 24) {
      return new SimManagerOfAPI24();
    }
    return new SimManagerDefault();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.sim.SimManagerFectory
 * JD-Core Version:    0.7.0.1
 */