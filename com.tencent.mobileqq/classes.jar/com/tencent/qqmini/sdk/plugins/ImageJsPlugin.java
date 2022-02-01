package com.tencent.qqmini.sdk.plugins;

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
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.core.utils.ShortVideoUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

@JsPlugin
public class ImageJsPlugin
  extends BaseJsPlugin
{
  public static final String ACTION_CHOOSE_IMAGE = "micro_api_choose_image";
  public static final String API_CHOOSE_IMAGE = "chooseImage";
  public static final String API_COMPRESS_IMAGE = "compressImage";
  public static final String API_GET_IMAGE_INFO = "getImageInfo";
  public static final String API_PREVIEW_IMAGE = "previewImage";
  public static final String API_SAVE_IMAGE_TO_ALBUM = "saveImageToPhotosAlbum";
  private static final String TAG = "ImageJsPlugin";
  private static final boolean USE_NATIVE_CAMERA_FLAG = true;
  private RequestEvent mCurRequestEvent;
  private boolean mHasChoosePhoto = false;
  private MiniAppProxy mMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  private boolean mNeedCompress = false;
  private BroadcastReceiver receiver = new ImageJsPlugin.1(this);
  
  private void callbackChooseImage(ArrayList<String> paramArrayList, RequestEvent paramRequestEvent)
  {
    if (this.mHasChoosePhoto) {
      return;
    }
    if (this.mNeedCompress)
    {
      callbackJsChooseImage(compressImages(paramArrayList), paramRequestEvent);
      return;
    }
    callbackJsChooseImage(copyImages(paramArrayList), paramRequestEvent);
  }
  
  private void callbackGetImageInfo(String paramString, RequestEvent paramRequestEvent)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("width", localOptions.outWidth);
      localJSONObject.put("height", localOptions.outHeight);
      localJSONObject.put("path", ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(paramString));
      localJSONObject.put("type", ImageUtil.getType(localOptions));
      localJSONObject.put("orientation", getExifOrientation(paramString));
      paramRequestEvent.ok(localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QMLog.e("ImageJsPlugin", "getimageinfo error,", paramString);
      paramRequestEvent.fail();
    }
  }
  
  private void callbackJsChooseImage(ArrayList<String> paramArrayList, RequestEvent paramRequestEvent)
  {
    Object localObject1 = null;
    Object localObject2;
    try
    {
      this.mHasChoosePhoto = true;
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        paramRequestEvent.fail("cancel");
        return;
      }
      if (paramArrayList == null) {
        break label265;
      }
      localObject1 = new JSONArray();
      localObject2 = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str1 = (String)paramArrayList.next();
        if (!TextUtils.isEmpty(str1))
        {
          String str2 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(str1);
          ((JSONArray)localObject1).put(str2);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("path", str2);
          localJSONObject.put("size", new File(str1).length());
          ((JSONArray)localObject2).put(localJSONObject);
        }
      }
      QMLog.d("ImageJsPlugin", "chooseImage photoArray=" + ((JSONArray)localObject1).toString() + ",fileArray=" + ((JSONArray)localObject2).toString());
    }
    catch (Exception paramArrayList)
    {
      this.mHasChoosePhoto = false;
      QMLog.e("ImageJsPlugin", paramArrayList.getMessage(), paramArrayList);
      paramRequestEvent.fail();
      return;
    }
    paramArrayList = (ArrayList<String>)localObject2;
    for (;;)
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("tempFilePaths", localObject1);
      if (paramArrayList != null) {
        ((JSONObject)localObject2).put("tempFiles", paramArrayList);
      }
      paramRequestEvent.ok((JSONObject)localObject2);
      return;
      label265:
      localObject2 = null;
      paramArrayList = (ArrayList<String>)localObject1;
      localObject1 = localObject2;
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
    //   1: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aload_1
    //   8: areturn
    //   9: new 233	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 236	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload_0
    //   20: getfield 80	com/tencent/qqmini/sdk/plugins/ImageJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   23: ldc 146
    //   25: invokeinterface 151 2 0
    //   30: checkcast 146	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   33: ldc_w 282
    //   36: invokevirtual 285	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   39: astore 11
    //   41: new 233	java/io/File
    //   44: dup
    //   45: aload 11
    //   47: invokespecial 236	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore 12
    //   52: aconst_null
    //   53: astore 8
    //   55: aconst_null
    //   56: astore 9
    //   58: aconst_null
    //   59: astore 7
    //   61: aload 8
    //   63: astore 5
    //   65: aload 9
    //   67: astore_3
    //   68: ldc 27
    //   70: new 248	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 287
    //   80: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload 4
    //   85: invokevirtual 240	java/io/File:length	()J
    //   88: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   91: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 265	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload 8
    //   99: astore 5
    //   101: aload 9
    //   103: astore_3
    //   104: new 114	android/graphics/BitmapFactory$Options
    //   107: dup
    //   108: invokespecial 115	android/graphics/BitmapFactory$Options:<init>	()V
    //   111: astore 4
    //   113: aload 8
    //   115: astore 5
    //   117: aload 9
    //   119: astore_3
    //   120: aload 4
    //   122: iconst_2
    //   123: putfield 293	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   126: aload 8
    //   128: astore 5
    //   130: aload 9
    //   132: astore_3
    //   133: aload_1
    //   134: aload 4
    //   136: invokestatic 124	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   139: astore 10
    //   141: aload 7
    //   143: astore 4
    //   145: aload 10
    //   147: ifnull +127 -> 274
    //   150: aload 8
    //   152: astore 5
    //   154: aload 9
    //   156: astore_3
    //   157: aload_1
    //   158: invokestatic 296	com/tencent/qqmini/sdk/core/utils/ImageUtil:getExifOrientation	(Ljava/lang/String;)I
    //   161: istore_2
    //   162: aload 8
    //   164: astore 5
    //   166: aload 9
    //   168: astore_3
    //   169: ldc 27
    //   171: new 248	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 298
    //   181: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: iload_2
    //   185: invokevirtual 301	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 265	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload 10
    //   196: astore 6
    //   198: iload_2
    //   199: ifeq +30 -> 229
    //   202: aload 8
    //   204: astore 5
    //   206: aload 9
    //   208: astore_3
    //   209: iload_2
    //   210: aload 10
    //   212: invokestatic 305	com/tencent/qqmini/sdk/core/utils/ImageUtil:rotaingImageView	(ILandroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   215: astore 6
    //   217: aload 8
    //   219: astore 5
    //   221: aload 9
    //   223: astore_3
    //   224: aload 10
    //   226: invokevirtual 310	android/graphics/Bitmap:recycle	()V
    //   229: aload 7
    //   231: astore 4
    //   233: aload 6
    //   235: ifnull +39 -> 274
    //   238: aload 8
    //   240: astore 5
    //   242: aload 9
    //   244: astore_3
    //   245: new 312	java/io/FileOutputStream
    //   248: dup
    //   249: aload 12
    //   251: invokespecial 315	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   254: astore 4
    //   256: aload 6
    //   258: getstatic 321	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   261: bipush 50
    //   263: aload 4
    //   265: invokevirtual 325	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   268: pop
    //   269: aload 4
    //   271: invokevirtual 328	java/io/FileOutputStream:flush	()V
    //   274: aload 4
    //   276: astore 5
    //   278: aload 4
    //   280: astore_3
    //   281: ldc 27
    //   283: new 248	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   290: ldc_w 330
    //   293: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload 12
    //   298: invokevirtual 240	java/io/File:length	()J
    //   301: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   304: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 265	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: aload 4
    //   312: ifnull +8 -> 320
    //   315: aload 4
    //   317: invokevirtual 333	java/io/FileOutputStream:close	()V
    //   320: aload 11
    //   322: areturn
    //   323: astore 4
    //   325: aload 5
    //   327: astore_3
    //   328: ldc 27
    //   330: aload 4
    //   332: invokevirtual 334	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   335: aload 4
    //   337: invokestatic 188	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   340: aload 5
    //   342: ifnull -335 -> 7
    //   345: aload 5
    //   347: invokevirtual 333	java/io/FileOutputStream:close	()V
    //   350: aload_1
    //   351: areturn
    //   352: astore_3
    //   353: aload_1
    //   354: areturn
    //   355: astore_1
    //   356: aload_3
    //   357: ifnull +7 -> 364
    //   360: aload_3
    //   361: invokevirtual 333	java/io/FileOutputStream:close	()V
    //   364: aload_1
    //   365: athrow
    //   366: astore_1
    //   367: goto -47 -> 320
    //   370: astore_3
    //   371: goto -7 -> 364
    //   374: astore_1
    //   375: aload 4
    //   377: astore_3
    //   378: goto -22 -> 356
    //   381: astore_3
    //   382: aload 4
    //   384: astore 5
    //   386: aload_3
    //   387: astore 4
    //   389: goto -64 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	ImageJsPlugin
    //   0	392	1	paramString	String
    //   161	49	2	i	int
    //   67	261	3	localObject1	Object
    //   352	9	3	localException1	Exception
    //   370	1	3	localException2	Exception
    //   377	1	3	localThrowable1	Throwable
    //   381	6	3	localThrowable2	Throwable
    //   17	299	4	localObject2	Object
    //   323	60	4	localThrowable3	Throwable
    //   387	1	4	localObject3	Object
    //   63	322	5	localObject4	Object
    //   196	61	6	localBitmap1	Bitmap
    //   59	171	7	localObject5	Object
    //   53	186	8	localObject6	Object
    //   56	187	9	localObject7	Object
    //   139	86	10	localBitmap2	Bitmap
    //   39	282	11	str	String
    //   50	247	12	localFile	File
    // Exception table:
    //   from	to	target	type
    //   68	97	323	java/lang/Throwable
    //   104	113	323	java/lang/Throwable
    //   120	126	323	java/lang/Throwable
    //   133	141	323	java/lang/Throwable
    //   157	162	323	java/lang/Throwable
    //   169	194	323	java/lang/Throwable
    //   209	217	323	java/lang/Throwable
    //   224	229	323	java/lang/Throwable
    //   245	256	323	java/lang/Throwable
    //   281	310	323	java/lang/Throwable
    //   345	350	352	java/lang/Exception
    //   68	97	355	finally
    //   104	113	355	finally
    //   120	126	355	finally
    //   133	141	355	finally
    //   157	162	355	finally
    //   169	194	355	finally
    //   209	217	355	finally
    //   224	229	355	finally
    //   245	256	355	finally
    //   281	310	355	finally
    //   328	340	355	finally
    //   315	320	366	java/lang/Exception
    //   360	364	370	java/lang/Exception
    //   256	274	374	finally
    //   256	274	381	java/lang/Throwable
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
      String str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).copyTmpFile(paramArrayList);
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
    return new File(((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath("jpg"));
  }
  
  private void doCompressImage(String paramString, int paramInt1, int paramInt2, int paramInt3, RequestEvent paramRequestEvent)
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
          paramRequestEvent.fail("destSize invalid(" + paramInt2 + "," + paramInt3 + ")");
          return;
        }
        localObject1 = ThumbnailUtils.extractThumbnail((Bitmap)localObject1, paramInt2, paramInt3);
        Object localObject2 = new ByteArrayOutputStream();
        ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, paramInt1, (OutputStream)localObject2);
        localObject2 = BitmapFactory.decodeStream(new ByteArrayInputStream(((ByteArrayOutputStream)localObject2).toByteArray()), null, null);
        localObject1 = localObject2;
        if (i != 0)
        {
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = ImageUtil.rotaingImageView(i, (Bitmap)localObject2);
            ((Bitmap)localObject2).recycle();
          }
        }
        paramString = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath(paramString.hashCode() + ".jpg");
        ImageUtil.saveBitmapToFile((Bitmap)localObject1, new File(paramString));
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("tempFilePath", ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(paramString));
        paramRequestEvent.ok((JSONObject)localObject1);
        return;
      }
    }
    catch (Exception paramString)
    {
      QMLog.e("ImageJsPlugin", "compressImage error,", paramString);
      paramRequestEvent.fail();
    }
  }
  
  private void doCompressImage(String paramString, int paramInt, RequestEvent paramRequestEvent)
  {
    try
    {
      int i = ImageUtil.getExifOrientation(paramString);
      Object localObject1 = ImageUtil.getLocalBitmap(paramString);
      if (localObject1 != null)
      {
        Object localObject2 = new ByteArrayOutputStream();
        ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, paramInt, (OutputStream)localObject2);
        localObject2 = BitmapFactory.decodeStream(new ByteArrayInputStream(((ByteArrayOutputStream)localObject2).toByteArray()), null, null);
        localObject1 = localObject2;
        if (i != 0)
        {
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = ImageUtil.rotaingImageView(i, (Bitmap)localObject2);
            ((Bitmap)localObject2).recycle();
          }
        }
        paramString = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath(paramString.hashCode() + ".jpg");
        ImageUtil.saveBitmapToFile((Bitmap)localObject1, new File(paramString));
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("tempFilePath", ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(paramString));
        paramRequestEvent.ok((JSONObject)localObject1);
      }
      return;
    }
    catch (Exception paramString)
    {
      QMLog.e("ImageJsPlugin", "compressImage error,", paramString);
      paramRequestEvent.fail();
    }
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
        QMLog.e("ImageJsPlugin", "getExifOrientation error." + paramString);
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
  
  private void openCamera(RequestEvent paramRequestEvent)
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    if (localIntent.resolveActivity(this.mMiniAppContext.getAttachedActivity().getPackageManager()) == null) {}
    File localFile;
    do
    {
      return;
      localFile = createImageFile(this.mMiniAppContext.getAttachedActivity());
    } while (localFile == null);
    localIntent.putExtra("output", FileUtils.getUriForFile(this.mMiniAppContext.getAttachedActivity(), localFile));
    this.mMiniAppContext.getAttachedActivity().startActivityForResult(localIntent, 4);
    ActivityResultManager.g().addActivityResultListener(new ImageJsPlugin.4(this, paramRequestEvent, localFile));
  }
  
  @JsEvent({"chooseImage"})
  public void chooseImage(RequestEvent paramRequestEvent)
  {
    int i = 9;
    int j = 1;
    for (;;)
    {
      int k;
      try
      {
        this.mHasChoosePhoto = false;
        localObject2 = new JSONObject(paramRequestEvent.jsonParams);
        k = ((JSONObject)localObject2).optInt("count", 9);
        localObject1 = ((JSONObject)localObject2).optJSONArray("sizeType");
        localObject2 = ((JSONObject)localObject2).optJSONArray("sourceType");
        if (k <= 9) {
          break label269;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        Object localObject1;
        QMLog.e("ImageJsPlugin", paramRequestEvent.event + " error,", localThrowable);
        paramRequestEvent.fail();
        return;
      }
      if (localObject1 != null)
      {
        localObject1 = ((JSONArray)localObject1).optString(0);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ("compressed".equals(localObject1))) {
          this.mNeedCompress = true;
        }
      }
      if (((JSONArray)localObject2).length() == 2)
      {
        AppBrandTask.runTaskOnUiThread(new ImageJsPlugin.2(this, paramRequestEvent, i));
        return;
      }
      if ("camera".equals(((JSONArray)localObject2).optString(0)))
      {
        openCamera(paramRequestEvent);
        return;
      }
      if (this.mMiniAppProxy.openChoosePhotoActivity(this.mMiniAppContext.getAttachedActivity(), i, new ImageJsPlugin.3(this, paramRequestEvent))) {
        break;
      }
      MiniToast.makeText(this.mMiniAppContext.getAttachedActivity(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中选择图片", 1);
      paramRequestEvent.fail();
      return;
      label269:
      do
      {
        break;
        i = k;
      } while (i >= 1);
      i = j;
    }
  }
  
  @JsEvent({"compressImage"})
  public void compressImage(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      String str;
      int i;
      int j;
      int k;
      try
      {
        Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        str = ((JSONObject)localObject1).optString("src");
        i = ((JSONObject)localObject1).optInt("quality");
        j = ((JSONObject)localObject1).optInt("destWidth");
        k = ((JSONObject)localObject1).optInt("destHeight");
        if (TextUtils.isEmpty(str)) {
          break label238;
        }
        localObject1 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label199;
        }
        if ((k > 0) && (j > 0)) {
          break label244;
        }
        doCompressImage((String)localObject1, i, paramRequestEvent);
        return;
      }
      catch (Exception localException)
      {
        label106:
        QMLog.e("ImageJsPlugin", paramRequestEvent.event + " error", localException);
        paramRequestEvent.fail();
        return;
      }
      paramRequestEvent.fail("destSize invalid(" + j + "," + k + ")");
      return;
      label199:
      label238:
      label244:
      do
      {
        doCompressImage(localException, i, j, k, paramRequestEvent);
        return;
        QMLog.e("ImageJsPlugin", paramRequestEvent.event + " realUrl is null: src" + str);
        paramRequestEvent.fail();
        return;
        Object localObject2 = null;
        break;
        if ((k > 0) && (j <= 0)) {
          break label106;
        }
      } while ((k > 0) || (j <= 0));
    }
  }
  
  @JsEvent({"getImageInfo"})
  public void getImageInfo(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      try
      {
        String str = new JSONObject(paramRequestEvent.jsonParams).optString("src", "");
        if (!TextUtils.isEmpty(str))
        {
          str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str);
          if (!TextUtils.isEmpty(str))
          {
            callbackGetImageInfo(str, paramRequestEvent);
            return;
          }
          paramRequestEvent.fail("image path error.");
          return;
        }
      }
      catch (Exception localException)
      {
        QMLog.e("ImageJsPlugin", paramRequestEvent.event + " error.", localException);
        paramRequestEvent.fail();
        return;
      }
      Object localObject = null;
    }
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    paramIMiniAppContext = new IntentFilter();
    paramIMiniAppContext.addAction("micro_api_choose_image");
    this.mMiniAppContext.getContext().registerReceiver(this.receiver, paramIMiniAppContext);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.receiver != null) {
      this.mMiniAppContext.getContext().unregisterReceiver(this.receiver);
    }
  }
  
  public boolean onInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    this.mCurRequestEvent = paramRequestEvent;
    return super.onInterceptJsEvent(paramRequestEvent);
  }
  
  @JsEvent({"previewImage"})
  public void previewImage(RequestEvent paramRequestEvent)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramRequestEvent.jsonParams);
        String str1 = ((JSONObject)localObject).optString("current", "");
        localObject = ((JSONObject)localObject).optJSONArray("urls");
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        if (i < ((JSONArray)localObject).length())
        {
          String str2 = ((JSONArray)localObject).optString(i);
          if (str2.equals(str1))
          {
            j = i;
            String str3 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str2);
            localArrayList.add(str3);
            QMLog.d("ImageJsPlugin", "previewImage wxFilePath=" + str2 + ",localFilePath=" + str3);
            i += 1;
          }
        }
        else
        {
          if ((localArrayList != null) && (!this.mMiniAppProxy.openImagePreview(this.mMiniAppContext.getAttachedActivity(), j, localArrayList)))
          {
            MiniToast.makeText(this.mMiniAppContext.getAttachedActivity(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中预览图片", 1);
            paramRequestEvent.fail();
            return;
          }
          paramRequestEvent.ok();
          return;
        }
      }
      catch (Exception localException)
      {
        QMLog.e("ImageJsPlugin", paramRequestEvent.event + " error,", localException);
        paramRequestEvent.fail();
        return;
      }
    }
  }
  
  @JsEvent({"saveImageToPhotosAlbum"})
  public void saveImageToPhotosAlbum(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optString("filePath", "");
      if (!TextUtils.isEmpty(str))
      {
        str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str);
        Object localObject = new File(str);
        localObject = ShortVideoUtil.getCameraPath() + System.currentTimeMillis() / 1000L + "_" + ((File)localObject).getName();
        if (FileUtils.saveVideoToAlbum(this.mMiniAppContext.getAttachedActivity(), str, (String)localObject))
        {
          paramRequestEvent.ok();
          return;
        }
        paramRequestEvent.fail("save failed.");
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("ImageJsPlugin", paramRequestEvent.event + " error", localException);
      paramRequestEvent.fail();
      return;
    }
    paramRequestEvent.fail("save failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ImageJsPlugin
 * JD-Core Version:    0.7.0.1
 */