package cooperation.qwallet.open.openpay;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class PayApi
  extends BaseApi
{
  public long a;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.e = paramBundle.getString("_mqqpay_payapi_serialnumber");
    this.f = paramBundle.getString("_mqqpay_payapi_callbackscheme");
    this.g = paramBundle.getString("_mqqpay_payapi_pubacc");
    this.h = paramBundle.getString("_mqqpay_payapi_pubacchint");
    this.i = paramBundle.getString("_mqqpay_payapi_tokenid");
    this.j = paramBundle.getString("_mqqpay_payapi_nonce");
    this.jdField_a_of_type_Long = paramBundle.getLong("_mqqpay_payapi_timeStamp");
    this.k = paramBundle.getString("_mqqpay_payapi_bargainorId");
    this.l = paramBundle.getString("_mqqpay_payapi_sigType");
    this.m = paramBundle.getString("_mqqpay_payapi_sig");
    this.n = paramBundle.getString("_mqqpay_payapi_packageName");
  }
  
  public void a(String paramString)
  {
    this.c = "browser";
    this.d = "pay";
    this.jdField_a_of_type_Int = 1;
    try
    {
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject = paramString.optJSONObject("action");
      if (localJSONObject != null)
      {
        String str = localJSONObject.optString("name");
        if (str != null)
        {
          if (!str.equals("pay")) {
            return;
          }
          this.e = localJSONObject.optString("identifier");
          localJSONObject = paramString.optJSONObject("application");
          if (localJSONObject != null)
          {
            this.jdField_a_of_type_JavaLangString = localJSONObject.optString("appId");
            this.b = localJSONObject.optString("sdkVersion");
            this.n = localJSONObject.optString("pkgName");
            this.f = localJSONObject.optString("urlScheme");
          }
          paramString = paramString.optJSONObject("params");
          if (paramString == null) {
            return;
          }
          this.i = paramString.optString("tokenId");
          this.jdField_a_of_type_Long = paramString.optLong("timeStamp");
          this.j = paramString.optString("nonce");
          this.k = paramString.optString("bargainorId");
          this.l = "HMAC-SHA1";
          this.m = paramString.optString("sig");
          return;
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (TextUtils.isEmpty(this.c)) {
      return false;
    }
    if ((!this.c.equals("native")) && (!this.c.equals("browser"))) {
      return false;
    }
    if (TextUtils.isEmpty(this.n)) {
      return false;
    }
    if ((!this.c.equals("browser")) && (TextUtils.isEmpty(this.f))) {
      return false;
    }
    if (TextUtils.isEmpty(this.i)) {
      return false;
    }
    if (TextUtils.isEmpty(this.k)) {
      return false;
    }
    if (TextUtils.isEmpty(this.j)) {
      return false;
    }
    if (TextUtils.isEmpty(this.m)) {
      return false;
    }
    if (TextUtils.isEmpty(this.l)) {
      return false;
    }
    if (this.jdField_a_of_type_Long <= 0L) {
      return false;
    }
    return !TextUtils.isEmpty(this.e);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(128);
    localStringBuilder1.append(super.toString());
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("&sn=");
    localStringBuilder2.append(this.e);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("&cs=");
    localStringBuilder2.append(this.f);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("&pa=");
    localStringBuilder2.append(this.g);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("&pah=");
    localStringBuilder2.append(this.h);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("&ti=");
    localStringBuilder2.append(this.i);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("&ne=");
    localStringBuilder2.append(this.j);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("&ts=");
    localStringBuilder2.append(this.jdField_a_of_type_Long);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("&bi=");
    localStringBuilder2.append(this.k);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("&st=");
    localStringBuilder2.append(this.l);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("&sg=");
    localStringBuilder2.append(this.m);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("&pn=");
    localStringBuilder2.append(this.n);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     cooperation.qwallet.open.openpay.PayApi
 * JD-Core Version:    0.7.0.1
 */