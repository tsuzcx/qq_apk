package com.tencent.mobileqq.config.business.search;

import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class SearchRichConfBean
{
  private int jdField_a_of_type_Int = 0;
  private ArrayMap<String, ArrayList<SearchRichConfBean.RichBaseTemplate>> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(5);
  private int b = 1;
  private int c = 1;
  private int d = 1;
  private int e = 1;
  private int f = 1;
  
  public static SearchRichConfBean a()
  {
    return (SearchRichConfBean)QConfigManager.a().a(432);
  }
  
  public static SearchRichConfBean a(QConfItem paramQConfItem)
  {
    int i = 0;
    SearchRichConfBean localSearchRichConfBean = new SearchRichConfBean();
    if (paramQConfItem != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfBean", 2, "parse taskid->" + paramQConfItem.jdField_a_of_type_Int + " content->" + paramQConfItem.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        paramQConfItem = new JSONObject(paramQConfItem.jdField_a_of_type_JavaLangString);
        int j = paramQConfItem.optInt("switch", 0);
        int k = paramQConfItem.optInt("ftsEnableMsgSwitch", 1);
        int m = paramQConfItem.optInt("showMessageResult", 1);
        int n = paramQConfItem.optInt("ftsEnableSwitch", 1);
        int i1 = paramQConfItem.optInt("ftsEnableTroopSwitch", 1);
        int i2 = paramQConfItem.optInt("ftsEnableFtsFilter", 1);
        localSearchRichConfBean.a(j);
        localSearchRichConfBean.b(k);
        localSearchRichConfBean.c(m);
        localSearchRichConfBean.c = n;
        localSearchRichConfBean.e = i1;
        localSearchRichConfBean.f = i2;
        paramQConfItem = paramQConfItem.optJSONArray("templateinfo");
        if (paramQConfItem != null)
        {
          localArrayList1 = new ArrayList(10);
          localArrayList2 = new ArrayList(10);
          j = paramQConfItem.length();
          if (i >= j) {
            break label375;
          }
          JSONObject localJSONObject = paramQConfItem.optJSONObject(i);
          if (localJSONObject == null) {
            break label396;
          }
          SearchRichConfBean.RichBaseTemplate localRichBaseTemplate = new SearchRichConfBean.RichBaseTemplate();
          localRichBaseTemplate.jdField_a_of_type_Int = localJSONObject.optInt("templateid");
          localRichBaseTemplate.jdField_a_of_type_JavaLangString = localJSONObject.optString("templatetype");
          localRichBaseTemplate.c = localJSONObject.optString("templatever");
          localRichBaseTemplate.b = localJSONObject.optString("templatename");
          localRichBaseTemplate.d = localJSONObject.optString("templateview");
          if ("ark".equals(localRichBaseTemplate.jdField_a_of_type_JavaLangString)) {
            localArrayList1.add(localRichBaseTemplate);
          } else if ("native".equals(localRichBaseTemplate.jdField_a_of_type_JavaLangString)) {
            localArrayList2.add(localRichBaseTemplate);
          }
        }
      }
      catch (Exception paramQConfItem)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchRichConfBean", 2, "parse error->" + paramQConfItem.toString());
        }
      }
      return localSearchRichConfBean;
      label375:
      localSearchRichConfBean.a("ark", localArrayList1);
      localSearchRichConfBean.a("native", localArrayList2);
      return localSearchRichConfBean;
      label396:
      i += 1;
    }
  }
  
  public ArrayList<SearchRichConfBean.RichBaseTemplate> a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap != null) {
      return (ArrayList)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString);
    }
    return null;
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void a(String paramString, ArrayList<SearchRichConfBean.RichBaseTemplate> paramArrayList)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilArrayMap != null) && (paramString != null)) {
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(paramString, paramArrayList);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public boolean b()
  {
    return this.c == 1;
  }
  
  void c(int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean c()
  {
    return this.e == 1;
  }
  
  public boolean d()
  {
    return this.f == 1;
  }
  
  public boolean e()
  {
    return this.d == 1;
  }
  
  public boolean f()
  {
    return this.b == 1;
  }
  
  public String toString()
  {
    int i = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap != null) {}
    for (String str = this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.toString();; str = "null") {
      return String.format("mRichSwitch:%d  templateData:%s", new Object[] { Integer.valueOf(i), str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.search.SearchRichConfBean
 * JD-Core Version:    0.7.0.1
 */