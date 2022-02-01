package com.tencent.mobileqq.troop.avatar;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.qroute.QRoute;
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
import java.util.Set;

public class TroopUploadingThread
  extends Thread
{
  protected ArrayList<UploadItem> a;
  protected boolean b = true;
  protected UploadingTask c;
  protected volatile boolean d = false;
  protected HeaderSetting e;
  private BaseUrlAction f;
  
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
            if (!paramUploadItem.c) {
              break label277;
            }
            this.a.remove(paramUploadItem);
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
          paramUploadItem.d = i;
          localUploadState = new TroopUploadingThread.UploadState();
          localUploadState.a = 0;
          localUploadState.b = i;
          localUploadState.d = paramUploadItem.f;
          localUploadState.e = paramUploadItem.e;
          this.c.notifyObservers(localUploadState);
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
    //   0: new 123	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 124	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: getstatic 130	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   12: putfield 133	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   15: aload_2
    //   16: iconst_1
    //   17: putfield 136	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   20: aload_1
    //   21: aload_2
    //   22: invokestatic 142	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   25: pop
    //   26: aload_2
    //   27: ldc 144
    //   29: invokestatic 150	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   32: checkcast 144	com/tencent/mobileqq/troop/avatar/api/ITroopPhotoUtilsApi
    //   35: aload_2
    //   36: sipush 1024
    //   39: sipush 1024
    //   42: invokeinterface 154 4 0
    //   47: putfield 157	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   50: aload_2
    //   51: iconst_0
    //   52: putfield 136	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   55: aload_1
    //   56: aload_2
    //   57: invokestatic 161	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: astore_2
    //   61: aload_2
    //   62: ifnonnull +5 -> 67
    //   65: aconst_null
    //   66: areturn
    //   67: ldc 163
    //   69: invokestatic 150	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   72: checkcast 163	com/tencent/mobileqq/troop/api/ITroopCardApi
    //   75: aload_2
    //   76: aload_1
    //   77: invokeinterface 167 3 0
    //   82: astore_3
    //   83: aload_3
    //   84: ifnonnull +5 -> 89
    //   87: aconst_null
    //   88: areturn
    //   89: new 169	java/io/ByteArrayOutputStream
    //   92: dup
    //   93: invokespecial 170	java/io/ByteArrayOutputStream:<init>	()V
    //   96: astore_2
    //   97: aload_2
    //   98: astore_1
    //   99: aload_3
    //   100: getstatic 176	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   103: bipush 100
    //   105: aload_2
    //   106: invokevirtual 182	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   109: pop
    //   110: aload_2
    //   111: invokevirtual 183	java/io/ByteArrayOutputStream:close	()V
    //   114: goto +8 -> 122
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   122: aload_3
    //   123: invokevirtual 186	android/graphics/Bitmap:isRecycled	()Z
    //   126: ifne +7 -> 133
    //   129: aload_3
    //   130: invokevirtual 189	android/graphics/Bitmap:recycle	()V
    //   133: aload_2
    //   134: areturn
    //   135: astore_3
    //   136: goto +12 -> 148
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_1
    //   142: goto +78 -> 220
    //   145: astore_3
    //   146: aconst_null
    //   147: astore_2
    //   148: aload_2
    //   149: astore_1
    //   150: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +49 -> 202
    //   156: aload_2
    //   157: astore_1
    //   158: new 191	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   165: astore 4
    //   167: aload_2
    //   168: astore_1
    //   169: aload 4
    //   171: ldc 194
    //   173: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_2
    //   178: astore_1
    //   179: aload 4
    //   181: aload_3
    //   182: invokevirtual 201	java/lang/Exception:toString	()Ljava/lang/String;
    //   185: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_2
    //   190: astore_1
    //   191: ldc 36
    //   193: iconst_2
    //   194: aload 4
    //   196: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: aload_2
    //   203: ifnull +14 -> 217
    //   206: aload_2
    //   207: invokevirtual 183	java/io/ByteArrayOutputStream:close	()V
    //   210: aconst_null
    //   211: areturn
    //   212: astore_1
    //   213: aload_1
    //   214: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   217: aconst_null
    //   218: areturn
    //   219: astore_2
    //   220: aload_1
    //   221: ifnull +15 -> 236
    //   224: aload_1
    //   225: invokevirtual 183	java/io/ByteArrayOutputStream:close	()V
    //   228: goto +8 -> 236
    //   231: astore_1
    //   232: aload_1
    //   233: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   236: aload_2
    //   237: athrow
    //   238: astore_1
    //   239: aconst_null
    //   240: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	TroopUploadingThread
    //   0	241	1	paramString	String
    //   7	127	2	localObject1	Object
    //   139	1	2	localObject2	Object
    //   147	60	2	localObject3	Object
    //   219	18	2	localObject4	Object
    //   82	48	3	localBitmap	android.graphics.Bitmap
    //   135	1	3	localException1	java.lang.Exception
    //   145	37	3	localException2	java.lang.Exception
    //   165	30	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   110	114	117	java/io/IOException
    //   99	110	135	java/lang/Exception
    //   89	97	139	finally
    //   89	97	145	java/lang/Exception
    //   206	210	212	java/io/IOException
    //   99	110	219	finally
    //   150	156	219	finally
    //   158	167	219	finally
    //   169	177	219	finally
    //   179	189	219	finally
    //   191	202	219	finally
    //   224	228	231	java/io/IOException
    //   0	61	238	java/lang/OutOfMemoryError
    //   0	61	238	java/lang/Exception
    //   67	83	238	java/lang/OutOfMemoryError
    //   67	83	238	java/lang/Exception
  }
  
  /* Error */
  public HttpURLConnection a(URL paramURL, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +19 -> 20
    //   4: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +11 -> 18
    //   10: ldc 36
    //   12: iconst_2
    //   13: ldc 209
    //   15: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aconst_null
    //   19: areturn
    //   20: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +41 -> 64
    //   26: new 191	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   33: astore 5
    //   35: aload 5
    //   37: ldc 211
    //   39: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 5
    //   45: aload_1
    //   46: invokevirtual 214	java/net/URL:toString	()Ljava/lang/String;
    //   49: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 36
    //   55: iconst_2
    //   56: aload 5
    //   58: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_1
    //   65: invokevirtual 214	java/net/URL:toString	()Ljava/lang/String;
    //   68: ldc 216
    //   70: invokevirtual 222	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   73: ifeq +77 -> 150
    //   76: aload_1
    //   77: invokevirtual 226	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   80: checkcast 228	javax/net/ssl/HttpsURLConnection
    //   83: astore_1
    //   84: aload_1
    //   85: iconst_1
    //   86: invokevirtual 232	javax/net/ssl/HttpsURLConnection:setInstanceFollowRedirects	(Z)V
    //   89: aload_0
    //   90: getfield 234	com/tencent/mobileqq/troop/avatar/TroopUploadingThread:e	Lcom/tencent/mobileqq/troop/avatar/HeaderSetting;
    //   93: ifnull +29 -> 122
    //   96: aload_0
    //   97: getfield 234	com/tencent/mobileqq/troop/avatar/TroopUploadingThread:e	Lcom/tencent/mobileqq/troop/avatar/HeaderSetting;
    //   100: invokevirtual 238	com/tencent/mobileqq/troop/avatar/HeaderSetting:a	()Ljava/lang/String;
    //   103: invokevirtual 241	java/lang/String:isEmpty	()Z
    //   106: ifne +16 -> 122
    //   109: aload_1
    //   110: ldc 243
    //   112: aload_0
    //   113: getfield 234	com/tencent/mobileqq/troop/avatar/TroopUploadingThread:e	Lcom/tencent/mobileqq/troop/avatar/HeaderSetting;
    //   116: invokevirtual 238	com/tencent/mobileqq/troop/avatar/HeaderSetting:a	()Ljava/lang/String;
    //   119: invokevirtual 247	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_1
    //   123: new 249	com/tencent/mobileqq/troop/avatar/HttpDnsTLSSniSocketFactory
    //   126: dup
    //   127: aload_1
    //   128: invokespecial 252	com/tencent/mobileqq/troop/avatar/HttpDnsTLSSniSocketFactory:<init>	(Ljavax/net/ssl/HttpsURLConnection;)V
    //   131: invokevirtual 256	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   134: aload_1
    //   135: new 258	com/tencent/mobileqq/troop/avatar/TroopUploadingThread$1
    //   138: dup
    //   139: aload_0
    //   140: aload_1
    //   141: invokespecial 261	com/tencent/mobileqq/troop/avatar/TroopUploadingThread$1:<init>	(Lcom/tencent/mobileqq/troop/avatar/TroopUploadingThread;Ljavax/net/ssl/HttpsURLConnection;)V
    //   144: invokevirtual 265	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   147: goto +11 -> 158
    //   150: aload_1
    //   151: invokevirtual 226	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   154: checkcast 45	java/net/HttpURLConnection
    //   157: astore_1
    //   158: aload_1
    //   159: ifnonnull +5 -> 164
    //   162: aconst_null
    //   163: areturn
    //   164: aload_1
    //   165: iconst_1
    //   166: invokevirtual 268	java/net/HttpURLConnection:setDoInput	(Z)V
    //   169: aload_1
    //   170: iconst_1
    //   171: invokevirtual 271	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   174: lload_2
    //   175: l2i
    //   176: istore 4
    //   178: aload_1
    //   179: iload 4
    //   181: invokevirtual 275	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   184: aload_1
    //   185: iconst_0
    //   186: invokevirtual 278	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   189: getstatic 284	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   192: ifnull +24 -> 216
    //   195: getstatic 287	android/os/Build$VERSION:SDK_INT	I
    //   198: bipush 13
    //   200: if_icmple +16 -> 216
    //   203: aload_1
    //   204: ldc_w 289
    //   207: ldc_w 290
    //   210: invokevirtual 291	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: goto +13 -> 226
    //   216: aload_1
    //   217: ldc_w 293
    //   220: ldc_w 295
    //   223: invokevirtual 291	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_1
    //   227: ldc_w 297
    //   230: invokevirtual 301	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   233: aload_1
    //   234: ldc_w 303
    //   237: ldc_w 305
    //   240: invokevirtual 291	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: new 191	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   250: astore 5
    //   252: aload 5
    //   254: ldc_w 307
    //   257: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 5
    //   263: ldc_w 309
    //   266: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload_1
    //   271: ldc_w 311
    //   274: aload 5
    //   276: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokevirtual 291	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: aload_0
    //   283: getfield 234	com/tencent/mobileqq/troop/avatar/TroopUploadingThread:e	Lcom/tencent/mobileqq/troop/avatar/HeaderSetting;
    //   286: ifnull +30 -> 316
    //   289: aload_0
    //   290: getfield 234	com/tencent/mobileqq/troop/avatar/TroopUploadingThread:e	Lcom/tencent/mobileqq/troop/avatar/HeaderSetting;
    //   293: invokevirtual 313	com/tencent/mobileqq/troop/avatar/HeaderSetting:b	()Ljava/lang/String;
    //   296: invokevirtual 241	java/lang/String:isEmpty	()Z
    //   299: ifne +17 -> 316
    //   302: aload_1
    //   303: ldc_w 315
    //   306: aload_0
    //   307: getfield 234	com/tencent/mobileqq/troop/avatar/TroopUploadingThread:e	Lcom/tencent/mobileqq/troop/avatar/HeaderSetting;
    //   310: invokevirtual 313	com/tencent/mobileqq/troop/avatar/HeaderSetting:b	()Ljava/lang/String;
    //   313: invokevirtual 291	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_1
    //   317: areturn
    //   318: astore_1
    //   319: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +13 -> 335
    //   325: ldc 36
    //   327: iconst_2
    //   328: ldc_w 317
    //   331: aload_1
    //   332: invokestatic 116	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   335: aconst_null
    //   336: areturn
    //   337: astore_1
    //   338: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq +13 -> 354
    //   344: ldc 36
    //   346: iconst_2
    //   347: ldc_w 319
    //   350: aload_1
    //   351: invokestatic 116	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   354: aconst_null
    //   355: areturn
    //   356: astore_1
    //   357: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   360: ifeq +13 -> 373
    //   363: ldc 36
    //   365: iconst_2
    //   366: ldc_w 321
    //   369: aload_1
    //   370: invokestatic 116	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   373: aconst_null
    //   374: areturn
    //   375: astore_1
    //   376: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   379: ifeq +13 -> 392
    //   382: ldc 36
    //   384: iconst_2
    //   385: ldc_w 323
    //   388: aload_1
    //   389: invokestatic 116	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   392: aconst_null
    //   393: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	TroopUploadingThread
    //   0	394	1	paramURL	URL
    //   0	394	2	paramLong	long
    //   176	4	4	i	int
    //   33	242	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   189	213	318	java/net/ProtocolException
    //   216	226	318	java/net/ProtocolException
    //   226	316	318	java/net/ProtocolException
    //   178	189	337	java/lang/Exception
    //   164	174	356	java/lang/IllegalAccessError
    //   64	122	375	java/lang/Exception
    //   122	147	375	java/lang/Exception
    //   150	158	375	java/lang/Exception
  }
  
  public ArrayList<UploadItem> a()
  {
    return this.a;
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
  
  public void a(BaseUrlAction paramBaseUrlAction)
  {
    this.f = paramBaseUrlAction;
    paramBaseUrlAction = this.f;
    if (paramBaseUrlAction != null) {
      this.e = paramBaseUrlAction.a();
    }
  }
  
  public void a(UploadItem paramUploadItem)
  {
    Object localObject3 = a(paramUploadItem.a);
    int i1 = 0;
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
    localUploadState.d = paramUploadItem.f;
    localUploadState.e = paramUploadItem.e;
    int i = -1;
    int j;
    for (;;)
    {
      j = i;
      if (i1 > 3) {
        break;
      }
      i1 += 1;
      if (k != 0)
      {
        j = 101;
        break;
      }
      Object localObject4 = localObject1;
      int n = i;
      try
      {
        Object localObject5 = new StringBuilder();
        localObject4 = localObject1;
        n = i;
        ((StringBuilder)localObject5).append(paramUploadItem.a(i1 - 1));
        localObject4 = localObject1;
        n = i;
        ((StringBuilder)localObject5).append("&filesize=");
        localObject4 = localObject1;
        n = i;
        ((StringBuilder)localObject5).append(localObject3);
        localObject4 = localObject1;
        n = i;
        localObject5 = new URL(((StringBuilder)localObject5).toString());
        localObject1 = localObject5;
      }
      catch (Throwable localThrowable)
      {
        break label318;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localObject4 = localThrowable;
        n = i;
        QLog.d("TroopUploadingThread", 1, localMalformedURLException.getMessage(), localMalformedURLException);
      }
      localObject4 = localThrowable;
      n = i;
      HttpURLConnection localHttpURLConnection = a(localThrowable, m);
      if (localHttpURLConnection != null)
      {
        localObject4 = localThrowable;
        n = i;
        i = a((byte[])localObject3, localHttpURLConnection, paramUploadItem, i1);
        if (i != -4) {
          break label391;
        }
        continue;
        localObject4 = localThrowable;
        n = i;
        j = i;
        if (this.f == null) {
          break;
        }
        localObject4 = localThrowable;
        n = i;
        j = this.f.a(localHttpURLConnection, localUploadState, paramUploadItem);
        break;
        label318:
        QLog.d("TroopUploadingThread", 1, localThrowable.getMessage(), localThrowable);
        Object localObject2 = localObject4;
        i = n;
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        localUploadState.a = 1;
      }
      else
      {
        localUploadState.a = 2;
        localUploadState.b = j;
      }
      this.a.remove(paramUploadItem);
      if (j != 104) {
        this.c.notifyObservers(localUploadState);
      }
      return;
      label391:
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
    this.c = paramUploadingTask;
    if (this.a == null) {
      this.a = new ArrayList();
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      paramUploadingTask = (TroopClipPic)paramArrayList.next();
      new File(paramUploadingTask.id);
      UploadItem localUploadItem = new UploadItem();
      localUploadItem.b = a(paramHashMap, paramList, paramUploadingTask);
      localUploadItem.a = paramUploadingTask.id;
      localUploadItem.e = paramUploadingTask.type;
      localUploadItem.f = paramUploadingTask.ts;
      localUploadItem.g = paramUploadingTask.clipInfo;
      this.a.add(localUploadItem);
    }
  }
  
  public void run()
  {
    for (;;)
    {
      ArrayList localArrayList = this.a;
      if ((localArrayList == null) || (localArrayList.size() <= 0)) {
        break;
      }
      a((UploadItem)this.a.get(0));
    }
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopUploadingThread
 * JD-Core Version:    0.7.0.1
 */