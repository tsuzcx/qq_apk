package com.tencent.mobileqq.jsp;

import java.util.concurrent.atomic.AtomicBoolean;

class MediaApiPlugin$3
  implements Runnable
{
  MediaApiPlugin$3(MediaApiPlugin paramMediaApiPlugin, String paramString1, String paramString2, AtomicBoolean paramAtomicBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 37	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 38	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: invokestatic 44	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: astore_2
    //   12: aload_0
    //   13: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$3:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokestatic 49	bdhb:a	(Ljava/lang/String;)[B
    //   19: astore_3
    //   20: aload_0
    //   21: getfield 16	com/tencent/mobileqq/jsp/MediaApiPlugin$3:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   24: aload_3
    //   25: invokevirtual 54	com/tencent/mobileqq/jsp/MediaApiPlugin:a	([B)Ljava/lang/String;
    //   28: astore_3
    //   29: aload_1
    //   30: ldc 56
    //   32: iconst_0
    //   33: invokevirtual 60	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   36: pop
    //   37: aload_1
    //   38: ldc 62
    //   40: aload_2
    //   41: ldc 63
    //   43: invokevirtual 69	android/content/Context:getString	(I)Ljava/lang/String;
    //   46: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   49: pop
    //   50: aload_1
    //   51: ldc 74
    //   53: aload_3
    //   54: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   57: pop
    //   58: aload_0
    //   59: getfield 20	com/tencent/mobileqq/jsp/MediaApiPlugin$3:b	Ljava/lang/String;
    //   62: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   65: ifne +129 -> 194
    //   68: aload_0
    //   69: getfield 22	com/tencent/mobileqq/jsp/MediaApiPlugin$3:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   72: iconst_0
    //   73: iconst_1
    //   74: invokevirtual 86	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   77: ifeq +117 -> 194
    //   80: aload_0
    //   81: getfield 16	com/tencent/mobileqq/jsp/MediaApiPlugin$3:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   84: aload_0
    //   85: getfield 20	com/tencent/mobileqq/jsp/MediaApiPlugin$3:b	Ljava/lang/String;
    //   88: iconst_1
    //   89: anewarray 88	java/lang/String
    //   92: dup
    //   93: iconst_0
    //   94: aload_1
    //   95: invokevirtual 92	org/json/JSONObject:toString	()Ljava/lang/String;
    //   98: aastore
    //   99: invokevirtual 96	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   102: return
    //   103: astore_3
    //   104: aload_1
    //   105: ldc 56
    //   107: iconst_1
    //   108: invokevirtual 60	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   111: pop
    //   112: aload_1
    //   113: ldc 62
    //   115: aload_2
    //   116: ldc 97
    //   118: invokevirtual 69	android/content/Context:getString	(I)Ljava/lang/String;
    //   121: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   124: pop
    //   125: goto -67 -> 58
    //   128: astore_2
    //   129: goto -71 -> 58
    //   132: astore_3
    //   133: aload_1
    //   134: ldc 56
    //   136: iconst_2
    //   137: invokevirtual 60	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   140: pop
    //   141: aload_1
    //   142: ldc 62
    //   144: aload_2
    //   145: ldc 98
    //   147: invokevirtual 69	android/content/Context:getString	(I)Ljava/lang/String;
    //   150: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   153: pop
    //   154: goto -96 -> 58
    //   157: astore_2
    //   158: goto -100 -> 58
    //   161: astore_2
    //   162: getstatic 99	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   165: iconst_2
    //   166: new 101	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   173: ldc 104
    //   175: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_2
    //   179: invokestatic 114	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   182: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: goto -133 -> 58
    //   194: aload_0
    //   195: getfield 16	com/tencent/mobileqq/jsp/MediaApiPlugin$3:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   198: ldc 121
    //   200: iconst_0
    //   201: aload_1
    //   202: invokevirtual 92	org/json/JSONObject:toString	()Ljava/lang/String;
    //   205: invokevirtual 124	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: return
    //   209: astore_2
    //   210: goto -152 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	3
    //   7	195	1	localJSONObject	org.json.JSONObject
    //   11	105	2	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    //   128	17	2	localJSONException1	org.json.JSONException
    //   157	1	2	localJSONException2	org.json.JSONException
    //   161	18	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   209	1	2	localJSONException3	org.json.JSONException
    //   19	35	3	localObject	Object
    //   103	1	3	localIOException	java.io.IOException
    //   132	1	3	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   12	29	103	java/io/IOException
    //   29	58	103	java/io/IOException
    //   104	125	128	org/json/JSONException
    //   12	29	132	java/lang/IllegalArgumentException
    //   29	58	132	java/lang/IllegalArgumentException
    //   133	154	157	org/json/JSONException
    //   12	29	161	java/lang/OutOfMemoryError
    //   29	58	161	java/lang/OutOfMemoryError
    //   29	58	209	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin.3
 * JD-Core Version:    0.7.0.1
 */