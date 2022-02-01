package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
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
  public String a;
  public List<TencentDocLocalCooperationBean.ViewOrEditInfo> a;
  public Map<String, Long> a;
  public String b = "";
  public String c = "";
  public String d = "";
  
  public TencentDocLocalCooperationBean()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static TencentDocLocalCooperationBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      return null;
    }
    localTencentDocLocalCooperationBean = new TencentDocLocalCooperationBean();
    try
    {
      paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
      Object localObject;
      if (paramArrayOfQConfItem.has("report"))
      {
        localObject = paramArrayOfQConfItem.getJSONObject("report");
        localTencentDocLocalCooperationBean.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("inviteTShow");
        localTencentDocLocalCooperationBean.b = ((JSONObject)localObject).optString("inviteTClick");
        localTencentDocLocalCooperationBean.c = ((JSONObject)localObject).optString("stateTShow");
        localTencentDocLocalCooperationBean.d = ((JSONObject)localObject).optString("stateTClick");
      }
      if (paramArrayOfQConfItem.has("viewTogether"))
      {
        localObject = new TencentDocLocalCooperationBean.ViewOrEditInfo(paramArrayOfQConfItem.getJSONObject("viewTogether"));
        ((TencentDocLocalCooperationBean.ViewOrEditInfo)localObject).a = false;
        localTencentDocLocalCooperationBean.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfQConfItem.has("editTogether"))
      {
        localObject = new TencentDocLocalCooperationBean.ViewOrEditInfo(paramArrayOfQConfItem.getJSONObject("editTogether"));
        ((TencentDocLocalCooperationBean.ViewOrEditInfo)localObject).a = true;
        localTencentDocLocalCooperationBean.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfQConfItem.has("viewPrivate"))
      {
        localObject = new TencentDocLocalCooperationBean.ViewOrEditInfo(paramArrayOfQConfItem.getJSONObject("viewPrivate"));
        ((TencentDocLocalCooperationBean.ViewOrEditInfo)localObject).b = true;
        localTencentDocLocalCooperationBean.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      if (paramArrayOfQConfItem.has("editSupport"))
      {
        paramArrayOfQConfItem = paramArrayOfQConfItem.getJSONObject("editSupport");
        localObject = paramArrayOfQConfItem.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          localTencentDocLocalCooperationBean.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(paramArrayOfQConfItem.getLong(str)));
        }
      }
      return localTencentDocLocalCooperationBean;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      QLog.e("TencentDocLocalCooperationBean", 1, paramArrayOfQConfItem.getLocalizedMessage(), paramArrayOfQConfItem);
    }
  }
  
  public TencentDocLocalCooperationBean.ViewOrEditInfo a(String paramString)
  {
    paramString = TeamWorkUtils.a(paramString);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      TencentDocLocalCooperationBean.ViewOrEditInfo localViewOrEditInfo = (TencentDocLocalCooperationBean.ViewOrEditInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localViewOrEditInfo.a(paramString)) {
        return localViewOrEditInfo;
      }
      i += 1;
    }
    return null;
  }
  
  public boolean a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.a;
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.b;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationBean
 * JD-Core Version:    0.7.0.1
 */