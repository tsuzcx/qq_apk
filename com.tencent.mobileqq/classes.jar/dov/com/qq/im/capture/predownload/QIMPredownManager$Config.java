package dov.com.qq.im.capture.predownload;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QIMPredownManager$Config
{
  public int a;
  public ArrayList<QIMPredownManager.Config.Item> a;
  public ArrayList<QIMPredownManager.Config.Item> b = new ArrayList();
  
  public QIMPredownManager$Config()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static Config a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new Config();
    }
    localConfig = new Config();
    try
    {
      paramString = new JSONObject(paramString);
      localConfig.jdField_a_of_type_Int = paramString.getInt("levelLimit");
      paramString = paramString.getJSONArray("levelCfg");
      int j = 0;
      int i = 0;
      while (j < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(j);
        int i1 = localJSONObject.getInt("level");
        int k = 0;
        while (k < QIMPredownManager.a.length)
        {
          JSONArray localJSONArray = localJSONObject.optJSONArray(QIMPredownManager.a[k]);
          int n = i;
          if (localJSONArray != null)
          {
            int m = 0;
            for (;;)
            {
              n = i;
              if (m >= localJSONArray.length()) {
                break;
              }
              String str = localJSONArray.getString(m);
              QIMPredownManager.Config.Item localItem = new QIMPredownManager.Config.Item();
              localItem.jdField_a_of_type_JavaLangString = str;
              localItem.c = k;
              localItem.b = i1;
              n = i;
              if (localConfig.jdField_a_of_type_Int >= i1)
              {
                localItem.jdField_a_of_type_Int = i;
                localConfig.jdField_a_of_type_JavaUtilArrayList.add(localItem);
                n = i + 1;
              }
              localConfig.b.add(localItem);
              m += 1;
              i = n;
            }
          }
          k += 1;
          i = n;
        }
        j += 1;
      }
      return localConfig;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.predownload.QIMPredownManager.Config
 * JD-Core Version:    0.7.0.1
 */