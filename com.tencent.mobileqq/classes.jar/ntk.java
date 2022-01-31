import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ntk
  implements aokj<String>
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private int b;
  
  public static ntk a(int paramInt, String paramString, boolean paramBoolean)
  {
    ntk localntk = new ntk();
    localntk.jdField_a_of_type_Int = paramInt;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localntk.b = paramInt;
      localntk.jdField_a_of_type_JavaLangString = paramString;
      return localntk;
    }
  }
  
  public static ntk a(String paramString)
  {
    try
    {
      ntk localntk = (ntk)aolc.a(paramString, ntk.class);
      return localntk;
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      QLog.i("PublicAccountCenterUrlConfProcessor", 1, "loadConfig l :" + paramString, localQStorageInstantiateException);
    }
    return null;
  }
  
  public static ntk a(aoko[] paramArrayOfaoko)
  {
    ntk localntk = null;
    int i = 0;
    while (i < paramArrayOfaoko.length)
    {
      localntk = a(paramArrayOfaoko[i].jdField_a_of_type_JavaLangString);
      i += 1;
    }
    return localntk;
  }
  
  public void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      int i = suk.a((QQAppInterface)localObject);
      if (this.jdField_a_of_type_Int != i) {
        break label47;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PaSubscribeRedDotProcessor", 2, "IGNORE THIS ACTION because of SAME VERSION");
      }
    }
    label47:
    do
    {
      return;
      suk.a((QQAppInterface)localObject, this.jdField_a_of_type_Int);
      suk.a((QQAppInterface)localObject, this.b, this.jdField_a_of_type_JavaLangString);
      localObject = (WebProcessManager)((QQAppInterface)localObject).getManager(13);
    } while (localObject == null);
    ((WebProcessManager)localObject).e();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaSubscribeRedDotProcessor", 2, "updateSubscribeConfig xml: " + paramString);
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.trim();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        NodeList localNodeList = paramString.getElementsByTagName("version");
        Object localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject instanceof QQAppInterface))
        {
          localObject = (QQAppInterface)localObject;
          this.jdField_a_of_type_Int = Integer.parseInt(localNodeList.item(0).getFirstChild().getNodeValue());
          paramString = paramString.getElementsByTagName("public-account-folder");
          if (paramString.getLength() > 0)
          {
            paramString = (Element)paramString.item(0);
            this.b = Integer.parseInt(paramString.getElementsByTagName("show").item(0).getFirstChild().getNodeValue());
            this.jdField_a_of_type_JavaLangString = paramString.getElementsByTagName("msg").item(0).getFirstChild().getNodeValue();
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PaSubscribeRedDotProcessor", 2, "updateSubscribeConfig xml is empty");
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PaSubscribeRedDotProcessor", 2, "updateSubscribeConfig error", paramString);
      }
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ntk
 * JD-Core Version:    0.7.0.1
 */