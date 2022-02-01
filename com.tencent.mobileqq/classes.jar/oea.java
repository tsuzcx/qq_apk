import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class oea
  implements arae<String>
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private String c = "";
  
  public static oea a()
  {
    oea localoea = new oea();
    localoea.jdField_a_of_type_JavaLangString = tyi.jdField_a_of_type_JavaLangString;
    localoea.jdField_b_of_type_JavaLangString = tyi.jdField_b_of_type_JavaLangString;
    localoea.c = tyi.c;
    localoea.jdField_a_of_type_Boolean = tyi.d;
    return localoea;
  }
  
  private oea a(oea paramoea, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return this;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("pacenter_url")) {
          this.jdField_a_of_type_JavaLangString = paramoea.jdField_a_of_type_JavaLangString;
        }
        if (paramString.has("pacategory_url")) {
          this.jdField_b_of_type_JavaLangString = paramoea.jdField_b_of_type_JavaLangString;
        }
        if (paramString.has("readinjoy_search_url")) {
          this.c = paramoea.c;
        }
        if (paramString.has("image_collection_comment")) {
          this.jdField_a_of_type_Boolean = paramoea.jdField_a_of_type_Boolean;
        }
        if (paramoea.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          return this;
        }
      }
      catch (Exception paramoea)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountCenterUrlConfProcessor", 2, "checkPublicAccountCenterUrlConfigData error", paramoea);
        }
        paramoea.printStackTrace();
      }
    }
    return this;
  }
  
  public static oea a(araj[] paramArrayOfaraj)
  {
    Object localObject = new oea();
    int i = 0;
    String str;
    for (;;)
    {
      if (i >= paramArrayOfaraj.length) {
        return localObject;
      }
      str = paramArrayOfaraj[i].jdField_a_of_type_JavaLangString;
      try
      {
        oea localoea = ((oea)localObject).a((oea)arax.a(str, oea.class), str);
        localObject = localoea;
      }
      catch (QStorageInstantiateException localQStorageInstantiateException)
      {
        for (;;)
        {
          QLog.i("PublicAccountCenterUrlConfProcessor", 1, "loadConfig l :" + str, localQStorageInstantiateException);
        }
      }
      i += 1;
    }
    return localObject;
  }
  
  public void a()
  {
    tyi.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    tyi.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    tyi.c = this.c;
    tyi.d = this.jdField_a_of_type_Boolean;
  }
  
  public void a(String paramString)
  {
    boolean bool3 = true;
    for (;;)
    {
      boolean bool2;
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.getString("pacenter_url");
        String str2 = paramString.getString("pacategory_url");
        if (!tyi.a(str1)) {
          break label156;
        }
        this.jdField_a_of_type_JavaLangString = str1;
        bool1 = true;
        if (tyi.a(str2))
        {
          this.jdField_b_of_type_JavaLangString = str2;
          bool1 = true;
        }
        bool2 = bool1;
        if (paramString.has("readinjoy_search_url"))
        {
          str1 = paramString.getString("readinjoy_search_url");
          bool2 = bool1;
          if (tyi.a(str1))
          {
            this.c = str1;
            bool2 = true;
          }
        }
        if (paramString.has("image_collection_comment"))
        {
          this.jdField_a_of_type_Boolean = paramString.getBoolean("image_collection_comment");
          bool1 = bool3;
          this.jdField_b_of_type_Boolean = bool1;
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountCenterUrlConfProcessor", 2, "checkPublicAccountCenterUrlConfigData error", paramString);
        }
        paramString.printStackTrace();
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      boolean bool1 = bool2;
      continue;
      label156:
      bool1 = false;
    }
  }
  
  public void b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      tyi.c((QQAppInterface)localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oea
 * JD-Core Version:    0.7.0.1
 */