package com.tencent.mobileqq.haoliyou.orion;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfigHelper;
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
  ZhuosConfig a = ZhuosConfig.a;
  ZhuosConfig b = ZhuosConfig.a;
  ZhuosConfig c = ZhuosConfig.a;
  ZhuosConfig d = ZhuosConfig.a;
  ZhuosConfig e = ZhuosConfig.a;
  ZhuosConfig f = ZhuosConfig.a;
  ZhuosConfig g = ZhuosConfig.a;
  ZhuosConfig h = ZhuosConfig.a;
  ZhuosConfig i = ZhuosConfig.a;
  ZhuosConfig j = ZhuosConfig.a;
  boolean k = false;
  boolean l = false;
  boolean m = false;
  String n = "";
  String o = "";
  private final Context p = BaseApplication.getContext();
  
  ZhuoXusManager$ConfigLoader()
  {
    try
    {
      b();
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
      return ZhuosConfig.a;
    }
    int i1 = paramJSONObject.optInt("need_block");
    boolean bool = true;
    if (i1 != 1) {
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
    return ZhuosConfig.a;
  }
  
  private void a(int paramInt)
  {
    Object localObject2 = PreferenceManager.getDefaultSharedPreferences(this.p);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(d());
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = ((SharedPreferences)localObject2).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KEY_WO_KAO_VERSION");
    localStringBuilder.append((String)localObject1);
    ((SharedPreferences.Editor)localObject2).putInt(localStringBuilder.toString(), paramInt).apply();
  }
  
  private void c()
  {
    this.a = ZhuosConfig.a;
    this.b = ZhuosConfig.a;
    this.c = ZhuosConfig.a;
    this.d = ZhuosConfig.a;
    this.e = ZhuosConfig.a;
    this.f = ZhuosConfig.a;
    this.g = ZhuosConfig.a;
    this.h = ZhuosConfig.a;
    this.i = ZhuosConfig.a;
    this.j = ZhuosConfig.a;
    this.k = false;
    this.l = false;
    this.m = false;
    this.n = "";
    this.o = "";
  }
  
  private String d()
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
  
  public int a()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.p);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(d());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KEY_WO_KAO_VERSION");
    localStringBuilder.append((String)localObject);
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    int i1 = paramConfig.version.get();
    int i2 = a();
    a(i1);
    if (i2 != i1)
    {
      paramConfig = QConfigHelper.a(paramConfig, i2, paramConfig.type.get());
      a(paramConfig);
      b(paramConfig);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramConfig = new StringBuilder();
      paramConfig.append("handleConfig: invoked. save version, ignored. version: ");
      paramConfig.append(i2);
      QLog.i("Zhuoxu", 2, paramConfig.toString());
    }
  }
  
  void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      c();
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.a = a(paramString.optJSONObject("webview_menu"));
        this.b = a(paramString.optJSONObject("webview_launch_app"));
        this.c = a(paramString.optJSONObject("scan_qrcode"));
        this.d = a(paramString.optJSONObject("save_image"));
        this.e = a(paramString.optJSONObject("imageUpload_scan"));
        this.g = a(paramString.optJSONObject("assetInfo_upload"));
        this.f = a(paramString.optJSONObject("image_probe"));
        this.h = a(paramString.optJSONObject("send_fileqrcode_switch"));
        this.i = a(paramString.optJSONObject("file_exif_info"));
        this.j = a(paramString.optJSONObject("file_app_scan"));
        int i1 = paramString.optInt("need_report_system_share_info_new");
        boolean bool2 = false;
        if (i1 == 1)
        {
          bool1 = true;
          this.k = bool1;
          if (paramString.optInt("need_xxxxx_else_xxx_installed") != 1) {
            break label295;
          }
          bool1 = true;
          this.l = bool1;
          bool1 = bool2;
          if (paramString.optInt("need_xxxxx_plugin_xxxxx") == 1) {
            bool1 = true;
          }
          this.m = bool1;
          this.n = paramString.optString("package1");
          this.o = paramString.optString("package2");
          paramString = paramString.optJSONObject("webview_launch_xxx_xxxxxyyyy");
          JefsClassUtil.a(this.b.a(), paramString);
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
      label295:
      bool1 = false;
    }
  }
  
  void b()
  {
    long l1 = System.currentTimeMillis();
    Object localObject2 = this.p.getSharedPreferences("SP_WO_KAO", 4);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(d());
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
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
      QLog.i("Zhuoxu", 2, ((StringBuilder)localObject1).toString());
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
    Object localObject2 = this.p.getSharedPreferences("SP_WO_KAO", 4);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(d());
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = ((SharedPreferences)localObject2).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KEY_WO_KAO_CONFIG");
    localStringBuilder.append((String)localObject1);
    ((SharedPreferences.Editor)localObject2).putString(localStringBuilder.toString(), paramString).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager.ConfigLoader
 * JD-Core Version:    0.7.0.1
 */