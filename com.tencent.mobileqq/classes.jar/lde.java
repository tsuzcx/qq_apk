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

public class lde
  extends lcx
{
  private static lde jdField_a_of_type_Lde;
  DocumentBuilder jdField_a_of_type_JavaxXmlParsersDocumentBuilder;
  DocumentBuilderFactory jdField_a_of_type_JavaxXmlParsersDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
  private ldi jdField_a_of_type_Ldi = new ldi(this, null);
  
  private lde()
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
  
  public static lde a()
  {
    try
    {
      if (jdField_a_of_type_Lde == null) {
        jdField_a_of_type_Lde = new lde();
      }
      return jdField_a_of_type_Lde;
    }
    finally {}
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, Long paramLong, lcn paramlcn)
  {
    paramLong = new HashMap();
    paramLong.put("client_id", paramString1);
    paramLong.put("client_secret", paramString2);
    paramLong.put("scope", "http://api.microsofttranslator.com");
    paramLong.put("grant_type", "client_credentials");
    try
    {
      ldd.a(paramContext, null, paramLong, new ldh(this, paramlcn));
      return;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      paramlcn.a(new TranslateError(paramContext), "UnsupportedEncodingException");
    }
  }
  
  private void a(Context paramContext, List<String> paramList, Language paramLanguage, String paramString, Long paramLong, ldq paramldq)
  {
    if (paramLanguage == null) {
      paramLanguage = Language.MS_CHINESE_SIMPLIFIED.toString();
    }
    for (;;)
    {
      paramString = new BasicHeader("Authorization", "Bearer " + paramString);
      try
      {
        localObject = new ldg(this, paramList, paramldq, paramLong);
        ldd.a(paramContext, new Header[] { paramString }, paramList, paramLanguage, (lcl)localObject);
        return;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        Object localObject;
        paramldq.a(new TranslateError(paramContext), paramLong);
        return;
      }
      catch (Exception paramContext)
      {
        paramldq.a(new TranslateError(paramContext), paramLong);
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
  
  public void a(Context paramContext, List<String> paramList, Language paramLanguage, Long paramLong, String paramString1, String paramString2, ldq paramldq)
  {
    if (System.currentTimeMillis() < this.jdField_a_of_type_Ldi.jdField_a_of_type_Long)
    {
      a(paramContext, paramList, paramLanguage, this.jdField_a_of_type_Ldi.jdField_a_of_type_JavaLangString, paramLong, paramldq);
      return;
    }
    a(paramContext, paramString1, paramString2, paramLong, new ldf(this, paramLong, paramContext, paramList, paramLanguage, paramldq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lde
 * JD-Core Version:    0.7.0.1
 */