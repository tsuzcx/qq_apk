package com.tencent.mobileqq.search.model;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unite.search.DynamicSearch.ResultItem;

public class NetSearchTemplateSubItem
  extends NetSearchTemplateBaseItem
{
  public CharSequence a;
  public String a;
  public CharSequence b;
  public boolean b;
  
  public NetSearchTemplateSubItem(String paramString, long paramLong, List paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void a(String paramString)
  {
    for (boolean bool = true;; bool = false) {
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_a_of_type_JavaLangCharSequence = SearchUtils.a(paramString.optJSONArray("leftText"));
        this.jdField_b_of_type_JavaLangCharSequence = SearchUtils.a(paramString.optJSONArray("rightText"));
        this.jdField_a_of_type_JavaLangString = paramString.optString("bgColor");
        if (paramString.optInt("needCenter") == 1)
        {
          this.jdField_b_of_type_Boolean = bool;
          return;
        }
      }
      catch (JSONException paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(c, 0, paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateSubItem
 * JD-Core Version:    0.7.0.1
 */