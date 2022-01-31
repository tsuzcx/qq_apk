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

public class lba
  extends lat
{
  private static lba jdField_a_of_type_Lba;
  DocumentBuilder jdField_a_of_type_JavaxXmlParsersDocumentBuilder;
  DocumentBuilderFactory jdField_a_of_type_JavaxXmlParsersDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
  private lbe jdField_a_of_type_Lbe = new lbe(this, null);
  
  private lba()
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
  
  public static lba a()
  {
    try
    {
      if (jdField_a_of_type_Lba == null) {
        jdField_a_of_type_Lba = new lba();
      }
      return jdField_a_of_type_Lba;
    }
    finally {}
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, Long paramLong, laj paramlaj)
  {
    paramLong = new HashMap();
    paramLong.put("client_id", paramString1);
    paramLong.put("client_secret", paramString2);
    paramLong.put("scope", "http://api.microsofttranslator.com");
    paramLong.put("grant_type", "client_credentials");
    try
    {
      laz.a(paramContext, null, paramLong, new lbd(this, paramlaj));
      return;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      paramlaj.a(new TranslateError(paramContext), "UnsupportedEncodingException");
    }
  }
  
  private void a(Context paramContext, List<String> paramList, Language paramLanguage, String paramString, Long paramLong, lbm paramlbm)
  {
    if (paramLanguage == null) {
      paramLanguage = Language.MS_CHINESE_SIMPLIFIED.toString();
    }
    for (;;)
    {
      paramString = new BasicHeader("Authorization", "Bearer " + paramString);
      try
      {
        localObject = new lbc(this, paramList, paramlbm, paramLong);
        laz.a(paramContext, new Header[] { paramString }, paramList, paramLanguage, (lah)localObject);
        return;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        Object localObject;
        paramlbm.a(new TranslateError(paramContext), paramLong);
        return;
      }
      catch (Exception paramContext)
      {
        paramlbm.a(new TranslateError(paramContext), paramLong);
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
  
  public void a(Context paramContext, List<String> paramList, Language paramLanguage, Long paramLong, String paramString1, String paramString2, lbm paramlbm)
  {
    if (System.currentTimeMillis() < this.jdField_a_of_type_Lbe.jdField_a_of_type_Long)
    {
      a(paramContext, paramList, paramLanguage, this.jdField_a_of_type_Lbe.jdField_a_of_type_JavaLangString, paramLong, paramlbm);
      return;
    }
    a(paramContext, paramString1, paramString2, paramLong, new lbb(this, paramLong, paramContext, paramList, paramLanguage, paramlbm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     lba
 * JD-Core Version:    0.7.0.1
 */