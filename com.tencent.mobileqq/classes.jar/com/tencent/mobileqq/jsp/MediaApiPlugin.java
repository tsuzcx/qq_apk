package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.av.ui.GetIsLTUserActivity;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.MediaApiPluginInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressDialog.Callback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaApiPlugin
  extends WebViewPlugin
  implements ITroopMemberApiClientApi.Callback, QQProgressDialog.Callback
{
  static final String jdField_a_of_type_JavaLangString = UiApiPlugin.class.getSimpleName();
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  Thread jdField_a_of_type_JavaLangThread;
  
  public MediaApiPlugin()
  {
    this.mPluginNameSpace = "media";
  }
  
  public static String a(String paramString, int paramInt)
  {
    paramString = new CompressInfo(paramString, paramInt, 1035);
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(paramString);
    return paramString.e;
  }
  
  public static JSONObject a(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis();
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = new File(paramString);
    if (((File)localObject1).length() >= 3L)
    {
      Object localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject2);
      int i = ((BitmapFactory.Options)localObject2).outWidth;
      int j = ((BitmapFactory.Options)localObject2).outHeight;
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("packImageObjectV2 realWidth: ");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append(", realHeight: ");
        ((StringBuilder)localObject3).append(j);
        ((StringBuilder)localObject3).append(", realSize: ");
        ((StringBuilder)localObject3).append(((File)localObject1).length());
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      if ((i >= 0) && (j >= 0))
      {
        localObject3 = a(paramString, paramInt);
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
        localObject2 = BitmapFactory.decodeFile((String)localObject3, (BitmapFactory.Options)localObject1);
        if (QLog.isColorLevel())
        {
          localObject3 = new File((String)localObject3);
          String str = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("packImageObjectV2 curWidth: ");
          localStringBuilder.append(((BitmapFactory.Options)localObject1).outWidth);
          localStringBuilder.append(", curHeight: ");
          localStringBuilder.append(((BitmapFactory.Options)localObject1).outHeight);
          localStringBuilder.append(", realSize: ");
          localStringBuilder.append(((File)localObject3).length());
          QLog.d(str, 2, localStringBuilder.toString());
        }
        localObject3 = new ByteArrayOutputStream(1024);
        localObject1 = ((BitmapFactory.Options)localObject1).outMimeType;
        if ((!"image/png".equalsIgnoreCase((String)localObject1)) && (!"image/gif".equals(localObject1)) && (!"image/bmp".equals(localObject1)))
        {
          localObject1 = new StringBuilder("data:image/jpeg;base64,");
          ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject3);
        }
        else
        {
          localObject1 = new StringBuilder("data:image/png;base64,");
          ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
        }
        ((Bitmap)localObject2).recycle();
        ((StringBuilder)localObject1).append(Base64Util.encodeToString(((ByteArrayOutputStream)localObject3).toByteArray(), 2));
        localJSONObject.put("match", 0);
        localJSONObject.put("data", localObject1);
        localJSONObject.put("imageID", paramString);
        if (QLog.isColorLevel())
        {
          paramString = jdField_a_of_type_JavaLangString;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("packImageObjectV2 time: ");
          ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
          QLog.d(paramString, 2, ((StringBuilder)localObject1).toString());
        }
        return localJSONObject;
      }
      throw new IOException();
    }
    throw new IOException();
  }
  
  public static JSONObject a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = new File(paramString);
    if (((File)localObject2).length() >= 3L)
    {
      Object localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
      int i = ((BitmapFactory.Options)localObject1).outWidth;
      int j = ((BitmapFactory.Options)localObject1).outHeight;
      if ((i >= 0) && (j >= 0))
      {
        if ((i >= paramInt1) && (j >= paramInt2))
        {
          if ((i <= paramInt3) && (j <= paramInt4)) {}
          try
          {
            localObject2 = new FileInputStream((File)localObject2);
            try
            {
              paramInt1 = ((InputStream)localObject2).read();
              paramInt2 = ((InputStream)localObject2).read();
              paramInt3 = ((InputStream)localObject2).read();
              if ((paramInt1 == 255) && (paramInt2 == 216)) {
                localObject1 = new StringBuilder("data:image/jpeg;base64,");
              } else if ((paramInt1 == 66) && (paramInt2 == 77)) {
                localObject1 = new StringBuilder("data:image/bmp;base64,");
              } else if ((paramInt1 == 137) && (paramInt2 == 80)) {
                localObject1 = new StringBuilder("data:image/png;base64,");
              } else if ((paramInt1 == 71) && (paramInt2 == 73)) {
                localObject1 = new StringBuilder("data:image/gif;base64,");
              } else {
                localObject1 = new StringBuilder("data:base64,");
              }
              ((StringBuilder)localObject1).append(Base64Util.encodeToString(new byte[] { (byte)paramInt1, (byte)paramInt2, (byte)paramInt3 }, 2));
              localObject3 = new byte[30720];
              for (;;)
              {
                paramInt1 = ((InputStream)localObject2).read((byte[])localObject3);
                if (paramInt1 == -1) {
                  break label369;
                }
                if (Thread.currentThread().isInterrupted()) {
                  break;
                }
                if (paramInt1 < 30720)
                {
                  byte[] arrayOfByte = new byte[paramInt1];
                  System.arraycopy(localObject3, 0, arrayOfByte, 0, paramInt1);
                  ((StringBuilder)localObject1).append(Base64Util.encodeToString(arrayOfByte, 2));
                }
                else
                {
                  ((StringBuilder)localObject1).append(Base64Util.encodeToString((byte[])localObject3, 2));
                }
              }
              throw new InterruptedException();
              label369:
              localJSONObject.put("match", 0);
              localJSONObject.put("data", localObject1);
              localJSONObject.put("imageID", paramString);
              ((InputStream)localObject2).close();
              return localJSONObject;
            }
            finally
            {
              localObject1 = localObject2;
            }
            paramInt1 |= paramInt1 >>> 2;
          }
          finally
          {
            localObject1 = null;
            if (localObject1 != null) {
              ((InputStream)localObject1).close();
            }
          }
          paramInt1 |= paramInt1 >>> 4;
          paramInt1 |= paramInt1 >>> 8;
          ((BitmapFactory.Options)localObject1).inSampleSize = ((paramInt1 | paramInt1 >>> 16) + 1 >>> 1);
          Object localObject3 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
          if (localObject3 != null)
          {
            float f;
            if (i * paramInt4 > j * paramInt3)
            {
              f = paramInt3;
              paramInt1 = ((Bitmap)localObject3).getWidth();
            }
            else
            {
              f = paramInt4;
              paramInt1 = ((Bitmap)localObject3).getHeight();
            }
            f /= paramInt1;
            localObject2 = new Matrix();
            switch (JpegExifReader.readOrientation(paramString))
            {
            default: 
              ((Matrix)localObject2).setScale(f, f);
              break;
            case 8: 
              ((Matrix)localObject2).setScale(f, f);
              ((Matrix)localObject2).postRotate(270.0F);
              break;
            case 7: 
              ((Matrix)localObject2).setScale(-f, f);
              ((Matrix)localObject2).postRotate(90.0F);
              break;
            case 6: 
              ((Matrix)localObject2).setScale(f, f);
              ((Matrix)localObject2).postRotate(90.0F);
              break;
            case 5: 
              ((Matrix)localObject2).setScale(f, -f);
              ((Matrix)localObject2).postRotate(90.0F);
              break;
            case 4: 
              ((Matrix)localObject2).setScale(f, -f);
              break;
            case 3: 
              ((Matrix)localObject2).setScale(f, f);
              ((Matrix)localObject2).postRotate(180.0F);
              break;
            case 2: 
              ((Matrix)localObject2).setScale(-f, f);
            }
            localObject2 = Bitmap.createBitmap((Bitmap)localObject3, 0, 0, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight(), (Matrix)localObject2, true);
            if (localObject3 != localObject2) {
              ((Bitmap)localObject3).recycle();
            }
            localObject3 = new ByteArrayOutputStream(1024);
            localObject1 = ((BitmapFactory.Options)localObject1).outMimeType;
            if ((!"image/png".equalsIgnoreCase((String)localObject1)) && (!"image/gif".equals(localObject1)) && (!"image/bmp".equals(localObject1)))
            {
              localObject1 = new StringBuilder("data:image/jpeg;base64,");
              ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject3);
            }
            else
            {
              localObject1 = new StringBuilder("data:image/png;base64,");
              ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
            }
            ((Bitmap)localObject2).recycle();
            ((StringBuilder)localObject1).append(Base64Util.encodeToString(((ByteArrayOutputStream)localObject3).toByteArray(), 2));
            localJSONObject.put("match", 0);
            localJSONObject.put("data", localObject1);
            localJSONObject.put("imageID", paramString);
            return localJSONObject;
          }
          throw new IOException();
        }
        localJSONObject.put("match", 1);
        return localJSONObject;
      }
      throw new IOException();
    }
    paramString = new IOException();
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static void a(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent(paramContext, ShortVideoPreviewActivity.class);
    localIntent.putExtra("file_send_path", paramString);
    localIntent.putExtra("file_send_size", paramLong1);
    localIntent.putExtra("file_send_duration", paramLong2);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramContext.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("preview_only", true);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  private boolean a()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    if ((i >= 23) && (localBaseApplication.checkSelfPermission("android.permission.CAMERA") != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (Camera.getNumberOfCameras() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static SharedPreferences b(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append("_preferences");
    return paramContext.getSharedPreferences(localStringBuilder.toString(), 4);
  }
  
  Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  /* Error */
  String a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 71	java/io/File
    //   3: dup
    //   4: getstatic 395	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   7: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: aload_3
    //   12: invokevirtual 398	java/io/File:mkdirs	()Z
    //   15: pop
    //   16: aload_3
    //   17: invokevirtual 401	java/io/File:canWrite	()Z
    //   20: ifeq +522 -> 542
    //   23: new 81	android/graphics/BitmapFactory$Options
    //   26: dup
    //   27: invokespecial 82	android/graphics/BitmapFactory$Options:<init>	()V
    //   30: astore_3
    //   31: aload_3
    //   32: iconst_1
    //   33: putfield 86	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   36: aload_1
    //   37: iconst_0
    //   38: aload_1
    //   39: arraylength
    //   40: aload_3
    //   41: invokestatic 405	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   44: pop
    //   45: aload_3
    //   46: getfield 96	android/graphics/BitmapFactory$Options:outWidth	I
    //   49: ifle +482 -> 531
    //   52: aload_3
    //   53: getfield 99	android/graphics/BitmapFactory$Options:outHeight	I
    //   56: ifle +475 -> 531
    //   59: ldc_w 407
    //   62: aload_3
    //   63: getfield 145	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   66: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: istore_2
    //   70: aconst_null
    //   71: astore 4
    //   73: iload_2
    //   74: ifeq +10 -> 84
    //   77: ldc_w 409
    //   80: astore_3
    //   81: goto +62 -> 143
    //   84: ldc 161
    //   86: aload_3
    //   87: getfield 145	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   90: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifeq +10 -> 103
    //   96: ldc_w 411
    //   99: astore_3
    //   100: goto +43 -> 143
    //   103: ldc 147
    //   105: aload_3
    //   106: getfield 145	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   109: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   112: ifeq +10 -> 122
    //   115: ldc_w 413
    //   118: astore_3
    //   119: goto +24 -> 143
    //   122: ldc 155
    //   124: aload_3
    //   125: getfield 145	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   128: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   131: ifeq +10 -> 141
    //   134: ldc_w 415
    //   137: astore_3
    //   138: goto +5 -> 143
    //   141: aconst_null
    //   142: astore_3
    //   143: aload_3
    //   144: ifnull +142 -> 286
    //   147: new 107	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   154: astore 5
    //   156: aload 5
    //   158: getstatic 395	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   161: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 5
    //   167: ldc_w 417
    //   170: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 5
    //   176: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   179: invokevirtual 124	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 5
    //   185: aload_3
    //   186: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 5
    //   192: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: astore_3
    //   196: new 71	java/io/File
    //   199: dup
    //   200: aload_3
    //   201: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   204: astore 6
    //   206: new 419	java/io/FileOutputStream
    //   209: dup
    //   210: aload 6
    //   212: invokespecial 420	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   215: astore 5
    //   217: aload 5
    //   219: aload_1
    //   220: invokevirtual 424	java/io/FileOutputStream:write	([B)V
    //   223: aload 5
    //   225: invokevirtual 425	java/io/FileOutputStream:close	()V
    //   228: iconst_1
    //   229: istore_2
    //   230: aload_3
    //   231: astore_1
    //   232: goto +179 -> 411
    //   235: astore_1
    //   236: aload 5
    //   238: astore_3
    //   239: goto +7 -> 246
    //   242: astore_1
    //   243: aload 4
    //   245: astore_3
    //   246: aload_3
    //   247: ifnull +7 -> 254
    //   250: aload_3
    //   251: invokevirtual 425	java/io/FileOutputStream:close	()V
    //   254: aload 6
    //   256: invokevirtual 428	java/io/File:exists	()Z
    //   259: ifeq +9 -> 268
    //   262: aload 6
    //   264: invokevirtual 431	java/io/File:delete	()Z
    //   267: pop
    //   268: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +13 -> 284
    //   274: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   277: iconst_2
    //   278: ldc_w 433
    //   281: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: aload_1
    //   285: athrow
    //   286: new 107	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   293: astore_3
    //   294: aload_3
    //   295: getstatic 395	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   298: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload_3
    //   303: ldc_w 417
    //   306: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload_3
    //   311: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   314: invokevirtual 124	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload_3
    //   319: ldc_w 409
    //   322: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_3
    //   327: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: astore_3
    //   331: new 71	java/io/File
    //   334: dup
    //   335: aload_3
    //   336: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   339: astore 5
    //   341: new 419	java/io/FileOutputStream
    //   344: dup
    //   345: aload 5
    //   347: invokespecial 420	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   350: astore 4
    //   352: aload_1
    //   353: iconst_0
    //   354: aload_1
    //   355: arraylength
    //   356: invokestatic 436	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   359: getstatic 170	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   362: bipush 75
    //   364: aload 4
    //   366: invokevirtual 176	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   369: istore_2
    //   370: aload 4
    //   372: invokevirtual 425	java/io/FileOutputStream:close	()V
    //   375: iload_2
    //   376: ifne +33 -> 409
    //   379: aload 5
    //   381: invokevirtual 428	java/io/File:exists	()Z
    //   384: ifeq +9 -> 393
    //   387: aload 5
    //   389: invokevirtual 431	java/io/File:delete	()Z
    //   392: pop
    //   393: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   396: ifeq +13 -> 409
    //   399: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   402: iconst_2
    //   403: ldc_w 438
    //   406: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: aload_3
    //   410: astore_1
    //   411: iload_2
    //   412: ifeq +61 -> 473
    //   415: new 293	android/content/Intent
    //   418: dup
    //   419: ldc_w 440
    //   422: invokespecial 441	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   425: astore_3
    //   426: new 107	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   433: astore 4
    //   435: aload 4
    //   437: ldc_w 443
    //   440: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload 4
    //   446: aload_1
    //   447: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload_3
    //   452: aload 4
    //   454: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 449	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   460: invokevirtual 453	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   463: pop
    //   464: invokestatic 350	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   467: aload_3
    //   468: invokevirtual 458	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   471: aload_1
    //   472: areturn
    //   473: new 210	java/io/IOException
    //   476: dup
    //   477: invokespecial 211	java/io/IOException:<init>	()V
    //   480: athrow
    //   481: astore_1
    //   482: aload 4
    //   484: astore_3
    //   485: goto +6 -> 491
    //   488: astore_1
    //   489: aconst_null
    //   490: astore_3
    //   491: aload_3
    //   492: ifnull +7 -> 499
    //   495: aload_3
    //   496: invokevirtual 425	java/io/FileOutputStream:close	()V
    //   499: aload 5
    //   501: invokevirtual 428	java/io/File:exists	()Z
    //   504: ifeq +9 -> 513
    //   507: aload 5
    //   509: invokevirtual 431	java/io/File:delete	()Z
    //   512: pop
    //   513: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   516: ifeq +13 -> 529
    //   519: getstatic 25	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   522: iconst_2
    //   523: ldc_w 438
    //   526: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: aload_1
    //   530: athrow
    //   531: new 460	java/lang/IllegalArgumentException
    //   534: dup
    //   535: ldc_w 462
    //   538: invokespecial 463	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   541: athrow
    //   542: new 210	java/io/IOException
    //   545: dup
    //   546: ldc_w 465
    //   549: invokespecial 466	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   552: athrow
    //   553: astore_1
    //   554: goto -326 -> 228
    //   557: astore_3
    //   558: goto -304 -> 254
    //   561: astore_1
    //   562: goto -187 -> 375
    //   565: astore_3
    //   566: goto -67 -> 499
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	569	0	this	MediaApiPlugin
    //   0	569	1	paramArrayOfByte	byte[]
    //   69	343	2	bool	boolean
    //   10	486	3	localObject1	Object
    //   557	1	3	localIOException1	IOException
    //   565	1	3	localIOException2	IOException
    //   71	412	4	localObject2	Object
    //   154	354	5	localObject3	Object
    //   204	59	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   217	223	235	finally
    //   206	217	242	finally
    //   352	370	481	finally
    //   341	352	488	finally
    //   223	228	553	java/io/IOException
    //   250	254	557	java/io/IOException
    //   370	375	561	java/io/IOException
    //   495	499	565	java/io/IOException
  }
  
  /* Error */
  JSONObject a(String paramString)
  {
    // Byte code:
    //   0: new 139	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: sipush 1024
    //   7: invokespecial 142	java/io/ByteArrayOutputStream:<init>	(I)V
    //   10: astore_2
    //   11: aconst_null
    //   12: aload_1
    //   13: invokestatic 475	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   16: astore_3
    //   17: new 107	java/lang/StringBuilder
    //   20: dup
    //   21: ldc 163
    //   23: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   26: astore 4
    //   28: aload_3
    //   29: ifnull +18 -> 47
    //   32: aload_3
    //   33: getstatic 170	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   36: bipush 80
    //   38: aload_2
    //   39: invokevirtual 176	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 184	android/graphics/Bitmap:recycle	()V
    //   47: aload 4
    //   49: aload_2
    //   50: invokevirtual 188	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   53: iconst_2
    //   54: invokestatic 194	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   57: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: new 68	org/json/JSONObject
    //   64: dup
    //   65: invokespecial 69	org/json/JSONObject:<init>	()V
    //   68: astore_3
    //   69: aload_3
    //   70: ldc_w 477
    //   73: aload 4
    //   75: invokevirtual 204	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: aload_3
    //   80: ldc_w 479
    //   83: aload_1
    //   84: invokevirtual 204	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   87: pop
    //   88: aload_2
    //   89: invokevirtual 482	java/io/ByteArrayOutputStream:flush	()V
    //   92: aload_2
    //   93: invokevirtual 483	java/io/ByteArrayOutputStream:close	()V
    //   96: aload_3
    //   97: areturn
    //   98: astore_1
    //   99: goto +25 -> 124
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 486	org/json/JSONException:printStackTrace	()V
    //   107: aload_2
    //   108: invokevirtual 482	java/io/ByteArrayOutputStream:flush	()V
    //   111: aload_2
    //   112: invokevirtual 483	java/io/ByteArrayOutputStream:close	()V
    //   115: aload_3
    //   116: areturn
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 487	java/io/IOException:printStackTrace	()V
    //   122: aload_3
    //   123: areturn
    //   124: aload_2
    //   125: invokevirtual 482	java/io/ByteArrayOutputStream:flush	()V
    //   128: aload_2
    //   129: invokevirtual 483	java/io/ByteArrayOutputStream:close	()V
    //   132: goto +8 -> 140
    //   135: astore_2
    //   136: aload_2
    //   137: invokevirtual 487	java/io/IOException:printStackTrace	()V
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	MediaApiPlugin
    //   0	142	1	paramString	String
    //   10	119	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   135	2	2	localIOException	IOException
    //   16	107	3	localObject	Object
    //   26	48	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   69	88	98	finally
    //   103	107	98	finally
    //   69	88	102	org/json/JSONException
    //   88	96	117	java/io/IOException
    //   107	115	117	java/io/IOException
    //   124	132	135	java/io/IOException
  }
  
  public void a()
  {
    Thread localThread = this.jdField_a_of_type_JavaLangThread;
    if (localThread != null) {
      localThread.interrupt();
    }
  }
  
  void a(Activity paramActivity, boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramActivity instanceof AppActivity))
    {
      paramActivity = (AppActivity)paramActivity;
      paramActivity.requestPermissions(new MediaApiPlugin.6(this, paramJSONObject, paramBoolean, paramActivity), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    if ((paramActivity instanceof BaseActivity))
    {
      paramActivity = (BaseActivity)paramActivity;
      paramActivity.requestPermissions(new MediaApiPlugin.7(this, paramJSONObject, paramBoolean, paramActivity), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
    }
  }
  
  void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    boolean bool1 = paramJSONObject.optBoolean("needCrop", false);
    int j = paramJSONObject.optInt("mediaType", 0);
    double d1 = paramJSONObject.optDouble("maxProportion", 2.0D);
    double d2 = paramJSONObject.optDouble("minProportion", 0.6D);
    int i = paramJSONObject.optInt("imageSizeLimit", 8192) * 1024;
    long l1 = paramJSONObject.optLong("videoSizeLimit", 512000L);
    long l2 = paramJSONObject.optLong("videoDurationLimit", 120L);
    Activity localActivity = this.mRuntime.a();
    String str = this.mRuntime.a().getAccount();
    boolean bool2 = localActivity instanceof AbsBaseWebViewActivity;
    boolean bool3 = localActivity instanceof WebUiUtils.MediaApiPluginInterface;
    Intent localIntent = new Intent();
    Object localObject;
    if (bool3)
    {
      localObject = (WebUiUtils.MediaApiPluginInterface)localActivity;
      if (((WebUiUtils.MediaApiPluginInterface)localObject).b())
      {
        localIntent.setClass(a(), NewPhotoListActivity.class);
        localIntent.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", true);
        localIntent.putExtra("PhotoConst.PLUGIN_APK", ((WebUiUtils.MediaApiPluginInterface)localObject).c());
        localIntent.putExtra("PhotoConst.PLUGIN_NAME", ((WebUiUtils.MediaApiPluginInterface)localObject).b());
        localIntent.putExtra("PhotoConst.UIN", this.mRuntime.a().getCurrentAccountUin());
        break label242;
      }
    }
    localIntent.setClass(localActivity, NewPhotoListActivity.class);
    label242:
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", localActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PeakConstants.showGifTypeIcon", true);
    if (bool1)
    {
      localObject = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getClipRectSize(localActivity, 103);
      localIntent.putExtra("PhotoConst.CLIP_WIDTH", ((Point)localObject).x);
      localIntent.putExtra("PhotoConst.CLIP_HEIGHT", ((Point)localObject).y);
      localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
      localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
      localIntent.putExtra("Business_Origin", 103);
      localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
      localIntent.putExtra("PhotoConst.TARGET_PATH", ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getUploadPhotoTempPath());
    }
    if (j == 0)
    {
      j = paramJSONObject.optInt("max", 1);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", j);
      if (j == 1) {
        localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      }
      localIntent.putExtra("imageSizeLimit", i);
      if (bool2) {
        ((AbsBaseWebViewActivity)localActivity).gotoSelectPicture(this, localIntent, (byte)2);
      } else if (bool3) {
        ((WebUiUtils.MediaApiPluginInterface)localActivity).a(this, localIntent, (byte)2);
      } else {
        WebViewUtil.a(this, localIntent, (byte)2, this.mRuntime.a());
      }
    }
    else if (j == 1)
    {
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 2);
      if (bool2) {
        ((AbsBaseWebViewActivity)localActivity).gotoSelectPicture(this, localIntent, (byte)3);
      } else {
        ((WebUiUtils.MediaApiPluginInterface)localActivity).a(this, localIntent, (byte)3);
      }
    }
    else if (j == 2)
    {
      localIntent.putExtra("uin", str);
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      localIntent.putExtra("PhotoConst.IS_FROM_TROOP_REWARD", true);
      localIntent.putExtra("maxProportion", d1);
      localIntent.putExtra("minProportion", d2);
      localIntent.putExtra("imageSizeLimit", i);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 1000L * l2);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", l1 * 1024L);
      if (bool2) {
        ((AbsBaseWebViewActivity)localActivity).gotoSelectPicture(this, localIntent, (byte)3);
      } else {
        ((WebUiUtils.MediaApiPluginInterface)localActivity).a(this, localIntent, (byte)3);
      }
    }
    b(localBaseApplication).edit().putString("getMediaParam", paramJSONObject.toString()).putBoolean("calledFromOpenApi", paramBoolean).commit();
  }
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle == null) {}
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool1 = "media".equals(paramString2);
    int j = 0;
    if (bool1)
    {
      if ((paramJsBridgeListener != null) && (paramJsBridgeListener.a)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      if (((!"getPicture".equals(paramString3)) && (!"getPictureV2".equals(paramString3))) || (paramVarArgs.length != 1)) {}
    }
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        paramString1.put("method", paramString3);
        paramString2 = paramString1.optString("callback");
        if ((TextUtils.isEmpty(paramString2)) && (!bool1)) {
          return true;
        }
        i = paramString1.optInt("source", 0);
        paramJsBridgeListener = BaseApplicationImpl.getContext();
        if (i == 0)
        {
          paramJsBridgeListener = this.mRuntime.a();
          boolean bool2 = paramJsBridgeListener instanceof AbsBaseWebViewActivity;
          boolean bool3 = paramJsBridgeListener instanceof WebUiUtils.MediaApiPluginInterface;
          if ((!bool2) && (!bool3)) {}
          try
          {
            if (((this.mRuntime.a() != null) && (this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof AppActivity))) || ((this.mRuntime.a() instanceof BaseActivity)))
            {
              i = j;
              if (Build.VERSION.SDK_INT >= 23)
              {
                i = j;
                if (this.mRuntime.a().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
                {
                  a(paramJsBridgeListener, bool1, paramString1);
                  i = 1;
                }
              }
              if (i != 0) {
                break label1966;
              }
              a(paramString1, bool1);
              return true;
            }
            if (bool1)
            {
              callJs4OpenApiIfNeeded(paramString3, 0, "[]");
              return true;
            }
            callJs(paramString2, new String[] { "2", "[]" });
            return true;
          }
          catch (Throwable paramJsBridgeListener)
          {
            QLog.d(jdField_a_of_type_JavaLangString, 1, "getPicture ", paramJsBridgeListener);
            return true;
          }
        }
        if (i != 1) {
          break label1966;
        }
        if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
          return true;
        }
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(AppConstants.SDCARD_PATH);
        paramVarArgs.append("photo/");
        paramVarArgs.append(System.currentTimeMillis());
        paramVarArgs.append(".jpg");
        paramVarArgs = paramVarArgs.toString();
        localIntent = new Intent();
        FileProvider7Helper.setSystemCapture(BaseApplicationImpl.getContext(), new File(paramVarArgs), localIntent);
        if (paramString1.optBoolean("front", false)) {
          localIntent.putExtra("android.intent.extras.CAMERA_FACING", 1);
        }
        localObject = this.mRuntime;
        if ((localObject != null) && (this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof AppActivity)))
        {
          localObject = (AppActivity)this.mRuntime.a();
          if ((Build.VERSION.SDK_INT < 23) || (((AppActivity)localObject).checkSelfPermission("android.permission.CAMERA") == 0)) {
            break label1974;
          }
          ((AppActivity)localObject).requestPermissions(new MediaApiPlugin.1(this, localIntent, paramJsBridgeListener, paramVarArgs, paramString1, bool1, (AppActivity)localObject), 1, new String[] { "android.permission.CAMERA" });
          break label1977;
        }
        if ((this.mRuntime == null) || (this.mRuntime.a() == null) || (!(this.mRuntime.a() instanceof BasePluginActivity))) {
          break label1983;
        }
        localObject = (BasePluginActivity)this.mRuntime.a();
        if ((Build.VERSION.SDK_INT < 23) || (((BasePluginActivity)localObject).checkSelfPermission("android.permission.CAMERA") == 0)) {
          break label1983;
        }
        ((BasePluginActivity)localObject).requestPermissions(new MediaApiPlugin.2(this, localIntent, paramJsBridgeListener, paramVarArgs, paramString1, bool1, (BasePluginActivity)localObject), 1, new String[] { "android.permission.CAMERA" });
      }
      catch (JSONException paramJsBridgeListener)
      {
        Intent localIntent;
        Object localObject;
        paramJsBridgeListener.printStackTrace();
        return true;
      }
      if (i == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
        ((StringBuilder)localObject).append("photo/");
        localObject = new File(((StringBuilder)localObject).toString());
        if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
        {
          QQToast.a(paramJsBridgeListener, 2131718574, 0).a();
          if (bool1)
          {
            callJs4OpenApiIfNeeded(paramString3, 0, "[]");
            return true;
          }
          callJs(paramString2, new String[] { "2", "[]" });
          return true;
        }
        try
        {
          startActivityForResult(localIntent, (byte)1);
          b(paramJsBridgeListener).edit().putString("camera_photo_path", paramVarArgs).putString("getMediaParam", paramString1.toString()).putBoolean("calledFromOpenApi", bool1).commit();
          return true;
        }
        catch (Exception paramString1)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, paramString1, new Object[0]);
          QQToast.a(paramJsBridgeListener, 2131690725, 0).a();
          return true;
        }
        if ((("getLocalImage".equals(paramString3)) || ("getLocalImageV2".equals(paramString3))) && (paramVarArgs.length == 1)) {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            paramString1 = paramJsBridgeListener.optString("callback");
            paramString2 = paramJsBridgeListener.optString("imageID");
            if (!TextUtils.isEmpty(paramString1))
            {
              if (TextUtils.isEmpty(paramString2)) {
                return true;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
              {
                paramVarArgs = this.mRuntime.a();
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramVarArgs, paramVarArgs.getResources().getDimensionPixelSize(2131299168));
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693895);
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this);
              }
              if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
              }
              if ("getLocalImageV2".equals(paramString3))
              {
                ThreadManager.post(new MediaApiPlugin.PrepareSinglePictureAndCallbackThreadV2(this, paramString1, paramJsBridgeListener.optInt("scaleMode", 0), paramString2), 5, null, true);
                return true;
              }
              ThreadManager.post(new MediaApiPlugin.PrepareSinglePictureAndCallbackThread(this, paramString1, paramJsBridgeListener.optInt("outMaxWidth", 1280), paramJsBridgeListener.optInt("outMaxHeight", 1280), paramJsBridgeListener.optInt("inMinWidth", 1), paramJsBridgeListener.optInt("inMinHeight", 1), paramString2), 5, null, true);
              return true;
            }
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            return true;
          }
        }
        if (("saveImage".equals(paramString3)) && (paramVarArgs.length == 1))
        {
          paramString2 = new AtomicBoolean(false);
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("callback");
            try
            {
              paramString3 = paramString1.optString("imagePath");
              if (!TextUtils.isEmpty(paramString3))
              {
                if (!new File(paramString3).exists())
                {
                  QQToast.a(this.mRuntime.a().getApplication(), 1, HardCodeUtil.a(2131706551), 0).a();
                  return true;
                }
                ThreadManager.post(new MediaApiPlugin.3(this, paramString3, paramJsBridgeListener, paramString2), 8, null, true);
                return true;
              }
              paramString1 = paramString1.getString("content");
              if ((!paramString1.startsWith("http://")) && (!paramString1.startsWith("https://")))
              {
                ThreadManager.getSubThreadHandler().post(new MediaApiPlugin.5(this, paramString1, paramJsBridgeListener, paramString2));
                return true;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
              {
                paramString3 = this.mRuntime.a();
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramString3, paramString3.getResources().getDimensionPixelSize(2131299168));
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693895);
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this);
              }
              if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
              }
              ThreadManager.post(new MediaApiPlugin.4(this, paramString1, paramJsBridgeListener, paramString2), 5, null, true);
              return true;
            }
            catch (OutOfMemoryError paramString1) {}
            if (!QLog.isDevelopLevel()) {
              break label1460;
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            if (!QLog.isDevelopLevel()) {
              break label1966;
            }
            paramString1 = jdField_a_of_type_JavaLangString;
            paramString2 = new StringBuilder();
            paramString2.append("saveImage failed:");
            paramString2.append(paramJsBridgeListener);
            QLog.d(paramString1, 4, paramString2.toString());
            return true;
          }
          catch (OutOfMemoryError paramString1)
          {
            paramJsBridgeListener = null;
          }
          paramString3 = jdField_a_of_type_JavaLangString;
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("saveImage failed:");
          paramVarArgs.append(paramString1);
          QLog.d(paramString3, 4, paramVarArgs.toString());
          label1460:
          if ((TextUtils.isEmpty(paramJsBridgeListener)) || (!paramString2.compareAndSet(false, true))) {
            break label1966;
          }
          paramString1 = new JSONObject();
        }
      }
      try
      {
        paramString1.put("retCode", -1);
        paramString1.put("msg", BaseApplicationImpl.getContext().getString(2131718389));
        label1510:
        if (bool1)
        {
          callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          return true;
        }
        callJs4OpenApiIfNeeded("saveImage", 0, paramString1.toString());
        return true;
        if (("previewLocalVideo".equals(paramString3)) && (paramVarArgs.length == 1))
        {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            if (QLog.isColorLevel())
            {
              paramString1 = new StringBuilder();
              paramString1.append("previewLocalVideo:");
              paramString1.append(paramJsBridgeListener);
              QLog.d("MediaApiPlugin", 2, paramString1.toString());
            }
            paramString1 = paramJsBridgeListener.optString("path");
            long l1 = paramJsBridgeListener.optLong("videoSize");
            long l2 = paramJsBridgeListener.optLong("videoDuration");
            a(this.mRuntime.a(), paramString1, l1, l2);
            return true;
          }
          catch (Exception paramJsBridgeListener)
          {
            if (!QLog.isColorLevel()) {
              break label1966;
            }
          }
          QLog.w("MediaApiPlugin", 2, "previewLocalVideo exp", paramJsBridgeListener);
          return true;
        }
        else if (("getIsLTUser".equals(paramString3)) && (paramVarArgs.length >= 1))
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("callback");
            paramString2 = BaseApplicationImpl.getContext();
            startActivityForResult(new Intent(paramString2, GetIsLTUserActivity.class), (byte)5);
            b(paramString2).edit().putString("getMediaParam", paramString1.toString()).putBoolean("calledFromOpenApi", bool1).commit();
            if (!QLog.isColorLevel()) {
              break label1966;
            }
            paramString1 = new StringBuilder();
            paramString1.append("WL_DEBUG GetIsLTUser args[0] = ");
            paramString1.append(paramVarArgs[0]);
            paramString1.append("callback = ");
            paramString1.append(paramJsBridgeListener);
            QLog.w("MediaApiPlugin", 2, paramString1.toString());
            return true;
          }
          catch (Exception paramJsBridgeListener)
          {
            if (!QLog.isColorLevel()) {
              break label1966;
            }
          }
          paramString1 = new StringBuilder();
          paramString1.append("WL_DEBUG GetIsLTUser e = ");
          paramString1.append(paramJsBridgeListener);
          QLog.w("MediaApiPlugin", 2, paramString1.toString());
          return true;
        }
        else if ("isCameraAvailable".equals(paramString3))
        {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
            if (!TextUtils.isEmpty(paramJsBridgeListener))
            {
              paramString1 = new JSONObject();
              paramString1.put("result", a());
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              return true;
            }
          }
          catch (Exception paramJsBridgeListener)
          {
            if (QLog.isColorLevel()) {
              QLog.w(jdField_a_of_type_JavaLangString, 2, "call isCameraAvailable error", paramJsBridgeListener);
            }
          }
        }
        label1966:
        return true;
        return false;
      }
      catch (JSONException paramString2)
      {
        break label1510;
      }
      label1974:
      break label1983;
      label1977:
      int i = 1;
      continue;
      label1983:
      i = 0;
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    Object localObject2 = b(BaseApplicationImpl.getContext());
    Object localObject3 = ((SharedPreferences)localObject2).getString("camera_photo_path", "");
    Object localObject1 = ((SharedPreferences)localObject2).getString("getMediaParam", "");
    boolean bool1 = ((SharedPreferences)localObject2).getBoolean("calledFromOpenApi", false);
    ((SharedPreferences)localObject2).edit().remove("camera_photo_path").remove("getMediaParam").remove("calledFromOpenApi").commit();
    if (paramByte == 6) {
      localObject1 = paramIntent.getStringExtra("savedParam");
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (!bool1)) {
      return;
    }
    try
    {
      localJSONObject = new JSONObject((String)localObject1);
      String str = localJSONObject.optString("method");
      localObject2 = localJSONObject.optString("callback");
      boolean bool2 = TextUtils.isEmpty((CharSequence)localObject2);
      if ((bool2) && (!bool1)) {
        return;
      }
      if ((paramByte != 1) && (paramByte != 2) && (paramByte != 6))
      {
        if (paramByte == 3)
        {
          if (paramInt == -1)
          {
            if (paramIntent != null) {
              localObject1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
            } else {
              localObject1 = null;
            }
            if ((paramIntent != null) && (paramIntent.getBooleanExtra("PhotoConst.IS_VIDEO_SELECTED", false))) {
              paramInt = 1;
            } else {
              paramInt = 0;
            }
            long l2 = 0L;
            long l1;
            if (paramIntent != null) {
              l1 = paramIntent.getLongExtra("PhotoConst.VIDEO_SIZE", 0L);
            } else {
              l1 = 0L;
            }
            if (paramIntent != null) {
              l2 = paramIntent.getLongExtra("file_send_duration", 0L);
            }
            if (paramInt != 0)
            {
              paramIntent = new JSONArray();
              localObject1 = a((String)localObject1);
              try
              {
                ((JSONObject)localObject1).put("videoDuration", l2 / 1000L);
                ((JSONObject)localObject1).put("videoSize", l1 / 1024L);
                ((JSONObject)localObject1).put("mediaType", 1);
              }
              catch (JSONException localJSONException)
              {
                localJSONException.printStackTrace();
              }
              paramIntent.put(localObject1);
              callJs((String)localObject2, new String[] { "0", paramIntent.toString() });
              return;
            }
            this.jdField_a_of_type_JavaLangThread = new MediaApiPlugin.PreparePicturesAndCallbackThread(this, (String)localObject2, bool1, localJSONException, localJSONObject.optInt("outMaxWidth", 2000), localJSONObject.optInt("outMaxHeight", 3000), localJSONObject.optInt("inMinWidth", 0), localJSONObject.optInt("inMinHeight", 0), new String[] { localObject1 });
            ThreadManager.post(this.jdField_a_of_type_JavaLangThread, 5, null, true);
          }
        }
        else if (paramByte == 5)
        {
          i = paramIntent.getIntExtra("pstnGrayFlag", 0);
          bool2 = paramIntent.getBooleanExtra("isBindingContact", false);
          if (i != 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if ((bool1) && (bool2)) {
            paramInt = 1;
          } else if (!bool2) {
            paramInt = 2;
          } else {
            paramInt = 0;
          }
          callJs((String)localObject2, new String[] { String.valueOf(paramInt) });
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("GetIsLTUser pstnGrayFlag = ");
            paramIntent.append(i);
            paramIntent.append("|");
            paramIntent.append(bool2);
            paramIntent.append("|");
            paramIntent.append(bool1);
            paramIntent.append("|");
            paramIntent.append(paramInt);
            QLog.w("MediaApiPlugin", 2, paramIntent.toString());
          }
        }
      }
      else if (paramInt == -1)
      {
        if (paramByte == 1)
        {
          paramIntent = new String[1];
          paramIntent[0] = localObject3;
        }
        else
        {
          if (paramIntent != null) {
            paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
          } else {
            paramIntent = null;
          }
          if ((paramIntent == null) || (paramIntent.size() == 0)) {
            break label1197;
          }
          paramIntent = (String[])paramIntent.toArray(new String[paramIntent.size()]);
        }
        if ((paramByte == 1) && (localJSONObject.optBoolean("needCrop", false)))
        {
          if (a() == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, " currentContext is null");
            }
            return;
          }
          localObject2 = new Intent();
          paramInt = this.mRuntime.a().switchRequestCode(this, (byte)6);
          ((Intent)localObject2).putExtra("keyAction", "actionSelectPicture");
          ((Intent)localObject2).putExtra("requestCode", paramInt);
          ((Intent)localObject2).putExtra("savedParam", (String)localObject1);
          ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoEdit((Activity)a(), (Intent)localObject2, paramIntent[0], 103);
          return;
        }
        if (!localJSONObject.optBoolean("urlOnly", false)) {}
      }
    }
    catch (JSONException paramIntent)
    {
      JSONObject localJSONObject;
      int i;
      label851:
      paramIntent.printStackTrace();
      label959:
      return;
    }
    try
    {
      localObject1 = new JSONArray();
      i = paramIntent.length;
      paramInt = 0;
      if (paramInt < i)
      {
        localJSONObject = paramIntent[paramInt];
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("data", "");
        ((JSONObject)localObject3).put("imageID", localJSONObject);
        ((JSONObject)localObject3).put("match", 0);
        ((JSONArray)localObject1).put(localObject3);
        paramInt += 1;
        break label851;
      }
      if (bool1)
      {
        callJs4OpenApiIfNeeded(localJSONException, 0, ((JSONArray)localObject1).toString());
        return;
      }
      callJs((String)localObject2, new String[] { "0", ((JSONArray)localObject1).toString() });
      return;
    }
    catch (JSONException paramIntent)
    {
      break label959;
    }
    if (bool1)
    {
      callJs4OpenApiIfNeeded(localJSONException, 0, "[]");
      return;
    }
    callJs((String)localObject2, new String[] { "2", "[]" });
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      localObject1 = this.mRuntime.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog((Context)localObject1, ((Activity)localObject1).getResources().getDimensionPixelSize(2131299168));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693895);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this);
    }
    localObject1 = this.jdField_a_of_type_JavaLangThread;
    if (localObject1 != null) {
      ((Thread)localObject1).interrupt();
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    if ("getPictureV2".equals(localJSONException)) {
      this.jdField_a_of_type_JavaLangThread = new MediaApiPlugin.PreparePicturesAndCallbackThreadV2(this, (String)localObject2, localJSONObject.optInt("scaleMode", 0), paramIntent);
    } else {
      this.jdField_a_of_type_JavaLangThread = new MediaApiPlugin.PreparePicturesAndCallbackThread(this, (String)localObject2, bool1, localJSONException, localJSONObject.optInt("outMaxWidth", 1280), localJSONObject.optInt("outMaxHeight", 1280), localJSONObject.optInt("inMinWidth", 1), localJSONObject.optInt("inMinHeight", 1), paramIntent);
    }
    ThreadManager.post(this.jdField_a_of_type_JavaLangThread, 5, null, true);
    return;
    label1197:
    if (bool1)
    {
      callJs4OpenApiIfNeeded(localJSONException, 0, "[]");
      return;
    }
    callJs((String)localObject2, new String[] { "2", "[]" });
    return;
    if (bool1)
    {
      callJs4OpenApiIfNeeded(localJSONException, 0, "[]");
      return;
    }
    callJs((String)localObject2, new String[] { "1", "[]" });
  }
  
  protected void onDestroy()
  {
    Object localObject = this.jdField_a_of_type_JavaLangThread;
    if (localObject != null) {
      ((Thread)localObject).interrupt();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    localObject = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    if (localObject != null) {
      ((TroopMemberApiClient)localObject).b();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin
 * JD-Core Version:    0.7.0.1
 */