package com.tencent.mobileqq.vip.lianghao.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class LiangHaoRsp
{
  public int a;
  public String a;
  public List<LiangHaoUinData> a;
  public boolean a;
  public String b;
  public String c;
  
  public LiangHaoRsp()
  {
    this.jdField_a_of_type_Int = -30009;
  }
  
  public LiangHaoRsp(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = -30009;
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("msg");
    int j = paramJSONObject.optInt("openflag");
    int i = 0;
    boolean bool = true;
    if (j != 1) {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_Int = paramJSONObject.optInt("ret", -30009);
    this.c = paramJSONObject.optString("content");
    this.b = paramJSONObject.optString("url");
    paramJSONObject = paramJSONObject.optString("list");
    if (TextUtils.isEmpty(paramJSONObject)) {
      return;
    }
    paramJSONObject = new JSONArray(paramJSONObject);
    j = paramJSONObject.length();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    while (i < j)
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      if (localJSONObject != null) {
        this.jdField_a_of_type_JavaUtilList.add(new LiangHaoUinData(localJSONObject.optString("num"), localJSONObject.optString("light")));
      }
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LiangHaoRsp{openFlag=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", ret=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", msg='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", moreUrl='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.data.LiangHaoRsp
 * JD-Core Version:    0.7.0.1
 */