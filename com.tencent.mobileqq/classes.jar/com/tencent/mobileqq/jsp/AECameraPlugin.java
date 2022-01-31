package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import apdh;
import aqrh;
import aqri;
import atqs;
import axro;
import axrr;
import axrt;
import axsr;
import baaw;
import bacm;
import badq;
import bbac;
import bbmy;
import bgww;
import bgxa;
import bgxb;
import bgxx;
import biig;
import bjeg;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneFeedsPluginProxyActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class AECameraPlugin
  extends WebViewPlugin
{
  private static final String jdField_a_of_type_JavaLangString;
  private int jdField_a_of_type_Int = -1;
  private AECameraPlugin.DownloadRunnable jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  
  static
  {
    File localFile = new File(ShortVideoUtils.d());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(bgxx.jdField_c_of_type_JavaLangString, "play_show_web_video");
    jdField_a_of_type_JavaLangString = localFile.getPath();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public AECameraPlugin()
  {
    this.mPluginNameSpace = "aecamera";
  }
  
  private static int a(int paramInt)
  {
    return 53504 + paramInt;
  }
  
  private static Bitmap a(@NonNull String paramString, int paramInt)
  {
    int i = 144;
    paramString = ThumbnailUtils.createVideoThumbnail(paramString, paramInt);
    if (paramString != null)
    {
      int j = paramString.getWidth();
      paramInt = paramString.getHeight();
      if (j > 144)
      {
        float f = 144.0F / j;
        paramInt = (int)(paramInt * f);
      }
      for (;;)
      {
        return ThumbnailUtils.extractThumbnail(paramString, i, paramInt, 2);
        i = j;
      }
    }
    return paramString;
  }
  
  private String a(@NonNull String paramString)
  {
    Object localObject = paramString.split("\\.");
    localObject = localObject[(localObject.length - 1)];
    return ShortVideoUtils.d() + paramString.hashCode() + "." + (String)localObject;
  }
  
  private String a(String paramString, int paramInt)
  {
    paramString = new CompressInfo(paramString, paramInt);
    atqs.a(paramString);
    return paramString.e;
  }
  
  private String a(String paramString, int paramInt1, int paramInt2)
  {
    String str = jdField_a_of_type_JavaLangString + File.separator + "ae_pic_" + System.currentTimeMillis() + ".jpeg";
    bacm.a(paramString, str, paramInt1, paramInt2, 70);
    return str;
  }
  
  private StringBuilder a(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = false;
    Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
    paramString = localOptions.outMimeType;
    if (("image/png".equalsIgnoreCase(paramString)) || ("image/gif".equals(paramString)) || ("image/bmp".equals(paramString)))
    {
      paramString = new StringBuilder("data:image/png;base64,");
      localBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    }
    for (;;)
    {
      localBitmap.recycle();
      paramString.append(baaw.encodeToString(localByteArrayOutputStream.toByteArray(), 2));
      return paramString;
      paramString = new StringBuilder("data:image/jpeg;base64,");
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 80, localByteArrayOutputStream);
    }
  }
  
  private JSONObject a(@NonNull String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("succeeded", false);
      localJSONObject.put("message", paramString);
      return localJSONObject;
    }
    catch (JSONException paramString) {}
    return localJSONObject;
  }
  
  private JSONObject a(@Nullable String paramString, int paramInt)
  {
    e(paramString);
    paramString = a(paramString, paramInt);
    StringBuilder localStringBuilder = a(paramString);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("succeeded", true);
    localJSONObject.put("picData", localStringBuilder);
    localJSONObject.put("picPath", paramString);
    return localJSONObject;
  }
  
  private JSONObject a(@Nullable String paramString, int paramInt1, int paramInt2)
  {
    e(paramString);
    paramString = a(paramString, paramInt1, paramInt2);
    StringBuilder localStringBuilder = a(paramString);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("succeeded", true);
    localJSONObject.put("picData", localStringBuilder);
    localJSONObject.put("picPath", paramString);
    return localJSONObject;
  }
  
  private JSONObject a(@NonNull String paramString1, @Nullable String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("succeeded", true);
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("message", paramString2);
      }
      localJSONObject.put("videoUrl", paramString1);
      return localJSONObject;
    }
    catch (JSONException paramString1) {}
    return localJSONObject;
  }
  
  private void a()
  {
    if (this.mRuntime == null) {
      return;
    }
    if (bjeg.a(this.mRuntime.a())) {}
    for (Intent localIntent = new Intent(this.mRuntime.a(), QzoneFeedsPluginProxyActivity.class);; localIntent = new Intent(this.mRuntime.a(), SplashActivity.class))
    {
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      this.mRuntime.a().startActivity(localIntent);
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, @NonNull String paramString)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_c_of_type_JavaLangString = paramString;
    bgxa.a(this.mRuntime.a(), a(1), bgww.w.a());
  }
  
  private void a(Intent paramIntent, int paramInt)
  {
    int i = 400;
    if (paramInt != -1)
    {
      paramIntent = a("not get valid image");
      callJs(this.jdField_c_of_type_JavaLangString, new String[] { paramIntent.toString() });
      return;
    }
    paramIntent = paramIntent.getStringExtra("take_photo_path");
    if (this.jdField_b_of_type_Int == 0)
    {
      paramInt = 400;
      if (this.jdField_c_of_type_Int != 0) {
        break label90;
      }
    }
    for (;;)
    {
      ThreadManager.excute(new AECameraPlugin.1(this, paramIntent, paramInt, i), 64, null, true);
      return;
      paramInt = this.jdField_b_of_type_Int;
      break;
      label90:
      i = this.jdField_c_of_type_Int;
    }
  }
  
  private void a(@Nullable String paramString)
  {
    bgxb.a().a("key_web_selected_pic_path", paramString, 0);
  }
  
  private void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.equals(paramString1)) && ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2))) {
      return;
    }
    c(paramString1);
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = 1;
    String str = a(paramString1);
    aqrh localaqrh = new aqrh(this, paramString1, paramString2, str);
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable = new AECameraPlugin.DownloadRunnable(null);
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable.jdField_b_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable.jdField_a_of_type_Axrt = localaqrh;
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable.jdField_c_of_type_JavaLangString = paramString2;
    ThreadManager.excute(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable, 128, null, true);
  }
  
  private String b(@NonNull String paramString)
  {
    return jdField_a_of_type_JavaLangString + File.separator + paramString.hashCode() + "_thumb.jpg";
  }
  
  private JSONObject b(@NonNull String paramString1, @NonNull String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("succeeded", false);
      localJSONObject.put("message", paramString2);
      localJSONObject.put("videoUrl", paramString1);
      return localJSONObject;
    }
    catch (JSONException paramString1) {}
    return localJSONObject;
  }
  
  private static void b(AppInterface paramAppInterface, String paramString1, String paramString2, axrt paramaxrt)
  {
    axro localaxro = new axro();
    localaxro.jdField_a_of_type_JavaLangString = paramString1;
    localaxro.jdField_a_of_type_Int = 0;
    localaxro.jdField_c_of_type_JavaLangString = paramString2;
    localaxro.jdField_c_of_type_Int = badq.a(axsr.a().a());
    localaxro.jdField_c_of_type_Long = 60000L;
    localaxro.jdField_a_of_type_Axrt = new aqri(paramaxrt);
    try
    {
      paramAppInterface.getNetEngine(0).a(localaxro);
      localaxro.jdField_a_of_type_Axrt.onUpdateProgeress(localaxro, 1L, 100L);
      return;
    }
    catch (Exception paramAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          paramAppInterface.printStackTrace();
        }
      }
    }
  }
  
  private void b(@NonNull String paramString)
  {
    ThreadManager.excute(new AECameraPlugin.2(this, bgxb.a().a("key_web_selected_pic_path", "", 0), paramString), 64, null, true);
  }
  
  private void c(@NonNull String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable != null) && (this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable.jdField_a_of_type_JavaLangString.equals(paramString)) && (this.jdField_a_of_type_Int == 1))
    {
      JSONObject localJSONObject = b(paramString, "downloading canceled");
      callJs(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable.jdField_c_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable, 128);
    }
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = -1;
    paramString = new File(a(paramString));
    if (paramString.exists()) {
      apdh.a(paramString);
    }
  }
  
  private void d(@NonNull String paramString)
  {
    String str1 = a(paramString);
    String str2 = b(paramString);
    if (!new File(str1).exists()) {
      bbmy.a(this.mRuntime.a(), 2131653595, 0).a();
    }
    for (;;)
    {
      return;
      paramString = a(str1, 1);
      if (paramString != null) {}
      try
      {
        bacm.b(paramString, 80, new File(str2));
        biig.a(this.mRuntime.a(), str1, str2, bjeg.a(this.mRuntime.a()), a(21));
        for (;;)
        {
          return;
          bbmy.a(this.mRuntime.a(), 2131653595, 0).a();
        }
      }
      catch (IOException localIOException)
      {
        bbmy.a(this.mRuntime.a(), 2131653595, 0).a();
        return;
      }
      finally
      {
        if (paramString != null) {
          paramString.recycle();
        }
      }
    }
  }
  
  private void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IOException();
    }
    Object localObject = new File(paramString);
    if ((!((File)localObject).exists()) || (((File)localObject).length() < 3L)) {
      throw new IOException();
    }
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    int i = ((BitmapFactory.Options)localObject).outWidth;
    int j = ((BitmapFactory.Options)localObject).outHeight;
    if ((i < 0) || (j < 0)) {
      throw new IOException();
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"aecamera".equals(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    if ("takePhoto".equals(paramString3)) {}
    for (;;)
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        a(paramJsBridgeListener.getInt("outMaxWidth"), paramJsBridgeListener.getInt("outMaxHeight"), paramJsBridgeListener.getString("callback"));
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
        continue;
      }
      if ("setLastSelectedPicture".equals(paramString3))
      {
        try
        {
          a(new JSONObject(paramVarArgs[0]).optString("picPath"));
        }
        catch (Exception paramJsBridgeListener) {}
        if (QLog.isColorLevel()) {
          QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
        }
      }
      else if ("getLastSelectedPicture".equals(paramString3))
      {
        try
        {
          b(new JSONObject(paramVarArgs[0]).optString("callback"));
        }
        catch (Exception paramJsBridgeListener) {}
        if (QLog.isColorLevel()) {
          QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
        }
      }
      else if ("downloadVideo".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          a(paramJsBridgeListener.optString("videoUrl"), paramJsBridgeListener.optString("callback"));
        }
        catch (Exception paramJsBridgeListener) {}
        if (QLog.isColorLevel()) {
          QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
        }
      }
      else if ("cancelDownload".equals(paramString3))
      {
        try
        {
          c(new JSONObject(paramVarArgs[0]).optString("videoUrl"));
        }
        catch (Exception paramJsBridgeListener) {}
        if (QLog.isColorLevel()) {
          QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
        }
      }
      else if ("shareVideo".equals(paramString3))
      {
        try
        {
          d(new JSONObject(paramVarArgs[0]).optString("videoUrl"));
        }
        catch (Exception paramJsBridgeListener) {}
        if (QLog.isColorLevel()) {
          QLog.e("AECameraPlugin", 2, paramJsBridgeListener.getMessage());
        }
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramByte == 1) {
      a(paramIntent, paramInt);
    }
    for (;;)
    {
      super.onActivityResult(paramIntent, paramByte, paramInt);
      return;
      if ((paramByte == 21) && (paramInt == -1)) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.AECameraPlugin
 * JD-Core Version:    0.7.0.1
 */