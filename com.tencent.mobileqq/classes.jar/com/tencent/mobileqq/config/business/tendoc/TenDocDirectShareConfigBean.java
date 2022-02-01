package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.QConfItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TenDocDirectShareConfigBean
{
  private List<String> a = new ArrayList();
  private String b = HardCodeUtil.a(2131912153);
  private String c = "";
  
  public static TenDocDirectShareConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      TenDocDirectShareConfigBean localTenDocDirectShareConfigBean = new TenDocDirectShareConfigBean();
      int i = 0;
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].b);
        JSONArray localJSONArray = paramArrayOfQConfItem.getJSONArray("suffix");
        while (i < localJSONArray.length())
        {
          localTenDocDirectShareConfigBean.a.add(localJSONArray.getString(i));
          i += 1;
        }
        localTenDocDirectShareConfigBean.b = paramArrayOfQConfItem.getString("title");
        localTenDocDirectShareConfigBean.c = paramArrayOfQConfItem.getString("desc");
        return localTenDocDirectShareConfigBean;
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
        return localTenDocDirectShareConfigBean;
      }
    }
    return null;
  }
  
  public List<String> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TenDocDirectShareConfigBean
 * JD-Core Version:    0.7.0.1
 */