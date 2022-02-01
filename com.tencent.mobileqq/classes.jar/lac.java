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

public class lac
  extends kzv
{
  private static lac jdField_a_of_type_Lac;
  DocumentBuilder jdField_a_of_type_JavaxXmlParsersDocumentBuilder;
  DocumentBuilderFactory jdField_a_of_type_JavaxXmlParsersDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
  private lag jdField_a_of_type_Lag = new lag(this, null);
  
  private lac()
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
  
  public static lac a()
  {
    try
    {
      if (jdField_a_of_type_Lac == null) {
        jdField_a_of_type_Lac = new lac();
      }
      return jdField_a_of_type_Lac;
    }
    finally {}
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, Long paramLong, kzl paramkzl)
  {
    paramLong = new HashMap();
    paramLong.put("client_id", paramString1);
    paramLong.put("client_secret", paramString2);
    paramLong.put("scope", "https://api.microsofttranslator.com");
    paramLong.put("grant_type", "client_credentials");
    try
    {
      lab.a(paramContext, null, paramLong, new laf(this, paramkzl));
      return;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      paramkzl.a(new TranslateError(paramContext), "UnsupportedEncodingException");
    }
  }
  
  private void a(Context paramContext, List<String> paramList, Language paramLanguage, String paramString, Long paramLong, lao paramlao)
  {
    if (paramLanguage == null) {
      paramLanguage = Language.MS_CHINESE_SIMPLIFIED.toString();
    }
    for (;;)
    {
      paramString = new BasicHeader("Authorization", "Bearer " + paramString);
      try
      {
        localObject = new lae(this, paramList, paramlao, paramLong);
        lab.a(paramContext, new Header[] { paramString }, paramList, paramLanguage, (kzj)localObject);
        return;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        Object localObject;
        paramlao.a(new TranslateError(paramContext), paramLong);
        return;
      }
      catch (Exception paramContext)
      {
        paramlao.a(new TranslateError(paramContext), paramLong);
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
  
  public void a(Context paramContext, List<String> paramList, Language paramLanguage, Long paramLong, String paramString1, String paramString2, lao paramlao)
  {
    if (System.currentTimeMillis() < this.jdField_a_of_type_Lag.jdField_a_of_type_Long)
    {
      a(paramContext, paramList, paramLanguage, this.jdField_a_of_type_Lag.jdField_a_of_type_JavaLangString, paramLong, paramlao);
      return;
    }
    a(paramContext, paramString1, paramString2, paramLong, new lad(this, paramLong, paramContext, paramList, paramLanguage, paramlao));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lac
 * JD-Core Version:    0.7.0.1
 */