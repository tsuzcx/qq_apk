import java.util.List;

public class sep
  extends seq<sdg>
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
  
  protected long a(sdg paramsdg1, sdg paramsdg2)
  {
    if ((paramsdg1 != paramsdg2) && (paramsdg1.b == paramsdg2.b)) {
      return 1L;
    }
    return Math.abs(paramsdg1.b - paramsdg2.b);
  }
  
  protected sdg a(List<sdg> paramList)
  {
    long l = 0L;
    int i = 0;
    while (i < paramList.size())
    {
      l += ((sdg)paramList.get(i)).b;
      i += 1;
    }
    sdg localsdg = new sdg();
    localsdg.b = (l / paramList.size());
    return localsdg;
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
  
  protected boolean a(sdg paramsdg1, sdg paramsdg2)
  {
    return paramsdg1.b == paramsdg2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sep
 * JD-Core Version:    0.7.0.1
 */