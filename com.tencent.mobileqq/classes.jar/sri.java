import java.util.List;

public class sri
  extends srj<spz>
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
  
  protected long a(spz paramspz1, spz paramspz2)
  {
    if ((paramspz1 != paramspz2) && (paramspz1.b == paramspz2.b)) {
      return 1L;
    }
    return Math.abs(paramspz1.b - paramspz2.b);
  }
  
  protected spz a(List<spz> paramList)
  {
    long l = 0L;
    int i = 0;
    while (i < paramList.size())
    {
      l += ((spz)paramList.get(i)).b;
      i += 1;
    }
    spz localspz = new spz();
    localspz.b = (l / paramList.size());
    return localspz;
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
  
  protected boolean a(spz paramspz1, spz paramspz2)
  {
    return paramspz1.b == paramspz2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sri
 * JD-Core Version:    0.7.0.1
 */