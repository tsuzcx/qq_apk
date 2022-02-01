package cooperation.qzone.statistic.access.concept;

public abstract class Sampler
{
  public static Sampler All = new Sampler.1();
  
  public int getFrequency()
  {
    return 1;
  }
  
  public abstract boolean sample();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.statistic.access.concept.Sampler
 * JD-Core Version:    0.7.0.1
 */