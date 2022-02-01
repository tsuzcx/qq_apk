import android.view.View;
import com.tencent.mobileqq.text.QQText.LinkSpan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class nps
  extends QQText.LinkSpan
{
  public nps(npr paramnpr, String paramString)
  {
    super(paramnpr, paramString);
  }
  
  public void onClick(View paramView)
  {
    if (npt.a.matcher(this.mUrl).find())
    {
      npr.a(paramView, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nps
 * JD-Core Version:    0.7.0.1
 */