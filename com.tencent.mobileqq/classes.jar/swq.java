import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;

class swq
{
  int a;
  private int b;
  private int c;
  
  public static swq a(int paramInt, Object... paramVarArgs)
  {
    swq localswq = new swq();
    localswq.a = paramInt;
    switch (paramInt)
    {
    case 3: 
    default: 
      return localswq;
    case 1: 
    case 2: 
      localswq.b = ((Integer)paramVarArgs[0]).intValue();
      return localswq;
    }
    localswq.c = ((Integer)paramVarArgs[0]).intValue();
    return localswq;
  }
  
  public Object a()
  {
    switch (this.a)
    {
    default: 
      return null;
    case 1: 
      return new swp(this.b);
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
 * Qualified Name:     swq
 * JD-Core Version:    0.7.0.1
 */