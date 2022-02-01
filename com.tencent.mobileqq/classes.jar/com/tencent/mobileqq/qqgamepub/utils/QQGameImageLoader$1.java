package com.tencent.mobileqq.qqgamepub.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.open.base.img.ImageDownCallback;
import com.tencent.qphone.base.util.QLog;

class QQGameImageLoader$1
  implements ImageDownCallback
{
  QQGameImageLoader$1(QQGameImageLoader paramQQGameImageLoader, int paramInt1, int paramInt2, QQGameImageLoader.ImageLoadListener paramImageLoadListener, String paramString) {}
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      Bitmap localBitmap = QQGameImageLoader.a(paramString3, this.a, this.b);
      if (localBitmap != null) {
        synchronized (QQGameImageLoader.b)
        {
          this.e.c.put(paramString1, localBitmap);
        }
      }
      if (this.c != null) {
        this.c.a(this.d, localBitmap, paramString3);
      }
      paramString1 = new StringBuilder();
      paramString1.append("-->imgDownloaded path = ");
      paramString1.append(paramString2);
      paramString1.append(" localUrl = ");
      paramString1.append(paramString3);
      paramString1.append(",bitmap:");
      paramString1.append(localBitmap);
      QLog.d("QQGameImageLoader", 1, paramString1.toString());
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("QQGameImageLoader", 1, paramString1, new Object[0]);
    }
  }
  
  /* Error */
  public void b(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 95	com/tencent/open/appcommon/Common:d	()Z
    //   3: ifne +352 -> 355
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore 8
    //   15: new 97	java/net/URL
    //   18: dup
    //   19: aload_0
    //   20: getfield 27	com/tencent/mobileqq/qqgamepub/utils/QQGameImageLoader$1:d	Ljava/lang/String;
    //   23: invokespecial 100	java/net/URL:<init>	(Ljava/lang/String;)V
    //   26: invokevirtual 104	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   29: checkcast 106	java/net/HttpURLConnection
    //   32: astore 5
    //   34: aload 5
    //   36: sipush 5000
    //   39: invokevirtual 110	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   42: aload 5
    //   44: ldc 112
    //   46: invokevirtual 115	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   49: aload 5
    //   51: invokevirtual 119	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   54: astore 5
    //   56: aload 5
    //   58: astore 4
    //   60: aload_3
    //   61: aload_0
    //   62: getfield 21	com/tencent/mobileqq/qqgamepub/utils/QQGameImageLoader$1:a	I
    //   65: aload_0
    //   66: getfield 23	com/tencent/mobileqq/qqgamepub/utils/QQGameImageLoader$1:b	I
    //   69: invokestatic 39	com/tencent/mobileqq/qqgamepub/utils/QQGameImageLoader:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   72: astore 6
    //   74: aload 6
    //   76: astore 4
    //   78: aload 5
    //   80: ifnull +118 -> 198
    //   83: aload 6
    //   85: astore 4
    //   87: aload 5
    //   89: invokevirtual 124	java/io/InputStream:close	()V
    //   92: aload 6
    //   94: astore 4
    //   96: goto +102 -> 198
    //   99: astore 5
    //   101: aload 5
    //   103: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   106: goto +92 -> 198
    //   109: astore 6
    //   111: goto +17 -> 128
    //   114: astore 6
    //   116: goto +51 -> 167
    //   119: astore_1
    //   120: goto +215 -> 335
    //   123: astore 6
    //   125: aconst_null
    //   126: astore 5
    //   128: aload 5
    //   130: astore 4
    //   132: aload 6
    //   134: invokevirtual 128	java/lang/Throwable:printStackTrace	()V
    //   137: aload 7
    //   139: astore 4
    //   141: aload 5
    //   143: ifnull +55 -> 198
    //   146: aload 8
    //   148: astore 4
    //   150: aload 5
    //   152: invokevirtual 124	java/io/InputStream:close	()V
    //   155: aload 7
    //   157: astore 4
    //   159: goto +39 -> 198
    //   162: astore 6
    //   164: aconst_null
    //   165: astore 5
    //   167: aload 5
    //   169: astore 4
    //   171: aload 6
    //   173: invokevirtual 129	java/net/MalformedURLException:printStackTrace	()V
    //   176: aload 7
    //   178: astore 4
    //   180: aload 5
    //   182: ifnull +16 -> 198
    //   185: aload 8
    //   187: astore 4
    //   189: aload 5
    //   191: invokevirtual 124	java/io/InputStream:close	()V
    //   194: aload 7
    //   196: astore 4
    //   198: aload 4
    //   200: ifnull +37 -> 237
    //   203: getstatic 42	com/tencent/mobileqq/qqgamepub/utils/QQGameImageLoader:b	[B
    //   206: astore 5
    //   208: aload 5
    //   210: monitorenter
    //   211: aload_0
    //   212: getfield 19	com/tencent/mobileqq/qqgamepub/utils/QQGameImageLoader$1:e	Lcom/tencent/mobileqq/qqgamepub/utils/QQGameImageLoader;
    //   215: getfield 45	com/tencent/mobileqq/qqgamepub/utils/QQGameImageLoader:c	Landroid/support/v4/util/LruCache;
    //   218: aload_1
    //   219: aload 4
    //   221: invokevirtual 51	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   224: pop
    //   225: aload 5
    //   227: monitorexit
    //   228: goto +9 -> 237
    //   231: astore_1
    //   232: aload 5
    //   234: monitorexit
    //   235: aload_1
    //   236: athrow
    //   237: aload_0
    //   238: getfield 25	com/tencent/mobileqq/qqgamepub/utils/QQGameImageLoader$1:c	Lcom/tencent/mobileqq/qqgamepub/utils/QQGameImageLoader$ImageLoadListener;
    //   241: ifnull +34 -> 275
    //   244: aload_0
    //   245: getfield 25	com/tencent/mobileqq/qqgamepub/utils/QQGameImageLoader$1:c	Lcom/tencent/mobileqq/qqgamepub/utils/QQGameImageLoader$ImageLoadListener;
    //   248: aload_0
    //   249: getfield 27	com/tencent/mobileqq/qqgamepub/utils/QQGameImageLoader$1:d	Ljava/lang/String;
    //   252: aload 4
    //   254: aload_3
    //   255: invokeinterface 56 4 0
    //   260: goto +15 -> 275
    //   263: astore_1
    //   264: ldc 74
    //   266: iconst_1
    //   267: aload_1
    //   268: iconst_0
    //   269: anewarray 4	java/lang/Object
    //   272: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   275: new 58	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   282: astore_1
    //   283: aload_1
    //   284: ldc 131
    //   286: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload_1
    //   291: aload_2
    //   292: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_1
    //   297: ldc 67
    //   299: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload_1
    //   304: aload_3
    //   305: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload_1
    //   310: ldc 69
    //   312: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_1
    //   317: aload 4
    //   319: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: ldc 74
    //   325: iconst_1
    //   326: aload_1
    //   327: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: return
    //   334: astore_1
    //   335: aload 4
    //   337: ifnull +16 -> 353
    //   340: aload 4
    //   342: invokevirtual 124	java/io/InputStream:close	()V
    //   345: goto +8 -> 353
    //   348: astore_2
    //   349: aload_2
    //   350: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   353: aload_1
    //   354: athrow
    //   355: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	this	1
    //   0	356	1	paramString1	String
    //   0	356	2	paramString2	String
    //   0	356	3	paramString3	String
    //   10	331	4	localObject1	Object
    //   32	56	5	localObject2	Object
    //   99	3	5	localIOException	java.io.IOException
    //   72	21	6	localBitmap	Bitmap
    //   109	1	6	localThrowable1	Throwable
    //   114	1	6	localMalformedURLException1	java.net.MalformedURLException
    //   123	10	6	localThrowable2	Throwable
    //   162	10	6	localMalformedURLException2	java.net.MalformedURLException
    //   7	188	7	localObject3	Object
    //   13	173	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   87	92	99	java/io/IOException
    //   150	155	99	java/io/IOException
    //   189	194	99	java/io/IOException
    //   60	74	109	java/lang/Throwable
    //   60	74	114	java/net/MalformedURLException
    //   15	56	119	finally
    //   15	56	123	java/lang/Throwable
    //   15	56	162	java/net/MalformedURLException
    //   211	228	231	finally
    //   232	235	231	finally
    //   203	211	263	java/lang/Throwable
    //   235	237	263	java/lang/Throwable
    //   237	260	263	java/lang/Throwable
    //   60	74	334	finally
    //   132	137	334	finally
    //   171	176	334	finally
    //   340	345	348	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.utils.QQGameImageLoader.1
 * JD-Core Version:    0.7.0.1
 */