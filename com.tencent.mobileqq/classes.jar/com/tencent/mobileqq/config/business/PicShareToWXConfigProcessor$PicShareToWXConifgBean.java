package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PicShareToWXConfigProcessor$PicShareToWXConifgBean
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c = "分享给你1张图片";
  public String d = "";
  
  public PicShareToWXConfigProcessor$PicShareToWXConifgBean()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 10485760L;
    this.jdField_a_of_type_JavaLangString = "gh_0fc5d8395610";
    this.jdField_b_of_type_JavaLangString = "/pages/gallery/gallery?";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
  }
  
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
          localPicShareToWXConifgBean.jdField_a_of_type_Boolean = bool1;
        }
        if (paramString.has("picShareToWeChatSize")) {
          localPicShareToWXConifgBean.jdField_a_of_type_Long = paramString.getLong("picShareToWeChatSize");
        }
        if (paramString.has("PicShareToWeChatUserName")) {
          localPicShareToWXConifgBean.jdField_a_of_type_JavaLangString = paramString.getString("PicShareToWeChatUserName");
        }
        if (paramString.has("PicShareToWeChatPath")) {
          localPicShareToWXConifgBean.jdField_b_of_type_JavaLangString = paramString.getString("PicShareToWeChatPath");
        }
        if (paramString.has("PicShareToWeChatShareTicket"))
        {
          bool1 = bool2;
          if (paramString.getInt("PicShareToWeChatShareTicket") == 1) {
            bool1 = true;
          }
          localPicShareToWXConifgBean.jdField_b_of_type_Boolean = bool1;
        }
        if (paramString.has("PicShareToWeChatMiniType")) {
          localPicShareToWXConifgBean.jdField_a_of_type_Int = paramString.getInt("PicShareToWeChatMiniType");
        }
        if (paramString.has("PicShareToWeChatTitle")) {
          localPicShareToWXConifgBean.c = paramString.getString("PicShareToWeChatTitle");
        }
        if (paramString.has("PicShareToWeChatDescription"))
        {
          localPicShareToWXConifgBean.d = paramString.getString("PicShareToWeChatDescription");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PicShareToWXConfigProcessor.PicShareToWXConifgBean
 * JD-Core Version:    0.7.0.1
 */