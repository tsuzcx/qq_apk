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
    for (;;)
    {
      try
      {
        this.mHasChoosePhoto = true;
        if ((paramArrayList != null) && (paramArrayList.size() != 0))
        {
          localObject1 = null;
          if (paramArrayList != null)
          {
            localObject2 = new JSONArray();
            localObject1 = new JSONArray();
            paramArrayList = paramArrayList.iterator();
            if (paramArrayList.hasNext())
            {
              String str1 = (String)paramArrayList.next();
              if (TextUtils.isEmpty(str1)) {
                continue;
              }
              String str2 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(str1);
              ((JSONArray)localObject2).put(str2);
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("path", str2);
              localJSONObject.put("size", new File(str1).length());
              ((JSONArray)localObject1).put(localJSONObject);
              continue;
            }
            paramArrayList = new StringBuilder();
            paramArrayList.append("chooseImage photoArray=");
            paramArrayList.append(((JSONArray)localObject2).toString());
            paramArrayList.append(",fileArray=");
            paramArrayList.append(((JSONArray)localObject1).toString());
            QMLog.d("ImageJsPlugin", paramArrayList.toString());
            paramArrayList = (ArrayList<String>)localObject2;
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("tempFilePaths", paramArrayList);
            if (localObject1 != null) {
              ((JSONObject)localObject2).put("tempFiles", localObject1);
            }
            paramRequestEvent.ok((JSONObject)localObject2);
          }
        }
        else
        {
          paramRequestEvent.fail("cancel");
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        this.mHasChoosePhoto = false;
        QMLog.e("ImageJsPlugin", paramArrayList.getMessage(), paramArrayList);
        paramRequestEvent.fail();
        return;
      }
      Object localObject2 = null;
      paramArrayList = (ArrayList<String>)localObject1;
      Object localObject1 = localObject2;
    }
  }
  
  private ArrayList<String> compressImages(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return paramArrayList;
      }
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localArrayList.add(compressSingleImg((String)paramArrayList.next()));
      }
      return localArrayList;
    }
    return paramArrayList;
  }
  
  /* Error */
  private String compressSingleImg(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aload_1
    //   8: areturn
    //   9: new 229	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 232	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload_0
    //   20: getfield 80	com/tencent/qqmini/sdk/plugins/ImageJsPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   23: ldc 146
    //   25: invokeinterface 151 2 0
    //   30: checkcast 146	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   33: ldc_w 282
    //   36: invokevirtual 285	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   39: astore 11
    //   41: new 229	java/io/File
    //   44: dup
    //   45: aload 11
    //   47: invokespecial 232	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore 12
    //   52: aconst_null
    //   53: astore 8
    //   55: aconst_null
    //   56: astore 9
    //   58: aconst_null
    //   59: astore 7
    //   61: aload 8
    //   63: astore_3
    //   64: aload 9
    //   66: astore 5
    //   68: new 241	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   75: astore 6
    //   77: aload 8
    //   79: astore_3
    //   80: aload 9
    //   82: astore 5
    //   84: aload 6
    //   86: ldc_w 287
    //   89: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 8
    //   95: astore_3
    //   96: aload 9
    //   98: astore 5
    //   100: aload 6
    //   102: aload 4
    //   104: invokevirtual 236	java/io/File:length	()J
    //   107: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 8
    //   113: astore_3
    //   114: aload 9
    //   116: astore 5
    //   118: ldc 27
    //   120: aload 6
    //   122: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 258	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload 8
    //   130: astore_3
    //   131: aload 9
    //   133: astore 5
    //   135: new 114	android/graphics/BitmapFactory$Options
    //   138: dup
    //   139: invokespecial 115	android/graphics/BitmapFactory$Options:<init>	()V
    //   142: astore 4
    //   144: aload 8
    //   146: astore_3
    //   147: aload 9
    //   149: astore 5
    //   151: aload 4
    //   153: iconst_2
    //   154: putfield 293	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   157: aload 8
    //   159: astore_3
    //   160: aload 9
    //   162: astore 5
    //   164: aload_1
    //   165: aload 4
    //   167: invokestatic 124	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   170: astore 10
    //   172: aload 7
    //   174: astore 4
    //   176: aload 10
    //   178: ifnull +179 -> 357
    //   181: aload 8
    //   183: astore_3
    //   184: aload 9
    //   186: astore 5
    //   188: aload_1
    //   189: invokestatic 296	com/tencent/qqmini/sdk/core/utils/ImageUtil:getExifOrientation	(Ljava/lang/String;)I
    //   192: istore_2
    //   193: aload 8
    //   195: astore_3
    //   196: aload 9
    //   198: astore 5
    //   200: new 241	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   207: astore 4
    //   209: aload 8
    //   211: astore_3
    //   212: aload 9
    //   214: astore 5
    //   216: aload 4
    //   218: ldc_w 298
    //   221: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 8
    //   227: astore_3
    //   228: aload 9
    //   230: astore 5
    //   232: aload 4
    //   234: iload_2
    //   235: invokevirtual 301	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 8
    //   241: astore_3
    //   242: aload 9
    //   244: astore 5
    //   246: ldc 27
    //   248: aload 4
    //   250: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 258	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: aload 10
    //   258: astore 6
    //   260: iload_2
    //   261: ifeq +30 -> 291
    //   264: aload 8
    //   266: astore_3
    //   267: aload 9
    //   269: astore 5
    //   271: iload_2
    //   272: aload 10
    //   274: invokestatic 305	com/tencent/qqmini/sdk/core/utils/ImageUtil:rotaingImageView	(ILandroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   277: astore 6
    //   279: aload 8
    //   281: astore_3
    //   282: aload 9
    //   284: astore 5
    //   286: aload 10
    //   288: invokevirtual 310	android/graphics/Bitmap:recycle	()V
    //   291: aload 7
    //   293: astore 4
    //   295: aload 6
    //   297: ifnull +60 -> 357
    //   300: aload 8
    //   302: astore_3
    //   303: aload 9
    //   305: astore 5
    //   307: new 312	java/io/FileOutputStream
    //   310: dup
    //   311: aload 12
    //   313: invokespecial 315	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   316: astore 4
    //   318: aload 6
    //   320: getstatic 321	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   323: bipush 50
    //   325: aload 4
    //   327: invokevirtual 325	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   330: pop
    //   331: aload 4
    //   333: invokevirtual 328	java/io/FileOutputStream:flush	()V
    //   336: goto +21 -> 357
    //   339: astore_1
    //   340: aload 4
    //   342: astore_3
    //   343: goto +127 -> 470
    //   346: astore_3
    //   347: aload 4
    //   349: astore 5
    //   351: aload_3
    //   352: astore 4
    //   354: goto +89 -> 443
    //   357: aload 4
    //   359: astore_3
    //   360: aload 4
    //   362: astore 5
    //   364: new 241	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   371: astore 6
    //   373: aload 4
    //   375: astore_3
    //   376: aload 4
    //   378: astore 5
    //   380: aload 6
    //   382: ldc_w 330
    //   385: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 4
    //   391: astore_3
    //   392: aload 4
    //   394: astore 5
    //   396: aload 6
    //   398: aload 12
    //   400: invokevirtual 236	java/io/File:length	()J
    //   403: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 4
    //   409: astore_3
    //   410: aload 4
    //   412: astore 5
    //   414: ldc 27
    //   416: aload 6
    //   418: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokestatic 258	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: aload 4
    //   426: ifnull +8 -> 434
    //   429: aload 4
    //   431: invokevirtual 333	java/io/FileOutputStream:close	()V
    //   434: aload 11
    //   436: areturn
    //   437: astore_1
    //   438: goto +32 -> 470
    //   441: astore 4
    //   443: aload 5
    //   445: astore_3
    //   446: ldc 27
    //   448: aload 4
    //   450: invokevirtual 334	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   453: aload 4
    //   455: invokestatic 188	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   458: aload 5
    //   460: ifnull +8 -> 468
    //   463: aload 5
    //   465: invokevirtual 333	java/io/FileOutputStream:close	()V
    //   468: aload_1
    //   469: areturn
    //   470: aload_3
    //   471: ifnull +7 -> 478
    //   474: aload_3
    //   475: invokevirtual 333	java/io/FileOutputStream:close	()V
    //   478: aload_1
    //   479: athrow
    //   480: astore_1
    //   481: aload 11
    //   483: areturn
    //   484: astore_3
    //   485: aload_1
    //   486: areturn
    //   487: astore_3
    //   488: goto -10 -> 478
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	this	ImageJsPlugin
    //   0	491	1	paramString	String
    //   192	80	2	i	int
    //   63	280	3	localObject1	Object
    //   346	6	3	localThrowable1	Throwable
    //   359	116	3	localObject2	Object
    //   484	1	3	localException1	Exception
    //   487	1	3	localException2	Exception
    //   17	413	4	localObject3	Object
    //   441	13	4	localThrowable2	Throwable
    //   66	398	5	localObject4	Object
    //   75	342	6	localObject5	Object
    //   59	233	7	localObject6	Object
    //   53	248	8	localObject7	Object
    //   56	248	9	localObject8	Object
    //   170	117	10	localBitmap	Bitmap
    //   39	443	11	str	String
    //   50	349	12	localFile	File
    // Exception table:
    //   from	to	target	type
    //   318	336	339	finally
    //   318	336	346	java/lang/Throwable
    //   68	77	437	finally
    //   84	93	437	finally
    //   100	111	437	finally
    //   118	128	437	finally
    //   135	144	437	finally
    //   151	157	437	finally
    //   164	172	437	finally
    //   188	193	437	finally
    //   200	209	437	finally
    //   216	225	437	finally
    //   232	239	437	finally
    //   246	256	437	finally
    //   271	279	437	finally
    //   286	291	437	finally
    //   307	318	437	finally
    //   364	373	437	finally
    //   380	389	437	finally
    //   396	407	437	finally
    //   414	424	437	finally
    //   446	458	437	finally
    //   68	77	441	java/lang/Throwable
    //   84	93	441	java/lang/Throwable
    //   100	111	441	java/lang/Throwable
    //   118	128	441	java/lang/Throwable
    //   135	144	441	java/lang/Throwable
    //   151	157	441	java/lang/Throwable
    //   164	172	441	java/lang/Throwable
    //   188	193	441	java/lang/Throwable
    //   200	209	441	java/lang/Throwable
    //   216	225	441	java/lang/Throwable
    //   232	239	441	java/lang/Throwable
    //   246	256	441	java/lang/Throwable
    //   271	279	441	java/lang/Throwable
    //   286	291	441	java/lang/Throwable
    //   307	318	441	java/lang/Throwable
    //   364	373	441	java/lang/Throwable
    //   380	389	441	java/lang/Throwable
    //   396	407	441	java/lang/Throwable
    //   414	424	441	java/lang/Throwable
    //   429	434	480	java/lang/Exception
    //   463	468	484	java/lang/Exception
    //   474	478	487	java/lang/Exception
  }
  
  private ArrayList<String> copyImages(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return paramArrayList;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        paramArrayList = (String)localIterator.next();
        String str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).copyTmpFile(paramArrayList);
        if (!TextUtils.isEmpty(str)) {
          paramArrayList = str;
        }
        localArrayList.add(paramArrayList);
      }
      return localArrayList;
    }
    return paramArrayList;
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
      Object localObject1 = ImageUtil.getLocalBitmapwithHW(paramString, paramInt2, paramInt3);
      if (localObject1 != null)
      {
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
        localObject2 = (MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.hashCode());
        localStringBuilder.append(".jpg");
        paramString = ((MiniAppFileManager)localObject2).getTmpPath(localStringBuilder.toString());
        ImageUtil.saveBitmapToFile((Bitmap)localObject1, new File(paramString));
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("tempFilePath", ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(paramString));
        paramRequestEvent.ok((JSONObject)localObject1);
        return;
      }
      paramString = new StringBuilder();
      paramString.append("getLocalBitmap fail or destSize invalid(");
      paramString.append(paramInt2);
      paramString.append(",");
      paramString.append(paramInt3);
      paramString.append(")");
      QMLog.e("ImageJsPlugin", paramString.toString());
      paramString = new StringBuilder();
      paramString.append("fail to get Local picture or destSize invalid(");
      paramString.append(paramInt2);
      paramString.append(",");
      paramString.append(paramInt3);
      paramString.append(")");
      paramRequestEvent.fail(paramString.toString());
      return;
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
        localObject2 = (MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.hashCode());
        localStringBuilder.append(".jpg");
        paramString = ((MiniAppFileManager)localObject2).getTmpPath(localStringBuilder.toString());
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
  
  private String getExifOrientation(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
    }
    catch (IOException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getExifOrientation error.");
      ((StringBuilder)localObject).append(paramString);
      QMLog.e("ImageJsPlugin", ((StringBuilder)localObject).toString());
      paramString = null;
    }
    String str = "up";
    Object localObject = str;
    if (paramString != null)
    {
      localObject = str;
      switch (paramString.getAttributeInt("Orientation", -1))
      {
      default: 
        return "up";
      case 8: 
        return "left";
      case 7: 
        return "right-mirrored";
      case 6: 
        return "right";
      case 5: 
        return "left-mirrored";
      case 4: 
        return "down-mirrored";
      case 3: 
        return "down";
      case 2: 
        localObject = "up-mirrored";
      }
    }
    return localObject;
  }
  
  private void openCamera(RequestEvent paramRequestEvent)
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    if (localIntent.resolveActivity(this.mMiniAppContext.getAttachedActivity().getPackageManager()) == null) {
      return;
    }
    File localFile = createImageFile(this.mMiniAppContext.getAttachedActivity());
    if (localFile == null) {
      return;
    }
    localIntent.putExtra("output", FileUtils.getUriForFile(this.mMiniAppContext.getAttachedActivity(), localFile));
    this.mMiniAppContext.getAttachedActivity().startActivityForResult(localIntent, 4);
    ActivityResultManager.g().addActivityResultListener(new ImageJsPlugin.4(this, paramRequestEvent, localFile));
  }
  
  @JsEvent({"chooseImage"})
  public void chooseImage(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      int i;
      try
      {
        this.mHasChoosePhoto = false;
        localObject2 = new JSONObject(paramRequestEvent.jsonParams);
        j = ((JSONObject)localObject2).optInt("count", 9);
        localObject1 = ((JSONObject)localObject2).optJSONArray("sizeType");
        localObject2 = ((JSONObject)localObject2).optJSONArray("sourceType");
        i = j;
        if (j <= 9) {
          break label291;
        }
        i = 9;
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramRequestEvent.event);
        ((StringBuilder)localObject2).append(" error,");
        QMLog.e("ImageJsPlugin", ((StringBuilder)localObject2).toString(), localThrowable);
        paramRequestEvent.fail();
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
        AppBrandTask.runTaskOnUiThread(new ImageJsPlugin.2(this, paramRequestEvent, j));
        return;
      }
      if ("camera".equals(((JSONArray)localObject2).optString(0)))
      {
        openCamera(paramRequestEvent);
        return;
      }
      if (!this.mMiniAppProxy.openChoosePhotoActivity(this.mMiniAppContext.getAttachedActivity(), j, new ImageJsPlugin.3(this, paramRequestEvent)))
      {
        localObject1 = this.mMiniAppContext.getAttachedActivity();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("暂不支持在");
        ((StringBuilder)localObject2).append(QUAUtil.getApplicationName(this.mContext));
        ((StringBuilder)localObject2).append("中选择图片");
        MiniToast.makeText((Context)localObject1, 0, ((StringBuilder)localObject2).toString(), 1);
        paramRequestEvent.fail();
        return;
      }
      return;
      label291:
      int j = i;
      if (i < 1) {
        j = 1;
      }
    }
  }
  
  @JsEvent({"compressImage"})
  public void compressImage(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      int j;
      int k;
      try
      {
        Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        localObject3 = ((JSONObject)localObject1).optString("src");
        int i = ((JSONObject)localObject1).optInt("quality");
        j = ((JSONObject)localObject1).optInt("destWidth");
        k = ((JSONObject)localObject1).optInt("destHeight");
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject1 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath((String)localObject3);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if ((k > 0) || (j > 0)) {
              break label289;
            }
            doCompressImage((String)localObject1, i, paramRequestEvent);
            return;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("destSize invalid(");
            ((StringBuilder)localObject1).append(j);
            ((StringBuilder)localObject1).append(",");
            ((StringBuilder)localObject1).append(k);
            ((StringBuilder)localObject1).append(")");
            paramRequestEvent.fail(((StringBuilder)localObject1).toString());
            return;
            doCompressImage((String)localObject1, i, j, k, paramRequestEvent);
            return;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramRequestEvent.event);
          ((StringBuilder)localObject1).append(" realUrl is null: src");
          ((StringBuilder)localObject1).append((String)localObject3);
          QMLog.e("ImageJsPlugin", ((StringBuilder)localObject1).toString());
          paramRequestEvent.fail();
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramRequestEvent.event);
        ((StringBuilder)localObject3).append(" error");
        QMLog.e("ImageJsPlugin", ((StringBuilder)localObject3).toString(), localException);
        paramRequestEvent.fail();
        return;
      }
      Object localObject2 = null;
      continue;
      label289:
      if ((k <= 0) || (j > 0)) {
        if ((k > 0) || (j <= 0)) {}
      }
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramRequestEvent.event);
        localStringBuilder.append(" error.");
        QMLog.e("ImageJsPlugin", localStringBuilder.toString(), localException);
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
    try
    {
      localObject2 = new JSONObject(paramRequestEvent.jsonParams);
      Object localObject1 = ((JSONObject)localObject2).optString("current", "");
      localObject2 = ((JSONObject)localObject2).optJSONArray("urls");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      int j = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        String str1 = ((JSONArray)localObject2).optString(i);
        if (str1.equals(localObject1)) {
          j = i;
        }
        String str2 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str1);
        localArrayList.add(str2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("previewImage wxFilePath=");
        localStringBuilder.append(str1);
        localStringBuilder.append(",localFilePath=");
        localStringBuilder.append(str2);
        QMLog.d("ImageJsPlugin", localStringBuilder.toString());
        i += 1;
      }
      if (!this.mMiniAppProxy.openImagePreview(this.mMiniAppContext.getAttachedActivity(), j, localArrayList))
      {
        localObject1 = this.mMiniAppContext.getAttachedActivity();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("暂不支持在");
        ((StringBuilder)localObject2).append(QUAUtil.getApplicationName(this.mContext));
        ((StringBuilder)localObject2).append("中预览图片");
        MiniToast.makeText((Context)localObject1, 0, ((StringBuilder)localObject2).toString(), 1);
        paramRequestEvent.fail();
        return;
      }
      paramRequestEvent.ok();
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramRequestEvent.event);
      ((StringBuilder)localObject2).append(" error,");
      QMLog.e("ImageJsPlugin", ((StringBuilder)localObject2).toString(), localException);
      paramRequestEvent.fail();
    }
  }
  
  @JsEvent({"saveImageToPhotosAlbum"})
  public void saveImageToPhotosAlbum(RequestEvent paramRequestEvent)
  {
    Object localObject2 = "";
    try
    {
      Object localObject1 = new JSONObject(paramRequestEvent.jsonParams).optString("filePath", "");
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool)
      {
        String str1 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath((String)localObject1);
        File localFile = new File(str1);
        localObject1 = localObject2;
        if (!ImageUtil.isJpgFile(str1))
        {
          localObject1 = localObject2;
          if (!ImageUtil.isPngFile(str1))
          {
            localObject1 = localObject2;
            if (!ImageUtil.isWebpFile(str1))
            {
              localObject1 = new BitmapFactory.Options();
              ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
              BitmapFactory.decodeFile(str1, (BitmapFactory.Options)localObject1);
              String str2 = ImageUtil.getType((BitmapFactory.Options)localObject1);
              localObject1 = localObject2;
              if (!TextUtils.isEmpty(str2)) {
                if (str2.equals("unknown"))
                {
                  localObject1 = localObject2;
                }
                else
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append(".");
                  ((StringBuilder)localObject1).append(str2);
                  localObject1 = ((StringBuilder)localObject1).toString();
                }
              }
            }
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(ShortVideoUtil.getCameraPath());
        ((StringBuilder)localObject2).append(System.currentTimeMillis() / 1000L);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(localFile.getName());
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject2).toString();
        if (FileUtils.saveVideoToAlbum(this.mMiniAppContext.getAttachedActivity(), str1, (String)localObject1))
        {
          paramRequestEvent.ok();
          return;
        }
        paramRequestEvent.fail("save failed.");
        return;
      }
      paramRequestEvent.fail("save failed.");
      return;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramRequestEvent.event);
      ((StringBuilder)localObject2).append(" error");
      QMLog.e("ImageJsPlugin", ((StringBuilder)localObject2).toString(), localException);
      paramRequestEvent.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ImageJsPlugin
 * JD-Core Version:    0.7.0.1
 */