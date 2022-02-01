package com.tencent.mobileqq.download.unite.config;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadConfigBean
{
  public String a;
  @NonNull
  public List<String> a;
  public boolean a;
  public String b;
  @NonNull
  public List<String> b;
  public String c = HardCodeUtil.a(2131720372);
  public String d = HardCodeUtil.a(2131720371);
  public String e = HardCodeUtil.a(2131720369);
  
  public DownloadConfigBean()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131720373);
    this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131720370);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static DownloadConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    DownloadConfigBean localDownloadConfigBean = new DownloadConfigBean();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      int j = paramArrayOfQConfItem.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          Object localObject = paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString;
          QLog.d("[UniteDownload] DownloadConfigBean", 2, new Object[] { "[config] parse: invoked. ", " content: ", localObject });
          try
          {
            localObject = new JSONObject((String)localObject);
            JSONArray localJSONArray1 = ((JSONObject)localObject).optJSONArray("BlackList");
            JSONArray localJSONArray2 = ((JSONObject)localObject).optJSONArray("WhiteList");
            localDownloadConfigBean.jdField_a_of_type_JavaUtilList = a(localJSONArray1);
            localDownloadConfigBean.jdField_b_of_type_JavaUtilList = a(localJSONArray2);
            localDownloadConfigBean.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("DialogTitle", HardCodeUtil.a(2131720373));
            localDownloadConfigBean.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("DialogContent", HardCodeUtil.a(2131720370));
            localDownloadConfigBean.d = ((JSONObject)localObject).optString("DialogDownloadButton", HardCodeUtil.a(2131720371));
            localDownloadConfigBean.e = ((JSONObject)localObject).optString("DialogCancelButton", HardCodeUtil.a(2131720369));
            localDownloadConfigBean.c = ((JSONObject)localObject).optString("DialogFeedbackButton", HardCodeUtil.a(2131720372));
            localDownloadConfigBean.jdField_a_of_type_Boolean = ((JSONObject)localObject).optBoolean("EnableUniteDownloadDialog", true);
            i += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              QLog.e("[UniteDownload] DownloadConfigBean", 1, localThrowable, new Object[0]);
            }
          }
        }
      }
    }
    return localDownloadConfigBean;
  }
  
  private static List<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray == null) {
      return localArrayList;
    }
    int j = paramJSONArray.length();
    int i = 0;
    while (i < j) {
      try
      {
        localArrayList.add(paramJSONArray.getString(i));
        i += 1;
      }
      catch (JSONException paramJSONArray)
      {
        QLog.e("[UniteDownload] DownloadConfigBean", 1, "jsonArray2List error: ", paramJSONArray);
      }
    }
    return localArrayList;
  }
  
  public String toString()
  {
    return "DownloadConfigBean{blacklist=" + this.jdField_a_of_type_JavaUtilList + ", whitelist=" + this.jdField_b_of_type_JavaUtilList + ", dialogTitle='" + this.jdField_a_of_type_JavaLangString + '\'' + ", dialogContent='" + this.jdField_b_of_type_JavaLangString + '\'' + ", dialogFeedbackButton='" + this.c + '\'' + ", dialogDownloadButton='" + this.d + '\'' + ", dialogCancelButton='" + this.e + '\'' + ", enableUniteDownloadDialog=" + this.jdField_a_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.config.DownloadConfigBean
 * JD-Core Version:    0.7.0.1
 */