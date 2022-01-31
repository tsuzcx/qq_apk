import android.view.View;
import com.tencent.biz.eqq.CrmIvrText.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mpz
  extends axkd
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  String jdField_a_of_type_JavaLangString = "";
  String b = "";
  
  public mpz(CharSequence paramCharSequence, int paramInt1, int paramInt2, MessageRecord paramMessageRecord, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
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
  
  protected void a()
  {
    super.a();
    Matcher localMatcher = Pattern.compile(e + "|" + "QQ语音").matcher(this.g);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      a(new mqa(this, this.g.substring(i, j)), i, j, 33);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mpz
 * JD-Core Version:    0.7.0.1
 */