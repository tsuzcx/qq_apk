package com.tencent.mobileqq.troop.utils;

import android.graphics.BitmapFactory.Options;
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
  protected UploadingTask a;
  protected ArrayList a;
  protected boolean a;
  
  public TroopUploadingThread()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          m = j;
        }
      }
    }
    label43:
    int k;
    label55:
    do
    {
      return m;
      j = paramOptions.outHeight;
      k = paramOptions.outWidth;
      if (j > paramInt2) {
        break;
      }
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      k /= 2;
      j /= 2;
      i *= 2;
      break label55;
      n = m;
    }
  }
  
  public int a(HttpURLConnection paramHttpURLConnection, TroopUploadingThread.UploadState paramUploadState, UploadItem paramUploadItem)
  {
    int k = -1;
    Object localObject1 = Integer.valueOf(-1);
    Object localObject3 = null;
    Object localObject2 = null;
    Map localMap = paramHttpURLConnection.getHeaderFields();
    try
    {
      j = paramHttpURLConnection.getResponseCode();
      Object localObject4 = localObject1;
      if (localMap != null)
      {
        Iterator localIterator = localMap.keySet().iterator();
        for (;;)
        {
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (!localIterator.hasNext()) {
            break label342;
          }
          localObject4 = (String)localIterator.next();
          if (localObject4 == null) {
            break label486;
          }
          localObject3 = localMap.get(localObject4);
          if ((localObject3 == null) || (!(localObject3 instanceof List))) {
            break label486;
          }
          if (!((String)localObject4).equals("Result")) {
            break;
          }
          localObject4 = ((List)localObject3).get(0);
          if ((localObject4 == null) || (!(localObject4 instanceof String))) {
            break label501;
          }
          localObject1 = Integer.valueOf(Integer.parseInt((String)((List)localObject3).get(0)));
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
    }
    catch (IOException localIOException)
    {
      label342:
      label473:
      label486:
      label501:
      for (;;)
      {
        localIOException.printStackTrace();
        int j = -1;
        continue;
        Object localObject5;
        if (localIOException.equals("NewSeq"))
        {
          localObject5 = ((List)localObject3).get(0);
          if ((localObject5 != null) && ((localObject5 instanceof String))) {
            paramUploadState.c = Integer.parseInt((String)((List)localObject3).get(0));
          }
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
        else
        {
          if (localObject5.equals("FileName"))
          {
            localObject5 = ((List)localObject3).get(0);
            if ((localObject5 != null) && ((localObject5 instanceof String)))
            {
              localObject3 = (String)((List)localObject3).get(0);
              localObject2 = localObject1;
              localObject1 = localObject3;
              continue;
              int i = localObject5.intValue();
              if (j != 200) {
                i = 102;
              }
              if ((i != 0) && (QLog.isColorLevel())) {
                QLog.d("TroopUploadingThread", 2, "result:" + i);
              }
              j = k;
              if (localObject3 != null)
              {
                j = k;
                if (((String)localObject3).contains("_"))
                {
                  localObject1 = ((String)localObject3).split("_");
                  if (localObject1.length != 2) {
                    break label473;
                  }
                }
              }
              for (;;)
              {
                try
                {
                  paramUploadState.b = Integer.parseInt(localObject1[1]);
                  j = i;
                  if (!paramUploadItem.jdField_a_of_type_Boolean) {
                    break;
                  }
                  return 104;
                }
                catch (NumberFormatException paramUploadState)
                {
                  paramUploadState.printStackTrace();
                  i = -1;
                  continue;
                }
                i = -1;
              }
              paramHttpURLConnection.disconnect();
              return j;
            }
          }
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
      }
    }
  }
  
  /* Error */
  public int a(byte[] paramArrayOfByte, HttpURLConnection paramHttpURLConnection, UploadItem paramUploadItem, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +19 -> 20
    //   4: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +11 -> 18
    //   10: ldc 117
    //   12: iconst_2
    //   13: ldc 160
    //   15: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: iconst_m1
    //   19: ireturn
    //   20: new 162	java/io/DataOutputStream
    //   23: dup
    //   24: aload_2
    //   25: invokevirtual 166	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   28: invokespecial 169	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
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
    //   47: if_icmpge +195 -> 242
    //   50: aload_3
    //   51: getfield 153	com/tencent/mobileqq/troop/utils/UploadItem:jdField_a_of_type_Boolean	Z
    //   54: ifeq +44 -> 98
    //   57: aload_0
    //   58: getfield 171	com/tencent/mobileqq/troop/utils/TroopUploadingThread:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   61: aload_3
    //   62: invokevirtual 176	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   65: pop
    //   66: aload 9
    //   68: invokevirtual 179	java/io/DataOutputStream:flush	()V
    //   71: bipush 104
    //   73: ireturn
    //   74: astore_1
    //   75: aload_1
    //   76: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   79: iconst_0
    //   80: ifeq -62 -> 18
    //   83: new 181	java/lang/NullPointerException
    //   86: dup
    //   87: invokespecial 182	java/lang/NullPointerException:<init>	()V
    //   90: athrow
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   96: iconst_m1
    //   97: ireturn
    //   98: iload 8
    //   100: iload 6
    //   102: isub
    //   103: sipush 10240
    //   106: if_icmple +89 -> 195
    //   109: sipush 10240
    //   112: istore 7
    //   114: aload 9
    //   116: aload_1
    //   117: iload 6
    //   119: iload 7
    //   121: invokevirtual 186	java/io/DataOutputStream:write	([BII)V
    //   124: iload 6
    //   126: iload 7
    //   128: iadd
    //   129: istore 6
    //   131: iload 6
    //   133: bipush 100
    //   135: imul
    //   136: iload 8
    //   138: idiv
    //   139: iload 5
    //   141: isub
    //   142: ifle +40 -> 182
    //   145: aload_3
    //   146: iload 5
    //   148: putfield 188	com/tencent/mobileqq/troop/utils/UploadItem:jdField_a_of_type_Int	I
    //   151: new 102	com/tencent/mobileqq/troop/utils/TroopUploadingThread$UploadState
    //   154: dup
    //   155: invokespecial 189	com/tencent/mobileqq/troop/utils/TroopUploadingThread$UploadState:<init>	()V
    //   158: astore 10
    //   160: aload 10
    //   162: iconst_0
    //   163: putfield 190	com/tencent/mobileqq/troop/utils/TroopUploadingThread$UploadState:jdField_a_of_type_Int	I
    //   166: aload 10
    //   168: iload 5
    //   170: putfield 150	com/tencent/mobileqq/troop/utils/TroopUploadingThread$UploadState:b	I
    //   173: aload_0
    //   174: getfield 192	com/tencent/mobileqq/troop/utils/TroopUploadingThread:jdField_a_of_type_ComTencentMobileqqTroopUtilsUploadingTask	Lcom/tencent/mobileqq/troop/utils/UploadingTask;
    //   177: aload 10
    //   179: invokevirtual 198	com/tencent/mobileqq/troop/utils/UploadingTask:notifyObservers	(Ljava/lang/Object;)V
    //   182: iload 6
    //   184: bipush 100
    //   186: imul
    //   187: iload 8
    //   189: idiv
    //   190: istore 5
    //   192: goto -149 -> 43
    //   195: iload 8
    //   197: iload 6
    //   199: isub
    //   200: istore 7
    //   202: goto -88 -> 114
    //   205: astore_1
    //   206: aload 9
    //   208: invokevirtual 179	java/io/DataOutputStream:flush	()V
    //   211: aload_1
    //   212: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   215: aload_2
    //   216: ifnull +7 -> 223
    //   219: aload_2
    //   220: invokevirtual 157	java/net/HttpURLConnection:disconnect	()V
    //   223: iload 4
    //   225: iconst_3
    //   226: if_icmpge +13 -> 239
    //   229: bipush 252
    //   231: ireturn
    //   232: astore_1
    //   233: aload_1
    //   234: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   237: iconst_m1
    //   238: ireturn
    //   239: bipush 103
    //   241: ireturn
    //   242: aload 9
    //   244: invokevirtual 179	java/io/DataOutputStream:flush	()V
    //   247: aload 9
    //   249: invokevirtual 201	java/io/DataOutputStream:close	()V
    //   252: iconst_0
    //   253: ireturn
    //   254: astore_1
    //   255: aload_1
    //   256: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   259: iconst_m1
    //   260: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	TroopUploadingThread
    //   0	261	1	paramArrayOfByte	byte[]
    //   0	261	2	paramHttpURLConnection	HttpURLConnection
    //   0	261	3	paramUploadItem	UploadItem
    //   0	261	4	paramInt	int
    //   38	153	5	i	int
    //   41	159	6	j	int
    //   112	89	7	k	int
    //   35	165	8	m	int
    //   31	217	9	localDataOutputStream	java.io.DataOutputStream
    //   158	20	10	localUploadState	TroopUploadingThread.UploadState
    // Exception table:
    //   from	to	target	type
    //   20	33	74	java/io/IOException
    //   83	91	91	java/io/IOException
    //   50	71	205	java/io/IOException
    //   114	124	205	java/io/IOException
    //   131	182	205	java/io/IOException
    //   182	192	205	java/io/IOException
    //   206	211	232	java/io/IOException
    //   242	252	254	java/io/IOException
  }
  
  /* Error */
  ByteArrayOutputStream a(String paramString)
  {
    // Byte code:
    //   0: new 18	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 207	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: getstatic 213	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   12: putfield 216	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   15: aload_2
    //   16: iconst_1
    //   17: putfield 219	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   20: aload_1
    //   21: aload_2
    //   22: invokestatic 225	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   25: pop
    //   26: aload_2
    //   27: aload_0
    //   28: aload_2
    //   29: sipush 1024
    //   32: sipush 1024
    //   35: invokespecial 227	com/tencent/mobileqq/troop/utils/TroopUploadingThread:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   38: putfield 230	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   41: aload_2
    //   42: iconst_0
    //   43: putfield 219	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   46: aload_1
    //   47: aload_2
    //   48: invokestatic 234	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   51: astore_2
    //   52: aload_2
    //   53: ifnonnull +5 -> 58
    //   56: aconst_null
    //   57: areturn
    //   58: new 236	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 239	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:<init>	(Ljava/lang/String;)V
    //   66: aload_2
    //   67: invokevirtual 242	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   70: astore_2
    //   71: aload_2
    //   72: ifnull +143 -> 215
    //   75: new 244	java/io/ByteArrayOutputStream
    //   78: dup
    //   79: invokespecial 245	java/io/ByteArrayOutputStream:<init>	()V
    //   82: astore_1
    //   83: aload_2
    //   84: getstatic 251	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   87: bipush 100
    //   89: aload_1
    //   90: invokevirtual 257	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   93: pop
    //   94: aload_1
    //   95: ifnull +7 -> 102
    //   98: aload_1
    //   99: invokevirtual 258	java/io/ByteArrayOutputStream:close	()V
    //   102: aload_2
    //   103: invokevirtual 261	android/graphics/Bitmap:isRecycled	()Z
    //   106: ifne +7 -> 113
    //   109: aload_2
    //   110: invokevirtual 264	android/graphics/Bitmap:recycle	()V
    //   113: aload_1
    //   114: areturn
    //   115: astore_3
    //   116: aload_3
    //   117: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   120: goto -18 -> 102
    //   123: astore_2
    //   124: aconst_null
    //   125: astore_1
    //   126: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +32 -> 161
    //   132: ldc 117
    //   134: iconst_2
    //   135: new 119	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 266
    //   145: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_2
    //   149: invokevirtual 267	java/lang/Exception:toString	()Ljava/lang/String;
    //   152: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: aload_1
    //   162: ifnull +53 -> 215
    //   165: aload_1
    //   166: invokevirtual 258	java/io/ByteArrayOutputStream:close	()V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_1
    //   172: aload_1
    //   173: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   176: aconst_null
    //   177: areturn
    //   178: astore_2
    //   179: aconst_null
    //   180: astore_1
    //   181: aload_1
    //   182: ifnull +7 -> 189
    //   185: aload_1
    //   186: invokevirtual 258	java/io/ByteArrayOutputStream:close	()V
    //   189: aload_2
    //   190: athrow
    //   191: astore_1
    //   192: aload_1
    //   193: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   196: goto -7 -> 189
    //   199: astore_2
    //   200: goto -19 -> 181
    //   203: astore_2
    //   204: goto -23 -> 181
    //   207: astore_2
    //   208: goto -82 -> 126
    //   211: astore_1
    //   212: aconst_null
    //   213: areturn
    //   214: astore_1
    //   215: aconst_null
    //   216: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	TroopUploadingThread
    //   0	217	1	paramString	String
    //   7	103	2	localObject1	Object
    //   123	26	2	localException1	java.lang.Exception
    //   178	12	2	localObject2	Object
    //   199	1	2	localObject3	Object
    //   203	1	2	localObject4	Object
    //   207	1	2	localException2	java.lang.Exception
    //   115	2	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   98	102	115	java/io/IOException
    //   75	83	123	java/lang/Exception
    //   165	169	171	java/io/IOException
    //   75	83	178	finally
    //   185	189	191	java/io/IOException
    //   83	94	199	finally
    //   126	161	203	finally
    //   83	94	207	java/lang/Exception
    //   0	52	211	java/lang/Exception
    //   58	71	211	java/lang/Exception
    //   0	52	214	java/lang/OutOfMemoryError
    //   58	71	214	java/lang/OutOfMemoryError
  }
  
  protected String a(HashMap paramHashMap, String paramString)
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
    return str;
  }
  
  /* Error */
  public HttpURLConnection a(URL paramURL, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +20 -> 21
    //   4: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 117
    //   12: iconst_2
    //   13: ldc_w 283
    //   16: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_1
    //   22: invokevirtual 289	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   25: checkcast 44	java/net/HttpURLConnection
    //   28: astore_1
    //   29: aload_1
    //   30: ifnonnull +15 -> 45
    //   33: aconst_null
    //   34: areturn
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   40: aconst_null
    //   41: astore_1
    //   42: goto -13 -> 29
    //   45: aload_1
    //   46: iconst_1
    //   47: invokevirtual 293	java/net/HttpURLConnection:setDoInput	(Z)V
    //   50: aload_1
    //   51: iconst_1
    //   52: invokevirtual 296	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   55: lload_2
    //   56: l2i
    //   57: istore 4
    //   59: aload_1
    //   60: iload 4
    //   62: invokevirtual 300	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   65: aload_1
    //   66: iconst_0
    //   67: invokevirtual 303	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   70: getstatic 309	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   73: ifnull +90 -> 163
    //   76: getstatic 312	android/os/Build$VERSION:SDK_INT	I
    //   79: bipush 13
    //   81: if_icmple +82 -> 163
    //   84: aload_1
    //   85: ldc_w 314
    //   88: ldc_w 315
    //   91: invokevirtual 319	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_1
    //   95: ldc_w 321
    //   98: invokevirtual 324	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   101: aload_1
    //   102: ldc_w 326
    //   105: ldc_w 328
    //   108: invokevirtual 319	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_1
    //   112: ldc_w 330
    //   115: new 119	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   122: ldc_w 332
    //   125: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc_w 334
    //   131: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokevirtual 319	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_1
    //   141: areturn
    //   142: astore_1
    //   143: aload_1
    //   144: invokevirtual 335	java/net/ProtocolException:printStackTrace	()V
    //   147: aconst_null
    //   148: areturn
    //   149: astore_1
    //   150: aload_1
    //   151: invokevirtual 336	java/lang/IllegalAccessError:printStackTrace	()V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_1
    //   157: aload_1
    //   158: invokevirtual 337	java/lang/Exception:printStackTrace	()V
    //   161: aconst_null
    //   162: areturn
    //   163: aload_1
    //   164: ldc_w 339
    //   167: ldc_w 341
    //   170: invokevirtual 319	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: goto -79 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	TroopUploadingThread
    //   0	176	1	paramURL	URL
    //   0	176	2	paramLong	long
    //   57	4	4	i	int
    // Exception table:
    //   from	to	target	type
    //   21	29	35	java/io/IOException
    //   70	94	142	java/net/ProtocolException
    //   94	140	142	java/net/ProtocolException
    //   163	173	142	java/net/ProtocolException
    //   45	55	149	java/lang/IllegalAccessError
    //   59	70	156	java/lang/Exception
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(UploadItem paramUploadItem)
  {
    Object localObject1 = a(paramUploadItem.jdField_a_of_type_JavaLangString);
    int j;
    byte[] arrayOfByte;
    int k;
    TroopUploadingThread.UploadState localUploadState;
    int m;
    int i;
    if (localObject1 == null)
    {
      j = -1;
      arrayOfByte = null;
      k = 1;
      localUploadState = new TroopUploadingThread.UploadState();
      m = 0;
      i = -1;
      localObject1 = null;
      label40:
      if (m >= 3) {
        break label247;
      }
      if (k == 0) {
        break label106;
      }
      i = 101;
    }
    label54:
    label106:
    label244:
    label247:
    for (;;)
    {
      if (i == 0) {
        localUploadState.jdField_a_of_type_Int = 1;
      }
      for (;;)
      {
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(paramUploadItem);
          if (i != 104) {
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsUploadingTask.notifyObservers(localUploadState);
          }
          return;
          arrayOfByte = ((ByteArrayOutputStream)localObject1).toByteArray();
          j = arrayOfByte.length;
          k = 0;
          break;
          try
          {
            Object localObject2 = new URL(paramUploadItem.b + "&filesize=" + arrayOfByte);
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
            i = a(arrayOfByte, localMalformedURLException, paramUploadItem, m);
            if (i == -4)
            {
              m += 1;
              break label40;
            }
            if (i == -1) {
              break label244;
            }
          }
        }
        if (i == 104) {
          break label54;
        }
        i = a(localMalformedURLException, localUploadState, paramUploadItem);
        break label54;
        localUploadState.jdField_a_of_type_Int = 2;
        localUploadState.b = i;
      }
    }
  }
  
  public void a(ArrayList paramArrayList, HashMap paramHashMap, String paramString, UploadingTask paramUploadingTask)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsUploadingTask = paramUploadingTask;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      paramUploadingTask = (String)paramArrayList.next();
      new File(paramUploadingTask);
      UploadItem localUploadItem = new UploadItem();
      localUploadItem.b = a(paramHashMap, paramString);
      localUploadItem.jdField_a_of_type_JavaLangString = paramUploadingTask;
      this.jdField_a_of_type_JavaUtilArrayList.add(localUploadItem);
    }
  }
  
  public void run()
  {
    while ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      a((UploadItem)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsUploadingTask = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUploadingThread
 * JD-Core Version:    0.7.0.1
 */