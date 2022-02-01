package com.tencent.qapmsdk.impl.c;

import com.tencent.qapmsdk.impl.instrumentation.g;
import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;

public abstract interface b
{
  public abstract void a(g paramg, IOException paramIOException);
  
  public abstract void a(Request paramRequest, g paramg);
  
  public abstract void a(Response paramResponse, g paramg);
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.c.b
 * JD-Core Version:    0.7.0.1
 */