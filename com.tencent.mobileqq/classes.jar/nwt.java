import android.view.View;
import com.tencent.mobileqq.text.QQText.LinkSpan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class nwt
  extends QQText.LinkSpan
{
  public nwt(nws paramnws, String paramString)
  {
    super(paramnws, paramString);
  }
  
  public void onClick(View paramView)
  {
    if (nwu.a.matcher(this.mUrl).find())
    {
      nws.a(paramView, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nwt
 * JD-Core Version:    0.7.0.1
 */