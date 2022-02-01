import android.text.Editable;
import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuEditText;
import java.util.Comparator;

public class owd
  implements Comparator<ForegroundColorSpan>
{
  public owd(BiuEditText paramBiuEditText, Editable paramEditable) {}
  
  public int a(ForegroundColorSpan paramForegroundColorSpan1, ForegroundColorSpan paramForegroundColorSpan2)
  {
    return this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramForegroundColorSpan1) - this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramForegroundColorSpan2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     owd
 * JD-Core Version:    0.7.0.1
 */