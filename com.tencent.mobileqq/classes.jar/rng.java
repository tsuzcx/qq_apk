import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;

class rng
{
  int a;
  private int b;
  private int c;
  
  public static rng a(int paramInt, Object... paramVarArgs)
  {
    rng localrng = new rng();
    localrng.a = paramInt;
    switch (paramInt)
    {
    case 3: 
    default: 
      return localrng;
    case 1: 
    case 2: 
      localrng.b = ((Integer)paramVarArgs[0]).intValue();
      return localrng;
    }
    localrng.c = ((Integer)paramVarArgs[0]).intValue();
    return localrng;
  }
  
  public Object a()
  {
    switch (this.a)
    {
    default: 
      return null;
    case 1: 
      return new rnf(this.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rng
 * JD-Core Version:    0.7.0.1
 */