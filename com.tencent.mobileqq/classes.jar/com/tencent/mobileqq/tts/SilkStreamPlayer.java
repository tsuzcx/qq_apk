package com.tencent.mobileqq.tts;

import android.content.Context;
import bflu;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.TextUtils;
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
import org.json.JSONException;
import org.json.JSONObject;

public class SilkStreamPlayer
{
  private static long jdField_a_of_type_Long;
  private SilkStreamPlayer.SilkStreamPlayerThread jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c = "0";
  private String d;
  
  public SilkStreamPlayer(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = TextUtils.emoticonToTextForTalkBack(paramString1).replaceAll("/", " ");
    this.b = paramString2;
    this.d = paramString3;
  }
  
  private InputStream a(HttpsURLConnection paramHttpsURLConnection, int paramInt)
  {
    Object localObject3 = null;
    paramHttpsURLConnection.setRequestMethod("POST");
    paramHttpsURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
    paramHttpsURLConnection.setRequestProperty("Accept", "application/json");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("uin=");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(";skey=");
    ((StringBuilder)localObject1).append(this.d);
    paramHttpsURLConnection.setRequestProperty("Cookie", ((StringBuilder)localObject1).toString());
    paramHttpsURLConnection.setDoOutput(true);
    paramHttpsURLConnection.setDoInput(true);
    try
    {
      localObject1 = SSLContext.getDefault();
      if (localObject1 != null) {
        paramHttpsURLConnection.setSSLSocketFactory(((SSLContext)localObject1).getSocketFactory());
      }
      localObject1 = new JSONObject();
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      try
      {
        ((JSONObject)localObject1).put("appid", "201908021016");
        ((JSONObject)localObject1).put("uin", Long.valueOf(this.b));
        ((JSONObject)localObject1).put("sendUin", Long.valueOf(this.c));
        ((JSONObject)localObject1).put("text", this.jdField_a_of_type_JavaLangString);
        ((JSONObject)localObject1).put("textmd5", MD5Utils.toMD5(this.jdField_a_of_type_JavaLangString));
        long l = jdField_a_of_type_Long;
        jdField_a_of_type_Long = 1L + l;
        ((JSONObject)localObject1).put("seq", l);
        ((JSONObject)localObject1).put("clientVersion", "AND_" + AppSetting.a() + "_" + "8.4.8");
        ((JSONObject)localObject1).put("net", HttpUtil.getNetWorkType());
        ((JSONObject)localObject1).put("businessID", paramInt);
        try
        {
          DataOutputStream localDataOutputStream = new DataOutputStream(paramHttpsURLConnection.getOutputStream());
          localDataOutputStream.write(new String(((JSONObject)localObject1).toString().getBytes(), "utf-8").getBytes());
          localDataOutputStream.flush();
          localDataOutputStream.close();
          if (paramHttpsURLConnection.getResponseCode() != 200) {
            break label387;
          }
          if (paramInt == 1) {
            a("0", "0");
          }
          localObject1 = paramHttpsURLConnection.getInputStream();
        }
        catch (Exception paramHttpsURLConnection)
        {
          do
          {
            Object localObject2 = localObject3;
          } while (!QLog.isColorLevel());
          QLog.d("SilkStreamPlayer", 1, paramHttpsURLConnection, new Object[0]);
        }
        return localObject1;
        localNoSuchAlgorithmException = localNoSuchAlgorithmException;
        QLog.e("SilkStreamPlayer", 2, localNoSuchAlgorithmException, new Object[0]);
        localObject2 = null;
      }
      catch (JSONException localJSONException)
      {
        label387:
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SilkStreamPlayer", 1, localJSONException, new Object[0]);
            }
          }
          localObject2 = localObject3;
        } while (paramInt != 1);
        paramHttpsURLConnection = String.valueOf(paramHttpsURLConnection.getResponseCode());
        a(paramHttpsURLConnection, paramHttpsURLConnection);
        return null;
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
    boolean bool2 = true;
    byte[] arrayOfByte = HexUtil.hexStr2Bytes("02232153494C4B5F5633");
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < 10)
      {
        if (arrayOfByte[i] != paramArrayOfByte[i]) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread != null)
    {
      SilkStreamPlayer.SilkStreamPlayerThread.a(this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread, false);
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread = null;
    }
  }
  
  public void a(bflu parambflu, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread == null) {
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread = new SilkStreamPlayer.SilkStreamPlayerThread(this, BaseApplicationImpl.sApplication, parambflu, paramInt1, paramInt2);
    }
    ThreadManagerV2.excute(this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread, 128, null, true);
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread != null) && (SilkStreamPlayer.SilkStreamPlayerThread.a(this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread != null) {
      SilkStreamPlayer.SilkStreamPlayerThread.a(this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread, false);
    }
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = TextUtils.emoticonToTextForTalkBack(paramString).replaceAll("/", " ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tts.SilkStreamPlayer
 * JD-Core Version:    0.7.0.1
 */