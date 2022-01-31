package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unite.search.DynamicSearch.ResultItem;

public class NetSearchTemplateHorizontalContainerItem
  extends NetSearchTemplateBaseItem
{
  public static final String a;
  public ArrayList a;
  protected final String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = NetSearchTemplateHorizontalContainerItem.class.getSimpleName();
  }
  
  public NetSearchTemplateHorizontalContainerItem(String paramString, long paramLong, List paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
    this.jdField_b_of_type_JavaLangString = "itemList";
  }
  
  public void a(View paramView) {}
  
  public void a(String paramString)
  {
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONObject(paramString).getJSONArray("itemList");
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      } else {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
    }
    catch (JSONException paramString)
    {
      if (!QLog.isColorLevel()) {
        break label221;
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "parseLayoutExtensions, e = " + paramString);
    return;
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i >= localJSONArray.length()) || (i >= 5)) {
          break label221;
        }
        localJSONObject = localJSONArray.getJSONObject(i);
        paramString = null;
        j = localJSONObject.optInt("type");
        switch (j)
        {
        case 1: 
          if (paramString == null) {
            break label225;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        }
      }
      catch (JSONException paramString)
      {
        JSONObject localJSONObject;
        int j;
        if (!QLog.isColorLevel()) {
          break label221;
        }
      }
      paramString = new NetSearchTemplateHorizontalOneItem(this.g, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_Int, localJSONObject, j, this.jdField_a_of_type_PbUniteSearchDynamicSearch$ResultItem);
      continue;
      QLog.e(jdField_a_of_type_JavaLangString, 2, "parseLayoutExtensions, e = " + paramString);
      return;
      if (localJSONArray != null) {
        break;
      }
      label221:
      return;
      continue;
      label225:
      i += 1;
    }
  }
  
  public int c()
  {
    return 2;
  }
  
  public int d()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalContainerItem
 * JD-Core Version:    0.7.0.1
 */