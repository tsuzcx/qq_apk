package com.tencent.mobileqq.vip.lianghao.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class LiangHaoRsp
{
  public boolean a;
  public int b = -30009;
  public String c;
  public String d;
  public String e;
  public List<LiangHaoUinData> f;
  
  public LiangHaoRsp() {}
  
  public LiangHaoRsp(JSONObject paramJSONObject)
  {
    this.c = paramJSONObject.optString("msg");
    int j = paramJSONObject.optInt("openflag");
    int i = 0;
    boolean bool = true;
    if (j != 1) {
      bool = false;
    }
    this.a = bool;
    this.b = paramJSONObject.optInt("ret", -30009);
    this.e = paramJSONObject.optString("content");
    this.d = paramJSONObject.optString("url");
    paramJSONObject = paramJSONObject.optString("list");
    if (TextUtils.isEmpty(paramJSONObject)) {
      return;
    }
    paramJSONObject = new JSONArray(paramJSONObject);
    j = paramJSONObject.length();
    this.f = new ArrayList();
    while (i < j)
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      if (localJSONObject != null) {
        this.f.add(new LiangHaoUinData(localJSONObject.optString("num"), localJSONObject.optString("light")));
      }
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LiangHaoRsp{openFlag=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ret=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", msg='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", moreUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.data.LiangHaoRsp
 * JD-Core Version:    0.7.0.1
 */