package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmoticonTabSortConfProcessor$EmoticonTabSortConfBean
{
  private int a;
  public String a;
  public List<String> a;
  public List<String> b = new ArrayList();
  
  public EmoticonTabSortConfProcessor$EmoticonTabSortConfBean()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static EmoticonTabSortConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    EmoticonTabSortConfBean localEmoticonTabSortConfBean = new EmoticonTabSortConfBean();
    int k;
    int i;
    try
    {
      k = paramArrayOfQConfItem.length;
      i = 0;
    }
    catch (Throwable paramArrayOfQConfItem)
    {
      boolean bool;
      QLog.d("EmoticonTabSortConfProcessor", 2, "parse S$EConfBean failed!", paramArrayOfQConfItem);
    }
    Object localObject = ((QConfItem)localObject).jdField_a_of_type_JavaLangString;
    bool = TextUtils.isEmpty((CharSequence)localObject);
    if (!bool) {}
    for (;;)
    {
      int j;
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject);
        if (localJSONObject.has("setting_change_style")) {
          localEmoticonTabSortConfBean.jdField_a_of_type_Int = localJSONObject.optInt("setting_change_style", 0);
        }
        ArrayList localArrayList;
        JSONArray localJSONArray;
        String str;
        if (localJSONObject.has("setting_orders"))
        {
          localArrayList = new ArrayList();
          localJSONArray = localJSONObject.optJSONArray("setting_orders");
          if (localJSONArray != null)
          {
            j = 0;
            if (j < localJSONArray.length())
            {
              str = localJSONArray.getString(j);
              if (localArrayList.contains(str)) {
                break label364;
              }
              localArrayList.add(str);
              break label364;
            }
          }
          localEmoticonTabSortConfBean.jdField_a_of_type_JavaUtilList.clear();
          localEmoticonTabSortConfBean.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
        }
        if (localJSONObject.has("face_orders"))
        {
          localArrayList = new ArrayList();
          localJSONArray = localJSONObject.optJSONArray("face_orders");
          if (localJSONArray != null)
          {
            j = 0;
            if (j < localJSONArray.length())
            {
              str = localJSONArray.getString(j);
              if (localArrayList.contains(str)) {
                break label371;
              }
              localArrayList.add(str);
              break label371;
            }
          }
          localEmoticonTabSortConfBean.b.clear();
          localEmoticonTabSortConfBean.b.addAll(localArrayList);
        }
        if (localJSONObject.has("gif_entrance_icon_url")) {
          localEmoticonTabSortConfBean.jdField_a_of_type_JavaLangString = localJSONObject.optString("gif_entrance_icon_url");
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.i("EmoticonTabSortConfProcessor", 2, "parse S$EConfBean: " + (String)localObject);
        break label357;
        return localEmoticonTabSortConfBean;
      }
      for (;;)
      {
        if (i >= k) {
          break label362;
        }
        localObject = paramArrayOfQConfItem[i];
        if (localObject != null) {
          break;
        }
        label357:
        i += 1;
      }
      label362:
      continue;
      label364:
      j += 1;
      continue;
      label371:
      j += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public String toString()
  {
    return "EmoticonTabSortConfBean{mChangeNewSettingStyle=" + this.jdField_a_of_type_Int + ", mSettingOrder=" + this.jdField_a_of_type_JavaUtilList + ", mEntryOrder=" + this.b + ", mGifEntranceIconUrl=" + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.EmoticonTabSortConfProcessor.EmoticonTabSortConfBean
 * JD-Core Version:    0.7.0.1
 */