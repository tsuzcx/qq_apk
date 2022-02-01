package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmoticonSearchTagsConfProcessor$EmoticonSearchTagConfBean
{
  public List<String> a = new ArrayList();
  
  public static EmoticonSearchTagConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    EmoticonSearchTagConfBean localEmoticonSearchTagConfBean = new EmoticonSearchTagConfBean();
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
      QLog.d("EmoticonSearchTagsConfProcessor", 2, "parse S$EConfBean failed!", paramArrayOfQConfItem);
    }
    Object localObject1 = ((QConfItem)localObject1).a;
    bool = TextUtils.isEmpty((CharSequence)localObject1);
    if (!bool)
    {
      try
      {
        Object localObject2 = new JSONObject((String)localObject1);
        if (((JSONObject)localObject2).has("keyWords"))
        {
          localObject2 = ((JSONObject)localObject2).optJSONArray("keyWords");
          int j = 0;
          while (j < ((JSONArray)localObject2).length())
          {
            localEmoticonSearchTagConfBean.a.add(((JSONArray)localObject2).optString(j, ""));
            j += 1;
          }
        }
        if (!QLog.isColorLevel()) {
          break label173;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      QLog.i("EmoticonSearchTagsConfProcessor", 2, "parse S$EConfBean: " + (String)localObject1);
    }
    label173:
    label178:
    for (;;)
    {
      return localEmoticonSearchTagConfBean;
      for (;;)
      {
        if (i >= k) {
          break label178;
        }
        localObject1 = paramArrayOfQConfItem[i];
        if (localObject1 != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("mConfig:");
    if (this.a == null) {}
    for (String str = "null";; str = this.a.toString())
    {
      localStringBuilder.append(str);
      return super.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.EmoticonSearchTagsConfProcessor.EmoticonSearchTagConfBean
 * JD-Core Version:    0.7.0.1
 */