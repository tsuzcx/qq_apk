package com.tencent.mobileqq.haoliyou.orion;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ZhuoXusManager$ConfigLoader
{
  private final Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.context;
  ZhuosConfig jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
  String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean = false;
  ZhuosConfig jdField_b_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
  String jdField_b_of_type_JavaLangString = "";
  boolean jdField_b_of_type_Boolean = false;
  ZhuosConfig jdField_c_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
  boolean jdField_c_of_type_Boolean = false;
  ZhuosConfig d = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
  ZhuosConfig e = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
  ZhuosConfig f = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
  ZhuosConfig g = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
  ZhuosConfig h = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
  ZhuosConfig i = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
  ZhuosConfig j = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
  
  ZhuoXusManager$ConfigLoader()
  {
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private ZhuosConfig a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramJSONObject == null) {
      return ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
    }
    if (paramJSONObject.optInt("need_block") == 1) {}
    for (;;)
    {
      String str = paramJSONObject.optString("start_time");
      paramJSONObject = paramJSONObject.optString("end_time");
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
      try
      {
        paramJSONObject = new ZhuosConfig(bool, localSimpleDateFormat.parse(str), localSimpleDateFormat.parse(paramJSONObject));
        return paramJSONObject;
      }
      catch (ParseException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
      }
      catch (Throwable paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
      bool = false;
    }
  }
  
  private String a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if (localObject == null) {
        return "";
      }
      str = ((AppRuntime)localObject).getAccount();
      localObject = str;
    } while (str != null);
    return "";
  }
  
  private void a(int paramInt)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext);
    String str = "_" + a();
    localSharedPreferences.edit().putInt("KEY_WO_KAO_VERSION" + str, paramInt).apply();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
    this.jdField_b_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
    this.jdField_c_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
    this.d = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
    this.e = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
    this.f = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
    this.g = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
    this.h = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
    this.i = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
    this.j = ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public int a()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext);
    String str = "_" + a();
    return localSharedPreferences.getInt("KEY_WO_KAO_VERSION" + str, 0);
  }
  
  void a()
  {
    long l = System.currentTimeMillis();
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("SP_WO_KAO", 4);
    String str = "_" + a();
    str = ((SharedPreferences)localObject).getString("KEY_WO_KAO_CONFIG" + str, "");
    localObject = "";
    try
    {
      str = XorCipher.b(str);
      localObject = str;
    }
    catch (XorCipherException localXorCipherException)
    {
      for (;;)
      {
        localXorCipherException.printStackTrace();
      }
    }
    a((String)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("Zhuoxu", 2, "loadConfigFromSp: invoked.  cost ms: " + (System.currentTimeMillis() - l));
    }
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    int k = paramConfig.version.get();
    int m = a();
    a(k);
    if (m != k)
    {
      paramConfig = ConfigServlet.b(paramConfig, m, paramConfig.type.get());
      a(paramConfig);
      b(paramConfig);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("Zhuoxu", 2, "handleConfig: invoked. save version, ignored. version: " + m);
  }
  
  void a(String paramString)
  {
    boolean bool2 = true;
    if (TextUtils.isEmpty(paramString)) {
      b();
    }
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig = a(paramString.optJSONObject("webview_menu"));
        this.jdField_b_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig = a(paramString.optJSONObject("webview_launch_app"));
        this.jdField_c_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig = a(paramString.optJSONObject("scan_qrcode"));
        this.d = a(paramString.optJSONObject("save_image"));
        this.e = a(paramString.optJSONObject("imageUpload_scan"));
        this.g = a(paramString.optJSONObject("assetInfo_upload"));
        this.f = a(paramString.optJSONObject("image_probe"));
        this.h = a(paramString.optJSONObject("send_fileqrcode_switch"));
        this.i = a(paramString.optJSONObject("file_exif_info"));
        this.j = a(paramString.optJSONObject("file_app_scan"));
        if (paramString.optInt("need_report_system_share_info_new") == 1)
        {
          bool1 = true;
          this.jdField_a_of_type_Boolean = bool1;
          if (paramString.optInt("need_xxxxx_else_xxx_installed") != 1) {
            break label294;
          }
          bool1 = true;
          this.jdField_b_of_type_Boolean = bool1;
          if (paramString.optInt("need_xxxxx_plugin_xxxxx") != 1) {
            break label299;
          }
          bool1 = bool2;
          this.jdField_c_of_type_Boolean = bool1;
          this.jdField_a_of_type_JavaLangString = paramString.optString("package1");
          this.jdField_b_of_type_JavaLangString = paramString.optString("package2");
          paramString = paramString.optJSONObject("webview_launch_xxx_xxxxxyyyy");
          JefsClass.getInstance().a(this.jdField_b_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig.a(), paramString);
        }
      }
      catch (JSONException paramString)
      {
        boolean bool1;
        while (QLog.isColorLevel())
        {
          QLog.e("Zhuoxu", 2, "parseConfig: failed. ", paramString);
          return;
          bool1 = false;
          continue;
          label294:
          bool1 = false;
          continue;
          label299:
          bool1 = false;
        }
      }
      catch (Throwable paramString) {}
    }
  }
  
  void b(String paramString)
  {
    Object localObject = "";
    try
    {
      paramString = XorCipher.a(paramString);
      localObject = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("SP_WO_KAO", 4);
      String str = "_" + a();
      ((SharedPreferences)localObject).edit().putString("KEY_WO_KAO_CONFIG" + str, paramString).apply();
      return;
    }
    catch (XorCipherException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = (String)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager.ConfigLoader
 * JD-Core Version:    0.7.0.1
 */