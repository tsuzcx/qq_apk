package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.DictInfo;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkManageConfig$AIDictConfig
  extends ArkManageConfig.DictConfig
  implements IQStorageSafable<String>
{
  protected String a;
  public ArrayList<ArkManageConfig.ConditionalDict> a;
  
  public ArkManageConfig$AIDictConfig()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private static ArkAiDictUpdateMgr.DictInfo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    ArkAiDictUpdateMgr.DictInfo localDictInfo = new ArkAiDictUpdateMgr.DictInfo();
    localDictInfo.jdField_a_of_type_Int = paramJSONObject.optInt("type", -1);
    localDictInfo.d = paramJSONObject.optString("md5", null);
    localDictInfo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("url", null);
    localDictInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name", null);
    localDictInfo.c = paramJSONObject.optString("identifier", null);
    if (!localDictInfo.a())
    {
      QLog.i("AIDictConfig", 1, "getDictInfoFromJSON, invalid dict info");
      return null;
    }
    QLog.i("AIDictConfig", 1, "onParse getDictInfoFromJSON  info.type=" + localDictInfo.jdField_a_of_type_Int + ", info.md5=" + localDictInfo.d + ", info.url=" + localDictInfo.jdField_b_of_type_JavaLangString + ",  info.name =" + localDictInfo.jdField_a_of_type_JavaLangString + ",  info.identifier =" + localDictInfo.c);
    paramJSONObject = paramJSONObject.optJSONObject("diff");
    if (paramJSONObject != null)
    {
      localDictInfo.e = paramJSONObject.optString("url");
      localDictInfo.f = paramJSONObject.optString("diff-md5");
      localDictInfo.g = paramJSONObject.optString("source-md5");
      if (!localDictInfo.b()) {
        localDictInfo.a();
      }
      QLog.i("AIDictConfig", 1, "onParse getDictInfoFromJSON info.diffURL=" + localDictInfo.e + ", info.diffMD5=" + localDictInfo.f + ", info.diffSourceMD5=" + localDictInfo.g);
    }
    return localDictInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    int k = 0;
    if (TextUtils.isEmpty(paramString))
    {
      ArkAppCenter.c("AIDictConfig", "onParse,fileOrRes is null");
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    Object localObject5;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      this.c = paramString.optString("environment");
      this.jdField_b_of_type_JavaLangString = paramString.optString("timestamp");
      this.d = paramString.optString("ark_dict_init");
      this.e = paramString.optString("netType", "");
      localObject1 = paramString.optJSONArray("conditional_dict_list");
      if (localObject1 == null) {
        break label420;
      }
      i = 0;
      if (i >= ((JSONArray)localObject1).length()) {
        break label420;
      }
      localObject2 = ((JSONArray)localObject1).optJSONObject(i);
      if (localObject2 == null) {
        break label517;
      }
      localObject3 = ((JSONObject)localObject2).optJSONObject("condition");
      Object localObject4 = ((JSONObject)localObject2).optJSONObject("dict");
      if ((localObject3 == null) || (localObject4 == null)) {
        break label517;
      }
      localObject2 = new ArkManageConfig.ConditionalDict();
      localObject5 = new ArkManageConfig.Condition();
      ((ArkManageConfig.Condition)localObject5).jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("date", "");
      ((ArkManageConfig.ConditionalDict)localObject2).jdField_a_of_type_ComTencentMobileqqConfigBusinessArkManageConfig$Condition = ((ArkManageConfig.Condition)localObject5);
      localObject3 = new ArkManageConfig.DictConfig();
      ((ArkManageConfig.DictConfig)localObject3).c = ((JSONObject)localObject4).optString("environment");
      ((ArkManageConfig.DictConfig)localObject3).jdField_b_of_type_JavaLangString = ((JSONObject)localObject4).optString("timestamp");
      ((ArkManageConfig.DictConfig)localObject3).d = ((JSONObject)localObject4).optString("ark_dict_init");
      ((ArkManageConfig.DictConfig)localObject3).e = ((JSONObject)localObject4).optString("netType", "");
      QLog.i("AIDictConfig", 1, "onParse conditional_dict_list tDict.environment=" + ((ArkManageConfig.DictConfig)localObject3).c + ", tDict.mTimestamp =" + ((ArkManageConfig.DictConfig)localObject3).jdField_b_of_type_JavaLangString + ", tDict.mArkDictInit =" + ((ArkManageConfig.DictConfig)localObject3).d + ", tDict.mNetType =" + ((ArkManageConfig.DictConfig)localObject3).e + ", tCondition.mData =" + ((ArkManageConfig.Condition)localObject5).jdField_a_of_type_JavaLangString);
      localObject4 = ((JSONObject)localObject4).optJSONArray("word_dict_list");
      if (localObject4 == null) {
        break label400;
      }
      localObject5 = new ArrayList();
      j = 0;
      label343:
      if (j < ((JSONArray)localObject4).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject4).optJSONObject(j);
        if (localJSONObject == null) {
          break label524;
        }
        ((ArrayList)localObject5).add(a(localJSONObject));
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("AIDictConfig", 1, "onParse error e = ", paramString);
      return;
    }
    ((ArkManageConfig.DictConfig)localObject3).jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject5);
    label400:
    ((ArkManageConfig.ConditionalDict)localObject2).jdField_a_of_type_ComTencentMobileqqConfigBusinessArkManageConfig$DictConfig = ((ArkManageConfig.DictConfig)localObject3);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
    break label517;
    label420:
    paramString = paramString.optJSONArray("word_dict_list");
    if (paramString != null)
    {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      i = k;
    }
    for (;;)
    {
      if (i < paramString.length())
      {
        localObject1 = paramString.optJSONObject(i);
        if (localObject1 != null)
        {
          localObject1 = a((JSONObject)localObject1);
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject1);
        }
      }
      else
      {
        QLog.d("AIDictConfig", 1, new Object[] { "mWordDictList list size =", Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) });
        return;
        label517:
        i += 1;
        break;
        label524:
        j += 1;
        break label343;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.ArkManageConfig.AIDictConfig
 * JD-Core Version:    0.7.0.1
 */