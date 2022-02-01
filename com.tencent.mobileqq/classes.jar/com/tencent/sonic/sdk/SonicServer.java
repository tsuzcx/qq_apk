package com.tencent.sonic.sdk;

import android.content.Intent;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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
      Object localObject = this.connectionImpl.getResponseStream();
      if (localObject == null)
      {
        paramAtomicBoolean = new StringBuilder();
        paramAtomicBoolean.append("session(");
        paramAtomicBoolean.append(this.session.sId);
        paramAtomicBoolean.append(") readServerResponse error: bufferedInputStream is null!");
        SonicUtils.log("SonicSdk_SonicServer", 6, paramAtomicBoolean.toString());
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
          i = ((BufferedInputStream)localObject).read(arrayOfByte);
          j = i;
          if (-1 == i) {
            break;
          }
          this.outputStream.write(arrayOfByte, 0, i);
        }
        if (j == -1) {
          this.serverRsp = this.outputStream.toString(this.session.getCharsetFromHeaders());
        }
      }
      catch (Exception paramAtomicBoolean)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("session(");
        ((StringBuilder)localObject).append(this.session.sId);
        ((StringBuilder)localObject).append(") readServerResponse error:");
        ((StringBuilder)localObject).append(paramAtomicBoolean.getMessage());
        ((StringBuilder)localObject).append(".");
        SonicUtils.log("SonicSdk_SonicServer", 6, ((StringBuilder)localObject).toString());
        return false;
      }
    }
    return true;
  }
  
  protected int connect()
  {
    long l = System.currentTimeMillis();
    int i = this.connectionImpl.connect();
    this.session.statistics.connectionConnectTime = System.currentTimeMillis();
    if (SonicUtils.shouldLog(3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("session(");
      ((StringBuilder)localObject).append(this.session.id);
      ((StringBuilder)localObject).append(") server connect cost = ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      ((StringBuilder)localObject).append(" ms.");
      SonicUtils.log("SonicSdk_SonicServer", 3, ((StringBuilder)localObject).toString());
    }
    if (i != 0) {
      return i;
    }
    l = System.currentTimeMillis();
    this.responseCode = this.connectionImpl.getResponseCode();
    this.session.statistics.connectionRespondTime = System.currentTimeMillis();
    if (SonicUtils.shouldLog(3))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("session(");
      ((StringBuilder)localObject).append(this.session.id);
      ((StringBuilder)localObject).append(") server response cost = ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      ((StringBuilder)localObject).append(" ms.");
      SonicUtils.log("SonicSdk_SonicServer", 3, ((StringBuilder)localObject).toString());
    }
    i = this.responseCode;
    if (304 == i) {
      return 0;
    }
    if (200 != i) {
      return 0;
    }
    String str1 = getResponseHeaderField("eTag");
    Object localObject = str1;
    if (!TextUtils.isEmpty(str1))
    {
      localObject = str1;
      if (str1.toLowerCase().startsWith("w/"))
      {
        localObject = str1.toLowerCase().replace("w/", "").replace("\"", "");
        addResponseHeaderFields("eTag", new String[] { localObject });
      }
    }
    str1 = this.requestIntent.getStringExtra("eTag");
    String str2 = getResponseHeaderField("eTag");
    if ((!TextUtils.isEmpty(str1)) && (str1.equals(str2)))
    {
      this.responseCode = 304;
      return 0;
    }
    if (!isSonicResponse())
    {
      if (!this.session.config.SUPPORT_LOCAL_SERVER) {
        return 0;
      }
      str2 = getResponseHeaderField("cache-offline");
      if ("http".equalsIgnoreCase(str2)) {
        return 0;
      }
      if (TextUtils.isEmpty(str2)) {
        addResponseHeaderFields("cache-offline", new String[] { "true" });
      }
      if (isFirstLoadRequest()) {
        return 0;
      }
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        readServerResponse(null);
        if (!TextUtils.isEmpty(this.serverRsp))
        {
          localObject = SonicUtils.getSHA1(this.serverRsp);
          addResponseHeaderFields("eTag", new String[] { localObject });
          addResponseHeaderFields("sonic-html-sha1", new String[] { localObject });
          if (str1.equals(localObject))
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
      str1 = getResponseHeaderField("template-tag");
      localObject = str1;
      if (TextUtils.isEmpty(str1))
      {
        if (TextUtils.isEmpty(this.serverRsp)) {
          readServerResponse(null);
        }
        if (!TextUtils.isEmpty(this.serverRsp))
        {
          separateTemplateAndData();
          localObject = getResponseHeaderField("template-tag");
        }
        else
        {
          return -901;
        }
      }
      if (this.requestIntent.getStringExtra("template-tag").equals(localObject))
      {
        addResponseHeaderFields("template-change", new String[] { "false" });
        return 0;
      }
      addResponseHeaderFields("template-change", new String[] { "true" });
    }
    return 0;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("session(");
      localStringBuilder.append(this.session.sId);
      localStringBuilder.append(") server disconnect error:");
      localStringBuilder.append(localThrowable.getMessage());
      localStringBuilder.append(".");
      SonicUtils.log("SonicSdk_SonicServer", 6, localStringBuilder.toString());
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
  
  public InputStream getResponseStream(AtomicBoolean paramAtomicBoolean)
  {
    try
    {
      boolean bool = readServerResponse(paramAtomicBoolean);
      paramAtomicBoolean = null;
      if (bool)
      {
        if (TextUtils.isEmpty(this.serverRsp)) {
          paramAtomicBoolean = this.connectionImpl.getResponseStream();
        }
        paramAtomicBoolean = new SonicSessionStream(this, this.outputStream, paramAtomicBoolean);
        return paramAtomicBoolean;
      }
      return null;
    }
    finally {}
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
    if ((TextUtils.isEmpty(this.serverRsp)) && (paramBoolean) && (paramByteArrayOutputStream != null)) {
      try
      {
        this.serverRsp = paramByteArrayOutputStream.toString(this.session.getCharsetFromHeaders());
        paramByteArrayOutputStream.close();
      }
      catch (Throwable paramByteArrayOutputStream)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("session(");
        localStringBuilder.append(this.session.sId);
        localStringBuilder.append("), onClose error:");
        localStringBuilder.append(paramByteArrayOutputStream.getMessage());
        localStringBuilder.append(".");
        SonicUtils.log("SonicSdk_SonicServer", 6, localStringBuilder.toString());
      }
    }
    this.session.onServerClosed(this, paramBoolean);
  }
  
  protected void separateTemplateAndData()
  {
    if (!TextUtils.isEmpty(this.serverRsp))
    {
      Object localObject1 = new StringBuilder();
      Object localObject3 = new StringBuilder();
      boolean bool = SonicUtils.separateTemplateAndData(this.session.id, this.serverRsp, (StringBuilder)localObject1, (StringBuilder)localObject3);
      Object localObject2 = null;
      if (bool)
      {
        this.templateString = ((StringBuilder)localObject1).toString();
        localObject1 = ((StringBuilder)localObject3).toString();
      }
      else
      {
        localObject1 = null;
      }
      String str1 = getResponseHeaderField("eTag");
      String str2 = getResponseHeaderField("template-tag");
      localObject3 = str1;
      if (TextUtils.isEmpty(str1))
      {
        localObject2 = SonicUtils.getSHA1(this.serverRsp);
        addResponseHeaderFields("eTag", new String[] { localObject2 });
        addResponseHeaderFields("sonic-html-sha1", new String[] { localObject2 });
        localObject3 = localObject2;
      }
      if (TextUtils.isEmpty(this.templateString))
      {
        this.templateString = this.serverRsp;
        addResponseHeaderFields("template-tag", new String[] { localObject3 });
      }
      else if (TextUtils.isEmpty(str2))
      {
        addResponseHeaderFields("template-tag", new String[] { SonicUtils.getSHA1(this.templateString) });
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        try
        {
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("data", new JSONObject((String)localObject1));
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            addResponseHeaderFields("sonic-html-sha1", new String[] { SonicUtils.getSHA1(this.serverRsp) });
          }
          ((JSONObject)localObject3).put("html-sha1", getResponseHeaderField("sonic-html-sha1"));
          ((JSONObject)localObject3).put("template-tag", getResponseHeaderField("template-tag"));
          this.dataString = ((JSONObject)localObject3).toString();
          return;
        }
        catch (Exception localException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("session(");
          ((StringBuilder)localObject2).append(this.session.sId);
          ((StringBuilder)localObject2).append(") parse server response data error:");
          ((StringBuilder)localObject2).append(localException.getMessage());
          ((StringBuilder)localObject2).append(".");
          SonicUtils.log("SonicSdk_SonicServer", 6, ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicServer
 * JD-Core Version:    0.7.0.1
 */