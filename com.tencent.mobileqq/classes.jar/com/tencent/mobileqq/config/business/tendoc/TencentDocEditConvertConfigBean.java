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

public class TencentDocEditConvertConfigBean
{
  private Map<String, List<TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem>> a = new HashMap();
  
  public static TencentDocEditConvertConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      return null;
    }
    localTencentDocEditConvertConfigBean = new TencentDocEditConvertConfigBean();
    try
    {
      paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].a);
      Iterator localIterator = paramArrayOfQConfItem.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONArray localJSONArray = paramArrayOfQConfItem.getJSONArray(str);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem.a(localJSONArray.getJSONObject(i)));
          i += 1;
        }
        localTencentDocEditConvertConfigBean.a.put(str, localArrayList);
      }
      return localTencentDocEditConvertConfigBean;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      QLog.e("TencentDocEditConvertConfigBean", 1, "parse fail", paramArrayOfQConfItem);
    }
  }
  
  public Map<String, List<TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigBean
 * JD-Core Version:    0.7.0.1
 */