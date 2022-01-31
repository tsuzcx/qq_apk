package com.tencent.mobileqq.profile;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class VipWZRYTemplateConfig
{
  public static VipWZRYTemplateConfig a;
  public SparseArray a;
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqProfileVipWZRYTemplateConfig == null) {
      return a(VipWZRYTemplateHelper.a(paramQQAppInterface.getApp()) + "xydata.json");
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VipWZRYTemplateConfig", 2, "configPath = " + paramString);
      }
      return false;
    }
    Object localObject = new File(paramString);
    try
    {
      localObject = FileUtils.b((File)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("VipWZRYTemplateConfig", 1, paramString + " content is empty.");
        return false;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("VipWZRYTemplateConfig", 1, paramString.getMessage());
      return false;
    }
    paramString = new VipWZRYTemplateConfig();
    localObject = new JSONObject((String)localObject).optJSONArray("cardWZResourceGrade");
    int i;
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      paramString.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
      i = 0;
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
        if (localJSONObject != null)
        {
          VipWZRYTemplateConfig.WZRYHonorItem localWZRYHonorItem = new VipWZRYTemplateConfig.WZRYHonorItem();
          localWZRYHonorItem.jdField_a_of_type_Int = localJSONObject.optInt("wz_id");
          localWZRYHonorItem.jdField_a_of_type_JavaLangString = localJSONObject.optString("wz_name");
          localWZRYHonorItem.jdField_b_of_type_JavaLangString = localJSONObject.optString("wz_format");
          localWZRYHonorItem.jdField_b_of_type_Int = localJSONObject.optInt("position_type", 1);
          if (localJSONObject.has("wz_icon"))
          {
            VipWZRYTemplateConfig.WZRYResourceItem localWZRYResourceItem = new VipWZRYTemplateConfig.WZRYResourceItem();
            localJSONObject = localJSONObject.getJSONObject("wz_icon");
            localWZRYResourceItem.jdField_a_of_type_JavaLangString = localJSONObject.optString("src");
            localWZRYResourceItem.jdField_a_of_type_Int = localJSONObject.optInt("size");
            localWZRYResourceItem.jdField_b_of_type_JavaLangString = localJSONObject.optString("md5");
            localWZRYResourceItem.jdField_b_of_type_Int = localJSONObject.optInt("width");
            localWZRYResourceItem.jdField_c_of_type_Int = localJSONObject.optInt("height");
            localWZRYResourceItem.jdField_c_of_type_JavaLangString = localJSONObject.optString("mainColor");
            localWZRYHonorItem.jdField_a_of_type_ComTencentMobileqqProfileVipWZRYTemplateConfig$WZRYResourceItem = localWZRYResourceItem;
          }
          paramString.jdField_a_of_type_AndroidUtilSparseArray.put(localWZRYHonorItem.jdField_a_of_type_Int, localWZRYHonorItem);
        }
      }
      else
      {
        jdField_a_of_type_ComTencentMobileqqProfileVipWZRYTemplateConfig = paramString;
        return true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipWZRYTemplateConfig
 * JD-Core Version:    0.7.0.1
 */