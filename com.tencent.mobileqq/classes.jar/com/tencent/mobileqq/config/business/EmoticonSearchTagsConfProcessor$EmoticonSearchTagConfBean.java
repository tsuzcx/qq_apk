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
    if (!bool) {
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
        StringBuilder localStringBuilder;
        i += 1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("parse S$EConfBean: ");
          localStringBuilder.append((String)localObject1);
          QLog.i("EmoticonSearchTagsConfProcessor", 2, localStringBuilder.toString());
        }
      }
    }
    for (;;)
    {
      while (i >= k) {
        return localEmoticonSearchTagConfBean;
      }
      localObject1 = paramArrayOfQConfItem[i];
      if (localObject1 != null) {
        break;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mConfig:");
    Object localObject = this.a;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = localObject.toString();
    }
    localStringBuilder.append((String)localObject);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.EmoticonSearchTagsConfProcessor.EmoticonSearchTagConfBean
 * JD-Core Version:    0.7.0.1
 */