import android.content.Context;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class kqr
  extends kqk
{
  private static kqr jdField_a_of_type_Kqr;
  DocumentBuilder jdField_a_of_type_JavaxXmlParsersDocumentBuilder;
  DocumentBuilderFactory jdField_a_of_type_JavaxXmlParsersDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
  private kqv jdField_a_of_type_Kqv = new kqv(this, null);
  
  private kqr()
  {
    try
    {
      this.jdField_a_of_type_JavaxXmlParsersDocumentBuilder = this.jdField_a_of_type_JavaxXmlParsersDocumentBuilderFactory.newDocumentBuilder();
      return;
    }
    catch (ParserConfigurationException localParserConfigurationException)
    {
      localParserConfigurationException.printStackTrace();
    }
  }
  
  public static kqr a()
  {
    try
    {
      if (jdField_a_of_type_Kqr == null) {
        jdField_a_of_type_Kqr = new kqr();
      }
      return jdField_a_of_type_Kqr;
    }
    finally {}
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, Long paramLong, kqa paramkqa)
  {
    paramLong = new HashMap();
    paramLong.put("client_id", paramString1);
    paramLong.put("client_secret", paramString2);
    paramLong.put("scope", "http://api.microsofttranslator.com");
    paramLong.put("grant_type", "client_credentials");
    try
    {
      kqq.a(paramContext, null, paramLong, new kqu(this, paramkqa));
      return;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      paramkqa.a(new TranslateError(paramContext), "UnsupportedEncodingException");
    }
  }
  
  private void a(Context paramContext, List<String> paramList, Language paramLanguage, String paramString, Long paramLong, krd paramkrd)
  {
    if (paramLanguage == null) {
      paramLanguage = Language.MS_CHINESE_SIMPLIFIED.toString();
    }
    for (;;)
    {
      paramString = new BasicHeader("Authorization", "Bearer " + paramString);
      try
      {
        localObject = new kqt(this, paramList, paramkrd, paramLong);
        kqq.a(paramContext, new Header[] { paramString }, paramList, paramLanguage, (kpy)localObject);
        return;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        Object localObject;
        paramkrd.a(new TranslateError(paramContext), paramLong);
        return;
      }
      catch (Exception paramContext)
      {
        paramkrd.a(new TranslateError(paramContext), paramLong);
      }
      localObject = paramLanguage.toString();
      if (localObject != null)
      {
        paramLanguage = (Language)localObject;
        if (((String)localObject).length() != 0) {}
      }
      else
      {
        paramLanguage = Language.MS_CHINESE_SIMPLIFIED.toString();
      }
    }
  }
  
  public void a(Context paramContext, List<String> paramList, Language paramLanguage, Long paramLong, String paramString1, String paramString2, krd paramkrd)
  {
    if (System.currentTimeMillis() < this.jdField_a_of_type_Kqv.jdField_a_of_type_Long)
    {
      a(paramContext, paramList, paramLanguage, this.jdField_a_of_type_Kqv.jdField_a_of_type_JavaLangString, paramLong, paramkrd);
      return;
    }
    a(paramContext, paramString1, paramString2, paramLong, new kqs(this, paramLong, paramContext, paramList, paramLanguage, paramkrd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     kqr
 * JD-Core Version:    0.7.0.1
 */