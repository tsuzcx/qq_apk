import android.text.Spanned;
import android.text.style.CharacterStyle;
import java.util.Comparator;

class j
  implements Comparator<CharacterStyle>
{
  Spanned a;
  
  public int a(CharacterStyle paramCharacterStyle1, CharacterStyle paramCharacterStyle2)
  {
    int i = 1;
    if (this.a == null) {
      i = 0;
    }
    int j;
    int k;
    do
    {
      do
      {
        return i;
        j = this.a.getSpanStart(paramCharacterStyle1);
        k = this.a.getSpanStart(paramCharacterStyle2);
        if (j != k) {
          break;
        }
        j = this.a.getSpanEnd(paramCharacterStyle1);
        k = this.a.getSpanEnd(paramCharacterStyle2);
        if (j == k) {
          return 0;
        }
      } while (j > k);
      return -1;
    } while (j > k);
    return -1;
  }
  
  void a(Spanned paramSpanned)
  {
    this.a = paramSpanned;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     j
 * JD-Core Version:    0.7.0.1
 */