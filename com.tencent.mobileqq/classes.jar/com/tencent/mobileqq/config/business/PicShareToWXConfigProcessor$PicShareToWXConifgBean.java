package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PicShareToWXConfigProcessor$PicShareToWXConifgBean
{
  public boolean a = false;
  public long b = 10485760L;
  public String c = "gh_0fc5d8395610";
  public String d = "/pages/gallery/gallery?";
  public boolean e = false;
  public int f = 0;
  public String g = "分享给你1张图片";
  public String h = "";
  
  public static PicShareToWXConifgBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    PicShareToWXConifgBean localPicShareToWXConifgBean = new PicShareToWXConifgBean();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        bool1 = paramString.has("picShareToWeChatEnable");
        boolean bool2 = false;
        if (bool1)
        {
          if (paramString.getInt("picShareToWeChatEnable") != 1) {
            break label212;
          }
          bool1 = true;
          localPicShareToWXConifgBean.a = bool1;
        }
        if (paramString.has("picShareToWeChatSize")) {
          localPicShareToWXConifgBean.b = paramString.getLong("picShareToWeChatSize");
        }
        if (paramString.has("PicShareToWeChatUserName")) {
          localPicShareToWXConifgBean.c = paramString.getString("PicShareToWeChatUserName");
        }
        if (paramString.has("PicShareToWeChatPath")) {
          localPicShareToWXConifgBean.d = paramString.getString("PicShareToWeChatPath");
        }
        if (paramString.has("PicShareToWeChatShareTicket"))
        {
          bool1 = bool2;
          if (paramString.getInt("PicShareToWeChatShareTicket") == 1) {
            bool1 = true;
          }
          localPicShareToWXConifgBean.e = bool1;
        }
        if (paramString.has("PicShareToWeChatMiniType")) {
          localPicShareToWXConifgBean.f = paramString.getInt("PicShareToWeChatMiniType");
        }
        if (paramString.has("PicShareToWeChatTitle")) {
          localPicShareToWXConifgBean.g = paramString.getString("PicShareToWeChatTitle");
        }
        if (paramString.has("PicShareToWeChatDescription"))
        {
          localPicShareToWXConifgBean.h = paramString.getString("PicShareToWeChatDescription");
          return localPicShareToWXConifgBean;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("PicShareToWXConfigProcessor", 1, "parse error.", paramString);
      }
      return localPicShareToWXConifgBean;
      label212:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PicShareToWXConfigProcessor.PicShareToWXConifgBean
 * JD-Core Version:    0.7.0.1
 */