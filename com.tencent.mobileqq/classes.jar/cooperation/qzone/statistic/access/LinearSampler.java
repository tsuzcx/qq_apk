package cooperation.qzone.statistic.access;

import cooperation.qzone.statistic.access.concept.Sampler;
import java.util.Random;

public class LinearSampler
  extends Sampler
{
  protected int frequency = 1;
  protected Random random = new Random(System.currentTimeMillis());
  
  public LinearSampler(int paramInt)
  {
    setFrequency(paramInt);
  }
  
  public int getFrequency()
  {
    return this.frequency;
  }
  
  public boolean sample()
  {
    return this.random.nextInt(this.frequency) < 1;
  }
  
  public void setFrequency(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    this.frequency = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.statistic.access.LinearSampler
 * JD-Core Version:    0.7.0.1
 */