package com.tencent.qqmini.sdk.core.plugins;

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
import bgho;
import bgjd;
import bgjm;
import bgkd;
import bgkk;
import bgkv;
import bgkx;
import bgll;
import bgnf;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

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
  private bgkd mCurRequestEvent;
  private boolean mHasChoosePhoto;
  private MiniAppProxy mMiniAppProxy;
  private boolean mNeedCompress;
  private BroadcastReceiver receiver = new ImageJsPlugin.4(this);
  
  private void callbackChooseImage(ArrayList<String> paramArrayList, bgkd parambgkd)
  {
    if (this.mHasChoosePhoto) {
      return;
    }
    if (this.mNeedCompress)
    {
      callbackJsChooseImage(compressImages(paramArrayList), parambgkd);
      return;
    }
    callbackJsChooseImage(copyImages(paramArrayList), parambgkd);
  }
  
  private void callbackGetImageInfo(String paramString, bgkd parambgkd)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("width", localOptions.outWidth);
      localJSONObject.put("height", localOptions.outHeight);
      localJSONObject.put("path", bgjm.a().e(paramString));
      localJSONObject.put("type", bgkx.a(localOptions));
      localJSONObject.put("orientation", getExifOrientation(paramString));
      parambgkd.a(localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QMLog.e("ImageJsPlugin", "getimageinfo error,", paramString);
      parambgkd.b();
    }
  }
  
  private void callbackJsChooseImage(ArrayList<String> paramArrayList, bgkd parambgkd)
  {
    Object localObject1 = null;
    Object localObject2;
    try
    {
      this.mHasChoosePhoto = true;
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        parambgkd.a("cancel");
        return;
      }
      if (paramArrayList == null) {
        break label251;
      }
      localObject1 = new JSONArray();
      localObject2 = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str1 = (String)paramArrayList.next();
        if (!TextUtils.isEmpty(str1))
        {
          String str2 = bgjm.a().e(str1);
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
      parambgkd.b();
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
      parambgkd.a((JSONObject)localObject2);
      return;
      label251:
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
    //   1: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aload_1
    //   8: areturn
    //   9: new 206	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 209	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: invokestatic 127	bgjm:a	()Lbgjm;
    //   22: ldc 255
    //   24: invokevirtual 257	bgjm:b	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 11
    //   29: new 206	java/io/File
    //   32: dup
    //   33: aload 11
    //   35: invokespecial 209	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore 12
    //   40: aconst_null
    //   41: astore 8
    //   43: aconst_null
    //   44: astore 9
    //   46: aconst_null
    //   47: astore 7
    //   49: aload 8
    //   51: astore 5
    //   53: aload 9
    //   55: astore_3
    //   56: ldc 26
    //   58: new 221	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 259
    //   68: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload 4
    //   73: invokevirtual 213	java/io/File:length	()J
    //   76: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   79: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 238	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload 8
    //   87: astore 5
    //   89: aload 9
    //   91: astore_3
    //   92: new 91	android/graphics/BitmapFactory$Options
    //   95: dup
    //   96: invokespecial 92	android/graphics/BitmapFactory$Options:<init>	()V
    //   99: astore 4
    //   101: aload 8
    //   103: astore 5
    //   105: aload 9
    //   107: astore_3
    //   108: aload 4
    //   110: iconst_2
    //   111: putfield 265	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   114: aload 8
    //   116: astore 5
    //   118: aload 9
    //   120: astore_3
    //   121: aload_1
    //   122: aload 4
    //   124: invokestatic 101	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   127: astore 10
    //   129: aload 7
    //   131: astore 4
    //   133: aload 10
    //   135: ifnull +127 -> 262
    //   138: aload 8
    //   140: astore 5
    //   142: aload 9
    //   144: astore_3
    //   145: aload_1
    //   146: invokestatic 268	bgkx:a	(Ljava/lang/String;)I
    //   149: istore_2
    //   150: aload 8
    //   152: astore 5
    //   154: aload 9
    //   156: astore_3
    //   157: ldc 26
    //   159: new 221	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   166: ldc_w 270
    //   169: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: iload_2
    //   173: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 238	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 10
    //   184: astore 6
    //   186: iload_2
    //   187: ifeq +30 -> 217
    //   190: aload 8
    //   192: astore 5
    //   194: aload 9
    //   196: astore_3
    //   197: iload_2
    //   198: aload 10
    //   200: invokestatic 276	bgkx:a	(ILandroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   203: astore 6
    //   205: aload 8
    //   207: astore 5
    //   209: aload 9
    //   211: astore_3
    //   212: aload 10
    //   214: invokevirtual 281	android/graphics/Bitmap:recycle	()V
    //   217: aload 7
    //   219: astore 4
    //   221: aload 6
    //   223: ifnull +39 -> 262
    //   226: aload 8
    //   228: astore 5
    //   230: aload 9
    //   232: astore_3
    //   233: new 283	java/io/FileOutputStream
    //   236: dup
    //   237: aload 12
    //   239: invokespecial 286	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   242: astore 4
    //   244: aload 6
    //   246: getstatic 292	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   249: bipush 50
    //   251: aload 4
    //   253: invokevirtual 296	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   256: pop
    //   257: aload 4
    //   259: invokevirtual 299	java/io/FileOutputStream:flush	()V
    //   262: aload 4
    //   264: astore 5
    //   266: aload 4
    //   268: astore_3
    //   269: ldc 26
    //   271: new 221	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   278: ldc_w 301
    //   281: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload 12
    //   286: invokevirtual 213	java/io/File:length	()J
    //   289: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   292: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 238	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: aload 4
    //   300: ifnull +8 -> 308
    //   303: aload 4
    //   305: invokevirtual 304	java/io/FileOutputStream:close	()V
    //   308: aload 11
    //   310: areturn
    //   311: astore 4
    //   313: aload 5
    //   315: astore_3
    //   316: ldc 26
    //   318: aload 4
    //   320: invokevirtual 305	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   323: aload 4
    //   325: invokestatic 161	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   328: aload 5
    //   330: ifnull -323 -> 7
    //   333: aload 5
    //   335: invokevirtual 304	java/io/FileOutputStream:close	()V
    //   338: aload_1
    //   339: areturn
    //   340: astore_3
    //   341: aload_1
    //   342: areturn
    //   343: astore_1
    //   344: aload_3
    //   345: ifnull +7 -> 352
    //   348: aload_3
    //   349: invokevirtual 304	java/io/FileOutputStream:close	()V
    //   352: aload_1
    //   353: athrow
    //   354: astore_1
    //   355: goto -47 -> 308
    //   358: astore_3
    //   359: goto -7 -> 352
    //   362: astore_1
    //   363: aload 4
    //   365: astore_3
    //   366: goto -22 -> 344
    //   369: astore_3
    //   370: aload 4
    //   372: astore 5
    //   374: aload_3
    //   375: astore 4
    //   377: goto -64 -> 313
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	ImageJsPlugin
    //   0	380	1	paramString	String
    //   149	49	2	i	int
    //   55	261	3	localObject1	Object
    //   340	9	3	localException1	Exception
    //   358	1	3	localException2	Exception
    //   365	1	3	localThrowable1	Throwable
    //   369	6	3	localThrowable2	Throwable
    //   17	287	4	localObject2	Object
    //   311	60	4	localThrowable3	Throwable
    //   375	1	4	localObject3	Object
    //   51	322	5	localObject4	Object
    //   184	61	6	localBitmap1	Bitmap
    //   47	171	7	localObject5	Object
    //   41	186	8	localObject6	Object
    //   44	187	9	localObject7	Object
    //   127	86	10	localBitmap2	Bitmap
    //   27	282	11	str	String
    //   38	247	12	localFile	File
    // Exception table:
    //   from	to	target	type
    //   56	85	311	java/lang/Throwable
    //   92	101	311	java/lang/Throwable
    //   108	114	311	java/lang/Throwable
    //   121	129	311	java/lang/Throwable
    //   145	150	311	java/lang/Throwable
    //   157	182	311	java/lang/Throwable
    //   197	205	311	java/lang/Throwable
    //   212	217	311	java/lang/Throwable
    //   233	244	311	java/lang/Throwable
    //   269	298	311	java/lang/Throwable
    //   333	338	340	java/lang/Exception
    //   56	85	343	finally
    //   92	101	343	finally
    //   108	114	343	finally
    //   121	129	343	finally
    //   145	150	343	finally
    //   157	182	343	finally
    //   197	205	343	finally
    //   212	217	343	finally
    //   233	244	343	finally
    //   269	298	343	finally
    //   316	328	343	finally
    //   303	308	354	java/lang/Exception
    //   348	352	358	java/lang/Exception
    //   244	262	362	finally
    //   244	262	369	java/lang/Throwable
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
      String str = bgjm.a().h(paramArrayList);
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
    return new File(bgjm.a().b("jpg"));
  }
  
  private void doCompressImage(String paramString, int paramInt, bgkd parambgkd)
  {
    try
    {
      Object localObject = bgkx.a(paramString);
      if (localObject != null)
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
        localObject = BitmapFactory.decodeStream(new ByteArrayInputStream(localByteArrayOutputStream.toByteArray()), null, null);
        paramString = bgjm.a().b(paramString.hashCode() + ".jpg");
        bgkx.a((Bitmap)localObject, new File(paramString));
        localObject = new JSONObject();
        ((JSONObject)localObject).put("tempFilePath", bgjm.a().e(paramString));
        parambgkd.a((JSONObject)localObject);
      }
      return;
    }
    catch (Exception paramString)
    {
      QMLog.e("ImageJsPlugin", "compressImage error,", paramString);
      parambgkd.b();
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
  
  private void openCamera(bgkd parambgkd)
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    if (localIntent.resolveActivity(this.mMiniAppContext.a().getPackageManager()) == null) {}
    File localFile;
    do
    {
      return;
      localFile = createImageFile(this.mMiniAppContext.a());
    } while (localFile == null);
    localIntent.putExtra("output", bgkv.a(this.mMiniAppContext.a(), localFile));
    this.mMiniAppContext.a().startActivityForResult(localIntent, 4);
    bgjd.a().a(new ImageJsPlugin.3(this, parambgkd, localFile));
  }
  
  public void chooseImage(bgkd parambgkd)
  {
    int i = 9;
    int j = 1;
    for (;;)
    {
      int k;
      try
      {
        this.mHasChoosePhoto = false;
        localObject2 = new JSONObject(parambgkd.b);
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
        QMLog.e("ImageJsPlugin", parambgkd.a + " error,", localThrowable);
        parambgkd.b();
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
        bgkk.a(new ImageJsPlugin.1(this, parambgkd, i));
        return;
      }
      if ("camera".equals(((JSONArray)localObject2).optString(0)))
      {
        openCamera(parambgkd);
        return;
      }
      if (this.mMiniAppProxy.openChoosePhotoActivity(this.mMiniAppContext.a(), i, new ImageJsPlugin.2(this, parambgkd))) {
        break;
      }
      bgnf.a(this.mMiniAppContext.a(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中选择图片", 1);
      parambgkd.b();
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
  
  public void compressImage(bgkd parambgkd)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(parambgkd.b);
        String str = ((JSONObject)localObject1).optString("src");
        int i = ((JSONObject)localObject1).optInt("quality");
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = bgjm.a().a(str);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            doCompressImage((String)localObject1, i, parambgkd);
            return;
          }
          parambgkd.b();
          return;
        }
      }
      catch (Exception localException)
      {
        QMLog.e("ImageJsPlugin", parambgkd.a + " error", localException);
        parambgkd.b();
        return;
      }
      Object localObject2 = null;
    }
  }
  
  public void getImageInfo(bgkd parambgkd)
  {
    for (;;)
    {
      try
      {
        String str = new JSONObject(parambgkd.b).optString("src", "");
        if (!TextUtils.isEmpty(str))
        {
          str = bgjm.a().a(str);
          if (!TextUtils.isEmpty(str))
          {
            callbackGetImageInfo(str, parambgkd);
            return;
          }
          parambgkd.a("image path error.");
          return;
        }
      }
      catch (Exception localException)
      {
        QMLog.e("ImageJsPlugin", parambgkd.a + " error.", localException);
        parambgkd.b();
        return;
      }
      Object localObject = null;
    }
  }
  
  public void onCreate(bgho parambgho)
  {
    super.onCreate(parambgho);
    parambgho = new IntentFilter();
    parambgho.addAction("micro_api_choose_image");
    this.mMiniAppContext.a().registerReceiver(this.receiver, parambgho);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.receiver != null) {
      this.mMiniAppContext.a().unregisterReceiver(this.receiver);
    }
  }
  
  public boolean onInterceptJsEvent(bgkd parambgkd)
  {
    this.mCurRequestEvent = parambgkd;
    return super.onInterceptJsEvent(parambgkd);
  }
  
  public void previewImage(bgkd parambgkd)
  {
    int i = 0;
    try
    {
      Object localObject = new JSONObject(parambgkd.b);
      String str1 = ((JSONObject)localObject).optString("current", "");
      localObject = ((JSONObject)localObject).optJSONArray("urls");
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      while (i < ((JSONArray)localObject).length())
      {
        String str2 = ((JSONArray)localObject).optString(i);
        if (str2.equals(str1)) {
          j = i;
        }
        String str3 = bgjm.a().a(str2);
        localArrayList.add(str3);
        QMLog.d("ImageJsPlugin", "previewImage wxFilePath=" + str2 + ",localFilePath=" + str3);
        i += 1;
      }
      if ((localArrayList != null) && (!this.mMiniAppProxy.openImagePreview(this.mMiniAppContext.a(), j, localArrayList)))
      {
        bgnf.a(this.mMiniAppContext.a(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中预览图片", 1);
        parambgkd.b();
        return;
      }
      parambgkd.a();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("ImageJsPlugin", parambgkd.a + " error,", localException);
      parambgkd.b();
    }
  }
  
  public void saveImageToPhotosAlbum(bgkd parambgkd)
  {
    try
    {
      String str = new JSONObject(parambgkd.b).optString("filePath", "");
      if (!TextUtils.isEmpty(str))
      {
        str = bgjm.a().a(str);
        Object localObject = new File(str);
        localObject = bgll.a() + System.currentTimeMillis() / 1000L + "_" + ((File)localObject).getName();
        if (bgkv.a(this.mMiniAppContext.a(), str, (String)localObject))
        {
          parambgkd.a();
          return;
        }
        parambgkd.a("save failed.");
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("ImageJsPlugin", parambgkd.a + " error", localException);
      parambgkd.b();
      return;
    }
    parambgkd.a("save failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ImageJsPlugin
 * JD-Core Version:    0.7.0.1
 */