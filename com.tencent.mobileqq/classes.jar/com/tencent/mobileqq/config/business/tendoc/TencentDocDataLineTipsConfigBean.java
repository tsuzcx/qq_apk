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
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      boolean bool = false;
      Object localObject1 = paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString;
      paramArrayOfQConfItem = new TencentDocDataLineTipsConfigBean();
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TencentDocDataLineTipsConfigBean", 2, "updateConfig json parse faild");
        }
        return paramArrayOfQConfItem;
      }
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        JSONObject localJSONObject = ((JSONObject)localObject1).optJSONObject("File");
        paramArrayOfQConfItem.jdField_a_of_type_Int = localJSONObject.optInt("maxCount");
        paramArrayOfQConfItem.jdField_b_of_type_Int = localJSONObject.optInt("insertDur");
        Object localObject2 = localJSONObject.optJSONObject("fileType");
        Object localObject3 = new StringBuilder();
        Object localObject4 = ((JSONObject)localObject2).keys();
        Object localObject5 = new StringBuilder();
        Object localObject6;
        Object localObject7;
        while (((Iterator)localObject4).hasNext())
        {
          localObject6 = (String)((Iterator)localObject4).next();
          ((StringBuilder)localObject3).append((String)localObject6);
          ((StringBuilder)localObject3).append("|");
          localObject7 = ((JSONObject)localObject2).getString((String)localObject6);
          Object localObject8 = paramArrayOfQConfItem.jdField_a_of_type_JavaUtilMap;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("fileType_");
          localStringBuilder.append((String)localObject6);
          ((Map)localObject8).put(localStringBuilder.toString(), localObject7);
          ((StringBuilder)localObject5).append((String)localObject7);
          ((StringBuilder)localObject5).append("|");
          localObject8 = new TencentDocDataLineTipsConfigBean.KeyWords();
          ((TencentDocDataLineTipsConfigBean.KeyWords)localObject8).jdField_b_of_type_ArrayOfJavaLangString = a((String)localObject7);
          paramArrayOfQConfItem.jdField_b_of_type_JavaUtilMap.put(localObject6, localObject8);
        }
        if (((StringBuilder)localObject5).length() > 0) {
          ((StringBuilder)localObject5).deleteCharAt(((StringBuilder)localObject5).length() - 1);
        }
        if (((StringBuilder)localObject3).length() > 0) {
          ((StringBuilder)localObject3).deleteCharAt(((StringBuilder)localObject3).length() - 1);
        }
        paramArrayOfQConfItem.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject3).toString();
        paramArrayOfQConfItem.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject5).toString();
        localJSONObject = localJSONObject.optJSONObject("KeyWords");
        localObject2 = paramArrayOfQConfItem.jdField_b_of_type_JavaUtilMap.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject6 = localJSONObject.optJSONObject((String)localObject3);
          localObject4 = (TencentDocDataLineTipsConfigBean.KeyWords)paramArrayOfQConfItem.jdField_b_of_type_JavaUtilMap.get(localObject3);
          localObject5 = ((JSONObject)localObject6).optString("key");
          ((TencentDocDataLineTipsConfigBean.KeyWords)localObject4).jdField_a_of_type_ArrayOfJavaLangString = a((String)localObject5);
          if (paramArrayOfQConfItem.jdField_c_of_type_Int == 1)
          {
            ((TencentDocDataLineTipsConfigBean.KeyWords)localObject4).jdField_a_of_type_JavaLangString = ((JSONObject)localObject6).optString("Tips1");
            ((TencentDocDataLineTipsConfigBean.KeyWords)localObject4).jdField_b_of_type_JavaLangString = ((JSONObject)localObject6).optString("Link1");
          }
          else
          {
            ((TencentDocDataLineTipsConfigBean.KeyWords)localObject4).jdField_a_of_type_JavaLangString = ((JSONObject)localObject6).optString("Tips0");
            ((TencentDocDataLineTipsConfigBean.KeyWords)localObject4).jdField_b_of_type_JavaLangString = ((JSONObject)localObject6).optString("Link0");
          }
          paramArrayOfQConfItem.jdField_b_of_type_JavaUtilMap.put(localObject3, localObject4);
          localObject6 = paramArrayOfQConfItem.jdField_c_of_type_JavaUtilMap;
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append("key_str_key_words");
          ((StringBuilder)localObject7).append((String)localObject3);
          ((Map)localObject6).put(((StringBuilder)localObject7).toString(), localObject5);
          localObject5 = paramArrayOfQConfItem.jdField_c_of_type_JavaUtilMap;
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("key_str_key_tips");
          ((StringBuilder)localObject6).append((String)localObject3);
          ((Map)localObject5).put(((StringBuilder)localObject6).toString(), ((TencentDocDataLineTipsConfigBean.KeyWords)localObject4).jdField_a_of_type_JavaLangString);
          localObject5 = paramArrayOfQConfItem.jdField_c_of_type_JavaUtilMap;
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("key_str_key_link");
          ((StringBuilder)localObject6).append((String)localObject3);
          ((Map)localObject5).put(((StringBuilder)localObject6).toString(), ((TencentDocDataLineTipsConfigBean.KeyWords)localObject4).jdField_b_of_type_JavaLangString);
        }
        localObject1 = ((JSONObject)localObject1).optJSONObject("Text");
        if (localObject1 != null)
        {
          paramArrayOfQConfItem.jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).toString();
          if (((JSONObject)localObject1).optInt("textSwitch", 0) == 1) {
            bool = true;
          }
          paramArrayOfQConfItem.jdField_a_of_type_Boolean = bool;
          a((JSONObject)localObject1, paramArrayOfQConfItem);
          return paramArrayOfQConfItem;
        }
      }
      catch (Exception localException)
      {
        QLog.e("TencentDocDataLineTipsConfigBean", 2, localException.toString());
        localException.printStackTrace();
      }
      return paramArrayOfQConfItem;
    }
    return null;
  }
  
  private static void a(JSONObject paramJSONObject, TencentDocDataLineTipsConfigBean paramTencentDocDataLineTipsConfigBean)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("template_list");
    int i = 0;
    while (i < localJSONArray.length())
    {
      int k = localJSONArray.getJSONObject(i).optInt("template_type", -1);
      TencentDocDataLineTipsConfigBean.KeyWords localKeyWords = new TencentDocDataLineTipsConfigBean.KeyWords();
      paramTencentDocDataLineTipsConfigBean.jdField_d_of_type_Int = paramJSONObject.optInt("containKeyword");
      if (paramTencentDocDataLineTipsConfigBean.jdField_d_of_type_Int == 1)
      {
        localKeyWords.jdField_a_of_type_JavaLangString = paramJSONObject.optString("Tips1");
        localKeyWords.jdField_b_of_type_JavaLangString = paramJSONObject.optString("Link1");
      }
      else
      {
        localKeyWords.jdField_a_of_type_JavaLangString = paramJSONObject.optString("Tips0");
        localKeyWords.jdField_b_of_type_JavaLangString = paramJSONObject.optString("Link0");
      }
      int j = k;
      if (k == -1) {
        j = i;
      }
      paramTencentDocDataLineTipsConfigBean.jdField_a_of_type_AndroidUtilSparseArray.put(j, localKeyWords);
      i += 1;
    }
  }
  
  private static String[] a(String paramString)
  {
    Object localObject = new StringTokenizer(paramString, "|");
    boolean bool = ((StringTokenizer)localObject).hasMoreTokens();
    int i = 0;
    if (!bool)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("split String faild :");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("TencentDocDataLineTipsConfigBean", 1, ((StringBuilder)localObject).toString());
      }
      return new String[0];
    }
    paramString = new String[((StringTokenizer)localObject).countTokens()];
    while (((StringTokenizer)localObject).hasMoreTokens())
    {
      paramString[i] = ((StringTokenizer)localObject).nextToken();
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
    if (paramJSONObject == null) {
      localObject = "";
    } else {
      localObject = paramJSONObject.toString();
    }
    this.jdField_d_of_type_JavaLangString = ((String)localObject);
    if (paramJSONObject == null)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = paramJSONObject.optJSONArray("template_list");
        if (paramJSONObject.optInt("retcode", -1) == 0) {
          break label217;
        }
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      catch (Exception paramJSONObject)
      {
        int k;
        int j;
        JSONObject localJSONObject;
        TencentDocDataLineTipsConfigBean.TeamworkKeyWords localTeamworkKeyWords;
        QLog.e("TencentDocDataLineTipsConfigBean", 2, paramJSONObject.toString());
      }
      if (i < ((JSONArray)localObject).length())
      {
        paramJSONObject = ((JSONArray)localObject).getJSONObject(i);
        k = paramJSONObject.optInt("template_type", -1);
        if (paramJSONObject.optJSONArray("infos") != null)
        {
          paramJSONObject = paramJSONObject.optJSONArray("infos");
          j = 0;
          if (j < paramJSONObject.length())
          {
            localJSONObject = paramJSONObject.getJSONObject(j);
            localTeamworkKeyWords = new TencentDocDataLineTipsConfigBean.TeamworkKeyWords();
            localTeamworkKeyWords.jdField_a_of_type_JavaLangString = localJSONObject.optString("template_name");
            localTeamworkKeyWords.jdField_a_of_type_Int = localJSONObject.optInt("template_id", -1);
            if (localTeamworkKeyWords.jdField_a_of_type_Int == -1) {
              QLog.d("TencentDocDataLineTipsConfigBean", 2, "template has no id");
            }
            localTeamworkKeyWords.jdField_b_of_type_Int = k;
            this.jdField_a_of_type_JavaUtilList.add(localTeamworkKeyWords);
            j += 1;
            continue;
          }
        }
        i += 1;
      }
      else
      {
        label217:
        while (localObject == null) {
          return;
        }
        i = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigBean
 * JD-Core Version:    0.7.0.1
 */