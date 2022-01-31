package com.tencent.tmassistantbase.network;

import org.apache.http.client.methods.HttpPost;

public abstract class PostHttpRequest
{
  static final String REQUEST_SERVER_URL = "http://masdk.3g.qq.com/";
  static final String TAG = "BaseHttpRequest";
  HttpPost mHttpPost = null;
  
  /* Error */
  public void cancleRequest()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/tencent/tmassistantbase/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   6: ifnull +54 -> 60
    //   9: aload_0
    //   10: getfield 19	com/tencent/tmassistantbase/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   13: invokevirtual 29	org/apache/http/client/methods/HttpPost:isAborted	()Z
    //   16: ifne +44 -> 60
    //   19: ldc 11
    //   21: new 31	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   28: ldc 34
    //   30: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: ldc 43
    //   39: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 53	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload_0
    //   49: getfield 19	com/tencent/tmassistantbase/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   52: invokevirtual 56	org/apache/http/client/methods/HttpPost:abort	()V
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 19	com/tencent/tmassistantbase/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_1
    //   64: aload_1
    //   65: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   68: aload_0
    //   69: aconst_null
    //   70: putfield 19	com/tencent/tmassistantbase/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   73: goto -13 -> 60
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    //   81: astore_1
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 19	com/tencent/tmassistantbase/network/PostHttpRequest:mHttpPost	Lorg/apache/http/client/methods/HttpPost;
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	PostHttpRequest
    //   63	2	1	localException	java.lang.Exception
    //   76	4	1	localObject1	Object
    //   81	7	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   48	55	63	java/lang/Exception
    //   2	48	76	finally
    //   55	60	76	finally
    //   68	73	76	finally
    //   82	89	76	finally
    //   48	55	81	finally
    //   64	68	81	finally
  }
  
  protected abstract void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt);
  
  protected boolean sendRequest(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return bool;
      try
      {
        if (this.mHttpPost != null) {
          continue;
        }
        new Thread(new c(this, paramArrayOfByte)).start();
        bool = true;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.network.PostHttpRequest
 * JD-Core Version:    0.7.0.1
 */