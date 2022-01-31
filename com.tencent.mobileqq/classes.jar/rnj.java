import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;

class rnj
{
  int a;
  private int b;
  private int c;
  
  public static rnj a(int paramInt, Object... paramVarArgs)
  {
    rnj localrnj = new rnj();
    localrnj.a = paramInt;
    switch (paramInt)
    {
    case 3: 
    default: 
      return localrnj;
    case 1: 
    case 2: 
      localrnj.b = ((Integer)paramVarArgs[0]).intValue();
      return localrnj;
    }
    localrnj.c = ((Integer)paramVarArgs[0]).intValue();
    return localrnj;
  }
  
  public Object a()
  {
    switch (this.a)
    {
    default: 
      return null;
    case 1: 
      return new rni(this.b);
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
 * Qualified Name:     rnj
 * JD-Core Version:    0.7.0.1
 */