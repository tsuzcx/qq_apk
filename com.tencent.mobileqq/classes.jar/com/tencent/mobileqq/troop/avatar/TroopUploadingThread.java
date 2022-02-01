package com.tencent.mobileqq.troop.avatar;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TroopUploadingThread
  extends Thread
{
  protected UploadingTask a;
  protected ArrayList<UploadItem> a;
  protected boolean a;
  protected volatile boolean b = false;
  
  public TroopUploadingThread()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int a(HttpURLConnection paramHttpURLConnection, TroopUploadingThread.UploadState paramUploadState, UploadItem paramUploadItem)
  {
    int k = -1;
    Object localObject1 = Integer.valueOf(-1);
    Map localMap = paramHttpURLConnection.getHeaderFields();
    try
    {
      j = paramHttpURLConnection.getResponseCode();
    }
    catch (IOException localIOException)
    {
      QLog.d("TroopUploadingThread", 1, "getResult IOException", localIOException);
      j = -1;
    }
    Object localObject3 = null;
    String str = null;
    Object localObject2 = localObject1;
    if (localMap != null)
    {
      Iterator localIterator = localMap.keySet().iterator();
      for (;;)
      {
        localObject2 = localObject1;
        localObject3 = str;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (String)localIterator.next();
        if (localObject2 != null)
        {
          localObject3 = localMap.get(localObject2);
          if ((localObject3 != null) && ((localObject3 instanceof List))) {
            if (((String)localObject2).equals("Result"))
            {
              localObject2 = (List)localObject3;
              localObject3 = ((List)localObject2).get(0);
              if ((localObject3 != null) && ((localObject3 instanceof String))) {
                localObject1 = Integer.valueOf(Integer.parseInt((String)((List)localObject2).get(0)));
              }
            }
            else if (((String)localObject2).equals("NewSeq"))
            {
              localObject2 = (List)localObject3;
              localObject3 = ((List)localObject2).get(0);
              if ((localObject3 != null) && ((localObject3 instanceof String))) {
                paramUploadState.c = Integer.parseInt((String)((List)localObject2).get(0));
              }
            }
            else if (((String)localObject2).equals("FileName"))
            {
              localObject2 = (List)localObject3;
              localObject3 = ((List)localObject2).get(0);
              if ((localObject3 != null) && ((localObject3 instanceof String))) {
                str = (String)((List)localObject2).get(0);
              }
            }
            else if (((String)localObject2).equals("X-ErrMsg"))
            {
              localObject2 = (List)localObject3;
              localObject3 = ((List)localObject2).get(0);
              if ((localObject3 != null) && ((localObject3 instanceof String))) {
                paramUploadState.jdField_a_of_type_JavaLangString = new String(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).base64Decode((String)((List)localObject2).get(0)));
              }
            }
            else if (((String)localObject2).equals("X-ErrNo"))
            {
              localObject2 = (List)localObject3;
              localObject3 = ((List)localObject2).get(0);
              if ((localObject3 != null) && ((localObject3 instanceof String)))
              {
                paramUploadState.e = Integer.parseInt((String)((List)localObject2).get(0));
                localObject1 = Integer.valueOf(paramUploadState.e);
              }
            }
          }
        }
      }
    }
    int i = ((Integer)localObject2).intValue();
    if (j != 200) {
      i = 102;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("result:");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append("resCode:");
    ((StringBuilder)localObject1).append(j);
    QLog.d("TroopUploadingThread", 1, ((StringBuilder)localObject1).toString());
    int j = k;
    if (localObject3 != null)
    {
      j = k;
      if (((String)localObject3).contains("_"))
      {
        localObject1 = ((String)localObject3).split("_");
        j = k;
        if (localObject1.length == 2) {
          try
          {
            paramUploadState.jdField_b_of_type_Int = Integer.parseInt(localObject1[1]);
            j = i;
          }
          catch (NumberFormatException paramUploadState)
          {
            paramUploadState.printStackTrace();
            j = k;
          }
        }
      }
    }
    if (paramUploadItem.jdField_a_of_type_Boolean) {
      return 104;
    }
    paramHttpURLConnection.disconnect();
    return j;
  }
  
  public int a(byte[] paramArrayOfByte, HttpURLConnection paramHttpURLConnection, UploadItem paramUploadItem, int paramInt)
  {
    if (paramHttpURLConnection == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopUploadingThread", 2, "writeData,con == null");
      }
      return -1;
    }
    label277:
    label304:
    for (;;)
    {
      try
      {
        DataOutputStream localDataOutputStream = new DataOutputStream(paramHttpURLConnection.getOutputStream());
        int n = paramArrayOfByte.length;
        int j = 0;
        int i = 0;
        if (j < n)
        {
          try
          {
            if (!paramUploadItem.jdField_a_of_type_Boolean) {
              break label277;
            }
            this.jdField_a_of_type_JavaUtilArrayList.remove(paramUploadItem);
            localDataOutputStream.flush();
            return 104;
          }
          catch (IOException paramArrayOfByte)
          {
            try
            {
              TroopUploadingThread.UploadState localUploadState;
              localDataOutputStream.flush();
              QLog.d("TroopUploadingThread", 1, paramArrayOfByte.getMessage(), paramArrayOfByte);
              if (paramHttpURLConnection == null) {
                continue;
              }
              paramHttpURLConnection.disconnect();
              if (paramInt >= 3) {
                continue;
              }
              return -4;
              return 103;
            }
            catch (IOException paramArrayOfByte)
            {
              paramArrayOfByte.printStackTrace();
              return -1;
            }
          }
          localDataOutputStream.write(paramArrayOfByte, j, k);
          j += k;
          k = j * 100;
          if (k / n - i <= 0) {
            break label304;
          }
          paramUploadItem.jdField_a_of_type_Int = i;
          localUploadState = new TroopUploadingThread.UploadState();
          localUploadState.jdField_a_of_type_Int = 0;
          localUploadState.jdField_b_of_type_Int = i;
          localUploadState.jdField_a_of_type_Long = paramUploadItem.jdField_a_of_type_Long;
          localUploadState.d = paramUploadItem.jdField_b_of_type_Int;
          this.jdField_a_of_type_ComTencentMobileqqTroopAvatarUploadingTask.notifyObservers(localUploadState);
          i = k / n;
          continue;
        }
        try
        {
          localDataOutputStream.flush();
          localDataOutputStream.close();
          return 0;
        }
        catch (IOException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          return -1;
        }
        m = n - j;
      }
      catch (IOException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopUploadingThread", 1, paramArrayOfByte.getMessage(), paramArrayOfByte);
        }
        if (paramHttpURLConnection != null) {
          paramHttpURLConnection.disconnect();
        }
        if (paramInt < 3) {
          return -4;
        }
        return -1;
      }
      int m;
      int k = m;
      if (m > 10240) {
        k = 10240;
      }
    }
  }
  
  /* Error */
  ByteArrayOutputStream a(String paramString)
  {
    // Byte code:
    //   0: new 238	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 239	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: getstatic 245	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   12: putfield 248	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   15: aload_2
    //   16: iconst_1
    //   17: putfield 251	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   20: aload_1
    //   21: aload_2
    //   22: invokestatic 257	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   25: pop
    //   26: aload_2
    //   27: ldc_w 259
    //   30: invokestatic 113	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   33: checkcast 259	com/tencent/mobileqq/troop/avatar/api/ITroopPhotoUtilsApi
    //   36: aload_2
    //   37: sipush 1024
    //   40: sipush 1024
    //   43: invokeinterface 263 4 0
    //   48: putfield 266	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   51: aload_2
    //   52: iconst_0
    //   53: putfield 251	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   56: aload_1
    //   57: aload_2
    //   58: invokestatic 270	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   61: astore_2
    //   62: aload_2
    //   63: ifnonnull +5 -> 68
    //   66: aconst_null
    //   67: areturn
    //   68: ldc 107
    //   70: invokestatic 113	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   73: checkcast 107	com/tencent/mobileqq/troop/api/ITroopCardApi
    //   76: aload_2
    //   77: aload_1
    //   78: invokeinterface 274 3 0
    //   83: astore_3
    //   84: aload_3
    //   85: ifnonnull +5 -> 90
    //   88: aconst_null
    //   89: areturn
    //   90: new 276	java/io/ByteArrayOutputStream
    //   93: dup
    //   94: invokespecial 277	java/io/ByteArrayOutputStream:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: astore_1
    //   100: aload_3
    //   101: getstatic 283	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   104: bipush 100
    //   106: aload_2
    //   107: invokevirtual 289	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   110: pop
    //   111: aload_2
    //   112: invokevirtual 290	java/io/ByteArrayOutputStream:close	()V
    //   115: goto +8 -> 123
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 225	java/io/IOException:printStackTrace	()V
    //   123: aload_3
    //   124: invokevirtual 293	android/graphics/Bitmap:isRecycled	()Z
    //   127: ifne +7 -> 134
    //   130: aload_3
    //   131: invokevirtual 296	android/graphics/Bitmap:recycle	()V
    //   134: aload_2
    //   135: areturn
    //   136: astore_3
    //   137: goto +12 -> 149
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_1
    //   143: goto +79 -> 222
    //   146: astore_3
    //   147: aconst_null
    //   148: astore_2
    //   149: aload_2
    //   150: astore_1
    //   151: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +50 -> 204
    //   157: aload_2
    //   158: astore_1
    //   159: new 133	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   166: astore 4
    //   168: aload_2
    //   169: astore_1
    //   170: aload 4
    //   172: ldc_w 298
    //   175: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_2
    //   180: astore_1
    //   181: aload 4
    //   183: aload_3
    //   184: invokevirtual 299	java/lang/Exception:toString	()Ljava/lang/String;
    //   187: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_2
    //   192: astore_1
    //   193: ldc 42
    //   195: iconst_2
    //   196: aload 4
    //   198: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_2
    //   205: ifnull +14 -> 219
    //   208: aload_2
    //   209: invokevirtual 290	java/io/ByteArrayOutputStream:close	()V
    //   212: aconst_null
    //   213: areturn
    //   214: astore_1
    //   215: aload_1
    //   216: invokevirtual 225	java/io/IOException:printStackTrace	()V
    //   219: aconst_null
    //   220: areturn
    //   221: astore_2
    //   222: aload_1
    //   223: ifnull +15 -> 238
    //   226: aload_1
    //   227: invokevirtual 290	java/io/ByteArrayOutputStream:close	()V
    //   230: goto +8 -> 238
    //   233: astore_1
    //   234: aload_1
    //   235: invokevirtual 225	java/io/IOException:printStackTrace	()V
    //   238: aload_2
    //   239: athrow
    //   240: astore_1
    //   241: aconst_null
    //   242: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	TroopUploadingThread
    //   0	243	1	paramString	String
    //   7	128	2	localObject1	Object
    //   140	1	2	localObject2	Object
    //   148	61	2	localObject3	Object
    //   221	18	2	localObject4	Object
    //   83	48	3	localBitmap	android.graphics.Bitmap
    //   136	1	3	localException1	java.lang.Exception
    //   146	38	3	localException2	java.lang.Exception
    //   166	31	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   111	115	118	java/io/IOException
    //   100	111	136	java/lang/Exception
    //   90	98	140	finally
    //   90	98	146	java/lang/Exception
    //   208	212	214	java/io/IOException
    //   100	111	221	finally
    //   151	157	221	finally
    //   159	168	221	finally
    //   170	179	221	finally
    //   181	191	221	finally
    //   193	204	221	finally
    //   226	230	233	java/io/IOException
    //   0	62	240	java/lang/OutOfMemoryError
    //   0	62	240	java/lang/Exception
    //   68	84	240	java/lang/OutOfMemoryError
    //   68	84	240	java/lang/Exception
  }
  
  /* Error */
  public HttpURLConnection a(URL paramURL, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +20 -> 21
    //   4: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 42
    //   12: iconst_2
    //   13: ldc_w 306
    //   16: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aconst_null
    //   20: areturn
    //   21: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +42 -> 66
    //   27: new 133	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   34: astore 5
    //   36: aload 5
    //   38: ldc_w 308
    //   41: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 5
    //   47: aload_1
    //   48: invokevirtual 311	java/net/URL:toString	()Ljava/lang/String;
    //   51: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: ldc 42
    //   57: iconst_2
    //   58: aload 5
    //   60: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: aload_1
    //   67: invokevirtual 311	java/net/URL:toString	()Ljava/lang/String;
    //   70: ldc_w 313
    //   73: invokevirtual 317	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   76: ifeq +54 -> 130
    //   79: aload_1
    //   80: invokevirtual 321	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   83: checkcast 323	javax/net/ssl/HttpsURLConnection
    //   86: astore_1
    //   87: aload_1
    //   88: iconst_1
    //   89: invokevirtual 327	javax/net/ssl/HttpsURLConnection:setInstanceFollowRedirects	(Z)V
    //   92: aload_1
    //   93: ldc_w 329
    //   96: ldc_w 331
    //   99: invokevirtual 335	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload_1
    //   103: new 337	com/tencent/mobileqq/troop/avatar/HttpDnsTLSSniSocketFactory
    //   106: dup
    //   107: aload_1
    //   108: invokespecial 340	com/tencent/mobileqq/troop/avatar/HttpDnsTLSSniSocketFactory:<init>	(Ljavax/net/ssl/HttpsURLConnection;)V
    //   111: invokevirtual 344	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   114: aload_1
    //   115: new 346	com/tencent/mobileqq/troop/avatar/TroopUploadingThread$1
    //   118: dup
    //   119: aload_0
    //   120: aload_1
    //   121: invokespecial 349	com/tencent/mobileqq/troop/avatar/TroopUploadingThread$1:<init>	(Lcom/tencent/mobileqq/troop/avatar/TroopUploadingThread;Ljavax/net/ssl/HttpsURLConnection;)V
    //   124: invokevirtual 353	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   127: goto +11 -> 138
    //   130: aload_1
    //   131: invokevirtual 321	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   134: checkcast 32	java/net/HttpURLConnection
    //   137: astore_1
    //   138: aload_1
    //   139: ifnonnull +5 -> 144
    //   142: aconst_null
    //   143: areturn
    //   144: aload_1
    //   145: iconst_1
    //   146: invokevirtual 356	java/net/HttpURLConnection:setDoInput	(Z)V
    //   149: aload_1
    //   150: iconst_1
    //   151: invokevirtual 359	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   154: lload_2
    //   155: l2i
    //   156: istore 4
    //   158: aload_1
    //   159: iload 4
    //   161: invokevirtual 363	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   164: aload_1
    //   165: iconst_0
    //   166: invokevirtual 366	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   169: getstatic 371	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   172: ifnull +24 -> 196
    //   175: getstatic 374	android/os/Build$VERSION:SDK_INT	I
    //   178: bipush 13
    //   180: if_icmple +16 -> 196
    //   183: aload_1
    //   184: ldc_w 376
    //   187: ldc_w 377
    //   190: invokevirtual 378	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: goto +13 -> 206
    //   196: aload_1
    //   197: ldc_w 380
    //   200: ldc_w 382
    //   203: invokevirtual 378	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload_1
    //   207: ldc_w 384
    //   210: invokevirtual 388	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   213: aload_1
    //   214: ldc_w 390
    //   217: ldc_w 392
    //   220: invokevirtual 378	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: new 133	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   230: astore 5
    //   232: aload 5
    //   234: ldc_w 394
    //   237: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload 5
    //   243: ldc_w 396
    //   246: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_1
    //   251: ldc_w 398
    //   254: aload 5
    //   256: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokevirtual 378	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload_1
    //   263: areturn
    //   264: astore_1
    //   265: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +13 -> 281
    //   271: ldc 42
    //   273: iconst_2
    //   274: ldc_w 400
    //   277: aload_1
    //   278: invokestatic 231	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   281: aconst_null
    //   282: areturn
    //   283: astore_1
    //   284: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq +13 -> 300
    //   290: ldc 42
    //   292: iconst_2
    //   293: ldc_w 402
    //   296: aload_1
    //   297: invokestatic 231	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   300: aconst_null
    //   301: areturn
    //   302: astore_1
    //   303: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   306: ifeq +13 -> 319
    //   309: ldc 42
    //   311: iconst_2
    //   312: ldc_w 404
    //   315: aload_1
    //   316: invokestatic 231	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   319: aconst_null
    //   320: areturn
    //   321: astore_1
    //   322: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq +13 -> 338
    //   328: ldc 42
    //   330: iconst_2
    //   331: ldc_w 406
    //   334: aload_1
    //   335: invokestatic 231	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   338: aconst_null
    //   339: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	this	TroopUploadingThread
    //   0	340	1	paramURL	URL
    //   0	340	2	paramLong	long
    //   156	4	4	i	int
    //   34	221	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   169	193	264	java/net/ProtocolException
    //   196	206	264	java/net/ProtocolException
    //   206	262	264	java/net/ProtocolException
    //   158	169	283	java/lang/Exception
    //   144	154	302	java/lang/IllegalAccessError
    //   66	127	321	java/lang/Exception
    //   130	138	321	java/lang/Exception
  }
  
  public ArrayList<UploadItem> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  protected List<String> a(HashMap<String, String> paramHashMap, List<String> paramList, TroopClipPic paramTroopClipPic)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      paramList = (String)localIterator1.next();
      Object localObject = paramList;
      if (paramHashMap != null)
      {
        Iterator localIterator2 = paramHashMap.keySet().iterator();
        for (;;)
        {
          localObject = paramList;
          if (!localIterator2.hasNext()) {
            break;
          }
          localObject = (String)localIterator2.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramList);
          localStringBuilder.append("&");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("=");
          localStringBuilder.append((String)paramHashMap.get(localObject));
          paramList = localStringBuilder.toString();
        }
      }
      paramList = new StringBuilder();
      paramList.append((String)localObject);
      paramList.append("&subcmd=");
      paramList.append(((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getSubcmdByType(paramTroopClipPic.type));
      paramList = paramList.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramList);
      ((StringBuilder)localObject).append("&subver=101");
      paramList = ((StringBuilder)localObject).toString();
      if (!TextUtils.isEmpty(paramTroopClipPic.clipInfo))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramList);
        ((StringBuilder)localObject).append("&clip=");
        ((StringBuilder)localObject).append(paramTroopClipPic.clipInfo);
        paramList = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramList);
        ((StringBuilder)localObject).append("&clip=");
        ((StringBuilder)localObject).append(((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getClipStr(0, 0, 0, 0));
        paramList = ((StringBuilder)localObject).toString();
      }
      localArrayList.add(paramList);
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopUploadingThread", 2, String.format("geturl=%s", new Object[] { Arrays.toString(localArrayList.toArray()) }));
    }
    return localArrayList;
  }
  
  public void a(UploadItem paramUploadItem)
  {
    Object localObject3 = a(paramUploadItem.jdField_a_of_type_JavaLangString);
    int n = 0;
    Object localObject1 = null;
    int k;
    int m;
    if (localObject3 == null)
    {
      localObject3 = null;
      k = 1;
      m = -1;
    }
    else
    {
      localObject3 = ((ByteArrayOutputStream)localObject3).toByteArray();
      m = localObject3.length;
      k = 0;
    }
    TroopUploadingThread.UploadState localUploadState = new TroopUploadingThread.UploadState();
    localUploadState.jdField_a_of_type_Long = paramUploadItem.jdField_a_of_type_Long;
    localUploadState.d = paramUploadItem.jdField_b_of_type_Int;
    int i = -1;
    int j;
    for (;;)
    {
      j = i;
      if (n > 3) {
        break;
      }
      n += 1;
      if (k != 0)
      {
        j = 101;
        break;
      }
      Object localObject4 = localObject1;
      j = i;
      try
      {
        Object localObject5 = new StringBuilder();
        localObject4 = localObject1;
        j = i;
        ((StringBuilder)localObject5).append(paramUploadItem.a(n - 1));
        localObject4 = localObject1;
        j = i;
        ((StringBuilder)localObject5).append("&filesize=");
        localObject4 = localObject1;
        j = i;
        ((StringBuilder)localObject5).append(localObject3);
        localObject4 = localObject1;
        j = i;
        localObject5 = new URL(((StringBuilder)localObject5).toString());
        localObject1 = localObject5;
      }
      catch (Throwable localThrowable)
      {
        break label292;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localObject4 = localThrowable;
        j = i;
        QLog.d("TroopUploadingThread", 1, localMalformedURLException.getMessage(), localMalformedURLException);
      }
      localObject4 = localThrowable;
      j = i;
      HttpURLConnection localHttpURLConnection = a(localThrowable, m);
      if (localHttpURLConnection != null)
      {
        localObject4 = localThrowable;
        j = i;
        i = a((byte[])localObject3, localHttpURLConnection, paramUploadItem, n);
        if (i != -4) {
          break label364;
        }
        continue;
        localObject4 = localThrowable;
        j = i;
        i = a(localHttpURLConnection, localUploadState, paramUploadItem);
        j = i;
        break;
        label292:
        QLog.d("TroopUploadingThread", 1, localThrowable.getMessage(), localThrowable);
        Object localObject2 = localObject4;
        i = j;
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        localUploadState.jdField_a_of_type_Int = 1;
      }
      else
      {
        localUploadState.jdField_a_of_type_Int = 2;
        localUploadState.jdField_b_of_type_Int = j;
      }
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramUploadItem);
      if (j != 104) {
        this.jdField_a_of_type_ComTencentMobileqqTroopAvatarUploadingTask.notifyObservers(localUploadState);
      }
      return;
      label364:
      j = i;
      if (i != -1)
      {
        if (i != 104) {
          break;
        }
        j = i;
      }
    }
  }
  
  public void a(ArrayList<TroopClipPic> paramArrayList, HashMap<String, String> paramHashMap, List<String> paramList, UploadingTask paramUploadingTask)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopAvatarUploadingTask = paramUploadingTask;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      paramUploadingTask = (TroopClipPic)paramArrayList.next();
      new File(paramUploadingTask.id);
      UploadItem localUploadItem = new UploadItem();
      localUploadItem.jdField_a_of_type_JavaUtilList = a(paramHashMap, paramList, paramUploadingTask);
      localUploadItem.jdField_a_of_type_JavaLangString = paramUploadingTask.id;
      localUploadItem.jdField_b_of_type_Int = paramUploadingTask.type;
      localUploadItem.jdField_a_of_type_Long = paramUploadingTask.ts;
      localUploadItem.jdField_b_of_type_JavaLangString = paramUploadingTask.clipInfo;
      this.jdField_a_of_type_JavaUtilArrayList.add(localUploadItem);
    }
  }
  
  public void run()
  {
    for (;;)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localArrayList == null) || (localArrayList.size() <= 0)) {
        break;
      }
      a((UploadItem)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopAvatarUploadingTask = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopUploadingThread
 * JD-Core Version:    0.7.0.1
 */