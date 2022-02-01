package cooperation.qwallet.open.openpay;

import android.os.Bundle;

public abstract class BaseResponse
{
  protected final int a = -9999999;
  protected final int b = 0;
  public int c = -9999999;
  public String d;
  public String e;
  public int f;
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putInt("_mqqpay_baseresp_retcode", this.c);
    paramBundle.putString("_mqqpay_baseresp_retmsg", this.d);
    paramBundle.putString("_mqqpay_baseapi_apiname", this.e);
    paramBundle.putInt("_mqqpay_baseapi_apimark", this.f);
  }
  
  public boolean a()
  {
    return this.c == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.open.openpay.BaseResponse
 * JD-Core Version:    0.7.0.1
 */