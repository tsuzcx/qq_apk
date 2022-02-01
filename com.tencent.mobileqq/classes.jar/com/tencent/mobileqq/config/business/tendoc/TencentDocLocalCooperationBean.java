package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocLocalCooperationBean
{
  public List<TencentDocLocalCooperationBean.ViewOrEditInfo> a = new ArrayList();
  public Map<String, Long> b = new HashMap();
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  
  public static TencentDocLocalCooperationBean a(QConfItem[] paramArrayOfQConfItem)
  {
    TencentDocLocalCooperationBean localTencentDocLocalCooperationBean;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      localTencentDocLocalCooperationBean = new TencentDocLocalCooperationBean();
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].b);
        Object localObject;
        if (paramArrayOfQConfItem.has("report"))
        {
          localObject = paramArrayOfQConfItem.getJSONObject("report");
          localTencentDocLocalCooperationBean.c = ((JSONObject)localObject).optString("inviteTShow");
          localTencentDocLocalCooperationBean.d = ((JSONObject)localObject).optString("inviteTClick");
          localTencentDocLocalCooperationBean.e = ((JSONObject)localObject).optString("stateTShow");
          localTencentDocLocalCooperationBean.f = ((JSONObject)localObject).optString("stateTClick");
        }
        if (paramArrayOfQConfItem.has("viewTogether"))
        {
          localObject = new TencentDocLocalCooperationBean.ViewOrEditInfo(paramArrayOfQConfItem.getJSONObject("viewTogether"));
          ((TencentDocLocalCooperationBean.ViewOrEditInfo)localObject).e = false;
          localTencentDocLocalCooperationBean.a.add(localObject);
        }
        if (paramArrayOfQConfItem.has("editTogether"))
        {
          localObject = new TencentDocLocalCooperationBean.ViewOrEditInfo(paramArrayOfQConfItem.getJSONObject("editTogether"));
          ((TencentDocLocalCooperationBean.ViewOrEditInfo)localObject).e = true;
          localTencentDocLocalCooperationBean.a.add(localObject);
        }
        if (paramArrayOfQConfItem.has("viewPrivate"))
        {
          localObject = new TencentDocLocalCooperationBean.ViewOrEditInfo(paramArrayOfQConfItem.getJSONObject("viewPrivate"));
          ((TencentDocLocalCooperationBean.ViewOrEditInfo)localObject).f = true;
          localTencentDocLocalCooperationBean.a.add(localObject);
        }
        if (paramArrayOfQConfItem.has("editSupport"))
        {
          paramArrayOfQConfItem = paramArrayOfQConfItem.getJSONObject("editSupport");
          localObject = paramArrayOfQConfItem.keys();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            localTencentDocLocalCooperationBean.b.put(str, Long.valueOf(paramArrayOfQConfItem.getLong(str)));
          }
        }
        return localTencentDocLocalCooperationBean;
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        QLog.e("TencentDocLocalCooperationBean", 1, paramArrayOfQConfItem.getLocalizedMessage(), paramArrayOfQConfItem);
      }
    }
    return null;
  }
  
  public TencentDocLocalCooperationBean.ViewOrEditInfo a(String paramString)
  {
    paramString = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getNoDotExtension(paramString);
    int i = 0;
    while (i < this.a.size())
    {
      TencentDocLocalCooperationBean.ViewOrEditInfo localViewOrEditInfo = (TencentDocLocalCooperationBean.ViewOrEditInfo)this.a.get(i);
      if (localViewOrEditInfo.a(paramString)) {
        return localViewOrEditInfo;
      }
      i += 1;
    }
    return null;
  }
  
  public boolean b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.e;
    }
    return false;
  }
  
  public boolean c(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.f;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationBean
 * JD-Core Version:    0.7.0.1
 */