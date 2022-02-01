package com.tencent.mobileqq.haoliyou.orion;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.haoliyou.JefsClassUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class ZhuoXusManager$ConfigLoader
{
  private final Context jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
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
    if (paramJSONObject == null) {
      return ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
    }
    int k = paramJSONObject.optInt("need_block");
    boolean bool = true;
    if (k != 1) {
      bool = false;
    }
    String str = paramJSONObject.optString("start_time");
    paramJSONObject = paramJSONObject.optString("end_time");
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    try
    {
      paramJSONObject = new ZhuosConfig(bool, localSimpleDateFormat.parse(str), localSimpleDateFormat.parse(paramJSONObject));
      return paramJSONObject;
    }
    catch (Throwable paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    catch (ParseException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return ZhuosConfig.jdField_a_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig;
  }
  
  private String a()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject == null) {
      return "";
    }
    localObject = ((AppRuntime)localObject).getAccount();
    if (localObject == null) {
      return "";
    }
    return localObject;
  }
  
  private void a(int paramInt)
  {
    Object localObject2 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(a());
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = ((SharedPreferences)localObject2).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KEY_WO_KAO_VERSION");
    localStringBuilder.append((String)localObject1);
    ((SharedPreferences.Editor)localObject2).putInt(localStringBuilder.toString(), paramInt).apply();
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(a());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KEY_WO_KAO_VERSION");
    localStringBuilder.append((String)localObject);
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  void a()
  {
    long l = System.currentTimeMillis();
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("SP_WO_KAO", 4);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(a());
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("KEY_WO_KAO_CONFIG");
    ((StringBuilder)localObject3).append((String)localObject1);
    localObject3 = ((StringBuilder)localObject3).toString();
    localObject1 = "";
    localObject2 = ((SharedPreferences)localObject2).getString((String)localObject3, "");
    try
    {
      localObject2 = XorCipher.b((String)localObject2);
      localObject1 = localObject2;
    }
    catch (XorCipherException localXorCipherException)
    {
      localXorCipherException.printStackTrace();
    }
    a((String)localObject1);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("loadConfigFromSp: invoked.  cost ms: ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      QLog.i("Zhuoxu", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    int k = paramConfig.version.get();
    int m = a();
    a(k);
    if (m != k)
    {
      paramConfig = QConfigServlet.a(paramConfig, m, paramConfig.type.get());
      a(paramConfig);
      b(paramConfig);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramConfig = new StringBuilder();
      paramConfig.append("handleConfig: invoked. save version, ignored. version: ");
      paramConfig.append(m);
      QLog.i("Zhuoxu", 2, paramConfig.toString());
    }
  }
  
  void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      b();
      return;
    }
    for (;;)
    {
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
        int k = paramString.optInt("need_report_system_share_info_new");
        boolean bool2 = false;
        if (k == 1)
        {
          bool1 = true;
          this.jdField_a_of_type_Boolean = bool1;
          if (paramString.optInt("need_xxxxx_else_xxx_installed") != 1) {
            break label305;
          }
          bool1 = true;
          this.jdField_b_of_type_Boolean = bool1;
          bool1 = bool2;
          if (paramString.optInt("need_xxxxx_plugin_xxxxx") == 1) {
            bool1 = true;
          }
          this.jdField_c_of_type_Boolean = bool1;
          this.jdField_a_of_type_JavaLangString = paramString.optString("package1");
          this.jdField_b_of_type_JavaLangString = paramString.optString("package2");
          paramString = paramString.optJSONObject("webview_launch_xxx_xxxxxyyyy");
          JefsClassUtil.a(this.jdField_b_of_type_ComTencentMobileqqHaoliyouOrionZhuosConfig.a(), paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Zhuoxu", 2, "parseConfig: failed. ", paramString);
        }
        return;
      }
      catch (Throwable paramString)
      {
        return;
      }
      boolean bool1 = false;
      continue;
      label305:
      bool1 = false;
    }
  }
  
  void b(String paramString)
  {
    try
    {
      paramString = XorCipher.a(paramString);
    }
    catch (XorCipherException paramString)
    {
      paramString.printStackTrace();
      paramString = "";
    }
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("SP_WO_KAO", 4);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(a());
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = ((SharedPreferences)localObject2).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KEY_WO_KAO_CONFIG");
    localStringBuilder.append((String)localObject1);
    ((SharedPreferences.Editor)localObject2).putString(localStringBuilder.toString(), paramString).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager.ConfigLoader
 * JD-Core Version:    0.7.0.1
 */