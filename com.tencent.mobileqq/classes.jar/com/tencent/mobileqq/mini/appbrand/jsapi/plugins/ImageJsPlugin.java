package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import bhkd;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import zom;

public class ImageJsPlugin
  extends BaseJsPlugin
{
  public static final String ACTION_CHOOSE_IMAGE = "micro_api_choose_image";
  private static final Set<String> S_EVENT_MAP = new ImageJsPlugin.1();
  private static final String TAG = "ImageJsPlugin";
  private static final boolean USE_NATIVE_CAMERA_FLAG = true;
  private int mCallBackId = -1;
  private boolean mHasChoosePhoto;
  private boolean mHasRegisterChooseImageReceiver;
  private JsRuntime mJsRunTime;
  private boolean mNeedCompress;
  private boolean mShowOriBtn;
  private BroadcastReceiver receiver = new ImageJsPlugin.7(this);
  
  private void callbackChooseImage(ArrayList<String> paramArrayList, JsRuntime paramJsRuntime, int paramInt)
  {
    if (this.mHasChoosePhoto) {
      return;
    }
    if (this.mNeedCompress)
    {
      ThreadManager.getFileThreadHandler().post(new ImageJsPlugin.5(this, paramArrayList, paramJsRuntime, paramInt));
      return;
    }
    ThreadManager.getFileThreadHandler().post(new ImageJsPlugin.6(this, paramArrayList, paramJsRuntime, paramInt));
  }
  
  private void callbackGetImageInfo(String paramString, JsRuntime paramJsRuntime, int paramInt)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramString, localOptions);
      JSONObject localJSONObject = new JSONObject();
      String str = getExifOrientation(paramString);
      int j;
      int i;
      if (("left".equals(str)) || ("right".equals(str)))
      {
        j = localOptions.outHeight;
        i = localOptions.outWidth;
        str = "up";
      }
      for (;;)
      {
        localJSONObject.put("width", j);
        localJSONObject.put("height", i);
        localJSONObject.put("path", MiniAppFileManager.getInstance().getWxFilePath(paramString));
        localJSONObject.put("type", ImageUtil.getType(localOptions));
        localJSONObject.put("orientation", str);
        this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, "getImageInfo", localJSONObject, paramInt);
        return;
        j = localOptions.outWidth;
        i = localOptions.outHeight;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.e("ImageJsPlugin", 1, "getimageinfo error,", paramString);
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "getImageInfo", null, paramInt);
    }
  }
  
  private void callbackJsChooseImage(ArrayList<String> paramArrayList, JsRuntime paramJsRuntime, int paramInt)
  {
    JSONArray localJSONArray;
    Object localObject;
    try
    {
      this.mHasChoosePhoto = true;
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "chooseImage", null, "cancel", paramInt);
        return;
      }
      if (paramArrayList == null) {
        break label285;
      }
      localJSONArray = new JSONArray();
      localObject = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str1 = (String)paramArrayList.next();
        if (!TextUtils.isEmpty(str1))
        {
          String str2 = MiniAppFileManager.getInstance().getWxFilePath(str1);
          localJSONArray.put(str2);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("path", str2);
          localJSONObject.put("size", new File(str1).length());
          ((JSONArray)localObject).put(localJSONObject);
        }
      }
      QLog.d("ImageJsPlugin", 2, "chooseImage photoArray=" + localJSONArray.toString() + ",fileArray=" + ((JSONArray)localObject).toString());
    }
    catch (Exception paramArrayList)
    {
      this.mHasChoosePhoto = false;
      if (QLog.isColorLevel()) {
        QLog.e("ImageJsPlugin", 2, paramArrayList, new Object[0]);
      }
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "chooseImage", null, paramInt);
      return;
    }
    paramArrayList = (ArrayList<String>)localObject;
    for (;;)
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("tempFilePaths", localJSONArray);
      if (paramArrayList != null) {
        ((JSONObject)localObject).put("tempFiles", paramArrayList);
      }
      this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, "chooseImage", (JSONObject)localObject, paramInt);
      return;
      label285:
      paramArrayList = null;
      localJSONArray = null;
    }
  }
  
  private void compressImage(String paramString, int paramInt1, int paramInt2, int paramInt3, JsRuntime paramJsRuntime, int paramInt4)
  {
    try
    {
      int i = ImageUtil.getExifOrientation(paramString);
      Object localObject1 = ImageUtil.getLocalBitmap(paramString);
      if (localObject1 != null)
      {
        int j = ((Bitmap)localObject1).getWidth();
        if ((((Bitmap)localObject1).getHeight() < paramInt3) || (j < paramInt2))
        {
          Object localObject2 = "destSize invalid(" + paramInt2 + "," + paramInt3 + ")";
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "compressImage", null, (String)localObject2, paramInt4);
          localObject2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, paramInt1, (OutputStream)localObject2);
          localObject1 = BitmapFactory.decodeStream(new ByteArrayInputStream(((ByteArrayOutputStream)localObject2).toByteArray()), null, null);
          if ((i == 0) || (localObject1 == null)) {
            break label289;
          }
          localObject2 = ImageUtil.rotaingImageView(i, (Bitmap)localObject1);
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject2;
        }
        for (;;)
        {
          paramString = MiniAppFileManager.getInstance().getTmpPath(paramString.hashCode() + ".jpg");
          ImageUtil.saveBitmapToFile((Bitmap)localObject1, new File(paramString));
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("tempFilePath", MiniAppFileManager.getInstance().getWxFilePath(paramString));
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, "compressImage", (JSONObject)localObject1, paramInt4);
          return;
          localObject1 = ThumbnailUtils.extractThumbnail((Bitmap)localObject1, paramInt2, paramInt3);
          break;
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.e("ImageJsPlugin", 1, "compressImage error,", paramString);
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "compressImage", null, paramInt4);
      return;
    }
    label289:
  }
  
  private void compressImage(String paramString, int paramInt1, JsRuntime paramJsRuntime, int paramInt2)
  {
    for (;;)
    {
      try
      {
        int i = ImageUtil.getExifOrientation(paramString);
        Object localObject1 = ImageUtil.getLocalBitmap(paramString);
        if (localObject1 != null)
        {
          Object localObject2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, paramInt1, (OutputStream)localObject2);
          localObject1 = BitmapFactory.decodeStream(new ByteArrayInputStream(((ByteArrayOutputStream)localObject2).toByteArray()), null, null);
          if ((i != 0) && (localObject1 != null))
          {
            localObject2 = ImageUtil.rotaingImageView(i, (Bitmap)localObject1);
            ((Bitmap)localObject1).recycle();
            localObject1 = localObject2;
            paramString = MiniAppFileManager.getInstance().getTmpPath(paramString.hashCode() + ".jpg");
            ImageUtil.saveBitmapToFile((Bitmap)localObject1, new File(paramString));
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("tempFilePath", MiniAppFileManager.getInstance().getWxFilePath(paramString));
            this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, "compressImage", (JSONObject)localObject1, paramInt2);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ImageJsPlugin", 1, "compressImage error,", paramString);
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "compressImage", null, paramInt2);
        return;
      }
    }
  }
  
  private ArrayList<String> compressImages(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return paramArrayList;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(compressSingleImg((String)paramArrayList.next()));
    }
    return localArrayList;
  }
  
  /* Error */
  private String compressSingleImg(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 251	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aload_1
    //   8: areturn
    //   9: new 257	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 260	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: invokestatic 173	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   22: ldc_w 396
    //   25: invokevirtual 369	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore 11
    //   30: aload 11
    //   32: ifnonnull +16 -> 48
    //   35: ldc 14
    //   37: iconst_1
    //   38: ldc_w 398
    //   41: invokestatic 400	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: ldc_w 402
    //   47: areturn
    //   48: new 257	java/io/File
    //   51: dup
    //   52: aload 11
    //   54: invokespecial 260	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore 12
    //   59: aconst_null
    //   60: astore 8
    //   62: aconst_null
    //   63: astore 9
    //   65: aconst_null
    //   66: astore 7
    //   68: aload 8
    //   70: astore 5
    //   72: aload 9
    //   74: astore_3
    //   75: invokestatic 270	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +40 -> 118
    //   81: aload 8
    //   83: astore 5
    //   85: aload 9
    //   87: astore_3
    //   88: ldc 14
    //   90: iconst_2
    //   91: new 277	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 278	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 404
    //   101: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload 4
    //   106: invokevirtual 264	java/io/File:length	()J
    //   109: invokevirtual 407	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   112: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 400	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload 8
    //   120: astore 5
    //   122: aload 9
    //   124: astore_3
    //   125: new 122	android/graphics/BitmapFactory$Options
    //   128: dup
    //   129: invokespecial 123	android/graphics/BitmapFactory$Options:<init>	()V
    //   132: astore 4
    //   134: aload 8
    //   136: astore 5
    //   138: aload 9
    //   140: astore_3
    //   141: aload 4
    //   143: iconst_2
    //   144: putfield 410	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   147: aload 8
    //   149: astore 5
    //   151: aload 9
    //   153: astore_3
    //   154: aload_1
    //   155: aload 4
    //   157: invokestatic 411	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   160: astore 10
    //   162: aload 7
    //   164: astore 4
    //   166: aload 10
    //   168: ifnull +128 -> 296
    //   171: aload 8
    //   173: astore 5
    //   175: aload 9
    //   177: astore_3
    //   178: aload_1
    //   179: invokestatic 304	com/tencent/mobileqq/mini/util/ImageUtil:getExifOrientation	(Ljava/lang/String;)I
    //   182: istore_2
    //   183: aload 8
    //   185: astore 5
    //   187: aload 9
    //   189: astore_3
    //   190: ldc 14
    //   192: iconst_2
    //   193: new 277	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 278	java/lang/StringBuilder:<init>	()V
    //   200: ldc_w 413
    //   203: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: iload_2
    //   207: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 295	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: aload 10
    //   218: astore 6
    //   220: iload_2
    //   221: ifeq +30 -> 251
    //   224: aload 8
    //   226: astore 5
    //   228: aload 9
    //   230: astore_3
    //   231: iload_2
    //   232: aload 10
    //   234: invokestatic 358	com/tencent/mobileqq/mini/util/ImageUtil:rotaingImageView	(ILandroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   237: astore 6
    //   239: aload 8
    //   241: astore 5
    //   243: aload 9
    //   245: astore_3
    //   246: aload 10
    //   248: invokevirtual 361	android/graphics/Bitmap:recycle	()V
    //   251: aload 7
    //   253: astore 4
    //   255: aload 6
    //   257: ifnull +39 -> 296
    //   260: aload 8
    //   262: astore 5
    //   264: aload 9
    //   266: astore_3
    //   267: new 415	java/io/FileOutputStream
    //   270: dup
    //   271: aload 12
    //   273: invokespecial 418	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   276: astore 4
    //   278: aload 6
    //   280: getstatic 335	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   283: bipush 50
    //   285: aload 4
    //   287: invokevirtual 339	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   290: pop
    //   291: aload 4
    //   293: invokevirtual 421	java/io/FileOutputStream:flush	()V
    //   296: aload 4
    //   298: astore 5
    //   300: aload 4
    //   302: astore_3
    //   303: invokestatic 270	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   306: ifeq +40 -> 346
    //   309: aload 4
    //   311: astore 5
    //   313: aload 4
    //   315: astore_3
    //   316: ldc 14
    //   318: iconst_2
    //   319: new 277	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 278	java/lang/StringBuilder:<init>	()V
    //   326: ldc_w 423
    //   329: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload 12
    //   334: invokevirtual 264	java/io/File:length	()J
    //   337: invokevirtual 407	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   340: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 400	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: aload 4
    //   348: ifnull +8 -> 356
    //   351: aload 4
    //   353: invokevirtual 426	java/io/FileOutputStream:close	()V
    //   356: aload 11
    //   358: areturn
    //   359: astore 4
    //   361: aload 5
    //   363: astore_3
    //   364: invokestatic 270	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq +18 -> 385
    //   370: aload 5
    //   372: astore_3
    //   373: ldc 14
    //   375: iconst_2
    //   376: aload 4
    //   378: iconst_0
    //   379: anewarray 272	java/lang/Object
    //   382: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   385: aload 5
    //   387: ifnull -380 -> 7
    //   390: aload 5
    //   392: invokevirtual 426	java/io/FileOutputStream:close	()V
    //   395: aload_1
    //   396: areturn
    //   397: astore_3
    //   398: aload_1
    //   399: areturn
    //   400: astore_1
    //   401: aload_3
    //   402: ifnull +7 -> 409
    //   405: aload_3
    //   406: invokevirtual 426	java/io/FileOutputStream:close	()V
    //   409: aload_1
    //   410: athrow
    //   411: astore_1
    //   412: goto -56 -> 356
    //   415: astore_3
    //   416: goto -7 -> 409
    //   419: astore_1
    //   420: aload 4
    //   422: astore_3
    //   423: goto -22 -> 401
    //   426: astore_3
    //   427: aload 4
    //   429: astore 5
    //   431: aload_3
    //   432: astore 4
    //   434: goto -73 -> 361
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	437	0	this	ImageJsPlugin
    //   0	437	1	paramString	String
    //   182	50	2	i	int
    //   74	299	3	localObject1	Object
    //   397	9	3	localException1	Exception
    //   415	1	3	localException2	Exception
    //   422	1	3	localThrowable1	Throwable
    //   426	6	3	localThrowable2	Throwable
    //   17	335	4	localObject2	Object
    //   359	69	4	localThrowable3	Throwable
    //   432	1	4	localObject3	Object
    //   70	360	5	localObject4	Object
    //   218	61	6	localBitmap1	Bitmap
    //   66	186	7	localObject5	Object
    //   60	201	8	localObject6	Object
    //   63	202	9	localObject7	Object
    //   160	87	10	localBitmap2	Bitmap
    //   28	329	11	str	String
    //   57	276	12	localFile	File
    // Exception table:
    //   from	to	target	type
    //   75	81	359	java/lang/Throwable
    //   88	118	359	java/lang/Throwable
    //   125	134	359	java/lang/Throwable
    //   141	147	359	java/lang/Throwable
    //   154	162	359	java/lang/Throwable
    //   178	183	359	java/lang/Throwable
    //   190	216	359	java/lang/Throwable
    //   231	239	359	java/lang/Throwable
    //   246	251	359	java/lang/Throwable
    //   267	278	359	java/lang/Throwable
    //   303	309	359	java/lang/Throwable
    //   316	346	359	java/lang/Throwable
    //   390	395	397	java/lang/Exception
    //   75	81	400	finally
    //   88	118	400	finally
    //   125	134	400	finally
    //   141	147	400	finally
    //   154	162	400	finally
    //   178	183	400	finally
    //   190	216	400	finally
    //   231	239	400	finally
    //   246	251	400	finally
    //   267	278	400	finally
    //   303	309	400	finally
    //   316	346	400	finally
    //   364	370	400	finally
    //   373	385	400	finally
    //   351	356	411	java/lang/Exception
    //   405	409	415	java/lang/Exception
    //   278	296	419	finally
    //   278	296	426	java/lang/Throwable
  }
  
  private ArrayList<String> copyImages(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return paramArrayList;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      paramArrayList = (String)localIterator.next();
      String str = MiniAppFileManager.getInstance().copyTmpFile(paramArrayList);
      if (TextUtils.isEmpty(str)) {}
      for (;;)
      {
        localArrayList.add(paramArrayList);
        break;
        paramArrayList = str;
      }
    }
    return localArrayList;
  }
  
  private File createImageFile(Context paramContext)
  {
    return new File(MiniAppFileManager.getInstance().getTmpPath("jpg"));
  }
  
  private String getExifOrientation(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      if (paramString != null) {}
      switch (paramString.getAttributeInt("Orientation", -1))
      {
      default: 
        return "up";
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        QLog.e("ImageJsPlugin", 1, "getExifOrientation error." + paramString);
        paramString = null;
      }
      return "up";
    }
    return "up-mirrored";
    return "down";
    return "down-mirrored";
    return "left-mirrored";
    return "right";
    return "right-mirrored";
    return "left";
  }
  
  private void openCamera(Activity paramActivity, JsRuntime paramJsRuntime, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    openNativeCamera(paramActivity, paramJsRuntime, paramInt);
  }
  
  private void openChoosePhotoActivity(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 4);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 6);
    localIntent.putExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME", "micro_api_choose_image");
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.original_button", paramBoolean);
    paramActivity.startActivity(localIntent);
    bhkd.anim(paramActivity, false, true);
  }
  
  private void openNativeCamera(Activity paramActivity, JsRuntime paramJsRuntime, int paramInt)
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    if (localIntent.resolveActivity(paramActivity.getPackageManager()) == null) {}
    File localFile;
    do
    {
      return;
      localFile = createImageFile(paramActivity);
    } while (localFile == null);
    MiniAppController.getInstance().setActivityResultListener(new ImageJsPlugin.4(this, localFile, paramJsRuntime, paramInt));
    localIntent.putExtra("output", FileProvider7Helper.getUriForFile(paramActivity, localFile));
    paramActivity.startActivityForResult(localIntent, 4);
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("ImageJsPlugin", 2, "handleNativeRequest eventName=" + paramString1 + ",jsonParams=" + paramString2);
    this.mNeedCompress = false;
    this.mHasChoosePhoto = false;
    this.mShowOriBtn = false;
    this.mJsRunTime = paramJsRuntime;
    this.mCallBackId = paramInt;
    if ("chooseImage".equals(paramString1)) {}
    for (;;)
    {
      Object localObject1;
      int i;
      int m;
      Object localObject2;
      int n;
      int k;
      try
      {
        if (!this.mHasRegisterChooseImageReceiver)
        {
          localObject1 = new IntentFilter();
          ((IntentFilter)localObject1).addAction("micro_api_choose_image");
          AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApp().registerReceiver(this.receiver, (IntentFilter)localObject1);
          this.mHasRegisterChooseImageReceiver = true;
        }
        localObject1 = new JSONObject(paramString2);
        j = ((JSONObject)localObject1).optInt("count", 9);
        paramString2 = ((JSONObject)localObject1).optJSONArray("sizeType");
        localObject1 = ((JSONObject)localObject1).optJSONArray("sourceType");
        i = j;
        if (j <= 9) {
          break label1329;
        }
        i = 9;
      }
      catch (Throwable paramString2)
      {
        QLog.e("ImageJsPlugin", 1, paramString1 + " error,", paramString2);
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
        continue;
        if (!"camera".equals(((JSONArray)localObject1).optString(0))) {
          continue;
        }
        openCamera(this.jsPluginEngine.getActivityContext(), paramJsRuntime, paramInt);
        continue;
        openChoosePhotoActivity(this.jsPluginEngine.getActivityContext(), i, this.mShowOriBtn);
        continue;
      }
      if (m < paramString2.length())
      {
        localObject2 = paramString2.optString(m);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          n = j;
        }
        else if (((String)localObject2).equals("original"))
        {
          n = 1;
        }
        else
        {
          n = j;
          if (((String)localObject2).equals("compressed"))
          {
            k = 1;
            n = j;
          }
        }
      }
      else
      {
        if (k != 0)
        {
          if (j != 0) {
            this.mShowOriBtn = true;
          }
        }
        else
        {
          if (((JSONArray)localObject1).length() != 2) {
            continue;
          }
          AppBrandTask.runTaskOnUiThread(new ImageJsPlugin.2(this, paramJsRuntime, paramInt, i));
          return "";
        }
        this.mNeedCompress = true;
        continue;
        if ("previewImage".equals(paramString1))
        {
          try
          {
            paramString2 = new JSONObject(paramString2);
            localObject1 = paramString2.optString("current", "");
            localObject2 = paramString2.optJSONArray("urls");
            paramString2 = new ArrayList();
            j = 0;
            i = 0;
            while (i < ((JSONArray)localObject2).length())
            {
              String str1 = ((JSONArray)localObject2).optString(i);
              if (str1.equals(localObject1)) {
                j = i;
              }
              String str2 = MiniAppFileManager.getInstance().getAbsolutePath(str1);
              paramString2.add(str2);
              QLog.d("ImageJsPlugin", 1, "previewImage wxFilePath=" + str1 + ",localFilePath=" + str2);
              i += 1;
            }
            if (paramString2 != null)
            {
              localObject1 = new Intent(this.jsPluginEngine.getActivityContext(), TroopAvatarWallPreviewActivity.class);
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("index", j);
              ((Bundle)localObject2).putStringArrayList("seqNum", paramString2);
              ((Bundle)localObject2).putBoolean("needBottomBar", false);
              ((Bundle)localObject2).putBoolean("is_show_action", true);
              ((Bundle)localObject2).putBoolean("is_not_show_index", true);
              ((Bundle)localObject2).putBoolean("is_need_to_aio", false);
              ((Bundle)localObject2).putBoolean("is_from_plugin", true);
              ((Intent)localObject1).putExtras((Bundle)localObject2);
              ((Intent)localObject1).addFlags(603979776);
              this.jsPluginEngine.getActivityContext().startActivity((Intent)localObject1);
            }
            this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
          }
          catch (Exception paramString2)
          {
            for (;;)
            {
              QLog.e("ImageJsPlugin", 2, paramString1 + " error,", paramString2);
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
            }
          }
          return "";
        }
        if ("getImageInfo".equals(paramString1)) {
          for (;;)
          {
            try
            {
              paramString2 = new JSONObject(paramString2).optString("src", "");
              if (TextUtils.isEmpty(paramString2)) {
                continue;
              }
              paramString2 = MiniAppFileManager.getInstance().getAbsolutePath(paramString2);
              if (TextUtils.isEmpty(paramString2)) {
                continue;
              }
              callbackGetImageInfo(paramString2, paramJsRuntime, paramInt);
            }
            catch (Exception paramString2)
            {
              QLog.e("ImageJsPlugin", 2, paramString1 + " error.", paramString2);
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
              continue;
            }
            return "";
            paramString2 = null;
            continue;
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "image path error.", paramInt);
          }
        }
        if ("saveImageToPhotosAlbum".equals(paramString1)) {
          try
          {
            paramString2 = new JSONObject(paramString2).optString("filePath", "");
            if (!TextUtils.isEmpty(paramString2))
            {
              paramString2 = MiniAppFileManager.getInstance().getAbsolutePath(paramString2);
              localObject1 = new File(paramString2);
              localObject1 = ShortVideoUtils.d() + System.currentTimeMillis() / 1000L + "_" + ((File)localObject1).getName();
              if (zom.a(this.jsPluginEngine.getActivityContext(), paramString2, (String)localObject1)) {
                this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
              }
              for (;;)
              {
                return "";
                this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "save failed.", paramInt);
              }
            }
          }
          catch (Exception paramString2)
          {
            for (;;)
            {
              QLog.e("ImageJsPlugin", 1, paramString1 + " error", paramString2);
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
              continue;
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "save failed.", paramInt);
            }
          }
        }
        if ("compressImage".equals(paramString1)) {}
        for (;;)
        {
          try
          {
            paramString2 = new JSONObject(paramString2);
            localObject1 = paramString2.optString("src");
            i = paramString2.optInt("quality");
            j = paramString2.optInt("destWidth");
            k = paramString2.optInt("destHeight");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              continue;
            }
            paramString2 = MiniAppFileManager.getInstance().getAbsolutePath((String)localObject1);
            if (TextUtils.isEmpty(paramString2)) {
              continue;
            }
            if ((k > 0) && (j > 0)) {
              continue;
            }
            compressImage(paramString2, i, paramJsRuntime, paramInt);
          }
          catch (Exception paramString2)
          {
            QLog.e("ImageJsPlugin", 1, paramString1 + " error", paramString2);
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
            continue;
            compressImage(paramString2, i, j, k, paramJsRuntime, paramInt);
            continue;
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
            continue;
          }
          return "";
          paramString2 = null;
          continue;
          if (((k <= 0) || (j > 0)) && ((k > 0) || (j <= 0))) {
            continue;
          }
          paramString2 = "destSize invalid(" + j + "," + k + ")";
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramString2, paramInt);
        }
        for (;;)
        {
          break;
          label1329:
          if (i < 1) {
            i = 1;
          }
        }
        if (paramString2 == null) {
          continue;
        }
        j = 0;
        k = 0;
        m = 0;
        continue;
      }
      m += 1;
      int j = n;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.receiver != null) && (this.mHasRegisterChooseImageReceiver)) {}
    try
    {
      AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApp().unregisterReceiver(this.receiver);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ImageJsPlugin", 1, "unregisterReceiver exception", localThrowable);
    }
  }
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ImageJsPlugin
 * JD-Core Version:    0.7.0.1
 */