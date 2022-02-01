package com.tencent.mobileqq.config.business.tendoc.tds;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class TdsReaderGrayConfigBean
{
  private int jdField_a_of_type_Int = -1;
  private final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static TdsReaderGrayConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0))
    {
      QLog.e("TdsReaderView_TdsReaderGrayConfigBean", 1, "parse error, confFiles is no-valid.");
      return null;
    }
    TdsReaderGrayConfigBean localTdsReaderGrayConfigBean = new TdsReaderGrayConfigBean();
    int k = paramArrayOfQConfItem.length;
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        Object localObject1 = paramArrayOfQConfItem[i];
        try
        {
          localObject1 = new JSONObject(((QConfItem)localObject1).a);
          if (localObject1 != null)
          {
            if (((JSONObject)localObject1).has("is_enable"))
            {
              if (((JSONObject)localObject1).optBoolean("is_enable"))
              {
                j = 1;
                localTdsReaderGrayConfigBean.jdField_a_of_type_Int = j;
              }
            }
            else {
              TdsReaderConfigBean.a((JSONObject)localObject1, localTdsReaderGrayConfigBean.jdField_a_of_type_JavaUtilMap);
            }
          }
          else {
            i += 1;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("TdsReaderView_TdsReaderGrayConfigBean", 1, "parse error", localJSONException);
            Object localObject2 = null;
            continue;
            int j = 0;
          }
        }
      }
    }
    return localTdsReaderGrayConfigBean;
  }
  
  public static void a(boolean paramBoolean, TdsReaderGrayConfigBean paramTdsReaderGrayConfigBean)
  {
    paramBoolean = true;
    if (paramTdsReaderGrayConfigBean == null) {
      QLog.w("TdsReaderView_TdsReaderGrayConfigBean", 1, "source error, configBean is null.");
    }
    do
    {
      return;
      if (!paramTdsReaderGrayConfigBean.jdField_a_of_type_JavaUtilMap.isEmpty()) {
        TdsReaderGlobal.a(true, paramTdsReaderGrayConfigBean.jdField_a_of_type_JavaUtilMap);
      }
    } while (paramTdsReaderGrayConfigBean.jdField_a_of_type_Int == -1);
    if (paramTdsReaderGrayConfigBean.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      TdsReaderGlobal.a(paramBoolean);
      return;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.tds.TdsReaderGrayConfigBean
 * JD-Core Version:    0.7.0.1
 */