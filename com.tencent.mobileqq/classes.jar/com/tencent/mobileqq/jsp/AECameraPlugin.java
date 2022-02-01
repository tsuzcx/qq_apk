package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import apdr;
import auog;
import awfz;
import awga;
import awgb;
import azrm;
import beum;
import beuo;
import beuq;
import bevn;
import bhkv;
import bhmq;
import bhnv;
import bioy;
import boeq;
import bofb;
import born;
import borr;
import bozz;
import bqip;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneFeedsPluginProxyActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class AECameraPlugin
  extends WebViewPlugin
{
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int = -1;
  private AECameraPlugin.DownloadRunnable jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  
  static
  {
    File localFile = new File(bofb.d);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (b(BaseApplicationImpl.getContext()))
    {
      localFile = new File(boeq.a());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
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
    int i = 300;
    paramString = ThumbnailUtils.createVideoThumbnail(paramString, paramInt);
    if (paramString != null)
    {
      int j = paramString.getWidth();
      paramInt = paramString.getHeight();
      if (j > 300)
      {
        float f = 300.0F / j;
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
    if (b(this.mRuntime.a())) {
      return boeq.a() + paramString.hashCode() + "." + (String)localObject;
    }
    return bofb.d + File.separator + paramString.hashCode() + "." + (String)localObject;
  }
  
  private String a(String paramString, int paramInt)
  {
    paramString = new CompressInfo(paramString, paramInt);
    azrm.a(paramString);
    return paramString.e;
  }
  
  private String a(String paramString, int paramInt1, int paramInt2)
  {
    String str = bofb.d + File.separator + "ae_pic_" + System.currentTimeMillis() + ".jpeg";
    this.jdField_a_of_type_Double = 0.7D;
    bhmq.a(paramString, str, paramInt1, paramInt2, (int)(this.jdField_a_of_type_Double * 100.0D));
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
      paramString.append(bhkv.encodeToString(localByteArrayOutputStream.toByteArray(), 2));
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
    c(paramString);
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
    c(paramString);
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
    if ((born.c(this.mRuntime.a())) || (born.d(this.mRuntime.a()))) {}
    for (Intent localIntent = new Intent(this.mRuntime.a(), QzoneFeedsPluginProxyActivity.class);; localIntent = new Intent(this.mRuntime.a(), SplashActivity.class))
    {
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
      this.mRuntime.a().startActivity(localIntent);
      return;
    }
  }
  
  private void a(Intent paramIntent, int paramInt)
  {
    int i = 400;
    if (paramInt != -1)
    {
      paramIntent = a("not get valid image");
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { paramIntent.toString() });
      return;
    }
    paramIntent = paramIntent.getStringExtra("take_photo_path");
    if (this.jdField_b_of_type_Int == 0)
    {
      paramInt = 400;
      if (this.c != 0) {
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
      i = this.c;
    }
  }
  
  private void a(awgb paramawgb, @NonNull String paramString)
  {
    this.jdField_b_of_type_Int = paramawgb.jdField_a_of_type_Int;
    this.c = paramawgb.jdField_b_of_type_Int;
    this.jdField_b_of_type_JavaLangString = paramString;
    int i = born.C.a();
    borr.a(this.mRuntime.a(), a(1), i, paramawgb);
  }
  
  private void a(@NonNull String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable != null) && (this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable.jdField_a_of_type_JavaLangString.equals(paramString)) && (this.jdField_a_of_type_Int == 1))
    {
      JSONObject localJSONObject = b(paramString, "downloading canceled");
      callJs(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable.jdField_c_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable, 128);
    }
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = -1;
    paramString = new File(a(paramString));
    if (paramString.exists()) {
      auog.a(paramString);
    }
  }
  
  private void a(@Nullable String paramString1, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "key_web_selected_pic_path";
    }
    bozz.a().a(str, paramString1, 0);
  }
  
  private boolean a()
  {
    if ((this.mRuntime != null) && (this.mRuntime.a() != null) && (this.mRuntime.a().getIntent() != null)) {
      return born.h(this.mRuntime.a().getIntent().getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", born.a.a()));
    }
    return false;
  }
  
  private String b(@NonNull String paramString)
  {
    return bofb.d + File.separator + paramString.hashCode() + "_thumb.jpg";
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
  
  private static void b(AppInterface paramAppInterface, String paramString1, String paramString2, beuq parambeuq)
  {
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_JavaLangString = paramString1;
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.jdField_c_of_type_JavaLangString = paramString2;
    localbeum.jdField_b_of_type_Int = bhnv.a(bevn.a().a());
    localbeum.jdField_c_of_type_Long = 60000L;
    localbeum.jdField_a_of_type_Beuq = new awga(parambeuq);
    try
    {
      paramAppInterface.getNetEngine(0).a(localbeum);
      localbeum.jdField_a_of_type_Beuq.onUpdateProgeress(localbeum, 1L, 100L);
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
    String str1 = a(paramString);
    String str2 = b(paramString);
    if (!new File(str1).exists()) {
      QQToast.a(this.mRuntime.a(), 2131718139, 0).a();
    }
    for (;;)
    {
      return;
      paramString = this.mRuntime.a().getIntent();
      Object localObject;
      if (paramString == null)
      {
        localObject = born.a;
        paramString = "";
        label69:
        if ((localObject != born.e) || (TextUtils.isEmpty(paramString))) {
          break label178;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("file_send_path", str1);
        ((Intent)localObject).putExtra("file_send_duration", ShortVideoUtils.a(str1));
      }
      try
      {
        ((Intent)localObject).putExtra("widgetinfo", URLEncoder.encode(paramString, "UTF-8"));
        label127:
        this.mRuntime.a().setResult(-1, (Intent)localObject);
        this.mRuntime.a().finish();
        return;
        localObject = born.a(paramString.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", born.a.a()));
        paramString = paramString.getStringExtra("url");
        break label69;
        label178:
        localObject = a(str1, 1);
        try
        {
          if (a())
          {
            Intent localIntent = new Intent();
            localIntent.putExtra("h5_key_flag", true);
            localIntent.putExtra("h5_key_video_path", str1);
            localIntent.putExtra("h5_key_thumb_path", str2);
            localIntent.putExtra("widgetinfo", URLEncoder.encode(paramString, "UTF-8"));
            bhmq.b((Bitmap)localObject, 80, new File(str2));
            this.mRuntime.a().setResult(-1, localIntent);
            this.mRuntime.a().finish();
            return;
          }
          if (localObject != null)
          {
            bhmq.b((Bitmap)localObject, 80, new File(str2));
            bqip.a(this.mRuntime.a(), str1, str2, born.c(this.mRuntime.a()), a(21));
          }
          for (;;)
          {
            return;
            QQToast.a(this.mRuntime.a(), 2131718139, 0).a();
          }
        }
        catch (IOException paramString)
        {
          QQToast.a(this.mRuntime.a(), 2131718139, 0).a();
          return;
        }
        finally
        {
          if (localObject != null) {
            ((Bitmap)localObject).recycle();
          }
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        break label127;
      }
    }
  }
  
  private void b(@NonNull String paramString1, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "key_web_selected_pic_path";
    }
    ThreadManager.excute(new AECameraPlugin.2(this, bozz.a().a(str, "", 0), paramString1), 64, null, true);
  }
  
  private static boolean b(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    return apdr.a(paramContext);
  }
  
  private void c(String paramString)
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
  
  private void c(@NonNull String paramString1, @NonNull String paramString2)
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString1)) && ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2))) {
      return;
    }
    a(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = 1;
    String str = a(paramString1);
    awfz localawfz = new awfz(this, paramString1, paramString2, str);
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable = new AECameraPlugin.DownloadRunnable(null);
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable.jdField_b_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable.jdField_a_of_type_Beuq = localawfz;
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable.jdField_c_of_type_JavaLangString = paramString2;
    ThreadManager.excute(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin$DownloadRunnable, 128, null, true);
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
        paramString1 = new awgb();
        paramString1.jdField_a_of_type_Int = paramJsBridgeListener.getInt("outMaxWidth");
        paramString1.jdField_b_of_type_Int = paramJsBridgeListener.getInt("outMaxHeight");
        paramString1.jdField_a_of_type_Double = paramJsBridgeListener.optDouble("compression");
        paramString1.jdField_a_of_type_Boolean = paramJsBridgeListener.optBoolean("backDevicePosition");
        paramString1.jdField_a_of_type_JavaLangString = paramJsBridgeListener.optString("guideImage");
        paramString1.jdField_b_of_type_Boolean = paramJsBridgeListener.optBoolean("enableCountDown");
        paramString1.c = paramJsBridgeListener.optBoolean("sensitiveValidate");
        paramString1.d = paramJsBridgeListener.optBoolean("disableFaceDetect");
        a(paramString1, paramJsBridgeListener.getString("callback"));
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
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          a(paramJsBridgeListener.optString("picPath"), paramJsBridgeListener.optString("id"));
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
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = paramJsBridgeListener.optString("id");
          b(paramJsBridgeListener.optString("callback"), paramString1);
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
          c(paramJsBridgeListener.optString("videoUrl"), paramJsBridgeListener.optString("callback"));
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
          a(new JSONObject(paramVarArgs[0]).optString("videoUrl"));
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
          b(new JSONObject(paramVarArgs[0]).optString("videoUrl"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.AECameraPlugin
 * JD-Core Version:    0.7.0.1
 */