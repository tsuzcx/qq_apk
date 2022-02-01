package com.tencent.mobileqq.config.business.tendoc;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.json.JSONArray;
import org.json.JSONObject;

public class TencentDocDataLineTipsConfigBean
{
  private int jdField_a_of_type_Int = 0;
  private SparseArray<TencentDocDataLineTipsConfigBean.KeyWords> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private String jdField_a_of_type_JavaLangString = "";
  private List<TencentDocDataLineTipsConfigBean.TeamworkKeyWords> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = "";
  private Map<String, TencentDocDataLineTipsConfigBean.KeyWords> jdField_b_of_type_JavaUtilMap = new HashMap();
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString = "";
  private Map<String, String> jdField_c_of_type_JavaUtilMap = new HashMap();
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString = "";
  
  public static TencentDocDataLineTipsConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      return null;
    }
    Object localObject1 = paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString;
    paramArrayOfQConfItem = new TencentDocDataLineTipsConfigBean();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocDataLineTipsConfigBean", 2, "updateConfig json parse faild");
      }
      return paramArrayOfQConfItem;
    }
    JSONObject localJSONObject2;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    String str1;
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      localJSONObject2 = ((JSONObject)localObject1).optJSONObject("File");
      paramArrayOfQConfItem.jdField_a_of_type_Int = localJSONObject2.optInt("maxCount");
      paramArrayOfQConfItem.jdField_b_of_type_Int = localJSONObject2.optInt("insertDur");
      localObject2 = localJSONObject2.optJSONObject("fileType");
      localObject3 = new StringBuilder();
      localObject4 = ((JSONObject)localObject2).keys();
      localObject5 = new StringBuilder();
      while (((Iterator)localObject4).hasNext())
      {
        str1 = (String)((Iterator)localObject4).next();
        ((StringBuilder)localObject3).append(str1).append("|");
        String str2 = ((JSONObject)localObject2).getString(str1);
        paramArrayOfQConfItem.jdField_a_of_type_JavaUtilMap.put("fileType_" + str1, str2);
        ((StringBuilder)localObject5).append(str2).append("|");
        TencentDocDataLineTipsConfigBean.KeyWords localKeyWords = new TencentDocDataLineTipsConfigBean.KeyWords();
        localKeyWords.jdField_b_of_type_ArrayOfJavaLangString = a(str2);
        paramArrayOfQConfItem.jdField_b_of_type_JavaUtilMap.put(str1, localKeyWords);
        continue;
        return paramArrayOfQConfItem;
      }
    }
    catch (Exception localException)
    {
      QLog.e("TencentDocDataLineTipsConfigBean", 2, localException.toString());
      localException.printStackTrace();
    }
    JSONObject localJSONObject1;
    do
    {
      if (((StringBuilder)localObject5).length() > 0) {
        ((StringBuilder)localObject5).deleteCharAt(((StringBuilder)localObject5).length() - 1);
      }
      if (((StringBuilder)localObject3).length() > 0) {
        ((StringBuilder)localObject3).deleteCharAt(((StringBuilder)localObject3).length() - 1);
      }
      paramArrayOfQConfItem.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject3).toString();
      paramArrayOfQConfItem.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject5).toString();
      localJSONObject2 = localJSONObject2.optJSONObject("KeyWords");
      localObject2 = paramArrayOfQConfItem.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = localJSONObject2.optJSONObject((String)localObject3);
        localObject5 = (TencentDocDataLineTipsConfigBean.KeyWords)paramArrayOfQConfItem.jdField_b_of_type_JavaUtilMap.get(localObject3);
        str1 = ((JSONObject)localObject4).optString("key");
        ((TencentDocDataLineTipsConfigBean.KeyWords)localObject5).jdField_a_of_type_ArrayOfJavaLangString = a(str1);
        if (paramArrayOfQConfItem.jdField_c_of_type_Int == 1) {
          ((TencentDocDataLineTipsConfigBean.KeyWords)localObject5).jdField_a_of_type_JavaLangString = ((JSONObject)localObject4).optString("Tips1");
        }
        for (((TencentDocDataLineTipsConfigBean.KeyWords)localObject5).jdField_b_of_type_JavaLangString = ((JSONObject)localObject4).optString("Link1");; ((TencentDocDataLineTipsConfigBean.KeyWords)localObject5).jdField_b_of_type_JavaLangString = ((JSONObject)localObject4).optString("Link0"))
        {
          paramArrayOfQConfItem.jdField_b_of_type_JavaUtilMap.put(localObject3, localObject5);
          paramArrayOfQConfItem.jdField_c_of_type_JavaUtilMap.put("key_str_key_words" + (String)localObject3, str1);
          paramArrayOfQConfItem.jdField_c_of_type_JavaUtilMap.put("key_str_key_tips" + (String)localObject3, ((TencentDocDataLineTipsConfigBean.KeyWords)localObject5).jdField_a_of_type_JavaLangString);
          paramArrayOfQConfItem.jdField_c_of_type_JavaUtilMap.put("key_str_key_link" + (String)localObject3, ((TencentDocDataLineTipsConfigBean.KeyWords)localObject5).jdField_b_of_type_JavaLangString);
          break;
          ((TencentDocDataLineTipsConfigBean.KeyWords)localObject5).jdField_a_of_type_JavaLangString = ((JSONObject)localObject4).optString("Tips0");
        }
      }
      localJSONObject1 = localException.optJSONObject("Text");
    } while (localJSONObject1 == null);
    paramArrayOfQConfItem.jdField_c_of_type_JavaLangString = localJSONObject1.toString();
    if (localJSONObject1.optInt("textSwitch", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfQConfItem.jdField_a_of_type_Boolean = bool;
      a(localJSONObject1, paramArrayOfQConfItem);
      break;
    }
  }
  
  private static void a(JSONObject paramJSONObject, TencentDocDataLineTipsConfigBean paramTencentDocDataLineTipsConfigBean)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("template_list");
    int i = 0;
    if (i < localJSONArray.length())
    {
      int k = localJSONArray.getJSONObject(i).optInt("template_type", -1);
      TencentDocDataLineTipsConfigBean.KeyWords localKeyWords = new TencentDocDataLineTipsConfigBean.KeyWords();
      paramTencentDocDataLineTipsConfigBean.jdField_d_of_type_Int = paramJSONObject.optInt("containKeyword");
      if (paramTencentDocDataLineTipsConfigBean.jdField_d_of_type_Int == 1) {
        localKeyWords.jdField_a_of_type_JavaLangString = paramJSONObject.optString("Tips1");
      }
      for (localKeyWords.jdField_b_of_type_JavaLangString = paramJSONObject.optString("Link1");; localKeyWords.jdField_b_of_type_JavaLangString = paramJSONObject.optString("Link0"))
      {
        int j = k;
        if (k == -1) {
          j = i;
        }
        paramTencentDocDataLineTipsConfigBean.jdField_a_of_type_AndroidUtilSparseArray.put(j, localKeyWords);
        i += 1;
        break;
        localKeyWords.jdField_a_of_type_JavaLangString = paramJSONObject.optString("Tips0");
      }
    }
  }
  
  private static String[] a(String paramString)
  {
    int i = 0;
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, "|");
    if (!localStringTokenizer.hasMoreTokens())
    {
      if (QLog.isColorLevel()) {
        QLog.i("TencentDocDataLineTipsConfigBean", 1, "split String faild :" + paramString);
      }
      return new String[0];
    }
    paramString = new String[localStringTokenizer.countTokens()];
    while (localStringTokenizer.hasMoreTokens())
    {
      paramString[i] = localStringTokenizer.nextToken();
      i += 1;
    }
    return paramString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public List<TencentDocDataLineTipsConfigBean.TeamworkKeyWords> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public Map<String, TencentDocDataLineTipsConfigBean.KeyWords> a()
  {
    return this.jdField_b_of_type_JavaUtilMap;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null)
    {
      localObject = "";
      this.jdField_d_of_type_JavaLangString = ((String)localObject);
      if (paramJSONObject != null) {
        break label33;
      }
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      return;
      localObject = paramJSONObject.toString();
      break;
      try
      {
        label33:
        localObject = paramJSONObject.optJSONArray("template_list");
        if (paramJSONObject.optInt("retcode", -1) != 0)
        {
          this.jdField_a_of_type_Boolean = false;
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("TencentDocDataLineTipsConfigBean", 2, paramJSONObject.toString());
        return;
      }
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          paramJSONObject = ((JSONArray)localObject).getJSONObject(i);
          int k = paramJSONObject.optInt("template_type", -1);
          if (paramJSONObject.optJSONArray("infos") != null)
          {
            paramJSONObject = paramJSONObject.optJSONArray("infos");
            int j = 0;
            while (j < paramJSONObject.length())
            {
              JSONObject localJSONObject = paramJSONObject.getJSONObject(j);
              TencentDocDataLineTipsConfigBean.TeamworkKeyWords localTeamworkKeyWords = new TencentDocDataLineTipsConfigBean.TeamworkKeyWords();
              localTeamworkKeyWords.jdField_a_of_type_JavaLangString = localJSONObject.optString("template_name");
              localTeamworkKeyWords.jdField_a_of_type_Int = localJSONObject.optInt("template_id", -1);
              if (localTeamworkKeyWords.jdField_a_of_type_Int == -1) {
                QLog.d("TencentDocDataLineTipsConfigBean", 2, "template has no id");
              }
              localTeamworkKeyWords.jdField_b_of_type_Int = k;
              this.jdField_a_of_type_JavaUtilList.add(localTeamworkKeyWords);
              j += 1;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigBean
 * JD-Core Version:    0.7.0.1
 */