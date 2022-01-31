package com.tencent.mobileqq.tribe.view;

import android.text.TextUtils;
import org.json.JSONObject;

public class TribeTitlePrefixPanelView$TitlePrefixItem
{
  public String a;
  public String b;
  public String c;
  
  public void a(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("left");
    this.b = paramJSONObject.optString("text");
    this.c = paramJSONObject.optString("right");
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView.TitlePrefixItem
 * JD-Core Version:    0.7.0.1
 */