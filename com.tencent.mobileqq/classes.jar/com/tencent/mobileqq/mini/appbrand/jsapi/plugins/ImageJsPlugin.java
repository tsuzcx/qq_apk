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
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import baaf;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
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
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import vlm;

public class ImageJsPlugin
  extends BaseJsPlugin
{
  public static final String ACTION_CHOOSE_IMAGE = "micro_api_choose_image";
  private static final Set<String> S_EVENT_MAP = new ImageJsPlugin.1();
  private static final String TAG = "ImageJsPlugin";
  private static final boolean USE_NATIVE_CAMERA_FLAG = true;
  private int mCallBackId = -1;
  private boolean mHasChoosePhoto;
  private JsRuntime mJsRunTime;
  private boolean mNeedCompress;
  private BroadcastReceiver receiver = new ImageJsPlugin.5(this);
  
  public ImageJsPlugin()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("micro_api_choose_image");
    AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApp().registerReceiver(this.receiver, localIntentFilter);
  }
  
  private void callbackChooseImage(ArrayList<String> paramArrayList, JsRuntime paramJsRuntime, int paramInt)
  {
    if (this.mHasChoosePhoto) {
      return;
    }
    if (this.mNeedCompress)
    {
      callbackJsChooseImage(compressImages(paramArrayList), paramJsRuntime, paramInt);
      return;
    }
    callbackJsChooseImage(copyImages(paramArrayList), paramJsRuntime, paramInt);
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
  
  private void compressImage(String paramString, int paramInt1, JsRuntime paramJsRuntime, int paramInt2)
  {
    try
    {
      Object localObject = ImageUtil.getLocalBitmap(paramString);
      if (localObject != null)
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, paramInt1, localByteArrayOutputStream);
        localObject = BitmapFactory.decodeStream(new ByteArrayInputStream(localByteArrayOutputStream.toByteArray()), null, null);
        paramString = MiniAppFileManager.getInstance().getTmpPath(paramString.hashCode() + ".jpg");
        ImageUtil.saveBitmapToFile((Bitmap)localObject, new File(paramString));
        localObject = new JSONObject();
        ((JSONObject)localObject).put("tempFilePath", MiniAppFileManager.getInstance().getWxFilePath(paramString));
        this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, "compressImage", (JSONObject)localObject, paramInt2);
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ImageJsPlugin", 1, "compressImage error,", paramString);
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, "compressImage", null, paramInt2);
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
    //   14: invokespecial 259	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: invokestatic 173	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   22: ldc_w 366
    //   25: invokevirtual 345	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore 11
    //   30: new 257	java/io/File
    //   33: dup
    //   34: aload 11
    //   36: invokespecial 259	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore 12
    //   41: aconst_null
    //   42: astore 8
    //   44: aconst_null
    //   45: astore 9
    //   47: aconst_null
    //   48: astore 7
    //   50: aload 8
    //   52: astore 5
    //   54: aload 9
    //   56: astore_3
    //   57: invokestatic 269	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +40 -> 100
    //   63: aload 8
    //   65: astore 5
    //   67: aload 9
    //   69: astore_3
    //   70: ldc 14
    //   72: iconst_2
    //   73: new 276	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   80: ldc_w 368
    //   83: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload 4
    //   88: invokevirtual 263	java/io/File:length	()J
    //   91: invokevirtual 371	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   94: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 373	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload 8
    //   102: astore 5
    //   104: aload 9
    //   106: astore_3
    //   107: new 122	android/graphics/BitmapFactory$Options
    //   110: dup
    //   111: invokespecial 123	android/graphics/BitmapFactory$Options:<init>	()V
    //   114: astore 4
    //   116: aload 8
    //   118: astore 5
    //   120: aload 9
    //   122: astore_3
    //   123: aload 4
    //   125: iconst_2
    //   126: putfield 376	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   129: aload 8
    //   131: astore 5
    //   133: aload 9
    //   135: astore_3
    //   136: aload_1
    //   137: aload 4
    //   139: invokestatic 377	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   142: astore 10
    //   144: aload 7
    //   146: astore 4
    //   148: aload 10
    //   150: ifnull +128 -> 278
    //   153: aload 8
    //   155: astore 5
    //   157: aload 9
    //   159: astore_3
    //   160: aload_1
    //   161: invokestatic 380	com/tencent/mobileqq/mini/util/ImageUtil:getExifOrientation	(Ljava/lang/String;)I
    //   164: istore_2
    //   165: aload 8
    //   167: astore 5
    //   169: aload 9
    //   171: astore_3
    //   172: ldc 14
    //   174: iconst_2
    //   175: new 276	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 382
    //   185: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: iload_2
    //   189: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 294	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload 10
    //   200: astore 6
    //   202: iload_2
    //   203: ifeq +30 -> 233
    //   206: aload 8
    //   208: astore 5
    //   210: aload 9
    //   212: astore_3
    //   213: iload_2
    //   214: aload 10
    //   216: invokestatic 386	com/tencent/mobileqq/mini/util/ImageUtil:rotaingImageView	(ILandroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   219: astore 6
    //   221: aload 8
    //   223: astore 5
    //   225: aload 9
    //   227: astore_3
    //   228: aload 10
    //   230: invokevirtual 389	android/graphics/Bitmap:recycle	()V
    //   233: aload 7
    //   235: astore 4
    //   237: aload 6
    //   239: ifnull +39 -> 278
    //   242: aload 8
    //   244: astore 5
    //   246: aload 9
    //   248: astore_3
    //   249: new 391	java/io/FileOutputStream
    //   252: dup
    //   253: aload 12
    //   255: invokespecial 394	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   258: astore 4
    //   260: aload 6
    //   262: getstatic 313	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   265: bipush 50
    //   267: aload 4
    //   269: invokevirtual 319	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   272: pop
    //   273: aload 4
    //   275: invokevirtual 397	java/io/FileOutputStream:flush	()V
    //   278: aload 4
    //   280: astore 5
    //   282: aload 4
    //   284: astore_3
    //   285: invokestatic 269	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +40 -> 328
    //   291: aload 4
    //   293: astore 5
    //   295: aload 4
    //   297: astore_3
    //   298: ldc 14
    //   300: iconst_2
    //   301: new 276	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   308: ldc_w 399
    //   311: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload 12
    //   316: invokevirtual 263	java/io/File:length	()J
    //   319: invokevirtual 371	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   322: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 373	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   328: aload 4
    //   330: ifnull +8 -> 338
    //   333: aload 4
    //   335: invokevirtual 402	java/io/FileOutputStream:close	()V
    //   338: aload 11
    //   340: areturn
    //   341: astore 4
    //   343: aload 5
    //   345: astore_3
    //   346: invokestatic 269	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq +18 -> 367
    //   352: aload 5
    //   354: astore_3
    //   355: ldc 14
    //   357: iconst_2
    //   358: aload 4
    //   360: iconst_0
    //   361: anewarray 271	java/lang/Object
    //   364: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   367: aload 5
    //   369: ifnull -362 -> 7
    //   372: aload 5
    //   374: invokevirtual 402	java/io/FileOutputStream:close	()V
    //   377: aload_1
    //   378: areturn
    //   379: astore_3
    //   380: aload_1
    //   381: areturn
    //   382: astore_1
    //   383: aload_3
    //   384: ifnull +7 -> 391
    //   387: aload_3
    //   388: invokevirtual 402	java/io/FileOutputStream:close	()V
    //   391: aload_1
    //   392: athrow
    //   393: astore_1
    //   394: goto -56 -> 338
    //   397: astore_3
    //   398: goto -7 -> 391
    //   401: astore_1
    //   402: aload 4
    //   404: astore_3
    //   405: goto -22 -> 383
    //   408: astore_3
    //   409: aload 4
    //   411: astore 5
    //   413: aload_3
    //   414: astore 4
    //   416: goto -73 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	this	ImageJsPlugin
    //   0	419	1	paramString	String
    //   164	50	2	i	int
    //   56	299	3	localObject1	Object
    //   379	9	3	localException1	Exception
    //   397	1	3	localException2	Exception
    //   404	1	3	localThrowable1	Throwable
    //   408	6	3	localThrowable2	Throwable
    //   17	317	4	localObject2	Object
    //   341	69	4	localThrowable3	Throwable
    //   414	1	4	localObject3	Object
    //   52	360	5	localObject4	Object
    //   200	61	6	localBitmap1	Bitmap
    //   48	186	7	localObject5	Object
    //   42	201	8	localObject6	Object
    //   45	202	9	localObject7	Object
    //   142	87	10	localBitmap2	Bitmap
    //   28	311	11	str	String
    //   39	276	12	localFile	File
    // Exception table:
    //   from	to	target	type
    //   57	63	341	java/lang/Throwable
    //   70	100	341	java/lang/Throwable
    //   107	116	341	java/lang/Throwable
    //   123	129	341	java/lang/Throwable
    //   136	144	341	java/lang/Throwable
    //   160	165	341	java/lang/Throwable
    //   172	198	341	java/lang/Throwable
    //   213	221	341	java/lang/Throwable
    //   228	233	341	java/lang/Throwable
    //   249	260	341	java/lang/Throwable
    //   285	291	341	java/lang/Throwable
    //   298	328	341	java/lang/Throwable
    //   372	377	379	java/lang/Exception
    //   57	63	382	finally
    //   70	100	382	finally
    //   107	116	382	finally
    //   123	129	382	finally
    //   136	144	382	finally
    //   160	165	382	finally
    //   172	198	382	finally
    //   213	221	382	finally
    //   228	233	382	finally
    //   249	260	382	finally
    //   285	291	382	finally
    //   298	328	382	finally
    //   346	352	382	finally
    //   355	367	382	finally
    //   333	338	393	java/lang/Exception
    //   387	391	397	java/lang/Exception
    //   260	278	401	finally
    //   260	278	408	java/lang/Throwable
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
  
  private void openChoosePhotoActivity(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 4);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 6);
    localIntent.putExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME", "micro_api_choose_image");
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    paramActivity.startActivity(localIntent);
    baaf.a(paramActivity, false, true);
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
    this.mJsRunTime = paramJsRuntime;
    this.mCallBackId = paramInt;
    Object localObject1;
    int j;
    int i;
    if ("chooseImage".equals(paramString1))
    {
      try
      {
        localObject1 = new JSONObject(paramString2);
        j = ((JSONObject)localObject1).optInt("count", 9);
        paramString2 = ((JSONObject)localObject1).optJSONArray("sizeType");
        localObject1 = ((JSONObject)localObject1).optJSONArray("sourceType");
        i = j;
        if (j <= 9) {
          break label1083;
        }
        i = 9;
      }
      catch (Throwable paramString2)
      {
        for (;;)
        {
          QLog.e("ImageJsPlugin", 1, paramString1 + " error,", paramString2);
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
          continue;
          openChoosePhotoActivity(this.jsPluginEngine.getActivityContext(), j);
        }
      }
      if (paramString2 != null)
      {
        paramString2 = paramString2.optString(0);
        if ((!TextUtils.isEmpty(paramString2)) && ("compressed".equals(paramString2))) {
          this.mNeedCompress = true;
        }
      }
      if (((JSONArray)localObject1).length() == 2) {
        AppBrandTask.runTaskOnUiThread(new ImageJsPlugin.2(this, paramJsRuntime, paramInt, j));
      }
      for (;;)
      {
        return "";
        if (!"camera".equals(((JSONArray)localObject1).optString(0))) {
          break;
        }
        openCamera(this.jsPluginEngine.getActivityContext(), paramJsRuntime, paramInt);
      }
    }
    else if (!"previewImage".equals(paramString1)) {}
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString2);
        localObject1 = paramString2.optString("current", "");
        Object localObject2 = paramString2.optJSONArray("urls");
        paramString2 = new ArrayList();
        j = 0;
        i = 0;
        if (i < ((JSONArray)localObject2).length())
        {
          String str1 = ((JSONArray)localObject2).optString(i);
          if (str1.equals(localObject1)) {
            j = i;
          }
          String str2 = MiniAppFileManager.getInstance().getAbsolutePath(str1);
          paramString2.add(str2);
          if (!QLog.isColorLevel()) {
            break label1099;
          }
          QLog.d("ImageJsPlugin", 2, "previewImage wxFilePath=" + str1 + ",localFilePath=" + str2);
          break label1099;
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
        QLog.e("ImageJsPlugin", 2, paramString1 + " error,", paramString2);
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
        continue;
      }
      return "";
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
            if (vlm.a(this.jsPluginEngine.getActivityContext(), paramString2, (String)localObject1)) {
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
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            continue;
          }
          paramString2 = MiniAppFileManager.getInstance().getAbsolutePath((String)localObject1);
          if (TextUtils.isEmpty(paramString2)) {
            continue;
          }
          compressImage(paramString2, i, paramJsRuntime, paramInt);
        }
        catch (Exception paramString2)
        {
          QLog.e("ImageJsPlugin", 1, paramString1 + " error", paramString2);
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
          continue;
        }
        return "";
        paramString2 = null;
        continue;
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
      }
      label1083:
      j = i;
      if (i >= 1) {
        break;
      }
      j = 1;
      break;
      label1099:
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.receiver != null) {
      AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApp().unregisterReceiver(this.receiver);
    }
  }
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ImageJsPlugin
 * JD-Core Version:    0.7.0.1
 */