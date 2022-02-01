package com.tencent.mobileqq.qwallet.preload.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletApiProxy;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadImgApi;
import com.tencent.mobileqq.qwallet.preload.IPreloadImgApi.OnSingleDownloadCallback;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.utils.QWalletValues;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

public class PreloadImgApiImpl
  implements IPreloadImgApi
{
  private static final int MIN_LIMIT_FREE_SIZE = 20;
  private static final String PRELOAD_DIR_NAME = "/preload/";
  private static final String TAG = "PreloadImgApi";
  private static final String URL_LIST_CONFIG = "urlList.cfg";
  private DownloadListener mDownloadListener = new PreloadImgApiImpl.1(this);
  DownloaderInterface mDownloaderInterface;
  private Map<String, List<IPreloadImgApi.OnSingleDownloadCallback>> mDownloadingCallbackMap = Collections.synchronizedMap(new HashMap(6));
  private MQLruCache<String, Object> mLruCache = null;
  
  private String getExternalSavePath(AppInterface paramAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QWalletValues.a);
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    localStringBuilder.append("/preload/");
    return localStringBuilder.toString();
  }
  
  private String getInternalSavePath(AppInterface paramAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getQWalletInternalPath());
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    localStringBuilder.append("/preload/");
    return localStringBuilder.toString();
  }
  
  private void imageDownBack(AppInterface paramAppInterface, String paramString, List<IPreloadImgApi.OnSingleDownloadCallback> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (paramAppInterface != null))
    {
      paramAppInterface = PreloadStaticApi.a(paramString);
      Object localObject = MobileQQ.getContext().getApplicationContext().getResources().getDrawable(R.drawable.u);
      paramAppInterface = ((IQWalletApiProxy)QRoute.api(IQWalletApiProxy.class)).getDrawableForWallet(paramAppInterface, (Drawable)localObject, null);
      int i = 0;
      while (i < paramList.size())
      {
        localObject = (IPreloadImgApi.OnSingleDownloadCallback)paramList.get(i);
        if (localObject != null) {
          if (paramAppInterface != null) {
            ((IPreloadImgApi.OnSingleDownloadCallback)localObject).a(paramAppInterface);
          } else {
            ((IPreloadImgApi.OnSingleDownloadCallback)localObject).a();
          }
        }
        i += 1;
      }
      this.mDownloadingCallbackMap.remove(paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadImgApi", 2, "imageDownBack callback error");
    }
  }
  
  private void imageZipDownBack(AppInterface paramAppInterface, String paramString1, String paramString2, List<IPreloadImgApi.OnSingleDownloadCallback> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      boolean bool = TextUtils.isEmpty(paramString2);
      int j = 0;
      int i;
      if ((!bool) && (new File(paramString2).exists())) {
        i = 1;
      } else {
        i = 0;
      }
      while (j < paramList.size())
      {
        paramAppInterface = (IPreloadImgApi.OnSingleDownloadCallback)paramList.get(j);
        if (paramAppInterface != null) {
          if (i != 0) {
            paramAppInterface.a(paramString2);
          } else {
            paramAppInterface.a();
          }
        }
        j += 1;
      }
      this.mDownloadingCallbackMap.remove(paramString1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadImgApi", 2, "imageZipDownBack callback error");
    }
  }
  
  /* Error */
  private Bitmap loadBitmap(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 6
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 9
    //   12: iload 6
    //   14: ifne +367 -> 381
    //   17: aload_2
    //   18: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: new 221	android/graphics/BitmapFactory$Options
    //   29: dup
    //   30: invokespecial 222	android/graphics/BitmapFactory$Options:<init>	()V
    //   33: astore 11
    //   35: aload 11
    //   37: iconst_1
    //   38: putfield 226	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   41: new 228	java/io/BufferedInputStream
    //   44: dup
    //   45: new 230	java/io/FileInputStream
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 231	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   53: invokespecial 234	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: astore 8
    //   58: aload 8
    //   60: astore 7
    //   62: aload 8
    //   64: aconst_null
    //   65: aload 11
    //   67: invokestatic 240	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   70: pop
    //   71: aload 8
    //   73: astore 7
    //   75: aload 8
    //   77: invokevirtual 243	java/io/BufferedInputStream:close	()V
    //   80: aload 8
    //   82: astore 7
    //   84: aload_1
    //   85: invokevirtual 146	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   88: invokevirtual 247	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   91: astore_1
    //   92: aload 8
    //   94: astore 7
    //   96: aload 11
    //   98: getfield 250	android/graphics/BitmapFactory$Options:outWidth	I
    //   101: aload_1
    //   102: getfield 255	android/util/DisplayMetrics:widthPixels	I
    //   105: idiv
    //   106: istore 4
    //   108: aload 8
    //   110: astore 7
    //   112: aload 11
    //   114: getfield 258	android/graphics/BitmapFactory$Options:outHeight	I
    //   117: aload_1
    //   118: getfield 261	android/util/DisplayMetrics:heightPixels	I
    //   121: idiv
    //   122: istore 5
    //   124: iload 4
    //   126: iload 5
    //   128: if_icmpge +17 -> 145
    //   131: aload 8
    //   133: astore 7
    //   135: aload 11
    //   137: iload 4
    //   139: putfield 264	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   142: goto +14 -> 156
    //   145: aload 8
    //   147: astore 7
    //   149: aload 11
    //   151: iload 5
    //   153: putfield 264	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   156: aload 8
    //   158: astore 7
    //   160: aload 11
    //   162: getfield 264	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   165: ifgt +13 -> 178
    //   168: aload 8
    //   170: astore 7
    //   172: aload 11
    //   174: iconst_1
    //   175: putfield 264	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   178: aload 8
    //   180: astore 7
    //   182: aload 11
    //   184: iconst_0
    //   185: putfield 226	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   188: aload 8
    //   190: astore 7
    //   192: new 228	java/io/BufferedInputStream
    //   195: dup
    //   196: new 230	java/io/FileInputStream
    //   199: dup
    //   200: aload_2
    //   201: invokespecial 231	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   204: invokespecial 234	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   207: astore_1
    //   208: aload_1
    //   209: aconst_null
    //   210: aload 11
    //   212: invokestatic 240	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   215: astore 7
    //   217: aload 7
    //   219: astore_2
    //   220: aload_1
    //   221: invokevirtual 243	java/io/BufferedInputStream:close	()V
    //   224: aload 7
    //   226: astore_2
    //   227: goto +119 -> 346
    //   230: astore_2
    //   231: aload_1
    //   232: astore 7
    //   234: aload_2
    //   235: astore_1
    //   236: goto +133 -> 369
    //   239: astore_2
    //   240: goto +42 -> 282
    //   243: astore_2
    //   244: goto +68 -> 312
    //   247: astore_2
    //   248: goto +81 -> 329
    //   251: astore_2
    //   252: aload 8
    //   254: astore_1
    //   255: goto +27 -> 282
    //   258: astore_2
    //   259: aload 8
    //   261: astore_1
    //   262: goto +50 -> 312
    //   265: astore_2
    //   266: aload 8
    //   268: astore_1
    //   269: goto +60 -> 329
    //   272: astore_1
    //   273: aconst_null
    //   274: astore 7
    //   276: goto +93 -> 369
    //   279: astore_2
    //   280: aconst_null
    //   281: astore_1
    //   282: aload_1
    //   283: astore 7
    //   285: aload_2
    //   286: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   289: aload 9
    //   291: astore_2
    //   292: aload_1
    //   293: ifnull +53 -> 346
    //   296: aload 10
    //   298: astore_2
    //   299: aload_1
    //   300: invokevirtual 243	java/io/BufferedInputStream:close	()V
    //   303: aload 9
    //   305: astore_2
    //   306: goto +40 -> 346
    //   309: astore_2
    //   310: aconst_null
    //   311: astore_1
    //   312: aload_1
    //   313: astore 7
    //   315: aload_2
    //   316: invokevirtual 268	java/lang/OutOfMemoryError:printStackTrace	()V
    //   319: aload 9
    //   321: astore_2
    //   322: aload_1
    //   323: ifnull +23 -> 346
    //   326: goto -30 -> 296
    //   329: aload_1
    //   330: astore 7
    //   332: aload_2
    //   333: invokevirtual 269	java/io/FileNotFoundException:printStackTrace	()V
    //   336: aload 9
    //   338: astore_2
    //   339: aload_1
    //   340: ifnull +6 -> 346
    //   343: goto -47 -> 296
    //   346: aload_0
    //   347: getfield 35	com/tencent/mobileqq/qwallet/preload/impl/PreloadImgApiImpl:mLruCache	Landroid/support/v4/util/MQLruCache;
    //   350: astore_1
    //   351: aload_1
    //   352: ifnull +14 -> 366
    //   355: aload_2
    //   356: ifnull +10 -> 366
    //   359: aload_1
    //   360: aload_3
    //   361: aload_2
    //   362: invokevirtual 275	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   365: pop
    //   366: aload_2
    //   367: areturn
    //   368: astore_1
    //   369: aload 7
    //   371: ifnull +8 -> 379
    //   374: aload 7
    //   376: invokevirtual 243	java/io/BufferedInputStream:close	()V
    //   379: aload_1
    //   380: athrow
    //   381: aconst_null
    //   382: areturn
    //   383: astore_1
    //   384: goto -38 -> 346
    //   387: astore_2
    //   388: goto -9 -> 379
    //   391: astore_2
    //   392: aconst_null
    //   393: astore_1
    //   394: goto -65 -> 329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	PreloadImgApiImpl
    //   0	397	1	paramContext	Context
    //   0	397	2	paramString1	String
    //   0	397	3	paramString2	String
    //   106	32	4	i	int
    //   122	30	5	j	int
    //   4	9	6	bool	boolean
    //   60	315	7	localObject1	Object
    //   56	211	8	localBufferedInputStream	java.io.BufferedInputStream
    //   10	327	9	localObject2	Object
    //   7	290	10	localObject3	Object
    //   33	178	11	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   208	217	230	finally
    //   208	217	239	java/io/IOException
    //   208	217	243	java/lang/OutOfMemoryError
    //   208	217	247	java/io/FileNotFoundException
    //   62	71	251	java/io/IOException
    //   75	80	251	java/io/IOException
    //   84	92	251	java/io/IOException
    //   96	108	251	java/io/IOException
    //   112	124	251	java/io/IOException
    //   135	142	251	java/io/IOException
    //   149	156	251	java/io/IOException
    //   160	168	251	java/io/IOException
    //   172	178	251	java/io/IOException
    //   182	188	251	java/io/IOException
    //   192	208	251	java/io/IOException
    //   62	71	258	java/lang/OutOfMemoryError
    //   75	80	258	java/lang/OutOfMemoryError
    //   84	92	258	java/lang/OutOfMemoryError
    //   96	108	258	java/lang/OutOfMemoryError
    //   112	124	258	java/lang/OutOfMemoryError
    //   135	142	258	java/lang/OutOfMemoryError
    //   149	156	258	java/lang/OutOfMemoryError
    //   160	168	258	java/lang/OutOfMemoryError
    //   172	178	258	java/lang/OutOfMemoryError
    //   182	188	258	java/lang/OutOfMemoryError
    //   192	208	258	java/lang/OutOfMemoryError
    //   62	71	265	java/io/FileNotFoundException
    //   75	80	265	java/io/FileNotFoundException
    //   84	92	265	java/io/FileNotFoundException
    //   96	108	265	java/io/FileNotFoundException
    //   112	124	265	java/io/FileNotFoundException
    //   135	142	265	java/io/FileNotFoundException
    //   149	156	265	java/io/FileNotFoundException
    //   160	168	265	java/io/FileNotFoundException
    //   172	178	265	java/io/FileNotFoundException
    //   182	188	265	java/io/FileNotFoundException
    //   192	208	265	java/io/FileNotFoundException
    //   41	58	272	finally
    //   41	58	279	java/io/IOException
    //   41	58	309	java/lang/OutOfMemoryError
    //   62	71	368	finally
    //   75	80	368	finally
    //   84	92	368	finally
    //   96	108	368	finally
    //   112	124	368	finally
    //   135	142	368	finally
    //   149	156	368	finally
    //   160	168	368	finally
    //   172	178	368	finally
    //   182	188	368	finally
    //   192	208	368	finally
    //   285	289	368	finally
    //   315	319	368	finally
    //   332	336	368	finally
    //   220	224	383	java/io/IOException
    //   299	303	383	java/io/IOException
    //   374	379	387	java/io/IOException
    //   41	58	391	java/io/FileNotFoundException
  }
  
  public void cancelAllDownload()
  {
    DownloaderInterface localDownloaderInterface = this.mDownloaderInterface;
    if (localDownloaderInterface != null) {
      localDownloaderInterface.cancelTask(true, null);
    }
  }
  
  public void delete(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = ".png";
    }
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadImgApi", 2, "delete url is empty return!!!");
      }
      return;
    }
    paramString2 = getExternalSavePath(paramAppInterface);
    paramAppInterface = getInternalSavePath(paramAppInterface);
    if (!TextUtils.isEmpty(paramString2)) {
      paramAppInterface = paramString2;
    }
    paramString2 = paramString1;
    if (!paramString1.endsWith(str))
    {
      paramString1 = new StringBuilder(paramString1);
      paramString1.append(str);
      paramString2 = paramString1.toString();
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder("删除没用的图片及缓存url=");
      paramString1.append(paramString2);
      paramString1.append(" ,缓存路径: ");
      paramString1.append(paramAppInterface);
      QLog.d("PreloadImgApi", 2, paramString1.toString());
    }
    paramString1 = this.mLruCache;
    if (paramString1 != null) {
      paramString1.remove(paramString2);
    }
    paramAppInterface = new File(paramAppInterface, MD5.toMD5(paramString2));
    if (paramAppInterface.exists()) {
      paramAppInterface.delete();
    }
  }
  
  public void download(AppInterface paramAppInterface, String paramString, IPreloadImgApi.OnSingleDownloadCallback paramOnSingleDownloadCallback)
  {
    downloadWithSuffix(paramAppInterface, paramString, ".png", paramOnSingleDownloadCallback);
  }
  
  public void downloadWithSuffix(AppInterface paramAppInterface, String paramString1, String paramString2, IPreloadImgApi.OnSingleDownloadCallback paramOnSingleDownloadCallback)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = ".png";
    }
    if ((paramAppInterface != null) && (!TextUtils.isEmpty(paramString1)))
    {
      paramString2 = paramString1;
      if (!paramString1.endsWith(str))
      {
        paramString1 = new StringBuilder(paramString1);
        paramString1.append(str);
        paramString2 = paramString1.toString();
      }
      if (this.mDownloadingCallbackMap.containsKey(paramString2))
      {
        ((List)this.mDownloadingCallbackMap.get(paramString2)).add(paramOnSingleDownloadCallback);
        if (QLog.isColorLevel()) {
          QLog.d("PreloadImgApi", 2, "url is already in download set return! ");
        }
        return;
      }
      this.mDownloadingCallbackMap.put(paramString2, new ArrayList(6));
      ((List)this.mDownloadingCallbackMap.get(paramString2)).add(paramOnSingleDownloadCallback);
      ((IPreloadService)paramAppInterface.getRuntimeService(IPreloadService.class, "")).getResPath(paramString2, new PreloadImgApiImpl.2(this, paramAppInterface));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadImgApi", 2, "download AppInterface is null or url is emprty ");
    }
  }
  
  public Bitmap getBitmap(AppInterface paramAppInterface, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    String str1 = paramString;
    if (!paramString.endsWith(".png"))
    {
      paramString = new StringBuilder(paramString);
      paramString.append(".png");
      str1 = paramString.toString();
    }
    Object localObject2 = this.mLruCache;
    paramString = (String)localObject1;
    if (localObject2 != null) {
      paramString = (Bitmap)((MQLruCache)localObject2).get(str1);
    }
    localObject2 = paramString;
    if (paramString == null)
    {
      String str2 = MD5.toMD5(str1);
      localObject2 = new File(getExternalSavePath(paramAppInterface), str2);
      localObject1 = localObject2;
      if (!((File)localObject2).exists()) {
        localObject1 = new File(getInternalSavePath(paramAppInterface), str2);
      }
      localObject2 = paramString;
      if (((File)localObject1).exists())
      {
        paramAppInterface.getApplication();
        localObject2 = loadBitmap(MobileQQ.getContext(), ((File)localObject1).getPath(), str1);
      }
    }
    return localObject2;
  }
  
  public Bitmap getBitmapByTheme(AppInterface paramAppInterface, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (bool) {
      return null;
    }
    paramAppInterface = paramString;
    if (!paramString.endsWith(".png"))
    {
      paramAppInterface = new StringBuilder(paramString);
      paramAppInterface.append(".png");
      paramAppInterface = paramAppInterface.toString();
    }
    MQLruCache localMQLruCache = this.mLruCache;
    paramString = localObject;
    if (localMQLruCache != null) {
      paramString = (Bitmap)localMQLruCache.get(paramAppInterface);
    }
    return paramString;
  }
  
  public Drawable getDrawableByTheme(AppInterface paramAppInterface, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (bool) {
      return null;
    }
    paramAppInterface = paramString;
    if (!paramString.endsWith(".png"))
    {
      paramAppInterface = new StringBuilder(paramString);
      paramAppInterface.append(".png");
      paramAppInterface = paramAppInterface.toString();
    }
    MQLruCache localMQLruCache = this.mLruCache;
    paramString = localObject;
    if (localMQLruCache != null) {
      paramString = (Drawable)localMQLruCache.get(paramAppInterface);
    }
    return paramString;
  }
  
  public String getStorePath(AppInterface paramAppInterface)
  {
    String str = getExternalSavePath(paramAppInterface);
    paramAppInterface = getInternalSavePath(paramAppInterface);
    if (TextUtils.isEmpty(str)) {
      return paramAppInterface;
    }
    return str;
  }
  
  public String getZipFolderPath(AppInterface paramAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramAppInterface = paramString;
    if (!paramString.endsWith(".zip"))
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append(paramString);
      paramAppInterface.append(".zip");
      paramAppInterface = paramAppInterface.toString();
    }
    paramAppInterface = PreloadStaticApi.c(paramAppInterface);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getZipBitmap zipName = ");
      paramString.append(paramAppInterface);
      QLog.d("PreloadImgApi", 2, paramString.toString());
    }
    return paramAppInterface;
  }
  
  public void onDestory()
  {
    cancelAllDownload();
    Map localMap = this.mDownloadingCallbackMap;
    if (localMap != null) {
      localMap.clear();
    }
  }
  
  public void startDownload(AppInterface paramAppInterface, Set<String> paramSet)
  {
    if (paramSet != null)
    {
      if (paramSet.isEmpty()) {
        return;
      }
      HashSet localHashSet = new HashSet(paramSet.size());
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        String str = (String)paramSet.next();
        if ((!TextUtils.isEmpty(str)) && (!str.endsWith(".png")) && (!str.endsWith(".zip")))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(".png");
          localHashSet.add(localStringBuilder.toString());
        }
      }
      if (localHashSet.size() > 0) {
        startDownloadWithSurffix(paramAppInterface, localHashSet);
      }
    }
  }
  
  public void startDownloadWithSurffix(AppInterface paramAppInterface, Set<String> paramSet)
  {
    if ((paramSet != null) && (!paramSet.isEmpty()))
    {
      this.mDownloaderInterface = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(1);
      HashMap localHashMap = new HashMap();
      ArrayList localArrayList = new ArrayList();
      String str2 = getExternalSavePath(paramAppInterface);
      String str3 = getInternalSavePath(paramAppInterface);
      String str1;
      if (TextUtils.isEmpty(str2)) {
        str1 = str3;
      } else {
        str1 = str2;
      }
      Bundle localBundle = new Bundle();
      ThreadManager.post(new PreloadImgApiImpl.3(this, paramSet, str2, str3, paramAppInterface, localArrayList, str1, localHashMap, localBundle), 8, new PreloadImgApiImpl.4(this, localArrayList, localHashMap, localBundle), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadImgApiImpl
 * JD-Core Version:    0.7.0.1
 */