package com.tencent.mobileqq.highway.netprobe;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class EchoTask
{
  private static final int DEFAULT_2G_TIMEOUT = 20000;
  private static final int DEFAULT_3G_TIMEOUT = 15000;
  private static final int DEFAULT_4G_TIMEOUT = 10000;
  private static final int DEFAULT_WIFI_TIMEOUT = 10000;
  private static Pair<String, String>[] ECHO_ADDRESS = { new Pair("http://183.60.50.149:8080/cgi-bin/httpecho?len=20", null), new Pair("http://112.90.137.111:8080/cgi-bin/httpecho?len=20", null), new Pair("http://120.198.191.71:8080/cgi-bin/httpecho?len=20", null) };
  public static final int ECHO_EXCEPTION = 3;
  public static final int ECHO_NORMAL = 1;
  public static final int ECHO_REDIRECT_EXCEPTION = -1000;
  public static final int ECHO_RESPONSECODE_EXCEPTION = -999;
  public static final int ECHO_RESP_LENGTH = 20;
  public static final int ECHO_SERVER_EXCEPTION = -998;
  public static final int ECHO_UNKONW_EXCEPTION = -997;
  public static final int ECHO_WRONG_CONTENT = 2;
  private static final int MAX_REDIRECT_TIME = 5;
  private String errorMsg = "unkonw";
  private Context mContext;
  private String mExpectContent;
  private String mRealResponse;
  private String mRequestURL;
  private String mResponseURL;
  private int mTimeout;
  public int mType;
  private int responseCode;
  
  public EchoTask(Context paramContext)
  {
    this(paramContext, 1);
  }
  
  public EchoTask(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mType = paramInt;
    this.mTimeout = getTimeoutMills();
  }
  
  private void fillErrorMsg(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case -998: 
      this.errorMsg = ("echo connect exception:" + paramString);
      return;
    case -1000: 
      this.errorMsg = ("echo connect redirect error:" + paramString);
      return;
    case -997: 
      this.errorMsg = ("echo unkonw exception:" + paramString);
      return;
    }
    this.errorMsg = ("echo response exception,the responseCode is:" + paramString);
  }
  
  private String getMethod(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "GET";
    }
    return "POST";
  }
  
  private int getSystemNetwork()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable())) {}
    switch (localNetworkInfo.getType())
    {
    case 7: 
    case 8: 
    default: 
      return 0;
    case 9: 
      return 5;
    case 1: 
    case 6: 
      return 1;
    }
    switch (((TelephonyManager)this.mContext.getSystemService("phone")).getNetworkType())
    {
    case 4: 
    case 7: 
    case 11: 
    default: 
      return 2;
    case 13: 
      return 4;
    }
    return 3;
  }
  
  private int getTimeoutMills()
  {
    switch (getSystemNetwork())
    {
    case 2: 
    default: 
      return 20000;
    case 3: 
      return 15000;
    case 4: 
      return 10000;
    }
    return 10000;
  }
  
  public boolean checkEchoResp(String paramString)
  {
    paramString = paramString.toCharArray();
    if (paramString.length != 20) {
      return false;
    }
    int i = 0;
    int j = paramString.length;
    for (;;)
    {
      if (i >= j) {
        break label47;
      }
      if (('A' > paramString[i]) || (paramString[i] > 'Z')) {
        break;
      }
      i += 1;
    }
    label47:
    return true;
  }
  
  public int doEcho()
  {
    Pair[] arrayOfPair = ECHO_ADDRESS;
    Object localObject6 = null;
    int j = 0;
    int n = arrayOfPair.length;
    Object localObject1;
    Object localObject4;
    if (j < n)
    {
      localObject1 = localObject6;
      localObject4 = localObject6;
    }
    int k;
    Object localObject8;
    label912:
    for (;;)
    {
      try
      {
        this.mRequestURL = ((String)arrayOfPair[j].first);
        localObject1 = localObject6;
        localObject4 = localObject6;
        this.mExpectContent = ((String)arrayOfPair[j].second);
        k = 0;
        localObject1 = localObject6;
        localObject4 = localObject6;
        localObject8 = this.mRequestURL;
        m = 0;
        localObject4 = localObject6;
        localObject6 = localObject4;
        i = m;
        if (k < 5)
        {
          localObject1 = localObject4;
          localObject8 = (HttpURLConnection)new URL((String)localObject8).openConnection();
          localObject1 = localObject8;
          localObject4 = localObject8;
          ((HttpURLConnection)localObject8).setDoInput(true);
          localObject1 = localObject8;
          localObject4 = localObject8;
          ((HttpURLConnection)localObject8).setDoOutput(true);
          localObject1 = localObject8;
          localObject4 = localObject8;
          ((HttpURLConnection)localObject8).setUseCaches(false);
          localObject1 = localObject8;
          localObject4 = localObject8;
          ((HttpURLConnection)localObject8).setRequestMethod(getMethod(this.mType));
          localObject1 = localObject8;
          localObject4 = localObject8;
          ((HttpURLConnection)localObject8).setConnectTimeout(this.mTimeout);
          localObject1 = localObject8;
          localObject4 = localObject8;
          ((HttpURLConnection)localObject8).setReadTimeout(this.mTimeout);
          localObject1 = localObject8;
          localObject4 = localObject8;
          ((HttpURLConnection)localObject8).connect();
          localObject1 = localObject8;
          localObject4 = localObject8;
          if (this.mType == 2)
          {
            localObject1 = localObject8;
            localObject4 = localObject8;
            localObject6 = ((HttpURLConnection)localObject8).getOutputStream();
            localObject1 = localObject8;
            localObject4 = localObject8;
            localObject9 = new byte[2048];
            localObject1 = localObject8;
            localObject4 = localObject8;
            new Random().nextBytes((byte[])localObject9);
            localObject1 = localObject8;
            localObject4 = localObject8;
            ((OutputStream)localObject6).write((byte[])localObject9);
            localObject1 = localObject8;
            localObject4 = localObject8;
            ((OutputStream)localObject6).flush();
          }
          localObject1 = localObject8;
          localObject4 = localObject8;
          this.responseCode = ((HttpURLConnection)localObject8).getResponseCode();
          localObject1 = localObject8;
          localObject4 = localObject8;
          if (this.responseCode != 301)
          {
            localObject1 = localObject8;
            localObject4 = localObject8;
            if (this.responseCode != 302) {
              continue;
            }
          }
          if (k + 1 == 5)
          {
            localObject1 = localObject8;
            localObject4 = localObject8;
            fillErrorMsg(-1000, "redirect to many!");
            i = 1;
            localObject6 = localObject8;
          }
        }
        else
        {
          if (i != 0) {
            continue;
          }
          localObject1 = localObject6;
          localObject4 = localObject6;
          this.mResponseURL = ((HttpURLConnection)localObject6).getURL().toString();
          localObject1 = localObject6;
          localObject4 = localObject6;
          if (this.responseCode != 200)
          {
            localObject1 = localObject6;
            localObject4 = localObject6;
            if (this.responseCode != 206) {
              continue;
            }
          }
          localObject1 = localObject6;
          localObject4 = localObject6;
          localObject8 = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject6).getInputStream()));
          localObject1 = localObject6;
          localObject4 = localObject6;
          localObject9 = new StringBuilder();
          localObject1 = localObject6;
          localObject4 = localObject6;
          String str = ((BufferedReader)localObject8).readLine();
          if (str == null) {
            continue;
          }
          localObject1 = localObject6;
          localObject4 = localObject6;
          ((StringBuilder)localObject9).append(str + "\n");
          continue;
        }
      }
      catch (IOException localIOException)
      {
        int m;
        Object localObject9;
        localObject4 = localObject1;
        try
        {
          localObject8 = localObject1.getErrorStream();
          localObject4 = localObject1;
          i = ((InputStream)localObject8).read();
          if (i != -1) {
            continue;
          }
        }
        catch (Exception localException)
        {
          Object localObject7;
          boolean bool;
          continue;
          Object localObject3 = localObject7;
          k += 1;
          Object localObject5 = localObject8;
          localObject8 = localObject3;
        }
        localObject4 = localObject1;
        fillErrorMsg(-997, localIOException.toString());
        localObject4 = localObject1;
        if (localObject1 != null)
        {
          localObject1.disconnect();
          localObject4 = localObject1;
        }
        j += 1;
        localObject7 = localObject4;
        break;
        localObject1 = localObject8;
        localObject4 = localObject8;
        localObject7 = ((HttpURLConnection)localObject8).getHeaderField("Location");
        if (localObject7 != null) {
          break label912;
        }
        localObject1 = localObject8;
        localObject4 = localObject8;
        fillErrorMsg(-1000, " redirect and location header can't get ");
        int i = 1;
        localObject7 = localObject8;
        continue;
        localObject7 = localObject8;
        i = m;
        localObject1 = localObject8;
        localObject4 = localObject8;
        if (this.responseCode != 404) {
          continue;
        }
        i = 1;
        localObject7 = localObject8;
        continue;
        localObject1 = localObject7;
        localObject4 = localObject7;
        ((BufferedReader)localObject8).close();
        localObject1 = localObject7;
        localObject4 = localObject7;
        this.mRealResponse = ((StringBuilder)localObject9).toString().trim();
        localObject1 = localObject7;
        localObject4 = localObject7;
        bool = checkEchoResp(this.mRealResponse);
        if (bool)
        {
          j = 1;
          i = j;
          if (localObject7 != null)
          {
            ((HttpURLConnection)localObject7).disconnect();
            i = j;
          }
          return i;
        }
        i = 2;
        if (localObject7 == null) {
          continue;
        }
        ((HttpURLConnection)localObject7).disconnect();
        return 2;
        localObject1 = localObject7;
        localObject4 = localObject7;
        fillErrorMsg(-999, this.responseCode + "");
        i = 3;
        if (localObject7 == null) {
          continue;
        }
        ((HttpURLConnection)localObject7).disconnect();
        return 3;
        localObject4 = localObject7;
        if (localObject7 == null) {
          continue;
        }
        ((HttpURLConnection)localObject7).disconnect();
        localObject4 = localObject7;
        continue;
      }
      finally
      {
        if (localObject4 != null) {
          localObject4.disconnect();
        }
      }
      return 3;
    }
  }
  
  public String getErrorMsg()
  {
    return this.errorMsg;
  }
  
  public String getExpectContent()
  {
    return this.mExpectContent;
  }
  
  public String getResponseContent()
  {
    return this.mRealResponse;
  }
  
  public String getResponseUrl()
  {
    return this.mResponseURL;
  }
  
  public int getTimeout()
  {
    return this.mTimeout;
  }
  
  public static abstract interface ECHO_TYPE
  {
    public static final int HTTP_GET = 1;
    public static final int HTTP_POST = 2;
  }
  
  static abstract interface NetType
  {
    public static final int CABLE = 5;
    public static final int G2 = 2;
    public static final int G3 = 3;
    public static final int G4 = 4;
    public static final int NONE = 0;
    public static final int WIFI = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.EchoTask
 * JD-Core Version:    0.7.0.1
 */