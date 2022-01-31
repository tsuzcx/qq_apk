package com.tencent.plato.mqq.module;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Base64;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;
import com.tencent.plato.ExportedModule;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.JSONWritableArray;
import com.tencent.plato.JSONWritableMap;
import com.tencent.plato.annotation.Exported;
import com.tencent.plato.core.IFunction;
import com.tencent.plato.core.IReadableArray;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.IWritableMap;
import com.tencent.plato.core.utils.Ev;
import com.tencent.plato.mqq.network.RequestBodyUtil;
import com.tencent.plato.network.PlatoCookieHandler;
import com.tencent.plato.network.RequestException;
import com.tencent.plato.utils.FuncUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class NetworkingModule
  extends ExportedModule
{
  private static final int CHUNK_TIMEOUT_NS = 100000000;
  private static final String CONTENT_ENCODING_HEADER_NAME = "content-encoding";
  private static final String CONTENT_TYPE_HEADER_NAME = "content-type";
  private static final String REQUEST_BODY_KEY_BASE64 = "base64";
  private static final String REQUEST_BODY_KEY_FORM_DATA = "formData";
  private static final String REQUEST_BODY_KEY_STRING = "string";
  private static final String REQUEST_BODY_KEY_URI = "uri";
  private static final String USER_AGENT_HEADER_NAME = "user-agent";
  private final OkHttpClient mClient = new OkHttpClient();
  private final PlatoCookieHandler mCookieHandler = new PlatoCookieHandler(Ev.appContext());
  @Nullable
  private final String mDefaultUserAgent;
  private final Map mRequests = new HashMap();
  private boolean mShuttingDown;
  
  public NetworkingModule()
  {
    super("Networking");
    this.mClient.setConnectTimeout(30000L, TimeUnit.MILLISECONDS);
    this.mClient.setWriteTimeout(30000L, TimeUnit.MILLISECONDS);
    this.mClient.setCookieHandler(this.mCookieHandler);
    this.mDefaultUserAgent = null;
  }
  
  private void addRequest(int paramInt, Call paramCall)
  {
    try
    {
      this.mRequests.put(Integer.valueOf(paramInt), paramCall);
      return;
    }
    finally
    {
      paramCall = finally;
      throw paramCall;
    }
  }
  
  private RequestBody buildBase64RequestBody(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      throw new RequestException("Payload is set but no content-type header specified");
    }
    return RequestBody.create(MediaType.parse(paramString2), ByteString.decodeBase64(paramString1));
  }
  
  private RequestBody buildFormDataRequestBody(Context paramContext, IReadableArray paramIReadableArray, String paramString, IFunction paramIFunction)
  {
    String str = paramString;
    if (paramString == null) {
      str = "multipart/form-data";
    }
    return RequestBodyUtil.createProgressRequest(constructMultipartBody(paramContext, paramIReadableArray, str).build(), new NetworkingModule.4(this, paramIFunction));
  }
  
  private RequestBody buildRequestBody(String paramString1, String paramString2, String paramString3)
  {
    if (paramString2 == null) {
      throw new RequestException("Payload is set but no content-type header specified");
    }
    paramString2 = MediaType.parse(paramString2);
    if ("gzip".equalsIgnoreCase(paramString3))
    {
      paramString2 = RequestBodyUtil.createGzip(paramString2, paramString1);
      paramString1 = paramString2;
      if (paramString2 == null) {
        throw new RequestException("Failed to gzip request body");
      }
    }
    else
    {
      paramString1 = RequestBody.create(paramString2, paramString1);
    }
    return paramString1;
  }
  
  private RequestBody buildUriRequestBody(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      throw new RequestException("Payload is set but no content-type header specified");
    }
    paramContext = RequestBodyUtil.getFileInputStream(paramContext, paramString1);
    if (paramContext == null) {
      throw new RequestException("Could not retrieve file for uri " + paramString1);
    }
    return RequestBodyUtil.create(MediaType.parse(paramString2), paramContext);
  }
  
  private void cancelAllRequests()
  {
    try
    {
      Iterator localIterator = this.mRequests.keySet().iterator();
      while (localIterator.hasNext()) {
        cancelRequest(localIterator.next());
      }
      this.mRequests.clear();
    }
    finally {}
  }
  
  private void cancelRequest(Object paramObject)
  {
    paramObject = (Call)this.mRequests.get(paramObject);
    if ((paramObject != null) && (!paramObject.isCanceled())) {
      AsyncTask.THREAD_POOL_EXECUTOR.execute(new NetworkingModule.5(this, paramObject));
    }
  }
  
  private MultipartBuilder constructMultipartBody(Context paramContext, IReadableArray paramIReadableArray, String paramString)
  {
    MultipartBuilder localMultipartBuilder = new MultipartBuilder();
    localMultipartBuilder.type(MediaType.parse(paramString));
    int j = paramIReadableArray.length();
    int i = 0;
    Object localObject;
    Headers localHeaders;
    while (i < j)
    {
      localObject = paramIReadableArray.getReadableMap(i);
      if (localObject == null)
      {
        i += 1;
      }
      else
      {
        localHeaders = extractHeaders(((IReadableMap)localObject).getReadableMap("headers"), false);
        paramString = localHeaders.get("content-type");
        if (paramString == null) {
          break label267;
        }
        paramString = MediaType.parse(paramString);
        localHeaders = localHeaders.newBuilder().removeAll("content-type").build();
      }
    }
    for (;;)
    {
      if (((IReadableMap)localObject).has("string"))
      {
        localObject = ((IReadableMap)localObject).getString("string", null);
        if (localObject == null) {
          break;
        }
        localMultipartBuilder.addPart(localHeaders, RequestBody.create(paramString, (String)localObject));
        break;
      }
      if (((IReadableMap)localObject).has("uri"))
      {
        if (paramString == null) {
          throw new RequestException("Binary FormData part needs a content-type header.");
        }
        localObject = ((IReadableMap)localObject).getString("uri", null);
        InputStream localInputStream = RequestBodyUtil.getFileInputStream(paramContext, (String)localObject);
        if (localInputStream == null) {
          throw new RequestException("Could not retrieve file for uri " + (String)localObject);
        }
        localMultipartBuilder.addPart(localHeaders, RequestBodyUtil.create(paramString, localInputStream));
        break;
      }
      throw new RequestException("Unrecognized FormData part.");
      return localMultipartBuilder;
      label267:
      paramString = null;
    }
  }
  
  private Headers extractHeaders(@Nullable IReadableMap paramIReadableMap, boolean paramBoolean)
  {
    Headers.Builder localBuilder = new Headers.Builder();
    if (paramIReadableMap != null)
    {
      Iterator localIterator = paramIReadableMap.names().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localBuilder.add(str, paramIReadableMap.getString(str, ""));
      }
    }
    if ((localBuilder.get("user-agent") == null) && (this.mDefaultUserAgent != null)) {
      localBuilder.add("user-agent", this.mDefaultUserAgent);
    }
    if (!paramBoolean) {
      localBuilder.removeAll("content-encoding");
    }
    return localBuilder.build();
  }
  
  private Object getResponseContent(String paramString, ResponseBody paramResponseBody)
  {
    if (paramString == null) {
      throw new IOException("unknown responseType:null");
    }
    if (paramString.contains("application/json"))
    {
      paramString = paramResponseBody.string().trim();
      if ((paramString.startsWith("[")) && (paramString.endsWith("]"))) {
        return new JSONWritableArray(new JSONArray(paramString));
      }
      if ((paramString.startsWith("{")) && (paramString.endsWith("}"))) {
        return new JSONWritableMap(new JSONObject(paramString));
      }
      throw new JSONException("JsonError:" + paramString);
    }
    if ((paramString.contains("text/html")) || ("text".equalsIgnoreCase(paramString))) {
      return paramResponseBody.string();
    }
    if ("base64".equalsIgnoreCase(paramString)) {
      return Base64.encodeToString(paramResponseBody.bytes(), 2);
    }
    throw new IOException("unknown responseType:" + paramString);
  }
  
  private void removeRequest(int paramInt)
  {
    try
    {
      this.mRequests.remove(Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void sendRequest(IPlatoRuntime paramIPlatoRuntime, int paramInt, IReadableMap paramIReadableMap)
  {
    Object localObject1 = paramIReadableMap.getString("url", null);
    Object localObject3 = paramIReadableMap.getReadableMap("data");
    localObject1 = new Request.Builder().url((String)localObject1);
    if (paramInt != 0) {
      ((Request.Builder)localObject1).tag(Integer.valueOf(paramInt));
    }
    String str = paramIReadableMap.getString("method", null);
    Object localObject2 = paramIReadableMap.getReadableMap("headers");
    boolean bool;
    Object localObject4;
    if ((localObject3 != null) && (((IReadableMap)localObject3).has("string")))
    {
      bool = true;
      localObject4 = extractHeaders((IReadableMap)localObject2, bool);
      ((Request.Builder)localObject1).headers((Headers)localObject4);
      localObject2 = ((Headers)localObject4).get("content-type");
      localObject4 = ((Headers)localObject4).get("content-encoding");
      if (localObject3 != null) {
        break label302;
      }
      ((Request.Builder)localObject1).method(str, RequestBodyUtil.getEmptyBody(str));
    }
    for (;;)
    {
      if (!paramIReadableMap.getBoolean("withCredentials", false)) {
        this.mClient.setCookieHandler(new NetworkingModule.1(this));
      }
      paramIPlatoRuntime = paramIReadableMap.getFunction("receivedProgress");
      if (paramIPlatoRuntime != null) {
        this.mClient.networkInterceptors().add(new NetworkingModule.2(this, paramIPlatoRuntime));
      }
      if (paramIReadableMap.has("timeout"))
      {
        int i = paramIReadableMap.getInt("timeout", 0);
        if (i != this.mClient.getReadTimeout()) {
          this.mClient.setReadTimeout(i, TimeUnit.MILLISECONDS);
        }
      }
      paramIPlatoRuntime = this.mClient.newCall(((Request.Builder)localObject1).build());
      addRequest(paramInt, paramIPlatoRuntime);
      paramIPlatoRuntime.enqueue(new NetworkingModule.3(this, paramInt, paramIReadableMap));
      return;
      bool = false;
      break;
      label302:
      if (((IReadableMap)localObject3).has("string"))
      {
        ((Request.Builder)localObject1).method(str, buildRequestBody(((IReadableMap)localObject3).getString("string", null), (String)localObject2, (String)localObject4));
      }
      else if (((IReadableMap)localObject3).has("base64"))
      {
        ((Request.Builder)localObject1).method(str, buildBase64RequestBody(((IReadableMap)localObject3).getString("base64", null), (String)localObject2));
      }
      else if (((IReadableMap)localObject3).has("uri"))
      {
        localObject3 = ((IReadableMap)localObject3).getString("uri", null);
        ((Request.Builder)localObject1).method(str, buildUriRequestBody(paramIPlatoRuntime.getContext(), (String)localObject3, (String)localObject2));
      }
      else if (((IReadableMap)localObject3).has("formData"))
      {
        localObject3 = ((IReadableMap)localObject3).getReadableArray("formData");
        localObject4 = paramIReadableMap.getFunction("sendProgress");
        ((Request.Builder)localObject1).method(str, buildFormDataRequestBody(paramIPlatoRuntime.getContext(), (IReadableArray)localObject3, (String)localObject2, (IFunction)localObject4));
      }
      else
      {
        ((Request.Builder)localObject1).method(str, RequestBodyUtil.getEmptyBody(str));
      }
    }
  }
  
  private static boolean shouldDispatch(long paramLong1, long paramLong2)
  {
    return 100000000L + paramLong2 < paramLong1;
  }
  
  private static IReadableMap translateHeaders(Headers paramHeaders)
  {
    JSONWritableMap localJSONWritableMap = new JSONWritableMap();
    int i = 0;
    if (i < paramHeaders.size())
    {
      String str = paramHeaders.name(i);
      if (localJSONWritableMap.has(str)) {
        localJSONWritableMap.put(str, localJSONWritableMap.getString(str, null) + ", " + paramHeaders.value(i));
      }
      for (;;)
      {
        i += 1;
        break;
        localJSONWritableMap.put(str, paramHeaders.value(i));
      }
    }
    return localJSONWritableMap;
  }
  
  @Exported("abortRequest")
  public void abortRequest(int paramInt)
  {
    cancelRequest(Integer.valueOf(paramInt));
    removeRequest(paramInt);
  }
  
  @Exported("clearCookies")
  public void clearCookies(IFunction paramIFunction)
  {
    this.mCookieHandler.clearCookies(paramIFunction);
  }
  
  public void onDestroy()
  {
    this.mShuttingDown = true;
    this.mCookieHandler.destroy();
    cancelAllRequests();
  }
  
  @Exported("request")
  public void request(IPlatoRuntime paramIPlatoRuntime, int paramInt, IReadableMap paramIReadableMap)
  {
    try
    {
      sendRequest(paramIPlatoRuntime, paramInt, paramIReadableMap);
      return;
    }
    catch (Exception paramIPlatoRuntime)
    {
      FuncUtil.invoke(paramIReadableMap.getFunction("fail"), new Object[] { new JSONWritableMap().put("code", -1).put("message", paramIPlatoRuntime.getMessage()) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.mqq.module.NetworkingModule
 * JD-Core Version:    0.7.0.1
 */