package com.tencent.mobileqq.troop.utils;

import aiqe;
import android.text.TextUtils;
import bcpw;
import bcqb;
import bcqd;
import bezi;
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
  protected bcqd a;
  protected ArrayList<bcqb> a;
  protected boolean a;
  protected volatile boolean b;
  
  public TroopUploadingThread()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int a(HttpURLConnection paramHttpURLConnection, bcpw parambcpw, bcqb parambcqb)
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
          parambcpw.c = Integer.parseInt((String)((List)localObject2).get(0));
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
          parambcpw.jdField_a_of_type_JavaLangString = new String(bezi.a((String)((List)localObject2).get(0), 0));
        }
        break;
      }
      if (localObject4.equals("X-ErrNo"))
      {
        localObject4 = ((List)localObject2).get(0);
        if ((localObject4 != null) && ((localObject4 instanceof String)))
        {
          parambcpw.e = Integer.parseInt((String)((List)localObject2).get(0));
          localObject1 = Integer.valueOf(parambcpw.e);
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
              parambcpw.jdField_b_of_type_Int = Integer.parseInt(localObject1[1]);
              j = i;
              if (!parambcqb.jdField_a_of_type_Boolean) {
                break;
              }
              return 104;
            }
            catch (NumberFormatException parambcpw)
            {
              parambcpw.printStackTrace();
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
  public int a(byte[] paramArrayOfByte, HttpURLConnection paramHttpURLConnection, bcqb parambcqb, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +19 -> 20
    //   4: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +11 -> 18
    //   10: ldc 83
    //   12: iconst_2
    //   13: ldc 170
    //   15: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   51: getfield 158	bcqb:jdField_a_of_type_Boolean	Z
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
    //   74: astore_1
    //   75: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +14 -> 92
    //   81: ldc 83
    //   83: iconst_1
    //   84: aload_1
    //   85: invokevirtual 192	java/io/IOException:getMessage	()Ljava/lang/String;
    //   88: aload_1
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
    //   121: astore_3
    //   122: aload_1
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
    //   181: putfield 205	bcqb:jdField_a_of_type_Int	I
    //   184: new 95	bcpw
    //   187: dup
    //   188: invokespecial 206	bcpw:<init>	()V
    //   191: astore 10
    //   193: aload 10
    //   195: iconst_0
    //   196: putfield 207	bcpw:jdField_a_of_type_Int	I
    //   199: aload 10
    //   201: iload 6
    //   203: putfield 155	bcpw:jdField_b_of_type_Int	I
    //   206: aload 10
    //   208: aload_3
    //   209: getfield 210	bcqb:jdField_a_of_type_Long	J
    //   212: putfield 211	bcpw:jdField_a_of_type_Long	J
    //   215: aload 10
    //   217: aload_3
    //   218: getfield 212	bcqb:jdField_b_of_type_Int	I
    //   221: putfield 214	bcpw:d	I
    //   224: aload_0
    //   225: getfield 216	com/tencent/mobileqq/troop/utils/TroopUploadingThread:jdField_a_of_type_Bcqd	Lbcqd;
    //   228: aload 10
    //   230: invokevirtual 222	bcqd:notifyObservers	(Ljava/lang/Object;)V
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
    //   262: ldc 83
    //   264: iconst_1
    //   265: aload_1
    //   266: invokevirtual 192	java/io/IOException:getMessage	()Ljava/lang/String;
    //   269: aload_1
    //   270: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   0	319	3	parambcqb	bcqb
    //   0	319	4	paramInt	int
    //   38	213	5	i	int
    //   41	201	6	j	int
    //   145	107	7	k	int
    //   35	216	8	m	int
    //   31	275	9	localDataOutputStream	java.io.DataOutputStream
    //   191	38	10	localbcpw	bcpw
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
    //   34: invokestatic 256	aiqe:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   37: putfield 259	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   40: aload_2
    //   41: iconst_0
    //   42: putfield 245	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   45: aload_1
    //   46: aload_2
    //   47: invokestatic 263	bdhj:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   50: astore_2
    //   51: aload_2
    //   52: ifnonnull +5 -> 57
    //   55: aconst_null
    //   56: areturn
    //   57: new 265	bazi
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 268	bazi:<init>	(Ljava/lang/String;)V
    //   65: aload_2
    //   66: invokevirtual 271	bazi:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   69: astore_2
    //   70: aload_2
    //   71: ifnull +143 -> 214
    //   74: new 273	java/io/ByteArrayOutputStream
    //   77: dup
    //   78: invokespecial 274	java/io/ByteArrayOutputStream:<init>	()V
    //   81: astore_1
    //   82: aload_2
    //   83: getstatic 280	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   86: bipush 100
    //   88: aload_1
    //   89: invokevirtual 286	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   92: pop
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 287	java/io/ByteArrayOutputStream:close	()V
    //   101: aload_2
    //   102: invokevirtual 290	android/graphics/Bitmap:isRecycled	()Z
    //   105: ifne +7 -> 112
    //   108: aload_2
    //   109: invokevirtual 293	android/graphics/Bitmap:recycle	()V
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
    //   131: ldc 83
    //   133: iconst_2
    //   134: new 124	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 295
    //   144: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_2
    //   148: invokevirtual 296	java/lang/Exception:toString	()Ljava/lang/String;
    //   151: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: aload_1
    //   161: ifnull +53 -> 214
    //   164: aload_1
    //   165: invokevirtual 287	java/io/ByteArrayOutputStream:close	()V
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
    //   185: invokevirtual 287	java/io/ByteArrayOutputStream:close	()V
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
    //   10: ldc 83
    //   12: iconst_2
    //   13: ldc_w 303
    //   16: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_1
    //   22: invokevirtual 309	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   25: checkcast 30	java/net/HttpURLConnection
    //   28: astore_1
    //   29: aload_1
    //   30: ifnonnull +27 -> 57
    //   33: aconst_null
    //   34: areturn
    //   35: astore_1
    //   36: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +13 -> 52
    //   42: ldc 83
    //   44: iconst_2
    //   45: ldc_w 311
    //   48: aload_1
    //   49: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   52: aconst_null
    //   53: astore_1
    //   54: goto -25 -> 29
    //   57: aload_1
    //   58: iconst_1
    //   59: invokevirtual 315	java/net/HttpURLConnection:setDoInput	(Z)V
    //   62: aload_1
    //   63: iconst_1
    //   64: invokevirtual 318	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   67: lload_2
    //   68: l2i
    //   69: istore 4
    //   71: aload_1
    //   72: iload 4
    //   74: invokevirtual 322	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   77: aload_1
    //   78: iconst_0
    //   79: invokevirtual 325	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   82: getstatic 330	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   85: ifnull +126 -> 211
    //   88: getstatic 333	android/os/Build$VERSION:SDK_INT	I
    //   91: bipush 13
    //   93: if_icmple +118 -> 211
    //   96: aload_1
    //   97: ldc_w 335
    //   100: ldc_w 336
    //   103: invokevirtual 340	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload_1
    //   107: ldc_w 342
    //   110: invokevirtual 345	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   113: aload_1
    //   114: ldc_w 347
    //   117: ldc_w 349
    //   120: invokevirtual 340	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_1
    //   124: ldc_w 351
    //   127: new 124	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 353
    //   137: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc_w 355
    //   143: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokevirtual 340	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload_1
    //   153: areturn
    //   154: astore_1
    //   155: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +13 -> 171
    //   161: ldc 83
    //   163: iconst_2
    //   164: ldc_w 357
    //   167: aload_1
    //   168: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   171: aconst_null
    //   172: areturn
    //   173: astore_1
    //   174: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +13 -> 190
    //   180: ldc 83
    //   182: iconst_2
    //   183: ldc_w 359
    //   186: aload_1
    //   187: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: aconst_null
    //   191: areturn
    //   192: astore_1
    //   193: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +13 -> 209
    //   199: ldc 83
    //   201: iconst_2
    //   202: ldc_w 361
    //   205: aload_1
    //   206: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   209: aconst_null
    //   210: areturn
    //   211: aload_1
    //   212: ldc_w 363
    //   215: ldc_w 365
    //   218: invokevirtual 340	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: goto -115 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	TroopUploadingThread
    //   0	224	1	paramURL	URL
    //   0	224	2	paramLong	long
    //   69	4	4	i	int
    // Exception table:
    //   from	to	target	type
    //   21	29	35	java/io/IOException
    //   82	106	154	java/net/ProtocolException
    //   106	152	154	java/net/ProtocolException
    //   211	221	154	java/net/ProtocolException
    //   57	67	173	java/lang/IllegalAccessError
    //   71	82	192	java/lang/Exception
  }
  
  public ArrayList<bcqb> a()
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
      paramList = (String)localObject + "&subcmd=" + aiqe.b(paramTroopClipPic.type);
      paramList = paramList + "&subver=101";
      if (!TextUtils.isEmpty(paramTroopClipPic.clipInfo)) {}
      for (paramList = paramList + "&clip=" + paramTroopClipPic.clipInfo;; paramList = paramList + "&clip=" + aiqe.a(0, 0, 0, 0))
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
  
  public void a(bcqb parambcqb)
  {
    Object localObject1 = a(parambcqb.jdField_a_of_type_JavaLangString);
    int m;
    byte[] arrayOfByte;
    int n;
    bcpw localbcpw;
    int j;
    int i;
    label58:
    int k;
    if (localObject1 == null)
    {
      m = -1;
      arrayOfByte = null;
      n = 1;
      localbcpw = new bcpw();
      localbcpw.jdField_a_of_type_Long = parambcqb.jdField_a_of_type_Long;
      localbcpw.d = parambcqb.jdField_b_of_type_Int;
      localObject1 = null;
      j = 0;
      i = -1;
      k = i;
      if (j <= 3)
      {
        j += 1;
        if (n == 0) {
          break label139;
        }
        k = 101;
      }
      label79:
      if (k != 0) {
        break label337;
      }
      localbcpw.jdField_a_of_type_Int = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambcqb);
      this.b = true;
      if (k != 104) {
        this.jdField_a_of_type_Bcqd.notifyObservers(localbcpw);
      }
      return;
      arrayOfByte = ((ByteArrayOutputStream)localObject1).toByteArray();
      m = arrayOfByte.length;
      n = 0;
      break;
      label139:
      k = i;
      Object localObject3 = localObject1;
      try
      {
        localObject4 = new URL(parambcqb.a(j - 1) + "&filesize=" + arrayOfByte);
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
      i = a(arrayOfByte, localMalformedURLException, parambcqb, j);
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
      i = a(localMalformedURLException, localbcpw, parambcqb);
      k = i;
      break label79;
      label337:
      localbcpw.jdField_a_of_type_Int = 2;
      localbcpw.jdField_b_of_type_Int = k;
    }
  }
  
  public void a(ArrayList<TroopClipPic> paramArrayList, HashMap<String, String> paramHashMap, List<String> paramList, bcqd parambcqd)
  {
    this.jdField_a_of_type_Bcqd = parambcqd;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      parambcqd = (TroopClipPic)paramArrayList.next();
      new File(parambcqd.id);
      bcqb localbcqb = new bcqb();
      localbcqb.jdField_a_of_type_JavaUtilList = a(paramHashMap, paramList, parambcqd);
      localbcqb.jdField_a_of_type_JavaLangString = parambcqd.id;
      localbcqb.jdField_b_of_type_Int = parambcqd.type;
      localbcqb.jdField_a_of_type_Long = parambcqd.ts;
      localbcqb.jdField_b_of_type_JavaLangString = parambcqd.clipInfo;
      this.jdField_a_of_type_JavaUtilArrayList.add(localbcqb);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void run()
  {
    while ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      a((bcqb)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
    this.jdField_a_of_type_Bcqd = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUploadingThread
 * JD-Core Version:    0.7.0.1
 */