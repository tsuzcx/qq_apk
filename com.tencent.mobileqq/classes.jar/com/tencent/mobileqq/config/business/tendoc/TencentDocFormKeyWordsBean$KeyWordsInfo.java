package com.tencent.mobileqq.config.business.tendoc;

import android.text.TextUtils;
import org.json.JSONObject;

public class TencentDocFormKeyWordsBean$KeyWordsInfo
{
  public String[] a;
  public String[] b;
  public String c;
  public String d;
  
  public TencentDocFormKeyWordsBean$KeyWordsInfo(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("words");
    if (!TextUtils.isEmpty(str)) {
      this.a = str.split("\\/");
    }
    str = paramJSONObject.optString("overlay");
    if (!TextUtils.isEmpty(str)) {
      this.b = str.split("\\/");
    }
    this.c = paramJSONObject.optString("optString");
    this.d = paramJSONObject.optString("aioTips");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocFormKeyWordsBean.KeyWordsInfo
 * JD-Core Version:    0.7.0.1
 */