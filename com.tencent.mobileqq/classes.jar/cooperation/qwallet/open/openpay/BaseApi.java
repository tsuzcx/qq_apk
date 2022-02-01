package cooperation.qwallet.open.openpay;

import android.os.Bundle;

public abstract class BaseApi
{
  public String a;
  public String b;
  public String c;
  public String d;
  public int e;
  
  public void a(Bundle paramBundle)
  {
    this.a = paramBundle.getString("_mqqpay_baseapi_appid");
    this.c = paramBundle.getString("_mqqpay_baseapi_apptype");
    this.b = paramBundle.getString("_mqqpay_baseapi_sdkversion");
    this.d = paramBundle.getString("_mqqpay_baseapi_apiname");
    this.e = paramBundle.getInt("_mqqpay_baseapi_apimark");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(50);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("ai=");
    localStringBuilder2.append(this.a);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("&sv=");
    localStringBuilder2.append(this.b);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("&at=");
    localStringBuilder2.append(this.c);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("&an=");
    localStringBuilder2.append(this.d);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("&am=");
    localStringBuilder2.append(this.e);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.open.openpay.BaseApi
 * JD-Core Version:    0.7.0.1
 */