package com.tencent.mobileqq.ecshop.keep;

import com.tencent.mobileqq.utils.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class EcshopMinusViewConfBean
{
  public int a = 0;
  public String b = "";
  public String c = "";
  public String d = "";
  public int e;
  
  public static EcshopMinusViewConfBean a(String paramString)
  {
    EcshopMinusViewConfBean localEcshopMinusViewConfBean = new EcshopMinusViewConfBean();
    if (!StringUtil.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        localEcshopMinusViewConfBean.a = paramString.optInt("minus_view_switch");
        localEcshopMinusViewConfBean.b = paramString.optString("minus_view_titie");
        localEcshopMinusViewConfBean.c = paramString.optString("recommend_title");
        localEcshopMinusViewConfBean.d = paramString.optString("btn_jump_url");
        localEcshopMinusViewConfBean.e = paramString.optInt("max_open_cnt", 2);
        if (localEcshopMinusViewConfBean.e <= 0)
        {
          localEcshopMinusViewConfBean.e = 2;
          return localEcshopMinusViewConfBean;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return localEcshopMinusViewConfBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.keep.EcshopMinusViewConfBean
 * JD-Core Version:    0.7.0.1
 */