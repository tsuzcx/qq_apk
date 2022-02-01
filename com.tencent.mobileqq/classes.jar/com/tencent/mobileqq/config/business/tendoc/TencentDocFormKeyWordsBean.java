package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocFormKeyWordsBean
{
  public List<TencentDocFormKeyWordsBean.KeyWordsInfo> a;
  public Map<String, Long> a;
  
  public TencentDocFormKeyWordsBean()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static TencentDocFormKeyWordsBean a(QConfItem[] paramArrayOfQConfItem)
  {
    TencentDocFormKeyWordsBean localTencentDocFormKeyWordsBean;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      localTencentDocFormKeyWordsBean = new TencentDocFormKeyWordsBean();
      int i = 0;
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].a);
        Object localObject1;
        Object localObject2;
        if (paramArrayOfQConfItem.has("collection"))
        {
          localObject1 = paramArrayOfQConfItem.getJSONArray("collection");
          while (i < ((JSONArray)localObject1).length())
          {
            localObject2 = new TencentDocFormKeyWordsBean.KeyWordsInfo(((JSONArray)localObject1).getJSONObject(i));
            localTencentDocFormKeyWordsBean.jdField_a_of_type_JavaUtilList.add(localObject2);
            i += 1;
          }
        }
        if (paramArrayOfQConfItem.has("collectionTypeAndSize"))
        {
          paramArrayOfQConfItem = paramArrayOfQConfItem.getJSONObject("collectionTypeAndSize");
          localObject1 = paramArrayOfQConfItem.keys();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            localTencentDocFormKeyWordsBean.jdField_a_of_type_JavaUtilMap.put(localObject2, Long.valueOf(paramArrayOfQConfItem.getLong((String)localObject2)));
          }
        }
        return localTencentDocFormKeyWordsBean;
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        QLog.e("TencentDocFormKeyWordsBean", 1, paramArrayOfQConfItem.getLocalizedMessage(), paramArrayOfQConfItem);
      }
    }
    return null;
  }
  
  public boolean a(String paramString)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      TencentDocFormKeyWordsBean.KeyWordsInfo localKeyWordsInfo = (TencentDocFormKeyWordsBean.KeyWordsInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      String str;
      if (localKeyWordsInfo.a != null)
      {
        j = 0;
        while (j < localKeyWordsInfo.a.length)
        {
          str = localKeyWordsInfo.a[j];
          if ((paramString != null) && (paramString.indexOf(str) >= 0))
          {
            j = 1;
            break label86;
          }
          j += 1;
        }
      }
      int j = 0;
      label86:
      if (j != 0)
      {
        if (localKeyWordsInfo.b != null)
        {
          j = 0;
          while (j < localKeyWordsInfo.b.length)
          {
            str = localKeyWordsInfo.b[j];
            if ((paramString != null) && (paramString.indexOf(str) >= 0)) {
              return true;
            }
            j += 1;
          }
        }
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocFormKeyWordsBean
 * JD-Core Version:    0.7.0.1
 */