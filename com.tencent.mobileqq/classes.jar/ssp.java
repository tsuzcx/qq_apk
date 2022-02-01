import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;

public class ssp
  implements LineBackgroundSpan
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public ssp(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void drawBackground(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, int paramInt8) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ssp
 * JD-Core Version:    0.7.0.1
 */