package cooperation.qzone.statistic;

public abstract class Singleton
{
  private volatile Object a;
  
  public abstract Object a(Object paramObject);
  
  public final Object b(Object paramObject)
  {
    if (this.a == null) {}
    try
    {
      if (this.a == null) {
        this.a = a(paramObject);
      }
      return this.a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.statistic.Singleton
 * JD-Core Version:    0.7.0.1
 */