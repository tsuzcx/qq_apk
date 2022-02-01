package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmoticonTabSortConfBean
{
  private int a;
  public String a;
  public List<String> a;
  public List<String> b = new ArrayList();
  
  public EmoticonTabSortConfBean()
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
      QLog.d("EmoticonTabSortConfBean", 2, "parse S$EConfBean failed!", paramArrayOfQConfItem);
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
                break label377;
              }
              localArrayList.add(str);
              break label377;
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
                break label384;
              }
              localArrayList.add(str);
              break label384;
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
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse S$EConfBean: ");
        localStringBuilder.append((String)localObject);
        QLog.i("EmoticonTabSortConfBean", 2, localStringBuilder.toString());
      }
      for (;;)
      {
        i += 1;
        while (i >= k) {
          return localEmoticonTabSortConfBean;
        }
        localObject = paramArrayOfQConfItem[i];
        if (localObject != null) {
          break;
        }
      }
      label377:
      j += 1;
      continue;
      label384:
      j += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EmoticonTabSortConfBean{mChangeNewSettingStyle=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mSettingOrder=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(", mEntryOrder=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mGifEntranceIconUrl=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.EmoticonTabSortConfBean
 * JD-Core Version:    0.7.0.1
 */