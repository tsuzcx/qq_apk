package cooperation.qzone.statistic.access.concept;

public abstract class Deliverer
{
  public static Deliverer Console = new Deliverer.1();
  public static final int NODATA = -1;
  public static final int SUCCESS = 0;
  
  public abstract int deliver(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.statistic.access.concept.Deliverer
 * JD-Core Version:    0.7.0.1
 */