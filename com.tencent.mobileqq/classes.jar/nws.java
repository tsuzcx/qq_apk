import android.view.View;
import com.tencent.biz.eqq.CrmIvrText.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextParseLinkUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class nws
  extends QQText
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  String jdField_a_of_type_JavaLangString = "";
  String b = "";
  
  public nws(CharSequence paramCharSequence, int paramInt1, int paramInt2, MessageRecord paramMessageRecord, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    super(paramCharSequence, paramInt1, paramInt2, paramMessageRecord);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  static void a(View paramView, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    paramView.post(new CrmIvrText.1(paramQQAppInterface, paramView, paramString1));
  }
  
  public void parseLinkSpan()
  {
    super.parseLinkSpan();
    Matcher localMatcher = Pattern.compile(QQTextParseLinkUtil.LINK_REGEX + "|" + "QQ语音").matcher(this.mText);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      addSpan(new nwt(this, this.mText.substring(i, j)), i, j, 33);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nws
 * JD-Core Version:    0.7.0.1
 */