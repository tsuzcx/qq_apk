package cooperation.qzone.statistic.access.concept;

public abstract class Condition
{
  public static Condition Always = new Condition.1();
  
  public abstract boolean meet(Collector paramCollector);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.statistic.access.concept.Condition
 * JD-Core Version:    0.7.0.1
 */