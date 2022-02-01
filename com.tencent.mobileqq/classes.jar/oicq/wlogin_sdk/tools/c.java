package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import oicq.wlogin_sdk.report.event.a;
import oicq.wlogin_sdk.report.event.b;
import oicq.wlogin_sdk.request.t;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private t a;
  
  public static c a()
  {
    return c.b.a;
  }
  
  private void f()
  {
    try
    {
      Object localObject1 = this.a;
      if (localObject1 == null)
      {
        util.LOGI("[pubkey]checkLocalPubKey g is null", "");
        return;
      }
      Object localObject2 = e();
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        util.LOGI("[pubkey]checkLocalPubKey local empty", "");
        g();
        return;
      }
      localObject1 = a((String)localObject2);
      if (localObject1 == null)
      {
        b.a(new a("wtlogin_rotate_pub_key_error", "json_error", (String)localObject2));
        util.LOGI("[pubkey]checkLocalPubKey value is null", "");
        g();
        return;
      }
      long l = d();
      if (((c.c)localObject1).a * 1000 + l < System.currentTimeMillis())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[pubkey]checkLocalPubKey lastTime:");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append(" span:");
        ((StringBuilder)localObject2).append(((c.c)localObject1).a);
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        g();
        return;
      }
      util.LOGI("[pubkey]checkLocalPubKey span valid", "");
      if (!a(((c.c)localObject1).b, ((c.c)localObject1).c, ((c.c)localObject1).d))
      {
        b.a(new a("wtlogin_rotate_pub_key_error", "key_error", ""));
        util.LOGI("[pubkey]checkLocalPubKey wrong sign", "");
        g();
        return;
      }
      util.LOGI("[pubkey]checkLocalPubKey sign valid", "");
      return;
    }
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "checkLocalPubKey");
    }
  }
  
  private void g()
  {
    try
    {
      Object localObject1 = this.a;
      if (localObject1 == null)
      {
        util.LOGI("[pubkey]fetchPubKey g null", "");
        return;
      }
      if (this.a.f == 0L) {
        localObject1 = "10000";
      } else {
        localObject1 = String.valueOf(this.a.f);
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[pubkey]fetchPubKey uin:");
      ((StringBuilder)localObject2).append((String)localObject1);
      util.LOGI(((StringBuilder)localObject2).toString(), "");
      try
      {
        localObject1 = (HttpURLConnection)new URL(String.format("https://keyrotate.qq.com/rotate_key?cipher_suite_ver=%s&uin=%s", new Object[] { String.valueOf(305), localObject1 })).openConnection();
        ((HttpURLConnection)localObject1).setRequestMethod("GET");
        ((HttpURLConnection)localObject1).setConnectTimeout(this.a.l);
        ((HttpURLConnection)localObject1).setDoOutput(true);
        ((HttpURLConnection)localObject1).setDoInput(true);
        int i = ((HttpURLConnection)localObject1).getResponseCode();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[pubkey]response code=");
        ((StringBuilder)localObject2).append(i);
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(this.a.f);
        util.LOGI((String)localObject2, ((StringBuilder)localObject3).toString());
        if (200 == i)
        {
          localObject1 = ((HttpURLConnection)localObject1).getInputStream();
          localObject2 = new ByteArrayOutputStream();
          localObject3 = new byte[1024];
          for (;;)
          {
            i = ((InputStream)localObject1).read((byte[])localObject3);
            if (i == -1) {
              break;
            }
            ((ByteArrayOutputStream)localObject2).write((byte[])localObject3, 0, i);
          }
          ((ByteArrayOutputStream)localObject2).close();
          ((InputStream)localObject1).close();
          localObject1 = new String(((ByteArrayOutputStream)localObject2).toByteArray());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[pubkey]json:");
          ((StringBuilder)localObject2).append((String)localObject1);
          util.LOGI(((StringBuilder)localObject2).toString(), "");
          localObject2 = a((String)localObject1);
          if (a(((c.c)localObject2).b, ((c.c)localObject2).c, ((c.c)localObject2).d))
          {
            b((String)localObject1);
            a(System.currentTimeMillis());
            return;
          }
          util.LOGI("[pubkey]fetchPubKey not valid", "");
          return;
        }
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[pubkey]connect exception");
        ((StringBuilder)localObject2).append(localException.toString());
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        return;
      }
      catch (ConnectException localConnectException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[pubkey]connect exception");
        ((StringBuilder)localObject2).append(localConnectException.toString());
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "fetchPubKey");
    }
  }
  
  public c.c a(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        util.LOGI("[pubkey]parseJsonResult empty json", "");
        return null;
      }
      try
      {
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("QuerySpan", 0);
        paramString = paramString.optJSONObject("PubKeyMeta");
        if (paramString != null) {
          return new c.c(i, paramString.optInt("KeyVer", 0), paramString.optString("PubKey"), paramString.optString("PubKeySign"));
        }
        util.LOGI("[pubkey]parseJsonResult empty keyMetaObj", "");
        return null;
      }
      catch (JSONException paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[pubkey]parseJsonResult exception");
        localStringBuilder.append(paramString.toString());
        util.LOGI(localStringBuilder.toString(), "");
        return null;
      }
      return null;
    }
    catch (Throwable paramString)
    {
      util.printThrowable(paramString, "parseJsonResult");
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      Object localObject = this.a;
      localObject = t.u;
      if (localObject != null)
      {
        localObject = ((Context)localObject).getSharedPreferences("WLOGIN_DEVICE_INFO", 4).edit();
        ((SharedPreferences.Editor)localObject).putLong("pubKeyTime", paramLong);
        ((SharedPreferences.Editor)localObject).commit();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[pubkey]saveReqTimeToSp time:");
        ((StringBuilder)localObject).append(paramLong);
        util.LOGI(((StringBuilder)localObject).toString(), "");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "saveReqTimeToSp");
    }
  }
  
  public void a(t paramt)
  {
    this.a = paramt;
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.valueOf(305));
      ((StringBuilder)localObject).append(String.valueOf(paramInt));
      ((StringBuilder)localObject).append(paramString1);
      paramString1 = ((StringBuilder)localObject).toString();
      try
      {
        localObject = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuJTW4abQJXeVdAODw1CamZH4QJZChyT08ribet1Gp0wpSabIgyKFZAOxeArcCbknKyBrRY3FFI9HgY1AyItH8DOUe6ajDEb6c+vrgjgeCiOiCVyum4lI5Fmp38iHKH14xap6xGaXcBccdOZNzGT82sPDM2Oc6QYSZpfs8EO7TYT7KSB2gaHz99RQ4A/Lel1Vw0krk+DescN6TgRCaXjSGn268jD7lOO23x5JS1mavsUJtOZpXkK9GqCGSTCTbCwZhI33CpwdQ2EHLhiP5RaXZCio6lksu+d8sKTWU1eEiEb3cQ7nuZXLYH7leeYFoPtbFV4RicIWp0/YG+RP7rLPCwIDAQAB", 0)));
        Signature localSignature = Signature.getInstance("SHA256WithRSA");
        localSignature.initVerify((PublicKey)localObject);
        localSignature.update(paramString1.getBytes());
        boolean bool = localSignature.verify(Base64.decode(paramString2, 0));
        paramString1 = new StringBuilder();
        paramString1.append("[pubkey]checkPubKeyValid result:");
        paramString1.append(bool);
        util.LOGI(paramString1.toString(), "");
        return bool;
      }
      catch (SignatureException paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("[pubkey]checkPubKeyValid ");
        paramString2.append(paramString1.toString());
        util.LOGI(paramString2.toString(), "");
        return false;
      }
      catch (InvalidKeyException paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("[pubkey]checkPubKeyValid ");
        paramString2.append(paramString1.toString());
        util.LOGI(paramString2.toString(), "");
        return false;
      }
      catch (InvalidKeySpecException paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("[pubkey]checkPubKeyValid ");
        paramString2.append(paramString1.toString());
        util.LOGI(paramString2.toString(), "");
        return false;
      }
      catch (NoSuchAlgorithmException paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("[pubkey]checkPubKeyValid ");
        paramString2.append(paramString1.toString());
        util.LOGI(paramString2.toString(), "");
        return false;
      }
      return false;
    }
    catch (Throwable paramString1)
    {
      util.printThrowable(paramString1, "checkPubKeyValid");
    }
  }
  
  public void b()
  {
    new Thread(new c.a(), "PubKeyRotater").start();
  }
  
  public void b(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject = this.a;
        localObject = t.u;
        if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
        {
          localObject = ((Context)localObject).getSharedPreferences("WLOGIN_DEVICE_INFO", 4).edit();
          ((SharedPreferences.Editor)localObject).putString("pubKey", paramString);
          ((SharedPreferences.Editor)localObject).commit();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[pubkey]savePubKeyToFile json:");
          if (paramString == null) {
            break label105;
          }
          i = paramString.length();
          ((StringBuilder)localObject).append(i);
          util.LOGI(((StringBuilder)localObject).toString(), "");
          return;
        }
      }
      catch (Throwable paramString)
      {
        util.printThrowable(paramString, "savePubKeyToFile");
      }
      return;
      label105:
      int i = 0;
    }
  }
  
  public Pair<String, Integer> c()
  {
    try
    {
      Object localObject = e();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        util.LOGI("[pubkey]syncGetPubKey json is empty");
        return null;
      }
      localObject = a((String)localObject);
      if (localObject == null)
      {
        util.LOGI("[pubkey]syncGetPubKey value is null");
        return null;
      }
      if (!a(((c.c)localObject).b, ((c.c)localObject).c, ((c.c)localObject).d))
      {
        util.LOGI("[pubkey]syncGetPubKey key sign not right");
        return null;
      }
      localObject = new Pair(((c.c)localObject).c, Integer.valueOf(((c.c)localObject).b));
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "syncGetPubKey");
    }
    return null;
  }
  
  public long d()
  {
    for (;;)
    {
      try
      {
        Object localObject = this.a;
        localObject = t.u;
        if (localObject != null)
        {
          l = ((Context)localObject).getSharedPreferences("WLOGIN_DEVICE_INFO", 4).getLong("pubKeyTime", 0L);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[pubkey]getReqTimeFromSp ");
          ((StringBuilder)localObject).append(l);
          util.LOGI(((StringBuilder)localObject).toString(), "");
          return l;
        }
      }
      catch (Throwable localThrowable)
      {
        util.printThrowable(localThrowable, "getReqTimeFromSp");
        return 0L;
      }
      long l = 0L;
    }
  }
  
  public String e()
  {
    for (;;)
    {
      try
      {
        Object localObject = this.a;
        localObject = t.u;
        if (localObject != null)
        {
          localObject = ((Context)localObject).getSharedPreferences("WLOGIN_DEVICE_INFO", 4).getString("pubKey", "");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[pubkey]getPubKeyFromFile ");
          if (localObject == null) {
            break label97;
          }
          i = ((String)localObject).length();
          localStringBuilder.append(i);
          util.LOGI(localStringBuilder.toString(), "");
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        util.printThrowable(localThrowable, "savePubKeyToFile");
        return "";
      }
      String str = "";
      continue;
      label97:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.c
 * JD-Core Version:    0.7.0.1
 */