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
    int i = 0;
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      return null;
    }
    localTencentDocFormKeyWordsBean = new TencentDocFormKeyWordsBean();
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
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    TencentDocFormKeyWordsBean.KeyWordsInfo localKeyWordsInfo;
    String str;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localKeyWordsInfo = (TencentDocFormKeyWordsBean.KeyWordsInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localKeyWordsInfo.a == null) {
        break label156;
      }
      j = 0;
      if (j >= localKeyWordsInfo.a.length) {
        break label156;
      }
      str = localKeyWordsInfo.a[j];
      if ((paramString == null) || (paramString.indexOf(str) < 0)) {
        break label133;
      }
    }
    label133:
    label149:
    label156:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        if (localKeyWordsInfo.b != null)
        {
          j = 0;
          for (;;)
          {
            if (j >= localKeyWordsInfo.b.length) {
              break label149;
            }
            str = localKeyWordsInfo.b[j];
            if ((paramString != null) && (paramString.indexOf(str) >= 0))
            {
              bool1 = true;
              return bool1;
              j += 1;
              break;
            }
            j += 1;
          }
        }
        return true;
      }
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocFormKeyWordsBean
 * JD-Core Version:    0.7.0.1
 */