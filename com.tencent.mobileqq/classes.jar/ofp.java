import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ofp
  implements apts<String>
{
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<uey> jdField_a_of_type_JavaUtilArrayList = new ArrayList(0);
  private boolean jdField_a_of_type_Boolean;
  
  public static ofp a(String paramString)
  {
    try
    {
      ofp localofp = (ofp)apul.a(paramString, ofp.class);
      return localofp;
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      QLog.i("PublicAccountCenterUrlConfProcessor", 1, "loadConfig l :" + paramString, localQStorageInstantiateException);
    }
    return null;
  }
  
  public static ofp a(aptx[] paramArrayOfaptx)
  {
    ofp localofp = null;
    int i = 0;
    while (i < paramArrayOfaptx.length)
    {
      localofp = a(paramArrayOfaptx[i].jdField_a_of_type_JavaLangString);
      i += 1;
    }
    return localofp;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        bfyz.f(((QQAppInterface)localAppRuntime).getApplication(), this.jdField_a_of_type_JavaLangString);
      }
    }
    while (!QLog.isColorLevel())
    {
      AppRuntime localAppRuntime;
      return;
    }
    QLog.e("PublicAccountConfProcessor", 2, "updateEqqConfig fail");
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfProcessor", 2, "parseConfigXml xml: " + paramString);
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        paramString = paramString.trim();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8"))).getElementsByTagName("public-account-folder");
        int j = paramString.getLength();
        Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject1 instanceof QQAppInterface))
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)localObject1;
          localObject1 = ((AppRuntime)localObject1).getApplication();
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(j);
          int i = 0;
          while (i < j)
          {
            Object localObject2 = (Element)paramString.item(i);
            localObject2 = new uey(localQQAppInterface, (Context)localObject1, Integer.parseInt(((Element)localObject2).getElementsByTagName("id").item(0).getFirstChild().getNodeValue()), ((Element)localObject2).getElementsByTagName("name").item(0).getFirstChild().getNodeValue(), ((Element)localObject2).getElementsByTagName("icon").item(0).getFirstChild().getNodeValue());
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            i += 1;
          }
          this.jdField_a_of_type_Boolean = true;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PublicAccountConfProcessor", 2, "parsePublicAccountConfigXml xml is empty");
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountConfProcessor", 2, "parsePublicAccountConfigXml error", paramString);
      }
      paramString.printStackTrace();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      uex.a(this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ofp
 * JD-Core Version:    0.7.0.1
 */