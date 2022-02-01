package com.tencent.mobileqq.troop.utils;

import ajpz;
import android.text.TextUtils;
import bfed;
import bfef;
import bfeh;
import bhmx;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
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
  protected bfeh a;
  protected ArrayList<bfef> a;
  protected boolean a;
  
  public TroopUploadingThread()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int a(HttpURLConnection paramHttpURLConnection, bfed parambfed, bfef parambfef)
  {
    int k = -1;
    Object localObject1 = Integer.valueOf(-1);
    Object localObject2 = null;
    String str = null;
    Map localMap = paramHttpURLConnection.getHeaderFields();
    int j;
    try
    {
      j = paramHttpURLConnection.getResponseCode();
      Object localObject3 = localObject1;
      if (localMap == null) {
        break label440;
      }
      Iterator localIterator = localMap.keySet().iterator();
      for (;;)
      {
        localObject2 = str;
        localObject3 = localObject1;
        if (!localIterator.hasNext()) {
          break label440;
        }
        localObject3 = (String)localIterator.next();
        if (localObject3 == null) {
          break label583;
        }
        localObject2 = localMap.get(localObject3);
        if ((localObject2 == null) || (!(localObject2 instanceof List))) {
          break label583;
        }
        if (!((String)localObject3).equals("Result")) {
          break;
        }
        localObject3 = ((List)localObject2).get(0);
        if ((localObject3 == null) || (!(localObject3 instanceof String))) {
          break label583;
        }
        localObject1 = Integer.valueOf(Integer.parseInt((String)((List)localObject2).get(0)));
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.d("TroopUploadingThread", 1, "getResult IOException", localIOException);
        j = -1;
        continue;
        if (!localIOException.equals("NewSeq")) {
          break;
        }
        localObject4 = ((List)localObject2).get(0);
        if ((localObject4 != null) && ((localObject4 instanceof String))) {
          parambfed.c = Integer.parseInt((String)((List)localObject2).get(0));
        }
      }
      if (!localObject4.equals("FileName")) {
        break label303;
      }
    }
    Object localObject4 = ((List)localObject2).get(0);
    if ((localObject4 != null) && ((localObject4 instanceof String))) {
      str = (String)((List)localObject2).get(0);
    }
    for (;;)
    {
      break;
      label303:
      if (localObject4.equals("X-ErrMsg"))
      {
        localObject4 = ((List)localObject2).get(0);
        if ((localObject4 != null) && ((localObject4 instanceof String))) {
          parambfed.jdField_a_of_type_JavaLangString = new String(bhmx.a((String)((List)localObject2).get(0), 0));
        }
        break;
      }
      if (localObject4.equals("X-ErrNo"))
      {
        localObject4 = ((List)localObject2).get(0);
        if ((localObject4 != null) && ((localObject4 instanceof String)))
        {
          parambfed.e = Integer.parseInt((String)((List)localObject2).get(0));
          localObject1 = Integer.valueOf(parambfed.e);
          break;
          label440:
          int i = localObject4.intValue();
          if (j != 200) {
            i = 102;
          }
          QLog.d("TroopUploadingThread", 1, "result:" + i + "resCode:" + j);
          j = k;
          if (localObject2 != null)
          {
            j = k;
            if (localObject2.contains("_"))
            {
              localObject1 = localObject2.split("_");
              if (localObject1.length != 2) {
                break label570;
              }
            }
          }
          for (;;)
          {
            try
            {
              parambfed.jdField_b_of_type_Int = Integer.parseInt(localObject1[1]);
              j = i;
              if (!parambfef.jdField_a_of_type_Boolean) {
                break;
              }
              return 104;
            }
            catch (NumberFormatException parambfed)
            {
              parambfed.printStackTrace();
              i = -1;
              continue;
            }
            label570:
            i = -1;
          }
          paramHttpURLConnection.disconnect();
          return j;
        }
      }
      label583:
      break;
    }
  }
  
  /* Error */
  public int a(byte[] paramArrayOfByte, HttpURLConnection paramHttpURLConnection, bfef parambfef, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +19 -> 20
    //   4: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +11 -> 18
    //   10: ldc 82
    //   12: iconst_2
    //   13: ldc 170
    //   15: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: iconst_m1
    //   19: ireturn
    //   20: new 172	java/io/DataOutputStream
    //   23: dup
    //   24: aload_2
    //   25: invokevirtual 176	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   28: invokespecial 179	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore 9
    //   33: aload_1
    //   34: arraylength
    //   35: istore 8
    //   37: iconst_0
    //   38: istore 5
    //   40: iconst_0
    //   41: istore 6
    //   43: iload 5
    //   45: iload 8
    //   47: if_icmpge +253 -> 300
    //   50: aload_3
    //   51: getfield 158	bfef:jdField_a_of_type_Boolean	Z
    //   54: ifeq +77 -> 131
    //   57: aload_0
    //   58: getfield 181	com/tencent/mobileqq/troop/utils/TroopUploadingThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   61: aload_3
    //   62: invokevirtual 186	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   65: pop
    //   66: aload 9
    //   68: invokevirtual 189	java/io/DataOutputStream:flush	()V
    //   71: bipush 104
    //   73: ireturn
    //   74: astore_3
    //   75: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +14 -> 92
    //   81: ldc 82
    //   83: iconst_1
    //   84: aload_3
    //   85: invokevirtual 192	java/io/IOException:getMessage	()Ljava/lang/String;
    //   88: aload_3
    //   89: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: iconst_0
    //   93: ifeq +11 -> 104
    //   96: new 197	java/lang/NullPointerException
    //   99: dup
    //   100: invokespecial 198	java/lang/NullPointerException:<init>	()V
    //   103: athrow
    //   104: aload_2
    //   105: ifnull +7 -> 112
    //   108: aload_2
    //   109: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   112: iload 4
    //   114: iconst_3
    //   115: if_icmpge +14 -> 129
    //   118: bipush 252
    //   120: ireturn
    //   121: astore_1
    //   122: aload_3
    //   123: invokevirtual 199	java/io/IOException:printStackTrace	()V
    //   126: goto -22 -> 104
    //   129: iconst_m1
    //   130: ireturn
    //   131: iload 8
    //   133: iload 5
    //   135: isub
    //   136: sipush 10240
    //   139: if_icmple +107 -> 246
    //   142: sipush 10240
    //   145: istore 7
    //   147: aload 9
    //   149: aload_1
    //   150: iload 5
    //   152: iload 7
    //   154: invokevirtual 203	java/io/DataOutputStream:write	([BII)V
    //   157: iload 5
    //   159: iload 7
    //   161: iadd
    //   162: istore 5
    //   164: iload 5
    //   166: bipush 100
    //   168: imul
    //   169: iload 8
    //   171: idiv
    //   172: iload 6
    //   174: isub
    //   175: ifle +58 -> 233
    //   178: aload_3
    //   179: iload 6
    //   181: putfield 205	bfef:jdField_a_of_type_Int	I
    //   184: new 94	bfed
    //   187: dup
    //   188: invokespecial 206	bfed:<init>	()V
    //   191: astore 10
    //   193: aload 10
    //   195: iconst_0
    //   196: putfield 207	bfed:jdField_a_of_type_Int	I
    //   199: aload 10
    //   201: iload 6
    //   203: putfield 155	bfed:jdField_b_of_type_Int	I
    //   206: aload 10
    //   208: aload_3
    //   209: getfield 210	bfef:jdField_a_of_type_Long	J
    //   212: putfield 211	bfed:jdField_a_of_type_Long	J
    //   215: aload 10
    //   217: aload_3
    //   218: getfield 212	bfef:jdField_b_of_type_Int	I
    //   221: putfield 214	bfed:d	I
    //   224: aload_0
    //   225: getfield 216	com/tencent/mobileqq/troop/utils/TroopUploadingThread:jdField_a_of_type_Bfeh	Lbfeh;
    //   228: aload 10
    //   230: invokevirtual 222	bfeh:notifyObservers	(Ljava/lang/Object;)V
    //   233: iload 5
    //   235: bipush 100
    //   237: imul
    //   238: iload 8
    //   240: idiv
    //   241: istore 6
    //   243: goto -200 -> 43
    //   246: iload 8
    //   248: iload 5
    //   250: isub
    //   251: istore 7
    //   253: goto -106 -> 147
    //   256: astore_1
    //   257: aload 9
    //   259: invokevirtual 189	java/io/DataOutputStream:flush	()V
    //   262: ldc 82
    //   264: iconst_1
    //   265: aload_1
    //   266: invokevirtual 192	java/io/IOException:getMessage	()Ljava/lang/String;
    //   269: aload_1
    //   270: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   273: aload_2
    //   274: ifnull +7 -> 281
    //   277: aload_2
    //   278: invokevirtual 164	java/net/HttpURLConnection:disconnect	()V
    //   281: iload 4
    //   283: iconst_3
    //   284: if_icmpge +13 -> 297
    //   287: bipush 252
    //   289: ireturn
    //   290: astore_1
    //   291: aload_1
    //   292: invokevirtual 199	java/io/IOException:printStackTrace	()V
    //   295: iconst_m1
    //   296: ireturn
    //   297: bipush 103
    //   299: ireturn
    //   300: aload 9
    //   302: invokevirtual 189	java/io/DataOutputStream:flush	()V
    //   305: aload 9
    //   307: invokevirtual 225	java/io/DataOutputStream:close	()V
    //   310: iconst_0
    //   311: ireturn
    //   312: astore_1
    //   313: aload_1
    //   314: invokevirtual 199	java/io/IOException:printStackTrace	()V
    //   317: iconst_m1
    //   318: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	TroopUploadingThread
    //   0	319	1	paramArrayOfByte	byte[]
    //   0	319	2	paramHttpURLConnection	HttpURLConnection
    //   0	319	3	parambfef	bfef
    //   0	319	4	paramInt	int
    //   38	213	5	i	int
    //   41	201	6	j	int
    //   145	107	7	k	int
    //   35	216	8	m	int
    //   31	275	9	localDataOutputStream	java.io.DataOutputStream
    //   191	38	10	localbfed	bfed
    // Exception table:
    //   from	to	target	type
    //   20	33	74	java/io/IOException
    //   96	104	121	java/io/IOException
    //   50	71	256	java/io/IOException
    //   147	157	256	java/io/IOException
    //   164	233	256	java/io/IOException
    //   233	243	256	java/io/IOException
    //   257	262	290	java/io/IOException
    //   300	310	312	java/io/IOException
  }
  
  /* Error */
  ByteArrayOutputStream a(String paramString)
  {
    // Byte code:
    //   0: new 232	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 233	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: getstatic 239	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   12: putfield 242	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   15: aload_2
    //   16: iconst_1
    //   17: putfield 245	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   20: aload_1
    //   21: aload_2
    //   22: invokestatic 251	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   25: pop
    //   26: aload_2
    //   27: aload_2
    //   28: sipush 1024
    //   31: sipush 1024
    //   34: invokestatic 256	ajpz:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   37: putfield 259	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   40: aload_2
    //   41: iconst_0
    //   42: putfield 245	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   45: aload_1
    //   46: aload_2
    //   47: invokestatic 263	bfvo:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   50: astore_2
    //   51: aload_2
    //   52: ifnonnull +5 -> 57
    //   55: aconst_null
    //   56: areturn
    //   57: new 265	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 268	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:<init>	(Ljava/lang/String;)V
    //   65: aload_2
    //   66: invokevirtual 272	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:creatBitmap	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   69: astore_2
    //   70: aload_2
    //   71: ifnull +143 -> 214
    //   74: new 274	java/io/ByteArrayOutputStream
    //   77: dup
    //   78: invokespecial 275	java/io/ByteArrayOutputStream:<init>	()V
    //   81: astore_1
    //   82: aload_2
    //   83: getstatic 281	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   86: bipush 100
    //   88: aload_1
    //   89: invokevirtual 287	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   92: pop
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 288	java/io/ByteArrayOutputStream:close	()V
    //   101: aload_2
    //   102: invokevirtual 291	android/graphics/Bitmap:isRecycled	()Z
    //   105: ifne +7 -> 112
    //   108: aload_2
    //   109: invokevirtual 294	android/graphics/Bitmap:recycle	()V
    //   112: aload_1
    //   113: areturn
    //   114: astore_3
    //   115: aload_3
    //   116: invokevirtual 199	java/io/IOException:printStackTrace	()V
    //   119: goto -18 -> 101
    //   122: astore_2
    //   123: aconst_null
    //   124: astore_1
    //   125: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +32 -> 160
    //   131: ldc 82
    //   133: iconst_2
    //   134: new 123	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 296
    //   144: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_2
    //   148: invokevirtual 297	java/lang/Exception:toString	()Ljava/lang/String;
    //   151: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: aload_1
    //   161: ifnull +53 -> 214
    //   164: aload_1
    //   165: invokevirtual 288	java/io/ByteArrayOutputStream:close	()V
    //   168: aconst_null
    //   169: areturn
    //   170: astore_1
    //   171: aload_1
    //   172: invokevirtual 199	java/io/IOException:printStackTrace	()V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_2
    //   178: aconst_null
    //   179: astore_1
    //   180: aload_1
    //   181: ifnull +7 -> 188
    //   184: aload_1
    //   185: invokevirtual 288	java/io/ByteArrayOutputStream:close	()V
    //   188: aload_2
    //   189: athrow
    //   190: astore_1
    //   191: aload_1
    //   192: invokevirtual 199	java/io/IOException:printStackTrace	()V
    //   195: goto -7 -> 188
    //   198: astore_2
    //   199: goto -19 -> 180
    //   202: astore_2
    //   203: goto -23 -> 180
    //   206: astore_2
    //   207: goto -82 -> 125
    //   210: astore_1
    //   211: aconst_null
    //   212: areturn
    //   213: astore_1
    //   214: aconst_null
    //   215: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	TroopUploadingThread
    //   0	216	1	paramString	String
    //   7	102	2	localObject1	Object
    //   122	26	2	localException1	java.lang.Exception
    //   177	12	2	localObject2	Object
    //   198	1	2	localObject3	Object
    //   202	1	2	localObject4	Object
    //   206	1	2	localException2	java.lang.Exception
    //   114	2	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   97	101	114	java/io/IOException
    //   74	82	122	java/lang/Exception
    //   164	168	170	java/io/IOException
    //   74	82	177	finally
    //   184	188	190	java/io/IOException
    //   82	93	198	finally
    //   125	160	202	finally
    //   82	93	206	java/lang/Exception
    //   0	51	210	java/lang/Exception
    //   57	70	210	java/lang/Exception
    //   0	51	213	java/lang/OutOfMemoryError
    //   57	70	213	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public HttpURLConnection a(URL paramURL, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +20 -> 21
    //   4: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 82
    //   12: iconst_2
    //   13: ldc_w 304
    //   16: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aconst_null
    //   20: areturn
    //   21: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +32 -> 56
    //   27: ldc 82
    //   29: iconst_2
    //   30: new 123	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 306
    //   40: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 309	java/net/URL:toString	()Ljava/lang/String;
    //   47: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_1
    //   57: invokevirtual 309	java/net/URL:toString	()Ljava/lang/String;
    //   60: ldc_w 311
    //   63: invokevirtual 315	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   66: ifeq +54 -> 120
    //   69: aload_1
    //   70: invokevirtual 319	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   73: checkcast 321	javax/net/ssl/HttpsURLConnection
    //   76: astore_1
    //   77: aload_1
    //   78: iconst_1
    //   79: invokevirtual 325	javax/net/ssl/HttpsURLConnection:setInstanceFollowRedirects	(Z)V
    //   82: aload_1
    //   83: ldc_w 327
    //   86: ldc_w 329
    //   89: invokevirtual 333	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_1
    //   93: new 335	bezb
    //   96: dup
    //   97: aload_1
    //   98: invokespecial 338	bezb:<init>	(Ljavax/net/ssl/HttpsURLConnection;)V
    //   101: invokevirtual 342	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   104: aload_1
    //   105: new 344	bfec
    //   108: dup
    //   109: aload_0
    //   110: aload_1
    //   111: invokespecial 347	bfec:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopUploadingThread;Ljavax/net/ssl/HttpsURLConnection;)V
    //   114: invokevirtual 351	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   117: goto +200 -> 317
    //   120: aload_1
    //   121: invokevirtual 319	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   124: checkcast 29	java/net/HttpURLConnection
    //   127: astore_1
    //   128: goto +189 -> 317
    //   131: astore_1
    //   132: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +13 -> 148
    //   138: ldc 82
    //   140: iconst_2
    //   141: ldc_w 353
    //   144: aload_1
    //   145: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: aconst_null
    //   149: areturn
    //   150: aload_1
    //   151: iconst_1
    //   152: invokevirtual 356	java/net/HttpURLConnection:setDoInput	(Z)V
    //   155: aload_1
    //   156: iconst_1
    //   157: invokevirtual 359	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   160: lload_2
    //   161: l2i
    //   162: istore 4
    //   164: aload_1
    //   165: iload 4
    //   167: invokevirtual 363	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   170: aload_1
    //   171: iconst_0
    //   172: invokevirtual 366	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   175: getstatic 371	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   178: ifnull +126 -> 304
    //   181: getstatic 374	android/os/Build$VERSION:SDK_INT	I
    //   184: bipush 13
    //   186: if_icmple +118 -> 304
    //   189: aload_1
    //   190: ldc_w 376
    //   193: ldc_w 377
    //   196: invokevirtual 378	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload_1
    //   200: ldc_w 380
    //   203: invokevirtual 383	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   206: aload_1
    //   207: ldc_w 385
    //   210: ldc_w 387
    //   213: invokevirtual 378	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload_1
    //   217: ldc_w 389
    //   220: new 123	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 391
    //   230: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 393
    //   236: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokevirtual 378	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload_1
    //   246: areturn
    //   247: astore_1
    //   248: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq +13 -> 264
    //   254: ldc 82
    //   256: iconst_2
    //   257: ldc_w 395
    //   260: aload_1
    //   261: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   264: aconst_null
    //   265: areturn
    //   266: astore_1
    //   267: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +13 -> 283
    //   273: ldc 82
    //   275: iconst_2
    //   276: ldc_w 397
    //   279: aload_1
    //   280: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: aconst_null
    //   284: areturn
    //   285: astore_1
    //   286: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +13 -> 302
    //   292: ldc 82
    //   294: iconst_2
    //   295: ldc_w 399
    //   298: aload_1
    //   299: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   302: aconst_null
    //   303: areturn
    //   304: aload_1
    //   305: ldc_w 401
    //   308: ldc_w 403
    //   311: invokevirtual 378	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: goto -115 -> 199
    //   317: aload_1
    //   318: ifnonnull -168 -> 150
    //   321: aconst_null
    //   322: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	TroopUploadingThread
    //   0	323	1	paramURL	URL
    //   0	323	2	paramLong	long
    //   162	4	4	i	int
    // Exception table:
    //   from	to	target	type
    //   56	117	131	java/lang/Exception
    //   120	128	131	java/lang/Exception
    //   175	199	247	java/net/ProtocolException
    //   199	245	247	java/net/ProtocolException
    //   304	314	247	java/net/ProtocolException
    //   150	160	266	java/lang/IllegalAccessError
    //   164	175	285	java/lang/Exception
  }
  
  public ArrayList<bfef> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  protected List<String> a(HashMap<String, String> paramHashMap, List<String> paramList, TroopClipPic paramTroopClipPic)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator1 = paramList.iterator();
    if (localIterator1.hasNext())
    {
      paramList = (String)localIterator1.next();
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
          paramList = paramList + "&" + (String)localObject + "=" + (String)paramHashMap.get(localObject);
        }
      }
      Object localObject = paramList;
      paramList = (String)localObject + "&subcmd=" + ajpz.b(paramTroopClipPic.type);
      paramList = paramList + "&subver=101";
      if (!TextUtils.isEmpty(paramTroopClipPic.clipInfo)) {}
      for (paramList = paramList + "&clip=" + paramTroopClipPic.clipInfo;; paramList = paramList + "&clip=" + ajpz.a(0, 0, 0, 0))
      {
        localArrayList.add(paramList);
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopUploadingThread", 2, String.format("geturl=%s", new Object[] { Arrays.toString(localArrayList.toArray()) }));
    }
    return localArrayList;
  }
  
  public void a(bfef parambfef)
  {
    Object localObject1 = a(parambfef.jdField_a_of_type_JavaLangString);
    int m;
    byte[] arrayOfByte;
    int n;
    bfed localbfed;
    int j;
    int i;
    label58:
    int k;
    if (localObject1 == null)
    {
      m = -1;
      arrayOfByte = null;
      n = 1;
      localbfed = new bfed();
      localbfed.jdField_a_of_type_Long = parambfef.jdField_a_of_type_Long;
      localbfed.d = parambfef.jdField_b_of_type_Int;
      localObject1 = null;
      j = 0;
      i = -1;
      k = i;
      if (j <= 3)
      {
        j += 1;
        if (n == 0) {
          break label134;
        }
        k = 101;
      }
      label79:
      if (k != 0) {
        break label332;
      }
      localbfed.jdField_a_of_type_Int = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambfef);
      if (k != 104) {
        this.jdField_a_of_type_Bfeh.notifyObservers(localbfed);
      }
      return;
      arrayOfByte = ((ByteArrayOutputStream)localObject1).toByteArray();
      m = arrayOfByte.length;
      n = 0;
      break;
      label134:
      k = i;
      Object localObject3 = localObject1;
      try
      {
        localObject4 = new URL(parambfef.a(j - 1) + "&filesize=" + arrayOfByte);
        localObject1 = localObject4;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          Object localObject4;
          long l;
          k = i;
          localObject3 = localObject1;
          QLog.d("TroopUploadingThread", 1, localMalformedURLException.getMessage(), localMalformedURLException);
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.d("TroopUploadingThread", 1, localThrowable.getMessage(), localThrowable);
        i = k;
        localObject2 = localObject3;
      }
      l = m;
      k = i;
      localObject3 = localObject1;
      localObject4 = a((URL)localObject1, l);
      Object localObject2;
      if (localObject4 == null)
      {
        break label58;
        break label58;
      }
      k = i;
      localObject3 = localObject2;
      i = a(arrayOfByte, localMalformedURLException, parambfef, j);
      if (i == -4) {
        break label58;
      }
      k = i;
      if (i == -1) {
        break label79;
      }
      k = i;
      if (i == 104) {
        break label79;
      }
      k = i;
      localObject3 = localObject2;
      i = a(localMalformedURLException, localbfed, parambfef);
      k = i;
      break label79;
      label332:
      localbfed.jdField_a_of_type_Int = 2;
      localbfed.jdField_b_of_type_Int = k;
    }
  }
  
  public void a(ArrayList<TroopClipPic> paramArrayList, HashMap<String, String> paramHashMap, List<String> paramList, bfeh parambfeh)
  {
    this.jdField_a_of_type_Bfeh = parambfeh;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      parambfeh = (TroopClipPic)paramArrayList.next();
      new File(parambfeh.id);
      bfef localbfef = new bfef();
      localbfef.jdField_a_of_type_JavaUtilList = a(paramHashMap, paramList, parambfeh);
      localbfef.jdField_a_of_type_JavaLangString = parambfeh.id;
      localbfef.jdField_b_of_type_Int = parambfeh.type;
      localbfef.jdField_a_of_type_Long = parambfeh.ts;
      localbfef.jdField_b_of_type_JavaLangString = parambfeh.clipInfo;
      this.jdField_a_of_type_JavaUtilArrayList.add(localbfef);
    }
  }
  
  public void run()
  {
    while ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      a((bfef)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
    this.jdField_a_of_type_Bfeh = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUploadingThread
 * JD-Core Version:    0.7.0.1
 */