import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;

class ssq
{
  int a;
  private int b;
  private int c;
  
  public static ssq a(int paramInt, Object... paramVarArgs)
  {
    ssq localssq = new ssq();
    localssq.a = paramInt;
    switch (paramInt)
    {
    case 3: 
    default: 
      return localssq;
    case 1: 
    case 2: 
      localssq.b = ((Integer)paramVarArgs[0]).intValue();
      return localssq;
    }
    localssq.c = ((Integer)paramVarArgs[0]).intValue();
    return localssq;
  }
  
  public Object a()
  {
    switch (this.a)
    {
    default: 
      return null;
    case 1: 
      return new ssp(this.b);
    case 2: 
      return new ForegroundColorSpan(this.b);
    case 5: 
      return new StrikethroughSpan();
    case 4: 
      return new StyleSpan(this.c);
    }
    return new UnderlineSpan();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ssq
 * JD-Core Version:    0.7.0.1
 */