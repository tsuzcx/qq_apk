import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ong
  implements aqwv<String>
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private String c = "";
  
  public static ong a()
  {
    ong localong = new ong();
    localong.jdField_a_of_type_JavaLangString = usu.jdField_a_of_type_JavaLangString;
    localong.jdField_b_of_type_JavaLangString = usu.jdField_b_of_type_JavaLangString;
    localong.c = usu.c;
    localong.jdField_a_of_type_Boolean = usu.d;
    return localong;
  }
  
  private ong a(ong paramong, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return this;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("pacenter_url")) {
          this.jdField_a_of_type_JavaLangString = paramong.jdField_a_of_type_JavaLangString;
        }
        if (paramString.has("pacategory_url")) {
          this.jdField_b_of_type_JavaLangString = paramong.jdField_b_of_type_JavaLangString;
        }
        if (paramString.has("readinjoy_search_url")) {
          this.c = paramong.c;
        }
        if (paramString.has("image_collection_comment")) {
          this.jdField_a_of_type_Boolean = paramong.jdField_a_of_type_Boolean;
        }
        if (paramong.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          return this;
        }
      }
      catch (Exception paramong)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountCenterUrlConfProcessor", 2, "checkPublicAccountCenterUrlConfigData error", paramong);
        }
        paramong.printStackTrace();
      }
    }
    return this;
  }
  
  public static ong a(aqxa[] paramArrayOfaqxa)
  {
    Object localObject = new ong();
    int i = 0;
    String str;
    for (;;)
    {
      if (i >= paramArrayOfaqxa.length) {
        return localObject;
      }
      str = paramArrayOfaqxa[i].jdField_a_of_type_JavaLangString;
      try
      {
        ong localong = ((ong)localObject).a((ong)aqxo.a(str, ong.class), str);
        localObject = localong;
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
    usu.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    usu.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    usu.c = this.c;
    usu.d = this.jdField_a_of_type_Boolean;
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
        if (!usu.a(str1)) {
          break label156;
        }
        this.jdField_a_of_type_JavaLangString = str1;
        bool1 = true;
        if (usu.a(str2))
        {
          this.jdField_b_of_type_JavaLangString = str2;
          bool1 = true;
        }
        bool2 = bool1;
        if (paramString.has("readinjoy_search_url"))
        {
          str1 = paramString.getString("readinjoy_search_url");
          bool2 = bool1;
          if (usu.a(str1))
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
      usu.c((QQAppInterface)localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ong
 * JD-Core Version:    0.7.0.1
 */