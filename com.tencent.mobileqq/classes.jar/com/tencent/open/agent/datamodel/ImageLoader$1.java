package com.tencent.open.agent.datamodel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.img.ImageDownCallback;

class ImageLoader$1
  implements ImageDownCallback
{
  ImageLoader$1(ImageLoader paramImageLoader, ImageLoader.ImageLoadListener paramImageLoadListener, String paramString) {}
  
  public void a(String paramString1, String arg2, String paramString3)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString3);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->imgDownloaded path = ");
      localStringBuilder.append(???);
      localStringBuilder.append(" localUrl = ");
      localStringBuilder.append(paramString3);
      LogUtility.c("ImageLoader", localStringBuilder.toString());
      localBitmap = BaseImageUtil.a(CommonDataAdapter.a().a(), localBitmap, 50, 50);
      synchronized (ImageLoader.jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_ComTencentOpenAgentDatamodelImageLoader.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString1, localBitmap);
        this.jdField_a_of_type_ComTencentOpenAgentDatamodelImageLoader$ImageLoadListener.a(this.jdField_a_of_type_JavaLangString, localBitmap, paramString3);
        return;
      }
      return;
    }
    catch (OutOfMemoryError paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  /* Error */
  public void b(String paramString1, String arg2, String paramString3)
  {
    // Byte code:
    //   0: new 33	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: ldc 96
    //   13: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 4
    //   19: aload_2
    //   20: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 4
    //   26: ldc 42
    //   28: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 4
    //   34: aload_3
    //   35: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc 44
    //   41: aload 4
    //   43: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 54	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: invokestatic 101	com/tencent/open/appcommon/Common:a	()Z
    //   52: ifne +292 -> 344
    //   55: aconst_null
    //   56: astore 6
    //   58: aconst_null
    //   59: astore_2
    //   60: aconst_null
    //   61: astore 7
    //   63: new 103	java/net/URL
    //   66: dup
    //   67: aload_0
    //   68: getfield 18	com/tencent/open/agent/datamodel/ImageLoader$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   71: invokespecial 106	java/net/URL:<init>	(Ljava/lang/String;)V
    //   74: invokevirtual 110	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   77: checkcast 112	java/net/HttpURLConnection
    //   80: astore 4
    //   82: aload 4
    //   84: sipush 5000
    //   87: invokevirtual 116	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   90: aload 4
    //   92: ldc 118
    //   94: invokevirtual 121	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   97: aload 4
    //   99: invokevirtual 125	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   102: astore 4
    //   104: aload 4
    //   106: astore_2
    //   107: aload 4
    //   109: invokestatic 129	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   112: astore 5
    //   114: aload 5
    //   116: astore_2
    //   117: aload 4
    //   119: ifnull +108 -> 227
    //   122: aload 5
    //   124: astore_2
    //   125: aload 4
    //   127: invokevirtual 134	java/io/InputStream:close	()V
    //   130: aload 5
    //   132: astore_2
    //   133: goto +94 -> 227
    //   136: astore 4
    //   138: aload 4
    //   140: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   143: goto +84 -> 227
    //   146: astore 5
    //   148: goto +17 -> 165
    //   151: astore 5
    //   153: goto +47 -> 200
    //   156: astore_1
    //   157: goto +169 -> 326
    //   160: astore 5
    //   162: aconst_null
    //   163: astore 4
    //   165: aload 4
    //   167: astore_2
    //   168: aload 5
    //   170: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   173: aload 6
    //   175: astore_2
    //   176: aload 4
    //   178: ifnull +49 -> 227
    //   181: aload 7
    //   183: astore_2
    //   184: aload 4
    //   186: invokevirtual 134	java/io/InputStream:close	()V
    //   189: aload 6
    //   191: astore_2
    //   192: goto +35 -> 227
    //   195: astore 5
    //   197: aconst_null
    //   198: astore 4
    //   200: aload 4
    //   202: astore_2
    //   203: aload 5
    //   205: invokevirtual 136	java/net/MalformedURLException:printStackTrace	()V
    //   208: aload 6
    //   210: astore_2
    //   211: aload 4
    //   213: ifnull +14 -> 227
    //   216: aload 7
    //   218: astore_2
    //   219: aload 4
    //   221: invokevirtual 134	java/io/InputStream:close	()V
    //   224: aload 6
    //   226: astore_2
    //   227: new 33	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   234: astore 4
    //   236: aload 4
    //   238: ldc 138
    //   240: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 4
    //   246: aload_2
    //   247: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: ldc 44
    //   253: aload 4
    //   255: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 54	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload_2
    //   262: ifnull +82 -> 344
    //   265: invokestatic 59	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   268: invokevirtual 62	com/tencent/open/adapter/CommonDataAdapter:a	()Landroid/content/Context;
    //   271: aload_2
    //   272: bipush 50
    //   274: bipush 50
    //   276: invokestatic 67	com/tencent/mobileqq/utils/BaseImageUtil:a	(Landroid/content/Context;Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   279: astore 4
    //   281: getstatic 72	com/tencent/open/agent/datamodel/ImageLoader:jdField_a_of_type_ArrayOfByte	[B
    //   284: astore_2
    //   285: aload_2
    //   286: monitorenter
    //   287: aload_0
    //   288: getfield 14	com/tencent/open/agent/datamodel/ImageLoader$1:jdField_a_of_type_ComTencentOpenAgentDatamodelImageLoader	Lcom/tencent/open/agent/datamodel/ImageLoader;
    //   291: getfield 75	com/tencent/open/agent/datamodel/ImageLoader:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   294: aload_1
    //   295: aload 4
    //   297: invokevirtual 81	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   300: pop
    //   301: aload_2
    //   302: monitorexit
    //   303: aload_0
    //   304: getfield 16	com/tencent/open/agent/datamodel/ImageLoader$1:jdField_a_of_type_ComTencentOpenAgentDatamodelImageLoader$ImageLoadListener	Lcom/tencent/open/agent/datamodel/ImageLoader$ImageLoadListener;
    //   307: aload_0
    //   308: getfield 18	com/tencent/open/agent/datamodel/ImageLoader$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   311: aload 4
    //   313: aload_3
    //   314: invokeinterface 86 4 0
    //   319: return
    //   320: astore_1
    //   321: aload_2
    //   322: monitorexit
    //   323: aload_1
    //   324: athrow
    //   325: astore_1
    //   326: aload_2
    //   327: ifnull +15 -> 342
    //   330: aload_2
    //   331: invokevirtual 134	java/io/InputStream:close	()V
    //   334: goto +8 -> 342
    //   337: astore_2
    //   338: aload_2
    //   339: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   342: aload_1
    //   343: athrow
    //   344: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	1
    //   0	345	1	paramString1	String
    //   0	345	3	paramString3	String
    //   7	119	4	localObject1	Object
    //   136	3	4	localIOException1	java.io.IOException
    //   163	149	4	localObject2	Object
    //   112	19	5	localBitmap	Bitmap
    //   146	1	5	localIOException2	java.io.IOException
    //   151	1	5	localMalformedURLException1	java.net.MalformedURLException
    //   160	9	5	localIOException3	java.io.IOException
    //   195	9	5	localMalformedURLException2	java.net.MalformedURLException
    //   56	169	6	localObject3	Object
    //   61	156	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   125	130	136	java/io/IOException
    //   184	189	136	java/io/IOException
    //   219	224	136	java/io/IOException
    //   107	114	146	java/io/IOException
    //   107	114	151	java/net/MalformedURLException
    //   63	104	156	finally
    //   63	104	160	java/io/IOException
    //   63	104	195	java/net/MalformedURLException
    //   287	303	320	finally
    //   321	323	320	finally
    //   107	114	325	finally
    //   168	173	325	finally
    //   203	208	325	finally
    //   330	334	337	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.datamodel.ImageLoader.1
 * JD-Core Version:    0.7.0.1
 */