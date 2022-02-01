import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;

class tbu
{
  int a;
  private int b;
  private int c;
  
  public static tbu a(int paramInt, Object... paramVarArgs)
  {
    tbu localtbu = new tbu();
    localtbu.a = paramInt;
    switch (paramInt)
    {
    case 3: 
    default: 
      return localtbu;
    case 1: 
    case 2: 
      localtbu.b = ((Integer)paramVarArgs[0]).intValue();
      return localtbu;
    }
    localtbu.c = ((Integer)paramVarArgs[0]).intValue();
    return localtbu;
  }
  
  public Object a()
  {
    switch (this.a)
    {
    default: 
      return null;
    case 1: 
      return new tbt(this.b);
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
 * Qualified Name:     tbu
 * JD-Core Version:    0.7.0.1
 */