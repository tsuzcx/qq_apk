package com.tencent.mobileqq.troop.homework.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PublishHwkThirdPartyEntryConfig
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = false;
  private String c = "";
  private String d = "";
  
  public PublishHwkThirdPartyEntryConfig() {}
  
  public PublishHwkThirdPartyEntryConfig(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public static PublishHwkThirdPartyEntryConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject5 = "";
    Object localObject4 = localObject5;
    Object localObject6 = localObject4;
    Object localObject9 = localObject6;
    int n = 0;
    int k = 0;
    int i = 0;
    while (n < paramArrayOfQConfItem.length)
    {
      Object localObject2 = paramArrayOfQConfItem[n].jdField_a_of_type_JavaLangString;
      int j;
      Object localObject1;
      Object localObject8;
      Object localObject10;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        j = k;
        localObject1 = localObject5;
        localObject8 = localObject6;
        localObject10 = localObject9;
      }
      else
      {
        j = k;
        int m = i;
        localObject1 = localObject5;
        Object localObject7 = localObject4;
        localObject8 = localObject6;
        try
        {
          localObject10 = new JSONObject((String)localObject2);
          j = k;
          m = i;
          localObject1 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject6;
          k = ((JSONObject)localObject10).optInt("globalOpen", 0);
          j = k;
          m = i;
          localObject1 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject6;
          int i1 = ((JSONObject)localObject10).optInt("globalOpenTXDoc", 0);
          j = k;
          m = i1;
          localObject1 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject6;
          JSONObject localJSONObject = ((JSONObject)localObject10).optJSONObject("weikeUrls");
          Object localObject3 = localObject5;
          localObject2 = localObject4;
          if (localJSONObject != null)
          {
            j = k;
            m = i1;
            localObject1 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject6;
            localObject3 = localJSONObject.optString("choose_exam");
            j = k;
            m = i1;
            localObject1 = localObject3;
            localObject7 = localObject4;
            localObject8 = localObject6;
            localObject2 = localJSONObject.optString("get_exam_info");
          }
          j = k;
          m = i1;
          localObject1 = localObject3;
          localObject7 = localObject2;
          localObject8 = localObject6;
          localJSONObject = ((JSONObject)localObject10).optJSONObject("txDocUrls");
          j = k;
          i = i1;
          localObject1 = localObject3;
          localObject4 = localObject2;
          localObject8 = localObject6;
          localObject10 = localObject9;
          if (localJSONObject != null)
          {
            j = k;
            m = i1;
            localObject1 = localObject3;
            localObject7 = localObject2;
            localObject8 = localObject6;
            localObject5 = localJSONObject.optString("choose_doc");
            j = k;
            m = i1;
            localObject1 = localObject3;
            localObject7 = localObject2;
            localObject8 = localObject5;
            localObject10 = localJSONObject.optString("get_doc_info");
            j = k;
            i = i1;
            localObject1 = localObject3;
            localObject4 = localObject2;
            localObject8 = localObject5;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          localObject10 = localObject9;
          localObject4 = localObject7;
          i = m;
        }
      }
      n += 1;
      k = j;
      localObject5 = localObject1;
      localObject6 = localObject8;
      localObject9 = localObject10;
    }
    boolean bool1;
    if (k == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (i == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    paramArrayOfQConfItem = new PublishHwkThirdPartyEntryConfig(bool1, (String)localObject5, localObject4, bool2, localObject6, localObject9);
    if (QLog.isColorLevel()) {
      QLog.i("PublishHwkThirdPartyEntryConfig", 2, paramArrayOfQConfItem.toString());
    }
    return paramArrayOfQConfItem;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsGlobalOpenWeiKe:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("mIsGlobalOpenTXDoc:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("mStrSelectWeiKeUrl:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("mStrDetailWeiKeUrl:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("mStrSelectDocUrl:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\r\n");
    localStringBuilder.append("mStrDetailDocUrl:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\r\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.config.PublishHwkThirdPartyEntryConfig
 * JD-Core Version:    0.7.0.1
 */