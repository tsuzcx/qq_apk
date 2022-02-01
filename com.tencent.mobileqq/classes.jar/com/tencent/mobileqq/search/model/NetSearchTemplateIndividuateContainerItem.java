package com.tencent.mobileqq.search.model;

import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;

public class NetSearchTemplateIndividuateContainerItem
  extends NetSearchTemplateBaseItem
{
  public List<NetSearchTemplateHorizontalBaseItem> a;
  private boolean b;
  
  public NetSearchTemplateIndividuateContainerItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      if (this.jdField_b_of_type_Boolean) {
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_Long == 1106L)
      {
        MobileReportManager.getInstance().reportAction("", "", "platform898", "7", "1", 111, 1, System.currentTimeMillis());
        UniteSearchReportController.a(null, 0, this.jdField_c_of_type_Int, "0X800BAC6", 0, 0, null, null);
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("items");
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      } else {
        this.jdField_a_of_type_JavaUtilList.clear();
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
          localObject = new NetSearchTemplateIndividuateOneItem(this.g, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_Int, (JSONObject)localObject, this.u, (UnifySearchCommon.ResultItem)a());
          this.jdField_a_of_type_JavaUtilList.add(localObject);
          i += 1;
        }
        localObject = jdField_c_of_type_JavaLangString;
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
        localObject = jdField_c_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("vas_search_parsejson, e = ");
        localStringBuilder.append(paramString);
        QLog.e((String)localObject, 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateIndividuateContainerItem
 * JD-Core Version:    0.7.0.1
 */