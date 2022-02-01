package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;
import unite.DynamicSearch.ResultItem;

public class NetSearchTemplateHorizontalContainerItem
  extends NetSearchTemplateBaseItem
{
  public static final String a = "NetSearchTemplateHorizontalContainerItem";
  public ArrayList<NetSearchTemplateHorizontalBaseItem> a;
  protected final String b;
  
  public NetSearchTemplateHorizontalContainerItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
    this.jdField_b_of_type_JavaLangString = "itemList";
  }
  
  public NetSearchTemplateHorizontalContainerItem(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
    this.jdField_b_of_type_JavaLangString = "itemList";
  }
  
  public void a(View paramView) {}
  
  public void a(String paramString)
  {
    try
    {
      localObject1 = new JSONObject(paramString).getJSONArray("itemList");
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      } else {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      if (localObject1 == null) {
        return;
      }
      int i = 0;
      try
      {
        while ((i < ((JSONArray)localObject1).length()) && (i < 5))
        {
          localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          paramString = null;
          int j = ((JSONObject)localObject2).optInt("type");
          if (j == 1) {
            if ((a() instanceof DynamicSearch.ResultItem)) {
              paramString = new NetSearchTemplateHorizontalOneItem(this.g, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaUtilList, this.c, (JSONObject)localObject2, j, (DynamicSearch.ResultItem)a(), i + 1);
            } else if ((a() instanceof UnifySearchCommon.ResultItem)) {
              paramString = new NetSearchTemplateHorizontalOneItem(this.g, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaUtilList, this.c, (JSONObject)localObject2, j, (UnifySearchCommon.ResultItem)a(), i + 1);
            }
          }
          if (paramString != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
          }
          i += 1;
        }
        localObject1 = jdField_a_of_type_JavaLangString;
      }
      catch (JSONException paramString)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parseLayoutExtensions, e = ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      return;
    }
    catch (JSONException paramString)
    {
      Object localObject1;
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parseLayoutExtensions, e = ");
        ((StringBuilder)localObject2).append(paramString);
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public int b()
  {
    return 2;
  }
  
  public int f_()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalContainerItem
 * JD-Core Version:    0.7.0.1
 */