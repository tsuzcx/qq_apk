package com.tencent.mobileqq.tts;

import android.app.Application;
import android.content.Context;
import bdol;
import bgch;
import bgmj;
import bita;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import nlw;
import org.json.JSONException;
import org.json.JSONObject;

public class SilkStreamPlayer
{
  private static long jdField_a_of_type_Long;
  private Application jdField_a_of_type_AndroidAppApplication = BaseApplicationImpl.sApplication;
  private Context jdField_a_of_type_AndroidContentContext;
  private bgch jdField_a_of_type_Bgch;
  private SilkStreamPlayer.SilkStreamPlayerThread jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread;
  private InputStream jdField_a_of_type_JavaIoInputStream;
  private String jdField_a_of_type_JavaLangString;
  private HttpsURLConnection jdField_a_of_type_JavaxNetSslHttpsURLConnection;
  private String b;
  private String c;
  private String d;
  
  public SilkStreamPlayer(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = bdol.e(paramString1).replaceAll("/", " ");
    this.b = paramString2;
    this.d = paramString3;
  }
  
  private InputStream a()
  {
    this.jdField_a_of_type_JavaxNetSslHttpsURLConnection = ((HttpsURLConnection)new URL("https://textts.qq.com/cgi-bin/tts").openConnection());
    this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.setRequestMethod("POST");
    this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
    this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.setRequestProperty("Accept", "application/json");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("uin=");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(";skey=");
    ((StringBuilder)localObject1).append(this.d);
    this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.setRequestProperty("Cookie", ((StringBuilder)localObject1).toString());
    this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.setDoOutput(true);
    this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.setDoInput(true);
    try
    {
      localObject1 = SSLContext.getDefault();
      if (localObject1 != null) {
        this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.setSSLSocketFactory(((SSLContext)localObject1).getSocketFactory());
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
        ((JSONObject)localObject1).put("textmd5", bita.d(this.jdField_a_of_type_JavaLangString));
        long l = jdField_a_of_type_Long;
        jdField_a_of_type_Long = 1L + l;
        ((JSONObject)localObject1).put("seq", l);
        ((JSONObject)localObject1).put("clientVersion", "AND_" + AppSetting.a() + "_" + "8.4.1");
        ((JSONObject)localObject1).put("net", nlw.a());
        DataOutputStream localDataOutputStream = new DataOutputStream(this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.getOutputStream());
        localDataOutputStream.write(new String(((JSONObject)localObject1).toString().getBytes(), "utf-8").getBytes());
        localDataOutputStream.flush();
        localDataOutputStream.close();
        if (this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.getResponseCode() == 200)
        {
          return this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.getInputStream();
          localNoSuchAlgorithmException = localNoSuchAlgorithmException;
          QLog.e("SilkStreamPlayer", 2, localNoSuchAlgorithmException, new Object[0]);
          Object localObject2 = null;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SilkStreamPlayer", 1, localJSONException, new Object[0]);
          }
        }
      }
    }
    return null;
  }
  
  private boolean a(byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    byte[] arrayOfByte = bgmj.a("02232153494C4B5F5633");
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
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread == null) {
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread = new SilkStreamPlayer.SilkStreamPlayerThread(this, this.jdField_a_of_type_AndroidAppApplication);
    }
    ThreadManagerV2.excute(this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread, 128, null, true);
  }
  
  public void a(bgch parambgch)
  {
    this.jdField_a_of_type_Bgch = parambgch;
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
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread != null)
    {
      SilkStreamPlayer.SilkStreamPlayerThread.a(this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread, false);
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread = null;
    }
    this.jdField_a_of_type_Bgch = null;
    if (this.jdField_a_of_type_Bgch != null) {
      this.jdField_a_of_type_Bgch.c();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bgch = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tts.SilkStreamPlayer
 * JD-Core Version:    0.7.0.1
 */