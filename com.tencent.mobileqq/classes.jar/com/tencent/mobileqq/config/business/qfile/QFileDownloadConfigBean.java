package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.util.IQStorageSafable;
import com.tencent.mobileqq.filemanager.data.DownloadFileConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QFileDownloadConfigBean
  implements IQStorageSafable<String>
{
  public String a;
  public HashMap<String, DownloadFileConfig> a;
  
  public QFileDownloadConfigBean()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("*", new DownloadFileConfig());
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.length() == 0) {
        return;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      paramString = localJSONObject.names();
      int i = 0;
      while (i < paramString.length())
      {
        Object localObject1 = paramString.getString(i).trim().toLowerCase();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          Object localObject2 = localJSONObject.optJSONObject((String)localObject1);
          DownloadFileConfig localDownloadFileConfig = new DownloadFileConfig();
          localDownloadFileConfig.c = ((JSONObject)localObject2).getInt("CellNetAutoDownloadSize");
          localDownloadFileConfig.b = ((JSONObject)localObject2).getInt("CellNetWarningSize");
          localDownloadFileConfig.a = ((JSONObject)localObject2).getInt("WiFiNetAutoDownloadSize");
          if (!((String)localObject1).contains(","))
          {
            this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, localDownloadFileConfig);
          }
          else
          {
            localObject1 = ((String)localObject1).split(",");
            int j = 0;
            while (j < localObject1.length)
            {
              localObject2 = localObject1[j].trim().toLowerCase();
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, localDownloadFileConfig);
              }
              j += 1;
            }
          }
        }
        i += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("", 1, QLog.getStackTraceString(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileDownloadConfigBean
 * JD-Core Version:    0.7.0.1
 */