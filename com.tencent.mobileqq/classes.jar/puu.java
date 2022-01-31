import android.text.Spanned;
import java.util.Comparator;

public class puu
  implements Comparator<Object>
{
  private Spanned a;
  
  public puu(Spanned paramSpanned)
  {
    this.a = paramSpanned;
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    int i = this.a.getSpanStart(paramObject1);
    int j = this.a.getSpanStart(paramObject2);
    if (i > j) {
      return 1;
    }
    if (i < j) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     puu
 * JD-Core Version:    0.7.0.1
 */