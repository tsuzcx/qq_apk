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

public class lbf
  extends lay
{
  private static lbf jdField_a_of_type_Lbf;
  DocumentBuilder jdField_a_of_type_JavaxXmlParsersDocumentBuilder;
  DocumentBuilderFactory jdField_a_of_type_JavaxXmlParsersDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
  private lbj jdField_a_of_type_Lbj = new lbj(this, null);
  
  private lbf()
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
  
  public static lbf a()
  {
    try
    {
      if (jdField_a_of_type_Lbf == null) {
        jdField_a_of_type_Lbf = new lbf();
      }
      return jdField_a_of_type_Lbf;
    }
    finally {}
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, Long paramLong, lao paramlao)
  {
    paramLong = new HashMap();
    paramLong.put("client_id", paramString1);
    paramLong.put("client_secret", paramString2);
    paramLong.put("scope", "http://api.microsofttranslator.com");
    paramLong.put("grant_type", "client_credentials");
    try
    {
      lbe.a(paramContext, null, paramLong, new lbi(this, paramlao));
      return;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      paramlao.a(new TranslateError(paramContext), "UnsupportedEncodingException");
    }
  }
  
  private void a(Context paramContext, List<String> paramList, Language paramLanguage, String paramString, Long paramLong, lbr paramlbr)
  {
    if (paramLanguage == null) {
      paramLanguage = Language.MS_CHINESE_SIMPLIFIED.toString();
    }
    for (;;)
    {
      paramString = new BasicHeader("Authorization", "Bearer " + paramString);
      try
      {
        localObject = new lbh(this, paramList, paramlbr, paramLong);
        lbe.a(paramContext, new Header[] { paramString }, paramList, paramLanguage, (lam)localObject);
        return;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        Object localObject;
        paramlbr.a(new TranslateError(paramContext), paramLong);
        return;
      }
      catch (Exception paramContext)
      {
        paramlbr.a(new TranslateError(paramContext), paramLong);
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
  
  public void a(Context paramContext, List<String> paramList, Language paramLanguage, Long paramLong, String paramString1, String paramString2, lbr paramlbr)
  {
    if (System.currentTimeMillis() < this.jdField_a_of_type_Lbj.jdField_a_of_type_Long)
    {
      a(paramContext, paramList, paramLanguage, this.jdField_a_of_type_Lbj.jdField_a_of_type_JavaLangString, paramLong, paramlbr);
      return;
    }
    a(paramContext, paramString1, paramString2, paramLong, new lbg(this, paramLong, paramContext, paramList, paramLanguage, paramlbr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     lbf
 * JD-Core Version:    0.7.0.1
 */