package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocPreviewConfigBean
{
  private Map<String, Long> a = new HashMap();
  
  public static TencentDocPreviewConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    TencentDocPreviewConfigBean localTencentDocPreviewConfigBean;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      localTencentDocPreviewConfigBean = new TencentDocPreviewConfigBean();
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].b);
        Iterator localIterator = paramArrayOfQConfItem.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localTencentDocPreviewConfigBean.a.put(str, Long.valueOf(paramArrayOfQConfItem.getLong(str)));
        }
        return localTencentDocPreviewConfigBean;
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        QLog.e("TencentDocPreviewConfigBean", 1, paramArrayOfQConfItem.getLocalizedMessage(), paramArrayOfQConfItem);
      }
    }
    return null;
  }
  
  public Map<String, Long> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigBean
 * JD-Core Version:    0.7.0.1
 */