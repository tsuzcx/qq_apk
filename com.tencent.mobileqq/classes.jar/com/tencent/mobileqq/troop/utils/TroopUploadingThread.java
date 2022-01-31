package com.tencent.mobileqq.troop.utils;

import ageu;
import android.text.TextUtils;
import azli;
import azln;
import azlp;
import bbrj;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TroopUploadingThread
  extends Thread
{
  protected azlp a;
  protected ArrayList<azln> a;
  protected boolean a;
  protected volatile boolean b;
  
  public TroopUploadingThread()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int a(HttpURLConnection paramHttpURLConnection, azli paramazli, azln paramazln)
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
        break label435;
      }
      Iterator localIterator = localMap.keySet().iterator();
      for (;;)
      {
        localObject2 = str;
        localObject3 = localObject1;
        if (!localIterator.hasNext()) {
          break label435;
        }
        localObject3 = (String)localIterator.next();
        if (localObject3 == null) {
          break label579;
        }
        localObject2 = localMap.get(localObject3);
        if ((localObject2 == null) || (!(localObject2 instanceof List))) {
          break label579;
        }
        if (!((String)localObject3).equals("Result")) {
          break;
        }
        localObject3 = ((List)localObject2).get(0);
        if ((localObject3 == null) || (!(localObject3 instanceof String))) {
          break label579;
        }
        localObject1 = Integer.valueOf(Integer.parseInt((String)((List)localObject2).get(0)));
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        j = -1;
        continue;
        if (!localIOException.equals("NewSeq")) {
          break;
        }
        localObject4 = ((List)localObject2).get(0);
        if ((localObject4 != null) && ((localObject4 instanceof String))) {
          paramazli.c = Integer.parseInt((String)((List)localObject2).get(0));
        }
      }
      if (!localObject4.equals("FileName")) {
        break label298;
      }
    }
    Object localObject4 = ((List)localObject2).get(0);
    if ((localObject4 != null) && ((localObject4 instanceof String))) {
      str = (String)((List)localObject2).get(0);
    }
    for (;;)
    {
      break;
      label298:
      if (localObject4.equals("X-ErrMsg"))
      {
        localObject4 = ((List)localObject2).get(0);
        if ((localObject4 != null) && ((localObject4 instanceof String))) {
          paramazli.jdField_a_of_type_JavaLangString = new String(bbrj.a((String)((List)localObject2).get(0), 0));
        }
        break;
      }
      if (localObject4.equals("X-ErrNo"))
      {
        localObject4 = ((List)localObject2).get(0);
        if ((localObject4 != null) && ((localObject4 instanceof String)))
        {
          paramazli.e = Integer.parseInt((String)((List)localObject2).get(0));
          localObject1 = Integer.valueOf(paramazli.e);
          break;
          label435:
          int i = localObject4.intValue();
          if (j != 200) {
            i = 102;
          }
          if ((i != 0) && (QLog.isColorLevel())) {
            QLog.d("TroopUploadingThread", 2, "result:" + i);
          }
          j = k;
          if (localObject2 != null)
          {
            j = k;
            if (localObject2.contains("_"))
            {
              localObject1 = localObject2.split("_");
              if (localObject1.length != 2) {
                break label566;
              }
            }
          }
          for (;;)
          {
            try
            {
              paramazli.jdField_b_of_type_Int = Integer.parseInt(localObject1[1]);
              j = i;
              if (!paramazln.jdField_a_of_type_Boolean) {
                break;
              }
              return 104;
            }
            catch (NumberFormatException paramazli)
            {
              paramazli.printStackTrace();
              i = -1;
              continue;
            }
            label566:
            i = -1;
          }
          paramHttpURLConnection.disconnect();
          return j;
        }
      }
      label579:
      break;
    }
  }
  
  /* Error */
  public int a(byte[] paramArrayOfByte, HttpURLConnection paramHttpURLConnection, azln paramazln, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +19 -> 20
    //   4: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +11 -> 18
    //   10: ldc 122
    //   12: iconst_2
    //   13: ldc 164
    //   15: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: iconst_m1
    //   19: ireturn
    //   20: new 166	java/io/DataOutputStream
    //   23: dup
    //   24: aload_2
    //   25: invokevirtual 170	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   28: invokespecial 173	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore 9
    //   33: aload_1
    //   34: arraylength
    //   35: istore 8
    //   37: iconst_0
    //   38: istore 5
    //   40: iconst_0
    //   41: istore 6
    //   43: iload 6
    //   45: iload 8
    //   47: if_icmpge +224 -> 271
    //   50: aload_3
    //   51: getfield 157	azln:jdField_a_of_type_Boolean	Z
    //   54: ifeq +55 -> 109
    //   57: aload_0
    //   58: getfield 175	com/tencent/mobileqq/troop/utils/TroopUploadingThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   61: aload_3
    //   62: invokevirtual 180	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   65: pop
    //   66: aload 9
    //   68: invokevirtual 183	java/io/DataOutputStream:flush	()V
    //   71: bipush 104
    //   73: ireturn
    //   74: astore_1
    //   75: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +12 -> 90
    //   81: ldc 122
    //   83: iconst_2
    //   84: ldc 185
    //   86: aload_1
    //   87: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   90: iconst_0
    //   91: ifeq -73 -> 18
    //   94: new 191	java/lang/NullPointerException
    //   97: dup
    //   98: invokespecial 192	java/lang/NullPointerException:<init>	()V
    //   101: athrow
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   107: iconst_m1
    //   108: ireturn
    //   109: iload 8
    //   111: iload 6
    //   113: isub
    //   114: sipush 10240
    //   117: if_icmple +107 -> 224
    //   120: sipush 10240
    //   123: istore 7
    //   125: aload 9
    //   127: aload_1
    //   128: iload 6
    //   130: iload 7
    //   132: invokevirtual 196	java/io/DataOutputStream:write	([BII)V
    //   135: iload 6
    //   137: iload 7
    //   139: iadd
    //   140: istore 6
    //   142: iload 6
    //   144: bipush 100
    //   146: imul
    //   147: iload 8
    //   149: idiv
    //   150: iload 5
    //   152: isub
    //   153: ifle +58 -> 211
    //   156: aload_3
    //   157: iload 5
    //   159: putfield 198	azln:jdField_a_of_type_Int	I
    //   162: new 88	azli
    //   165: dup
    //   166: invokespecial 199	azli:<init>	()V
    //   169: astore 10
    //   171: aload 10
    //   173: iconst_0
    //   174: putfield 200	azli:jdField_a_of_type_Int	I
    //   177: aload 10
    //   179: iload 5
    //   181: putfield 154	azli:jdField_b_of_type_Int	I
    //   184: aload 10
    //   186: aload_3
    //   187: getfield 203	azln:jdField_a_of_type_Long	J
    //   190: putfield 204	azli:jdField_a_of_type_Long	J
    //   193: aload 10
    //   195: aload_3
    //   196: getfield 205	azln:jdField_b_of_type_Int	I
    //   199: putfield 207	azli:d	I
    //   202: aload_0
    //   203: getfield 209	com/tencent/mobileqq/troop/utils/TroopUploadingThread:jdField_a_of_type_Azlp	Lazlp;
    //   206: aload 10
    //   208: invokevirtual 215	azlp:notifyObservers	(Ljava/lang/Object;)V
    //   211: iload 6
    //   213: bipush 100
    //   215: imul
    //   216: iload 8
    //   218: idiv
    //   219: istore 5
    //   221: goto -178 -> 43
    //   224: iload 8
    //   226: iload 6
    //   228: isub
    //   229: istore 7
    //   231: goto -106 -> 125
    //   234: astore_1
    //   235: aload 9
    //   237: invokevirtual 183	java/io/DataOutputStream:flush	()V
    //   240: aload_1
    //   241: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   244: aload_2
    //   245: ifnull +7 -> 252
    //   248: aload_2
    //   249: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   252: iload 4
    //   254: iconst_3
    //   255: if_icmpge +13 -> 268
    //   258: bipush 252
    //   260: ireturn
    //   261: astore_1
    //   262: aload_1
    //   263: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   266: iconst_m1
    //   267: ireturn
    //   268: bipush 103
    //   270: ireturn
    //   271: aload 9
    //   273: invokevirtual 183	java/io/DataOutputStream:flush	()V
    //   276: aload 9
    //   278: invokevirtual 218	java/io/DataOutputStream:close	()V
    //   281: iconst_0
    //   282: ireturn
    //   283: astore_1
    //   284: aload_1
    //   285: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   288: iconst_m1
    //   289: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	TroopUploadingThread
    //   0	290	1	paramArrayOfByte	byte[]
    //   0	290	2	paramHttpURLConnection	HttpURLConnection
    //   0	290	3	paramazln	azln
    //   0	290	4	paramInt	int
    //   38	182	5	i	int
    //   41	188	6	j	int
    //   123	107	7	k	int
    //   35	194	8	m	int
    //   31	246	9	localDataOutputStream	java.io.DataOutputStream
    //   169	38	10	localazli	azli
    // Exception table:
    //   from	to	target	type
    //   20	33	74	java/io/IOException
    //   94	102	102	java/io/IOException
    //   50	71	234	java/io/IOException
    //   125	135	234	java/io/IOException
    //   142	211	234	java/io/IOException
    //   211	221	234	java/io/IOException
    //   235	240	261	java/io/IOException
    //   271	281	283	java/io/IOException
  }
  
  /* Error */
  ByteArrayOutputStream a(String paramString)
  {
    // Byte code:
    //   0: new 225	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 226	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: getstatic 232	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   12: putfield 235	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   15: aload_2
    //   16: iconst_1
    //   17: putfield 238	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   20: aload_1
    //   21: aload_2
    //   22: invokestatic 244	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   25: pop
    //   26: aload_2
    //   27: aload_2
    //   28: sipush 1024
    //   31: sipush 1024
    //   34: invokestatic 249	ageu:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   37: putfield 252	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   40: aload_2
    //   41: iconst_0
    //   42: putfield 238	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   45: aload_1
    //   46: aload_2
    //   47: invokestatic 256	bacm:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   50: astore_2
    //   51: aload_2
    //   52: ifnonnull +5 -> 57
    //   55: aconst_null
    //   56: areturn
    //   57: new 258	axwr
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 261	axwr:<init>	(Ljava/lang/String;)V
    //   65: aload_2
    //   66: invokevirtual 264	axwr:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   69: astore_2
    //   70: aload_2
    //   71: ifnull +143 -> 214
    //   74: new 266	java/io/ByteArrayOutputStream
    //   77: dup
    //   78: invokespecial 267	java/io/ByteArrayOutputStream:<init>	()V
    //   81: astore_1
    //   82: aload_2
    //   83: getstatic 273	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   86: bipush 100
    //   88: aload_1
    //   89: invokevirtual 279	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   92: pop
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 280	java/io/ByteArrayOutputStream:close	()V
    //   101: aload_2
    //   102: invokevirtual 283	android/graphics/Bitmap:isRecycled	()Z
    //   105: ifne +7 -> 112
    //   108: aload_2
    //   109: invokevirtual 286	android/graphics/Bitmap:recycle	()V
    //   112: aload_1
    //   113: areturn
    //   114: astore_3
    //   115: aload_3
    //   116: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   119: goto -18 -> 101
    //   122: astore_2
    //   123: aconst_null
    //   124: astore_1
    //   125: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +32 -> 160
    //   131: ldc 122
    //   133: iconst_2
    //   134: new 124	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 288
    //   144: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_2
    //   148: invokevirtual 289	java/lang/Exception:toString	()Ljava/lang/String;
    //   151: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: aload_1
    //   161: ifnull +53 -> 214
    //   164: aload_1
    //   165: invokevirtual 280	java/io/ByteArrayOutputStream:close	()V
    //   168: aconst_null
    //   169: areturn
    //   170: astore_1
    //   171: aload_1
    //   172: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_2
    //   178: aconst_null
    //   179: astore_1
    //   180: aload_1
    //   181: ifnull +7 -> 188
    //   184: aload_1
    //   185: invokevirtual 280	java/io/ByteArrayOutputStream:close	()V
    //   188: aload_2
    //   189: athrow
    //   190: astore_1
    //   191: aload_1
    //   192: invokevirtual 84	java/io/IOException:printStackTrace	()V
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
  
  protected String a(HashMap<String, String> paramHashMap, String paramString, TroopClipPic paramTroopClipPic)
  {
    String str = paramString;
    if (paramHashMap != null)
    {
      Iterator localIterator = paramHashMap.keySet().iterator();
      for (;;)
      {
        str = paramString;
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
        paramString = paramString + "&" + str + "=" + (String)paramHashMap.get(str);
      }
    }
    paramHashMap = str + "&subcmd=" + ageu.b(paramTroopClipPic.type);
    paramHashMap = paramHashMap + "&subver=101";
    if (!TextUtils.isEmpty(paramTroopClipPic.clipInfo)) {}
    for (paramHashMap = paramHashMap + "&clip=" + paramTroopClipPic.clipInfo;; paramHashMap = paramHashMap + "&clip=" + ageu.a(0, 0, 0, 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopUploadingThread", 2, String.format("geturl=%s", new Object[] { paramHashMap }));
      }
      return paramHashMap;
    }
  }
  
  /* Error */
  public HttpURLConnection a(URL paramURL, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +20 -> 21
    //   4: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 122
    //   12: iconst_2
    //   13: ldc_w 342
    //   16: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_1
    //   22: invokevirtual 348	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   25: checkcast 30	java/net/HttpURLConnection
    //   28: astore_1
    //   29: aload_1
    //   30: ifnonnull +27 -> 57
    //   33: aconst_null
    //   34: areturn
    //   35: astore_1
    //   36: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +13 -> 52
    //   42: ldc 122
    //   44: iconst_2
    //   45: ldc_w 350
    //   48: aload_1
    //   49: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   52: aconst_null
    //   53: astore_1
    //   54: goto -25 -> 29
    //   57: aload_1
    //   58: iconst_1
    //   59: invokevirtual 354	java/net/HttpURLConnection:setDoInput	(Z)V
    //   62: aload_1
    //   63: iconst_1
    //   64: invokevirtual 357	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   67: lload_2
    //   68: l2i
    //   69: istore 4
    //   71: aload_1
    //   72: iload 4
    //   74: invokevirtual 361	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   77: aload_1
    //   78: iconst_0
    //   79: invokevirtual 364	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   82: getstatic 369	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   85: ifnull +114 -> 199
    //   88: getstatic 372	android/os/Build$VERSION:SDK_INT	I
    //   91: bipush 13
    //   93: if_icmple +106 -> 199
    //   96: aload_1
    //   97: ldc_w 374
    //   100: ldc_w 375
    //   103: invokevirtual 379	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload_1
    //   107: ldc_w 381
    //   110: invokevirtual 384	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   113: aload_1
    //   114: ldc_w 386
    //   117: ldc_w 388
    //   120: invokevirtual 379	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_1
    //   124: ldc_w 390
    //   127: new 124	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 392
    //   137: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc_w 394
    //   143: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokevirtual 379	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload_1
    //   153: areturn
    //   154: astore_1
    //   155: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +13 -> 171
    //   161: ldc 122
    //   163: iconst_2
    //   164: ldc_w 396
    //   167: aload_1
    //   168: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   171: aconst_null
    //   172: areturn
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 397	java/lang/IllegalAccessError:printStackTrace	()V
    //   178: aconst_null
    //   179: areturn
    //   180: astore_1
    //   181: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq +13 -> 197
    //   187: ldc 122
    //   189: iconst_2
    //   190: ldc_w 399
    //   193: aload_1
    //   194: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: aconst_null
    //   198: areturn
    //   199: aload_1
    //   200: ldc_w 401
    //   203: ldc_w 403
    //   206: invokevirtual 379	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: goto -103 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	TroopUploadingThread
    //   0	212	1	paramURL	URL
    //   0	212	2	paramLong	long
    //   69	4	4	i	int
    // Exception table:
    //   from	to	target	type
    //   21	29	35	java/io/IOException
    //   82	106	154	java/net/ProtocolException
    //   106	152	154	java/net/ProtocolException
    //   199	209	154	java/net/ProtocolException
    //   57	67	173	java/lang/IllegalAccessError
    //   71	82	180	java/lang/Exception
  }
  
  public ArrayList<azln> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(azln paramazln)
  {
    Object localObject1 = a(paramazln.jdField_a_of_type_JavaLangString);
    int j;
    byte[] arrayOfByte;
    int k;
    azli localazli;
    int m;
    int i;
    if (localObject1 == null)
    {
      j = -1;
      arrayOfByte = null;
      k = 1;
      localazli = new azli();
      localazli.jdField_a_of_type_Long = paramazln.jdField_a_of_type_Long;
      localazli.d = paramazln.jdField_b_of_type_Int;
      m = 0;
      i = -1;
      localObject1 = null;
      label58:
      if (m >= 3) {
        break label270;
      }
      if (k == 0) {
        break label129;
      }
      i = 101;
    }
    label129:
    label267:
    label270:
    for (;;)
    {
      label72:
      if (i == 0) {
        localazli.jdField_a_of_type_Int = 1;
      }
      for (;;)
      {
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(paramazln);
          this.b = true;
          if (i != 104) {
            this.jdField_a_of_type_Azlp.notifyObservers(localazli);
          }
          return;
          arrayOfByte = ((ByteArrayOutputStream)localObject1).toByteArray();
          j = arrayOfByte.length;
          k = 0;
          break;
          try
          {
            Object localObject2 = new URL(paramazln.jdField_b_of_type_JavaLangString + "&filesize=" + arrayOfByte);
            localObject1 = localObject2;
            localObject2 = a((URL)localObject1, j);
            if (localObject2 != null) {}
          }
          catch (MalformedURLException localMalformedURLException)
          {
            for (;;)
            {
              localMalformedURLException.printStackTrace();
            }
            i = a(arrayOfByte, localMalformedURLException, paramazln, m);
            if (i == -4)
            {
              m += 1;
              break label58;
            }
            if (i == -1) {
              break label267;
            }
          }
        }
        if (i == 104) {
          break label72;
        }
        i = a(localMalformedURLException, localazli, paramazln);
        break label72;
        localazli.jdField_a_of_type_Int = 2;
        localazli.jdField_b_of_type_Int = i;
      }
    }
  }
  
  public void a(ArrayList<TroopClipPic> paramArrayList, HashMap<String, String> paramHashMap, String paramString, azlp paramazlp)
  {
    this.jdField_a_of_type_Azlp = paramazlp;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      paramazlp = (TroopClipPic)paramArrayList.next();
      new File(paramazlp.id);
      azln localazln = new azln();
      localazln.jdField_b_of_type_JavaLangString = a(paramHashMap, paramString, paramazlp);
      localazln.jdField_a_of_type_JavaLangString = paramazlp.id;
      localazln.jdField_b_of_type_Int = paramazlp.type;
      localazln.jdField_a_of_type_Long = paramazlp.ts;
      localazln.c = paramazlp.clipInfo;
      this.jdField_a_of_type_JavaUtilArrayList.add(localazln);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void run()
  {
    while ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      a((azln)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
    this.jdField_a_of_type_Azlp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUploadingThread
 * JD-Core Version:    0.7.0.1
 */