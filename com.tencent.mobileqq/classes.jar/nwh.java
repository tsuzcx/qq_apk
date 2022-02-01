import android.text.TextUtils;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.MsgCommonData;

public class nwh
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public String m = "";
  public String n = "";
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  
  private nwh()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 5;
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_l_of_type_JavaLangString = "";
  }
  
  public nwh(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 5;
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_l_of_type_JavaLangString = "";
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_JavaLangString = paramString.optString("paUin", "");
      this.jdField_b_of_type_JavaLangString = paramString.optString("paName", "");
      this.jdField_c_of_type_JavaLangString = paramString.optString("adId", "");
      this.jdField_d_of_type_JavaLangString = paramString.optString("adPosId", "");
      this.jdField_b_of_type_Boolean = paramString.optBoolean("bannerShow", false);
      this.jdField_c_of_type_Int = paramString.optInt("bannertype", 0);
      this.jdField_d_of_type_Int = paramString.optInt("jumpType", 0);
      this.n = paramString.optString("jumpUrl", "");
      this.jdField_k_of_type_JavaLangString = paramString.optString("appId", "");
      this.jdField_l_of_type_JavaLangString = paramString.optString("packagename", "");
      this.jdField_i_of_type_JavaLangString = paramString.optString("androidDownloadUrl", "");
      this.jdField_f_of_type_JavaLangString = paramString.optString("bannerImgUrl", "");
      this.jdField_g_of_type_JavaLangString = paramString.optString("bannerText", "");
      this.jdField_h_of_type_JavaLangString = paramString.optString("bannerButtonText", "");
      this.jdField_c_of_type_Boolean = paramString.optBoolean("silentDownload", false);
      this.m = paramString.optString("appName", "");
      this.jdField_e_of_type_JavaLangString = paramString.optString("reportLink", "");
      this.jdField_a_of_type_Boolean = paramString.optBoolean("horizontalVideo", false);
      this.jdField_a_of_type_Int = paramString.optInt("audioFadeinDuration", 5);
      this.jdField_b_of_type_Int = paramString.optInt("audioSwitchType", 0);
      this.jdField_e_of_type_Int = paramString.optInt("preDownloadType", 0);
      this.jdField_e_of_type_Int = PAAdPreloadTask.checkNetworkType(this.jdField_e_of_type_Int);
      if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!this.jdField_e_of_type_JavaLangString.contains("https"))) {
        this.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString.replace("http", "https");
      }
      if (QLog.isColorLevel()) {
        QLog.w("AdvertisementRecentUserManager", 2, "reportLink :" + this.jdField_e_of_type_JavaLangString);
      }
      this.o = paramString.optString("str_openJumpUrlGuide", "");
      this.jdField_j_of_type_JavaLangString = paramString.optString("str_myappDownloadUrl", "");
      this.p = paramString.optString("jumpTypeParams");
      this.jdField_h_of_type_Int = paramString.optInt("canScorll");
      if (this.jdField_h_of_type_Int == 1) {}
      for (;;)
      {
        this.jdField_d_of_type_Boolean = bool;
        this.jdField_i_of_type_Int = paramString.optInt("controlVariable");
        this.jdField_j_of_type_Int = paramString.optInt("uint32_control_plugin_time");
        this.jdField_k_of_type_Int = paramString.optInt("uint32_autoJump");
        this.jdField_g_of_type_Int = paramString.optInt("dDCategoryId", -1);
        this.q = paramString.optString("dDCategoryName", "");
        this.jdField_f_of_type_Int = paramString.optInt("dDItemID", -1);
        this.r = paramString.optString("str_clickLink", "");
        this.jdField_l_of_type_Int = paramString.optInt("uint32_monitorType", 0);
        this.s = paramString.getString("str_share_nick");
        this.t = paramString.getString("str_share_ad_head_url");
        this.u = paramString.getString("str_share_ad_brief");
        this.v = paramString.getString("str_share_ad_txt");
        this.w = paramString.getString("str_share_ad_icon_url");
        this.x = paramString.getString("str_share_jump_url");
        return;
        bool = false;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static nwh a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    nwh localnwh = new nwh();
    localnwh.jdField_a_of_type_JavaLangString = paramString2;
    localnwh.jdField_b_of_type_JavaLangString = paramString3;
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        localnwh.jdField_c_of_type_JavaLangString = paramString1.optString("str_adId", "");
        localnwh.jdField_d_of_type_JavaLangString = paramString1.optString("str_adPosId", "");
        localnwh.jdField_b_of_type_Boolean = paramString1.optBoolean("bool_bannerShow", false);
        localnwh.jdField_c_of_type_Int = paramString1.optInt("uint32_bannertype", 0);
        localnwh.jdField_d_of_type_Int = paramString1.optInt("uint32_jumpType", 0);
        localnwh.n = paramString1.optString("str_jumpUrl", "");
        localnwh.jdField_k_of_type_JavaLangString = paramString1.optString("str_appId", "");
        localnwh.jdField_l_of_type_JavaLangString = paramString1.optString("str_packagename", "");
        localnwh.jdField_i_of_type_JavaLangString = paramString1.optString("str_androidDownloadUrl", "");
        localnwh.jdField_f_of_type_JavaLangString = paramString1.optString("str_bannerImgUrl", "");
        localnwh.jdField_g_of_type_JavaLangString = paramString1.optString("str_bannerText", "");
        localnwh.jdField_h_of_type_JavaLangString = paramString1.optString("str_bannerButtonText", "");
        localnwh.jdField_c_of_type_Boolean = paramString1.optBoolean("bool_silentDownload", false);
        localnwh.m = paramString1.optString("str_appName", "");
        localnwh.jdField_e_of_type_JavaLangString = paramString1.optString("str_reportLink", "");
        if ((!TextUtils.isEmpty(localnwh.jdField_e_of_type_JavaLangString)) && (!localnwh.jdField_e_of_type_JavaLangString.contains("https"))) {
          localnwh.jdField_e_of_type_JavaLangString = localnwh.jdField_e_of_type_JavaLangString.replace("http", "https");
        }
        localnwh.jdField_a_of_type_Boolean = paramString1.optBoolean("bool_horizontalVideo", false);
        localnwh.jdField_a_of_type_Int = paramString1.optInt("uint32_audioFadeinDuration", 5);
        localnwh.jdField_b_of_type_Int = paramString1.optInt("uint32_audioSwitchType", 0);
        localnwh.jdField_e_of_type_Int = paramString1.optInt("uint32_preDownloadType", 0);
        localnwh.jdField_e_of_type_Int = PAAdPreloadTask.checkNetworkType(localnwh.jdField_e_of_type_Int);
        localnwh.o = paramString1.optString("str_openJumpUrlGuide", "");
        localnwh.jdField_j_of_type_JavaLangString = paramString1.optString("str_myappDownloadUrl", "");
        localnwh.p = paramString1.optString("str_jumpTypeParams", "");
        localnwh.jdField_h_of_type_Int = paramString1.optInt("uint32_scrollUpToJump", 0);
        if (localnwh.jdField_h_of_type_Int == 1)
        {
          localnwh.jdField_d_of_type_Boolean = bool;
          localnwh.jdField_i_of_type_Int = paramString1.optInt("uint32_controlVariable", 0);
          localnwh.jdField_j_of_type_Int = paramString1.optInt("uint32_control_plugin_time", 0);
          localnwh.jdField_k_of_type_Int = paramString1.optInt("uint32_autoJump", 0);
          if (localnwh.jdField_d_of_type_Int >= 3)
          {
            bool = TextUtils.isEmpty(localnwh.p);
            if (bool) {}
          }
          try
          {
            paramString2 = new JSONObject(localnwh.p);
            localnwh.jdField_g_of_type_Int = paramString2.optInt("class_id", -1);
            localnwh.q = paramString2.optString("class_name", "");
            localnwh.jdField_f_of_type_Int = paramString2.optInt("pendant_id", -1);
            localnwh.r = paramString1.optString("str_clickLink", "");
            localnwh.jdField_l_of_type_Int = paramString1.optInt("uint32_monitorType", 0);
            localnwh.s = paramString1.optString("str_share_nick", "");
            localnwh.t = paramString1.optString("str_share_ad_head_url", "");
            localnwh.u = paramString1.optString("str_share_ad_brief", "");
            localnwh.v = paramString1.optString("str_share_ad_txt", "");
            localnwh.w = paramString1.optString("str_share_ad_icon_url", "");
            localnwh.x = paramString1.optString("str_share_jump_url", "");
            return localnwh;
          }
          catch (JSONException paramString2)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.w("AdvertisementRecentUserManager", 2, "parse jumpTypeParams fail" + paramString2.getMessage());
            continue;
          }
        }
        bool = false;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
    }
  }
  
  public static nwh a(submsgtype0xf9.MsgCommonData paramMsgCommonData, String paramString1, String paramString2)
  {
    boolean bool = true;
    nwh localnwh = new nwh();
    localnwh.jdField_a_of_type_JavaLangString = paramString1;
    localnwh.jdField_b_of_type_JavaLangString = paramString2;
    if (paramMsgCommonData.str_adId.has()) {
      localnwh.jdField_c_of_type_JavaLangString = paramMsgCommonData.str_adId.get();
    }
    if (paramMsgCommonData.str_adPosId.has()) {
      localnwh.jdField_d_of_type_JavaLangString = paramMsgCommonData.str_adPosId.get();
    }
    if (paramMsgCommonData.bool_bannerShow.has()) {
      localnwh.jdField_b_of_type_Boolean = paramMsgCommonData.bool_bannerShow.get();
    }
    if (paramMsgCommonData.uint32_bannertype.has()) {
      localnwh.jdField_c_of_type_Int = paramMsgCommonData.uint32_bannertype.get();
    }
    if (paramMsgCommonData.uint32_jumpType.has()) {
      localnwh.jdField_d_of_type_Int = paramMsgCommonData.uint32_jumpType.get();
    }
    if (paramMsgCommonData.str_jumpUrl.has()) {
      localnwh.n = paramMsgCommonData.str_jumpUrl.get();
    }
    if (paramMsgCommonData.str_appId.has()) {
      localnwh.jdField_k_of_type_JavaLangString = paramMsgCommonData.str_appId.get();
    }
    if (paramMsgCommonData.str_packagename.has()) {
      localnwh.jdField_l_of_type_JavaLangString = paramMsgCommonData.str_packagename.get();
    }
    if (paramMsgCommonData.str_androidDownloadUrl.has()) {
      localnwh.jdField_i_of_type_JavaLangString = paramMsgCommonData.str_androidDownloadUrl.get();
    }
    if (paramMsgCommonData.str_bannerImgUrl.has()) {
      localnwh.jdField_f_of_type_JavaLangString = paramMsgCommonData.str_bannerImgUrl.get();
    }
    if (paramMsgCommonData.str_bannerText.has()) {
      localnwh.jdField_g_of_type_JavaLangString = paramMsgCommonData.str_bannerText.get();
    }
    if (paramMsgCommonData.str_bannerButtonText.has()) {
      localnwh.jdField_h_of_type_JavaLangString = paramMsgCommonData.str_bannerButtonText.get();
    }
    if (paramMsgCommonData.bool_silentDownload.has()) {
      localnwh.jdField_c_of_type_Boolean = paramMsgCommonData.bool_silentDownload.get();
    }
    if (paramMsgCommonData.str_appName.has()) {
      localnwh.m = paramMsgCommonData.str_appName.get();
    }
    if (paramMsgCommonData.str_reportLink.has())
    {
      localnwh.jdField_e_of_type_JavaLangString = paramMsgCommonData.str_reportLink.get();
      if ((!TextUtils.isEmpty(localnwh.jdField_e_of_type_JavaLangString)) && (!localnwh.jdField_e_of_type_JavaLangString.contains("https"))) {
        localnwh.jdField_e_of_type_JavaLangString = localnwh.jdField_e_of_type_JavaLangString.replace("http", "https");
      }
    }
    if (paramMsgCommonData.bool_horizontalVideo.has()) {
      localnwh.jdField_a_of_type_Boolean = paramMsgCommonData.bool_horizontalVideo.get();
    }
    if (paramMsgCommonData.uint32_audioFadeinDuration.has()) {
      localnwh.jdField_a_of_type_Int = paramMsgCommonData.uint32_audioFadeinDuration.get();
    }
    if (paramMsgCommonData.uint32_audioSwitchType.has()) {
      localnwh.jdField_b_of_type_Int = paramMsgCommonData.uint32_audioSwitchType.get();
    }
    if (paramMsgCommonData.uint32_preDownloadType.has())
    {
      localnwh.jdField_e_of_type_Int = paramMsgCommonData.uint32_preDownloadType.get();
      localnwh.jdField_e_of_type_Int = PAAdPreloadTask.checkNetworkType(localnwh.jdField_e_of_type_Int);
    }
    if (paramMsgCommonData.str_openJumpUrlGuide.has()) {
      localnwh.o = paramMsgCommonData.str_openJumpUrlGuide.get();
    }
    if (paramMsgCommonData.str_myappDownloadUrl.has()) {
      localnwh.jdField_j_of_type_JavaLangString = paramMsgCommonData.str_myappDownloadUrl.get();
    }
    if (paramMsgCommonData.str_jumpTypeParams.has()) {
      localnwh.p = paramMsgCommonData.str_jumpTypeParams.get();
    }
    if (paramMsgCommonData.uint32_scrollUpToJump.has())
    {
      if (QLog.isColorLevel()) {
        QLog.w("AdvertisementRecentUserManager", 2, "uint32_scrollUpToJump :" + paramMsgCommonData.uint32_scrollUpToJump.get());
      }
      localnwh.jdField_h_of_type_Int = paramMsgCommonData.uint32_scrollUpToJump.get();
      if (localnwh.jdField_h_of_type_Int != 1) {
        break label1112;
      }
    }
    for (;;)
    {
      localnwh.jdField_d_of_type_Boolean = bool;
      if (paramMsgCommonData.uint32_controlVariable.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementRecentUserManager", 2, "uint32_controlVariable :" + paramMsgCommonData.uint32_controlVariable.get());
        }
        localnwh.jdField_i_of_type_Int = paramMsgCommonData.uint32_controlVariable.get();
      }
      if (paramMsgCommonData.uint32_control_plugin_time.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementRecentUserManager", 2, "uint32_control_plugin_time :" + paramMsgCommonData.uint32_control_plugin_time.get());
        }
        localnwh.jdField_j_of_type_Int = paramMsgCommonData.uint32_control_plugin_time.get();
      }
      if (paramMsgCommonData.uint32_autoJump.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementRecentUserManager", 2, "uint32_autoJump :" + paramMsgCommonData.uint32_autoJump.get());
        }
        localnwh.jdField_k_of_type_Int = paramMsgCommonData.uint32_autoJump.get();
      }
      if ((localnwh.jdField_d_of_type_Int >= 3) && (!TextUtils.isEmpty(localnwh.p))) {}
      try
      {
        paramString1 = new JSONObject(localnwh.p);
        localnwh.jdField_g_of_type_Int = paramString1.optInt("class_id", -1);
        localnwh.q = paramString1.optString("class_name", "");
        localnwh.jdField_f_of_type_Int = paramString1.optInt("pendant_id", -1);
        if (paramMsgCommonData.str_clickLink.has())
        {
          localnwh.r = paramMsgCommonData.str_clickLink.get();
          if ((!TextUtils.isEmpty(localnwh.r)) && (!localnwh.r.startsWith("https://"))) {
            localnwh.r = localnwh.r.replace("http://", "https://");
          }
        }
        if (paramMsgCommonData.uint32_monitorType.has()) {
          localnwh.jdField_l_of_type_Int = paramMsgCommonData.uint32_monitorType.get();
        }
        if (paramMsgCommonData.str_share_nick.has()) {
          localnwh.s = paramMsgCommonData.str_share_nick.get();
        }
        if (paramMsgCommonData.str_share_ad_head_url.has()) {
          localnwh.t = paramMsgCommonData.str_share_ad_head_url.get();
        }
        if (paramMsgCommonData.str_share_ad_brief.has()) {
          localnwh.u = paramMsgCommonData.str_share_ad_brief.get();
        }
        if (paramMsgCommonData.str_share_ad_txt.has()) {
          localnwh.v = paramMsgCommonData.str_share_ad_txt.get();
        }
        if (paramMsgCommonData.str_share_ad_icon_url.has()) {
          localnwh.w = paramMsgCommonData.str_share_ad_icon_url.get();
        }
        if (paramMsgCommonData.str_share_jump_url.has()) {
          localnwh.x = paramMsgCommonData.str_share_jump_url.get();
        }
        return localnwh;
        label1112:
        bool = false;
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("AdvertisementRecentUserManager", 2, "parse jumpTypeParams fail" + paramString1.getMessage());
          }
        }
      }
    }
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("paUin", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("paName", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("bannerShow", this.jdField_b_of_type_Boolean);
      localJSONObject.put("bannertype", this.jdField_c_of_type_Int);
      localJSONObject.put("jumpType", this.jdField_d_of_type_Int);
      localJSONObject.put("jumpUrl", this.n);
      localJSONObject.put("appId", this.jdField_k_of_type_JavaLangString);
      localJSONObject.put("packagename", this.jdField_l_of_type_JavaLangString);
      localJSONObject.put("androidDownloadUrl", this.jdField_i_of_type_JavaLangString);
      localJSONObject.put("bannerImgUrl", this.jdField_f_of_type_JavaLangString);
      localJSONObject.put("bannerText", this.jdField_g_of_type_JavaLangString);
      localJSONObject.put("bannerButtonText", this.jdField_h_of_type_JavaLangString);
      localJSONObject.put("silentDownload", this.jdField_c_of_type_Boolean);
      localJSONObject.put("adId", this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("adPosId", this.jdField_d_of_type_JavaLangString);
      localJSONObject.put("appName", this.m);
      localJSONObject.put("reportLink", this.jdField_e_of_type_JavaLangString);
      localJSONObject.put("horizontalVideo", this.jdField_a_of_type_Boolean);
      localJSONObject.put("audioFadeinDuration", this.jdField_a_of_type_Int);
      localJSONObject.put("audioSwitchType", this.jdField_b_of_type_Int);
      localJSONObject.put("preDownloadType", this.jdField_e_of_type_Int);
      localJSONObject.put("str_openJumpUrlGuide", this.o);
      localJSONObject.put("str_myappDownloadUrl", this.jdField_j_of_type_JavaLangString);
      localJSONObject.put("jumpTypeParams", this.p);
      localJSONObject.put("canScorll", this.jdField_h_of_type_Int);
      localJSONObject.put("controlVariable", this.jdField_i_of_type_Int);
      localJSONObject.put("uint32_control_plugin_time", this.jdField_j_of_type_Int);
      localJSONObject.put("uint32_autoJump", this.jdField_k_of_type_Int);
      localJSONObject.put("dDCategoryId", this.jdField_g_of_type_Int);
      localJSONObject.put("dDCategoryName", this.q);
      localJSONObject.put("dDItemID", this.jdField_f_of_type_Int);
      localJSONObject.put("str_clickLink", this.r);
      localJSONObject.put("uint32_monitorType", this.jdField_l_of_type_Int);
      localJSONObject.put("str_share_nick", this.s);
      localJSONObject.put("str_share_ad_head_url", this.t);
      localJSONObject.put("str_share_ad_brief", this.u);
      localJSONObject.put("str_share_ad_txt", this.v);
      localJSONObject.put("str_share_ad_icon_url", this.w);
      localJSONObject.put("str_share_jump_url", this.x);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    return "VideoDownloadItem{mTrueUin='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mNickName='" + this.jdField_b_of_type_JavaLangString + '\'' + ", adId='" + this.jdField_c_of_type_JavaLangString + '\'' + ", adPosId='" + this.jdField_d_of_type_JavaLangString + '\'' + ", reportLink='" + this.jdField_e_of_type_JavaLangString + '\'' + ", audioFadeinDuration=" + this.jdField_a_of_type_Int + ", horizontalVideo=" + this.jdField_a_of_type_Boolean + ", audioMode=" + this.jdField_b_of_type_Int + ", bannerShow=" + this.jdField_b_of_type_Boolean + ", bannertype=" + this.jdField_c_of_type_Int + ", bannerImgUrl='" + this.jdField_f_of_type_JavaLangString + '\'' + ", bannerText='" + this.jdField_g_of_type_JavaLangString + '\'' + ", bannerButtonText='" + this.jdField_h_of_type_JavaLangString + '\'' + ", jumpType=" + this.jdField_d_of_type_Int + ", downloadUrl='" + this.jdField_i_of_type_JavaLangString + '\'' + ", myappDownloadUrl='" + this.jdField_j_of_type_JavaLangString + '\'' + ", appId='" + this.jdField_k_of_type_JavaLangString + '\'' + ", packagename='" + this.jdField_l_of_type_JavaLangString + '\'' + ", appName='" + this.m + '\'' + ", silentDownload=" + this.jdField_c_of_type_Boolean + ", downloadType=" + this.jdField_e_of_type_Int + ", jumpUrl='" + this.n + '\'' + ", openJumpUrlGuide='" + this.o + '\'' + ", jumpTypeParams='" + this.p + '\'' + ", dDItemID=" + this.jdField_f_of_type_Int + ", dDCategoryName='" + this.q + '\'' + ", dDCategoryId=" + this.jdField_g_of_type_Int + ", canScorll=" + this.jdField_h_of_type_Int + ", controlVariable=" + this.jdField_i_of_type_Int + ", plugin_time=" + this.jdField_j_of_type_Int + ", scrollUpToJump=" + this.jdField_d_of_type_Boolean + ", uint32_autoJump=" + this.jdField_k_of_type_Int + ", mClickReportLink='" + this.r + '\'' + ", mReportPlatType=" + this.jdField_l_of_type_Int + ", mShareNickname='" + this.s + '\'' + ", mShareHeaderUrl='" + this.t + '\'' + ", mShareBrief='" + this.u + '\'' + ", mShareTxt='" + this.v + '\'' + ", mShareIconUrl='" + this.w + '\'' + ", mShareJumpUrl='" + this.x + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     nwh
 * JD-Core Version:    0.7.0.1
 */