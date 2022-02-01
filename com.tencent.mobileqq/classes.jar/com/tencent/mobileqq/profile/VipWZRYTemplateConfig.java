package com.tencent.mobileqq.profile;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class VipWZRYTemplateConfig
{
  public static VipWZRYTemplateConfig a;
  public SparseArray<VipWZRYTemplateConfig.WZRYHonorItem> a;
  
  public static boolean a()
  {
    if (jdField_a_of_type_ComTencentMobileqqProfileVipWZRYTemplateConfig == null)
    {
      if (!VipWZRYTemplateHelper.a("cardWZ.zip"))
      {
        VipWZRYTemplateHelper.a(null);
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(VipWZRYTemplateHelper.a());
      localStringBuilder.append("xydata.json");
      return a(localStringBuilder.toString());
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("configPath = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("VipWZRYTemplateConfig", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    Object localObject = new File(paramString);
    for (;;)
    {
      int i;
      try
      {
        localObject = FileUtils.readFileToString((File)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" content is empty.");
          QLog.e("VipWZRYTemplateConfig", 1, ((StringBuilder)localObject).toString());
          return false;
        }
        paramString = new VipWZRYTemplateConfig();
        localObject = new JSONObject((String)localObject).optJSONArray("cardWZResourceGrade");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          paramString.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
            if (localJSONObject == null) {
              break label359;
            }
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
            break label359;
          }
        }
        jdField_a_of_type_ComTencentMobileqqProfileVipWZRYTemplateConfig = paramString;
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e("VipWZRYTemplateConfig", 1, paramString.getMessage());
        return false;
      }
      label359:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipWZRYTemplateConfig
 * JD-Core Version:    0.7.0.1
 */