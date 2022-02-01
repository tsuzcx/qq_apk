package com.tencent.tgpa.vendorpd.a;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;

class j$2
  implements Callback
{
  j$2(j paramj) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    m.b("onFailure: report data failed. ");
    paramIOException.printStackTrace();
  }
  
  /* Error */
  public void onResponse(Call paramCall, okhttp3.Response paramResponse)
  {
    // Byte code:
    //   0: new 37	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   7: ldc 40
    //   9: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: aload_2
    //   13: invokevirtual 50	okhttp3/Response:code	()I
    //   16: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 26	com/tencent/tgpa/vendorpd/a/m:b	(Ljava/lang/String;)V
    //   25: aload_2
    //   26: invokevirtual 61	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   29: invokevirtual 66	okhttp3/ResponseBody:close	()V
    //   32: return
    //   33: astore_1
    //   34: aload_2
    //   35: invokevirtual 61	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   38: invokevirtual 66	okhttp3/ResponseBody:close	()V
    //   41: return
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 61	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   47: invokevirtual 66	okhttp3/ResponseBody:close	()V
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	2
    //   0	52	1	paramCall	Call
    //   0	52	2	paramResponse	okhttp3.Response
    // Exception table:
    //   from	to	target	type
    //   0	25	33	java/lang/Exception
    //   0	25	42	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.j.2
 * JD-Core Version:    0.7.0.1
 */