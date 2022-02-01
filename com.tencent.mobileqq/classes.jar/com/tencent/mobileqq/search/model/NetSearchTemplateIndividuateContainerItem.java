package com.tencent.mobileqq.search.model;

import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;

public class NetSearchTemplateIndividuateContainerItem
  extends NetSearchTemplateBaseItem
{
  public List<NetSearchTemplateHorizontalBaseItem> a;
  private boolean b = false;
  
  public NetSearchTemplateIndividuateContainerItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void b(int paramInt)
  {
    if (paramInt > 0)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      if (this.i == 1106L)
      {
        MobileReportManager.getInstance().reportAction("", "", "platform898", "7", "1", 111, 1, System.currentTimeMillis());
        UniteSearchReportController.a(null, 0, this.p, "0X800BAC6", 0, 0, null, null);
      }
    }
  }
  
  public void e(int paramInt)
  {
    super.e(paramInt);
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((NetSearchTemplateBaseItem)((Iterator)localObject).next()).e(paramInt);
      }
    }
  }
  
  public void o_(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("items");
      if (this.a == null) {
        this.a = new ArrayList();
      } else {
        this.a.clear();
      }
      if (paramString == null) {
        return;
      }
      int i = 0;
      try
      {
        while (i < paramString.length())
        {
          localObject = paramString.getJSONObject(i);
          localObject = new NetSearchTemplateIndividuateOneItem(this.m, this.i, this.k, this.p, (JSONObject)localObject, this.af, (UnifySearchCommon.ResultItem)j());
          this.a.add(localObject);
          i += 1;
        }
        localObject = g;
      }
      catch (JSONException paramString)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("vas_search_parsejson, e = ");
      localStringBuilder.append(paramString);
      QLog.e((String)localObject, 2, localStringBuilder.toString());
      return;
    }
    catch (JSONException paramString)
    {
      Object localObject;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localObject = g;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("vas_search_parsejson, e = ");
        localStringBuilder.append(paramString);
        QLog.e((String)localObject, 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateIndividuateContainerItem
 * JD-Core Version:    0.7.0.1
 */