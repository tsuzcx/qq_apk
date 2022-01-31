import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;

class rar
{
  int a;
  private int b;
  private int c;
  
  public static rar a(int paramInt, Object... paramVarArgs)
  {
    rar localrar = new rar();
    localrar.a = paramInt;
    switch (paramInt)
    {
    case 3: 
    default: 
      return localrar;
    case 1: 
    case 2: 
      localrar.b = ((Integer)paramVarArgs[0]).intValue();
      return localrar;
    }
    localrar.c = ((Integer)paramVarArgs[0]).intValue();
    return localrar;
  }
  
  public Object a()
  {
    switch (this.a)
    {
    default: 
      return null;
    case 1: 
      return new raq(this.b);
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
 * Qualified Name:     rar
 * JD-Core Version:    0.7.0.1
 */