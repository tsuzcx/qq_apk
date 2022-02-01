package com.tencent.sonic.sdk;

import android.content.Intent;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class SonicServer
  implements SonicSessionStream.Callback
{
  public static final String TAG = "SonicSdk_SonicServer";
  protected Map<String, List<String>> cachedResponseHeaders;
  protected final SonicSessionConnection connectionImpl;
  protected String dataString;
  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  protected final Intent requestIntent;
  protected int responseCode;
  protected String serverRsp;
  protected final SonicSession session;
  protected String templateString;
  
  public SonicServer(SonicSession paramSonicSession, Intent paramIntent)
  {
    this.session = paramSonicSession;
    this.requestIntent = paramIntent;
    this.connectionImpl = SonicSessionConnectionInterceptor.getSonicSessionConnection(paramSonicSession, paramIntent);
  }
  
  private void addResponseHeaderFields(String paramString, String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    Collections.addAll(localArrayList, paramVarArgs);
    getResponseHeaderFields().put(paramString.toLowerCase(), localArrayList);
  }
  
  private boolean isFirstLoadRequest()
  {
    return (TextUtils.isEmpty(this.requestIntent.getStringExtra("eTag"))) || (TextUtils.isEmpty(this.requestIntent.getStringExtra("template-tag")));
  }
  
  private boolean isSonicResponse()
  {
    Object localObject1 = this.connectionImpl.getResponseHeaderFields();
    if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty((CharSequence)((Map.Entry)localObject2).getKey()))
        {
          localObject2 = ((String)((Map.Entry)localObject2).getKey()).toLowerCase();
          if ((((String)localObject2).equals("cache-offline")) || (((String)localObject2).equals("template-change")) || (((String)localObject2).equals("template-tag"))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private boolean readServerResponse(AtomicBoolean paramAtomicBoolean)
  {
    if (TextUtils.isEmpty(this.serverRsp))
    {
      BufferedInputStream localBufferedInputStream = this.connectionImpl.getResponseStream();
      if (localBufferedInputStream == null)
      {
        SonicUtils.log("SonicSdk_SonicServer", 6, "session(" + this.session.sId + ") readServerResponse error: bufferedInputStream is null!");
        return false;
      }
      try
      {
        byte[] arrayOfByte = new byte[this.session.config.READ_BUF_SIZE];
        int i = 0;
        int j;
        for (;;)
        {
          if (paramAtomicBoolean != null)
          {
            j = i;
            if (paramAtomicBoolean.get()) {
              break;
            }
          }
          i = localBufferedInputStream.read(arrayOfByte);
          j = i;
          if (-1 == i) {
            break;
          }
          this.outputStream.write(arrayOfByte, 0, i);
        }
        if (j != -1) {
          break label196;
        }
      }
      catch (Exception paramAtomicBoolean)
      {
        SonicUtils.log("SonicSdk_SonicServer", 6, "session(" + this.session.sId + ") readServerResponse error:" + paramAtomicBoolean.getMessage() + ".");
        return false;
      }
      this.serverRsp = this.outputStream.toString(this.session.getCharsetFromHeaders());
    }
    label196:
    return true;
  }
  
  protected int connect()
  {
    long l = System.currentTimeMillis();
    int i = this.connectionImpl.connect();
    this.session.statistics.connectionConnectTime = System.currentTimeMillis();
    if (SonicUtils.shouldLog(3)) {
      SonicUtils.log("SonicSdk_SonicServer", 3, "session(" + this.session.id + ") server connect cost = " + (System.currentTimeMillis() - l) + " ms.");
    }
    if (i != 0) {
      return i;
    }
    l = System.currentTimeMillis();
    this.responseCode = this.connectionImpl.getResponseCode();
    this.session.statistics.connectionRespondTime = System.currentTimeMillis();
    if (SonicUtils.shouldLog(3)) {
      SonicUtils.log("SonicSdk_SonicServer", 3, "session(" + this.session.id + ") server response cost = " + (System.currentTimeMillis() - l) + " ms.");
    }
    if (304 == this.responseCode) {
      return 0;
    }
    if (200 != this.responseCode) {
      return 0;
    }
    String str2 = getResponseHeaderField("eTag");
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.toLowerCase().startsWith("w/"))
      {
        str1 = str2.toLowerCase().replace("w/", "").replace("\"", "");
        addResponseHeaderFields("eTag", new String[] { str1 });
      }
    }
    str2 = this.requestIntent.getStringExtra("eTag");
    String str3 = getResponseHeaderField("eTag");
    if ((!TextUtils.isEmpty(str2)) && (str2.equals(str3)))
    {
      this.responseCode = 304;
      return 0;
    }
    if ((isSonicResponse()) || (!this.session.config.SUPPORT_LOCAL_SERVER)) {
      return 0;
    }
    str3 = getResponseHeaderField("cache-offline");
    if ("http".equalsIgnoreCase(str3)) {
      return 0;
    }
    if (TextUtils.isEmpty(str3)) {
      addResponseHeaderFields("cache-offline", new String[] { "true" });
    }
    if (isFirstLoadRequest()) {
      return 0;
    }
    if (TextUtils.isEmpty(str1))
    {
      readServerResponse(null);
      if (!TextUtils.isEmpty(this.serverRsp))
      {
        str1 = SonicUtils.getSHA1(this.serverRsp);
        addResponseHeaderFields("eTag", new String[] { str1 });
        addResponseHeaderFields("sonic-html-sha1", new String[] { str1 });
        if (str2.equals(str1))
        {
          this.responseCode = 304;
          return 0;
        }
      }
      else
      {
        return -901;
      }
    }
    str2 = getResponseHeaderField("template-tag");
    str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if (TextUtils.isEmpty(this.serverRsp)) {
        readServerResponse(null);
      }
      if (!TextUtils.isEmpty(this.serverRsp))
      {
        separateTemplateAndData();
        str1 = getResponseHeaderField("template-tag");
      }
    }
    else
    {
      if (!this.requestIntent.getStringExtra("template-tag").equals(str1)) {
        break label579;
      }
      addResponseHeaderFields("template-change", new String[] { "false" });
    }
    for (;;)
    {
      return 0;
      return -901;
      label579:
      addResponseHeaderFields("template-change", new String[] { "true" });
    }
  }
  
  public void disconnect()
  {
    try
    {
      BufferedInputStream localBufferedInputStream = this.connectionImpl.getResponseStream();
      if (localBufferedInputStream != null) {
        localBufferedInputStream.close();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        SonicUtils.log("SonicSdk_SonicServer", 6, "session(" + this.session.sId + ") server disconnect error:" + localThrowable.getMessage() + ".");
      }
    }
    this.connectionImpl.disconnect();
  }
  
  public int getResponseCode()
  {
    return this.responseCode;
  }
  
  public String getResponseData(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if (TextUtils.isEmpty(this.serverRsp)) {
        readServerResponse(null);
      }
      String str = this.serverRsp;
      return str;
    }
    finally {}
  }
  
  public String getResponseHeaderField(String paramString)
  {
    Object localObject = getResponseHeaderFields();
    if ((localObject != null) && (((Map)localObject).size() != 0))
    {
      paramString = (List)((Map)localObject).get(paramString.toLowerCase());
      if ((paramString != null) && (paramString.size() != 0))
      {
        localObject = new StringBuilder((String)paramString.get(0));
        int j = paramString.size();
        int i = 1;
        while (i < j)
        {
          ((StringBuilder)localObject).append(',');
          ((StringBuilder)localObject).append((String)paramString.get(i));
          i += 1;
        }
        return ((StringBuilder)localObject).toString();
      }
    }
    return null;
  }
  
  public Map<String, List<String>> getResponseHeaderFields()
  {
    if (this.cachedResponseHeaders == null)
    {
      this.cachedResponseHeaders = new ConcurrentHashMap();
      Object localObject3;
      Object localObject2;
      if ((this.session.config.customResponseHeaders != null) && (this.session.config.customResponseHeaders.size() > 0))
      {
        localObject3 = this.session.config.customResponseHeaders.entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
          String str = (String)localEntry.getKey();
          if (!TextUtils.isEmpty(str))
          {
            localObject2 = (List)this.cachedResponseHeaders.get(str.toLowerCase());
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new ArrayList(1);
              this.cachedResponseHeaders.put(str.toLowerCase(), localObject1);
            }
            ((List)localObject1).add(localEntry.getValue());
          }
        }
      }
      Object localObject1 = this.connectionImpl.getResponseHeaderFields();
      if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = (String)((Map.Entry)localObject2).getKey();
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            this.cachedResponseHeaders.put(((String)localObject3).toLowerCase(), ((Map.Entry)localObject2).getValue());
          }
        }
      }
    }
    return this.cachedResponseHeaders;
  }
  
  /* Error */
  public java.io.InputStream getResponseStream(AtomicBoolean paramAtomicBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 287	com/tencent/sonic/sdk/SonicServer:readServerResponse	(Ljava/util/concurrent/atomic/AtomicBoolean;)Z
    //   9: ifeq +29 -> 38
    //   12: aload_0
    //   13: getfield 142	com/tencent/sonic/sdk/SonicServer:serverRsp	Ljava/lang/String;
    //   16: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifne +23 -> 42
    //   22: aconst_null
    //   23: astore_1
    //   24: new 347	com/tencent/sonic/sdk/SonicSessionStream
    //   27: dup
    //   28: aload_0
    //   29: aload_0
    //   30: getfield 36	com/tencent/sonic/sdk/SonicServer:outputStream	Ljava/io/ByteArrayOutputStream;
    //   33: aload_1
    //   34: invokespecial 350	com/tencent/sonic/sdk/SonicSessionStream:<init>	(Lcom/tencent/sonic/sdk/SonicSessionStream$Callback;Ljava/io/ByteArrayOutputStream;Ljava/io/BufferedInputStream;)V
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: areturn
    //   42: aload_0
    //   43: getfield 48	com/tencent/sonic/sdk/SonicServer:connectionImpl	Lcom/tencent/sonic/sdk/SonicSessionConnection;
    //   46: invokevirtual 146	com/tencent/sonic/sdk/SonicSessionConnection:getResponseStream	()Ljava/io/BufferedInputStream;
    //   49: astore_1
    //   50: goto -26 -> 24
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	SonicServer
    //   0	58	1	paramAtomicBoolean	AtomicBoolean
    //   1	40	2	localSonicSessionStream	SonicSessionStream
    // Exception table:
    //   from	to	target	type
    //   4	22	53	finally
    //   24	38	53	finally
    //   42	50	53	finally
  }
  
  public String getTemplate()
  {
    try
    {
      if ((TextUtils.isEmpty(this.templateString)) && (!TextUtils.isEmpty(this.serverRsp))) {
        separateTemplateAndData();
      }
      String str = this.templateString;
      return str;
    }
    finally {}
  }
  
  public String getUpdatedData()
  {
    try
    {
      if ((TextUtils.isEmpty(this.dataString)) && (!TextUtils.isEmpty(this.serverRsp))) {
        separateTemplateAndData();
      }
      String str = this.dataString;
      return str;
    }
    finally {}
  }
  
  public void onClose(boolean paramBoolean, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    if ((TextUtils.isEmpty(this.serverRsp)) && (paramBoolean) && (paramByteArrayOutputStream != null)) {}
    try
    {
      this.serverRsp = paramByteArrayOutputStream.toString(this.session.getCharsetFromHeaders());
      paramByteArrayOutputStream.close();
      this.session.onServerClosed(this, paramBoolean);
      return;
    }
    catch (Throwable paramByteArrayOutputStream)
    {
      for (;;)
      {
        SonicUtils.log("SonicSdk_SonicServer", 6, "session(" + this.session.sId + "), onClose error:" + paramByteArrayOutputStream.getMessage() + ".");
      }
    }
  }
  
  protected void separateTemplateAndData()
  {
    String str1 = null;
    Object localObject3;
    if (!TextUtils.isEmpty(this.serverRsp))
    {
      localObject1 = new StringBuilder();
      localObject3 = new StringBuilder();
      if (!SonicUtils.separateTemplateAndData(this.session.id, this.serverRsp, (StringBuilder)localObject1, (StringBuilder)localObject3)) {
        break label337;
      }
      this.templateString = ((StringBuilder)localObject1).toString();
    }
    label337:
    Object localObject2;
    for (Object localObject1 = ((StringBuilder)localObject3).toString();; localObject2 = null)
    {
      String str2 = getResponseHeaderField("eTag");
      String str3 = getResponseHeaderField("template-tag");
      localObject3 = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = SonicUtils.getSHA1(this.serverRsp);
        addResponseHeaderFields("eTag", new String[] { str1 });
        addResponseHeaderFields("sonic-html-sha1", new String[] { str1 });
        localObject3 = str1;
      }
      if (TextUtils.isEmpty(this.templateString))
      {
        this.templateString = this.serverRsp;
        addResponseHeaderFields("template-tag", new String[] { localObject3 });
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
        try
        {
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("data", new JSONObject((String)localObject1));
          if (TextUtils.isEmpty(str1)) {
            addResponseHeaderFields("sonic-html-sha1", new String[] { SonicUtils.getSHA1(this.serverRsp) });
          }
          ((JSONObject)localObject3).put("html-sha1", getResponseHeaderField("sonic-html-sha1"));
          ((JSONObject)localObject3).put("template-tag", getResponseHeaderField("template-tag"));
          this.dataString = ((JSONObject)localObject3).toString();
          return;
        }
        catch (Exception localException)
        {
          SonicUtils.log("SonicSdk_SonicServer", 6, "session(" + this.session.sId + ") parse server response data error:" + localException.getMessage() + ".");
          return;
        }
        if (TextUtils.isEmpty(str3)) {
          addResponseHeaderFields("template-tag", new String[] { SonicUtils.getSHA1(this.templateString) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicServer
 * JD-Core Version:    0.7.0.1
 */