package com.tencent.mobileqq.tts;

import android.content.Context;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqemoticon.api.ITextUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class SilkStreamPlayer
{
  private static long a;
  private SilkStreamPlayer.SilkStreamPlayerThread b;
  private String c;
  private String d;
  private String e = "0";
  private String f;
  
  public SilkStreamPlayer(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.c = ((ITextUtilsApi)QRoute.api(ITextUtilsApi.class)).emoticonToTextForTalkBack(paramString1).replaceAll("/", " ");
    this.c = paramString1;
    this.d = paramString2;
    this.f = paramString3;
  }
  
  private InputStream a(HttpsURLConnection paramHttpsURLConnection, int paramInt)
  {
    paramHttpsURLConnection.setRequestMethod("POST");
    paramHttpsURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
    paramHttpsURLConnection.setRequestProperty("Accept", "application/json");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uin=");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(";skey=");
    ((StringBuilder)localObject).append(this.f);
    paramHttpsURLConnection.setRequestProperty("Cookie", ((StringBuilder)localObject).toString());
    paramHttpsURLConnection.setDoOutput(true);
    paramHttpsURLConnection.setDoInput(true);
    try
    {
      localObject = SSLContext.getDefault();
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      QLog.e("SilkStreamPlayer", 2, localNoSuchAlgorithmException, new Object[0]);
      localJSONObject = null;
    }
    if (localJSONObject != null) {
      paramHttpsURLConnection.setSSLSocketFactory(localJSONObject.getSocketFactory());
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", "201908021016");
      localJSONObject.put("uin", Long.valueOf(this.d));
      localJSONObject.put("sendUin", Long.valueOf(this.e));
      localJSONObject.put("text", this.c);
      localJSONObject.put("textmd5", MD5Utils.toMD5(this.c));
      long l = a;
      a = 1L + l;
      localJSONObject.put("seq", l);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AND_");
      localStringBuilder.append(AppSetting.d());
      localStringBuilder.append("_");
      localStringBuilder.append("8.8.17");
      localJSONObject.put("clientVersion", localStringBuilder.toString());
      localJSONObject.put("net", HttpUtil.getNetWorkType());
      localJSONObject.put("businessID", paramInt);
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SilkStreamPlayer", 1, localJSONException, new Object[0]);
      }
    }
    try
    {
      DataOutputStream localDataOutputStream = new DataOutputStream(paramHttpsURLConnection.getOutputStream());
      localDataOutputStream.write(new String(localJSONObject.toString().getBytes(), "utf-8").getBytes());
      localDataOutputStream.flush();
      localDataOutputStream.close();
      if (paramHttpsURLConnection.getResponseCode() == 200)
      {
        if (paramInt == 1) {
          a("0", "0");
        }
        return paramHttpsURLConnection.getInputStream();
      }
      if (paramInt == 1)
      {
        paramHttpsURLConnection = String.valueOf(paramHttpsURLConnection.getResponseCode());
        a(paramHttpsURLConnection, paramHttpsURLConnection);
        return null;
      }
    }
    catch (Exception paramHttpsURLConnection)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SilkStreamPlayer", 1, paramHttpsURLConnection, new Object[0]);
      }
    }
    return null;
  }
  
  private void a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("playSuccess", paramString1);
    localHashMap.put("playError", paramString2);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "TTSPlayMonitor", true, 0L, 0L, localHashMap, "");
  }
  
  private boolean a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = HexUtil.hexStr2Bytes("02232153494C4B5F5633");
    int i = 1;
    while (i < 10)
    {
      if (arrayOfByte[i] != paramArrayOfByte[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public void a()
  {
    SilkStreamPlayer.SilkStreamPlayerThread localSilkStreamPlayerThread = this.b;
    if (localSilkStreamPlayerThread != null)
    {
      SilkStreamPlayer.SilkStreamPlayerThread.a(localSilkStreamPlayerThread, false);
      this.b = null;
    }
  }
  
  public void a(SilkStreamPlayer.OnSilkStreamPlay paramOnSilkStreamPlay, int paramInt1, int paramInt2)
  {
    if (this.b == null) {
      this.b = new SilkStreamPlayer.SilkStreamPlayerThread(this, MobileQQ.sMobileQQ, paramOnSilkStreamPlay, paramInt1, paramInt2);
    }
    ThreadManagerV2.excute(this.b, 128, null, true);
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public boolean b()
  {
    SilkStreamPlayer.SilkStreamPlayerThread localSilkStreamPlayerThread = this.b;
    return (localSilkStreamPlayerThread != null) && (SilkStreamPlayer.SilkStreamPlayerThread.a(localSilkStreamPlayerThread));
  }
  
  public void c()
  {
    SilkStreamPlayer.SilkStreamPlayerThread localSilkStreamPlayerThread = this.b;
    if (localSilkStreamPlayerThread != null) {
      SilkStreamPlayer.SilkStreamPlayerThread.a(localSilkStreamPlayerThread, false);
    }
  }
  
  public void c(String paramString)
  {
    this.c = ((ITextUtilsApi)QRoute.api(ITextUtilsApi.class)).emoticonToTextForTalkBack(paramString).replaceAll("/", " ");
    this.c = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tts.SilkStreamPlayer
 * JD-Core Version:    0.7.0.1
 */