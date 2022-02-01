package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class RelationVipGrayBean
{
  public int a;
  public String a;
  public HashMap<String, String> a;
  public String b = "";
  
  public RelationVipGrayBean()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static RelationVipGrayBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    RelationVipGrayBean localRelationVipGrayBean;
    try
    {
      localRelationVipGrayBean = new RelationVipGrayBean();
      localRelationVipGrayBean.jdField_a_of_type_JavaLangString = paramString;
      paramString = new JSONObject(paramString);
      localRelationVipGrayBean.jdField_a_of_type_Int = paramString.optInt("isShowEntry");
      localRelationVipGrayBean.b = paramString.optString("iconUrl");
      if (!TextUtils.isEmpty(localRelationVipGrayBean.b)) {
        localRelationVipGrayBean.b = localRelationVipGrayBean.b.trim();
      }
      paramString = paramString.optJSONObject("grayTips");
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localRelationVipGrayBean.jdField_a_of_type_JavaUtilHashMap.put(str, paramString.optString(str));
      }
      QLog.d("ConfBean", 0, "confBean = " + localRelationVipGrayBean.toString());
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ConfBean", 1, "parse e:", paramString);
      }
      return null;
    }
    return localRelationVipGrayBean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("configContent:").append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.RelationVipGrayBean
 * JD-Core Version:    0.7.0.1
 */