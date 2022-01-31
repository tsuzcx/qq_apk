import java.util.List;

public class srl
  extends srm<sqc>
{
  private int a = 200;
  
  protected double a()
  {
    return 0.3D;
  }
  
  protected int a()
  {
    return this.a;
  }
  
  protected long a(sqc paramsqc1, sqc paramsqc2)
  {
    if ((paramsqc1 != paramsqc2) && (paramsqc1.b == paramsqc2.b)) {
      return 1L;
    }
    return Math.abs(paramsqc1.b - paramsqc2.b);
  }
  
  protected sqc a(List<sqc> paramList)
  {
    long l = 0L;
    int i = 0;
    while (i < paramList.size())
    {
      l += ((sqc)paramList.get(i)).b;
      i += 1;
    }
    sqc localsqc = new sqc();
    localsqc.b = (l / paramList.size());
    return localsqc;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  protected boolean a(long paramLong)
  {
    int i = b();
    if (i > 0) {
      if (paramLong / i >= 1500L) {}
    }
    while (paramLong < 200L)
    {
      return true;
      return false;
    }
    return false;
  }
  
  protected boolean a(sqc paramsqc1, sqc paramsqc2)
  {
    return paramsqc1.b == paramsqc2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     srl
 * JD-Core Version:    0.7.0.1
 */