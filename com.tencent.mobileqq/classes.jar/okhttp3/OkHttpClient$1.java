package okhttp3;

import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Internal;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;

class OkHttpClient$1
  extends Internal
{
  public void addLenient(Headers.Builder paramBuilder, String paramString)
  {
    paramBuilder.addLenient(paramString);
  }
  
  public void addLenient(Headers.Builder paramBuilder, String paramString1, String paramString2)
  {
    paramBuilder.addLenient(paramString1, paramString2);
  }
  
  public void apply(ConnectionSpec paramConnectionSpec, SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    paramConnectionSpec.apply(paramSSLSocket, paramBoolean);
  }
  
  public int code(Response.Builder paramBuilder)
  {
    return paramBuilder.code;
  }
  
  public boolean connectionBecameIdle(ConnectionPool paramConnectionPool, RealConnection paramRealConnection)
  {
    return paramConnectionPool.connectionBecameIdle(paramRealConnection);
  }
  
  public Socket deduplicate(ConnectionPool paramConnectionPool, Address paramAddress, StreamAllocation paramStreamAllocation)
  {
    return paramConnectionPool.deduplicate(paramAddress, paramStreamAllocation);
  }
  
  public boolean equalsNonHost(Address paramAddress1, Address paramAddress2)
  {
    return paramAddress1.equalsNonHost(paramAddress2);
  }
  
  public RealConnection get(ConnectionPool paramConnectionPool, Address paramAddress, StreamAllocation paramStreamAllocation, Route paramRoute)
  {
    return paramConnectionPool.get(paramAddress, paramStreamAllocation, paramRoute);
  }
  
  public boolean isInvalidHttpUrlHost(IllegalArgumentException paramIllegalArgumentException)
  {
    return paramIllegalArgumentException.getMessage().startsWith("Invalid URL host");
  }
  
  public Call newWebSocketCall(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    return RealCall.newRealCall(paramOkHttpClient, paramRequest, true);
  }
  
  public void put(ConnectionPool paramConnectionPool, RealConnection paramRealConnection)
  {
    paramConnectionPool.put(paramRealConnection);
  }
  
  public RouteDatabase routeDatabase(ConnectionPool paramConnectionPool)
  {
    return paramConnectionPool.routeDatabase;
  }
  
  public void setCache(OkHttpClient.Builder paramBuilder, InternalCache paramInternalCache)
  {
    paramBuilder.setInternalCache(paramInternalCache);
  }
  
  public StreamAllocation streamAllocation(Call paramCall)
  {
    return ((RealCall)paramCall).streamAllocation();
  }
  
  @Nullable
  public IOException timeoutExit(Call paramCall, @Nullable IOException paramIOException)
  {
    return ((RealCall)paramCall).timeoutExit(paramIOException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.OkHttpClient.1
 * JD-Core Version:    0.7.0.1
 */