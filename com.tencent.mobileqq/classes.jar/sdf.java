import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;

class sdf
{
  int a;
  private int b;
  private int c;
  
  public static sdf a(int paramInt, Object... paramVarArgs)
  {
    sdf localsdf = new sdf();
    localsdf.a = paramInt;
    switch (paramInt)
    {
    case 3: 
    default: 
      return localsdf;
    case 1: 
    case 2: 
      localsdf.b = ((Integer)paramVarArgs[0]).intValue();
      return localsdf;
    }
    localsdf.c = ((Integer)paramVarArgs[0]).intValue();
    return localsdf;
  }
  
  public Object a()
  {
    switch (this.a)
    {
    default: 
      return null;
    case 1: 
      return new sde(this.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sdf
 * JD-Core Version:    0.7.0.1
 */